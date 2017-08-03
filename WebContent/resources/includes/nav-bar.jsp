<%--
  Created by IntelliJ IDEA.
  User: I863273
  Date: 01/08/2017
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>

<div class="content-color col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2 text-left">
    <nav class="nav-bar-color navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">Where To Eat!</a>
            </div>
            <%--<ul class="nav navbar-nav">--%>
                <%--<li class="active"><a href="#">Home</a></li>--%>
                <%--<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                        <%--<li><a href="#">Page 1-1</a></li>--%>
                        <%--<li><a href="#">Page 1-2</a></li>--%>
                        <%--<li><a href="#">Page 1-3</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
                <%--<li><a href="#">Page 2</a></li>--%>
            <%--</ul>--%>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a>
                        <span class="glyphicon glyphicon-user"></span> <sec:authentication property="principal.username" />
                    </a>
                </li>
                <li>
                    <a href="/user/logout">
                        <span class="glyphicon glyphicon-log-out"></span> Logout
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</div>