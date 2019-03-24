<%--
****************************************************************************
* DESC       ��ͨ�ô����ѯ����ҳ��,���������صĿ����,���������Ҫ��ʾ�����嵥ʱ���ô�ҳ��
*            ����ҳ��Ҫ���������쳣�����Բ����б�����󣬲����׳��κ��쳣
* AUTHOR     ��������Ŀ��
* CREATEDATE ��2002-12-23
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page contentType="text/html; charset=GBK" %>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.sysframework.common.util.*" %>
<%@page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@page import="com.sinosoft.sysframework.exceptionlog.*" %>
<%@page import="com.sinosoft.sysframework.reference.*" %>
<%@page import="com.sinosoft.claim.dto.domain.*" %>
<%@page import="com.sinosoft.claim.resource.dtofactory.domain.*" %>
<%@page import="com.sinosoft.claim.ui.control.action.*" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<%
  String codeindex = StringUtils.rightTrim(request.getParameter("codeindex"));
  String codevalue = StringUtils.rightTrim(request.getParameter("codevalue"));
  //if(codevalue == null || codevalue.equals("")){
  ///	codevalue = "*";
  //}
  String codetype  = StringUtils.rightTrim(request.getParameter("codetype" ));
  String relation  = StringUtils.rightTrim(request.getParameter("relation" ));
  String inputtype = StringUtils.rightTrim(request.getParameter("inputtype"));
  String querytype = StringUtils.rightTrim(request.getParameter("querytype"));
  String limit     = StringUtils.rightTrim(request.getParameter("limit"    ));
  String method    = StringUtils.rightTrim(request.getParameter("method"   ));
  String fieldsign = StringUtils.rightTrim(request.getParameter("fieldsign"));
  String other     = StringUtils.rightTrim(request.getParameter("other"    ));

  codevalue = new String(codevalue.getBytes("ISO8859-1")); //ת��
  StringBuffer buffer         = new StringBuffer(); // װ�ش����ѯ���
  String queryResult          = "";
  String errorMessage         = "";   // ������Ϣ
  int    recordSize           = -1;   // ��¼������Ϣ -1--null, 0--����0, 1--����0
  int    i                    = 0;
  int index = 0;
  String[] arrRelation;
  String[] arrCodeName        = new String[0];
  //�õ�����ҳ��ķ�ʽ,��ȷ���ǳ�������ҳ��,����ͨ��ҳ���ѯ����
  String submitMethod = request.getMethod();
  //���ִӻ�����ȡ��������
  String strRiskCode  = StringUtils.rightTrim(request.getParameter("riskcode"));
  if (strRiskCode.length()==0)
  {
     strRiskCode = "PUB";
  }
  //���ִӻ�����ȡ��������
  String strLanguage = "C";

%>

<%
  System.out.println("==��������============  "+submitMethod);
  //�����POST��ʽ����ҳ��,˵����Ҫͨ��ҳ���ѯ����,ִ�����²�ѯ����,����ֱ�ӷ���Ĭ��ҳ��
  if(submitMethod.equals("POST"))              // ��POST��ʽ����
  {
    Collection collection = new ArrayList();
    String conditions = "";  //�����ѯ����
    UICodeAction   uiCodeAction = new UICodeAction();
    //���ݲ�ͬ�Ĵ������ͽ��в�ѯ
    try
    {
      //1�����Ŵ����ת��
      if(codetype.equals("ComCode"))
      {
        if(method.equals("select"))
        {
          if(inputtype.equals("code"))
          {
            conditions = " comcode like '%" + codevalue + "%'";
          }
          else
          {
            conditions = " comcname like '%" + codevalue + "%'";
          }
        }
        else
        {
          if(inputtype.equals("code"))
          {
            conditions = " comcode like '%" + codevalue + "%'";
          }
          else
          {
            conditions = " comcname like '%" + codevalue + "%'";
          }
        }
        conditions = conditions+"  order by  comlevel,comcode ";
        collection = uiCodeAction.findByConditions(UICodeAction.COMCODE,conditions,0,0);
        recordSize=collection.size();
        for(Iterator iterator = collection.iterator();iterator.hasNext();)
        {
          PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)iterator.next();
          buffer.append("<option value='");
          buffer.append(prpDcompanyDto.getComCode());
          buffer.append("_FIELD_SEPARATOR_");
          buffer.append(prpDcompanyDto.getComCName());
          buffer.append("'>");
          buffer.append(prpDcompanyDto.getComCode());
          buffer.append("-");
          buffer.append(prpDcompanyDto.getComCName());
        }
      }
      else if(codetype.equals("Currency"))  //2���ұ�����ת��
      {
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
               conditions = " currencycode like '%"+codevalue +"%'";
            }
            else
            {
               conditions = " currencycname like '%"+codevalue +"%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
               conditions = " currencycode like '%" + codevalue + "%'";
            }
            else
            {
               conditions = " currencycname like '%" + codevalue + "%'";
            }
         }
         collection = uiCodeAction.findByConditions(UICodeAction.CURRENCYCODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcurrencyDto prpDcurrencyDto = (PrpDcurrencyDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcurrencyDto.getCurrencyCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcurrencyDto.getCurrencyCName());
           buffer.append("'>");
           buffer.append(prpDcurrencyDto.getCurrencyCode());
           buffer.append("-");
           buffer.append(prpDcurrencyDto.getCurrencyCName());
         }
      }
      else if(codetype.equals("KindCode")) //3���ձ�����ת��
      {
         conditions = "riskcode='"+strRiskCode+"' AND ValidStatus='1'";
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
               conditions = conditions + " AND kindcode like '%"+codevalue +"%'";
            }
            else
            {
               conditions = conditions + " AND kindcname like '%"+codevalue +"%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
               conditions = conditions + " AND kindcode like '%"+codevalue +"%'";
            }
            else
            {
               conditions = conditions + " AND kindcname like '%"+codevalue +"%'";
            }
         }
         collection = uiCodeAction.findByConditions(UICodeAction.KINDCODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDkindDto prpDkindDto = (PrpDkindDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDkindDto.getKindCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDkindDto.getKindCName());
           buffer.append("'>");
           buffer.append(prpDkindDto.getKindCode());
           buffer.append("-");
           buffer.append(prpDkindDto.getKindCName());
         }
      }
      else if(codetype.equals("ClauseCode")) //4����������ת��
      {
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " ClauseCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " ClauseName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " ClauseCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " ClauseName = '" + codevalue + "'";
            }
         }
         conditions = conditions +" AND LineNo=1"+" AND ValidStatus='1'"
                       + " AND ClauseCode IN"
                       + "( SELECT CodeCode FROM PrpDcodeRisk "
                       + " WHERE CodeType='ClauseCode'"
                       + " AND ( RiskCode='"+ strRiskCode
                       + "' OR RiskCode='PUB' )" + " )"
                       + " ORDER BY ClauseCode";
         collection = uiCodeAction.findByConditions(UICodeAction.CLAUSECODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDclauseDto prpDclauseDto = (PrpDclauseDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDclauseDto.getClauseCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDclauseDto.getClauseName());
           buffer.append("'>");
           buffer.append(prpDclauseDto.getClauseCode());
           buffer.append("-");
           buffer.append(prpDclauseDto.getClauseName());
         }
     }
     else if(codetype.equals("DamageCode")) //5������ԭ������ת��
      {
      System.out.print("Ҫ��ʼ���Դ���dedamageCode��----��"+conditions);

         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         }

         if conditions.equals("")
         {
            conditions = " codeType ='"+ codetype +"' order by codecname";
          }
          else
          {
           conditions = " codeType ='"+ codetype +"' and "+ conditions+"order by codecname";

          }

          System.out.print("Ҫ��ʼ���Դ�����----��"+conditions);

         collection = uiCodeAction.findByConditions(UICodeAction.DAMAGECODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodecode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodecode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }
      }
      else if(codetype.equals("DamageAreaCode")) //6��������������ת��
      {
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " DamageAreaCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " DamageAreaName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " DamageAreaCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " DamageAreaName = '" + codevalue + "'";
            }
         }
         collection = uiCodeAction.findByConditions(UICodeAction.DAMAGEAREACODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodecode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodecode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }
      }
      else if(codetype.equals("DamageTypeCode")) //7���¹����ʹ����ת��
      {
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " DamageTypeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " DamageTypeName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " DamageTypeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " DamageTypeName = '" + codevalue + "'";
            }
         }

         collection = uiCodeAction.findByConditions(UICodeAction.DamageTypeCode,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodecode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodecode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }
      }
      else if(codetype.equals("DocCode")) //8����֤�����ת��
      {
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " DocCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " DocName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " DocCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " DocName = '" + codevalue + "'";
            }
         }
         collection = uiCodeAction.findByConditions(UICodeAction.DocCode,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodecode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodecode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }
      }
     else if(codetype.equals("ClamCode")) //!!!����֪���Ĵ����ת��
     {
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
               conditions = " claimcode like '%"+codevalue +"%'";
            }
            else
            {
               conditions = " longname like '%"+codevalue +"%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
               conditions = " reinscode like '%"+codevalue +"%'";
            }
            else
            {
               conditions = " longname  like '%"+codevalue +"%'";
            }
         }
         collection = uiCodeAction.findByConditions(UICodeAction.REINSCODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           //PrpDreinsDto prpDreinsDto = (PrpDreinsDto)iterator.next();
           //buffer.append("<option value='");
           //buffer.append(prpDreinsDto.getPrpDreinsReinsCode());
           //buffer.append("_FIELD_SEPARATOR_");
           //buffer.append(prpDreinsDto.getPrpDreinsLongName());
           //buffer.append("'>");
           //buffer.append(prpDreinsDto.getPrpDreinsReinsCode());
           //buffer.append("-");
           //buffer.append(prpDreinsDto.getPrpDreinsLongName());
         }
      }

    }catch(Exception exception)
    {
      exception.printStackTrace();
      errorMessage = "��ѯʧ��";
    }
    queryResult = buffer.toString();
    System.out.println("queryresult"+queryResult);
  }
%>

<html>
<head>
  <title>�����ѯ</title>
  <app:css />
    <jsp:include page="/common/pub/StaticJavascript.jsp" />
    <script language="Javascript" src="/claim/common/js/PrivateInputCode.js"></script>

    <script language='javascript'>
        var fmInput;
        var fraInterface;
        try
        {
            //fraInterface= parent.fraMenu.fraInterface;
            //fmInput =fraInterface.fm;
            fmInput = parent.fraInterface.fm;

        }catch(E){
        }
    </script>
</head>
<body class="interface">
  <%--��ѯ�����󣬽���ѯ�������input�򴫻ص��ͻ��ˣ������ػ�ҳ�棬ʹ��ָ�����ʼ״̬--%>
  <form name='fm' action="/claim/common/pub/InputCode.jsp" method='POST'>
    <input type="hidden" name=codeindex value='<%=codeindex%>'>
    <input type="hidden" name=codevalue value='<%=codevalue%>'>
    <input type="hidden" name=codetype  value='<%=codetype%>'>
    <input type="hidden" name=relation  value='<%=relation%>'>
    <input type="hidden" name=inputtype value='<%=inputtype%>'>
    <input type="hidden" name=querytype value='<%=querytype%>'>
    <input type="hidden" name=limit value='<%=limit%>'>
    <input type="hidden" name=method    value='<%=method%>'>
    <input type="hidden" name=fieldsign value='<%=fieldsign%>'>
    <input type="hidden" name=other value='<%=other%>'>
    <input type="hidden" name=riskcode value='<%=strRiskCode%>'>

<%
    try
    {
        if(submitMethod.equals("POST")){//�����POST����
            out.println("<script language='javascript'>            ");
                if(!errorMessage.equals("")){//��ѯ����ʧ��
                out.println("    fm.elements["+codeindex+"].focus();");
                out.println("    window.status='��ѯ����ʧ��\t';");
                out.println("    parent.fraInterface.setInquery(false);");
                out.println("    parent.fraInterface.setQueryError(true);");
            }
            else if(method.equals("change") && recordSize>0){//��ѯ����ɹ���methodΪchange
                queryResult = queryResult.substring(queryResult.indexOf("<option value='") + ("<option value='").length(),queryResult.indexOf("'>"));
                arrCodeName = StringUtils.split(queryResult,"_FIELD_SEPARATOR");
                out.println("    window.status='��ѯ����<" + codevalue + ">�ɹ�';");
                out.println("    if(parent.fraInterface.getSign()==fm.fieldsign.value){");
                if(inputtype.equals("name")){
                    arrRelation = StringUtils.split("0,"+relation,",");
                    arrRelation[0] = arrRelation[1];
                    arrRelation[1] = "0";
                    for(i=0;i<arrRelation.length;i++){
                        index = Integer.parseInt(arrRelation[i]) + Integer.parseInt(DataUtils.nullToZero(codeindex));
                        if(querytype.equals("need") && i!=0){
                            out.println("        if(isEmpty(fmInput.elements["+ index +"])){");
                        }
                        if(i>arrCodeName.length-1){
                            out.println("            fmInput.elements["+ index +"].value = '"+arrCodeName[arrCodeName.length-1]+"';");
                            out.println("            fmInput.elements["+ index +"].tag = '"+arrCodeName[arrCodeName.length-1]+"';");
                        }
                        else{
                            out.println("            fmInput.elements["+ index +"].value = '"+arrCodeName[i]+"';");
                            out.println("            fmInput.elements["+ index +"].tag = '"+arrCodeName[i]+"';");
                        }
                        out.println("            try");
                        out.println("            {");
                        out.println("                if(fmInput.elements["+ index +"].onchange!=null){");
                        out.println("                    fmInput.elements["+ index +"].onchange();");
                        out.println("                }");
                        out.println("            }catch(Ex1){");
                        out.println("            }");
                        if(querytype.equals("need") && i!=0){
                        out.println("        }");
                        }
                    }
                }
                else{ //inputtype is code
                    arrRelation = StringUtils.split("0,"+relation,",");
                    for(i=0;i<arrRelation.length;i++){
                        index = Integer.parseInt(arrRelation[i]) + Integer.parseInt(DataUtils.nullToZero(codeindex));
                        if(querytype.equals("need") && i!=0){
                            out.println("        if(isEmpty(fmInput.elements["+ index +"])){");
                        }
                        if(i>arrCodeName.length-1){
                            out.println("            fmInput.elements["+ index + "].value = '"+arrCodeName[arrCodeName.length-1]+"';");
                            out.println("            fmInput.elements["+ index + "].tag = '"+arrCodeName[arrCodeName.length-1]+"';");
                        }
                        else{
                            out.println("            fmInput.elements["+ index +"].value = '"+arrCodeName[i]+"';");
                            out.println("            fmInput.elements["+ index +"].tag = '"+arrCodeName[i]+"';");
                        }
                        out.println("            try");
                        out.println("            {");
                        out.println("                if(fmInput.elements["+ index +"].onchange!=null){");
                        out.println("                    fmInput.elements["+ index +"].onchange();");
                        out.println("                }");
                        out.println("            }catch(Ex1){");
                        out.println("            }");
                        if(querytype.equals("need") && i!=0){
                            out.println("        }");
                        }
                    }
                }

                out.println("    }");
                out.println("    parent.fraInterface.setInquery(false);");
                out.println("    parent.fraInterface.setQueryError(false);");
            }
            else if(recordSize==0){//û�в鵽��������������
                arrRelation = StringUtils.split("0,"+relation,",");
                if (limit.equals("must") && !codevalue.equals("")){
                    out.println("    if(parent.fraInterface.getSign() == fm.fieldsign.value){");
                    out.println("        fmInput.elements[" + codeindex + "].focus();");
                    out.println("        window.status='����<" + codevalue + ">�����ڣ�����������';");
                    out.println("    }");
                }
                else{
                    if (limit.equals("clear") || (limit.equals("must") && codevalue.equals(""))){
                        out.println("    window.status='����<" + codevalue + ">�����ڣ���������';");
                        out.println("    if(parent.fraInterface.getSign() == fm.fieldsign.value){");

                        for(i=0;i<arrRelation.length;i++){
                            index = Integer.parseInt(arrRelation[i]) + Integer.parseInt(DataUtils.nullToZero(codeindex));

                            out.println("        fmInput.elements[" + index + "].value = '';");
                            out.println("        fmInput.elements[" + index + "].oldvalue = '';");
                        }
                        out.println("    }");
                    }
                    else if(limit.equals("none")){
                        out.println("    window.status='����<" + codevalue + ">������';");
                    }
                }
                out.println("    parent.fraInterface.setInquery(false);");
                out.println("    parent.fraInterface.setQueryError(true);");
            }
            out.println("</script>");

            if(errorMessage.equals("") && method.equals("select") && recordSize>0){ //methodΪselect�Ҳ�ѯ�����
System.out.println("buff"+buffer.toString());
%>
        <table class="common" style="width:100%" align="center">
          <tr>
            <td style="width:30%">
            </td>
            <td style="width:20%" align="center">
            <%// ȷ����ť%>
              <input type=button name=SelectIt class="button" value="<bean:message key='button.save.value' />" onclick='setFieldValue()'></input>
            </td>
            <td style="width:20%" align="center">
              <input type=button name=CancelIt  class="button" value="<bean:message key='button.cancel.value' />" onclick='cancelFieldValue()'></input>
            </td>
            <td style="width:30%">
            </td>
          </tr>
          <tr>
            <td colspan=4 align="center" style="width:100%">
<%
            if(codetype.equals("ItemCode1") && (codevalue.equals("*") || codevalue.length()<=4) || (codetype.equals("ItemCode2") && (codevalue.equals("*") || codevalue.length()<=4)))
            {
%>
              <select name=codeselect class="code" style='width:320px' size=8 onkeypress=fieldOnKeyPress() ondblclick="continueQueryItemCode()">
                <%=buffer.toString()%>
              </select>
<%
            }else
            {
%>
              <select name=codeselect class="code" style='width:320px' size=8 onkeypress=fieldOnKeyPress() ondblclick="setFieldValue()">
                <%=buffer.toString()%>
              </select>
<%
            }
%>
            </td>
          </tr>
        </table>
        <script language='javascript'>
          window.status='��ѯ����<<%=codevalue%>>�ɹ�';
          parent.fraRight.rows = "50%,0%,*";
          fm.codeselect.options.selectedIndex=0;
          fm.codeselect.focus();

          function continueQueryItemCode()
          {

             fm.codevalue.value = fm.codeselect.options[fm.codeselect.options.selectedIndex].value + "*";
             arrCodeValue = fm.codevalue.value.split(FIELD_SEPARATOR);
             fm.codevalue.value = arrCodeValue[0] + "*";
             fm.submit();
          }
        </script>
<%
            }
        }
    }catch(Exception e2)
    {
        e2.printStackTrace();
    }
%>
  </form>
</body>
</html>