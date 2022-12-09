<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
    <style>
        #container {
            max-width: 1200px;
            margin: 0 auto;
        }

        #header {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 20px 0;
            margin: 30px 0;
            color: #00933B;
            border-bottom: 1px solid #009378;
        }
    </style>
</head>

<body>
<div id="container">
    <div id="wrapper">
        <div id="header">
            <a>Danh Sach</a>
        </div>
    </div>
    <b>Add New:</b>
    <%--@elvariable id="object" type="quanly.entity.Entity"--%>
    <form:form action="save" modelAttribute="object"
               method="post">
        <form:hidden path="madt"/>
        <br><br>
        <div class="mb-3">
            <label for="fname" class="form-label">Ten KS</label>
            <form:input path="tendt" cssClass="form-control"/>
        </div>
        <div class="mb-3">
            <label for="lname" class="form-label">Ten MoKS</label>
            <form:input path="tenmoks" cssClass="form-control"/>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Tru luong</label>
            <form:input path="truluong" cssClass="form-control"/>
        </div>
<%--        <div class="mb-3">--%>
<%--            <label for="email" class="form-label">So luong</label>--%>
<%--            <form:input path="soluong" cssClass="form-control"/>--%>
<%--        </div>--%>
<%--        <div class="mb-3">--%>
<%--            <label for="email" class="form-label">OS</label>--%>
<%--            <form:input path="hedieuhanh" cssClass="form-control"/>--%>
<%--        </div>--%>

        <br>
        <button type="submit" class="btn btn-primary">Save</button>
        &nbsp; &nbsp; or &nbsp;     &nbsp;

        <a href="${pageContext.request.contextPath}/list">
            <button type="button" class="btn btn-success">Back to
                list
            </button>
        </a>
    </form:form>


</div>
<script type="javascript"
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>