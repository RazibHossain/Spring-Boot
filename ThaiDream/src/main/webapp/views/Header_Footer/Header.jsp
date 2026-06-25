
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<html>
<head>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">ProjecD</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">User
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/User/Add/">Add</a></li>
                    <li><a href="/User/List/">List</a></li>
                    <li><a href="/User/Report/">Report (Jasper)</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Batch
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/Batch/Add/">Add</a></li>
                    <li><a href="/Batch/List/">List</a></li>
                </ul>
            </li>
            <li><a href="/Upload/file">Uploader</a></li>
            <li><a href="#">Page 2</a></li>
            <li style="alignment: right"><a href="/logout">Logout</a></li>
        </ul>
    </div>
</nav>

</body>
</html>
