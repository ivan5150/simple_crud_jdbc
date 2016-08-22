<?xml version="1.0" encoding="UTF-8" ?>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>All Users</title>

</head>
<body>
<div class="container">

    <h1><p class="text-center">All Users</p></h1>
    <p align="right"><a class="btn btn-info btn-xs" href="/save/user" role="button">add user</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        </thead>
        <c:forEach var="user" items="${users}">
            <thbody>
                <tr>
                    <td> ${user.id}</td>
                    <td>${user.firstName}</td>

                </tr>
            </thbody>
        </c:forEach>
    </table>
</div>
</body>
</html>