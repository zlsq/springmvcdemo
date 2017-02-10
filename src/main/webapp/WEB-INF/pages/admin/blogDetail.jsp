<%--
  Created by IntelliJ IDEA.
  User: zlsq
  Date: 2017/2/10
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>SpringMVC 博文详情</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <table class="table table-bordered table-striped">
        <tr>
            <th>ID</th>
            <td>${blog.id}</td>
        </tr>
        <tr>
            <th>Title</th>
            <td>${blog.title}</td>
        </tr>
        <tr>
            <th>Author</th>
            <td>${blog.userByUserId.nickname}, ${blog.userByUserId.firstName} ${blog.userByUserId.lastName}</td>
        </tr>
        <tr>
            <th>Content</th>
            <td>${blog.content}</td>
        </tr>
        <tr>
            <th>Publish Date</th>
            <td><fmt:formatDate value="${blog.pubDate}" pattern="yyyy年MM月dd日"/></td>
        </tr>
    </table>
</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
