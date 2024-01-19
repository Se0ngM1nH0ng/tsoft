<%@ tag language="java" pageEncoding="UTF-8"%>

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
                <div><input type="hidden" class="hiddenServerId" name="serverId"></div>
                <div>▶ 서버명</div>
                <div class="modalServer"><p id="modalName" contenteditable= "false" ></p></div><hr>
                <div>▶ 서버내용</div>
                <div class="modalServer"><p id="modalDesc" contenteditable= "false"></p></div><hr>
                <div>▶ 서버ip</div>
                <div class="modalServer"><p id="modalIp" contenteditable= "false"></p></div><hr>
                <div>▶ 서버그룹</div>
                <div class="modalServer"><p id="modalGroup" contenteditable= "false"></p></div><hr>
            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-primary" id="update_server" onclick="javascript:updateServer()">수정</button>
                <button type="button" class="btn btn-default" id="close_server" data-dismiss="modal" >닫기</button>
                <button type="button" class="btn btn-default" id="delete_server" data-dismiss="modal"
                        style="background-color: #9c3328; color: #fff0f0" onclick="javascript:deleteServer()">삭제</button>
            </div>
        </div>
    </div>
</div>