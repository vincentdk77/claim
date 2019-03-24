<%--
****************************************************************************
* DESC       ：机动车辆保险定损报告/明细表打印页面
* AUTHOR     ：zhulianyu
* CREATEDATE ：2005-11-15
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
   <%-- 初始化 --%>

<%@include file="DAALossNoneFormatPrintIni.jsp"%>

<html>
<!--<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">-->
<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
  <script language='javascript'>
      function noticeShow()
      {
        initshow.style.display = "none";
		initdisplay.style.display = "";
		notice.style.display = "";
		list.style.display = "none";
		initlist.style.display = "none";
      }
	  function listShow()
      {
        initshow.style.display = "none";
		initdisplay.style.display = "";
		notice.style.display = "none";
		initlist.style.display = "";
      }
   </script>
  <body bgcolor="#FFFFFF" onload="loadForm()">
  <div id="initshow" style="display:">
    <table width="50%"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td>
          <div align="center">
            <input name="loss" type="button" id="loss" class="button" value="定损报告" onClick="noticeShow()">
          </div></td>
        <td>
          <div align="center">
            <input name="list" type="submit" id="list" class="button" value="明细表" onClick="listShow()">
          </div></td>
      </tr>
    </table>
  </div>
  <div id="initdisplay" style="display:none">
    <!-- 标题部分 -->
    <table width="96%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height=30>
        <td colspan="3" align="center">
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr height=30>
        <td colspan="3" align=center style=" font-family:宋体; font-size:14pt;">
          <B><center>机动车辆保险定损报告<span id="initlist" style="display:none">明细表</span><center><B>
        </td>
      </tr>
      <tr height=20>
        <td align=left id="tdRegistNo" width="25%" style="font-family:宋体; font-size:11pt;">
          被保险人：<%=strInsuredName%>
        </td>
        <td align=left id="tdRegistNo" width="43%" style="font-family:宋体; font-size:11pt;">报案号：<%=strRegistNo%></td>
        <td width="32%" align=right style="font-family:宋体; font-size:11pt;">共&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;第&nbsp;&nbsp;&nbsp;页</td>
      </tr>
    </table>

    <!-- 主体部分 -->
    <table border=1 width="96%" align="center" cellspacing="0" cellpadding="0" style=" border-collapse:collapse;font-family:宋体; font-size:11pt;" bordercolor="#111111">
      <tr>
        <td height=20 colspan="1" width="12%" align="center">号牌号码</td>
        <td height=20 colspan="1" width="22%" align="center"><%=licenseNo%></td>
        <td height=20 colspan="2" align="center">保单号码</td>
        <td height=20 colspan="2" align="center"><%=strPolicyNo%></td>
      </tr>
      <tr>
        <td height=20 colspan="1" align="center">发动机号</td>
        <td height=20 colspan="1" align="center" ><%=engineNo%></td>
        <td height=20 colspan="2" align="center" >车 架 号</td>
        <td height=20 colspan="2" align="center"><%=frameNo%></td>
      </tr>
      <tr>
        <td height=20 colspan="1" align="center">厂牌型号</td>
        <td height=20 colspan="1" align="center"><%=brandName%></td>
        <td width="12%" height=20 colspan="1" align="center">出险时间</td>
        <td height=20 colspan="1" width="22%" align="center"><%=strDamageStartDate%></td>
        <td width="10%" height=20 align="center">主 险</td>
        <!--
        <td height=20 colspan="1" >主险</td>
        <td height=20 colspan="1"> □车损险 □三者险</td>
        -->
        <% if ( k<2 ) {   %>
        <td width="22%" height=20 colspan="1" align="center"><%=strMainKindName[0]%></td>    
     <%}else if ( k > 1 ){   %>
        <td width="22%" height=20 colspan="1" align="center">
        <table  border=0 width="100%" align="center">
        <tr><td align="center" style="font-family:宋体; font-size:11pt;"><%=strMainKindName[0]%> </td></tr>
        <tr><td align="center" style="font-family:宋体; font-size:11pt;"><%=strMainKindName[1]%> </td></tr>
        </table>
        </td>    
         <%}%>
       <!-- <td width="17%" height=20 colspan="1" align="center"><%=strMainKindName%></td>                -->
      </tr>
      <tr>
        <td height=20 colspan="1" align="center">生产年月</td>
        <td height=20 colspan="1" align="center"><%=strEnrollDate%></td>
        <td height=20 colspan="1" align="center">排 气 量(L)</td>
        <td height=20 colspan="1" align="center"><%=douExhaustScale%></td>
        <td height=20 align="center">附加险</td>
        <td height=20 colspan="1" align="center"><%=strKindName[0]%></td>
      </tr>
      <tr>
        <td height=20 colspan="1" align="center">发动机形式</td>
        <td height=20 colspan="1" align="center"> □ 化油器 □ 电喷</td>
        <td height=25 colspan="1" align="center">变速箱形式</td>
        <td height=25 colspan="1" align="center"><%=strGearboxName%></td>
        <td height=20 align="center">附加险</td>
        <!--        
        <td height=20 colspan="1">变速箱型式</td>
        <td height=20 colspan="1"> □ 自动 □ 手动</td>
        -->
        <td height=20 colspan="1" align="center"><%=strKindName[1]%></td>
      </tr>
      <tr>
        <!--
        <td height=25 colspan="1" align="center">安全装置</td>
        <td height=25 colspan="3" align="center"><%=strSafeDevice%></td>      
        -->
        <td height=20 colspan="1" align="center">安全装置</td>
        <td height=20 colspan="3" align="center"> □ 安全气囊 □ ABS系统 □无安全装置</td>
        <td height=20 align="center">附加险</td>
        <td height=20 colspan="1" align="center"><%=strKindName[2]%></td>
      </tr>
    </table>
      <table border=1 width="96%" align="center" cellspacing="0" cellpadding="2" style="font-family:宋体; font-size:11pt; border-collapse:collapse;display:none" bordercolor="#111111">
        <tr>
           <td height=20 colspan="1" width="8%"  align="center">事故责任</td>
           <td height=20 colspan="1" width="38%" align="center"><%=strIndemnityDuty%></td>
           <td height=20 colspan="1" width="8%"  align="center">送修时间</td>
           <td height=20 colspan="1" width="18%" align="center"><%=strRepairStartDate%></td>
           <td height=20 colspan="1" width="10%" align="center">修复竣工时间</td>
           <td height=20 colspan="1" align="center"><%=strRepairEndDate%></td>
        </tr>
    </table>
	   <div id="notice" style="display:none">
    <table  border=1 width="96%" align="center" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
      <tr>
	  	<td height=20 colspan="1" width="40%" valign="top">
			<table  border=1 width="100%" align="center" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:11pt; border-collapse:collapse" bordercolor="#111111">
				<tr>
					<td height=20 colspan="1" width="50%" align="center">更换配件名称</td>
					<td height=20 colspan="1" width="25%" align="center">数量</td>
					<td height=20 colspan="1" width="25%" align="center">配件价格</td>
				</tr>
				<%if(intComponentCount<=17){ %> 
					<%for(int i=0;i<intComponentCount && i<17;i++){ %>
					<tr>
						<td height=20 colspan="1" align="center"><%=strCompName[i]%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#").format(dblMaterialQuantity[i])%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblMaterialUnitPrice[i])%></td>
				
					</tr>
					<%}%>
					<%for(int i=0;i<(17-intComponentCount);i++){ %>
					<tr>
						<td height=20 colspan="1" align="center"></td>
						<td height=20 colspan="1" align="center"></td>
						<td height=20 colspan="1" align="center"></td>
					</tr>
					<%}}else{%>
					<tr><td colspan="3">具体内容详见定损报告明细表（更换）</td></tr>
					<%for(int i=0;i<16;i++){ %>
					<tr>
						<td height=20 colspan="1" align="center"></td>
						<td height=20 colspan="1" align="center"></td>
						<td height=20 colspan="1" align="center"></td>
					</tr>
					<%}}%>
				<tr>
					<td height=20 colspan="2">材料费小计：</td>
					<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumchangefee)%></td>
				</tr>
				
			</table>
		</td>
		<td height=20 colspan="1" width="60%" valign="top">
			<table  border=1 width="100%" align="center" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:11pt;border-collapse: collapse" bordercolor="#111111">
				<tr>
					<td height=20 colspan="1" width="60%" align="center">修理项目</td>
					<td height=20 colspan="1" width="15%" align="center">工时</td>
					<td height=20 colspan="1" width="25%" align="center">工时费</td>
				</tr>
				<%if(count5<=2){ %>
					<tr>
						<td height=20 colspan="1">事故拆装：</td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
				 	</tr>
					  <%
					  for(int i=0;i<intRepairFeeCount && inttemp<2;i++){
							if(strRepairType[i].equals("事故拆装")){
							inttemp++;%>
					   <tr>
						<td height=20 colspan="1" align="center"><%=strCompName1[i]%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(dblManHour[i])%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblManHourFee[i])%></td>
					  </tr>
					  <%}}
					  for(int i=0;i<2-inttemp;i++){ %>
					   <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}
					  inttemp=0;
				}else{ %>
					<tr>
						<td height=20 colspan="1">事故拆装：</td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(sumhour5)%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumhourfee5)%></td>
				 	</tr>				
					  <tr>
						<td height=20 colspan="3">具体内容详见定损报告明细（修理）</td>
					  </tr>
					  <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}inttemp=0;%>
				   <%if(count1<=2){ %>
					<tr>
						<td height=20 colspan="1">事故钣金：</td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
				 	</tr>
					  <%for(int i=0;i<intRepairFeeCount && inttemp<2;i++){
							if(strRepairType[i].equals("事故钣金")){
							inttemp++;%>
					   <tr>
						<td height=20 colspan="1" align="center"><%=strCompName1[i]%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(dblManHour[i])%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblManHourFee[i])%></td>
					  </tr>
					  <%}}
					  for(int i=0;i<2-inttemp;i++){ %>
					   <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}
					  inttemp=0;
				}else{%>
					<tr>
						<td height=20 colspan="1">事故钣金：</td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(sumhour1)%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumhourfee1)%></td>
				 	</tr>				
					  <tr>
						<td height=20 colspan="3">具体内容详见定损报告明细（修理）</td>
					  </tr>
					  <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}inttemp=0;%>
				  <%if(count3<=2){ %>
					<tr>
						<td height=20 colspan="1">机修：</td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
				 	</tr>
					  <%for(int i=0;i<intRepairFeeCount && inttemp<2;i++){
							if(strRepairType[i].equals("事故机修")){
							inttemp++;%>
					   <tr>
						<td height=20 colspan="1" align="center"><%=strCompName1[i]%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(dblManHour[i])%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblManHourFee[i])%></td>
					  </tr>
					  <%}}
					  for(int i=0;i<2-inttemp;i++){ %>
					   <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}
					  inttemp=0;
				}else{%>
					<tr>
						<td height=20 colspan="1">机修：</td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(sumhour3)%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumhourfee3)%></td>
				 	</tr>
					  <tr>
						<td height=20 colspan="3">具体内容详见定损报告明细（修理）</td>
					  </tr>
					  <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					 <%}inttemp=0;%>
				   <%if(count4<=2){ %>
					<tr>
						<td height=20 colspan="1">电工：</td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
				 	</tr>
					  <%for(int i=0;i<intRepairFeeCount && inttemp<2;i++){
							if(strRepairType[i].equals("事故电工")){
							inttemp++;%>
					   <tr>
						<td height=20 colspan="1" align="center"><%=strCompName1[i]%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(dblManHour[i])%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblManHourFee[i])%></td>
					  </tr>
					  <%}}
					  for(int i=0;i<2-inttemp;i++){ %>
					   <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}
					  inttemp=0;
				}else{%>
					<tr>
						<td height=20 colspan="1">电工：</td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(sumhour4)%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumhourfee4)%></td>
				 	</tr>
					  <tr>
						<td height=20 colspan="3">具体内容详见定损报告明细（修理）</td>
					  </tr>
					  <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}inttemp=0;%>
				<%if(count2<=1){ %>
					<tr>
						<td height=20 colspan="1">事故油漆：</td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
				 	</tr>
					  <%
					  for(int i=0;i<intRepairFeeCount && inttemp<1;i++){
							if(strRepairType[i].equals("事故喷漆")){
							inttemp++;%>
					   <tr>
						<td height=20 colspan="1" align="center"><%=strCompName1[i]%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(dblManHour[i])%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblManHourFee[i])%></td>
					  </tr>
					  <%}}
					  for(int i=0;i<1-inttemp;i++){ %>
					   <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}
					  inttemp=0;
				}else{%>
					<tr>
						<td height=20 colspan="1">事故油漆：</td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(sumhour2)%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumhourfee2)%></td>
				 	</tr>
					  <tr>
						<td height=20 colspan="3">具体内容详见定损报告明细（修理）</td>
					  </tr>
					  <%}inttemp=0;%>
				   <tr>
					<td height=20 colspan="2">工时费小计:</td>
					<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblSumManHourFee[0])%></td>
				  </tr>
				  
				  <tr>
					<td height=20 colspan="2">管理费:</td>
					<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumManager[0])%></td>
				  </tr>
				  <tr>
					<td height=20 colspan="2">运费:</td>
					<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumTransFee[0])%></td>
				  </tr>
				  <tr>
					<td height=20 colspan="2">税金:</td>
					<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumTax[0])%></td>
				  </tr>
			</table>
		</td>
		  
		   
	  </tr>
    </table>
    <table  border=1 width="96%" align="center" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:11pt;border-collapse: collapse" bordercolor="#111111">
      <tr>
        <td height=20 colspan="6"><p>本页未尽之栏目，请见定损报告明细表。</P></td>
      </tr>
      <tr valign="top">
        <td colspan="6" height="80">
          1、甲、乙、丙三方协商，完全同意按以上核定的价格修理。总计工料费人民币（大写)：<%=strSumAllFee%>(<%=new DecimalFormat("#,##0.00").format(dblSumManHourFee[0]+dblSumMaterialFee[0])%>)。<br>
          2、乙方按以上核定项目保质保量修理，且履行以上核定的修理及换件项目。如有违背，甲方有权向乙方追回价格差额。 <br>
          3、乙方保证在_______日内保质保量完成修理，如违约，愿意赔偿因拖延时间而造成丙方的利润损失。 <br>
          4、丙方对以上核定的修理项目和价格无任何异议。如存在修理质量或价格超标，由乙方负责全部责任。<br>
          5、其它约定：
        </td>
      </tr>
      <tr>
        <td colspan="2" height="100" align="center" valign="middle">
          <table width="100%" border="0" height="100%" style="font-family:宋体; font-size:11pt;border-collapse: collapse" bordercolor="#111111">
            <tr>
              <td valign="top">
                乙方(承修方)签章：<br><br>
                <br>
             <br>
      <br>
              </td>
            </tr>
            <tr>
              <td align="right" valign="bottom">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日&nbsp;
              </td>
            </tr>
          </table>
        </td>
        <td colspan="2" height="100" valign="middle" align="center">
          <table width="100%" border="0" height="100%" style="font-family:宋体; font-size:11pt;border-collapse: collapse" bordercolor="#111111">
            <tr>
              <td valign="top">
                丙方(被保险人或其授权委托人)签章:<br><br>
                <br>
              </td>
            </tr>
            <tr>
              <td align="right" valign="bottom">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日&nbsp;
              </td>
            </tr>
          </table>
        </td>
        <td colspan="2" height="100" align="center" valign="middle" width="33%">
          <table  width="100%" border="0" height="100%" style="font-family:宋体; font-size:11pt;border-collapse: collapse" bordercolor="#111111">
          <tr>
              <td valign="top">
                甲方(保险公司)签章:<br>
                查勘定损人:<%=strHandlerName%><br>
                核价人:<%=strApproverName%><br>
              </td>
            </tr>
            <tr>
              <td align="right" valign="bottom">
                <%=printDate.getYear()+1900%>年<%=printDate.getMonth()+1%>月<%=printDate.getDate()%>日&nbsp;
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table></div>
      <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
  </div>
  </body>
</html>
