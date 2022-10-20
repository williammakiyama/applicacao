/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author William
 */
@WebFilter("/Paginas/*")
public class UsuarioFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpSession sessaoUsuario = ((HttpServletRequest)request).getSession();
        
        Usuario usuario = (Usuario) sessaoUsuario.getAttribute("usuarioLogado");
        
        if(usuario != null){
            chain.doFilter(request, response);
        }
        else{
//            chain.doFilter(request, response);
            //if(sessaoUsuario != null){
                sessaoUsuario.setMaxInactiveInterval(600);
                String msg = "Por favor faça Login!";
                sessaoUsuario.setAttribute("msg", msg);
           // }
            
            ((HttpServletResponse)response).sendRedirect("/applicacao/index.html");
        }
    }

    @Override
    public void destroy() {
    
    }
    
}
