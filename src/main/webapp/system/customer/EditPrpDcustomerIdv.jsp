<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.platform.dto.domain.PrpDcodeDto" %>
<%@page import="com.sinosoft.platform.dto.domain.PrpDcompanyDto" %>
<%@page import="com.sinosoft.platform.dto.domain.PrpDcustomerIdvDto" %>
<%@page import="com.sinosoft.platform.bl.facade.*" %>
<%@page import="java.util.*" %>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>

<html>
<head>

<link href="/claim/css/Standard.css" rel="stylesheet" type="text/css">

  <script language="javascript">
    function checkIdentifyNumber()
    {
     /*modify by kangzhen  现在证件类型改成只读的，不需要这个判断
      if(fm.prpDcustomerIdvIdentifyNumber.value!=fm.identifyNumber.value)
      {
        alert("身份证号码与承保时输入的身份证号码不符，请核对后重新输入");
        return false;
      }
      */
     return true;
    }
  
    function submitFormToSave()
    {
      if(checkIdentifyNumber()==false)
      {
        return false;
      }
      if(!validateForm(fm))
      {
        return false;
      }
     
      fm.submit();

      return true;
    }
  </script>

<%
  //PrpDcustomerIdvDto prpDcustomerIdvDto=(PrpDcustomerIdvDto)request.getAttribute("prpDcustomerIdvDto");
  UIPrpDcustomerIdvAction uiPrpDcustomerIdvAction = new UIPrpDcustomerIdvAction();
  String policyNo=(String)request.getAttribute("prpCmainPolicyNo");

  
  String insuredCode=(String)request.getAttribute("prpDcustomerIdvCustomerCode");
  String conditions="policyNo='"+policyNo+ "'and InsuredCode='"+insuredCode+"'";
  //String conditions=" InsuredCode='"+insuredCode+"'";
  String identifyNumber=uiPrpDcustomerIdvAction.findIdentifyNumber(conditions);
%>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="initPage();initSet();" >
<form name="fm" method="post" action="/claim/processPrpDcustomerIdv.do" onsubmit="return validateForm(this,'CustomerIdv','');">
<input type="hidden" name="actionType" value="<%=request.getParameter("actionType")%>">
	<table border="0" align="center" cellpadding="0" cellspacing="0" class="common" >
	  <tr>
	    <td width="184" height="26" valign="bottom">
	      <table width="184" height="19" border="0" cellpadding="0" cellspacing="0">
	        <tr>
	          <td><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
	          <td width="161" class="formtitle">编辑个人客户资料</td>
	          <td><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
	        </tr>
	      </table>
	    </td>
	    <td valign="bottom"><font color="#666666">&nbsp;</td>
	  </tr>
	</table>
<table  border="0" id="CustomerIdv" align="center" cellpadding="4" cellspacing="1" width="100%" bgcolor="#2D8EE1" class="title" >


<%
     PrpDcustomerIdvDto prpDcustomerIdvDto = (PrpDcustomerIdvDto)request.getAttribute("prpDcustomerIdvDto");
    if(request.getParameter("actionType").equals("insert")){
%>
        <tr>
          <td width="15%" class="title">客户代码：</td>
          <td width="35%" class="input"> 系统自动生成
          </td>
          <td width="15%" class="title"></td>
          <td width="35%" class="input">
          </td>
        </tr>
<%
    }else{
%>
        <tr>
          <td width="15%" class="title">客户代码：</td>
          <td width="35%" class="input">
            <bean:write name="prpDcustomerIdvDto" property="customerCode" />
            <input type="hidden" name="prpDcustomerIdvCustomerCode" value="<bean:write name="prpDcustomerIdvDto" property="customerCode" />">
          </td>
          <td width="15%" class="title"></td>
          <td width="35%" class="input">
          </td>
        </tr>
<%
    }
%>
        <tr>
          <td width="15%" class="title">速查索引码：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvShortHandCode" value="<bean:write name="prpDcustomerIdvDto" property="shortHandCode" />">
          </td>
          <td width="15%" class="title">客户中文名称：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvCustomerCName" value="<bean:write name="prpDcustomerIdvDto" property="customerCName" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">客户英文名称：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvCustomerEName" value="<bean:write name="prpDcustomerIdvDto" property="customerEName" />">
          </td>
          <td width="15%" class="title">地址中文名称：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvAddressCName" value="<bean:write name="prpDcustomerIdvDto" property="addressCName" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">地址英文名称：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvAddressEName" value="<bean:write name="prpDcustomerIdvDto" property="addressEName" />">
          </td>
          <td width="15%" class="title">证件类型：</td>
          <td width="35%" class="input">
             <%-- modify by kangzhen  reason: 不允许修改证件类型
             <input type="text" class="codecode" Style="width:20%" name="prpDcustomerIdvIdentifyType" value="<bean:write name="prpDcustomerIdvDto" property="identifyType" />"
              ondblclick="code_CodeSelect(this,'IdentifyType');"
              onkeyup="code_CodeSelect(this,'IdentifyType');">  
             <input type="text" class="codecode" Style="width:40%" name="prpDcustomerIdvIdentifyTypeName"  value="<bean:write name="prpDcustomerIdvDto" property="identifyTypeName" />"
              ondblclick="code_CodeSelect(this,'IdentifyType','-1','Y');"
              onkeyup="code_CodeSelect(this,'IdentifyType','-1','Y');"> 
              --%>
              <bean:write name="prpDcustomerIdvDto" property="identifyType" />-<bean:write name="prpDcustomerIdvDto" property="identifyTypeName" />
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">证件号码：</td>
          <td width="35%" class="input">
             <%--
             <input type="text" class="common" name="prpDcustomerIdvIdentifyNumber" value="<bean:write name="prpDcustomerIdvDto" property="identifyNumber" />">
             --%>
             <bean:write name="prpDcustomerIdvDto" property="identifyNumber" />
             <input type="hidden" class="common" name="identifyNumber" value="<%=identifyNumber%>"> 
          </td>
          <td width="15%" class="title">资信等级：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvCreditLevel" value="<bean:write name="prpDcustomerIdvDto" property="creditLevel" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">性别：</td>
          <td width="35%" class="input">
             <select name="prpDcustomerIdvSex" style="width:20%">
                   <option value="1" <%if(prpDcustomerIdvDto.getSex().equals("1")){out.print("selected");}%> >男</option>
                   <option value="0" <%if(prpDcustomerIdvDto.getSex().equals("0")){out.print("selected");}%>>女</option>
             </select>
       </td>
          <td width="15%" class="title">年龄：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvAge" value="<bean:write name="prpDcustomerIdvDto" property="age" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">健康状况：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvHealth" value="<bean:write name="prpDcustomerIdvDto" property="health" />">
          </td>
          <td width="15%" class="title">职业代码：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvOccupationCode" value="<bean:write name="prpDcustomerIdvDto" property="occupationCode" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">学历代码：</td>
          <td width="35%" class="input">
           <input type="hidden" class="common" name="prpDcustomerIdvEducationCodeHidden" >
             <select class="common" name="prpDcustomerIdvEducationCode">
             <%
          BLPrpDcodeFacade blPrpDcodeFacade = new BLPrpDcodeFacade();
          Collection educationCollection = blPrpDcodeFacade.findByConditions( "codetype='EducationCode'");
          if(educationCollection !=null){
            for(Iterator iterator = educationCollection.iterator();iterator.hasNext();){
                PrpDcodeDto  prpDcodeDto= (PrpDcodeDto)iterator.next();
             %>
                <option value=<%= prpDcodeDto.getCodeCode()%>  
                <%if(prpDcodeDto.getCodeCode().equals(prpDcustomerIdvDto.getEducationCode())){out.print("selected");}%>

               ><%= prpDcodeDto.getCodeCode()%>-<%= prpDcodeDto.getCodeCName()%></option>
              <%
              }
            }
              %>
             </select>
          </td>
          <!--
          <input type="text" class="codecode" name="prpDcustomerIdvEducationCode"
              value="<bean:write name="prpDcustomerIdvDto" property="educationCode" />"
              ondblclick="code_CodeSelect(this,'EducationCode','0','Y');"
              onkeyup="code_CodeSelect(this,'EducationCode','0','Y');"
              onchange="code_CodeChange(this,'EducationCode','0','Y');">
          </td>
          -->
          <td width="15%" class="title">工作单位：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvUnit" value="<bean:write name="prpDcustomerIdvDto" property="unit" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">单位地址：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvUnitAddress" value="<bean:write name="prpDcustomerIdvDto" property="unitAddress" />">
          </td>
          <td width="15%" class="title">客户类型：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvCustomerKind" value="<bean:write name="prpDcustomerIdvDto" property="customerKind" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">客户标志：</td>
          <td width="35%" class="input">
          <html:select name="prpDcustomerIdvDto" property="customerFlag" styleClass="one">
         	    <html:options  collection="customerFlagFList" property="value" labelProperty="label"/>
          </html:select>
          </td>
          <td width="15%" class="title">电话：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvPhoneNumber" value="<bean:write name="prpDcustomerIdvDto" property="phoneNumber" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">传真：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvFaxNumber" value="<bean:write name="prpDcustomerIdvDto" property="faxNumber" />">
          </td>
          <td width="15%" class="title">手机：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvMobile" value="<bean:write name="prpDcustomerIdvDto" property="mobile" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">通信地址：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvLinkAddress" value="<bean:write name="prpDcustomerIdvDto" property="linkAddress" />">
          </td>
          <td width="15%" class="title">邮编：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvPostCode" value="<bean:write name="prpDcustomerIdvDto" property="postCode" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">呼机：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvPager" value="<bean:write name="prpDcustomerIdvDto" property="pager" />">
          </td>
          <td width="15%" class="title">电子信箱：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvEmail" value="<bean:write name="prpDcustomerIdvDto" property="email" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">开户银行：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvBank" value="<bean:write name="prpDcustomerIdvDto" property="bank" />">
          </td>
          <td width="15%" class="title">银行帐号：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvAccount" value="<bean:write name="prpDcustomerIdvDto" property="account" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">死亡时间：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvDeathDate" value="<bean:write name="prpDcustomerIdvDto" property="deathDate" />">
          </td>
          <td width="15%" class="title">黑名单标志：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvBlackState" value="<bean:write name="prpDcustomerIdvDto" property="blackState" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">新的客户代码：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvNewCustomerCode" value="<bean:write name="prpDcustomerIdvDto" property="newCustomerCode" />"><img src="/claim/images/imgMustInput.gif"/>
          </td>
          <td width="15%" class="title">效力状态：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvValidStatus" value="<bean:write name="prpDcustomerIdvDto" property="validStatus" />"><img src="/claim/images/imgMustInput.gif"/>
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">专项代码：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvArticleCode" value="<bean:write name="prpDcustomerIdvDto" property="articleCode" />">
          </td>
          <td width="15%" class="title">出生日期：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvBirthday" value="<bean:write name="prpDcustomerIdvDto" property="birthDate" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">网址：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvNetAddress" value="<bean:write name="prpDcustomerIdvDto" property="netAddress" />">
          </td>
          <td width="15%" class="title">归属业务员代码：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvHandlerCode" value="<bean:write name="prpDcustomerIdvDto" property="handlerCode" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">操作员代码：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvOperatorCode" value="<bean:write name="prpDcustomerIdvDto" property="operatorCode" />">
          </td>
          <td width="15%" class="title">输入日期：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvInputDate" value="<bean:write name="prpDcustomerIdvDto" property="inputDate" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">最后一次修改人：</td>
          <td width="35%" class="input">
             <input type="text" class="common" name="prpDcustomerIdvUpdaterCode" value="<bean:write name="prpDcustomerIdvDto" property="updaterCode" />">
          </td>
          <td width="15%" class="title">修改日期：</td>
          <td width="35%" class="input">
            <input type="text" class="common" name="prpDcustomerIdvUpdateDate" value="<bean:write name="prpDcustomerIdvDto" property="updateDate" />">
          </td>
        </tr>
        <tr>
          <td width="15%" class="title">归属机构代码：</td>
          <td width="35%" class="input">
           <input type="hidden" class="common" name="prpDcustomerIdvComcodeHidden" >
             <select class="common" name="prpDcustomerIdvComcode">
             <%

             BLPrpDcompanyFacade blPrpDcompanyFacade = new BLPrpDcompanyFacade();
             Collection comCodeCollection = blPrpDcompanyFacade.findByConditions( " 1=1 ");
             if(comCodeCollection !=null){
               for(Iterator iterator = comCodeCollection.iterator();iterator.hasNext();){
                   PrpDcompanyDto prpDcompanyDto= (PrpDcompanyDto)iterator.next();
                %>
                   <option value="<%=prpDcompanyDto.getComCode()%>"     
                 <%
                    if(prpDcompanyDto.getComCode().equals(prpDcustomerIdvDto.getComCode()))
                    {
                       out.print("selected");
                    }
                  %>
                     ><%= prpDcompanyDto.getComCode()%>-<%= prpDcompanyDto.getComCName()%></option>
                 <%
                 }
               }
            %>
             </select>
          </td>
          <%--modify by kangzhen--%>
          <%--
            <input type="text" class="codecode" name="prpDcustomerIdvComcode"
              value="<bean:write name="prpDcustomerIdvDto" property="comCode" />"
              ondblclick="code_CodeSelect(this,'comCode','0,1','Y');"
              onkeyup="code_CodeSelect(this,'comCode','0,1','Y');"
              onchange="code_CodeChange(this,'comCode','0,1','Y');">
          </td>
          --%>
          <td width="15%" class="title">下级查看权限：</td>
          <td width="35%" class="input">
            <html:select name="prpDcustomerIdvDto" property="lowerViewFlag" styleClass="one">
         	    <html:options  collection="lowerViewFList" property="value" labelProperty="label"/>
          </html:select>
          </td>
        </tr>
      </table>
      &nbsp; <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr align="center">
          <td><input type="button" class="button" value="保 存" src="/claim/images/btnSave.gif" onclick="return submitFormToSave(fm,'','')" width="75" height="20" border="0"></td>
        </tr>
      </table></td>
  </tr>
</table>


</form>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
<script language="Javascript">
//学历代码：

       function initSet(){
	 for(var i=0;i<fm.prpDcustomerIdvEducationCode.length;i++){
	  if (fm.prpDcustomerIdvEducationCode[i].value==fm.prpDcustomerIdvEducationCodeHidden.value){
		  fm.prpDcustomerIdvEducationCode[i].selected=true;
		}
	 }
	 for(var i=0;i<fm.prpDcustomerIdvComcode.length;i++){
	  if (fm.prpDcustomerIdvComcode[i].value==fm.prpDcustomerIdvComcodeHidden.value){
		  fm.prpDcustomerIdvComcode[i].selected=true;
		}
	 }
       }
</script>
</body>
</html>
