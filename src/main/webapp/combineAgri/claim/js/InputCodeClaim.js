/****************************************************************************
 * DESC       ������¼��
 * AUTHOR     ��liuyang
 * CREATEDATE ��2003-12-23
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

var DEBUG_MODE = true;
var inquery = false;    //���ڲ�ѯ�����־
var queryError = false; //��ѯ��������־
var sign; //ʱ���



function private_Code_CallServiceClaim(field,codetype,relation,inputtype,querytype,limit,method,indexOfRegist){
    var fmcode = parent.fraCode.fm;  
    if(isInquery()==true){
        var isRealInquery = true;
        try{
            var title = parent.fraCode.document.title; 
            if(title != undefined){
                if( title.indexOf("Error") >= 0){//��ҳ����
                    isRealInquery = false;
                    window.status = "��ѯ�������......";
                }
            }           
        }catch(e){
            //��ҳ�Ѿ�����
            isRealInquery = false;            
        }
        if(isRealInquery){
            window.status = "���ڲ�ѯ����......";
            window.status ="isInquery()="+isInquery();
            return;
        }else{
            parent.document.all.fraCode.src="/claim/common/pub/InputCode.jsp";
            setInquery(false);
            return;
        }
        
    }
    setSign(new Date().getTime());
    setInquery(true);
    setQueryError(false);
    
    //���������
    try
    {
        if(relation==null){
            relation = 1;
        }
        if(inputtype==null){
            inputtype = "code";
        }
        if(querytype==null){
            querytype = "always";
        }
        if(limit==null){
            limit = "must";
        }
        if(method==null){
            method = "select";
        }
        fmcode.codeindex.value= getElementIndex(field);
        fmcode.codevalue.value=field.value;
        fmcode.codetype.value=codetype;
        fmcode.relation.value=relation;
        fmcode.inputtype.value=inputtype;
        fmcode.querytype.value=querytype;
        fmcode.limit.value=limit;
        fmcode.method.value=method;
        fmcode.fieldsign.value= getSign();
        fmcode.other.value="";
        
        
        if(codetype=="PolicyItemCode"){
            try{
                fmcode.other.value = fm.prpLclaimLossKindCode[getElementOrder(field)-1].value;
             }catch(ex1)
            {
                window.status = ex1;
            }
        }
       
        //�ж��Ƿ�Ϊ��ѯ�鿱��
        if (codetype == "CheckPerson") {
            try {
                var companyCode = fm.prpLscheduleMainWFScheduleObjectID.value;    //�����ȵ�λ����
                if (companyCode == "") {
                    alert("����ѡ��鿱��λ��");
                    inquery = false;
                    return true;
                } 
                 
                fmcode.other.value = companyCode;
            } catch (ex2) {
                window.status = ex2;
            }
        }
        //�ж��Ƿ�Ϊ��ѯ������
        if (codetype == "CertaHanderCode"||codetype == "WoundHanderCode"||codetype == "PropHanderCode") {
            try {
             	  var companyCode = fm.selectcomcode.value;    //�����ȵ�λ����
                if (companyCode == "") {
                    alert("����ѡ����λ��");
                    inquery = false;
                    return true;
                } 
                 
                fmcode.other.value = companyCode;
                
            } catch (ex2) {
                window.status = ex2;
            }
        }

//------------------------------
   if(codetype=="ModelCode")
    {   
	    fmcode.codevalue.value=""+"|"+""+"|"+""+"|"+field.value;
	         
    }
//-----------------------------------
        //�ж��Ƿ�Ϊ����ѯ����Ա
        if (codetype == "VerifyPricePerson") {
            try {
                var companyCode = fm.nextHandleDept.value;    //����ѯ�ۻ���
                if (companyCode == "") {
                    alert("����ѡ������ѯ�ۻ�����");
                    inquery = false;
                    return true;
                } 
                fmcode.other.value = companyCode;
            } catch (ex2) {
                window.status = ex2;
            }
        }
        try
        {
           fmcode.riskcode.value= fm.riskcode.value;
        }catch(ex)
        {
        	 //alert("���ָ����쳣��������"+fmcode.policyno.value);
        	try
	        {
	           fmcode.riskcode.value= fm.riskCode.value;
	        }catch(ex2)
	        {
	        	fmcode.riskcode.value = "0000";
	        }
        }
        try
        {
           fmcode.provinceCode.value= fm.provinceCode.value;
        }catch(ex)
        {
        	 //alert("���ָ����쳣��������"+fmcode.policyno.value);
        	try
	        {
	           fmcode.provinceCode.value= fm.provinceCode.value;
	        }catch(ex2)
	        {
	        	fmcode.provinceCode.value = "";
	        }
        }
        try
        {
        	 //�ű���
           fmcode.policyno.value= fm.policyno.value;
        }catch(ex)
        {
        	fmcode.policyno.value="";
        }
        if(codetype=="InjuryGrade")
        {
             var fieldname=field.name;
             var i = 0;
             var findex=0;
             for(i=1;i<fm.all(fieldname).length;i++)
             {
                 if( fm.all(fieldname)[i] == field )
                 {
                    findex=i;
                    break;
                 }
             }
            //����������أ�
             //modify by lixiang start at 2006-01-05
             if (findex>0){
                fmcode.codevalue.value = fm.prpLpersonLossLiabDetailCode[findex].value+"|"+field.value;
             }
             //modify by lixiang end at 2006-01-05
             
        }
         //��ѯ�ձ���Ϣ  by sunny
        if(codetype=="PolicyKindCode"||codetype=="PolicyKindCode1")
        {
             var fieldname=field.name;
             var i = 0;
             var findex=0;
             for(i=1;i<fm.all(fieldname).length;i++)
             {
                 if( fm.all(fieldname)[i] == field )
                 {
                    findex=i;
                    break;
                 }
             }
                           
             // alert("oooo");
             //modify by liyanjie modify begin
             //ԭ����д������,��ҳ�����޴˶���
             //fmcode.codevalue.value = fm.damageStartDate.value+"|"+ field.value; 
             //fmcode.codevalue.value = fm.prpLclaimFrameNo.value+"|"+ field.value;
             //fmcode.codevalue.value = fm.prpLregistDamageStartDate1.value+"|"+ field.value; 
              
              //modify by liuyanmei modify start 
             //add by qinyongli 2006-06-06 �����ǿ�Ʊ����ŵĻ�ȡ
              var PolicyBzNo = "";
              try{
                  PolicyBzNo = fm.prplCheckPolicyBzNoShow.value;
              }catch(ex2){
              	  
              }
              fmcode.codevalue.value = fm.damageStartDate.value+"|"+field.value+"|"+PolicyBzNo;     
             //modify by liuyanmei modify end       
             //modify by liyanjie modify end
        }
        
        //Modify by chenrenda begin 20070629
        //readon:�����ŵ�ҵ����������ģ����ѡ��б��ձ�ʱӦ���й���
        if(codetype=="AcciPolicyKindCode")
        {
        	 //�õ����г����߷ֻ����
        	 var count=getElementCount("prpLpersonLossFamilyNo");
        	 var familyNo ="";
        	 var familyNoTemp = "";
        	 for(var i=0;i<count;i++)
             {
                if(count==1){
                    familyNoTemp = fm.prpLpersonLossFamilyNo.value;
                    familyNo = "("+familyNoTemp+")";
                }else{
                   familyNoTemp = fm.prpLpersonLossFamilyNo[i].value;
                   if(i+1==count){
                      familyNo+=familyNoTemp;
                   }else{
                      familyNo+=familyNoTemp;
                   }
                 }
             }
             familyNo = "("+familyNo+")";
             var PolicyBzNo = "";
             try{
                  PolicyBzNo = fm.policyno.value;
             }catch(ex2)
             {
              	  
             }
             fmcode.codevalue.value = fm.damageStartDate.value+"|"+field.value+"|"+PolicyBzNo+"|"+familyNo;     
        }
      
        //�����ŵ�ҵ���������ǰ��ձ�������ͳ�Ƶ�
        if(codetype=="PolicyKindCodeVirturlItem")
        {
             var PolicyBzNo = "";
             try{
                  PolicyBzNo = fm.policyno.value;
             }catch(ex2)
             {
                  
             }
             fmcode.codevalue.value = fm.damageStartDate.value+"|"+field.value+"|"+PolicyBzNo;     
        }
        //����չ����ѯ�б��ձ� �ĳɸ���ֱ�ӷֻ�����ֱ�Ӳ�ѯcitemkind�� 
        //��ѯ�ձ���Ϣ  �����������ձ�����ѯ
        if(codetype=="PolicyKindCode2"||codetype=="KindCodeVirturlItem")
        {
        	 var fieldname=field.name;
             var i = 0;
             var findex=0;
             for(i=1;i<fm.all(fieldname).length;i++)
             {
                 if( fm.all(fieldname)[i] == field )
                 {
                    findex=i;
                    break;
                 }
             }
             var PolicyBzNo = "";
             try{
             	var elePrpLclaimPolicyNo = document.getElementsByName("prpLclaimPolicyNo_"+indexOfRegist);
                 PolicyBzNo = elePrpLclaimPolicyNo[0].value;
             }catch(ex2){
              	  
             }
             
             try{
	               if(fm.prpLclaimLossAcciName[findex].value==null||(fm.prpLclaimLossAcciName[findex].value).length<1){
			               errorMessage("������"+fm.prpLclaimLossAcciName[findex].title);
			               inquery = false;
			               return false;
	               }
               }catch(ex3){
               }
               var strFamilyNO = "";
               //��������ȡ��familyno
               try{
                   var count = getElementCount("prpLclaimAcciPersonFamilyNo_"+indexOfRegist);
                   var elePrpLclaimAcciPersonFamilyNo = document.getElementsByName("prpLclaimAcciPersonFamilyNo_"+indexOfRegist);
                   if(count==1){
                       strFamilyNO = elePrpLclaimAcciPersonFamilyNo[0].value;
                   }else{
                       strFamilyNO = elePrpLclaimAcciPersonFamilyNo[findex].value;
                   }

               }catch(ex4){
               
               }
               
                //���黷��ȡ��familyno
               try{
                   var count = getElementCount("prpLpropFamilyNo_"+indexOfRegist);
                   if(count==1){
                       strFamilyNO = fm.prpLpropFamilyNo.value;
                   }else{
                       strFamilyNO = fm.prpLpropFamilyNo[findex].value;
                   }
                   
               }catch(ex4){
               
               }


               //�⽡�����㻷��ȡ��familyno
               try{

		               var count = getElementCount("prpLpersonLossFamilyNo_"+indexOfRegist);
		               if(count==1){
		                   strFamilyNO = fm.prpLpersonLossFamilyNo.value;
		               }else{
				               var familyindex = fm.personLossSerialNo[findex].value;
				               strFamilyNO = fm.prpLpersonLossFamilyNo[familyindex-1].value;
		               }
               }catch(ex5){
               }
                //ũ�����㻷��ȡ��familyno
               try{
                   var count = getElementCount("prpLlossDtoFamilyNo_"+indexOfRegist);
                   if(count==1){
                       strFamilyNO = fm.prpLlossDtoFamilyNo.value;
                   }else{
                       var familyindex = fm.prpLlossSerialNo[findex].value;
                       strFamilyNO = fm.prpLlossDtoFamilyNo[familyindex].value;
                   }
               }catch(ex6){
               }
               
            
           	var eleDamageStartDate = document.getElementsByName("damageStartDate_"+indexOfRegist);
           	fmcode.damageStartDate.value = eleDamageStartDate[0].value;
             
             fmcode.codevalue.value = field.value+"|"+PolicyBzNo+"|"+strFamilyNO;
              
        }
        if(codetype=="PolicyItemCode2")
        {
             
             var fieldname=field.name;
             var i = 0;
             var findex=0;
             var startDate = fm.damageStartDate.value;
             for(i=1;i<fm.all(fieldname).length;i++)
             {
                 if( fm.all(fieldname)[i] == field)
                 {
                    findex=i;
                    break;
                 }
             }
             fmcode.other.value = fm.prpLclaimLossKindCode[getElementOrder(field)-1].value;
             fmcode.codevalue.value = fm.prpLclaimLossKindCode[findex].value+"|"+field.value +"|"+startDate+"|"+fm.prpLclaimLossAcciName[findex].value;
        }
        //Modify by chenrenda end 20070629
        
        //��ѯ�����Ϣ  by sunny
        if(codetype=="PolicyItemKindCode")
        {
             var fieldname=field.name;
             var i = 0;
             var findex=0;
             var startDate = fm.damageStartDate.value;
             for(i=1;i<fm.all(fieldname).length;i++)
             {
                 if( fm.all(fieldname)[i] == field )
                 {
                    findex=i;
                    break;
                 }
             }

          fmcode.codevalue.value = fm.prpLlossDtoKindCode[findex].value+"|"+field.value +"|"+startDate ;
        }
         //��ѯ�����Ϣ(���ձ��޹�)
        if(codetype=="PolicyItemKindCodeNoRisk")
        {
             var fieldname=field.name;
             var startDate = fm.damageStartDate.value;
  
             for(i=1;i<fm.all(fieldname).length;i++)
             {
                 if( fm.all(fieldname)[i] == field )
                 {
                    findex=i;
                    break;
                 }
             }
          fmcode.codevalue.value = field.value +"|"+startDate ;
        }            
        
        
        
        //����ԭ��  by sunny
        if(codetype=="DamageCode")
        {
          try{
                 if(fm.all("theMain").length>0){
                     var theMain = fm.theMain.value;
                     fmcode.codevalue.value = fm.theMain.value+"|"+field.value;
                 }
             }
          catch(ex2)
             {
                 fmcode.codevalue.value = "wang"+"|"+field.value;
             }
        }
        
        if(codetype=="PolicyItemKindCode1")
        {
             var fieldname=field.name;
             var i = 0;
             var findex=0;
             var startDate = fm.damageStartDate.value;
             for(i=1;i<fm.all(fieldname).length;i++)
             {
                 if( fm.all(fieldname)[i] == field )
                 {
                    findex=i;
                    break;
                 }
             }
             fmcode.codevalue.value = fm.prpLpersonLossKindCode[findex].value+"|"+field.value+"|"+startDate ;
        }
        if(codetype=="PolicyKindCodeOfPerson")
        {
             var fieldname=field.name;
             var i = 0;
             var findex=0;
             for(i=1;i<fm.all(fieldname).length;i++)
             {
                 if( fm.all(fieldname)[i] == field )
                 {
                    findex=i;
                    break;
                 }
             }
             var familyindex = fm.personLossSerialNo[findex].value;
             
             var count = getElementCount("prpLpersonLossFamilyNo");
             if(count==1){
                fmcode.codevalue.value = fm.familyNo.value+"|"+field.value;  
             }else{
                fmcode.codevalue.value = fm.familyNo[familyindex-1].value+"|"+field.value;
             }
        }
        if(codetype=="PolicyKindCodeOfAgri")
        {
             var fieldname=field.name;
             var i = 0;
             var findex=0;
             for(i=1;i<fm.all(fieldname).length;i++)
             {
                 if( fm.all(fieldname)[i] == field )
                 {
                    findex=i;
                    break;
                 }
             }
             var familyindex = fm.prpLlossSerialNo[findex].value;
             var familyCount = getElementCount("prpLlossDtoFamilyNo");
             var modelCount = getElementCount("prpLlossDtoLicenseNo");
             if(familyCount==1){
                fmcode.codevalue.value = fm.prpLlossDtoFamilyNo.value+"|"+field.value+"|"+fm.prpLlossDtoLicenseNo.value;  
             }else{
                fmcode.codevalue.value = fm.prpLlossDtoFamilyNo[familyindex].value+"|"+field.value+"|"+fm.prpLlossDtoLicenseNo[familyindex].value;
             }
             
        }
        if(codetype=="PolicyKindCodeForPerson")
        {
        	    var PolicyBzNo = "";
              try{
                  PolicyBzNo = fm.prplCheckPolicyBzNoShow.value;
              }catch(ex2){
              	  
              }
             fmcode.codevalue.value = PolicyBzNo +"|"+field.value;
        }
        if(codetype=="PolicyKindCodeForProp")
        {
              var PolicyBzNo = "";
              try{
                  PolicyBzNo = fm.prplCheckPolicyBzNoShow.value;
              }catch(ex2){
              	  
              }
             fmcode.codevalue.value = PolicyBzNo +"|"+field.value;
        }
        
        if(codetype=="ChargeCode")
        {
        	   //add by lixiang start at 20051226
        	   //reason:�����Ϊnull�������
        	   if (fm.prpLchargeSerialNo != null && fm.prpLchargeSerialNo.value!=null){
          	   //add by lixiang end at 20051226
               fmcode.codevalue.value = fm.prpLchargeSerialNo.value+"|"+field.value;
             }
             else {
               fmcode.codevalue.value = field.value;
             }
        }
        if(codetype=="PrpDliab")
        {
             var fieldname=field.name;
             var i = 0;
             var findex=0;
             for(i=1;i<fm.all(fieldname).length;i++)
             {
                 if( fm.all(fieldname)[i] == field )
                 {
                    findex=i;
                    break;
                 }
             }
             var serialNo = fm.personLossSerialNo[findex].value;
             fmcode.codevalue.value = fm.prpLpersonLossKindCode[serialNo].value+"|"+field.value;
             
        }
        
        if(codetype=="PayObject")
        {
             var fieldname=field.name;
             var i = 0;
             var findex=0;
             for(i=1;i<fm.all(fieldname).length;i++)
             {
                 if( fm.all(fieldname)[i] == field )
                 {
                    findex=i;
                    break;
                 }
             }
             var serialNo = fm.prpLchargePayObjectType[findex].value;
             fmcode.codevalue.value = serialNo+"|"+field.value;
             //alert(serailNo+fmcode.codevalue.value)
        }
        if(codetype=="frameType")
        {
             fmcode.codevalue.value = fm.prpLregistExtRegistNo.value;
        }
        window.status = "�ύmethod"+ method;
        fmcode.submit();
                                                                       //�ύ
    }
    catch(E){
        if(DEBUG_MODE==true){
            parent.document.all.fraCode.src="/claim/common/pub/InputCode.jsp";
            window.status="��ѯ����,��������......";
            setInquery(false);
        }
    }
}


function code_CodeSelectClaim(field,codetype,relation,inputtype,querytype,limit,indexOfRegist){
    if(!isInquery() && !isQueryError()){
        window.status="";
    }
	if(event.type == "keyup")
	{
        var charCode=window.event.keyCode;
        if(!(charCode==13 && window.event.ctrlKey)){
            return;
        }
	}
    window.status=window.status+"select";
    
    private_Code_CallServiceClaim(field,codetype,relation,inputtype,querytype,limit,"select",indexOfRegist);
    
}

function code_CodeChangeClaim(field,codetype,relation,inputtype,querytype,limit,method){
    if(!isInquery() && !isQueryError()){
        window.status="";
    }

    if(field.tag==field.value){
        return;
    }
    window.status=window.status+"change";
    private_Code_CallService(field,codetype,relation,inputtype,querytype,limit,"change");
}
function open_CodeSelectClaim(field,codeType,provinceCode,treeTitle){
	var elements = fm.elements;
	var index = 0;
	for(var i = 0;i < elements.length;i++){
		if(elements[i] == field){
			index = i; 
			break;
		}
	}
	var strUrl = "/claim/common/pub/CodeTree.jsp?";
	strUrl += "provinceCode=" + provinceCode;
	strUrl += "&treeTitle=" + treeTitle;
	strUrl += "&codeType=" + codeType;
	var result = window.showModalDialog(strUrl,'selectWindow','DialogWidth=260px;DialogHeight=350px;help=no;status=no');
	if(typeof(result) != 'undefined' && result != null && result != ""){
		var temp = result.split("#");
		fm.elements[i - 1].value = temp[0];
		field.value = temp[1];
	}
}

