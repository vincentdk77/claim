<%--
****************************************************************************
* DESC       ：[ 单证收集 ]列表页面
* AUTHOR     ： 
* CREATEDATE ： 2011-08-18
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@ page import="java.util.*"%>
 <%@page import="com.gyic.claim.dto.domain.PrplcombineDto"%>
<%@page import="com.sinosoft.claim.bl.facade.BLSwfLogFacade"%>
<%@page import="com.sinosoft.claim.dto.domain.SwfLogDto"%>
<script language="javascript">

	  //显示保单
	  function showPolicy(strPolicyNo,strRiskCode)
	  { var versionType = fm.versionType.value;
     var versionNo = fm.versionNo.value;
     var vURL="";
   	if("A01" == versionNo || versionNo == "" )
 	{
      vURL = '/prpall/' + fm.prpLcertifyCollectRiskCode.value + '/tbcbpg/UIPrPoEn' +  fm.prpLcertifyCollectRiskCode.value + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ fm.prpLcertifyCollectPolicyNo.value+'&RiskCode='+  fm.prpLcertifyCollectRiskCode.value;
     }
     else
     {
      vURL = '/prpall/' + fm.prpLcertifyCollectRiskCode.value  + "-" + versionType + "-" + versionNo + '/tbcbpg/UIPrPoEn' +  fm.prpLcertifyCollectRiskCode.value + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ fm.prpLcertifyCollectPolicyNo.value+'&RiskCode='+  fm.prpLcertifyCollectRiskCode.value;
     }
     
              window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0'); 
	  }

	  </script>



<table align="center" cellpadding="5" cellspacing="0" class="common">
  
  <%-- 
   <tr>
   <td class=button ><input class=button  type="button" width="80" height="21" name="messageSave"  value="理赔沟通" onclick="openWinSaveQuery(fm.RegistNo.value,'<bean:write name='prpLcertifyCollectDto' property='policyNo'/>',fm.riskCode.value,'certi','','registNo',fm.RegistNo.value);"></td>
   <td class=button><input class=button type="button" name="buttonCertifyDirect" value="索赔清单" onClick="doCertifyDirect('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>','certi')"></td> 
    <td class=button><input class=button type="button" name="buttonCertifyDirect" value="索赔须知" onClick="certifyDirectList('<bean:write name='prpLcertifyCollectDto' property='businessNo'/>','certi')"></td> 
  </tr> --%>
</table> 
   <table class=common cellpadding="5" cellspacing="1">
   <tr>
    <td class="formtitle">单证收集</td>
    </tr>
    </table >
 
  <table border="0" align="center" cellpadding="5" cellspacing="1"  class="title" style="width:100%">
    
    <tr>
 <%-- <td class="title" >报案号码:</td>  
      <td class="input"  >
        <input type="text" name="RegistNo" class="readonly" readonly="true" style="width:160px" value="<bean:write name='prpLcertifyCollectDto' property='businessNo'/>">
        <input type="button" name="btRegistRelate" value="报案信息" class='bigbutton' onclick="relateRegist();return false;">
      </td>  --%>
      <td class="title" >保单号码:</td>  
      <td class="input"  >
        <input type="text" name="PolicyNo" class="readonly" readonly="true" style="width:160px" value="<bean:write name='prpLcertifyCollectDto' property='policyNo'/>">
                <input type="button" name="btPolicyRelate" value="保单信息" class='bigbutton' onclick="showPolicy(fm.PolicyNo.value);return false;"> 
      </td>
      <td class="title" ></td>
      <td class="input" ></td>  
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
        
        <% //modify by lixiang add 20050304 start
        //reason:保存留言，和打开留言所用的参数
        %> 
        <input type="hidden" name="policyNo" value="<%=request.getParameter("policyNo")%>">
        <input type="hidden" name="riskCode" value="<%=request.getParameter("riskCode")%>">        
        <input type="hidden" name="swfLogFlowID" value="<%= request.getParameter("swfLogFlowID") %>">
        <input type="hidden" name="swfLogLogNo" value="<%= request.getParameter("swfLogLogNo") %>">
          <input type="hidden" name="editType" value="<%= request.getParameter("editType") %>">
      
        <% //modify by lixiang add 20050304 end%>
      </td> 
    </tr>     
  </table>   
    <%

      PrpLcertifyImgDto prpLcertifyImgDto = (PrpLcertifyImgDto)request.getAttribute("prpLcertifyImgDto");
      List prpLcertifyImgDtoList =  (ArrayList)prpLcertifyImgDto.getCertifyImgList();
      
      PrpLcertifyDirectDto prpLcertifyDirectDto = (PrpLcertifyDirectDto)request.getAttribute("prpLcertifyDirectDto");
      List prpLcertifyDirectDtoList =  (ArrayList)prpLcertifyDirectDto.getCertifyDirectList();
      
      List imageTypeList = (ArrayList)request.getAttribute("imageTypeList");
      PrpLcertifyCollectDto prpLcertifyCollectDto = (PrpLcertifyCollectDto)request.getAttribute("prpLcertifyCollectDto");
%>   
<%
   //取得标题
      String   strTitle="基本资料";
%>
<%-- 
<table cellpadding="5" cellspacing="1" border="0"  class="common">
  <tr>
    <td class="input" style="width:100%" colspan="3">
      <table cellpadding="5" cellspacing="1" border="0"  class="common" >
        <tr> 
          <td class="centertitle" style="width:100%" colspan="6"><%= strTitle %></td>                                                                                     
        </tr>   
        <tr>  
          <td class="subformtitle" style="width:10%">需要标志</td>                                                                                   
          <td class="subformtitle" style="width:60%">清单类型</td> 
          <td class="subformtitle" style="width:10%">是否上传</td>    
          <td class="subformtitle" style="width:10%">查看</td>   
          <td class="subformtitle" style="width:10%">上传</td>                                                                                       
        </tr>
      </table>    
    </td>  
  </tr> 

  <tr>
    <td class="input" style="width:80%">        
      <table cellpadding="0" cellspacing="1" border="0"  class="title" style="width:100%">
    <%  
      String strImageList = "";
      String strCodeCode="";
      String strsubTitle="";
      for(int i=0;i<imageTypeList.size();i++){ 
        PrpDcodeDto prpDcodeDto = (PrpDcodeDto)imageTypeList.get(i);
       
        //add by lixiang start at 2006-01-25
        //增加货运险的分类显示
       /*
        strCodeCode="";
        if (prpDcodeDto!=null) strCodeCode=prpDcodeDto.getCodeCode();
        
        if (strCodeCode.length()>1
          &&(strCodeCode.equals("H12")||strCodeCode.equals("H18")||strCodeCode.equals("H21") )){
          //判断=H12,H18,H21增加一列
          if (strCodeCode.equals("H12")) strsubTitle="涉及第三方人员伤亡或财产损失的赔案";
          if (strCodeCode.equals("H18")) strsubTitle="涉及诉讼的赔案";
          if (strCodeCode.equals("H21")) strsubTitle="货运险赔案";
          %>
                 </table>
             </td>
             <td class="input" style="width:10%"></td> 
             <td class="input" style="width:10%"></td> 
           </tr>
         </table>
         
          <table cellpadding="5" cellspacing="1" border="0"  class="common">
          <tr>
              <td class="input" style="width:100%" colspan="3">
       <table cellpadding="5" cellspacing="1" border="0"  class="common" >
        <tr> 
          <td class="centertitle" style="width:100%" colspan="6"><%= strsubTitle %></td>                                                                               
        </tr>   
      </table>    
      </td>  
    </tr> 

    <tr>
      <td class="input" style="width:80%">        
         <table cellpadding="0" cellspacing="1" border="0"  class="title" style="width:100%">
         <%
        }
        */
        //add by lixiang end at 2006-01-25
        
        
        //是否已经上传的标志 从PrpLcertifyImg取得
          String alreadyUploadFlag = "";
          if(prpLcertifyImgDtoList!=null&&prpLcertifyImgDtoList.size()>0){
            for(int j=0;j < prpLcertifyImgDtoList.size(); j++){ 
              PrpLcertifyImgDto prpLcertifyImgDtoTemp = (PrpLcertifyImgDto)prpLcertifyImgDtoList.get(j);
              if(prpLcertifyImgDtoTemp.getTypeCode().equals(prpDcodeDto.getCodeCode())||prpLcertifyImgDtoTemp.getTypeCode().equals(prpDcodeDto.getCodeCode())){
                alreadyUploadFlag = "checked";
                System.out.println("----此单证已经上传-------"+prpDcodeDto.getCodeCode());
                break;
              }
              
              
            }
          } 
          String requireUploadFlag = "";
          //是否需要上传的标志 从PrpLcertifyDirect取得
          if(prpLcertifyDirectDtoList!=null&&prpLcertifyDirectDtoList.size()>0){
            for(int j=0;j < prpLcertifyDirectDtoList.size(); j++){  
              PrpLcertifyDirectDto prpLcertifyDirectDtoTemp = (PrpLcertifyDirectDto)prpLcertifyDirectDtoList.get(j);
                //System.out.println("----此单证需要上传-------"+prpLcertifyDirectDtoTemp.getTypeCode()+"|"+prpDcodeDto.getCodeCode()+"|"+prpLcertifyDirectDtoTemp.getLossItemCode()+"|"+k);
              if(prpLcertifyDirectDtoTemp.getTypeCode().equals(prpDcodeDto.getCodeCode())){
                requireUploadFlag = "checked";
                //modify by qinyongli 2005-8-27 因为在applet中，代码处理采用的是四位，而非车险在代码库中存储的是三位,所以,加入一个占位符
                strImageList +=prpDcodeDto.getCodeCode()+"@@"+ prpDcodeDto.getCodeCName() + "|";
                System.out.println("----此单证需要上传-------"+prpDcodeDto.getCodeCode());
                break;
              }
              
            }
          }
    %>
        <tr>  
          <td class="input" style="width:10%"><input type="checkbox" name="prpLcertifyDirectCheck<%= prpDcodeDto.getCodeCode() %>" disabled  <%= requireUploadFlag %>></td> 
          <td class="input" style="width:60%"><input type="text" name="prpLcertifyDirectTypeName<%= prpDcodeDto.getCodeCode() %>" class="readonly" readonly="true" value="<%= prpDcodeDto.getCodeCName() %>"></td>                                                                                      
          <td class="input" style="width:10%"><input type="checkbox" name="prpLcertifyDirectUploadFlag<%= prpDcodeDto.getCodeCode() %>" disabled <%= alreadyUploadFlag %>></td>                                                                                        
        </tr>    
    <%
      }
    %>  
      </table>    
    </td>
    <td class="input" style="width:10%"><input class=button type="button" name="buttonView" value="查看" onclick="doViewFile('1');return false;"></td> 
    <td class="input" style="width:10%"><input class=button type="button" name="buttonUpload" value="上传" onclick="doUploadFile('0','1','claim','<%= strTitle %>','<%=strImageList%>');return false;"></td> 
  </tr>
</table> --%>
<table cellpadding="5" cellspacing="1" border="0"  class="common">
<tr>
      <td class="title" colspan="4" style="width:100%">并案案件：</td>
</tr>
<tr> 
<% int  Index=0;%>
<logic:notEmpty  name="prplcombineDtoList"  > 
	  <logic:iterate id="prplcombineDto" name="prplcombineDtoList">
	  <% 
	   String dealHref ="";
	   String flowStr ="";
	   String nodestatus ="";
	   SwfLogDto swfLogDto =null;
	   ArrayList  prplcombineDtoList = (ArrayList)request.getAttribute("prplcombineDtoList");
	   PrplcombineDto prplcombineDto1 = (PrplcombineDto)prplcombineDtoList.get(Index);
	   String registNo = prplcombineDto1.getRegistno();
	   BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
	   ArrayList swfLogDtoList = (ArrayList)bLSwfLogFacade.findByConditions("registNo='"+registNo+"' and nodeType='certi'");
	   if(swfLogDtoList!=null&&swfLogDtoList.size()>0){
	    swfLogDto = (SwfLogDto)swfLogDtoList.get(0);
	    if ("0".equals(swfLogDto.getNodeStatus())){
	    	nodestatus ="未处理";
	    }else{
	    	nodestatus ="正在处理";
	    }
	    flowStr="&swfLogFlowID="+swfLogDto.getFlowID()+"&swfLogLogNo="+swfLogDto.getLogNo()+"&status="+swfLogDto.getNodeStatus()
        +"&riskCode="+swfLogDto.getRiskCode()+"&editType=ADD"
        +"&nodeType="+swfLogDto.getNodeType()
        +"&businessNo="+swfLogDto.getBusinessNo()
        +"&keyIn="+swfLogDto.getKeyIn()
        +"&policyNo="+swfLogDto.getPolicyNo()
        +"&modelNo="+swfLogDto.getModelNo()
        +"&nodeNo="+swfLogDto.getNodeNo()
  		+"&dfFlag="+swfLogDto.getDfFlag()
  		+"&combineNo="+prplcombineDto1.getCombineno();
	    dealHref="/claim/certifyBeforeEditOne.do?RegistNo="+swfLogDto.getKeyIn()+flowStr; 
	   }
	  %>
		<tr>
		  <input type="hidden" name="CombinedealHref" value="<%= dealHref%>">
		  <input type="hidden" name="prplcombineRegistNo" value="<bean:write name='prplcombineDto' property='registno'/>">
		  <input type="hidden" name="CombinenodeStatus" value="<%= swfLogDto.getNodeStatus()%>">
		  <td class="input" style="width:15%" align="center">报案号：</td>
		  <td class="input" style="width:15%" align="left">
		    <a  href="<%=dealHref%>"><bean:write name='prplcombineDto' property='registno'/></a></td>
		  <td class="input" style="width:15%" align="center">案件状态：</td>
		  <td class="input" style="width:20%" align="left"><%= nodestatus%></td>
		  <td class="input" style="width:15%" align="left">事故号：</td>
		  <td class="input" style="width:30%" > 
		    <bean:write name='prplcombineDto' property='combineno'/></td>
		</tr>	
	  <%Index++;%>
      </logic:iterate> 
</logic:notEmpty>
</tr> 			
</table>
 <%
  String nodeType=request.getParameter("nodeType");
  if(nodeType.equals("check")||nodeType.equals("certa")||nodeType.equals("verif")){}else{
%> 

  <table  border="0" cellpadding="5" cellspacing="1"  class="common" >   
    <tr>
      <td class="title" colspan="4" style="width:100%">案件处理意见</td>
    </tr> 
    <tr>       
      <td class="title" style="text-align:center;" colspan="0" colspan="4">
       <textarea style="wrap:hard" rows="10" cols="60" name="prpLcertifyCollectContent"  maxLength="255" onblur="checkLength1(this);" description="案件处理意见"><bean:write name='prpLcertifyCollectDto' property='content'/></textarea>
      </td>
    </tr> 
  </table> 
   <%
    }
   %>
  <input type="hidden" name="nodeTypeUpload" value="certi">
