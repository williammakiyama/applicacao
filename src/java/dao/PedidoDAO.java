package dao;

import enums.StatusPagamentoEnum;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import model.Usuario;
import util.IConexao;

public class PedidoDAO extends DAO<Pedido>{

    public PedidoDAO(IConexao conexao) throws SQLException {
        super(conexao);
    }

    public Pedido obterUm(Pedido item) {
        Pedido pedido = null;
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM pedidos WHERE ID = ?");
            pstmt.setInt(1, item.getId());
            ResultSet rs = pstmt.executeQuery();
            ArrayList<ItemPedido> itensPedido = new ArrayList<>();
            while(rs.next()){
                pedido = new Pedido();
                pedido.setId(rs.getInt("ID"));
                pedido.setDataCriacao(rs.getDate("DATA_CRIACAO"));
                pedido.setDataPagamento(rs.getDate("DATA_PAGAMENTO"));
                pedido.setPagamento(StatusPagamentoEnum.valueOf("STATUS_PAGAMENTO"));
                while(rs.next()){
                    ItemPedido itemPedido = new ItemPedido();
                    Produto produto = new Produto();
                    itemPedido.setId(0);
                    produto.setId(0);
                    itemPedido.setProduto(produto);
                    itemPedido.setQuantidade(0);
                    itemPedido.setValor(0);
                    itensPedido.add(itemPedido);
                }
                pedido.setItensPedido(itensPedido);
            }
            pstmt.close();
        } catch (SQLException ex) {
            return pedido;
        }
        return pedido;
    }
    
    @Override
    public ArrayList<Pedido> listarTodos() {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM pedidos");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("ID"));
                pedido.setDataCriacao(rs.getDate("DATA_CRIACAO"));
                pedido.setDataPagamento(rs.getDate("DATA_PAGAMENTO"));
                pedido.setPagamento(StatusPagamentoEnum.valueOf("STATUS_PAGAMENTO"));
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            return pedidos;
        }
        return pedidos;
    }
    
    public ArrayList<Pedido> listarTodosPendentesDePagamento() {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM pedidos WHERE STATUS_PAGAMENTO = FIADO");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("ID"));
                pedido.setDataCriacao(rs.getDate("DATA_CRIACAO"));
                pedido.setDataPagamento(rs.getDate("DATA_PAGAMENTO"));
                pedido.setPagamento(StatusPagamentoEnum.valueOf("STATUS_PAGAMENTO"));
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            return pedidos;
        }
        return pedidos;
    }
    
    public boolean alterar(Pedido item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("UPDATE pedidos SET DAT_CRIACAO = ?, DAT_CANCELAMENTO = ?, DAT_FINALIZACAO = ?, DAT_PAGAMENTO = ?, DAT_ENTREGA = ?, FLG_CANCELADO = ?, STATUS = ?, ID_USUARIOS = ?, FLG_EMAIL = ?, CODIGO_PEDIDO = ?, REFERENCIA = ?  WHERE ID = ?");
            
            if(item.getDataCriacao() == null)
                pstmt.setNull(1, Types.VARCHAR);
            else
                pstmt.setDate(1, new java.sql.Date(item.getDataCriacao().getTime()));
            
            if(item.getDataPagamento() == null)
                pstmt.setNull(4, Types.VARCHAR);
            else
                pstmt.setDate(4, new java.sql.Date(item.getDataPagamento().getTime()));
            pstmt.setInt(12, item.getId());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }


    @Override
    public boolean inserir(Pedido t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean desativar(Pedido t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
