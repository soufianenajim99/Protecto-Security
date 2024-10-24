<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/22/2024
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Test</title>

</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h2 class="text-center">Adding Utilisateur
            Example</h2>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Add Utilisateur</div>
            </div>
            <div class="panel-body">
                <form:form action="saveUtilisateur" cssClass="form-horizontal"
                           method="post" modelAttribute="utilisateur">

                    <!-- need to associate this data with utilisateur id -->
                    <form:hidden path="id" />

                    <div class="form-group">
                        <label for="username" class="col-md-3 control-label">First
                            Name</label>
                        <div class="col-md-9">
                            <form:input path="username" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-md-3 control-label">Last
                            Name</label>
                        <div class="col-md-9">
                            <form:input path="password" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="address" class="col-md-3 control-label">Adress</label>
                        <div class="col-md-9">
                            <form:input path="address" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telephone" class="col-md-3 control-label">Adress</label>
                        <div class="col-md-9">
                            <form:input path="telephone" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
