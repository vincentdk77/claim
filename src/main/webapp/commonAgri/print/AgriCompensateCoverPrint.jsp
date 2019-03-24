<%--
****************************************************************************
* DESC       ���������ڷ����ӡ����
* Author     : ��Ԫ
* CREATEDATE ��2014-05-8
* MODIFYLIST ��Name       Date            Reason/Contents
****************************************************************************
--%>

<%@page errorPage="/UIErrorPage"%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>

<%@page import="com.sinosoft.prpall.blsvr.cb.*"%>
<%@page import="com.sinosoft.prpall.schema.*"%>
<%@page import="com.sinosoft.utiall.blsvr.*"%>
<%@page import="com.sinosoft.utility.error.UserException"%>
<%@page import="com.sinosoft.utiall.schema.*"%>
<%@page import="com.sinosoft.claim.bl.facade.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>


<%
	String strCompensateNo      = request.getParameter("CompensateNo");       //ȡ�������
  
  //�������
  	String claimNo = "";//������
  	String strPolicyNo = "";//������
  	String strDamageName = "";//����ԭ��
  	String strDamageDate = "";//����ʱ��


    //�õ���������
    if( strCompensateNo == null )
    {
      throw new UserException(-98,-998,"AgriCompensateCoverPrint","û���ṩ�����������");
    }
    if( strCompensateNo.trim().length() == 0 )
    {
      throw new UserException(-98,-997,"AgriCompensateCoverPrint","�û�û���ṩ������ţ�");
    }
    if( !strCompensateNo.trim().startsWith("631") && !strCompensateNo.trim().startsWith("632") && !strCompensateNo.trim().startsWith("60310")&& !strCompensateNo.trim().startsWith("60312"))
    {
      throw new UserException(-98,-997,"AgriCompensateCoverPrint","ũ�վ��ڴ�ӡ����¼��ũ�ռ�����ţ�");
    }
    BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
    PrpLcompensateDto prpLcompensateDto = blPrpLcompensateFacade.findByPrimaryKey(strCompensateNo);
    claimNo = prpLcompensateDto.getClaimNo();
    strPolicyNo = prpLcompensateDto.getPolicyNo();
    
    BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
    PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo);
    if(null != prpLclaimDto){
    	strDamageName = prpLclaimDto.getDamageName();
    	DateTime damageDate = prpLclaimDto.getDamageStartDate();
    	strDamageDate = damageDate.toString();
    }
    
    //��ȡ������Ϣ
    BLPrpCmain blPrpCmain = new BLPrpCmain();
    blPrpCmain.getData(strPolicyNo);
    
  
	  //���뷭�����
	  String strComCode = "";//��������
	  String strComName = "";//��������
	  String strRiskCode = "";//���ִ���
	  String strRiskName = "";//��������
  

  
	PrpCmainSchema prpCmainSchema = new PrpCmainSchema(); 
    prpCmainSchema = blPrpCmain.getArr(0);
    
    
  	strComCode = prpLcompensateDto.getComCode();
  	BLPrpDcompany blPrpDcompany = new BLPrpDcompany();
  	strComName = blPrpDcompany.translateCode(strComCode,true);
  	
  	strRiskCode = prpCmainSchema.getRiskCode();
  	BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
  	strRiskName = blPrpDrisk.translateCode(strRiskCode,true);
  	
  	//������ӡʡ�ݸ���
	  String strComCodeForTemp = (String)session.getValue("ComCode");
	  BLPrpDcompany blPrpDcompanyForTemp = new BLPrpDcompany();
	  String strComCodeForProvince = blPrpDcompanyForTemp.getProvinceComCode(strComCodeForTemp);
	  BLPrpDprovinceConfig bLPrpDprovinceConfig = new BLPrpDprovinceConfig();
	  PrpDprovinceConfigSchema prpDprovinceConfigSchema = null;
	  bLPrpDprovinceConfig.Query(strComCodeForProvince,strRiskCode);
	  prpDprovinceConfigSchema = bLPrpDprovinceConfig.getArr(0);
	  if(prpDprovinceConfigSchema != null)
	  {
	  	if(prpDprovinceConfigSchema.getRiskName() != null && prpDprovinceConfigSchema.getRiskName() != "")
	  	{
	  		strRiskName = prpDprovinceConfigSchema.getRiskName();
	  	}
	  }
  	
	String currencyUnit = "";//��λ
	String strCurrency = prpLcompensateDto.getCurrency();
	if("CNY".equals(strCurrency))
		currencyUnit = "Ԫ";
%>
 <script language='javascript'>
 	function coverPrint(){
 		coverPrintButton.style.display = "none"
 		window.print();
 	}
 </script>
<html>	
	<head>
		<title>�ⰸ���ڷ����ӡ </title>
	</head>
	<body onload="">
	  <form id="fm">
      <!-- ���ⲿ�� -->  
      <div width="100%" align="left" cellspacing="0" cellpadding="0" border="0">
      <table  align="center" cellspacing="0" cellpadding="0" border="0">
	    <tr>
	      <br><br/><br/><br/><br/><br/>
	      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="/claim/images/imgCoverPrintLogo.gif" >
        </tr>
        <tr>
	      <br/><br/><br/>
          <b height="30" style="text-align:center; font-size:30pt;">  
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;��&nbsp;��&nbsp;��
          </b>  
        </tr>
        <tr>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b height="30" style="FONT-WEIGHT: bold; FONT-SIZE: 20pt;font-family:Times New Roman; TEXT-DECORATION:underline; FONT-STYLE:italic;">
          CLAIMS FILE
          </b>
        </tr>
        <tr>
        	<br/><br/><br/><br/>
        </tr>
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">�ⰸ��ţ�</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%=claimNo %></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">�������룺</b></td>
        	<td width="25%" ><b height="15" style=" font-size:15pt;"><%=prpCmainSchema.getPolicyNo()%></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">�������ˣ�</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%=prpCmainSchema.getInsuredName()%></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">�б����֣�</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%=strRiskName %></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">����ԭ��</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%=strDamageName %></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">����ʱ�䣺</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%=strDamageDate %></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">�����</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%= prpLcompensateDto.getSumPaid()%><%=currencyUnit %></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">�������ƣ�</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%=strComName%></b></td>
        	<td width="35%"></td>
        </tr>
   
         <tr id = "coverPrintButton" name = "coverPrintButton" style="display:">
    	
	          <td width="15%"></td>
		      <td class=button style="width:25%" align="center" >
		        <input class="button" type="button"  name="buttonPrint" alt="��ӡ" value="��ӡ" onclick="coverPrint()">
		      </td>
		      <td class=button style="width:25%" align=""center"">
		        <input class="button" type="button"  name="buttonClose" alt="�ر�" value="�ر�" onclick="javascript:window.close()">
		      </td>
	          <td width="35%"></td>
    </tr>
      </table>
      <!-- 
    <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">
        <tr>
        	&nbsp;<br><br/><br/><br/><br/><br/><br><br/><br/><br/><br/><br/><br><br/>
        </tr>
        <tr>
          <span height="25" style="text-align:center; font-size:25pt; font-weight:800;">  
           	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;Ԫ&nbsp;ũ&nbsp;ҵ&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;˾
          </span>  
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
          <b height="20" style="text-align:center; font-size:20pt;">  
           	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%--=strRiskName --%>�ⰸ�����嵥
          </b>  
        </tr>
        <tr>
        	<br><br/><br/><br/><br/><br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  1��&nbsp;�ⰸ��ת������</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  2��&nbsp;��������</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  3��&nbsp;���ռ�����֪ͨ��</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  4��&nbsp;���յ�����</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  5��&nbsp;�ֳ��ۺϲ鿱����</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  6��&nbsp;�ֺ���ʧ���ϲ鿱ȷ����</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  7��&nbsp;����֤��</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  8��&nbsp;����ʾ֤��</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  9��&nbsp;���⹫ʾ֤��</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  10��&nbsp;ί���⸶Э��</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  11��&nbsp;����ֻ��嵥</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" style="height:20pt;"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  12��&nbsp;����</b>
        </tr>
      </table>
         -->
	      </div>
	  	
	  </form>
	</body>	
</html>