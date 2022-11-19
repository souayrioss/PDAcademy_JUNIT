<jsp:useBean id="activity" scope="request" type="org.loukili.javac.entity.Activity"/>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Tables | Bootstrap Simple Admin Template</title>
  <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome/css/fontawesome.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome/css/solid.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome/css/brands.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/datatables/datatables.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/css/master.css" rel="stylesheet">

  <link href="https://cdn.rawgit.com/harvesthq/chosen/gh-pages/chosen.min.css" rel="stylesheet"/>
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
          <h3>Activity information</h3>
        </div>
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title"></h5>
                <form class="needs-validation" novalidate accept-charset="utf-8">
                  <div class="row g-2">
                    <div class="mb-3 col-md-6">
                      <label  class="form-label">Activity Title</label>
                      <input type="text" class="form-control" name="title" value="${activity.title}" required disabled>
                    </div>
                    <div class="mb-3 col-md-6">
                      <label  class="form-label">responsible</label>
                      <input type="text" class="form-control" value="${activity.responsible.firstName} ${activity.responsible.firstName}" disabled>
                    </div>
                  </div>
                  <div class="mb-3">
                    <label  class="form-label">Description</label>
                    <textarea name="description" class="form-control" rows="4" cols="50" disabled>${activity.description}</textarea>
                  </div>
                  <div class="row g-2">
                    <div class="mb-3 col-md-6">
                      <label  class="form-label">start date</label>
                      <input type="text" class="form-control" value="${activity.startDate}" disabled required>
                    </div>
                    <div class="mb-3 col-md-6">
                      <label  class="form-label">start date</label>
                      <input type="text" class="form-control" value="${activity.endDate}" disabled required>
                    </div>
                  </div>
                  <div class="row g-2">
                    <div class="mb-3 col-md-6">
                      <label  class="form-label">Activity state</label>
                      <input type="text" class="form-control" value="${activity.state}" disabled required>
                    </div>
                    <div class="mb-3 col-md-6">
                      <label  class="form-label">Activity type</label>
                      <input type="text" class="form-control" value="${activity.activityType}" disabled required>
                    </div>
                  </div>
                  <div class="mb-3">
                    <h3 class="h3 text-primary"> exercises of this activity:</h3>
                    <table class="table table-hover" id="dataTables-example">
                      <thead>
                      <tr>
                        <th>title</th>
                        <th>year</th>
                        <th>status</th>
                      </tr>
                      </thead>
                      <tbody>
                    <c:forEach items="${activity.exercises}" var="exercise">
                      <tr>
                        <td><c:out value="${exercise.title}" /></td>
                        <td><c:out value="${exercise.year}" /></td>
                        <td><c:out value="${exercise.exerciseStatus}" /></td>
                      </tr>
                    </c:forEach>
                      </tbody>
                    </table>
                  </div>
                  <div class="mb-3">
                    <h3 class="h3 text-primary">participants in this activity:</h3>
                    <table class="table table-hover" id="dataTables-example" width="100%">
                      <thead>
                      <tr>
                        <th>Full name</th>
                        <th>Gender</th>
                        <th>Phone number</th>
                        <th>Email</th>
                        <th>Domain</th>
                      </tr>
                      </thead>
                      <tbody>
                    <c:forEach items="${activity.participants}" var="participant">
                      <tr>
                        <td><c:out value="${participant.firstName} ${participant.lastName}" /></td>
                        <td><c:out value="${participant.gender}" /></td>
                        <td><c:out value="${participant.phoneNumber}" /></td>
                        <td><c:out value="${participant.email}" /></td>
                        <td><c:out value="${participant.domain}" /></td>
                      </tr>
                    </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </form>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.rawgit.com/harvesthq/chosen/gh-pages/chosen.jquery.min.js"></script>

<script>
  $(document).ready(function () {
    $(".chosen-select").chosen();
  });
</script>
</body>

</html>

