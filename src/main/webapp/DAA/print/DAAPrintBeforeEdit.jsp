<%--
****************************************************************************
* DESC       ����ӡǰ����ҵ���ҳ��
* AUTHOR     �� lixiang
* CREATEDATE �� 2004-11-12 
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>

<%
  session.setAttribute("riskClass","05");
  String strPrintType = request.getParameter("printType");
  System.out.println("==========test print printtype:" + strPrintType);
  String strTitleName = "";
  String strBizName   = "";

  String strWherePart = "";
  int    intCount     = 0;
  String strMessage    = "";
  String strSerialNo = "";//���ƺ���
  String strPolicyNo = "";//������
  String strInsuredName = "";//�������� 
  if( strPrintType.equals("Regist") )
  {
    //1.������¼����������
    strTitleName = "�����������ձ�����¼������������ӡ";
    strBizName   = "������";
    strPolicyNo  = "������";
    strInsuredName = "��������";
    strSerialNo  = "���ƺ���";
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
   //�����¹�ǿ�Ʊ��յ�֤ add by zhouliu start 2006-6-12
  if (strPrintType.equals("Cancelcompel"))
  {
	strTitleName = "�¹�����ǿ�Ʊ��վ���֪ͨ���ӡ";
    strBizName   = "������";
  }
 //�����¹�ǿ�Ʊ��յ�֤ add by zhouliu end 2006-6-12
 
    //��ŵ֧��ҽ�Ʒ��õ�������ӡ add by hi start 2006-6-12
  if (strPrintType.equals("PromisesFeeForService"))
  {
	strTitleName = "��ŵ֧��ҽ�Ʒ��õ�������ӡ";
    strBizName   = "������";
  }
 //��ŵ֧��ҽ�Ʒ��õ�������ӡ add by hi end 2006-6-12
 
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
    strTitleName = "���𱨸���ϸ���ӡ";
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
   // strBizName   = "������";
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
    //17.ע��֪ͨ��
    strTitleName = "����ע������֪ͨ���ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("PressnoticeEnd") )
  {
    //17.�᰸�߸�֪ͨ��
    strTitleName = "�᰸�߸�֪ͨ���ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("Endcase") )
  {
    //18.�᰸������
    strTitleName = "�᰸�������ӡ";
          // strBizName   = "�鵵��";
            strBizName   = "������";
  }
  if( strPrintType.equals("EndcaseAdd") )
  {
    //18.�᰸������
    strTitleName = "�᰸�����鸽ҳ��ӡ";
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
   //modify by zhaozhuo add 20050414 start

  if(strPrintType.equals("BackcRecord"))
  {

    strTitleName = "�ؿ�֪ͨ���ӡ";
          strBizName   = "������";
          strSerialNo = "�������";
  }


  if(strPrintType.equals("BackcInform"))
  {

    strTitleName = "�������ؿ���¼��ӡ";
          strBizName   = "������";
          strSerialNo = "�������";
  }
  //modify by zhaozhuo add 20050414 end

  //modify by wangwei add start 20050527
  //ԭ������13����ͬ������
  if (strPrintType.equals("LogoutClaimEntrol")) {
      //21.ע���ⰸ�Ǽǲ�
      strTitleName = "ע���ⰸ�Ǽǲ���ӡ";
      strBizName   = "�鵵��";
  }

  if (strPrintType.equals("PrepayClaimKnow")) {
      //22.Ԥ�����������
      strTitleName = "Ԥ������������ӡ";
      strBizName   = "�鵵��";
  }

  if (strPrintType.equals("HeresyCheckSubmit")) {
      //23.���鿱ί����
      strTitleName = "���鿱ί�����ӡ";
      strBizName   = "������";
  }

  if (strPrintType.equals("StopClaimEntrol")) {
      //24.�Ѿ��ⰸ�Ǽǲ�
      strTitleName = "�Ѿ��ⰸ�Ǽǲ���ӡ";
      strBizName   = "";
  }

  if (strPrintType.equals("NotClaimEntrol")) {
      //25.δ���ⰸ�Ǽǲ�
      strTitleName = "δ���ⰸ�Ǽǲ���ӡ";
      strBizName   = "";
  }

  if (strPrintType.equals("LoseCallBackEntrol")) {
      //26.�������ʻ��յǼǲ�
      strTitleName = "�������ʻ��յǼǲ���ӡ";
      strBizName   = "";
  }

  if (strPrintType.equals("LawArbitrogeQuestion")) {
      //27.�����ٲð������߱�
      strTitleName = "�����ٲð������߱��ӡ";
      strBizName   = "";
  }

  if (strPrintType.equals("CheckOrderLetter")) {
      //28.����鿱���𸴺�
      strTitleName = "����鿱���𸴺���ӡ";
      strBizName   = "";
  }

  if (strPrintType.equals("EndCaseHurry")) {
      //29.�᰸�߿���
      strTitleName = "�᰸�߿����ӡ";
      strBizName   = "";
  }

  if (strPrintType.equals("CallBackDispose")) {
      //30.�����������ʴ���
      strTitleName = "�����������ʴ�����ӡ";
      strBizName   = "";
  }

  if (strPrintType.equals("SubRogationEntrol")) {
      //31.��λ׷�������Ǽǲ�
      strTitleName = "��λ׷�������Ǽǲ���ӡ";
      strBizName   = "";
  }

  if (strPrintType.equals("ReportRegistEntrol")) {
      //32.���������Ǽǲ�
      strTitleName = "���������Ǽǲ���ӡ";
      strBizName   = "������";
  }

  if (strPrintType.equals("BothEraEntrol")) {
      //33.��˫�����Ǽǲ�
      strTitleName = "��˫�����Ǽǲ���ӡ";
      strBizName   = "";
  }
  //modify by wangwei add end 20050527
  
  if( strPrintType.equals("Check") )
  {
    //34.�ֳ��鿱��¼
     strTitleName = "�鿱��¼��ӡ";
     strBizName   = "������";
  }
  if( strPrintType.equals("PersonLoss") )
  {
    //34.��Ա���������嵥
     strTitleName = "��Ա���������嵥��ӡ";
     strBizName   = "������";
  }
  //add begin by zhuly 20051107
  if( strPrintType.equals("DAAPilfer") )
  {
    //35.���յ����ղ鿱����
     strTitleName = "���յ����ղ鿱�����ӡ";
     strBizName   = "������";
  }   
  if( strPrintType.equals("DAAClaimDocument") )
  {
    //36.������������������Ͻ��ӵ�
     strTitleName = "������������������Ͻ��ӵ���ӡ";
     strBizName   = "������";
  }  
  //add end   by zhuly 20051107
  //add by caopeng start at 2005-12-2
  if( strPrintType.equals("IndemnityReceipt") )
  {
    //37.����վ�
     strTitleName = "����վݴ�ӡ";
     strBizName   = "���������";
  }
  //add by caopeng end at 2005-12-6 
   if( strPrintType.equals("ClaimNotice") )
  {
    //38.������֪
     strTitleName = "������֪��ӡ";
     strBizName   = "������";
  }
   if( strPrintType.equals("InvesNotes") )
  {
    //39.�����������յ��鱨������¼
     strTitleName = "�����������յ��鱨������¼��ӡ";
     strBizName   = "������";
  }
  if( strPrintType.equals("RobInvesNotes") )
  {
    //40.�����յ����¼
     strTitleName = "�����յ����¼��ӡ";
     strBizName   = "������";
  }
  if( strPrintType.equals("ClaimApply") )
  {
    //41.���������� 
     strTitleName = "�����������ӡ";
     strBizName   = "������";
  }
  if( strPrintType.equals("PersonDamageInvesReport") )
  {
    //42.���˵��鱨�� 
     strTitleName = "���˵��鱨���ӡ";
     strBizName   = "������";
  }
  if( strPrintType.equals("PersonDamageInvesNotes") )
  {
    //43.���˵����¼ 
     strTitleName = "���˵����¼��ӡ";
     strBizName   = "������";
  }
  if( strPrintType.equals("RightsTransferBook") )
  {
    //44.Ȩ��ת���� 
     strTitleName = "Ȩ��ת�����ӡ";
     strBizName   = "";
  }
  if( strPrintType.equals("RefuseCancelReport") )
  {
    //45.����ע����������
    strTitleName = "����ע�����������ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("AccidentTotalLossCard") )
  {
    //46.�¹ʳ���ȫ��
    strTitleName = "�¹ʳ���ȫ�𵥴�ӡ";
    strBizName   = "������";
  }
  if( strPrintType.equals("IndemnityNotice") )
  {
    //47.���֪ͨ��
     strTitleName = "���֪ͨ���ӡ";
     strBizName   = "���������";
  }
  if( strPrintType.equals("PrepareIndemnityExamineCard") )
  {
    //48.Ԥ�����ͨ���⸶������
     strTitleName = "Ԥ�����ͨ���⸶��������ӡ";
     strBizName   = "���������";
  }
  if( strPrintType.equals("AuthorizationTrustBook") )
  {
    //49.��Ȩί����
     strTitleName = "��Ȩί�����ӡ";
     strBizName   = "";
  }
  if( strPrintType.equals("AccidentPhotoCard") )
  {
    //50.�¹���Ƭճ������ӡ
     strTitleName = "�¹���Ƭճ������ӡ";
     strBizName   = "������";
  }
  if( strPrintType.equals("OriginNoteCard") )
  {
    //51.ԭʼ��֤ճ��ҳ
     strTitleName = "ԭʼ��֤ճ��ҳ��ӡ";
     strBizName   = "������";
  }
  //add by caopeng end at 2005-12-12       
%>
<html:html locale="true">
<head>
  <title>�����ӡǰ���뵥֤��</title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/print/js/DAAPrintBeforeEdit.js"></script>
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
          registNo.style.display="";
        }
        
        if ("<%=strPrintType%>"=="Loss"  || "<%=strPrintType%>"=="ComponentList"  ||"<%=strPrintType%>"=="ComponentAdd"
             ||"<%=strPrintType%>"=="RepairList" || "<%=strPrintType%>"=="RepairAdd" )
         {
           registNo.style.display="";
         }   
        
         if ("<%=strPrintType%>"=="Compensate"  || "<%=strPrintType%>"=="CompensateAdd" 
             ||"<%=strPrintType%>"=="Endcase"  ||"<%=strPrintType%>"=="EndcaseAdd" )
         {
           registNo.style.display="";
          
         }   
     
        if ("<%=strPrintType%>"=="FileOnRisk")
        {
          fm.EndDate.value= '<%= new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY) %>';
          fm.EndDateHour.value="<%= DateTime.current().getHour() %>";
        }
         <%--modify by zhaozhuo modify 20050414 start--%>
        if ("<%=strPrintType%>"=="BackcRecord"|| "<%=strPrintType%>"=="BackcInform")
        {
         trSerialNo.style.display="";
        }
        <%--modify by zhaozhuo modify 20050414 end--%>
        if ("<%=strPrintType%>"=="Regist")
        {
          trPolicyNo.style.display="";
          trInsuredName.style.display="";
          trSerialNo.style.display="";
        }
      }


      function checkForm()
      {
        var businessNo= fm.BizNo.value;
        if( fm.PrintType.value=="FileOnRisk" || fm.PrintType.value == "ComponentList" 
                ||  fm.PrintType.value == "ComponentAdd"  ||  fm.PrintType.value == "RepairList" 
                 ||  fm.PrintType.value == "RepairAdd"  || fm.PrintType.value == "Loss"  
                 ||   fm.PrintType.value == "Endcase"  || fm.PrintType.value == "EndcaseAdd"   )        //1.������¼����������
          {
            var registNo=fm.registNo.value;
             if(registNo.length<1 && businessNo.length<1 )
            {
              errorMessage( "�����š�"+fm.BizName.value+"����ȫΪ��!");
              return false;
            }
         
       }
       else if (fm.PrintType.value=="Compensate"  || fm.PrintType.value=="CompensateAdd") {
           var registNo=fm.registNo.value;
            var claimNo=fm.claimNo.value; 
             if(registNo.length<1 && businessNo.length<1  && claimNo.length<1) 
            {
              errorMessage( "�����š�"+fm.BizName.value+"�������Ų���ȫΪ��!");
              return false;
            }
       
       
       }else if(!(fm.PrintType.value == "Regist" )){
        
         if(businessNo.length<1 )
          {
            fm.BizNo.focus();
            errorMessage(fm.BizName.value + "����Ϊ��!");
            return false;
          }
         
         //modify begin by zhuly 20051102
         // else if(trim(fm.BizNo.value).length!=21 && trim(fm.BizNo.value).length != 25 && trim(fm.BizNo.value).length !=22)
         // {
         // fm.BizNo.focus();
         // errorMessage(fm.BizName.value + "ӦΪ21λ��25!");
         //   return false;
         // }
         //modify end by zhuly 20051102
        }  
        else{
          if((trim(fm.BizNo.value).length<1)&&(trim(fm.PolicyNo.value).length<1)&&(trim(fm.InsuredName.value).length<1)&&(trim(fm.SerialNo.value).length<1)){
            alert("����ѡ��ܶ�Ϊ��");
            return false;
          }
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
            strUrl = "/claim/registBeforeQuery.do?editType=PRINT"+"&RegistNo=" +fm.BizNo.value+"&PolicyNo=" + fm.PolicyNo.value+"&InsuredName=" + fm.InsuredName.value+"&LicenseNo=" + fm.SerialNo.value;
            
          }
          if( fm.PrintType.value=="Pilfer" )          //2.���գ�������֤��
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="Cancelnotice" )    //3.����֪ͨ��
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="Canceltrans" )     //4.���ⰸ��������
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="LossSimple" )      //5.��ʧ�������ȷ����
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="Loss" )            //6.��ʧ���ȷ����
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value +"&ClaimNo=" + fm.BizNo.value;
          }
        
        	  //add by zhouliu start 2006-6-12
		     if (fm.PrintType.value=="Cancelcompel")
		      {
			      strUrl="/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
		      }
		  //add by zhouliu end 2006-6-12
         /* if( fm.PrintType.value=="ComponentList" )   //7.�㲿��������Ŀ�嵥
          {
             strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value ; //+"&ClaimNo=" + fm.BizNo.value;
           // strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value +"&ClaimNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="ComponentAdd" )    //8.�㲿��������Ŀ�嵥����
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value +"&ClaimNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="RepairList" )      //9.������Ŀ�嵥
          {
             // strUrl = "/claim/ClaimPrint.do?&ClaimNo=" + fm.BizNo.value;
             strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value +"&ClaimNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="RepairAdd" )       //10.������Ŀ�嵥����
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value +"&ClaimNo=" + fm.BizNo.value;
          }
          */
          
          if( fm.PrintType.value=="PropList" )        //11.�Ʋ���ʧȷ����
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
         /* if( fm.PrintType.value=="Compensate" )      //12.��������
          {
           strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value +"&CompensateNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="CompensateAdd" )   //13.�������鸽ҳ
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value +"&CompensateNo=" + fm.BizNo.value;
          }
          */
          if( fm.PrintType.value=="PayStatList" )     //14.���ͳ����ϸ��
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CaseNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="Drawnotice" )      //15.��ȡ���֪ͨ��
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="Prepay" )          //16.Ԥ�����������
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&PreCompensateNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="Pressnotice" )     //17.ע��֪ͨ��
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="PressnoticeEnd" )     //17.�᰸�߸�֪ͨ��
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="Endcase" )         //18.�᰸������
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value +"&ClaimNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="EndcaseAdd" )         //18.�᰸�����鸽ҳ
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value +"&ClaimNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="HistoryFile" )     //19.ԭʼ����������ǰ����
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&PolicyNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="FileOnRisk" )      //20.����ʱ����
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value +"&PolicyNo=" + fm.BizNo.value + "&EndDate=" + fm.EndDate.value +" &EndDateHour=" + fm.EndDateHour.value;

          }
          //modify by zhaozhuo add 20050414 start
          if( fm.PrintType.value=="BackcInform" )      //21.�޸��鳵֪ͨ��
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;

          }
          if( fm.PrintType.value=="BackcRecord" )      //22.���������޸��鳵��¼
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;

          }
          //modify by zhaozhuo add 20050414 end

          //modify by wangwei add start 20050527
          //ԭ������13������
          if (fm.PrintType.value == "LogoutClaimEntrol")  //23.ע���ⰸ�Ǽǲ�
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;
          }

          if (fm.PrintType.value == "PrepayClaimKnow")    //24.Ԥ�����������
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;
          }

          if (fm.PrintType.value == "HeresyCheckSubmit")   //25.���鿱ί����
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;
          }

          if (fm.PrintType.value == "StopClaimEntrol")     //26.�Ѿ��ⰸ�Ǽǲ�
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;
          }

          if (fm.PrintType.value == "NotClaimEntrol")      //27.δ���ⰸ�Ǽǲ�
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;
          }

          if (fm.PrintType.value == "LoseCallbackEntrol")   //28.�������ʻ��յǼǲ�
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;
          }

          if (fm.PrintType.value == "LawArbitrogeQuestion") //29.�����ٲð������߱�
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;
          }

          if (fm.PrintType.value == "CheckOrderLetter")     //30.����鿱���𸴺�
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;
          }

          if (fm.PrintType.value == "EndCaseHurry")         //31.�᰸�߸���
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;
          }

          if (fm.PrintType.value == "CallBackLoseDispose")   //32.�����������ʴ���
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;
          }

          if (fm.PrintType.value == "SubRogationEntrol")     //33.��λ׷�������Ǽǲ�
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;
          }

          if (fm.PrintType.value == "ReportRegistEntrol")     //34.���������Ǽǲ�
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;
          }

          if (fm.PrintType.value == "BothEraEntrol")          //35.��˫�����Ǽǲ�
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value +"&SerialNo="+fm.SerialNo.value;
          }
          if (fm.PrintType.value == "Check")          //36.�ֳ��鿱��¼
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
          if (fm.PrintType.value == "PerssonLoss")          //37.��Ա���������嵥
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
          //add begin by zhuly 20051107
          if (fm.PrintType.value == "DAAPilfer")          //1e35.���յ����ղ鿱����
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }           
          if (fm.PrintType.value == "DAAClaimDocument")  //1e36.������������������Ͻ��ӵ� 
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
          //add end   by zhuly 20051107 
		  //add by caopeng start at 2005-12-2
		  if (fm.PrintType.value == "IndemnityReceipt")  //1e37.����վ� 
          {
              if(isEmptyField(fm.printNo)){
	            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
              }else{
              	strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value + "&printNo="+fm.printNo.value;
              }
          }
		  //add by caopeng end at 2005-12-2	
		  //add by caopeng start at 2005-12-6
		  if (fm.PrintType.value == "ClaimNotice")  //1e38.������֪ 
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
		  if (fm.PrintType.value == "InvesNotes")  //1e39.�����¼ 
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
		  if (fm.PrintType.value == "RobInvesNotes")  //1e40.�����յ����¼
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
		  if (fm.PrintType.value == "ClaimApply")  //1e41.����������
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
		  if (fm.PrintType.value == "PersonDamageInvesReport")  //1e42.���˵��鱨��
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
		  if (fm.PrintType.value == "PersonDamageInvesNotes")  //1e43.���˵����¼
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
		  if (fm.PrintType.value == "RightsTransferBook")  //1e44.Ȩ��ת����
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
		  if (fm.PrintType.value == "RefuseCancelReport")  //1e45.����ע����������
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
          if (fm.PrintType.value == "AccidentTotalLossCard")  //1e46.�¹ʳ���ȫ��
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
		  if (fm.PrintType.value == "IndemnityNotice")  //1e47.���֪ͨ�� 
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
		  if (fm.PrintType.value == "PrepareIndemnityExamineCard")  //1e48.Ԥ�����ͨ���⸶������ 
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value;
          }
		  if (fm.PrintType.value == "AuthorizationTrustBook")  //1e49.��Ȩί���� 
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.BizNo.value;
          }
		  if (fm.PrintType.value == "AccidentPhotoCard")  //1e50.�¹���Ƭճ���� 
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
		  if (fm.PrintType.value == "OriginNoteCard")  //1e51.ԭʼ��֤ճ��ҳ 
          {
              strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
          }
          
          
		  //add by caopeng end at 2005-12-12	  
          
           if( fm.PrintType.value=="RepairList"  || fm.PrintType.value=="RepairAdd" ||fm.PrintType.value=="ComponentList" ||fm.PrintType.value=="Loss"
              ||fm.PrintType.value=="ComponentAdd" ) {
             //fm.action="/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&ClaimNo=" + fm.BizNo.value;
             fm.action="/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value+"&ClaimNo=" + fm.BizNo.value;
             fm.submit();
           }
           else if( fm.PrintType.value=="Compensate" || fm.PrintType.value=="CompensateAdd"  ) {
               var newWindow = window.open("/claim/compensateQuery.do?PrintType="+fm.PrintType.value+"&CompensateNo=" + fm.BizNo.value+"&RegistNo=" + fm.registNo.value+"&ClaimNo=" + fm.claimNo.value +"&editType=PRINT","NewWindow","width=600,height=500,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
             //fm.action="/claim/compensateQuery.do?PrintType="+fm.PrintType.value+"&ClaimNo=" + fm.claimNo.value +"&editType=PRINT";
             //fm.submit();
           }
           else{     //9.������Ŀ�嵥
               printWindow(strUrl,"��ӡ1");
          }
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

<meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>
<html>
<body class="interface" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="loadForm();"">
<form name="fm" method="post"   onsubmit="return validateForm(this);">

  <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
      <td width="284" height="26" valign="bottom">
        <table width="284" height="19" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
            <td width="261" class="formtitle" id="TitleName"></td>
            <td><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
          </tr>
        </table>
      </td>
      <td valign="bottom"><font color="#666666">&nbsp;</td>
    </tr>
  </table>
    <table width="90%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="common">
        <tr  style="display:none" id="registNo">
        <td class='common' style="width:20%" >�����ţ�</td>
        <td class='input'> 
            <input class="common" type='text' name='registNo' maxlength='25' style="width:320px">
        </td>
      </tr>
     
     
     
      <tr>
        <td class='common' style="width:20%" id="BizName"></td>
        <td class='input'>
            <input type='hidden' name='BizName'>
            <input class="common" type='text' name='BizNo' maxlength='25' style="width:320px">
        </td>
      </tr>
      
      <%if(strPrintType.equals("Compensate") ||strPrintType.equals("CompensateAdd") ){%>
      <tr>
        <td class='common' style="width:20%">�����ţ�</td>
        <td class='input'>            
            <input class="common" type='text' name='claimNo' maxlength='25' style="width:320px">
        </td>
      </tr>
    <%}%>
      

	<%if(strPrintType.equals("IndemnityReceipt")){%>
      <tr>
        <td class='common' style="width:20%">��ˮ��</td>
        <td class='input'>            
            <input class="common" type='text' name='printNo' maxlength='25' style="width:320px">
        </td>
      </tr>
    <%}%>
      
      <tr style="display:none" id="trPolicyNo">
        <td class="common" style="width:20%">�����ţ�</td>
        <td class="input">
          <input class="common" type="text" name="PolicyNo" maxlength="22" style="width:320px">
        </td>
      </tr>
      <tr style="display:none" id="trInsuredName">
        <td class="common" style="width:20%">�������ˣ�</td>
        <td class="input">
          <input class="common" type="text" name="InsuredName" maxlength="22" style="width:320px">
        </td>
      </tr>
      <%--modify by zhaozhuo modify 20050414 start--%>
      <tr  style="display:none" id="trSerialNo">
        <td class='common' style="width:20%">���ƺ��룺</td>
        <td class='input'>
           <input class="common" type='text' name='SerialNo' maxlength='22' style="width:320px">
        </td>
      </tr>
      <%--modify by zhaozhuo modify 20050414 end--%>
      <tr  style="display:none" id="trEndDate">
        <td class='common' style="width:20%">��ֹ���ڣ�</td>
        <td class='input'>
            <input class="common" type='text' name='EndDate' style="width:80" maxlength="10">��
            <input class="common" type='text' name='EndDateHour' style="width:20">ʱ
        </td>
      </tr>
      <tr>
        <td class="common" align="center" style="width:100%"  colspan="2">
            <input type=button value="��һ��" class='button' onclick="submitForm();">
        </td>
      </tr>
          <input type='hidden' name="PrintType">
    </table>

  </form>
</body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>


