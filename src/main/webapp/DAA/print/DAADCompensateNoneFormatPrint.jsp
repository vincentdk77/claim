<%--
****************************************************************************
* DESC       ：机动车辆强制保险赔款计算书打印页面
* AUTHOR     ：liubvo
* CREATEDATE ：22004-11-16
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

  <%-- 初始化 --%>
  <%@include file="DAADCompensateNoneFormatPrintIni.jsp"%>

<html>
  <head>
    <title>机动车辆保险赔款计算书打印</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  <style type="text/css">
<!--
.style2 {font-size: 10pt}
.STYLE3 {font-size: 10px}
.STYLE6 {font-size: 14px}
-->
  </style>
  </head>

  <body bgcolor="#FFFFFF" onLoad="loadForm();">
    <form name="fm">
      <!-- 标题部分 -->
     <table width="92%" align="center"　cellpadding="2" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td colspan="2" height="40" align=center style="font-family:宋体; font-size:14pt;">
            <img src="/claim/images/LOGO.jpg"/>
          </td>
        </tr>
        <tr>
          <td colspan="2" height="40"  align=center style="font-family:宋体; font-size:16pt;">
            <p align=center><B>机动车辆保险赔款计算书<B></p>
          </td>
       </tr>
     </table>
     <!-- 主体部分 -->
     <table width="92%" align="center" cellspacing="0" cellpadding="2"  style="font-size: 10pt;border-collapse:collapse; bordercolor:#111111;">
       <tr>
         <td align=left colspan="2" id="tdPolicyNo" style="font-family:宋体; font-size:9pt;">保险单号：
         </td>
       </tr>
       <tr>
         <td align=left id="tdRegistNo" style="font-family:宋体; font-size:9pt;">报案编号：</td>
         <td align=right id="tdCompensateNo" style="font-family:宋体; font-size:9pt;">赔款计算书号：</td>
       </tr>
     </table>
     <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2"  style="font-size: 10pt;border-collapse:collapse; bordercolor:#111111;">
        <tr>
          <td height="23" align="left" width="10%"><span class="style2">被保险人</span></td>
          <td id="tdInsuredName"  colspan="7"></td>
          <td width="10%" align="center" class="style2">条款类别</td>
          <td id="tdCarClause"colspan="3" ></td>
        </tr>

        <tr height="23">
          <td width="10%" align="left" class="style2">厂牌型号</td>
          <td id="tdBrandName" colspan="3"></td>
          <td align="center" width="10%">车辆购置价</td>
          <td id="tdPurchasePrice" colspan="3"></td>

          <td align="center" width="10%">事故类别</td>
          <td id="tdIndemnityType" colspan="3"></td>
        </tr>
        <tr height="23">
          <td align="left" width="10%">号牌号码</td>
          <td id="tdLicenseNo" colspan="3">&nbsp;</td>
          <td align="center" width="10%">车损险保额</td>
          <td id="tdSumAmount1" colspan="3">&nbsp;</td>
          <td align="center" width="10%">责任比例</td>
          <td id="tdIndemnityDutyRate" colspan="3"></td>
        </tr>





        <tr height="23">
          <td align="left" width="10%">出险日期</td>
          <td id="tdDamageStartDate" colspan="3"></td> 
          <td align="center" width="10%">三者责任限额</td>
          <td id="tdAmount" colspan="3"></td>
          <td align="center" width="10%">免赔比例</td>
          <td id="tdLossRate" colspan="3"></td>
        </tr>
    
        <tr height="23">
          <td align="left" width="10%">出险地点</td>
          <td id="tdDamageAddress" colspan="3"></td>

          <td align="center" width="10%">保险期限</td>
          <td id="tdInsuredDate" colspan="7"></td>
        </tr>
    
   <!--     
         <tr height="23">
          <td align="left" width="15%">&nbsp;出险原因</td>
          <td id="tdDamageName" colspan="3">&nbsp;</td>
          <td align="center" width="15%">&nbsp;事故责任</td>
          <td id="tdIndemnityDuty" colspan="3">&nbsp;</td>
          <td align="center" width="10%">&nbsp;责任限额</td>
          <td id="tdSumAmount2" colspan="3">&nbsp;</td>
        </tr>
        -->
		<!-- weiqun temp edit -->
	<!--	
	<tr height="23">
          <td align="left" width="15%">&nbsp;指定驾驶员</td>
          <td id="tdDriverName1" colspan="3">&nbsp;</td>
          <td align="center" width="15%">&nbsp;绝对免赔率</td>
          <td id="" colspan="3">&nbsp;</td>
          
          <td align="center" width="10%">&nbsp;赔案类别</td>
          <td id="tdClaimType" colspan="3">&nbsp;</td>
        </tr>
        -->
        <!--
	       <tr height="23">
	       　<td align="left" width="15%">&nbsp;出险驾驶员</td>
          <td id="tdDriverName" colspan="3">&nbsp;</td>
          <td align="center" width="15%">&nbsp;绝对免赔额</td>
          <td id="" colspan="3">&nbsp;</td>
          <td align="center" width="15%">&nbsp;出险区域类别</td>
          <td id="tdDamageAddressType" colspan="3">&nbsp;</td>          
        </tr>
        -->
        <!--
        
        <tr>
          <td align="left" width="15%">&nbsp;损失程度</td>
          <td id="tdSumClaim" colspan="3">&nbsp;</td>
          <td align="left" width="15%">&nbsp;行驶区域</td>
          <td id="tdRunAreaName" colspan="3">&nbsp;</td>

        </tr>
        
        -->
        <!--
	<tr height="23">
          <td align="left" width="15%">&nbsp事故处理部门</td>
          <td id="tdHandleUnit" colspan="3">&nbsp;</td>
          <td align="center" width="15%">&nbsp;人员伤亡情况</td>
          <td id="tdPersonInjure" colspan="9">&nbsp;</td>
        </tr>
        
        -->
		<!-- weiqun temp edit -->
        <!--modified by zhangli 20070511-->
         <%
	        String bank = "";
	        if(!"0.0".equals(prpLcompensateDto.getBank())&&!"0.0".equals(prpLcompensateDto.getBank())
	           &&!"0.00".equals(prpLcompensateDto.getBank())){
	           bank = prpLcompensateDto.getBank();
            }         
        %>
         <tr height="23">
          <td align="left" width="10%">被保险人开户银行</td>
          <td id="bank" colspan="3">&nbsp;<%=bank%></td>

          <td align="center" width="10%">支付帐号</td>
          <td id="account" colspan="7">&nbsp;<%=prpLcompensateDto.getAccount()%></td>
        </tr>  
         <tr height="23">
          <td align="left" width="10%">收款人全称</td>
          <td id="bank" colspan="3">&nbsp;<%=prpLcompensateDto.getReceiverName()%></td>

          <td align="center" width="10%"></td>
          <td id="account" colspan="7">&nbsp;</td>
        </tr>  
        <tr>
          <td align="center" colspan="12" height="19"> 赔&nbsp;&nbsp;&nbsp;
          款&nbsp;&nbsp;&nbsp;
          计&nbsp;&nbsp;&nbsp;
          算&nbsp;&nbsp;&nbsp;
          公&nbsp;&nbsp;&nbsp;
          式 </td>
        </tr>
         
         
        
        <tr>
          <td id="tdContext" colspan="12" height="230" valign="top">
            <input type=text rows=18 cols=90 class=readonlyWhite readonly style="overflow:hidden;FONT-SIZE: 10pt">          </td>
        </tr>

                <tr>
          <td colspan="4">
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr>
                <td height="23" id="tdJudgeFee"><span class="STYLE3">&nbsp;</span>鉴定费<span class="STYLE3">：</span></td>
                <td align=right>元&nbsp;</td>
              </tr>
            </table>          </td>
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr>
                <td height="23" id="tdCheckFee1"><span class="STYLE3">&nbsp;</span>代查勘费<span class="STYLE3">：</span></td>
                <td align=right>元&nbsp;</td>
              </tr>
            </table>          </td>
          

          
          
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr>
                <td height="23" id="tdLawFee">&nbsp;诉讼、仲裁费<span class="STYLE3">：</span></td>
                <td align=right>元&nbsp;</td>
              </tr>
            </table>          </td>
        </tr>
        
       <tr>
        <!--  <td colspan="4">
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr>
                <td id="tdSerialNo" height="23">&nbsp;已预付次数：</td>
                <td align=right>次&nbsp;</td>
              </tr>
            </table>

          </td>  -->
          
          <td colspan="4">
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr>
                <td height="23" id="tdJianYan">&nbsp;检验费：</td>
                <td align=right>元&nbsp;</td>
              </tr>
            </table>          </td>
       
       
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr>
                <td height="23" id="tdCheckFee">&nbsp;查勘费<span class="STYLE3">：</span></td>
                <td align=right>元&nbsp;</td>
              </tr>
            </table>          </td>
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr>
                <td height="23" id="tdAssessFee">&nbsp;公估费：</td>
                <td align=right>元&nbsp;</td>
              </tr>
            </table>          </td>
        </tr>
        
        
        <tr>
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr>
                <td height="23" id="tdElseFee">&nbsp;其它费用<span class="STYLE3">：</span></td>
                <td align=right>元&nbsp;</td>
              </tr>
            </table>          </td>
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr>
                <td height="23" id="tdSumPrePaid">&nbsp;已预付金额<span class="STYLE3">：</span></td>
                <td align=right>元&nbsp;</td>
              </tr>
            </table>          </td>
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr>
                <td height="23" id="tdSumRest">&nbsp;损余物资/残值金额：</td>
                <td align=right>元&nbsp;</td>
              </tr>
            </table>          </td>
        </tr>

<!--
        <tr>
          <td colspan=12>

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr height="23">
                <td id="tdCSumThisPaid" width="70%">&nbsp;本次实付赔款（人民币大写）：</td>
                <td id="tdSumThisPaid" width="30%">&nbsp;</td>
                <td align=right>元）&nbsp;</td>
              </tr>
            </table>

          </td>
        </tr>
        -->
        <tr>
          <td colspan=12>

            <table width="100%" height="80%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr height="23">
                <td width="70%" id="tdCSumPaid">&nbsp;商业保险赔款合计（人民币大写）：</td>
                <td id="tdSumPaid" width="30%">&nbsp;</td>
                <td align=right>元）&nbsp;</td>
              </tr>
            </table>          </td>
        </tr>
        
        <tr>
          <td colspan=12>

            <table width="100%" height="80%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr height="23">
                <td width="70%" id="tdCAllSumPaid">&nbsp;赔款合计（人民币大写）：</td>
                <td id="tdAllSumPaid" width="30%">&nbsp;</td>
                <td align=right>元）&nbsp;</td>
              </tr>
            </table>          </td>
        </tr>

         <tr>
          <td colspan="4" width="50%">

            <table width="50%" height="50%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr height="50">
                <td width="33%" align="left" valign="top" id="tdHandlerName"></td>
              </tr>
              <tr height="23">
                <td width="33%" align="right" id="tdInputDate"></td>
              </tr>
            </table>          </td>
          <td colspan="8" width="50%">

            <table width="50%" height="50%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr height="50">
                <td width="33%" align="left" valign="top" id="tdUnderWriteName"></td>
              </tr>
              <tr height="23">
                <td width="33%" align="right" id="tdUnderWriteEndDate"></td>
              </tr>
            </table>          </td>
          
        </tr>


         <tr>
          <td colspan="12" height="60" align="left" valign="top">

            <table width="100%" height="50%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
              <tr height="40">
                <td width="33%" align="left" valign="top">&nbsp;上级审批意见<span class="STYLE3">：</span></td>
              </tr>
              <tr height="20">
                <td width="33%" align="left">                </td>
              </tr>
            </table>          </td>
        </tr>
      </table>
 <!--     <br>
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:10pt;">
      <tr>
           <td  align="left" width="50%">&nbsp;理算：<%=strOperatorName%></td>
           <td  align="left" width="50%">&nbsp;打印日期：<%=new DateTime(dateTime.current(),dateTime.YEAR_TO_DAY)%></td>
        </td>
      </table>   -->
      
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      	<tr>
      		<td align="left"><%=strPayRefName%></td>
      		<td align="right"><%=strPayRefDate%></td>
      	</tr>
      </table>
    </form>
    <br/><br/>
    <% if(intCtextCountTmp>20){ %>
        <table width="92%"  align="center" cellspacing="0" cellpadding="0" border="1" 
        		style="font-family:宋体; padding:5 5 5 5;font-size:10pt;border-collapse: collapse;display:<%=strDisplay %>" 
        		bordercolor="#111111" >
        <tr>
          <td align=center style="font-family:宋体; font-size:14pt;">赔款计算方式清单</td>
        </tr>
        <tr>
          <td  align="left" valign="top"><%=strContexTtemp%></td>
        </tr>
        </table>
    <% }%>
    <%--//modify by wangli update  start 20050422 --%>
    <%
     String PrintFlag="0";
     PrintFlag =request.getParameter("PrintFlag");
     if(PrintFlag == null){
   	%>
       <jsp:include page="/common/print/PrintButton.jsp" />
    <%
     }
    %>
      <%-- <jsp:include page="/DAA/compensate/DAASpecialPrintButton.jsp" />--%>
    <%--//modify by wangli update end 20050422 --%>
  </body>

</html>
