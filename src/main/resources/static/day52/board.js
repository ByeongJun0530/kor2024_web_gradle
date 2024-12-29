/*
const option = {
    method : 'POST', 
    headers : {'Content-Type' : 'application/json'},
    body : JSON.stringify(전송할 객체체)
    }
fetch('자바컨트롤러URL', 옵션)
    .then(response => response.json())
    .then(data => {응답결과코드})
    .catch(error => {console.log(error)})
*/


// (1) 글 쓰기 함수, 함수명 : write(), 사용처 : [등록]버튼 클릭시, 매개변수 : x, 반환값 : x
function _write(){ // JS함수중에 내장된 write함수가 존재하므로 중복이다. write() -> _write()
    // [1] input 마크업에 입력받은 값 가져오기 
        // 1. document.querySelector() 함수 이용하여 (dom)마크업 객체 가져오기 
    let titleInput = document.querySelector('.titleInput');
    let contentInput = document.querySelector('.contentInput')
    let pwdInput = document.querySelector('.pwdInput')
        // 2. 가져온 dom객체의 value 속성을 가져온다. 
    let title = titleInput.value;
    let content = contentInput.value;
    let pwd = pwdInput.value;

    // [2] 입력받은 값들을 객체화
    let board = {title : title, content : content, pwd : pwd};
    
    // [3] fetch함수를 이용한 자바의 컨트롤러에게 입력받은 값 전달하고 응답 받기
    const option = { // fetch함수가 HTTP통신할 때 사용할 부가정보가 담긴 객체 
        method : 'POST', // (1) method : HTTP통신할 때 사용할 메소드 선택(post:저장,get:호출,put:수정,delete:삭제)
        // 글쓰기이므로 4개 중 POST선택
        headers : {'Content-Type' : 'application/json'}, // HTTP 통신의 부가 정보
        // (1) 'Content-Type' 이란, 보내고자 하는 데이터의 타입 설정, 'application/json' : JSON타입
        body : JSON.stringify(board), // HTTP 통신의 본문
        //  JSON.stringify(객체) : JSON객체 타입을 문자열 타입으로 변환 함수 
        // <--- input으로부터 입력받은 값들을 JSON형식의 문자열 타입으로 자바에게게 전송
    }
    fetch('/day52/write', option) // fetch('통신할URL', 옵션)
        .then(response => response.json()) // .then(매개변수 => 매개변수명.json()) : 응답 결과를 json타입으로 변환 
        .then(data => {                    // .then(매개변수/응답값 => {응답결과 코드})
            // [4] 응답 결과에 따른 메시지 출력 
            if(data == true){
                alert('write success');
                findAll();
            }
            else{alert('write fail')}
        })
        .catch(error => {console.log(error)}) // .catch(매개변수명 => {오류결과 코드;})
}//f end

// (2) 글 출력 함수 
function findAll(){
    // fetch 출력
    fetch('/day52/findAll')
        .then(r => r.json())
        .then(data => {console.log(data)})
        .catch(e => {console.log(e)})
}//f end