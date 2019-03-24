/****************************************************************************
 * DESC       ������У��JavaScript(����IE5/NN6)--ƽ̨��������ƣ���Ŀ�鲻���޸ģ��������Ը�
 *              ��������������������֪ͨ�ṩ��      
 * ������   :2004-08-17          
 * AUTHOR     ��zhouxianli@sinosoft.com.cn
 *          ------------------------------------------------------
 *
 ************************************************************************************/

 /**
    �ṹΪ �ֶ������ֶ�������ԭʼ���ͣ��Ƿ�����Ϊ��
           4��Ǳ����
 */
var mulLineDataFields = new Array(); //��ʱ�洢Form�ж���Data�ֶε�����
var skipFieldPrefixs = new Array(); //��ʱ�洢Form���������ֶ�ǰ׺������
// modify by weishixin remark begin 20040820 
// reason:�˴����½���У��ʧ�ܣ���ʱע��
//var schemaColumns = new Array(); //�洢�ֶνṹ������

//
////��ʼ������
//var private_columnIndex = 0; //���
///**
// * ���SchemaColumn
// */
//function addSchemaColumn(schemaColumn){
//    if(schemaColumns[schemaColumn.name]==null){
//    	schemaColumns[schemaColumn.name]=schemaColumn;
//    }
//}
//
///**
// * schemaColumn����
// */
//function schemaColumn(name,desc,dataType,allowNulls)
//{
//    this.name = name;
//    this.desc = desc;
//    this.dataType = dataType;
//    this.allowNulls = allowNulls;
//}
///**
// * �õ�SchemaColumn
// * @param name SchemaColumn��name����
// * @return �鵽����SchemaColumn,���򷵻�null
// */
// function getSchemaColumn(name)
// {
// 		if(isSkipFieldName(name)){
// 				return null;
// 		}
//     return schemaColumns[name];
// }
//  modify by weishixin remark end 20040820 


/**
 * ��ʼ������������
 * mulLineTableIdList �Զ���Ϊ�ָ����ϵĶ�����������ID
 */
function initCombineMulLineFields(mulLineTableIdList){
    mulLineDataFields = new Array();
    if(mulLineTableIdList==null || mulLineTableIdList==""){
        return;
    }
    var tableIdArray = new Array();                   
    if(mulLineTableIdList.indexOf(",")>-1){
    	tableIdArray = mulLineTableIdList.split(",");
    }else{
    	tableIdArray[0]=mulLineTableIdList;
  	}
    	
    var index = 0;
    for(var i=0;i<tableIdArray.length;i++)
    {
        var elements=new Array();
        elements=getTableElements(tableIdArray[i]);
        for(var j=0;j<elements.length;j++){
            mulLineDataFields[index++]=elements[j];
        }
    }                
}


/**
 * ��ʼ�������ֶ�ǰ׺���б�
 * skipFieldPrefixsList �Զ���Ϊ�ָ����ϵ������ֶ�ǰ׺���б�
 */
function initCombineSkipFieldPrefixs(skipFieldPrefixsList){
    skipFieldPrefixs = new Array();
    if(skipFieldPrefixsList==null || skipFieldPrefixsList==""){
        return;
    }

    var skipFieldNameArray = new Array();                   
    if(skipFieldPrefixsList.indexOf(",")>-1){
    	skipFieldNameArray = skipFieldPrefixsList.split(",");
    }else{
    	skipFieldNameArray[0]=skipFieldPrefixsList;
  	}

    var index = 0;
    for(var i=0;i<skipFieldNameArray.length;i++)
    {
       skipFieldPrefixs[index++]=skipFieldNameArray[i];
    }                
}

/**
 * �Ƿ��Ƕ���������
 * @param field Ԫ��
 * @return ���򷵻�true,���򷵻�false
 */
function isMulLineField(field)
{
    for(var i=0;i<mulLineDataFields.length;i++){
        if(field==mulLineDataFields[i]){
            return true;
        }
    }
    return false;
}

/**
 * �Ƿ���������������֣����账��
 * @param name Ԫ������
 * @return ���򷵻�true,���򷵻�false
 */
function isSkipFieldName(name)
{
    for(var i=0;i<skipFieldPrefixs.length;i++){
        if(name.indexOf(skipFieldPrefixs[i])==0){
            return true;
        }
    }
    return false;
}

/**
 * ��֤����������(����struts����Ӧ����)
 * @param form form
 * @return �Ƿ���true,�񷵻�false
 */
function validateCombineRequired(form) {
        var bValid = true;
    var focusField = null;
    var field = null;
    var schemaColumn = null;
    var fields = new Array(); //���schemaColumns
    var count  = 0;
    
    var schemaColumns = getCombineSchemaColumn();
    var len1 = schemaColumns.length;
	for(var i=0;i<len1;i++){
		for(var j=0;j<getElementCount("combineRegistNo");j++){
		var elements = document.getElementsByName(schemaColumns[i].name+"_"+j);
		var len2 = elements.length;
		for(var k=0;k<len2;k++){
			 field = elements[k];
			 if (field.type == 'text' ||
	            field.type == 'file' ||
	            field.type == 'textarea' ||
	            field.type == 'select-one' ||
	            field.type == 'radio' ||
	            field.type == 'password') {

				//			            count = getElementCount(field.name);
				//			            //�������е�һ��
				//			            if((count>1 && getElementOrder(field)==1) ||
				//			                (count==1 && isMulLineField(field))){
				//			                continue;
				//			            }

	            if(isMulLineField(field)){
					if(isFirstElement(field)){        	
	                	continue;
	                }	
	            }

	            schemaColumn = getSchemaColumn(schemaColumns[i].name);

	            if(schemaColumn==null){
	                log("�ֶ�" + field.name + "û����ValidateData.js�ж���");
	                continue;
	            }
	            //��������Ϊ�յ�������
	            if(schemaColumn.allowNulls==true){
	                continue;
	            }

	            var value;
				// get field's value
				if (field.type == "select-one") {
					var si = field.selectedIndex;
					value = field.options[si].value;
				} else {
					value = field.value;
				}

	            if (value == '') {
	                if (focusField == null) {
	                    focusField = field;
	                }
	                fields[fields.length] = schemaColumn;
	                bValid = false;
	            }
	        }
		}
		}
	}
    

    if (fields.length>0) {
        var message = "";
        for(i=0;i<fields.length;i++)
        {
            message = message + fields[i].desc + "������Ϊ��\n";
        }
			  if (focusField.type != "hidden") {
				  try{
				     focusField.focus();
				  }catch(focusE){}
			  }
        alert(message);
    }
    return bValid;
}

/**
 * ����Ƿ��ǺϷ���varchar�����ֶ�
 * @param form form
 * @param schemaColumn schemaColumn
 * @return �Ƿ���true,�񷵻�false
 */
function isValidateVarcharField(field,schemaColumn){
    var maxLength  = 0;
    var minSpace  = 0;
    var temp = schemaColumn.dataType;
    var start = schemaColumn.dataType.indexOf("(",7);  //"("��λ��
    var middle = schemaColumn.dataType.indexOf(",",start); //","��λ��
    var end = schemaColumn.dataType.indexOf(")",start); //")"��λ��
    if(middle==-1){ //û��������Сֵ
        maxLength = parseInt(schemaColumn.dataType.substring(start+1,end),10);
        minSpace = 0;
    }
    else{
        maxLength = parseInt(schemaColumn.dataType.substring(start+1,middle),10);
        minSpace = parseInt(schemaColumn.dataType.substring(middle+1,end),10);
    }

    if (getByteLength(field.value) > maxLength) {
        return false;
    }
    if (getByteLength(field.value) < minSpace) {
        return false;
    }
    return true;
}

/**
 * ����Ƿ��ǺϷ���char�����ֶ�
 * @param form form
 * @param schemaColumn schemaColumn
 * @return �Ƿ���true,�񷵻�false
 */
function isValidateCharField(field,schemaColumn){
    var maxLength  = 0;
    var temp = schemaColumn.dataType;
    var start = schemaColumn.dataType.indexOf("(",4);//"("��λ��
    var end = schemaColumn.dataType.indexOf(")",start);//")"��λ��
    maxLength=parseInt(schemaColumn.dataType.substring(start+1,end),10);

    if (getByteLength(field.value) > maxLength) {
        return false;
    }
    return true;
}

/**
 * ����Ƿ��ǺϷ���Integer�����ֶ�
 * @param form form
 * @param schemaColumn schemaColumn
 * @return �Ƿ���true,�񷵻�false
 */
function isValidateIntegerField(field,schemaColumn)
{
  var strValue = field.value;
  if(strValue.length==0)
    return true;

  field.value = trim(field.value);
  var strValue=field.value;
  if(strValue=="")
    strValue = "0";
  field.value = strValue

  if (regExpTest(strValue,/[+|\-]?\d+/g)==false){
    return false;
  }

  var value = parseInt(strValue,10);

  if(isNaN(value) || value>MAX_INTEGER || value<MIN_INTEGER){
    return false;
  }
  return true;
}

/**
 * ����Ƿ��ǺϷ���SmallInt�����ֶ�
 * @param form form
 * @param schemaColumn schemaColumn
 * @return �Ƿ���true,�񷵻�false
 */
function isValidateSmallintField(field,schemaColumn)
{
    if(isValidateIntegerField(field,schemaColumn)==false){
        return false;
    }
    var strValue = field.value;
    var value = parseInt(strValue,10);
    if(value>MAX_SMALLINT || value<MIN_SMALLINT){
        return false;
    }
    return true;
}

/**
 * ����Ƿ���decimal�����ֶ�
 * @param form form
 * @param schemaColumn schemaColumn
 * @return �Ƿ���true,�񷵻�false
 */
function isValidateDecimalField(field,schemaColumn){
    var length  = 0;
    var scale  = 0;
    var temp = schemaColumn.dataType;
    var start = schemaColumn.dataType.indexOf("(");  //"("��λ��
    var middle = schemaColumn.dataType.indexOf(","); //","��λ��
    var end = schemaColumn.dataType.indexOf(")"); //")"��λ��
    if(middle==-1){ //û��������Сֵ
        length = parseInt(schemaColumn.dataType.substring(start+1,end),10);
        scale = 0;
    }
    else{
        length = parseInt(schemaColumn.dataType.substring(start+1,middle),10);
        scale = parseInt(schemaColumn.dataType.substring(middle+1,end),10);
    }
    field.value = trim(field.value);//ȥ��������ͷβ�ո�
    var strValue=field.value;
     if(strValue==""){
        strValue = "0";
    }
    field.value = strValue;

    if(regExpTest(strValue,/^[+|\-]?\d*[.]?\d*/g)==false){
        return false;
    }
    //��龫��
    middle = strValue.indexOf("."); //"."��λ��
    if(middle>-1){
        if(scale<strValue.substr(middle+1).length){
            return false;
        }
    }

    //�����󳤶�
    var addLength = 0;
    if(strValue.indexOf("+")>-1 ){
        addLength++;
    }
    if(strValue.indexOf("-")>-1){
        addLength++;
    }

    if(strValue.indexOf(".")==0){
        addLength--;
    }
    else if(strValue.indexOf(".")>0){
        addLength++;
    }

    if (getByteLength(strValue) > (length + addLength)) {
        return false;
    }

    return true;
}

/**
 * ����Ƿ��ǺϷ���date�����ֶ�
 * @param form form
 * @param schemaColumn schemaColumn
 * @return �Ƿ���true,�񷵻�false
 */
function isValidateDateField(field,schemaColumn)
{
    field.value = trim(field.value);
    var strValue = field.value;

    //�����ȫ����,��ת��Ϊ����������
    if (regExpTest(strValue,/\d+/g)==true){
        //ֻ����YYYYMMDD��ʽ
        if(getByteLength(strValue)!=8){
            return false;
        }
        strValue = strValue.substring(0,4) + DATE_DELIMITER +
                   strValue.substring(4,6) + DATE_DELIMITER +
                   strValue.substring(6);
    }
    field.value = strValue;
    if(getByteLength(strValue)==9){
        strValue=strValue.substring(0,8)+"0" + strValue.substring(8);
        field.value = strValue;
    }
    
    if(getByteLength(strValue)!=10 ||
            strValue.substring(4,5) != DATE_DELIMITER ||
            strValue.substring(7,8) != DATE_DELIMITER){
        return false;
    }

    var year = parseInt(strValue.substring(0,4),10);
    //modify by weishixin modify begin 20040825
    //reason:��������31ʱ����js���Ǵ�0-11
    var month = parseInt(strValue.substring(5,7),10)-1;
    //modify by weishixin modify end 20040825
    var date = parseInt(strValue.substring(8,10),10);

    var testDate = new Date(year,month,date);

    if(testDate.getFullYear()!=year ||testDate.getMonth()!=month ||testDate.getDate()!=date){
        return false;
    }

    return true;
}

/**
 * ����Ƿ��ǺϷ���datetime�����ֶ�
 * @param form form
 * @param schemaColumn schemaColumn
 * @return �Ƿ���true,�񷵻�false 
 */
function isValidateDateTimeField(field,schemaColumn)
{
	property = schemaColumn.dataType.toLowerCase();
	//������굽��,�����isValidateDateFieldУ��
	if(property=="datetime year to day"){
		return isValidateDateField(field,schemaColumn);
	}

    field.value = trim(field.value);
    var strValue = field.value;    
    
    if(property=="datetime year to year"){//���꿪ʼ
		var reg =new RegExp ("^(\\d+)$"); 
		var r = strValue.match(reg); 
		if(r==null)return false; 
		var d= new Date(r[1], 0,1 ); 
		if(d.getFullYear()!=r[1]) return false; 
    }else if(property=="datetime year to month"){
		var reg =new RegExp ("^(\\d+)" + DATE_DELIMITER + "(\\d{1,2})$"); 
		var r = strValue.match(reg); 
		if(r==null)return false; 
		r[2]=r[2]-1; 
		var d= new Date(r[1], r[2],1 ); 
		if(d.getFullYear()!=r[1]) return false; 
		if(d.getMonth()!=r[2])return false; 
    }else if(property=="datetime year to day"){
		var reg =new RegExp ("^(\\d+)" + DATE_DELIMITER + "(\\d{1,2})" + DATE_DELIMITER + "(\\d{1,2})$"); 
		var r = strValue.match(reg); 
		if(r==null)return false; 
		r[2]=r[2]-1; 
		var d= new Date(r[1], r[2],r[3] ); 		
		if(d.getFullYear()!=r[1]) return false; 
		if(d.getMonth()!=r[2])return false; 
        if(d.getDate()!=r[3])return false; 
    }else if(property=="datetime year to hour"){
		var reg =new RegExp ("^(\\d+)" + DATE_DELIMITER + "(\\d{1,2})" + DATE_DELIMITER + "(\\d{1,2}) (\\d{1,2})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        r[2]=r[2]-1; 
        var d= new Date(r[1], r[2],r[3], r[4],1,1); 
        if(d.getFullYear()!=r[1])return false; 
        if(d.getMonth()!=r[2])return false; 
        if(d.getDate()!=r[3])return false; 
        if(d.getHours()!=r[4])return false; 
    }else if(property=="datetime year to minute"){
		var reg =new RegExp ("^(\\d+)" + DATE_DELIMITER + "(\\d{1,2})" + DATE_DELIMITER + "(\\d{1,2}) (\\d{1,2}):(\\d{1,2})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        r[2]=r[2]-1; 
     	var d= new Date(r[1], r[2],r[3], r[4],r[5],1); 
        if(d.getFullYear()!=r[1])return false; 
        if(d.getMonth()!=r[2])return false; 
        if(d.getDate()!=r[3])return false; 
        if(d.getHours()!=r[4])return false; 
        if(d.getMinutes()!=r[5])return false; 
    }else if(property=="datetime year to second"){
		var reg =new RegExp ("^(\\d+)" + DATE_DELIMITER + "(\\d{1,2})" + DATE_DELIMITER + "(\\d{1,2}) (\\d{1,2}):(\\d{1,2}):(\\d{1,2})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        r[2]=r[2]-1; 
        var d= new Date(r[1], r[2],r[3], r[4],r[5], r[6]); 
        if(d.getFullYear()!=r[1])return false; 
        if(d.getMonth()!=r[2])return false; 
        if(d.getDate()!=r[3])return false; 
        if(d.getHours()!=r[4])return false; 
        if(d.getMinutes()!=r[5])return false; 
        if(d.getSeconds()!=r[6])return false; 
    }else if(property=="datetime year to millisecond"){
		var reg =new RegExp ("^(\\d+)" + DATE_DELIMITER + "(\\d{1,2})" + DATE_DELIMITER + "(\\d{1,2}) (\\d{1,2}):(\\d{1,2}):(\\d{1,2}).(\\d{1,3})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        r[2]=r[2]-1; 
        var d= new Date(r[1], r[2],r[3], r[4],r[5], r[6]); 
        if(d.getFullYear()!=r[1])return false; 
        if(d.getMonth()!=r[2])return false; 
        if(d.getDate()!=r[3])return false; 
        if(d.getHours()!=r[4])return false; 
        if(d.getMinutes()!=r[5])return false; 
        if(d.getSeconds()!=r[6])return false; 
    }else if(property=="datetime month to month"){ //���¿�ʼ
		var reg =new RegExp ("^(\\d{1,2})$"); 
		var r = strValue.match(reg); 
		if(r==null)return false; 
		r[1]=r[1]-1; 
		var d= new Date(2004, r[1],1 ); 
		if(d.getMonth()!=r[1])return false; 
    }else if(property=="datetime month to day"){
		var reg =new RegExp ("^(\\d{1,2})" + DATE_DELIMITER + "(\\d{1,2})$"); 
		var r = strValue.match(reg); 
		if(r==null)return false; 
		r[1]=r[1]-1; 
		var d= new Date(2004, r[1],r[2] ); 		
		if(d.getMonth()!=r[1])return false; 
        if(d.getDate()!=r[2])return false; 
    }else if(property=="datetime month to hour"){
		var reg =new RegExp ("^(\\d{1,2})" + DATE_DELIMITER + "(\\d{1,2}) (\\d{1,2})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        r[1]=r[1]-1; 
        var d= new Date(2004,r[1], r[2],r[3],1,1); 
        if(d.getMonth()!=r[1])return false; 
        if(d.getDate()!=r[2])return false; 
        if(d.getHours()!=r[3])return false; 
    }else if(property=="datetime month to minute"){
		var reg =new RegExp ("^(\\d{1,2})" + DATE_DELIMITER + "(\\d{1,2}) (\\d{1,2}):(\\d{1,2})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        r[1]=r[1]-1; 
     	var d= new Date(2004,r[1], r[2],r[3], r[4],1); 
        if(d.getMonth()!=r[1])return false; 
        if(d.getDate()!=r[2])return false; 
        if(d.getHours()!=r[3])return false; 
        if(d.getMinutes()!=r[4])return false; 
    }else if(property=="datetime month to second"){
		var reg =new RegExp ("^(\\d{1,2})" + DATE_DELIMITER + "(\\d{1,2}) (\\d{1,2}):(\\d{1,2}):(\\d{1,2})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        r[1]=r[1]-1; 
        var d= new Date(2004,r[1], r[2],r[3], r[4],r[5]); 
        if(d.getMonth()!=r[1])return false; 
        if(d.getDate()!=r[2])return false; 
        if(d.getHours()!=r[3])return false; 
        if(d.getMinutes()!=r[4])return false; 
        if(d.getSeconds()!=r[5])return false; 
    }else if(property=="datetime month to millisecond"){
		var reg =new RegExp ("^(\\d{1,2})" + DATE_DELIMITER + "(\\d{1,2}) (\\d{1,2}):(\\d{1,2}):(\\d{1,2}).(\\d{1,3})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        r[1]=r[1]-1; 
        var d= new Date(2004,r[1], r[2],r[3], r[4],r[5]); 
        if(d.getMonth()!=r[1])return false; 
        if(d.getDate()!=r[2])return false; 
        if(d.getHours()!=r[3])return false; 
        if(d.getMinutes()!=r[4])return false; 
        if(d.getSeconds()!=r[5])return false; 
    }else if(property=="datetime day to day"){ //���տ�ʼ
		var reg =new RegExp ("^(\\d{1,2})$"); 
		var r = strValue.match(reg); 
		if(r==null)return false;  
		var d= new Date(2004, 1,r[1] ); 		
        if(d.getDate()!=r[1])return false; 
    }else if(property=="datetime day to hour"){
		var reg =new RegExp ("^(\\d{1,2}) (\\d{1,2})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        var d= new Date(2004,1, r[1],r[2],1,1); 
        if(d.getDate()!=r[1])return false; 
        if(d.getHours()!=r[2])return false; 
    }else if(property=="datetime day to minute"){
		var reg =new RegExp ("^(\\d{1,2}) (\\d{1,2}):(\\d{1,2})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        var d= new Date(2004,1,r[1], r[2],r[3],1); 
        if(d.getDate()!=r[1])return false; 
        if(d.getHours()!=r[2])return false; 
        if(d.getMinutes()!=r[3])return false; 
    }else if(property=="datetime day to second"){
		var reg =new RegExp ("^(\\d{1,2}) (\\d{1,2}):(\\d{1,2}):(\\d{1,2})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        var d= new Date(2004,1,r[1], r[2],r[3], r[4]); 
        if(d.getDate()!=r[1])return false; 
        if(d.getHours()!=r[2])return false; 
        if(d.getMinutes()!=r[3])return false; 
        if(d.getSeconds()!=r[4])return false; 
    }else if(property=="datetime day to millisecond"){
		var reg =new RegExp ("^(\\d{1,2}) (\\d{1,2}):(\\d{1,2}):(\\d{1,2}).(\\d{1,3})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        var d= new Date(2004,1,r[1], r[2],r[3], r[4]); 
        if(d.getDate()!=r[1])return false; 
        if(d.getHours()!=r[2])return false; 
        if(d.getMinutes()!=r[3])return false; 
        if(d.getSeconds()!=r[4])return false; 
    }else if(property=="datetime hour to hour"){//��Сʱ��ʼ
		var reg =new RegExp ("^(\\d{1,2})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        var d= new Date(2004,1,1, r[1],1,1); 
        if(d.getHours()!=r[1])return false; 
    }else if(property=="datetime hour to minute"){
		var reg =new RegExp ("^(\\d{1,2}):(\\d{1,2})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        var d= new Date(2004,1,1,r[1], r[2],1); 
        if(d.getHours()!=r[1])return false; 
        if(d.getMinutes()!=r[2])return false; 
    }else if(property=="datetime hour to second"){
		var reg =new RegExp ("^(\\d{1,2}):(\\d{1,2}):(\\d{1,2})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        var d= new Date(2004,1,1,r[1], r[2],r[3]); 
        if(d.getHours()!=r[1])return false; 
        if(d.getMinutes()!=r[2])return false; 
        if(d.getSeconds()!=r[3])return false; 
    }else if(property=="datetime hour to millisecond"){
		var reg =new RegExp ("^(\\d{1,2}):(\\d{1,2}):(\\d{1,2}).(\\d{1,3})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        var d= new Date(2004,1,1,r[1], r[2],r[3]); 
        if(d.getHours()!=r[1])return false; 
        if(d.getMinutes()!=r[2])return false; 
        if(d.getSeconds()!=r[3])return false; 
    }else if(property=="datetime minute to minute"){//�ӷֿ�ʼ
		var reg =new RegExp ("^(\\d{1,2})$"); 
        var r = strValue.match(reg);  
        if(r==null)return false; 
        var d= new Date(2004,1,1,1,r[1],1); 
        if(d.getMinutes()!=r[1])return false; 
    }else if(property=="datetime minute to second"){
		var reg =new RegExp ("^(\\d{1,2}):(\\d{1,2})$"); 
        var r = strValue.match(reg);  
        if(r==null)return false; 
        var d= new Date(2004,1,1,1,r[1], r[2]); 
        if(d.getMinutes()!=r[1])return false; 
        if(d.getSeconds()!=r[2])return false; 
    }else if(property=="datetime minute to millisecond"){
		var reg =new RegExp ("^(\\d{1,2}):(\\d{1,2}).(\\d{1,3})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        var d= new Date(2004,1,1,1,r[1], r[2]); 
        if(d.getMinutes()!=r[1])return false; 
        if(d.getSeconds()!=r[2])return false; 
    }else if(property=="datetime second to second"){//���뿪ʼ
		var reg =new RegExp ("^(\\d{1,2})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        var d= new Date(2004,1,1,1,1, r[1]); 
        if(d.getSeconds()!=r[1])return false; 
    }else if(property=="datetime second to millisecond"){
		var reg =new RegExp ("^(\\d{1,2}).(\\d{1,3})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false; 
        var d= new Date(2004,1,1,1,1,r[1]); 
        if(d.getSeconds()!=r[1])return false; 
    }else if(property=="datetime millisecond to millisecond"){//�Ӻ��뿪ʼ
		var reg =new RegExp ("^(\\d{1,3})$"); 
        var r = strValue.match(reg); 
        if(r==null)return false;         
    }

    return true;
}

/**
 * ��֤�ֶ�����
 * @param form form
 * @return �Ƿ���true,�񷵻�false
 */
function validateCombineType(form) {
    var bValid = true;
    var bResult = true;
    var focusField = null;
    var i = 0;
    var field = null;
    var schemaColumn = null;
    var fields = new Array(); //���schemaColumns
    var count  = 0;
    var type = "";
    var property = "";
    var schemaColumns = getCombineSchemaColumn();
    var len1 = schemaColumns.length;
	for(var i=0;i<len1;i++){
		for(var j=0;j<getElementCount("combineRegistNo");j++){
		var elements = document.getElementsByName(schemaColumns[i].name+"_"+j);
		var len2 = elements.length;
		for(var k=0;k<len2;k++){
			 field = elements[k];
			 if (field.type == 'text' ||
	            field.type == 'password' ||
	            field.type == 'textarea') {

	            if(field.value==""){
	                continue;
	            }
		//			            count = getElementCount(field.name);
					//
		//			            //�������е�һ��
		//			            if((count>1 && getElementOrder(field)==1) ||
		//			                (count==1 && isMulLineField(field))){
		//			                continue;
		//			            }
				if(isMulLineField(field)){
					if(isFirstElement(field)){        	
	                	continue;
	                }	
	            }
				
	            schemaColumn = getSchemaColumn(schemaColumns[i].name);
	            if(schemaColumn==null){
	                log("�ֶ�" + field.name + "û����ValidateData.js�ж���");
	                continue;
	            }
	            property = schemaColumn.dataType.toLowerCase();

	            if (property=="text"){ //text��������У��
	                bResult = true;
	            }
	            else if (property==("byte")){//byte��������У��
	                bResult = true;
	            }
	            else if (property=="integer"){
	                bResult = isValidateIntegerField(field,schemaColumn);
	            }
	            else if (property=="smallint"){
	                bResult = isValidateSmallintField(field,schemaColumn);
	            }
	            else if (property=="date"){
	                bResult = isValidateDateField(field,schemaColumn);
	            }
	            else if (property.indexOf("datetime")!=-1){
	                bResult = isValidateDateTimeField(field,schemaColumn);
	            }
	            else if(property.indexOf("varchar")!=-1){
	                bResult = isValidateVarcharField(field,schemaColumn);
	            }
	            else if (property.indexOf("char")!=-1){
	                bResult = isValidateCharField(field,schemaColumn);
	            }
	            else if (property.indexOf("dec")!=-1){
	                bResult = isValidateDecimalField(field,schemaColumn);
	            }
	            else if (property.indexOf("float")!=-1){
	                bResult = isValidateDecimalField(field,schemaColumn);
	            }
	            else if (property.indexOf("number")!=-1){
	                bResult = isValidateDecimalField(field,schemaColumn);
	            }
	            else if (property.indexOf("numeric")!=-1){
	                bResult = isValidateDecimalField(field,schemaColumn);
	            }
	            else{
	                log("����:"+field.name+"����Ϊ" +property + ".��validateType��û�д���,����ϵ�ṩ��!");
	                bResult = true;
	            }

	            if(bResult==false){
	                if (focusField == null) {
	                    focusField = field;
	                }
	                fields[fields.length] = schemaColumn;
	                bValid = false;
	            }
			        }
				}
			}
		}


    if (fields.length>0) {
        var message = "";
        for(i=0;i<fields.length;i++)
        {
            var typeDesc = "";
            var maxLength  = 0;
            var minSpace  = 0;
            var start = 0;  //"("��λ��
            var middle = 0; //","��λ��
            var end = 0;    //")"��λ��
            field=fields[i];

            start = field.dataType.indexOf("(");  //"("��λ��
            middle = field.dataType.indexOf(","); //","��λ��
            end = field.dataType.indexOf(")"); //")"��λ��
            if(middle==-1){ //û��������Сֵ
                maxLength = parseInt(field.dataType.substring(start+1,end),10);
                minSpace = 0;
            }
            else{
                maxLength = parseInt(field.dataType.substring(start+1,middle),10);
                minSpace = parseInt(field.dataType.substring(middle+1,end),10);
            }

            property = field.dataType.toLowerCase();
            if (property=="integer"){
                typeDesc = "����";
//                typeDesc = typeDesc + "(���Ϊ" + MAX_INTEGER + ",��СΪ" + MIN_INTEGER + ")";
            }
            else if (property=="smallint"){
                typeDesc = "С����";
//                typeDesc = typeDesc + "(���Ϊ" + MAX_SMALLINT + ",��СΪ" + MIN_SMALLINT + ")";
            }
            else if (property=="date"){
                typeDesc = "����(��ʽΪYYYY" + DATE_DELIMITER + "MM" + DATE_DELIMITER + "DD)";
            }
            else if(property.indexOf("datetime")!=-1){
            	typeDesc = "����ʱ���ʽ(��ʽΪ" + trim(property.substring(8)) + ",�������ڷָ��Ϊ" + DATE_DELIMITER + ")";
            }
            else if(property.indexOf("varchar")!=-1){
                typeDesc = "�ַ���";
                typeDesc = typeDesc + "(��󳤶�Ϊ" + maxLength ;
                if (minSpace>0) {
                    typeDesc = typeDesc + ",��С����Ϊ" + minSpace ;
                }
                typeDesc = typeDesc + ")"
            }
            else if (property.indexOf("char")!=-1){
                typeDesc = "�ַ���";
                typeDesc = typeDesc + "(��󳤶�Ϊ" + maxLength ;
                if (minSpace>0) {
                    typeDesc = typeDesc + ",��С����Ϊ" + minSpace ;
                }
                typeDesc = typeDesc + ")"
            }
            else if (property.indexOf("dec")!=-1||property.indexOf("float")!=-1||property.indexOf("number")!=-1||property.indexOf("numeric")!=-1 ){
                typeDesc = "��ֵ";
                typeDesc = typeDesc + "(��Чλ��Ϊ" + maxLength ;
  //              alert(field.name );
                if (minSpace>0) {
                    typeDesc = typeDesc + ",����Ϊ" + minSpace ;
                }
                typeDesc = typeDesc + ")"
            }
            message = message + "\"" + field.desc + "\"������" + typeDesc + "\n";
        }

			  if (focusField.type != "hidden") {
				  try{
				     focusField.focus();
				  }catch(focusE){}
			  }
        alert(message);
    }
    return bValid;
}


/**
* Ĭ�ϵ�У��Form�ķ���
* @param form form
* @param mulLineTableIdList ���������������ҳ��table ID,����Ƕ�����м��ö��ŷָ���
* @param skipFieldPrefixs �ֶ�����������ǰ׺��������У�顣����Ƕ�����м��ö��ŷָ���
* @return ͨ��true/��ͨ��false
*/
function validateForm(form,mulLineTableIdList,skipFieldPrefixs)
{
   if(bCancel==true) {
     return true;
   }
//   if(!confirm("ȷ��Ҫ������Ϣ��")){
//     return false;
//   }

   initCombineMulLineFields(mulLineTableIdList);
   //������ʱ����initSkipFieldPrefixs(skipFieldPrefixs);

   return validateCombineRequired(form) && validateCombineType(form);
}

function getDataTypeMaxLength(dataType){
    var maxLength  = 0;
    var minSpace  = 0;
    var start = 0;  //"("��λ��
    var middle = 0; //","��λ��
    var end = 0;    //")"��λ��

    start = dataType.indexOf("(");  //"("��λ��
    middle = dataType.indexOf(","); //","��λ��
    end = dataType.indexOf(")"); //")"��λ��
    //����"("
    if(start>0){
        if(middle==-1){ //û��������Сֵ
            maxLength = parseInt(dataType.substring(start+1,end),10);
            minSpace = 0;
        }
        else{
            maxLength = parseInt(dataType.substring(start+1,middle),10);
            minSpace = parseInt(dataType.substring(middle+1,end),10);
        }
    }

    if (dataType=="integer"){
        maxLength=DB_INT_LENGTH;
    }
    else if (dataType=="smallint"){
        maxLength=DB_INT_LENGTH/4;
    }
    else if (dataType=="date"){
        maxLength=10;
    }
    return maxLength;
}

/**
 * ��ʼ������ҳ��ķ���
 * �������maxLenght����.
 */
function initCombinePage()
{
    var i=0;
    var j=0;
    var maxLength=0;
    var element;
    var schemaColumn;
    var method;
    var schemaColumns = getCombineSchemaColumn();
    var len1 = schemaColumns.length;
	for(i=0;i<len1;i++){
		for(j=0;j<getElementCount("combineRegistNo");j++){
		var elements = document.getElementsByName(schemaColumns[i].name+"_"+j);
		var len2 = elements.length;
		for(k=0;k<len2;k++){
	        element = elements[k];
	
	        if(element.name=="" || element.type == 'hidden'||element.type=='button'||element.type == 'select-one'||element.type=='submit')
	        {
	            continue;
	        }
	        schemaColumn = getSchemaColumn(schemaColumns[i].name);
	        if(schemaColumn==null){
	            log("�ֶ�" + element.name + "û����ValidateData.js�ж���");
	            continue;
	        }
	
	        //����maxLength
	        if (element.type == 'text' ||
	            element.type == 'textarea' ||
	            element.type == 'password') {
	
	            maxLength=getDataTypeMaxLength(schemaColumn.dataType);
	            if(maxLength>0){
	                element.maxLength=maxLength;
	            }
	        }
	        //���onkeypress�����¼�
	        method = null;
	        if(element.onkeypress!=null){
	          method = element.onkeypress;
	        }
	        element.onkeypress=keypressHandler;
	        if (method!=null){
	            eval("element.onkeypress.prototype." + schemaColumn.name + "=" + method);
	        } 
	        //���onblur�����¼�
	        //method = null;
	        //if(element.onblur!=null){
	        //  method = element.onblur;
	        //}
	        //element.onblur=blurHandler;
	        //if (method!=null){
	        //    eval("element.onblur.prototype." + element.name + "=" + method);
	        //}
			}
		}
    }
}
/**
 * ��ʼ������ҳ��ķ���
 * �������maxLenght����.
 */
function initCombineClaimPage()
{
    var i=0;
    var j=0;
    var maxLength=0;
    var element;
    var schemaColumn;
    var method;
    var schemaColumns = getCombineSchemaColumn();
    var len1 = schemaColumns.length;
	for(i=0;i<len1;i++){
		for(j=0;j<getElementCount("registNo");j++){
		var elements = document.getElementsByName(schemaColumns[i].name+"_"+j);
		var len2 = elements.length;
		for(k=0;k<len2;k++){
	        element = elements[k];
	
	        if(element.name=="" || element.type == 'hidden'||element.type=='button'||element.type == 'select-one'||element.type=='submit')
	        {
	            continue;
	        }
	        schemaColumn = getSchemaColumn(schemaColumns[i].name);
	        if(schemaColumn==null){
	            log("�ֶ�" + element.name + "û����ValidateData.js�ж���");
	            continue;
	        }
	
	        //����maxLength
	        if (element.type == 'text' ||
	            element.type == 'textarea' ||
	            element.type == 'password') {
	
	            maxLength=getDataTypeMaxLength(schemaColumn.dataType);
	            if(maxLength>0){
	                element.maxLength=maxLength;
	            }
	        }
	        //���onkeypress�����¼�
	        method = null;
	        if(element.onkeypress!=null){
	          method = element.onkeypress;
	        }
	        element.onkeypress=keypressHandler;
	        if (method!=null){
	            eval("element.onkeypress.prototype." + schemaColumn.name + "=" + method);
	        } 
	        //���onblur�����¼�
	        //method = null;
	        //if(element.onblur!=null){
	        //  method = element.onblur;
	        //}
	        //element.onblur=blurHandler;
	        //if (method!=null){
	        //    eval("element.onblur.prototype." + element.name + "=" + method);
	        //}
			}
		}
    }
}
function keypressHandler(evt)
{
	var charSplit = "_";
	var strValue = this.name.split(charSplit);
	var name;
	if(strValue.length>0){
		for(var i=0;i<strValue.length-1;i++){
			if(i==0)
				name = strValue[i];
			else 
				name = "_" + strValue[i]
		}
	}
	else  return false;
    var testValue;
    testValue = true;
    evt = (evt) ? evt : window.event;
    var schemaColumn = getSchemaColumn(name);
    if(schemaColumn==null){
        log("�ֶ�" + name + "û����ValidateData.js�ж���");
        testValue=true;
    }
    else{
        var dataType = schemaColumn.dataType.toLowerCase();
        if (dataType=="integer"){
            testValue=isValidateIntegerInput(evt);
        }
        else if (dataType=="smallint"){
            testValue=isValidateIntegerInput(evt);
        }
        else if (dataType=="date"){
            testValue=isValidateDateInput(evt);
        }
        else if(dataType.indexOf("varchar")!=-1){
            testValue=true;
        }
        else if (dataType.indexOf("char")!=-1){
            testValue=true;
        }
        else if (dataType.indexOf("dec")!=-1||dataType.indexOf("float")!=-1 ){
            testValue=isValidateDecimalInput(evt);
        }
        else{
        	log("����"+this.name+"����Ϊ" +dataType + ".��keypressHandler��û�д���");
            testValue=true;
        }
        if(testValue!=true){
            return false;
        }
    }

    try{
        var obj;
        obj = eval("this.onkeypress.prototype." + this.name );
        if(obj != null)
        {
            if(obj.apply(obj,arguments)==false){
                return false;
            }
        }
    }catch(E){
        log(E);
        testValue=false;
    }
    return testValue;
}
/**
 * �Ƿ��ǺϷ���decimal��������,��("0-9",".","+",'-")
 * �Ƿ���true,�񷵻�false.
 */
function isValidateDecimalInput(e)
{
    var value;
    if(isNetscape()){
        value=String.fromCharCode(e.charCode);
    }
    else{
        value=String.fromCharCode(e.keyCode);
    }
    if(regExpTest(value,/[+|\-|\.|0-9]{1}/)==true){
        return true;
    }
    else{
        return false;
    }
}

/**
 * �Ƿ��ǺϷ���integer��������,��("0-9","+",'-")
 * �Ƿ���true,�񷵻�false.
 */
function isValidateIntegerInput(e)
{
    var value;
    if(isNetscape()){
        value=String.fromCharCode(e.charCode);
    }
    else{
        value=String.fromCharCode(e.keyCode);
    }
    if(regExpTest(value,/[+|\-|0-9]{1}/)==true){
        return true;
    }
    else{
        return false;
    }
}

/**
 * �Ƿ��ǺϷ���date��������,��("0-9","/")
 * �Ƿ���true,�񷵻�false.
 */
function isValidateDateInput(e)
{
    var value;
    if(isNetscape()){
        value=String.fromCharCode(e.charCode);
    }
    else{
        value=String.fromCharCode(e.keyCode);
    }
    if(regExpTest(value,/[\/|0-9]| |-|:{1}/)==true){
        return true;
    }
    else{
        return false;
    }
}




function blurHandler(evt)
{    
	var testValue;
    testValue = true;
	var obj;
	evt = (evt) ? evt : window.event;
	obj = eval("window.customBlurHandler");
	if(obj != null)
	{
		//�Զ��巽��,����
		//  /**
	    //   * �����뿪ʱ����
		//   * @param field �����뿪��
	    //   * @return �����뿪����true�����򷵻�false
	    //   */
		//  function customBlurHandler(field){
		//  	return true;
		//  }		
		if(customBlurHandler(this)==false){ //�����Զ��巽��
            return false;
        }
	}

    try{        
        obj = eval("this.onblur.prototype." + this.name );
        if(obj != null)
        {
            if(obj.apply(obj,arguments)==false){
                return false;
            }
        }
    }catch(E){
        log(E);
        testValue=false;
    }
    return testValue;
}




// ʹ�÷���������ʾ
// <input name = "PolicyNo" maxlength="8" description="������"  onblur="checkLength(this)">
function checkLength(field)
{
  var str;
  var count  = 0;
  var value  = field.value;
  var length = field.maxLength;
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;

  if(value=="")
  {
    return true;
  }

  if(value.indexOf("^")>-1 ||
     value.indexOf(FIELD_SEPARATOR)>-1 ||
     value.indexOf(GROUP_SEPARATOR)>-1
    )
  {
    alert("^Ϊϵͳ�����ַ������������룡");
    field.focus();
    field.select();
    return false;
  }



  //���maxlength���Բ����ڣ��򷵻�
  if(isNaN(parseInt(length)))
    return true;

  for(var i=0;i<value.length;i++)
  {
    str = escape(value.charAt(i));
    if(str.substring(0,2)=="%u" && str.length==6)
      count = count + 2;
    else
      count = count + 1;
  }

  if(count>length)
  {
    alert(desc + "��������ݳ�����\n" + desc + "����󳤶�Ϊ" + length + "��Ӣ���ַ���\n���������룡");
    field.focus();
    field.select();
    return false;
  }
  return true;
}

//������������Ϊ��
// ʹ�÷���������ʾ
// <input name = "PolicyNo" maxlength="8" description="������"  onblur="checkNull(this)">
function checkNull(field)
{
  if(!hasValue(field))
  {
    alert("����Ϊ��");
    return false;
  }
}

//����
function hasValue(field)
{
  if(field.value=="")
    return false;
  else
    return true;
}
function clearSpace(field){
	var str = field.value;
	if(str != ""){
		field.value = str.replace(/ /g,""); 
	}
}
/**
*�ݴ��������
*/
function giveupCombineTemporarySave(nodeType){

	if(!confirm("ȷ��Ҫ�����ݴ�����")){
     return false;
   	}
  if(nodeType=="check"){
     fm.action="/claim/checkCombineBeforeEdit.do?editType=giveupTemporarySave";
  }
  if(nodeType=="certa"){
     fm.action="/claim/certainLossCombineBeforeEdit.do?editType=giveupTemporarySave";
  }
  fm.submit();
     
	}