<%@page import="com.sinosoft.sysframework.reference.*"%>

<html>
<head>
  <title>�鿴������Ϣ</title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  
  <script language='javascript'>
  	function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var strBizNo     =fm.PolicyNo.value;
     var BizNo = trim(strBizNo);
     var RiskCode  = BizNo.substring(1,5);
     var damageDate=fm.DamageStartDate.value;
     if(trim(BizNo).length==0)
     {
     	  alert("�����뱣����!");
     }
     if(trim(damageDate).length==0)
     {
     	  alert("�������������!");
     }
     else
     {
     	  var CoreWebUrl=fm.txtCoreWebUrl.value;
        var vURL = CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
        window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
     }
    }
  </script>
</head>
<%
  //ȡ����ϵͳ�ĵ�ַ
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
%>
<body>
	<form name="fm">
		<input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>"> 
		<table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
			<tr>
				<td height=55 style="font-family:����; font-size:14pt;text-align:center" colspan="2">����ʱ������Ϣ</td>
			</tr>
			<tr>
				<td align="center" width="30%">�����ţ�</td>
				<td>
					<input class="common" type='text' maxlength='25' name='PolicyNo'>
				</td>
		  </tr>
		  <tr>
				<td align="center" width="30%" >�������ڣ�</td>
				<td>
					<input class="common" type='text' maxlength='25' name='DamageStartDate' description="��������" onblur="checkFullDate(this)">
				</td>
		  </tr>
		  <tr>
		  	<td></td>
		  	<td>���ڸ�ʽΪYYYY-MM-DD ����YYYYMMDD</td>
		  </tr>
		  <tr>
		  	<td colspan="2" align="center">
		  		<input type=button class="bigbutton"  value="�鿴" onclick="backWardPolicy();">
		  	</td>
		  </tr>
		</table>
	</form>
</body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html>