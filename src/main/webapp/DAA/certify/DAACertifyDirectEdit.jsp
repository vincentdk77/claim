<%--
****************************************************************************
* DESC       ：索赔资料清单修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2005-03-25
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="java.util.*" %>

<html>
  <head>
    <!--对title处理-->
    <title>索赔资料清单</title>
    <%-- 页面样式  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/DAA/certify/js/DAACertifyEdit.js"></script>
  <SCRIPT>
  	function exit()
  	{
      window.opener.location.reload();
  	}

    /*
       插入一条新的ThirdParty之后的处理（可选方法）
    */
    function afterInsertCustomCertify(){
       setPrpLcertifyDirectCustomTypeSerialNo();
    }

    /*
      删除本条WarnRegion之后的处理（可选方法）
    */
    function afterDeleteCustomCertify(field){
        setPrpLcertifyDirectCustomTypeSerialNo();
    }
    /**
      设置setPrpLthirdPartySerialNo
    */
    function setPrpLcertifyDirectCustomTypeSerialNo(){
       var count=getElementCount("prpLcertifyDirectCustomTypeSerialNo");
       if(count!=1){
	       for(var i=0;i<count;i++){       	  
	          	fm.prpLcertifyDirectCustomTypeSerialNo[i].value=i;
	       }
       }
    }
    
  	
  </SCRIPT>
  </head>
<%
  //String strRiskCode =request.getParameter("riskCode");
  String nodeType=request.getParameter("nodeType");
  if(nodeType.equals("certi")){
%>
<body  onunload="exit();">
<%
  }else{
%>
<body >
<%
  }
%>
  <form name=fm action="/claim/certifySave.do" method="post">
  <input type="hidden" name="riskCode" value="<%=request.getAttribute("riskCode")%>">
	<%--自定义的单证类型--%>
	<span style="display:none">
		<table class="common" style="display:none" id="CustomCertify_Data" cellspacing="1" cellpadding="5">
			<tbody>
				<tr>
					<td class="common" style="width:10%" align="center">
						<input type="hidden" name="prpLcertifyDirectCustomTypeCheck">
					</td>
					<td class="common" style="width:86%">
						<input type="text" name="prpLcertifyDirectCustomTypeSerialNo" class="readonly" style="width:15px">.&nbsp&nbsp
						<input type="text" name="prpLcertifyDirectCustomTypeName"  style="width:80%" align="left" value="">
						<input type="hidden" name="prpLcertifyDirectCustomTypeCode" value="">
					</td>
					<td class="common" style='width:4%' align="center">
						<div>
							<input type="button" name="buttonCustomTypeDelete" class=smallbutton onclick="deleteRow(this,'CustomCertify')" value="-" style="cursor: hand">
						</div>
					</td>				
				</tr>
			</tbody>
		</table> 
	</span>

  <table border="0" align="center" cellpadding="5" cellspacing="1"  class="common" >
  <tr> <td colspan=4 class="formtitle">索赔资料清单</td></tr>

    <tr>
      <td class="title">报案号码:</td>
      <td class="input" >
        <input type="text" name="prpLcertifyCollectBusinessNo" class="readonly" readonly="true"  value="<bean:write name='prpLcertifyCollectDto' property='businessNo'/>">
      </td>
      <td class="title">保单号码:</td>
      <td class="input" >
        <input type="text" name="prpLcertifyCollectPolicyNo" class="readonly" readonly="true"  value="<bean:write name='prpLcertifyCollectDto' property='policyNo'/>">
      </td>
    </tr>
  </table>
    <%

      PrpLcertifyImgDto prpLcertifyImgDto = (PrpLcertifyImgDto)request.getAttribute("prpLcertifyImgDto");
      List prpLcertifyImgDtoList =  (ArrayList)prpLcertifyImgDto.getCertifyImgList();

      PrpLcertifyDirectDto prpLcertifyDirectDto = (PrpLcertifyDirectDto)request.getAttribute("prpLcertifyDirectDto");
      List prpLcertifyDirectDtoList =  (ArrayList)prpLcertifyDirectDto.getCertifyDirectList();
      
      ArrayList prpLpersonTraceList = (ArrayList)request.getAttribute("prpLpersonTraceList");   //add by miaowenjun 20060419

      List imageTypeList = (ArrayList)request.getAttribute("imageTypeList");
      ArrayList thirdPartyList = (ArrayList)request.getAttribute("thirdPartyList");
      PrpLcertifyCollectDto prpLcertifyCollectDto = (PrpLcertifyCollectDto)request.getAttribute("prpLcertifyCollectDto");
      int thirdPartyCount = thirdPartyList.size();// 车的数量
      int personCount = prpLpersonTraceList.size(); //人伤的数量 add by miaowenjun 20060491
      int k= 0;
      String strRiskCode  = prpLcertifyCollectDto.getRiskCode();
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
//单证类别进行循环
  for(k=1;k<=12;k++){
      //取得标题
      String strTitle = "";
      if(k==1){
        strTitle="索赔申请";
      } else if(k==2){  
        strTitle="保险单证";
      }else if(k==3){  
        strTitle="事故处理单证";
      }else if(k==4){  
        strTitle="法院提供单证";continue;
      }else if(k==5){  
        strTitle="车损资料";
      }else if(k==6){  
        strTitle="财产损失资料";
      }else if(k==7){  
        strTitle="人伤亡资料"; 
      }else if(k==8 ){  //0502没有盗抢险
          if(strRiskCode.equals("0502"))  
              {  continue;                }
          else{  strTitle="车辆盗抢资料"; } 
      }else if(k==9){  
        strTitle="车辆自燃资料";continue; 
      }else if(k==10){  
        strTitle="驾驶证件";
      }else if(k==11){  
        strTitle="领取赔款证件"; continue;
      }else if(k==12){  
        strTitle="车损资料" ;
      } else if (k == 13) {
        strTitle="其他资料"; 
      }
      
      List commonList = new ArrayList();
	  if(k==5||k==12){
	    commonList = thirdPartyList;
	  }else if(k==7){
	    commonList = prpLpersonTraceList;
	  }else{
	    commonList.add(new Object());
	  }
	  String subName = "";
	  for(int index=0;index<commonList.size();index++){
          if(k==5||k==12){
            if(k==5){
            	subName = "资料";
            }else{
            	subName = "车损资料";
            }
            PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)commonList.get(index);
            if(prpLthirdPartyDto.getSerialNo() == 1){
  	            strTitle = "标的车"+subName;
            }else{
            	strTitle = "三者车"+subName;
            }
            strTitle=strTitle+"("+prpLthirdPartyDto.getLicenseNo()+")";
          }else if(k==7){
   			PrpLpersonTraceDto prplpersontraceDto = (PrpLpersonTraceDto)commonList.get(index);
	        strTitle = "人伤亡资料";
   			strTitle=strTitle+"("+prplpersontraceDto.getPersonName()+")";
	      }
%>

  <table  border="0" cellpadding="5" cellspacing="1"  class="common" >
    <tr>
      <td class="subformtitle" style="width:10%" colspan="1">需要标志</td>
      <td class="centertitle" style="width:100%" colspan="5"><%= strTitle %></td>
    </tr>
    <tr>
    <%if("1".equals(relatePolicyFlag)){%>
      <td class="subformtitle" style="width:10%">商业&nbsp;强三</td>
    <%}else if("1".equals(compelPolicyFlag)){%>
      <td class="subformtitle" style="width:10%">强制</td>
    <%}else{%>
    <td class="subformtitle" style="width:10%">商业</td>
    <%}%>
      <td class="subformtitle" style="width:90%">清单类型</td>
    </tr>
	<input type="hidden" name="certifyType">
    <%
      for(int i=0;i<imageTypeList.size();i++){
        PrpDcodeDto prpDcodeDto = (PrpDcodeDto)imageTypeList.get(i);
        strTempCount = String.valueOf(k);
        if(strTempCount.length()<2){
          strTempCount = "0"+strTempCount;
        }
        if(prpDcodeDto.getCodeCode().substring(0,2).equals(strTempCount)){ 
          //是否需要上传CheckBox
          String requireUploadFlag = "";
          String compelRequireUploadFlag = "";
          //是否把checkbox变成不可用
          String requireDisabledFlag = "";
          //取得隐含域的值，需要上传时为1，否则为0
          String requireTxt = "0";
          //取得code的值
          String codeCode = prpDcodeDto.getCodeCode();
          //商三和强三的标志
          String compleChoiceFlag = "0";
          String certifyDirectFlag = "0";
          //是否需要上传的标志 从PrpLcertifyDirect取得
          if(prpLcertifyDirectDtoList!=null&&prpLcertifyDirectDtoList.size()>0){
            for(int j=0;j < prpLcertifyDirectDtoList.size(); j++){
              PrpLcertifyDirectDto prpLcertifyDirectDtoTemp = (PrpLcertifyDirectDto)prpLcertifyDirectDtoList.get(j);
              if(prpLcertifyDirectDtoTemp.getBusinessFlag().equals("1") && prpLcertifyDirectDtoTemp.getTypeCode().equals(prpDcodeDto.getCodeCode())&&prpLcertifyDirectDtoTemp.getLossItemCode().equals(String.valueOf(index+1))){
                requireUploadFlag = "checked";
                requireTxt = prpDcodeDto.getCodeCode();
                certifyDirectFlag = "1";
              }
              if(prpLcertifyDirectDtoTemp.getCompelFlag().equals("1") && prpLcertifyDirectDtoTemp.getTypeCode().equals(prpDcodeDto.getCodeCode())&&prpLcertifyDirectDtoTemp.getLossItemCode().equals(String.valueOf(index+1))){
                compelRequireUploadFlag = "checked";
                requireTxt = prpDcodeDto.getCodeCode();
                compleChoiceFlag = "1";
                break;
              }
            }
          }
          if(prpLcertifyImgDtoList!=null&&prpLcertifyImgDtoList.size()>0){
            for(int x=0;x < prpLcertifyImgDtoList.size(); x++){ 
              PrpLcertifyImgDto prpLcertifyImgDtoTemp = (PrpLcertifyImgDto)prpLcertifyImgDtoList.get(x);
              if(prpLcertifyImgDtoTemp.getTypeCode().equals(prpDcodeDto.getCodeCode())
                       &&prpLcertifyImgDtoTemp.getLossItemCode().equals(String.valueOf(index+1))){
                requireDisabledFlag = "disabled";
                break;
          	  }
            }
          }				  
    %>
        <tr>
          <td class="input" style="width:10%" align="center">
            <input type="<%=businessType%>" name="prpLcertifyDirect" <%= requireDisabledFlag %> <%= requireUploadFlag %> onClick="return directCodeChange(this);">
            <input type="<%=compelType%>" name="compelCertifyDirect" <%= requireDisabledFlag %> <%= compelRequireUploadFlag %> onclick="return compelDirectFlag(this);">
            <input type="hidden" name="compleChoiceFlag" value="<%=compleChoiceFlag%>">
            <input type="hidden" name="certifyDirectFlag" value="<%=certifyDirectFlag%>">
            <input type="hidden" name="prpLcertifyDirectLossItemCode" value="<%=index+1%>">
            <input type="hidden" name="prpLcertifyDirectCode" value="<%= requireTxt %>">
            <input type="hidden" name="code" value="<%=codeCode%>">
          </td>
          <td class="input" style="width:90%"><input type="text" name="prpLcertifyDirectTypeName" class="readonly" readonly="true" value="<%= prpDcodeDto.getCodeCName() %>"></td>
        </tr>
    <%
        }
      }
    %>
<%
        }// 三者车
%>
  </table>
<%
      }
%>
			<table border="0" cellpadding="5" cellspacing="1" class="common">
				<tr>
					<td class="centertitle" style="width:100%" colspan="3">
						其他资料
					</td>
				</tr>
			</table>
			<table id="CustomCertify" border="0" cellpadding="5" cellspacing="1" class="common">
				<thead>
					<tr>
						<td class="subformtitle" style="width:10%">
							需要标志
						</td>
						<td class="subformtitle" style="width:90%" colspan="2">
							清单类型
						</td>
					</tr>
				</thead>
				<tfoot>
					<tr class="common">
						<td colspan=2 align="center">
							(按"+"号键增加损失部位信息，按"-"号键删除信息)
						</td>
						<td class="title" align="right" style="width:4%">
							<div align="center">
								<input type="button" value="+" class=smallbutton onclick="insertRow('CustomCertify')" name="buttonCustomTypeInsert" style="cursor: hand">
							</div>
						</td>
					</tr>
				</tfoot>				
				<tbody>
<%
          //是否需要上传的标志 从PrpLcertifyDirect取得
          int x=0;
          String deleteDisabledFlag="";
          if(prpLcertifyDirectDtoList!=null&&prpLcertifyDirectDtoList.size()>0){
            for(int j=0;j < prpLcertifyDirectDtoList.size(); j++){
              prpLcertifyDirectDto = (PrpLcertifyDirectDto)prpLcertifyDirectDtoList.get(j);
              if("99".equals(prpLcertifyDirectDto.getTypeCode().substring(0,2))){              
              	x++;
              	deleteDisabledFlag="";
              	for(int m=0;m < prpLcertifyImgDtoList.size(); m++){ 
              		prpLcertifyImgDto = (PrpLcertifyImgDto)prpLcertifyImgDtoList.get(m);
              		if(prpLcertifyImgDto.getTypeCode().equals(prpLcertifyDirectDto.getTypeCode())){
                		deleteDisabledFlag = "disabled";
                		break;
                	}
                }
    %>
					<tr>
						<td class="input" style="width:10%" align="center"/>
						<td class="input" style="width:86%">
							<input type="text" name="prpLcertifyDirectCustomTypeSerialNo" class="readonly" value="<%=x%>" style="width:15px">.&nbsp&nbsp
							<input type="text" align="left" style="width:80%" name="prpLcertifyDirectCustomTypeName" value="<%=prpLcertifyDirectDto.getTypeName()%>">
							<input type="hidden" name="prpLcertifyDirectCustomTypeCode" value="<%=prpLcertifyDirectDto.getTypeCode()%>">
						</td>
						<td class="common" style='width:4%' align="center">
							<div>
								<input type="button" <%=deleteDisabledFlag%> name="buttonCustomTypeDelete" class=smallbutton onclick="deleteRow(this,'CustomCertify')" value="-" style="cursor: hand">
							</div>
						</td>
					</tr>
<%
			}
		 }
  	  }
%>
				
				</tbody>

			</table>

  <table cellpadding="0" cellspacing="0" class="common">
    <tr>
      <td class=button style="width:50%" align="center">
        <!--保存按钮-->
        <input type="button" name=buttonSave class='button' value="保存" onclick="return saveCertifyDirect();">
      </td>
      <td class=button style="width:50%" align="center">
        <!--关闭按钮-->
        <input type="button" name=buttonClose class='button' value="关闭" onclick="javascript:window.close();">
      </td>
    </tr>
  </table>

  <input type="hidden" name="nodeType" value="CertifDirect">
  <input type="hidden" name="thirdPartyCount" value="<%= thirdPartyCount %>">
  <input type="hidden" name="personCount" value="<%= personCount %>">  <!-- add by miaowenjun 20060419-->
  <input type="hidden" name="classCount" value="<%= k-1 %>">
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html>
