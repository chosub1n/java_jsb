<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
 <div class="container">
  <form action="/spring/login" class="mt-3" method="post">
  <h1>로그인</h1>
    <div class="form-group">
      <label for="id">아이디:</label>
      <input type="text" class="form-control" placeholder="아이디" name="id">
    </div>
    <div class="form-group">
      <label for="pw">비밀번호:</label>
      <input type="password" class="form-control" placeholder="비밀번호" name="pw">
    </div>
    <button class="btn btn-outline-success col-12 mb-4">로그인</button>
  </form>
</div>
</body>
</html>