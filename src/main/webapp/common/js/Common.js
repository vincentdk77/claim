/**
 * ����JavaScript(����IE5/NN6)--ƽ̨��������ƣ���Ŀ�鲻���޸ģ��������Ը�
 * ��������������������֪ͨ�ṩ��
 * �������û����private��ͷ,�򷽷��ǹ�����,�ұ�֤������.
 * ������:2004-08-11
 */
/** ȫ�ֱ���bCancel; */
var bCancel = false;
var DATE_DELIMITER = "-";
var DB_INT_LENGTH = 64; //���ݿ�λ��,���������ȣ�Ĭ��Ϊ64λ
var MAX_INTEGER  = Math.pow(2,DB_INT_LENGTH-1) - 1;
var MIN_INTEGER  = -Math.pow(2,DB_INT_LENGTH-1);
var MAX_SMALLINT = Math.pow(2,DB_INT_LENGTH/4-1) - 1;
var MIN_SMALLINT = -Math.pow(2,DB_INT_LENGTH/4-1);
var VERBOSE = false;//��ʾ������ϸ�����������п��Ե���setVerbose(true)
var FIELD_SEPARATOR = "_FIELD_SEPARATOR_";   //�ֶ�֮��ķָ��
var GROUP_SEPARATOR = "_GROUP_SEPARATOR_";     //һ�����֮��ķָ��

/**
 * �������ڷָ����Ĭ��Ϊ'/'
 * @param delimiter ���ڷָ��
 */
function setDateDelimiter(delimiter){
    DATE_DELIMITER = delimiter;
}
/**
 * �������ݿ��������ȣ�Ĭ��Ϊ64
 * @param len ��������
 */
function setDBIntLength(len){
    DB_INT_LENGTH = len;
    MAX_INTEGER  = Math.pow(2,DB_INT_LENGTH-1) - 1;
    MIN_INTEGER  = -Math.pow(2,DB_INT_LENGTH-1);
    MAX_SMALLINT = Math.pow(2,DB_INT_LENGTH/4-1) - 1;
    MIN_SMALLINT = -Math.pow(2,DB_INT_LENGTH/4-1);
}

/**
 * �����Ƿ���ʾ��ϸ��Ĭ��Ϊ����ʾ
 * @param verbose ���ڷָ��
 */
function setVerbose(verbose){
    VERBOSE = verbose;
}

/**
 * ����Ƿ���ʾ��ϸ
 * @return �Ƿ���ʾ��ϸ
 */
function isVerbose(){
    return VERBOSE;

}

/**
 * ��ӡ��־��Ϣ
 */
function log(value){
    if(isVerbose()){
        window.status=value;
    }
}

/**
 * �жϿͻ���������Ƿ�ΪNetscape
 * @return �ͻ��������ΪNetscape�򷵻�true,���򷵻�false;
 */
function isNetscape(){
    if(navigator.appName=="Netscape"){
        return true;
    }else{
        return false;
    }
}



var verbose = false;//��ʾ������ϸ������������Ӧ��Ϊfalse

/**
 * �жϿͻ���������Ƿ�ΪNetscape
 * @return �ͻ��������ΪNetscape�򷵻�true,���򷵻�false;
 */
function isNetscape()
{
  if(navigator.appName=="Netscape")
    return true;
  else
    return false;
}
/**
 * չ����+�������ݻ����ء����������ݣ�
 *
 */
function showPage(img,spanID)
{

  if(spanID.style.display=="")
  {
   //�ر�
    spanID.style.display="none";
    img.src="/claim/images/butCollapseBlue.gif";
  }
  else
  {
   //չ��
    spanID.style.display="";
    img.src="/claim/images/butExpandBlue.gif";
  }
}

/**
 * �õ�����element��Document�е�name��ͬ��elements�е�˳��(��1��ʼ)
 * @param field element
 * @return ����element��Document�е�name��ͬ��elements�е�˳��(��1��ʼ)
 */
function getElementOrder(field)
{
    var i = 0;
    var order = 0;
    var elements = document.getElementsByName(field.name);
    for(i=0;i<elements.length;i++)
    {
        order++;
        if(elements[i]==field)
        {
            break;
        }
    }

    return order;
}
/**
 * ����element�Ƿ���Document�е�name��ͬ��elements�еĵ�0��
 * @param field element
 * @return �Ƿ���true�����򷵻�false
 */
function isFirstElement(field){
    var elements = document.getElementsByName(field.name);
    if(elements[0]==field){
    	return true;
    }
    else{
    	return false;
    }
}

/**
 * ������Document�е�element��name���Ե��紫��ֵ��element������û���򷵻�0
 * @param fieldName Ԫ������
 * @return ��Document�е�element��name���Ե��紫��ֵ��element����
 */
function getElementCount(fieldName)
{
    var count = 0;
    count = document.getElementsByName(fieldName).length;
    return count;
}

/**
 * �õ��ַ������ֽڳ���
 * @param value �ַ���
 * @return �ַ������ֽڳ���
 */
function getByteLength(value)
{
  var str;
  var count  = 0;

  for(var i=0;i<value.length;i++)
  {
    str = escape(value.charAt(i));
    if(str.length==6)
      count = count + 2;
    else
      count = count + 1;
  }

  return count;
}

/**
 * �õ�Table������Ԫ��
 * @param tableId ������
 * @return table������Ԫ��
 */
function getTableElements(tableId)
{
  var i = 0;
  var elements=new Array();
  var tempElements = null;
  var tbody;
  var index=0;
  var tbodies = document.getElementById(tableId).tBodies;
  for(i=0;i<tbodies.length;i++)
  {
    tbody=tbodies.item(i);
    tempElements=tbody.getElementsByTagName("INPUT");    //����INPUT��

    for(var j=0;j<tempElements.length;j++)
    {
      elements[index++]=tempElements[j];
    }

    tempElements=tbody.getElementsByTagName("SELECT");   //����SELECT��
    for(var j=0;j<tempElements.length;j++)
    {
      elements[index++]=tempElements[j];
    }

    tempElements=tbody.getElementsByTagName("TEXTAREA"); //����TEXTAREA��
    for(var j=0;j<tempElements.length;j++)
    {
      elements[index++]=tempElements[j];
    }
  }
  return elements;
}

/**
 * ȥ���ַ���ͷ�ո�
 * @param value �����ַ���
 * @return ȥ��ͷ�ո����ַ���
 */
function leftTrim(value)
{
  var re =/^\s*/;
  if(value==null)
    return null;

  return value.replace(re,"");
}

/**
 * ȥ���ַ���β�ո�
 * @param value �����ַ���
 * @return ȥ��β�ո����ַ���
 */
function rightTrim(value)
{
  var re =/\s*$/;
  if(value==null)
    return null;

  return value.replace(re,"");
}

/**
 * ȥ���ַ���ͷβ�ո�
 * @param value �����ַ���
 * @return ȥ��ͷβ�ո����ַ���
 */
function trim(value)
{
  return leftTrim(rightTrim(value));
}


/**
 * ������ʽ����
 * @param source �����ַ���
 * @param re ������ʽ
 * @return ������ʽ���Խ��
 */
function regExpTest(resource,re)
{
  var result = false;

  if(resource==null || resource=="")
    return false;

  if(resource==re.exec(resource))
    result = true;

  return result;
}

/**
 * �滻�ַ�������
 * @param str ԭ��
 * @param strFind ���Ҵ�
 * @param strReplaceWith �滻��
 * @return �����滻����ַ���
 */
function replace(str,strFind,strReplaceWith){
    var strReturn;
    var re = new RegExp(strFind,"g");
    if(str==null){
        return null;
    }
    strReturn = str.replace(re,strReplaceWith);
    return strReturn;
}

/**
 * ����������Ƿ�Ϊ��
 * @param field ������
 * @return ����������ֵΪnull��գ��򷵻�true�����򷵻�false
 */
function isEmptyField(field){
    if(field.value==null || trim(field.value)==""){
        return true;
    }
    return false;
}

//��ӡ��־��Ϣ
function log(value){
    if(verbose==true){
        window.status=(value);
    }
}


////У��Decimal
//function checkDecimalField(field,p,s,MinValue,MaxValue)
//{
//  field.value = trim(field.value);
//  var strValue=field.value;
//  if(strValue=="")
//    strValue = "0";
//
//  var desc   = field.description;
//  //���description���Բ����ڣ�����name����
//  if(desc==null)
//    desc = field.name;
//
//  if(regExpTest(strValue,/\d*[.]?\d*/g)==false)
//  {
//    alert("������Ϸ�������");
//    field.focus();
//    field.select();
//    return false;
//  }
//  p = parseInt(p);
//  s = parseInt(s);
//
//  var pLength;
//  var sLength;
//  var position = strValue.indexOf(".");
//  if(position>-1)
//  {
//    pLength = position;
//    sLength = strValue.length - position - 1;
//  }
//  else
//  {
//    pLength = strValue.length;
//    sLength = 0;
//  }
//
//  if(pLength>(p-s) || sLength>s)
//  {
//    alert("������Ϸ���" + desc +"\n����Ϊ����,����λ�Ϊ" + (p-s) + ",С��λ�Ϊ" + s);
//    field.focus();
//    field.select();
//    return false;
//  }
//
//  var value = parseFloat(strValue);
//  if(MaxValue!=null && MinValue!=null && MaxValue!="" && MinValue!="")
//  {
//    MinValue = parseFloat(MinValue);
//    MaxValue = parseFloat(MaxValue);
//    if(isNaN(value) || value>MaxValue || value<MinValue)
//    {
//      alert("������Ϸ���" + desc +"\n����Ϊ����,��СֵΪ" + MinValue + ",���ֵΪ" +MaxValue);
//      field.focus();
//      field.select();
//      return false;
//    }
//  }
//
//  return true;
//}
//
//
////�Ƚ����������ַ���
//// date1=date2�򷵻�0 , date1>date2�򷵻�1 , date1<date2�򷵻�-1
//function compareFullDate(date1,date2)
//{
//  var strValue1=date1.split("/");
//  var date1Temp=new Date(strValue1[0],parseInt(strValue1[1],10)-1,parseInt(strValue1[2],10));
//
//  var strValue2=date2.split("/");
//  var date2Temp=new Date(strValue2[0],parseInt(strValue2[1],10)-1,parseInt(strValue2[2],10));
//
//  if(date1Temp.getTime()==date2Temp.getTime())
//    return 0;
//  else if(date1Temp.getTime()>date2Temp.getTime())
//    return 1;
//  else
//    return -1;
//}
//
//
////�Ƚ����������ַ�����YYYY/MM�ͣ�
//// date1=date2�򷵻�0 , date1>date2�򷵻�1 , date1<date2�򷵻�-1
//function compareYM(date1,date2)
//{
//  var strValue1=date1.split("/");
//  var date1Temp=new Date(strValue1[0],parseInt(strValue1[1],10)-1,1);
//
//  var strValue2=date2.split("/");
//  var date2Temp=new Date(strValue2[0],parseInt(strValue2[1],10)-1,1);
//
//  if(date1Temp.getTime()==date2Temp.getTime())
//    return 0;
//  else if(date1Temp.getTime()>date2Temp.getTime())
//    return 1;
//  else
//    return -1;
//}

//����

//function relate(strPolicyNo)
//{
//		if(strPolicyNo == null || trim(strPolicyNo).length != 22)
//		{
//		 	alert("û���ṩ��Ч��22λ�����ţ�");
//		 	return;
//		}
//var strURL = "/claim/common/pub/Relate.jsp?PolicyNo="+strPolicyNo;
//  var strURL = "/claim/common/pub/blank.html";
//  var newWindow = window.open(strURL,"Relate",'width=640,height=300,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
//  newWindow.focus();
//����Ϊʲô�������ύ�¼���
//}

//����
function relateProposalNo(strProposalNo)
{
		if(strProposalNo == null || trim(strProposalNo).length != 22)
		{
		 	alert("û���ṩ��Ч��22λͶ�����ţ�");
		 	return;
		}

  var strURL = "/claim/common/pub/RelateProposalNo.jsp?ProposalNo="+strProposalNo;
  var newWindow = window.open(strURL,"Relate",'width=640,height=300,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
  newWindow.focus();
}

function viewHePeiTrace(businessNo)
{
  if(businessNo=="")
  {
    errorMessage("û�к�����Ϣ!");
    return ;
  }
  //fm.target = "fraSubmit";
  //fm.action = "/undwrt/CommonViewTrace.do?BusinessNo=" + businessNo;
    //fm.method="post";
  //fm.submit();
  //var strURL="/undwrt/common/CommonTraceInfo.jsp?BusinessNo=" + businessNo;
  //window.open(strURL,'�˱���Ϣ','width=640,height=300,top=50,left=80,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');


  var submitStr="/claim/CommonViewTrace.do?BusinessNo=" + businessNo;
  window.open(submitStr,'������Ϣ','width=640,height=300,top=50,left=80,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
}

/**�رմ���**/
function closeWindow()
{
	window.close();
}

//��������������
//��ֵ,����
function round(number,precision)
{
  if(isNaN(number))
    number = 0;
  var prec = Math.pow(10,precision);
  var result = Math.round( number * prec) ;
  result = result/prec;
  return result;
}


//�����ֽ��и�ʽ��,��֤precisionλ
function point(number,precision)
{
  if(isNaN(number))
    number = 0;
  var result = number.toString();
  if(result.indexOf(".")==-1)
    result = result + ".";

  result = result + newString("0",precision);
  result = result.substring(0,precision + result.indexOf(".") + 1);
  return result;
}

//�����ֵ���λ��������
function mathRound(number)
{
  return round(number,2);
}

//�����ְ�0.00��ʽ��
function pointTwo( s )
{
  return point(s,2);
}

//�����ְ�0.0000 ��ʽ��
function pointFour( s )
{
  return point(s,4);
}

//�����ָ�ʽ����delimiterCharĬ��Ϊ"," precisionĬ��Ϊ3
function numberFormat(ivalue,delimiterChar,precision)
{
  if((ivalue==null) || (ivalue==""))
    return "";

  if(delimiterChar==null || delimiterChar=="")
    delimiterChar = ",";

  if(precision==null || precision =="")
    precision = 3;

  var i = 0;
  var ovalue = "";
  var times;

  var avalue = "";
  if(ivalue.indexOf(".")>-1)
  {
    avalue = "." + ivalue.substring(ivalue.indexOf(".")+1);
    ivalue = ivalue.substring(0,ivalue.indexOf("."));
  }

  times = ivalue.length % precision;
  if(times!=0)
  {
    ovalue = ivalue.substring(0,times);
    ivalue = ivalue.substring(times);
  }

  for(i=0;i<ivalue.length;i++)
  {
    if(i%precision==0)
    {
      ovalue += delimiterChar;
    }
    ovalue += ivalue.substring(i,i+1)
  }

  if(ovalue.substring(0,1) == delimiterChar)
    ovalue = ovalue.substring(1);


  return ovalue + avalue;
}


/**
 * ��ʽ������
 * @param value ֵ
 * @param count �ָ�λ�� Ĭ��Ϊ3
 * @param precision С���㱣��λ�� Ĭ��Ϊ2
 * @param delimiterChar �ָ�� Ĭ��Ϊ','
 */
function formatFloat(value,count,precision,delimiterChar)
{
  count = count==null?3:count;
  precision = precision==null?2:precision;
  delimiterChar = delimiterChar==null?",":delimiterChar;


  var strReturn = ""; //����ֵ
  var strValue = point(round(value,precision),precision); //��ʽ����ָ��С��λ��

  strReturn = strValue.substring(strValue.length-precision-1);
  strValue = strValue.substring(0,strValue.length-precision-1);
  while(strValue.length>count)
  {
    strReturn = delimiterChar + strValue.substring(strValue.length-count) + strReturn;
    strValue = strValue.substring(0,strValue.length-count);
  }

  strReturn = strValue + strReturn;
  return strReturn;
}


//�ָ���벢����select����
//���ĸ�ʽ: ֵFIELD_SEPARATOR�ı�GROUP_SEPARATORֵFIELD_SEPARATOR�ı�...
function setOption(selectName,strValue)
{
  //�鲻�����뷵��
  if(strValue==null || trim(strValue)=="")
  {
    return;
  }

  var arrayField=strValue.split(GROUP_SEPARATOR);
  var i=0;
  var j=0;
  var intCount = getElementCount(selectName);

  if(intCount>1)
  {
    for(j=0;j<intCount;j++)
    {
      fm.all(selectName)[j].options.length = 0;
    }
  }
  else
  {
    fm.all(selectName).options.length = 0;
  }

  while(i<arrayField.length)
  {
    if(intCount>1)
    {
      for(j=0;j<intCount;j++)
      {
        var option=document.createElement("option");
        var arrayTemp=arrayField[i].split(FIELD_SEPARATOR);
        var strFieldName=arrayTemp[0];
        var strFieldValue=unescape(arrayTemp[1]);
        option.value=strFieldName;
        option.text=strFieldValue;

        fm.all(selectName)[j].add(option);
      }
    }
    else
    {
        var option=document.createElement("option");
        var arrayTemp=arrayField[i].split(FIELD_SEPARATOR);
        var strFieldName=arrayTemp[0];
        var strFieldValue=unescape(arrayTemp[1]);
        option.value=strFieldName;
        option.text=strFieldValue;
      fm.all(selectName).add(option);
    }
    i++;
  }
}


/**
 * �������ַ������ƣ��
 * @param intLength �ַ�������
 * @return �ַ���
 */
function newString(iString, iTimes)
{
  var str = "";
  for (var i = 0 ; i < iTimes; i++)
     str = str + iString;
  return str;
}


/**
 * ���ܣ�����������ֻ����ͬʱ��CSS�����Ա��ֻ��
 * return true/false
 */
function readonlyAllInput()
{
  var testStr = "" ;
  var tempElements = null;
  var elements = document.all;
  var len = elements.length;
  for(i=0; i < len; i++)
  {
    
    if(elements[i].tagName=="INPUT")
    {
        tempElements = elements[i];
        //���������Ϊֻ��
        if(tempElements.type=="text")
        {
	    	tempElements.style.fontSize="9pt";
	    	tempElements.style.borderTop = "none";
	    	tempElements.style.borderBottom = "none";
	    	tempElements.style.borderRight= "none";
	    	tempElements.style.borderLeft = "none" ;
	    	//tempElements.style.width="80%";
	    	tempElements.style.color = "#000000";
	    	tempElements.style.backgroundColor = "#F4F9FF";
        	tempElements.readOnly=true;        	
            tempElements.onchange="";
            tempElements.ondblclick="";
            tempElements.onkeyup="";
            tempElements.onblur="";
        	
        }
        //���������Ϊֻ��
        if(tempElements.type=="radio")
        {
        	tempElements.disabled=true;
        }

        ////���������Ϊֻ��
        //if(tempElements.type=="button")
        //{
        //	tempElements.disabled=true;
        //}
        ////���������Ϊֻ��
        //if(tempElements.type=="submit")
        //{
        //	tempElements.disabled=true;
        //}

    }
    //��ѡ�����Ϊֻ��
    if(elements[i].tagName=="SELECT")
    {
    	tempElements = elements[i];
    	tempElements.disabled = true;
    }
    //��ѡ�����Ϊֻ��
    if(elements[i].tagName=="TEXTAREA")
    {
    	tempElements = elements[i];
    	tempElements.readOnly=true;
    	tempElements.style.backgroundColor = "RGB(247,247,247)";
    }

  }

}


/**
 * ���ܣ����������ɿ�д��ͬʱ��CSS�����Ա�ɿ�д
 * return true/false
 */
function ableAllInput()
{
  var testStr = "" ;
  var tempElements = null;

  for(i=0; i<document.all.length; i++)
  {
    //alert(document.all(i).tagName);
    if(document.all(i).tagName=="INPUT")
    {
        tempElements = document.all(i);
        //���������Ϊ��д
        if(tempElements.type=="text")
        {
  	    	tempElements.style.fontSize="9pt";
  	    	tempElements.style.borderTop = "none";
  	    	tempElements.style.borderBottom = "none";
  	    	tempElements.style.borderRight= "none";
  	    	tempElements.style.borderLeft = "none" ;
  	    	//tempElements.style.width="80%";
  	    	tempElements.style.color = "#000000";
  	    	tempElements.style.backgroundColor = "#F4F9FF";
          tempElements.readOnly=false;
        }
        //���������Ϊ��д
        if(tempElements.type=="radio")
        {
        	tempElements.disabled=false;
        }
        //���������Ϊ��д
        if(tempElements.type=="checkbox")
        {
        	tempElements.disabled=false;
        }
    }
    //��ѡ�����Ϊֻ��
    if(document.all(i).tagName=="SELECT")
    {
    	tempElements = document.all(i);
    	tempElements.disabled = false;
    }
    //��ѡ�����Ϊֻ��
    if(document.all(i).tagName=="TEXTAREA")
    {
    	tempElements = document.all(i);
    	tempElements.disabled = false;
    }

  }

}
/**
 * ���ܣ� ��ť��İ�ť���ɿɶ�
 * @param tableID ���а�ť�ı�ID
 */

 function disabledAllButton(tableId)
 {
   var elements = getTableElements(tableId);

   for(var i=0;i<elements.length;i++)
   {
   		if(elements[i].name=="buttonBack"){ //�������ΪbuttonBack�����
       	continue;
      } 
       //��button��ɲ�����
       if(elements[i].type == "button")
       {  
       	 elements[i].disabled = true;
       }
       //��submit��ɲ�����
       if(elements[i].type == "submit")
       {
          elements[i].disabled = true;
       }
       //��reset��ɲ�����
       if(elements[i].type == "reset")
       {
          elements[i].disabled = true;
       }

    }
 }
 /**
  * ���ܣ� ��ť��İ�ť���ɿɶ�
  * @param tableID ���а�ť�ı�ID
  */

  function enableAllButton(tableId)
  {
    var elements = getTableElements(tableId);

    for(var i=0;i<elements.length;i++)
    {
    		if(elements[i].name=="buttonBack"){ //�������ΪbuttonBack�����
        	continue;
       } 
        //��button��ɲ�����
        if(elements[i].type == "button")
        {  
        	 elements[i].disabled = false;
        }
        //��submit��ɲ�����
        if(elements[i].type == "submit")
        {
           elements[i].disabled = false;
        }
        //��reset��ɲ�����
        if(elements[i].type == "reset")
        {
           elements[i].disabled = false;
        }

     }
  }
 //�����������ڵĲ�,���ز������(M)������(D)
//2003/3/17 ��Ϊ(������������2.29��һ��)
function dateDiff(dateStart,dateEnd,MD)
{
  var i;
  if(MD=="D") //��������
  {
    var endTm   = dateEnd.getTime();
    var startTm = dateStart.getTime();
    var diffDay = (endTm - startTm)/86400000 + 1;

    return diffDay;
  }
  else //���¼����
  {
    var endD   = dateEnd.getDate();
    var endM   = dateEnd.getMonth();
    var endY   = dateEnd.getFullYear();
    var startD = dateStart.getDate();
    var startM = dateStart.getMonth();
    var startY = dateStart.getFullYear();

    if(endD>startD) //���ն˰�fcalc_month����ͳһ��endD>startDʱ�ż�1
    {
      return (endY-startY)*12 + (endM-startM) + 1;
    }
    else
    {
      return (endY-startY)*12 + (endM-startM);
    }
  }
}

//���������Ƿ���������У��,��ֻ�����ַ�0123456789
function isInteger(strValue)
{
  var result = regExpTest(strValue,/\d+/g);
  return result;
}

//���������Ƿ������ֵ�У��
function isNumeric(strValue)
{
  var result = regExpTest(strValue,/\d*[.]?\d*/g);
  return result;
}



//�������������
function checkFullDate(field)
{
  field.value = trim(field.value);
  var strValue = field.value;
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;
  if(strValue=="")
  {
    return false;
  }
  if(isNumeric(strValue ))
  {
    if(strValue.length > 6 && strValue.length < 9)
    {
        strValue = strValue.substring(0,4) + DATE_DELIMITER + strValue.substring(4,6) + DATE_DELIMITER + strValue.substring(6);

        field.value = strValue;
    }
     else
     {
      errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD");
        field.value="";
        field.focus();
        field.select();
        return false;
     }
  }
  if( !isDate(strValue,DATE_DELIMITER) && !isDate(strValue)||strValue.substring(0,1)=="0")
  {
    errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD");
    field.value="";
    field.focus();
    field.select();
    return false;
  }

  return true;
}


//���������Ƿ������ڵ�У�飬splitChar����ȱʡΪ"-"
function isDate(date,splitChar)
{
  var charSplit = (splitChar==null?"-":splitChar);
  var strValue = date.split(charSplit);

  if(strValue.length!=3) return false;
  if(!isInteger(strValue[0]) || !isInteger(strValue[1]) || !isInteger(strValue[2]) ) return false;

  var intYear  = parseInt(strValue[0],10);
  var intMonth = parseInt(strValue[1],10)-1;
  var intDay   = parseInt(strValue[2],10);

  var dt = new Date(intYear,intMonth,intDay);
  if( dt.getFullYear() != intYear ||
      dt.getMonth() != intMonth ||
      dt.getDate() != intDay
     )
  {
    return false;
  }
  return true;
}

//�������������
function checkFullDate(field)
{
  field.value = trim(field.value);
  var strValue = field.value;
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;
  if(strValue=="")
  {
    return false;
  }

  if(isNumeric(strValue ))
  {
     if(strValue.length > 6 && strValue.length < 9)
    {
      strValue = strValue.substring(0,4) + DATE_DELIMITER + strValue.substring(4,6) + DATE_DELIMITER + strValue.substring(6);
      field.value = strValue;
    }
     else
     {
      errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD");
        field.value="";
        field.focus();
        field.select();
        return false;
     }
  }
  if( !isDate(strValue,DATE_DELIMITER) && !isDate(strValue)||strValue.substring(0,1)=="0")
  {
    errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD");
    field.value="";
    field.focus();
    field.select();
    return false;
  }
  return true;
}
//���ӳ��͵Ĳ�ѯҳ��
function queryModelCode(riskcode,index)
{
  var strURL = "/claim/common/certainLoss/car/UIModelCodeQueryInput.jsp?riskcode=" + riskcode + "&index=" + index;
  
  window.open(strURL,'��ѯ���ʹ���','width=750,height=400,top=50,left=80,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}

function checkLength1(field)
{
  var strValue = field.value;
  var strDesc = field.description;
  var intMaxlength ;
  
  if(typeof(field.maxLength) != 'undefined'){
  		intMaxlength = field.maxLength;
  }else if(typeof(field.maxlength) != 'undefined'){
  		intMaxlength = field.maxlength;
  }else{
  	    intMaxlength = 1024;
  }
  var intCount = 0;
  var vChar;
  var i;

  if(trim(strValue).length==0)
    return true;
  if(strDesc==null)
    strDesc = field.name;
  if(isNaN(parseInt(intMaxlength,10)))
    return true;

  if(strValue.indexOf("^")>-1||
     strValue.indexOf(FIELD_SEPARATOR)>-1||
     strValue.indexOf(GROUP_SEPARATOR)>-1)
  {
    errorMessage("^Ϊϵͳ�����ַ������������룡");
    field.focus();
    field.select();
    return false;
  }

  for(i=0;i<strValue.length;i++)
  {
    vChar = escape(strValue.charAt(i));
    if(vChar.substring(0,2)=="%u"&&vChar.length==6)
      intCount = intCount+2;
    else
      intCount = intCount+1;
  }

  if(intCount>intMaxlength)
  {
    errorMessage(strDesc+"��������ݳ�����\n"+strDesc+"����󳤶�Ϊ"+intMaxlength+"���ַ���\nһ������ռ�����ַ�\n���������룡");
    field.focus();
    field.select();
    return false;
  }
  return true;
}
//У�����Сʱ
function checkMin(field){
	var vMin = field.value;
	if(vMin !="" &&(vMin<0 || vMin>59)){
		errorMessage("������Ϸ��ķ�����0~59!"); 
        field.value = "";      
        return false;
	}
}
//У��Сʱ
function checkHour(field){
	var vHour = field.value;
	if(vHour !="" &&(vHour<0 || vHour>23)){
		errorMessage("������Ϸ���Сʱ��0~23!"); 
        field.value = "";      
        return false;
	}
}

//�������򰴼�ʱ������У��
function pressInteger(e)
{

  if(window.event.keyCode >= 48 && window.event.keyCode <= 57){
  }
  else{
  	window.event.keyCode = 0;
  }
}

function HashMap()  
 {  
     /** Map ��С **/  
     var size = 0;  
     /** ���� **/  
     var entry = new Object();  
       
     /** �� **/  
     this.put = function (key , value)  
     {  
         if(!this.containsKey(key))  
         {  
             size ++ ;  
         }  
         entry[key] = value;  
     }  
       
     /** ȡ **/  
     this.get = function (key)  
     {  
         return this.containsKey(key) ? entry[key] : null;  
     }  
       
     /** ɾ�� **/  
     this.remove = function ( key )  
     {  
         if( this.containsKey(key) && ( delete entry[key] ) )  
         {  
             size --;  
         }  
     }  
       
     /** �Ƿ���� Key **/  
     this.containsKey = function ( key )  
     {  
         return (key in entry);  
     }  
       
     /** �Ƿ���� Value **/  
     this.containsValue = function ( value )  
     {  
         for(var prop in entry)  
         {  
             if(entry[prop] == value)  
             {  
                 return true;  
             }  
         }  
         return false;  
     }  
       
     /** ���� Value **/  
     this.values = function ()  
     {  
         var values = new Array();  
         for(var prop in entry)  
         {  
             values.push(entry[prop]);  
         }  
         return values;  
     }  
       
     /** ���� Key **/  
     this.keys = function ()  
     {  
         var keys = new Array();  
         for(var prop in entry)  
         {  
             keys.push(prop);  
         }  
         return keys;  
     }  
       
     /** Map Size **/  
     this.size = function ()  
     {  
         return size;  
     }  
       
     /* ��� */  
     this.clear = function ()  
     {  
         size = 0;  
         entry = new Object();  
     }  
 } 

//����targetchange�¼�
function fireChangeComm(target){
   
    //����change�¼�
	if (target.fireEvent){
	   target.fireEvent('onchange');
	}else{
	   target.onchange();
	}
}
function buttonTableAddDisabled(){
  $("#buttonTable").find(":button").attr("disabled","true");
}
function buttonTableRemoveDisabled(){
  $("#buttonTable").find(":button").removeAttr("disabled");;
}

