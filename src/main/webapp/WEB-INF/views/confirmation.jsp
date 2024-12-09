<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/10/2024
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmation Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div class="container">
    <h2>Confirmation</h2>
    <p>Do you want to proceed with creating a contract based on the following details?</p>

    <div class="panel panel-info">
        <div class="panel-heading">Devis Details</div>
        <div class="panel-body">

            <p><strong>Id:</strong> ${devis.id}</p>
            <p><strong>Status:</strong> ${devis.status}</p>
            <p><strong>Base Price:</strong> ${devis.prixDeBase}</p>
            <p><strong>Final Price:</strong> ${devis.prixFinale}</p>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/contrat/registerContrat" method="post">
        <button type="submit" class="btn btn-primary">Yes</button>
        <a href="${pageContext.request.contextPath}/utilisateur/home" class="btn btn-secondary">No</a>
    </form>
</div>
</body>
</html>

