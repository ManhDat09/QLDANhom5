<jsp:useBean id="listData" scope="request" type="java.util.List"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <b>QUAN LI KHOANG SAN</b>
            <c:if test="${username == null}">
                <a href="/login">Login</a>
            </c:if>

            <c:if test="${username != null}">
                <div>
                    <c:out value="${username}"/>
                    <a href="/logout">Logout</a>
                </div>
            </c:if>
        </div>
    </div>
    <form action="/search">
        <div class="input-group flex-nowrap" style="margin-bottom: 50px; width: 500px; margin-left: auto">
            <span class="input-group-text" id="addon-wrapping">Search</span>
            <input type="text" class="form-control" placeholder="brand..." aria-label="name"
                   aria-describedby="addon-wrapping" name="brand">
        </div>
    </form>
    <b>Danh sach khoang san:</b>
    <br><br>
    <table class="table">
        <thead>
        <tr style="background-color: #E9ECEF">
            <th scope="col">ID</th>
            <th scope="col">Ten khoang san</th>
            <th scope="col">Tên mo khoang san</th>
            <th scope="col">Tru luong</th>
<%--            <th scope="col">So luong</th>--%>
<%--            <th scope="col">OS</th>--%>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="entity" items="${listData}">
            <!-- Construct an update link (xây d?ng c?p nh?t) -->
            <c:url var="updateLink"
                   value="/showFormForUpdate">
                <c:param name="id"
                         value="${entity.madt}"/>
            </c:url>
            <!-- Construct an delete link  -->
            <c:url var="deleteLink" value="/delete">
                88
                <c:param name="id"
                         value="${entity.madt}"/>
            </c:url>
            <tr>
                <td>${entity.madt}</td>
                <td>${entity.tendt}</td>
                <td>${entity.tenmoks}</td>
                <td>${entity.truluong}</td>
                <c:choose>
                    <c:when test="${entity.truluong > 1000 }">
                        <td>Lon</td>
                    </c:when>
                    <c:when test="${entity.truluong < 100 }">
                        <td>IT</td>
                    </c:when>
                    <c:otherwise>
                        <td>TB</td>
                    </c:otherwise>
                </c:choose>
<%--                <td>${entity.soluong}</td>--%>
<%--                <td>${entity.hedieuhanh}</td>--%>
                <!-- display update link (hi?n th? lk c?p nh?t) -->
                <td><a href="${updateLink}">Update</a>
                    | <a href="${deleteLink}"
                         onclick="if(!(confirm('Delete confirm?'))) return false">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>
    <a href="/showFormForAdd">
        <button type="button" class="btn btn-success">Add New</button>
    </a>


</div>
<script type="javascript"
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
