<%--
****************************************************************************
* DESC       : 理赔节点状态查询结果页面
* AUTHOR     : liubvo
* CREATEDATE ：2004-05-28
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="java.util.*"%>

<html:html locale="true">
<head>
    <app:css />

  <title>
    <!-- 根据节点的类型显示标题 -->
    <!-- 预赔节点 -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="prepa">
      <bean:message key="title.prepayBeforeEdit.titleName"/>
    </logic:equal>
    <!-- 报案节点 -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="regis">
      <bean:message key="title.registBeforeEdit.titleName"/>
    </logic:equal>
    <!-- 实赔节点 -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="compe">
      <bean:message key="title.compensateBeforeEdit.titleName"/>
    </logic:equal>
    <!-- 立案节点 -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="claim">
      <bean:message key="title.claimBeforeEdit.titleName"/>
    </logic:equal>
     <!-- 调度节点 -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="sched">
      <bean:message key="title.scheduleBeforeEdit.titleName"/>
    </logic:equal>

    <!-- 查勘节点 -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="check">
      <bean:message key="title.checkBeforeEdit.titleName"/>
    </logic:equal>
    <!-- 结案节点 -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="endca">
      <bean:message key="title.endcaseBeforeEdit.titleName"/>
    </logic:equal>
    <!-- 单证收集节点 -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certi">
      <bean:message key="title.certifyBeforeEdit.titleName"/>
    </logic:equal>
    <!-- 定损节点 -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certa">
      <bean:message key="title.certainLossBeforeEdit.titleName"/>
    </logic:equal>
    <!-- 核损节点 -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="verif">
      <bean:message key="title.verifyLossBeforeEdit.titleName"/>
    </logic:equal>
  </title>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<%
  int colCount=4; //表示一共4列
  //如果是调度的时候就是5列
  PrpLclaimStatusDto prpLclaimStatusDto = (PrpLclaimStatusDto)request.getAttribute("prpLclaimStatusDto");
  PrpLclaimStatusDto prpLclaimStatusDtoTemp = null;
  String registNoTemp = "";
 %>

<body  >

  <table  class="common" cellpadding="4" cellspacing="1" >

  <tr> <td colspan=4 class="formtitle">
              <!-- 根据节点的类型显示内容 -->
              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="regis">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  未处理报案信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  正处理报案信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  已处理报案信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  已提交报案信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  已撤消报案信息
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="claim">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  未处理立案信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  正处理立案信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  已处理立案信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  已提交立案信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  已撤消立案信息
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="prepa">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  未处理预赔信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  正处理预赔信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  已处理预赔信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  已提交预赔信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  已撤消预赔信息
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="compe">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  未处理实赔信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  正处理实赔信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  已处理实赔信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  已提交实赔信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  已撤消实赔信息
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="sched">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  未处理调度信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  正处理调度信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  已处理调度信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  已提交调度信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  已撤消调度信息
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="check">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  未处理查勘信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  正处理查勘信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  已处理查勘信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  已提交查勘信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  已撤消查勘信息
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="endca">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  未处理结案信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  正处理结案信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  已处理结案信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  已提交结案信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  已撤消结案信息
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certi">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  未处理单证收集信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  正处理单证收集信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  已处理单证收集信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  已提交单证收集信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  已撤消单证收集信息
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certa">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  未处理定损信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  正处理定损信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  已处理定损信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  已提交定损信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  已撤消定损信息
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="verif">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  未处理核损信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  正处理核损信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  已处理核损信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  已提交核损信息
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  已撤消核损信息
                </logic:equal>
              </logic:equal>
            </td></tr>

     <tr>
        <td class="centertitle" >
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="prepa">
            <bean:message key="db.prpLprepay.preCompensateNo"/>
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="regis">
            报案号
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="compe">
            实赔号
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="claim">
            立案号
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="check">
            报案号
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="endca">
            归档号
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certi">
            报案号
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certa">
            报案号
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="verif">
            报案号
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="sched">
            报案号
          </logic:equal>
        </td>
        <logic:equal name="prpLclaimStatusDto" property="nodeType" value="sched">
          <td class="centertitle" >调度号</td>
        </logic:equal>
        <td class="centertitle" ><bean:message key="db.prpLregist.policyNo"/></td>
        <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certa">
          <td class="centertitle" >定损类型</td>
        </logic:equal>
        <logic:equal name="prpLclaimStatusDto" property="nodeType" value="verif">
          <td class="centertitle" >核损类型</td>
        </logic:equal>
        <td class="centertitle" ><bean:message key="db.prpLregist.operatorCode"/></td>
        <td class="centertitle" ><bean:message key="db.prpLregist.inputDate"/></td>
     </tr>
     <%int index=0;%>
     <%
     if(prpLclaimStatusDto.getClaimList()!=null){
       ArrayList list = (ArrayList)prpLclaimStatusDto.getClaimList();
       for(int i=0;i<list.size();i++){
         prpLclaimStatusDtoTemp = (PrpLclaimStatusDto)list.get(i);
     %>
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
        <td align="center">
        <%
          if(prpLclaimStatusDto.getNodeType().equals("prepa")){
        %>
            <a href="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo=<%= prpLclaimStatusDtoTemp.getBusinessNo() %>&editType=<%= prpLclaimStatusDto.getEditType() %>&riskCode=<%= prpLclaimStatusDtoTemp.getRiskCode() %>"><%= prpLclaimStatusDtoTemp.getBusinessNo() %></a>
        <%
          }
        %>

        <%
          if(prpLclaimStatusDto.getNodeType().equals("regis")){
        %>
            <a href="/claim/registFinishQueryList.do?prpLregistRegistNo=<%= prpLclaimStatusDtoTemp.getBusinessNo() %>&editType=<%= prpLclaimStatusDto.getEditType() %>&riskCode=<%= prpLclaimStatusDtoTemp.getRiskCode() %>"><%= prpLclaimStatusDtoTemp.getBusinessNo() %></a>
        <%
          }
        %>

        <%
          if(prpLclaimStatusDto.getNodeType().equals("compe")){
        %>
            <a href="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo=<%= prpLclaimStatusDtoTemp.getBusinessNo() %>&editType=<%= prpLclaimStatusDto.getEditType() %>&riskCode=<%= prpLclaimStatusDtoTemp.getRiskCode() %>"><%= prpLclaimStatusDtoTemp.getBusinessNo() %></a>
        <%
          }
        %>
        <%
          if(prpLclaimStatusDto.getNodeType().equals("claim")){
        %>
            <a href="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<%= prpLclaimStatusDtoTemp.getBusinessNo() %>&editType=<%= prpLclaimStatusDto.getEditType() %>&riskCode=<%= prpLclaimStatusDtoTemp.getRiskCode() %>"><%= prpLclaimStatusDtoTemp.getBusinessNo() %></a>
        <%
          }
        %>
        <%
          if(prpLclaimStatusDto.getNodeType().equals("check")){
        %>
            <a href="/claim/checkFinishQueryList.do?prpLcheckCheckNo=<%= prpLclaimStatusDtoTemp.getBusinessNo() %>&editType=<%= prpLclaimStatusDto.getEditType() %>&riskCode=<%= prpLclaimStatusDtoTemp.getRiskCode() %>"><%= prpLclaimStatusDtoTemp.getBusinessNo() %></a>
        <%
          }
        %>
        <%
          if(prpLclaimStatusDto.getNodeType().equals("endca")){
        %>
            <a href="/claim/endcaseFinishQueryList.do?prpLendcaseEndcaseNo=<%= prpLclaimStatusDtoTemp.getBusinessNo() %>&editType=<%= prpLclaimStatusDto.getEditType() %>&riskCode=<%= prpLclaimStatusDtoTemp.getRiskCode() %>"><%= prpLclaimStatusDtoTemp.getBusinessNo() %></a>
        <%
          }
        %>
        <%
          if(prpLclaimStatusDto.getNodeType().equals("certi")){
        %>
            <a href="/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo=<%= prpLclaimStatusDtoTemp.getBusinessNo() %>&editType=<%= prpLclaimStatusDto.getEditType() %>&riskCode=<%= prpLclaimStatusDtoTemp.getRiskCode() %>"><%= prpLclaimStatusDtoTemp.getBusinessNo() %></a>
        <%
          }
        %>

        <%
          if(prpLclaimStatusDto.getNodeType().equals("certa")){
            if(!registNoTemp.equals(prpLclaimStatusDtoTemp.getBusinessNo())){
        %>
            <a href="/claim/certainLossBeforeEdit.do?RegistNo=<%= prpLclaimStatusDtoTemp.getBusinessNo() %>&editType=SelectLossType"><%= prpLclaimStatusDtoTemp.getBusinessNo() %></a>
        <%
          } else {
        %>
          &nbsp;
        <%
          }
          }
        %>
        <%
          if(prpLclaimStatusDto.getNodeType().equals("verif")){
        %>
            <a href="/claim/verifyLossFinishQueryList.do?prpLverifyLossRegistNo=<%= prpLclaimStatusDtoTemp.getBusinessNo() %>&editType=<%= prpLclaimStatusDto.getEditType() %>&riskCode=<%= prpLclaimStatusDtoTemp.getRiskCode() %>&lossTypeFlag=<%= prpLclaimStatusDtoTemp.getTypeFlag() %>"><%= prpLclaimStatusDtoTemp.getBusinessNo() %></a>
        <%
          }
        %>
        <%
          if(prpLclaimStatusDto.getNodeType().equals("sched")){
        %>
            <a href="/claim/scheduleFinishQueryList.do?prpLscheduleMainWFRegistNo=<%= prpLclaimStatusDtoTemp.getBusinessNo() %>&editType=<%= prpLclaimStatusDto.getEditType() %>&riskCode=<%= prpLclaimStatusDtoTemp.getRiskCode() %>&prpLscheduleMainWFScheduleID=<%= prpLclaimStatusDtoTemp.getSerialNo() %>"><%= prpLclaimStatusDtoTemp.getBusinessNo() %></a>
        <%
          }
        %>

        </td>


        <%
          if(prpLclaimStatusDto.getNodeType().equals("sched")){
        %>
           <td align="center"><%= prpLclaimStatusDtoTemp.getSerialNo() %></td>
       <%
          }
        %>

        <td align="center"><%= prpLclaimStatusDtoTemp.getPolicyNo() %></td>

        <%
          if(prpLclaimStatusDto.getNodeType().equals("certa")){
            if(prpLclaimStatusDtoTemp.getStatus().equals("5")){
        %>
           <td align="center"><a href="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo=<%= prpLclaimStatusDtoTemp.getBusinessNo() %>&editType=<%= prpLclaimStatusDto.getEditType() %>&riskCode=<%= prpLclaimStatusDtoTemp.getRiskCode() %>&lossTypeFlag=<%= prpLclaimStatusDtoTemp.getTypeFlag() %>&flag=1"><%= prpLclaimStatusDtoTemp.getTypeFlagName() %></a></td>
       <%
          } else {
        %>
            <td align="center"><a href="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo=<%= prpLclaimStatusDtoTemp.getBusinessNo() %>&editType=<%= prpLclaimStatusDto.getEditType() %>&riskCode=<%= prpLclaimStatusDtoTemp.getRiskCode() %>&lossTypeFlag=<%= prpLclaimStatusDtoTemp.getTypeFlag() %>"><%= prpLclaimStatusDtoTemp.getTypeFlagName() %></a></td>
        <%
            }
          }
        %>

        <%
          if(prpLclaimStatusDto.getNodeType().equals("verif")){
        %>
           <td align="center"><%= prpLclaimStatusDtoTemp.getTypeFlagName() %></td>
       <%
          }
        %>
        <td align="center"><%= prpLclaimStatusDtoTemp.getHandlerCode() %></td>
        <td align="center"><%= prpLclaimStatusDtoTemp.getInputDate() %></td>

<%        index++;
registNoTemp=prpLclaimStatusDtoTemp.getBusinessNo();
      }
    }
%>
      <tr class="listtail">
     <logic:equal name="prpLclaimStatusDto" property="nodeType" value="sched">
	    <%  colCount=5;%>
	   </logic:equal>

	      <td colspan=<%=colCount+1%>>
	       共查询出<%= index %>条满足条件的记录
	      </td>
      </tr>
    </table>
   
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>