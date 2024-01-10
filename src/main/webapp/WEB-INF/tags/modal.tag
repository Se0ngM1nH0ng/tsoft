<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                <div><input type="hidden" class="hiddenJobId" name="job_id"></div>
                <div>▶ Job 명</div>
                <p id="modalTitle" contenteditable= "false" ></p><hr>
                <div>▶ Job 내용</div>
                <p id="modalDescription" contenteditable= "false"></p><hr>
                <div>▶ Job 시행일자 변경</div>
                <p id="modalStartDate" contenteditable= "false"></p><hr>
                <div>▶ URL</div>
                <p id="modalUrl" contenteditable= "false"></p><hr>
                <div>▶ PARAM</div>
                <p id="modalParam" contenteditable= "false"></p><hr>
            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-primary" id="update_job" onclick="javascript:updateJob()">수정</button>
                <button type="button" class="btn btn-default" id="close_job" data-dismiss="modal" >닫기</button>
                <button type="button" class="btn btn-default" id="delete_job" data-dismiss="modal"
                        style="background-color: #9c3328; color: #fff0f0" onclick="javascript:deleteJob()" >삭제</button>
            </div>
        </div>
    </div>
</div>