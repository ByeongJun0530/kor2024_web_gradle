let scoreList = [];
let stuNum = 1;
// 점수 등록 함수 
function scoreWrite(){
    // HTML로부터 INPUT  마크업 DOM 객체 가져오기 
    const nameInput = document.querySelector('.nameInput');
    const korInput = document.querySelector('.korInput');
    const mathInput = document.querySelector('.mathInput');
    const engInput = document.querySelector('.engInput'); 
    // 가져온 dom 객체 value 속성 호출 
    const stuName = nameInput.value;
    const korScore = korInput.value;
    const mathScore = mathInput.value;
    const engScore = engInput.value;   

    console.log(stuName, korScore, mathScore, engScore);  // 값이 제대로 들어가는지 확인
    // 객체 구성
    const stuScore = {
        stuNum : stuNum,
        stuName : stuName,
        korScore : korScore,
        mathScore : mathScore,
        engScore : engScore
    };              
    // 구성 객체 배열 내 저장 
    scoreList.push(stuScore);
    console.log(scoreList);
    // 옵션
    let option = {
        method : "POST",
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(stuScore)
    }
    // fetch
    fetch('/scoreWrite', option)
        .then(r => r.json())
        .then(d => console.log(d))
        .catch(e => console.log(e))
    // 결과 
    alert('[점수가 등록되었습니다.]')
    nameInput.value = ``;
    korInput.value = ``;
    mathInput.value = ``;
    engInput.value = ``;
    stuNum++;
    // scorePrint();
}


