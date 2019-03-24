function openWindow1(obj){
  var openUrl = obj.parentNode.firstChild.value;
  var iWidth=800;
  var iHeight=700;
  var iTop =(window.screen.availHeight-30-iHeight)/2;
  var iLeft = (window.screen.availWidth-10-iWidth)/2;
   window.open(openUrl, "WINDOW", "height="+iHeight+",width="+iWidth+",top="+iTop+",left="+iLeft+",toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

function openLink(Field){
	var flowID = Field.title;
		var url = "/newclaim/swfFlowBeforeQueryDxfl.do?swfLogFlowID="+flowID+"&swfList=swfFlowQuery";
		if(hasSVG()){
			url += "&svgFlag=1";
		}else{
			url += "&svgFlag=0";
		}
		var iWidth=800;
		var iHeight=700;
		var iTop =(window.screen.availHeight-30-iHeight)/2;
		var iLeft = (window.screen.availWidth-10-iWidth)/2;
		window.open(url, "WINDOW", "height="+iHeight+",width="+iWidth+",top="+iTop+",left="+iLeft+",toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}
function hasSVG(){
	SVG_NS = 'http://www.w3.org/2000/svg';
return !!document.createElementNS && !!document.createElementNS(SVG_NS,'svg').createSVGRect;
}