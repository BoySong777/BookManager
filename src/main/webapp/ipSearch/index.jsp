<%--
  User: LiQingsong
  Date: 2018/9/28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>ip查询</title>
    <script src="../assert/js/jquery.js"></script>
    <style>
        @import "../assert/bootstrap/css/bootstrap.min.css";
    </style>
    <script>
        $(document).ready(function(){
            $("#search").click(function () {
                var info = $("#info").val();
                if(info==""||info==null){
                    $("#result").text("输入条件不能为空。");
                    $("#result").css("color","red");
                    return;
                }
                var pattern = /^\d{1,3}.\d{1,3}.\d{1,3}.\d{1,3}$/;
                var rs = pattern.test(info);
                if(!rs){
                   $("#result").text("查询条件有误！请重新输入。");
                   $("#result").css("color","red");
                   return;
                }else{
                    $.ajax({
                       url:"/../searchInfo",
                       type:"get",
                       data:{'info':info},
                        dataType:"text",
                        async:true,
                        success:function (data) {
                            $("#result").css("color","");
                            $("#result").text(data);
                        }

                    });
                }
            });
        });
    </script>
</head>
<body>
<div style="padding: 100px 100px 10px; width: 50%" class="col-md-offset-3">

    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="input-group">
                            <input type="text" class="form-control" id="info" placeholder="IP">
                            <span class="input-group-btn">
						<button class="btn btn-default" id="search" type="button">
							查询
						</button>
					</span>
                        </div><!-- /input-group -->
                    </div>
                </div>
            </h3>
        </div>
        <div class="panel-body" id="result">

        </div>


</div>
</div>
<script src="../assert/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
