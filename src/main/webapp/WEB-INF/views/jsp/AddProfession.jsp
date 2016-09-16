<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Profession</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
</head>
<body>
<div class="container">
    <h1><p align="center" class="text-center">Add Profession</p></h1>
    <p align="right"><a class="btn btn-info btn-xs" href="/all/professions" role="button">all users page</a></p>
    <p align="right"><a class="btn btn-info btn-xs" href="/" role="button">home page</a></p>
    <form:form method="post" action="/save/profession" commandName="professionForm">
        <%-- <label for="id">Profession ID</label> --%>
        <form:input type="hidden" id="id" path="id" placeholder="Profession id"/>
        <br/>
        <br/>

        <label for="name">Profession:</label>
        <form:input type="text" id="name" path="name" placeholder="Profession title"/>
        <br/>
        <br/>

        <input type="submit" class="btn btn-large btn-primary" action="/save/profession">Send message</input>

    </form:form>


    <script src="js/bootstrap.js"></script>
</div>
</body>

</html>