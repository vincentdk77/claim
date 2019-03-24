/**
 * ����¼��--ƽ̨��������ƣ���Ŀ�鲻���޸ģ��������Ը�
 * ��������������������֪ͨ�ṩ��
 * �������û����private��ͷ,�򷽷��ǹ�����,�ұ�֤������.
 * ���¼ӵķ����������
 */
var inCodeQuery = false;  //�����ѯ��ʱ��������ѯ��onchange
var FIELD_SEPARATOR = "_FIELD_SEPARATOR_";   //�ֶ�֮��ķָ��
/**
 * �������������otherCondition
 * @param key key
 * @param value value
 */
function addCondition(key,value){
    var retValue = key + "=" + value;
    return retValue;
}
/**
 * ׼��ѡ�����,������¼������
 * @param field ��������
 * @param codeType ��������
 * @param codeRelation ��ظ�ֵ��ƫ��������","�ָ�
 * @param isClear �鲻������ʱ�Ƿ���������
 * @param otherCondition ��������(key=value,key=value)��ʽ
 * @param callBackMethod ִ�����ص��ķ���
 * @param getDataMethod ȡֵ��������codeTypeΪcustomʱȡ�����ã��ݲ�֧��)
 */
function code_CodeSelect(field,codeType,codeRelation,isClear,otherCondition,callBackMethod,getDataMethod){

    if(event.type=="keyup"){
        var charCode=window.event.keyCode;
        if(!(charCode==13 & window.event.ctrlKey)){
            return;
        }
    }
    inCodeQuery=true;
    var cf=document.all.CodeFrame;
    cf.style.display="";
    field.style.display="none";
    private_Code_CallService(field,"select",codeType,codeRelation,isClear,otherCondition,callBackMethod,getDataMethod);
    field.style.display="";
    inCodeQuery=false;
}

/**
 * ׼����ѯ����,�����ڲ�ѯ��,�ɶ�ѡ
 * @param field ��������
 * @param codeType ��������
 * @param codeRelation ��ظ�ֵ��ƫ��������","�ָ�
 * @param isClear �鲻������ʱ�Ƿ���������
 * @param otherCondition ��������(key=value,key=value)��ʽ
 * @param callBackMethod ִ�����ص��ķ���
 * @param getDataMethod ȡֵ��������codeTypeΪcustomʱȡ�����ã��ݲ�֧��)
 */
function code_CodeQuery(field,codeType,codeRelation,isClear,otherCondition,callBackMethod,getDataMethod){
	
    if(event.type=="keyup"){
        var charCode=window.event.keyCode;
        if(!(charCode==13 & window.event.ctrlKey)){
            return;
        }
    }
    inCodeQuery=true;
    var cf=document.all.CodeFrame;
    cf.style.display="";
    field.style.display="none";
    private_Code_CallService(field,"query",codeType,codeRelation,isClear,otherCondition,callBackMethod,getDataMethod);
    field.style.display="";
    inCodeQuery=false;
}

/**
 * �ı����¼�����ֵʱ�Ĳ���
 * @param field ��������
 * @param codeType ��������
 * @param codeRelation ��ظ�ֵ��ƫ��������","�ָ�
 * @param isClear �鲻������ʱ�Ƿ���������
 * @param otherCondition ��������(key=value,key=value)��ʽ
 * @param callBackMethod ִ�����ص��ķ���
 * @param getDataMethod �ص���������codeTypeΪcustomʱȡ�ص����������ݣ��ݲ�֧��)
 */
function code_CodeChange(field,codeType,codeRelation,isClear,otherCondition,callBackMethod,getDataMethod){
    if(inCodeQuery==true){
        return;
    }
    var cf=document.all.CodeFrame;

    field.style.display="none";
    cf.style.display="none";

    private_Code_CallService(field,"change",codeType,codeRelation,isClear,otherCondition,callBackMethod,getDataMethod);
    field.style.display="";
}

/**
 * ���÷������
 */
function private_Code_CallService(field,codeMethod,codeType,codeRelation,isClear,otherCondition,callBackMethod,getDataMethod){
    var cf=document.all.CodeFrame;
	var eL=0;var eT=0;var p=field;
    while(p&&p.tagName!="BODY"){
        eT+=p.offsetTop;
        eL+=p.offsetLeft;
        p=p.offsetParent;
    }
    cf.style.top = eT-field.offsetTop;
    cf.style.left = eL;
    var fieldIndex = getElementIndexInForm(fm,field);
    var fieldValue = field.value;
    if(fieldValue!=null){
        fieldValue=fieldValue.replace("*","%");  //ת��ͨ���
    }

    //�����
    var relations = new Array();
    if(codeRelation.indexOf(",")>-1){
    	relations = codeRelation.split(",");
    }else{
    	relations[0]=codeRelation;
  	}
    //���isClearΪY,����������
    if(isClear=="Y"){
        var relationsCount = relations.length;
        for(var i=0;i<relationsCount;i++){
            try{
                field.form.elements[fieldIndex + parseInt(relations[i],10)].value ="";
            }catch(E){
            }
        }
    }
    document.CodeFrame.codeQuery(fieldIndex,fieldValue,codeMethod,codeType,codeRelation,isClear,otherCondition,callBackMethod,getDataMethod);
}

/**
 * ����ȷ����ťʱ�Ĳ���
 */
function setFieldValue(){
    var cf=parent.document.all.CodeFrame;
    cf.style.display="none";
    //�����
    var relations = new Array();
    if(fm.codeRelation.value.indexOf(",")>-1){
    	relations = fm.codeRelation.value.split(",");
    }else{
    	relations[0]=fm.codeRelation.value;
  	}
    var fieldIndex = parseInt(fm.fieldIndex.value,10);
    var value="";

    //���codeMethodΪchange
    if(fm.codeMethod.value=="change"){
        if(fm.codeselect.options.length==1){
            fm.codeselect.selectedIndex=0;
        }
        if(fm.codeselect.options.length==0){
            if(fm.isClear.value=="Y"){
                var relationsCount = relations.length;
                for(var i=0;i<relationsCount;i++){
                    parent.document.fm.elements[fieldIndex + parseInt(relations[i],10)].value ="";
                }
            }
            if(fm.callBackMethod.value!=""){
				        eval("parent." +fm.callBackMethod.value);
				    }
            return;//�鲻������ʱ����
        }
    }

    if(fm.codeselect.selectedIndex<0){
    	  cf.style.display="";
        //showMessage("��ѡ�����");
		alert("��ѡ�����");
        fm.codeselect.selectedIndex=0;
        return false;
    }
    
    if(fm.codeMethod.value=="query"){ //query���������ѡ
        //ȡֵ
        var rowValues = new Array();
        var values = new Array();
        var selectedCount=0; //ѡ�еĴ���ĸ���
        for (var i=0; i<fm.codeselect.length; i++){
            if(fm.codeselect.options[i].selected==true){
                rowValues = new Array();
               var selectedValue = fm.codeselect.options[i].value;
                if(selectedValue.indexOf(FIELD_SEPARATOR)>-1){
            	    rowValues = selectedValue.split(FIELD_SEPARATOR);
                }else{
                	rowValues[0]=selectedValue;
              	}
              	values[selectedCount++]=rowValues;
            }
        }
      	//��ֵ
      	var relationsCount = relations.length;
        for(var i=0;i<relationsCount;i++){
            value=values[0][i];
            for (var j=1; j<selectedCount; j++){
                if(i>=values.length){
                    value=value+","+values[j][values.length-1];
                }else{
                    value=value+","+values[j][i];
                }
            }
            parent.document.fm.elements[fieldIndex + parseInt(relations[i],10)].value=value;
        }
    }
    else{//��query������ֻ����ѡ
        //ȡֵ
        var values = new Array();
        if(fm.codeselect.value.indexOf(FIELD_SEPARATOR)>-1){
        	values = fm.codeselect.value.split(FIELD_SEPARATOR);
        }else{
        	values[0]=fm.codeselect.value;
      	}
      	//��ֵ
      	var relationsCount = relations.length;
        for(var i=0;i<relationsCount;i++){
            if(i>=values.length){
      	        value=values[values.length-1];
            }else{
                value=values[i];
            }
            parent.document.fm.elements[fieldIndex + parseInt(relations[i],10)].value=value;
        }
    }

    if(fm.callBackMethod.value!=""){
        eval("parent." +fm.callBackMethod.value);
    }
    try{
        parent.document.fm.elements[fieldIndex].focus();
        cf.src="/claim/common/pub/QueryCodeInputOverview.jsp";
    }catch(E){
    	 cf.src="/claim/common/pub/QueryCodeInputOverview.jsp";
    	}
}

/**
 * ����ȡ����ťʱ�Ĳ���
 */
function cancelFieldValue(){
    //���isClear����Y����������
    if(fm.isClear.value=="Y"){
        var relations = new Array();
        if(fm.codeRelation.value.indexOf(",")>-1){
        	relations = fm.codeRelation.value.split(",");
        }else{
        	relations[0]=fm.codeRelation.value;
      	}

        var fieldIndex = parseInt(fm.fieldIndex.value,10);
        var relationsCount = relations.length;
        for(var i=0;i<relationsCount;i++){
            parent.document.fm.elements[fieldIndex + parseInt(relations[i],10)].value="";
        }
    }
    var cf=parent.document.all.CodeFrame;
    cf.style.display="none";
 
 
    //alert(cf.src)
    cf.src="/claim/common/pub/QueryCodeInputOverview.jsp";
    if(fm.callBackMethod.value!=""){
        eval("parent." +fm.callBackMethod.value);
    }
    
    try{
        parent.document.fm.elements[fieldIndex].focus();
    }catch(E){}
}

/**
 * ����ʱ�Ĳ���
 */
function fieldOnKeyPress(){
    var charCode=window.event.keyCode;
    if(charCode==13){
        setFieldValue();
    }
    else if(charCode==32){
        cancelFieldValue();
    }
}

function getElementIndexInForm(form,field)
{
  var intElementIndex = -1;
  var elementsCount = form.elements.length;
  for(var i=0;i<elementsCount;i++) //����fm���Ԫ��
  {
    if(form.elements[i]==field)
    {
      intElementIndex=i;
      break;
    }
  }
  return intElementIndex;
}

function setFocus(field){
    if (field.type != "hidden"){
        try{
            field.focus();
        }catch(E){}
    }
}