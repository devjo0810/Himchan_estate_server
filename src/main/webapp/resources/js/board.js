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

    var boardTr = $('#board-table').find('tr')
    $(boardTr).on("click",function(){

        var boardSq = $(this).find("#boardSq").val();
        var page = $(this).find("#page").val();

        location.href="/board/view?boardSq=" + boardSq + "&page=" + page;
    })

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
