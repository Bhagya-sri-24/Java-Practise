<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>${title}</title>
  <style>
    body{font-family:Arial;margin:24px}
    form{max-width:520px}
    label{display:block;margin-top:12px}
    input{width:100%;padding:8px;box-sizing:border-box}
    .row{display:flex;gap:12px}
    .row .col{flex:1}
    .actions{margin-top:16px;display:flex;gap:8px}
    a.button, button{padding:6px 10px;border:1px solid #aaa;background:#fafafa;text-decoration:none}
  </style>
</head>
<body>

<h2>${title}</h2>

<c:choose>
  <c:when test="${empty employee.id}">
    <form method="post" action="${pageContext.request.contextPath}/employees">
  </c:when>
  <c:otherwise>
    <form method="post" action="${pageContext.request.contextPath}/employees/${employee.id}">
  </c:otherwise>
</c:choose>

  <div class="row">
    <div class="col">
      <label>First Name
        <input type="text" name="firstName" value="${employee.firstName}" required maxlength="100"/>
      </label>
    </div>
    <div class="col">
      <label>Last Name
        <input type="text" name="lastName" value="${employee.lastName}" required maxlength="100"/>
      </label>
    </div>
  </div>

  <label>Email
    <input type="email" name="email" value="${employee.email}" maxlength="150"/>
  </label>

  <div class="row">
    <div class="col">
      <label>Salary
        <input type="number" step="0.01" name="salary" value="${employee.salary}"/>
      </label>
    </div>
    <div class="col">
      <label>Department
        <input type="text" name="department" value="${employee.department}" maxlength="100"/>
      </label>
    </div>
  </div>

  <div class="actions">
    <button type="submit">Save</button>
    <a class="button" href="${pageContext.request.contextPath}/employees">Cancel</a>
  </div>
</form>

</body>
</html>
