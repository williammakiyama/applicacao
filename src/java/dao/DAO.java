/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import util.IConexao;

/**
 *
 * @author willi
 */
public abstract class DAO<T> {
    
    private Connection conexao;
    
    public DAO(IConexao conexao) throws SQLException{
        this.conexao = conexao.getConexao();
        this.conexao.setAutoCommit(false);
    }
    
    public abstract T obterUm(T item);
    
    public abstract ArrayList<T> listarTodos();
    
    public abstract boolean alterar(T item);
    
    public abstract boolean inserir(T item);
    
    public abstract boolean desativar(T item);

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void fecharConexao() throws SQLException{
        this.conexao.commit();
        this.conexao.close();
    }
    
    
}
