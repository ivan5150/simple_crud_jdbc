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

<form method="post" action="/save/user"> <!-- /add/user -->
    <label for="author">User name:</label>

    <input type="text" id="author" name="author" placeholder="User"/>
    <br/>
    <br/>
    <label for="text">ID:</label>

    <input type="text" id="text" name="text" placeholder="ID"/>
    <br/>
    <br/>

    <button type="submit" class="btn btn-large btn-primary">Send message</button>

</form>



    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
      </div>
  </body>

</html>