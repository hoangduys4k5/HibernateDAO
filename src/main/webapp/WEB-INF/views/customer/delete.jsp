<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Do you want to delete this customer?</title>
    <style>
    .abc{
    color: red;}
    </style>
</head>

<%@ page isELIgnored="false" %>
<body>
    <h1>Customer details</h1>
    <a href="/customerdemo/list">Back to customer list</a>
     <form:form action="deleteconfirm" method="post" modelAttribute="customer">
        <fieldset>
            <legend>Customer information</legend>
    <table>
     <td> <form:hidden path="id"/> </td>
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
        <tr>
          <td><form:button class="abc">Delete customer</form:button> </td>
        </tr>
    </table>
      </fieldset>
    </form:form>
</body>
</html>
