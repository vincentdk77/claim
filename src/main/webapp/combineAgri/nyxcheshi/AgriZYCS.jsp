<%@page contentType="text/html; charset=GBK" %>
<%@page import="com.sinosoft.utility.string.*"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools"%>
<%
  ChgDate idate = new ChgDate();  
  String nowDate = idate.getCurrentTime("yyyy-MM-dd");
  String startTime = "";
  String endTime = "";
  //ȡ��ѯ������ʱ���
  PubTools pubTools = new PubTools();
  if(nowDate!=null){
	  startTime = pubTools.getMonthStart(pubTools.getNextMonthFullDate(nowDate,-1),"1",0);
	  endTime = pubTools.getMonthEnd(pubTools.getNextMonthFullDate(nowDate,0),"1",0);
  }
%>
<html>
  <head>
    <title>�������ݲ�ѯ����ҳ��</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/payment/common/pub/InputCodePrepare.js"></script>
    <script src="/payment/sff/pub/SffCommon.js"></script> 
    <jsp:include page="/common/StaticJavascript.jsp"/>
    
    <script language=javascript>
        function submitForm(){
	    	if("" == fm.startTime.value || "" == fm.endTime.value){
	    		alert("�ϴ����ڲ���Ϊ��!");
	    		return false;
	    	}
	    	if(fm.startTime.value >= "2015-09-01" && fm.dataType.value == "1"){
	    	   alert("�ϴ�������2015��9��1��֮������ݱ������T+1ģʽ�����ϴ�!");
	    	   return false;
	    	}
	    	if("" == fm.serviceType.value){
	    	  alert("�ӿ����Ͳ���Ϊ��!");
	    	  return false;
	    	}
	    	if("" == fm.requestType.value){
	    	  alert("�������Ͳ���Ϊ��!");
	    	  return false;
	    	}
	    	if("" == fm.uSize.value || 0==fm.uSize.value){
	    	 alert("�ϴ���������Ϊ�ջ�0!");
	    	 return false;
	    	}
	    	if(fm.endTime.value < fm.startTime.value){
	    	 alert("�ϴ��Ľ�ֹʱ��Ӧ�������ϴ�����ʼʱ��!");
	    	 return false;
	    	}
	    	if("2" == fm.requestType.value){
	    	  if(fm.uSize.value !=1){
	    	    alert("���������ϴ�����ʱ���ϴ�����ֻ��Ϊ1!");
	    	    return false;
	    	  }
	    	}
	    	fm.submit();
	    }
    	function resetForm(){
      		fm.reset();
    	}
    	
//�������������
function checkFullDateH(field){
  //field.value = trim(field.value);
  var strValue = field.value;
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;
  if(strValue==""){
    return false;
  }

  if(isNumericLocal(strValue )){
    if(strValue.length>8 || strValue.length<6){
      alert("ϵͳ��Ϣ:\n\n������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY/MM/DD ����YYYYMMDD");
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
    alert("ϵͳ��Ϣ:\n\n������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY/MM/DD ����YYYYMMDD");
    field.value="";
    field.focus();
    field.select();
    return false;
  }
  return true;
}

//���������Ƿ������ڵ�У�飬splitChar����ȱʡΪ"-"
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

//���������Ƿ���������У��,��ֻ�����ַ�0123456789
function isIntegerLocal(strValue)
{
  var result = regExpTestLocal(strValue,/\d+/g);
  return result;
}

//���������Ƿ������ֵ�У��
function isNumericLocal(strValue)
{
  var result = regExpTestLocal(strValue,/\d*[.]?\d*/g);
  return result;
}

/**
 * ������ʽ����
 * @param source �����ַ���
 * @param re ������ʽ
 * @return ������ʽ���Խ��
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
      <td class=formtitle colspan="4">ũ��ƽ̨���������ϴ�</td>
    </tr>
    <tr>
      <td class=title>
        �ϴ����� �ӣ�</td>
      <td class="input">
        <select class=tag name="VoucherNoSign">
          <option value=">=">>=</option>
        </select>
        <input type="text" name="startTime" class="query" maxlength="22" onBlur="checkFullDateH(this)" value="<%=startTime %>"></td>
      <td class="title">
        ����</td>
      <td class="input">
        <select class=tag name="VoucherNoSign1">
          <option value="<="><=</option>
        </select>
        <input type="text" name="endTime" class="query" maxlength="22" onBlur="checkFullDateH(this)" value="<%=endTime %>" ></td>
    </tr>
    
    <tr>
      <td class="title">�������ͣ�</td>
       <td class="input"> 
          <select class=tag name="dataType">
          <option value="1">��ʷ����</option>
          <option value="2">T+1����</option>
        </select>
       </td>
       <td class="title">�ϴ����������</td>
       <td> <input type="text" name="uSize"  onBlur="" onkeyup="value=value.replace(/[^\d.]/g,'')"> </td>
    </tr>
      <tr>
     <td class='title' width="15%">ũ�սӿڣ�</td>
	 <td class='input' width="25%">
	    <select name="serviceType" style="width:82%">
		<option value="">--��ѡ��--</option>
		<option value="claim">����</option>
		<option value="case">�ⰸ</option>
		<option value="cancel">ע��/����(����)</option>
		<option value="prepaid">Ԥ�ⰸ</option>
	    </select>
	 <font color="red">*</font>
	 <td class='title' width="15%">�������ͣ�</td>
	 <td class='input' width="25%">
	    <select name='requestType' style="width:82%">
	    <option value="">--��ѡ��--</option>
	    <option value="1">��������</option>
	    <option value="2">��������</option>
	    </select>
	</td>
    </tr>
   <!--  
    <tr>
      <td class=input colspan=4><font color="#ED1B24">**���������ʽ��YYYY-MM-DD ���� YYYYMMDD</font></td>
    </tr>
    -->
    </table>
    <table width=100%><tr>
      <td width=50% align=center>
        <Input name="buttonSubmit" type="button" alt="�ϴ�" value="�� ��" class=button  onclick="submitForm();" 
                      src="/payment/images/butQuery.gif" >
      </td>
      <td width=50% align=center>
        <Input name="buttonCancel" type="button" alt="����" value="�� ��" class=button  onclick="resetForm()" 
                      src="/payment/images/butReset.gif" >
      </td>
    </tr>
  </table>
  </form>
  </body>
</html>
