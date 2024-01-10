<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="common" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Job 등록</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/resources/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/resources/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">

<!--header-->
<common:header/>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>서버 등록</h1>
                </div>
            </div>
        </div>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <!-- left column -->
                <div class="col-md-12">
                    <!-- jquery validation -->
                    <div class="card card-primary" >
                        <div class="card-header" style="background-color: #f1f1f1!important;">
                            <h3 class="card-title" style="color: #0a0e14!important;">서버 등록 </h3>
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form id="quickForm">
                            <div class="card-body">
                                <div class="form-group">
                                    <label for="insertServerName">서버명</label>
                                    <input type="text" name="insertServerName" class="form-control" id="insertServerName" placeholder="서버명을 입력해주세요">
                                </div>
                                <div class="form-group">
                                    <label for="insertServerIp">서버 ip</label>
                                    <textarea type="text" name="insertServerIp" class="form-control" id="insertServerIp" placeholder="ip를 입력해주세요"></textarea>
                                </div>
                                <div class="form-group">
                                    <label for="insertServerDesc">서버 내용</label>
                                    <input type="text" name="insertServerDesc" class="form-control" id="insertServerDesc" placeholder="수행내용을 입력해주세요>
                                </div>
                                <div class="form-group">
                                    <label for="insertServerGroup">서버 그룹</label>
                                    <input type="text" name="insertServerGroup" class="form-control" id="insertServerGroup" placeholder="서버 그룹명을 입력해주세요">
                                </div>
                            </div>
                            <!-- /.card-body -->
                            <div class="card-footer">
                                <button type="button" class="btn btn-primary" onclick="javascript:insertServer()">등록</button>
                            </div>
                        </form>
                    </div>
                    <!-- /.card -->
                </div>
                <!--/.col (left) -->
                <!-- right column -->
                <div class="col-md-6">

                </div>
                <!--/.col (right) -->
            </div>
            <!-- /.row -->
        </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
</div>

<common:footer/>




<!-- jQuery -->
<script src="/resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- jquery-validation -->
<script src="/resources/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="/resources/plugins/jquery-validation/additional-methods.min.js"></script>
<!-- AdminLTE App -->
<script src="/resources/dist/js/adminlte.min.js"></script>
<!--scheduleInsert.js-->
<script src="/resources/js/admin/serverInsert.js"></script>
</body>
</html>
