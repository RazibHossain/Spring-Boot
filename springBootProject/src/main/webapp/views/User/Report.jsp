<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/21/2021
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../Header_Footer/Header.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
<h3 style="alignment: center">Generate User Report</h3><br><br><br>
<form action="/User/Report/" modelAttribute="reportForm" method="post">
    <input type="text" id="username" name="userName" placeholder="User Name" value="${reportForm.userName}"><br><br>
    <input type="text" name="userId" placeholder="User Id" value="${reportForm.userId}"><br><br>
    <select name="reportFormat" required>
        <option value="pdf">PDF</option>
        <option value="html">HTML</option>
    </select><br><br><br>
    <div class="controls" id="html">
        <button class="btn btn-success">Submit</button>
    </div>

   <%-- <div class="controls">
        <button class="btn btn-success" id="pdf">pdf</button>
    </div>--%>


</form>
</div>
</body>
</html>

<%--<script>
    $("#html").on('click', function(){
        // window.location = "http://localhost:8888/User/report/html/";
        console.log("Razib")

        console.log($("#id").val())
    });$("a#thing_to_click").on('click', function(){
        window.location = "http://localhost:8888/User/report/pdf/";
    });
</script>--%>
