<%--
****************************************************************************
* DESC       ���������Ϣ�ӿ����ҳ��
* AUTHOR     �� weishixin
* CREATEDATE �� 2004-02-29
* MODIFYLIST ��   Name       Date            Reason/Contents
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
*          ------------------------------------------------------
****************************************************************************
--%>
<%-- add by zhulei begin 20050711 ��¼�����ڸ�ʽ��У�飬Ҫ���ϸ�YYYYMMDD��YYYY-MM-DD��ʽ�������λҪ��0 --%>
<!--modify by liuyanmei add 20051114 start-->
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%
	//ȡ����ϵͳ�ĵ�ַ
	String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");

	//add by lym 20060604 for ǿ�� -----start  //
	String quaryPolicyNo = (String) request
			.getAttribute("quaryPolicyNo");
	//System.out.println("   quaryPolicyNo  =   [ "  + quaryPolicyNo +  " ]"); 

	String mainPolicyNo = (String) request.getAttribute("mainPolicyNo");
	String qsFlag = (String) request.getAttribute("qsFlag");
	String intPayFee = (String) request.getAttribute("intPayFee");
	String qs_PerilCount = (String) request
			.getAttribute("intPerilCount");
	String qs_RecentCount = (String) request
			.getAttribute("intRecentCount");
	String isStoppingCI = (String) request.getAttribute("isStoppingCI");//��ǿ����ͣʻ�ڼ��ڵñ�־
	String isStoppingBusiness = (String) request
			.getAttribute("isStoppingBusiness");//��ҵ����ͣʻ�ڼ��ڵı�־
	String isValidRelatedFlag = (String) request
			.getAttribute("isValidRelatedFlag");//��ҵ�ա���ǿ����Ч��������ı�־
	//  System.out.println("   ǿ��������mainPolicyNo  =   [ "  + mainPolicyNo +  " ]");
	//  System.out.println("   ǿ����־qsFlag        =   [ "  + qsFlag +  " ]");
	//add by lym 20060604 for ǿ�� -----end

	PrpLregistDto prpLregistDto = (PrpLregistDto) request
			.getAttribute("prpLregistDto");
	int intstartHour = 0;
	int intendHour = 0;
	String startHour = "";
	String endHour = "";
	intstartHour = prpLregistDto.getStartHour();
	intendHour = prpLregistDto.getEndHour();
	if (intstartHour == 0) {
		startHour = "��ʱ����";
	} else if (intstartHour == 12) {
		startHour = "ʮ��ʱ����";
	} else if (intstartHour == 24) {
		startHour = "��ʮ��ʱ��";
	}

	if (intendHour == 12) {
		endHour = "ʮ��ʱֹ";
	} else if (intendHour == 24) {
		endHour = "��ʮ��ʱֹ";
	} else if (intendHour == 0) {
		endHour = "��ʱֹ";
	}
%>
<!--modify by liuyanmei add 20051114 end-->
<script>
//�������������
function checkFullDate(field)
{
  field.value = trim(field.value);
  var strValue = field.value;
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;
  if(strValue=="")
  {
    return false;
  }
  if(strValue.length != 8 && strValue.length != 10)
  {
    errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD�������λҪ��0");
    field.focus();
    field.select();
    return false;
  }
  if(isNumeric(strValue ))
  {
     if(strValue.length == 8)
    {
      strValue = strValue.substring(0,4) + DATE_DELIMITER + strValue.substring(4,6) + DATE_DELIMITER + strValue.substring(6);
      field.value = strValue;
    }
    else
    {
     errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD");
       field.value="";
       field.focus();
       field.select();
       return false;
    }
  }
  if( !isDate(strValue,DATE_DELIMITER) && !isDate(strValue)||strValue.substring(0,1)=="0")
  {
    errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD");
    field.value="";
    field.focus();
    field.select();
    return false;
  }
  return true;
}

//���������Ƿ������ֵ�У��
function isNumeric(strValue)
{
  var result = regExpTest(strValue,/\d*[.]?\d*/g);
  return result;
}

//RegExt Test

//���������Ƿ�ʱ���ֵ�У�飬���������֣��򵯳�����ȷ�Ͽ�
function checkNumberInput(field){
    field.value = trim(field.value);
    var strValue = field.value;
    if(!isInteger(strValue)){
        errorMessage("������Ϸ�������");       
        field.focus();
        field.select();
        return false;
    }   
    return true;
}

//��ʧ���͵Ĵ���
function checkBox(field){

var prpLextFlag = fm.prpLextFlag.value;
var strField    = field.value+',';
  if(field.checked){   
     fm.prpLextFlag.value=prpLextFlag+strField;
    if((field.value=='4')){
      fm.prpLregistPersonInjureD1.style.display="";
      fm.prpLregistPersonDeathD1.style.display="";
     }else if((field.value=='5')){
      fm.prpLregistPersonInjureB.style.display="";
      fm.prpLregistPersonDeathB.style.display="";
     } 
    }
   else{
      fm.prpLextFlag.value = prpLextFlag.replace(strField,'');
      if((field.value=='4')){
      fm.prpLregistPersonInjureD1.style.display="none";
      fm.prpLregistPersonDeathD1.style.display="none";
      fm.prpLregistPersonInjureD1.value='0';
      fm.prpLregistPersonDeathD1.value='0';
    }else if((field.value=='5')){
      fm.prpLregistPersonInjureB.style.display="none";
      fm.prpLregistPersonDeathB.style.display="none";
      fm.prpLregistPersonInjureB.value='0';
      fm.prpLregistPersonDeathB.value='0';
    } 
   }
}

function regExpTest(source,re)
{
  var result = false;

  if(source==null || source=="")
    return false;

  if(source==re.exec(source))
    result = true;

  return result;
}

//�������򰴼�ʱ������У��
function pressFullDate(e)
{
  var value = String.fromCharCode(e.keyCode);
  if((value>=0 && value<=9) || value=="/" || value=="-")
    return true;
  else
    return false;
}

//���������Ƿ������ڵ�У�飬splitChar����ȱʡΪ"-"
function isDate(date,splitChar)
{
  var charSplit = (splitChar==null?"-":splitChar);
  var strValue = date.split(charSplit);

  if(strValue.length!=3) return false;

  var intYear  = parseInt(strValue[0],10);
  var intMonth = parseInt(strValue[1],10)-1;
  var intDay   = parseInt(strValue[2],10);

  var dt = new Date(intYear,intMonth,intDay);
  if( dt.getFullYear() != intYear ||
      dt.getMonth() != intMonth ||
      dt.getDate() != intDay
     )
  {
    return false;
  }
  return true;
}

function changeLxr()
{
  var prpLregistReportorName  = fm.prpLregistReportorName.value;
  
  if(trim(fm.prpLregistLinkerName.value).length==0){
    fm.prpLregistLinkerName.value=prpLregistReportorName;
  }
}
</script>
<%-- add by zhulei end 20050711 ��¼�����ڸ�ʽ��У�飬Ҫ���ϸ�YYYYMMDD��YYYY-MM-DD��ʽ�������λҪ��0 --%>
    
    <table cellpadding="5" cellspacing="1" class="common">
    <tr>
       <td>
         <%@include file="/common/pub/MessageButton.jsp" %>
       </td>
    </tr>   
    </table>
    <br>
    <table  class=common cellpadding="5" cellspacing="1">
      <tr class=listtitle>
        <td colspan="4">�����Ǽ�
        <logic:notEqual name="prpLregistDto" property="cancelDate" value="">
                 (��ע��)
        </logic:notEqual>
         <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
         <!--  add  by  lym 20060604 for ǿ��  start --> 
          <!--input type="hidden" name="mainPolicyNo" value="<%=mainPolicyNo%>"-->
          <input type="hidden" name="qsFlag" value="<%=qsFlag%>" onblur="initSet();initSet_qs();">
          <input type=hidden name="qs_prpLregistStartDate" title="������" class="readonly" style="width:80px" readonly="true"  value="<bean:write name='qs_prpCmainDto' property='startDate' filter='true' />">
          <input type=hidden name="qs_prpLregistEndDate"   title="�ձ�����" class="readonly" style="width:80px" readonly="true"   value="<bean:write name='qs_prpCmainDto' property='endDate' filter='true' />">
          <input type=hidden name="qs_prpLregistUnderWriteDate"   title="�˱�����" class="readonly" style="width:80px" readonly="true"   value="<bean:write name='qs_prpCmainDto' property='underWriteEndDate' filter='true' />">
          <input type="hidden" name="qs_prpLregistPayFee" value="<%=intPayFee%>">  
          <input type="hidden" name="qs_PerilCount" value="<%=qs_PerilCount%>">  
          <input type="hidden" name="qs_RecentCount" value="<%=qs_RecentCount%>"> 
            <input type="hidden" name="quaryPolicyNo" value="<%=quaryPolicyNo%>"> 
           <input type="hidden" name="isStoppingCI" value="<%=isStoppingCI%>"> 
            <input type="hidden" name="isStoppingBusiness" value="<%=isStoppingBusiness%>"> 
            <input type="hidden" name="isValidRelatedFlag" value="<%=isValidRelatedFlag %>">
            <input type="hidden" name="immediateValidPeriod" value="<%=request.getAttribute("immediateValidPeriod") %>">
         <!--  add  by  lym 20060604 for ǿ��  end --> 
        
          <input type="hidden" name="prpLregistLFlag" value="<bean:write name='prpLregistDto' property='LFlag' />">
          <input type="hidden" name="prpLregistRiskCode"  value="<bean:write name='prpLregistDto' property='riskCode' />">
          <input type="hidden" name="prpLregistClassCode" value="<bean:write name='prpLregistDto' property='classCode' />">
          <input type="hidden" name="prpLregistLanguage" value="<bean:write name='prpLregistDto' property='language' />">
          <input type="hidden" name="prpLregistEstiCurrency" value="<bean:write name='prpLregistDto' property='estiCurrency' />">
          <input type="hidden" name="prpLregistLicenseNo" value="<bean:write name='prpLregistDto' property='licenseNo' />">
          <input type="hidden" name="prpLregistLicenseColorCode" value="<bean:write name='prpLregistDto' property='licenseColorCode' />">
          <input type="hidden" name="prpLregistCarKindCode" value="<bean:write name='prpLregistDto' property='carKindCode' />">
          <input type="hidden" name="prpLregistModelCode" value="<bean:write name='prpLregistDto' property='modelCode' />">
          <input type="hidden" name="prpLregistEngineNo" value="<bean:write name='prpLregistDto' property='engineNo' />">
          <input type="hidden" name="prpLregistFrameNo" value="<bean:write name='prpLregistDto' property='frameNo' />">
          <input type="hidden" name="prpLregistRunDistance" value="<bean:write name='prpLregistDto' property='runDistance' />">
          <input type="hidden" name="prpLregistUseYears" value="<bean:write name='prpLregistDto' property='useYears' />">
          <input type="hidden" name="prpLregistBrandName" value="<bean:write name='prpLregistDto' property='brandName' />">
          <input type="hidden" name="prpLregistTypeForDriver" value="Regist">
          <input type="hidden" name='prpLregistEditType' value="<bean:write name='prpLregistDto' property='editType' />">
          <input type="hidden" name='prpLregistDrivingLicenseNo'>
          <input type="hidden" name='prpLregistDrivingName' >
          <input type="hidden" name='prpLregistDrivingSex'>
          <input type="hidden" name='prpLregistDrivingIdentifyNumber' >
          <input type="hidden" name='prpLregistDrivingAge'>
          <input type="hidden" name='prpLregistDrivingOccupation'>
          <input type="hidden" name='prpLregistDrivingOccupationName'>
          <input type="hidden" name='prpLregistDrivingEducation'>
          <input type="hidden" name='prpLregistDrivingEducationName'>
          <input type="hidden" name='prpLregistLossName' value="<bean:write name='prpLregistDto' property='lossName' />">
          <input type="hidden" name='prpLregistDrivingUnitAddress'>
          <input type="hidden" name='prpLregistDrivingReceiveLicenseDate'>
          <input type="hidden" name='prpLregistDrivingCarType'>
          <input type="hidden" name='prpLregistDrivingAwardLicenseOrgan'>
          <%--���뱨�������������� add by qinyongli--%>
          <logic:notEmpty name="configValue"  >
          <input type="hidden" name='configValue' value="<bean:write name='configValue' />">
          </logic:notEmpty>
          <logic:empty name="configValue"  >
          <input type="hidden" name='configValue' value="99999">
          </logic:empty>
          <input type="hidden" name='riskcode' value="<bean:write name='prpLregistDto' property='riskCode' />">
          <input type="hidden" name='policyno' value="<bean:write name='prpLregistDto' property='policyNo' />">
          <input type="hidden" name='prpLregistPayFee' value="<bean:write name='prpLregistDto' property='payFlag'/>">
          <input type="hidden" name="RecentCount" value="<bean:write name='prpLregistDto1' property='recentCount' filter='true' />">
          <input type="hidden" name="RegistViewLimitDay" value="<%= AppConfig.get("sysconst.RegistViewLimitDay") %>">
          <input type="hidden" name="prpLregistFlowInTime" value="<bean:write name='prpLregistDto' property='flowInTime' filter='true' />">
          <input type="hidden" name="prpLregistSignDate" value="<bean:write name='prpLregistDto' property='signDate' />">
          <input type="hidden" name="prpLregistUnderWriteEndDate" value="<bean:write name='prpLregistDto' property='underWriteEndDate' />">
          <input type="hidden" name="prpLregistOthFlag" value="<bean:write name='prpLregistDto' property='othFlag' />">
          <input type=hidden name="prpLregistInsuredCode"  value="<bean:write name='prpLregistDto' property='insuredCode' filter='true' />">
          <input type=hidden name="prpLregistHandler1Code" value="<bean:write name='prpLregistDto' property='handler1Code' filter='true' />">
          <input type=hidden   name="prpLregistHandler1Name"  value="<bean:write name='prpLregistDto' property='handler1Name' filter='true' />">
          <input type=hidden name="prpLregistAgentCode" value="<bean:write name='prpLregistDto' property='agentCode' filter='true' />">
          <input type=hidden name="prpLregistAgentName"  value="<bean:write name='prpLregistDto' property='agentName' filter='true' />"/>
          <input type=hidden name="prpLregistInsuredAddress"  value="<bean:write name='prpLregistDto' property='insuredAddress' filter='true' />">
          <input type="hidden" name="editType" value="<%=editType %>" />
          <% 
          	 PrpLregistDto prpLregistDto1= (PrpLregistDto)request.getAttribute("prpLregistDto");
             String checkExtFlag = "";
             //���Ϊ��  Ĭ��ѡ���һ�� "����"
	         if("".equals(prpLregistDto1.getFlag()))
             {
	        	 checkExtFlag = "checked";
          %>
		          <input type=hidden name="prpLextFlag"  value="1,">
          <%    
             }else
             {
             %>
            	 <input type=hidden name="prpLextFlag"  value="<bean:write name='prpLregistDto' property='flag' filter='true' />">
             <%     
          }
	     %>
          <input type=hidden name="prpLregistIndemnityDuty"  value="<bean:write name='prpLregistDto' property='indemnityDuty' filter='true' />">
         
        
        </td>
      </tr>
      <tr>
        <td class="title" ><bean:message key="db.prpLregist.registNo" />:</td>
        <td class="input" >
          <input type=text name="prpLregistRegistNo" class="readonly" readonly="true" value="<bean:write name='prpLregistDto' property='registNo' filter='true' />">
        </td>
        <td class="title" style="width:15%" ><bean:message key="db.prpLregist.policyNo" />:</td>
        <td class="input" style="width:35%" >
          <input type=text name="prpLregistPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLregistDto' property='policyNo' filter='true' />">
           <!--  add  by  lym 20060604 for ǿ��  start --> 
          <input type="text" name="mainPolicyNo"  class="readonly" readonly="true" value="<%=mainPolicyNo%>">
          <!--  add  by  lym 20060604 for ǿ��  end --> 
          
        </td>
      </tr>
      <tr>
        <td class="title" >���ƺ�:</td>
        <td class="input" >
          <input type=text name="prpLregistLicenseNo" class="readonly" readonly="true" value="<bean:write name='prpLregistDto' property='licenseNo' filter='true' />">
        </td>
        <td class="title" style="width:15%" >���Ƴ���:</td>
        <td class="input" style="width:35%" >
          <input type=text name="prpLregistBrandName" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLregistDto' property='brandName' filter='true' />">
        </td>
      </tr>
      <tr>
        <td class="title"><bean:message key="db.prpLregist.insuredName" />:</td>
        <td class="input">
          <input type=text name="prpLregistInsuredName" maxlength="60" title="������������" class="readonly" readonly="true"  value="<bean:write name='prpLregistDto' property='insuredName' filter='true' />">          
        </td>
        <td class="title">��������:</td>
        <td class="input">
          <input type=hidden name="prpLregistComCode" value = "<bean:write name='prpLregistDto' property='comCode' filter='true' />">
          <input type=text   name="prpLregistComName" title="��������" class="readonly" readonly="true" value = "<bean:write name='prpLregistDto' property='comName' filter='true' />">
        </td>
      </tr>
      <tr>
        <td class="title">�����ڼ�:</td>
        <td class="input" >
          <input type=text name="prpLregistStartDate" title="������" class="readonly" style="width:80px" readonly="true"  value="<bean:write name='prpLregistDto' property='startDate' filter='true' />"><%=startHour%>
          <input type=text name="prpLregistEndDate"   title="�ձ�����" class="readonly" style="width:80px" readonly="true"   value="<bean:write name='prpLregistDto' property='endDate' filter='true' />"><%=endHour%>          
        </td>
        <td class="title">�ѳ��մ���:</td>
        <td class="input">
        <%-- ������Ϣ���� --%>
           <%@include file="/DAA/regist/DAAExistRegist.jsp"%>
        </td>
      </tr>     
      <tr>
        <td class="title"></td>
        <td class="input" colspan='1'></td>
        <td class="input" colspan='3' align="center">
          <input type="hidden" name="damageDate" value="<%= request.getParameter("damageDate")%>">         
          
         	     
       </td>     
      </tr>
      <tr style='display:none'>
        <td class="title" ><bean:message key="db.prpLregist.clauseType" />:</td>
          <td class="input" colspan=3>
          <input type=text name="prpLregistClauseType" style="width:30px" class="readonly" readonly="true"  value="<bean:write name='prpLregistDto' property='clauseType' filter='true' />">
          <input type=text name="prpLregistClauseName" style="width:300px" class="readonly" readonly="true"  value="<bean:write name='prpLregistDto' property='clauseName' filter='true' />">
        </td>
      </tr>
      <%
      //modify by lixiang modify end 2005-06-18
      %>
   
      <tr>
        <td class="title" colspan="4" width="100%">     
            <%--��Ԫ����ʾ�����ձ���Լ��Ϣ--%>
            <%--@include file="/DAA/regist/DAARegistPolicyRiskEdit.jsp" --%>
            <%--@include file="/DAA/compensate/DAACompensateCengage.jsp"--%>       
        </td>
      </tr>
      <tr>
        <td class="title">����ʱ��:</td>
        <td class="input">
          <input type=text name="prpLregistDamageStartDate" title="����ʱ��" class="Wdate" maxlength="10" style="width:80px" value="<bean:write name='prpLregistDto' property='damageStartDate' filter='true' />" onKeyPress="pressFullDate(this)" onblur="checkFullDate(this)" onchange="checkFullDate(this);flashPageByTime();">
            <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.prpLregistDamageStartDate', '2007', '2017')"> -->��
<%
 if (editType.equals("ADD"))
  {
%>
		  <input type=text name="prpLregistDamageStartHour" title="����Сʱ" class="input" maxlength="2" style="width:20px" 
          		onchange="flashPageByTime();"
          		onblur="checkHour(this);"
          		onKeyPress="pressInteger(event)" >ʱ
          <input type=text name="prpLregistDamageStartMinute" title="���շ���" class="input" maxlength="2" style="width:20px"  
          		onchange="flashPageByTime();"
          		onblur="checkMin(this);"
          		onKeyPress="pressInteger(event)" >��
<%}else{ %>
		<input type=text name="prpLregistDamageStartHour" title="����Сʱ" class="input" maxlength="2" style="width:20px" value="<bean:write name='prpLregistDto' property='damageStartHour' filter='true' />" 
          		onchange="flashPageByTime();"
          		onblur="checkHour(this);"
          		onKeyPress="pressInteger(event)" >ʱ
          <input type=text name="prpLregistDamageStartMinute" title="���շ���" class="input" maxlength="2" style="width:20px" value="<bean:write name='prpLregistDto' property='damageStartMinute' filter='true' />"  
          		onchange="flashPageByTime();"
          		onblur="checkMin(this);"
          		onKeyPress="pressInteger(event)" >��
<%
}
%>
					
          <img src="/claim/images/bgMarkMustInput.jpg">
          <input type="hidden" name="flashPageFlag" value ="1">
          <img src="/claim/images/bgmore.gif" style='cursor: hand' onmousemove="showSpan_message();" onmouseout="hiddenSpan_message();" alt="��ʾϵͳ��ʾ">
          <span id="span_message" style="width:520; display:none;position:absolute; background-color:#0000FF;">
		      <table class="common"  cellspacing="0" cellpadding="0" border="1" style="background-color: #EFF1Fe;border-color: 436EEE;border-width: 1">
			      	<tr style="border-width: 0">
				      	<td class="" colspan="2" style="color: red">
				             ϵͳ��ʾ��<br><span id="message" rows="2" cols="20" description="������Ϣ"></span>
				        </td>
				   	</tr>
		      </table>
		    </span>
        </td>
       <td class="title"><bean:message key="db.prpLregist.damageAddress" />:</td>
         <td class="input">
          <input type=text name="prpLregistDamageAddress" title="���յ�" maxlength="60" Class="input" style="width:120px" value="<bean:write name='prpLregistDto' property='damageAddress' filter='true' />">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        </tr>
     <%--modify by wangli update end 20050416--%>

      <tr>
        <td class="title"><bean:message key="db.prpLregist.reportorName" />:</td>
        <td class="input">
            <input type=text onchange='changeLxr();' name="prpLregistReportorName" title="������" class="input"  maxlength="20" style="width:120px"  value="<bean:write name='prpLregistDto' property='reportorName' filter='true'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title"><bean:message key="db.prpLregist.linkerName" />:</td>
        <td class="input">
            <input type=text name="prpLregistLinkerName" title="��ϵ��" class="input"  maxlength="20" style="width:120px" value="<bean:write name='prpLregistDto' property='linkerName' filter='true' />"/>
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>

      <tr>
      <td class="title"><bean:message key="db.prpLregist.phoneNumber" />:</td>
        <td class="input">
          <input type=text name="prpLregistPhoneNumber" title="��ϵ�绰" maxlength="20" class="input" style="width:120px" value="<bean:write name='prpLregistDto' property='phoneNumber' filter='true' />">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title">�ƶ��绰:</td>
        <td class="input"><input type=text name="prpLregistReportorPhoneNumber" class="input"  maxlength="11" style="width:120px"  value="<bean:write name='prpLregistDto' property='reportorPhoneNumber' filter='true' />"></td>
      </tr>
      <tr>     
        <td class="title"><bean:message key="db.prpLregist.damageCode" />:</td>      
       <!--Reason:���ݴ���������ԭ�����ȼ�������-->
        <td class="input">        
         <logic:notEmpty  name="prpLregistDto"  property="linkerName"> 
           <input type="hidden" class="codecode" name="prpLregistDamageCode"  style="width:40px" title="����ԭ��" value="<bean:write name='prpLregistDto' property='damageCode' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode');"
             onchange="code_CodeChange(this, 'DamageCode');"
             onkeyup= "code_CodeSelect(this, 'DamageCode');">
           <input type=text class="codecode" name="prpLregistDamageName"  title="����ԭ��" style="width:125px" value="<bean:write name='prpLregistDto' property='damageName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1','name','post','clear');"
             onchange="code_CodeChange(this, 'DamageCode','-1','name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','name','post','clear');"
             onclick = "clearInput(this);">
         </logic:notEmpty>      
         <logic:empty  name="prpLregistDto"  property="linkerName">
           <input type="hidden" class="codecode" name="prpLregistDamageCode"  style="width:40px" title="����ԭ��"
       value="<bean:write name='prpLregistDto' property='damageCode' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode');"
             onchange="code_CodeChange(this, 'DamageCode');"
             onkeyup= "code_CodeSelect(this, 'DamageCode');">
           <input type=text class="codecode" name="prpLregistDamageName"  title="����ԭ��" style="width:125px"
            value="<bean:write name='prpLregistDto' property='damageName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1','name','post','clear');"
             onchange="code_CodeChange(this, 'DamageCode','-1','name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','name','post','clear');"
             onclick = "clearInput(this);">
         </logic:empty> 
          <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
         <td class="title"><bean:message key="db.prpLregist.damageAreaCode" />:</td>
              <td class="input">
        <input type="hidden" name="prpLregistDamageAreaCode" class="codecode" style="width:40px" title="��������" value="<bean:write name='prpLregistDto' property='damageAreaCode' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageAreaCode');"
             onchange="code_CodeChange(this, 'DamageAreaCode');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode');">
        <input type=text name="prpLregistDamageAreaName" class="codecode" style="width:125px" title="��������"  value="<bean:write name='prpLregistDto' property='damageAreaName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageAreaCode','-1','name','post','clear');"
             onchange="code_CodeChange(this, 'DamageAreaCode','-1','name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode','-1','name','post','clear');"
             onclick = "clearInput(this);">
        <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
        <img src="/claim/images/bgMarkMustInput.jpg">
        </td>      
      </tr>
      <tr>
        <td class="title"><bean:message key="db.prpLregist.damageAddressType" />:</td>
        <td class="input">
            <html:select name="prpLregistDto" property="damageAddressType" styleClass="three" style="width:120px">
              <html:options collection="damageAddressTypes" property="codeCode"   labelProperty="codeCName"/>
          </html:select>
        </td>
       <%
       	//modify by lixiang remark 20050308 start
       	//reason:���յ��ʱ�ĳ�ͨѶ��ַ�ʱ�
       %>

        <td class="title">����ʱ��:</td>
        <%
        //modify by lixiang remark 20050308 end
        %>

        <td class="input">
          <input type=text name="prpLregistReportDate" class="input"  maxlength="10" style="width:80px"  value="<bean:write name='prpLregistDto' property='reportDate' filter='true' />"onblur="checkFullDate(this)">��
          <input type=text name="prpLregistReportHour" class="input" maxlength="2" style="width:20px"  value="<bean:write name='prpLregistDto' property='reportHour' filter='true' />"
          		onblur="checkHour(this);"
          		onKeyPress="pressInteger(event)" >ʱ
          <input type=text name="prpLregistReportMinute" class="input" maxlength="2" style="width:20px"  value="<bean:write name='prpLregistDto' property='reportMinute' filter='true' />"
          		onblur="checkMin(this);"
          		onKeyPress="pressInteger(event)" >��
          <img src="/claim/images/bgMarkMustInput.jpg">
          <input type=hidden name="prpLregistDamageAreaPostCode" value="<bean:write name='prpLregistDto' property='damageAreaPostCode' filter='true' />">
          <input type=hidden name="prpLregistCurrentDate" class="input"  maxlength="10" style="width:80px"  value="<bean:write name='prpLregistDto' property='reportDate' filter='true' />">
        </td>
      </tr>

      <tr>
         <td class="title">��ʧ����:</td>
         <td colspan="3" class="input">
          <%  
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>    
           <input type="checkbox" name="prpLregistSS" id="prpLregistSS" value="1" disabled >����
           <input type="checkbox" name="prpLregistSS" id="prpLregistSS"   value="2" disabled>���� 
           <input type="checkbox" name="prpLregistSS" id="prpLregistSS"   value="3" disabled>����
           <input type="checkbox" name="prpLregistSS" id="prpLregistSS"   value="4" disabled>������<input style="display:none"  type=text name="prpLregistPersonInjureD1" class="input" style="width:40px;align:center" value="<bean:write name='prpLregistDto' property='personInjureD1' filter='true' />"  onblur="checkNumberInput(this)">�ˣ���<input style="display:none"  type=text name="prpLregistPersonDeathD1" class="input" style="width:40px" value="<bean:write name='prpLregistDto' property='personDeathD1' filter='true' />"  onblur="checkNumberInput(this)">��      
           <input type="checkbox" name="prpLregistSS" id="prpLregistSS"   value="5" disabled>������<input style="display:none"  type=text name="prpLregistPersonInjureB" class="input" style="width:40px;align:center" value="<bean:write name='prpLregistDto' property='personInjureB' filter='true' />"  onblur="checkNumberInput(this)">�ˣ���<input style="display:none"  type=text name="prpLregistPersonDeathB" class="input" style="width:40px" value="<bean:write name='prpLregistDto' property='personDeathB' filter='true' />" onblur="checkNumberInput(this)">��
           
 <%}else{%>
           <input type="checkbox" name="prpLregistSS" id="prpLregistSS" <%=checkExtFlag %>  value="1" onclick="checkBox(this)">����
           <input type="checkbox" name="prpLregistSS" id="prpLregistSS"  value="2" onclick="checkBox(this)">���� 
           <input type="checkbox" name="prpLregistSS" id="prpLregistSS"  value="3" onclick="checkBox(this)">����
           <input type="checkbox" name="prpLregistSS" id="prpLregistSS"  value="4" onclick="checkBox(this)">������<input style="display:none" type=text name="prpLregistPersonInjureD1" class="input" style="width:40px;align:center" value="<bean:write name='prpLregistDto' property='personInjureD1' filter='true' />"  onblur="checkNumberInput(this)">�ˣ���<input style="display:none" type=text name="prpLregistPersonDeathD1" class="input" style="width:40px" value="<bean:write name='prpLregistDto' property='personDeathD1' filter='true' />"  onblur="checkNumberInput(this)">��      
           <input type="checkbox" name="prpLregistSS" id="prpLregistSS"  value="5" onclick="checkBox(this)">������<input style="display:none" type=text name="prpLregistPersonInjureB" class="input" style="width:40px;align:center" value="<bean:write name='prpLregistDto' property='personInjureB' filter='true' />"  onblur="checkNumberInput(this)">�ˣ���<input style="display:none" type=text name="prpLregistPersonDeathB" class="input" style="width:40px" value="<bean:write name='prpLregistDto' property='personDeathB' filter='true' />" onblur="checkNumberInput(this)">��
             
<%}%>  
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr> 
      <tr>
        <td class="title">�¹�����:</td>
        <td  class="input">
        <select name="indemnityDuty"
			style="width:120px">
			<option value="0" selected="selected">ȫ��</option>
			<option value="1">����</option>
			<option value="2">ͬ��</option>
			<option value="3">����</option>
			<option value="4">����</option>
			<option value="9">����</option>
		</select>
          <%  
  if (!editType.equals("ADD"))
  {
%>  
      <script type="text/javascript">
          var strPrpLregistSS = document.getElementsByName("prpLregistSS");
          var strFlag = fm.prpLextFlag.value;
          var arr =strFlag.split(",");
          for(var i=0; i <arr.length; i++){
            for(var j=0; j<strPrpLregistSS.length;j++){
               if(arr[i] == strPrpLregistSS[j].value){
                  strPrpLregistSS[j].checked = true;
                  if((arr[i]=='4')){
                     fm.prpLregistPersonInjureD1.style.display="";
                     fm.prpLregistPersonDeathD1.style.display="";
                    }else if((arr[i]=='5')){
                                fm.prpLregistPersonInjureB.style.display="";
                                fm.prpLregistPersonDeathB.style.display="";
                              }
                }
            }
          }

		  var  duty = fm.prpLregistIndemnityDuty.value;
		  var  count = fm.indemnityDuty.length;
          var i; 
          for( i = 0; i < count; i ++){
            if(fm.indemnityDuty[i].value == duty){
               fm.indemnityDuty.selectedIndex = i;
               break;
             }
          }     
		</script>
	<%}%>  	
		 
          <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td> 
               
        <td class="title">�ⰸ���:</td> 
        <td class="input">
          <logic:notEmpty  name="prpLregistDto"  property="claimType"> 
           <input type="hidden" name="claimType" class="codecode"  style="width:40px" title="�¹�����" value="<bean:write name='prpLregistDto' property='claimType' filter='true' />"
             ondblclick="code_CodeSelect(this, 'CaseCode');"
             onchange="code_CodeChange(this, 'CaseCode');"
             onkeyup= "code_CodeSelect(this, 'CaseCode');">
           <input type=text name="claimTypeName" class="codecode" title="�¹�����" style="width:125px" value="<bean:write name='prpLregistDto' property='claimTypeName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'CaseCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'CaseCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'CaseCode','-1','name','none','post');">
          </logic:notEmpty> 
          <logic:empty  name="prpLregistDto"  property="claimType">
            <input type="hidden" name="claimType" class="codecode"  style="width:40px" title="�¹�����"
             ondblclick="code_CodeSelect(this, 'CaseCode');"
             onchange="code_CodeChange(this, 'CaseCode');"
             onkeyup= "code_CodeSelect(this, 'CaseCode');">
            <input type=text name="claimTypeName" class="codecode" title="�¹�����" style="width:125px"
             ondblclick="code_CodeSelect(this, 'CaseCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'CaseCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'CaseCode','-1','name','none','post');">
         </logic:empty>         
        </td>
    </tr>
     <tr> 
      <td class="title">�¹ʴ�����:</td>     
      <td class="input">
        <input type=hidden name="prpLregistHandleUnit" class="codecode" style="width:60px" title="������" value="<bean:write name='prpLregistDto' property='handleUnit' filter='true' />"
             ondblclick="code_CodeSelect(this, 'HandleUnitCar');"
             onchange="code_CodeChange(this, 'HandleUnitCar');"
             onkeyup= "code_CodeSelect(this, 'HandleUnitCar');">
        <input type=text name="prpLregistHandleUnitName" class="codecode"  style="width:170px" title="������" value="<bean:write name='prpLregistDto' property='handleUnitName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'HandleUnitCar','-1','name','none','post');"
             onchange="code_CodeChange(this, 'HandleUnitCar','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'HandleUnitCar','-1','name','none','post');"
             onclick = "clearInput(this);">
             <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
      </td>
    </tr>
  <logic:empty name="prpLdriverDto"  property="driverList">  
    <tr>
      <td class="title">��ʻԱ:</td>
      <td class="input">
       <input type=text name="prpLdriverDriverName"  maxlength="10" class="input" style="width:170px" title="��ʻԱ" value="">
       <img src="/claim/images/bgMarkMustInput.jpg">
      <!--  
        <input type=text name="prpLregistReceiverName" class="codecode" style="width:170px" title="��ʻԱ" value="<bean:write name='prpLregistDto' property='receiverName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'HanderCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'HanderCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'HanderCode','-1','name','none','post');">
           
        <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
        <img src="/claim/images/bgMarkMustInput.jpg">
        -->
      </td>
      
      <td class="title">��ʻԱ��ϵ�绰:</td>
      <td class="input">
       <input type=text name="prpLdriverDriverPhone"  maxlength="20" class="input" style="width:170px" title="��ʻԱ��ϵ�绰" value="">
       <img src="/claim/images/bgMarkMustInput.jpg">
      <!--  
        <input type=text name="prpLregistReceiverName" class="codecode" style="width:170px" title="��ʻԱ" value="<bean:write name='prpLregistDto' property='receiverName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'HanderCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'HanderCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'HanderCode','-1','name','none','post');">
           
        <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
        <img src="/claim/images/bgMarkMustInput.jpg">
        -->
      </td>    
      </tr>
 </logic:empty>
<logic:notEmpty  name="prpLdriverDto"  property="driverList">
    <logic:iterate id="driver" name="prpLdriverDto" property="driverList">
    <tr>
      <td class="title">��ʻԱ:</td>
      <td class="input">
       <input type=text name="prpLdriverDriverName" class="input" maxlength="10" style="width:170px" title="��ʻԱ" value="<bean:write name='driver' property='driverName'/>">
       <img src="/claim/images/bgMarkMustInput.jpg">
      <!--  
        <input type=text name="prpLregistReceiverName" class="codecode" style="width:170px" title="��ʻԱ" value="<bean:write name='prpLregistDto' property='receiverName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'HanderCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'HanderCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'HanderCode','-1','name','none','post');">
           
        <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
        <img src="/claim/images/bgMarkMustInput.jpg">
        -->
      </td>
      
      <td class="title">��ʻԱ��ϵ�绰:</td>
      <td class="input">
       <input type=text name="prpLdriverDriverPhone" class="input"  maxlength="20" style="width:170px" title="��ʻԱ��ϵ�绰" value="<bean:write name='driver' property='driverSeaRoute'/>">
       <img src="/claim/images/bgMarkMustInput.jpg">
      <!--  
        <input type=text name="prpLregistReceiverName" class="codecode" style="width:170px" title="��ʻԱ" value="<bean:write name='prpLregistDto' property='receiverName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'HanderCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'HanderCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'HanderCode','-1','name','none','post');">
           
        <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
        <img src="/claim/images/bgMarkMustInput.jpg">
        -->
      </td>    
      </tr>
     </logic:iterate> 
</logic:notEmpty>
    <tr>
        <td class="title">�Ƿ��һ�ֳ�����:</td>
        <td class="input">
          <html:radio  name="prpLregistDto" property="firstSiteFlag" value="1"/>��
          <html:radio  name="prpLregistDto" property="firstSiteFlag" value="0"/>��
        </td>
         <td class="title">¼������:</td>
        <td class="input" colspan="3">
            <input type=text name="prpLregistInputDate"  title="¼������" class="readonly" style="width:100%" readonly="true" value="<bean:write name='prpLregistDto' property='inputDate' filter='true' />">
        </td>
    </tr>
    
    <input type="hidden" name="acceptFlag" value="Y">
    <input type="hidden" name="repeatInsureFlag"  value="N">    
    <tr style="display:none">
      <td class="title">������(�ұ�:CNY-�����):</td>
      <td class="input"  >
        <input type=hidden  name="prpLregistEstimateFee" title="�������" Class="input" style="width:80px" value="<bean:write name='prpLregistDto' property='estimateFee' filter='true' format='0.00'/>">
        <input type=text name="prpLregistEstimateLoss" title="������ʧ" Class="input" style="width:120px" value="<bean:write name='prpLregistDto' property='estimateLoss' filter='true' format='0.00'/>">
      </td>

      <td class="title">�Ƿ���Ҫ�鿱:</td>
      <td class="input"  >
           <html:select name="prpLscheduleMainWFDto" property="scheduleType" >
            <html:option value="ALLS" >��Ҫ</html:option>
            <html:option value="NOCK">����Ҫ</html:option>
           </html:select>
      </td>       
     </tr>         
    <tr style="display:">
        <td class="title">�ӱ���Ա:</td>
        <td class="input">
          <input type=text name="prpLregistOperatorCode" title="�ӱ���Ա" class="readonly" style="width:80px" readonly="true" value="<bean:write name='prpLregistDto' property='operatorCode' filter='true' />">
          <input type=text name="prpLregistOperatorName" title="�ӱ���Ա����" class="readonly" style="width:80px" readonly="true" value="<bean:write name='prpLregistDto' property='operatorName' filter='true' />">
        </td>
        <td class="title">�����������:</td>
        <td class="input">
          <input type=hidden name="prpLregistMakeCom" title="�����������" class="readonly" style="width:80px" readonly="true" value="<bean:write name='prpLregistDto' property='makeCom' filter='true' />">
          <input type=text name="prpLregistMakeComName" title="�����������" class="readonly" style="width:200px" readonly="true" value="<bean:write name='prpLregistDto' property='makeComName' filter='true' />">
        </td>
    </tr>
    </table>