<%@ page language="java" import="java.util.*" %>
<%@page import="java.text.SimpleDateFormat" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String doQuery = request.getParameter("doQuery");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.text.SimpleDateFormat;"%>
<html>
  <head>
      <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
      <link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
	<jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script  src="/claim/js/WdatePicker.js" ></script>
  <script language='javascript'>
  var progressEnd = 25;  // set to number of progress <span>'s.
  var progressColor = '#2591FF'; // set to progress bar color
  var progressInterval = 200; // set to time between updates (milli-seconds)
  var progressAt = progressEnd;
  var progressTimer;
  function progressStart() {
    var waitingInfo = document.getElementById('waitingInfo');
    waitingInfo.style.display = ''; //show the ProgressBar
    progressUpdate();    //begin the progressbar
  }

  function progressClear() {
    for (var i = 1; i <= progressEnd; i++){
      document.getElementById('progress'+i).style.backgroundColor = 'transparent';
    }
    progressAt = 0;
  }
  function progressUpdate() {
    progressAt++;
    
    if (progressAt > progressEnd) {
      progressClear();
    }
    else {
    	
      document.getElementById('progress'+progressAt).style.backgroundColor = progressColor;
    }
    progressTimer = setTimeout('progressUpdate()',progressInterval);
  }
  function progressStop() {
    clearTimeout(progressTimer);
    progressClear();
    fm.buttSubmit.disabled=false;
    waitingInfo.style.display = 'none'; //hide the ProgressBar
  }
  
</script>
    <title>支付情况统计表</title>
  </head>
 <body class="interface" onload="requestprevUrl();progressStop();" >
   
  <script  type="text/javascript">
    	function submitForm(){
    		var checkBox = document.getElementsByName('payStatus');
    		var flag=false ;
    		for(var i=0;i<checkBox.length;i++){
    			if(checkBox[i].checked){
    				flag = true;
    			}
    		}
    		if(!flag){
    			alert("请选择至少一个支付状态！");
    			return ;
    		}
    		  progressStart();
    		  fm.action ="/claim/prplpaystatistics.do?type=4";
    		  fm.buttSubmit.disabled= true;
    		  fm.submit();//提交
    		  
    		  return true ;
    		
    	}
    	function disabledStates(obj){
    	    //alert(obj.value);
    		if(obj.value=='certify')
    		{
    			$("input[name='state'][type=checkbox]").attr('disabled','disabled');
    			$("input[name='state'][type=checkbox]").attr('checked',false);
    		}else{
    			$("input[name='state'][type=checkbox]").removeAttr("disabled");
    		}
    	}
    	function requestprevUrl(){
     		var prevPageUrl = document.getElementById('prevPageUrl').value;
     		if(prevPageUrl.length == 0){
 	    		var prevUrl = document.URL;
 	    		document.getElementById('prevPageUrl').value=prevUrl;
     		}
     	}
    </script>
    <%
    String type=request.getParameter("type");
     %>
  <form name="fm" action=""  method="post"  target ="showlist">
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl }">
   		<table  cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8" class="mycommon common">
   			<tr>
			<td colspan=4 class="tabletitle" ondblclick="showPage(RegistExtImg,paymain)">
				<IMG id="RegistExtImg" style="CURSOR: hand" onclick="showPage(this,paymain)"
					src="/claim/images/butExpandBlue.gif" name=RegistExtImg> 查询条件
			</td>
			</tr>
			<tbody id="paymain" >
	   			<tr>	
	   				<td class="title" style="width:15%;text-align:center">报案号码</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="registno" name="registnoSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" name="prplpay.registno" id="registno" class="input" style="width: 60%">
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">保单号码</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="policynoSign" name="policynoSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" name="prplpay.policyno" id="policyno" style="width: 60%" class="input" >
	   				</td>
	   			</tr>
	   			<tr>	
	   				<td class="title" style="width:15%;text-align:center">号牌号码</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="licenseNoSign" name="licenseNoSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="licenseNo" name="prplregist.licenseNo" class="input" style="width:60%"/>
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">被保险人</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="insuredNameSign" name="insuredNameSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="insuredName" name="prplregist.insuredName" class="input" style="width:60%"/>
	   				</td>
	   			</tr>
<%--	   				<td class="title" style="width:15%;text-align:center">案件类型</td>--%>
<%--	   				<td class="input" style="width:35%">--%>
<%--	   					<input type="checkbox" id="" name="mechanism" value="mechanism"/>本机构--%>
<%--	   					<input type="checkbox" id="" name="agnet" value="agnet"/>代查勘--%>
<%--	   				</td>--%>
	   			<tr>
		   			<td class="title" style="width:15%;text-align:center">支付状态</td>
	   				<td class="input" style="width:35%" colspan="3">
		   				<input type="checkbox" id="" name="payStatus" value="Q" checked/>核赔通过未支付
	   					<input type="checkbox" id="" name="payStatus" value="0"/>待提交
	   					<input type="checkbox" id="" name="payStatus" value="1"/>待审核
	   					<input type="checkbox" id="" name="payStatus" value="2"/>审核不通过
	   					<input type="checkbox" id="" name="payStatus" value="3"/>支付中心待处理
	   					<input type="checkbox" id="" name="payStatus" value="4"/>支付中心退回<br>
	   					<input type="checkbox" id="" name="payStatus" value="5"/>已打包待审核
	   					<input type="checkbox" id="" name="payStatus" value="6"/>打包审核通过待发送
	   					<input type="checkbox" id="" name="payStatus" value="7"/>已提交银行
	   					<input type="checkbox" id="" name="payStatus" value="8"/>银行打回
	   					<input type="checkbox" id="" name="payStatus" value="9"/>支付成功<br>
	   					<input type="checkbox" id="" name="payStatus" value="m" />默认成功
	   					<input type="checkbox" id="" name="payStatus" value="n" />银行退回支付中心
	   					<input type="checkbox" id="" name="payStatus" value="10" />同步资金成功
	   					<!-- <input type="checkbox" id="" name="payStatus" value="11" />重复数据 -->
	   					<input type="checkbox" id="" name="payStatus" value="12" />同步资金失败
	   					<input type="checkbox" id="" name="payStatus" value="13" />资金支付成功
	   					<input type="checkbox" id="" name="payStatus" value="14" />资金支付退票
	   					<input type="checkbox" id="" name="payStatus" value="15" />资金退回
		   			</td>
		   			</tr>
		   			<% Date date = new Date();
		   				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   				String inputDate2 = sdf.format(date);
		   				Calendar lastDate = Calendar.getInstance();
		   				lastDate.add(Calendar.MONTH,-1);
		   				String inputDate1 = sdf.format(lastDate.getTime());
		   			%>
		   			<tr>
		   			<td class="title" style="width:15%;text-align:center">核赔通过时间</td>
	   				<td class="input" style="width:35%" colspan="3">
	   					<input type="text" style="width:20%" id="inputDate1" name="inputDate1" class='input Wdate' value='<%=inputDate1 %>' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true,maxDate:'#F{$dp.$D(\'inputDate2\')}'})"/>
	   					至：
						<input type='text' style="width:20%" id="inputDate2" name="inputDate2" class='input Wdate' value='<%=inputDate2 %>' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true,minDate:'#F{$dp.$D(\'inputDate1\')}'})"/>
	   				</td>
		   		</tr>
   			</tbody>
   			<tr>
   				<td colspan="4" class="title" style="text-align:center">
   					<input type="hidden" value="<%=type %>" name="type"  >
   					<input name="buttSubmit"type="button" value="查询" class="bobu" onclick="submitForm()" >
   				</td>
   			</tr>
   		</table>
   	</form>
   	<table align='center' id='waitingInfo' ><tr><td class='page'>
正在处理数据, 请稍候......
<div style='font-size:2pt;padding:2px;border:solid #2591FF 1px'>
<span style='color:#ffffff' id='progress1'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress2'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress3'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress4'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress5'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress6'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress7'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress8'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress9'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress10'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress11'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress12'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress13'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress14'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress15'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress16'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress17'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress18'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress19'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress20'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress21'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress22'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress23'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress24'>&nbsp;&nbsp;&nbsp;</span>
<span style='color:#ffffff' id='progress25'>&nbsp;&nbsp;&nbsp;</span>
</div>
</td></tr></table>
   	<iframe name="showlist" src="/claim/DAA/payment/empty.jsp" height="100%" frameborder="0" marginheight="0" marginwidth="0" scrolling="yes" width="100%"></iframe>
  </body>
</html>
