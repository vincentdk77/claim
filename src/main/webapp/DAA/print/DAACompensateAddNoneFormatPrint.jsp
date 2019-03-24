<%--
****************************************************************************
* DESC       ����������������������鸽ҳ��ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.sysframework.common.util.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%>

<%
  //������������
  String strCompensateNo  = request.getParameter("CompensateNo"); //����������
  String strTextType       = "";
  String strContext       = "";   //�������������
  String strMessage       = "";
  String strClaimNo       = "";

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־

  //�����岿��

  PrpLctextDto       prpLctextDto       = null;

  int intCompensateCount = 0;   //CompensateDto����ļ�¼��
  int intCtextCount      = 0;   //CtextDto����ļ�¼��

  int index = 0;

  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto");
  if(compensateDto!=null && compensateDto.getPrpLcompensateDto()!=null){
    strClaimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
  }

  //�õ�dbPrpLctext����ļ�¼��
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    intCtextCount     = compensateDto.getPrpLctextDtoDtoList().size();
  }

%>

<script language="javascript">
  function loadForm()
  {
    tdCompensateNo.innerHTML = '�ⰸ���' + '<%=strClaimNo%>' + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;������ţ�' + '<%=strCompensateNo%>';
<%
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    //���������ֱ�PrpLctext
    for(index=0;index<intCtextCount;index++)
    {
      prpLctextDto = (PrpLctextDto)compensateDto.getPrpLctextDtoDtoList().get(index);
      strTextType = StringConvert.encode(prpLctextDto.getTextType());
      if ( strTextType.charAt(0)=='1' || strTextType.charAt(0)=='7')
      {
        strContext = strContext + StringConvert.encode(prpLctextDto.getContext()) ;
      }
    }
  }


    //�����������ִ�����Ǽ���
    int intCtextCountTmp = 0;    //textarea������
//    String la="\\";
//    String lala="\\r\\n";


    for(index=0;index<strContext.length();index++)
    {
      if(strContext.substring(index,index+1).equals("\\"))
      {
        if(!(strContext.substring(index).length()<4))
        {
          if(strContext.substring(index,index+4).equals("\\r\\n"))
          {
             intCtextCountTmp += 1;    //ֻҪ�лس����У�intCtextCountTmp+1
          }
        }
      }
    }

    int x = 0;
    int y = 0;
    if(!(strContext.length()<4))    //���strContext.length()>=4���ж�strContext��β�����֣����ǻس�����
    {
      x = strContext.length()-4;
      y = strContext.length();
      if(!strContext.substring(x,y).equals("\\r\\n"))
      {
         intCtextCountTmp += 1;
      }
    }
    else    //���strContext����1�У�intCtextCountTmp = 1;
      intCtextCountTmp = 1;

    while(strContext.indexOf("\\r\\n")!=-1)
       strContext=strContext.substring(0,strContext.indexOf("\\r\\n"))+"<br>"+strContext.substring(strContext.indexOf("\\r\\n")+"\\r\\n".length());

%>
   tdContext.innerHTML = '<%=strContext%>';
  }

</script>

<html>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
      <!-- ���ⲿ�� -->
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td colspan="3" height="40" align=top align=center style="font-family:����; font-size:14pt;">
            <center><B>��������������������鸽ҳ</B></center>
          </td>
        </tr>
        <tr>
          <td width="10%"></td>
          <td width="90%" align=right id="tdCompensateNo" style="font-family:����; font-size:10pt;">
            ������ţ�
          </td>
        </tr>
      </table>

      <!-- ���岿�� -->
      <table border=1 width="92%" height="90%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
        <tr>
          <td align="center" height="25" colspan="12">
            ���������
          </td>
        </tr>
        <tr>
          <td id="tdContext" colspan="12" height="375" valign="top"></td>
        </tr>


      </table>
    </form>

      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />

  </body>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html>
