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