<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/24/2024
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Register Utilisateur</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
<!-- Link to your CSS file for styling -->
</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h2 class="text-center">Register</h2>
        <div class="panel panel-info">

            <div class="panel-body">
                <!-- Spring form with model attribute "utilisateur" -->
                <%--@elvariable id="utilisateur" type="org.assurance.assuranceapp.models.Utilisateur"--%>
                <form:form
                           cssClass="form-horizontal" method="post" modelAttribute="utilisateur">

                    <!-- Hidden field for id -->
                    <form:hidden path="id" />

                    <!-- Username field -->
                    <div class="form-group">
                        <label for="username" class="col-md-3 control-label">Username</label>
                        <div class="col-md-9">
                            <form:input path="username" cssClass="form-control" />
                        </div>
                    </div>

                    <!-- Password field -->
                    <div class="form-group">
                        <label for="password" class="col-md-3 control-label">Password</label>
                        <div class="col-md-9">
                            <form:password path="password" cssClass="form-control" />
                        </div>
                    </div>

                    <!-- Address field -->
                    <div class="form-group">
                        <label for="address" class="col-md-3 control-label">Address</label>
                        <div class="col-md-9">
                            <form:input path="address" cssClass="form-control" />
                        </div>
                    </div>

                    <!-- Telephone field -->
                    <div class="form-group">
                        <label for="telephone" class="col-md-3 control-label">Telephone</label>
                        <div class="col-md-9">
                            <form:input path="telephone" cssClass="form-control" />
                        </div>
                    </div>

                    <!-- Submit Button -->
                    <div class="form-group">
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                        </div>
                    </div>
                </form:form>

                <div class="text-center">
                    <p>Already have an account? <a href="login">Login here</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
