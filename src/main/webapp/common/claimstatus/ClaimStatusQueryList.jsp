<%--
****************************************************************************
* DESC       : ����ڵ�״̬��ѯ���ҳ��
* AUTHOR     : liubvo
* CREATEDATE ��2004-05-28
* MODIFYLIST ��   id       Date            Reason/Contents
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
    <!-- ���ݽڵ��������ʾ���� -->
    <!-- Ԥ��ڵ� -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="prepa">
      <bean:message key="title.prepayBeforeEdit.titleName"/>
    </logic:equal>
    <!-- �����ڵ� -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="regis">
      <bean:message key="title.registBeforeEdit.titleName"/>
    </logic:equal>
    <!-- ʵ��ڵ� -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="compe">
      <bean:message key="title.compensateBeforeEdit.titleName"/>
    </logic:equal>
    <!-- �����ڵ� -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="claim">
      <bean:message key="title.claimBeforeEdit.titleName"/>
    </logic:equal>
     <!-- ���Ƚڵ� -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="sched">
      <bean:message key="title.scheduleBeforeEdit.titleName"/>
    </logic:equal>

    <!-- �鿱�ڵ� -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="check">
      <bean:message key="title.checkBeforeEdit.titleName"/>
    </logic:equal>
    <!-- �᰸�ڵ� -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="endca">
      <bean:message key="title.endcaseBeforeEdit.titleName"/>
    </logic:equal>
    <!-- ��֤�ռ��ڵ� -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certi">
      <bean:message key="title.certifyBeforeEdit.titleName"/>
    </logic:equal>
    <!-- ����ڵ� -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certa">
      <bean:message key="title.certainLossBeforeEdit.titleName"/>
    </logic:equal>
    <!-- ����ڵ� -->
    <logic:equal name="prpLclaimStatusDto" property="nodeType" value="verif">
      <bean:message key="title.verifyLossBeforeEdit.titleName"/>
    </logic:equal>
  </title>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<%
  int colCount=4; //��ʾһ��4��
  //����ǵ��ȵ�ʱ�����5��
  PrpLclaimStatusDto prpLclaimStatusDto = (PrpLclaimStatusDto)request.getAttribute("prpLclaimStatusDto");
  PrpLclaimStatusDto prpLclaimStatusDtoTemp = null;
  String registNoTemp = "";
 %>

<body  >

  <table  class="common" cellpadding="4" cellspacing="1" >

  <tr> <td colspan=4 class="formtitle">
              <!-- ���ݽڵ��������ʾ���� -->
              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="regis">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  δ��������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  ����������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  �Ѵ�������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  ���ύ������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  �ѳ���������Ϣ
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="claim">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  δ����������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  ������������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  �Ѵ���������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  ���ύ������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  �ѳ���������Ϣ
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="prepa">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  δ����Ԥ����Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  ������Ԥ����Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  �Ѵ���Ԥ����Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  ���ύԤ����Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  �ѳ���Ԥ����Ϣ
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="compe">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  δ����ʵ����Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  ������ʵ����Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  �Ѵ���ʵ����Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  ���ύʵ����Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  �ѳ���ʵ����Ϣ
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="sched">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  δ���������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  �����������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  �Ѵ��������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  ���ύ������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  �ѳ���������Ϣ
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="check">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  δ����鿱��Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  ������鿱��Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  �Ѵ���鿱��Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  ���ύ�鿱��Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  �ѳ����鿱��Ϣ
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="endca">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  δ����᰸��Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  ������᰸��Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  �Ѵ���᰸��Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  ���ύ�᰸��Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  �ѳ����᰸��Ϣ
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certi">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  δ����֤�ռ���Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  ������֤�ռ���Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  �Ѵ���֤�ռ���Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  ���ύ��֤�ռ���Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  �ѳ�����֤�ռ���Ϣ
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certa">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  δ��������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  ����������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  �Ѵ�������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  ���ύ������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  �ѳ���������Ϣ
                </logic:equal>
              </logic:equal>

              <logic:equal name="prpLclaimStatusDto" property="nodeType" value="verif">
                <logic:equal name="prpLclaimStatusDto" property="status" value="1">
                  δ���������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="2">
                  �����������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="3">
                  �Ѵ��������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="4">
                  ���ύ������Ϣ
                </logic:equal>
                <logic:equal name="prpLclaimStatusDto" property="status" value="5">
                  �ѳ���������Ϣ
                </logic:equal>
              </logic:equal>
            </td></tr>

     <tr>
        <td class="centertitle" >
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="prepa">
            <bean:message key="db.prpLprepay.preCompensateNo"/>
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="regis">
            ������
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="compe">
            ʵ���
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="claim">
            ������
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="check">
            ������
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="endca">
            �鵵��
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certi">
            ������
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certa">
            ������
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="verif">
            ������
          </logic:equal>
          <logic:equal name="prpLclaimStatusDto" property="nodeType" value="sched">
            ������
          </logic:equal>
        </td>
        <logic:equal name="prpLclaimStatusDto" property="nodeType" value="sched">
          <td class="centertitle" >���Ⱥ�</td>
        </logic:equal>
        <td class="centertitle" ><bean:message key="db.prpLregist.policyNo"/></td>
        <logic:equal name="prpLclaimStatusDto" property="nodeType" value="certa">
          <td class="centertitle" >��������</td>
        </logic:equal>
        <logic:equal name="prpLclaimStatusDto" property="nodeType" value="verif">
          <td class="centertitle" >��������</td>
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
	       ����ѯ��<%= index %>�����������ļ�¼
	      </td>
      </tr>
    </table>
   
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>