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
            <form:form class="form-horizontal" modelAttribute="user" servletRelativeAction="register" method="post">
                <div class="form-group">
                    <label for="name" class="cols-sm-2 control-label">Name</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                            <form:input class="form-control" type="text" id="name" path="name" placeholder="Enter your Name"/>
                        </div>
                        <form:errors cssClass="error-message"  path="name"></form:errors>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label">E-mail</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <form:input type="text" class="form-control" id="email" path="email"  placeholder="Enter your e-mail"/>
                        </div>
                        <form:errors cssClass="error-message" path="email"></form:errors>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <form:input class="form-control" type="password" id="password" path="password" placeholder="Enter your Password"/>
                        </div>
                        <form:errors cssClass="error-message" path="password"></form:errors>
                    </div>
                </div>

                <div class="form-group">
                    <label for="confirmPassword" class="cols-sm-2 control-label">Confirm Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <form:input class="form-control" type="password" id="confirmPassword" path="passwordConfirm" placeholder="Confirm your Password"/>
                        </div>
                        <form:errors cssClass="error-message" path="passwordConfirm"></form:errors>
                    </div>
                </div>

                <div class="form-group ">
                    <form:button class="btn btn-primary btn-lg btn-block login-button">Register</form:button>
                </div>
                <div class="login-register">
                    Already have an account? <a href="/user/login">Sign-in</a>
                </div>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
