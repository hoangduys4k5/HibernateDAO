<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nhat
  Date: 4/20/18
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
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
   
  
    <p>
      <c:if test="${message != null}">
          <span class="message">${message}</span>
      </c:if>
    </p>
    <form:form action="login" method="post" modelAttribute="customer">
        <fieldset>
            <legend>Login</legend>
            <table>
                <tr>
                    <td><form:label path="userName">Username:</form:label></td>
                    <td><form:input path="userName"/> </td>
                </tr>
                <tr>
                    <td><form:label path="passWord">Password:</form:label></td>
                    <td><form:input path="passWord"/> </td>
                </tr>
                <tr>
            
                
                <tr>
                    <td></td>
                    <td><form:button>Login</form:button> or <a href="/customerdemo/register">Register</td>
                </tr>
            </table>
        </fieldset>
    </form:form>
</body>
</html>
