window.onload = function () {  // HTML 문서 로딩이 완료가 되면 아래 내용을 실행

    var question = localStorage.getItem("question");  // localStorage : 브라우저 저장소에 저장하는 용도 (브라우저 종료 후에도 유지)
    var pollBtnDiv = document.querySelector(".content-left-poll-btn");  // document: HTML 문서 자체
    var pollDiv = document.querySelector(".content-left-poll");
    
    if (question) {  // 질문이 있다면 >> 투표 내용 출력
        var answers = localStorage.getItem("answers");
        var answerArr = JSON.parse(answers);  // answers.split(",")
        var poll = `
            <div class="vote">
                <div class="vote-question">${question}</div>
                <div class="vote-answer">
                    <ul>
        `;
        for (var i = 0; i < answerArr.length; i++) {
            poll += `
                    <li>
                        <label>
                            <input type="radio" name="vote-answer" value="${answerArr[i]}">
                            ${answerArr[i]}</input>
                        </label>
                    </li>
            `;
        }
        poll += `
                    </ul>
                </div>
                <div class="vote-button">
                    <button class="button btn-primary" onclick="javascript:poll();">투표하기</button>
                    <button class="button">결과보기</button>
                </div>
                <div class="vote-date">투표기간 : ${localStorage.getItem("sd")} ~ ${localStorage.getItem("ed")}</div>
            </div>
        `;

        pollDiv.innerHTML = poll;
        pollBtnDiv.style.display = "none";
        pollDiv.style.display = "";
    }
    else {
        var poll = "진행중인 투표가 없습니다.";
        pollDiv.innerHTML = poll;
        pollBtnDiv.style.display = "block";
        pollDiv.style.display = "block";
    }

    document.getElementById("btn-makepoll").onclick = function () {
        window.open("./makepoll.html", "mp", "width=500, height=500, top=0, left=0");
    };
};
