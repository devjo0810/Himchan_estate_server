// 게시판 핸들러 매핑
$(document).ready(function(){

    $("#enroll").on('click', function() {
        var title = $('#boardTitle').val();
        var content = $('#boardContent').val();

        if(title == '' || content == ''){
            mcxDialog.alert("제목과 글을 모두 작성해 주세요.");
        } else{
            if(mcxDialog.confirm("작성을 완료 하시겠습니까?")){
                var $frm = $(".write-area :input");
                var param = $frm.serialize();

                $.ajax({
                    url: "/board/write",
                    dataType: "json",
                    type: "POST",
                    data: param,
                    success: function(data, textStatus, jqXHR) {

                        mcxDialog.alert("작성 성공");

                        location.href = "/board";
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        mcxDialog.alert("작성 실패");
                    }
                });
            }
        }
    });

    $("#delete").on("click", function() {

        if(mcxDialog.confirm("삭제 하시겠습니까?")){

            var sq = $("#delBtn").val();

            $.ajax({
                url: "/board/delete",
                dataType: "json",
                type: "POST",
                data: {
                    sq: sq
                },
                success: function(data) {
                    mcxDialog.alert("삭제 성공");

                    location.href = "/board";
                },
                error: function() {
                    mcxDialog.alert("삭제 실패");
                }
            });
        }
    });

});

$(function(){
    $('.able').mouseenter(function(){
        $(this).css({'font-weight':'bold', 'font-size': '16px'});
    }).mouseout(function(){
        $(this).css({'font-weight':'normal', 'font-size': '14px'})
    });

    $('.boardView').mouseenter(function(){
        $(this).css({'font-weight':'bold'});
    }).mouseout(function(){
        $(this).css({'font-weight':'normal'})
    });

    $('#searchBtn').on("click", function(){
        var sVal = $('#searchValue').val();

        if(sVal != ''){
            location.href="/board?&sVal="+sVal;
        } else{
            location.href="/board";
        }
    });
});
