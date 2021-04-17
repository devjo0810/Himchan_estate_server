# Himchan_estate_server

## mcxDialog 사용법
```
mcxDialog.alert("출력 내용", option); // -> alert 창
alert option = {
  titleText:    String,
  sureBtnText:  String,
  sureBtnClick: Function
}

mcxDialog.confirm("출력 내용", option); // -> confirm 창
confirm option = {
  titleText :    String,
  cancelBtnText: String,
  sureBtnText:   String,
  cancelBtnClick:Function,
  sureBtnClick:  Function
}

option은 추가옵션으로 안줘도 되고 option객체 안의 key값을 다 설정 안해도됨
```

## Spinner 사용법
```
spinStart() -> 글로벌 스피너 실행
spinStop()  -> 글로벌 스피너 중지

위의 함수가 전역으로 등록되있어서 어디서든 사용 가능
```

## development url : http://localhost:8085

## Live Demo url : http://hiimchan:8085
