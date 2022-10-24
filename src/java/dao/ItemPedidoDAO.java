package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import util.IConexao;

public class ItemPedidoDAO extends DAO<ItemPedido>{

    public ItemPedidoDAO(IConexao conexao) throws SQLException {
        super(conexao);
    }

    @Override
    public ItemPedido obterUm(ItemPedido item) {
        ItemPedido itemPedido = null;
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM itens_pedido WHERE ID = ?");
            pstmt.setInt(1, item.getId());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                itemPedido = new ItemPedido();
                itemPedido.setId(rs.getInt("ID"));
                itemPedido.setQuantidade(rs.getInt("QUANTIDADE"));
                itemPedido.setValor(rs.getDouble("VALOR"));
                Produto produto = new Produto();
                produto.setId(rs.getInt("ID_PRODUTOS"));
                itemPedido.setProduto(produto);
            }
        } catch (SQLException ex) {
            return itemPedido;
        }
        return itemPedido;
    }

    public ArrayList<ItemPedido> listarTodos() {
        ItemPedido itemPedido = new ItemPedido();
        ArrayList<ItemPedido> itensPedido = new ArrayList<>();
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM itens_pedido");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                itemPedido = new ItemPedido();
                itemPedido.setId(rs.getInt("ID"));
                itemPedido.setQuantidade(rs.getInt("QUANTIDADE"));
                itemPedido.setValor(rs.getDouble("VALOR"));
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("ID_PEDIDOS"));
                Produto produto = new Produto();
                produto.setId(rs.getInt("ID_PRODUTOS"));
                itemPedido.setProduto(produto);
                itensPedido.add(itemPedido);
            }
        } catch (SQLException ex) {
            return itensPedido;
        }
        return itensPedido;
    }
    
    public ArrayList<ItemPedido> listarTodosPorPedido(Pedido pedido) {
        ItemPedido itemPedido = new ItemPedido();
        ArrayList<ItemPedido> itensPedido = new ArrayList<>();
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM itens_pedido WHERE ID_PEDIDOS = ?");
            pstmt.setInt(1, pedido.getId());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                itemPedido = new ItemPedido();
                itemPedido.setId(rs.getInt("ID"));
                itemPedido.setQuantidade(rs.getInt("QUANTIDADE"));
                itemPedido.setValor(rs.getDouble("VALOR"));
                Produto produto = new Produto();
                produto.setId(rs.getInt("ID_PRODUTOS"));
                itemPedido.setProduto(produto);
                itensPedido.add(itemPedido);
            }
        } catch (SQLException ex) {
            return itensPedido;
        }
        return itensPedido;
    }

    public boolean alterar(ItemPedido item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("UPDATE itens_pedido SET NOME = ?, QUANTIDADE = ?, VALOR = ? WHERE ID = ?");
            pstmt.setInt(2, item.getQuantidade());
            pstmt.setDouble(3, item.getValor());
            pstmt.setInt(4, item.getId());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }

    public boolean inserir(ItemPedido item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("INSERT INTO itens_pedido (QUANTIDADE,VALOR,ID_PRODUTOS) VALUES (?,?,?)");
            pstmt.setInt(2, item.getQuantidade());
            pstmt.setDouble(3, item.getValor());
            pstmt.setInt(5, item.getProduto().getId());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean desativar(ItemPedido t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
