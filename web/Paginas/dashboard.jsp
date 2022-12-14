<%-- 
    Document   : dashboard
    Created on : 17 de out. de 2022, 22:41:53
    Author     : William
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Respeto - Dashboard</title>
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
                                <a class="nav-link" aria-current="page" href="/applicacao/pedidos">Pedidos Em Aberto</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="#">Estoque</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/applicacao/dashboard?func=sair" id="btnSair" >Sair</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        
        <div class="row mt-5">
        
        </div>

        <div class="container p-md-5 border rounded-3 bg-light mt-5">
            <div class="d-grid gap-2 aling-items-center">
                <button class="btn btn-dark btn-lg mb-3" type="button">Novo Pedido</button>
                <button class="btn btn-dark btn-lg mb-3" type="button" value="submit" onclick="window.location.href = '/applicacao/pedidos'">Pedidos Em Aberto</button>
                <button class="btn btn-dark btn-lg mb-3" type="button">Estoque</button>
                <button class="btn btn-dark btn-lg mb-3" type="button">Produtos</button>
            </div>
        </div> 
        <script function listarPedidos>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </body>
</html>
