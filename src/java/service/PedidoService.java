package service;

import dao.ItemPedidoDAO;
import dao.PedidoDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ItemPedido;
import model.Pedido;
import model.Usuario;

public class PedidoService extends Servico {
    
    public ArrayList buscarTodos(){
        try {
            ArrayList<Pedido> pedidos = new ArrayList();
            PedidoDAO pedidoDao = new PedidoDAO(getConexao());
            pedidos = pedidoDao.listarTodos();
            pedidoDao.fecharConexao();
            return pedidos;
            
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
    
    
//    public boolean adcionarUmPedido(int idCliente){
//        try {
//            
//            Usuario usuario = new Usuario();
//            usuario.setId(idCliente);
//            
//            Pedido pedido = new Pedido();
//            pedido.setUsuario(usuario);
//            pedido.setStatus("Carrinho");
//            pedido.setCancelado(false);
//            pedido.setDataCriaocao(new Date( System.currentTimeMillis()));
//            
//            PedidoDAO daoPedido = null;
//            daoPedido = new PedidoDAO(getConexao());
//            daoPedido.inserir(pedido);
//            daoPedido.fecharConexao();
//            
//            return true;
//        } catch (SQLException ex) {
//            return false;
//        }
//
//    }
//    
//    public Pedido buscarCarrinhoPorCliente(int idCliente){
//        
//        try {
//            Usuario usuario = new Usuario();
//            usuario.setId(idCliente);
//            
//            Pedido pedido = new Pedido();
//            pedido.setUsuario(usuario);
//            
//            PedidoDAO daoPedido = new PedidoDAO(getConexao());
//            pedido = daoPedido.obterUmCarrinhoPorUsuario(pedido);
//            
//            if(pedido != null){
//                ItemPedidoDAO daoItem = new ItemPedidoDAO(getConexao());
//                pedido.setItensPedido(daoItem.listarTodosPorPedido(pedido));
//            }
//
//            return pedido;
//        } catch (Exception ex) {
//            return null;
//        }
//    }
//    
//    public Pedido buscarPorCliente(Pedido pedido){
//        try {
//            PedidoDAO daoPedido = new PedidoDAO(getConexao());
//            pedido = daoPedido.obterUm(pedido);
//            return pedido;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
//    
//    public Pedido buscarPorId(int idPedido){
//        
//        try {
//            Pedido pedido = new Pedido();
//            pedido.setId(idPedido);
//            
//            PedidoDAO daoPedido = new PedidoDAO(getConexao());
//            pedido = daoPedido.obterUm(pedido);
//            return pedido;
//        } catch (SQLException ex) {
//            return null;
//        }
//        
//    }
//    
//    public Pedido buscarDetalhePorId(int idPedido){
//        
//        try {
//            Pedido pedido = new Pedido();
//            pedido.setId(idPedido);
//            
//            PedidoDAO daoPedido = new PedidoDAO(getConexao());
//            pedido = daoPedido.obterUm(pedido);
//            
//            ArrayList<ItemPedido> itens = new ArrayList<>();
//            
//            ItemPedidoDAO daoItens = new ItemPedidoDAO(getConexao());
//            itens = daoItens.listarTodosPorPedido(pedido);
//            
//            Frete frete = new Frete();
//            frete.setPedido(pedido);
//            
//            FreteDAO daoFrete = new FreteDAO(getConexao());
//            frete = daoFrete.obterUmPorPedido(frete);
//            
//            Rastreamento rastreamento = new Rastreamento();
//            //TODO
//            
//            frete.setRastreamento(rastreamento);
//            
//            pedido.setFrete(frete);
//            pedido.setItensPedido(itens);
//            
//            return pedido;
//        } catch (SQLException ex) {
//            return null;
//        }
//        
//    }
//    
//    public ArrayList<Pedido> listarPedidosPendentesParaPagamento(){
//        try{
//            ArrayList<Pedido> pedidos = new ArrayList<>();
//            PedidoDAO dao = new PedidoDAO(getConexao());
//            pedidos = dao.listarTodosPendentesDePagamento();
//            return pedidos;
//        }
//        catch(Exception ex){
//            return null;
//        }
//    }
//    
//    public boolean desativar(int idItem){
//        
//        try {
//            ItemPedido item = new ItemPedido();
//            item.setId(idItem);
//            
//            ItemPedidoDAO dao = new ItemPedidoDAO(getConexao());
//            dao.desativar(item);
//            dao.fecharConexao();
//            
//            return true;
//        } catch (SQLException ex) {
//            return false;
//        }
// 
//    }
//    
//    public boolean finalizarCompra(int idPedido, int idEndereco, int idPagamento, double totalFrete){
//
//        try {
//            
//            Pedido pedido = new Pedido();
//            pedido = buscarPorId(idPedido);
//            pedido.setDataFinalizacao(new Date( System.currentTimeMillis()));
//            pedido.setStatus("Finalizado");
//            if(idPagamento == 1){
//                pedido.setDataPagamento(new Date( System.currentTimeMillis()));
//                pedido.setStatus("Aprovado");
//            }
//            else{
//                pedido.setStatus("Aguardando Pagamento");
//                pedido.setReferencia("REF" + Integer.toString(pedido.getId()) + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date( System.currentTimeMillis())));
//            }
//            
//            Cliente cliente = new Cliente();
//            cliente.setUsuario(pedido.getUsuario());
//            
//            ClienteDAO daoCliente = new ClienteDAO(getConexao());
//            cliente = daoCliente.obterUmPorIdUsuario(cliente);
//            cliente.setEnderecos(new ArrayList<Endereco>());
//
//            Cliente vendedor = new Cliente();
//            vendedor = daoCliente.obterUmVendedor();
//            vendedor.setEnderecos(new ArrayList<Endereco>());
//            
//            
//            EnderecoDAO daoEndereco = new EnderecoDAO(getConexao());
//            vendedor.getEnderecos().add(daoEndereco.obterEnderecoDoVendedor());
//            
//            Endereco enderecoCliente = new Endereco();
//            enderecoCliente.setId(idEndereco);
//            cliente.getEnderecos().add(daoEndereco.obterUm(enderecoCliente));
//            
//            Frete frete = new Frete();
//            frete.setOrigem(vendedor.getEnderecos().get(0));
//            frete.setDestino(cliente.getEnderecos().get(0));
//            frete.setPedido(pedido);
//            frete.setValor(totalFrete);
//            
//            FreteDAO daoFrete = new FreteDAO(getConexao());
//            
//            if(daoFrete.inserir(frete)){
//                daoFrete.fecharConexao();
//                PedidoDAO daoPedido = new PedidoDAO(getConexao());
//                if(daoPedido.alterar(pedido)){
//                    ProdutoService produtoService = new ProdutoService();
//                    produtoService.baixaEstoque(pedido);
//                    daoPedido.fecharConexao();
//                }
//                else{
//                    daoPedido.getConexao().rollback();
//                }
//            }
//            else{
//                daoFrete.getConexao().rollback();
//            }
//
//            return true;
//            
//        } catch (Exception ex) {
//            return false;
//        }
//  
//    }
//    
//    public String obterCodigoCheckOut(int idPedido, int idEndereco){
//        try{
//            
//            Pedido pedido = new Pedido();
//            pedido = buscarPorId(idPedido);
//            
//            Cliente cliente = new Cliente();
//            cliente.setUsuario(pedido.getUsuario());
//            
//            
//            ClienteDAO daoCliente = new ClienteDAO(getConexao());
//            cliente = daoCliente.obterUmPorIdUsuario(cliente);
//            cliente.setEnderecos(new ArrayList<Endereco>());
//
//            Endereco enderecoCliente = new Endereco();
//            enderecoCliente.setId(idEndereco);
//            
//            EnderecoDAO daoEndereco = new EnderecoDAO(getConexao());
//            cliente.getEnderecos().add(daoEndereco.obterUm(enderecoCliente));
//
//            ProdutoService produtoService = new ProdutoService();
//            String itens = produtoService.itensParaCompra(pedido);
//
//            PagSeguroIntegracao pagSeguro = new PagSeguroIntegracao();
//            String codigo = pagSeguro.iniciarCheckout(itens, pedido.getId(), cliente).getCode();
//
//            pedido.setCodigoPedido(codigo);
//            
//            PedidoDAO daoPedido = new PedidoDAO(getConexao());
//            daoPedido.alterar(pedido);
//            daoPedido.fecharConexao();
//            
//            return codigo;
//        }
//        catch(Exception ex){
//            return null;
//        }
//    }
//    
//    public ArrayList<Pedido> listarPedidosAprovados(){
//
//        try{
//            ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
//            
//            PedidoDAO daoPedido = new PedidoDAO(getConexao());
//            
//            for(Pedido pedido : daoPedido.listarTodosAprovados()){
//                ItemPedidoDAO daoItens = new ItemPedidoDAO(getConexao());
//                pedido.setItensPedido(daoItens.listarTodosPorPedido(pedido));
//                daoItens.fecharConexao();
//                
//                pedidos.add(pedido);
//            }
//            
//            daoPedido.fecharConexao();
//            
//            return pedidos;
//        }
//        catch(Exception ex){
//            return null;
//        }
//    }
//    
//    public ArrayList<Pedido> listarPorCliente(int idUsuario){
//
//        try{
//            Usuario usuario = new Usuario();
//            usuario.setId(idUsuario);
//            
//            ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
//            
//            PedidoDAO dao = new PedidoDAO(getConexao());
//            
//            for(Pedido pedido : dao.listarTodosPorCliente(usuario)){
//                
//                ItemPedidoDAO daoItens = new ItemPedidoDAO(getConexao());
//                pedido.setItensPedido(daoItens.listarTodosPorPedido(pedido));
//                daoItens.fecharConexao();
//                
//                pedidos.add(pedido);
//            }
//            
//            dao.fecharConexao();
//            
//            return pedidos;
//        }
//        catch(Exception ex){
//            return null;
//        }
//        
//        
//    }
//    
//    public boolean alterar(Pedido pedido){
//        try{
//            PedidoDAO dao = new PedidoDAO(getConexao());
//            dao.alterar(pedido);
//            dao.fecharConexao();
//            
//            return true;
//        }
//        catch(Exception ex){
//            return false;
//        }
//    }
}
