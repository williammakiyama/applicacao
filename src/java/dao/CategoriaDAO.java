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
import model.Categoria;
import model.Categoria;
import util.ConexaoMySQL;
import util.IConexao;

/**
 *
 * @author willi
 */
public class CategoriaDAO extends DAO<Categoria>{

    public CategoriaDAO(IConexao conexao) throws SQLException {
        super(conexao);
    }

    @Override
    public Categoria obterUm(Categoria item) {
        Categoria categoria = null;
        
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM categorias WHERE ID = ?");
            pstmt.setInt(1, item.getId());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                categoria = new Categoria();
                categoria.setId(rs.getInt("ID"));
                categoria.setDescricao(rs.getString("DESCRICAO"));
            }
        } catch (SQLException ex) {
            return categoria;
        }
        return categoria;
    }

    @Override
    public ArrayList<Categoria> listarTodos() {
        Categoria categoria = null;
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM categorias");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                categoria = new Categoria();
                categoria.setId(rs.getInt("ID"));
                categoria.setDescricao(rs.getString("DESCRICAO"));
                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            return categorias;
        }
        return categorias;
    }

    @Override
    public boolean alterar(Categoria item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("UPDATE categorias SET DESCRICAO = ? WHERE ID = ?");
            pstmt.setString(1, item.getDescricao());
            pstmt.setInt(2, item.getId());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean inserir(Categoria item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("INSERT INTO categorias(DESCRICAO) VALUES (?)");
            pstmt.setString(1, item.getDescricao());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean desativar(Categoria item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
