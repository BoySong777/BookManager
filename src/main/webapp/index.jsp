<%--
  User: LiQingsong
  Date: 2018/9/28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <head>
    <title>Login</title>
    <style>
      @import "assert/bootstrap/css/bootstrap.min.css";
      .header{
          background-color:#191e29 ;
          border-width: 0;
      }
      #head_img_a{
          padding: 0;
      }
        #head_img{
            height: 50px;
        }

        .navbar-banner{
            margin-top: 50px;
            background-image:url("assert/img/homepage-bg.png") ;
            background-size:cover;
            background-repeat: no-repeat;
        }
        .banner-container{
            min-height: 612px;
            padding-top: 140px;
        }
        .error-Info{
            height: 20px;
            color: #ac2925;
        }
        .form-group{
            width: 60%;
            margin: 0 auto;

        }
        .login{
            display: inline-block;
            margin: 0 23%;
            width: 150px;
        }
        .form-inline{
            width: 350px;
        }
        #submit{
            margin: 10px auto;
        }
        #registration-success{
            top: 40%;
            left: 40%;
            color: white;
            position: fixed;
            text-align: center;
            display:none;
        }

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
              <li class="">
                  <a href="ipSearch/index.jsp" style="color: #2aabd2">ip查询</a>
              </li>
          </ul>
        <div class="navbar-right btns">
          <a class="btn btn-default navbar-btn sign-up" data-sign="signup" href="#register" data-toggle="modal">注册</a>
        </div>
      </div>
    </div>
  </nav>
    <%--登录--%>
  <div class="navbar-banner layout-no-margin-top">
      <div class="banner-container">
            <div class="container">
                <div class="row">
                    <div class="col-md-7"></div>
                    <div class="col-md-5">
                        <div>
                            <div class="form-group">
                                <input class="form-control" name="email" id="email" type="email" placeholder="邮箱">
                                <div class="help-block text-left error-Info" id="error-info-email"></div>
                            </div>
                            <div class="form-group">
                                <input class="form-control" name="password" id="password" type="password" placeholder="密码">
                                <div class="help-block text-left error-Info"  id="error-info-password"></div>
                                <button class="btn btn-default login" id="login">登录</button>
                                <div class="help-block text-left error-Info"  id="error-info"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
      </div>
  </div>
    <%--注册模态框--%>
    <div id="register" class="modal fade" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">注册</h1>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <div class="form-group">
                            <label for="">用户名</label>
                            <div class="form-inline">
                            <input class="form-control" type="text" id="username" placeholder="用户名">
                                <label class="error-Info" id="user-info" style="color: red"></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="">邮箱</label>
                            <div class="form-inline">
                            <input class="form-control" type="email" id="new-email" placeholder="邮箱">
                            <label class="error-Info" id="email-info" style="color: red"></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="">密码</label>
                            <div class="form-inline">
                            <input class="form-control" type="password" id="new-password-1" placeholder="密码">
                            <label class="error-Info" id="password-info" style="color: red"></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="">再次输入密码</label>
                            <div class="form-inline">
                            <input class="form-control" type="password" id="new-password-2" placeholder="确认密码">
                            <label class="error-Info" id="confirm-info" style="color: red"></label>
                            </div>
                        </div>

                        <div class="text-center" id="submit">
                            <button class="btn btn-primary" id="sub">提交</button>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                        <a href="" data-dismiss="modal">已有账号？点我登录</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--注册成功出现的提示--%>
  <div id="registration-success" >
      <div>
          <label><img src="assert/img/true-ico.ico"></label>
          <label>注册成功</label>
      </div>
  </div>

  <script src="assert/js/jquery.js"></script>
  <script src="assert/js/operation.js"></script>
  <script src="assert/bootstrap/js/bootstrap.min.js"></script>

  <script>

  </script>
  </body>
</html>
