/*****************************************************************************
 * DESC       �����������̲�ѯJS
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-09-10
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/
//---------------------------------------------------------------
//����ȫ�ֱ���
//---------------------------------------------------------------
/**
 *@description ������ΪDAAʱ��ʾ���ƺ�
 *@param       field
 *@return      ͨ������true,���򷵻�false
 */
 function showLicenseNo(field)
 {
 	var riskCode = trim(field.value);
 	
 	if(riskCode=="DAA")
 	{
 		
 		fm.prpLregistLicenseNo.value = "" ;
 		fm.prpLregistLicenseNo.style.borderTop = "#4196BF 1px solid";
    	fm.prpLregistLicenseNo.style.borderBottom = "#4196BF 1px solid";
    	fm.prpLregistLicenseNo.style.borderRight= "#4196BF 1px solid";
    	fm.prpLregistLicenseNo.style.borderLeft= "#4196BF 1px solid" ;
    	fm.prpLregistLicenseNo.style.width="80%";
    	fm.prpLregistLicenseNo.style.color = "#ffffff";
    	fm.prpLregistLicenseNo.style.backgroundColor = "#ffffff";
 		fm.prpLregistLicenseNo.readOnly = false;
 	}
    else
    {
    	fm.prpLregistLicenseNo.style.fontSize="9pt";
    	fm.prpLregistLicenseNo.style.borderTop = "none";
    	fm.prpLregistLicenseNo.style.borderBottom = "none";
    	fm.prpLregistLicenseNo.style.borderRight= "none";
    	fm.prpLregistLicenseNo.style.borderLeft = "none" ;
    	fm.prpLregistLicenseNo.style.width="80%";
    	fm.prpLregistLicenseNo.style.color = "#000000";
    	fm.prpLregistLicenseNo.style.backgroundColor = "#F4F9FF";
    	//fm.prpLregistLicenseNo.style= "FONT-SIZE: 9pt; BORDER-TOP: none; BORDER-BOTTOM: none;BORDER-RIGHT-STYLE: none;BORDER-LEFT-STYLE: none;WIDTH: 100%;COLOR: #000000;BACKGROUND-COLOR: #F4F9FF";
    	fm.prpLregistLicenseNo.value = "" ;
 		fm.prpLregistLicenseNo.readOnly = true;
    }		
	return true;
  }
  
 function buildRiskCodeSelect(riskCategoryField, riskCodeField)
 {
    var categoryValue = riskCategoryField.value;
    riskCodeField.length = 0;
    riskCodeField.options[0] = new Option("", "");
    for(var i=0; i<riskCodeCount; i++)
    {
        if(riskCodes[i][0] == categoryValue)
        {
            riskCodeField.options[riskCodeField.length] = new Option(riskCodes[i][2], riskCodes[i][1]);
        }
    }
    riskCodeField.remove(0);
 }
 
 /**
  *@desc ͨ����ѯ�����������š������ţ��Զ�ѡ�����ִ���
  *@pagem field
  */
 function changeRiskCode(field){
    var fieldValue = field.value;
    if(fieldValue.length < 5){
        return false;
    }
    var riskcode = field.value.substring(1,5);
    var riskInfo = null;
    for(var i = 0; i < riskCodes.length; i ++){
        if(riskCodes[i][1] == riskcode){
            riskInfo = riskCodes[i];
        }
    }
    if(riskInfo == null){
        return false;
    }
    var riskCategory = fm.riskCategory;
    for(var i=0; i<riskCategory.length; i++){
        if(riskCategory.item(i).value==riskInfo[0]){
            riskCategory.item(i).selected = true;
        }
    }
    fm.riskCategory.onchange();
    var riskCodeField = fm.prpLregistRiskCode;
    for(var i=0; i<riskCodeField.length; i++){
        if(riskCodeField.item(i).value==riskInfo[1]){
            riskCodeField.item(i).selected = true;
        }
    }
 }
 
 /**
  *@desc ��ѯ����¼�복�ƺ�ʱ�Զ�ѡ�����ִ��ࣨ���գ�
  *@param field
  */
 function changeRiskGategory(field){
    var fieldValue = field.value;
    if(fieldValue.length == 0 || fm.riskCategory.value == "D"){
        return false;
    }
    var riskCategory = fm.riskCategory;
    for(var i=0; i<riskCategory.length; i++){
        if(riskCategory.item(i).value == "D"){
            riskCategory.item(i).selected = true;
        }
    }
    fm.riskCategory.onchange();
 } 
  
    function submitForm()
    {
      if(fm.caseType[0].checked != true && fm.prpLregistRiskCode.value == "" ){
            alert("���ֲ���Ϊ�գ�");
            return false;
      }
      fm.backButton.disabled=true;
      fm.submit();//�ύ
      setTimeout('fm.backButton.disabled=false',5000);
    }