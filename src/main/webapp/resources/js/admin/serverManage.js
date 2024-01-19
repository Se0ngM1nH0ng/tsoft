// 서버 조회 수정 삭제

function serverModal(){
    $(".serverButton").on("click",function(){
        let serverId = $(this).data("mid");
        let sManage={ serverId : serverId}; // JSON 데이터

        $.ajax({
            url : "/server/serverModal",
            type : "POST",
            data : JSON.stringify(sManage),
            dataType: "json",
            contentType: "application/json",
            success : function(response){

                const dataMapping = { // DOM 사용
                    'serverName': '#modalName',
                    'serverDesc': '#modalDesc',
                    'serverIp': '#modalIp',
                    'serverGroup': '#modalGroup'
                };

                for(let key in response.data){
                    if (response.data.hasOwnProperty(key) && dataMapping.hasOwnProperty(key)){
                        let value = response.data[key];
                        $(dataMapping[key]).text(value);
                    }
                }
                $('.hiddenServerId').val(response.data.serverId); // class 로 지정, id 는 고유의 것이라 여기서 밖에 사용 안됨
            },
            error : function(){
                console.log("로그 : 에러발생...");
            }
        });
    });
}

function updateServer(){
    let serverName = $('#modalName').text();
    let serverDesc = $('#modalDesc').text();
    let serverIp = $('#modalIp').text();
    let serverGroup = $('#modalGroup').text();
    let serverId = $('.hiddenServerId').val();
    if (!isNaN(serverId)) {
        serverId = parseInt(serverId);
    }

    var editable = $('#modalName').attr('contentEditable');

    if('true' == editable){ // null 값 이슈
        var update_confirm = confirm('수정 하시겠습니까?');
        if(!update_confirm){
            return;
        }

        $('.modalServer').attr('contentEditable', false)
        $('#update_server').text('수정');
        $('#close_server').text('닫기');
    }else{
        $('.modalServer').attr('contentEditable', true)
        $('#update_server').text('저장');
        $('#close_server').text('취소');
        return;
    }

    if(serverName.length > 30){
        alert("서버명 30자 제한");
        return;
    }

    var method="POST";
    var requestUrl="/server/serverUpdate";
    var params = {
        "serverName": serverName ,
        "serverDesc" : serverDesc,
        "serverIp" : serverIp,
        "serverGroup" : serverGroup
    };
    var getType="json";
    var contType="application/json; charset=UTF-8";
    $.ajax({
        url: requestUrl,
        type: method,
        data: JSON.stringify(params),
        dataType: getType,
        contentType : contType,
        cache: false,
        success: function(response) {
            console.log("response : " + response);
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

function deleteServer(){
    let serverId = $('.hiddenServerId').val();
    if (!isNaN(serverId)) {
        serverId = parseInt(serverId);
    }
    let first_confirm = confirm('삭제 하시겠습니까?');
    if(first_confirm){
        let second_confirm = confirm('정말 삭제 하시겠습니까 ? 이전내용은 복구되지 않습니다 !');
        if(second_confirm){
            $.ajax({
                url: '/server/serverDelete', // 삭제 요청을 처리하는 엔드포인트 URL
                method: 'POST', // 혹은 'DELETE' 등 HTTP 메서드 지정
                data: { serverId: serverId }, // 삭제할 Job ID 등의 데이터
                success: function(response) {
                    console.log("response : "+ response);
                    if (response.status === 200) {
                        alert('삭제 되었습니다!');

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

$(document).ready(function() {
        serverModal();
});