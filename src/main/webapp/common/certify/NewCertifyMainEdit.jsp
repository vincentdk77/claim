<%--
****************************************************************************
* DESC       ���������Ϣ�ӿ����ҳ��[ ��֤�ռ� ]
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-07-05
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@page import="com.sinosoft.report.utility.GetNewECMUtil"%>
<%@ page import="java.util.*"%>
<%@page import="com.sinosoft.utiall.dbsvr.*"%>
<%@page import="com.sinosoft.image.bl.facade.*"%>
<%@page import="com.sinosoft.image.dto.domain.*"%>
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%> 
<%@page import="com.sinosoft.platform.dto.domain.PrpDuserDto"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%
	String xml = "";
	String code = "";
	String usercode= "";
	PrpDuserDto pdd = new PrpDuserDto();
	DBPrpDuser dbPrpDuser = new DBPrpDuser();
	DBPrpDcompany dbprpDcompany = new DBPrpDcompany();
	int t = 0;
	String username="";
	String comcode = "";
	String comname= "";
	BLPrpdimagecodeFacade blPrpdimagecodeFacade = new BLPrpdimagecodeFacade();
	BLPrpdcertifycheckFacade blPrpdcertifycheckFacade = new BLPrpdcertifycheckFacade();
	PrpdimagecodeDto prpdimagecodeDto = new PrpdimagecodeDto();
	String role = "";
	String appcode = "";
	String appname = "";  
	PrpLcertifyCollectDto pcDto =  (PrpLcertifyCollectDto)request.getAttribute("prpLcertifyCollectDto");
	UserDto   userDto     = (UserDto)session.getAttribute("user");
	if(userDto == null)
	{
		System.err.println("UserΪ��");
		usercode = "0000000000";
		username = "����Ա";
		comcode = "0000000000";
		comname = "��Ԫũҵ���չɷ����޹�˾";
		
	}
	else
	{
		usercode= userDto.getUserCode();  //�û�
		t = dbPrpDuser.getInfo(usercode);
		username=dbPrpDuser.getUserName();
		t = dbprpDcompany.getInfo(dbPrpDuser.getComCode());
		comcode = dbPrpDuser.getComCode();
		comname= dbprpDcompany.getComCName();
	}
	String strRiskCode = pcDto.getRiskCode();
	
	
	//System.err.println("usercode:"+usercode);
	
	String ECM_URL =  AppConfig.get("sysconst.ECM_URL");
	GetNewECMUtil getNewECMUtil=new GetNewECMUtil();
    String ECM_URL_NEW ="";
   	String ECM_KEY ="";
    String ECM_JS_URL = "";
    String ECM_FLAG = getNewECMUtil.get();//0Ϊ��Ӱ��ϵͳ��1Ϊ��Ӱ��ϵͳ
    if("1".equals(ECM_FLAG)){
    	   ECM_URL_NEW = AppConfig.get("sysconst.ECM_URL_NEW");
      	   ECM_JS_URL = AppConfig.get("sysconst.ECM_JS_URL");
      	   ECM_KEY = AppConfig.get("sysconst.ECM_KEY");
      }
	String result = "";
	
	if(usercode == null || "".equals(usercode))
	{
		UserDto   userDto1     = (UserDto)session.getAttribute("userEcm");
		if(userDto1 == null)
		{
			usercode = "0000000000";
			username = "����Ա";
			comcode = "0000000000";
			comname = "��Ԫũҵ���չɷ����޹�˾";
		}
		else
		{
			usercode = userDto1.getUserCode();
			username = userDto1.getUserName();
			comcode = userDto1.getComCode();
			comname = userDto1.getComName();
		}

	}
%>
 <script language="javascript">

	  //��ʾ����
	  function showPolicy(strPolicyNo,strRiskCode)
	  {
	  var versionType = fm.versionType.value;
     var versionNo = fm.versionNo.value;
     var CoreWebUrl=fm.txtCoreWebUrl.value;
     var vURL = "";
              if("A01" == versionNo || versionNo == "" )
	 	{
	 	  vURL = CoreWebUrl+'/' + fm.prpLcertifyCollectRiskCode.value + '/tbcbpg/UIPrPoEn' +  fm.prpLcertifyCollectRiskCode.value + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ fm.prpLcertifyCollectPolicyNo.value+'&RiskCode='+  fm.prpLcertifyCollectRiskCode.value;
	 	}
	  	else
		{
		 vURL = CoreWebUrl+'/' + fm.prpLcertifyCollectRiskCode.value + "-" + versionType + "-" + versionNo  + '/tbcbpg/UIPrPoEn' +  fm.prpLcertifyCollectRiskCode.value + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ fm.prpLcertifyCollectPolicyNo.value+'&RiskCode='+  fm.prpLcertifyCollectRiskCode.value;
		}
              window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0'); 
	  }
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLclaimPolicyNo.value;
     var RiskCode  =fm.prpLclaimRiskCode.value;
     var damageDate=fm.damageDate.value;
     var CoreWebUrl=fm.txtCoreWebUrl.value;
     var versionType = fm.versionType.value;
     var versionNo = fm.versionNo.value;
     var vURL ="";
		if("A01" == versionNo || versionNo == "" )
	 	{
	 	 vURL = CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
	 	}
	  	else
		{
		 vURL = CoreWebUrl +'/' + RiskCode + "-" + versionType + "-" + versionNo + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
		}
		window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}

      //�ϴ��ļ� �¾�Ӱ�����ϵ������
      function doUploadFile(businessNo){
        // var oldAction = fm.action;
        // var oldTarget = fm.target;
        // fm.action="/prpall/applet/ViewApplet.jsp?businessNo="+businessNo+"&riskCode="+riskCode+"&uploadYear="+uploadYear+"&userCode="+userCode+"&userName="+userName;
        // fm.target="fraSubmit";
        // fm.submit();
        // fm.action=oldAction;
        // fm.target=oldTarget;
          <%
		  prpdimagecodeDto = blPrpdimagecodeFacade.findByPrimaryKey(strRiskCode,"0000000000");
		  role = prpdimagecodeDto.getClaimrole();
		  appcode=prpdimagecodeDto.getClaimcode();
		  code = "ECM0001";
		  appname=prpdimagecodeDto.getClaimname();
          %>
          fm2.code.value = "<%=code%>";
		  var s = "";
		  s += "<?xml version='1.0' encoding='UTF-8'?><root><BASE_DATA>";
		  s += "<USER_CODE>";
		  s += "<%=usercode%>";
		  s += "</USER_CODE>";
		  
		  s += "<USER_NAME>";
		  s += "<%=username%>";
		  s += "</USER_NAME>";
		  
		  s += "<ORG_CODE>";
		  s += "<%=comcode%>";
		  s += "</ORG_CODE>";
		  
		  s += "<ORG_NAME>";
		  s += "<%=comname%>";
		  s += "</ORG_NAME>";
		  
		  s += "<ROLE_CODE>";
		  s += "<%=role%>";
		  s += "</ROLE_CODE>";
		  
		  s += "</BASE_DATA><META_DATA><BATCH>";
		  
		  s += "<APP_CODE>";
		  s += "<%=appcode%>";
		  s += "</APP_CODE>";
		  
		  s += "<APP_NAME>";
		  s += "<%=appname%>";
		  s += "</APP_NAME>";
		  
		  s += "<BUSI_NO>";
		  s += businessNo;
		  s += "</BUSI_NO>";
		  
		  s += "</BATCH></META_DATA></root>";
		  
		  fm2.xml.value = s;
          var ECM_FLAG= fm.ECM_FLAG.value; 
		  if("1" == ECM_FLAG){
		  var url = fm.ECM_URL_NEW.value;
		  var requestXML=fm2.xml.value;
		  var eclKey = fm.ECM_KEY.value;
		     ECM_POST(url,
		     	   { format:'xml', code:'ECM0001', xml:requestXML } 
		     	     ,1000,eclKey);
		  }else{
		  var url = fm.ECM_URL.value;
	      fm2.action=url;
	      fm2.method = "post";
	      fm2.target = "_blank";
	      document.charset='utf-8';
	      fm2.submit();
	      document.charset='gbk';
      }
  }
	  /**
	  *@description �鿴&����δɾ���ļ� 
	  *@param       businessNo
	  */
	  function doViewFile(businessNo){
	    //var viewFile = "NoDeleteFile";
	    //window.open( "/prpall/commonship/upload/CertifyViewFile.jsp?businessNo="+businessNo+"&viewFile="+viewFile,"winName","scrollbars=1,resizable=yes");
	   	  <%
		  prpdimagecodeDto = blPrpdimagecodeFacade.findByPrimaryKey(strRiskCode,"0000000000");
		  role = prpdimagecodeDto.getClaimrole();
		  appcode=prpdimagecodeDto.getClaimcode();
		  code = "ECM0002";
		  appname=prpdimagecodeDto.getClaimname();
		  System.err.println(usercode + username + comcode+comname);
       	  %>
       	  fm2.code.value = "<%=code%>";
		  var s = "";
		  s += "<?xml version='1.0' encoding='UTF-8'?><root><BASE_DATA>";
		  s += "<USER_CODE>";
		  s += "<%=usercode%>";
		  s += "</USER_CODE>";
		  
		  s += "<USER_NAME>";
		  s += "<%=username%>";
		  s += "</USER_NAME>";
		  
		  s += "<ORG_CODE>";
		  s += "<%=comcode%>";
		  s += "</ORG_CODE>";
		  
		  s += "<ORG_NAME>";
		  s += "<%=comname%>";
		  s += "</ORG_NAME>";
		  
		  s += "<ROLE_CODE>";
		  s += "<%=role%>";
		  s += "</ROLE_CODE>";
		  
		  s += "</BASE_DATA><META_DATA><BATCH>";
		  
		  s += "<APP_CODE>";
		  s += "<%=appcode%>";
		  s += "</APP_CODE>";
		  
		  s += "<APP_NAME>";
		  s += "<%=appname%>";
		  s += "</APP_NAME>";
		  
		  s += "<BUSI_NO>";
		  s += businessNo;
		  s += "</BUSI_NO>";
		  
		  s += "</BATCH></META_DATA></root>";
		  
		  fm2.xml.value = s;
	   	  var ECM_FLAG= fm.ECM_FLAG.value; 
		  if("1" == ECM_FLAG){
		  var url = fm.ECM_URL_NEW.value;
		  var requestXML=fm2.xml.value;
		  var eclKey = fm.ECM_KEY.value;
		     ECM_POST(url,
		     	   { format:'xml', code:'ECM0002', xml:requestXML } 
		     	     ,1000,eclKey);
		  }else{
		  var url = fm.ECM_URL.value;
	      fm2.action=url;
	      fm2.method = "post";
	      fm2.target = "_blank";
	      document.charset='utf-8';
	      fm2.submit();
	      document.charset='gbk';
	  } 
 }
	  </script>



<table align="center" cellpadding="5" cellspacing="0" class="common">
  <tr>
  
          <!-- Modify By wangli add begin 20050328-->
   <td class=button ><input class=button  type="button" width="80" height="21" name="messageSave"  value="���⹵ͨ" onclick="openWinSaveQuery(fm.RegistNo.value,'<bean:write name='prpLcertifyCollectDto' property='policyNo'/>',fm.riskCode.value,'certi','','registNo',fm.RegistNo.value);"></td>
     <%--
     <td><input type="button" name="prpLmessageSave" value="׫д����" onclick="openWinSave()"></td> 
     <td><input type="button" name="prpLmessageView" value="�鿴����" onClick="openWinQuery()"></td> 
     --%>
      <!-- Modify By wangli add end 20050328-->
   <!--<td class=button><input class=button type="button" name="buttonCertifyDirect" value="�����嵥" onClick="doCertifyDirect('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>','certi')"></td> -->
   <!--- add by zhaolu 20060807 zhaolu start --->
    <td class=button><input class=button type="button" name="buttonCertifyDirect" value="������֪" onClick="certifyDirectList('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>','certi')"></td> 
   <!--- add by zhaolu 20060807 zhaolu end --->
  </tr> 
</table> 
   <table class=common cellpadding="5" cellspacing="1">
   <tr>
    <td class="formtitle">��֤�ռ�</td>
    </tr>
    </table >
 
  <table border="0" align="center" cellpadding="5" cellspacing="1"  class="title" style="width:100%">
    
    <tr>
      <td class="title" >��������:</td>  
      <td class="input"  >
        <input type="text" name="RegistNo" class="readonly" readonly="true" style="width:160px" value="<bean:write name='prpLcertifyCollectDto' property='businessNo'/>">
        <input type="button" name="btRegistRelate" value="������Ϣ" class='bigbutton' onclick="relateRegist();return false;">
      </td> 
      <td class="title" >��������:</td>  
      <td class="input"  >
        <input type="text" name="PolicyNo" class="readonly" readonly="true" style="width:160px" value="<bean:write name='prpLcertifyCollectDto' property='policyNo'/>">
                <input type="button" name="btPolicyRelate" value="������Ϣ" class='bigbutton' onclick="showPolicy(fm.PolicyNo.value);return false;"> 
         <input type="hidden" name="prpLcertifyCollectNoSubmitMsg" class="readonly" readonly="true" value="<bean:write name='prpLcertifyCollectDto' property='noSubmitMsg'/>">     
        <input type="hidden" name="prpLcertifyCollectBusinessNo" value="<bean:write name='prpLcertifyCollectDto' property='businessNo'/>"> 
        <input type="hidden" name="prpLcertifyCollectPolicyNo" value="<bean:write name='prpLcertifyCollectDto' property='policyNo'/>"> 
        <input type="hidden" name="prpLcertifyCollectLossItemCode" value="<bean:write name='prpLcertifyCollectDto' property='lossItemCode'/>"> 
        <input type="hidden" name="prpLcertifyCollectLossItemName" value="<bean:write name='prpLcertifyCollectDto' property='lossItemName'/>"> 
        <input type="hidden" name="prpLcertifyCollectPicCount" value="<bean:write name='prpLcertifyCollectDto' property='picCount'/>"> 
        <input type="hidden" name="prpLcertifyCollectStartDate" value="<bean:write name='prpLcertifyCollectDto' property='startDate'/>"> 
        <input type="hidden" name="prpLcertifyCollectStartHour" value="<bean:write name='prpLcertifyCollectDto' property='startHour'/>"> 
        <input type="hidden" name="prpLcertifyCollectEndDate" value="<bean:write name='prpLcertifyCollectDto' property='endDate'/>"> 
        <input type="hidden" name="prpLcertifyCollectEndHour" value="<bean:write name='prpLcertifyCollectDto' property='endHour'/>"> 
        <input type="hidden" name="prpLcertifyCollectOperatorCode" value="<bean:write name='prpLcertifyCollectDto' property='operatorCode'/>"> 
        <input type="hidden" name="prpLcertifyCollectCaseFlag" value="<bean:write name='prpLcertifyCollectDto' property='caseFlag'/>"> 
        <input type="hidden" name="prpLcertifyCollectFlag" value="<bean:write name='prpLcertifyCollectDto' property='flag'/>"> 
        <input type="hidden" name="prpLcertifyCollectUploadYear" value="<bean:write name='prpLcertifyCollectDto' property='uploadYear'/>"> 
        <input type="hidden" name="prpLcertifyCollectRiskCode" value="<bean:write name='prpLcertifyCollectDto' property='riskCode'/>"> 
        <!--     ������,��ȡ��ַ -->
        <input type="hidden" name="ECM_URL" value="<%=ECM_URL%>">
		<input type="hidden" name="ECM_URL_NEW" value="<%=ECM_URL_NEW%>">
		<input type="hidden" name=ECM_KEY value="<%=ECM_KEY%>">
		<input type="hidden" name="ECM_FLAG" value="<%=ECM_FLAG%>">
        
        <% //modify by lixiang add 20050304 start
        //reason:�������ԣ��ʹ��������õĲ���
        %> 
        <input type="hidden" name="policyNo" value="<%=request.getParameter("policyNo")%>">
        <input type="hidden" name="riskCode" value="<%=request.getParameter("riskCode")%>">        
        <input type="hidden" name="swfLogFlowID" value="<%= request.getParameter("swfLogFlowID") %>">
        <input type="hidden" name="swfLogLogNo" value="<%= request.getParameter("swfLogLogNo") %>">
          <input type="hidden" name="editType" value="<%= request.getParameter("editType") %>">
</td>
</tr>
</table>
<table cellpadding="5" cellspacing="1" border="0"  class="common">
  <tr>
    <td class="input" style="width:100%" colspan="2">
      <table cellpadding="5" cellspacing="2" border="0"  class="common" >
         <tr> 
          <td class="centertitle" style="width:100%" colspan="6">��֤�ϴ�</td>                                                                                     
        </tr>  
        <tr> 
           <td class=button><input class=button type="button" name="buttonCertifyUpload" value="��֤�ϴ�" onClick="doUploadFile('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>')"></td>                                                                                  
           <td class=button><input class=button type="button" name="buttonCertifyView" value="��֤�鿴" onClick="doViewFile('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>')"></td>                                                                                       
        </tr>
      </table>    
    </td>  
  </tr> 
  </table>
 <%
  String nodeType=request.getParameter("nodeType");
  if(nodeType.equals("check")||nodeType.equals("certa")||nodeType.equals("verif")){}else{
%> 

  <table  border="0" cellpadding="5" cellspacing="1"  class="common" >   
    <tr>
      <td class="title" colspan="4" style="width:100%">�����������</td>
    </tr> 
    <tr>       
      <td class="title" style="text-align:center;" colspan="0" colspan="4">
       <textarea style="wrap:hard" rows="10" cols="60" name="prpLcertifyCollectContent"  maxLength="255" onblur="checkLength1(this);" description="�����������"><bean:write name='prpLcertifyCollectDto' property='content'/></textarea>
      </td>
    </tr> 
  </table> 
   <%
    }
   %>
  <input type="hidden" name="nodeTypeUpload" value="certi">
    <!-- ������Ӱ���js�ļ� -->
  <script type="text/javascript" src="<%= ECM_JS_URL %>"></script>

