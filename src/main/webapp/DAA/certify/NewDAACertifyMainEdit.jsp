<%@page pageEncoding="GBK"%>
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
<%@page import="java.util.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.UserDto" %>
<%@page import="com.sinosoft.utiall.dbsvr.*"%>
<%@page import="com.sinosoft.image.bl.facade.*"%>
<%@page import="com.sinosoft.image.dto.domain.*"%>
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%> 
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%
        String showtype=(String)request.getAttribute("ShowType"); 
        String strEditTypeNew = request.getParameter("editType");
        UserDto   userDto = (UserDto)session.getAttribute("user");
        System.err.println("UserΪ��");
        boolean isShowButton = true;
        //�û�û�õ�¼����ϵͳʱ������ʾ��ذ�ť(��Ҫ��˫��ϵͳ������������ͼ�����)
        if(userDto == null){
        	System.err.println("UserΪ��");
            isShowButton = false;
        }
	 int serialno=0;
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
		String strImgRiskCode = pcDto.getRiskCode();
		usercode= userDto.getUserCode();  //�û�
		System.err.println(usercode);
		t = dbPrpDuser.getInfo(usercode);
		username=dbPrpDuser.getUserName();
		t = dbprpDcompany.getInfo(dbPrpDuser.getComCode());
		comcode = dbPrpDuser.getComCode();
		comname= dbprpDcompany.getComCName();
		System.err.println(comcode);
		System.err.println(comname);
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
			usercode = userDto1.getUserCode();
			username = userDto1.getUserName();
			comcode = userDto1.getComCode();
			comname = userDto1.getComName();
		}
%>		
<script language="javascript">
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
		  prpdimagecodeDto = blPrpdimagecodeFacade.findByPrimaryKey(strImgRiskCode,"0000000000");
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
		  prpdimagecodeDto = blPrpdimagecodeFacade.findByPrimaryKey(strImgRiskCode,"0000000000");
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
  <%if(isShowButton){ %>
     <td class=button ><input class=button  type="button" width="80" height="21" name="messageSave"  value="���⹵ͨ" onclick="openWinSaveQuery(fm.RegistNo.value,<bean:write name='prpLcertifyCollectDto' property='policyNo'/>,fm.riskCode.value,'certi','','registNo',fm.RegistNo.value);"></td>
  <%} %>  
     <td class=button><input class=button type="button" name="buttonCertifyDirect" value="�����嵥" onClick="doCertifyDirect('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>','certi','<bean:write name='prpLcertifyCollectDto' property='riskCode'/>')"></td> 
     <td class=button><input class=button type="button" name="certifyDirectPrint" value="������֪" onClick="certifyDirectList('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>','certi')"></td> 
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
        <%--- Ӧ���ղ�������ʱ���α�����Ϣ
        <input type="button" name="btPolicyRelate" value="����ʱ������Ϣ" class='bigbutton' onclick="relateBeforePolicyNo('<bean:write name='prpLregistDto' property='policyNo'/>','<bean:write name='prpLregistDto' property='riskCode'/>','<bean:write name='prpLregistDto' property='damageStartDate' filter='true' />');">    
         -------------%>
      <% if(request.getAttribute("prpLregistRPolicyNo") != null){
  %>  </td>
      <td class="input">
         <input type=text name="prplCheckPolicyBzNoShow" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLregistRPolicyNo' property='policyNo'/>">
         <%--- Ӧ���ղ�������ʱ���α�����Ϣ
         <input type="button" name="btPolicyRelate" value="ǿ�Ʊ�����Ϣ" class='bigbutton' onclick="relateBeforePolicyNo('<bean:write name='prpLregistRPolicyNo' property='policyNo'/>','<bean:write name='prpLregistRPolicyNo' property='riskCode'/>','<bean:write name='prpLregistDto' property='damageStartDate' filter='true' />');">       
      	-------------%>
<%
 }
//add by zhaolu end at 2006-6-10
%>        
      </td>  
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
        <% //modify by lixiang add 20050304 end%>
      
    </tr>   
     
      
  </table>   
    <%
      
      PrpLcertifyImgDto prpLcertifyImgDto = (PrpLcertifyImgDto)request.getAttribute("prpLcertifyImgDto");
      List prpLcertifyImgDtoList =  (ArrayList)prpLcertifyImgDto.getCertifyImgList();
      
      PrpLcertifyDirectDto prpLcertifyDirectDto = (PrpLcertifyDirectDto)request.getAttribute("prpLcertifyDirectDto");
      List prpLcertifyDirectDtoList =  (ArrayList)prpLcertifyDirectDto.getCertifyDirectList();
      	
      
      ArrayList prpLpersonTraceList = (ArrayList)request.getAttribute("prpLpersonTraceList");   //add by miaowenjun 20060420
      
      List imageTypeList = (ArrayList)request.getAttribute("imageTypeList");
      ArrayList thirdPartyList = (ArrayList)request.getAttribute("thirdPartyList");
      PrpLcertifyCollectDto prpLcertifyCollectDto = (PrpLcertifyCollectDto)request.getAttribute("prpLcertifyCollectDto");
  String strRiskCode = 	prpLcertifyCollectDto.getRiskCode();  
  String relatePolicyFlag = (String)request.getAttribute("relatePolicyFlag");
  String compelPolicyFlag = (String)request.getAttribute("compelPolicyFlag");
  String compelType = "hidden";
  String businessType = "hidden";
  if("1".equals(relatePolicyFlag)) {
    businessType = "checkbox";
    compelType = "checkbox";
  }else if("1".equals(compelPolicyFlag)){
     compelType = "checkbox"; 
   }else{
    businessType = "checkbox";
   }
%>   
<%
        String strTempCount = "";
//��֤������ѭ��
  for(int k=1;k<=12;k++){  
      //ȡ�ñ���
      String strTitle = "";
      if(k==1){
        strTitle="��������";
      } else if(k==2){  
        strTitle="���յ�֤";
      }else if(k==3){  
        strTitle="�¹ʴ���֤";
      }else if(k==4){  
        strTitle="��Ժ�ṩ��֤";continue;
      }else if(k==5){  
        strTitle="��������";
      }else if(k==6){  
        strTitle="�Ʋ���ʧ����";
      }else if(k==7){  
        strTitle="��������"; 
      }else if(k==8 ){  //0502û�е�����
        if ( strRiskCode.equals("0502"))  
          {continue;}
        else{  strTitle="������������"; }
      }else if(k==9){  
        strTitle="������ȼ����"; continue;
      }else if(k==10){  
        strTitle="��ʻ֤��"; 
      }else if(k==11){  
        strTitle="��ȡ���֤��"; continue;
      }else if(k==12){  
        strTitle="��������";
      } 
      List commonList = new ArrayList();
      List commonListTemp = new ArrayList();
	  if(k==5||k==12){
	    commonList = thirdPartyList;
	  }else if(k==7){
	    commonList = prpLpersonTraceList;
	  }else{
	    commonList.add(new Object());
	    commonListTemp = thirdPartyList;
	  }
	  String subName = "";
      int no = 0;
      String name = "";
    //add by miaowenjun 20060420
    boolean flag = false;
	for(int i=0;i<prpLcertifyDirectDtoList.size();i++){
		PrpLcertifyDirectDto prpLcertifyDirectDtoFlag = (PrpLcertifyDirectDto)prpLcertifyDirectDtoList.get(i);
		if((String.valueOf(k)).length() == 1){
			if(prpLcertifyDirectDtoFlag.getTypeCode().substring(1,2).equals(String.valueOf(k))){
				flag = true;
			}	
		}else{
			if(prpLcertifyDirectDtoFlag.getTypeCode().substring(0,2).equals(String.valueOf(k))){
				flag = true;
			}
		}
	}
	if(!flag){
		continue;
	}
  	//add end by miaowenjun 20060420
      
      
       for(int index=0;index<commonList.size();index++){
          if(k==5||k==12){
            if(k==5){
            	subName = "����";
            }else{
            	subName = "��������";
            }
            PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)commonList.get(index);
            no = prpLthirdPartyDto.getSerialNo();
            name = prpLthirdPartyDto.getLicenseNo();
            if(prpLthirdPartyDto.getSerialNo() == 1){
  	            strTitle = "��ĳ�"+subName;
            }else{
            	strTitle = "���߳�"+subName;
            }
            strTitle=strTitle+"("+prpLthirdPartyDto.getLicenseNo()+")";
          }else if(k==7){
   			PrpLpersonTraceDto prplpersontraceDto = (PrpLpersonTraceDto)commonList.get(index);
   			no = prplpersontraceDto.getPersonNo();
   			name = prplpersontraceDto.getPersonName();
	        strTitle = "����������";
   			strTitle=strTitle+"("+prplpersontraceDto.getPersonName()+")";
	      }else{
	      	PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)commonListTemp.get(index);
	      	 no = 0;
            name = "claim";
	      }
        String strImageList = "";
	 int aa = 0;
          
%><table cellpadding="5" cellspacing="1" border="0"  class="common" >
  <tr>
    <td class="input"  colspan="4">
      <table cellpadding="5" cellspacing="1" border="0"  class="common">
        <tr> 
          <td class="subformtitle" style="width:10%">��Ҫ��־</td>
          <td class="centertitle" style="width:90%" colspan="5"><%= strTitle %></td>                                                                                     
        </tr>   
        <tr>  
          <%if("1".equals(relatePolicyFlag)){%>
            <td class="subformtitle" style="width:10%">��ҵ&nbsp;ǿ��</td>
          <%}else if("1".equals(compelPolicyFlag)){%>
            <td class="subformtitle" style="width:10%">ǿ��</td>
          <%}else{%>
          <td class="subformtitle" style="width:10%">��ҵ</td>
          <%}%>                                                                                 
          <td class="subformtitle" style="width:50%">�嵥����</td> 
          <td class="subformtitle" style="width:10%">�Ƿ��ϴ�</td>    
          <td class="subformtitle" style="width:7%">�鿴</td>   
          <td class="subformtitle" style="width:16%;">��ɾ��ͼƬ</td>
          <td class="subformtitle" style="width:7%">�ϴ�</td>                                                                                       
        </tr>
      </table>    
    </td>  
  </tr> 

  <tr>
    <td class="input" style="width:70%">        
      <table cellpadding="5" cellspacing="1" border="0"  class="common" style="width:100%">
    <%  

      for(int i=0;i<imageTypeList.size();i++){ 
        PrpDcodeDto prpDcodeDto = (PrpDcodeDto)imageTypeList.get(i);

        strTempCount = String.valueOf(k);
        if(strTempCount.length()<2){
          strTempCount = "0"+strTempCount;
        }
        if(prpDcodeDto.getCodeCode().substring(0,2).equals(strTempCount)){ //��һλΪ1�����������
            //�Ƿ��Ѿ��ϴ��ı�־ ��PrpLcertifyImgȡ��
            String alreadyUploadFlag = "";
            
            if(prpLcertifyImgDtoList!=null&&prpLcertifyImgDtoList.size()>0){
            for(int j=0;j < prpLcertifyImgDtoList.size(); j++){ 
              PrpLcertifyImgDto prpLcertifyImgDtoTemp = (PrpLcertifyImgDto)prpLcertifyImgDtoList.get(j);
               
              if(prpLcertifyImgDtoTemp.getTypeCode().equals(prpDcodeDto.getCodeCode())&&prpLcertifyImgDtoTemp.getLossItemCode().equals(String.valueOf(no))){
                
                alreadyUploadFlag = "checked";
                break;
              }
            }
          }
          String requireUploadFlag = "";
          String compelRequireUploadFlag = "";
	   if (aa==index){}else
	   	{
		strImageList="";
		aa += index;
		
	   	}
          //�Ƿ���Ҫ�ϴ��ı�־ ��PrpLcertifyDirectȡ��
          if(prpLcertifyDirectDtoList!=null&&prpLcertifyDirectDtoList.size()>0){
            for(int j=0;j < prpLcertifyDirectDtoList.size(); j++){ 
              PrpLcertifyDirectDto prpLcertifyDirectDtoTemp = (PrpLcertifyDirectDto)prpLcertifyDirectDtoList.get(j);
              if(prpLcertifyDirectDtoTemp.getTypeCode().equals(prpDcodeDto.getCodeCode())&&prpLcertifyDirectDtoTemp.getLossItemCode().equals(String.valueOf(index+1))){
		              if("1".equals(prpLcertifyDirectDtoTemp.getBusinessFlag()) && "1".equals(prpLcertifyDirectDtoTemp.getCompelFlag())){
		                requireUploadFlag = "checked";
		                compelRequireUploadFlag = "checked";
		                strImageList +=prpDcodeDto.getCodeCode() + "@@" + prpDcodeDto.getCodeCName() + "|";
		              }else{
		              	if("1".equals(prpLcertifyDirectDtoTemp.getBusinessFlag())){
				                requireUploadFlag = "checked";
				                strImageList +=prpDcodeDto.getCodeCode() + "@@" + prpDcodeDto.getCodeCName() + "|";
				            }
		              	if("1".equals(prpLcertifyDirectDtoTemp.getCompelFlag())){
				                compelRequireUploadFlag = "checked";
				                strImageList +=prpDcodeDto.getCodeCode() + "@@" + prpDcodeDto.getCodeCName() + "|";
				                break;
		                }
		              }
		        }
            }
          }
	//add by miaowenjun 20060420 ֻ��ʾѡ���˵ģ�ûѡ��Ĳ���ʾ
	if("checked".equals(requireUploadFlag) || "checked".equals(compelRequireUploadFlag)){
    //add end by miaowenjun 20060420
    %>
        <tr>  
          <td class="input" style="width:5%"><input type="<%=businessType%>" name="prpLcertifyDirect" disabled <%= requireUploadFlag %>></td> 
          <td class="input" style="width:5%"><input type="<%=compelType%>" name="compelCertifyDirect" disabled <%= compelRequireUploadFlag %>></td> 
          <td class="input" style="width:50%"><input type="text" name="prpLcertifyDirectTypeName" class="readonly" readonly="true" value="<%= prpDcodeDto.getCodeCName() %>"></td>                                                                                      
          <td class="input" style="width:10%"><input type="checkbox" name="prpLcertifyDirectUploadFlag" disabled <%= alreadyUploadFlag %>></td>                                                                                        
        </tr>    
    <%}}

						}

						%>   
      </table>    
    </td>
    <td class="input" style="width:7%"><input class=button type="button" name="buttonView" value="�鿴"  onclick="doViewFile('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>')"></td>
    <td class="input" style="width:16%" align="center">
		<input class="button" type="button" name="buttonDelete" value="��ɾ��ͼƬ" onclick="doViewFile('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>')">
	</td>
    <td class="input" style="width:7%"><input class=button type="button" name="buttonUpload" value="�ϴ�" onclick="doUploadFile('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>')"></td>
  </tr>
</table>
<%}}

			%> 

<%
boolean isHavedCustomCertify=false;
for (int j = 0; j < prpLcertifyDirectDtoList.size(); j++) {
	prpLcertifyDirectDto = (PrpLcertifyDirectDto) prpLcertifyDirectDtoList.get(j);
	if ("99".equals(prpLcertifyDirectDto.getTypeCode().substring(0, 2))) {
		isHavedCustomCertify = true;
		break;
	}
}	
if(isHavedCustomCertify){
%>			

<table cellpadding="5" cellspacing="1" border="0"  class="common">
  <tr>
    <td class="input" style="width:100%" colspan="4">
      <table cellpadding="5" cellspacing="1" border="0"  class="common" >
        <tr> 
          <td class="centertitle" style="width:100%" colspan="6">��������</td>                                                                                     
        </tr>   
        <tr>  
          <td class="subformtitle" style="width:10%">��Ҫ��־</td>                                                                                   
          <td class="subformtitle" style="width:50%">�嵥����</td> 
          <td class="subformtitle" style="width:10%">�Ƿ��ϴ�</td>    
          <td class="subformtitle" style="width:7%">�鿴</td>   
          <td class="subformtitle" style="width:16%">��ɾ��ͼƬ</td>  
          <td class="subformtitle" style="width:7%">�ϴ�</td>                                                                                       
        </tr>
      </table>    
    </td>  
  </tr> 

  <tr>
    <td class="input" style="width:70%">        
      <table cellpadding="0" cellspacing="1" border="0"  class="title" style="width:100%">
    		<%
			String alreadyUploadFlag = "";
			String strImageList = "";
			if (prpLcertifyDirectDtoList != null) {
				for (int j = 0; j < prpLcertifyDirectDtoList.size(); j++) {
					prpLcertifyDirectDto = (PrpLcertifyDirectDto) prpLcertifyDirectDtoList.get(j);
					if ("99".equals(prpLcertifyDirectDto.getTypeCode().substring(0, 2))) {
    					alreadyUploadFlag = "";
						strImageList += prpLcertifyDirectDto.getTypeCode() +"@@"+ prpLcertifyDirectDto.getTypeName() + "|";
						if (prpLcertifyImgDtoList != null && prpLcertifyImgDtoList.size() > 0) {
							for (int k = 0; k < prpLcertifyImgDtoList.size(); k++) {
								PrpLcertifyImgDto prpLcertifyImgDtoTemp = (PrpLcertifyImgDto) prpLcertifyImgDtoList.get(k);
								if (prpLcertifyImgDtoTemp.getTypeCode().equals(prpLcertifyDirectDto.getTypeCode())) {
									alreadyUploadFlag = "checked";
									break;
								}
							}
						}
						%>
        <tr>  
          <td class="input" style="width:10%" align="center"/>
          <td class="input" style="width:50%">
				<input type="text" class="readonly" readonly="true" align="left" style="width:80%" name="prpLcertifyDirectCustomTypeName" value="<%=prpLcertifyDirectDto.getTypeName()%>">
				<input type="hidden" name="prpLcertifyDirectCustomTypeCode" value="<%=prpLcertifyDirectDto.getTypeCode()%>">
          </td> 
          <td class="input" style="width:10%"><input type="checkbox" name="prpLcertifyDirectUploadFlag" disabled <%= alreadyUploadFlag %>></td>                                                                                        
        </tr>    
    <%				}
				}
			}

			%>  
      </table>         
    </td>
    <td class="input" style="width:7%">
    	<input class=button type="button" name="buttonView" value="�鿴" onclick="doViewFile('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>')">   	
    </td> 
    <td class="input" style="width:16%" align="center">
    	<input class="button" type="button" name="buttonDelete" value="��ɾ��ͼƬ" onclick="doViewFile('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>')">
    </td>
    <td class="input" style="width:7%"><input class=button type="button" name="buttonUpload" value="�ϴ�" onclick="doUploadFile('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>')"></td> 
  </tr>
</table>
  
<%
}	//�Զ���������ʾ���
%>  
  
  
<%
	String nodeType = request.getParameter("nodeType");
	if (!(nodeType.equals("check") || nodeType.equals("certa") || nodeType.equals("verif"))) {
%> 
  <table  border="0" cellpadding="5" cellspacing="1"  class="common" >
    <tr>         
      <td class="title" >�ռ���־:</td>
      <td class="input" style="width:85%" style="valign:middle" colspan="3">
      	<html:radio  name="prpLcertifyCollectDto" property="collectFlag" value="0" onclick="setCollectFlag(this);"/>����ȫ
      	<html:radio  name="prpLcertifyCollectDto" property="collectFlag" value="1" onclick="setCollectFlag(this);"/>��ȫ
      </td> 
    </tr>    
<%
	int i = 0;

	//���߳��ı�־   
	String cltThirdCarFlag = prpLcertifyCollectDto.getCltThirdCarFlag();
	int cltThirdCarFlagSize = 0;
	if (cltThirdCarFlag != null && cltThirdCarFlag.length() > 0) {
		cltThirdCarFlagSize = cltThirdCarFlag.length(); //1111
	}
	if (thirdPartyList != null && thirdPartyList.size() > 0) {
		for (i = 0; i < thirdPartyList.size(); i++) {
			PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto) thirdPartyList.get(i);
			if (prpLthirdPartyDto.getInsureCarFlag() != null
				&& prpLthirdPartyDto.getInsureCarFlag().trim().equals("1")
				&& prpLthirdPartyDto.getSerialNo() == 1) {
%>    
			    <tr>         
			      <td class="title" style="width:50%">�����ռ���־(���ƺ���:<%=prpLthirdPartyDto.getLicenseNo()%>):</td>
			      <td class="input" style="width:50%" style="valign:middle" colspan="3">
			      	<html:radio  name="prpLcertifyCollectDto" property="cltInsureCarFlag" value="0" onclick="setCollectFlag(this);"/>����ȫ
			      	<html:radio  name="prpLcertifyCollectDto" property="cltInsureCarFlag" value="1" onclick="setCollectFlag(this);"/>��ȫ
			      </td>  
			    </tr>  
      
			<%}else{%>
		    <tr>         
		      <td class="title" style="width:50%">���߳��ռ���־(���ƺ���:<%=prpLthirdPartyDto.getLicenseNo()%>):</td>
		      <td class="input" style="width:50%" style="valign:middle" colspan="3">
		      <%if (cltThirdCarFlagSize >= i) {%>	    
		      	<input type="radio"  name="cltThirdCarFlag<%= i %>"  value="0" <%= cltThirdCarFlag.substring(i,i+1).equals("1") ? " ":"checked" %> onclick="setCollectFlag(this);">����ȫ 
		      	<input type="radio"  name="cltThirdCarFlag<%= i %>"  value="1" <%= cltThirdCarFlag.substring(i,i+1).equals("1") ? "checked":"" %> onclick="setCollectFlag(this);">��ȫ  
		      <%} else {%>
		      	<input type="radio"  name="cltThirdCarFlag<%= i %>"  value="0" checked onclick="setCollectFlag(this);">����ȫ 
		      	<input type="radio"  name="cltThirdCarFlag<%= i %>"  value="1" onclick="setCollectFlag(this);">��ȫ  
		      <%}%>
		      </td>   
		    </tr>     
			<%}
		}
	}
%>    
<input type="hidden" name="cltThirdCarCount" value="<%= i %>"> 
    <tr>          
      <td class="title" >�����ռ���־:</td>
      <td class="input" style="width:85%" style="valign:middle" colspan="3">
      	<html:radio  name="prpLcertifyCollectDto" property="cltPersonFlag" value="0" onclick="setCollectFlag(this);"/>����ȫ
      	<html:radio  name="prpLcertifyCollectDto" property="cltPersonFlag" value="1" onclick="setCollectFlag(this);"/>��ȫ
      </td> 
    </tr>    
    <tr>         
      <td class="title" >�����ռ���־:</td>
      <td class="input" style="width:85%" style="valign:middle" colspan="3">
      	<html:radio  name="prpLcertifyCollectDto" property="cltPropFlag" value="0" onclick="setCollectFlag(this);"/>����ȫ
      	<html:radio  name="prpLcertifyCollectDto" property="cltPropFlag" value="1" onclick="setCollectFlag(this);"/>��ȫ
      </td>  
    </tr>
    <%
    if("RISKCODE_DAZ".equals(new UICodeAction().translateRiskCodetoConfigCode(strRiskCode))
    		||"RISKCODE_DAY".equals(new UICodeAction().translateRiskCodetoConfigCode(strRiskCode))
    		||"RISKCODE_DAU".equals(new UICodeAction().translateRiskCodetoConfigCode(strRiskCode))){%>
    <tr>         
      <td class="title" >ǿ�Ʊ����ռ���־:</td>
      <td class="input" style="width:85%" style="valign:middle" colspan="3">
      	<html:radio  name="prpLcertifyCollectDto" property="compelFlag" value="0" onclick="setCollectFlag(this);"/>����ȫ
      	<html:radio  name="prpLcertifyCollectDto" property="compelFlag" value="1" onclick="setCollectFlag(this);"/>��ȫ
      </td>  
    </tr> 
    <%}%>
    <tr>         
      <td class="title" >�����ռ���־:</td>
      <td class="input" style="width:85%" style="valign:middle" colspan="3">
      	<html:radio  name="prpLcertifyCollectDto" property="cltCarLossFlag" value="0" onclick="setCollectFlag(this);"/>����ȫ
      	<html:radio  name="prpLcertifyCollectDto" property="cltCarLossFlag" value="1" onclick="setCollectFlag(this);"/>��ȫ
      </td> 
    </tr>    <tr style='display:none'>         
      <td class="title" >ȫ���ռ���־:</td>
      <td class="input" style="width:85%" style="valign:middle" colspan="3">
      	<html:radio  name="prpLcertifyCollectDto" property="cltAllLossFlag" value="0" onclick="setCollectFlag(this);"/>����ȫ
      	<html:radio  name="prpLcertifyCollectDto" property="cltAllLossFlag" value="1" onclick="setCollectFlag(this);"/>��ȫ
      </td>  
    </tr>
    <tr> 
      <td class="title" colspan="4" style="width:100%">�����������</td>
    </tr> 
    <tr>       
      <td class="title" style="text-align:center;" colspan="0" colspan="4">
       <textarea style="wrap:hard" rows="10" cols="60" name="prpLcertifyCollectContent" maxLength="255" onblur="checkLength1(this);" description="�����������"><bean:write name='prpLcertifyCollectDto' property='content'/></textarea>
      </td>
    </tr> 
  </table> 
   <%}%>
 <input type="hidden" name="nodeTypeUpload" value="certi">
     <!-- ������Ӱ���js�ļ� -->
  <script type="text/javascript" src="<%= ECM_JS_URL %>"></script>  
