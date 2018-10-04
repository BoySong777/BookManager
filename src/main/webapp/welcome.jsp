<%--
  User: LiQingsong
  Date: 2018/9/29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta name="viewport" content="width=device-width,initial-scale=1">
<head>
    <title>图书管理系统</title>
    <style>
        @import "assert/bootstrap/css/bootstrap.min.css";
    </style>
</head>
<body>
<%--导航条--%>
<nav class="navbar navbar-default navbar-fixed-top header">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#header-navbar-collapse" aria-expanded="false">
                <span class="sr-only">选项</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a id="head_img_a" class="navbar-brand" href="#">
                <img id="head_img" src="assert/img/headImg.png">
            </a>
        </div>

        <div class="collapse navbar-collapse" id="header-navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown ">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                        排序
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="" href="courses/index.html" >日期升序</a></li>
                        <li><a class="" href="developer/index.html">日期降序</a></li>
                    </ul>
                </li>
                <li class="">
                    <a href="paths/index.html">添加</a>
                </li>
                <li class="">
                    <a href="questions/index.html">最近添加</a>
                </li>
            </ul>
            <div class="navbar-right">
                <div>
                    <span>${sessionScope.user.username}</span>
                </div>
            </div>

            <div class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" class="form-control" name="search" autocomplete="off" placeholder="搜索 课程/问答">
                </div>
            </div>
        </div>
    </div>
</nav>

<script src="assert/js/jquery.js"></script>
<script src="assert/js/book_oper.js"></script>
<script src="assert/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
