<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@ page language="java" import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String nowDate = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY).toString();;
System.err.println("nowDate==="+nowDate);
String OperateDate = "";
String OperateDateEnd = "";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//ȡ��ѯ������ʱ���
if(nowDate!=null){
	OperateDate = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY).addDay(-7).toString();
	OperateDateEnd = sdf.format(new Date());
}

String OperateDateLater = new DateTime(OperateDateEnd,DateTime.YEAR_TO_DAY).addMonth(-3).toString();
System.err.println("ʱ��+"+OperateDateLater);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
      <link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
    <title>֧����Ϣ��ѯ</title>
   <jsp:include page="/common/pub/StaticJavascript.jsp" />
   <script language=JavaScript src="/claim/common/pub/UISelectTree.js"></script>
  <script  src="/claim/js/WdatePicker.js" ></script>
  <script  type="text/javascript">
    	function submitForm(){
   		var Flag=false;
   	    var checkCount = 0;
    	      if(fm.payType.length == null)
    	      {
    	        if(fm.payType.checked)
    	        {
    	          Flag=true;
    	        }
    	      }else
    	      {
    	        for (var i = 0;i < fm.payType.length;i++)
    	        {
    	          if(fm.payType[i].checked)
    	          {
    	            Flag=true;
    	          }
    	        }
    	      }
    	      if(Flag==false)
    	      {
    	        alert("֧�����Ͳ���Ϊ�գ�");
    	        return;
    	      }
    	      if(null==fm.inputDateStrat.value||""==fm.inputDateStrat.value ||null==fm.inputDateEnd.value||""==fm.inputDateEnd.value){
      	    	alert("����ͨ��ʱ�䲻��Ϊ�գ�");
        	        return;
      	      }
    	    //if(checkDate(fm.OperateDateLater.value,fm.inputDateStrat.value)){
    	    	if(true){
      	    	fm.buttonSubmit.disabled = true;
      		  	setTimeout('reserveButton()',10000);
      		  	fm.action ="/claim/paymainMergeAddQuery.do";
      		  	fm.submit();//�ύ
      	      }
    		  //return true ;
    	}
    	function reserveButton(){
    		fm.buttonSubmit.disabled = false;
    	}
    	
    	function checkDate(sdate1,edate2){
    	       if(sdate1!=""&&edate2!="")
    	       { //���벻Ϊ��ʱ��
    	           // ���ַ������д���
    	           // �� - / �� �ո� Ϊ�ָ���, �������ַ����ָ�Ϊ����
    	          var date1 = sdate1.split("-");
    	          var date2 = edate2.split("-");
    	           // ���� Date ����
    	           var myDate1 = new Date(date1[0],date1[1],date1[2]);
    	           var myDate2 = new Date(date2[0],date2[1],date2[2]);
    	           
    	           // ��������бȽ�
    	           if (myDate1 <= myDate2)
    	           {
    	                return true;
    	           }else
    	           {
    	             alert ("��ʾ: ʱ�������ô��������£�");
    	             return false;
    	           }
    	       }
    	       else
    	       {
    	             return true;
    	       }
    	     }
    </script>
  </head>
 <body class="interface" >
  <form name="fm" action=""  method="post"  target ="showlist">
  	<div id="displayInfoDiv" name="displayInfoDiv" style="position:absolute; display:none;border:1px solid #7F9DB9; width: 136px;height:200px;background-color:white;overflow:auto;z-index=10;" onmouseover="javascript:clearTimeout(delayId);" onmouseout="hideInfo('0','displayInfoDiv','divShim');">
	</div>
	<iframe id="divShim" name="divShim" src="javascript:false;" scrolling="no" frameborder="0" style="position:absolute;display:none;top:0px;left:0px;"></iframe>
  		<input type="hidden" name="nodeType" value="apay"/>
  		<input type="hidden" name="OperateDateLater" value="<%=OperateDateLater %>"/>
   		<table  cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8" class="mycommon common">
   			<tr>
			<td colspan=4 class="tabletitle" ondblclick="showPage(RegistExtImg,paymain)">
				<IMG id="RegistExtImg" style="CURSOR: hand" onclick="showPage(this,paymain)"
					src="/claim/images/butExpandBlue.gif" name=RegistExtImg> ��ѯ����
			</td>
			</tr>
			<tbody id="paymain" >
	   			<tr>	
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="registno" name="registNos">
	           				<option value="=">=</option>
<%--	            			<option value="*">*</option>--%>
	          			</select>
	   					<input type="text" name="registNoTNew" id="registNo" class="input" style="width: 60%" >
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="policyNos" name="policyNos">
	           				<option value="=">=</option>
<%--	            			<option value="*">*</option>--%>
	          			</select>
	   					<input type="text" name="policyNo" id="policyNo" style="width: 60%" class="input" >
	   				</td>
	   			</tr>
	   			<tr>	
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="insuredNames" name="insuredNames">
<%--	            			<option value="*">*</option>--%>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="insuredName" name="insuredName" class="input" style="width:60%"/>
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">����ͨ��ʱ��</td>
	   				<td class="input" style="width:35%">
	   					<input type="text" style="width:40%" id="inputDateStrat" value="<%=OperateDate %>" name="inputDateStrat" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',autoPickDate:true,maxDate:'#F{$dp.$D(\'inputDateStrat\')}'})"/>
	   					����
						<input type='text' style="width:40%" id="inputDateEnd" value="<%=OperateDateEnd %>" name="inputDateEnd" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',autoPickDate:true,minDate:'#F{$dp.$D(\'inputDateEnd\')}'})"/>
	   				</td>
	   			</tr>
	   			<tr >
	   				<td class="title" style="width:15%;text-align:center">����</td>
	   				<td class="input" style="width:35%">
	   					<input type=hidden id="riskCode" name="riskCode" value="">
			             <div id="riskCodeDiv" style="position:relative; border:1px solid #7F9DB9; width: 240px;margin-left:2px">
			                 <input type="text" id="riskCodeName" name="riskCodeName"  style="border-width:0px; width: 215px; font-size:12px;" readonly="true" onmouseover="dispalyInfo('0','riskCodeName','riskCodeDiv','displayInfoDiv','divShim')"onmouseout=javascript:delayId=setTimeout("hideInfo('1','displayInfoDiv','divShim')",200); value=""><img style="cursor:pointer;" onClick="selectCodeTree(fm.riskCode,'riskCode','1',fm.riskCodeName)" src="/claim/common/images/iconForm.gif" align="absmiddle">
			             </div>
	   				</td>	
	   				
	   				<td class="title" style="width:15%;text-align:center">֧������</td>
	   				<td class="input" style="width:35%">
	   					<input type="checkbox" name="payType" id="payType" value="P3" checked/>���
	   					<input type="checkbox" name="payType" id="payType" value="P3"/>����
	   					<input type="checkbox" name="payType" id="payType" value="P1"/>Ԥ�����
	   					<input type="checkbox" name="payType" id="payType" value="P1"/>Ԥ�����
	   					<input type="hidden" name="paymentType" value="${paymentType }"/>
	   				</td>
	   			</tr>
	   			<tr>
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<input type="checkbox" id="" name="mechanism" value="mechanism" checked/>������
	   					<input type="checkbox" id="" name="agnet" value="agnet"/>���鿱
	   				</td>
	   				<td class="title" style="width:15%;text-align:center"></td>
	   				<td class="input" style="width:35%">
	   				</td>
	   			</tr>
   			</tbody>
   			<tr>
   				<td colspan="4" class="title" style="text-align:center">
   					<input type="button" name="buttonSubmit" value="��ѯ" class="bobu" onclick="submitForm()" >
   				</td>
   			</tr>
   		</table>
   		<br>
   		<br>
   	</form>
   	<iframe name="showlist" src="/claim/DAA/payment/empty.jsp" height="100%" frameborder="0" marginheight="0" marginwidth="0" scrolling="yes" width="100%"></iframe>
  </body>
</html>
