<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../Header_Footer/Header.jsp"/>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/2/2021
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<h2 align="center">Edit User </h2>

<br><br><br><br><br><br>
<form class="form-horizontal" action='/User/Edit/' method="POST" modelAttribute="userform">
<table align="center">
    <th width="40%" align="center">&nbsp;</th>
    <th width="60%" align="center">&nbsp;</th>
    <tr>
        <td>&nbsp;</td>
        <td><input type="hidden" name="id" value="${userform.id}"></td>
    </tr>
    <tr>
        <td>User Name:</td>
        <td><input type="text" id="username" name="userName" placeholder="User Name*" required value="${userform.userName}"></td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><input type="text" id="password" name="password" placeholder="Password*" required value="${userform.password}"></td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td> Role:</td>
        <%--<td><input type="text" id="role" name="role" placeholder="Role" value="${userform.role}"></td>--%>
        <td><select name="Role" required>
            <option value="${userform.role}">${userform.role}</option>
            <option value="ADMIN">ADMIN</option>
            <option value="USER">USER</option>
            <option value="STUDENTS">STUDENTS</option>
            <option value="OTHERS">OTHERS</option>
        </select></td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>Enabled</td>
        <td><select name="Enabled" >
            <option value="${userform.isenabled()}}">${userform.isenabled() ? 'Yes' : 'No'}</option>
            <option value="1">YES</option>
            <option value="0">NO</option>
        </select></td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>

    <tr align="center">
        <td colspan="2" style="padding-right: 300px"><div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button class="btn btn-success">Add User</button>
            </div>
        </div></td>
    </tr>

</table>

</form>

</body>
</html>
