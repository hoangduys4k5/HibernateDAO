<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
    <style>
        .message{
            color: green;
        }
    </style>
</head>
<%@ page isELIgnored="false" %>
<body>
    <h1>Create new Customer</h1>
    <a href="/customerdemo/customers">Back to product list</a>
    <p>
      <c:if test="${message != null}">
          <span class="message">${message}</span>
      </c:if>
    </p>
    <form:form action="edit" method="post" modelAttribute="customer">
        <fieldset>
            <legend>Customer information</legend>
            <table>
             <td> <form:hidden path="id"/> </td>
                <tr>
                
                    <td><form:label path="userName">Username:</form:label></td>
                    <td><form:input path="userName"/> </td>
                    <td><form:errors path="userName" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><form:label path="passWord">Password:</form:label></td>
                    <td><form:input path="passWord"/> </td>
                    <td><form:errors path="passWord" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><form:label path="fullName">Fullname:</form:label></td>
                    <td><form:input path="fullName"/> </td>
                </tr>
                <tr>
                    <td><form:label path="age">Age:</form:label></td>
                    <td><form:input path="age"/> </td>
                </tr>
                <tr>
                    <td><form:label path="address">Address:</form:label></td>
                    <td><form:input path="address"/> </td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><form:button>Edit customer</form:button> </td>
                </tr>
            </table>
        </fieldset>
    </form:form>
</body>
</html>
