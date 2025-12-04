<%--
  Created by IntelliJ IDEA.
  User: bachtiar
  Date: 21/11/25
  Time: 19.29
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="true" contentType="text/html;charset=UTF-8" %>
<%
    if(session.getAttribute("userId")==null){ response.sendRedirect("login.jsp"); return; }
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Home - MetaFutsal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark" style="background:linear-gradient(90deg,#0d6efd,#0b5ed7);">
    <div class="container">
        <a class="navbar-brand" href="home.jsp"><img src="images/logo.png" alt="logo"/></a>
        <span style="color:#fff;font-weight:700;font-size:18px">MetaFutsal ⚽️</span>
        <div class="ms-auto d-flex gap-2">
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/booking">Booking</a>
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/history">Riwayat</a>
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/logout">Logout</a>
        </div>
    </div>
</nav>

<div class="container-main">
    <div class="row g-4">
        <div class="col-md-8">
            <div class="card">
                <h4>Selamat datang, 👕 <strong><%=session.getAttribute("fullname")%></strong></h4>
                <p class="small-muted">Pesan, bayar, dan main — cepat & aman.</p>
                <div class="mt-3">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/booking">Pesan Sekarang</a>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card">
                <h5>Status Lapangan</h5>
                <p class="small-muted">Ringkasan singkat tarif & lapangan.</p>
                <ul>
                    <%-- ambil fields singkat --%>
                    <%
                        java.util.List fields = (java.util.List) application.getAttribute("fields_cache");
                        if(fields == null){
                            fields = new java.util.ArrayList();
                        }
                        if(fields.size()==0){
                    %>
                    <li>Tidak ada data lapangan. Silakan ke Booking untuk melihat.</li>
                    <% } else {
                        for(Object o: fields){
                            com.metafutsal.model.Field f = (com.metafutsal.model.Field)o;
                    %>
                    <li><strong><%=f.getName()%></strong> — Rp <%=f.getPricePerHour()%>/jam</li>
                    <% }} %>
                </ul>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>