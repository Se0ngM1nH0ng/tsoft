<%--
  Created by IntelliJ IDEA.
  User: smhong
  Date: 2024-01-04
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="common" %>

<html>
<head>
    <title>스케쥴러 관리화면</title>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/resources/plugins/fontawesome-free/css/all.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/resources/dist/css/adminlte.min.css">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>


    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="#" class="brand-link">
            <img src="/resources/dist/img/nhLogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
            <span class="brand-text font-weight-light">NH 농협</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item">
                        <a href="/page/scheduleManage" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                스케쥴러 관리
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="/page/scheduleLog" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                스케쥴러 로그
                            </p>
                        </a>
                    </li>
                    <li class="nav-item menu-open">
                        <a href="#" class="nav-link active">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                서버관리
                            </p>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>스케쥴러 관리 화면</h1>
                    </div>
                    <div class="card-body pad table-responsive">
                        <div class="row" >
                            <div class="col-md-3">
                                <div class="row">
                                    <div class="col-md-3">
                                        <button type="button" class="btn btn-block btn-outline-primary"><a href ="/page/scheduleInsert">등록</a></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-header">

                                        <h3 class="card-title">Job 목록</h3>

                                        <div class="card-tools">
                                                    <div class="input-group">
                                                        <select class="form-control select2" >
                                                            <option>제목</option>
                                                            <option>내용</option>
                                                        </select>
                                                        <input type="text" name="table_search" class="form-control" placeholder="Search">
                                                        <div class="input-group-append">
                                                            <button type="submit" class="btn btn-default">
                                                                <i class="fas fa-search"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                        </div>
                                    </div>
                                    <!-- /.card-header -->
                                    <div class="card-body table-responsive p-0" style="height: 500px;">
                                        <table class="table table-head-fixed text-nowrap">
                                            <thead>
                                            <tr>
                                                <th>번호</th>
                                                <th >Job 명</th>
                                                <th>Job 시행일자</th>
                                                <th>상태</th>
                                                <th>Job 생성일</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="jobList" items="${jobList}">
                                            <tr>
                                                <c:if test="${jobList.jobStatus != -1}">
                                                <td><button type="button" class="jobButton" data-toggle="modal" data-target="#modal-lg"
                                                            data-mid="${jobList.jobId}" style="border: none; background-color: #fff; padding-left: 0; padding-top: 0; text-decoration: underline;  ">
                                                        ${jobList.jobId}
                                                </button></td>
                                                <td>${jobList.jobTitle}</td>
                                                <td>${jobList.jobStartDate}</td>
                                                    <c:choose>
                                                        <c:when test="${jobList.jobStatus == 0}">
                                                        <td><div class="bg-primary color-palette" style="width:34px"><span>준비</span></div></td>
                                                        </c:when>
                                                        <c:when test="${jobList.jobStatus == 1}">
                                                        <td><div class="bg-warning color-palette" style="width:34px"><span>진행</span></div></td>
                                                        </c:when>
                                                        <c:when test="${jobList.jobStatus == 4}">
                                                        <td><div class="bg-maroon color-palette" style="width:34px"><span>오류</span></div></td>
                                                        </c:when>
                                                        <c:when test="${jobList.jobStatus == 7}">
                                                        <td><div class="bg-info color-palette" style="width:34px"><span>취소</span></div></td>
                                                        </c:when>
                                                        <c:when test="${jobList.jobStatus == 9}">
                                                        <td><div class="bg-orange color-palette" style="width:49px"><span>재처리</span></div></td>
                                                        </c:when>
                                                        <c:when test="${jobList.jobStatus == 10}">
                                                        <td><div class="bg-success color-palette" style="width:34px"><span>완료</span></div></td>
                                                        </c:when>
                                                    </c:choose>
                                                <td>${jobList.jobRegDate}</td>
                                                </c:if>
                                            </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.card-body -->
                                </div>
                                <!-- /.card -->
                            </div>
                        </div>



<!--modal-->
   <common:modal/>


</div>

<!-- jQuery -->
<script src="/resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- overlayScrollbars -->
<script src="/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>

                    <!--scheduleManage-->
                    <script src="/resources/js/admin/scheduleManage.js"></script>


</body>
</html>
