 <%--
****************************************************************************
* DESC       ：第三方支付信息退回理算查询列表页面
* Author     : 国元项目组
* CREATEDATE ：2013-10-14
* MODIFYLIST ：Name          Date          Reason/Contents
              zhongfen       2013-09-14
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>

<html>
   <head>
   <title>显示列表</title>
    <link rel="stylesheet" type="text/css" href="/newclaim/css/Standard.css">
  </head>
  <script type="text/javascript">
  function initBody(){
	window.moveTo(250,250);
  }
  </script>
  <body class="interface" onload="initBody();">
    <form name="fm" method="post">
    <table cellpadding="0" cellspacing="0" border="0" width="100%"><tr><td>
    <div class="Wscrollbar">
      <table class="common1" cellpadding="5" cellspacing="1" align="center">
        <tr class="listtitle" > 
          <td nowrap>状态码 </td>
          <td nowrap>状态码简义</td>
          <td nowrap>状态码说明</td>
        </tr>                

        <tr class="listodd"><td>0</td><td align=center>待提交            </td><td align=left>已录入并保存支付信息，但尚未提交审核</td></tr>
		<tr class="listodd"><td>1</td><td align=center>待审核            </td><td align=left>支付信息已经提交审核，等待审核</td></tr>
		<tr class="listodd"><td>2</td><td align=center>审核不通过        </td><td align=left>支付信息由审核人审核不通过，并退回</td></tr>
		<tr class="listodd"><td>3</td><td align=center>支付中心待处理    </td><td align=left>正数金额时，表示支付信息已发往支付中心，处于待处理状态<br>负数金额时，表示为机构处理已经完毕，已发往支付中心，处于待处理状态</td></tr>
		<tr class="listodd"><td>4</td><td align=center>支付中心退回      </td><td align=left>正数金额时，支付中心在发往银行前或支付中心发现银行已经退回，由支付中心直接退回到机构<br>负数金额时，支付中心在确认前直接退回到机构</td></tr>
		<tr class="listodd"><td>5</td><td align=center>已打包待审核      </td><td align=left>支付信息已由支付中心打包，等待财务支付审核</td></tr>
		<tr class="listodd"><td>6</td><td align=center>打包审核通过待发送</td><td align=left>支付信息已由支付中心打包，并通过了财务的支付审核，等待发往银行端</td></tr>
		<tr class="listodd"><td>7</td><td align=center>已提交银行     </td><td align=left>支付信息已经发往银行端，银行正在处理过程中</td></tr>
		<tr class="listodd"><td>8</td><td align=center>银行打回          </td><td align=left>支付信息在银行处理失败，直接退回到机构</td></tr>
		<tr class="listodd"><td>9</td><td align=center>支付成功          </td><td align=left>正数金额时，表示支付信息在银行处理成功<br>负数金额时，表示支付中心确认成功<br>零金额（正负冲减）时为系统自动核销成功</td></tr>
		<tr class="listodd"><td>a</td><td align=center>机构收付待处理    </td><td align=left>表示负数金额支付信息在机构收付系统中待处理</td></tr>
		<tr class="listodd"><td>b</td><td align=center>机构收付待提交    </td><td align=left>表示负数金额支付信息在机构收付系统中已处理，但尚未提交支付中心确认</td></tr>
		<tr class="listodd"><td>c</td><td align=center>机构收付退回      </td><td align=left>表示负数金额支付信息由机构收付岗退回</td></tr>
		<tr class="listodd"><td>m</td><td align=center>默认支付成功      </td><td align=left>表示超出15天未明确状态</td></tr>
		<tr class="listodd"><td>n</td><td align=center>银行退回支付中心      </td><td align=left>表示银行打款失败，已退回至支付中心等待处理</td></tr>
		<tr class="listodd"><td>10</td><td align=center>同步资金成功 </td><td align=left>支付信息同步资金平台成功</td></tr>
		<tr class="listodd"><td>11</td><td align=center>重复数据</td><td align=left>数据重复</td></tr>
		<tr class="listodd"><td>12</td><td align=center>同步资金失败</td><td align=left>支付信息同步资金平台失败</td></tr>
		<tr class="listodd"><td>13</td><td align=center>资金支付成功</td><td align=left>支付信息由资金平台支付成功</td></tr>
		<tr class="listodd"><td>14</td><td align=center>资金支付退票 </td><td align=left>支付信息由资金平台支付后退票</td></tr>
		<tr class="listodd"><td>15</td><td align=center>资金退回 </td><td align=left>支付信息同步资金平台后未支付前退回</td></tr> 

  </table>
    </div>
    </td></tr></table>

    </form> 
    
  </body>
</html>