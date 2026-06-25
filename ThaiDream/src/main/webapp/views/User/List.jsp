<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/3/2021
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../Header_Footer/Header.jsp"/>

<html>
<head>
    <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com//ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<h2 align="center">Current User List</h2>
<br><br>
<table border="1" align="center" id = "tableId">

    <th>Id</th>
    <th>Name</th>
    <th>Password</th>
    <th>Role</th>
    <%--<th>Enabled</th>--%>
    <th>roleuser</th>
    <th>Edit</th>
    <th>Delete</th>

    <c:forEach items="${user_list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.password}</td>
            <td>${user.role}</td>
            <td>${user.roleuser}</td>
            <td><a href="/User/Edit/${user.id}/" >
                <button class="btn btn-lg" style="background-color:transparent;">
                    <i class="fa fa-pencil"></i> Edit
                </button></a></td>
            <td><a href="/User/Delete/${user.id}/" >
                <button class="btn btn-lg" style="background-color:transparent;">
                    <i class="fa fa-pencil"></i> Delete
                </button></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script>
    $(function () {
        $('#tableId').DataTable();
    });
</script>