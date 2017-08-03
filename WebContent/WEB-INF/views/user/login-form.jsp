<%--
  Created by IntelliJ IDEA.
  User: I863273
  Date: 01/08/2017
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="pt_BR">
    <%@include file="/resources/includes/header.jsp"%>
<body>

<div class="container">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Where To Eat!</h1>
                <hr />
            </div>
        </div>
        <div class="main-login main-center">
            <form:form class="form-horizontal" modelAttribute="user" servletRelativeAction="login" method="post">
                <div class="form-group">
                    <span class="success-message" >${message}</span>
                    <label for="email" class="cols-sm-2 control-label">E-mail</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="email" id="email"  placeholder="Enter your E-mail"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <span class="error-message" >${error}</span>
                    <label for="password" class="cols-sm-2 control-label">Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
                        </div>
                    </div>
                </div>

                <div class="form-group ">
                    <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Sign in</button>
                </div>
                <div class="login-register">
                    <a href="/user/register">Create account</a> or <a href="#">reset password</a>
                </div>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
