<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/28/2024
  Time: 12:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Reserve Health Insurance</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/santeens.css">
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

<!-- Main Content -->
<div class="container">
    <h2>Reserve Health Insurance</h2>
    <p class="form-description">Please fill in the following information to reserve your health insurance plan.</p>

    <form action="${pageContext.request.contextPath}/reserveAssurance/HealthInsuranceForm" method="post">
        <!-- Age Input -->
        <div class="form-group">
            <label for="age">Age</label>
            <input type="text" id="age" name="age" required>
        </div>

        <!-- Health History Input -->
        <div class="form-group">
            <label for="historiqueSante">Health History</label>
            <select id="historiqueSante" name="historiqueSante">
                <option value="none">None</option>
                <option value="chronic">Chronic Illness</option>
                <option value="acute">Acute Illness</option>
            </select>
        </div>

        <!-- Coverage Type Input -->
        <div class="form-group">
            <label for="typeCouverture">Coverage Type</label>
            <select id="typeCouverture" name="typeCouverture">
                <option value="basic">Basic</option>
                <option value="premium">Premium</option>
            </select>
        </div>

        <!-- Submit Button -->
        <button type="submit" class="btn-primary">Submit Reservation</button>
    </form>
</div>
</body>
</html>
