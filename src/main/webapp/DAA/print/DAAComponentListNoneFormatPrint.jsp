<%--
****************************************************************************
* DESC       ：机动车辆保险损失情况确认书零部件更换项目清单(代询价单附件)打印页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-16
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@include file="DAALossNoneFormatPrintIni.jsp"%>


<html>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">

  <body bgcolor="#FFFFFF" onload="loadForm();">
  
    <script language='javascript'>
      function printPage()
      {
        tbButton.style.display = "none";
        window.print();
      }
    </script>
  
    <!-- 标题部分 -->
    <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height=30>
        <td colspan="3" align="center">
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr height=30>
        <td colspan="3" align=center style=" font-family:宋体; font-size:14pt;">
          <B><center>机动车辆保险定损报告明细表（更换）</span><center><B>
        </td>
      </tr>
      <tr height=20>
        <td align=left width="48%" id ="tdInsuredName" style="font-family:宋体; font-size:10pt;">被保险人：<%=strInsuredName%>
        </td>
        <td align=left id="tdRegistNo" width="35%" style="font-family:宋体; font-size:10pt;">报案号：<%=strRegistNo%></td>
        <td width="17%" align=right style="font-family:宋体; font-size:10pt;">共<%=changePageTotal%>页&nbsp;&nbsp;&nbsp;第1页</td>
      </tr>
    </table>
   
  
      
    <!-- 主体部分 -->  
    <table border=1 width="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
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
       
     <% if ( k<2 ) {   %>
        <td width="22%" height=20 colspan="1" align="center"><%=strMainKindName[0]%></td>    
     <%}else if ( k > 1 ){   %>
        <td width="22%" height=20 colspan="1" align="center">
        <table  border=0 width="100%" align="center">
        <tr><td align="center"><%=strMainKindName[0]%> </td></tr>
        <tr><td align="center"><%=strMainKindName[1]%> </td></tr>
        </table>
        </td>    
         <%}%>
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
        <td height=20 colspan="1" align="center">变速箱形式</td>
        <td height=20 colspan="1" align="center">□ 自动 □ 手动</td>
        <td height=20 align="center">附加险</td>
        <td height=20 colspan="1" align="center"><%=strKindName[1]%></td>
      </tr>
      <tr>
        <td height=20 colspan="1" align="center">安全装置</td>
        <td height=20 colspan="3" align="center"> □ 安全气囊 □ ABS系统 □无安全装置</td>
        <td height=20 align="center">附加险</td>
        <td height=20 colspan="1" align="center"><%=strKindName[2]%></td>
      </tr>
    </table>
    
    <table  border=1 width="100%" align="center" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
  	  <tr><td valign="top"><table width="100%" border=1 align="top" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>序号<B></td>
                <td width="50%"><B>更换配件名称<B></td>
                <td width="10%"><B>数量<B></td>
                <td width="30%"><B>配件价格<B></td>
              </tr>
			  <%
			  if(changeListInfo.size()<=23){
			  	for(int i=0;i<changeListInfo.size();i++){ %>			  		
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getChangeName()%></td>
                		<td width="10%" align="center"><%=new DecimalFormat("#,##0").format(((RepairContentDto)changeListInfo.get(i)).getChangeCount())%></td>
               	 		<td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)changeListInfo.get(i)).getChangeFee())%></td>
			  			</tr>
			  <%}%>
			  <%for(int i=0;i<23-changeListInfo.size();i++){ %>
			  	<tr align="center" height="25" >
			  	<td width="10%" colspan="1"></td>
                <td width="50%"></td>
                <td width="10%"></td>
               	<td width="30%"></td>
               	</tr>
			  <%}%>
              <tr bgcolor="#CCCCCC" height="25">
                <td  colspan="3" align="center"><B>材料费小计<B></td>
                <td colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumchangefee)%></td>
              </tr>
              </table>
          </td>
          <td valign="top"><table width="100%" border=1 align="top" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>序号<B></td>
                <td width="50%"><B>更换配件名称<B></td>
                <td width="10%"><B>数量<B></td>
                <td width="30%"><B>配件价格<B></td>
              </tr>
              <%
              for(int i=0;i<23;i++){
              %>
              <tr align="center" height="25" >
			  	<td width="10%" colspan="1"></td>
                <td width="50%"></td>
                <td width="10%"></td>
               	<td width="30%"></td>
              </tr>
              <%}%>           
              <tr bgcolor="#CCCCCC" height="25">
                <td colspan="3" align="center">材料费小计</td>
                <td colspan="1"></td>
              </tr>
              </table>	
          </td>
      </tr>
      <%}else if(changeListInfo.size()<=46){
      			for(int i=0;i<23;i++){
      				firstchangefee += ((RepairContentDto)changeListInfo.get(i)).getChangeFee();%>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getChangeName()%></td>
                		<td width="10%" align="center"><%=new DecimalFormat("#,##0").format(((RepairContentDto)changeListInfo.get(i)).getChangeCount())%></td>
               	 		<td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)changeListInfo.get(i)).getChangeFee())%></td>
			  			</tr>
			  	<%}%>
              <tr bgcolor="#CCCCCC" height="25">
                <td colspan="3" align="center"><B>材料费小计<B></td>
                <td colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(firstchangefee)%></td>
              </tr>
              </table>
              </td>
              <td valign="top">
			  <table width="100%" border=1 align="top" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>序号<B></td>
                <td width="50%"><B>更换配件名称<B></td>
                <td width="10%"><B>数量<B></td>
                <td width="30%"><B>配件价格<B></td>
              </tr>
              <%for(int i=23;i<changeListInfo.size();i++){%>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getChangeName()%></td>
                		<td width="10%" align="center"><%=new DecimalFormat("#,##0").format(((RepairContentDto)changeListInfo.get(i)).getChangeCount())%></td>
               	 		<td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)changeListInfo.get(i)).getChangeFee())%></td>
			  			</tr>     
              <%}%>
              <%for(int i=0;i<46-changeListInfo.size();i++){ %>
			  	<tr align="center" height="25" >
			  	<td width="10%" colspan="1"></td>
                <td width="50%"></td>
                <td width="10%"></td>
               	<td width="30%"></td>
               	</tr>
			  <%}%>       
              <tr bgcolor="#CCCCCC" height="25">
                <td colspan="3" align="center"><B>材料费小计<B></td>
                <td colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumchangefee-firstchangefee)%></td>
              </tr>
              </table>
              </td>
              </tr>	
      <%}else{
      			for(int i=0;i<23;i++){	
      				firstchangefee += ((RepairContentDto)changeListInfo.get(i)).getChangeFee();%>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getChangeName()%></td>
                		<td width="10%" align="center"><%=new DecimalFormat("#,##0").format(((RepairContentDto)changeListInfo.get(i)).getChangeCount())%></td>
               	 		<td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)changeListInfo.get(i)).getChangeFee())%></td>
			  			</tr>
			  	<%}%> 
			  <tr bgcolor="#CCCCCC" height="25">
                <td colspan="3" align="center"><B>材料费小计<B></td>
                <td colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(firstchangefee)%></td>
              </tr>
              </table>
              </td> 
              <td valign="top">
              <table width="100%" border=1 align="top" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>序号<B></td>
                <td width="50%"><B>更换配件名称<B></td>
                <td width="10%"><B>数量<B></td>
                <td width="30%"><B>配件价格<B></td>
              </tr> 
              <%for(int i=23;i<46;i++){
              		secondchangefee += ((RepairContentDto)changeListInfo.get(i)).getChangeFee();%>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getChangeName()%></td>
                		<td width="10%" align="center"><%=new DecimalFormat("#,##0").format(((RepairContentDto)changeListInfo.get(i)).getChangeCount())%></td>
               	 		<td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)changeListInfo.get(i)).getChangeFee())%></td>
			  			</tr>     
              <%}%>
              <tr bgcolor="#CCCCCC" height="25">
                <td colspan="3" align="center">材料费小计</td>
                <td colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(secondchangefee)%></td>
              </tr>
              </table>
              </td>
              </tr>
              </table>
              
                  
    <!-- 结尾部分 -->
    <table width="100%" align="center" cellspacing="0" bordercolor="#111111" cellpadding="2" border="1" style="font-family:宋体; font-size:10pt;">
      <tr align="left"> 
        <td width="30%" id="tdSanctioner"><B>查勘定损人：<B><%=strHandlerName%></td>
        <td width="35%"><B>核价人：<B><%=strApproverName%></td>
        <%if(strApproverName == ""){%>
			<td width="35%" align="left"><B><%--=verpDate.getYear()--%>年<%--=verpDate.getMonth()--%>月<%--=verpDate.getDay()--%>日<B></td>	
      	<%}%>
      	<%if(strApproverName != ""){%>
      		<td width="35%" align="left"><B><%=verpDate.getYear()%>年<%=verpDate.getMonth()%>月<%=verpDate.getDay()%>日<B></td>	
      	<%}%>
      </tr>
    </table>
    <table width="100%" align="center" cellspacing="0" cellpadding="2" border="0" style="font-family:宋体; font-size:10pt;">
      <tr align="left"> 
        <td colspan="2">
          注: 1、油漆、防冻液等辅料列入配件项目中；<br>
              &nbsp;&nbsp;&nbsp;&nbsp;2、零部件更换项目的工时费列入修理项目中。<br>
        </td>
      </tr>
    </table>
    <%}%>
    
    
    <!-- 修理附页-->
    <%
    int p=0;
    String table1Style="display:none";
    if (changePageTotal>1) table1Style="";   
    for(p=0;p<changePageTotal-1;p++){
    %>
    <table style="width:100%;align:center;<%=table1Style%>" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height=30>
        <td colspan="3" align="center">
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr height=30>
        <td colspan="3" align=center style=" font-family:宋体; font-size:14pt;">
          <B><center>机动车辆保险定损报告明细表（更换-附页）</span><center><B>
        </td>
      </tr>
      <tr height=20>
        <td align=left width="48%" id ="tdInsuredName" style="font-family:宋体; font-size:10pt;">被保险人：<%=strInsuredName%>
        </td>
        <td align=left id="tdRegistNo" width="35%" style="font-family:宋体; font-size:10pt;">报案号：<%=strRegistNo%></td>
        <td width="17%" align=right style="font-family:宋体; font-size:10pt;">共<%=changePageTotal%>页&nbsp;&nbsp;&nbsp;第<%=p+2%>页</td>
      </tr>
    </table>

   <table  border=1 style="width:100%;align:center;<%=table1Style%>" align="center" cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">  
      
      <tr height="25" border=1> 
        <td width="15%" align=center id="tdLicenseNo" style="font-family:宋体; font-size:10pt;">
          号牌号码:
        </td>
        <td width="35%" align=center ><%=licenseNo%></td>
        <td width="15%" align=center id="tdPolicyNo" style="font-family:宋体; font-size:10pt;">
          保险单号: 
        </td>
        <td width="35%" align=center ><%=strPolicyNo%></td>
      </tr>
      <tr height="25"> 
        <td width="15%" align=center id="" style="font-family:宋体; font-size:10pt;">
          发动机号: 
        </td>
         <td width="35%" align=center ><%=engineNo%></td>
        <td width="15%" align=center id="" style="font-family:宋体; font-size:10pt;">
          车架号:
        </td>
         <td width="35%" align=center ><%=frameNo%> </td>
      </tr>
    </table>
    <table  border=1 style="width:100%;align:center;<%=table1Style%>" align="center" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
  	  <tr><td><table width="100%" border=1 align="center" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>序号<B></td>
                <td width="50%"><B>更换配件名称<B></td>
                <td width="10%"><B>数量<B></td>
                <td width="30%"><B>配件价格<B></td>
              </tr>
			  <%
			  int sizeResult=(changeListInfo.size()-46) % 54;
			  //直接判断到底是
			  if((changeListInfo.size()<=73+54*p)||((changeListInfo.size()>(100+54*p))&&(sizeResult <=27))){
			  	firstchangefee = 0;
			  	for(int i=46+54*p;i<73+54*p;i++){
			  		firstchangefee += ((RepairContentDto)changeListInfo.get(i)).getChangeFee();%>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getChangeName()%></td>
                		<td width="10%" align="center"><%=new DecimalFormat("#,##0").format(((RepairContentDto)changeListInfo.get(i)).getChangeCount())%></td>
               	 		<td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)changeListInfo.get(i)).getChangeFee())%></td>
			  			</tr>
			  	<%
			  	if(i == changeListInfo.size()-1){
			  		for(int j=0;j<27-sizeResult;j++){ %>
			  		<tr align="center" height="25" >
			  		<td width="10%" colspan="1"></td>
                	<td width="50%"></td>
                	<td width="10%"></td>
               		<td width="30%"></td>
               		</tr>
			  		<%}
			  		break;
			    }}%>	  
              <tr bgcolor="#CCCCCC" height="25">
                <td colspan="3" align="center"><B>材料费小计<B></td>
                <td colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(firstchangefee)%></td>
              </tr>
              </table>
          </td>
          <td><table width="100%" border=1 align="center" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>序号<B></td>
                <td width="50%"><B>更换配件名称<B></td>
                <td width="10%"><B>数量<B></td>
                <td width="30%"><B>配件价格<B></td>
              </tr>
              <%
              if(p != changePageTotal-2){
              	secondchangefee = 0;
              	for(int i=73+54*p;i<100+54*p;i++){
              		secondchangefee += ((RepairContentDto)changeListInfo.get(i)).getChangeFee();%>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getChangeName()%></td>
                		<td width="10%" align="center"><%=new DecimalFormat("#,##0").format(((RepairContentDto)changeListInfo.get(i)).getChangeCount())%></td>
               	 		<td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)changeListInfo.get(i)).getChangeFee())%></td>
			  			</tr>
			  	<%}}else{
			  	secondchangefee = 0;
			  	for(int i=0;i<27;i++){
              %>
              <tr align="center" height="25" >
			  	<td width="10%" colspan="1"></td>
                <td width="50%"></td>
                <td width="10%"></td>
               	<td width="30%"></td>
              </tr>
              <%}}%>           
              <tr bgcolor="#CCCCCC" height="25">
                <td colspan="3" align="center"><B>材料费小计<B></td>
                <td colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(secondchangefee)%></td>
              </tr>
              </table>	
          </td>
      </tr>
      
      <%}else if((changeListInfo.size()<=100+54*p||(changeListInfo.size()>(100+54*p)))){
      			firstchangefee = 0;
      			secondchangefee = 0;
      			for(int i=46+54*p;i<73+54*p;i++){
      				firstchangefee += ((RepairContentDto)changeListInfo.get(i)).getChangeFee();%>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getChangeName()%></td>
                		<td width="10%" align="center"><%=new DecimalFormat("#,##0").format(((RepairContentDto)changeListInfo.get(i)).getChangeCount())%></td>
               	 		<td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)changeListInfo.get(i)).getChangeFee())%></td>
			  			</tr>
			  	<%}
			  %>
              <tr bgcolor="#CCCCCC" height="25">
                <td  colspan="3" align="center"><B>材料费小计<B></td>
                <td colspan="3" align="center"><%=new DecimalFormat("#,##0.00").format(firstchangefee)%></td>
              </tr>
              </table>
              </td>
              <td>
			  <table width="100%" border=1 align="center" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>序号<B></td>
                <td width="50%"><B>更换项目名称<B></td>
                <td width="10%"><B>数量<B></td>
                <td width="30%"><B>配件价格<B></td>
              </tr>
              <%for(int i=73+54*p;i<100+54*p;i++){
              		secondchangefee += ((RepairContentDto)changeListInfo.get(i)).getChangeFee();%>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center"><%=((RepairContentDto)changeListInfo.get(i)).getChangeName()%></td>
                		<td width="10%" align="center"><%=new DecimalFormat("#,##0").format(((RepairContentDto)changeListInfo.get(i)).getChangeCount())%></td>
               	 		<td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)changeListInfo.get(i)).getChangeFee())%></td>
			  			</tr>     
              			<%
              			if(i == changeListInfo.size()-1){
              				break;
              			}
              }%>
              <%for(int i=0;i<100+54*p-changeListInfo.size();i++){ %>
			  	<tr align="center" height="25" >
			  	<td width="10%" colspan="1"></td>
                <td width="50%"></td>
                <td width="10%"></td>
               	<td width="30%"></td>
               	</tr>
			  <%}%>
			  <tr bgcolor="#CCCCCC" height="25">
                <td  colspan="3" align="center"><B>材料费小计<B></td>
                <td colspan="3" align="center"><%=new DecimalFormat("#,##0.00").format(secondchangefee)%></td>
              </tr>
              </table>
              </td>
              </tr>
              <%}%>       
              
              </table>      
    <!-- 结尾部分 -->
    <table style="width:100%;align:center;<%=table1Style%>" align="center" cellspacing="0" bordercolor="#111111" cellpadding="2" border="1" style="font-family:宋体; font-size:10pt;">
      <tr align="left"> 
        <td width="30%" id="tdSanctioner"><B>查勘定损人：<B><%=strHandlerName%></td>
        <td width="35%"><B>核价人：<B><%=strApproverName%></td>
        <%if(strApproverName == ""){ %>
			<td width="35%" align="left"><B><%--=verpDate.getYear()--%>年<%--=verpDate.getMonth()--%>月<%--=verpDate.getDay()--%>日<B></td>	
      	<%}%>
      	<%if(strApproverName != ""){ %>
      		<td width="35%" align="left"><B><%=verpDate.getYear()%>年<%=verpDate.getMonth()%>月<%=verpDate.getDay()%>日<B></td>	
      	<%}%>
      </tr>
    </table>
    <table style="width:100%;align:center;<%=table1Style%>" align="center" cellspacing="0" cellpadding="2" border="0" style="font-family:宋体; font-size:10pt;">
      <tr align="left"> 
        <td colspan="2">
          注: 1、油漆、防冻液等辅料列入配件项目中；<br>
              &nbsp;&nbsp;&nbsp;&nbsp;2、零部件更换项目的工时费列入修理项目中。<br>
        </td>
      </tr>
    </table>
    <%}%>
        
   <table id="tbButton" cellpadding="0" cellspacing="0" width="80%" style="display:">
      <tr>
        <td class=button style="width:50%" align="center">
          <input type=button name=buttonPrint value=" 打 印 " class="button" onclick="return printPage()">
        </td>
        <td class=button style="width:50%" align="center">
          <input type=button name=buttonClose value=" 关 闭 " class="button" onclick="javascript:window.close()">
        </td>
      </tr>
    </table> 
    
  </body>
</html>
