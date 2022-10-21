package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import model.Pedido;
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
            
            while(rs.next()){
                pedido = new Pedido();
                pedido.setId(rs.getInt("ID"));
                pedido.setDataCriaocao(rs.getDate("DAT_CRIACAO"));
                pedido.setDataPagamento(rs.getDate("DAT_PAGAMENTO"));
                pedido.setStatus(rs.getString("STATUS"));
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID_USUARIOS"));
            }
            
        } catch (SQLException ex) {
            return pedido;
        }
        
        return pedido;
    }
    
//    public Pedido obterUmPorUsuario(Pedido item) {
//        Pedido pedido = null;
//        
//        try {
//            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM pedidos WHERE ID_USUARIOS = ? AND ATIVO = 1");
//            pstmt.setInt(1, item.getUsuario().getId());
//            ResultSet rs = pstmt.executeQuery();
//            
//            while(rs.next()){
//                pedido = new Pedido();
//                pedido.setId(rs.getInt("ID"));
//                pedido.setDataCriaocao(rs.getDate("DAT_CRIACAO"));
//                pedido.setDataCancelamento(rs.getDate("DAT_CANCELAMENTO"));
//                pedido.setDataFinalizacao(rs.getDate("DAT_FINALIZACAO"));
//                pedido.setDataPagamento(rs.getDate("DAT_PAGAMENTO"));
//                pedido.setDataEntrega(rs.getDate("DAT_ENTREGA"));
//                pedido.setCancelado(rs.getBoolean("FLG_CANCELADO"));
//                pedido.setEmail(rs.getBoolean("FLG_EMAIL"));
//                pedido.setCodigoPedido(rs.getString("CODIGO_PEDIDO"));
//                pedido.setReferencia(rs.getString("REFERENCIA"));
//                pedido.setStatus(rs.getString("STATUS"));
//                Usuario usuario = new Usuario();
//                usuario.setId(rs.getInt("ID_USUARIOS"));
//                usuario = new UsuarioDAO(new ConexaoMySQL()).obterUmPorId(usuario);
//                pedido.setUsuario(usuario);
//                pedido.setAtivo(rs.getBoolean("ATIVO"));
//            }
//            
//        } catch (SQLException ex) {
//            return pedido;
//        }
//        
//        return pedido;
//    }
//    
//    public Pedido obterUmCarrinhoPorUsuario(Pedido item) {
//        Pedido pedido = null;
//        
//        try {
//            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM pedidos WHERE ID_USUARIOS = ? AND ATIVO = 1 AND STATUS = 'Carrinho'");
//            pstmt.setInt(1, item.getUsuario().getId());
//            ResultSet rs = pstmt.executeQuery();
//            
//            while(rs.next()){
//                pedido = new Pedido();
//                pedido.setId(rs.getInt("ID"));
//                pedido.setDataCriaocao(rs.getDate("DAT_CRIACAO"));
//                pedido.setDataCancelamento(rs.getDate("DAT_CANCELAMENTO"));
//                pedido.setDataFinalizacao(rs.getDate("DAT_FINALIZACAO"));
//                pedido.setDataPagamento(rs.getDate("DAT_PAGAMENTO"));
//                pedido.setDataEntrega(rs.getDate("DAT_ENTREGA"));
//                pedido.setCancelado(rs.getBoolean("FLG_CANCELADO"));
//                pedido.setEmail(rs.getBoolean("FLG_EMAIL"));
//                pedido.setCodigoPedido(rs.getString("CODIGO_PEDIDO"));
//                pedido.setReferencia(rs.getString("REFERENCIA"));
//                pedido.setStatus(rs.getString("STATUS"));
//                Usuario usuario = new Usuario();
//                usuario.setId(rs.getInt("ID_USUARIOS"));
//                usuario = new UsuarioDAO(new ConexaoMySQL()).obterUmPorId(usuario);
//                pedido.setUsuario(usuario);
//                pedido.setAtivo(rs.getBoolean("ATIVO"));
//            }
//            
//        } catch (SQLException ex) {
//            return pedido;
//        }
//        
//        return pedido;
//    }

    public ArrayList<Pedido> listarTodos() {
        Pedido pedido = new Pedido();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM pedidos");
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                pedido = new Pedido();
                pedido.setId(rs.getInt("ID"));
                pedido.setDataCriaocao(rs.getDate("DAT_CRIACAO"));
                pedido.setDataPagamento(rs.getDate("DAT_PAGAMENTO"));
                pedido.setStatus(rs.getString("STATUS"));
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID_USUARIOS"));
                pedidos.add(pedido);
            }
            
        } catch (SQLException ex) {
            return pedidos;
        }
        
        return pedidos;
    }
    
//    public ArrayList<Pedido> listarTodosAprovados() {
//        Pedido pedido = new Pedido();
//        ArrayList<Pedido> pedidos = new ArrayList<>();
//        
//        try {
//            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM pedidos WHERE ATIVO = 1 AND STATUS = 'Aprovado'");
//            ResultSet rs = pstmt.executeQuery();
//            
//            while(rs.next()){
//                pedido = new Pedido();
//                pedido.setId(rs.getInt("ID"));
//                pedido.setDataCriaocao(rs.getDate("DAT_CRIACAO"));
//                pedido.setDataCancelamento(rs.getDate("DAT_CANCELAMENTO"));
//                pedido.setDataFinalizacao(rs.getDate("DAT_FINALIZACAO"));
//                pedido.setDataPagamento(rs.getDate("DAT_PAGAMENTO"));
//                pedido.setDataEntrega(rs.getDate("DAT_ENTREGA"));
//                pedido.setCancelado(rs.getBoolean("FLG_CANCELADO"));
//                pedido.setEmail(rs.getBoolean("FLG_EMAIL"));
//                pedido.setCodigoPedido(rs.getString("CODIGO_PEDIDO"));
//                pedido.setReferencia(rs.getString("REFERENCIA"));
//                pedido.setStatus(rs.getString("STATUS"));
//                Usuario usuario = new Usuario();
//                usuario.setId(rs.getInt("ID_USUARIOS"));
//                usuario = new UsuarioDAO(new ConexaoMySQL()).obterUmPorId(usuario);
//                pedido.setUsuario(usuario);
//                pedido.setAtivo(rs.getBoolean("ATIVO"));
//                pedidos.add(pedido);
//            }
//            
//        } catch (SQLException ex) {
//            return pedidos;
//        }
//        
//        return pedidos;
//    }
    
//    public ArrayList<Pedido> listarTodosPendentesDeEmail() {
//        Pedido pedido = new Pedido();
//        ArrayList<Pedido> pedidos = new ArrayList<>();
//        
//        try {
//            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM pedidos WHERE ATIVO = 1 AND STATUS = 'Aprovado' AND FLG_EMAIL = 0");
//            ResultSet rs = pstmt.executeQuery();
//            
//            while(rs.next()){
//                pedido = new Pedido();
//                pedido.setId(rs.getInt("ID"));
//                pedido.setDataCriaocao(rs.getDate("DAT_CRIACAO"));
//                pedido.setDataCancelamento(rs.getDate("DAT_CANCELAMENTO"));
//                pedido.setDataFinalizacao(rs.getDate("DAT_FINALIZACAO"));
//                pedido.setDataPagamento(rs.getDate("DAT_PAGAMENTO"));
//                pedido.setDataEntrega(rs.getDate("DAT_ENTREGA"));
//                pedido.setCancelado(rs.getBoolean("FLG_CANCELADO"));
//                pedido.setEmail(rs.getBoolean("FLG_EMAIL"));
//                pedido.setCodigoPedido(rs.getString("CODIGO_PEDIDO"));
//                pedido.setReferencia(rs.getString("REFERENCIA"));
//                pedido.setStatus(rs.getString("STATUS"));
//                Usuario usuario = new Usuario();
//                usuario.setId(rs.getInt("ID_USUARIOS"));
//                usuario = new UsuarioDAO(new ConexaoMySQL()).obterUmPorId(usuario);
//                pedido.setUsuario(usuario);
//                pedido.setAtivo(rs.getBoolean("ATIVO"));
//                pedidos.add(pedido);
//            }
//            
//        } catch (SQLException ex) {
//            return pedidos;
//        }
//        
//        return pedidos;
//    }
    
    public ArrayList<Pedido> listarTodosPendentesDePagamento() {
        Pedido pedido = new Pedido();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM pedidos WHERE ATIVO = 1 AND STATUS NOT IN ");
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                pedido = new Pedido();
                pedido.setId(rs.getInt("ID"));
                pedido.setDataCriaocao(rs.getDate("DAT_CRIACAO"));
                pedido.setDataPagamento(rs.getDate("DAT_PAGAMENTO"));
                pedido.setStatus(rs.getString("STATUS"));
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID_USUARIOS"));
                pedido.setUsuario(usuario);
                pedido.setAtivo(rs.getBoolean("ATIVO"));
                pedidos.add(pedido);
            }
            
        } catch (SQLException ex) {
            return pedidos;
        }
        
        return pedidos;
    }
    
    public ArrayList<Pedido> listarTodosPorCliente(Usuario usuario) {
        Pedido pedido = new Pedido();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM pedidos WHERE ID_USUARIOS = ? AND ATIVO = 1");
            pstmt.setInt(1, usuario.getId());
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                pedido = new Pedido();
                pedido.setId(rs.getInt("ID"));
                pedido.setDataCriaocao(rs.getDate("DAT_CRIACAO"));
                pedido.setDataPagamento(rs.getDate("DAT_PAGAMENTO"));
                pedido.setStatus(rs.getString("STATUS"));
                Usuario usuarioNovo = new Usuario();
                usuarioNovo.setId(rs.getInt("ID_USUARIOS"));
                pedido.setUsuario(usuarioNovo);
                pedido.setAtivo(rs.getBoolean("ATIVO"));
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
            
            if(item.getDataCriaocao() == null)
                pstmt.setNull(1, Types.VARCHAR);
            else
                pstmt.setDate(1, new java.sql.Date(item.getDataCriaocao().getTime()));
            
            if(item.getDataPagamento() == null)
                pstmt.setNull(4, Types.VARCHAR);
            else
                pstmt.setDate(4, new java.sql.Date(item.getDataPagamento().getTime()));
            
            pstmt.setString(7, item.getStatus());
            pstmt.setInt(8, item.getUsuario().getId());
            pstmt.setInt(12, item.getId());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }

}
