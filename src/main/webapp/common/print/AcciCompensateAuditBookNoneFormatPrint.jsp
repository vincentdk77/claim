<%--
****************************************************************************
* DESC       ：理赔审核书打印
* AUTHOR     ：caopeng
* CREATEDATE ：2005-12-14
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="java.util.*"%>
<%-- 初始化 --%>
<%@include file="AcciCompensateAuditBookNoneFormatPrintIni.jsp"%>

<html>
<head>
<title>赔款计算书打印</title>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>

<%
	String acciName = (String)request.getAttribute("acciName");
	String sex = (String)request.getAttribute("sex");
	String identifyNumber = (String)request.getAttribute("identifyNumber");

%>

<body onLoad="loadForm();">
<table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
        <tr>
          <td width="100%" height="40" align=center style="font-family:宋体; font-size:14pt;">
            <img src="/claim/images/LOGO.jpg"/>
          </td>
        </tr>      
        <tr>
          <td height="20" align=center style="font-family:宋体; font-size:14pt;">
            <B>赔款计算书打印<B>
          </td>
        </tr>
        <tr>
          <td height="20" align=center style="font-family:宋体; font-size:10pt;"><div align="left"> 立案号 : <span id="spClaimNo"></span></div></td>
        </tr>
</table>

<table width="92%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#111111" style="border-collapse:collapse; font-family:宋体 font-size:10pt;">
  <tr  style=" font-family:'宋体';font-size:10pt ">
    <td width="2%" height="20" rowspan="6" align="center" valign="middle">事故情况</td>
    <td height="25" colspan="8">          <table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt;">
        <tr>
          <td height="20">事故类型： </td>
        </tr>
        <tr>
          <td height="20"><span id="spDamageTypeName">□意外身故 □意外残疾 □重疾 □意外医疗 □疾病医疗 </span></td>
        </tr>
      </table>
      
    </td>
  </tr>
  <tr  style=" font-family:'宋体';font-size:10pt ">
    <td width="17%" height="20" align="center" valign="middle"> 保单号码 </td>
    <td height="20" colspan="3" align="center" valign="middle"><span id="spPolicyNo"></span>&nbsp;</td>
    <td height="20" colspan="2" align="center"  valign="middle"> 生效日 </td>
	<td height="20" colspan="2" align="center"  valign="middle">&nbsp;</td>
  </tr>
  <%for(int i = 0;i < strAcciName.length; i++){ %>
  <tr  style=" font-family:'宋体';font-size:10pt ">
    <td width="17%" height="20" align="center" valign="middle"> 事故者姓名 </td>
    <td width="14%" height="20" align="center" valign="middle"><%=strAcciName[i] %>&nbsp;</span></td>
    <td width="7%" height="20" align="center" valign="middle"><div align="center">性别</div></td>
    <td width="6%" height="20" align="center" valign="middle"><%=strAcciSex[i] %>&nbsp;&nbsp;</span></td>
    <td width="7%" height="20" align="center" valign="middle">年龄</td>
    <td width="13%" height="20" align="center"  valign="middle"><%=strAcciAge[i] %>&nbsp;</span></td>
	<td width="13%" height="20" align="center"  valign="middle"> <div align="center">身份证号码</div></td>
    <td width="21%" height="20" align="center"  valign="middle"><%=strAcciIDCardNo[i] %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    <div align="center"></div></td>
  </tr>
  <%} %>
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td width="17%" height="20" align="center" valign="middle"> 事故时间 </td>
    <td height="20" colspan="3" align="center" valign="middle"><span id="spAcciDate"></span>&nbsp; </td>
    <td height="20" colspan="2" align="center"  valign="middle">身故日 </td>
	<td height="20" colspan="2" align="center"  valign="middle">&nbsp; </td>
  </tr>
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td height="20" align="center" valign="middle">残疾鉴定日</td>
    <td height="20" colspan="3" align="center" valign="middle">&nbsp;</td>
    <td height="20" colspan="2" align="center"  valign="middle">疾病诊断日</td>
    <td height="20" colspan="2" align="center"  valign="middle">&nbsp;</td>
  </tr>
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td height="25" colspan="8" align="center" valign="middle"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt ">
      <tr>
        <td height="20"> <div align="left">事故原因、性质及事故者现状： </div></td>
      </tr>
      <tr>
        <td height="25"><span id="spAcciDamageDesc"></span>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td width="2%" height="20" align="center" valign="middle"><p>保单信息 </p></td>
    <td height="12" colspan="8" valign="top">
    <table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt ">
      <tr>
        <td height="25"> 事故者所有保单信息： </td>
      </tr>
      <tr>
        <td height="25"> 保单号&nbsp;&nbsp;<span id="spPolicyNo1"></span></td>
      </tr>
      <tr>
        <td height="25"> 保险期限&nbsp;&nbsp;<span id="spInsuredDate"></span></td>
      </tr>
      <tr>
        <td height="25"> 保险金额&nbsp;&nbsp;<span id="spSumAmount"></span>&nbsp;&nbsp;元</td>
      </tr>      
    </table> 
    </td>
  </tr>
  <tr>
    <td height="13" colspan="8" valign="top">
    <table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt ">
      <tr>
        <td height="25"> 历史赔付记录：</td>
      </tr>
      <tr>
        <td height="25"> 事故时间&nbsp;&nbsp;<span id="spAcciDate1"></span></td>
      </tr>
      <tr>
        <td height="25"> 原因&nbsp;&nbsp;<span id="spAcciDamageName"></span></td>
      </tr>
      <tr>
        <td height="25"> 理赔决定 /给付金额&nbsp;&nbsp;</td>
      </tr>
      <tr>
        <td height="25"> 立案号&nbsp;&nbsp;<span id="spClaimNo1"></span></td>
      </tr>
    </table></td>
  </tr>
   <tr>
    <td height="13" colspan="8" valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt ">
      <tr>
        <td height="25"> 被保险人开户银行&nbsp;&nbsp;<%=prpLcompensateDto.getBank()%></td>
      </tr>
      <tr>
        <td height="25"> 支付帐号&nbsp;&nbsp;<%=prpLcompensateDto.getAccount()%></td>
      </tr>
       <tr>
        <td height="25"> 收款人全称&nbsp;&nbsp;<%=prpLcompensateDto.getReceiverName()%></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="13" colspan="8" valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt ">
      <tr>
        <td height="25"> 具体出险人信息：</td>
      </tr>
      <tr>
        <td height="25"> 事故者名称&nbsp;&nbsp;<%=acciName%></td>
      </tr>
      <tr>
        <td height="25"> 性别&nbsp;&nbsp;<%=sex%></td>
      </tr>
      <tr>
        <td height="25"> 身份证号码&nbsp;&nbsp;<%=identifyNumber%></td>
      </tr>
    </table></td>
  </tr>
  <!-- delete by miaowenjun 2007-1-29 10:28 -->
  <!--
  <tr>
  <td colspan="9"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt ">
    <tr>
      <td height="20"> 核赔结论、依据：</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
    </tr>
  </table></td></tr>
  -->
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td width="2%" height="25" rowspan='<%=prplPersonList.size()%>' align="center" valign="middle"><p>理算</p></td>
    <td height="25" colspan="8" valign="top">
<table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt ">
  <tr>
    <td height="20">赔款计算过程：
    	</td>
  </tr>
  <tr>
    <td height="40">&nbsp;&nbsp;
    	<%
    for (Iterator iter = prpLctextList.iterator(); iter.hasNext();) {
      prpLctextDto = new PrpLctextDto();
			prpLctextDto = (PrpLctextDto) iter.next();
			%>
			<%=prpLctextDto.getContext()%>
			<%
		}
    	%></td>
  </tr>
</table></td>
    <!-- delete by miaowenjun 2007-1-29 10:28 -->
  <!--
  </tr>
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td height="20" colspan="6">    <div align="center"> 给付项目及金额 </div></td>
    <td height="20" colspan="2"><div align="center"> 扣款项目及金额 </div></td>
  </tr>
  -->
  <%
  for (Iterator iter = prplPersonList.iterator(); iter.hasNext();) {
			PrpLpersonLossDto personLoss = (PrpLpersonLossDto) iter.next();
			if(personLoss!=null){
  %>
  <!--<tr style=" font-family:'宋体';font-size:10pt ">
    <td height="20"> <div align="center"><%=personLoss.getLiabDetailName()%></div></td>
    <td height="20" colspan="8">&nbsp;<%=personLoss.getSumRealPay()%></td>
  </tr>
    --><%}}%>
    <!-- delete by miaowenjun 2007-1-29 10:28 -->
  <!--
    <td height="20" colspan="2"> <div align="center">重大疾病 </div></td>
    <td height="20" colspan="2">&nbsp;</td>
    <td height="20"> <div align="center">欠缴保费 </div></td>
    <td height="20">&nbsp;</td>
  </tr>
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td height="20">
      <div align="center"> 意外残疾</div></td>
    <td height="20">&nbsp;</td>
    <td height="20" colspan="2">
      <div align="center"> 住院医疗 </div></td>
    <td height="20" colspan="2">&nbsp;</td>
    <td height="20">
      <div align="center"> 扣减费用 </div></td>
    <td height="20">&nbsp;</td>
  </tr>
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td height="20">
      <div align="center">意外医疗 </div></td>
    <td height="20">&nbsp;</td>
    <td height="20" colspan="2">
      <div align="center"> 住院补贴 </div></td>
    <td height="20" colspan="2">&nbsp;</td>
    <td height="20">
      <div align="center"> 其他 </div></td>
    <td height="20">&nbsp;</td>
  -->
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td height="20">
      <div align="center"> 合计</div></td>
    <td height="20" colspan="8">
      <div align="left">&nbsp;<%=strSumRealPay%>&nbsp;元</div></td>
  </tr>
  <!-- delete by miaowenjun 2007-1-29 10:28 -->
  <!--
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td height="20" colspan="9" align="center" valign="middle"><div align="left">&nbsp; 实际给付金额：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;拾万 &nbsp;&nbsp;万 &nbsp;&nbsp;仟 &nbsp;&nbsp;佰 &nbsp;&nbsp;拾 &nbsp;&nbsp;元 &nbsp;&nbsp;角 &nbsp;&nbsp;分 ￥ </div></td>
  </tr>
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td height="20" colspan="9" align="center" valign="middle"> <div align="left">&nbsp;&nbsp;查勘费用 ：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
  </tr>
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td height="20" colspan="9" align="center" valign="middle"> <div align="left">&nbsp;&nbsp;结案总金额：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
  </tr>
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td height="20" colspan="9">      <div align="center"> 审核人 </div></td>
  </tr>
  -->
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td height="20" colspan="5"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt ">
      <tr>
        <td height="10">&nbsp;</td>
      </tr>
      <tr>
        <td height="15"> &nbsp;&nbsp;经办人： <br><br>&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp<%=strHandlerName%><br><br> </td>
      </tr>
      <tr>
        <td height="15"> 
          <div align="center">&nbsp;&nbsp;&nbsp;&nbsp;<%=strInputDate%> </div></td>
      </tr>
    </table></td>
    <td height="20" colspan="5"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt ">
      <tr>
        <td height="10">&nbsp;</td>
      </tr>
      <tr>
        <td height="15"> &nbsp;&nbsp; 审核人 ：
        	<br><br> 
        	<%if("1".equals(prpLcompensateDto.getUnderWriteFlag())){ %>
        	&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp<%=strUnderWriteName%>
        	<%} %>
        	<br><br> </td>
      </tr>
      <tr>
        <td height="15">          
          <div align="center">&nbsp;&nbsp;&nbsp;&nbsp;
          <%if("1".equals(prpLcompensateDto.getUnderWriteFlag())){ %>
          <%=strUnderWriteEndDate%> 
          <%} %>
          </div></td>
      </tr>
    </table></td>
  </tr>
    <!-- delete by miaowenjun 2007-1-29 10:28 -->
  <!--
    <td height="20" colspan="2"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt ">
      <tr>
        <td height="20"> &nbsp; 签批意见： </td>
      </tr>
      <tr>
        <td height="20">&nbsp;</td>
      </tr>
      <tr>
        <td height="20"> &nbsp;&nbsp;签批人

： </td>
      </tr>
      <tr>
        <td height="20">          
          <div align="center">&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;月&nbsp;&nbsp;日&nbsp; </div></td>
      </tr>
    </table></td>
    -->
  <!-- delete by miaowenjun 2007-1-29 10:28 -->
  <!--
  <tr style=" font-family:'宋体';font-size:10pt ">
    <td height="10" colspan="9"><div align="center"> 总公司审核意见 </div></td>
  </tr>
  <tr>
    <td height="20" colspan="3"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt ">
        <tr>
          <td height="20"> &nbsp;&nbsp;经办意见： </td>
        </tr>
        <tr>
          <td height="20">&nbsp;</td>
        </tr>
        <tr>
          <td height="20"> &nbsp;&nbsp;经办人： </td>
        </tr>
        <tr>
          <td height="20">
            <div align="center">&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;月&nbsp;&nbsp;日&nbsp; </div></td>
        </tr>
    </table></td>
    <td height="20" colspan="4"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt ">
        <tr>
          <td height="20"> &nbsp;&nbsp; 审核意见：</td>
        </tr>
        <tr>
          <td height="20">&nbsp;</td>
        </tr>
        <tr>
          <td height="20"> &nbsp;&nbsp; 审核人 ： </td>
        </tr>
        <tr>
          <td height="20">
            <div align="center">&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;月&nbsp;&nbsp;日&nbsp; &nbsp; </div></td>
        </tr>
    </table></td>
    <td height="20" colspan="2"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'宋体';font-size:10pt ">
        <tr>
          <td height="20"> &nbsp; 签批意见： </td>
        </tr>
        <tr>
          <td height="20">&nbsp;</td>
        </tr>
        <tr>
          <td height="20"> &nbsp;&nbsp;签批人 ： </td>
        </tr>
        <tr>
          <td height="20">
            <div align="center">&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;月&nbsp;&nbsp;日&nbsp; </div></td>
        </tr>
    </table></td>
  </tr>
  -->
</table>

      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      	<tr>
      		<td align="left"><%=strPayRefName%></td>
      		<td align="right"><%=strPayRefDate%></td>
      	</tr>
      </table>
<!--include打印按钮-->
  <%
  //EndorseDto endorseDto = uiEndorseAction.findByConditions(strPolicyNo);
  ArrayList prpPheadDtoList = endorseDto.getPrpPheadDtoList();
    if(prpPheadDtoList!=null && prpPheadDtoList.size()>0){
     for(int i =0 ;i<prpPheadDtoList.size();i++)
     {
       PrpPheadDto prpPheadDto = (PrpPheadDto)endorseDto.getPrpPheadDtoList().get(i); 
       
       String EndorseNo = prpPheadDto.getEndorseNo();
       String strCompensateno = prpPheadDto.getCompensateNo();
       if(!(strCompensateno == null || strCompensateno.equals("")))
       {
       %>
	       <jsp:include page="/common/print/UIPtextShow.jsp">
	         <jsp:param name="EndorseNo" value="<%=EndorseNo%>"/>
	       </jsp:include>
       <%
       }
     }
     }  
  %>
  <jsp:include page="/common/print/PrintButton.jsp" />
</body>
</html>
