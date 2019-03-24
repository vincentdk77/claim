<%--
****************************************************************************
* DESC       ：机动车辆保险赔款收据打印页面
* AUTHOR     ：caopeng
* CREATEDATE ：2005-12-02
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<script src="/claim/common/js/print.js"></script>


  <%-- 初始化 --%>
  <%@include file="DAAIndemnityReceiptNoneFormatPrintIni.jsp"%>

<html>
  <head>
    <title>机动车辆保险赔款通知书/收据打印</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
  	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script language="javascript">
      var intWidth  = 55;  //调整打印偏移（左右对位置）
      var intHeight = -53  //调整打印高度（上下对位置）

      function loadForm()
      {
        var i = 0;
        var strTop;
        var strLeft;
        for(i=0;i<document.getElementsByTagName("span").length;i++)
        {
          strTop  = document.getElementsByTagName("span")[i].style.top;
          strLeft = document.getElementsByTagName("span")[i].style.left;
          strTop  = strTop.substring(0,strTop.length-2);
          if( isNaN(parseInt(strTop,10)) )
          {
            alert("style属性里的top值不正确。");
            return;
          }
          strTop  = parseInt(strTop,10) + intHeight;
          strLeft = strLeft.substring(0,strLeft.length-2);
          if( isNaN(parseInt(strLeft,10)) )
          {
            alert("style属性里的left值不正确。");
            return;
          }
          strLeft = parseInt(strLeft,10) + intWidth;
          document.getElementsByTagName("span")[i].style.top  = strTop+"px";
          document.getElementsByTagName("span")[i].style.left = strLeft+"px";
        }
      }
	    /**
		 *@description 弹出收款信息窗口
		 *@param       无
		 *@return      通过返回true,否则返回false
		 */
		function openWinSave(){
		   var param = "compensateNo=<%=strCompensateNo%>"; 
		   param = param + "&policyNo=<%=strPolicyNo%>";
		   param = param + "&insuredCode=<%=strInsuredCode%>";
		   param = param + "&insuredName=<%=strInsuredName%>";		   
		   param = param + "&unitBank=<%=strUnitBank%>";
   		   param = param + "&unitAccount=<%=strUnitAccount%>";		   
		   param = param + "&account=<%=strAccount%>";
		   param = param + "&identifyNumber=<%=strIdentifyNumber%>";   		   
		   msg=window.open("/claim/DAA/print/indemnityReceiptSave.jsp?"+param,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=600,Height=300,left=200,top=200");
		}
    	function jsPrintPage()
    	{
      		printPage()
        	UsedSubmit();
        	
    	}
    	function UsedSubmit()
    	{
          var strURL = "/claim/visa.do?" + 
                       "type=IndemnityReceiptUsed" + 
                       "&visaCode=<%=visaCode%>" +
                       "&visaName=<%=visaName%>" +                       
                       "&businessNo=<%=strCompensateNo%>" + 
                       "&printNo=<%=printNo%>";
                       
          window.open(strURL,"单证销号");
		}
    </script>
<script language="VBScript">
    // 避免弹出安全警告框的说明：Internet选项=〉安全=〉受信任的站点 
    // 1.将网站加入受信任站点，
    // 2.自定义级别中 启用 对没有标记为安全的ActiveX控件进行初始化和脚本运行    

    dim hkey_root,hkey_path,hkey_key
    hkey_root="HKEY_CURRENT_USER"
    hkey_path="\Software\Microsoft\Internet Explorer\PageSetup"
    
    dim oldheader,oldfooter     
    
    '//设置网页打印的页眉页脚，上下左右
    function pagesetup_set(header,footer)
        on error resume next
        Set RegWsh = CreateObject("WScript.Shell")
        hkey_key="\header"          
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,header
        hkey_key="\footer"
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,footer
        
        
        hkey_key="\margin_left" '左
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.73"
        hkey_key="\margin_right" '右
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.70"
        hkey_key="\margin_top" '上
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"1.1"
        hkey_key="\margin_bottom" '下
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"1"
        
    end function
    '//设置网页打印的页眉页脚,上下左右为默认值
    function pagesetup_default()
        on error resume next
        Set RegWsh = CreateObject("WScript.Shell")
        hkey_key="\header"    
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"&w&b页码，&p/&P"
        hkey_key="\footer"
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"&u&b&d"
        
        hkey_key="\margin_left" '左
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.75"     '(对应 19.05毫米)
        hkey_key="\margin_right" '右
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.75"
        hkey_key="\margin_top" '上
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.75"
        hkey_key="\margin_bottom" '下
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.75"        
    end function
    
    '//显示页面设置
    function pagesetup_get()
        on error resume next
        Set RegWsh = CreateObject("WScript.Shell")
        hkey_key="\header"    
        oldheader=RegWsh.RegRead(hkey_root+hkey_path+hkey_key)
        hkey_key="\footer"
        oldfooter=RegWsh.RegRead(hkey_root+hkey_path+hkey_key)
        
        'hkey_key="\margin_left" '左
        'message = message & "左:" & RegWsh.RegRead( hkey_root+hkey_path+hkey_key) & vbCrLf
        'hkey_key="\margin_right" '右
        'message = message & "右:" & RegWsh.RegRead( hkey_root+hkey_path+hkey_key) & vbCrLf
        'hkey_key="\margin_top" '上
        'message = message & "上:" & RegWsh.RegRead( hkey_root+hkey_path+hkey_key) & vbCrLf
        'hkey_key="\margin_bottom" '下
        'message = message & "下:" & RegWsh.RegRead( hkey_root+hkey_path+hkey_key) & vbCrLf
        '
        'msgbox (message)
    end function    
    
    function printPage()
		on error resume next
		pagesetup_get()         '读取旧值
		header=""
		footer=""		
		pagesetup_get()
		pagesetup_set header, footer
		spbutton.style.display = "none"
    	window.print()
		pagesetup_set oldheader, oldfooter            '恢复设置

    end function
</script>     

<%
if(isHavePrintNo.booleanValue()){
%>
<SCRIPT>
   if(confirm('该单证已有流水号,是否作废?')){ 
      var strURL = "/claim/visa.do?" + 
                       "type=IndemnityReceiptAnnul" + 
                       "&visaCode=<%=visaCode%>" +
                       "&visaName=<%=visaName%>" +                       
                       "&businessNo=<%=strCompensateNo%>" + 
                       "&printNo=<%=printNo%>";
                       
      window.open(strURL,"单证作废");
   		
   }else{
   	  window.close();
   }
</SCRIPT>
<%}%>

</head>
<body>


 <body leftmargin=0 topmargin=0 onload="loadForm()"style="font-family:宋体; font-size:11pt;">
    <form name=fm>
        <span id="spCompensateNo" style="WIDTH:300px; LEFT: 360px; POSITION: absolute; TOP: 94px; font-family:宋体; font-size:11pt;"><%=strCompensateNo%></span>
        <span id="spInsuredName"  style="WIDTH:300px; LEFT: 0px; POSITION: absolute; TOP: 133px; font-family:宋体; font-size:11pt;"><%=strInsuredName%></span>
        <span id="spPolicyNo"     style="WIDTH:300px; LEFT: 290px; POSITION: absolute; TOP: 133px; font-family:宋体; font-size:11pt;"><%=strPolicyNo%></span>
        <span id="spComCName"     style="WIDTH:400px; LEFT: 200px; POSITION: absolute; TOP: 213px; font-family:宋体; font-size:11pt;"><%=strComCName%></span>
        <span id="spRiskCode"     style="WIDTH:400px; LEFT: 460px; POSITION: absolute; TOP: 213px; font-family:宋体; font-size:11pt;"><%=riskCodeName%></span>
        <span id="spCSumPaid"     style="WIDTH:400px; LEFT: 50px;  POSITION: absolute; TOP: 295.5px; font-family:宋体; font-size:11pt;"><%=strCSumDutyPaid%></span>
        <span id="spSumPaid"      style="WIDTH:400px; LEFT: 500px; POSITION: absolute; TOP: 295.5px; font-family:宋体; font-size:11pt;"><%=strSumDutyPaid%></span>

        <span id="spuserName"     style="WIDTH:700px; LEFT: -20px; POSITION: absolute; TOP: 347px; font-family:宋体; font-size:11pt;"><%=strUnitBank%></span>
        <span id="spuserName"     style="WIDTH:700px; LEFT: 375px; POSITION: absolute; TOP: 347px; font-family:宋体; font-size:11pt;"><%=strAccount%></span>
        <span id="spuserName"     style="WIDTH:700px; LEFT: -20px; POSITION: absolute; TOP: 373px; font-family:宋体; font-size:11pt;"><%=strUnitAccount%></span>
        <span id="spuserName"     style="WIDTH:700px; LEFT: 375px; POSITION: absolute; TOP: 373px; font-family:宋体; font-size:11pt;"><%=strIdentifyNumber%></span>
                
        <span id="spuserName"     style="WIDTH:700px; LEFT: 175px; POSITION: absolute; TOP: 423.5px; font-family:宋体; font-size:11pt;"><%=userName%></span>
        <span id="spDate"         style="WIDTH:700px; LEFT: 480px; POSITION: absolute; TOP: 423.5px; font-family:宋体; font-size:11pt;"><%=strYear%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=strMonth%>&nbsp;&nbsp;&nbsp;&nbsp;<%=strDate%></span>
                
        <!-- 
        <span id="accountButton"       style="WIDTH:700px; LEFT: 0px; POSITION: absolute; TOP: 500px; font-family:宋体; font-size:11pt;">
        -->
        <span id="spbutton" style="WIDTH:700px; LEFT: 40px; POSITION: absolute; TOP: 500px; font-family:宋体; font-size:11pt;">
          <table cellpadding="0" cellspacing="0" width="80%" style="display:">
	          <tr>
		          <td class=button align="center">
			        <input class="button" type="button"  name="button" value="收款信息"  onclick="javascript:openWinSave();">
			      </td>
			      <td class=button align="center">
			        <input class="button" type="button"  name="buttonPrint" value=" 打 印 "  onclick="jsPrintPage();">
			      </td>
			      <td class=button align="center">
			        <input class="button" type="button"  name="buttonClose" value=" 关 闭 "  onclick="javascript:window.close();">
			      </td>
		      </tr>
	      </table>
		</span>
		<%--               
        <span id="spbutton"       style="WIDTH:700px; LEFT: 40px; POSITION: absolute; TOP: 500px; font-family:宋体; font-size:11pt;">
        	<jsp:include page="/common/print/PrintButton.jsp" />
        </span>
        --%>
        
        <input type="hidden" name="printNo" value="<%=printNo%>"/>
        <input type="hidden" name="visaCode" value="<%=visaCode%>"/>        
        <input type="hidden" name="visaCode" value="<%=visaName%>"/>             
    </form>
  </body>
</html>
