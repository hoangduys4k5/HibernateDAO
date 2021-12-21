
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer details</title>
</head>
<%@ page isELIgnored="false" %>
<body>
    <h1>Customer details</h1>
    <a href="/customerdemo/list">Back to customer list</a>
    <table>
        <tr>
            <td>Username: </td>
            <td>${customer.getUserName()}</td>
        </tr>
        <tr>
            <td>Password: </td>
            <td>${customer.getPassWord()}</td>
        </tr>
        <tr>
            <td>Fullname: </td>
            <td>${customer.getFullName()}</td>
        </tr>
        <tr>
            <td>Age: </td>
            <td>${customer.getAge()}</td>
        </tr>
        <tr>
            <td>Address: </td>
            <td>${customer.getAddress()}</td>
        </tr>
    </table>
</body>
</html>
