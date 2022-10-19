<!doctype html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Respeto - Login</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-5">
            <%
                HttpSession sessao = request.getSession();
                String msg = (String) sessao.getAttribute("msg");
                if (msg != null) {
            %>
            <div class="alert alert-danger alert-dismissible fade show justify-content-center text-center" role="alert">
                <strong>Erro!</strong> <%= msg%>
            </div>
            <% request.removeAttribute("msg");
                }
                msg = null;
            %>
            <div class="row aling-items-center">
                <div class="col-md-10 mx-auto col-lg-5">
                    <form class="p-4 p-md-5 border rounded-3 bg-light" method="post" action="Login">
                        <div class=" mb-3">
                            <h1>Login</h1>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="string" class="form-control" id="txtLogin" name="txtLogin" placeholder="Usuario"/>
                            <label for="txtLogin">Usuario</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="txtSenha" name="txtSenha" placeholder="Senha"/>
                            <label for="txtSenha">Senha</label>
                        </div>
                        <div class="checkbox mb-3">
                            <label>
                                <input type="checkbox" value="lembrar"> Lembrar
                            </label>
                        </div>
                          <button class="w-100 btn btn-lg btn-dark" type="submit">Entrar</button>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>< 
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </body>
</html>