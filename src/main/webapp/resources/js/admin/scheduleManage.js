// job 조회 수정 삭제

function modal(){
    $(".jobButton").on("click",function(){
        let jobId = $(this).data("mid");
        let jManage={ jobId : jobId}; // JSON 데이터
        alert('확인');
        $.ajax({
            url : "/job/jobModal",
            type : "POST",
            data : JSON.stringify(jManage),
            dataType: "json",
            contentType: "application/json",
            success : function(response){

                const dataMapping = { // DOM 사용
                    'jobTitle': '#modalTitle',
                    'jobDescription': '#modalDescription',
                    'url': '#modalUrl',
                    'param': '#modalParam',
                    'jobStatus': '.modalStatus',
                    'jobStartDate': '#modalStartDate',
                };

                for(let key in response.data){
                    if (response.data.hasOwnProperty(key) && dataMapping.hasOwnProperty(key)){
                        let value = response.data[key];
                        $(dataMapping[key]).text(value);
                    }
                }
                $('.hiddenJobId').val(response.data.jobId); // class 로 지정, id 는 고유의 것이라 여기서 밖에 사용 안됨
            },
            error : function(request, status, error){
                // console.log("로그 : 에러발생...");
                console.log("code:"+request.status+"\n >>"+"message:"+request.responseText+"\n >>"+"error:"+error);
            }
        });
    });
}

function updateJob(){
    let jobTitle = $('#modalTitle').text();
    let jobDescription = $('#modalDescription').text();
    let url = $('#modalDescription').text();
    let param = $('#modalDescription').text();
    let jobStartDate = $('#modalStartDate').text();
    let jobId = $('.hiddenJobId').val();
    if (!isNaN(jobId)) {
        jobId = parseInt(jobId);
    }

    var editable = $('#modalTitle').attr('contentEditable');

    if('true' == editable){ // null 값 이슈
        var update_confirm = confirm('수정 하시겠습니까?');
        if(!update_confirm){
            return;
        }
        $('.modalJob').attr('contentEditable', false)
        $('#update_job').text('수정');
        $('#close_job').text('닫기');
    }else{
        $('.modalJob').attr('contentEditable', true)
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
        "jobId": jobId ,
        "jobTitle" : jobTitle,
        "jobDescription" : jobDescription,
        "url" : url,
        "param" : param,
        "jobStartDate": jobStartDate

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
    var jobId = $('.hiddenJobId').val();
    if (!isNaN(jobId)) {
        jobId = parseInt(jobId);
    }
    var first_confirm = confirm('삭제 하시겠습니까?');
    if(first_confirm){
        var second_confirm = confirm('정말 삭제 하시겠습니까 ? 이전내용은 복구되지 않습니다 !');
        if(second_confirm){
            $.ajax({
                url: '/job/jobDelete', // 삭제 요청을 처리하는 엔드포인트 URL
                method: 'POST', // 혹은 'DELETE' 등 HTTP 메서드 지정
                data: { jobId: jobId }, // 삭제할 Job ID 등의 데이터
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
    modal(); // modal 함수 호출하여 이벤트 연결
});