<%--
****************************************************************************
* DESC       ��ԭʼ�����������е�������Ϣ��ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%-- ����bean�ಿ�� --%> 
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.claim.util.*"%>

<%
System.out.println("---------1  ��������--------------");
  //������������//������������
  String strPolicyNo          = request.getParameter("PolicyNo");   //���յ���
  String strEndorseNo         = "";                              //ȡ������
  String strInsuredName       = "";                              //������������
  String strEndorDate         = "";                              //��������
  String strUnderWriteName    = "";                              //���պ���������
  String strOperatorCode      = "";                              //����Ա����������Ӧ�Ƶ�
  String strOperatorName      = "";
  String strHandler1Code      = "";                              //����ҵ��Ա����������Ӧ����
  String strHandler1Name      = "";   
  //String strTitle             = "��زƲ����չɷ����޹�˾������������";  //DAA����ʾ���������
  String strRiskCode          = "";
  String strLanguage          = "";
  String strWhere             = "";
  int intPrpPtextCount = 0 ; 
  int i = 0;
  
  //���뷭�����
  boolean isChinese  = true; //���ı�־
  
  //�����岿��
  PrpPheadDto      prpPheadDto      = new PrpPheadDto();   //������PrpPheadDto����
  PrpPtextDto      prpPtextDto      = new PrpPtextDto();   //������PrpPtextDto����
 
  //�õ�PolicyDto,endorseDto����
  EndorseDto endorseDto = (EndorseDto)request.getAttribute("endorseDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
   
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ���������
  strWhere = " PolicyNo='" + strPolicyNo + "'";
  //blPrpPhead.query(strWhere,0);
  if (endorseDto.getPrpPheadDtoList()!=null&&endorseDto.getPrpPheadDtoList().size()>0)
  {
    //��ѯ���е����������Ұ���������
    strWhere = "PolicyNo='" + strPolicyNo + "' ORDER BY EndorseNo"; 
    //blPrpPhead.query(strWhere,0);
%>
   <html>                           
     <body bgcolor="#FFFFFF">
<%    
    //ѭ����ʾ�����Ĵ�ӡ����  
    for (i=0;i<endorseDto.getPrpPheadDtoList().size();i++)
    {
      prpPheadDto    = (PrpPheadDto)endorseDto.getPrpPheadDtoList().get(i);  
      
      //����
      strRiskCode       = StringConvert.encode(prpPheadDto.getRiskCode());    
      //if (!strRiskCode.equals(BusinessRuleUtil.getOuterCode(request,"RISKCODE_DAA")))
      //  strTitle = "";
      
      //����
      strLanguage       = StringConvert.encode(prpPheadDto.getLanguage()); 
      if (!strLanguage.equals("C"))
        isChinese = false;
        
      //���յ���
      strPolicyNo       = StringConvert.encode(prpPheadDto.getPolicyNo());    
      strEndorseNo      = StringConvert.encode(prpPheadDto.getEndorseNo());    
      
      //������������
      strInsuredName    = StringConvert.encode(prpPheadDto.getInsuredName()); 
      
      //��������
     // UICodeAction uiCodeAction = new UICodeAction();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(strRiskCode);
      if (("D").equals(strRiskType))
      {
        strEndorDate      = prpPheadDto.getEndorDate().getYear()  + " �� "
                          + prpPheadDto.getEndorDate().getMonth() + " �� "
                          + prpPheadDto.getEndorDate().getDate()  + " �� ";
      }
      else
      {
        strEndorDate = uiCodeAction.translateRiskCode(strRiskCode,isChinese);
      }
         
      //���պ���������
      strUnderWriteName = StringConvert.encode(prpPheadDto.getUnderWriteName());
      
      //����Ա--��Ӧ�Ƶ�
      strOperatorCode   = StringConvert.encode(prpPheadDto.getOperatorCode());
      strOperatorName   = uiCodeAction.translateUserCode(strOperatorCode,isChinese);
      
      //����ҵ��Ա�����Ӧ����   
      strHandler1Code   = StringConvert.encode(prpPheadDto.getHandler1Code());
      strHandler1Name   = uiCodeAction.translateUserCode(strHandler1Code,isChinese);
      
      //�õ�PrpPtextDto����ļ�¼��
      //  blPrpPtext    = blEndorse.getBLPrpPtext();
        
      //blPrpPtext        = new BLPrpPtext();
      //blPrpPtext.query(" EndorseNo = \"" + strEndorseNo +"\" ");
        //blPrpPtext.query(" EndorseNo = \'" + strEndorseNo +"\' ");
      //intPrpPtextCount = blPrpPtext.getSize(); 
      
      UIEndorseAction uiEndorseAction = new UIEndorseAction();
      EndorseDto endorseDtoTemp = uiEndorseAction.findByPrimaryKey(strEndorseNo);
      if(endorseDtoTemp.getPrpPtextDtoList()!=null){
        intPrpPtextCount = endorseDtoTemp.getPrpPtextDtoList().size();
      }
%>
          <!-- ���ⲿ�� --> 
        <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td align="center" style="font-family:����; font-size:18pt;"><br>��&nbsp;&nbsp;��&nbsp;&nbsp;<br><br><br></td>
          </tr>
        </table>
          <style>
            table.Normal, div.Normal
            {
              font-size:10pt;
            }
            pre.Normal
            {
              margin:0cm;
              font-siz:10pt
            }
          </style> 
          <script language="javascript">       
          </script>
          <div class= normal style = "margin-left:30">
            <!--����ͷ -->
            <table class=normal border=0  cellspacing=0 cellpadding=0>
              <tr height=25>
                <td width=90>���յ��ţ�</td>
                <td width=300><%=strPolicyNo%></td>
                <td width=90>�� �� �ţ�</td>
                <td width=300><%=strEndorseNo%></td>
              </tr>
              <tr height=25>
                <td>�������ˣ�</td>
                <td><%=strInsuredName%></td>
                <td id="tdEndorDateRiskNameTitle">�������ڣ�</td>
                <td><%=strEndorDate%></td>
              </tr>
              <tr height=25>
                <td colspan=4>
                  ��&nbsp&nbsp&nbsp&nbsp�ģ�
                </td>
              </tr>
            </table>
            <!--����-->
            <table  border="0" width="92%" align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
              <tr>
                <td align="left" valign="top" height="600">
    <%
                    for (int index=0;index<intPrpPtextCount;index++)
                    {
                      prpPtextDto = (PrpPtextDto)endorseDtoTemp.getPrpPtextDtoList().get(index);
                      String strEndorseText = StringConvert.toHTMLFormat(prpPtextDto.getEndorseText());
    %> 
                      <%=strEndorseText%><br>
    <%
                    }
    %>
              </td>
            </tr>  
            </table> 
            <!-- ��β-->
            <div class=normal style = "margin-left:350; margin-top:40"> ������ǩ��:</div>
            <div class=normal style = "margin-left:350; margin-top:30">
              <span class=Normal">
                <%= DateTime.current().getYear()%> ��
              </span>
              <span class=Normal style="LEFT:6cm;">
                <%= DateTime.current().getMonth()%> ��
              </span>
              <span class=Normal style="LEFT:6cm;">
                <%= DateTime.current().getDate()%> ��
              </span>
            </div>
            <div class=Normal style = "margin-top:60">
              <span style="margin-left:40;">
                �˱��� <%=strUnderWriteName%>
              </span>
              <span style="margin-left:140;">
                �Ƶ��� <%=strOperatorName%>
              </span>
              <span style="margin-left:140;">
                ���죺 <%=strHandler1Name%>
              </span>
            </div>
          </div>
        <%-- ��ҳ��,�������һ��ʱ����һ��ҳ�� --%>
<%        
        if (i!=endorseDto.getPrpPheadDtoList().size()-1)
%>        
        <br style="page-break-before:always" clear=all>
<%      
    }
  } 
%>
        <div style = margin-top:10">
          <%-- include��ӡ��ť --%>
          <span class=Normal style="LEFT:10cm; TOP:1cm">
      <jsp:include page="/common/print/PrintButton.jsp" />   
          </span>
        </div>
      </body>
    </html>   

