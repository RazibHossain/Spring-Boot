<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/9/2021
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../Header_Footer/Header.jsp"/>
<html>
<head>
    <title>File Upload</title>
</head>
<body>


<form action="/Upload/file" method = "POST" enctype="multipart/form-data">
    <%--enctype="multipart/form-data" used for sending the request to multipart request otherwise it will show error--%>
    <br /> <br />
    Please select a file to upload :
    <input type = "file" name = "file" value = "Browse File" /> <br /> <br />
    Press here to upload the file :
    <input type = "submit" value = "upload" /> <br /> <br />

    Do you want to save excel data into database ? <a href="/Upload/fileSave"><b>Yes</b></a> &nbsp &nbsp <a href="/Upload/file"><b>No</b></a>
</form>





<%--<form action="/Upload/file" method="post">--%>
    <%--<div class="form-group">--%>
        <%--<label for="exampleFormControlFile1">Example file input</label>--%>
        <%--<input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">--%>
    <%--</div>--%>

<%--</form>--%>
    <%--<form action="/Upload/file/" method="post">--%>
    <%--<div class="controls">--%>
        <%--<button class="btn btn-success">Upload</button>--%>
    <%--</div>--%>
<%--</form>--%>
<%--<form action="/Upload/fileSave" method="post"><div class="controls">--%>
    <%--<button class="btn btn-success" >Save</button>--%>
<%--</div>--%>
<%--</form>--%>




</body>
</html>
