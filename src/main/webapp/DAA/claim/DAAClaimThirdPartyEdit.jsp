<%@page pageEncoding='GBK'%>
<%@page import="java.util.*"%>

<%--
****************************************************************************
* DESC       ����ӵ����߳�����Ϣҳ��
* AUTHOR     ��weishixin
* CREATEDATE �� 2004-03-02
* MODIFYLIST ��   Name       Date            Reason/Contents
*
*          ------------------------------------------------------
*                wuxiaodong  20050906        ���ձ��Ƶ���ϸ��Ŀ���棬�ṩһ�β鿰���ձ�����
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��

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
                //alert("����ʲôʱ������?count="+count+"  i="+i);
                if(count!=1){
                    fm.prpLthirdPartySerialNo[i].value=i;
                 fm.prpLthirdPartyNewAddFlag[i].value="new" ; //add by liyanjie 2005-12-18
                    //�Ƿ������ĳ�����־=new,��Ϊ�Ѿ������˲���ɾ��ԭ����.
                }
            }
        }

        /**
         * �ж϶Ա��永�����α��������Ǵ���100��С��0����
         */
      function isRightDutyPercent(field){
        var lPercent=0;
        var strmsg="";
        var i=0;

         lPercent=parseFloat(field.value);
         if ((lPercent>100)||(lPercent<0))
         {
            strmsg="�永���������α������ܴ���100����С��0!";
            alert(strmsg);
            field.select();
            field.focus();
            return false;
         }

        if(isNaN(fm.prpLthirdPartySerialNo.length))
        {
           return true;
        }
        //ֻ��һ����У��

        

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
   //���Ͳ�ѯ
   function car_select(field,riskCode){   
        if(event.type=="keyup"){
            var charCode=window.event.keyCode;
            if(!(charCode==13 & window.event.ctrlKey)){
                return;
            }        
        }
        var index = 0;
        for(var i = 0 ;i < fm.all("prpLthirdPartyBrandName").length;i++){
            if(fm.all("prpLthirdPartyBrandName")[i] == field){
                index = i;
                break;
            }
        }        
        queryModelCode(riskCode,index);
   }
    </script>

<span style="display:none" >
	<table class="common" style="display:none" id="ThirdCarLoss_Data" cellspacing="1" cellpadding="5">
		<tbody>
			<tr>
				<td class="common">
					<input type="hidden" name="prpLthirdCarLossFlag">
					<input type="hidden" name="prpLthirdCarLossSerialNo" description="���">
		              
					<input type="hidden" name="RelateSerialNo" description="���">
					<input type="hidden" name="prpLthirdCarLossLossGrade" description="��ʧ�̶ȼ���">
					<input name="prpLthirdCarLossItemNo" class="readonly" readonly style="width:75%" maxlength=3 value="1">

				</td>
				<td class="common">
					<input name="prpLthirdCarLossLicenseNo" class="readonly" style="width:90%">
				</td>
				<%
                 String strThirdPartyNodeType1 = (String)request.getAttribute("prpLnodeType");
                 if(strThirdPartyNodeType1.equals("check"))
                 {
                 %>
				<td class="common">
					<html:select name="prpLthirdCarLossDto" property="kindCode" style="width:100%">
						<html:options collection="prpLcheckItemKindList" property="kindCode" labelProperty="kindName" />
					</html:select>
				</td>
				<%
                 }
                 %>
				<!--Modify by chenrenda update begin 20050406-->
				<td class="common">
					<html:select name="prpLthirdCarLossDto" property="partCode" styleClass="three" style="width:120px" onchange="getPartName(this);">
						<html:options collection="partCodeList" property="value" labelProperty="label" />
					</html:select>
					<input type="hidden" name="partName" value="<bean:write name='prpLthirdCarLossDto' property='partName'/>">
				
				</td>
				<td class="common">
					<input name="compName" class="codename" style="width:90%" ondblclick="return openCompCodeWin(ThirdCarLoss_Data,this);">
					<input type="hidden" name="compCode">
				</td>
				<!--Modify by chenrenda update end 20050406-->

				<td class="common">
					<input name="prpLthirdCarLossLossDesc" class="input" style="width:90%" onblur="checkLength1(this);" description="��ʧ�̶�����">
				</td>
				<td class="common" style='width:4%' align="center">
					<div>
						<input type=button name="buttonThirdCarLossDelete" class=smallbutton onclick="deleteRowTable(this,'ThirdCarLoss',1,1)" value="-" style="cursor: hand">
					</div>
				</td>
			</tr>
		</tbody>
	</table> 
</span>



<!--������ʾ��¼����������������ʾ��-->
<table class="common" align="center" cellpadding="5" cellspacing="1" style="display:none" id="table_cars">
	<!--��ʾ��ʾ���е�-->
	<tr class="mline">
		<td class="common" colspan="4" style="text-align:left;">
			<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="ThirdPartyImg" onclick="showPage(this,spanThirdPartyAll)">
			�永����
			<br>
			<span style="display:none"> <!--�������ʾ����-->
				<table class="common" style="display:none" id="ThirdParty_Data" cellspacing="1" cellpadding="5">
					<tbody>
						<tr>
							<td class="title" style="width:4%">
								<div align="center">
									<input class="readonlyno" readonly name="prpLthirdPartySerialNo">
									<input type="hidden" class="readonlyno"  name="prpLthirdPartyNewAddFlag" > <!--add by liyanjie 2005-12-18�Ƿ��������ĳ�����־ -->
     
								</div>
							</td>
							<td class="common" style="width:92%">
								<table class="common" cellspacing="1" cellpadding="5">

									<tr>
										<td class="common" style="TEXT-ALIGN: center" colspan=2 style="width:30%">
											<input type="hidden" name="insureCarFlag" value="0">
											<font color=red>���߳�</font>
										</td>

										<td class="common" style="width:10%">
											���ƺ���
										</td>
										<td class="common" style="valign:bottom" colspan=3 style="width:25%">
											<input name="prpLthirdPartyLicenseNo" class="input" onchange="getCarLossLicenseNo(this);" onblur="checkLength1(this);clearSpace(this);" description="���ƺ���">
										</td>

										<td class="common" style="valign:bottom" style="width:10%">
											���ܺ�
										</td>
										<td class="common" style="valign:bottom" style="width:25%">
											<input type="text" name="prpLthirdPartyFrameNo" class="input"  maxlength=20 onblur="checkLength(this)" description="���ܺ�">
										</td>

										<input type="hidden" name="prpLthirdPartySelectSend" value="0">
										<input type="hidden" name="insuredFlag" value="1">
										
									</tr>

									<tr>
										<td class="common" style="width:10%">
											��������
										</td>
										<td class="common" style="width:20%">
											<html:select name="prpLthirdPartyDto" property="carKindCode">
												<html:options collection="carKindCodes" property="codeCode" labelProperty="codeCName" />
											</html:select>
										</td>
										<td class="common" style="width:10%">
											��������
										</td>
										<td class="common" colspan=3 style="width:25%">
											<input type="text" name="prpLthirdPartyEngineNo" class="input" maxlength=20 description="��������">
										</td>
										<td class="common" style="width:10%">
											���Ƶ�ɫ
										</td>
										<td class="common" style="width:25%">
											<html:select name="prpLthirdPartyDto" property="licenseColorCode">
												<html:options collection="licenseColorCodes" property="codeCode" labelProperty="codeCName" />
											</html:select>
										</td>

									</tr>

									<tr>
									<!--	<td class="title" style="width:10%">
											�����ͺ�
										</td>
										<td class="input" style="width:20%">
											<input type="text" name="prpLthirdPartyBrandName" class="input" maxlength=30 description="�����ͺ�">
										</td> -->
										
										
								                <td class="title" style="width:10%">
											�����ͺ�
										</td>
										<td id="PartyBrandName" class="input"  style="width:20%">
											<input type="hidden" name="prpLthirdPartyModelCode" class="codecode" description="�����ͺ�"    
											   ondblclick="code_CodeSelect(this, 'ModelCode');" 
											   onchange="code_CodeChange(this, 'ModelCode');"
										  	   onkeyup="code_CodeSelect(this, 'ModelCode');">

											<input type="text" name="prpLthirdPartyBrandName" class="codename" maxlength=50 description="�����ͺ�����" style="width:90%" 
											   ondblclick="car_select(this,fm.prpLregistRiskCode.value);"
											   onchange="car_select(this,fm.prpLregistRiskCode.value);" 
											   onkeyup="car_select(this,fm.prpLregistRiskCode.value);">
										</td>
										<td class="title" style="width:10%">
											�б���˾
										</td>
										<td id="ThirdPartyInsureComCodeInput" class="input" colspan=3 style="width:25%">
										<input name="prpLthirdPartyInsureComCode" type="text" class="codename" description="�б���˾����" style="width:30%" 
                                                 ondblclick="code_CodeSelect(this, 'PlatFormComCode','1',null,'','clear');"
                                                 onchange="code_CodeChange(this, 'PlatFormComCode','1',null,'','clear');"
                                                 onkeyup= "code_CodeSelect(this, 'PlatFormComCode','1',null,'','clear');">

                                            <input type="text" name="prpLthirdPartyInsureComName" class="codename" maxlength=60 description="�б���˾����" style="width:60%" 
                                                 onblur="checkLength(this)"
                                                 ondblclick="code_CodeSelect(this, 'PlatFormComCode','-1','name','none','clear');"
                                                 onchange="code_CodeChange(this, 'PlatFormComCode','-1','name','none','clear');"
                                                 onkeyup= "code_CodeSelect(this, 'PlatFormComCode','-1','name','none','clear');">
                                        </td>
										
										<td class="title" style="width:12%">
											����ʹ������
										</td>
										<td class="input" style="width:23%">
											<input type="input" name="prpLthirdPartyUseYears" class="input" maxlength=5 description="����ʹ������">
										</td>
									</tr>

									<tr>
										<td class="title" style="width:10%">
											VIN
										</td>
										<td class="input" style="width:20%">
											<input type="text" name="prpLthirdPartyVINNo" class="common">
										</td>
										<td class="title" style="width:10%">
											��ʻ������
										</td>
										<td class="input" style="width:25%" colspan=3>
											<input type="text" name="prpLthirdPartyRunDistance" class="input" description="��������ʻ������" maxlength=15>
										</td>

										<%--modify by wangli update start 20050407--%>
										<!--Modify by chenrenda update begin 20050405 �ڱ���ʱ����ʾ���α���-->
										<td class="title" id="tdDutyPercentTitle" style="width:10%;">
											���α���
										</td>
										<td class="input" id="tdDutyPercentInput" style="width:25%;">
											<input type="text" name="prpLthirdPartyDutyPercent" class="input" value="0.0" maxlength=6 description="���ճ����Ա�������" style="width:90%"">
											%


										</td>
										<!--Modify by chenrenda update end 20050405-->
										<%--modify by wangli update end 20050407--%>
									</tr>
									<!--Modify by chenrenda add begin 20050417-->
									<!--Reason:������ģ��ϵ��永������-->
									<%
                 String strThirdPartyNodeType = (String)request.getAttribute("prpLnodeType");
                 if(strThirdPartyNodeType.equals("check"))
                 {
                 %>
							       <tr>
										<td class="title" style="width:10%">
											��ʧ���
										</td>
										<td class="input" style="width:20%">
											<input type="text" name="prpLthirdPartyLossFee" class="common">
										</td>
										<td class="title" style="width:10%">
											���߳���ʻԱ����
										</td>
										<td class="input" style="width:25%" colspan=3>
											<input type="text" name="prpLthirdPartyDriveName" class="input" description="���߳���ʻԱ����" maxlength=30>								    
                                            <img src="/claim/images/bgMarkMustInput.jpg">
										</td>

										<%--modify by wangli update start 20050407--%>
										<!--Modify by chenrenda update begin 20050405 �ڱ���ʱ����ʾ���α���-->
										<td class="title"  style="width:10%;">
											���߳���ʻԱ���֤
										</td>
										<td class="input" id="tdDutyPercentInput" style="width:25%;">
											<input type="text" name="prpLthirdPartyDriveLicensNo" class="input"  maxlength=30 description="���߳���ʻԱ���֤����" style="width:90%" >
										    <img src="/claim/images/bgMarkMustInput.jpg">
										</td>
										<!--Modify by chenrenda update end 20050405-->
										<%--modify by wangli update end 20050407--%>
										<input type="hidden" name="prpLthirdPartyLossFlag"  value="1" >
                                        <td class="input" colspan="6" /> 
									</tr>
									
									<%
                 }
                 %>
                                    <tr>
                                        <td class="title" style="width:10%">
                                                ������
                                        </td>
                                        <td class="input" style="width:20%">
                                            <input type="text" name="prpLthirdPartyCarPolicyNo" class="common">
                                        </td>
                                    </tr>
									<!--Modify by chenrenda add end 20050417-->

									<tr>
										<td colspan="8" class="common" style="width:92%">
											<table class="common" id="ThirdCarLoss" cellspacing="1" cellpadding="5">
												<thead>
													<tr>
														<td class="centertitle" style="width:15%">
															��ʧ��Ŀ���
														</td>
														<td class="centertitle" style="width:15%">
															���ƺ�
														</td>
														<%
                            if(strThirdPartyNodeType.equals("check")){
                            %>
														<td class="centertitle" style="width:20%">
															�ձ�
														</td>
														<%}%>
														<td class="centertitle" style="width:15%">
															��ʧ��λ
														</td>
														<td class="centertitle" style="width:15%">
															���(��Ŀ)����
														</td>
														<td class="centertitle" style="width:36%">
															��ʧ�̶�����
														</td>
														<td class="centertitle" style="width:4%">
															&nbsp;
														</td>
													</tr>
												</thead>
												<tfoot>
													<tr class=common>
														<%
                            if(strThirdPartyNodeType.equals("check")){
                            %>
														<td colspan=6 align="center">
															<%}else
                          	{
                            %>
														<td colspan=5 align="center">
															<%}%>
															(��"+"�ż�������ʧ��λ��Ϣ����"-"�ż�ɾ����Ϣ)
														</td>
														<td class="title" align="right" style="width:4%">
															<div align="center">
																<input type="button" value="+" class=smallbutton onclick="insertRowTable('ThirdCarLoss','ThirdCarLoss_Data',this)" name="buttonThirdCarLossInsert" style="cursor: hand">
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
									<input type=button name="buttonThirdPartyDelete" class=smallbutton onclick="deleteRow(this,'ThirdParty')" value="-">
								</div>
							</td>
						</tr>

					</tbody>
				</table> </span> <span id="spanThirdPartyAll" style="display:"> <%-- ��������չ���� --%>
				<table id="ThirdParty" class="common" align="center" cellspacing="1" cellpadding="0">
					<thead>
						<tr class=listtitle>
							<td style="width:4%">
								���
							</td>
							<td style="width:96%" colspan="2">
								����
								<%--����ֻ���ֵ��ȣ����������������ص������͹���--%>
								<input type=hidden name="nextScheduleTypeCheck" vlaue="1">
								<input type=hidden name="nextScheduleTypeLoss" vlaue="0">
							</td>
						</tr>
					</thead>
					<tfoot>
						<tr>

							<td class="title" colspan=3 align="right" style="width:4%">

								<input type="button" class=smallbutton value="+" onclick="insertRow('ThirdParty')" name="buttonThirdPartyInsert">

							</td>
						</tr>
					</tfoot>
					<tbody>
						<%
         int index=0;
         int intCheckLossIndex = 0;
         Collection prpLThirdPartyItemKindColl = (Collection)request.getAttribute("prpLcheckItemKindList");
       %>
						<% String butdisabled=""; //��-��ť��������
						   String readOnly="";
						%>
		<logic:notEmpty name="prpLthirdPartyDto" property="thirdPartyList">
			<logic:iterate id="thirdParty" name="prpLthirdPartyDto" property="thirdPartyList">
			
			<% readOnly=""; %>
			
				<logic:equal name="thirdParty" property="insureCarFlag" value="1">
					<%
						readOnly=" readOnly ";
					%>
				</logic:equal>
	
								<%
         //�õ��永�������
         PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)request.getAttribute("prpLthirdPartyDto");
         ArrayList prpLthirdPartyList = new ArrayList();
         prpLthirdPartyList = (ArrayList)prpLthirdPartyDto.getThirdPartyList();
         PrpLthirdPartyDto prpLthirdPartyDto2  = (PrpLthirdPartyDto )prpLthirdPartyList.get(index);
         int intSerialNo = prpLthirdPartyDto2.getSerialNo();

         //Modify by chenrenda update begin 20050418
         //Reason:ȡ��������ʧ��Ϣ
         //�õ��ڵ�����
         PrpLcheckLossDto prpLcheckLossDto2 = null;

         if(strThirdPartyNodeType.equals("check"))
         {

           PrpLcheckLossDto prpLcheckLossDto = (PrpLcheckLossDto)request.getAttribute("prpLcheckLossDto");
           ArrayList prpLcheckLossList = new ArrayList();
           prpLcheckLossList = (ArrayList)prpLcheckLossDto.getPrpLcheckLossList();

           if(prpLcheckLossList==null||prpLcheckLossList.size()==0)
           {
             prpLcheckLossDto2 = new PrpLcheckLossDto();
           }
           else
           {
             if(index>=prpLcheckLossList.size()){
               prpLcheckLossDto2 = new PrpLcheckLossDto();
             }else{
               prpLcheckLossDto2  = (PrpLcheckLossDto)prpLcheckLossList.get(index);  	
             }
             intCheckLossIndex++;
           }
         }
         //Modify by chenrenda update end 20050418
      %>



								<!-- �����永��������-->
								<%
									butdisabled="";  
									PrpLthirdPartyDto prpLthirdPartyDto_tmp3 = (PrpLthirdPartyDto)request.getAttribute("prpLthirdPartyDto");
									if("check".equals(prpLthirdPartyDto_tmp3.getNodeType())){
								       butdisabled="disabled";
								    }
								%>
								<tr>
									<td class="title" style="width:4%">
										<div align="center">
											<input class="readonlyno" readonly name="prpLthirdPartySerialNo" value="<bean:write name='thirdParty' property='serialNo'/>">
										    <input type="hidden" class="readonlyno"  name="prpLthirdPartyNewAddFlag" value="old" > <!--add by liyanjie 2005-12-18�Ƿ��������ĳ�����־ -->
            
										</div>
									</td>
									<td class="common" style="width:92%">
										<table class="common" cellspacing="1" cellpadding="5">
											<tr>
												<td class="common" style="TEXT-ALIGN: center" colspan=2 style="width:30%">
													<input type="hidden" name="insureCarFlag" value="<bean:write name='thirdParty' property='insureCarFlag'/>">
													<logic:equal name="thirdParty" property="insureCarFlag" value="1"><font color=red>��ĳ�</font></logic:equal>
													<logic:notEqual name="thirdParty" property="insureCarFlag" value="1"><font color=red>���߳�</font></logic:notEqual>
												</td>
																							
												<td class="common" style="width:10%">
													���ƺ���
												</td>
												
												<td class="common" colspan=3 style="width:25%">
													
													
													<logic:equal name="thirdParty" property="licenseNo" value="">
														 <input name="prpLthirdPartyLicenseNo" class="input"  maxlength=30 onblur="checkLength(this);clearSpace(this);" onchange="getCarLossLicenseNo(this);" description="���ƺ���" value="�³�" <%=readOnly%>>
													</logic:equal>
													
													<logic:notEqual name="thirdParty" property="insureCarFlag" value="">
												     <input name="prpLthirdPartyLicenseNo" class="input"  maxlength=30 onblur="checkLength(this);clearSpace(this);" onchange="getCarLossLicenseNo(this);" description="���ƺ���" value="<bean:write name='thirdParty' property='licenseNo'/>" <%=readOnly%> >
												   </logic:notEqual>
													
												
													<img src="/claim/images/bgMarkMustInput.jpg">
												</td>

												<td class="common" style="width:12%">
													���ܺ�
												</td>

												<td class="common" style="width:23%">

													<input type="text" name="prpLthirdPartyFrameNo" class="input" maxlength=20 description="���ܺ�" value="<bean:write name='thirdParty' property='frameNo'/>" <%=readOnly%> >
												</td>


												<input type="hidden" name="selectSend" value="1">
												<input type="hidden" name="prpLthirdPartySelectSend" value="<bean:write name='thirdParty' property='selectSend'/>">
												<input type="hidden" name="insuredFlag" value="1">
											</tr>
											<tr>
												<td class="common" style="width:10%">
													��������
												</td>
												<td class="common" style="width:20%">
												
													<html:select name="thirdParty" property="carKindCode" styleClass="one">
														<html:options collection="carKindCodes" property="codeCode" labelProperty="codeCName" />
													</html:select>
													
												</td>
												<td class="common" style="width:10%">
													��������
												</td>
												<td class="common" colspan=3 style="width:25%">
													<input type="text" name="prpLthirdPartyEngineNo" value="<bean:write name='thirdParty' property='engineNo'/>" class="input" maxlength=20 description="��������" <%=readOnly%>>
												</td>
												<td class="title" style="width:12%">
													���Ƶ�ɫ
												</td>
												<td class="input" style="width:23%">
													<html:select name="thirdParty" property="licenseColorCode">
														<html:options collection="licenseColorCodes" property="codeCode" labelProperty="codeCName" />
													</html:select>
												</td>
											</tr>
											<tr>
											
										               <td class="title" style="width:10%">
											          �����ͺ�
										               </td>
										               <td id="PartyBrandName" class="common"  style="width:20%">
											           <input type="hidden" <%=readOnly%> name="prpLthirdPartyModelCode" class="codecode" description="�����ͺ�"  value="<bean:write name='thirdParty' property='modelCode'/>" 
											              ondblclick="code_CodeSelect(this, 'ModelCode');" 
											              onchange="code_CodeChange(this, 'ModelCode');"
										  	              onkeyup="code_CodeSelect(this, 'ModelCode');">

											           <input   <%=readOnly%> type="text" name="prpLthirdPartyBrandName" class="codename" maxlength=50 description="�����ͺ�����" style="width:90%"  value="<bean:write name='thirdParty' property='brandName'/>" 
											              ondblclick="car_select(this,fm.prpLregistRiskCode.value);"
											              onchange="car_select(this,fm.prpLregistRiskCode.value);" 
											              onkeyup="car_select(this,fm.prpLregistRiskCode.value);">
										                </td>
											
											<!--	<td class="common" style="width:10%">
													�����ͺ�
												</td>
												<td class="common" style="width:20%">
													<input type="text" name="prpLthirdPartyBrandName" class="input" value="<bean:write name='thirdParty' property='brandName'/>"  maxlength=30 description="�����ͺ�" <%=readOnly%>>
												</td>-->
												<td class="title" style="width:10%">
													�б���˾
												</td>
												<td id="ThirdPartyInsureComCodeInput" class="input" colspan=3 style="width:25%">
												    <logic:equal name="thirdParty" property="insureCarFlag" value="1"><!-- ��ĳ� -->
                                                        <input name="prpLthirdPartyInsureComCode" class="codename" description="�б���˾����" style="width:30%" value="<bean:write name='thirdParty' property='insureComCode'/>"  ondblclick="code_CodeSelect(this, 'InsureComCode');" onkeyup= "code_CodeSelect(this, 'InsureComCode');" <%=readOnly%>>
                                                        <input type="text" name="prpLthirdPartyInsureComName" class="codename" maxlength=50 description="�б���˾����" style="width:55%" value="<bean:write name='thirdParty' property='insureComName'/>" ondblclick="code_CodeSelect(this, 'InsureComCode','-1','always','none','post');"  onkeyup= "code_CodeSelect(this, 'InsureComCode','-1','always','none','post');" <%=readOnly%>>
                                                    </logic:equal>
                                                    <logic:notEqual name="thirdParty" property="insureCarFlag" value="1"><!-- ���߳� -->                                                        
                                                        <input name="prpLthirdPartyInsureComCode" type="text" class="codename" description="�б���˾����" style="width:30%" 
                                                            value="<bean:write name='thirdParty' property='insureComCode'/>" <%=readOnly%>
                                                            ondblclick="code_CodeSelect(this, 'PlatFormComCode','1',null,'','clear');"
                                                            onchange="code_CodeChange(this, 'PlatFormComCode','1',null,'','clear');"
                                                            onkeyup= "code_CodeSelect(this, 'PlatFormComCode','1',null,'','clear');">

                                                        <input type="text" name="prpLthirdPartyInsureComName" class="codename" maxlength=60 description="�б���˾����" style="width:60%" 
                                                            value="<bean:write name='thirdParty' property='insureComName'/>" <%=readOnly%>
                                                            onblur="checkLength(this)"
                                                            ondblclick="code_CodeSelect(this, 'PlatFormComCode','-1','name','none','clear');"
                                                            onchange="code_CodeChange(this, 'PlatFormComCode','-1','name','none','clear');"
                                                            onkeyup= "code_CodeSelect(this, 'PlatFormComCode','-1','name','none','clear');">
                                                    </logic:notEqual>
												</td>
												<td class="common" style="width:12%">
													����ʹ������
												</td> 
												<td class="common" style="width:23%">
													<input type="input" name="prpLthirdPartyUseYears" class="common" maxlength=5 description="����ʹ������" value="<bean:write name='thirdParty' property='useYears'/>" <%=readOnly%>>
												</td>


											</tr>
											<tr>
												<td class="common" width=10%>
													VIN
												</td>
												<td class="common" width=20%>
													<input type="text" name="prpLthirdPartyVINNo" class="common"  value="<bean:write name='thirdParty' property='VINNo'/>" <%=readOnly%>>
												</td>
												<td class="common" style="width:10%">
													��ʻ������
												</td>
												<td class="common" style="width:25%" colspan=3>
													<input type="text" name="prpLthirdPartyRunDistance" value="<bean:write name='thirdParty' property='runDistance'/>" class="common" description="��������ʻ������" maxlength=15 <%=readOnly%>>
												</td>
												<!-- modify by wangli update start 20050407 -->
												<td class="common" id="tdDutyPercentTitle" style="width:12%;">
													���α���
												</td>
												<td class="common" id="tdDutyPercentInput" style="width:23%;">
													<input type="text" name="prpLthirdPartyDutyPercent" class="common" maxlength=6 description="���ճ����Ա�������"  onchange="return isRightDutyPercent(this);" value="<bean:write name='thirdParty' property='dutyPercent'/>" >
													%
												</td>
												<!-- modify by wangli update end 20050407 -->
											</tr>

											<!--Modify by chenrenda add begin 20050417-->
											<!--Reason:������ģ��ϵ��永������-->
											<%
                if(strThirdPartyNodeType.equals("check")){
                
               String kindAFlag = (String)request.getAttribute("kindAFlag");
              
                 %>
											<tr>
												  <td class="title" style="width:10%">
												  	��ʧ���
												  </td>
												  <td class="input" style="width:20%">
												  	  <input type="text" name="prpLthirdPartyLossFee" class="common" value="<%=prpLcheckLossDto2.getLossFee()%>" >
												  </td>
												  <%   
												  if( prpLthirdPartyDto2!=null  && ("1".equals(prpLthirdPartyDto2.getInsureCarFlag()))  ){
												     if   ( kindAFlag !=null &&kindAFlag.equals("1") ) {
												            if (!prpLthirdPartyDto2.getLossFlag().equals("0")) prpLthirdPartyDto2.setLossFlag("1");
												       %>
												       <td class="title" >�����Ƿ�����</td>
                               <td class="input" style="width:10%">
                                  <!--<select name="thirdParty" property="lossFlag" >-->
                                   <select name="prpLthirdPartyLossFlag"  >
                                   	 <option value="" <%= prpLthirdPartyDto2.getLossFlag().equals("")? "selected":"" %> > </option>
                                      <option value="1" <%= prpLthirdPartyDto2.getLossFlag().equals("1") ? "selected":"" %> >��</option>
                                      <option value="0" <%= prpLthirdPartyDto2.getLossFlag().equals("0") ? "selected":"" %> >��</option>
                                   </select>
                               </td>
                               <%
                             }
                             else { %>

								<logic:notEqual name="thirdParty" property="insureCarFlag" value="1">
			
								
								</logic:notEqual>
                             	<input type="hidden" name="prpLthirdPartyLossFlag"  value="0" >   
                            <%}
                          }else{
                          %>
         								<td class="title"  style="width:10%;">	
         											���߳���ʻԱ����
										</td>
										<td class="input" style="width:25%" colspan=3>
											<input type="text" name="prpLthirdPartyDriveName" class="input" description="���߳���ʻԱ����" maxlength=30  value="<bean:write name='thirdParty' property='prpLthirdPartyDriveName'/>" <%=readOnly%> >								    
										    <img src="/claim/images/bgMarkMustInput.jpg">
										</td>

										<%--modify by wangli update start 20050407--%>
										<!--Modify by chenrenda update begin 20050405 �ڱ���ʱ����ʾ���α���-->
										<td class="title"  style="width:10%;">
											���߳���ʻԱ���֤
										</td>
										<td class="input" id="tdDutyPercentInput" style="width:25%;">
											<input type="text" name="prpLthirdPartyDriveLicensNo" class="input"  maxlength=30 description="���߳���ʻԱ���֤����" style="width:90%" value="<bean:write name='thirdParty' property='prpLthirdPartyDriveLicensNo'/>" <%=readOnly%> >
										    <img src="/claim/images/bgMarkMustInput.jpg">
										</td>	
										<input type="hidden" name="prpLthirdPartyLossFlag"  value="1" >
                          </td>
                          
                          <%
                          }
                          %>
                         <td class="input" colspan="5" /> 
											</tr>
											<%
                }
                %>
				<%if( prpLthirdPartyDto2!=null  && !("1".equals(prpLthirdPartyDto2.getInsureCarFlag()))  ){ %>						
                            <tr>
                                <td class="title" style="width:10%">
                                           ������
                                </td>
                                <td class="input" style="width:20%">
                                   <input type="text" name="prpLthirdPartyCarPolicyNo" class="common" value="<bean:write name='thirdParty' property='carPolicyNo'/>">
                                </td>
                            </tr>
                <%}else{ %>
                            <input type="hidden" name="prpLthirdPartyCarPolicyNo"  value="0" description="������">     
                <%} %>
											<tr class=common>
												<td colspan="8" class="common" style="width:92%">
													<table class="common" id="ThirdCarLoss" cellspacing="1" cellpadding="5">
														<thead>
															<tr>
																<td class="centertitle" style="width:15%">
																	��ʧ��Ŀ���
																</td>
																<td class="centertitle" style="width:15%">
																	���ƺ�
																</td>
																<%
                            if(strThirdPartyNodeType.equals("check")){
                            %>
																<td class="centertitle" style="width:20%">
																	�ձ�
																</td>
																<%}%>
																<td class="centertitle" style="width:15%">
																	��ʧ��λ
																</td>
																<td class="centertitle" style="width:15%">
																	���(��Ŀ)����
																</td>
																<td class="centertitle" style="width:36%">
																	��ʧ�̶�����
																</td>
																<td class="centertitle" style="width:4%">
																	&nbsp;
																</td>
															</tr>
														</thead>
														<tfoot>
															<tr class=common>
																<%
                            if(strThirdPartyNodeType.equals("check")){
                            %>
																<td colspan=6>
																	<%}else
                          	{
                            %>
																<td colspan=5>
																	<%}%>
																	(��"+"�ż�������ʧ��λ��Ϣ����"-"�ż�ɾ����Ϣ)
																</td>
																<td align="right">
																	<div align="center">
																		<input type="button" class=smallbutton value="+" onclick="insertRowTable('ThirdCarLoss','ThirdCarLoss_Data',this)" name="buttonThirdCarLossInsert" style="cursor: hand">
																	</div>
																</td>
															</tr>
														</tfoot>
														<tbody>
															<logic:notEmpty name="prpLthirdCarLossDto" property="thirdCarLossList">
																<logic:iterate id="thirdCarLossdtox" name="prpLthirdCarLossDto" property="thirdCarLossList">
																	<input type="hidden" name="test" value="<bean:write name='thirdParty' property='serialNo'/>">
																	<input type="hidden" name="test2" value="<bean:write name='thirdCarLossdtox' property='serialNo'/>">

																	<logic:equal name="thirdCarLossdtox" property="serialNo" value="<%=String.valueOf(intSerialNo)%>">
																		<tr class=common>
																			<td>
																				<input type="hidden" name="prpLthirdCarLossFlag" value="<bean:write name='thirdCarLossdtox' property='flag'/>">
																				<input type="hidden" name="prpLthirdCarLossSerialNo" description="���" value="<bean:write name='thirdCarLossdtox' property='serialNo'/>">
																				<input type="hidden" name="RelateSerialNo" description="���" value="<bean:write name='thirdCarLossdtox' property='serialNo'/>">
																				<input type="hidden" name="prpLthirdCarLossLossGrade" value="<bean:write name='thirdCarLossdtox' property='lossGrade'/>">
																				<input name="prpLthirdCarLossItemNo" class="readonly" readonly style="width:75%" maxlength=3 value="<bean:write name='thirdCarLossdtox' property='itemNo'/>">
																			</td>
																			<td>
																				<input name="prpLthirdCarLossLicenseNo" class="readonly" readonly style="width:90%" value="<bean:write name='thirdCarLossdtox' property='licenseNo'/>">
																			</td>
																			<%
                                     if(strThirdPartyNodeType.equals("check")){
                                     %>
																			<td>
																				<html:select name="thirdCarLossdtox" property="kindCode" style="width:100%">
																					<html:options collection="prpLcheckItemKindList" property="kindCode" labelProperty="kindName" />
																				</html:select>
																			</td>
																			<%}%>
																			<td>
																				<html:select name="thirdCarLossdtox" property="partCode" styleClass="three" style="width:90%" onchange="getPartName(this);">
																					<html:options collection="partCodeList" property="value" labelProperty="label" />
																				</html:select>
																				<input type="hidden" name="partName" value="<bean:write name='thirdCarLossdtox' property='partName'/>">
																			</td>

																			<td>
																				<input name="compName" class="codename" style="width:90%" value="<bean:write name='thirdCarLossdtox' property='compName'/>" ondblclick="return openCompCodeWin(ThirdCarLoss,this);">
																				<input type="hidden" name="compCode" value="<bean:write name='thirdCarLossdtox' property='compCode'/>">
																			</td>


																			<td>
																				<input name="prpLthirdCarLossLossDesc" class="input" style="width:90%"  value="<bean:write name='thirdCarLossdtox' property='lossDesc'/>"
																					 onblur="checkLength1(this);" description="��ʧ�̶�����">
																			</td>
																			<td align="center">
																				<div>
																					<input type=button name="buttonThirdCarLossDelete" class=smallbutton onclick="deleteRowTable(this,'ThirdCarLoss',1,1)" value="-" style="cursor: hand">
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
											<input type=button name="buttonThirdPartyDelete" class=smallbutton onclick="deleteRow(this,'ThirdParty')" value="-" <%=butdisabled%>>
										</div>
									</td>
								</tr>
								<% index++;%>
							</logic:iterate>
						</logic:notEmpty>
					</tbody>
				</table> </span>
		</td>
	</tr>
</table>
