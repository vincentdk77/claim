<%--
****************************************************************************
* DESC       ��������ѯ��������ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-06-07
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.prpall.pubfun.PubTools"%>
<%@ page import="com.sinosoft.claim.bl.facade.BLPrpDriskFacade" %>
<%@ page import="com.sinosoft.claim.dto.domain.PrpDriskDto" %>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="java.util.List"%>
<% 
PubTools pubTools = new PubTools();
String nowDate = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY).toString();;
System.err.println("nowDate==="+nowDate);
String OperateDate = "";
String OperateDateEnd = "";
//ȡ��ѯ������ʱ���
if(nowDate!=null){
	OperateDate = pubTools.getMonthStart(pubTools.getNextMonthFullDate(nowDate,-1),"1",0);
	OperateDateEnd = pubTools.getMonthEnd(pubTools.getNextMonthFullDate(nowDate,1),"1",0);
}

List riskCodeCollection = (List)new BLPrpDriskFacade().findRiskCodeByConditions(" k.validstatus = '1'");
String[] riskCategory = new String[riskCodeCollection.size()];
String[] riskCode = new String[riskCodeCollection.size()];
String[] riskName = new String[riskCodeCollection.size()];
PrpDriskDto prpdRiskDto = null;
for(int i=0; i<riskCodeCollection.size(); i++)
{
	prpdRiskDto = (PrpDriskDto)riskCodeCollection.get(i);
    riskCategory[i] = prpdRiskDto.getRiskType();
    riskCode[i] = prpdRiskDto.getRiskCode();
    riskName[i] = prpdRiskDto.getRiskCName();
}

%>
<html:html locale="true">
<head>
  <title>��ѯ������Ϣ</title>
  <%-- ���ú��� --%>
  <script src="/claim/workflow/task/js/WfLogStatusList.js"> </script>
  <script src="/claim/common/js/Common.js"></script>
  <script src="/claim/common/js/showpage.js"> </script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script src="/claim/common/js/UILoad.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
  <script language="javascript">
  <%--����״̬��־����--%>
  //<!--
    function submitForm()
    {
		//if(fm.Fname != null && trim(fm.Fname.value).length != 0)
		//{
		//	if(fm.EarLabel != null && trim(fm.EarLabel.value).length == 0)
		//	{
		//	 alert("ũ��������Ϊ��ʱ�������������ţ�");
		//	 return false;
		//	}
		//}
	    if(fm.riskCategory !=null &&trim(fm.riskCategory.value).length==0)
       {
           alert("���ִ��಻��Ϊ�գ���ѡ��");
           return false;
       }
     	if(fm.queryRiskCode !=null && trim(fm.queryRiskCode.value).length==0)
       {
            alert("���ֲ���Ϊ�գ���ѡ��");
            return false;
        }	
		 if(fm.EarLabel !=null && trim(fm.EarLabel.value).length<4 && trim(fm.EarLabel.value).length>0)
       {
           alert("����ų��Ȳ���С��4λ");
           return false;
       }
     	if(fm.FamilyNo !=null && trim(fm.FamilyNo.value).length<4 && trim(fm.FamilyNo.value).length>0)
       {
            alert("����ų��Ȳ���С��4λ");
            return false;
        }
       if(fm.FCardID !=null && trim(fm.FCardID.value).length<6 && trim(fm.FCardID.value).length>0)
       {
           alert("ũ�����֤�ų��Ȳ���С��6λ");
           return false;
       }
        if(fm.FamilyFIDCard !=null && trim(fm.FamilyFIDCard.value).length<6 && trim(fm.FamilyFIDCard.value).length>0)
        {
            alert("�������֤�ų��Ȳ���С��6λ");
            return false;
        }
      var ref="";
      for(i=0;i<fm.status.length;i++){
        if(fm.status[i].checked==true){
           ref = ref+fm.status[i].value+",";
        }
      }
      fm.caseFlag.value = ref;
      //x_load.show("ϵͳ���ڲ�ѯ,������ҳ��...");
      fm.queryButton.disabled=true;
	  fm.submit();//�ύ
	  setTimeout('fm.queryButton.disabled=false',5000);
    }
    //radio˫���¼�
    function dbclick(){
    	fm.cancelFlag[1].checked=false;
    	fm.cancelFlag[0].checked=false;
    	cancelDate.style.display="none";
    	//alert(cancelDate.style.display);
    }
    //radio�����¼���ʾע��ʱ��ѡ����
    function radioclick(){
    	//alert(cancelDate.style.display);
    	if (fm.cancelFlag[0].checked==false){
    	cancelDate.style.display="none";
    	}else{
    	cancelDate.style.display="";
    	}
    }
    
     function buildRiskCodeSelect(riskCategoryField, riskCodeField)
   {
    var categoryValue = riskCategoryField.value;
    riskCodeField.length = 0;
    riskCodeField.options[0] = new Option("", "");
    for(var i=0; i<riskCodeCount; i++)
    {
        if(riskCodes[i][0] == categoryValue)
        {
            riskCodeField.options[riskCodeField.length] = new Option(riskCodes[i][2], riskCodes[i][1]);
        }
    }
    riskCodeField.remove(0);
   }
   
    var riskCodeCount = <%=riskCodeCollection.size()%>;
    var riskCodes = new Array();
    <%for(int i=0; i<riskCodeCollection.size(); i++){%>
        riskCodes[<%=i%>] = new Array("<%=riskCategory[i]%>", "<%=riskCode[i]%>", "<%=riskName[i]%>");
    <%}%>
    
    
  //-->
  </script>

  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>

<body  onload="initPage();">
<form name="fm" action="/claim/RegistQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
       <tr>

	          <td colspan="4" class="formtitle"><bean:message key="title.registBeforeEdit.titleName" /></td>

	        </tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLregist.registNo" />��</td>
        <td class='input' >
          <select class=tag name="RegistNoSign" >
            <option value="=">=</option>
          </select> <input type=text name="RegistNo" class="query" >
        </td>
        <td class='title' ><bean:message key="db.prpLregist.policyNo" />��</td>
        <td class='input' >
        <select class=tag name="PolicyNoSign" >
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query" >
        </td>
    </tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLregist.licenseNo" />��</td>
        <td class='input' >
        <select class=tag name="LicenseNoSign" >
            <option value="=">=</option>
            <option value="*">*</option>
          </select> <input type=text name="LicenseNo" class="query" >
        </td>
        <td class='title' ></td>
        <td class='input' >
        </td>
      </tr>
      <tr>
        <td class='title'>
						������
		</td>
		<td class='input' >
			<input type=hidden class="codecode" name="comCode"
					title="���嵥λ" value="">
			<input type=text class="codecode" name="comName" id="deptname" title="���嵥λ"
					style="width: 82%" maxLength="50" description="���λ" value=""
					ondblclick="open_CodeSelect(this,'jobComCode','0000000000','���λ');"
					onkeyup="open_CodeSelect(this,'jobComCode','0000000000','���λ');"
					onkeypress="window.event.keyCode = 0;">
		</td>
        <%--������ѯ���ӱ������˲�ѯ����--%>
       <td class='title' >������������:</td>
        <td class='input' >
          <select class=tag name="InsuredNameSign" >
            <option value="=">=</option>
          </select> <input type=text name="InsuredName" class="query" >
        </td>

        </tr>
        <!--modify by wangwei add delete 2005-06-15-->
        <!--ԭ���⽡����Ҫ�ڱ���ʱ�������֤��ѯ��������ѯ���á�-->
        <%--
        <td class='title' >���֤��:</td>
        <td class='input' >
          <select class=tag name="IdentifyNumberSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="IdentifyNumber" class="query" >
        </td>
        <input type="hidden" name="IDCardFlag" value="Flag">
        --%>
        <!--modify by wangwei add end 2005-06-15-->



      <tr>
        <td class='title'>�Ƿ�ע����</td>
        <td class='input'>
            <input type="radio" name="cancelFlag" value="1" onDblclick="dbclick();" onclick="radioclick();">��</input>
            <input type="radio" name="cancelFlag" value="0" onDblclick="dbclick();" onclick="radioclick();">��</input>
        </td>
        <td class='title' >����״̬��</td>
        <td class='input'>
          <input type="hidden" name="caseFlag" value="">
          <%--input type="checkbox" name="status" value="1"δ����--%>
          <input type="checkbox" name="status" value="2">������
          <%--û�д��ְ���״̬ 2005-07-28<input type="checkbox" name="status" value="3">�Ѵ���--%>
          <input type="checkbox" name="status" value="4">�Ѵ���
      <tr id="cancelDate" style="display:none">
        <td class='title' >ע����ʼʱ�䣺</td>
        <td class='input' >
          <input type=text name="registStartCancelDate" class="Wdate" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.registStartCancelDate', '2007', '2017')"> -->
        </td>
        <td class='title' >ע������ʱ�䣺</td>
        <td class='input' >
          <input type=text name="registEndCancelDate" class="Wdate" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.registEndCancelDate', '2007', '2017')"> -->
        </td>
        </tr>
        </td>
      </tr>
	<tr>
	</tr>
	<tr>
        <td class='title' >����ţ�(������������ֳ��ר��)</td>
        <td class='input' >
          <select class=tag name="EarLabelSign" >
            <option value="=">=</option>
          </select> <input type=text name="EarLabel" class="query" >
        </td>
        <td class='title'>ũ��������(������������ֳ��ר��)</td>
		<td class='input' >
		<select class=tag name="FnameSign" >
            <option value="=">=</option>
          </select> <input type=text name="Fname" class="query" >
		</td>
      </tr>
      <tr>
        <td class='title' >���֤�ţ�(��ֲ��ר��)</td>
        <td class='input' >
          <select class=tag name="FCardIDSign" >
            <option value="=">=</option>
          </select> <input type=text name="FCardID" class="query" >
        </td>
        <td class='title'>ũ��������(��ֲ��ר��)</td>
    <td class='input' >
    <select class=tag name="Fname1Sign" >
            <option value="=">=</option>
          </select> <input type=text name="Fname1" class="query" >
    </td>
      </tr>
	  <tr>	
	  <%
		       		DateTime dateTime = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
		       		OperateDate = dateTime.addDay(-7).toString();
		       		OperateDateEnd = dateTime.toString();

		           %>
		 <td class='title' >����ʱ����ʼ��</td>
        <td class='input' >
        <select class=tag name="OperateDateSign" >
          <option value=">=">&gt;=</option>
        </select> <input type="text" name="OperateDate" value="<%=OperateDate %>" style="width:60%" class="Wdate" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.OperateDate', '2007', '2017')" onblur="return checkFullDate(this);"> -->
        </td>
		 <td class='title' >����ʱ���ֹ��</td>
        <td class='input' >
        <select class=tag name="OperateDateSignEnd" >
          <option value="<=">&lt;=</option>
        </select> <input type="text" name="OperateDateEnd" value="<%=OperateDateEnd %>" style="width:60%" class="Wdate" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.OperateDateEnd', '2007', '2017')" onblur="return checkFullDate(this);"> -->
        </td>
	  </tr>
	  <tr>	
		<td class='title'>���ִ��ࣺ</td>
        <td class='title'>
        <select class="common" name="riskCategory" 
                                onchange="buildRiskCodeSelect(fm.riskCategory, fm.queryRiskCode);">
                            <option value="">��ѡ��</option>
                            <option value="D">����</option>
                            <option value="Y">ˮ��</option>
                            <option value="Q">��ˮ</option>
                            <option value="E">�⽡</option>
                            <option value="H">��ֲ</option>
                            <option value="I">��ֳ</option>
                        </select>
        </td>
		<td class='title'>���֣�</td>
        <td class="input">
            <select class=tag name="RiskCodeSign" style="display:none">
                <option value="=">=</option>
            </select> 
            <input type="hidden" name="riskCodeTag" value="=">
            <select class="common" name="queryRiskCode" size="7" >
            </select>
        </td>
	  </tr>
	  <tr>
	    <td colspan="4" class='input'><font color="red">Ϊ��������Ĳ�ѯ�ٶȣ��뾡��¼�뾫ȷ�Ĳ�ѯ������ͬʱϵͳ��������������Ϊ�յĲ�ѯ</font></td>
	  </tr>
    </table>
    <table width=100%>

        <td align=center>
          <input type=button class='button'name="queryButton" value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
      </tr>
      </table>
    <input type="hidden" name="editType" value="SHOW">
  </form>
</body>
</html:html>

