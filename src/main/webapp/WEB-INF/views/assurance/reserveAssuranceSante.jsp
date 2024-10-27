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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/form.css">
</head>
<body>
<h2>Reserve Health Insurance (Assurance Sante)</h2>
<form action="${pageContext.request.contextPath}/reserveAssuranceSante" method="post">
    <label for="age">Age:</label>
    <input type="number" id="age" name="age" required>

    <label for="historiqueSante">Health History:</label>
    <select id="historiqueSante" name="historiqueSante">
        <option value="none">None</option>
        <option value="chronique">Chronic Illness</option>
    </select>

    <label for="typeCouverture">Coverage Type:</label>
    <select id="typeCouverture" name="typeCouverture">
        <option value="basic">Basic</option>
        <option value="premium">Premium</option>
    </select>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
