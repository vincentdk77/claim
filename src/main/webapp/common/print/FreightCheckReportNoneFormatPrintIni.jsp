<%--
****************************************************************************
* DESC       �������ղ鿱�����嵥��ӡ��ʼ��
* AUTHOR     ��wangwei
* CREATEDATE ��2005-5-22
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.sysframework.common.util.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%>
<%@page import="com.sinosoft.claim.bl.facade.*"%>
<%@page import="com.sinosoft.utiall.dbsvr.DBPrpDcode"%>
<%@page import="com.sinosoft.claim.resource.dtofactory.domain.*"%>
<%@page import="java.util.*"%>

<%
    String strPolicyNo = "";           //������
    String strRegistNo = "";           //������
    String strEndorseNo = "";           //������
    UIEndorseAction uiEndorseAction = new UIEndorseAction();
    UIPrpLcheckExtAction uiPrpLcheckExtAction = new UIPrpLcheckExtAction();

    PrpLregistDto prpLregistDto = (PrpLregistDto) request.getAttribute("prpLregistDto");
    PrpPheadDto  prpPheadDto = null;
    PrpLcheckDto prpLcheckDto = (PrpLcheckDto) request.getAttribute("prpLcheckDto");
    PrpDcompanyDto prpDcompanyDto=(PrpDcompanyDto)request.getAttribute("prpDcompanyDto");
    PrpLextDto prpLextDto=(PrpLextDto)request.getAttribute("PrpLextDto");
    PrpCmainDto prpCmainDto=(PrpCmainDto)request.getAttribute("prpCmainDto");
    PrpCmainCargoDto prpCmainCargoDto=(PrpCmainCargoDto)request.getAttribute("prpCmainCargoDto"); 
	  strPolicyNo = prpLregistDto.getPolicyNo();
      strRegistNo = prpLregistDto.getRegistNo();

  UICheckAction uiCheckAction = new UICheckAction();
  CheckDto checkDto = uiCheckAction.findByPrimaryKey(strRegistNo);
	
	prpLextDto = checkDto.getPrpLextDto();
/*
 out.println("<br>prpLextDto=======================:"+prpLextDto);
 out.println("<br>strRegistNo=======================:"+strRegistNo);
 out.println("<br>prpLregistDto=======================:"+prpLregistDto);
 out.println("<br>prpLcheckDto=======================:"+prpLcheckDto);
 out.println("<br>prpDcompanyDto=======================:"+prpDcompanyDto);
 out.println("<br>prpLextDto=======================:"+prpLextDto);
 out.println("<br>prpCmainDto=======================:"+prpCmainDto);
 out.println("<br>prpCmainCargoDto=======================:"+prpCmainCargoDto);
*/
	Collection prpPheadDtoList = uiEndorseAction.findByPrpPheadConditions(" policyNo='" + strPolicyNo + "'");
	  if (prpPheadDtoList != null) {
           Iterator iterator = prpPheadDtoList.iterator();
            while (iterator.hasNext()) {
             prpPheadDto = (PrpPheadDto) iterator.next();
			 strEndorseNo = prpPheadDto.getEndorseNo();
			}
	    }
    Collection list=(ArrayList)request.getAttribute("list");
//      Iterator it = list.iterator();
      
  //    String strItemDetailName = "";   //��������
//      while(it.hasNext())
//			{
		 
//		    PrpCitemKindDto prpCitemKindDto=(PrpCitemKindDto)it.next();
//        if(strItemDetailName.indexOf(prpCitemKindDto.getItemDetailName())<0){
//           strItemDetailName = strItemDetailName + prpCitemKindDto.getItemDetailName() +","+ prpCitemKindDto.getQuantity();
//          }    
//      }

//        Iterator itt=list.iterator();
        double dbDeductible = 0;
//      	while(itt.hasNext())
//				{
//		      PrpCitemKindDto prpCitemKindDto=(PrpCitemKindDto)itt.next();
//			    dbDeductible =(double)prpCitemKindDto.getDeductible();
//			    break;
//			  }

    //add by zhulei 20050926 ��Ϣ��ȡ
    //prpLregistDto
    String strDamageStartDate = "";    //��������
    String strDamageName = "";         //����ԭ��
    String strEstiCurrency = "";       //������ұ�
    String strEstimateLoss = "";       //������
    DateTime dateDamageStartDate = null;   //��������
    DateTime dateReportDate = null;   //��������
    String strReportDate = "";       //��������
    String strLinkerName = "";       //��ϵ��
    String strPhoneNumber = "";       //��ϵ��ʽ
    if(prpLregistDto!=null){
      strDamageStartDate = prpLregistDto.getDamageStartDate().toString();
      strDamageName = prpLregistDto.getDamageName();
      strEstiCurrency = prpLregistDto.getEstiCurrency();
      strLinkerName = prpLregistDto.getLinkerName();
      strPhoneNumber = prpLregistDto.getPhoneNumber();
      strEstimateLoss = new DecimalFormat("0.00").format(prpLregistDto.getEstimateLoss());
      dateReportDate = prpLregistDto.getReportDate();
      strReportDate = dateReportDate.getYear()+"��"+dateReportDate.getMonth()+"��"+dateReportDate.getDate()+"��";
	  dateDamageStartDate = prpLregistDto.getDamageStartDate();
       strDamageStartDate = dateDamageStartDate.getYear()+"��"+dateDamageStartDate.getMonth()+"��"+dateDamageStartDate.getDate()+"��"+prpLregistDto.getDamageStartHour().substring(0,2)+"ʱ";

   }
    
    //prpLcheckDto
    DateTime dateCheckDate = null;   //
    String strCheckDate = "";        //ʱ��
    String strCheckSite = "";        //���յص�
    String CheckSite = "";            //�鿱�ص�	
    String CheckDate = "";            //�鿱����
    String strChecker1 = "";          //�鿱��
    String strCheckUnitName = "";     //�μӲ鿱�ĸ���
    String strHandleUnit = "";        //�μӲ鿱�ĸ���
    String ClaimNo = "";              //������ 
    String Conveyance = "";           //���䷽ʽ
    if(prpLcheckDto!=null){
     strCheckDate      = prpLcheckDto.getCheckDate().toString();
     dateCheckDate = prpLcheckDto.getCheckDate();
     strCheckDate = dateCheckDate.getYear()+"��"+dateCheckDate.getMonth()+"��"+dateCheckDate.getDate()+"��";

	  strCheckSite     = prpLcheckDto.getCheckSite();
       CheckSite       = prpLcheckDto.getCheckSite();
      CheckDate        = dateCheckDate.getYear()+"��"+dateCheckDate.getMonth()+"��"+dateCheckDate.getDate()+"��";
      strChecker1      = prpLcheckDto.getChecker1();
      strCheckUnitName = prpLcheckDto.getCheckUnitName();
      strHandleUnit    = prpLcheckDto.getHandleUnit();
	  ClaimNo          = prpLcheckDto.getClaimNo();
   }
	

    //prpLextDto
    String strAppliCheckDate = "";    //����鿱����
    String strAppliPhone = "";        //Ͷ���˻������ϵ�绰
    String strInsuredPhone = "";      //�������˻������ϵ�绰
    String strCargoLossCheckCom = ""; //����鿱��˾
    String strUnloadDate = "";        //ж������
    int strRestQuantity = 0;          //��ֵ����
	double strCargoValue = 0.0 ;      //����
    String strGuarantor = "";         //������
	String strRemark = ""  ;          //��ע,����˵������
	String strSailStartDate = "" ;    //��������
	String strLoadingNo = "" ;       //�ᵥ/�˵�
	String strInvoiceNo = "" ;       //��Ʊ����NO
	String strValue1 = "" ;          //�������Ƽ�����
	String strValue2 = "" ;           //�鿱������

   if(prpLextDto!=null){
     strAppliCheckDate = prpLextDto.getAppliCheckDate().toString();
      strAppliPhone = prpLextDto.getAppliPhone();
      strInsuredPhone = prpLextDto.getInsuredPhone();
      strCargoLossCheckCom = prpLextDto.getCargoLossCheckCom();
      strUnloadDate = prpLextDto.getUnloadDate().toString();
      strRestQuantity = prpLextDto.getRestQuantity();
      strCargoValue = prpLextDto.getCargoValue();
      strGuarantor = prpLextDto.getGuarantor();
      strRemark = prpLextDto.getRemark();

       DateTime dateSailStartDate = prpLextDto.getSailStartDate();   //��������
      strSailStartDate =  dateSailStartDate.getYear()+"��"+dateSailStartDate.getMonth()+"��"+dateSailStartDate.getDate()+"��";
      strCargoLossCheckCom = prpLextDto.getCargoLossCheckCom();
      strLoadingNo = prpLextDto.getRemark();
      strInvoiceNo = prpLextDto.getValue3();
      strValue1 = prpLextDto.getValue1();
      strValue2 = prpLextDto.getValue2();
    }
    
    //prpCmainDto
     UICompanyAction  uiCompanyAction = new UICompanyAction();
    String strSumAmount = "0.00";     //����
    String strSumValue = "0.00";      //����
    String strAppliName = "";        //Ͷ��������
    String strInsuredName = "";      //������������
    String strComCode = "";      //�б���˾����
   if(prpCmainDto!=null){
      strSumAmount   = new DecimalFormat("0.00").format(prpCmainDto.getSumAmount());
      strSumValue    = new DecimalFormat("0.00").format(prpCmainDto.getSumValue());
      strAppliName   = prpCmainDto.getAppliName();
      strInsuredName = prpCmainDto.getInsuredName();
	  strComCode     = prpCmainDto.getComCode();
      prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strComCode);//���ݳб���˾����õ���˾����
	}
    
    //prpDcompanyDto
    String strComCName = "";        //�б���˾
    if(prpDcompanyDto!=null){
      strComCName = prpDcompanyDto.getComCName();
    }
    
    //prpCmainCargoDto
    String strLadingNo = "";       //�ᵥ/�˵�
    String strCarryBillNo = "";    //��Ʊ����
    String strConveyance = "";     //���䷽ʽ
    String strVoyageNo = "";       //����/����/����
     String strTPath             = "";   //����·��
	String strStartSiteName = "";  //����·�����
    String strViaSiteName = "";   //����·�߾���
    String strEndSiteName = "";   //����·���յ�


    String strInvoiceCurrency = "";  //��Ʊ���ұ�
    String strInvoiceAmount = "";   //��Ʊ���
    String strPlusRate = "";        //�ӳɱ���
    String strCreditNo = "";        //����֤��
    String strShipNoteNo = "";      //����֪ͨ����
    String strBargainNo = "";       //��ͬ��
    String strTransferConveyance = "";  //ת�˹���
    String strBLNo = "";            //�˾��ƺ�
    String strTonCount = "";        //��λ��
    String strStartSiteCode = "";   //��ʼ�ر���
    String strViaSiteCode = "";     //��ת�ر���
    String strReshipSiteName = "";  // ת�ص�����
    String strEndDetailName = "";   //������ֹ������
    String strClaimSite = "";       //�����ص�
    String strTransferBank = "";    //��������
    String strBLName = "";    //���乤������

	if(prpCmainCargoDto!=null){
      strLadingNo = prpCmainCargoDto.getLadingNo();
      strCarryBillNo = prpCmainCargoDto.getCarryBillNo();
      strConveyance = prpCmainCargoDto.getConveyance();
      //add by zhulei begin 20050913 ���䷽ʽ����
      if(strConveyance!=null && !strConveyance.equals("")){
        DBPrpDcode dbPrpDcode = new DBPrpDcode();
        dbPrpDcode.getInfo("ConveyanceType",strConveyance);
        strConveyance = dbPrpDcode.getCodeCName();
      }
      strVoyageNo = prpCmainCargoDto.getVoyageNo();
      strStartSiteName = prpCmainCargoDto.getStartSiteName();
      if(prpCmainCargoDto.getViaSiteName()!=null){
      	strViaSiteName = prpCmainCargoDto.getViaSiteName();
      }
      strEndSiteName = prpCmainCargoDto.getEndSiteName();

	
      strInvoiceCurrency = prpCmainCargoDto.getInvoiceCurrency();
      strInvoiceAmount = prpCmainCargoDto.getInvoiceAmount()+"";
      strPlusRate = prpCmainCargoDto.getPlusRate()+"";
      strCreditNo = prpCmainCargoDto.getCreditNo();
      strShipNoteNo = prpCmainCargoDto.getShipNoteNo();
      strBargainNo = prpCmainCargoDto.getBargainNo();
      strTransferConveyance = prpCmainCargoDto.getTransferConveyance();
      strBLNo = prpCmainCargoDto.getBLNo();
      strTonCount = prpCmainCargoDto.getTonCount()+"";
      strStartSiteCode = prpCmainCargoDto.getStartSiteCode();
      strStartSiteName = prpCmainCargoDto.getStartSiteName();
      strViaSiteCode = prpCmainCargoDto.getViaSiteCode();
      strViaSiteName = prpCmainCargoDto.getViaSiteName();
      strReshipSiteName = prpCmainCargoDto.getReshipSiteName();
      strEndSiteName = prpCmainCargoDto.getEndSiteName();
      strEndDetailName = prpCmainCargoDto.getEndDetailName();
      strClaimSite = prpCmainCargoDto.getClaimSite();
      strTransferBank = prpCmainCargoDto.getTransferBank();
      strBLName = prpCmainCargoDto.getBLName();
	}
    if(strStartSiteName.length()>0)
      strTPath = strTPath + "�� "+strStartSiteName  +" ��";
    if(strViaSiteName.length()>0)
      strTPath = strTPath + " �� "+strStartSiteName  +" ";
    if(strStartSiteName.length()>0)
      strTPath = strTPath + "�� "+strEndSiteName;

//zhulei leave:ȡ ��������� ����......
    String conditions = "";
    Collection collection = null;
    conditions = "RegistNo='" + strRegistNo + "' AND TextType='3'";
    BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
    collection = blPrpLregistTextFacade.findByConditions(conditions);
    int i = 0;
    String strContext = "";      //�鿱����
    //String[] arrContext = "";      //�鿱����
    if(collection!=null){
      Iterator iterator1 = collection .iterator();
      //arrContext = new String[collection.size()];
      while (iterator1.hasNext()) {
        PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto) iterator1.next();
        //arrContext[i] = prpLRegistTextDto.getContext();
        strContext = strContext + prpLregistTextDto.getContext();
        i++;
      }
    }

%>
