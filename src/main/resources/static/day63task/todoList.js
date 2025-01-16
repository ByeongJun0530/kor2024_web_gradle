let todoList = [];
// 등록
function todoWrite(){
    const contInput = document.querySelector('.contInput');
    const todoContent = contInput.value;
    const todo = { console.log(todo);
        todoContent : todoContent,
        todoState : false
    }
    let option = {
        method : "POST",
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(todo)
    }   
    fetch('/todoWrite', option)
        .then(r => r.json())
        .then(d => {
            todo.tno = d.tno;
            todoList.push(todo);
            todoPrint()
        })
        .catch(e => console.log(e))
}

//출력
function todoPrint(){
    const todoBottom = document.querySelector('.todoBottom')
    let HTML = '';
    fetch('/todoPrint')
        .then(r => r.json())
        .then(d => {
            todoList = d;
            for(let index = 0; index <= todoList.length-1; index++){
                const todo = todoList[index];
                HTML += `<div class="contBox ${todo.todoState ? 'success' : ''}">
                        <div class="cont> ${todo.todoContent} </div>
                        <div class="contBtn">
                            <button onclick="todoUpdate(${todo.tno})" class="updateBtn>수정</button>
                            <button onclick="todoDelete(${todo.tno})" class="deleteBtn>삭제</button>
                        </div>
                    </div>`
            }
            todoBottom.innerHTML = HTML;
        })
        .catch(e => console.log(e))  
}

//수정
function todoUpdate(tno){
    for(let index = 0; index <= todoList.length-1; index++){
        if(todoList[index].tno == tno){
            let todoState = todoList[index].todoState
            todoList[index].todoState = !todoState;
            break;
        }
    }
    const updatedTodo = todoList.find(todo => todo.tno === tno)
    fetch('/todoUpdate',{
        method : "PUT", header : {'Content-Type' : 'application/json', body : JSON.stringify(updatedTodo)}
    })
        .then(r => r.json())
        .then(d => console.log(d))
        .catch(e => console.log(e))  
    todoPrint();
}

//삭제 
function todoDelete(tno){
    for(let index = 0; index <= todoList.length-1; index++){
        if(todoList[index].tno == tno){
            todoList.splice(index, 1);
            break;
        }
    }
    fetch(`/todoDelete?tno=${tno}`, {method : 'DELETE'})
        .then(r => r.json())
        .then(d => console.log(d))
        .catch(e => console.log(e))  
    todoPrint();
}