<%--
****************************************************************************
* DESC       ：进口货物运输保险赔款理算书打印页面
* AUTHOR     ：zhuly
* CREATEDATE ：22004-11-16
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%-- 初始化 --%>
<%@include file="FreightInportCompensateNoneFormatPrintIni.jsp"%>
<html>
  <head>
    <title>
    	<%=riskCName %>赔款理算书
    </title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
      <!-- 标题部分 -->
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:宋体; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>      
        <tr>
          <td colspan="3" height="40"  align=center style="font-family:宋体; font-size:14pt;">
            <B><%=riskCName %>赔款理算书<B>
          </td>
        </tr>
      </table>

     <!-- 主体部分 -->
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
        <tr height="25">
          <td width="20%"  align="center" colspan="2">保 险 单 号 码</td>
          <td id="tdPolicyNo" width="39%"align="center" colspan="3">&nbsp;</td>    
          <td width="15%"  colspan="2"align="center" >立&nbsp; 案&nbsp; 号</td>     
          <td align=center id="tdClaimNo" width="26%"align="center" colspan="3"></td>          
        </tr>
        <tr height="25">
          <td width="15%" align="center" colspan="2">被&nbsp; 保&nbsp; 险&nbsp; 人</td>
          <td id="tdInsuredName"align="center" colspan="3">&nbsp;</td>    
          <td width="15%"colspan="2"align="center">出&nbsp; 险&nbsp; 日&nbsp; 期</td>     
          <td id="tdDamageStartDate"align="center" colspan="3"></td>          
        </tr>   
        <tr height="25">
           <td width="15%" align="center"  colspan="2">提&nbsp;&nbsp;&nbsp; 单&nbsp;&nbsp;&nbsp; 号</td>
          <td id="tdLadingNo" colspan="3" align="center">&nbsp;</td>   
          <td width="15%" align="center" colspan="2">保&nbsp; 险&nbsp; 金&nbsp; 额</td>     
          <td align="center" id="tdSumAmount" colspan="3"></td>          
        </tr>
        <tr height="25">   
           <td width="12%" align="center" colspan="2" >公&nbsp; 司&nbsp; 合&nbsp; 同<br>或&nbsp; 发&nbsp; 票&nbsp; 号</td>
          <td id="tdInvoiceNo" width="39%"align="center" colspan="3">&nbsp;</td> 
          <td width="15%" align="center" colspan="2">保&nbsp; 险&nbsp; 险&nbsp; 别</td>     
          <td align=center id="tdRiskName" colspan="3"></td>           
        </tr>   
        <tr height="25">
          <td width="15%" align="center"  colspan="2">运&nbsp; 输&nbsp; 工&nbsp; 具</td>
          <td id="tdBLNo"align="center" colspan="3">&nbsp;</td>     
          <td width="3%" align="center" rowspan="5">标的及件数</td>     
          <td align="center" id="tdValue1" rowspan="5" width="35%" colspan="4" valign="top"></td>          
        </tr> 
        <tr height="25">
          <td width="15%" align="center"  colspan="2">运&nbsp; 输&nbsp; 路&nbsp; 线</td>
          <td id="tdSiteName"align="center" colspan="3">&nbsp;</td> 
        </tr>
        <tr height="25">  
          <td width="15%" align="center"  colspan="2">开&nbsp; 航&nbsp; 日&nbsp; 期</td>     
          <td align="center"id="tdSailStartDate"align="center"  colspan="3"></td>          
        </tr> 
        <tr height="25">
          <td width="15%" align="center"  colspan="2">检&nbsp; 验&nbsp; 代&nbsp; 理</td>
          <td id="tdCheckAgentCode"align="center" colspan="3">&nbsp;</td>            
        </tr>                    
       
        <tr height="25">
          <td width="15%" align="center" colspan="2">被保险人开户银行</td>
          <td id="bank"align="center" colspan="3">&nbsp;<%=prpLcompensateDto.getBank()%></td>              
        </tr>
        <tr height="25">
          <td width="15%" align="center" colspan="2">收款人全称</td>
          <td id="bank"align="center" colspan="3">&nbsp;<%=prpLcompensateDto.getReceiverName()%></td>    
          <td width="15%"colspan="2"align="center">支&nbsp; 付&nbsp; 帐&nbsp; 号</td>     
          <td id="account"align="center" colspan="3">&nbsp;<%=prpLcompensateDto.getAccount()%></td>          
        </tr>    
        <tr>
          <td id="tdContext" colspan="10" height="200" valign="top">
            赔款理算：<br>
            <!--<input type=text rows=18 cols=95 class=readonlyWhite readonly style="overflow:hidden;FONT-SIZE: 10pt">-->
          </td>
        </tr>
		  <tr>
			<td colspan="2"> <div align="center">保 品 受 损 </div></td>
			<td colspan="3"><div align="center"> 受 损 金 额 </div></td>
			<td colspan="4" rowspan="6"width="20%"> <p>编制人意见： </p>
			<p><input type="text" name="ksjsks" class="readonly"  readonly="true"  style="width:140px" value=""></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</p>
			</td>
			<td width="129" rowspan="6"><p>分公司核赔人意见： </p>  
			<p>&nbsp;</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</p>
			</td>
		  </tr>
		  <tr>
			<td colspan="2"><div align="center"> 险 别 分 析 </div></td>
			<td width="90"><div align="center"> 人 民 币 </div></td>
			<td width="37"><div align="center"></div></td>
			<td width="122"><div align="center"> 原 币 </div></td>
		  </tr>
		  
		  <%
		  	String strKindName2 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		  	String strRealPay = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		  for(int i=0;i<prplLossList.size();i++){
		  	PrpLlossDto lossDto = (PrpLlossDto)prplLossList.get(i);
		  	if(lossDto.getKindName()!=null&&lossDto.getKindName().trim().length()>0){
			  	strKindName2 =lossDto.getKindName();
			  	strRealPay = new DecimalFormat("#,##0.00").format(lossDto.getSumRealPay());
			  	//lossDto.getSumRealPay()
		  	}else{
		  	 	strKindName2 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		  	 	strRealPay = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		  	}
		  	
		  %>
		  <tr>
			<td colspan="2"><div align="center"> <%=strKindName2%> </div></td>
			<td><div align="center"><%=strRealPay%></div></td>
			<td/>
			<td/>
		  </tr>
		  <%}%>		  

		  <tr>
			<td colspan="2"><div align="center"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
			<td><div align="center"></div></td>
			<td><div align="center"></div></td>
			<td><div align="center"></div></td>
			<td colspan="4" rowspan="9"> <p>分公司首席核赔人意见： </p>
			 <p>&nbsp;</p>
			 <p>&nbsp;</p>
			 <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</p>
			
			</td>
			<td rowspan="9"> <p>总公司核赔人意见： </p> 
			 <p>&nbsp;</p>
			 <p>&nbsp;</p>
			 <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</p>
			</td>
		  </tr>
		  <tr>
			<td  rowspan="7" align="center">费 用</td>
			<td ><div align="center">施救费</div></td>
			<td id="tdRescueFee" align="center"></td>
			<td/>
			<td/>
		  </tr>
		  <tr>
			<td><div align="center">查勘费</div></td>
			<td id="tdCheckFee" align="center"></td>
			<td/>
			<td/>
		  </tr>
		  <tr>
			<td><div align="center">检验鉴定费</div></td>
			<td  id="tdJudgeFee" align="center"></td>
			<td/>
			<td/>
		  </tr>
		  <tr>
			<td><div align="center">共损救助费</div></td>
			<td  id="tdGsjzFee" align="center"></td>
			<td/>
			<td/>
		  </tr>
		  <tr>
			<td><div align="center">公估费</div></td>
			<td  id="tdAssessFee" align="center"></td>
			<td/>
			<td/>
		  </tr>		  		  
		  <tr>
			<td><div align="center">法律费</div></td>
			<td  id="tdFlFee" align="center"></td>
			<td/>
			<td/>
		  </tr>		  
		  <tr>
			<td><div align="center">其它</div></td>
			<td id="tdElseFee" align="center"></td>
			<td/>
			<td/>
		  </tr>
		  <tr>
			<td colspan="2"><div align="center"> 本案损失合计 </div></td>
			<td id="tdSSumPaid" align="center"></td>
			<td/>
			<td/>
		  </tr>
       </table>        
      <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
  </body>

</html>
