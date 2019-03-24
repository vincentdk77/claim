<%--
****************************************************************************
* DESC       ：耳标号增加页面
* AUTHOR     ：
* CREATEDATE ：2010-07-28
* MODIFYLIST ：   Name       Date            Reason/Contents
			     wuzheng    20071207        国元打印赔款收据的时候需要出险标的信息。所以出险标的改为必须项，且控制长度
                 
****************************************************************************
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLearDto" %>
<%@page import="com.gyic.claim.dto.domain.PrplcompensateearDto" %>

<!--

//-->
</script>
 <tr>
      <td class="subformtitle" colspan="4" style="text-align:left;"><img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="prpLearImg" onclick="showPage(this,spanEar)">
        耳标号信息<br>
    <!--表示显示多行的-->
         <table cellpadding="5" cellspacing="1" class="common"  id="Ear_Data" style="display:none">
            <tbody>
              <tr>                
                <td class="input" style='width:15%' align="center">
                  <input name="prpLearNo" maxlength="22" class="common" description="耳标号" onblur="checkLength(this);updateValueofEarCheck();"  style="background-color:white"/>
                </td>
                <td class="input" style='width:10%' align="center">
                 <input type="hidden" name="prpSerialNo" style="width:20px" value=""/>
         		<%-- 被保险人换成农户姓名 By GYIC 李杨 20110808 --%>
                  <!-- <input name="prpLinsuredName"  maxlength="120" description="被保险人姓名" class="common" onblur="checkLength(this)"/> -->
                  <input name="fname" readonly="true" maxlength="120" description="农户姓名" class="common" onblur="checkLength(this)"/>
                </td>
                <td class="input" style='width:11%'  align="center" value="" >
                    <div>
                         <input type=button name="buttonEarDelete"  class="smallbutton" 
                                onclick="deleteRow(this,'Ear')"
                                value="-" style="cursor: hand" />
                    </div>
                </td>
              </tr>
            </tbody>
        </table>
		
   <span  id="spanEar" style="display:" cellspacing="1" cellpadding="0">
	        <%-- 多行输入展现域 --%>
	 <table class=common id="Ear" cellpadding="5" cellspacing="1">
       <thead>
         <tr>
         <%-- 被保险人换成农户姓名 By GYIC 李杨 20110808 --%>
            <!-- <td class="centertitle" style='width:30%'>被保险人名称</td> -->
            <td class="centertitle" style='width:20%'>耳标号</td>
            <td class="centertitle" style='width:30%'>农户姓名</td>
            <td class="centertitle" style='width:12%'>&nbsp;</td>
         </tr>
       </thead>
       <tfoot>
          <tr>
             <td class="title" colspan=2 align="center" style="display: <%=type %>">(按"+"号键增加耳标号信息，按"-"号键删除信息)</td>
             <td class="title"  style="width:4%" align="center" style="display: <%=type %>">
             <input type="button" value="+" class=smallbutton name="buttonEarInsert" 
                              onclick="insertRow('Ear');updateValueofEarCheck();" style="cursor: hand">
            </td>
          </tr>
          <tr>
          	<td colspan="2"></td>
          	<td class="title"  style="width:4%" align="center" style="display: <%=type %>">
             <input type="button" value="确定" class="button" name="buttonEarCheck" 
                              onclick="earCheck('Ear')" style="cursor: hand"/>
             <input type="hidden" value="false" name="valueofEarCheck" id="valueofEarCheck"/>
            </td>
          </tr>
       </tfoot>
     <tbody>
 <%  
 	//更改耳标号表为 prplcompensateear By GYIC 李杨 20110811 Start!
 	ArrayList prpLcompensateEarDtoList = new ArrayList();
 	prpLcompensateEarDtoList = (ArrayList)request.getAttribute("prpLearDtoList");
 	if(null != prpLcompensateEarDtoList){
 		for(Iterator iter = prpLcompensateEarDtoList.iterator(); iter.hasNext();){
 			PrplcompensateearDto prpLCompensateEarDto = new PrplcompensateearDto();
 			prpLCompensateEarDto = (PrplcompensateearDto)iter.next();
    //ArrayList prpLearDtoList = new ArrayList();
	//prpLearDtoList = (ArrayList)request.getAttribute("prpLearDtoList");
    //    if(prpLearDtoList != null){
	//    	for(Iterator iter = prpLearDtoList.iterator(); iter.hasNext();){
	//    		PrpLearDto prpLearDto = new PrpLearDto();
	//    		prpLearDto = (PrpLearDto)iter.next();
 	//更改耳标号表为 prplcompensateear By GYIC 李杨 20110811 End!
	     
%>     
           <tr>
                <td class="input" style='width:15%' align="center">
 	<!-- 更改耳标号表为 prplcompensateear By GYIC 李杨 20110811 Start! -->
                  <input name="prpLearNo" class="common" value="<%=prpLCompensateEarDto.getEarno() %>" style="background-color:white">
 	<!-- 更改耳标号表为 prplcompensateear By GYIC 李杨 20110811 End! -->
                </td>
                
                <td class="input" style='width:10%' align="center">
                  <input type="hidden" name="prpSerialNo" style="width:20px" value="" />
 	<!-- 更改耳标号表为 prplcompensateear By GYIC 李杨 20110811 Start! -->
                  <input name="fname" readonly="true" class="common" value="<%=prpLCompensateEarDto.getName() %>" >
 	<!-- 更改耳标号表为 prplcompensateear By GYIC 李杨 20110811 End! -->
                </td>
                <td class="input" style='width:11%'  align="center" >
                    <div>
                         <input type=button name="buttonEarDelete"  class="smallbutton" 
                                onclick="deleteRow(this,'Ear')" style="display:<%=type %>"
                                value="-" style="cursor: hand" />
                    </div>
                </td>
              </tr>
<%}}%>
  </tbody>
    </table>
   </span>
  </td>
 </tr>

