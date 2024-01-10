// job 등록 js
function insertJob(){
    let jobTitle = $('#insertJobTitle').val();
    let jobDescription = $('#insertJobDescription').val();
    let jobStartDate = $('#insertJobStartDate').val();
    let serverGroup = $('#serverGroup').val();
    let url = $('#insertUrl').val();
    let param = $('#insertParam').val();


    if(jobTitle == "")	{
        alert('제목을 입력해 주세요.')
        $('#insertJobTitle').focus();
        return;
    }
    else if(jobDescription == "")	{
        alert('내용을 입력해 주세요.')
        $('#insertJobBody').focus();
        return;
    }
    else if(jobStartDate == ""){
        alert('날짜를 입력해 주세요.')
        $('#insertJobStartDate').focus();
        return;
    }
    else if(serverGroup == ""){
        alert('날짜를 입력해 주세요.')
        $('#insertServerGroup').focus();
        return;
    }
    else if(url == ""){
        alert('URL를 입력해 주세요.')
        $('#insertUrl').focus();
        return;
    }
    else if(param == ""){
        alert('수행내용을 입력해 주세요.')
        $('#insertParam').focus();
        return;
    }

    var insert_confirm = confirm('등록 하시겠습니까?');
    if(!insert_confirm){
        return;
    }

    var method="POST";

    var requestUrl="/job/insertJobManage";

    var params = {
        "jobTitle" : jobTitle,
        "jobDescription" : jobDescription,
        "jobStartDate": jobStartDate,
        "serverGroup": serverGroup,
        "url": url,
        "param": param

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
