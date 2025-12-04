<%--
  Created by IntelliJ IDEA.
  User: bachtiar
  Date: 21/11/25
  Time: 19.31
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="true" contentType="text/html;charset=UTF-8" %>
<%
    if(session.getAttribute("userId")==null){ response.sendRedirect("login.jsp"); return; }
    String bookingId = request.getParameter("booking_id");
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Payment - MetaFutsal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<nav class="navbar navbar-dark" style="background:linear-gradient(90deg,#0d6efd,#0b5ed7);">
    <div class="container">
        <a class="navbar-brand" href="home.jsp"><img src="images/logo.png" alt="logo"/></a>
        <span style="color:#fff;font-weight:700;font-size:18px">MetaFutsal ⚽️</span>
        <div class="ms-auto"><a class="btn btn-secondary" href="home.jsp">Beranda</a></div>
    </div>
</nav>

<div class="container-main">
    <div class="card" style="max-width:720px;margin:0 auto;">
        <h4>Payment</h4>
        <p class="small-muted">Unggah bukti transfer, lalu tekan Kirim Bukti.</p>

        <form action="${pageContext.request.contextPath}/payment" method="post" enctype="multipart/form-data">
            <input type="hidden" name="booking_id" value="<%=bookingId%>">
            <div class="mb-3">
                <label class="form-label">Metode Pembayaran</label>
                <select name="method" class="form-select">
                    <option>Transfer</option>
                    <option>QRIS</option>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label">Bukti Pembayaran</label>
                <input type="file" name="proof" class="form-control" accept="image/*" required>
            </div>

            <div class="d-flex gap-2">
                <button class="btn btn-primary">Kirim Bukti</button>
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/booking">Batal</a>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>