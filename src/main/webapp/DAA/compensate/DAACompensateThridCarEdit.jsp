<%--
****************************************************************************
* DESC       ：添加互碰时三者的信息
* AUTHOR     ：yangbo
* CREATEDATE ：2008-01-16
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLthirdPartyDto" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpDcodeDto" %>

<script language='javascript'>
      //在下面加入本页自定义的JavaScript方法

        /*
        插入一条新的ThirdParty之后的处理（可选方法）
      */
      function afterInsertThirdCar()
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
<table class="common" cellpadding="5" cellspacing="1" id="tabThridCar" >
    <tr>
     <td class="common" colspan="4" style="text-align:left;">
       <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="ThirdPartyImg" onclick="showPage(this,spanThirdPartyAll)">
			 互碰车辆信息
			<br>
     <span  id="spanThridCar" style="display:none" cellspacing="1" cellpadding="0">
        <%-- 多行输入展现域 --%>
       <table class="common" cellspacing="1" cellpadding="5" id="ThirdCar_Data">
           <tbody>
				<tr>
				    <td class="title" style="width:4%">
						<div align="center">
							<input class="readonlyno" readonly name="prpLthirdPartySerialNo">
							<input type="hidden" class="readonlyno"  name="prpLthirdPartyNewAddFlag" > <!--add by liyanjie 2005-12-18是否是新增的车辆标志 -->
	  
						</div>
					</td>
					  <td>
						<table  class="common" cellspacing="1" cellpadding="5" >
						  <tr>
							<td class="common" style="TEXT-ALIGN: center" colspan=2 style="width:30%">
								<input type="hidden" name="insureCarFlag" value="0">
								<input type="hidden" name="flag" value="1">
								<font color=red>三者车</font>
							</td>
		
							<td class="common" style="width:10%">
								号牌号码
							</td>
							<td class="common" style="valign:bottom" colspan=3 style="width:25%">
								<input name="prpLthirdPartyLicenseNo" class="input"  onblur="checkLength1(this);clearSpace(this);" description="号牌号码">
							</td>
		
							<td class="common" style="valign:bottom" style="width:10%">
								车架号
							</td>
							<td class="common" style="valign:bottom" style="width:25%">
								<input type="text" name="prpLthirdPartyFrameNo" class="input"  maxlength=20 onblur="checkLength(this)" description="车架号">
							</td>
							 
							 <td class="title" style="width:4%" rowspan="3">
								<div align="center">
									<input type=button name="buttonThirdPartyDelete" class=smallbutton onclick="deleteRow(this,'ThirdCar');afterDeleteThirdParty();" value="-" style="cursor: hand">
								</div>
							</td>
		
							<input type="hidden" name="prpLthirdPartySelectSend" value="0">
							<input type="hidden" name="insuredFlag" value="1">
							
							
						</tr>
		
						<tr>
							<td class="common" style="width:10%">
								车辆种类
							</td>
							<td class="common" style="width:20%">
								<html:select name="prpLcompensateDto" property="carKindCode">
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
								<html:select name="prpLcompensateDto" property="licenseColorCode">
									<html:options collection="licenseColorCodes" property="codeCode" labelProperty="codeCName" />
								</html:select>
							</td>
		
						</tr>
						<tr>
					       <td class="title" style="width:10%">
								厂牌型号
							</td>
							<td id="PartyBrandName" class="input"  style="width:20%">
								<input type="hidden" name="prpLthirdPartyModelCode" class="codecode" description="厂牌型号"    
								   ondblclick="code_CodeSelect(this, 'ModelCode');" 
								   onchange="code_CodeChange(this, 'ModelCode');"
							  	   onkeyup="code_CodeSelect(this, 'ModelCode');">
		
								<input type="text" name="prpLthirdPartyBrandName" class="codename" maxlength=50 description="厂牌型号名称" style="width:90%" 
								   ondblclick="car_select(this,fm.prpLcompensateRiskCode.value);"
								   onchange="car_select(this,fm.prpLcompensateRiskCode.value);" 
								   onkeyup="car_select(this,fm.prpLcompensateRiskCode.value);">
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
		                       <td class="title" style="width:10%">
		                               保单号
		                       </td>
		                       <td class="input" style="width:20%">
		                              <input type="text" name="prpLthirdPartyCarPolicyNo" class="common">
		                          </td>
							  </tr>
						   </table>
						</td>
                    </tr>
			</tbody>
		  </table>
		</span>  
		<span id="spanThirdPartyAll" style="display:"> <%-- 多行输入展现域 --%>
			<table class="common" cellspacing="1" cellpadding="5" id="ThirdCar">
				<thead>
						<tr class=listtitle>
							<td style="width:4%">
								序号
							</td>
							<td style="width:96%" colspan="2">
								内容
							</td>
						</tr>
				</thead>
			    <tfoot>		
<%
					if(editType.equals("SHOW")){
%>				
						<tr>
							<td class="title" colspan=3 align="right" style="width:4%">
								<input type="button" class=smallbutton value="+" onclick="insertRow('ThirdCar');" name="buttonThirdPartyInsert" disabled>
							</td>
						</tr>
<%
					}else{
%>
						<tr>
							<td class="title" colspan=3 align="right" style="width:4%">
								<input type="button" class=smallbutton value="+" onclick="insertRow('ThirdCar');" name="buttonThirdPartyInsert">
							</td>
						</tr>
<%
					}
%>
				 </tfoot>
				 <tbody>
		
<% 
	if(request.getAttribute("prpLthirdPartyDtoList") != null){
		ArrayList prpLthirdPartyDtoList = (ArrayList)request.getAttribute("prpLthirdPartyDtoList");	
		for(int i = 0;i < prpLthirdPartyDtoList.size();i++){
			PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)prpLthirdPartyDtoList.get(i); 
			String strReadonlyFlag = "";
			String strSelectReadonlyFlag = "";
			String strCommonFlag = "";
			String strHidden = "";
			String strDisabled = "";
			if(prpLthirdPartyDto.getFlag().equals("1")){
				strReadonlyFlag = "";
				strSelectReadonlyFlag = "";
				strCommonFlag = "common";
				strHidden  = "text";
				strDisabled = "";
			}else{
				strReadonlyFlag = "readonly";
				strCommonFlag = "readonly";
				strHidden = "hidden";
				strDisabled = "disabled";
				strSelectReadonlyFlag = " style='color: #8B8386;' onmousemove='this.setCapture();' onmouseout='this.releaseCapture();' onfocus='this.blur();' ";
			}
			if(editType.equals("SHOW")){
				strHidden = "hidden";
			}
			
%> 
                <tr>
                     <td class="title" style="width:4%">
						<div align="center">
							<input class="readonlyno" readonly name="prpLthirdPartySerialNo" value="<%=prpLthirdPartyDto.getSerialNo() %>">
						    <input type="hidden" class="readonlyno"  name="prpLthirdPartyNewAddFlag" value="old" > <!--add by liyanjie 2005-12-18是否是新增的车辆标志 -->
        
						</div>
					</td>
					<td>
					 <table class="common" cellspacing="1" cellpadding="5">
					   <tr>
							<td class="common" style="TEXT-ALIGN: center" colspan=2 style="width:30%">
								<input type="hidden" name="insureCarFlag" value='<%=prpLthirdPartyDto.getInsureCarFlag() %>'>
								<input type="hidden" name="flag" value='<%=prpLthirdPartyDto.getFlag() %>'>
<%
							if(prpLthirdPartyDto.getInsureCarFlag().equals("1")){
%>
								<font color=red>标的车</font>
<%
							}else{
								
%>  
								<font color=red>三者车</font>
<%
							}
%>
								
							</td>
		
							<td class="common" style="width:10%">
								号牌号码
							</td>
							<td class="common" style="valign:bottom" colspan=3 style="width:25%">
								<input name="prpLthirdPartyLicenseNo" description="号牌号码" value='<%=prpLthirdPartyDto.getLicenseNo() %>' class="common" <%=strReadonlyFlag %>
								<%
									if("readonly".equals(strReadonlyFlag)){
								%>
									style="color: #AAAAAA"
								<%
									}
								%>
								>
								
							</td>
		
							<td class="common" style="valign:bottom" style="width:10%">
								车架号
							</td>
							<td class="common" style="valign:bottom" style="width:25%">
								<input type="text" name="prpLthirdPartyFrameNo" description="车架号" value='<%=prpLthirdPartyDto.getFrameNo() %>' class="common" <%=strReadonlyFlag %>
								<%
									if("readonly".equals(strReadonlyFlag)){
								%>
									style="color: #AAAAAA"
								<%
									}
								%>
								>
							</td>
							<td class="title" style="width:4%" rowspan="3">
								<input type=button name="buttonThirdPartyDelete" class=smallbutton onclick="deleteRow(this,'ThirdCar')" value="-" style="cursor: hand" <%=strDisabled %>>
							</td>
		
							<input type="hidden" name="prpLthirdPartySelectSend" value="0">
							<input type="hidden" name="insuredFlag" value="1">
							
						</tr>
		
						<tr>
							<td class="common" style="width:10%">
								车辆种类
							</td>
							<td>
								<select name="carKindCode" class='common' <%=strSelectReadonlyFlag %>>									
									 <option selected="selected" ></option>
<%
									ArrayList carKindCodes = (ArrayList)request.getAttribute("carKindCodes");
									for(int j=0;j<carKindCodes.size();j++){
										PrpDcodeDto carKindCodeDto = (PrpDcodeDto)carKindCodes.get(j);
%>	
       	 							 <option value="<%=carKindCodeDto.getCodeCode()%>" <%=carKindCodeDto.getCodeCode().equals(prpLthirdPartyDto.getCarKindCode()) ? "selected" : "" %> ><%=carKindCodeDto.getCodeCName() %></option>								
<%
									}
%>
								</select>
							</td>
							<td class="common" style="width:10%">
								发动机号
							</td>
							<td class="common" colspan=3 style="width:25%">
								<input type="text" name="prpLthirdPartyEngineNo" description="发动机号" value='<%=prpLthirdPartyDto.getEngineNo() %>' class="common" <%=strReadonlyFlag %>
								<%
									if("readonly".equals(strReadonlyFlag)){
								%>
									style="color: #AAAAAA"
								<%
									}
								%>
								>
							</td>
							<td class="common" style="width:10%">
								号牌底色
							</td>
							<td class="input" style="width:23%">
								<select name="licenseColorCode" <%=strSelectReadonlyFlag %>>
									<option selected="selected"></option>
<%
									ArrayList licenseColorCodes = (ArrayList)request.getAttribute("licenseColorCodes");
									for(int j=0;j<licenseColorCodes.size();j++){
										PrpDcodeDto licenseColorCodeDto = (PrpDcodeDto)licenseColorCodes.get(j);
%>										
									 <option value="<%=licenseColorCodeDto.getCodeCode()%>" <%=licenseColorCodeDto.getCodeCode().equals(prpLthirdPartyDto.getLicenseColorCode()) ? "selected" : "" %>><%=licenseColorCodeDto.getCodeCName() %></option>								
<%
									}
%>								
								<select>
							</td>
		
						</tr>
		
						<tr>
					       <td class="title" style="width:10%">
								厂牌型号
							</td>
							<td id="PartyBrandName" class="input"  style="width:20%">
								<input type="hidden" name="prpLthirdPartyModelCode"  value='<%=prpLthirdPartyDto.getModelCode() %>' class="codecode" description="厂牌型号" 
								   ondblclick="code_CodeSelect(this, 'ModelCode');" 
								   onchange="code_CodeChange(this, 'ModelCode');"
							  	   onkeyup="code_CodeSelect(this, 'ModelCode');">
		
								<input type="text" name="prpLthirdPartyBrandName"  value='<%=prpLthirdPartyDto.getBrandName() %>' class="codename" maxlength=50 description="厂牌型号名称" 
								   <% 
								   if(!"readonly".equals(strReadonlyFlag)){ 
								   %>
								   ondblclick="car_select(this,fm.prpLcompensateRiskCode.value);"
								   onchange="car_select(this,fm.prpLcompensateRiskCode.value);" 
								   onkeyup="car_select(this,fm.prpLcompensateRiskCode.value);"
								   style="width:90%"
								   <% 
								   }else{
								   %>
								    style="color: #AAAAAA;width:90%"
								   <%
								   }
								   %>
								   >
							</td>
							<td class="title" style="width:10%">
								承保公司
							</td>
							<td id="ThirdPartyInsureComCodeInput" class="input" colspan=3 style="width:25%">
								<input <%=strReadonlyFlag %> name="prpLthirdPartyInsureComCode" type="<%=strHidden %>" value='<%=prpLthirdPartyDto.getInsureComCode() %>' class="codename" description="承保公司代码" style="width:30%"  
			                      <% 
								   if(!"readonly".equals(strReadonlyFlag)){ 
								   %>                     
                                       ondblclick="code_CodeSelect(this, 'PlatFormComCode','1',null,'','clear');"
                                       onchange="code_CodeChange(this, 'PlatFormComCode','1',null,'','clear');"
                                       onkeyup= "code_CodeSelect(this, 'PlatFormComCode','1',null,'','clear');"
                                       style="width:90%"
								   <% 
								   }else{
								   %>
								       style="color: #AAAAAA;width:90%"
								   <%
								   }
								   %>
								   >    
                                 <input <%=strReadonlyFlag %> type="text" name="prpLthirdPartyInsureComName"  value='<%=prpLthirdPartyDto.getInsureComName()%>' class="codename" maxlength=60 description="承保公司名称" style="width:60%"
                                    <% 
								   if(!"readonly".equals(strReadonlyFlag)){ 
								   %>       
                                      onblur="checkLength(this)"
                                      ondblclick="code_CodeSelect(this, 'PlatFormComCode','-1','name','none','clear');"
                                      onchange="code_CodeChange(this, 'PlatFormComCode','-1','name','none','clear');"
                                      onkeyup= "code_CodeSelect(this, 'PlatFormComCode','-1','name','none','clear');"
                                      style="width:90%"
								   <% 
								   }else{
								   %>
								      style="color: #AAAAAA;width:90%"
								   <%
								   }
								   %>
                                 >
		                      </td>
		                    <td class="title" style="width:10%">
		                            保单号
		                    </td>
		                    <td class="input" style="width:25%">
		                       <input type="text" name="prpLthirdPartyCarPolicyNo" description="保单号" style="width:60%" value='<%=prpLthirdPartyDto.getCarPolicyNo()%>' class="common" <%=strReadonlyFlag %>
		                       <%
									if("readonly".equals(strReadonlyFlag)){
								%>
									style="color: #AAAAAA"
								<%
									}
								%>
		                       >		
		                    </td>
		                </tr>
		           </table>
		        </td>
		       </tr>

<%   }
   } 
%> 
		</tbody>
    </table></span>
   </td>
  </tr>
</table>









