console.log('member.js open')

// 1. signup 메소드 
function signup(){ console.log("signup() open");
    // (1) HTML의 input의 DOM 객체 가져오기 
    const midInput = document.querySelector('.midInput')
    const mpwdInput = document.querySelector('.mpwdInput')
    const mnameInput = document.querySelector('.mnameInput')
    const mphoneInput = document.querySelector('.mphoneInput')
    // (2) DOM 의 VALUE 입력값 반환 
    const mid = midInput.value;
    const mpwd = mpwdInput.value;
    const mname = mnameInput.value;
    const mphone = mphoneInput.value;
    // (3) 여러개 데이터를 하나의 타입으로 묶어주기 객체화
    const info = {mid : mid,mpwd : mpwd,mname : mname,mphone : mphone}
    // (4) fetch
    const option = {
        method : 'POST',
        headers : {'Content-Type':'application/json'},
        body : JSON.stringify(info)
    }
    fetch('/signup.do', option)
        .then(r => r.json())
        .then(data => { console.log(data);
            // (5) 결과에 따른 화면 구성 .
            if(data == true){
                alert('회원가입 성공 했습니다.')
                // 회원가입 성공시 로그인 페이지로 이동 
                location.href="/login"  // location.href="URL" : JS에서 페이지 전환 함수 
            }else{
                alert('회원가입 실패 했습니다.')
            }
        })
        .catch(e => console.log(e))
} // f end 
// 2. login 메소드 
function login(){
    //1.
    const midInput = document.querySelector('.midInput')
    const mpwdInput = document.querySelector('.mpwdInput')
    //2.
    const mid = midInput.value;
    const mpwd = mpwdInput.value;
    //3. UPL 뒤로 ? 부터는 쿼리스트링 방식, 매개변수1=값1&매개변수2=값2
    fetch(`/login?mid=${mid}&mpwd=${mpwd}`)
        .then(r => r.json())
        .then(data => {
            if(data == true){
                alert('로그인 성공')
                // 로그인 성공시 메인페이지로 이동
                location.href="/"
            }else{
                alert('로그인 실패')
            }
        })
        .catch(e => {console.log(e)})

}