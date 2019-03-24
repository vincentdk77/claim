<%--
****************************************************************************
* DESC       ：添加驾驶员信息页面
* AUTHOR     ：weishixin
* CREATEDATE ： 2004-03-03
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%-- 多行输入展现域的模板 --%>
<%--多行输入自定义JavaScript方法域--%>
<script language='javascript'>
  //在下面加入本页自定义的JavaScript方法

	/*
    插入一条新的driver之后的处理（可选方法）
  */

//modify by liuyanmei delete 20051107 start 

    function afterInsertDriver()
    {
        setPrpLdriverSerialNo();
        /*
        var count=getElementCount("prpLdriverDrivingLicenseNo");
        for(var i=0;i<count;i++)
        {  
            //alert("看看什么时候运行?count="+count+"  i="+i);
            if(count!=1){
                //限制驾驶证号的长度,因为在公共文件默认限制了长度为30，通过html修改不成，只有通过js 。dongchengliang20050621
            	fm.prpLdriverDrivingLicenseNo[i].maxLength=20;
            }
        }
        */
        setButtonDriverInsertStatus();
    }


  /*
    删除本条Driver之后的处理（可选方法）
  */

    function afterDeleteDriver(field)
    {
        setPrpLdriverSerialNo();
        setButtonDriverInsertStatus();
    }

    /**
     * 设置setPrpLdriverSerialNo
     */
    function setPrpLdriverSerialNo(){
        var count=getElementCount("prpLdriverSerialNo");
        for(var i=0;i<count;i++)
        {
            //alert("看看什么时候运行?count="+count+"  i="+i);
            if(count!=1){
            	fm.prpLdriverSerialNo[i].value=i;
            }
        }
    }

//modify by liuyanmei modify 20051119 reason:itest bug 976要求可以输入多条记录
    /**
     * 只允许有一个驾驶员
     */
    function setButtonDriverInsertStatus(){
	    //var count=getElementCount("prpLdriverDrivingLicenseNo");
	   // var count=getElementCount("prpLdriverDriverName");
	   // if(count<=1){
       //   fm.buttonDriverInsert.disabled=false;
       // }else{
            fm.buttonDriverInsert.disabled=false;
       // }
    }
  //modify by liuyanmei modify 20051107 end  
</script>
<!--建立显示的录入条，可以收缩显示的-->
    <table class="common" cellpadding="5" cellspacing="1">
   <!--表示显示多行的-->
      <tr>
        <td class="common" colspan="3" style="text-align:left;"><img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="DriverImg" onclick="showPage(this,spanClaimdriver)">
        驾驶员信息<br>
  <span  id="spanClaimdriver">
  <%-- 多行输入展现域 --%>
    <table class=common id="Driver" cellpadding="5" cellspacing="1">
            <thead>

             <tr class=listtitle >
                <td  style="width:5%" >序号</td>
                <td colspan=4 style="width:95%">内容</td>
             </tr>
            </thead>
         <tbody>
         <tr style="display: none;">
          <td style="width:5%" class=common rowspan="2">
             <div align="center">
               <input class="readonlyNo" readonly name="prpLdriverSerialNo" description="序号" value="1">
             </div>
         </td>
        <td class="title" style="width:10%" align="center">姓名</td>
        <td class="input" style='width:15%'>
               <input name="prpLdriverDriverName" class="input" style="width:70%" maxlength=20 description="驾驶员姓名">
         <%--姓名允许为空<img src="/claim/images/bgMarkMustInput.jpg">  --%>
        </td>
        <!----modify by liuyanmei modify 20051105 start---reason:客户要求只保留姓名和电话---------------> 
         <td class="title" style="width:10%">联系电话</td>
         <td class="input" style='width:20%'>
               <input name="prpLdriverDriverPhone" class="input" style="width:70%" maxlength=20 description="驾驶员电话">
         </td>
		   <!--- modify by zhaolu 20060818 start--->
	      <td class="title" style="width:12%;display: none;">驾驶证号码</td>
        <td class="input" style="width:23%;display: none;">
               <input name="prpLdriverDrivingLicenseNo" class="common"  style="width:80%" maxLength="10" description="驾驶证号码" value="">
               <input  name="prpLdriverLicenseNo"  type="hidden">
               <input  name="prpLdriverLicenseColorCode"  type="hidden">
               <input  name="prpLdriverDriverOccupation"  type="hidden">
               <input  name="prpLdriverDriverGrade"  type="hidden">
               <input  name="prpLdriverDriverSeaRoute"  type="hidden">
               <input  name="prpLdriverDrivingYear"  type="hidden">
               <input  name="prpLdriverSpecialCertificate"  type="hidden">
               <input  name="prpLdriverFlag"  type="hidden">
        </td>
        </tr> 
        <tr style="display: none;">
            <td class="title" style="width:10%"  align="center">证件类型</td>
            <td>
                <html:select name="prpLdriverDto" property="identifyType" style="width:70%">
                        <html:options collection="identifyTypes" property="codeCode" labelProperty="codeCName"/>          
                </html:select>  
            </td>
            <td class="title" style="width:5%">证件号码</td>
            <td>
                <input name="prpLdriverIdentifyNumber" class="input" style="width:70%" maxlength=20 description="证件号码">
            </td>
        </tr>               
<logic:empty name="prpLdriverDto"  property="driverList">
		<tr>
          <td style="width:5%" class=common rowspan="2">
             <div align="center">
               <input class="readonlyNo" readonly name="prpLdriverSerialNo" description="序号" value="1">
             </div>
         </td>
        <td class="title" style="width:10%" align="center">姓名</td>
        <td class="input" style='width:15%'>
               <input name="prpLdriverDriverName" class="input" style="width:70%" maxlength=20 description="驾驶员姓名">
         <%--姓名允许为空<img src="/claim/images/bgMarkMustInput.jpg">  --%>
        </td>
        <!----modify by liuyanmei modify 20051105 start---reason:客户要求只保留姓名和电话---------------> 
         <td class="title" style="width:10%">联系电话</td>
         <td class="input" style='width:20%'>
               <input name="prpLdriverDriverPhone" class="input" style="width:70%" maxlength=20 description="驾驶员电话">
         </td>
		   <!--- modify by zhaolu 20060818 start--->
	      <td class="title" style="width:12%;display: none;">驾驶证号码</td>
        <td class="input" style="width:23%;display: none;">
               <input name="prpLdriverDrivingLicenseNo" class="common"  style="width:80%" maxLength="10" description="驾驶证号码" value="">
               <input  name="prpLdriverLicenseNo"  type="hidden">
               <input  name="prpLdriverLicenseColorCode"  type="hidden">
               <input  name="prpLdriverDriverOccupation"  type="hidden">
               <input  name="prpLdriverDriverGrade"  type="hidden">
               <input  name="prpLdriverDriverSeaRoute"  type="hidden">
               <input  name="prpLdriverDrivingYear"  type="hidden">
               <input  name="prpLdriverSpecialCertificate"  type="hidden">
               <input  name="prpLdriverFlag"  type="hidden">
        </td>
        </tr>                
        <tr>
            <td class="title" style="width:10%"  align="center">证件类型</td>
            <td>
                <html:select name="prpLdriverDto" property="identifyType" style="width:70%">
                        <html:options collection="identifyTypes" property="codeCode" labelProperty="codeCName"/>          
                </html:select>  
            </td>
            <td class="title" style="width:5%">证件号码</td>
            <td>
                <input name="prpLdriverIdentifyNumber" class="input" style="width:70%" maxlength=20 description="证件号码">
            </td>
        </tr>
</logic:empty>
<logic:notEmpty  name="prpLdriverDto"  property="driverList">
         <logic:iterate id="driver" name="prpLdriverDto" property="driverList">
			<tr class=oddrow>
              <td class="input" style="width:4%" rowspan="2">
                <div align="center">
                  <input  name="prpLdriverSerialNo"  class="readonlyno" readonly="true" value="<bean:write name='driver' property='serialNo'/>">
                </div>
              </td>
                <td class="title" style="width:10%"  align="center">姓名</td>
                <td class="input" style='width:15%'>
                     <input name="prpLdriverDriverName"  class="input" style="width:70%" maxlength=20 value="<bean:write name='driver' property='driverName'/>" title="驾驶员姓名">
                 <!--<img src="/claim/images/bgMarkMustInput.jpg">-->
                 </td>
           <!----modify by liuyanmei modify 20051105 start-------reason:客户要求只保留姓名和电话-----------> 
                <td class="title" style="width:5%">联系电话</td>
                <td class="input" style='width:10%'>
                <!--因为驾驶员航线字段DriverSeaRoute车险理赔暂没用到，所以用此字段来存放联系人电话-->
                     <input name="prpLdriverDriverPhone"  class="input" style="width:70%" maxlength=20 value="<bean:write name='driver' property='driverSeaRoute'/>" title="驾驶员电话">
                <!--<img src="/claim/images/bgMarkMustInput.jpg">-->
                </td>
			   <!--- modify by zhaolu 20060818 start--->
		     	<td class="title" style="width:12%;display: none;" >驾驶证号码</td>
                    <td class="input" style="width:23%;display: none;">
                      <input name="prpLdriverDrivingLicenseNo" class="input"  style="width:80%" maxlength=10 value="<bean:write name='driver' property='drivingLicenseNo'/>" title="驾驶证号码">
                </td>
                </td>
                <td class="title"  style="width:23%;display: none;">
                  <input  name="prpLdriverLicenseNo"  type="hidden"  value="<bean:write name='driver' property='licenseNo'/>">
                  <input  name="prpLdriverLicenseColorCode"  type="hidden"  value="<bean:write name='driver' property='licenseColorCode'/>">
                  <input  name="prpLdriverDriverOccupation"  type="hidden"  value="<bean:write name='driver' property='driverOccupation'/>">
                  <input  name="prpLdriverDriverGrade"  type="hidden"  value="<bean:write name='driver' property='driverGrade'/>">
                  <input  name="prpLdriverDriverSeaRoute"  type="hidden"  value="<bean:write name='driver' property='driverSeaRoute'/>">
                  <input  name="prpLdriverDrivingYear"  type="hidden"  value="<bean:write name='driver' property='drivingYear'/>">
                  <input  name="prpLdriverSpecialCertificate"  type="hidden"  value="<bean:write name='driver' property='specialCertificate'/>">
                  <input  name="prpLdriverFlag"  type="hidden"  value="<bean:write name='driver' property='flag'/>">
                </td>  
             </tr>   
             <tr>
                <td class="title" style="width:10%"  align="center">证件类型</td>
                <td>
                    <html:select name="driver" property="identifyType" style="width:70%">
                        <html:options collection="identifyTypes" property="codeCode" labelProperty="codeCName"/>          
                    </html:select>  
                </td>
                <td class="title" style="width:5%">证件号码</td>
                <td>
                    <input name="prpLdriverIdentifyNumber" class="input" style="width:70%" maxlength=20 description="证件号码" value="<bean:write name='driver' property='identifyNumber'/>">
                </td>
            </tr>
         <!------------------modify by liuyanmei hidden 20051105 end----------------->
</logic:iterate>
      </logic:notEmpty>
          </tbody>
        </table>
      </td>
    </tr>
  </table>
</span>
</table>

<script language='javascript'>
    //setButtonDriverInsertStatus();
</script>