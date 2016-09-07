  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Add User</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
  </head>
  <body>
      <div class="container">
          <h1><p class="text-center">Add User!</p></h1>
          <p align="right"><a class="btn btn-info btn-xs" href="/all/users" role="button">all users page</a></p>
<form:form method="post" action="/save/user" commandName="userForm" > <!-- /save/user -->
    <label for="id">User ID</label>
    <form:input type="text" id="id" path="id" placeholder="User id"/>
    <br/>
    <br/>

    <label for="name">User Name:</label>
    <form:input type="text" id="name" path="name" placeholder="User name"/>
    <br/>
    <br/>

    <input type="submit" class="btn btn-large btn-primary" action="/save/user" >Send message</input>

</form:form>


    <script src="js/bootstrap.js"></script>
      </div>
  </body>

</html>