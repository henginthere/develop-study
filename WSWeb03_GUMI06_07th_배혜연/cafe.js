function func_prompt() {
    var id = prompt("아이디입력");
    if (id == "ssafy") {
        var pw = prompt("비밀번호입력");
    }
    if (pw == "1234") {
        alert("로그인 성공!!!");
        var login = true;
    }
    if (login == true) {
        location.href = "http://127.0.0.1:5500/loginpage.html";
    }
}

function make_poll() {
    window.open("./makepoll.html", "mp", "width=500, height=500, top=200, left=300");
}

window.onload = function () {
    document.getElementById("btn-add").addEventListener("click", function () {
      var listDiv = document.getElementById("poll-answer-list");
  
      var divEl = document.createElement("div"); // <div></div>
      divEl.setAttribute("class", "poll-answer-item");// <div class="poll-answer-item"></div>
      var inputEl = document.createElement("input");
      inputEl.setAttribute("type", "text");
      inputEl.setAttribute("name", "answer");
      var btnEl = document.createElement("button");
      btnEl.setAttribute("type", "button");
      btnEl.setAttribute("class", "button");
      btnEl.appendChild(document.createTextNode("삭제"));
  
      btnEl.addEventListener('click', function () {
        var parent = this.parentNode;
        listDiv.removeChild(parent);
      });
  
      divEl.appendChild(inputEl);
      divEl.appendChild(btnEl);
  
      listDiv.appendChild(divEl);
    });
  
    document.getElementById("btn-make").addEventListener("click", function () {
      var question = document.querySelector("#question").value;
      if (!question) {
        alert("투표 내용 입력!!!");
        return;
      }
  
      var answers = document.getElementsByName("answer");
      for (var i = 0; i < answers.length; i++) { // 유효성 검사(Validation Check)
        if (!answers[i].value) {
          alert("답변 항목 입력!!!!");
          return;
        }
      }
  
      var answerArr = [];
      for (var i = 0; i < answers.length; i++) {
        answerArr.push(answers[i].value);
      }
      // console.log(answerArr);

  
      localStorage.setItem("question", question);
      localStorage.setItem("answers", JSON.stringify(answerArr));

  
      alert("투표를 생성합니다!!");
      self.close();
      opener.location.reload();
    });
};

function openCloseToc() {
    if (document.getElementById("toc-content-1").style.display === 'block' && document.getElementById("toc-content-2").style.display === 'block'
        && document.getElementById("toc-content-3").style.display === 'block' && document.getElementById("toc-content-4").style.display === 'block') {
        document.getElementById("toc-content-1").style.display = 'none';
        document.getElementById("toc-content-2").style.display = 'none';
        document.getElementById("toc-content-3").style.display = 'none';
        document.getElementById("toc-content-4").style.display = 'none';
        document.getElementById('store-list-show').textContent = '전국매장펼치기';
    } else {
        document.getElementById("toc-content-1").style.display = 'block';
        document.getElementById("toc-content-2").style.display = 'block';
        document.getElementById("toc-content-3").style.display = 'block';
        document.getElementById("toc-content-4").style.display = 'block';
        document.getElementById('store-list-show').textContent = '전국매장접기';
    }
}; 
function openCloseToc_Seoul() {
    if (document.getElementById("toc-content-1").style.display === 'block') {
        document.getElementById("toc-content-1").style.display = 'none';
    }
    else {
        document.getElementById("toc-content-1").style.display = 'block';
    }
}

function openCloseToc_Daejeon() {
    if (document.getElementById("toc-content-2").style.display === 'block') {
        document.getElementById("toc-content-2").style.display = 'none';
    }
    else {
        document.getElementById("toc-content-2").style.display = 'block';
    }
}
function openCloseToc_Gumi() {
    if (document.getElementById("toc-content-3").style.display === 'block') {
        document.getElementById("toc-content-3").style.display = 'none';
    }
    else {
        document.getElementById("toc-content-3").style.display = 'block';
    }
}
function openCloseToc_Gwangju() {
    if (document.getElementById("toc-content-4").style.display === 'block') {
        document.getElementById("toc-content-4").style.display = 'none';
    }
    else {
        document.getElementById("toc-content-4").style.display = 'block';
    }
}