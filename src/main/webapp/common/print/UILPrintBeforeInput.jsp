
<%--
****************************************************************************
* DESC       �� �����մ�ӡǰ����ҵ���ҳ��
* AUTHOR     �� wangwei
* CREATEDATE �� 2005-05-21
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime;"%>

<%
  String strPrintType = request.getParameter("printType");
  String strTitleName = "";
  String strBizName   = "";

  String strWherePart = "";
  int    intCount     = 0;
  String strMessage    = "";

	//add by miaowenjun 2007-1-30 14:32 start
  if(strPrintType.equals("AgriRegist"))
  {
    //ũ�ճ���
    strTitleName = "ũ�մ�������ӡ";
    strBizName   = "������";
  }
  //add by miaowenjun 2007-1-30 14:32 end
  
  //add by sinosoft 2007-1-30 begin
  //reason:���Ӳ��ձ��Ѵ�ӡ����
  if(strPrintType.equals("AddPremium"))
  {
    strTitleName = "���ⲹ�ձ��Ѵ�ӡ";
    strBizName   = "������";
  }
  //add by sinosoft 2007-1-30 end
  
	
  //add by kangzhen 070129 start
  if(strPrintType.equals("ReduceAmountEndorse"))
  {
    //�����������
    strTitleName = "����������Ĵ�ӡ";
    strBizName   = "������";
  }
  //add by kangzhen 070129 end
  
  if(strPrintType.equals("CompensateHosp"))
  {
    //��סԺҽ�Ʋ�������
    strTitleName = "��סԺҽ�Ʋ������ռ������ӡ";
    strBizName   = "���������";
  }
  
  
  //add by kangzhen 070117 start
  if(strPrintType.equals("AgriCompensate"))
  {
    //ũ����������
    strTitleName = "ũ�����������ӡ";
    strBizName   = "���������";
  }
  //add by kangzhen 070117 end
  if( strPrintType.equals("FreightCompensate") ){

    //1.��������������
    strTitleName = "���������ӡ";
    strBizName   = "���������";
  }

  if( strPrintType.equals("FreightCompensateNotice") ) {

    //2.�������ⰸ�սᱨ����
    strTitleName = "�������ⰸ�սᱨ�����ӡ";
    strBizName   = "������";
  }

  if (strPrintType.equals("FreightDamageNotice")) {

    //3.�����ճ���֪ͨ��
    strTitleName = "�����ճ���֪ͨ���ӡ";
    strBizName   = "������";
  }

  if( strPrintType.equals("FreightCheckReport") ){

   //4.�����ղ鿱����
    strTitleName = "�����ղ鿱�����ӡ";
    strBizName   = "������";
  }

  if (strPrintType.equals("ClaimDispose")) {
      //5.���⴦����
      strTitleName = "���⴦�����ӡ";
      strBizName   =  "������";
  }

  if (strPrintType.equals("LocalCheck")) {
      //6.�ֳ��鿰����
      strTitleName = "�ֳ��鿰�����ӡ";
      strBizName   = "������";
  }

  //modify by wangwei add start 20050528
  if (strPrintType.equals("CopyPrint")) {
      //7.������ӡ
      strTitleName = "������ӡ";
      strBizName   = "������";
  }
  //modify by wangwei add end 20050528

  //modify by dongchengliang add start 20050615
  if (strPrintType.equals("AcciCheck")) {
      //7.�⽡�յ��鱨��
      strTitleName = "�⽡�յ��鱨��";
      strBizName   = "������";
  }
  //modify by dongchengliang add end 20050615
  if( strPrintType.equals("PropCancelNotice")){
  //8.�Ʋ��վ���֪ͨ��
  strTitleName = "�Ʋ��վ���֪ͨ���ӡ";
  strBizName   = "������";
  }
  if( strPrintType.equals("PropCompensate")){
  //10.�Ʋ�����������
  strTitleName = "�Ʋ������������ӡ";
  strBizName   = "���������";
  }
  if( strPrintType.equals("PropCompensateNotice")){
  //11.�Ʋ������֪ͨ��
  strTitleName = "�Ʋ������֪ͨ��";
  strBizName   = "���������";
  }
  if( strPrintType.equals("ShipEndcase")){
  //12.�����ս᰸�����ӡ
  strTitleName = "�����ս᰸�����ӡ";
  strBizName   = "���������";
  }
  if( strPrintType.equals("AcciNotClaim")){
  //13.�⽡�ղ�������֪ͨ���ӡ
  strTitleName = "�⽡�ղ�������֪ͨ���ӡ";
  strBizName   = "������";
  }
  if( strPrintType.equals("AcciReview")){
  //14.�⽡�ն���������ӡ
  strTitleName = "�⽡�ն���������ӡ";
  strBizName   = "���������";
  }
  if( strPrintType.equals("AcciCancelNotice")){
  //15.�⽡�վ���֪ͨ���ӡ
  strTitleName = "�⽡�վ���֪ͨ���ӡ";
  strBizName   = "������";
  }
  if( strPrintType.equals("ShipCopyPrint")){
  //�����ճ�����ӡ
  strTitleName = "�����ճ�����ӡ";
  strBizName   = "������";
  }
  if (strPrintType.equals("ReparationsList")) {    //�⽡������������ӡ
      strTitleName  = "�⽡������������ӡ";
      strBizName    = "���������";
  }
  //add begin by zhuly 20051110
  if(strPrintType.equals("FreightHeresyCheck"))
  {
     strTitleName   = "�����մ��鿱ί�����ӡ";
     strBizName     = "������";  
  }
  if(strPrintType.equals("FreightNationalCompensate"))
  {
     strTitleName   = "���ڻ������䱣�����������";
     strBizName     = "���������";
  }
  if(strPrintType.equals("FreightInportCompensate"))
  {
     strTitleName   = "���ڻ������䱣�����������";
     strBizName     = "���������";
  }
  if(strPrintType.equals("FreightExportCompensate"))
  {
     strTitleName   = "���ڻ������䱣�����������";
     strBizName     = "���������";
  }
  if(strPrintType.equals("FreightRefuseCancel"))
  {
     strTitleName   = "����/ע������֪ͨ��";
     strBizName     = "������";
  }
  if(strPrintType.equals("ClaimRefuse"))
  {
     strTitleName   = "���⣨ע��������֪ͨ��";
     strBizName     = "������";
  }
  if(strPrintType.equals("PropLocalCheck"))
  {
     strTitleName   = "�Ʋ����ֳ��鿱����";
     strBizName     = "������";
  }
  if(strPrintType.equals("LiabCompensate"))
  {
     strTitleName   =  "������������㱨��";
     strBizName     =  "���������";
  }
  //add end  by zhuly 20051110
  //add begin by hanliang	20051212
  if(strPrintType.equals("LiabLocaleCheck"))
  {
     strTitleName   = "�������ֳ��鿱����";
     strBizName     = "������";  
  }
  if(strPrintType.equals("PropLocaleHeresy"))
  {
     strTitleName   = "�Ʋ��մ��鿱ί����";
     strBizName     = "������";  
  }
  //add end  by hanliang 20051212
  //add begin by hanliang	20051214
  if(strPrintType.equals("FreightClaimApply"))
  {
     strTitleName   = "����������������";
     strBizName     = "������";  
  }
  //add end  by hanliang 20051214
  //add by caopeng start at 20051213
  if(strPrintType.equals("ClaimDocumentHandinCredence"))//�����������ļ�����ƾ֤
  {
     strTitleName   = "�����������ļ�����ƾ֤��ӡ";
     strBizName     = "������";  
  }
  if (strPrintType.equals("InvesReport")) {
      //�⽡��������鱨��
      strTitleName = "�⽡��������鱨���ӡ";
      strBizName   = "�����";
  }
  if (strPrintType.equals("CompensateAuditBook")) {
      //���������
      strTitleName = "���������ӡ";
      strBizName   = "���������";
  }
  //add by caopeng end at 20051213
%>

<html:html locale="true">
<head>
  <title>�����ӡǰ���뵥֤��</title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/print/js/DAAPrintBeforeEdit.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
   <script language='javascript'>
      function loadForm()
      {
        TitleName.innerHTML = '<%=strTitleName%>';
        fm.PrintType.value  = '<%=strPrintType%>';
        BizName.innerHTML   = '<%=strBizName%>' + '��';
        fm.BizName.value    = '<%=strBizName%>';
      }


      function checkForm()
      {
        if(fm.BizNo.length<1)
        {
          fm.BizNo.focus();
          errorMessage(fm.BizName.value + "����Ϊ��!");
          return false;
        }
        //modify by zhuly 20051110
        //else if(trim(fm.BizNo.value).length!=21 && trim(fm.BizNo.value).length !=25)
        //{
        //  fm.BizNo.focus();
        //  errorMessage(fm.BizName.value + "ӦΪ21λ��25λ��!");
        //  return false;
        //}

        return true;
      }


      function submitForm()
      {
        if(checkForm()==true)
        {
          var strUrl = "";
          //add by kangzhen 070129 start
          if( fm.PrintType.value=="ReduceAmountEndorse" ) //�����������
          {
          	strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
          //add by kangzhen 070129 end
          
          if( fm.PrintType.value=="CompensateHosp" )       //��סԺҽ�Ƽ�����
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
          
          //add by kangzhen 070117 start
          if( fm.PrintType.value=="AgriCompensate" )       //ũ����������
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
          //add by kangzhen 070117 end
          
          //add by miaowenjun 2007-1-30 14:33 start
          if( fm.PrintType.value=="AgriRegist" )       //ũ�մ�����
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
          //add by miaowenjun 2007-1-30 14:33 end
          
          //add by sinosoft 2007-5-24  begin
          //���ⲹ�ձ���
          if( fm.PrintType.value=="AddPremium" )      
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
          //add by sinosoft 2007-5-24 end
          
          if( fm.PrintType.value=="FreightCompensate" )       //1.��������������
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }

          if( fm.PrintType.value=="FreightCompensateNotice" ) //2.�������ⰸ�սᱨ����
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }

          if( fm.PrintType.value=="FreightDamageNotice" )     //3.�����ճ���֪ͨ��
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }

          if( fm.PrintType.value=="FreightCheckReport" )     //4.�����ղ鿱����
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }

           if( fm.PrintType.value=="ClaimDispose" )          //5.���⴦����
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }

           if( fm.PrintType.value=="LocalCheck" )           //6.�ֳ��鿱����
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }

          //modify by wangwei add start 2050528
          if (fm.PrintType.value=="CopyPrint")
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
          //modify by wangwei add end 20050528

          //modify by dongchengliang add start 20050615
          if (fm.PrintType.value=="AcciCheck")
          {
             // strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
             strUrl = "/claim/checkQuery.do?editType=PRINT&RegistNo=" + fm.BizNo.value;
          }
          if (fm.PrintType.value=="ShipEndcase")
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
          if (fm.PrintType.value=="PropCompensateNotice")
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
          if (fm.PrintType.value=="AcciNotClaim")
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
          //modify by dongchengliang add end 20050615
          if( fm.PrintType.value=="PropCancelNotice")
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="PropCompensate")
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="AcciReview")
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="AcciCancelNotice")
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="ShipCopyPrint")
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
          if(fm.PrintType.value=="ReparationsList") {  //�⽡��������ӡ
              strUrl = "/claim/ClaimPrint.do?printType=" + fm.PrintType.value + "&CompensateNo=" + fm.BizNo.value;
          }
          //add begin by zhuly 20051110  
          if(fm.PrintType.value=="FreightHeresyCheck")//�����մ��鿱ί�����ӡ
          {
             strUrl = "/claim/ClaimPrint.do?printType=" + fm.PrintType.value + "&RegistNo="+ fm.BizNo.value;
          }
          if(fm.PrintType.value=="FreightNationalCompensate")//���ڻ��������������
          {
             strUrl = "/claim/ClaimPrint.do?printType=" + fm.PrintType.value + "&CompensateNo="+ fm.BizNo.value;
          }
          if(fm.PrintType.value=="FreightInportCompensate")//���ڻ��������������
          {
             strUrl = "/claim/ClaimPrint.do?printType=" + fm.PrintType.value + "&CompensateNo="+ fm.BizNo.value;
          }
          if(fm.PrintType.value=="FreightExportCompensate")//���ڻ��������������
          {
             strUrl = "/claim/ClaimPrint.do?printType=" + fm.PrintType.value + "&CompensateNo=" + fm.BizNo.value;
          }
          if(fm.PrintType.value=="FreightRefuseCancel")//����/ע������֪ͨ��
          {
             strUrl = "/claim/ClaimPrint.do?printType=" + fm.PrintType.value + "&ClaimNo=" + fm.BizNo.value;
          }
          if(fm.PrintType.value=="ClaimRefuse")//����(ע��)����֪ͨ��
          {
             strUrl = "/claim/ClaimPrint.do?printType=" + fm.PrintType.value + "&ClaimNo=" + fm.BizNo.value;
          }
          if(fm.PrintType.vlaue=="PropLocalCheck")//�Ʋ����ֳ��鿱����
          {
             strUrl = "/claim/ClaimPrint.do?printType=" + fm.PrintType.value + "&RegistNo=" + fm.BizNo.value;
          }
          if(fm.PrintType.value=="LiabCompensate")//������������㱨��
          {
             strUrl = "/claim/ClaimPrint.do?printType=" + fm.PrintType.value + "&CompensateNo=" + fm.BizNo.value;
          }
          //modify by hanliang add end 20051208
          if( fm.PrintType.value=="PropLocalCheck")
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
          //add end   by zhuly 20051110
          //add start   by hanliang 20051212 
          if( fm.PrintType.value=="LiabLocaleCheck")
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="PropLocaleHeresy")//�Ʋ������������
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
          //add end   by hanliang 20051212
          //add start   by hanliang 20051214 
          if( fm.PrintType.value=="FreightClaimApply")//����������������
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
          //add end   by hanliang 20051214
		  //add by caopeng start at 20051213
          if( fm.PrintType.value=="ClaimDocumentHandinCredence")//�����������ļ�����ƾ֤
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
		  if( fm.PrintType.value=="InvesReport")//�⽡��������鱨��
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
		  if( fm.PrintType.value=="CompensateAuditBook")//���������
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
          //add by caopeng end at 20051214
		  printWindow(strUrl,"��ӡ1");
        }
      }

      //��ʾ��ӡ����
      function printWindow(strURL,strWindowName)
      {
        var pageWidth=screen.availWidth-10;
        var pageHeight=screen.availHeight-30;

        if (pageWidth<100 )
          pageWidth = 100;

        if (pageHeight<100 )
          pageHeight = 100;

        var newWindow = window.open(strURL,strWindowName,'width='+pageWidth+',height='+pageHeight+',top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
        newWindow.focus();
        return newWindow;
      }
    </script>
</head>

<body  onload="loadForm();"">
<form name="fm" method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr>  <td colspan=2 class="formtitle" id="TitleName"></td></tr>
      <tr>
        <td class='title2'  id="BizName"></td>
        <td class='input2'>
            <input type='hidden' name='BizName'>
            <input class="common" type='text' name='BizNo' maxlength='25' >
        </td>
      </tr>

      <%--modify by zhaozhuo modify 20050414 end--%>
      <tr  style="display:none" id="trEndDate">
        <td class='title2' >��ֹ���ڣ�</td>
        <td class='input2'>
            <input class="common" type='text' name='EndDate' style="width:60" maxlength="10">��
            <input class="common" type='text' name='EndDateHour' style="width:20">ʱ
        </td>
      </tr>
      <tr>
        <td class="button" align="center"   colspan="2">
            <input type=button value="��һ��" class='button' onclick="submitForm();">
        </td>
      </tr>
          <input type='hidden' name="PrintType">
    </table>

  </form>
</body>
</html:html>



