<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 21.06.2018
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona logowania</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <form class="form-signin" method="post" action="/login">
        <h2 class="form-signin-heading">Zaloguj się</h2>
        <label for="email" class="sr-only">Email</label>
        <input type="email" name="email" id="email" class="form-control" placeholder="Email" required autofocus>
        <label for="password" class="sr-only">Hasło</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="Hasło" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="rememberMe"> Zapamiętaj mnie
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
    </form>

</div> <!-- /container -->

</body>
</html>
