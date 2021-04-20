// 게시판 핸들러 매핑
$(document).ready(function(){
    $("#delete").on("click", function() {

        mcxDialog.confirm("삭제 하시겠습니까?", {
            sureBtnClick: function() {
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
        })
    });
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
        var sCate = $('#searchCate').val();

        if(sVal != ''){
            location.href="/board?&sVal="+sVal+"&sCate="+sCate;
        } else{
            location.href="/board";
        }
    });
});
