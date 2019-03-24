<%@page pageEncoding='GBK'%>
<%@page import="java.util.*"%>

<%--
****************************************************************************
* DESC       ：添加第三者车辆信息页面
* AUTHOR     ：weishixin
* CREATEDATE ： 2004-03-02
* MODIFYLIST ：   Name       Date            Reason/Contents
*
*          ------------------------------------------------------
*                wuxiaodong  20050906        将险别移到明细条目里面，提供一次查堪多险别的情况
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择

************************ ****************************************************
--%>
<%-- 多行输入展现域的模板 --%>
<%--多行输入自定义JavaScript方法域--%>

<script language='javascript'>
      //在下面加入本页自定义的JavaScript方法

        /*
        插入一条新的ThirdParty之后的处理（可选方法）
      */
      function afterInsertThirdParty()
      {
        setPrpLthirdPartySerialNo();
      }

      /*
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeleteThirdParty(field)
      {

        setPrpLthirdPartySerialNo();
      }

        /**
         * 设置setPrpLthirdPartySerialNo
         */
        function setPrpLthirdPartySerialNo(){
            var count=getElementCount("prpLthirdPartySerialNo");
            for(var i=0;i<count;i++)
            {
                //alert("看看什么时候运行?count="+count+"  i="+i);
                if(count!=1){
                    fm.prpLthirdPartySerialNo[i].value=i;
                 fm.prpLthirdPartyNewAddFlag[i].value="new" ; //add by liyanjie 2005-12-18
                    //是否新增的车辆标志=new,因为已经控制了不能删除原来的.
                }
            }
        }

        /**
         * 判断对本涉案车责任比例不能是大于100，小于0的数
         */
      function isRightDutyPercent(field){
        var lPercent=0;
        var strmsg="";
        var i=0;

         lPercent=parseFloat(field.value);
         if ((lPercent>100)||(lPercent<0))
         {
            strmsg="涉案车辆的责任比例不能大于100或者小于0!";
            alert(strmsg);
            field.select();
            field.focus();
            return false;
         }

        if(isNaN(fm.prpLthirdPartySerialNo.length))
        {
           return true;
        }
        //只有一条不校验

        

        return true;
      }
      /**
      * 并且只应该/必须有一辆为保单车辆
      */
      function checkInsureCarFlag(){
        var insureCarFlag=""; //是否本保单车辆
        var i=0;              //计数
        var flagCount =0;     //
        var strmsg="";        //提示消息

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
            strmsg="涉案车辆中，必须有1辆车辆为本保单车辆！";
            alert(strmsg);
            return false;
        }

         if ( flagCount>1)
        {
            strmsg="涉案车辆中，只能有1辆车辆为本保单车辆！";
            alert(strmsg);
            return false;
        }

        return true;
      }
   //车型查询
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
					<input type="hidden" name="prpLthirdCarLossSerialNo" description="序号">
		              
					<input type="hidden" name="RelateSerialNo" description="序号">
					<input type="hidden" name="prpLthirdCarLossLossGrade" description="损失程度级别">
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
					<input name="prpLthirdCarLossLossDesc" class="input" style="width:90%" onblur="checkLength1(this);" description="损失程度描述">
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



<!--建立显示的录入条，可以收缩显示的-->
<table class="common" align="center" cellpadding="5" cellspacing="1" style="display:none" id="table_cars">
	<!--表示显示多行的-->
	<tr class="mline">
		<td class="common" colspan="4" style="text-align:left;">
			<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="ThirdPartyImg" onclick="showPage(this,spanThirdPartyAll)">
			涉案车辆
			<br>
			<span style="display:none"> <!--点击后显示内容-->
				<table class="common" style="display:none" id="ThirdParty_Data" cellspacing="1" cellpadding="5">
					<tbody>
						<tr>
							<td class="title" style="width:4%">
								<div align="center">
									<input class="readonlyno" readonly name="prpLthirdPartySerialNo">
									<input type="hidden" class="readonlyno"  name="prpLthirdPartyNewAddFlag" > <!--add by liyanjie 2005-12-18是否是新增的车辆标志 -->
     
								</div>
							</td>
							<td class="common" style="width:92%">
								<table class="common" cellspacing="1" cellpadding="5">

									<tr>
										<td class="common" style="TEXT-ALIGN: center" colspan=2 style="width:30%">
											<input type="hidden" name="insureCarFlag" value="0">
											<font color=red>三者车</font>
										</td>

										<td class="common" style="width:10%">
											号牌号码
										</td>
										<td class="common" style="valign:bottom" colspan=3 style="width:25%">
											<input name="prpLthirdPartyLicenseNo" class="input" onchange="getCarLossLicenseNo(this);" onblur="checkLength1(this);clearSpace(this);" description="号牌号码">
										</td>

										<td class="common" style="valign:bottom" style="width:10%">
											车架号
										</td>
										<td class="common" style="valign:bottom" style="width:25%">
											<input type="text" name="prpLthirdPartyFrameNo" class="input"  maxlength=20 onblur="checkLength(this)" description="车架号">
										</td>

										<input type="hidden" name="prpLthirdPartySelectSend" value="0">
										<input type="hidden" name="insuredFlag" value="1">
										
									</tr>

									<tr>
										<td class="common" style="width:10%">
											车辆种类
										</td>
										<td class="common" style="width:20%">
											<html:select name="prpLthirdPartyDto" property="carKindCode">
												<html:options collection="carKindCodes" property="codeCode" labelProperty="codeCName" />
											</html:select>
										</td>
										<td class="common" style="width:10%">
											发动机号
										</td>
										<td class="common" colspan=3 style="width:25%">
											<input type="text" name="prpLthirdPartyEngineNo" class="input" maxlength=20 description="发动机号">
										</td>
										<td class="common" style="width:10%">
											号牌底色
										</td>
										<td class="common" style="width:25%">
											<html:select name="prpLthirdPartyDto" property="licenseColorCode">
												<html:options collection="licenseColorCodes" property="codeCode" labelProperty="codeCName" />
											</html:select>
										</td>

									</tr>

									<tr>
									<!--	<td class="title" style="width:10%">
											厂牌型号
										</td>
										<td class="input" style="width:20%">
											<input type="text" name="prpLthirdPartyBrandName" class="input" maxlength=30 description="厂牌型号">
										</td> -->
										
										
								                <td class="title" style="width:10%">
											厂牌型号
										</td>
										<td id="PartyBrandName" class="input"  style="width:20%">
											<input type="hidden" name="prpLthirdPartyModelCode" class="codecode" description="厂牌型号"    
											   ondblclick="code_CodeSelect(this, 'ModelCode');" 
											   onchange="code_CodeChange(this, 'ModelCode');"
										  	   onkeyup="code_CodeSelect(this, 'ModelCode');">

											<input type="text" name="prpLthirdPartyBrandName" class="codename" maxlength=50 description="厂牌型号名称" style="width:90%" 
											   ondblclick="car_select(this,fm.prpLregistRiskCode.value);"
											   onchange="car_select(this,fm.prpLregistRiskCode.value);" 
											   onkeyup="car_select(this,fm.prpLregistRiskCode.value);">
										</td>
										<td class="title" style="width:10%">
											承保公司
										</td>
										<td id="ThirdPartyInsureComCodeInput" class="input" colspan=3 style="width:25%">
										<input name="prpLthirdPartyInsureComCode" type="text" class="codename" description="承保公司代码" style="width:30%" 
                                                 ondblclick="code_CodeSelect(this, 'PlatFormComCode','1',null,'','clear');"
                                                 onchange="code_CodeChange(this, 'PlatFormComCode','1',null,'','clear');"
                                                 onkeyup= "code_CodeSelect(this, 'PlatFormComCode','1',null,'','clear');">

                                            <input type="text" name="prpLthirdPartyInsureComName" class="codename" maxlength=60 description="承保公司名称" style="width:60%" 
                                                 onblur="checkLength(this)"
                                                 ondblclick="code_CodeSelect(this, 'PlatFormComCode','-1','name','none','clear');"
                                                 onchange="code_CodeChange(this, 'PlatFormComCode','-1','name','none','clear');"
                                                 onkeyup= "code_CodeSelect(this, 'PlatFormComCode','-1','name','none','clear');">
                                        </td>
										
										<td class="title" style="width:12%">
											车辆使用年限
										</td>
										<td class="input" style="width:23%">
											<input type="input" name="prpLthirdPartyUseYears" class="input" maxlength=5 description="车辆使用年限">
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
											行驶公里数
										</td>
										<td class="input" style="width:25%" colspan=3>
											<input type="text" name="prpLthirdPartyRunDistance" class="input" description="车辆已行驶公里数" maxlength=15>
										</td>

										<%--modify by wangli update start 20050407--%>
										<!--Modify by chenrenda update begin 20050405 在报案时不显示责任比例-->
										<td class="title" id="tdDutyPercentTitle" style="width:10%;">
											责任比例
										</td>
										<td class="input" id="tdDutyPercentInput" style="width:25%;">
											<input type="text" name="prpLthirdPartyDutyPercent" class="input" value="0.0" maxlength=6 description="保险车辆对本车责任" style="width:90%"">
											%


										</td>
										<!--Modify by chenrenda update end 20050405-->
										<%--modify by wangli update end 20050407--%>
									</tr>
									<!--Modify by chenrenda add begin 20050417-->
									<!--Reason:赔款费用模块合到涉案车辆中-->
									<%
                 String strThirdPartyNodeType = (String)request.getAttribute("prpLnodeType");
                 if(strThirdPartyNodeType.equals("check"))
                 {
                 %>
							       <tr>
										<td class="title" style="width:10%">
											损失金额
										</td>
										<td class="input" style="width:20%">
											<input type="text" name="prpLthirdPartyLossFee" class="common">
										</td>
										<td class="title" style="width:10%">
											三者车驾驶员姓名
										</td>
										<td class="input" style="width:25%" colspan=3>
											<input type="text" name="prpLthirdPartyDriveName" class="input" description="三者车驾驶员名称" maxlength=30>								    
                                            <img src="/claim/images/bgMarkMustInput.jpg">
										</td>

										<%--modify by wangli update start 20050407--%>
										<!--Modify by chenrenda update begin 20050405 在报案时不显示责任比例-->
										<td class="title"  style="width:10%;">
											三者车驾驶员身份证
										</td>
										<td class="input" id="tdDutyPercentInput" style="width:25%;">
											<input type="text" name="prpLthirdPartyDriveLicensNo" class="input"  maxlength=30 description="三者车驾驶员身份证号码" style="width:90%" >
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
                                                保单号
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
															损失项目序号
														</td>
														<td class="centertitle" style="width:15%">
															车牌号
														</td>
														<%
                            if(strThirdPartyNodeType.equals("check")){
                            %>
														<td class="centertitle" style="width:20%">
															险别
														</td>
														<%}%>
														<td class="centertitle" style="width:15%">
															损失部位
														</td>
														<td class="centertitle" style="width:15%">
															零件(项目)名称
														</td>
														<td class="centertitle" style="width:36%">
															损失程度描述
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
															(按"+"号键增加损失部位信息，按"-"号键删除信息)
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
				</table> </span> <span id="spanThirdPartyAll" style="display:"> <%-- 多行输入展现域 --%>
				<table id="ThirdParty" class="common" align="center" cellspacing="1" cellpadding="0">
					<thead>
						<tr class=listtitle>
							<td style="width:4%">
								序号
							</td>
							<td style="width:96%" colspan="2">
								内容
								<%--反正只两种调度，所以先用两个隐藏的输入框就够了--%>
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
						<% String butdisabled=""; //让-按钮不可以用
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
         //得到涉案车辆序号
         PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)request.getAttribute("prpLthirdPartyDto");
         ArrayList prpLthirdPartyList = new ArrayList();
         prpLthirdPartyList = (ArrayList)prpLthirdPartyDto.getThirdPartyList();
         PrpLthirdPartyDto prpLthirdPartyDto2  = (PrpLthirdPartyDto )prpLthirdPartyList.get(index);
         int intSerialNo = prpLthirdPartyDto2.getSerialNo();

         //Modify by chenrenda update begin 20050418
         //Reason:取出估计损失信息
         //得到节点类型
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



								<!-- 插入涉案车辆内容-->
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
										    <input type="hidden" class="readonlyno"  name="prpLthirdPartyNewAddFlag" value="old" > <!--add by liyanjie 2005-12-18是否是新增的车辆标志 -->
            
										</div>
									</td>
									<td class="common" style="width:92%">
										<table class="common" cellspacing="1" cellpadding="5">
											<tr>
												<td class="common" style="TEXT-ALIGN: center" colspan=2 style="width:30%">
													<input type="hidden" name="insureCarFlag" value="<bean:write name='thirdParty' property='insureCarFlag'/>">
													<logic:equal name="thirdParty" property="insureCarFlag" value="1"><font color=red>标的车</font></logic:equal>
													<logic:notEqual name="thirdParty" property="insureCarFlag" value="1"><font color=red>三者车</font></logic:notEqual>
												</td>
																							
												<td class="common" style="width:10%">
													号牌号码
												</td>
												
												<td class="common" colspan=3 style="width:25%">
													
													
													<logic:equal name="thirdParty" property="licenseNo" value="">
														 <input name="prpLthirdPartyLicenseNo" class="input"  maxlength=30 onblur="checkLength(this);clearSpace(this);" onchange="getCarLossLicenseNo(this);" description="号牌号码" value="新车" <%=readOnly%>>
													</logic:equal>
													
													<logic:notEqual name="thirdParty" property="insureCarFlag" value="">
												     <input name="prpLthirdPartyLicenseNo" class="input"  maxlength=30 onblur="checkLength(this);clearSpace(this);" onchange="getCarLossLicenseNo(this);" description="号牌号码" value="<bean:write name='thirdParty' property='licenseNo'/>" <%=readOnly%> >
												   </logic:notEqual>
													
												
													<img src="/claim/images/bgMarkMustInput.jpg">
												</td>

												<td class="common" style="width:12%">
													车架号
												</td>

												<td class="common" style="width:23%">

													<input type="text" name="prpLthirdPartyFrameNo" class="input" maxlength=20 description="车架号" value="<bean:write name='thirdParty' property='frameNo'/>" <%=readOnly%> >
												</td>


												<input type="hidden" name="selectSend" value="1">
												<input type="hidden" name="prpLthirdPartySelectSend" value="<bean:write name='thirdParty' property='selectSend'/>">
												<input type="hidden" name="insuredFlag" value="1">
											</tr>
											<tr>
												<td class="common" style="width:10%">
													车辆种类
												</td>
												<td class="common" style="width:20%">
												
													<html:select name="thirdParty" property="carKindCode" styleClass="one">
														<html:options collection="carKindCodes" property="codeCode" labelProperty="codeCName" />
													</html:select>
													
												</td>
												<td class="common" style="width:10%">
													发动机号
												</td>
												<td class="common" colspan=3 style="width:25%">
													<input type="text" name="prpLthirdPartyEngineNo" value="<bean:write name='thirdParty' property='engineNo'/>" class="input" maxlength=20 description="发动机号" <%=readOnly%>>
												</td>
												<td class="title" style="width:12%">
													号牌底色
												</td>
												<td class="input" style="width:23%">
													<html:select name="thirdParty" property="licenseColorCode">
														<html:options collection="licenseColorCodes" property="codeCode" labelProperty="codeCName" />
													</html:select>
												</td>
											</tr>
											<tr>
											
										               <td class="title" style="width:10%">
											          厂牌型号
										               </td>
										               <td id="PartyBrandName" class="common"  style="width:20%">
											           <input type="hidden" <%=readOnly%> name="prpLthirdPartyModelCode" class="codecode" description="厂牌型号"  value="<bean:write name='thirdParty' property='modelCode'/>" 
											              ondblclick="code_CodeSelect(this, 'ModelCode');" 
											              onchange="code_CodeChange(this, 'ModelCode');"
										  	              onkeyup="code_CodeSelect(this, 'ModelCode');">

											           <input   <%=readOnly%> type="text" name="prpLthirdPartyBrandName" class="codename" maxlength=50 description="厂牌型号名称" style="width:90%"  value="<bean:write name='thirdParty' property='brandName'/>" 
											              ondblclick="car_select(this,fm.prpLregistRiskCode.value);"
											              onchange="car_select(this,fm.prpLregistRiskCode.value);" 
											              onkeyup="car_select(this,fm.prpLregistRiskCode.value);">
										                </td>
											
											<!--	<td class="common" style="width:10%">
													厂牌型号
												</td>
												<td class="common" style="width:20%">
													<input type="text" name="prpLthirdPartyBrandName" class="input" value="<bean:write name='thirdParty' property='brandName'/>"  maxlength=30 description="厂牌型号" <%=readOnly%>>
												</td>-->
												<td class="title" style="width:10%">
													承保公司
												</td>
												<td id="ThirdPartyInsureComCodeInput" class="input" colspan=3 style="width:25%">
												    <logic:equal name="thirdParty" property="insureCarFlag" value="1"><!-- 标的车 -->
                                                        <input name="prpLthirdPartyInsureComCode" class="codename" description="承保公司代码" style="width:30%" value="<bean:write name='thirdParty' property='insureComCode'/>"  ondblclick="code_CodeSelect(this, 'InsureComCode');" onkeyup= "code_CodeSelect(this, 'InsureComCode');" <%=readOnly%>>
                                                        <input type="text" name="prpLthirdPartyInsureComName" class="codename" maxlength=50 description="承保公司名称" style="width:55%" value="<bean:write name='thirdParty' property='insureComName'/>" ondblclick="code_CodeSelect(this, 'InsureComCode','-1','always','none','post');"  onkeyup= "code_CodeSelect(this, 'InsureComCode','-1','always','none','post');" <%=readOnly%>>
                                                    </logic:equal>
                                                    <logic:notEqual name="thirdParty" property="insureCarFlag" value="1"><!-- 三者车 -->                                                        
                                                        <input name="prpLthirdPartyInsureComCode" type="text" class="codename" description="承保公司代码" style="width:30%" 
                                                            value="<bean:write name='thirdParty' property='insureComCode'/>" <%=readOnly%>
                                                            ondblclick="code_CodeSelect(this, 'PlatFormComCode','1',null,'','clear');"
                                                            onchange="code_CodeChange(this, 'PlatFormComCode','1',null,'','clear');"
                                                            onkeyup= "code_CodeSelect(this, 'PlatFormComCode','1',null,'','clear');">

                                                        <input type="text" name="prpLthirdPartyInsureComName" class="codename" maxlength=60 description="承保公司名称" style="width:60%" 
                                                            value="<bean:write name='thirdParty' property='insureComName'/>" <%=readOnly%>
                                                            onblur="checkLength(this)"
                                                            ondblclick="code_CodeSelect(this, 'PlatFormComCode','-1','name','none','clear');"
                                                            onchange="code_CodeChange(this, 'PlatFormComCode','-1','name','none','clear');"
                                                            onkeyup= "code_CodeSelect(this, 'PlatFormComCode','-1','name','none','clear');">
                                                    </logic:notEqual>
												</td>
												<td class="common" style="width:12%">
													车辆使用年限
												</td> 
												<td class="common" style="width:23%">
													<input type="input" name="prpLthirdPartyUseYears" class="common" maxlength=5 description="车辆使用年限" value="<bean:write name='thirdParty' property='useYears'/>" <%=readOnly%>>
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
													行驶公里数
												</td>
												<td class="common" style="width:25%" colspan=3>
													<input type="text" name="prpLthirdPartyRunDistance" value="<bean:write name='thirdParty' property='runDistance'/>" class="common" description="车辆已行驶公里数" maxlength=15 <%=readOnly%>>
												</td>
												<!-- modify by wangli update start 20050407 -->
												<td class="common" id="tdDutyPercentTitle" style="width:12%;">
													责任比例
												</td>
												<td class="common" id="tdDutyPercentInput" style="width:23%;">
													<input type="text" name="prpLthirdPartyDutyPercent" class="common" maxlength=6 description="保险车辆对本车责任"  onchange="return isRightDutyPercent(this);" value="<bean:write name='thirdParty' property='dutyPercent'/>" >
													%
												</td>
												<!-- modify by wangli update end 20050407 -->
											</tr>

											<!--Modify by chenrenda add begin 20050417-->
											<!--Reason:赔款费用模块合到涉案车辆中-->
											<%
                if(strThirdPartyNodeType.equals("check")){
                
               String kindAFlag = (String)request.getAttribute("kindAFlag");
              
                 %>
											<tr>
												  <td class="title" style="width:10%">
												  	损失金额
												  </td>
												  <td class="input" style="width:20%">
												  	  <input type="text" name="prpLthirdPartyLossFee" class="common" value="<%=prpLcheckLossDto2.getLossFee()%>" >
												  </td>
												  <%   
												  if( prpLthirdPartyDto2!=null  && ("1".equals(prpLthirdPartyDto2.getInsureCarFlag()))  ){
												     if   ( kindAFlag !=null &&kindAFlag.equals("1") ) {
												            if (!prpLthirdPartyDto2.getLossFlag().equals("0")) prpLthirdPartyDto2.setLossFlag("1");
												       %>
												       <td class="title" >本车是否受损：</td>
                               <td class="input" style="width:10%">
                                  <!--<select name="thirdParty" property="lossFlag" >-->
                                   <select name="prpLthirdPartyLossFlag"  >
                                   	 <option value="" <%= prpLthirdPartyDto2.getLossFlag().equals("")? "selected":"" %> > </option>
                                      <option value="1" <%= prpLthirdPartyDto2.getLossFlag().equals("1") ? "selected":"" %> >是</option>
                                      <option value="0" <%= prpLthirdPartyDto2.getLossFlag().equals("0") ? "selected":"" %> >否</option>
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
         											三者车驾驶员姓名
										</td>
										<td class="input" style="width:25%" colspan=3>
											<input type="text" name="prpLthirdPartyDriveName" class="input" description="三者车驾驶员名称" maxlength=30  value="<bean:write name='thirdParty' property='prpLthirdPartyDriveName'/>" <%=readOnly%> >								    
										    <img src="/claim/images/bgMarkMustInput.jpg">
										</td>

										<%--modify by wangli update start 20050407--%>
										<!--Modify by chenrenda update begin 20050405 在报案时不显示责任比例-->
										<td class="title"  style="width:10%;">
											三者车驾驶员身份证
										</td>
										<td class="input" id="tdDutyPercentInput" style="width:25%;">
											<input type="text" name="prpLthirdPartyDriveLicensNo" class="input"  maxlength=30 description="三者车驾驶员身份证号码" style="width:90%" value="<bean:write name='thirdParty' property='prpLthirdPartyDriveLicensNo'/>" <%=readOnly%> >
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
                                           保单号
                                </td>
                                <td class="input" style="width:20%">
                                   <input type="text" name="prpLthirdPartyCarPolicyNo" class="common" value="<bean:write name='thirdParty' property='carPolicyNo'/>">
                                </td>
                            </tr>
                <%}else{ %>
                            <input type="hidden" name="prpLthirdPartyCarPolicyNo"  value="0" description="保单号">     
                <%} %>
											<tr class=common>
												<td colspan="8" class="common" style="width:92%">
													<table class="common" id="ThirdCarLoss" cellspacing="1" cellpadding="5">
														<thead>
															<tr>
																<td class="centertitle" style="width:15%">
																	损失项目序号
																</td>
																<td class="centertitle" style="width:15%">
																	车牌号
																</td>
																<%
                            if(strThirdPartyNodeType.equals("check")){
                            %>
																<td class="centertitle" style="width:20%">
																	险别
																</td>
																<%}%>
																<td class="centertitle" style="width:15%">
																	损失部位
																</td>
																<td class="centertitle" style="width:15%">
																	零件(项目)名称
																</td>
																<td class="centertitle" style="width:36%">
																	损失程度描述
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
																	(按"+"号键增加损失部位信息，按"-"号键删除信息)
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
																				<input type="hidden" name="prpLthirdCarLossSerialNo" description="序号" value="<bean:write name='thirdCarLossdtox' property='serialNo'/>">
																				<input type="hidden" name="RelateSerialNo" description="序号" value="<bean:write name='thirdCarLossdtox' property='serialNo'/>">
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
																					 onblur="checkLength1(this);" description="损失程度描述">
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
