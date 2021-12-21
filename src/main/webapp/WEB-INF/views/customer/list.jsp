
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listing product</title>
</head>
<%@ page isELIgnored="false" %>
<body>
    <h1>Products</h1>
    <p><a href="/customerdemo/new">Add new Customer</a></p>
    <p>There are ${customers.size()} customers in this list.</p>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>Username</td>
            <td>Password</td>
            <td>FullName</td>
            <td>Age</td>
            <td>Address</td>
        </tr>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.getId()}</td>
                <td><a href="view?id=${customer.getId()}"> ${customer.getUserName()}</a></td>
                <td>${customer.getPassWord()}</td>
                <td>${customer.getFullName()}</td>
                <td>${customer.getAge()}</td>
                <td>${customer.getAddress()}</td>           
            </tr>
        </c:forEach>
    </table>
</body>
</html>
