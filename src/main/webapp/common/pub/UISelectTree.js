/****************************************************************************

 * DESC       ������ѡ�����ݽṹ

 * AUTHOR     ��

 * CREATEDATE ��2014-12-24

 * MODIFYLIST ��   Name       Date            Reason/Contents

 *          ------------------------------------------------------

 *            ������νṹѡ��


 ****************************************************************************/

var nowField;
var nowNameField;
//field �ı���type ��������,flag 1�е����� 0�޵�����
function selectCodeTree(field,type,flag,nameField){
		nowField = field;
		nowNameField = nameField;
		var codecode =field.value;
		var x = field.offsetLeft;
		var y = field.offsetTop;
		var parent = field;
		while(parent.offsetParent){
			parent = parent.offsetParent;
			x += parent.offsetLeft;
			y += parent.offsetTop;
		
		}
		var baseUrl = "/claim/common/pub/UISelectTreeQuery.jsp?";
		if(type == "agentCode"){
			var organCode = fm.organCode.value;
			if(organCode == ""){
				alert("����ѡ���������!");
				return false;
			}
			baseUrl += "codeType=" + type;
			baseUrl += "&flag=" + flag;
			baseUrl += "&organCode=" + organCode;
			baseUrl += "&codecode=" + codecode;
		}
		else{
			baseUrl += "codeType="+type;
			baseUrl += "&flag="+flag;
			baseUrl += "&codecode=" + codecode;
		}
		var screenX = event.screenX;
		var screenY = event.screenY;
		//window.open(baseUrl,'selectWindow',"top="+screenY+"px,left="+screenX+"px,width=300,height=400" );
		var temp = window.showModalDialog(baseUrl,window,"dialogHide:yes;help:no;status:no;scroll:yes;dialogWidth:300px;dialogHeight:400px,dialogLeft:"+screenX+",dialogTop:"+screenY);
		if(temp!=null){
		    var arrtemp = new Array(); 
			arrtemp= temp.split("#");
			field.value=arrtemp[0];
			nameField.value=arrtemp[1];
		}
		
}

function setCodeValue(value){
	fm.classCodeTemp.value = value;
}
function setCodeName(value){
	if(nowNameField!=null)
		fm.classCodeTempName.value = value;
}

var delayId;
/**
* param iid   input��ID
* param divId div��ID
* param ifrId iframe��ID
*/
function dispalyInfo(id,iid,odivId,divId,ifrId){
	var info = document.getElementsByName(iid)[id].value;//document.getElementById(iid).value;
	
	var odiv = document.getElementsByName(odivId)[id];
	if(info!=''){
		info = info.replace(/,/g,"<br>");
		var divRef = document.getElementById(divId);
		var ifrRef = document.getElementById(ifrId);
		divRef.innerHTML = info;
		divRef.style.width = odiv.offsetWidth;
		divRef.style.top = odiv.offsetTop+odiv.offsetHeight;
		divRef.style.left = odiv.offsetLeft;
		divRef.style.display = "block";
		ifrRef.style.width = divRef.offsetWidth;
		ifrRef.style.height = divRef.offsetHeight;
		ifrRef.style.top = divRef.offsetTop;
		ifrRef.style.left = divRef.offsetLeft;
		ifrRef.style.zIndex = divRef.style.zIndex-1;
		ifrRef.style.display = "block";
	}
}
function hideInfo(id,divId,ifrId){
	var ref = document.getElementById("displayInfoDiv");
	ref.style.display = "none";
	var divRef = document.getElementById(divId);
	var ifrRef = document.getElementById(ifrId);
	divRef.style.display = "none";
	ifrRef.style.display = "none";
}