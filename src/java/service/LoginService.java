package service;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import util.ConexaoMySQL;
import util.CriptografarSenha;

public class LoginService extends Servico {
    
    private static Usuario usuario;
    
    public Usuario validarUsuario(String login, String senha){
        try {
            String senhaCriptografada = CriptografarSenha.encripta(senha);
            
            Usuario usuario = new Usuario();
            usuario.setLogin(login);
            usuario.setSenha(senhaCriptografada);
            
            UsuarioDAO dao = new UsuarioDAO(new ConexaoMySQL());
            usuario = dao.obterUm(usuario);
            dao.fecharConexao();
            
            LoginService.usuario = usuario;

            return usuario;
        } catch (SQLException ex) {
            return null;
        }
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        LoginService.usuario = usuario;
    }
    
}
