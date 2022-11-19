<%--
  Created by IntelliJ IDEA.
  User: aslu
  Date: 11/14/22
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>all responsibles</title>
  <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome/css/fontawesome.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome/css/solid.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome/css/brands.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/datatables/datatables.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/css/master.css" rel="stylesheet">
</head>

<body>
<div class="wrapper">
  <!-- sidebar navigation component -->
  <nav id="sidebar" class="active">
    <div class="sidebar-header">
      <img src="../assets/img/bootstraper-logo.png" alt="javaclogo" class="app-logo">
    </div>
    <ul class="list-unstyled components text-secondary">
      <li>
        <a href="dashboard"><i class="fas fa-home"></i>Dashboard</a>
      </li>
      <li>
        <a href="activities"><i class="fas fa-file-alt"></i>Activities</a>
      </li>
      <li>
        <a href="exercises"><i class="fas fa-table"></i>Exercises</a>
      </li>
      <li>
        <a href="responsibles"><i class="fas fa-chart-bar"></i>Responsibles</a>
      </li>
      <li>
        <a href="participants"><i class="fas fa-icons"></i>Participants</a>
      </li>
    </ul>
  </nav>
  <!-- end of sidebar component -->
  <div id="body" class="active">
    <!-- navbar navigation component -->
    <nav class="navbar navbar-expand-lg navbar-white bg-white">
      <button type="button" id="sidebarCollapse" class="btn btn-light">
        <i class="fas fa-bars"></i><span></span>
      </button>
    </nav>
    <!-- end of navbar navigation -->
    <div class="content">
      <div class="container">
        <div class="page-title">
          <h3>responsables table</h3>
        </div>
        <div class="row">
          <div class="col-md-12 col-lg-12">
            <div class="card">
              <div class="card-header d-flex justify-content-between"><p></p> <a class="link-primary" href="create-responsible">add responsible</a></div>
              <div class="card-body">
                <p class="card-title"></p>
                <table class="table table-hover" id="dataTables-example" width="100%">
                  <thead>
                  <tr>
                    <th>Full name</th>
                    <th>Gender</th>
                    <th>Phone number</th>
                    <th>Domain</th>
                    <th>Type</th>
                    <th>State</th>
                    <th>Actions</th>
                  </tr>
                  </thead>
                  <tbody>
                  <jsp:useBean id="responsibles" scope="request" type="java.util.List"/>
                  <c:forEach items="${responsibles}" var="responsible">
                    <tr>
                      <td><c:out value="${responsible.firstName} ${responsible.lastName}" /></td>
                      <td><c:out value="${responsible.gender}" /></td>
                      <td><c:out value="${responsible.phoneNumber}" /></td>
                      <td><c:out value="${responsible.domain}" /></td>
                      <td><c:out value="${responsible.responsibleType}" /></td>
                      <td><c:out value="${responsible.state}" /></td>
                      <td>
                        <a class="btn-info" href="edit-responsible?id=<c:out value='${responsible.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn-danger" href="delete-responsible?id=<c:out value='${responsible.id}' />">Delete</a>
                      </td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/datatables/datatables.min.css"></script>
<script src="${pageContext.request.contextPath}/assets/js/initiate-datatables.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/script.js"></script>

</body>

</html>
