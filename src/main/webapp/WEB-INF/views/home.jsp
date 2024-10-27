<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/26/2024
  Time: 7:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome - Assurances</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">
</head>
<body>
<!-- Navbar -->
<div class="navbar">
    <div class="navbar-left">
        <h3>Protecto</h3>
    </div>
    <div class="navbar-right">
        <p>Welcome, ${loggedInUser.username}</p>
        <a href="${pageContext.request.contextPath}/utilisateur/logout" class="btn btn-secondary">Logout</a>
    </div>
</div>

<div class="container">
    <div class="col-md-offset-2 col-md-8">
        <h2 class="text-center">Available Assurances</h2>
        <div class="panel panel-info">
            <div class="panel-body">
                <!-- Assurance Sante Section -->
                <div class="assurance-item">
                    <h3>Health Insurance (Assurance Sante)</h3>
                    <p>Comprehensive coverage for health and medical needs.</p>
                    <a href="${pageContext.request.contextPath}/reserveAssurance/HealthInsuranceForm" class="btn btn-primary">Reserve</a>
                </div>

                <!-- Assurance Habitation Section -->
                <div class="assurance-item">
                    <h3>Home Insurance (Assurance Habitation)</h3>
                    <p>Protection for your home and valuable belongings.</p>
                    <a href="${pageContext.request.contextPath}/reserveAssuranceHabitation" class="btn btn-primary">Reserve</a>
                </div>

                <!-- Assurance Automobile Section -->
                <div class="assurance-item">
                    <h3>Auto Insurance (Assurance Automobile)</h3>
                    <p>Coverage for vehicle damage, liability, and more.</p>
                    <a href="${pageContext.request.contextPath}/reserveAssuranceAutomobile" class="btn btn-primary">Reserve</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
