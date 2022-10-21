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
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM categorias WHERE (ID = ? OR DESCRICAO = ?) AND ATIVO = 1");
            pstmt.setInt(1, item.getId());
            pstmt.setString(2, item.getDescricao());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                categoria = new Categoria();
                categoria.setId(rs.getInt("ID"));
                categoria.setDescricao(rs.getString("DESCRICAO"));
                categoria.setAtivo(rs.getBoolean("ATIVO"));
                categoria.setCategoria(new Categoria());
                categoria.getCategoria().setId(rs.getInt("ID_CATEGORIAS"));
            }
        } catch (SQLException ex) {
            return categoria;
        }
        return categoria;
    }

    public ArrayList<Categoria> listarTodos() {
        Categoria categoria = null;
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            PreparedStatement pstmt = getConexao().prepareStatement("SELECT * FROM categorias WHERE ATIVO = 1");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                categoria = new Categoria();
                categoria.setId(rs.getInt("ID"));
                categoria.setDescricao(rs.getString("DESCRICAO"));
                categoria.setAtivo(rs.getBoolean("ATIVO"));
                categoria.setCategoria(new Categoria());
                categoria.getCategoria().setId(rs.getInt("ID_CATEGORIAS"));
                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            return categorias;
        }
        return categorias;
    }

    public boolean alterar(Categoria item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("UPDATE categorias SET DESCRICAO = ?, ID_CATEGORIAS = ? WHERE ID = ?");
            pstmt.setString(1, item.getDescricao());
            pstmt.setInt(2, item.getCategoria().getId());
            pstmt.setInt(3, item.getId());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }

    public boolean inserir(Categoria item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("INSERT INTO categorias(DESCRICAO,ID_CATEGORIAS) VALUES (?,?)");
            pstmt.setString(1, item.getDescricao());
            pstmt.setInt(2, item.getCategoria().getId());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }

    public boolean desativar(Categoria item) {
        PreparedStatement pstmt;
        try {
            pstmt = getConexao().prepareStatement("UPDATE categorias SET ATIVO = 0 WHERE ID = ?");
            pstmt.setInt(1, item.getId());
            pstmt.execute();
            return true;
        } catch(Exception ex){
            return false;
        }
    }
}
