<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Employees</title>
  <style>
    body{font-family:Arial;margin:24px}
    table{border-collapse:collapse;width:100%;margin-top:12px}
    th,td{border:1px solid #ddd;padding:8px}
    th{background:#f4f4f4}
    .topbar{display:flex;justify-content:space-between;align-items:center}
    a.button, button{padding:6px 10px;border:1px solid #aaa;background:#fafafa;text-decoration:none}
    .actions form{display:inline}
  </style>
</head>
<body>
<div class="topbar">
  <h2>Employee List</h2>
  <a class="button" href="${pageContext.request.contextPath}/employees/new">Add Employee</a>
</div>

<table>
  <thead>
    <tr>
      <th>Id</th><th>First</th><th>Last</th><th>Email</th><th>Salary</th><th>Dept</th><th>Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${employees}" var="e">
    <tr>
      <td>${e.id}</td><td>${e.firstName}</td><td>${e.lastName}</td>
      <td>${e.email}</td><td>${e.salary}</td><td>${e.department}</td>
      <td class="actions">
        <a class="button" href="${pageContext.request.contextPath}/employees/${e.id}/edit">Edit</a>
        <form method="post" action="${pageContext.request.contextPath}/employees/${e.id}/delete">
          <button type="submit" onclick="return confirm('Delete this employee?')">Delete</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
