<%-- 
    Document   : pedidos
    Created on : 22 de out. de 2022, 23:22:42
    Author     : William
--%>

<%@page import="model.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Respeto - Pedidos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark fixed-top">
            <div class="container-fluid">
                <a class="navbar-brand " href="/applicacao/Paginas/dashboard.jsp">Respeto Black</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Funções</h5>
                        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body">
                        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="#">Produtos</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="/applicacao/Paginas/pedidos.jsp">Pedidos Realizados</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="#">Estoque</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/applicacao/pedidos?func=sair" id="btnSair" >Sair</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        
        <div class="row mt-5">
        
        </div>
        <%
            HttpSession sessao = request.getSession();
            ArrayList  pedidosRecebidos = (ArrayList) sessao.getAttribute("pedidos");
            
            for(int i = 0;  i < pedidosRecebidos.size();  i++ ){

            }  
            
            
        %>

        <div class="container p-md-5 border rounded-3 bg-light mt-5">
            <table class="table table-striped  table-hover table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th class="col-2">Numero Pedido</th>
                        <th class="col-4">Data Pedido</th>
                        <th class="col">Cliente</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        
                    %>
                    <tr>
                        <th scope="row">1</th>
                        <td>01/03</td>
                        <td>Mark</td>
                    </tr>
                </tbody>
            </table>

        </div> 
        
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </body>
</html>
