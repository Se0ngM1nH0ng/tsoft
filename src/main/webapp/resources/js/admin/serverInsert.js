// 서버 등록 js
function insertServer(){
    let serverName = $('#insertServerName').val();
    let serverIp = $('#insertServerIp').val();
    let serverDesc = $('#insertServerDesc').val();
    let serverGroup = $('#insertServerGroup').val();


    if(serverName == "")	{
        alert('서버명을 입력해 주세요.')
        $('#insertServerTitle').focus();
        return;
    }
    else if(serverIp == "")	{
        alert('ip를 입력해 주세요.')
        $('#insertServerIp').focus();
        return;
    }
    else if(serverDesc == ""){
        alert('내용를 입력해 주세요.')
        $('#insertServerDesc').focus();
        return;
    }
    else if(serverGroup == ""){
        alert('그룹을 입력해 주세요.')
        $('#insertServerGroup').focus();
        return;
    }


    var insert_confirm = confirm('등록 하시겠습니까?');
    if(!insert_confirm){
        return;
    }

    var method="POST";

    var requestUrl="/server/serverInsert";

    var params = {
        "serverName" : serverName,
        "serverIp" : serverIp,
        "serverDesc": serverDesc,
        "serverGroup": serverGroup
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
            if (response.status === 201) {
                alert("성공적으로 등록되었습니다");
                location.reload();
            } else {
                alert("실패");
            }
        },
        fail: function() {
            alert("서버와의 연결에 실패하였습니다\n잠시후 다시 시도해주세요");
        }
    });

}
