<%@page import="java.util.*"%>

<%--
****************************************************************************
* DESC       ����ӵ����߳�����Ϣҳ��
* AUTHOR     ��weishixin
* CREATEDATE �� 2004-03-02
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
************************ ****************************************************
--%>
    <%-- ��������չ�����ģ�� --%>
    <%--���������Զ���JavaScript������--%>

    <script language='javascript'>
      //��������뱾ҳ�Զ����JavaScript����

        /*
        ����һ���µ�ThirdParty֮��Ĵ�����ѡ������
      */
      function afterInsertThirdParty()
      {
        setPrpLthirdPartySerialNo();
      }

      /* 
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteThirdParty(field)
      {

        setPrpLthirdPartySerialNo();
      }

        /**
         * ����setPrpLthirdPartySerialNo
         */
        function setPrpLthirdPartySerialNo(){
            var count=getElementCount("prpLthirdPartySerialNo");
            for(var i=0;i<count;i++)
            {
               // alert("����ʲôʱ������?count="+count+"  i="+i);
                if(count!=1){
                    fm.prpLthirdPartySerialNo[i].value=i;
                    fm.prpLthirdPartyNewAddFlag[i].value="new" ; //add by liyanjie 2005-12-17
                    //�Ƿ������ĳ�����־=new,��Ϊ�Ѿ������˲���ɾ��ԭ����.
                }
            }
        }

        /**
         * �ж϶Ա��永�����α��������Ǵ���100��С��0����
         */
      function isRightDutyPercent(){
        var lPercent=0;
        var strmsg="";
        var i=0;
        if(isNaN(fm.prpLthirdPartySerialNo.length))
        {
           return true;
        }
        //ֻ��һ����У��

        //alert(fm.prpLthirdPartySerialNo.length)
        for (i=1;i<fm.prpLthirdPartySerialNo.length;i++)
        {
         lPercent=parseInt(fm.prpLthirdPartyDutyPercent[i].value);
         if ((lPercent>100)||(lPercent<0))
         {
            strmsg="���Ϊ"+fm.prpLthirdPartySerialNo[i].value+"���永���������α��������Ǵ���100����С��0!";
            alert(strmsg);
            //fm.prpLthirdPartySerialNo[i].onfocus();
            return false;
         }

        }

        return true;
      }
      /**
      * ����ֻӦ��/������һ��Ϊ��������
      */
      function checkInsureCarFlag(){
        var insureCarFlag=""; //�Ƿ񱾱�������
        var i=0;              //����
        var flagCount =0;     //
        var strmsg="";        //��ʾ��Ϣ

        for (i=1;i<fm.prpLthirdPartySerialNo.length;i++)
        {
           insureCarFlag=fm.insureCarFlag[i].value;
           if (insureCarFlag="1")
           {
            flagCount++;
           }
        }
        if ( flagCount<1)
        {
            strmsg="�永�����У�������1������Ϊ������������";
            alert(strmsg);
            return false;
        }

         if ( flagCount>1)
        {
            strmsg="�永�����У�ֻ����1������Ϊ������������";
            alert(strmsg);
            return false;
        }

        return true;
      }

 
    </script>
        
      <span style="display:none"> 
        <table class="common" style="display:none" id="ThirdCarLoss_Data" cellspacing="1" cellpadding="0">
          <tbody>   
            <tr>
                  <td class="input" style="width:10%"> 
                  <input type="hidden"  name="prpLthirdCarLossFlag">
                  <input type="hidden"  name="prpLthirdCarLossSerialNo" description="���">
                  <input type="hidden"  name="RelateSerialNo" description="���">
                  <input type="hidden"  name="prpLthirdCarLossLossGrade" description="��ʧ�̶ȼ���">
                  <input name="prpLthirdCarLossItemNo" class="readonly" readonly style="width:75%" maxlength=3 value="1">
                  
                </td>
                <td class="input" style="width:15%">
                  <input name="prpLthirdCarLossLicenseNo" class="common"  style="width:90%" >
                </td>
                <!--Modify by chenrenda update begin 20050406-->
                <td class="input" style="width:15%">
                  <html:select name="prpLthirdCarLossDto" property="partCode" styleClass="three" style="width:120px" onchange="getPartName(this);">
                    <html:options  collection="partCodeList" property="value" labelProperty="label"/>
                  </html:select>
                  <input type="hidden" name="partName" value="<bean:write name='prpLthirdCarLossDto' property='partName'/>">
                </td>    
                <td class="input" style="width:15%">
                  <input name="compName" class="codename" style="width:90%"  			             
                     ondblclick="return openCompCodeWin(ThirdCarLoss_Data,this);">  
                     <input type="hidden" name="compCode">
                </td>
                <!--Modify by chenrenda update end 20050406-->
              
                <td class="input" style="width:26%">
                  <input name="prpLthirdCarLossLossDesc" class="input" style="width:90%">
                </td> 
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonThirdCarLossDelete"  onclick="deleteRowTable(this,'ThirdCarLoss',1,1)" value="-" style="cursor: hand">
                </div>
                </td>
              </tr>
          </tbody>
        </table>
      </span>
      
      
    
   <!--������ʾ��¼����������������ʾ��-->
    <table class="common" align="center">
   <!--��ʾ��ʾ���е�-->    
      <tr class="mline">
        <td class="subformtitle" colspan="4" style="text-align:left"><img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="ThirdPartyImg" onclick="showPage(this,spanThirdPartyAll)">
        �永����<br>
          <span  style="display:none">
             <!--�������ʾ����-->
             <table class="common" style="display:none" id="ThirdParty_Data" cellspacing="1" cellpadding="0" >
               <tbody>
                 <tr>
                    <td class="title" style="width:4%">
                      <div align="center">
                          <input class="readonlyno" readonly name="prpLthirdPartySerialNo" >
                          <input type="hidden" class="readonlyno"  name="prpLthirdPartyNewAddFlag" > <!--add by liyanjie 2005-12-17�Ƿ��������ĳ�����־ -->
                      </div>
                    </td>
                    <td class="subformtitle" style="width:92%" >
                        <table class="common" cellspacing="1" cellpadding="0">
                           <tr>
                    <td class="common" style="TEXT-ALIGN: center" colspan=2 style="width:30%">
											<font color=red>���߳�</font>
										</td>
                   <td class="title" style="width:10%">���ƺ���</td>
                   <td class="input" style="width:20%" style="valign:bottom" >
                     <input name="prpLthirdPartyLicenseNo" class="input" style="width:75%" maxlength=30 onblur="checkLength1(this)" description="���ƺ���" >
                     <img src="/claim/images/bgMarkMustInput.jpg"> 
                   </td>

                   <td class="title" style="width:10%;valign:bottom" >���ܺ�</td>
                   <td class="input" style="width:20%;valign:bottom" >
                    <input type="text" name="prpLthirdPartyFrameNo" class="input" maxlength=20 description="���ܺ�" >

                   </td>

                   
                    <input type="hidden" name="prpLthirdPartySelectSend" value="0">          
                    <input type="hidden" name="insuredFlag" value="1">
                </tr>
                <tr>
                  <td class="title" style="width:10%">��������</td>
                  <td class="input" style="width:20%">
                       <html:select name="prpLthirdPartyDto" property="carKindCode" >
                          <html:options collection="carKindCodes" property="codeCode" labelProperty="codeCName" />
                       </html:select>
                  </td>
                  <td class="title" style="width:10%">��������</td>
                  <td class="input" style="width:20%">
                  <input type="text" name="prpLthirdPartyEngineNo" class="input" maxlength=20 description="��������">
                  </td>
                  <td class="title"  style="width:10%">���Ƶ�ɫ</td>
                  <td class="input" style="width:20%">
                   <html:select name="prpLthirdPartyDto" property="licenseColorCode" >
                     <html:options collection="licenseColorCodes" property="codeCode" labelProperty="codeCName" />
                   </html:select>
                  </td>

                </tr>
                <tr>
                  <td class="title" style="width:10%">�����ͺ�</td>
                  <td class="input" style="width:20%">
                   <input type="text" name="prpLthirdPartyBrandName" class="input"  maxlength=30 description="�����ͺ�" >
                  </td>
                  <td class="title" style="width:10%">�б���˾</td>
                  <td id="ThirdPartyInsureComCodeInput" class="input"  style="width:20%">
                       <input name="prpLthirdPartyInsureComCode" class="codecode" description="�б���˾����" style="width:30%"
                          ondblclick="code_CodeSelect(this, 'InsureComCode');"
                          onkeyup= "code_CodeSelect(this, 'InsureComCode');">

                       <input type="text" name="prpLthirdPartyInsureComName" class="codename" maxlength=50 description="�б���˾����" style="width:60%"
                          ondblclick="code_CodeSelect(this, 'InsureComCode','-1','always','none','post');"
                          onkeyup= "code_CodeSelect(this, 'InsureComCode','-1','always','none','post');">
                  </td>
                  <td class="title" style="width:10%">����ʹ������</td>
                  <td class="input" style="width:20%">
                   <input type="input" name="prpLthirdPartyUseYears" class="input" maxlength=5 description="����ʹ������">
                  </td>
                </tr>

               <tr>
               <td class="title" style="width:10%">VIN</td>
                  <td class="input" style="width:20%">
                    <input type="text" name="prpLthirdPartyVINNo" class="common" style="width:90%">
                  </td>
                   <td class="title"  style="width:10%">��ʻ������</td>
                   <td class="input" style="width:20%">
                    <input type="text" name="prpLthirdPartyRunDistance" class="input"  description="��������ʻ������" maxlength=15 >
                   </td>
                  <td class="title" style="width:16%;display:none" >�Ƿ�Ϊ����������</td>
                  <td class="input"  style="width:6%;TEXT-ALIGN: center;display:none">
                    <input type="hidden" name="insureCarFlag" value="0">���߳�
                  </td>
                  <%--modify by wangli update start 20050407--%>
                   <!--Modify by chenrenda update begin 20050405 �ڱ���ʱ����ʾ���α���-->
                  <td class="title"  id="tdDutyPercentTitle" style="width:10%;">�Ա��永�����α���</td>
                  <td class="input" id="tdDutyPercentInput" style="width:20%;">
                  <input type="text" name="prpLthirdPartyDutyPercent" class="input" maxlength=6 description="���ճ����Ա�������" style="width:90%"">%
                   <img src="/claim/images/bgMarkMustInput.jpg"> 

                  </td>
                  <!--Modify by chenrenda update begin 20050405-->                                    
                  <%--modify by wangli update end 20050407--%>
                </tr>
                <tr>
                    <td colspan="8" class="subformtitle" style="width:92%" >
                       <table  class="common" id="ThirdCarLoss" cellspacing="1" cellpadding="0">
                           <thead> 
                            <tr>
                                <td class="centertitle" style="width:10%">��ʧ��Ŀ���</td>
                                <td class="centertitle" style="width:15%">���ƺ�</td>
                                <td class="centertitle" style="width:15%">��ʧ��λ</td>
                                <td class="centertitle" style="width:15%">���(��Ŀ)����</td>
                                <td class="centertitle" style="width:26%">��ʧ�̶�����</td>
                              <td class="title" style="width:4%" >&nbsp;</td> 
                            </tr> 
                          </thead>
                          <tfoot>
                              <tr>
                                <td class="title" colspan=5 style="width:96%">(��"+"�ż�������ʧ��λ��Ϣ����"-"�ż�ɾ����Ϣ)</td>
                                 <td class="title" align="right" style="width:4%">
                                 <div align="center">
                                 <input type="button" value="+" onclick="insertRowTable('ThirdCarLoss','ThirdCarLoss_Data',this)" name="buttonDriverInsert" style="cursor: hand">
                                 </div>
                                 </td>
                              </tr>
                           </tfoot> 
                            <tbody>
                              
                            </tbody>
                        </table>
                    </td>
                </tr>               
                
             </table>
          </td>
         
          <td class="title" style="width:4%">
             <div align="center">
                <input type=button name="buttonThirdPartyDelete"  onclick="deleteRow(this,'ThirdParty')" value="-" >
             </div>
          </td>
                  </tr>

                 </tbody>
             </table>
          </span>
          
          
          <span id="spanThirdPartyAll" style="display:">
          <%-- ��������չ���� --%>
             <table id="ThirdParty" class="common" align="center" cellspacing="1" cellpadding="0">
                <thead>
                  <tr>
                     <td class="title" style="width:4%">���</td>
                     <td class="title" style="width:96%" colspan="2">����
                   </td>
                  </tr>
                </thead>
                <tfoot>
                  <tr>
                     <td class="title" colspan=2 style="width:96%">(��"+"�ż������永��������"-"�ż�ɾ����Ϣ)</td>
                     <td class="title" align="right" style="width:4%">
                        <div align="center">
                            <input type="button" value="+" onclick="insertRow('ThirdParty')" align="right" name="buttonThirdPartyInsert" >
                        </div>
                     </td>
                  </tr>
                  </tfoot>
                <tbody id="readonlyThirdPartyTable"> 
       <%
       int index=0;
       int intCheckLossIndex = 0;
       %>
       <% String butdisabled=""; //��-��ť��������%>

      <logic:notEmpty  name="prpLthirdPartyDto"  property="thirdPartyList">
        <logic:iterate id="thirdParty" name="prpLthirdPartyDto" property="thirdPartyList">
            
      <%
         //�õ��永�������
         PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)request.getAttribute("prpLthirdPartyDto"); 
         ArrayList prpLthirdPartyList = new ArrayList();
         prpLthirdPartyList = (ArrayList)prpLthirdPartyDto.getThirdPartyList();
         PrpLthirdPartyDto prpLthirdPartyDto2  = (PrpLthirdPartyDto )prpLthirdPartyList.get(index);
         int intSerialNo = prpLthirdPartyDto2.getSerialNo();
      %> 
             
           
        
             <!-- �����永��������-->
             <%butdisabled="";%>
             <logic:equal name="prpLthirdPartyDto" property="nodeType" value="check">
             <%butdisabled="disabled";%>
             </logic:equal>
                <tr>
                   <td class="title" style="width:4%">
                     <div align="center">
                         <input class="readonlyno" readonly name="prpLthirdPartySerialNo" value="<bean:write name='thirdParty' property='serialNo'/>">
                         <input type="hidden" class="readonlyno"  name="prpLthirdPartyNewAddFlag" value="old" > <!--add by liyanjie 2005-12-17�Ƿ��������ĳ�����־ -->
                     </div>
                   </td>
                   <td class="subformtitle" style="width:92%" >
                       <table class="common" cellspacing="1" cellpadding="0">
                          <tr>
                          
                          <td class="common" style="TEXT-ALIGN: center" colspan=2 style="width:30%">
												   <logic:equal name="thirdParty" property="insureCarFlag" value="1"><font color=red>��ĳ�</font></logic:equal>
												  	<logic:notEqual name="thirdParty" property="insureCarFlag" value="1"><font color=red>���߳�</font></logic:notEqual>
												  </td>
												
                     <td class="title" style="width:10%">���ƺ���</td>
                     <td class="input" style="width:20%;valign:bottom" >
                       <input name="prpLthirdPartyLicenseNo" class="input"  style="width:75%" maxlength=30 onblur="checkLength1(this)" description="���ƺ���"  value="<bean:write name='thirdParty' property='licenseNo'/>">
                       <img src="/claim/images/bgMarkMustInput.jpg">
                     </td>

                   <td class="title" style="width:10%">���ܺ�</td>

                   <td class="input" style="width:20%" >

                    <input type="text" name="prpLthirdPartyFrameNo" class="input" maxlength=20 description="���ܺ�"  value="<bean:write name='thirdParty' property='frameNo'/>">
                   </td>

                 
                   <input type="hidden" name="prpLthirdPartySelectSend" value="<bean:write name='thirdParty' property='selectSend'/>" >
                   <input type="hidden" name="insuredFlag" value="1">
               </tr>
               <tr>
                 <td class="title"  style="width:10%">��������</td>
                 <td class="input" style="width:20%">
                      <html:select name="thirdParty" property="carKindCode" styleClass="one" style="width:100%" >
                         <html:options collection="carKindCodes" property="codeCode" labelProperty="codeCName" />
                      </html:select>
                 </td>
                 <td class="title" style="width:10%">��������</td>
                 <td class="input" style="width:20%">
                 <input type="text" name="prpLthirdPartyEngineNo" value="<bean:write name='thirdParty' property='engineNo'/>"  class="input" maxlength=20 description="��������" >
                 </td>
                 <td class="title" style="width:10%">���Ƶ�ɫ</td>
                 <td class="input" style="width:20%">
                  <html:select name="thirdParty" property="licenseColorCode" >
                    <html:options collection="licenseColorCodes" property="codeCode" labelProperty="codeCName" />
                  </html:select>
                 </td>
                 </tr>
                 
               <tr>
                  <td class="title" style="width:10%">�����ͺ�</td>
                  <td class="input" style="width:20%">
                   <input type="text" name="prpLthirdPartyBrandName" class="input" value="<bean:write name='thirdParty' property='brandName'/>" style="width:100%" maxlength=30 description="�����ͺ�" >
                  </td>
                   <td class="title" style="width:10%">�б���˾</td>
                   <td id="ThirdPartyInsureComCodeInput" class="input" style="width:20%" >
                       <input name="prpLthirdPartyInsureComCode" class="codecode" description="�б���˾����" style="width:30%" value="<bean:write name='thirdParty' property='insureComCode'/>">

                       <input type="text" name="prpLthirdPartyInsureComName" class="codename" maxlength=50 description="�б���˾����" style="width:60%" value="<bean:write name='thirdParty' property='insureComName'/>">
                   </td>
                   <td class="title" style="width:10%">����ʹ������</td>
                   <td class="input" style="width:20%">
                    <input type="input" name="prpLthirdPartyUseYears" class="common" maxlength=5 description="����ʹ������"
                                      value="<bean:write name='thirdParty' property='useYears'/>">
                   </td>


                 </tr>
                 <tr>
                   <td class="title" style="width:10%">VIN</td>
                   <td class="input" style="width:20%">
                     <input type="text" name="prpLthirdPartyVINNo" class="common" style="width:90%" value="<bean:write name='thirdParty' property='VINNo'/>" >
                   </td>
                   <td class="title" style="width:10%">��ʻ������</td>
                   <td class="input" style="width:20%">
                     <input type="text" name="prpLthirdPartyRunDistance" value="<bean:write name='thirdParty' property='runDistance'/>" class="common"  description="��������ʻ������" maxlength=15 >
                   </td>
                   <td class="title" style="width:16%;display:none">�Ƿ�Ϊ����������</td>
                   <td class="input"  style="width:6%;display:none;TEXT-ALIGN: center">
                   <input type="hidden" name="insureCarFlag" value="<bean:write name='thirdParty' property='insureCarFlag'/>">
                     <logic:equal name="thirdParty" property="insureCarFlag" value="1">��ĳ�</logic:equal>
                     <logic:notEqual name="thirdParty" property="insureCarFlag" value="1">���߳�</logic:notEqual>
                   </td>
                   <!-- modify by wangli update start 20050407 -->
                   <td class="title" id="tdDutyPercentTitle"  style="width:10%;">�Ա��永�����α���</td>
                   <td class="input" id="tdDutyPercentInput" style="width:20%;">
                     <input type="text" name="prpLthirdPartyDutyPercent" class="common" maxlength=6 description="���ճ����Ա�������"
                       style="width:90%"  value="<bean:write name='thirdParty' property='dutyPercent'/>">%
                       <img src="/claim/images/bgMarkMustInput.jpg"> 
                   </td>
                   <!-- modify by wangli update end 20050407 -->
                 </tr>
                 <tr>
                   <td colspan="8" class="subformtitle" style="width:92%" >
                     <table  class="common" id="ThirdCarLoss" cellspacing="1" cellpadding="0">
                       <thead>  
                        <tr>
                            <td class="centertitle" style="width:10%">��ʧ��Ŀ���</td>
                            <td class="centertitle" style="width:15%">���ƺ�</td>
                            <td class="centertitle" style="width:15%">��ʧ��λ</td>
                            <td class="centertitle" style="width:15%">���(��Ŀ)����</td>
                            <td class="centertitle" style="width:26%">��ʧ�̶�����</td>
                            <td class="title" style="width:4%" >&nbsp;</td> 
                        </tr>
                       </thead>
                       <tfoot>
                          <tr>
                            <td class="title" colspan=5 style="width:96%">(��"+"�ż�������ʧ��λ��Ϣ����"-"�ż�ɾ����Ϣ)</td>
                             <td class="title" align="right" style="width:4%">
                             <div align="center">
                             <input type="button" value="+" onclick="insertRowTable('ThirdCarLoss','ThirdCarLoss_Data',this)" name="buttonDriverInsert" <%=butdisabled%> style="cursor: hand">
                             </div>
                             </td>
                          </tr>
                       </tfoot> 
                       <tbody>
                         <logic:notEmpty  name="prpLthirdCarLossDto"  property="thirdCarLossList"> 
                           <logic:iterate id="thirdCarLossdtox" name="prpLthirdCarLossDto" property="thirdCarLossList">
                             <input type="hidden" name="test" value="<bean:write name='thirdParty' property='serialNo'/>"> 
                             <input type="hidden" name="test2" value="<bean:write name='thirdCarLossdtox' property='serialNo'/>"> 
                     
                             <logic:equal name="thirdCarLossdtox" property="serialNo" value="<%=String.valueOf(intSerialNo)%>">
                                  <tr>
                                    <td class="input" style="width:10%"> 
                                      <input type="hidden"  name="prpLthirdCarLossFlag" value="<bean:write name='thirdCarLossdtox' property='flag'/>">
                                      <input type="hidden"  name="prpLthirdCarLossSerialNo" description="���" value="<bean:write name='thirdCarLossdtox' property='serialNo'/>">
                                      <input type="hidden"  name="RelateSerialNo" description="���" value="<bean:write name='thirdCarLossdtox' property='serialNo'/>">
                                      <input type="hidden"  name="prpLthirdCarLossLossGrade" value="<bean:write name='thirdCarLossdtox' property='lossGrade'/>">
                                      <input name="prpLthirdCarLossItemNo" class="readonly" readonly style="width:75%" maxlength=3 value="<bean:write name='thirdCarLossdtox' property='itemNo'/>">
                                    </td> 
                                    <td class="input" style="width:15%">
                                      <input name="prpLthirdCarLossLicenseNo" class="readonly" readonly  style="width:90%" value="<bean:write name='thirdCarLossdtox' property='licenseNo'/>">
                                    </td>
                                 
                                    <td class="input" style="width:15%">
                                      <html:select name="thirdCarLossdtox" property="partCode" styleClass="three" style="width:120px" onchange="getPartName(this);">
                                        <html:options  collection="partCodeList" property="value" labelProperty="label"/>
                                      </html:select>
                                      <input type="hidden"  name="partName"  value="<bean:write name='thirdCarLossdtox' property='partName'/>">
                                    </td>    
                                 
                                    <td class="input" style="width:15%">
                                      <input name="compName" class="codename" style="width:90%" value="<bean:write name='thirdCarLossdtox' property='compName'/>">  
                                      <input type="hidden"  name="compCode"  value="<bean:write name='thirdCarLossdtox' property='compCode'/>">
                                    </td>
                                  
                                    
                                    <td class="input" style="width:26%">
                                      <input name="prpLthirdCarLossLossDesc" class="input" style="width:90%" value="<bean:write name='thirdCarLossdtox' property='lossDesc'/>">
                                    </td>
                                    <td class="input" style='width:4%'  align="center">
                                    <div>
                                      <input type=button name="buttonThirdCarLossDelete"  onclick="deleteRowTable(this,'ThirdCarLoss',1,1)" value="-" <%=butdisabled%> style="cursor: hand">
                                    </div>
                                    </td>
                                  </tr>
                             </logic:equal>       
                           </logic:iterate>
                         </logic:notEmpty>          
                      </tbody> 
                    </table>  
                  </td>
                </tr>
               </table>
             </td>
             <td class="title" style="width:4%">
                <div align="center">
                   <input type=button name="buttonThirdPartyDelete"  onclick="deleteRow(this,'ThirdParty')" value="-" <%=butdisabled%> >
                </div>
             </td>
            </tr>
          <% index++;%>
        </logic:iterate> 
      </logic:notEmpty>
                </tbody>
             </table>
        </span>
      </td>
   </tr>
  
</table>