<%--
****************************************************************************
* DESC       ：国内货物运输保险赔款理算书打印页面
* AUTHOR     ：zhuly
* CREATEDATE ：2005-11-15
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
<%@include file="FreightNationalCompensateNoneFormatPrintIni.jsp"%>
<html>
  <head>
    <title>国内货物运输保险赔款理算书打印</title>
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
            <B>国内货物运输保险赔款理算书<B>
          </td>
        </tr>
        <!--<tr>
          <td width="50%" align=left style="font-family:宋体; font-size:10pt;">
            承保公司（签章）：
          </td>
          <td width="50%" align=left id="tdCompensateNo" style="font-family:宋体; font-size:10pt;">
            赔款计算书号：
          </td>
        </tr>-->
      </table>

      <!-- 主体部分 -->
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
        <tr height="23">
          <td width="12%" align="left" >&nbsp;&nbsp;保险单号</td>
          <td id="tdPolicyNo" width="39%" colspan="3" >&nbsp;</td>    
          <td width="12%" align="left" >&nbsp;&nbsp;赔案编号</td>     
          <td align=left id="tdCaseNo" width="29%" colspan="3" ></td>          
        </tr>
        <tr height="23">
          <td width="15%" align="left" >&nbsp;&nbsp;被保险人</td>
          <td id="tdInsuredName" colspan="3" >&nbsp;</td>    
          <td width="15%" align="left" >&nbsp;&nbsp;保险日期</td>     
          <td align=left id="tdInsuredDate" colspan="3" ></td>          
        </tr>             
        <tr height="23">
          <td width="15%" align="left" ></td>
          <td  colspan="3" >&nbsp;</td>    
          <td width="15%" align="left" >&nbsp;&nbsp;出险日期</td>     
          <td align=left id="tdDamageStartDate" colspan="3" ></td>          
        </tr>    
        <tr height="23">
          <td width="15%" align="left" >&nbsp;&nbsp;出险地点</td>
          <td colspan="7" id="tdDamageAddress">&nbsp;</td>            
        </tr> 
        <tr height="23">
          <td width="15%" align="left" >&nbsp;&nbsp;运输工具牌号</td>
          <td id="tdBLNo" colspan="3" >&nbsp;</td>    
          <td width="15%" align="left" >&nbsp;&nbsp;出险原因</td>     
          <td align=left id="tdDamageName" colspan="3" ></td>          
        </tr> 
        <tr height="23">
          <td width="15%" align="left" >&nbsp;&nbsp;运单号码</td>
          <td id="tdCarryBillNo" colspan="3" >&nbsp;</td>    
          <td width="15%" align="left" >&nbsp;&nbsp;货物名称</td>     
          <td align=left id="" colspan="3" ><%=strLossName%></td>          
        </tr> 
        <tr height="23">
          <td width="15%" align="left">&nbsp;&nbsp;保险险别</td>
          <td  colspan="3" id="tdRiskName" >&nbsp;</td>    
          <td width="15%" align="left">&nbsp;&nbsp;货物数量</td>     
          <td align=left id="" colspan="3" ><%=intLossQuantity%></td>          
        </tr> 
        <tr height="23">
          <td width="15%" align="left">&nbsp;&nbsp;运输路线</td>
          <td id="tdSiteName" colspan="3" >&nbsp;</td>    
          <td width="15%" align="left">&nbsp;&nbsp;保险金额</td>     
          <td align=left id="tdSumAmount" colspan="3" ></td>          
        </tr>
        <tr height="25">
          <td width="15%" align="left" >被保险人开户银行</td>
          <td id="bank" align="left" colspan="3">&nbsp;<%=prpLcompensateDto.getBank()%></td>    
          <td width="15%" align="left" >&nbsp;&nbsp;支付帐号</td>     
          <td id="account" align=left  colspan="3"><%=prpLcompensateDto.getAccount()%></td>          
        </tr>
         <tr height="25">
          <td width="15%" align="left" >收款人全称</td>
          <td id="bank" align="left" colspan="3">&nbsp;<%=prpLcompensateDto.getReceiverName()%></td>    
          <td width="15%" align="left" ></td>     
          <td id="account" align=left  colspan="3"></td>          
        </tr>    
        <tr>
          <td id="tdContext" colspan="8" height="200" valign="top">
            赔款理算：<br>
            <!--<input type=text rows=18 cols=95 class=readonlyWhite readonly style="overflow:hidden;FONT-SIZE: 10pt">-->
          </td>
        </tr>
        <tr height="23">
          <td width="15%" align="center" >&nbsp;赔款项目</td>
          <td width="31%"align="center"  colspan="3" >金&nbsp;&nbsp;额</td>    
          <td width="15%" align="center"  colspan="1" >&nbsp;回收项目</td>     
          <td  width="31%" align="center"  colspan="3" >金&nbsp;&nbsp;额</td>          
        </tr>        
        <tr height="23">
          <td width="15%" align="left" >&nbsp;标的赔款</td>
          <td id="tdSumLossPay" colspan="3" >&nbsp;</td>    
          <td width="15%" align="left"  colspan="1" >&nbsp;第三者责任追回</td>     
          <td align=left  colspan="3" ></td>          
        </tr>        
        <tr height="23">
          <td width="15%" align="left" >&nbsp;施救费</td>
          <td align=left colspan="3" >&nbsp;</td>    
          <td width="15%" align="left"  colspan="1" >&nbsp;损余收回</td>     
          <td align=left  colspan="3" ></td>          
        </tr>     
        <tr height="23">
          <td colspan="8" align="left" id="tdCSumLossPay">赔款合计（大写） （小写）</td>         
        </tr>   
        <tr>
          <td rowspan="5" colspan="2">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr height="50">
                <td width="33%" align="left" valign="top">&nbsp;理算缮制人：<br><br>
                	&nbsp;&nbsp;&nbsp;<%=strHandlerName%></td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=strInputDate%>
                </td>
              </tr>
            </table>
          </td>
          <td rowspan="5" colspan="4">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr height="50">
                <td width="33%" align="left" valign="top">&nbsp;核赔人：<br><br>
                	&nbsp;&nbsp;&nbsp;<%=strUnderWriteName%></td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=strUnderWriteEndDate%>
                </td>
              </tr>
            </table>
          </td>   
          <td align="center" colspan="2" width="25%">&nbsp;赔款支出</td>               
        </tr>
        <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;标的赔款</td>  
          <td align="center" id="tdSSumLossPay" width="15%">&nbsp;</td>            
        </tr>   
        <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;施救费</td>  
          <td align="center" id="tdRescueFee">&nbsp;</td>            
        </tr> 
        <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;查勘费</td>  
          <td align="center" id="tdCheckFee">&nbsp;</td>            
        </tr> 
        <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;检验鉴定费</td>  
          <td align="center" id="tdJudgeFee">&nbsp;</td>            
        </tr>                 
        <tr>
          <td rowspan="5" colspan="2">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr height="80">
                <td width="33%" align="left" valign="top">&nbsp;分公司首席核赔人：</td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
              </tr>
            </table>
          </td>
          <td rowspan="5" colspan="4">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr height="80">
                <td width="33%" align="left" valign="top">&nbsp;总公司核赔人：</td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
              </tr>
            </table>
          </td> 
          <td align="left" colspan="1">&nbsp;&nbsp;共损救助费</td>  
          <td align="center" id="tdGsjzFee">&nbsp;</td>                               
         </tr>
         <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;公估费</td>  
          <td align="center" id="tdAssessFee">&nbsp;</td>           
         </tr>
         <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;法律费</td>  
          <td align="center" id="tdFlFee">&nbsp;</td>           
         </tr>         
         <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;其它</td>  
          <td align="center" id="tdElseFee">&nbsp;</td>           
         </tr>
         <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;总计</td>  
          <td align="center" id="tdSSumPaid">&nbsp;</td>           
         </tr>    
         
         <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      	<tr>
      		<td align="left"><%=strPayRefName%></td>
      		<td align="right"><%=strPayRefDate%></td>
      	</tr>
      </table>
    <table border="0"><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：赔款支出项目中赔款合计栏所列金额为支付被保险的人赔款金额。</td></tr></table>

    <%--//modify by wangli update  start 20050422 --%>
     <jsp:include page="/common/print/PrintButton.jsp" />
      
      <%-- <jsp:include page="/DAA/compensate/DAASpecialPrintButton.jsp" />--%>
    <%--//modify by wangli update end 20050422 --%>
  </body>

</html>
