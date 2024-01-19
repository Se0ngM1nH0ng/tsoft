<%@ tag language="java" pageEncoding="UTF-8" %>

<div class="modal fade" id="modal-lg">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modalTitle"></h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div>
                <div><input type="hidden" class="hiddenJobId" name="job_id"></div>
                <div>▶ Job 명</div>
                <div class="modalJob"><p id="modalTitle"></p></div><hr>
                <div>▶ Job 내용</div>
                <div class="modalJob"><p id="modalDescription"></p></div><hr>
                <div>▶ Job 시행일자 변경</div>
                <div class="modalJob"><p id="modalStartDate"></p></div><hr>
                <div>▶ URL</div>
                <div class="modalJob"><p id="modalUrl"></p></div><hr>
                <div>▶ PARAM</div>
                <div class="modalJob"><p id="modalParam"></p></div><hr>
            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-primary" id="update_job" onclick="javascript:updateJob()">수정
                </button>
                <button type="button" class="btn btn-default" id="close_job" data-dismiss="modal">닫기</button>
                <button type="button" class="btn btn-default" id="delete_job" data-dismiss="modal"
                        style="background-color: #9c3328; color: #fff0f0" onclick="javascript:deleteJob()">삭제
                </button>
            </div>
        </div>
    </div>
</div>