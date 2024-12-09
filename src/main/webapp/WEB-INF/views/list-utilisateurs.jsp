<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/22/2024
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>javaguides.net</title>

</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h2>CRM - Customer Relationship Manager</h2>
        <hr />

        <input type="button" value="Add Customer"
               onclick="window.location.href='showForm'; return false;"
               class="btn btn-primary" />
        <br/><br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Customer List</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Username</th>
                        <th>Adress</th>
                        <th>telephone</th>
                        <th>Action</th>
                    </tr>

                    <!-- loop over and print our utilisateurs -->
                    <c:forEach var="tempCustomer" items="${utilisateurs}">

                        <!-- construct an "update" link with utilisateur id -->
<%--                        <c:url var="updateLink" value="/utilisateur/updateForm">--%>
<%--                            <c:param name="utilisateurId" value="${tempCustomer.id}" />--%>
<%--                        </c:url>--%>

                        <!-- construct an "delete" link with utilisateur id -->
                        <c:url var="deleteLink" value="/utilisateur/delete">
                            <c:param name="utilisateurId" value="${tempCustomer.id}" />
                        </c:url>

                        <tr>
                            <td>${tempCustomer.username}</td>
                            <td>${tempCustomer.address}</td>
                            <td>${tempCustomer.telephone}</td>
0

                            <td>
                                <!-- display the update link --> <a href="${updateLink}">Update</a>
                                | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Are you sure you want to delete this utilisateur?'))) return false">Delete</a>
                            </td>

                        </tr>

                    </c:forEach>

                    <a href="logout">lgoout</a>

                </table>

            </div>
        </div>
    </div>

</div>
</body>
</html>
