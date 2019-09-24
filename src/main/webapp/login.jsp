<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">

<head>
    <title>Sign in</title>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="stylesheet.css">
</head>

<body>
<div class="container">
    <h1>Login to your account!</h1>

    <form action="/login" class="contact-form" method="post">
        <%--        UWAGA metoda post inaczej wyśle GET--%>

        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" class="sda-input" required>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" class="sda-input" required>
        </div>

        <div class="form-info">
            <label></label>
            <input type="checkbox" name="remember-me" checked="checked" name="remember"> Remember me
        </div>

        <div>
            <input type="submit" class="sda-button" value="Login" )>
        </div>
            <div>
                <form action="index.jsp">
                    <input type="submit" class="sda-button" value="Back to home page" />
                </form>
            </div>

    </form>
</div>

<%--<script src="login_listener.js"></script>--%>

</body>
</html>