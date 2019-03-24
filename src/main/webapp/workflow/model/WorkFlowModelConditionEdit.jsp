 <%--
****************************************************************************
* DESC       ��������ģ��·������¼��/�޸�ҳ��
* AUTHOR     ��weishixin
* CREATEDATE ��2004-08-22
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      ������ģ��·�������༭����
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/workflow/model/js/WorkFlowModelConditionEdit.js"></script>
</head>

<body class="interface" onload="initPage();">
    <form name=fm action="/claim/swfConditionSave.do" method="post">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
      <tr>
        <td class="title" colspan="4">������ģ��·������</td>
      </tr>
      <tr>

        <td class="title" >ģ��ţ�</td>
        <td class="input"  >
          <input type=text name="swfConditionModelNo" class="readonly" readonly="true" value="<bean:write name='swfConditionDto' property='modelNo' />">
        </td>
        <td class="title"  style="valign:bottom" >·���ţ�</td>
        <td class="input"  style="valign:middle">
          <input type=text name="swfConditionPathNo"  class="readonly" readonly="true" value="<bean:write name='swfConditionDto' property='pathNo'/>">
        </td>
        </tr>
        <tr>
        <td class="title"  style="valign:bottom" >·������</td>
        <td class="input"  style="valign:middle">
          <input type=text name="swfConditionPathNameNo"  class="readonly" readonly="true" value="<bean:write name='swfConditionDto' property='pathName'/>">
        </td>
        <td class=title  colspan="2"></td>
      </tr>

    </table>



   <table class="common" align="center">
    <!--��ʾ��ʾ���е�-->
    <tr >
      <td class="subformtitle" colspan="4" cellspacing="5" cellpadding="1">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="PersonLossImg" onclick="showPage(this,spanWfCondition)">������Ϣ<br>
        <span style="display:none">
          <table class="common" style="display:none" id="WorkFlowCondition_Data" cellspacing="5" cellpadding="1">
            <tbody>
           <tr>
          <td class="input" style="width:4%">
             <div align="center">
               <input class="readonlyNo" readonly name="swfConditionConditionNo" description="���">
             </div>
         </td>
         <td class="subformtitle" style="width:92%">
         <table  cellpadding="5" cellspacing="1" class="common" style="width:100%">
            <tbody>
                <tr>
                  <input type="hidden" name="swfConditionSerialNo" value="1">
                  <td class="title" >�������ͣ�</td>
                  <td class="input">
			          <html:select name="swfConditionDto" property="configType" styleClass="three" >
			              <html:option value="0" >������</html:option>
					      <html:option value="1" >SQL�������</html:option>
					      <html:option value="2" >�߼�����</html:option>
			          </html:select>
                  </td>
                  <td class="title">��Ч��־��</td>
                  <td class="input">
                    <html:select name="swfConditionDto" property="validStatus" styleClass="three" >
			              <html:option value="0" >��Ч</html:option>
					      <html:option value="1" >��Ч</html:option>
			         </html:select>
                  </td>
                </tr>
                <tr>
                  <td class="title">ҵ���ֵ��</td>
                  <td class="input">
                    <input class='common' name="swfConditionBusinessKey"
                      maxlength="18" description="ҵ���ֵ">
                  </td>
                  <td class="title">���ݿ�����</td>
                  <td class="input">
                    <input class='common' name="swfConditionDBName"
                      maxlength="20" description="���ݿ���">
                  </td>
                </tr>
                <tr>
                  <td class="title">������</td>
                  <td class="input">
                       <input class='common' name="swfConditionTableName"
                      maxlength="20" description="����">
                  </td>
                  <td  class="title">�ֶ����ͣ�</td>
                  <td class="input">
                     <input class='common' name="swfConditionDataType"
                      maxlength="255" description="�ֶ�����">
                  </td>
                </tr>
                <tr>
                  <td class='title'>�ֶ�����</td>
                  <td class="input">
                    <input class='common' name="swfConditionColumnName"
                      maxlength="20" description="�ֶ���">
                  </td>
                  <td class='title'>�ֶ�������</td>
                  <td class='input'>
                    <input class='common' name="swfConditionColumnDesc"
                      maxlength="60" description="�ֶ�����">
                  </td>
                </tr>
                <tr>
                  <td class='title'>�������</td>
                  <td class='input'>
                    <html:select name="swfConditionDto" property="operator" styleClass="three" >
			              <html:option value="=">=</html:option>
					      <html:option value="!=">!=</html:option>
					      <html:option value=">=">&gt;=</html:option>
					      <html:option value="<=">&lt;=</html:option>
					      <html:option value=">">&gt;</html:option>
					      <html:option value="<">&lt;</html:option>
					      <html:option value="in">in</html:option>
					      <html:option value="like">like</html:option>
			         </html:select>
                  </td>
                  <td class="title">�Ƚ�ֵ��</td>
                  <td class="input">
                    <input class='common' name="swfConditionValue"
                      maxlength="60" description="�Ƚ�ֵ">
                  </td>
                </tr>

            </tbody>
           </table>
           </td>
          <td class="input" style='width:4%'>
          <div align="center">
            <input type=button name="buttonWorkFlowConditionDelete"  onclick="deleteRow(this,'WorkFlowCondition')" value="-" style="cursor: hand">
          </div>
          </td>

       </tr>



            </tbody>
          </table>
        </span>
        <span  id="spanWfCondition" style="display:none">
        <%-- ��������չ���� --%>
        <table id="WorkFlowCondition" class="common" align="center" cellspacing="1" cellpadding="5">
          <thead>
             <tr>
                <td class="title" style="width:4%">���</td>
                <td class="title" style="width:96%" colspan=2 >����</td>
             </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=2 style="width:96%">(��"+"�ż�����������Ϣ����"-"�ż�ɾ��������Ϣ)</td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" onclick="insertRow('WorkFlowCondition')" name="buttonWorkFlowConditionInsert" style="cursor: hand">
                 </div>
                 </td>
              </tr>
           </tfoot>
          <tbody>

	        <%int indexCondition=0;%>

			<logic:notEmpty  name="swfConditionDto"  property="conditionList">
	        <logic:iterate id="swfCondition" name="swfConditionDto" property="conditionList">
              <tr>
		          <td class="input" style="width:4%">
		             <div align="center">
		               <input class="readonlyNo" readonly name="swfConditionConditionNo" description="���" value=<bean:write name="swfCondition" property="conditionNo"/>>
		             </div>
		         </td>
		         <td class="subformtitle" style="width:92%">
		         <table  cellpadding="5" cellspacing="1" class="common" >
		            <tbody>
		                <tr>
		                  <input type="hidden" name="swfConditionSerialNo" value=<bean:write name="swfCondition" property="serialNo"/>>
		                  <td class="title" >�������ͣ�</td>
		                  <td class="input">
					          <html:select name="swfCondition" property="configType" styleClass="three" >
					              <html:option value="0" >������</html:option>
							      <html:option value="1" >SQL�������</html:option>
							      <html:option value="2" >�߼�����</html:option>
					          </html:select>
		                  </td>
		                  <td class="title">��Ч��־��</td>
		                  <td class="input">
		                    <html:select name="swfCondition" property="validStatus" styleClass="three" >
					              <html:option value="0" >��Ч</html:option>
							      <html:option value="1" >��Ч</html:option>
					         </html:select>
		                  </td>
		                </tr>
		                <tr>
		                  <td class="title">ҵ���ֵ��</td>
		                  <td class="input">
		                    <input class='common' name="swfConditionBusinessKey"
		                      maxlength="18" description="ҵ���ֵ"  value=<bean:write name="swfCondition" property="businessKey"/>>
		                  </td>
		                  <td class="title">���ݿ�����</td>
		                  <td class="input">
		                    <input class='common' name="swfConditionDBName" maxlength="20" description="���ݿ���" value=<bean:write name="swfCondition" property="DBName"/>>
		                  </td>
		                </tr>
		                <tr>
		                  <td class="title">������</td>
		                  <td class="input">
		                       <input class='common' name="swfConditionTableName"
		                      maxlength="20" description="����" value=<bean:write name="swfCondition" property="tableName"/>>
		                  </td>
		                  <td  class="title">�ֶ����ͣ�</td>
		                  <td class="input">
		                     <input class='common' name="swfConditionDataType"
		                      maxlength="255" description="�ֶ�����" value=<bean:write name="swfCondition" property="dataType"/>>
		                  </td>
		                </tr>
		                <tr>
		                  <td class='title'>�ֶ�����</td>
		                  <td class="input">
		                    <input class='common' name="swfConditionColumnName"
		                      maxlength="20" description="�ֶ���" value=<bean:write name="swfCondition" property="columnName"/>>
		                  </td>
		                  <td class='title'>�ֶ�������</td>
		                  <td class='input'>
		                    <input class='common' name="swfConditionColumnDesc"
		                      maxlength="60" description="�ֶ�����" value=<bean:write name="swfCondition" property="columnDesc"/>>
		                  </td>
		                </tr>
		                <tr>
		                  <td class='title'>�������</td>
		                  <td class='input'>
		                    <html:select name="swfCondition" property="operator" styleClass="three" >
					              <html:option value="=">=</html:option>
							      <html:option value="!=">!=</html:option>
							      <html:option value=">=">&gt;=</html:option>
							      <html:option value="<=">&lt;=</html:option>
							      <html:option value=">">&gt;</html:option>
							      <html:option value="<">&lt;</html:option>
							      <html:option value="in">in</html:option>
							      <html:option value="like">like</html:option>
					         </html:select>
		                  </td>
		                  <td class="title">�Ƚ�ֵ��</td>
		                  <td class="input">
		                    <input class='common' name="swfConditionValue"
		                      maxlength="60" description="�Ƚ�ֵ" value=<bean:write name="swfCondition" property="value"/>>
		                  </td>
		                </tr>

		            </tbody>
		           </table>
		           </td>
		          <td class="input" style='width:4%'>
		          <div align="center">
		            <input type=button name="buttonWorkFlowConditionDelete"  onclick="deleteRow(this,'WorkFlowCondition')" value="-" style="cursor: hand">
		          </div>
		          </td>

		       </tr>
	        <% indexCondition++;%>
	        </logic:iterate>
	        </logic:notEmpty>

          </tbody>
        </table>
        </span>
      </td>
    </tr>
  </table>

  <input type=hidden name="editType" value="<bean:write name='swfConditionDto' property='editType' filter='true' />">


          <table cellpadding="0" cellspacing="0" width="100%" style="display:">

            <tr>
              <td class=button style="width:50%" align="center">
                <!--���水ť-->
                <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value'/>" onclick="return submitForm();">
              </td>

             <td class=button style="width:50%" align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
             </td>

        </tr>
      </table>
     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
