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
    @Override
    public Usuario obterUm(Usuario usuario) {
        
        PreparedStatement pstmt;
        Usuario user = null;
        try {
            pstmt = getConexao().prepareStatement("SELECT * FROM usuarios WHERE login = ? AND senha = ?");
            
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            ResultSet resultado = pstmt.executeQuery();
            
            while(resultado.next()){
                user = new Usuario();
                user.setId(resultado.getInt("IDUSUARIOS"));
                user.setLogin(resultado.getString("LOGIN"));
                user.setSenha(resultado.getString("SENHA"));
            }
            //getConexao().close();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }
}