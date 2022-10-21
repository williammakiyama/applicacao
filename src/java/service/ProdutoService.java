/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

//import dao.FichaTecnicaDAO;
//import dao.ItemPedidoDAO;
//import dao.ProdutoDAO;
//import java.sql.SQLException;
import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import model.FichaTecnica;
//import model.ItemPedido;
//import model.Pedido;
import model.Produto;
import static service.Servico.getConexao;

/**
 *
 * @author willi
 */
public class ProdutoService extends Servico {

    public ArrayList<Produto> ListarTodosProdutos() {
        
        try {
            ArrayList<Produto> produtos = new ArrayList<>();
            ProdutoDAO dao = new ProdutoDAO(getConexao());
            produtos = dao.listarTodos();
            dao.fecharConexao();
            return produtos;
        } catch (Exception ex) {
            return null;
        }     

    }
    
    public ArrayList<Produto> ListarEstoqueBaixo() {
        
        try {
            ArrayList<Produto> produtos = new ArrayList<>();
            
            ProdutoDAO dao = new ProdutoDAO(getConexao());
            produtos = dao.listarEstoqueBaixo();
            dao.fecharConexao();
            
            return produtos;
        } catch (Exception ex) {
            return null;
        }

    }

    public boolean CadastrarProduto(String nome, String descricao, int marca, int categoria, String codigo, double valor,
            String altura, String largura, String acabamento, String material, String textura, String aplicacao,
             int quantidadeEstoque, int quantidadeMinimo) {
        try {
            
            FichaTecnica fichaAltura = new FichaTecnica();
            fichaAltura.setNome("Altura");
            fichaAltura.setDescricao(altura);
            
            FichaTecnica fichaLargura = new FichaTecnica();
            fichaLargura.setNome("Largura");
            fichaLargura.setDescricao(largura);
            
            FichaTecnica fichaAcabamento = new FichaTecnica();
            fichaAcabamento.setNome("Acabamento");
            fichaAcabamento.setDescricao(acabamento);
            
            FichaTecnica fichaMaterial = new FichaTecnica();
            fichaMaterial.setNome("Material");
            fichaMaterial.setDescricao(material);
            
            FichaTecnica fichaTextura = new FichaTecnica();
            fichaTextura.setNome("Textura");
            fichaTextura.setDescricao(textura);
            
            FichaTecnica fichaAplicacao = new FichaTecnica();
            fichaAplicacao.setNome("Aplicacao");
            fichaAplicacao.setDescricao(aplicacao);

            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setDescricao(descricao);
            produto.setCodigo(codigo);
            produto.setValor(valor);
            produto.setQuantidadeEstoque(quantidadeEstoque);
            produto.setQuantidadeMinimo(quantidadeMinimo);
            produto.setFichasTecnicas(new ArrayList<>() );
            produto.getFichasTecnicas().add(fichaAltura);
            produto.getFichasTecnicas().add(fichaLargura);
            produto.getFichasTecnicas().add(fichaAcabamento);
            produto.getFichasTecnicas().add(fichaMaterial);
            produto.getFichasTecnicas().add(fichaTextura);
            produto.getFichasTecnicas().add(fichaAplicacao);
            
            MarcaService marcaServico = new MarcaService();
            produto.setMarca(marcaServico.BuscarMarca(marca));
            
            CategoriaService categoriaServico = new CategoriaService();
            produto.setCategoria(categoriaServico.BuscarCategoria(categoria));
            
            ProdutoDAO dao = new ProdutoDAO(getConexao());
            if(dao.inserir(produto)){
                Produto produtoNovo = dao.obterUm(produto);
                
                FichaTecnicaDAO fichaDAO = new FichaTecnicaDAO(getConexao());
                for(FichaTecnica ficha : produto.getFichasTecnicas()){
                    ficha.setProduto(produtoNovo);
                    fichaDAO.inserir(ficha);
                }
                fichaDAO.fecharConexao();
            }
            dao.fecharConexao();
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public boolean AtualizarProduto(int id,String nome, String descricao, int marca, int categoria, String codigo, double valor,
            String altura, String largura, String acabamento, String material, String textura, String aplicacao,
             int quantidadeEstoque, int quantidadeMinimo) {
        try {
            
            Produto produto = new Produto();
            produto.setId(id);
            produto.setNome(nome);
            produto.setDescricao(descricao);
            produto.setCodigo(codigo);
            produto.setValor(valor);
            produto.setQuantidadeEstoque(quantidadeEstoque);
            produto.setQuantidadeMinimo(quantidadeMinimo);
            produto.setEmail(false);
            
            MarcaService marcaServico = new MarcaService();
            produto.setMarca(marcaServico.BuscarMarca(marca));
            
            CategoriaService categoriaServico = new CategoriaService();
            produto.setCategoria(categoriaServico.BuscarCategoria(categoria));
            
            ProdutoDAO dao = new ProdutoDAO(getConexao());
            dao.alterar(produto);
            dao.fecharConexao();
            
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    

    public boolean AtualizarProduto(Produto produto) throws SQLException {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO(getConexao());
            produtoDAO.alterar(produto);
            produtoDAO.fecharConexao();
            
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Produto BuscarProduto(int idProduto) throws SQLException {
        Produto produto = new Produto();
        produto.setId(idProduto);
        
        ProdutoDAO produtoDAO = new ProdutoDAO(getConexao());
        produto = produtoDAO.obterUm(produto);
        produtoDAO.fecharConexao();
        
        return produto;
    }

    public boolean Desativar(int idProduto) throws SQLException {
        Produto produto = new Produto();
        produto.setId(idProduto);
        
        ProdutoDAO produtoDAO = new ProdutoDAO(getConexao());
        produtoDAO.desativar(produto);
        produtoDAO.fecharConexao();
        
        return true;
    }
    
    public void baixaEstoque(Pedido pedido){
        
        try {
            ItemPedidoDAO itensDao = new ItemPedidoDAO(getConexao());
            for(ItemPedido item: itensDao.listarTodosPorPedido(pedido)){
                Produto produto = new Produto();
                produto = BuscarProduto(item.getProduto().getId());
                produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidade());
                AtualizarProduto(produto); 
            }
        } catch (Exception ex) {
            Logger.getLogger(ProdutoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String itensParaCompra(Pedido pedido){
        try {
            
            int count = 1;
            String listaDeItens = new String();
            
            ItemPedidoDAO itensDao = new ItemPedidoDAO(getConexao());
            for(ItemPedido item: itensDao.listarTodosPorPedido(pedido)){
                
                listaDeItens += "&itemId"+count+"=" + String.format("%04d", count)
                                +"&itemDescription"+count+"=" + item.getNome()
                                +"&itemAmount"+count+"=" + String.format("%.2f",item.getValor()).replace(",", ".")
                                +"&itemQuantity"+count+"=" + item.getQuantidade()
                                +"&itemWeight"+count+"=1000";
                count++;
                
            }
            return listaDeItens;
        } catch (Exception ex) {
            return null;
        }
    }
}
