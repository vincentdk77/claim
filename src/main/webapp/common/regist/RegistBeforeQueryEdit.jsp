<%--
****************************************************************************
* DESC       ：录入报案前查询保单号条件果面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-12-06
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.common.datatype.*"%>


<html:html locale="true">
<head>
  <title>查询保单信息</title>
  <%-- 公用函数 --%>
  <script src="/claim/common/js/Common.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
     <script src="/claim/common/js/InputCode.js"></script>
    <script src="/claim/common/js/UIPrpslPoli0310UploadList.js"></script>
    <script src="/claim/common/js/UILoad.js"></script>
    <script src="/claim/js/WdatePicker.js"></script>
  <script language="javascript">
  <%--案件状态标志处理--%>
 
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
       if(fm.DamageDate.value=="")
       {
           alert("出险日期不能为空");
           return false;
       }
       if(fm.DamageHour.value=="")
       {
           alert("出险小时不能为空");
           return false;
       }
       if(fm.EarLabel !=null&& fm.EarLabelSign.value =="*" && trim(fm.EarLabel.value).length<4 && trim(fm.EarLabel.value).length>0)
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
       if(fm.IdentifyNumber_0310 !=null && trim(fm.IdentifyNumber_0310.value).length<6 && trim(fm.IdentifyNumber_0310.value).length>0)
       {
           alert("农房身份证号长度不能小于6位");
           return false;
       }
       if((fm.AreasProvince!=null && ""!=fm.AreasProvince.value) && (fm.AreasCity!=null && ""!=fm.AreasCity.value))
       {
	       if((fm.AreasVillage.value==null||fm.AreasVillage.value=="")
			&&(fm.AreasCountry.value==null||fm.AreasCountry.value=="")
				&&(fm.AreasTown.value==null||fm.AreasTown.value==""))
			{
				alert("请选择承保清单归属区域！");
				return false;
			}
		}
		else
		{
			fm.AreasCode.value = "";
		}
		x_load.show("系统正在查询,请勿点击页面...");
		fm.queryButton.disabled=true;
        fm.submit();//提交
		setTimeout('fm.queryButton.disabled=false',5000);
    }
  </script>

  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>

<body  onload="initPage();">
<form name="fm" action="/claim/registBeforeQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1"  class="common">
      <tr>

      <%
       // 从session里取扶贫/大户标志
		String strHPflag = (String)session.getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				%> <td colspan="4" class="formtitle">查询规模经营主体系统保单信息</td><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <td colspan="4" class="formtitle">查询扶贫系统保单信息</td><% 
			} else {
				%> <td colspan="4" class="formtitle">查询保单信息</td><% 
			}
		} else {
			%> <td colspan="4" class="formtitle">查询保单信息</td><% 
		}
      %>

	        </tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLregist.policyNo" />：</td>
        <td class='input' >
        <select class=tag name="PolicyNoSign" >
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query" >
        </td>
         <td class='title' ><bean:message key="db.prpLregist.licenseNo" />：</td>
        <td class='input'  >
        <select class=tag name="LicenseNoSign" >
            <option value="=">=</option>
            <option value="*">*</option>
          </select> <input type=text name="LicenseNo" class="query" >
        </td>
     
        
      </tr>
      <tr>  
        <td class='title' >被保险人名称：</td>
        <td class='input' >
          <select class=tag name="InsuredNameSign" >
            <option value="=">=</option>
          </select> <input type=text name="InsuredName" class="query" >
        </td>
        
        <!--modify by wangwei add start 2005-06-05-->
        <!--原因：需要增加身份证查询条件-->
        <td class='title' >身份证号：</td>
        <td class='input' >
          <select class=tag name="IdentifyNumberSign" >
            <option value="=">=</option>
          </select> <input type=text name="IdentifyNumber" class="query" >
        </td>
        <input type="hidden" name="IDCardFlag" value="Flag">
        <!--modify by wangwei add end 2005-06-05-->
        
      </tr>
      <tr>
        <td class='title' >保险起期：</td>
        <td class='input' >
        <select class=tag name="StartDateSign" >
          <option value=">=">&gt;=</option>
          <option value="=">=&nbsp;</option>
          <option value=">">&gt;&nbsp;</option>
          <option value="">&lt;&nbsp;</option>
          <option value="<=">&lt;=</option>
          </select> <input type=text name="StartDate" class="Wdate" style="width:60%"  value="<%= new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY).addYear(-1) %> "  onfocus="WdatePicker()"> 
        </td>
        <td class='title' >保险止期：</td>
        <td class='input' >
        <select class=tag name="EndDateSign" >
          <option value="<=">&lt;=</option>
          <option value="=">=&nbsp;</option>
          <option value=">">&gt;&nbsp;</option>
          <option value="<">&lt;&nbsp;</option>
          <option value=">=">&gt;=</option>
        </select> <input type="text" name="EndDate" style="width:60%" class="Wdate"  value="<%= new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY).addYear(1) %>" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.EndDate', '2007', '2017')"> -->
        </td>
      </tr>

      <tr>
       

          <td class='title' ><bean:message key="db.prpLregist.engineNo" />：</td>
        <td class='input'  >
        <select class=tag name="EngineNoSign" >
            <option value="=">=</option>
            <option value="*">*</option>
          </select> <input type=text name="EngineNo" class="query" >
        </td>
         <td class='title' ><bean:message key="db.prpLregist.frameNo" />：</td>
        <td class='input' >
        <select class=tag name="FrameNoSign" >
            <option value="=">=</option>
            <option value="*">*</option>
          </select> <input type=text name="FrameNo" class="query" >
        </td>
      </tr>

      <tr>
        <td class='title' >出险日期:</td>
        <td class='input' >
        <select class=tag name="DamageDateSign" >
          <option value="=">=&nbsp;</option>
          </select> <input type=text name="DamageDate" style="width:60%" class="Wdate"  value="<%= new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY) %>"  onfocus="WdatePicker()"> <!--  <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.DamageDate', '2007', '2017')"> -->
        </td>
         <td class='title' >出险小时:</td>
        <td class='input' >
        <select class=tag name="DamageHourSign" >
          <option value="=">=&nbsp;</option>
          </select> <input type=text name="DamageHour" class="query"  value="0"> 
        </td>
      </tr>
      <tr>
        <td class='title' >险种大类:</td>
        <td class='input' >  
             <select class=tag name="RiskTypeSign" >                
                <option value="=">=&nbsp;</option>
             </select>              
             <select name="RiskType" class="query" style="width: 60%">
                            <option value="">全险种</option>
                            <option value="D">车险</option>
                            <option value="Y">水险</option>
                            <option value="Q">非水</option>
                            <option value="E">意健</option>
                            <option value="H">种植</option>
                            <option value="I">养殖</option>
             </select>
        </td>
      
        <td class='title' >原保单号：</td>
        <td class='input' >
          <select class=tag name="OldPolicyNoSign" >
            <option value="=">=</option>
          </select> <input type=text class="query" name="OldPolicyNo" >
        </td>
      </tr>
      
         <tr>
        <td class='title' >保单流水号:</td>
        <td class='input' >
        <select class=tag name="PolicyNoPrintNoSign" >
          <option value="=">=&nbsp;</option>
          </select> 
          <input type=text name="PolicyNoPrintNo" class="query"> 
        </td>
      </tr>
      <tr>
        <td class='title' >耳标号：(中央政策性养殖险专用)</td>
        <td class='input' >
          <select class=tag name="EarLabelSign" >
            <option value="=">=</option>
          </select> 
		  <input type=text name="EarLabel" class="query" >
        </td>
        <td class='title'>农户姓名：(中央政策性养殖险专用)</td>
		<td class='input' >
		 <select class=tag name="FnameSign" >
            <option value="=">=</option>
          </select> 
		  <input type=text name="Fname" class="query" >
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
          </select>
    <input type=text name="Fname1" class="query" >
    </td>
      </tr>
      <tr>
        <td class='title' >户编号：(农家福组合保险专用)</td>
        <td class='input' >
          <select class=tag name="FamilyNoSign" >
            <option value="=">=</option>
          </select> 
		  <input type=text name="FamilyNo" class="query" >
        </td>
       <td class='title' >户主身份证号：(农家福组合保险专用)</td>
        <td class='input' >
          <select class=tag name="FamilyFIDCardSign" >
            <option value="=">=</option>
          </select> 
		  <input type=text name="FamilyFIDCard" class="query" >
        </td>
      </tr>
      		<!-- 针对旅行意外伤害险的个性化处理 -->
	      <tr>
	      	<td class="title">姓名：（旅行意外伤害险专用）</td>
	      	<td class="input">
	      		<select class="tag" name="InsuredNameSign_2743">
	      			<option value="=">=</option>
	      		</select>
	      		<input type="text" name="InsuredName_2743" class="query">
	      	</td>
	      	<td class="title">身份证号：（旅行意外伤害险专用）</td>
	      	<td class="input">
	      		<select class="tag" name="IdentifyNumberSign_2743">
	      			<option value="=">=</option>
	      		</select>
	      		<input type="text" name="IdentifyNumber_2743" class="query">
	      	</td>
	      </tr>
	      
	      <!-- 针对农房险的个性化处理 -->
	      <tr>
	      	<td class="title">身份证号：（农房保险专用）</td>
	      	<td class="input">
	      		<select class="tag" name="IdentifyNumberSign_0310">
	      			<option value="=">=</option>
	      		</select>
	      		<input type="text" name="IdentifyNumber_0310" class="query">
	      	</td>
	      	<td</td>
	      	<td>

	      	</td>
	      </tr>
	      </table>
	<table width="100%" border="0" align="center" cellpadding="6" cellspacing="1"  class="common">
	          <tr id="trAreas" name="trAreas">
         <td style="width:15%">农房清单归属区域(养殖险可用)：</td>
        <td style="width:13%">
        <input type="hidden" name="AreasProvince">
        <input type="text" name="AreasProvinceName" class="codename" description="行政区域：省"
          querytype="always" codetype="AreasProvince" coderelation="-1" codelimit="clear"
          ondblclick="check_AreasProvince(AreasProvinceName,'AreasProvince');clear_AreasProvince();setAreasCodeAndName()"
          onkeyup="code_CodeSelect(this,'AreasProvince','-1' ,'name','post','clear');clear_AreasProvince();setAreasCodeAndName()"
          onblur="code_CodeChange(this,'AreasProvince','-1' ,'name','post','clear');clear_AreasProvince();setAreasCodeAndName()"
          onchange="clear_AreasProvince();setAreasCodeAndName()">
        </td>
        <td style="width:13%">  
        <input type="hidden" name="AreasCity">
        <input type="text" name="AreasCityName" class="codename"  description="行政区域：地市"
          querytype="always" codetype="AreasCity" coderelation="-1" codelimit="clear"
          ondblclick="code_CodeSelect(this,'AreasCity','-1','name','post','clear');clear_AreasCity();setAreasCodeAndName()"
          onkeyup="code_CodeSelect(this,'AreasCity','-1','name','post','clear');clear_AreasCity();setAreasCodeAndName()"
          onblur="code_CodeChange(this,'AreasCity','-1','name','post','clear');clear_AreasCity();setAreasCodeAndName()"
          onchange="clear_AreasCity();setAreasCodeAndName()">
         </td>
         <td style="width:13%">
        <input type="hidden" name="AreasTown">
        <input type="text" name="AreasTownName" class="codename"  description="行政区域：区县"
          querytype="always" codetype="AreasTown" coderelation="-1" codelimit="clear"
          ondblclick="code_CodeSelect(this,'AreasTown','-1','name','post','clear');clear_AreasTown();setAreasCodeAndName()"
          onkeyup="code_CodeSelect(this,'AreasTown','-1','name','post','clear');clear_AreasTown();setAreasCodeAndName()"
          onblur="code_CodeChange(this,'AreasTown','-1','name','post','clear');clear_AreasTown();setAreasCodeAndName()"
          onchange="clear_AreasTown();setAreasCodeAndName()"
          >
          </td>
          <td style="width:13%">
        <input type="hidden" name="AreasCountry">
        <input type="text" name="AreasCountryName" class="codename"  description="行政区域：乡"
          querytype="always" codetype="AreasCountry" coderelation="-1" codelimit="clear"
          ondblclick="code_CodeSelect(this,'AreasCountry','-1','name','post','clear');clear_AreasCountry();setAreasCodeAndName()"
          onkeyup="code_CodeSelect(this,'AreasCountry','-1','name','post','clear');clear_AreasCountry();setAreasCodeAndName()"
          onblur="code_CodeChange(this,'AreasCountry','-1','name','post','clear');clear_AreasCountry();setAreasCodeAndName()"
          onchange="clear_AreasCountry();setAreasCodeAndName()"
          >
          </td>
          <td style="width:13%">
        <input type="hidden" name="AreasVillage">
        <input type="text" name="AreasVillageName" class="codename"  description="行政区域：行政村"
          querytype="always" codetype="AreasVillage" coderelation="-1" codelimit="clear"
          ondblclick="code_CodeSelect(this,'AreasVillage','-1','name','post','clear');clear_AreasVillage();setAreasCodeAndName()"
          onkeyup="code_CodeSelect(this,'AreasVillage','-1','name','post','clear');clear_AreasVillage();setAreasCodeAndName()"
          onblur="code_CodeChange(this,'AreasVillage','-1','name','post','clear');clear_AreasVillage();setAreasCodeAndName()"
          onchange="clear_AreasVillage();setAreasCodeAndName()"
          >       
        <input type="hidden" name="AreasCode" description="行政区域代码">
        <input type="hidden" name="AreasCName" description="行政区域名称">
        </td>
    </tr>
      </table>
      <table border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
      <tr>
       <td class='button' colspan="4">
          <input type=button class='button' name="queryButton"value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
      </tr>

    </table>

    <input type="hidden" name="editType" value="RegistBeforeQuery">
    <input type="hidden" name="nodeType" value="regis">
  </form>
  <iframe name=CodeFrame src="/claim/common/pub/QueryCodeInputOverview.jsp" style='DISPLAY:none;Z-INDEX:100;POSITION:absolute' marginwidth='0' marginheight='0' hspace='0' vspace='0' frameborder='0' scrolling='no'></iframe>
</body>
</html:html>
