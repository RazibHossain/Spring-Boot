<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 10/8/2020
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>*****Login*****</h3>
<form action="addEntry">
   ID:   <input type="text" name="ID"><br>
   NAME: <input type="text" name="NAME"><br>
    <input type="submit"><br>

</form>
<br><br><br><br>
<h3>*****Search By Id*****</h3>
<form action="getEntry">
    ID:   <input type="text" name="ID"><br>
    <input type="submit"><br>


</form>
</body>
</html>
