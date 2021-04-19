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

        if (calcVal == 1) {
            $result.text((input / 0.3025).toFixed(2));
        } else {
            $result.text((input * 0.3025).toFixed(2));
        }
    });

    function changePage(url) {
        location.href = url;
    }

    function changeCalcAreaLabel(val) {
        if (val == 1) {
            $("#input-calc-label").text("평");
            $("#result-calc-label").text("㎡");
        } else {
            $("#input-calc-label").text("㎡");
            $("#result-calc-label").text("평");
        }
    }


});

function spinStart() {
    $("#global-loader").show();
}

function spinStop() {
    $("#global-loader").hide();
}