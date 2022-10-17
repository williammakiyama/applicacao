/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author willi
 */
public class ConexaoMySQL implements IConexao{

    @Override
    public Connection getConexao(){
        
        Connection conexao = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbSistema","root","");
        
        }catch(ClassNotFoundException erro1){
            throw new RuntimeException(erro1);
        
        }catch(SQLException erro2){
            throw new RuntimeException(erro2);
        }
        
        return conexao;
    }

}
