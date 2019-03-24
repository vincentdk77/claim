<%--
****************************************************************************
* DESC       ：保单卷宗封面打印界面
* Author     : 国元
* CREATEDATE ：2014-05-8
* MODIFYLIST ：Name       Date            Reason/Contents
****************************************************************************
--%>

<%@page errorPage="/UIErrorPage"%>

<%-- 引入bean类部分 --%>
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
	String strCompensateNo      = request.getParameter("CompensateNo");       //取理算书号
  
  //定义变量
  	String claimNo = "";//立案号
  	String strPolicyNo = "";//保单号
  	String strDamageName = "";//出险原因
  	String strDamageDate = "";//出险时间


    //得到保单对象
    if( strCompensateNo == null )
    {
      throw new UserException(-98,-998,"AgriCompensateCoverPrint","没有提供理算书参数！");
    }
    if( strCompensateNo.trim().length() == 0 )
    {
      throw new UserException(-98,-997,"AgriCompensateCoverPrint","用户没有提供理算书号！");
    }
    if( !strCompensateNo.trim().startsWith("631") && !strCompensateNo.trim().startsWith("632") && !strCompensateNo.trim().startsWith("60310")&& !strCompensateNo.trim().startsWith("60312"))
    {
      throw new UserException(-98,-997,"AgriCompensateCoverPrint","农险卷宗打印，请录入农险计算书号！");
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
    
    //获取保单信息
    BLPrpCmain blPrpCmain = new BLPrpCmain();
    blPrpCmain.getData(strPolicyNo);
    
  
	  //代码翻译变量
	  String strComCode = "";//机构代码
	  String strComName = "";//机构名称
	  String strRiskCode = "";//险种代码
	  String strRiskName = "";//险种名称
  

  
	PrpCmainSchema prpCmainSchema = new PrpCmainSchema(); 
    prpCmainSchema = blPrpCmain.getArr(0);
    
    
  	strComCode = prpLcompensateDto.getComCode();
  	BLPrpDcompany blPrpDcompany = new BLPrpDcompany();
  	strComName = blPrpDcompany.translateCode(strComCode,true);
  	
  	strRiskCode = prpCmainSchema.getRiskCode();
  	BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
  	strRiskName = blPrpDrisk.translateCode(strRiskCode,true);
  	
  	//保单打印省份改造
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
  	
	String currencyUnit = "";//金额单位
	String strCurrency = prpLcompensateDto.getCurrency();
	if("CNY".equals(strCurrency))
		currencyUnit = "元";
%>
 <script language='javascript'>
 	function coverPrint(){
 		coverPrintButton.style.display = "none"
 		window.print();
 	}
 </script>
<html>	
	<head>
		<title>赔案卷宗封面打印 </title>
	</head>
	<body onload="">
	  <form id="fm">
      <!-- 标题部分 -->  
      <div width="100%" align="left" cellspacing="0" cellpadding="0" border="0">
      <table  align="center" cellspacing="0" cellpadding="0" border="0">
	    <tr>
	      <br><br/><br/><br/><br/><br/>
	      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="/claim/images/imgCoverPrintLogo.gif" >
        </tr>
        <tr>
	      <br/><br/><br/>
          <b height="30" style="text-align:center; font-size:30pt;">  
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;赔&nbsp;案&nbsp;卷&nbsp;宗
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
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">赔案编号：</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%=claimNo %></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">保单号码：</b></td>
        	<td width="25%" ><b height="15" style=" font-size:15pt;"><%=prpCmainSchema.getPolicyNo()%></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">被保险人：</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%=prpCmainSchema.getInsuredName()%></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">承保险种：</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%=strRiskName %></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">出险原因：</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%=strDamageName %></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">出险时间：</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%=strDamageDate %></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">理赔金额：</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%= prpLcompensateDto.getSumPaid()%><%=currencyUnit %></b></td>
        	<td width="35%"></td>
        </tr>
        <tr>
        	<td >&nbsp;</td>
        </tr>
        <tr>
        	<td width="15%"></td>
        	<td width="25%" align="right"><b height="15" style=" font-size:15pt;">机构名称：</b></td>
        	<td width="25%"><b height="15" style=" font-size:15pt;"><%=strComName%></b></td>
        	<td width="35%"></td>
        </tr>
   
         <tr id = "coverPrintButton" name = "coverPrintButton" style="display:">
    	
	          <td width="15%"></td>
		      <td class=button style="width:25%" align="center" >
		        <input class="button" type="button"  name="buttonPrint" alt="打印" value="打印" onclick="coverPrint()">
		      </td>
		      <td class=button style="width:25%" align=""center"">
		        <input class="button" type="button"  name="buttonClose" alt="关闭" value="关闭" onclick="javascript:window.close()">
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
           	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;国&nbsp;元&nbsp;农&nbsp;业&nbsp;保&nbsp;险&nbsp;股&nbsp;份&nbsp;有&nbsp;限&nbsp;公&nbsp;司
          </span>  
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
          <b height="20" style="text-align:center; font-size:20pt;">  
           	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%--=strRiskName --%>赔案卷宗清单
          </b>  
        </tr>
        <tr>
        	<br><br/><br/><br/><br/><br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  1、&nbsp;赔案流转审批表</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  2、&nbsp;赔款计算书</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  3、&nbsp;出险及索赔通知书</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  4、&nbsp;保险单抄件</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  5、&nbsp;现场综合查勘报告</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  6、&nbsp;灾害损失联合查勘确认书</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  7、&nbsp;气象证明</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  8、&nbsp;定损公示证明</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  9、&nbsp;理赔公示证明</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  10、&nbsp;委托赔付协议</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  11、&nbsp;理赔分户清单</b>
        </tr>
        <tr>
        	&nbsp;<br/>
        </tr>
        <tr>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" style="height:20pt;"/>&nbsp;&nbsp;<b height="20" style="text-align:center; font-size:20pt;">  12、&nbsp;其他</b>
        </tr>
      </table>
         -->
	      </div>
	  	
	  </form>
	</body>	
</html>