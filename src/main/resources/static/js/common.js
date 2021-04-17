// 공통 핸들러 매핑
$(document).ready(function() {
    $("#main-navi-home").on("click", function() {
        changePage("/");
    });
    $("#main-navi-board").on("click", function() {
        changePage("/board");
    });
    $("#main-navi-come").on("click", function() {
        changePage("/come");
    });
    $("input[name=select-area]").on("click", function(e) {
        var val = e.target.value;
        changeCalcAreaLabel(val);
    });
    $("#area-calc").on("click", function() {
        var calcVal = $("input[name=select-area]:checked").val();
        var input = $("#input-calc").val();
        var $result = $("#result-calc");

        if(calcVal == 1) {
            $result.text( (input / 0.3025).toFixed(2) );
        }
        else {
            $result.text( (input * 0.3025).toFixed(2) );
        }
    });

    function changePage(url) {
        location.href = url;
    }

    function changeCalcAreaLabel(val) {
        if(val == 1) {
            $("#input-calc-label").text("평");
            $("#result-calc-label").text("㎡");
        }
        else {
            $("#input-calc-label").text("㎡");
            $("#result-calc-label").text("평");
        }
    }

    $("#enroll").on('click', function(){
        var $frm = $(".write-area :input");
        var param = $frm.serialize();

        $.ajax({
            url : "/board/write",
            dataType: "json",
            type: "POST",
            data : param,
            success: function(data, textStatus, jqXHR)
            {

                alert("메세지:"+data.check);

                location.href = "/board";
            },
            error: function (jqXHR, textStatus, errorThrown)
            {
                alert("작성 실패");
            }
        });
    });

    $("#delete").on("click", function(){

        var sq = $("#delBtn").val();

        $.ajax({
            url : "/board/delete",
            dataType: "json",
            type: "POST",
            data : {
                sq : sq
            },
            success : function(data){
                alert("메세지 : " + data.check);

                location.href = "/board";
            },
            error: function(){
                alert("삭제 실패");
            }
        });
    });
});