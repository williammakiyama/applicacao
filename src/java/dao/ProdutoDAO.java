/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;
import util.ConexaoMySQL;
import util.IConexao;

/**
 *
 * @author willi
 */
public class ProdutoDAO extends DAO<Produto>{

    public ProdutoDAO(IConexao conexao) throws SQLException {
        super(conexao);
    }

    @Override
    public Produto obterUm(Produto item) {
        Produto produto = null;
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM produtos WHERE (ID = ? OR NOME = ?) AND ATIVO = 1");
            pstmt.setInt(1, item.getId());
            pstmt.setString(2, item.getNome());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                produto = new Produto();
                produto.setId(rs.getInt("ID"));
                produto.setUltimoValorCompra(rs.getDouble("ULTIMOVALORCOMPRA"));
                produto.setValorVenda(rs.getDouble("VALORVENDA"));
                produto.setNome(rs.getString("NOME"));
                produto.setCategoria(new Categoria(rs.getInt("ID_CATEGORIAS")));
                produto.setAtivo(rs.getBoolean("ATIVO"));
                produto.setQuantidadeEstoque(rs.getInt("QUANTIDADEESTOQUE"));
                produto.setQuantidadeMinimo(rs.getInt("QUANTIDADEMINIMO"));
                produto.setTotalProdutos(rs.getInt("TOTALPRODUTOS"));
            }
        } catch (SQLException ex) {
            return produto;
        }
        return produto;
    }

    public ArrayList<Produto> listarTodos() {
        ArrayList<Produto> produtos = null;
        
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM produtos WHERE ATIVO = 1");
            ResultSet rs = pstmt.executeQuery();
            produtos = new ArrayList<Produto>();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("ID"));
                produto.setUltimoValorCompra(rs.getDouble("ULTIMOVALORCOMPRA"));
                produto.setValorVenda(rs.getDouble("VALORVENDA"));
                produto.setNome(rs.getString("NOME"));
                produto.setCategoria(new Categoria(rs.getInt("ID_CATEGORIAS")));
                produto.setAtivo(rs.getBoolean("ATIVO"));
                produto.setQuantidadeEstoque(rs.getInt("QUANTIDADEESTOQUE"));
                produto.setQuantidadeMinimo(rs.getInt("QUANTIDADEMINIMO"));
                produto.setTotalProdutos(rs.getInt("TOTALPRODUTOS"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            return produtos;
        }
        return produtos;
    }
    
    public ArrayList<Produto> listarEstoqueBaixo() {
        ArrayList<Produto> produtos = null;
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM produtos WHERE ATIVO = 1 AND QUANTIDADEESTOQUE <= QUANTIDADEMINIMO");
            ResultSet rs = pstmt.executeQuery();
            produtos = new ArrayList<Produto>();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("ID"));
                produto.setUltimoValorCompra(rs.getDouble("ULTIMOVALORCOMPRA"));
                produto.setValorVenda(rs.getDouble("VALORVENDA"));
                produto.setNome(rs.getString("NOME"));
                produto.setCategoria(new Categoria(rs.getInt("ID_CATEGORIAS")));
                produto.setAtivo(rs.getBoolean("ATIVO"));
                produto.setQuantidadeEstoque(rs.getInt("QUANTIDADEESTOQUE"));
                produto.setQuantidadeMinimo(rs.getInt("QUANTIDADEMINIMO"));
                produto.setTotalProdutos(rs.getInt("TOTALPRODUTOS"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            return produtos;
        }
        return produtos;
    }

    public boolean alterar(Produto item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("UPDATE produtos SET ULTIMOVALORCOMPRA = ?, VALORVENDA =? ,NOME = ?,ID_CATEGORIAS = ?, QUANTIDADEESTOQUE = ?, QUANTIDADEMINIMO = ? WHERE ID = ?");
            pstmt.setDouble(1, item.getUltimoValorCompra());
            pstmt.setDouble(2, item.getValorVenda());
            pstmt.setString(3, item.getNome());
            pstmt.setInt(4, item.getCategoria().getId());
            pstmt.setInt(5, item.getQuantidadeEstoque());
            pstmt.setInt(6, item.getQuantidadeMinimo());
            pstmt.setInt(7, item.getId());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }

    public boolean inserir(Produto item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("INSERT INTO produtos(ULTIMOVALORCOMPRA,VALORVENDA,NOME,ID_CATEGORIAS,QUANTIDADEESTOQUE,QUANTIDADEMINIMO) VALUES (?,?,?,?,?,?)");
            pstmt.setDouble(1, item.getUltimoValorCompra());
            pstmt.setDouble(2, item.getValorVenda());
            pstmt.setString(3, item.getNome());
            pstmt.setInt(4, item.getCategoria().getId());
            pstmt.setInt(5, item.getQuantidadeEstoque());
            pstmt.setInt(6, item.getQuantidadeMinimo());
            
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }

    public boolean desativar(Produto item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("UPDATE produtos SET ATIVO = 0 WHERE ID = ?");
            pstmt.setInt(1, item.getId());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }

}
