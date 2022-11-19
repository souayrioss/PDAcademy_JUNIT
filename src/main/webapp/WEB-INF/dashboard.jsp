
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Dashboard</title>
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
      <c:out value="${sessionScope.adminConn.firstName.concat(' ').concat(sessionScope.adminConn.lastName)} " />
    </nav>
    <!-- end of navbar navigation -->
    <div class="content">
      <div class="container">
        <div class="row">
          <div class="col-md-12 page-header">
            <div class="page-pretitle">Overview</div>
            <h2 class="page-title">Dashboard</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-6 col-md-6 col-lg-4 mt-3">
            <div class="card">
              <div class="content">
                <div class="row">
                  <div class="col-sm-4">
                    <div class="icon-big text-center">
                      <i class="teal fas  fa-eye"></i>
                    </div>
                  </div>
                  <div class="col-sm-8">
                    <div class="detail">
                      <p class="detail-subtitle">All Activity</p>
                      <span class="number"><c:out value="${ countActivity }" /></span>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-6 col-lg-4 mt-3">
            <div class="card">
              <div class="content">
                <div class="row">
                  <div class="col-sm-4">
                    <div class="icon-big text-center">
                      <i class="violet fas fa-eye"></i>
                    </div>
                  </div>
                  <div class="col-sm-8">
                    <div class="detail">
                      <p class="detail-subtitle">All Exercise</p>
                      <span class="number"><c:out value="${ countExercise }" /></span>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-6 col-lg-4 mt-3">
            <div class="card">
              <div class="content">
                <div class="row">
                  <div class="col-sm-4">
                    <div class="icon-big text-center">
                      <i class="orange fas  fa-eye"></i>
                    </div>
                  </div>
                  <div class="col-sm-8">
                    <div class="detail">
                      <p class="detail-subtitle">All Participant</p>
                      <span class="number"><c:out value="${ countParticipant }" /></span>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="content">
                <div class="head">
                  <h5 class="mb-0">Top 10 Activity</h5>
                </div>
                <div class="canvas-wrapper">
                  <table class="table table-striped">
                    <thead class="success">
                    <tr>
                      <th>Title Activity</th>
                      <th >Type of Activity </th>
                      <th>Statenof Activity</th>
                      <th>Exercises In Activity</th>
                    </tr>
                    </thead>
                    <tbody>
                      <jsp:useBean id="activities" scope="request" type="java.util.List"/>
                      <c:forEach items="${activities}" var="activity">
                        <tr>
                          <td><c:out value="${activity.title}" /></td>
                          <td><c:out value="${activity.activityType}" /></td>
                          <td> <c:out value="${activity.state}" /></td>
                          <td><c:out value = "${activity.exercises.size()}"/></td>

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
</div>
<script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/datatables/datatables.min.css"></script>
<script src="${pageContext.request.contextPath}/assets/js/initiate-datatables.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/script.js"></script>

</body>

</html>
