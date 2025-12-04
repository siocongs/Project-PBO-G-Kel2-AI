<%--
  Created by IntelliJ IDEA.
  User: bachtiar
  Date: 21/11/25
  Time: 19.33
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Time" %>
<%@ page import="java.util.List" %>
<%@ page import="com.metafutsal.model.Field" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (session.getAttribute("userId") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Field> fields = (List<Field>) request.getAttribute("fields");
    Integer selectedField = (Integer) request.getAttribute("selectedField");
    java.sql.Date selectedDate = (java.sql.Date) request.getAttribute("selectedDate");
    List<Time> booked = (List<Time>) request.getAttribute("booked");

    String selectedDateStr = (selectedDate != null) ? selectedDate.toString() : "";
%>

<!DOCTYPE html>
<html>
<head>
    <title>Booking Lapangan – MetaFutsal</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">

    <style>
        body {
            background: #eef3ff;
        }
        .slot {
            display: inline-block;
            padding: 8px 14px;
            margin: 6px;
            border-radius: 8px;
            font-weight: 600;
        }
        .available {
            background: #dfe9ff;
            color: #0856d1;
            border: 1px solid #a8c5ff;
        }
        .booked {
            background: #ffd6d6;
            color: #b70000;
            border: 1px solid #ff8e8e;
        }
        .topbar {
            background: #0d6efd;
            padding: 14px;
            color: white;
        }
        .topbar a {
            background: white;
            color: #0d6efd;
            padding: 6px 14px;
            border-radius: 8px;
            font-weight: 600;
            text-decoration: none;
        }
    </style>
</head>

<body>

<!-- NAVBAR -->
<nav class="navbar navbar-dark" style="background:linear-gradient(90deg,#0d6efd,#0b5ed7);">
    <div class="container">
        <a class="navbar-brand" href="home.jsp"><img src="images/logo.png" alt="logo"/></a>
        <span style="color:#fff;font-weight:700;font-size:18px">MetaFutsal ⚽️</span>
        <div class="ms-auto"><a class="btn btn-secondary" href="home.jsp">Beranda</a></div>
    </div>
</nav>

<div class="container mt-4">

    <div class="card p-4">
        <h4 class="mb-3">Form Booking</h4>

        <a href="home.jsp" class="btn btn-outline-primary btn-sm mb-3">← Kembali</a>

        <% if (request.getAttribute("error") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
        <% } %>

        <!-- FORM -->
        <form method="get" action="booking">
            <div class="row">
                <div class="col-md-4 mb-3">
                    <label>Lapangan</label>
                    <select name="field_id" class="form-select" required>
                        <% for (Field f : fields) { %>
                        <option value="<%=f.getId()%>"
                                <%= (selectedField != null && selectedField == f.getId()) ? "selected" : "" %>>
                            <%= f.getName() %> — Rp <%= f.getPricePerHour() %>/jam
                        </option>
                        <% } %>
                    </select>
                </div>

                <div class="col-md-4 mb-3">
                    <label>Tanggal</label>
                    <input type="date" name="date" value="<%= selectedDateStr %>" class="form-control" required>
                </div>

                <div class="col-md-4 mb-3 d-flex align-items-end">
                    <button class="btn btn-primary w-100">Tampilkan Jadwal</button>
                </div>
            </div>
        </form>

        <hr>

        <!-- FORM BOOKING UTAMA -->
        <form method="post" action="booking">

            <input type="hidden" name="field_id" value="<%= (selectedField != null ? selectedField : fields.get(0).getId()) %>">

            <input type="hidden" name="date" value="<%= (!selectedDateStr.isEmpty() ? selectedDateStr : new java.sql.Date(System.currentTimeMillis()).toString()) %>">


            <div class="row">
                <div class="col-md-4 mb-3">
                    <label>Jam Mulai</label>
                    <input type="time" name="start_time" class="form-control" required>
                </div>

                <div class="col-md-4 mb-3">
                    <label>Durasi (jam)</label>
                    <input type="number" name="duration" min="1" value="1" class="form-control" required>
                </div>
            </div>

            <button class="btn btn-primary">Pesan</button>
            <a href="home.jsp" class="btn btn-secondary">Batal</a>
        </form>

        <hr>

        <!-- SLOT WAKTU -->
        <h5 class="mt-3">Jadwal untuk <%= selectedDateStr %></h5>
        <small>Waktu tersedia 08:00 – 22:00 (per jam)</small>
        <div class="mt-3">

            <%
                for (int h = 8; h <= 21; h++) {
                    String hh = (h < 10 ? "0" + h : "" + h) + ":00:00";
                    Time t = Time.valueOf(hh);
                    boolean isBooked = booked != null && booked.contains(t);
            %>

            <span class="slot <%= isBooked ? "booked" : "available" %>">
                    <%= (h < 10 ? "0" + h : h) %>:00
                    <%= isBooked ? "Booked" : "Available" %>
                </span>

            <% } %>

        </div>

    </div>
</div>

</body>
</html>