<%--
  Created by IntelliJ IDEA.
  User: smhong
  Date: 2024-01-04
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
<body class="hold-transition sidebar-mini layout-fixed">

<!-- Site wrapper -->
<div class="wrapper">
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="../../index3.html" class="nav-link">Home</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Contact</a>
            </li>
        </ul>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <!-- Navbar Search -->
            <li class="nav-item">
                <a class="nav-link" data-widget="navbar-search" href="#" role="button">
                    <i class="fas fa-search"></i>
                </a>
                <div class="navbar-search-block">
                    <form class="form-inline">
                        <div class="input-group input-group-sm">
                            <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                            <div class="input-group-append">
                                <button class="btn btn-navbar" type="submit">
                                    <i class="fas fa-search"></i>
                                </button>
                                <button class="btn btn-navbar" type="button" data-widget="navbar-search">
                                    <i class="fas fa-times"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </li>

            <!-- Messages Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-comments"></i>
                    <span class="badge badge-danger navbar-badge">3</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="../../dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Brad Diesel
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">Call me whenever you can...</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="../../dist/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    John Pierce
                                    <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">I got your message bro</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="../../dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nora Silvester
                                    <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">The subject goes here</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
                </div>
            </li>
            <!-- Notifications Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-bell"></i>
                    <span class="badge badge-warning navbar-badge">15</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <span class="dropdown-item dropdown-header">15 Notifications</span>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-envelope mr-2"></i> 4 new messages
                        <span class="float-right text-muted text-sm">3 mins</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-users mr-2"></i> 8 friend requests
                        <span class="float-right text-muted text-sm">12 hours</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-file mr-2"></i> 3 new reports
                        <span class="float-right text-muted text-sm">2 days</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                    <i class="fas fa-expand-arrows-alt"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                    <i class="fas fa-th-large"></i>
                </a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="../../index3.html" class="brand-link">
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
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Layout</a></li>
                            <li class="breadcrumb-item active">Fixed Layout</li>
                        </ol>
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
                                                <c:if test="${jobList.job_status != -1}">
                                                <td><button type="button" class="jobButton" data-toggle="modal" data-target="#modal-lg"
                                                            data-mid="${jobList.job_id}" style="border: none; background-color: #fff; padding-left: 0; padding-top: 0; text-decoration: underline;  ">
                                                        ${jobList.job_id}
                                                </button></td>
                                                <td>${jobList.job_title}</td>
                                                <td>${jobList.job_start_date}</td>
                                                    <c:choose>
                                                        <c:when test="${jobList.job_status == 0}">
                                                        <td><div class="bg-primary color-palette" style="width:34px"><span>준비</span></div></td>
                                                        </c:when>
                                                        <c:when test="${jobList.job_status == 1}">
                                                        <td><div class="bg-warning color-palette" style="width:34px"><span>진행</span></div></td>
                                                        </c:when>
                                                        <c:when test="${jobList.job_status == 4}">
                                                        <td><div class="bg-maroon color-palette" style="width:34px"><span>오류</span></div></td>
                                                        </c:when>
                                                        <c:when test="${jobList.job_status == 7}">
                                                        <td><div class="bg-info color-palette" style="width:34px"><span>취소</span></div></td>
                                                        </c:when>
                                                        <c:when test="${jobList.job_status == 9}">
                                                        <td><div class="bg-orange color-palette" style="width:49px"><span>재처리</span></div></td>
                                                        </c:when>
                                                        <c:when test="${jobList.job_status == 10}">
                                                        <td><div class="bg-success color-palette" style="width:34px"><span>완료</span></div></td>
                                                        </c:when>
                                                    </c:choose>
                                                <td>${jobList.job_reg_date}</td>
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






    <!-- 모달창 -->
    <div class="modal fade" id="modal-lg">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modalTitle" ></h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="hiddenJobId" name="job_id">
                    <p>▶ Job 명</p>
                    <p id="modalTitle" contenteditable= "false" ></p><hr>

                    <p>▶ Job 내용</p>
                    <p id="modalDescription" contenteditable= "false"></p><hr>
                    <p>▶ URL</p>
                    <p id="modalUrl" contenteditable= "false"></p><hr>
                    <p>▶ PARAM</p>
                    <p id="modalParam" contenteditable= "false"></p><hr>
                    <p>▶ 상태 ( 숫자로 표현 해주세요 ! )</p>
                    <p style="font-size: 12px">준비(0), 진행(1), 오류(4), 취소(7), 재처리(9) , 완료(10)</p>
                    <p class="modalStatus" contenteditable="false"></p>
                </div>
                <div class="modal-footer justify-content-between">
                    <button type="button" class="btn btn-primary" id="update_job" onclick="javascript:updateJob()">수정</button>
                    <button type="button" class="btn btn-default" id="close_job" data-dismiss="modal" >닫기</button>
                    <button type="button" class="btn btn-default" id="delete_job" data-dismiss="modal"
                            style="background-color: #9c3328; color: #fff0f0" onclick="javascript:deleteJob()" >삭제</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<script type="text/javascript">

    $(document).ready(function() {
        $(".jobButton").on("click",function(){
            var job_id = $(this).data("mid");

            var jManage={ job_id : job_id}; // JSON 데이터

            $.ajax({
                url : "/job/modal",
                type : "POST",
                data : JSON.stringify(jManage),
                dataType: "json",
                contentType: "application/json",
                success : function(response){

                    var modalTitle = response.data.job_title;
                    var modalDescription = response.data.job_description;
                    var modalUrl = response.data.url;
                    var modalParam = response.data.param;
                    var modalStatus = response.data.job_status;
                    var modalJobId = response.data.job_id;

                    $('#modalTitle').html(modalTitle);
                    $('#modalDescription').html(modalDescription);
                    $('#modalUrl').html(modalUrl);
                    $('#modalParam').html(modalParam);
                    $('.modalStatus').html(modalStatus);
                    $('#hiddenJobId').val(modalJobId);

                    //showModalWithData(order);
                },
                error : function(){
                    console.log("로그 : 에러발생...");
                }
            });
        });
    });

    function updateJob(){
        var jobTitle = $('#modalTitle').text();
        var description = $('#modalDescription').text();
        var url = $('#modalDescription').text();
        var param = $('#modalDescription').text();
        var status = $('.modalStatus').text();
        var hiddenJobId = $('#hiddenJobId').val();
        if (!isNaN(hiddenJobId)) {
            hiddenJobId = parseInt(hiddenJobId);
        }

        var editable = $('#modalTitle').attr('contentEditable');

        if(editable == 'true'){
            var update_confirm = confirm('수정 하시겠습니까?');
            if(!update_confirm){
                return;
            }

            $('#modalTitle').attr('contentEditable', false)
            $('#modalDescription').attr('contentEditable', false)
            $('#modalUrl').attr('contentEditable', false)
            $('#modalParam').attr('contentEditable', false)
            $('.modalStatus').attr('contentEditable', false)
            $('#update_job').text('수정');
            $('#close_job').text('닫기');
        }else{
            $('#modalTitle').attr('contentEditable', true)
            $('#modalDescription').attr('contentEditable', true)
            $('#modalUrl').attr('contentEditable', true)
            $('#modalParam').attr('contentEditable', true)
            $('.modalStatus').attr('contentEditable', true)
            $('#update_job').text('저장');
            $('#close_job').text('취소');
            return;
        }

        if(jobTitle.length > 30){
            alert("제목 30자 제한");
            return;
        }

        var method="POST";
        var requestUrl="/job/jobUpdate";
        var params = {
            "jobId": hiddenJobId ,
            "jobTitle" : jobTitle,
            "jobDescription" : description,
            "url" : url,
            "param" : param,
            "jobStatus" : status
        };
        var getType="json";
        var contType="application/json; charset=UTF-8";
        $.ajax({
            url: requestUrl,
            type: method,
            data: JSON.stringify( params),
            dataType: getType,
            contentType : contType,
            cache: false,
            success: function(response) {
                console.log("response : " + response);
                console.log("response.data.job_id : " + response.status == 200);
                if(response.status === 200){
                    alert("변경되었습니다.");
                    location.reload();
                }else{
                    alert("실패");
                }

            },
            fail: function() {
                alert("서버와의 연결에 실패하였습니다\n잠시후 다시 시도해주세요");
            }
        });
    }

    function deleteJob(){
        var hiddenJobId = $('#hiddenJobId').val();
        if (!isNaN(hiddenJobId)) {
            hiddenJobId = parseInt(hiddenJobId);
        }

        var first_confirm = confirm('삭제 하시겠습니까?');
        if(first_confirm){
            var second_confirm = confirm('정말 삭제 하시겠습니까 ? 이전내용은 복구되지 않습니다 !');
            if(second_confirm){
                $.ajax({
                    url: '/job/jobDelete', // 삭제 요청을 처리하는 엔드포인트 URL
                    method: 'POST', // 혹은 'DELETE' 등 HTTP 메서드 지정
                    data: { jobId: hiddenJobId }, // 삭제할 Job ID 등의 데이터
                    success: function(response) {
                        console.log("response : "+ response);
                        if (response.status === 200) {
                            alert('삭제 되었습니다!');
                            // 삭제 후 필요한 추가 동작 수행
                        } else {
                            alert('삭제 실패했습니다!');
                        }
                    },
                    error: function() {
                        alert('서버 요청에 실패했습니다!');
                    }
                });

            }else{
                return;
            }
        }else{
            return;
        }
    }


</script>

<!-- jQuery -->
<script src="/resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- overlayScrollbars -->
<script src="/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>


</body>
</html>
