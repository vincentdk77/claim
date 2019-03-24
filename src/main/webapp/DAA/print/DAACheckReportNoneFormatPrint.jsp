<%--
****************************************************************************
* DESC       ：机动车辆现场查勘记录打印页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-16
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
 
<%@include file="DAACheckReportNoneFormatPrintIni.jsp"%>
 
<html>    
<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  
  <body bgcolor="#FFFFFF" >
    <!-- 标题部分 -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td colspan="3" height="40" align=center style="font-family:宋体; font-size:14pt;"><img src="/claim/images/LOGO.JPG"/></td>
        </tr>      
      <tr>
        <td colspan="3" height="40" align=center style="text-align:center; font-family:宋体; font-size:14pt;">
          <B>机动车辆保险事故现场查勘记录<br>        </td>
      </tr>
      <tr height=25>
        <td align=left  style="font-family:宋体; font-size:10pt;">
          保险号：<%=strPolicyNo%>        </td>
        <td align=center  style="font-family:宋体; font-size:10pt;">
          报案号：<%=strRegistNo%>        </td>
          <%
            if(strClaimNo == "" || strClaimNo.equals(""))
            {
          %>
        <td align=right  style="font-family:宋体; font-size:10pt;">
          立案号:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
          <%
            }
          else
          	{ 
          %>
           <td align=right  style="font-family:宋体; font-size:10pt;">
          立案号：<%=strClaimNo%>        </td>
          <%
            }
          %>
       
      </tr>
    </table>  
    
   
      
   
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse;font-family:宋体; font-size:10pt;" bordercolor="#111111">
      <tr> 
        <td height=25 colspan="3">出险时间:<%=strdamageStartDate%></td>
          
        <td width="170" height=25>出险地点:<%=strPrpLregistDamageAddress%></td>               
       
        <td width="244" height=25 colspan="1" >案件性质: &nbsp□自赔□本代□外代	</td>                
           
      </tr>
      
      <tr>
        <td height=25 colspan="3 width="40%">查堪时间:<%=strgetCheckDate%></td>
      
        <td height=25>查堪地点:<%=strCheckSite%></td>
      
        <td height=25 colspan="1" >是否第一现场:<%=strFirstSite%></td>
       
      </tr>
      
      
   
      <tr>
   		<td  rowspan=4 colspan=1 width="28"><div align="center">保险车辆</div></td>
    		<td height=24 colspan=2 >厂牌型号：<%=strBrandName%></td>
    		<td  width="170" height=24 colspan=1 >发动机号: <%=strEngineNo%></td>
    	  <td  colspan=1 width="244" height=24>号牌底色:  <%=strLicenseColor%></td>
     </tr>
     <tr>
     	  <td height=24 colspan=2 >车牌号码：<%=strLicenseNo%></td>
     	  <td  width="170" height=24 colspan=1 >车架号：<%=strFrameNo%></td>
     	  <td  colspan=1 width="244" >初次登记日期:</td>
     </tr>
     <tr>
     	  <td height=24 colspan=2 >驾驶员姓名：<%=strPrpLdriverName%></td>
     	  <td  width="170" height=24 colspan=1 >驾驶证号码：<%=strPrpLdriverLicenseNo%></td>
     	  <td  colspan=1 width="244" aligh="center">准驾车型:</td>
     </tr>
     <tr>
     	   <td height=24 colspan=2 >初次领证日期:</td>
     	   <td  colspan=1 width="170">性别:□男□女</td>
     	    <td  colspan=1 width="244" aligh="center">联系方式:<%=strPrpLregistPhoneNumber%></td>
     </tr>	
  
     
     <!---<tr>
      <td  rowspan=3 colspan=1 width="28"><div align="center">三者车辆 </div></td>
     	<td></td>
     	</tr>
     	<tr>
     	</tr>
     	<tr>
     	<tr>--->
     
   
     <%
    	for(int m=1; m < registDto.getPrpLthirdPartyDtoList().size();m++ )
    	{ 
    	    String strDriverName = "";
    	    String strDriverLicenseNo = "";
    	    String strDriverPhoneNo = "";
    %>
      
    	<tr>
    
   		  <td  rowspan=3 colspan=1 width="30"><div align="center">三者车辆</div></td>
    		<td  width="235" height=26 colspan=1 >厂牌型号：<%=strBrandNamethird[m]%></td>
    		<td  width="199" height=26 colspan=1 >号牌号码: <%=strLicenseNothird[m]%></td>
    	  <td  colspan=2 height=26>交强险保单号:<%=prpLRegistRPolicyNo%></td>
     </tr>
     <%
        if(strThirdPrpLdriverName.length > m)
        {
           strDriverName = strThirdPrpLdriverName[m];
           strDriverLicenseNo = strThirdPrpLdriverLicenseNo[m];
           strDriverPhoneNo = strThirdPrpLregistPhoneNumber[m];
        }
     %>
     <tr>
     	  <td width="235" height="33"  colspan=1 aligh="center">驾驶员姓名:<%=strDriverName%></td>
     	  <td  colspan=1 width="199" aligh="center">驾驶证号码：<%=strDriverLicenseNo%></td>
     	  <td  colspan=2 aligh="center">起保日期:</td>
     </tr>
     <tr>
     	   <td width="235" height="28"  colspan=1 aligh="center">初次领证日期:</td>
     	   <td  colspan=1 width="199" aligh="center">性别:□男□女</td>
     	    <td  colspan=1 width="68" aligh="center">准驾车型:</td>
     	   <td  colspan=1 width="126" aligh="center">联系方式:<%=strDriverPhoneNo%></td>
     </tr>	
  
   <%
    }
   %>
     
     
     
   
    	<tr>
   		  <td  rowspan=5 colspan=1 width="28"><div align="center">事故信息</div></td>
    		<td  width="190" height=27 colspan=1 >出险原因</td>
    		<td height=27 colspan=3 ><%=strDamageClause%></td>
    	</tr>
     <tr>
     	  <td width="190" height="24"  colspan=1 aligh="center">事故类型</td>
     	 <td height=27 colspan=3 >□单方肇事&nbsp□双方事故&nbsp□多方事故&nbsp□仅涉及财产损失&nbsp□涉及人员伤亡</td>
     	 
     </tr>
     <tr>
     	   <td width="190" height="28"  colspan=1 aligh="center">事故涉及的第三方机动车数:<%=registDto.getPrpLthirdPartyDtoList().size() - 1%></td>
     	   <td  colspan=2 aligh="center">第三者伤亡人数:伤<%=personInjureB%>人，亡<%=personDeathB%>人</td>
     	    <td  colspan=1 width="244" aligh="center">车上人员伤亡人数:伤<%=personInjureD1%>人，亡<%=personDeathD1%>人</td>
     </tr>
     
     <tr>
     	   <td width="190" height="28"  colspan=1 aligh="center">事故处理方式:<%=handleUnit%></td>
     	   <td  colspan=3 aligh="center">是否需要施救:□是　□否</td>
      </tr>
   	   <tr>
     	   <td width="190" height="28"  colspan=1 aligh="center">预计事故责任划分:<%=indemnityDuty%></td>
     	   <td  colspan=3 aligh="center">核定施救费金额:</td>
   	   </tr>
     	
  
    	<tr>
    		<td  rowspan=3 colspan=1 width="28"><p align="center">查堪<br></p>
    		  <p align="center">&nbsp;</p>
    		  <p align="center"><br>
	      信息</p>
   		  </td>
    	  <td height=100 colspan=4 >
    	  	<%
    	  	  for(int j = 0;j < prpLcheckExtDtoList.size();j++)
    	  	  {
    	  	     PrpLcheckExtDto prpLcheckExtDto = (PrpLcheckExtDto)prpLcheckExtDtoList.get(j);
    	  	%>
    	  	    <%=prpLcheckExtDto.getDisplayName()+" ■是    □否 " + "<br>"%>
    	  	<%
    	  	  }
    	  	%>
   	  	  </td>
   	  </tr>
    	 <tr>
    		<td height=90 colspan=4><h6 align="justify">查堪意见(事故经过、施救过程、查堪情况简单描述和初步责任判断):<br>
    			<br>
    			<br>
    			<br>
    			<br>
    			<br>
    			
    		
   		   </h6></td>
    	 </tr>
    	 	<tr>
    	 		<td height=23 colspan=2 >案件处理等级:</td>
    	 		<td width="170">理算顺序:</td>
    	 		<td width="244">询问笔录&nbsp&nbsp张,现场草图&nbsp&nbsp 张,事故照片&nbsp&nbsp 张</td>
    	 </tr>
    	 <tr>
    	 	<td  rowspan=5 colspan=1 width="28">责任判断及损失估计</td>
    	 <td  width="190" height=27 colspan=1 >出险原因</td>
    	 	<td height=27 colspan=3 ><%
   		  	  for(int count = 0;count < intItemKindCount;count++)
   		  	  {
   		    %>
   		    <%=strKindCode[count]%>&nbsp<%=strKindName[count]%>
   		    <%
   		      }
   		    %></td>
   		   
    	</tr>
    	<tr>
    		<td  width="190" height=27 colspan=1 >立案建议</td>
    		<td height=27 colspan=3 >交 强 险:&nbsp&nbsp&nbsp□立案&nbsp&nbsp&nbsp□不立案(注销/拒赔)&nbsp&nbsp&nbsp□待确定(原因:                 )<br>
    	  	  <br>
          商业保险:&nbsp&nbsp&nbsp□立案&nbsp&nbsp&nbsp□不立案(注销/拒赔)&nbsp&nbsp&nbsp□待确定(原因:            
    			</td>
    </tr>
    <tr>
    	<td  width="190" height=27 colspan=1 rowspan=3>事故估损金额</td>
    	<td>总计:<%=new DecimalFormat("#,##0.00").format(lossFee+lossFeeThird)%></td>
    	<td>本车车损:<%=new DecimalFormat("#,##0.00").format(lossFee)%></td>
    	<td>第三者车损:<%=new DecimalFormat("#,##0.00").format(lossFeeThird)%></td>
    </tr>
    <tr>
    	<td width="125">本车车上人员伤亡:</td>
    	  <td width="177">第三者人员伤亡:</td>
    	  <td width="242">本车上财产损失:</td>
    	</tr>
    	<tr>
    		<td width="125">第三者车上财产损失:</td>
    	  <td width="177">第三者其他财产损失:</td>
    	  <td width="242">其他:</td>
    </tr>
    </table>
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse;font-family:宋体; font-size:10pt;" bordercolor="#111111">
    	<tr>
   	<td width="50%" height="50">查堪人员签字:<br>
   		<br>
	 <br></td>
   	<td width="50%">被保险人(当事人)签字:<br>
   		<br>
	 <br></td>
  </tr>
  </table>
   
    
     
  
       
     
  <jsp:include page="/common/print/PrintButton.jsp" />
          
  </body> 
</html>
