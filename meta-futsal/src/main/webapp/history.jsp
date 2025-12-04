<%--
  Created by IntelliJ IDEA.
  User: bachtiar
  Date: 21/11/25
  Time: 19.33
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page session="true" contentType="text/html;charset=UTF-8" %>
<%
    if(session.getAttribute("userId")==null){ response.sendRedirect("login.jsp"); return; }
    List history = (List) request.getAttribute("history");
%>
<!doctype html>
<html>
<head><meta charset="utf-8"><title>Riwayat - MetaFutsal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css"></head>
<body>
<nav class="navbar navbar-dark" style="background:linear-gradient(90deg,#0d6efd,#0b5ed7);">
    <div class="container">
        <a class="navbar-brand" href="home.jsp"><img src="images/logo.png" alt="logo"/></a>
        <span style="color:#fff;font-weight:700;font-size:18px">MetaFutsal ⚽️</span>
        <div class="ms-auto"><a class="btn btn-secondary" href="home.jsp">Beranda</a></div>
    </div>
</nav>

<div class="container-main">
    <div class="card">
        <h4>Riwayat Booking</h4>
        <table class="table">
            <thead><tr><th>ID</th><th>Lapangan</th><th>Tanggal</th><th>Jam</th><th>Durasi</th><th>Total</th></tr></thead>
            <tbody>
            <% for(Object o: history){
                com.metafutsal.model.Booking b = (com.metafutsal.model.Booking) o;
                java.sql.Connection c = com.metafutsal.util.DBUtil.getConnection();
                java.sql.PreparedStatement p = c.prepareStatement("SELECT name FROM fields WHERE id=?");
                p.setInt(1, b.getFieldId());
                java.sql.ResultSet rr = p.executeQuery();
                String fname = rr.next() ? rr.getString(1) : "N/A";
            %>
            <tr>
                <td><%= b.getId() %></td>
                <td><%= fname %></td>
                <td><%= b.getBookingDate() %></td>
                <td><%= b.getStartTime() %></td>
                <td><%= b.getDuration() %> jam</td>
                <td>Rp <%= b.getTotalPrice() %></td>
            </tr>
            <% try{ rr.close(); p.close(); c.close(); }catch(Exception ignore){} } %>
            </tbody>
        </table>
        <a href="home.jsp" class="btn btn-secondary">Kembali</a>
    </div>
</div>
</body>
</html>