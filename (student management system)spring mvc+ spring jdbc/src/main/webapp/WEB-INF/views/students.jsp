<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Students</title>
  <style>
    body { font-family: sans-serif; }
    table { border-collapse: collapse; width: 900px; }
    th, td { border: 1px solid #ccc; padding: 6px 10px; }
    th { background: #f4f4f4; }
    a.btn, button { padding: 6px 10px; text-decoration: none; border: 1px solid #888; background:#fafafa; cursor:pointer; }
    .topbar { margin-bottom: 12px; }
  </style>
</head>
<body>

<h1>Students</h1>

<div class="topbar">
  <a class="btn" href="${pageContext.request.contextPath}/students/new">Add Student</a>
</div>

<table>
  <thead>
    <tr>
      <th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Enrolled</th><th>Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="s" items="${students}">
    <tr>
      <td>${s.id}</td>
      <td>${s.name}</td>
      <td>${s.email}</td>
      <td>${s.course}</td>
      <td><c:out value="${s.enrolledDate}"/></td>
      <td>
        <a class="btn" href="${pageContext.request.contextPath}/students/${s.id}/edit">Edit</a>
        <form action="${pageContext.request.contextPath}/students/${s.id}/delete" method="post" style="display:inline">
          <button type="submit">Delete</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<c:if test="${empty students}">
  <p>No students yet. Click “Add Student”.</p>
</c:if>

</body>
</html>
