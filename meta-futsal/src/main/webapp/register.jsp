<%--
  Created by IntelliJ IDEA.
  User: bachtiar
  Date: 21/11/25
  Time: 19.28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Daftar - MetaFutsal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<nav class="navbar navbar-expand-lg" style="background:linear-gradient(90deg,#0d6efd,#0b5ed7);color:#fff;padding:12px 18px;">
    <div class="container">
        <a class="navbar-brand" href="home.jsp">
            <img src="images/logo.png" alt="MetaFutsal Logo" />
            <span style="color:#fff;font-weight:700;font-size:18px">MetaFutsal ⚽️</span>
        </a>
    </div>
</nav>

<div class="container-main">
    <div class="card" style="max-width:560px;margin:24px auto;">
        <h3 class="text-primary">Daftar Akun</h3>
        <% if(request.getAttribute("error")!=null){ %>
        <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
        <% } %>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="row g-3">
                <div class="col-md-6"><label class="form-label">Nama Lengkap</label><input type="text" name="fullname" class="form-control" required></div>
                <div class="col-md-6"><label class="form-label">No. HP</label><input type="text" name="phone" class="form-control"></div>
                <div class="col-12"><label class="form-label">Email</label><input type="email" name="email" class="form-control" required></div>
                <div class="col-12"><label class="form-label">Password</label><input type="password" name="password" class="form-control" required></div>
            </div>
            <div class="mt-3 d-flex gap-2">
                <button class="btn btn-primary">Daftar</button>
                <a class="btn btn-secondary" href="login.jsp">Kembali</a>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>