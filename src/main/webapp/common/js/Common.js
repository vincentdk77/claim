/**
 * 公用JavaScript(兼容IE5/NN6)--平台中心组控制，项目组不得修改，否则后果自负
 * 如果发现有问题或需求，请通知提供者
 * 如果方法没有用private开头,则方法是公开的,且保证向后兼容.
 * 最后更新:2004-08-11
 */
/** 全局变量bCancel; */
var bCancel = false;
var DATE_DELIMITER = "-";
var DB_INT_LENGTH = 64; //数据库位数,即整数长度，默认为64位
var MAX_INTEGER  = Math.pow(2,DB_INT_LENGTH-1) - 1;
var MIN_INTEGER  = -Math.pow(2,DB_INT_LENGTH-1);
var MAX_SMALLINT = Math.pow(2,DB_INT_LENGTH/4-1) - 1;
var MIN_SMALLINT = -Math.pow(2,DB_INT_LENGTH/4-1);
var VERBOSE = false;//显示所有明细，开发环境中可以调用setVerbose(true)
var FIELD_SEPARATOR = "_FIELD_SEPARATOR_";   //字段之间的分割符
var GROUP_SEPARATOR = "_GROUP_SEPARATOR_";     //一组代码之间的分割符

/**
 * 设置日期分割符，默认为'/'
 * @param delimiter 日期分割符
 */
function setDateDelimiter(delimiter){
    DATE_DELIMITER = delimiter;
}
/**
 * 设置数据库整数长度，默认为64
 * @param len 整数长度
 */
function setDBIntLength(len){
    DB_INT_LENGTH = len;
    MAX_INTEGER  = Math.pow(2,DB_INT_LENGTH-1) - 1;
    MIN_INTEGER  = -Math.pow(2,DB_INT_LENGTH-1);
    MAX_SMALLINT = Math.pow(2,DB_INT_LENGTH/4-1) - 1;
    MIN_SMALLINT = -Math.pow(2,DB_INT_LENGTH/4-1);
}

/**
 * 设置是否显示明细，默认为不显示
 * @param verbose 日期分割符
 */
function setVerbose(verbose){
    VERBOSE = verbose;
}

/**
 * 检查是否显示明细
 * @return 是否显示明细
 */
function isVerbose(){
    return VERBOSE;

}

/**
 * 打印日志信息
 */
function log(value){
    if(isVerbose()){
        window.status=value;
    }
}

/**
 * 判断客户端浏览器是否为Netscape
 * @return 客户端浏览器为Netscape则返回true,否则返回false;
 */
function isNetscape(){
    if(navigator.appName=="Netscape"){
        return true;
    }else{
        return false;
    }
}



var verbose = false;//显示所有明细，生产环境中应改为false

/**
 * 判断客户端浏览器是否为Netscape
 * @return 客户端浏览器为Netscape则返回true,否则返回false;
 */
function isNetscape()
{
  if(navigator.appName=="Netscape")
    return true;
  else
    return false;
}
/**
 * 展开“+”号内容或隐藏“—”号内容；
 *
 */
function showPage(img,spanID)
{

  if(spanID.style.display=="")
  {
   //关闭
    spanID.style.display="none";
    img.src="/claim/images/butCollapseBlue.gif";
  }
  else
  {
   //展开
    spanID.style.display="";
    img.src="/claim/images/butExpandBlue.gif";
  }
}

/**
 * 得到传入element在Document中的name相同的elements中的顺序(从1开始)
 * @param field element
 * @return 传入element在Document中的name相同的elements中的顺序(从1开始)
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
 * 传入element是否是Document中的name相同的elements中的第0个
 * @param field element
 * @return 是返回true，否则返回false
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
 * 查找在Document中的element的name属性等如传入值的element个数，没有则返回0
 * @param fieldName 元素名称
 * @return 在Document中的element的name属性等如传入值的element个数
 */
function getElementCount(fieldName)
{
    var count = 0;
    count = document.getElementsByName(fieldName).length;
    return count;
}

/**
 * 得到字符串的字节长度
 * @param value 字符串
 * @return 字符串的字节长度
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
 * 得到Table的所有元素
 * @param tableId 表名称
 * @return table的所有元素
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
    tempElements=tbody.getElementsByTagName("INPUT");    //加入INPUT域

    for(var j=0;j<tempElements.length;j++)
    {
      elements[index++]=tempElements[j];
    }

    tempElements=tbody.getElementsByTagName("SELECT");   //加入SELECT域
    for(var j=0;j<tempElements.length;j++)
    {
      elements[index++]=tempElements[j];
    }

    tempElements=tbody.getElementsByTagName("TEXTAREA"); //加入TEXTAREA域
    for(var j=0;j<tempElements.length;j++)
    {
      elements[index++]=tempElements[j];
    }
  }
  return elements;
}

/**
 * 去掉字符串头空格
 * @param value 传人字符串
 * @return 去掉头空格后的字符串
 */
function leftTrim(value)
{
  var re =/^\s*/;
  if(value==null)
    return null;

  return value.replace(re,"");
}

/**
 * 去掉字符串尾空格
 * @param value 传人字符串
 * @return 去掉尾空格后的字符串
 */
function rightTrim(value)
{
  var re =/\s*$/;
  if(value==null)
    return null;

  return value.replace(re,"");
}

/**
 * 去掉字符串头尾空格
 * @param value 传人字符串
 * @return 去掉头尾空格后的字符串
 */
function trim(value)
{
  return leftTrim(rightTrim(value));
}


/**
 * 正则表达式测试
 * @param source 传人字符串
 * @param re 正则表达式
 * @return 正则表达式测试结果
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
 * 替换字符串函数
 * @param str 原串
 * @param strFind 查找串
 * @param strReplaceWith 替换串
 * @return 返回替换后的字符串
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
 * 检查输入域是否为空
 * @param field 输入域
 * @return 如果输入域的值为null或空，则返回true，否则返回false
 */
function isEmptyField(field){
    if(field.value==null || trim(field.value)==""){
        return true;
    }
    return false;
}

//打印日志信息
function log(value){
    if(verbose==true){
        window.status=(value);
    }
}


////校验Decimal
//function checkDecimalField(field,p,s,MinValue,MaxValue)
//{
//  field.value = trim(field.value);
//  var strValue=field.value;
//  if(strValue=="")
//    strValue = "0";
//
//  var desc   = field.description;
//  //如果description属性不存在，则用name属性
//  if(desc==null)
//    desc = field.name;
//
//  if(regExpTest(strValue,/\d*[.]?\d*/g)==false)
//  {
//    alert("请输入合法的数字");
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
//    alert("请输入合法的" + desc +"\n类型为数字,整数位最长为" + (p-s) + ",小数位最长为" + s);
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
//      alert("请输入合法的" + desc +"\n类型为数字,最小值为" + MinValue + ",最大值为" +MaxValue);
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
////比较两个日期字符串
//// date1=date2则返回0 , date1>date2则返回1 , date1<date2则返回-1
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
////比较两个日期字符串（YYYY/MM型）
//// date1=date2则返回0 , date1>date2则返回1 , date1<date2则返回-1
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

//关联

//function relate(strPolicyNo)
//{
//		if(strPolicyNo == null || trim(strPolicyNo).length != 22)
//		{
//		 	alert("没有提供有效的22位保单号！");
//		 	return;
//		}
//var strURL = "/claim/common/pub/Relate.jsp?PolicyNo="+strPolicyNo;
//  var strURL = "/claim/common/pub/blank.html";
//  var newWindow = window.open(strURL,"Relate",'width=640,height=300,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
//  newWindow.focus();
//关联为什么会引起提交事件？
//}

//关联
function relateProposalNo(strProposalNo)
{
		if(strProposalNo == null || trim(strProposalNo).length != 22)
		{
		 	alert("没有提供有效的22位投保单号！");
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
    errorMessage("没有核赔信息!");
    return ;
  }
  //fm.target = "fraSubmit";
  //fm.action = "/undwrt/CommonViewTrace.do?BusinessNo=" + businessNo;
    //fm.method="post";
  //fm.submit();
  //var strURL="/undwrt/common/CommonTraceInfo.jsp?BusinessNo=" + businessNo;
  //window.open(strURL,'核保信息','width=640,height=300,top=50,left=80,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');


  var submitStr="/claim/CommonViewTrace.do?BusinessNo=" + businessNo;
  window.open(submitStr,'核赔信息','width=640,height=300,top=50,left=80,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
}

/**关闭窗口**/
function closeWindow()
{
	window.close();
}

//对数字四舍五入
//数值,精度
function round(number,precision)
{
  if(isNaN(number))
    number = 0;
  var prec = Math.pow(10,precision);
  var result = Math.round( number * prec) ;
  result = result/prec;
  return result;
}


//对数字进行格式化,保证precision位
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

//对数字第三位四舍五入
function mathRound(number)
{
  return round(number,2);
}

//对数字按0.00格式化
function pointTwo( s )
{
  return point(s,2);
}

//对数字按0.0000 格式化
function pointFour( s )
{
  return point(s,4);
}

//对数字格式化，delimiterChar默认为"," precision默认为3
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
 * 格式化数字
 * @param value 值
 * @param count 分割位数 默认为3
 * @param precision 小数点保留位数 默认为2
 * @param delimiterChar 分割符 默认为','
 */
function formatFloat(value,count,precision,delimiterChar)
{
  count = count==null?3:count;
  precision = precision==null?2:precision;
  delimiterChar = delimiterChar==null?",":delimiterChar;


  var strReturn = ""; //返回值
  var strValue = point(round(value,precision),precision); //格式化成指定小数位数

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


//分割代码并放在select域里
//串的格式: 值FIELD_SEPARATOR文本GROUP_SEPARATOR值FIELD_SEPARATOR文本...
function setOption(selectName,strValue)
{
  //查不到代码返回
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
 * 将给定字符串复制ｎ遍
 * @param intLength 字符串长度
 * @return 字符串
 */
function newString(iString, iTimes)
{
  var str = "";
  for (var i = 0 ; i < iTimes; i++)
     str = str + iString;
  return str;
}


/**
 * 功能：将输入域变成只读，同时将CSS的属性变成只读
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
        //将输入域变为只读
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
        //将输入域变为只读
        if(tempElements.type=="radio")
        {
        	tempElements.disabled=true;
        }

        ////将输入域变为只读
        //if(tempElements.type=="button")
        //{
        //	tempElements.disabled=true;
        //}
        ////将输入域变为只读
        //if(tempElements.type=="submit")
        //{
        //	tempElements.disabled=true;
        //}

    }
    //将选择域变为只读
    if(elements[i].tagName=="SELECT")
    {
    	tempElements = elements[i];
    	tempElements.disabled = true;
    }
    //将选择域变为只读
    if(elements[i].tagName=="TEXTAREA")
    {
    	tempElements = elements[i];
    	tempElements.readOnly=true;
    	tempElements.style.backgroundColor = "RGB(247,247,247)";
    }

  }

}


/**
 * 功能：将输入域变成可写，同时将CSS的属性变成可写
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
        //将输入域变为可写
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
        //将输入域变为可写
        if(tempElements.type=="radio")
        {
        	tempElements.disabled=false;
        }
        //将输入域变为可写
        if(tempElements.type=="checkbox")
        {
        	tempElements.disabled=false;
        }
    }
    //将选择域变为只读
    if(document.all(i).tagName=="SELECT")
    {
    	tempElements = document.all(i);
    	tempElements.disabled = false;
    }
    //将选择域变为只读
    if(document.all(i).tagName=="TEXTAREA")
    {
    	tempElements = document.all(i);
    	tempElements.disabled = false;
    }

  }

}
/**
 * 功能： 按钮域的按钮域变成可读
 * @param tableID 含有按钮的表ID
 */

 function disabledAllButton(tableId)
 {
   var elements = getTableElements(tableId);

   for(var i=0;i<elements.length;i++)
   {
   		if(elements[i].name=="buttonBack"){ //如果名字为buttonBack则继续
       	continue;
      } 
       //将button设成不可用
       if(elements[i].type == "button")
       {  
       	 elements[i].disabled = true;
       }
       //将submit设成不可用
       if(elements[i].type == "submit")
       {
          elements[i].disabled = true;
       }
       //将reset设成不可用
       if(elements[i].type == "reset")
       {
          elements[i].disabled = true;
       }

    }
 }
 /**
  * 功能： 按钮域的按钮域变成可读
  * @param tableID 含有按钮的表ID
  */

  function enableAllButton(tableId)
  {
    var elements = getTableElements(tableId);

    for(var i=0;i<elements.length;i++)
    {
    		if(elements[i].name=="buttonBack"){ //如果名字为buttonBack则继续
        	continue;
       } 
        //将button设成不可用
        if(elements[i].type == "button")
        {  
        	 elements[i].disabled = false;
        }
        //将submit设成不可用
        if(elements[i].type == "submit")
        {
           elements[i].disabled = false;
        }
        //将reset设成不可用
        if(elements[i].type == "reset")
        {
           elements[i].disabled = false;
        }

     }
  }
 //计算两个日期的差,返回差的月数(M)或天数(D)
//2003/3/17 改为(其中天数包含2.29这一天)
function dateDiff(dateStart,dateEnd,MD)
{
  var i;
  if(MD=="D") //按天计算差
  {
    var endTm   = dateEnd.getTime();
    var startTm = dateStart.getTime();
    var diffDay = (endTm - startTm)/86400000 + 1;

    return diffDay;
  }
  else //按月计算差
  {
    var endD   = dateEnd.getDate();
    var endM   = dateEnd.getMonth();
    var endY   = dateEnd.getFullYear();
    var startD = dateStart.getDate();
    var startM = dateStart.getMonth();
    var startY = dateStart.getFullYear();

    if(endD>startD) //跟终端版fcalc_month函数统一，endD>startD时才加1
    {
      return (endY-startY)*12 + (endM-startM) + 1;
    }
    else
    {
      return (endY-startY)*12 + (endM-startM);
    }
  }
}

//对输入域是否是整数的校验,即只包含字符0123456789
function isInteger(strValue)
{
  var result = regExpTest(strValue,/\d+/g);
  return result;
}

//对输入域是否是数字的校验
function isNumeric(strValue)
{
  var result = regExpTest(strValue,/\d*[.]?\d*/g);
  return result;
}



//检查日期输入域
function checkFullDate(field)
{
  field.value = trim(field.value);
  var strValue = field.value;
  var desc   = field.description;
  //如果description属性不存在，则用name属性
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
      errorMessage("请输入合法的" + desc +"\n类型为日期，格式为YYYY-MM-DD 或者YYYYMMDD");
        field.value="";
        field.focus();
        field.select();
        return false;
     }
  }
  if( !isDate(strValue,DATE_DELIMITER) && !isDate(strValue)||strValue.substring(0,1)=="0")
  {
    errorMessage("请输入合法的" + desc +"\n类型为日期，格式为YYYY-MM-DD 或者YYYYMMDD");
    field.value="";
    field.focus();
    field.select();
    return false;
  }

  return true;
}


//对输入域是否是日期的校验，splitChar参数缺省为"-"
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

//检查日期输入域
function checkFullDate(field)
{
  field.value = trim(field.value);
  var strValue = field.value;
  var desc   = field.description;
  //如果description属性不存在，则用name属性
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
      errorMessage("请输入合法的" + desc +"\n类型为日期，格式为YYYY-MM-DD 或者YYYYMMDD");
        field.value="";
        field.focus();
        field.select();
        return false;
     }
  }
  if( !isDate(strValue,DATE_DELIMITER) && !isDate(strValue)||strValue.substring(0,1)=="0")
  {
    errorMessage("请输入合法的" + desc +"\n类型为日期，格式为YYYY-MM-DD 或者YYYYMMDD");
    field.value="";
    field.focus();
    field.select();
    return false;
  }
  return true;
}
//增加车型的查询页面
function queryModelCode(riskcode,index)
{
  var strURL = "/claim/common/certainLoss/car/UIModelCodeQueryInput.jsp?riskcode=" + riskcode + "&index=" + index;
  
  window.open(strURL,'查询车型代码','width=750,height=400,top=50,left=80,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
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
    errorMessage("^为系统保留字符，不允许输入！");
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
    errorMessage(strDesc+"输入的内容超长！\n"+strDesc+"的最大长度为"+intMaxlength+"个字符！\n一个中文占两个字符\n请重新输入！");
    field.focus();
    field.select();
    return false;
  }
  return true;
}
//校验分钟小时
function checkMin(field){
	var vMin = field.value;
	if(vMin !="" &&(vMin<0 || vMin>59)){
		errorMessage("请输入合法的分钟数0~59!"); 
        field.value = "";      
        return false;
	}
}
//校验小时
function checkHour(field){
	var vHour = field.value;
	if(vHour !="" &&(vHour<0 || vHour>23)){
		errorMessage("请输入合法的小时数0~23!"); 
        field.value = "";      
        return false;
	}
}

//对输入域按键时的整数校验
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
     /** Map 大小 **/  
     var size = 0;  
     /** 对象 **/  
     var entry = new Object();  
       
     /** 存 **/  
     this.put = function (key , value)  
     {  
         if(!this.containsKey(key))  
         {  
             size ++ ;  
         }  
         entry[key] = value;  
     }  
       
     /** 取 **/  
     this.get = function (key)  
     {  
         return this.containsKey(key) ? entry[key] : null;  
     }  
       
     /** 删除 **/  
     this.remove = function ( key )  
     {  
         if( this.containsKey(key) && ( delete entry[key] ) )  
         {  
             size --;  
         }  
     }  
       
     /** 是否包含 Key **/  
     this.containsKey = function ( key )  
     {  
         return (key in entry);  
     }  
       
     /** 是否包含 Value **/  
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
       
     /** 所有 Value **/  
     this.values = function ()  
     {  
         var values = new Array();  
         for(var prop in entry)  
         {  
             values.push(entry[prop]);  
         }  
         return values;  
     }  
       
     /** 所有 Key **/  
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
       
     /* 清空 */  
     this.clear = function ()  
     {  
         size = 0;  
         entry = new Object();  
     }  
 } 

//触发targetchange事件
function fireChangeComm(target){
   
    //触发change事件
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

