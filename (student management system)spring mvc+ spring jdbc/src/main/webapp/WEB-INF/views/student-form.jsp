<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title><c:out value="${mode=='edit' ? 'Edit Student' : 'Add Student'}"/></title>
  <style>
    body { font-family: sans-serif; }
    label { display:block; margin-top:10px; }
    input { padding:6px; width:320px; }
    .actions { margin-top:15px; }
    a.btn, button { padding:6px 10px; text-decoration:none; border:1px solid #888; background:#fafafa; cursor:pointer;}
  </style>
</head>
<body>

<h1><c:out value="${mode=='edit' ? 'Edit Student' : 'Add Student'}"/></h1>

<c:choose>
  <c:when test="${mode=='edit'}">
    <form method="post" action="${pageContext.request.contextPath}/students/${student.id}">
  </c:when>
  <c:otherwise>
    <form method="post" action="${pageContext.request.contextPath}/students">
  </c:otherwise>
</c:choose>

  <label>Name</label>
  <input type="text" name="name" value="${student.name}" required />

  <label>Email</label>
  <input type="email" name="email" value="${student.email}" required />

  <label>Course</label>
  <input type="text" name="course" value="${student.course}" required />

  <label>Enrolled Date (yyyy-MM-dd)</label>
  <input type="text" name="enrolledDate" value="${student.enrolledDate}" placeholder="2025-09-15" />

  <div class="actions">
    <button type="submit"><c:out value="${mode=='edit' ? 'Update' : 'Create'}"/></button>
    <a class="btn" href="${pageContext.request.contextPath}/students">Cancel</a>
  </div>
</form>

</body>
</html>
