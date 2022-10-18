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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import util.IConexao;

/**
 *
 * @author willi
 */
public class UsuarioDAO extends DAO<Usuario> {

    public UsuarioDAO(IConexao conexao) throws SQLException {
        super(conexao);
    }
    
    public Usuario Validar(Usuario usuario) throws SQLException{
        
        
        PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND senha = ?");
        pstmt.setString(1, usuario.getLogin());
        pstmt.setString(2, usuario.getSenha());
        ResultSet resultado = pstmt.executeQuery();
        Usuario user = null;
        while(resultado.next()){
            user = new Usuario();
            user.setId(resultado.getInt("ID"));
            user.setLogin(resultado.getString("USUARIO"));
            user.setSenha(resultado.getString("SENHA"));
        }
        
        //getConexao().close();
        
        return user;  
    }

    @Override
    public Usuario obterUm(Usuario usuario) {
        
        PreparedStatement pstmt;
        Usuario user = null;
        try {
            pstmt = getConexao().prepareStatement("SELECT * FROM usuarios WHERE login = ? AND senha = ? AND ativo = 1");
            
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            ResultSet resultado = pstmt.executeQuery();
            
            while(resultado.next()){
                user = new Usuario();
                user.setId(resultado.getInt("ID"));
                user.setLogin(resultado.getString("LOGIN"));
                user.setSenha(resultado.getString("SENHA"));
            }
            //getConexao().close();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }
    
    public Usuario obterUmPorId(Usuario usuario) {
        
        PreparedStatement pstmt;
        Usuario user = null;
        try {
            pstmt = getConexao().prepareStatement("SELECT * FROM usuarios WHERE id = ? AND ativo = 1");
            
            pstmt.setInt(1, usuario.getId());
            ResultSet resultado = pstmt.executeQuery();
            
            while(resultado.next()){
                user = new Usuario();
                user.setId(resultado.getInt("ID"));
                user.setLogin(resultado.getString("LOGIN"));
                user.setSenha(resultado.getString("SENHA"));
            }
            //getConexao().close();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

    @Override
    public ArrayList<Usuario> listarTodos() {
        
        PreparedStatement pstmt;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario user = null;
        
        try {
            pstmt = getConexao().prepareStatement("SELECT * FROM usuarios WHERE perfil = 'C'");
            ResultSet resultado = pstmt.executeQuery();
            
            while(resultado.next()){
                user = new Usuario();
                user.setId(resultado.getInt("ID"));
                user.setLogin(resultado.getString("LOGIN"));
                user.setSenha(resultado.getString("SENHA"));
                usuarios.add(user);
            }
            
            //getConexao().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
        
    }

    @Override
    public boolean alterar(Usuario item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("UPDATE usuarios SET LOGIN = ?,SENHA = ?,PERFIL = ? WHERE ID = ?");
            pstmt.setString(1, item.getLogin());
            pstmt.setString(2, item.getSenha());
            pstmt.setInt(4, item.getId());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean inserir(Usuario item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("INSERT INTO usuarios(LOGIN,SENHA,PERFIL) VALUES(?,?,?)");
            pstmt.setString(1, item.getLogin());
            pstmt.setString(2, item.getSenha());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean desativar(Usuario item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("UPDATE usuarios SET ATIVO = 0 WHERE ID = ?");
            pstmt.setInt(1, item.getId());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }

}
