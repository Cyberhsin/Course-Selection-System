<%--
  Created by IntelliJ IDEA.
  User: Shinlee
  Date: 2017/1/5
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>学生信息修改</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect.
    -->
    <link rel="stylesheet" href="/dist/css/skins/skin-blue.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="/Admin/adminIndex.jsp" class="logo">

            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>学生选课管理系统</b>管理员版</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">




            <!-- Sidebar Menu -->
            <ul class="sidebar-menu">
                <li class="header">HEADER</li>
                <!-- Optionally, you can add icons to the links -->
                <li class="active"><a href="/listAllStudent"><i class="fa fa-list-ol"></i> <span>学生列表</span></a></li>
                <li><a href="/selectionCount"><i class="fa fa-list"></i> <span>选课情况统计</span></a></li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-align-center"></i> <span>学生信息统计</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="studentNativeCount">籍贯统计</a></li>
                        <li><a href="studentHobbyCount">爱好统计</a></li>
                    </ul>
                </li>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">

            <!-- Your Page Content Here -->
            <!-- Horizontal Form -->
            <div class="box box-info">
                <div class="box-header with-border">
                    <h3 class="box-title">学生信息添加</h3>
                </div>
                <!-- /.box-header -->
                <!-- form start -->

                <script>
                    function check(form){
                        if (form.studentNum.value == "" || form.studentName.value == "" || form.studentPwd.value == "" ||
                            form.studentIdnums.value == "" || form.studentClass.value == "" || form.studentClass.value == "" ||
                            form.studentSex.value == "")
                        {
                            alert("请输入相应信息");
                            return false;
                        }
                        return true;
                    }
                </script>

                <form class="form-horizontal" action="/updateStudent/${student.studentNum}" method="post" onsubmit="return check(this)">
                    <div class="box-body">
                        <div class="form-group">
                            <label for="studentNum" class="col-sm-2 control-label">学号 *</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="studentNum" placeholder="学号" name="studentNum" value=${student.studentNum}>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="studentName" class="col-sm-2 control-label">姓名 *</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="studentName" placeholder="姓名" name="studentName" value=${student.studentName}>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="studentPwd" class="col-sm-2 control-label">密码 *</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="studentPwd" placeholder="密码" name="studentPwd">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="studentIdnums" class="col-sm-2 control-label">身份证号 *</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="studentIdnums" placeholder="身份证号" name="studentIdnums" value=${student.studentIdnums}>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="studentClass" class="col-sm-2 control-label">班级 *</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="studentClass" placeholder="班级" name="studentClass" value=${student.studentClass}>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="studentSex" class="col-sm-2 control-label">性别 *</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="studentSex" placeholder="性别" name="studentSex" value=${student.studentSex}>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="studentAddress" class="col-sm-2 control-label">地址</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="studentAddress" placeholder="地址" name="studentAddress" value=${student.studentAddress}>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="studentNative" class="col-sm-2 control-label">籍贯</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="studentNative" placeholder="籍贯" name="studentNative" value=${student.studentNative}>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="studentTel" class="col-sm-2 control-label">电话</label>
                            <div class="col-sm-10">
                                <input type="tel" class="form-control" id="studentTel" placeholder="电话" name="studentTel" value=${student.studentTel}>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="studentHobby" class="col-sm-2 control-label">爱好</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="studentHobby" placeholder="爱好" name="studentHobby" value=${student.studentHobby}>
                            </div>
                        </div>
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer">
                        <button type="reset" class="btn btn-default">重置</button>
                        <button type="submit" class="btn btn-info pull-right">修改</button>
                    </div>

                    <!-- /.box-footer -->
                </form>
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
            Anything you want
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2016 <a href="#">Company</a>.</strong> All rights reserved.
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
            <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
            <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- Home tab content -->
            <div class="tab-pane active" id="control-sidebar-home-tab">
                <h3 class="control-sidebar-heading">Recent Activity</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:">
                            <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                                <p>Will be 23 on April 24th</p>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

                <h3 class="control-sidebar-heading">Tasks Progress</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:">
                            <h4 class="control-sidebar-subheading">
                                Custom Template Design
                                <span class="pull-right-container">
                  <span class="label label-danger pull-right">70%</span>
                </span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

            </div>
            <!-- /.tab-pane -->
            <!-- Stats tab content -->
            <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
            <!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">
                <form method="post">
                    <h3 class="control-sidebar-heading">General Settings</h3>

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Report panel usage
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Some information about this general settings option
                        </p>
                    </div>
                    <!-- /.form-group -->
                </form>
            </div>
            <!-- /.tab-pane -->
        </div>
    </aside>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.3 -->
<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/app.min.js"></script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
</body>
</html>