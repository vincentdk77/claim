<%--
****************************************************************************
* DESC       �������ӡǰ���뵥֤��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
 
<%-- ����bean�ಿ�� --%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.utility.string.*"%>
<%@page import="com.ddcc.utiall.dbsvr.*"%>
<%@page import="com.ddcc.utiall.dbsvr.*"%>
<%@page import="com.ddcc.ddccall.blsvr.lp.*"%>
<%@page import="com.ddcc.ddccall.dbsvr.lp.*"%>
<%@page import="com.ddcc.ddccall.schema.*"%>
<%@page import="com.sinosoft.utility.string.Date"%>
 
<%
  String strPrintType = request.getParameter("PrintType");
  String strTitleName = "";
  String strBizName   = "";
  ChgDate chgDate = new ChgDate();
   
  String strWherePart = "";
  int    intCount     = 0;
  String strMessage    = "";
  
  if( strPrintType.equals("Regist") )
  {
    //1.������¼����������
    strTitleName = "�����������ձ�����¼������������ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("Pilfer") )
  {
    //2.���գ�������֤�� 
    strTitleName = "���գ�������֤����ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("Cancelnotice") )
  {
    //3.����֪ͨ��
    strTitleName = "����֪ͨ���ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("Canceltrans") )
  {
    //4.���ⰸ��������
    strTitleName = "���ⰸ���������ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("LossSimple") )
  {
    //5.��ʧ�������ȷ����
    strTitleName = "��ʧ�������ȷ�����ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("Loss") )
  {
    //6.��ʧ���ȷ����
    strTitleName = "��ʧ���ȷ�����ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("ComponentList") )
  {
    //7.�㲿��������Ŀ�嵥
    strTitleName = "�㲿��������Ŀ�嵥��ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("ComponentAdd") )
  {
    //8.�㲿��������Ŀ�嵥����
    strTitleName = "�㲿��������Ŀ�嵥�����ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("RepairList") )
  {
    //9.������Ŀ�嵥
    strTitleName = "������Ŀ�嵥��ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("RepairAdd") )
  {
    //10.������Ŀ�嵥����
    strTitleName = "������Ŀ�嵥�����ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("PropList") )
  {
    //11.�Ʋ���ʧȷ����
    strTitleName = "�Ʋ���ʧȷ�����ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("Compensate") )
  {
    //12.��������
    strTitleName = "���������ӡ";
    strBizName   = "���������";
  }
  if( strPrintType.equals("CompensateAdd") )
  {
    //13.�������鸽ҳ
    strTitleName = "�������鸽ҳ��ӡ";
    strBizName   = "���������";
  }
  if( strPrintType.equals("PayStatList") )
  {
    //14.���ͳ����ϸ��
    strTitleName = "���ͳ����ϸ��";
    strBizName   = "�鵵��";
  }
  if( strPrintType.equals("Drawnotice") )
  {
    //15.��ȡ���֪ͨ��
    strTitleName = "��ȡ���֪ͨ���ӡ";
//    strBizName   = "�鵵��";
    strBizName   = "���������";
  }
  if( strPrintType.equals("Prepay") )
  {
    //16.Ԥ�����������
    strTitleName = "Ԥ������������ӡ";
    strBizName   = "Ԥ���";
  }
  if( strPrintType.equals("Pressnotice") )
  {
    //17.�᰸�߸桢ע��֪ͨ��
    strTitleName = "�᰸�߸桢ע��֪ͨ���ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("Endcase") )
  {
    //18.�᰸������
    strTitleName = "�᰸�������ӡ";
          // strBizName   = "�鵵��";
            strBizName   = "������";
  }
  if(strPrintType.equals("HistoryFile"))
  {
    //19.ԭʼ����������ǰ����
    strTitleName = "ԭʼ����������ǰ������ӡ";
          strBizName   = "������";
  }
  if(strPrintType.equals("FileOnRisk"))
  {
    //20.����ʱ����
    strTitleName = "����ʱ������ӡ";
          strBizName   = "������";
  }
  
%>  
<html>
  <head>
    <title>�����ӡǰ���뵥֤��</title>
    <%-- ���ú��� --%>
    <script src="/ddccallweb/common/print/Common.js"></script>
    <%-- ҳ����ʽ  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script language='javascript'>     
  
      function loadForm()
      {       
        TitleName.innerHTML = '<%=strTitleName%>';
        fm.PrintType.value  = '<%=strPrintType%>';
        BizName.innerHTML   = '<%=strBizName%>' + '��';
        fm.BizName.value    = '<%=strBizName%>';
        
        if("<%=strPrintType%>"=="FileOnRisk" || "<%=strPrintType%>"=="HistoryFile")
        {
          trEndDate.style.display="";
        }
        
        if ("<%=strPrintType%>"=="FileOnRisk")
        {
          fm.EndDate.value= '<%= chgDate.getCurrentTime("yyyy-MM-dd") %>';
          fm.EndDateHour.value="<%=new Date().getString(Date.HOUR)%>";
        } 
    
      }
      
      
      function checkForm()
      {
        if(isEmpty(fm.BizNo))
        {
          fm.BizNo.focus();
          errorMessage(fm.BizName.value + "����Ϊ��!");
          return false;
        }
        else if(trim(fm.BizNo.value).length!=22)
        {
          fm.BizNo.focus();
          errorMessage(fm.BizName.value + "ӦΪ22λ��!");
          return false;
        }                

        return true;
      }  
  
  
      function submitForm()
      {                     
        if(checkForm()==true)
        {
          var strUrl = "";  
          
          if( fm.PrintType.value=="Regist" )          //1.������¼����������
          {
            strUrl = "/ddccallwebDAARegistNoneFormatPrint.jsp?RegistNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="Pilfer" )          //2.���գ�������֤��
          {
            strUrl = "/ddccallwebDAAPilferNoneFormatPrint.jsp?ClaimNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="Cancelnotice" )    //3.����֪ͨ��
          {
            strUrl = "/ddccallwebDAACancelnoticeNoneFormatPrint.jsp?ClaimNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="Canceltrans" )     //4.���ⰸ��������
          {
            strUrl = "/ddccallwebDAACanceltransNoneFormatPrint.jsp?ClaimNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="LossSimple" )      //5.��ʧ�������ȷ����
          {
            strUrl = "/ddccallwebDAALossSimpleNoneFormatPrint.jsp?ClaimNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="Loss" )            //6.��ʧ���ȷ����
          {
            strUrl = "/ddccallwebDAALossNoneFormatPrint.jsp?ClaimNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="ComponentList" )   //7.�㲿��������Ŀ�嵥
          {
            strUrl = "/ddccallwebDAAComponentListNoneFormatPrint.jsp?ClaimNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="ComponentAdd" )    //8.�㲿��������Ŀ�嵥����
          {
            strUrl = "/ddccallwebDAAComponentAddNoneFormatPrint.jsp?ClaimNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="RepairList" )      //9.������Ŀ�嵥
          {
            strUrl = "/ddccallwebDAARepairListNoneFormatPrint.jsp?ClaimNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="RepairAdd" )       //10.������Ŀ�嵥����
          {
            strUrl = "/ddccallwebDAARepairAddNoneFormatPrint.jsp?ClaimNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="PropList" )        //11.�Ʋ���ʧȷ����
          {
            strUrl = "/ddccallwebDAAPropListNoneFormatPrint.jsp?ClaimNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="Compensate" )      //12.��������
          {
            strUrl = "/ddccallwebDAACompensateNoneFormatPrint.jsp?CompensateNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="CompensateAdd" )   //13.�������鸽ҳ
          {
            strUrl = "/ddccallwebDAACompensateAddNoneFormatPrint.jsp?CompensateNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="PayStatList" )     //14.���ͳ����ϸ��
          {
            strUrl = "/ddccallwebDAAPayStatListNoneFormatPrint.jsp?CaseNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="Drawnotice" )      //15.��ȡ���֪ͨ��
          {
            strUrl = "/ddccallwebDAADrawnoticeNoneFormatPrint.jsp?CompensateNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="Prepay" )          //16.Ԥ�����������
          {
            strUrl = "/ddccallwebDAAPrepayNoneFormatPrint.jsp?PreCompensateNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="Pressnotice" )     //17.�᰸�߸桢ע��֪ͨ��
          {
            strUrl = "/ddccallwebDAAPressnoticeNoneFormatPrint.jsp?ClaimNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="Endcase" )         //18.�᰸������
          {
            // strUrl = "/ddccallwebDAAEndcaseNoneFormatPrint.jsp?CaseNo=" + fm.BizNo.value;  
               strUrl = "/ddccallwebDAAEndcaseNoneFormatPrint.jsp?ClaimNo=" + fm.BizNo.value;  
          }
          if( fm.PrintType.value=="HistoryFile" )     //19.ԭʼ����������ǰ����
          {
            //strUrl = "/ddccallwebDAAEndcaseNoneFormatPrint.jsp?CaseNo=" + fm.BizNo.value;  
            strUrl = "/ddccallweb/common/lp/print/UILOrigalPolicyEndorseNoneFormatPrintBefore.jsp?PolicyNo=" + fm.BizNo.value; 
           
          }
          if( fm.PrintType.value=="FileOnRisk" )      //20.����ʱ����
          {
            // strUrl = "/ddccallweb/common/lp/print/UILFileOnRiskNoneFormatPrint.jsp";  
            strUrl = "/ddccallweb/common/lp/print/UILDamagePolicyNoneFormatPrint.jsp?PolicyNo=" + fm.BizNo.value + "&EndDate=" + fm.EndDate.value +" &EndDateHour=" + fm.EndDateHour.value; 
           
          }
      printWindow(strUrl,"��ӡ1");
//          var newWindow = window.open(strUrl,"",'width=760,height=400,top=0,left=0,toolbar=1,location=1,directories=0,menubar=1,scrollbars=1,resizable=1,status=1');
//          newWindow.focus();
//          return newWindow;
        }  
      }
    </script>
  </head>
  
  <body class="interface" onload="loadForm();">
    <form name='fm' method="post">
      <table class="three" align=center>
        <tr>
          <td class=formtitle colspan="3" id="TitleName"></td>
          <input type='hidden' name="PrintType">        
        </tr>
        <tr>
          <td class='title' style="width:20%" id="BizName"></td>
          <td class='input'>       
            <input type='hidden' name='BizName'>        
            <input class="common" type='text' name='BizNo' maxlength='22' onkeypress="return uppercaseKey();">
          </td>
        </tr>  
        <tr style="display:none" id="trEndDate">
          <td class='title' style="width:20%" >��ֹ���ڣ�</td>
          <td class='input' >       
            <input class="common" type='text' name='EndDate' style="width:80" maxlength="10" onkeypress="return pressDatetime(event)">��
            <input class="common" type='text' name='EndDateHour' style="width:20" onkeypress="return pressInteger(event);">ʱ
          </td>
        </tr>
        <tr>
          <td class=centertitle colspan="2">
            <input type=button value="��һ��" class="button"
              onclick="submitForm();">
          </td>
        </tr>
      </table>
    </form> 
  </body> 
</html>
  