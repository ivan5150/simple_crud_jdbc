<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head><a href="css/bootstrap.css" rel="stylesheet" media="screen"></a>
    <title>All Professions</title>
</head>
<body>
<div class="container">
    <h1><p align="center" class="text-center">All Professions</p></h1>
    <p align="right"><a class="btn btn-info btn-xs" href="/add/profession" role="button">add profession</a></p>
    <p align="right"><a class="btn btn-info btn-xs" href="/" role="button">home page</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="profession" items="${professions}">
            <thbody>
                <tr>
                    <td> ${profession.id}</td>
                    <td>${profession.name}</td>
                    <td>
                        <p>
                            <a class="btn btn-danger btn-xs" href="/delete/profession/${profession.id}" role="button">delete</a>
                            <a class="btn btn-default btn-xs" href="/save/profession/${profession.id}" role="button">edit</a>
                                <%--  <a class="btn btn-info btn-xs" href="/user/save/purse/${user.id}" role="button">add</a>  --%>
                            <a class="btn btn-info btn-xs" href="/add/profession" role="button">add new profession</a>
                        </p>
                    </td>
                </tr>
            </thbody>
        </c:forEach>
    </table>
</div>
</body>
</html>