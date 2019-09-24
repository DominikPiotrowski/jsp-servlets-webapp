<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">


<head>
    <title>Register</title>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="stylesheet.css">
</head>

<body>
<div class="container">
    <h1>Create account</h1>

    <form action="/registrationServlet" class="contact-form" method="post">

        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" class="sda-input" required>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" class="sda-input" required>
        </div>

        <div class="form-group">
            <label>firstName</label>
            <input type="text" name="firstName" class="sda-input" required>
        </div>

        <div class="form-group">
            <label>lastName</label>
            <input type="text" name="lastName" class="sda-input" required>
        </div>

        <div>
            <input type="submit" class="sda-button" value="Create" )>
        </div>
    </form>
</div>

</body>
</html>