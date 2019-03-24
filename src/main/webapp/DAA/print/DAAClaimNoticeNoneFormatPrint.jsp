<%@include file="DAAClaimNoticeNoneFormatPrintIni.jsp"%>
<html>
  <head>
    <title>机动车辆保险索赔须知打印</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>

  <body bgcolor="#FFFFFF">
    <!-- 标题部分 -->
    
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:8pt;">
      
      <tr height="40">
        <td colspan="2" align=center style="text-align:center; font-family:宋体; font-size:14pt;">
          <B>机动车辆保险索赔须知<B>
          <br>
        </td>
      </tr>
      <tr height="30">
        <td width="62%"></td>
        <td align="left">报案号：<%=strRegistNo%></td>
      <tr height="30">
        <td width="62%"62%></td><td align="left">保单号：<%=strPolicyNo%></td>
      </tr>
      <tr height="30">
        <td align="left" colspan="2">尊敬的<ins>&nbsp;&nbsp;&nbsp;&nbsp;<%=strInsuredName%>&nbsp;&nbsp;&nbsp;&nbsp;</ins>:</td>
      </tr>
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;请您在向我公司提交《机动车辆保险索赔申请书》的同时，依照我公司的要求，将以下划“√”部分的材料准备齐备后，送交至本须知下面注明的索赔地点，以便我们能及时、准确地给予赔付。在此我们提醒您注意：我公司对您车辆的定损价格只是对损失的认定，不做为是否赔付的依据。<br>
        &nbsp;&nbsp;&nbsp;&nbsp;谢谢您的合作！<br><br></td>
      </tr>
      <tr height="30">
        <td colspan="2"align="left">1.事故处理部门出具的：</td>
      </tr>      
      <tr height="30">
       <td colspan="2">&nbsp;&nbsp;□ 交通事故认定书 □ 调解书 □简易事故处理书　□ 其它事故证明<br><br></td>
      </tr>
      <tr height="30">
       <td colspan="2">2.法院仲裁机构出具的：</td>
      </tr>
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;□ 裁定书 □ 裁决书 □调解书　□ 判决书　□ 仲裁书<br><br></td>
      </tr>
      <tr height="30">
       <td colspan="2">3.涉及车辆损失</td>
      </tr>
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;□ 车辆修理的正式发票　□ 修理材料清单 □　修理协议<br>&nbsp;&nbsp;□ 施救费发票<br><br></td>
      </tr>      
      <tr height="30">
       <td colspan="2">4.涉及财产损失</td>
      </tr>
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;□ 设备总体造及损失证明　□ 设备恢复的工程预算 □ 施救费发票<br>&nbsp;&nbsp;□ 财产损失清单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;□ 购置、修复受损财产的有关费用单据<br><br></td>
      </tr>
      <tr height="30">
       <td colspan="2">5.涉及人身伤、残、亡损失</td>
      </tr>
      <tr height="30">
        <td colspan="2">
         <table style="font-family:宋体; font-size:8pt;">
           <tr height="25">
             <td>&nbsp;□ 县级以上医院诊断证明</td><td>□ 出院通知书</td><td>□ 需要护理人员证明</td>
           </tr>
           <tr height="25">
             <td>&nbsp;□ 护理人员误工证明及收入情况证明</td><td>□ 伤、残、亡误工证明及收入情况证明</td><td>□ 被扶养人证明材料</td>
           </tr>
           <tr height="25">
             <td>&nbsp;□ 残者须提供法医伤残鉴定书</td>
             <td>□ 亡者须提供死亡证明、火化证明户口注销证明</td>
             <td>□ 丧失劳动能力证明</td>
           </tr>
           <tr height="25">
             <td>&nbsp;□ 户籍证明</td><td>□ 户籍派出所所出具的受害者家庭情况证明</td><td>□ 病历复印件</td>
           </tr>
           <tr height="25">
             <td>&nbsp;□ 公安部门出具的赔偿凭证</td>
             <td>□ 残病辅助器具发票及更换周期证明</td><td>□ 医疗手册</td>
           </tr> 
           <tr height="25">
             <td>&nbsp;□ 医疗费结算明细表</td><td>□ 二次医疗费用就诊医院证明</td><td>□ 转院医疗证明</td>
           </tr>       
           <tr height="25">
             <td colspan="3">&nbsp;□ 医疗费报销凭证</td>
           </tr>                                                                       
         </table><br>
        </td>
      </tr>
      <tr height="30">
       <td colspan="2">6.涉及车辆盗抢案件:</td>
      </tr>      
      <tr height="30">
        <td colspan="2">
         <table cellpadding="0" cellspacing="0" style="font-family:宋体; font-size:8pt;">
           <tr height="25">
             <td>&nbsp;□ 出险地县级以上刑侦部门出具的盗抢案件立案证明</td>
             <td>□ 已登报(省级报纸)声明的证明</td><td>□ 车辆购置附加费凭证</td>
           </tr>
           <tr height="25">
             <td>&nbsp;□ 机动车登记证书（原件）</td><td>□ 车辆停驶手续证明</td>
             <td>□ 机动车原始发票</td>
           </tr>
           <tr height="25">
             <td>&nbsp;□ 全套车钥匙（原车配）</td>
             <td>□ 车辆停放当事人驾驶证</td><td>□ 权益转让书</td>
           </tr>      
           <tr height="25">
             <td>&nbsp;□ 被保险人营业执照复印件</td>
             <td> □ 被保险人身份证复印件</td>
             <td>□ 盗抢险立破案表</td>
           </tr>
           <tr height="25">
             <td>&nbsp;□ 停车费收据</td>
             <td>□ 保险车辆机动车行驶证原件</td>
             <td>&nbsp;</td>
           </tr>                                                                       
         </table>
         <br>
        </td>
      </tr>    
      <tr height="30">
       <td colspan="2">7.被保险人索赔时，提供以下证件原件，经保险公司验证后留存复印件</td>
      </tr>
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;□ 保险车辆机动车行驶证　□ 肈事驾驶人员的机动车驾驶证<br>
          <br></td>
      </tr>   
      <tr height="30">
       <td colspan="2">8.被保险人委托他人代办理赔手续时提供：</td>
      </tr>
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;□ 机动车辆保险授权委托书<br><br></td>
      </tr>
      <tr height="30">
       <td colspan="2">9.被保险人领取赔款时，须提供以下材料和证件，并经保险公司验证后留存：</td>
      </tr>
      <tr height="30">
        <td colspan="2">
         <table style="font-family:宋体; font-size:8pt;">
           <tr height="25">
             <td >&nbsp;被保险人为单位的：</td><td>□ 被保险人开具的介绍信或委托书</td><td>□ 领取赔款人员身份证及复印件</td>
           </tr>
           <tr height="25">
             <td></td><td>□ 加盖被保险人公章或财务章的《赔款收据》</td><td></td>
           </tr>
           <tr height="25">
             <td>&nbsp;被保险人为个人的：</td><td></td><td></td>
           </tr>                                                                           
         </table>
        </td>
      </tr>   
      <tr height="30">
        <td colspan="2">
         <table style="font-family:宋体; font-size:8pt;">
           <tr height="25">
             <td >&nbsp;被保险人本人领取赔款:</td><td>□ 被保险人身份证原件及复印件</td><td>□ 《机动车辆保险索赔须知》原件</td>
           </tr>                                                                         
         </table>
        </td>
      </tr> 
      <tr height="30">
        <td colspan="2">
         <table width="100%" border="0" cellpadding="0" cellspacing="0" style="font-family:宋体; font-size:8pt;">
           <tr height="25">
             <td height="12" colspan="3" >&nbsp;被保险人的亲属代为办理领赔手续：</td>
           </tr>
           <tr height="25">
             <td width="10%">&nbsp;</td>
             <td>□ 被保险人身份证复印件</td>
             <td>□ 代办人（须为被保险人的亲属）身份证原件及复印件</td>
           </tr>
           <tr height="25">
             <td ></td>
             <td>□ 与被保险人关系证明（结婚证或户口本）</td><td>□ 《机动车辆保险索赔须知》原件</td>
           </tr>                                                                                     
         </table>
        </td>
      </tr> 
      <tr height="30">
        <td colspan="2">
         <table style="font-family:宋体; font-size:8pt;">
           <tr height="25">
             <td >&nbsp;委托他人领取赔款：</td><td>□ 机动车辆保险授权委托书</td><td>□ 被保险人身份证原件及复印件</td>
           </tr>
           <tr height="25">
             <td ></td><td>□ 被委托人身份证原件及复印件</td><td>□ 《机动车辆保险索赔须知》原件</td>
           </tr>                                                                                     
         </table><br>
        </td>
      </tr>       
      <tr height="30">
       <td colspan="2">10.所有案件都需要的单证：</td>
      </tr>
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;□ 机动车辆保险索赔申请书 □ 机动车辆保险单正本及复印件 □ 保险公司出具的定损报告及相关附件<br><br></td>
      </tr> 
      <tr height="30">
       <td colspan="2">11.需要提供的其它索赔证明和单据：</td>
      </tr>
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;（1）</td>
      </tr>  
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;（2）<br></td>
      </tr>  
      <tr height="30">
        <td colspan="2">&nbsp;<br>        </td>
      </tr>                                                                                                                    
 </table>    
 <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:8pt;">
      <tr height="30">
        <td><strong>案件类型：</strong>&nbsp;&nbsp;□简易案件&nbsp;&nbsp;&nbsp;&nbsp;□常规案件&nbsp;&nbsp;&nbsp;&nbsp;□重大案件<br></td>
      </tr>  
      <tr height="30">
        <td><strong>索赔地点指南：</strong><br><br></td>
      </tr>  
      <tr height="30">
        <td><strong> 财产保险股份有限公司报案电话：</strong><br><br></td>
      </tr>
      <tr height="30">
        <td><strong>敬请注意：</strong>为确保您能够获得更加全面、合理的保险赔偿，我公司在理赔过程中，可能需要您进一步提供上述所列单证以外的其他证明材料。届时，我公司将及时通知您。感谢您对我们工作的理解与支持！</td>
      </tr> 
 </table>
 <br><br><br><br>
 <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:宋体; font-size:8pt;">
      <tr height="30">
        <td><strong>被保险人：</strong></td>
        <td><strong>保险公司：</strong></td>
      </tr>  
      <tr height="30">
        <td>领到《索赔通知》日期：&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;月&nbsp;&nbsp;日</td>
        <td>交付《索赔通知》日期：&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;月&nbsp;&nbsp;日</td>
      </tr>  
      <tr height="30">
        <td>签章：</td><td>经办人签字：</td>
      </tr>  
 </table> 
<!--<table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="display:none" >
  <tr height="30">
    <td colspan="1" width="15%">保单号码：</td>
    <td colspan="2" width="31%">&nbsp;</td>
    <td colspan="1" width="15%"> 号牌号码：</td>
    <td colspan="2" width="31">&nbsp;</td>
  </tr>
  <tr height="30"> 
    <td colspan="1">被保险人</td>
    <td colspan="2">&nbsp;</td>
    <td colspan="1">保险险别</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr height="30">
    <td colspan="1">厂牌型号</td>
    <td colspan="1" width="15%">&nbsp;</td>
    <td colspan="1">使用性质</td>
    <td colspan="1"> 口营业 口非营业</td>
    <td colspan="1">附加险</td>
    <td colspan="1"width="15%">&nbsp;</td>
  </tr>
  <tr height="30">
    <td colspan="1">发动机号</td>
    <td colspan="1">&nbsp;</td>
    <td colspan="1">吨/座位</td>
    <td colspan="1">&nbsp;</td>
    <td colspan="1" width="10%">附加险</td>
    <td colspan="1">&nbsp;</td>
  </tr>  
  <tr height="30">
    <td colspan="1">车损险保额</td>
    <td colspan="1">&nbsp;</td>
    <td colspan="1">第三者责任限额</td>
    <td colspan="1">&nbsp;</td>
    <td colspan="1">附加险</td>
    <td colspan="1"width="15%">&nbsp;</td>
  </tr>
  <tr height="30" > 
    <td colspan="1">保险期限</td>
    <td colspan="5"><p>自 年 月 日零时起  至 年 月 日二十四时止</p></td>
  </tr>      
  <tr height="30"> 
    <td colspan="1">报案号码</td>
    <td colspan="2">&nbsp;</td>
    <td colspan="1">出险地点</td>
    <td colspan="2">&nbsp;</td>
  </tr>  
  <tr height="30">
    <td colspan="1"> 出险时间</td>
    <td colspan="2">&nbsp;</td>
    <td colspan="1">报案时间</td>
    <td colspan="2">&nbsp;</td>
  </tr>    
  <tr height="30">
    <td colspan="1">出险原因</td>
    <td colspan="5">&nbsp;</td>
  </tr>  
  </table>-->
  <!--<table sytle="display:none">
  <tr height="30"> 
    <td height="44" colspan="2">第三者责任险限额</td>
    <td>&nbsp;</td>
  </tr>
  <tr height="125" > 
    <td height="75"  colspan="2" align=center> <p>附加险保额</p></td>
    <td height="75" align=center>_____________</td>
    <td width="121" height="75" align=center>_____________</td>
    <td width="121" height="75" align=center>_____________</td>
    <td height="75" align=center>_____________</td>
    <td height="75" align=center>_____________</td>
  </tr>
  <tr height="125" > 
    <td height="65"  colspan="2" align=center>附加险保额 </td>
    <td height="65" align=center>_____________</td>
    <td height="65" align=center>_____________</td>
    <td height="65" align=center>_____________</td>
    <td height="65" align=center>_____________</td>
    <td height="65" align=center>_____________</td>
  </tr>
  <tr height="125" > 
    <td height="44"  colspan="2" align=center> <p>委托事项</p></td>
    <td height="44" colspan="5" ><p>1．代为前往现场、拍摄相片、查勘现场； </p>
      <p>2． 请为“ □”内打“√”的项目代查勘、核损：</p>
      <p>
        □核定标的车辆的损失； □核定标的车上货物损失及施救处理； □核定第三者财物损失；</p>
      <p> □协助安排修理； □拍摄车辆及财物损失相片； □核实人员伤亡情况； </p>
      <p>□车辆、财物损失超过 元时，请及时报我公司核定。 </p>
      <p>
        附：《机动车辆保险出险报案记录》 </p>
      </td>
  </tr>
</table >-->
<!--<table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="display:none">
<tr>
 <td colspan="2">
<p> 现委托你公司办如下事宜：<br>
 &nbsp;&nbsp;&nbsp;1、代碍勘，并将查勘报告、定损报告、人伤调查报告、现场照片、车辆损坏照片 查勘费用收据等所有查勘资料邮寄我公司，
 我公司将凭据划付查勘费用。<br>
 &nbsp;&nbsp;&nbsp;2、代定损。<br>
 &nbsp;&nbsp;&nbsp;3、<br>
 &nbsp;&nbsp;&nbsp;4、<br>
 &nbsp;&nbsp;&nbsp;如预估车损超过　　　　元，第三者责任损失超过　　　元，敬请告之我司后再做处理。<br><br>  
 此谢！</p>     
 </td>
 </tr>
 <tr height="30">
    <td width="46">&nbsp; </td>
    <td>委托公司:____________________________________公司（章）</td>
 </tr>
 <tr height="30">
 <td width="46%">&nbsp;</td>
   <td>地　　址:_____________________________________________</td>
 </tr>
 <tr height="30">
   <td>被保险人联系电话:    _________________________________</td>
   <td>邮政编码:_____________________________________________</td>
 </tr>
 <tr height="30">
   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;_________________________________ </td>
   <td>传　　真:_____________________________________________</td>
 </tr>
 <tr height="30">
   <td>联系人：___________________________________________</td>
   <td>联系电话:_____________________________________________</td>
 <tr height="30">  
   <td>&nbsp;</td>
   <td>联&nbsp;系&nbsp;人:_____________________________________________</td>
 </tr>
 <tr height="30">
   <td>&nbsp;</td>
   <td>委托日期___________________________年_______月_______日</td>
 </tr>
</table>  --> 
  	<!-- 按钮部分 -->
            <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
  <script language='javascript'>
    function printPage()
    {
      divButton.style.display = "none";
      window.print();
    }
  </script>
  </body>
</html>
