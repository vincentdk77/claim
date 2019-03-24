<%@page contentType="text/html; charset=GBK" %>
<%@page import="com.sinosoft.utility.string.*"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools"%>
<%
  ChgDate idate = new ChgDate();  
  String nowDate = idate.getCurrentTime("yyyy-MM-dd");
  String startTime = "";
  String endTime = "";
  //取查询条件的时间段
  PubTools pubTools = new PubTools();
  if(nowDate!=null){
	  startTime = pubTools.getMonthStart(pubTools.getNextMonthFullDate(nowDate,-1),"1",0);
	  endTime = pubTools.getMonthEnd(pubTools.getNextMonthFullDate(nowDate,0),"1",0);
  }
%>
<html>
  <head>
    <title>理赔数据查询条件页面</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/payment/common/pub/InputCodePrepare.js"></script>
    <script src="/payment/sff/pub/SffCommon.js"></script> 
    <jsp:include page="/common/StaticJavascript.jsp"/>
    
    <script language=javascript>
        function submitForm(){
	    	if("" == fm.startTime.value || "" == fm.endTime.value){
	    		alert("上传日期不能为空!");
	    		return false;
	    	}
	    	if(fm.startTime.value >= "2015-09-01" && fm.dataType.value == "1"){
	    	   alert("上传日期在2015年9月1号之后的数据必须采用T+1模式进行上传!");
	    	   return false;
	    	}
	    	if("" == fm.serviceType.value){
	    	  alert("接口类型不能为空!");
	    	  return false;
	    	}
	    	if("" == fm.requestType.value){
	    	  alert("请求类型不能为空!");
	    	  return false;
	    	}
	    	if("" == fm.uSize.value || 0==fm.uSize.value){
	    	 alert("上传条数不能为空或0!");
	    	 return false;
	    	}
	    	if(fm.endTime.value < fm.startTime.value){
	    	 alert("上传的截止时间应当大于上传的起始时间!");
	    	 return false;
	    	}
	    	if("2" == fm.requestType.value){
	    	  if(fm.uSize.value !=1){
	    	    alert("修正请求上传数据时，上传条数只能为1!");
	    	    return false;
	    	  }
	    	}
	    	fm.submit();
	    }
    	function resetForm(){
      		fm.reset();
    	}
    	
//检查日期输入域
function checkFullDateH(field){
  //field.value = trim(field.value);
  var strValue = field.value;
  var desc   = field.description;
  //如果description属性不存在，则用name属性
  if(desc==null)
    desc = field.name;
  if(strValue==""){
    return false;
  }

  if(isNumericLocal(strValue )){
    if(strValue.length>8 || strValue.length<6){
      alert("系统信息:\n\n请输入合法的" + desc +"\n类型为日期，格式为YYYY/MM/DD 或者YYYYMMDD");
      field.value="";
      field.focus();
      field.select();
      return false;
    }
    if(strValue.length>6){
      strValue = strValue.substring(0,4) + '-' + strValue.substring(4,6) + '-' + strValue.substring(6);
      field.value = strValue;
    }
  }

  if( !isDateLocal(strValue,'-') && !isDateLocal(strValue)){
    alert("系统信息:\n\n请输入合法的" + desc +"\n类型为日期，格式为YYYY/MM/DD 或者YYYYMMDD");
    field.value="";
    field.focus();
    field.select();
    return false;
  }
  return true;
}

//对输入域是否是日期的校验，splitChar参数缺省为"-"
function isDateLocal(date,splitChar)
{
  var charSplit = (splitChar==null?"-":splitChar);
  var strValue = date.split(charSplit);

  if(strValue.length!=3) return false;
  if(!isIntegerLocal(strValue[0]) || !isIntegerLocal(strValue[1]) || !isIntegerLocal(strValue[2]) ) return false;

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

//对输入域是否是整数的校验,即只包含字符0123456789
function isIntegerLocal(strValue)
{
  var result = regExpTestLocal(strValue,/\d+/g);
  return result;
}

//对输入域是否是数字的校验
function isNumericLocal(strValue)
{
  var result = regExpTestLocal(strValue,/\d*[.]?\d*/g);
  return result;
}

/**
 * 正则表达式测试
 * @param source 传人字符串
 * @param re 正则表达式
 * @return 正则表达式测试结果
 */
function regExpTestLocal(resource,re)
{
  var result = false;

  if(resource==null || resource=="")
    return false;

  if(resource==re.exec(resource))
    result = true;

  return result;
}
    	
    </script>
  </head>

  <body>
    <form name="fm" method="post" action="AgriZYCheShi.jsp">
  <table class=common align=center cellpadding="5" cellspacing="1">
    <tr>
      <td class=formtitle colspan="4">农险平台理赔数据上传</td>
    </tr>
    <tr>
      <td class=title>
        上传日期 从：</td>
      <td class="input">
        <select class=tag name="VoucherNoSign">
          <option value=">=">>=</option>
        </select>
        <input type="text" name="startTime" class="query" maxlength="22" onBlur="checkFullDateH(this)" value="<%=startTime %>"></td>
      <td class="title">
        到：</td>
      <td class="input">
        <select class=tag name="VoucherNoSign1">
          <option value="<="><=</option>
        </select>
        <input type="text" name="endTime" class="query" maxlength="22" onBlur="checkFullDateH(this)" value="<%=endTime %>" ></td>
    </tr>
    
    <tr>
      <td class="title">数据类型：</td>
       <td class="input"> 
          <select class=tag name="dataType">
          <option value="1">历史数据</option>
          <option value="2">T+1数据</option>
        </select>
       </td>
       <td class="title">上传最大条数：</td>
       <td> <input type="text" name="uSize"  onBlur="" onkeyup="value=value.replace(/[^\d.]/g,'')"> </td>
    </tr>
      <tr>
     <td class='title' width="15%">农险接口：</td>
	 <td class='input' width="25%">
	    <select name="serviceType" style="width:82%">
		<option value="">--请选择--</option>
		<option value="claim">立案</option>
		<option value="case">赔案</option>
		<option value="cancel">注销/拒赔(立案)</option>
		<option value="prepaid">预赔案</option>
	    </select>
	 <font color="red">*</font>
	 <td class='title' width="15%">请求类型：</td>
	 <td class='input' width="25%">
	    <select name='requestType' style="width:82%">
	    <option value="">--请选择--</option>
	    <option value="1">正常请求</option>
	    <option value="2">修正请求</option>
	    </select>
	</td>
    </tr>
   <!--  
    <tr>
      <td class=input colspan=4><font color="#ED1B24">**日期输入格式：YYYY-MM-DD 或者 YYYYMMDD</font></td>
    </tr>
    -->
    </table>
    <table width=100%><tr>
      <td width=50% align=center>
        <Input name="buttonSubmit" type="button" alt="上传" value="上 传" class=button  onclick="submitForm();" 
                      src="/payment/images/butQuery.gif" >
      </td>
      <td width=50% align=center>
        <Input name="buttonCancel" type="button" alt="重置" value="重 置" class=button  onclick="resetForm()" 
                      src="/payment/images/butReset.gif" >
      </td>
    </tr>
  </table>
  </form>
  </body>
</html>
