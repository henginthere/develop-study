function getXMLHttpRequest(){
	if(window.ActiveXObject){ // MS IE
		try{
			return new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e1){
			try{
				return new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e2){
				return null;
			}
		}
	}else if(window.XMLHttpRequest){ //기타 웹 브라우져
		return new XMLHttpRequest();
	}else{
		return null; 
	}
}

var httpRequest = null;

function sendRequest2(url, params, method, successcallback, errorcallback, dataType = "text"){
	httpRequest = getXMLHttpRequest();
	
	httpRequest.addEventListener('loadend', function(e){
		const result = e.currentTarget;
		if (result.status == 200) {
			if (dataType == "xml") {
				successcallback(result.responseXML);
			}else if(dataType == "json") {
				successcallback(result.responseText);
			} else {
				successcallback(result.responseText);
			}
		}else{
			errorcallback(result.status, result.response);
		}
	});

	var httpMethod = method ? method : 'GET';
	if(httpMethod != 'GET' && httpMethod != 'POST'){
		httpMethod = 'GET';
	}
	var httpParams = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if(httpMethod == 'GET' && httpParams != null){
		httpUrl = httpUrl + "?" + httpParams;
	}
	
	//open() : 요청의 초기화, GET/POST 선택, 접속할 URL 입력, async(true)
	httpRequest.open(httpMethod, httpUrl, true);
	if (dataType == "json") {
		httpRequest.setRequestHeader('Content-Type', 'application/json;charset=utf-8');
	} else {
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	}
	
	//send() : web server에 요청을 전송.
	httpRequest.send(httpMethod == 'POST' ? httpParams : null);
}
