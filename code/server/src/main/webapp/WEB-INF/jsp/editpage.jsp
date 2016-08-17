<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16.08.2016
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>Edit Person</h1>
<c:url var="saveUrl" value="/HederKosher/main/persons/edit?id=${personAttribute.id}" />
<form:form modelAttribute="personAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="id">Id:</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="firstName">First Name:</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>

        <tr>
            <td><form:label path="lastName">Last Name</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>

        <%--<tr>--%>
            <%--<td><form:label path="money">Money</form:label></td>--%>
            <%--<td><form:input path="money"/></td>--%>
        <%--</tr>--%>
    </table>

    <input type="submit" value="Save" />
</form:form>

</body>
</html>
