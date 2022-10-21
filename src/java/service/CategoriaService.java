/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CategoriaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Categoria;
import util.ConexaoMySQL;

/**
 *
 * @author willi
 */
public class CategoriaService extends Servico {

    public ArrayList<Categoria> ListarCategorias() throws SQLException {
        
        ArrayList<Categoria> categorias = new ArrayList<>();
        
        CategoriaDAO dao = new CategoriaDAO(getConexao());
        categorias = dao.listarTodos();
        dao.fecharConexao();

        return categorias;
    }
    
    public Categoria BuscarCategoria(int idCategoria) throws SQLException{
            
        Categoria categoria = new Categoria();
        categoria.setId(idCategoria);
        
        CategoriaDAO dao = new CategoriaDAO(getConexao());   
        categoria = dao.obterUm(categoria);   
        dao.fecharConexao();
            
        return categoria;
    }

}