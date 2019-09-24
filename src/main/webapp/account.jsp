<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set scope="page" var="user" value="${requestScope.get('user')}" />
<c:set scope="page" var="account" value="${user.bankAccounts}" />

<!DOCTYPE html>
<html lang="pl">

<head>
    <title>Account</title>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="stylesheet.css">
</head>

<body>
<div class="container">
    <h1>Welcome to your account</h1>
    <h2>First name: <span name="firstName" style="color:#f9aa33">${user.firstName}</span></h2>
    <h2>Last name: <span name="lastName" style="color:#f9aa33"> ${user.lastName} </span></h2>
    <h2>Email: <span name="email" style="color:#f9aa33"> ${user.email} </span></h2>
    <h2>Accounts : <span name="accountNumber" style="color:#f9aa33">

<%--${user.bankAccounts}--%>

    <c:forEach var="accountItem" items="${account}">
        <p>Account number: <c:out value="${accountItem.accountNumber}"/> </p>
        <p>Free founds: <c:out value="${accountItem.freeFounds}"/> </p>
        <p>Currency: <c:out value="${accountItem.currency}"/> </p><br>
    </c:forEach>

    </span></h2>

    <div>
        <form action="logout.jsp">
            <input type="submit" class="sda-button" value="Logout" />
        </form>
    </div>

    </div>
</body>

</html>
