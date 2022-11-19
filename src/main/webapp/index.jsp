<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <!-- CSS only -->
  <link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/css/auth.css" rel="stylesheet">

</head>
<body>
<div class="wrapper">
  <div class="auth-content">
    <div class="card">
      <div class="card-body text-center">
        <div class="mb-4">
        </div>
        <h6 class="mb-4 text-muted">Login to your account</h6>
        <div class="text-danger ">
          <c:if test="${ !empty message }"><p>
            <i class="fa-solid fa-circle-exclamation"> </i><c:out value="${ message }" /></p>
          </c:if>
        </div>
        <form action="login" method="post">
          <div class="mb-3 text-start">
            <label  class="form-label">Username Or Email address</label>
            <input type="text" name="email" class="form-control" placeholder="Enter Email Or Username" required>
          </div>
          <div class="mb-5 text-start">
            <label class="form-label">Password</label>
            <input type="password" name="password" class="form-control" placeholder="Password" required>
          </div>
          <button class="btn btn-primary shadow-2 mb-4">Login</button>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>