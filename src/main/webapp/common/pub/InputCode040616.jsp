<%--
****************************************************************************
* DESC       ：通用代码查询处理页面,包含在隐藏的框架中,输入过程中要显示代码清单时调用此页面
*            ：此页面要处理所有异常，绝对不能有编译错误，不能抛出任何异常
* AUTHOR     ：理赔项目组
* CREATEDATE ：2002-12-23
* MODIFYLIST ：   Name       Date            Reason/Contents
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

  codevalue = new String(codevalue.getBytes("ISO8859-1")); //转换
  StringBuffer buffer         = new StringBuffer(); // 装载代码查询结果
  String queryResult          = "";
  String errorMessage         = "";   // 错误信息
  int    recordSize           = -1;   // 记录条数信息 -1--null, 0--等于0, 1--大于0
  int    i                    = 0;
  int index = 0;
  String[] arrRelation;
  String[] arrCodeName        = new String[0];
  //得到请求页面的方式,以确定是初次下载页面,还是通过页面查询代码
  String submitMethod = request.getMethod();
  //险种从画面中取，待修正
  String strRiskCode  = StringUtils.rightTrim(request.getParameter("riskcode"));
  if (strRiskCode.length()==0)
  {
     strRiskCode = "PUB";
  }
  //语种从画面中取，待修正
  String strLanguage = "C";

%>

<%
  System.out.println("==☆☆☆☆☆☆☆============  "+submitMethod);
  //如果是POST方式请求页面,说明是要通过页面查询代码,执行以下查询程序,否则直接返回默认页面
  if(submitMethod.equals("POST"))              // 以POST方式请求
  {
    Collection collection = new ArrayList();
    String conditions = "";  //代码查询条件
    UICodeAction   uiCodeAction = new UICodeAction();
    //根据不同的代码类型进行查询
    try
    {
      //1。部门代码的转换
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
      else if(codetype.equals("Currency"))  //2。币别代码的转换
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
      else if(codetype.equals("KindCode")) //3。险别代码的转换
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
      else if(codetype.equals("ClauseCode")) //4。条款代码的转换
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
     else if(codetype.equals("DamageCode")) //5。出险原因代码的转换
      {
      System.out.print("要开始测试代码dedamageCode啦----："+conditions);

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

          System.out.print("要开始测试代码啦----："+conditions);

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
      else if(codetype.equals("DamageAreaCode")) //6。出险区域代码的转换
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
      else if(codetype.equals("DamageTypeCode")) //7。事故类型代码的转换
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
      else if(codetype.equals("DocCode")) //8。单证代码的转换
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
     else if(codetype.equals("ClamCode")) //!!!。不知道的代码的转换
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
      errorMessage = "查询失败";
    }
    queryResult = buffer.toString();
    System.out.println("queryresult"+queryResult);
  }
%>

<html>
<head>
  <title>代码查询</title>
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
  <%--查询结束后，将查询结果放在input域传回到客户端，并且重画页面，使其恢复到初始状态--%>
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
        if(submitMethod.equals("POST")){//如果是POST则处理
            out.println("<script language='javascript'>            ");
                if(!errorMessage.equals("")){//查询代码失败
                out.println("    fm.elements["+codeindex+"].focus();");
                out.println("    window.status='查询代码失败\t';");
                out.println("    parent.fraInterface.setInquery(false);");
                out.println("    parent.fraInterface.setQueryError(true);");
            }
            else if(method.equals("change") && recordSize>0){//查询代码成功且method为change
                queryResult = queryResult.substring(queryResult.indexOf("<option value='") + ("<option value='").length(),queryResult.indexOf("'>"));
                arrCodeName = StringUtils.split(queryResult,"_FIELD_SEPARATOR");
                out.println("    window.status='查询代码<" + codevalue + ">成功';");
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
            else if(recordSize==0){//没有查到符合条件的数据
                arrRelation = StringUtils.split("0,"+relation,",");
                if (limit.equals("must") && !codevalue.equals("")){
                    out.println("    if(parent.fraInterface.getSign() == fm.fieldsign.value){");
                    out.println("        fmInput.elements[" + codeindex + "].focus();");
                    out.println("        window.status='代码<" + codevalue + ">不存在，请重新输入';");
                    out.println("    }");
                }
                else{
                    if (limit.equals("clear") || (limit.equals("must") && codevalue.equals(""))){
                        out.println("    window.status='代码<" + codevalue + ">不存在，清空相关域';");
                        out.println("    if(parent.fraInterface.getSign() == fm.fieldsign.value){");

                        for(i=0;i<arrRelation.length;i++){
                            index = Integer.parseInt(arrRelation[i]) + Integer.parseInt(DataUtils.nullToZero(codeindex));

                            out.println("        fmInput.elements[" + index + "].value = '';");
                            out.println("        fmInput.elements[" + index + "].oldvalue = '';");
                        }
                        out.println("    }");
                    }
                    else if(limit.equals("none")){
                        out.println("    window.status='代码<" + codevalue + ">不存在';");
                    }
                }
                out.println("    parent.fraInterface.setInquery(false);");
                out.println("    parent.fraInterface.setQueryError(true);");
            }
            out.println("</script>");

            if(errorMessage.equals("") && method.equals("select") && recordSize>0){ //method为select且查询出结果
System.out.println("buff"+buffer.toString());
%>
        <table class="common" style="width:100%" align="center">
          <tr>
            <td style="width:30%">
            </td>
            <td style="width:20%" align="center">
            <%// 确定按钮%>
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
          window.status='查询代码<<%=codevalue%>>成功';
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