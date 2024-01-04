<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>jQuery test </title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"  crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdf.js/2.10.377/pdf.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdf.js/2.10.377/pdf.worker.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
    <script>
<%-- 우클릭 방지 스크립트 처리--%>
        document.addEventListener('contextmenu', function(event) {
            event.preventDefault();
        });
<%-- 인쇄 방지 단축키 스크립트 처리 --%>
        document.addEventListener('keydown', function(event) {
            // Ctrl + P를 누를 때 동작 막기
            if (event.ctrlKey && event.key === 'p') {
                alert("인쇄 Ctrl + p 동작이 불가합니다.");
                event.preventDefault();
            }
        });
    </script>
</head>

<body>


<div class="container-fluid">

    <div class="row">
        <div class="col-md-12">

            <div class="row navbar fixed-top navbar-light bg-info ">
                <div onclick="viewPrint()">인쇄</div>
                <div class="col-md-4">
                </div>
                <div class="col-md-4">

                    <div style="width: 200px;">
                        <span> <input type="text" id="currentPageNum" name="currentPageNum" style="float: left; text-align: right; width: 80px"></span>
                        <span style="float: left; width: 30px; text-align: center;  color: white"> / </span>
                        <span id="max_pdf_page" style="float: left; width: 70px; color: white"></span>
                    </div>
                </div>
                <div class="col-md-4">
                </div>

                <br><br><hr>
            </div>

            <div class="row" style="margin-top: 100px;">
                <div class="col-md-12">
                    <div id="pdfBox" style="overflow-y:scroll; text-align: center; height:100%; padding-bottom: 730px;"> </div>
                </div>
            </div>

        </div>
    </div>

</div>

</body>
</html>

<script>
    function viewPrint(canvas){
        window.print({});
        alert("viewPrint");
    }

    // 사용자
    let MAX_PDF_PAGE    = 0;
    var scrollTop       = 0;




    // Loaded via <script> tag, create shortcut to access PDF.js exports.
    var pdfjsLib = window['pdfjs-dist/build/pdf'];

    // The workerSrc property shall be specified.
    pdfjsLib.GlobalWorkerOptions.workerSrc = 'https://mozilla.github.io/pdf.js/build/pdf.worker.js';

    var pdfDoc = null,
        pageNum = 0,
        pageRendering = false,
        pageNumPending = null,
        scale = 1;

    /**
     * Get page info from document, resize canvas accordingly, and render page.
     * @param num Page number.
     */
    function renderPage(num) {
        pageRendering = true;

        // Using promise to fetch the page
        pdfDoc.getPage(num).then(function(page)
        {
            pageNum++;

            var canvasBox   = document.getElementById('pdfBox');
            var viewport    = page.getViewport({scale: scale});
            var pageWidth   = viewport.width;
            var pageHeight  = viewport.height;

            var canvas    = document.createElement('canvas');
            canvas.setAttribute("id", "page_" + pageNum );
            canvas.setAttribute("style", 'width: ' + pageWidth + 'px; height: ' + pageHeight + 'px; border: dotted 1px green');
            canvas.width  = pageWidth;
            canvas.height = pageHeight;
            canvasBox.appendChild(canvas);

            // Render PDF page into canvas context
            var ctx = canvas.getContext('2d');
            var renderContext = {
                canvasContext: ctx,
                viewport: viewport
            };

            var renderTask = page.render(renderContext);

            // Wait for rendering to finish
            renderTask.promise.then(function( event )
            {
                pageRendering = false;
                if (pageNumPending !== null) {
                    // New page rendering is pending
                    renderPage(pageNumPending);
                    pageNumPending = null;
                }
                let nowPageNum  = page._pageIndex + 1;

                // create canvas image
                // https://stackoverflow.com/questions/45446734/convert-a-pdf-to-thumbnail-using-pdf-js
                var imgUrl      = canvas.toDataURL();
                var imgThumb    = document.getElementById('thumb_img_' + nowPageNum );
                imgThumb.setAttribute('src', imgUrl); // base64
                imgThumb.setAttribute('border', '1');
                imgThumb.setAttribute('width', 150);
            });

        });

    }


    /**
     * Asynchronously downloads PDF.
     */
    function pdf_url( url )
    {
        pdfjsLib.getDocument(url).promise.then(function(pdfDoc_) {
            pdfDoc = pdfDoc_;

            // 전체 페이지 갯수를 상단에 넣어 준다
            MAX_PDF_PAGE    = pdfDoc.numPages;
            $('#max_pdf_page').text(MAX_PDF_PAGE);

            // 섬네일 보여줄 자리를 미리 만들어 주는것
            let thumbList     = '';
            let pageNum       = 0;
            for ( pageNum = 1; pageNum <= MAX_PDF_PAGE; pageNum++ ) {
                var alt = pageNum + ' page';
                thumbList += '<a id="thumb_href_' + pageNum + '" onclick="pdf_page_move( ' + pageNum + ' )"><img id="thumb_img_' + pageNum + '" alt="' + alt + '"></a><br><div style="text-align: left;"> - ' + pageNum + ' - </div><p></p>';
            }
            $( "#thumb_list" ).append(thumbList);


            // show pages
            pageNum           = 0;
            for ( pageNum = 1; pageNum <= MAX_PDF_PAGE; pageNum++ ) {
                renderPage(pageNum);
            }
        });
    }

    var url = 'https://raw.githubusercontent.com/mozilla/pdf.js/ba2edeae/web/compressed.tracemonkey-pldi-09.pdf';
    pdf_url( url );



    // ============================== user function ==============================




    $(document).ready(function() {

        // page move
        $('#currentPageNum').keyup(function(event) {
            if (event.key == "Enter") {
                var pageNum     = $("#currentPageNum").val();
                pdf_page_move( pageNum );
            }
        });


        // current page show
        $(document).scroll(function()
        {
            scrollTop    = $(this).scrollTop();
            // console.log(scrollTop);

            let pageScrollTop = 0;
            let pageHeight    = 0;
            for ( var pageNum = 1; pageNum <= MAX_PDF_PAGE; pageNum++ ) {
                pageScrollTop = $("#page_"+pageNum).offset().top;
                pageHeight    = $('#page_'+pageNum).outerHeight();
                if ( scrollTop >= pageScrollTop && scrollTop <= pageScrollTop + pageHeight ) {
                    // console.log(pageNum);
                    $("#currentPageNum").val(pageNum);
                    break;
                }
            }
        });


        $("#currentPageNum").val(1);

    });


    /**
     * pdf page move
     */
    function pdf_page_move( pageNum ) {
        $("#currentPageNum").val(pageNum);
        $('html, body').animate({ scrollTop: $("#page_"+pageNum).offset().top }, 50);
    }


</script>