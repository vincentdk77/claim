<%--
****************************************************************************
* DESC       ����Ӽ�ʻԱ��Ϣҳ��
* AUTHOR     ��weishixin
* CREATEDATE �� 2004-03-03
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%-- ��������չ�����ģ�� --%>
<%--���������Զ���JavaScript������--%>
<script language='javascript'>
  //��������뱾ҳ�Զ����JavaScript����

	/*
    ����һ���µ�driver֮��Ĵ�����ѡ������
  */

//modify by liuyanmei delete 20051107 start 

    function afterInsertDriver()
    {
        setPrpLdriverSerialNo();
        /*
        var count=getElementCount("prpLdriverDrivingLicenseNo");
        for(var i=0;i<count;i++)
        {  
            //alert("����ʲôʱ������?count="+count+"  i="+i);
            if(count!=1){
                //���Ƽ�ʻ֤�ŵĳ���,��Ϊ�ڹ����ļ�Ĭ�������˳���Ϊ30��ͨ��html�޸Ĳ��ɣ�ֻ��ͨ��js ��dongchengliang20050621
            	fm.prpLdriverDrivingLicenseNo[i].maxLength=20;
            }
        }
        */
        setButtonDriverInsertStatus();
    }


  /*
    ɾ������Driver֮��Ĵ�����ѡ������
  */

    function afterDeleteDriver(field)
    {
        setPrpLdriverSerialNo();
        setButtonDriverInsertStatus();
    }

    /**
     * ����setPrpLdriverSerialNo
     */
    function setPrpLdriverSerialNo(){
        var count=getElementCount("prpLdriverSerialNo");
        for(var i=0;i<count;i++)
        {
            //alert("����ʲôʱ������?count="+count+"  i="+i);
            if(count!=1){
            	fm.prpLdriverSerialNo[i].value=i;
            }
        }
    }

//modify by liuyanmei modify 20051119 reason:itest bug 976Ҫ��������������¼
    /**
     * ֻ������һ����ʻԱ
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
<!--������ʾ��¼����������������ʾ��-->
    <table class="common" cellpadding="5" cellspacing="1">
   <!--��ʾ��ʾ���е�-->
      <tr>
        <td class="common" colspan="3" style="text-align:left;"><img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="DriverImg" onclick="showPage(this,spanClaimdriver)">
        ��ʻԱ��Ϣ<br>
  <span  id="spanClaimdriver">
  <%-- ��������չ���� --%>
    <table class=common id="Driver" cellpadding="5" cellspacing="1">
            <thead>

             <tr class=listtitle >
                <td  style="width:5%" >���</td>
                <td colspan=4 style="width:95%">����</td>
             </tr>
            </thead>
         <tbody>
         <tr style="display: none;">
          <td style="width:5%" class=common rowspan="2">
             <div align="center">
               <input class="readonlyNo" readonly name="prpLdriverSerialNo" description="���" value="1">
             </div>
         </td>
        <td class="title" style="width:10%" align="center">����</td>
        <td class="input" style='width:15%'>
               <input name="prpLdriverDriverName" class="input" style="width:70%" maxlength=20 description="��ʻԱ����">
         <%--��������Ϊ��<img src="/claim/images/bgMarkMustInput.jpg">  --%>
        </td>
        <!----modify by liuyanmei modify 20051105 start---reason:�ͻ�Ҫ��ֻ���������͵绰---------------> 
         <td class="title" style="width:10%">��ϵ�绰</td>
         <td class="input" style='width:20%'>
               <input name="prpLdriverDriverPhone" class="input" style="width:70%" maxlength=20 description="��ʻԱ�绰">
         </td>
		   <!--- modify by zhaolu 20060818 start--->
	      <td class="title" style="width:12%;display: none;">��ʻ֤����</td>
        <td class="input" style="width:23%;display: none;">
               <input name="prpLdriverDrivingLicenseNo" class="common"  style="width:80%" maxLength="10" description="��ʻ֤����" value="">
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
            <td class="title" style="width:10%"  align="center">֤������</td>
            <td>
                <html:select name="prpLdriverDto" property="identifyType" style="width:70%">
                        <html:options collection="identifyTypes" property="codeCode" labelProperty="codeCName"/>          
                </html:select>  
            </td>
            <td class="title" style="width:5%">֤������</td>
            <td>
                <input name="prpLdriverIdentifyNumber" class="input" style="width:70%" maxlength=20 description="֤������">
            </td>
        </tr>               
<logic:empty name="prpLdriverDto"  property="driverList">
		<tr>
          <td style="width:5%" class=common rowspan="2">
             <div align="center">
               <input class="readonlyNo" readonly name="prpLdriverSerialNo" description="���" value="1">
             </div>
         </td>
        <td class="title" style="width:10%" align="center">����</td>
        <td class="input" style='width:15%'>
               <input name="prpLdriverDriverName" class="input" style="width:70%" maxlength=20 description="��ʻԱ����">
         <%--��������Ϊ��<img src="/claim/images/bgMarkMustInput.jpg">  --%>
        </td>
        <!----modify by liuyanmei modify 20051105 start---reason:�ͻ�Ҫ��ֻ���������͵绰---------------> 
         <td class="title" style="width:10%">��ϵ�绰</td>
         <td class="input" style='width:20%'>
               <input name="prpLdriverDriverPhone" class="input" style="width:70%" maxlength=20 description="��ʻԱ�绰">
         </td>
		   <!--- modify by zhaolu 20060818 start--->
	      <td class="title" style="width:12%;display: none;">��ʻ֤����</td>
        <td class="input" style="width:23%;display: none;">
               <input name="prpLdriverDrivingLicenseNo" class="common"  style="width:80%" maxLength="10" description="��ʻ֤����" value="">
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
            <td class="title" style="width:10%"  align="center">֤������</td>
            <td>
                <html:select name="prpLdriverDto" property="identifyType" style="width:70%">
                        <html:options collection="identifyTypes" property="codeCode" labelProperty="codeCName"/>          
                </html:select>  
            </td>
            <td class="title" style="width:5%">֤������</td>
            <td>
                <input name="prpLdriverIdentifyNumber" class="input" style="width:70%" maxlength=20 description="֤������">
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
                <td class="title" style="width:10%"  align="center">����</td>
                <td class="input" style='width:15%'>
                     <input name="prpLdriverDriverName"  class="input" style="width:70%" maxlength=20 value="<bean:write name='driver' property='driverName'/>" title="��ʻԱ����">
                 <!--<img src="/claim/images/bgMarkMustInput.jpg">-->
                 </td>
           <!----modify by liuyanmei modify 20051105 start-------reason:�ͻ�Ҫ��ֻ���������͵绰-----------> 
                <td class="title" style="width:5%">��ϵ�绰</td>
                <td class="input" style='width:10%'>
                <!--��Ϊ��ʻԱ�����ֶ�DriverSeaRoute����������û�õ��������ô��ֶ��������ϵ�˵绰-->
                     <input name="prpLdriverDriverPhone"  class="input" style="width:70%" maxlength=20 value="<bean:write name='driver' property='driverSeaRoute'/>" title="��ʻԱ�绰">
                <!--<img src="/claim/images/bgMarkMustInput.jpg">-->
                </td>
			   <!--- modify by zhaolu 20060818 start--->
		     	<td class="title" style="width:12%;display: none;" >��ʻ֤����</td>
                    <td class="input" style="width:23%;display: none;">
                      <input name="prpLdriverDrivingLicenseNo" class="input"  style="width:80%" maxlength=10 value="<bean:write name='driver' property='drivingLicenseNo'/>" title="��ʻ֤����">
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
                <td class="title" style="width:10%"  align="center">֤������</td>
                <td>
                    <html:select name="driver" property="identifyType" style="width:70%">
                        <html:options collection="identifyTypes" property="codeCode" labelProperty="codeCName"/>          
                    </html:select>  
                </td>
                <td class="title" style="width:5%">֤������</td>
                <td>
                    <input name="prpLdriverIdentifyNumber" class="input" style="width:70%" maxlength=20 description="֤������" value="<bean:write name='driver' property='identifyNumber'/>">
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