<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/24/2024
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h2 class="text-center">Login</h2>
        <div class="panel panel-info">

            <div class="panel-body">
                <form:form action="login" cssClass="form-horizontal" method="post" modelAttribute="utilisateur">

                    <div class="form-group">
                        <label for="username" class="col-md-3 control-label">Username</label>
                        <div class="col-md-9">
                            <form:input path="username" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-md-3 control-label">Password</label>
                        <div class="col-md-9">
                            <form:input path="password" cssClass="form-control" type="password"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Login</form:button>
                        </div>
                    </div>
                </form:form>

                <div class="text-center">
                    <p>Don't have an account? <a href="register">Register here</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
