var X_LOAD = function(){
	this.version = '1.0';
	this.target = null;
	this.iframe = null;
	this.divCover = null;
	this.divContent = null;
	this.divError = null;
}	
X_LOAD.prototype.setTarget = function(target){
	this.target = target;
}
X_LOAD.prototype.show = function(title){
	
	if(title == null || title == 'undefined' ||  title == ''){
		title = '执行中...';
	}
	if(this.target == null){
		this.target = document.body;
	}
	this.showFrame();
	this.showDiv(title);
}
X_LOAD.prototype.showFrame = function(){
	var iframe = document.createElement("IFRAME");
	iframe.id = 'X_iframe_cover';
	iframe.style.position = 'absolute';
	iframe.style.left = '0px';
	iframe.style.top = '0px';
	iframe.style.zIndex = 0;
	iframe.style.filter = 'Alpha(Opacity=0)';
	
	var bodySize = this.targetSize();
	iframe.style.width = bodySize[0];
	iframe.style.height = bodySize[1];
	document.body.appendChild(iframe);
	this.iframe = iframe;
}
X_LOAD.prototype.showDiv = function(title){
	var div = document.createElement("DIV");
	div.id = 'X_div_cover';
	div.style.position = 'absolute';
	div.style.left = '0px';
	div.style.top = '0px';
	div.style.background = 'gray';
	div.style.zIndex = 0;
	div.style.filter = 'Alpha(Opacity=60)';
	var bodySize = this.targetSize();
	div.style.width = bodySize[0];
	div.style.height =  bodySize[1];
	var contentDiv = document.createElement("DIV");
	var CW = document.body.clientWidth;
	var CH = document.body.clientHeight;
	var top = CW/2 -250;
	var left = CH/2;
	contentDiv.id = 'X_div_content';
	contentDiv.innerHTML += '<div style="height:20px;"/>'
	contentDiv.innerHTML += '<img src="/claim/images/loading.gif"/><br/>'
	contentDiv.innerHTML += '<div style="padding-top:10px;"><b>'+ title +'</b></div>';
	contentDiv.style.position = 'absolute';
	contentDiv.style.textAlign = 'center';
	contentDiv.style.background = 'white';
	contentDiv.style.color = '#27408B';
	contentDiv.style.width = '250px';
	contentDiv.style.height = '80px';
	contentDiv.style.border = '2px solid #27408B';
	contentDiv.style.top = document.body.scrollTop + top + 'px';
	contentDiv.style.left = left + 'px';
	
	var	closeDiv = document.createElement("DIV");
	closeDiv.id = 'X_div_close';
	closeDiv.style.zIndex = 0;
	closeDiv.innerHTML += '<img src="/claim/images/btn_close.gif"/>';
	closeDiv.style.position = 'absolute';
	closeDiv.style.width = '10px';
	closeDiv.style.height = '10px';
	closeDiv.style.top = '0px';
	closeDiv.style.left = (bodySize[0] - 12)  + 'px';
	closeDiv.style.cursor = 'hand';
	closeDiv.onclick = function(){x_load.hide();};
	div.appendChild(closeDiv);
	document.body.appendChild(div);
	document.body.appendChild(contentDiv);
	this.divCover = div;
	this.divContent = contentDiv;
	
	 
}
X_LOAD.prototype.hide = function(){
	if(this.iframe){
		this.iframe.parentNode.removeChild(this.iframe);
	}
	if(this.divCover){
		this.divCover.parentNode.removeChild(this.divCover);
	}
	if(this.divContent){
		this.divContent.parentNode.removeChild(this.divContent);
	}
	if(this.divError){
		this.divError.parentNode.removeChild(this.divError);
	}
	this.iframe = null;
	this.divCover = null;
	this.divContent = null;
	this.divError = null;
	
}
X_LOAD.prototype.targetSize = function(){
	var bodySize =[];
	with(this.target){
		bodySize[0] = (scrollWidth > clientWidth) ? scrollWidth :clientWidth;
		bodySize[1] = (scrollHeight > clientHeight) ?scrollHeight :clientHeight;
	}
	return bodySize;
}
X_LOAD.prototype.setHeight = function(height){
	this.iframe.style.height = height + "px";
	this.divCover.style.height = height + "px";
}
X_LOAD.prototype.showError = function(errorCode,errorText,errorDetail){
	this.divContent.parentNode.removeChild(this.divContent);
	this.divContent = null;
	var CW = document.body.clientWidth;
	var CH = document.body.clientHeight;
	var top = CW/2 - 250;
	var left = CH/2 - 100;
	var errorDiv = document.createElement("DIV");
	errorDiv.style.position = 'absolute';
	errorDiv.style.background = 'white';
	errorDiv.style.color = '#27408B';
	errorDiv.style.width = '450px';
	errorDiv.style.height = '100px';
	errorDiv.style.border = '2px solid #27408B';
	errorDiv.style.top = document.body.scrollTop + top + 'px';
	errorDiv.style.left = left + 'px';
		
	var errorTable =  document.createElement("TABLE");
	errorTable.style.width = '100%';
	errorTable.style.height = '100%';
	errorTable.style.border = '0px solid red';
	var tr1 = errorTable.insertRow();
	var tr2 = errorTable.insertRow();
	var tr3 = errorTable.insertRow();
	var td1 = tr1.insertCell();
	td1.rowSpan = '2';
	td1.style.width = '20%';
	tr1.style.height = '70px';
	td1.style.textAlign = 'center';
	var td2 = tr1.insertCell();
	var td3 = tr2.insertCell();
	var td4 = tr3.insertCell();
	td1.innerHTML = '<img src="/claim/images/failure.gif"/>';
	
	td2.innerHTML = '错误类型：' + errorCode + '<br/>'
				  + '错误描述：' + errorText;
	td3.style.height = '18px';
	td3.style.textAlign = 'right';
	td3.innerHTML = '<span onclick ="x_load.detailError();" onmouseover="x_load.onmouseover(this);" onmouseout="x_load.onmouseout(this);" '
	              + 'style="padding:1;width:55px;height:12px;color:white;border:1px solid #36648B;background-color:#4682B4;cursor:default">详细信息</span>&nbsp;'
				  + '<span onclick ="x_load.closeError();" onmouseover="x_load.onmouseover(this);" onmouseout="x_load.onmouseout(this);" '
 				  + 'style="padding:1;width:30px;height:12px;color:white;border:1px solid #36648B;background-color:#4682B4;cursor:default">关闭</span>';

	tr3.id = 'X_tr_error';
	tr3.style.display = 'none';
	td4.colSpan = '2';
	td4.innerHTML = '<textarea style="width:440px;height:100%">'+ errorDetail +'</textarea>';
	

	errorDiv.appendChild(errorTable);
	document.body.appendChild(errorDiv);
	this.divError = errorDiv;
	
}
X_LOAD.prototype.closeError = function(){
	this.hide();
}
X_LOAD.prototype.detailError = function(){
	var trError = document.getElementById('X_tr_error');
	if(trError.style.display == 'none'){
		this.divError.style.height = '400px';
		trError.style.display = "";
	}
	else{
		this.divError.style.height = '100px';
		trError.style.display = "none";
	}
	
}
X_LOAD.prototype.onmouseover = function(field){
	field.style.border = '1px solid #191970';
	field.style.background = '#104E8B';
}
X_LOAD.prototype.onmouseout = function(field){
	field.style.border = '1px solid #36648B';
	field.style.background = '#4682B4';
}
var x_load = new X_LOAD();


