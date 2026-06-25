
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../Header_Footer/Header.jsp"/>
<html>

<head>
    <title>Create User</title>
</head>
<body>

<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<h2 align="center">Create User </h2>

    <form class="form-horizontal" action='/User/Add/' method="POST" modelAttribute="userform">
        <br><br><br><br><br><br>
        <table align="center">
            <th width="40%" align="center">&nbsp;</th>
            <th width="60%" align="center">&nbsp;</th>
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
                    <option disabled selected value>--Select From Dropdown</option>
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
                <td><select name="Enabled">
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



       <%--<br><br> User Name: <input type="text" id="username" name="userName" placeholder="" value="${userform.userName}"><br><br>--%>
        <%--&lt;%&ndash;Password: <input type="text" id="password" name="password" placeholder="" value="${userform.password}"><br><br>&ndash;%&gt;--%>
       <%--Role:  <input type="text" id="role" name="role" placeholder="" value="${userform.role}"><br><br>--%>
        <%--Enabled: <input type="int" id="enabled" name="enabled" placeholder="" value="${userform.roleuser}"><br><br>--%>

        <%--<div class="control-group">--%>
            <%--<!-- Button -->--%>
            <%--<div class="controls">--%>
                <%--<button class="btn btn-success">Add User</button>--%>
            <%--</div>--%>
        <%--</div>--%>
    </form>
</body>
</html>
