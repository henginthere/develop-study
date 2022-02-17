function getXMLHttpRequest(){
	if(window.ActiveXObject){ //MS IE
		try{
			return new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch(e1){
			try{
				return new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch(e2){
				return null;
			}
		}
	}
	else if(window.XMLHttpRequest){ //기타 웹 브라우저(Chrome 등 ...)
		return new XMLHttpRequest();
	}
	else{
		return null;
	}
} 

var httpRequest = null;

function sendRequest(url, params, callback, method){
	httpRequest = getXMLHttpRequest();
	
	var httpMethod = method ? method : 'GET';
	
	if(httpMethod!='GET'&&httpMethod!='POST'){
		httpMethod='GET';
	}
	var httpParams = (params==null || params =='')? null:params;
	var httpUrl = url;
	if(httpMethod=='GET'&&httpParams!=null){
		httpUrl = httpUrl+'?'+httpParams;
	}
	
	//open() : 요청의 초기화, GET/POST 선택, 접속할 URL 입력, async(true)
	httpRequest.open(httpMethod, httpUrl, true);
	httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	httpRequest.onreadystatechange = callback;
	
	//send() : web server에 요청을 전송
	httpRequest.send(httpMethod=='POST' ? httpParams :null);
}
