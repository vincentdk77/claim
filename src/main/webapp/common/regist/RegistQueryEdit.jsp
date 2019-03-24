<%--
****************************************************************************
* DESC       ：报案查询条件输入页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-07
* MODIFYLIST ：   id       Date            Reason/Contents
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
//取查询条件的时间段
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
  <title>查询报案信息</title>
  <%-- 公用函数 --%>
  <script src="/claim/workflow/task/js/WfLogStatusList.js"> </script>
  <script src="/claim/common/js/Common.js"></script>
  <script src="/claim/common/js/showpage.js"> </script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script src="/claim/common/js/UILoad.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
  <script language="javascript">
  <%--案件状态标志处理--%>
  //<!--
    function submitForm()
    {
		//if(fm.Fname != null && trim(fm.Fname.value).length != 0)
		//{
		//	if(fm.EarLabel != null && trim(fm.EarLabel.value).length == 0)
		//	{
		//	 alert("农户姓名不为空时，必须输入耳标号！");
		//	 return false;
		//	}
		//}
	    if(fm.riskCategory !=null &&trim(fm.riskCategory.value).length==0)
       {
           alert("险种大类不能为空，请选择！");
           return false;
       }
     	if(fm.queryRiskCode !=null && trim(fm.queryRiskCode.value).length==0)
       {
            alert("险种不能为空，请选择！");
            return false;
        }	
		 if(fm.EarLabel !=null && trim(fm.EarLabel.value).length<4 && trim(fm.EarLabel.value).length>0)
       {
           alert("耳标号长度不能小于4位");
           return false;
       }
     	if(fm.FamilyNo !=null && trim(fm.FamilyNo.value).length<4 && trim(fm.FamilyNo.value).length>0)
       {
            alert("户编号长度不能小于4位");
            return false;
        }
       if(fm.FCardID !=null && trim(fm.FCardID.value).length<6 && trim(fm.FCardID.value).length>0)
       {
           alert("农户身份证号长度不能小于6位");
           return false;
       }
        if(fm.FamilyFIDCard !=null && trim(fm.FamilyFIDCard.value).length<6 && trim(fm.FamilyFIDCard.value).length>0)
        {
            alert("户主身份证号长度不能小于6位");
            return false;
        }
      var ref="";
      for(i=0;i<fm.status.length;i++){
        if(fm.status[i].checked==true){
           ref = ref+fm.status[i].value+",";
        }
      }
      fm.caseFlag.value = ref;
      //x_load.show("系统正在查询,请勿点击页面...");
      fm.queryButton.disabled=true;
	  fm.submit();//提交
	  setTimeout('fm.queryButton.disabled=false',5000);
    }
    //radio双击事件
    function dbclick(){
    	fm.cancelFlag[1].checked=false;
    	fm.cancelFlag[0].checked=false;
    	cancelDate.style.display="none";
    	//alert(cancelDate.style.display);
    }
    //radio单击事件显示注销时间选择项
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

  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>

<body  onload="initPage();">
<form name="fm" action="/claim/RegistQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
       <tr>

	          <td colspan="4" class="formtitle"><bean:message key="title.registBeforeEdit.titleName" /></td>

	        </tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLregist.registNo" />：</td>
        <td class='input' >
          <select class=tag name="RegistNoSign" >
            <option value="=">=</option>
          </select> <input type=text name="RegistNo" class="query" >
        </td>
        <td class='title' ><bean:message key="db.prpLregist.policyNo" />：</td>
        <td class='input' >
        <select class=tag name="PolicyNoSign" >
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query" >
        </td>
    </tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLregist.licenseNo" />：</td>
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
						机构：
		</td>
		<td class='input' >
			<input type=hidden class="codecode" name="comCode"
					title="具体单位" value="">
			<input type=text class="codecode" name="comName" id="deptname" title="具体单位"
					style="width: 82%" maxLength="50" description="班表单位" value=""
					ondblclick="open_CodeSelect(this,'jobComCode','0000000000','班表单位');"
					onkeyup="open_CodeSelect(this,'jobComCode','0000000000','班表单位');"
					onkeypress="window.event.keyCode = 0;">
		</td>
        <%--报案查询增加被保险人查询条件--%>
       <td class='title' >被保险人名称:</td>
        <td class='input' >
          <select class=tag name="InsuredNameSign" >
            <option value="=">=</option>
          </select> <input type=text name="InsuredName" class="query" >
        </td>

        </tr>
        <!--modify by wangwei add delete 2005-06-15-->
        <!--原因：意健险需要在报案时增加身份证查询条件，查询不用。-->
        <%--
        <td class='title' >身份证号:</td>
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
        <td class='title'>是否注销：</td>
        <td class='input'>
            <input type="radio" name="cancelFlag" value="1" onDblclick="dbclick();" onclick="radioclick();">是</input>
            <input type="radio" name="cancelFlag" value="0" onDblclick="dbclick();" onclick="radioclick();">否</input>
        </td>
        <td class='title' >案件状态：</td>
        <td class='input'>
          <input type="hidden" name="caseFlag" value="">
          <%--input type="checkbox" name="status" value="1"未处理--%>
          <input type="checkbox" name="status" value="2">正处理
          <%--没有此种案件状态 2005-07-28<input type="checkbox" name="status" value="3">已处理--%>
          <input type="checkbox" name="status" value="4">已处理
      <tr id="cancelDate" style="display:none">
        <td class='title' >注销开始时间：</td>
        <td class='input' >
          <input type=text name="registStartCancelDate" class="Wdate" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.registStartCancelDate', '2007', '2017')"> -->
        </td>
        <td class='title' >注销结束时间：</td>
        <td class='input' >
          <input type=text name="registEndCancelDate" class="Wdate" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.registEndCancelDate', '2007', '2017')"> -->
        </td>
        </tr>
        </td>
      </tr>
	<tr>
	</tr>
	<tr>
        <td class='title' >耳标号：(中央政策性养殖险专用)</td>
        <td class='input' >
          <select class=tag name="EarLabelSign" >
            <option value="=">=</option>
          </select> <input type=text name="EarLabel" class="query" >
        </td>
        <td class='title'>农户姓名：(中央政策性养殖险专用)</td>
		<td class='input' >
		<select class=tag name="FnameSign" >
            <option value="=">=</option>
          </select> <input type=text name="Fname" class="query" >
		</td>
      </tr>
      <tr>
        <td class='title' >身份证号：(种植险专用)</td>
        <td class='input' >
          <select class=tag name="FCardIDSign" >
            <option value="=">=</option>
          </select> <input type=text name="FCardID" class="query" >
        </td>
        <td class='title'>农户姓名：(种植险专用)</td>
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
		 <td class='title' >操作时间起始：</td>
        <td class='input' >
        <select class=tag name="OperateDateSign" >
          <option value=">=">&gt;=</option>
        </select> <input type="text" name="OperateDate" value="<%=OperateDate %>" style="width:60%" class="Wdate" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.OperateDate', '2007', '2017')" onblur="return checkFullDate(this);"> -->
        </td>
		 <td class='title' >操作时间截止：</td>
        <td class='input' >
        <select class=tag name="OperateDateSignEnd" >
          <option value="<=">&lt;=</option>
        </select> <input type="text" name="OperateDateEnd" value="<%=OperateDateEnd %>" style="width:60%" class="Wdate" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.OperateDateEnd', '2007', '2017')" onblur="return checkFullDate(this);"> -->
        </td>
	  </tr>
	  <tr>	
		<td class='title'>险种大类：</td>
        <td class='title'>
        <select class="common" name="riskCategory" 
                                onchange="buildRiskCodeSelect(fm.riskCategory, fm.queryRiskCode);">
                            <option value="">请选择</option>
                            <option value="D">车险</option>
                            <option value="Y">水险</option>
                            <option value="Q">非水</option>
                            <option value="E">意健</option>
                            <option value="H">种植</option>
                            <option value="I">养殖</option>
                        </select>
        </td>
		<td class='title'>险种：</td>
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
	    <td colspan="4" class='input'><font color="red">为了提高您的查询速度，请尽量录入精确的查询条件。同时系统不允许险种条件为空的查询</font></td>
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

