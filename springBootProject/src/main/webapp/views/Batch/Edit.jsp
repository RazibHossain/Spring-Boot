
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../Header_Footer/Header.jsp"/>
<html>

<head>
    <title>Create Batch</title>
</head>
<body>

<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<h2 align="center">Edit Batch </h2>

<form class="form-horizontal" action='/Batch/Edit/' method="POST" modelAttribute="batchform">
    <br><br><br><br><br><br>
    <table align="center">
        <th width="40%" align="center">&nbsp;</th>
        <th width="60%" align="center">&nbsp;</th>
        <tr>
            <td>&nbsp;</td>
            <td><input type="hidden" name="id" value="${batchform.id}"></td>
        </tr>
        <tr>
            <td>Batch Name:</td>
            <td><input type="text" id="batchId" name="batchName" placeholder="Batch Name*" required value="${batchform.batchName}"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>

        <tr>
            <td>Start Date:</td>
            <td><input type="date" id="startDateId" name="startDate" placeholder="Start Date*" required value="${batchform.startDate}"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>

        <tr>
            <td>End Date:</td>
            <td><input type="date" id="endDateId" name="endDate" placeholder="End Date*" required value="${batchform.endDate}"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>

        <tr>
            <td>Duration:</td>
            <td><input type="int" id="durationId" name="duration" placeholder="Duration in Month*" required value="${batchform.duration}"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>

        <tr>
            <td>Studen Capacity:</td>
            <td><input type="int" id="studentCapacityId" name="studentCapacity" placeholder="Capacity*" required value="${batchform.studentCapacity}"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>

        <tr align="center">
            <td colspan="2" style="padding-right: 300px"><div class="control-group">
                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success">Edit Batch</button>
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

<%--<script>--%>
    <%--&lt;%&ndash;document.getElementById("startDateId").defaultValue = ${batchform.endDate};&ndash;%&gt;--%>

    <%--$(document).ready( function() {--%>
        <%--var now = new Date();--%>
        <%--var today = now.getFullYear() + '-' + (now.getMonth() + 1) + '-' + now.getDate();--%>
        <%--$('#startDateId').val(today).change;--%>

        <%--&lt;%&ndash;var date = new Date(${batchform.endDate});&ndash;%&gt;--%>
        <%--console.log("razib")--%>
        <%--console.log(${batchform.startDate}.toString());--%>
        <%--// console.log(date)--%>
        <%--&lt;%&ndash;var x = ${batchform.startDate};&ndash;%&gt;--%>
        <%--&lt;%&ndash;var dat = new Date(${batchform.startDate});&ndash;%&gt;--%>
        <%--// console.log(dat)--%>
        <%--// $("#startDateId").attr("value", today);--%>
    <%--});--%>
<%--</script>--%>
