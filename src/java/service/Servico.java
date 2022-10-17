package service;

import util.ConexaoMySQL;
import util.IConexao;

public class Servico {
    private static IConexao conexao;
    
    public Servico(){
        this.conexao = new ConexaoMySQL();
    }

    public static IConexao getConexao() {
        return conexao;
    }

    public static void setConexao(IConexao conexao) {
        Servico.conexao = conexao;
    }
    
}
