let todoList = [];
let todoNum = 1;
// [3 C] 등록함수 정의, 
// 사용처 : [등록]버튼 onclick 클릭시, 매개변수 : X, 반환값 : X 
function todoWrite(){
    // 1. HTML로부터 INPUT 마크업 DOM 객체 가져오기 
    const contInput = document.querySelector('.contInput'); console.log(contInput);
    
    // 2. 가져온 DOM객체에 value 속성을 호출한다. 
    const todoContent = contInput.value;                       console.log(todoContent);
    // 3. 할일 객체 구성한다. 
    const todo = {
        todoNum : todoNum,
        todoContent : todoContent,
        todoState : false,
    };                                                     console.log(todo);
    // 4. 구성한 객체를 배열에 저장한다. 
    todoList.push(todo);                                    console.log(todoList);
    // option
    let option = {
        method : "POST",
        headers : {'Content-Type':'application/json'},
        body : JSON.stringify(todo)
    }
    // fetch
    fetch('/todoWrite',option)
        .then(r => r.json())
        .then(d => console.log(d))
        .catch(e => console.log(e))
    
    // 5. 결과 
    alert('[할일 등록 되었습니다.]')
    contInput.value = ``;
    todoNum++;
    todoPrint(); // 등록 성공시 출력함수 호출(출력상태 새로고침)
    return; // 함수 종료 
}

// [4 R] 출력함수 정의, 
// 사용처 : JS가 실행될때 JS에서 최초1번 실행, 등록/수정/삭제 성공했을 때, 매개변수 : X, 반환값 : X 
todoPrint(); // JS에서 출력함수를 호출
function todoPrint(){
    // 1. HTML로부터 DIV 마크업 DOM 객체 가져오기 
    const todoBottom = document.querySelector('.todoBottom');
    // 2. 출력할 HTML문자열 구성하기 
    let HTML = '';
        // (1) 할일 목록(배열)내 모든 요소를 하나씩 HTML 문자열로 만들기
        for(let index = 0; index <= todoList.length-1; index++){
            // -index는 0부터 배열 내 마지막 인덱스까지 1씩 증가 반복 
            const todo = todoList[index]; // -index번째 객체 꺼내기
            
            // - `백틱 이용한 HTML변수에 +=(누적) 대입하기. <div class = "contBox">

            // [삼항연산자]를 이용한 객체 속성값에 따른 마크업의 클래스명 조작하기.
            // - 만약에 할일 상태가 true이면 success라는 클래스를 대입하고 아니면 대입하지 않는다.
            HTML += `<div class="contBox ${todo.todoState ? 'success' : ''}">
                    <div class="cont"> ${todo.todoContent} </div>
                    <div class="contBtns"> 
                        <button onclick="todoUpdate(${todo.todoNum})" class="updateBtn">수정</button>
                        <button onclick="todoDelete(${todo.todoNum})" class="deleteBtn">삭제</button>
                    </div>
                </div>` 
        }
    // 3. 가져온 마크업 객체에 출력할 html문자열 대입하기 
    todoBottom.innerHTML = HTML;
    // fetch
    fetch('/todoPrint')
        .then(r => r.json())
        .then(d => console.log(d))
        .catch(e => console.log(e))  
}

// [5 U] 수정함수 정의, 상태 변경 
// 사용처 : [수정]버튼 onclick 클릭시, 매개변수 : 수정할 할일 코드, 반환값 : X 
function todoUpdate(todoNum){ console.log(`${todoNum}todoUpdate`)

    // (1) 배열 내 수정할 할일코드 객체 찾기.
    for(let index = 0;index <= todoList.length-1; index++){
        if(todoList[index].todoNum == todoNum){
             // index번째 할일 코드와 수정할 할일 코드가 같으면 
             let todoState = todoList[index].todoState; // - index번째의 할일상태 꺼내기
             todoList[index].todoState = !todoState; // index번째의 할일 상태(부정/반대) false -> true, true ->false
             break; // 수정했다면 for문 종료 
        }
    }
    // fetch
    const updatedTodo = todoList.find(todo => todo.todoNum === todoNum)
    fetch(`/todoUpdate`,{
        method : "PUT", headers : {'Content-Type':'application/json'}, body : JSON.stringify(updatedTodo)
    })
        .then(r => r.json())
        .then(d => console.log(d))
        .catch(e => console.log(e))  

    todoPrint(); // 수정처리 후 출력함수 재호출 함으로써 (출력상태 새로고침)
}

// [6 D] 삭제함수 정의,
// 사용처 : [삭제]버튼 onclick 클릭시, 매개변수 : 삭제할 할일 코드, 반환값 : X 
function todoDelete(todoNum){ console.log(`${todoNum}todoDelete`)
    // (1) 배열 내 삭제할 할일 코드 객체 찾기.
    for(let index = 0; index <= todoList.length-1; index++){
        if(todoList[index].todoNum == todoNum){
            // index번째 할일 코드와 삭제할 할일 코드가 같으면 
            todoList.splice(index, 1);
            break; // 삭제시 for문 종료 
        }
    }

    // fetch
    fetch(`/todoDelete?todoNum=${todoNum}`,{method : 'Delete'})
        .then(r => r.json())
        .then(d => console.log(d))
        .catch(e => console.log(e))  

    todoPrint(); // 삭제처리 후 출력함수 재호출 함으로써 (출력상태 새로고침)
}