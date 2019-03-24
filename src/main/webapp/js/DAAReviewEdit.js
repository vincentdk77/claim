function addDeviationmoney(){
	var nodeType=fm.nodeType.value;
	var deviationmoneySum = 0;
	var keys =$("input[name='personKey']");
	var url = "";
	//var prplregistNo = fm.prplregistNo.value;											//报案号
	var prplregistNo = fm.registNo.value;
	if(nodeType == 'certa' || nodeType == 'verif'){
		var lossItemCode = fm.lossItemCode.value;
		var prpLcomponentDtoProblemsType = "";											//更换配件 问题类型
		var prpLcomponentDtoDeviationmoney = "";										//更换配件 偏差金额
		var prpLComponentDtoSerialNo = "";
		var objP = $("select[name$='ProblemsType']");
       	var objD = $("input[name$='Deviationmoney']");
       	var componentSerialNo = $("input[name=prpLComponentSerialNo]");					////更换配件 序号
       	objP.each(function(i){
       		prpLcomponentDtoProblemsType += objP[i].value+";";
       		prpLcomponentDtoDeviationmoney += objD[i].value+";";
       		prpLComponentDtoSerialNo += componentSerialNo[i].value+";";
       	});
		var prpLrepairFeeProblemsType = "";												//维修工时费 问题类型
		var prpLrepairFeeDeviationmoney = "";											//维修工时费 偏差金额
		var prpLrepairFeeDtoSerialNo = "";												//维修工时费 序号
       	var objp = $("select[name^='problemsType']");
       	var objd = $("input[name^='deviationmoney']");
       	var serialNo = $("input[name=prpLrepairFeeSerialNo]");							//维修工时费 序号
       	objp.each(function(i){
       		prpLrepairFeeProblemsType += objp[i].value+";";
       		prpLrepairFeeDeviationmoney += objd[i].value+";";
       		prpLrepairFeeDtoSerialNo += serialNo[i].value+";";
       	});
		url = "prplregistNo="+prplregistNo+"&nodeType="+nodeType+"&prpLcomponentDtoProblemsType="+prpLcomponentDtoProblemsType+"&prpLcomponentDtoDeviationmoney="+prpLcomponentDtoDeviationmoney+"&prpLrepairFeeProblemsType="+prpLrepairFeeProblemsType+"&prpLrepairFeeDeviationmoney="+prpLrepairFeeDeviationmoney+"&prpLrepairFeeDtoSerialNo="+prpLrepairFeeDtoSerialNo+"&prpLComponentDtoSerialNo="+prpLComponentDtoSerialNo+"&lossItemCode="+lossItemCode;
		//alert(url);
	}
	
	if(nodeType == 'propc'||nodeType == 'propv'){
		var lossItemCode = fm.lossItemCode.value;
		var prpLPropItemNoObj = $("input[name=prpLPropItemNo]");
		var problemsTypeObj = $("select[name=problemsType]");
		//alert(problemsTypeObj.length);
		var deviationmoneyObj = $("input[name=deviationmoney]");
		var prpLPropItemNo = "";
		var problemsType = "";
		var deviationmoney = "";
		prpLPropItemNoObj.each(function(i){
       		prpLPropItemNo += prpLPropItemNoObj[i].value+";";
       		problemsType += problemsTypeObj[i].value+";";
       		deviationmoney += deviationmoneyObj[i].value+";";
       	});
		url = "prplregistNo="+prplregistNo+"&prpLPropItemNo="+prpLPropItemNo+"&problemsType="+problemsType+"&deviationmoney="+deviationmoney+"&nodeType="+nodeType+"&lossItemCode="+lossItemCode;
	}
	
	if(nodeType == 'surve'||nodeType == "rview"||nodeType == "wound"||nodeType == "veriw"){
		var objp;
		var objd;
		if(nodeType == 'surve'){
			 objp = $("select[name^='surveproblemsType']");
       		 objd = $("input[name^='survedeviationmoney']");
		}
		if(nodeType == 'rview'){
			 objp = $("select[name^='rviewproblemsType']");
       		 objd = $("input[name^='rviewdeviationmoney']");
		}
		if(nodeType == 'wound'){
			 objp = $("select[name^='woundproblemsType']");
       		 objd = $("input[name^='wounddeviationmoney']");
		}
		if(nodeType == 'veriw'){
			 objp = $("select[name^='veriwproblemsType']");
       		 objd = $("input[name^='veriwdeviationmoney']");
		}
       	var problemsType = "";
       	var problemsTypeName = "";
       	var deviationmoney = "";
       	var deviationmoneyName = "";
       	
       	//var keyArray=new Array();
       	var valueArray=new Array(keys.length);
       	var deviationmoneyvalue=0;
       	objp.each(function(i){
       		problemsType += objp[i].value+";";
       		problemsTypeName += objp[i].name+";";
       		deviationmoney += objd[i].value+";";
       		deviationmoneyName += objd[i].name+";";
       		deviationmoneyvalue+=Number(objd[i].value);
       		if((i+1)%18==0){
       			valueArray[(i+1)/18-1]=deviationmoneyvalue;
       			//alert(((i+1)/18)-1+"    OOOOO"+deviationmoneyvalue);
       			deviationmoneyvalue=0;
       		}
       	});
       	problemsTypeName=problemsTypeName.substring(0,problemsTypeName.length-1);
       	deviationmoneyName=deviationmoneyName.substring(0,deviationmoneyName.length-1);
       	//alert(prplregistNo);
       	//alert(nodeType);
       	url = "prplregistNo="+prplregistNo+"&problemsTypeName="+problemsTypeName+"&problemsType="+problemsType+"&deviationmoneyName="+deviationmoneyName+"&deviationmoney="+deviationmoney+"&nodeType="+nodeType;
	}
	//if(nodeType == "rview"){
	//		var objp = $("select[name^='rviewproblemsType']");
    //   	var objd = $("input[name^='rviewdeviationmoney']");
       	
    //   	var problemsType = "";
    //   	var problemsTypeName = "";
    //  	var deviationmoney = "";
    //   	var deviationmoneyName = "";
    //   	objp.each(function(i){
    //   		problemsType += objp[i].value+";";
    //   		problemsTypeName += objp[i].name+";";
    //   		deviationmoney += objd[i].value+";";
    //   		deviationmoneyName += objd[i].name+";";
    //   	});
    //   	problemsTypeName=problemsTypeName.substring(0,problemsTypeName.length-1);
    //   	deviationmoneyName=deviationmoneyName.substring(0,deviationmoneyName.length-1);
       	//alert(prplregistNo);
       	//alert(nodeType);
   //    	url = "prplregistNo="+prplregistNo+"&problemsTypeName="+problemsTypeName+"&problemsType="+problemsType+"&deviationmoneyName="+deviationmoneyName+"&deviationmoney="+deviationmoney+"&nodeType="+nodeType;
	//}
	//if(nodeType == "wound"){
	//	var objp = $("select[name^='woundproblemsType']");
    //   	var objd = $("input[name^='wounddeviationmoney']");
       	
    //   	var problemsType = "";
    //   	var problemsTypeName = "";
    //   	var deviationmoney = "";
    //   	var deviationmoneyName = "";
    //   	objp.each(function(i){
    //   		problemsType += objp[i].value+";";
    //   		problemsTypeName += objp[i].name+";";
    //   		deviationmoney += objd[i].value+";";
   //    		deviationmoneyName += objd[i].name+";";
    //   	});
   //    	problemsTypeName=problemsTypeName.substring(0,problemsTypeName.length-1);
    //   	deviationmoneyName=deviationmoneyName.substring(0,deviationmoneyName.length-1);
    //   	url = "prplregistNo="+prplregistNo+"&problemsTypeName="+problemsTypeName+"&problemsType="+problemsType+"&deviationmoneyName="+deviationmoneyName+"&deviationmoney="+deviationmoney+"&nodeType="+nodeType;
	//}
	//if(nodeType == "veriw"){
		//alert(nodeType);
	//	var objp = $("select[name^='veriwproblemsType']");
    //   	var objd = $("input[name^='veriwdeviationmoney']");
       	
    //   	var problemsType = "";
    //   	var problemsTypeName = "";
    //   	var deviationmoney = "";
    //   	var deviationmoneyName = "";
    //   	objp.each(function(i){
    //   		problemsType += objp[i].value+";";
    //   		problemsTypeName += objp[i].name+";";
    //   		deviationmoney += objd[i].value+";";
    //   		deviationmoneyName += objd[i].name+";";
    //   	});
    //   	problemsTypeName=problemsTypeName.substring(0,problemsTypeName.length-1);
    //   	deviationmoneyName=deviationmoneyName.substring(0,deviationmoneyName.length-1);
     //  	url = "prplregistNo="+prplregistNo+"&problemsTypeName="+problemsTypeName+"&problemsType="+problemsType+"&deviationmoneyName="+deviationmoneyName+"&deviationmoney="+deviationmoney+"&nodeType="+nodeType;
	//}
	var numberNo = "";
	var sum = 0;
	var html = $.ajax({
		type: "POST",
		url: "/newclaim/addReviewAmount.do",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8", 
		data: url,
		async: false,
		success: function(msg){
			if("surve" == nodeType || nodeType == "rview" || nodeType == "wound" || nodeType == "veriw"){
				var arrayObj = new Array();
				arrayObj = msg.split(";");
				var status = arrayObj[0];
				numberNo = arrayObj[1];
				sum = arrayObj[2];
			}else{
				var arrayObj = new Array();
				arrayObj = msg.split(";");
				var status = arrayObj[0];
				deviationmoneySum += Number(arrayObj[1]);
			}
			
		}
	}).responseText; 
			var w=window.dialogArguments;
			//var w=window;
			if("surve" == nodeType || nodeType == "rview" || nodeType == "wound" || nodeType == "veriw"){
				//var personKey = w.document.getElementsByName("personKey");
				//var keys =$("input[name='personKey']");
				//alert(keys.length+"  length");
				var lossitemcode = w.document.getElementsByName("lossitemcode");
				var no = numberNo.split("|");
				var sumS = sum.split("|");
				keys.each(function(c){
					//alert("PPP"+c+"  ooo"+keys[c].value);
					w.document.getElementById("deviationmoneySpan"+keys[c].value).innerHTML=valueArray[c];
					w.document.getElementById("prplreviewbusinessDtodeviationmoney"+keys[c].value).value=valueArray[c];
					//alert(valueArray[c]);
				});
				//for(var i=0;i<personKey.length;i++){
				//alert(i);
					//for(var x=0;x<no.length;x++){
						//if(lossitemcode[i].value == no[x]){
							//w.document.getElementsByName("deviationmoneySpan"+personKey[i]).innerHTML=valueArray[i];
							//w.document.getElementsByName("prplreviewbusinessDtodeviationmoney"+personKey[i]).value=valueArray[i];
							//alert(valueArray[i]);
						//}
					//}
				//}
			}else{
				var lossItemCode = fm.lossItemCode.value;
				var wlossitemcode = w.document.getElementsByName("lossitemcode");
				for(var i=0;i<wlossitemcode.length;i++){
					if(wlossitemcode[i].value == lossItemCode){
						if(w.document.getElementById("deviationmoneySpan"+wlossitemcode[i].value)!=null){
							w.document.getElementById("deviationmoneySpan"+wlossitemcode[i].value).innerHTML=deviationmoneySum;
						}
						w.document.getElementById("prplreviewbusinessDtodeviationmoney"+wlossitemcode[i].value).value=deviationmoneySum;
					}
				}
			}
			window.close();
}

function likeReview(obj){
	var tdObj = $(obj).find("input");
	var url = tdObj[0].value;
	var myDate = new Date();
	myDate.getMilliseconds();
	// alert(url);
	url += "&myDate="+myDate.getTime();
	//alert(url);
	//window.open(url);
	var policyMessage= window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1000px');
	//var policyMessage= window.open(url,"xxx",'dialogHeight:800px;dialogWidth:1000px');
}

function likeInput(obj,name){
	document.getElementById(name).value = obj.value;
	
}

//发送复审
function manualReview(){
	var nodeTypes = document.getElementById('nodeType').value;
	if(!nodeTypes == ''){
		//var nodeType=fm.nodeType.value;
		var nodeType=document.getElementById('nodeType').value;
		var prplregistNo = fm.prplregistNo.value;
		var lossitemcode = "";
		var url = "";
		if(nodeType == 'check' || nodeType == 'compe'|| nodeType == 'cview'|| nodeType == 'fview'){
			//if(nodeType == 'check'){
				lossitemcode = fm.lossitemcode.value;
			//}else{
			//	lossitemcode ="1";
			//}
			if(nodeType == 'compe'){
				url = "prplregistNo="+prplregistNo+"&nodeType=compp&lossitemcode="+lossitemcode;
			}else{
				url = "prplregistNo="+prplregistNo+"&nodeType="+nodeType+"&lossitemcode="+lossitemcode;
			}
		}
		if(nodeType == 'surve' || nodeType == 'rview' || nodeType == 'wound' || nodeType == 'veriw'){
			if(nodeType == 'wound'){
				var woundType=document.getElementById('woundType');
				if(woundType!=null&&woundType.value=='pendtrack'){
					nodeType="surve"
				}
			}
			lossitemcode = fm.lossitemcode.value;
			var personKey = document.getElementsByName('personKey');
			var personKeys = "";
			for(var i=0;i<personKey.length;i++){
				personKeys += personKey[i].value+";";
			}
			url = "prplregistNo="+prplregistNo+"&nodeType="+nodeType+"&lossitemcode="+lossitemcode+"&personKeys="+personKeys;
		}
		if(nodeType == 'certa' || nodeType == 'verif'){
			lossitemcode = fm.lossItemCode.value;
			url = "prplregistNo="+prplregistNo+"&nodeType="+nodeType+"&lossitemcode="+lossitemcode;
		}
		if(nodeType == 'propc' || nodeType == 'propv'){
			lossitemcode = fm.lossItemCode.value;
			url = "prplregistNo="+prplregistNo+"&nodeType="+nodeType+"&lossitemcode="+lossitemcode;
		}
	}else{
		var compensateno =$("#compensatenotemp").val();
		var nodeType='apay';
		var prplregistNo = document.getElementById('registNo_payment').value;
		//var compensateno = document.getElementById('compensateno').value;
		var lossitemcode = "";
		lossitemcode = "C";
		//alert(nodeType);
		url = "prplregistNo="+prplregistNo+"&nodeType="+nodeType+"&lossitemcode="+lossitemcode+"&compensateno="+compensateno;
	}
	//alert(url);
	var html = $.ajax({
		type: "POST",
		url: "/newclaim/addManualReview.do",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8", 
		data: url,
		async: false,
		success: function(msg){
			//alert(msg);
			if(msg == 'true'){
				alert("发送复审成功！");
			}else if(msg == 'ing'){
				alert("复审任务已存在，请不要重复发送！");
			}else{
				alert("发送复审失败！");
			}
		}
	}).responseText; 
}