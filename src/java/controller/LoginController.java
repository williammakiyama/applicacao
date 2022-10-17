/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import model.Cliente;
//import model.Pedido;
//import model.Usuario;
//import service.ClienteService;
//import service.EnderecoService;
import service.LoginService;
//import service.PedidoService;

public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("func").equals("sair")){
            request.getSession().invalidate();
            response.sendRedirect("/E-commerce/Autenticacao/Login.jsp");
        }
        else
            response.sendRedirect("/E-commerce/Autenticacao/NaoAutenticado.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");
        
        LoginService loginService = new LoginService();
        loginService.validarUsuario(login, senha);
        
        if(loginService.getUsuario() != null){
            
//            PedidoService pedidoService = new PedidoService();
//            if(pedidoService.buscarCarrinhoPorCliente(loginService.getUsuario().getId()) == null){
//                pedidoService.adcionarUmPedido(loginService.getUsuario().getId());
//            }
            HttpSession sessaoUsuario = request.getSession();
            if(sessaoUsuario != null){
                
                sessaoUsuario.setAttribute("usuarioLogado", loginService.getUsuario());
//                sessaoUsuario.setAttribute("carrinho", pedidoService.buscarCarrinhoPorCliente(loginService.getUsuario().getId()));
//            }
//            switch(loginService.validarUsuario(login, senha).getPerfil().toUpperCase()){
//                case "C":
//                    ClienteService clienteService = new ClienteService();
//                    Cliente cliente = new Cliente();
//                    cliente = clienteService.obterCliente(loginService.getUsuario().getId());
//                    sessaoUsuario.setAttribute("cliente", cliente);
//                    response.sendRedirect("../Cliente/Painel.jsp");
//                    break;
//                case "V":
//                    EnderecoService enderecoService = new EnderecoService();
//                    sessaoUsuario.setAttribute("endereco", enderecoService.obterEnderecoDoVendedor());
//                    response.sendRedirect("../Vendedor/Painel.jsp");
//                    break;
//                default:
//                    response.sendRedirect("../Erro/ErroPerfil.jsp");
//                    break;
            }
        }
        else{
            HttpSession sessaoUsuario = request.getSession();
            if(sessaoUsuario != null){
                sessaoUsuario.setMaxInactiveInterval(600);
                String msg = "Login ou Senha Incorreto!";
                sessaoUsuario.setAttribute("msg", msg);
            }
            response.sendRedirect("/index.jsp");
        }
    }
    
}
