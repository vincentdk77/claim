<%--
****************************************************************************
* DESC       ������������ӡ
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-14
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="java.util.*"%>
<%-- ��ʼ�� --%>
<%@include file="AcciCompensateAuditBookNoneFormatPrintIni.jsp"%>

<html>
<head>
<title>���������ӡ</title>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>

<%
	String acciName = (String)request.getAttribute("acciName");
	String sex = (String)request.getAttribute("sex");
	String identifyNumber = (String)request.getAttribute("identifyNumber");

%>

<body onLoad="loadForm();">
<table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
        <tr>
          <td width="100%" height="40" align=center style="font-family:����; font-size:14pt;">
            <img src="/claim/images/LOGO.jpg"/>
          </td>
        </tr>      
        <tr>
          <td height="20" align=center style="font-family:����; font-size:14pt;">
            <B>���������ӡ<B>
          </td>
        </tr>
        <tr>
          <td height="20" align=center style="font-family:����; font-size:10pt;"><div align="left"> ������ : <span id="spClaimNo"></span></div></td>
        </tr>
</table>

<table width="92%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#111111" style="border-collapse:collapse; font-family:���� font-size:10pt;">
  <tr  style=" font-family:'����';font-size:10pt ">
    <td width="2%" height="20" rowspan="6" align="center" valign="middle">�¹����</td>
    <td height="25" colspan="8">          <table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt;">
        <tr>
          <td height="20">�¹����ͣ� </td>
        </tr>
        <tr>
          <td height="20"><span id="spDamageTypeName">��������� ������м� ���ؼ� ������ҽ�� ������ҽ�� </span></td>
        </tr>
      </table>
      
    </td>
  </tr>
  <tr  style=" font-family:'����';font-size:10pt ">
    <td width="17%" height="20" align="center" valign="middle"> �������� </td>
    <td height="20" colspan="3" align="center" valign="middle"><span id="spPolicyNo"></span>&nbsp;</td>
    <td height="20" colspan="2" align="center"  valign="middle"> ��Ч�� </td>
	<td height="20" colspan="2" align="center"  valign="middle">&nbsp;</td>
  </tr>
  <%for(int i = 0;i < strAcciName.length; i++){ %>
  <tr  style=" font-family:'����';font-size:10pt ">
    <td width="17%" height="20" align="center" valign="middle"> �¹������� </td>
    <td width="14%" height="20" align="center" valign="middle"><%=strAcciName[i] %>&nbsp;</span></td>
    <td width="7%" height="20" align="center" valign="middle"><div align="center">�Ա�</div></td>
    <td width="6%" height="20" align="center" valign="middle"><%=strAcciSex[i] %>&nbsp;&nbsp;</span></td>
    <td width="7%" height="20" align="center" valign="middle">����</td>
    <td width="13%" height="20" align="center"  valign="middle"><%=strAcciAge[i] %>&nbsp;</span></td>
	<td width="13%" height="20" align="center"  valign="middle"> <div align="center">���֤����</div></td>
    <td width="21%" height="20" align="center"  valign="middle"><%=strAcciIDCardNo[i] %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    <div align="center"></div></td>
  </tr>
  <%} %>
  <tr style=" font-family:'����';font-size:10pt ">
    <td width="17%" height="20" align="center" valign="middle"> �¹�ʱ�� </td>
    <td height="20" colspan="3" align="center" valign="middle"><span id="spAcciDate"></span>&nbsp; </td>
    <td height="20" colspan="2" align="center"  valign="middle">����� </td>
	<td height="20" colspan="2" align="center"  valign="middle">&nbsp; </td>
  </tr>
  <tr style=" font-family:'����';font-size:10pt ">
    <td height="20" align="center" valign="middle">�м�������</td>
    <td height="20" colspan="3" align="center" valign="middle">&nbsp;</td>
    <td height="20" colspan="2" align="center"  valign="middle">���������</td>
    <td height="20" colspan="2" align="center"  valign="middle">&nbsp;</td>
  </tr>
  <tr style=" font-family:'����';font-size:10pt ">
    <td height="25" colspan="8" align="center" valign="middle"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt ">
      <tr>
        <td height="20"> <div align="left">�¹�ԭ�����ʼ��¹�����״�� </div></td>
      </tr>
      <tr>
        <td height="25"><span id="spAcciDamageDesc"></span>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  
  <tr style=" font-family:'����';font-size:10pt ">
    <td width="2%" height="20" align="center" valign="middle"><p>������Ϣ </p></td>
    <td height="12" colspan="8" valign="top">
    <table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt ">
      <tr>
        <td height="25"> �¹������б�����Ϣ�� </td>
      </tr>
      <tr>
        <td height="25"> ������&nbsp;&nbsp;<span id="spPolicyNo1"></span></td>
      </tr>
      <tr>
        <td height="25"> ��������&nbsp;&nbsp;<span id="spInsuredDate"></span></td>
      </tr>
      <tr>
        <td height="25"> ���ս��&nbsp;&nbsp;<span id="spSumAmount"></span>&nbsp;&nbsp;Ԫ</td>
      </tr>      
    </table> 
    </td>
  </tr>
  <tr>
    <td height="13" colspan="8" valign="top">
    <table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt ">
      <tr>
        <td height="25"> ��ʷ�⸶��¼��</td>
      </tr>
      <tr>
        <td height="25"> �¹�ʱ��&nbsp;&nbsp;<span id="spAcciDate1"></span></td>
      </tr>
      <tr>
        <td height="25"> ԭ��&nbsp;&nbsp;<span id="spAcciDamageName"></span></td>
      </tr>
      <tr>
        <td height="25"> ������� /�������&nbsp;&nbsp;</td>
      </tr>
      <tr>
        <td height="25"> ������&nbsp;&nbsp;<span id="spClaimNo1"></span></td>
      </tr>
    </table></td>
  </tr>
   <tr>
    <td height="13" colspan="8" valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt ">
      <tr>
        <td height="25"> �������˿�������&nbsp;&nbsp;<%=prpLcompensateDto.getBank()%></td>
      </tr>
      <tr>
        <td height="25"> ֧���ʺ�&nbsp;&nbsp;<%=prpLcompensateDto.getAccount()%></td>
      </tr>
       <tr>
        <td height="25"> �տ���ȫ��&nbsp;&nbsp;<%=prpLcompensateDto.getReceiverName()%></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="13" colspan="8" valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt ">
      <tr>
        <td height="25"> �����������Ϣ��</td>
      </tr>
      <tr>
        <td height="25"> �¹�������&nbsp;&nbsp;<%=acciName%></td>
      </tr>
      <tr>
        <td height="25"> �Ա�&nbsp;&nbsp;<%=sex%></td>
      </tr>
      <tr>
        <td height="25"> ���֤����&nbsp;&nbsp;<%=identifyNumber%></td>
      </tr>
    </table></td>
  </tr>
  <!-- delete by miaowenjun 2007-1-29 10:28 -->
  <!--
  <tr>
  <td colspan="9"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt ">
    <tr>
      <td height="20"> ������ۡ����ݣ�</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
    </tr>
  </table></td></tr>
  -->
  <tr style=" font-family:'����';font-size:10pt ">
    <td width="2%" height="25" rowspan='<%=prplPersonList.size()%>' align="center" valign="middle"><p>����</p></td>
    <td height="25" colspan="8" valign="top">
<table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt ">
  <tr>
    <td height="20">��������̣�
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
  <tr style=" font-family:'����';font-size:10pt ">
    <td height="20" colspan="6">    <div align="center"> ������Ŀ����� </div></td>
    <td height="20" colspan="2"><div align="center"> �ۿ���Ŀ����� </div></td>
  </tr>
  -->
  <%
  for (Iterator iter = prplPersonList.iterator(); iter.hasNext();) {
			PrpLpersonLossDto personLoss = (PrpLpersonLossDto) iter.next();
			if(personLoss!=null){
  %>
  <!--<tr style=" font-family:'����';font-size:10pt ">
    <td height="20"> <div align="center"><%=personLoss.getLiabDetailName()%></div></td>
    <td height="20" colspan="8">&nbsp;<%=personLoss.getSumRealPay()%></td>
  </tr>
    --><%}}%>
    <!-- delete by miaowenjun 2007-1-29 10:28 -->
  <!--
    <td height="20" colspan="2"> <div align="center">�ش󼲲� </div></td>
    <td height="20" colspan="2">&nbsp;</td>
    <td height="20"> <div align="center">Ƿ�ɱ��� </div></td>
    <td height="20">&nbsp;</td>
  </tr>
  <tr style=" font-family:'����';font-size:10pt ">
    <td height="20">
      <div align="center"> ����м�</div></td>
    <td height="20">&nbsp;</td>
    <td height="20" colspan="2">
      <div align="center"> סԺҽ�� </div></td>
    <td height="20" colspan="2">&nbsp;</td>
    <td height="20">
      <div align="center"> �ۼ����� </div></td>
    <td height="20">&nbsp;</td>
  </tr>
  <tr style=" font-family:'����';font-size:10pt ">
    <td height="20">
      <div align="center">����ҽ�� </div></td>
    <td height="20">&nbsp;</td>
    <td height="20" colspan="2">
      <div align="center"> סԺ���� </div></td>
    <td height="20" colspan="2">&nbsp;</td>
    <td height="20">
      <div align="center"> ���� </div></td>
    <td height="20">&nbsp;</td>
  -->
  <tr style=" font-family:'����';font-size:10pt ">
    <td height="20">
      <div align="center"> �ϼ�</div></td>
    <td height="20" colspan="8">
      <div align="left">&nbsp;<%=strSumRealPay%>&nbsp;Ԫ</div></td>
  </tr>
  <!-- delete by miaowenjun 2007-1-29 10:28 -->
  <!--
  <tr style=" font-family:'����';font-size:10pt ">
    <td height="20" colspan="9" align="center" valign="middle"><div align="left">&nbsp; ʵ�ʸ�����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ʰ�� &nbsp;&nbsp;�� &nbsp;&nbsp;Ǫ &nbsp;&nbsp;�� &nbsp;&nbsp;ʰ &nbsp;&nbsp;Ԫ &nbsp;&nbsp;�� &nbsp;&nbsp;�� �� </div></td>
  </tr>
  <tr style=" font-family:'����';font-size:10pt ">
    <td height="20" colspan="9" align="center" valign="middle"> <div align="left">&nbsp;&nbsp;�鿱���� ��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
  </tr>
  <tr style=" font-family:'����';font-size:10pt ">
    <td height="20" colspan="9" align="center" valign="middle"> <div align="left">&nbsp;&nbsp;�᰸�ܽ�&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
  </tr>
  <tr style=" font-family:'����';font-size:10pt ">
    <td height="20" colspan="9">      <div align="center"> ����� </div></td>
  </tr>
  -->
  <tr style=" font-family:'����';font-size:10pt ">
    <td height="20" colspan="5"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt ">
      <tr>
        <td height="10">&nbsp;</td>
      </tr>
      <tr>
        <td height="15"> &nbsp;&nbsp;�����ˣ� <br><br>&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp<%=strHandlerName%><br><br> </td>
      </tr>
      <tr>
        <td height="15"> 
          <div align="center">&nbsp;&nbsp;&nbsp;&nbsp;<%=strInputDate%> </div></td>
      </tr>
    </table></td>
    <td height="20" colspan="5"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt ">
      <tr>
        <td height="10">&nbsp;</td>
      </tr>
      <tr>
        <td height="15"> &nbsp;&nbsp; ����� ��
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
    <td height="20" colspan="2"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt ">
      <tr>
        <td height="20"> &nbsp; ǩ������� </td>
      </tr>
      <tr>
        <td height="20">&nbsp;</td>
      </tr>
      <tr>
        <td height="20"> &nbsp;&nbsp;ǩ����

�� </td>
      </tr>
      <tr>
        <td height="20">          
          <div align="center">&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp; </div></td>
      </tr>
    </table></td>
    -->
  <!-- delete by miaowenjun 2007-1-29 10:28 -->
  <!--
  <tr style=" font-family:'����';font-size:10pt ">
    <td height="10" colspan="9"><div align="center"> �ܹ�˾������ </div></td>
  </tr>
  <tr>
    <td height="20" colspan="3"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt ">
        <tr>
          <td height="20"> &nbsp;&nbsp;��������� </td>
        </tr>
        <tr>
          <td height="20">&nbsp;</td>
        </tr>
        <tr>
          <td height="20"> &nbsp;&nbsp;�����ˣ� </td>
        </tr>
        <tr>
          <td height="20">
            <div align="center">&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp; </div></td>
        </tr>
    </table></td>
    <td height="20" colspan="4"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt ">
        <tr>
          <td height="20"> &nbsp;&nbsp; ��������</td>
        </tr>
        <tr>
          <td height="20">&nbsp;</td>
        </tr>
        <tr>
          <td height="20"> &nbsp;&nbsp; ����� �� </td>
        </tr>
        <tr>
          <td height="20">
            <div align="center">&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp; &nbsp; </div></td>
        </tr>
    </table></td>
    <td height="20" colspan="2"><table width="100%"  border="0" cellspacing="0" cellpadding="0" style=" font-family:'����';font-size:10pt ">
        <tr>
          <td height="20"> &nbsp; ǩ������� </td>
        </tr>
        <tr>
          <td height="20">&nbsp;</td>
        </tr>
        <tr>
          <td height="20"> &nbsp;&nbsp;ǩ���� �� </td>
        </tr>
        <tr>
          <td height="20">
            <div align="center">&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp; </div></td>
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
<!--include��ӡ��ť-->
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
