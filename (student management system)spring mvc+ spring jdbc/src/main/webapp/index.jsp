<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Student Management System</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      text-align: center;
      margin-top: 100px;
    }
    h1 {
      color: #2c3e50;
    }
    a.btn {
      display: inline-block;
      margin-top: 20px;
      padding: 10px 20px;
      background-color: #3498db;
      color: #fff;
      text-decoration: none;
      border-radius: 5px;
    }
    a.btn:hover {
      background-color: #2980b9;
    }
  </style>
</head>
<body>

  <h1>Welcome to Student Management System</h1>
  <p>Click below to get started:</p>
  <a class="btn" href="${pageContext.request.contextPath}/students">Go to Students</a>

</body>
</html>
