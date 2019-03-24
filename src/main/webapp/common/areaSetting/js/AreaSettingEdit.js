function setArea(){
	var newSelect = document.getElementById('newSelect');
	var oldSelect = document.getElementById('oldSelect');
	var number = document.getElementById('number').value;
	var area = document.getElementsByName('area');
	area.value="";
	var indexId = document.getElementsByName('indexId');
	var obj = indexId[number-1];
	var spanObj = $(obj).parent().parent().find("span");
	for(var i=0;i<spanObj.length;i++){
		if(spanObj[i].id == 'spanText'){
			spanObj[i].innerHTML = "";
			for(var x=0;x<newSelect.options.length;x++){
				if(spanObj[i].innerHTML == ""){
					spanObj[i].innerHTML = newSelect.options[x].text;
					area[number-1].value = newSelect.options[x].value;
				}else{
					spanObj[i].innerHTML = spanObj[i].innerHTML+"<br/>"+newSelect.options[x].text;
					area[number-1].value = area[number-1].value+";"+newSelect.options[x].value;
				}
			}
			for(var x=newSelect.options.length;x>0;x--){
				oldSelect.options.add(new Option(newSelect.options[x-1].text,newSelect[x-1].value));
			}
			for(var x=newSelect.options.length;x>0;x--){
				newSelect.options.remove(newSelect[x]);
			}
		}
	}
	closeMsg();
}

function showMsg(obj){
		var objInput = $(obj).parent().find("input");
        var number = document.getElementById('number');
        var area = document.getElementsByName('area');
		for(var i=0;i<objInput.length;i++){
			if(objInput[i].id == "indexId"){
				number.value = objInput[i].value;
			}
		}
        new shieldDiv().show();//调用我的蒙层的show方法
    }
    function closeMsg(){
    	var number = document.getElementById('number');
    	
    	var newSelect = document.getElementById('newSelect');
		var oldSelect = document.getElementById('oldSelect');
			for(var x=newSelect.options.length;x>0;x--){
				oldSelect.options.add(new Option(newSelect.options[x-1].text,newSelect[x-1].value));
			}
			for(var x=newSelect.options.length;x>0;x--){
				newSelect.options.remove(newSelect[x]);
			}
    	
        new shieldDiv().hide();//调用我的蒙层的hide方法
    }

	function createSelect(obj,selectName){
		var selectName = document.getElementById(selectName);
//		if(selectName.options.length >0){
//			if(comLevelMap.get(obj.value) != comLevelMap.get(selectName.options[0].value)){
//				alert("请选择相同等级机构！");
//				return false;
//			}
//		}
		selectName.options.add(new Option(obj.options[obj.selectedIndex].text,obj.value));
		obj.options.remove(obj.selectedIndex);
	}
	//隐藏域
	function divStyle(obj,styleType){
		divSpan.style.display= "";
	}
	
	
	//删除
	function delTable(obj){
		$(obj).parent().parent().remove();
		getIndex();
	}
	
	
	function saveForm(id){
		alert();
		fm.submit();
		return true;
	}
	
	function addTable(){
		//添加第一行
		var handlercode = document.getElementsByName('handlercode');
		//alert(handlercode.length);
		var index = handlercode.length+1;
		//alert(index);
		var tab = document.getElementById('tab');
		$("#tab").append(
			"<tr>"+
			"<td align='center'><span id='spanId'>"+index+"</span><input type='hidden' id='indexId' name='indexId' value='"+index+"'></td>"+
			"<td>"+
			"<input type=text name='handlercode' class='codecode' style='width: 100%' maxlength='10' title='操作员' value='' ondblclick=\"code_CodeSelect(this,  'CertaJobCode');\" onkeyup=\"code_CodeSelect(this, 'CertaJobCode');\" onblur=\"code_CodeChange(this, 'CertaJobCode','1','code','post','clear')\">"+
			"</td>"+
			"<td>"+
			"<input type=text name='handlername' class='' style='width: 100%;TEXT-DECORATION: none;BORDER-TOP: medium none;' title='操作员' maxlength='30' value='' readonly>"+
			"</td>"+
			"<td onclick='showMsg(this)' class='textc'>"+
			"<span id='spanText'>作业区域</span><input type=\"hidden\" id=\"area\" name=\"area\" value=\"\"><input type=\"hidden\" id=\"flowintime\" name=\"flowintime\" value=''><input type=\"hidden\" id=\"id\" name=\"id\" value=''>"+
			"</td>"+
			"<td>"+
			"<input type='text' id='tel' name='tel' style='width: 100%'>"+
			"</td>"+
			"<td align='center'>"+
			"<input type='button' class='smallbutton' value='-' onclick='delTable(this);'/>"+
			"</td>"+
			"</tr>"
		);
     }
     
     function getIndex(){
		var handlercode = document.getElementsByName('handlercode');
		var indexId = document.getElementsByName('indexId');
		for(var i=0;i<indexId.length;i++){
			var spanobj = $(indexId[i]).parent().parent().find("span");
			//alert(spanobj.length);
			indexId[i].value=i+1;
			for(var a=0;a<spanobj.length;a++){
				if(spanobj[a].id=='spanId'){
					spanobj[a].innerHTML=i+1;
				}
			}
		}
	}