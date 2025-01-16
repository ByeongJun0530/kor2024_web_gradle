// 점수 출력 함수 
scorePrint();
function scorePrint(){
    const stuList = document.querySelector('.stuList')

    let HTML = '';
        for(let index = 0; index <= scoreList.length - 1; index++){
            const score = scoreList[index];

            HTML += `<tr>
        <td> ${score.stuNum} </td>  <td> ${score.stuName} </td>
        <td> ${score.korScore} </td> <td>${score.mathScore}</td> <td> ${score.engScore}</td>
      </tr>`

        }
    stuList.innerHTML = HTML;

    fetch('/scorePrint')
        .then(r => r.json())
        .then(d => console.log(d))
        .catch(e => console.log(e))  
}