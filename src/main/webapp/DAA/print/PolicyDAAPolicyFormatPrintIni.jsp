<%--
****************************************************************************
* DESC       �����ձ�����ӡ���״򣩳�ʼ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-23
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>  

<%
  //������������
  String strPolicyNo      = "";   //ȡ������
  String strEditType      = "";   //��ӡ��ʽ 
  String strBigTitle      = "";   //��ӡ��ʽ����
  String strCarType       = "";   //�ǵ������Ƕ೵
  String strContractNo    = "";   //��ͬ��
  String strInsuredName   = "";   //������������
  String strStartYear     = "";   //����
  String strStartMonth    = "";   //����
  String strStartDay      = "";   //����
  String strStartDate     = "";   //�����ڡ�������ʹ��
  boolean isStartDate     = true; //�����е��������Ƿ�һ��
  String strEndYear       = "";   //�ձ���
  String strEndMonth      = "";   //�ձ���
  String strEndDay        = "";   //�ձ���
  String strCSumPremium   = "";   //��д�ܱ���
  String strSumPremium    = "";   //�ܱ���
  String strArgueSolution = "";   //��������ʽ
  String strComCode       = "";   //ҵ������������� 
  String strComCName      = "";   //ҵ�����������������
  String strAddressCName  = "";   //ҵ�����������ַ
  String strPostCode      = "";   //ҵ�����������������
  String strPhoneNumber   = "";   //ҵ����������绰����
  String strUnderwriteName= "";   //�˱���
  String strOperatorCode  = "";   //�Ƶ���
  String strHandlerCode   = "";   //������                       
  String strOperateDate   = "";   //�Ƶ�����                       
                            
  String strLicenseNo     = "";   //���ƺ���
  String strBrandName     = "";   //�����ͺ�
  String strEngineNo      = "";   //��������
  String strVINNo         = "";   //VIN��
  String strFrameNo       = "";   //���ܺ�
  String strCarKind       = "";   //��������
  String strSeatCount     = "";   //�˶��ؿ�
  String strTonCount      = "";   //�˶�������
  String strExhaustScale  = "";   //����/����
  String strUseYears      = "";   //��ʹ������
  String strEnrollDate    = "";   //���εǼ�ʱ��
  String strRunMiles      = "";   //����ʻ�����
  String strUseNature     = "";   //ʹ������
  String strParkSite      = "";   //�̶�ͣ�ŵص�
  String strRunAreaName   = "";   //��ʻ����
  String strPurchasePrice = "";   //�³����ü�
  String strSafeDevice    = "";   //��ȫ����
  double dblTotalProfit    = 0;    //�Żݽ��
  double dblSumTotalProfit= 0;    //���Żݽ��
  //caopeng 11.30
  String strStartHour      = "";  //��ʱ
  String strEndHour        = "";  //�ձ�ʱ
  //caopeng 11.30
  
  String strClauseCode    = "";   //�õ��ر�Լ�����룺T0001
  String strClauses       = "";   //�õ��ر�Լ������
  String strFlag          = "";   //�ж����ر�Լ�������ƻ������ݣ�Flag[2]=0:���ƣ�Flag[2]=0:����
  String strCountryNature = "";   //�ж��ǹ����������ǽ��ڲ���

  int    intPolicyCount    = 0;    //��ͬ���µı�����Ŀ
  double dblHSumPremium   = 0;     //��ͬ���µ��ܱ���

  //���뷭�����
  String strCode          = "";
  String strName          = "";
  boolean isChinese       = true; //���ı�־
   
  //�����岿��
  Vector        vecPoliEndor  = new Vector(); 
    
  PrpCmainDto    prpMainDto       = null;   //����/Ͷ������MainDto����
  PrpCitemCarDto  prpItemcarDto   = null;   //����/Ͷ������ItemcarDto����
  PrpCitemKindDto  prpItemKindDto   = null;   //����/Ͷ������ItemKindDto����
  PrpCprofitDto    prpProfitDto     = null;   //����/Ͷ������ProfitDto����
  PrpCengageDto    prpEngageDto     = null;   //����/Ͷ������EngageDto����
  PrpCfeeDto    prpFeeDto     = null;   //����/Ͷ������fee����
  
  int intItemKindCount = 0;   //ItemKindDto����ļ�¼��
  int intProfitCount    = 0;   //ProfitDto����ļ�¼��
  int intEngageCount   = 0;   //EngageDto����ļ�¼��
    
  int index = 0;
  int index1 = 0;
%>

<%  
  strPolicyNo = request.getParameter("PolicyNo");   //ȡ������   
  strCarType  = request.getParameter("CarType");  //�ǵ������Ƕ೵
  strEditType = request.getParameter("EDITTYPE");
  
  //�õ�PolicyDto,ClaimDto,RegistDto����
  EndorseDto endorseDto = (EndorseDto)request.getAttribute("endorseDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
 
  //���ҳ��������Ǳ����Ŷ����Ǳ����ţ�request��ȡ������------------
   PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
   strPolicyNo = prpCmainDto.getPolicyNo();
  //--------------------------------------------------------
  
  
  UICodeAction uiCodeAction = new UICodeAction();
  
  prpMainDto =  policyDto.getPrpCmainDto();
  PolicyDto policyDtoOld = new PolicyDto(); 
  //���Ӵ�ӡ����,���ִ�ӡ���ձ�������
  String PrintType = request.getParameter("PrintType"); 
  if(PrintType==null)
  {
    PrintType = "C";
  }
  if(strCarType==null)
  {
    strCarType = "SingleCar";
  }
  //
  if (strEditType.equals("COPY")){
    strBigTitle = "��������";
  }
  

  if( strCarType.equals("SingleCar") )  //����
  {   
    if (PrintType.equals("L"))
    {
System.out.println("--------1-----------jsp----L--");    
      //blPolicy = new BLPolicy();
      policyDtoOld = (PolicyDto)request.getAttribute("policyDto"); 
System.out.println("--------2-----------jsp----L--");    
    }
    if(PrintType.equals("O"))
    {
System.out.println("--------1-----------jsp----O--");  
      /*
      blEndorse = new BLEndorse();
      vecPoliEndor = blEndorse.findForEndorBefore(strPolicyNo,prpMainDto.getStartDate());
      blPolicy = (BLPolicy)vecPoliEndor.elementAt(0);
      */
      EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
      policyDtoOld = endorseViewHelper.findForEndorBefore(strPolicyNo,prpMainDto.getStartDate().toString()); 
System.out.println("-------2------------jsp----O--");         
    }
    if (PrintType.equals("C"))
    {
      //blPolicy = new BLPolicy();
      //blPolicy.getData(strPolicyNo);
    }              
    //�õ�MainDto����
    prpMainDto     = policyDtoOld.getPrpCmainDto();
     
    //�õ�ItemcarDto����
    if(policyDtoOld.getPrpCitemCarDtoList()!=null){
      prpItemcarDto = (PrpCitemCarDto)policyDtoOld.getPrpCitemCarDtoList().get(0);
    }
    System.out.println("-------3------------jsp----O--");         
    //prpItemcarDto = blPolicy.getBLPrpCitemCar().getArr(0);
    
    //�õ�ItemKindDto����ļ�¼��
    ArrayList itemKindDtoList = new ArrayList();
    if(policyDtoOld.getPrpCitemKindDtoList()!=null){
      itemKindDtoList = policyDtoOld.getPrpCitemKindDtoList();
      intItemKindCount = policyDtoOld.getPrpCitemKindDtoList().size();
    }
      EndorseViewHelper endorseViewHelper = new EndorseViewHelper();  
    policyDtoOld.setPrpCitemKindDtoList(endorseViewHelper.TransKind(itemKindDtoList,prpItemcarDto.getClauseType()));   
    //blPrpCitemKind    = blPolicy.getBLPrpCitemKind();
    //blPrpCitemKind    = new UIItemKindPrint().get(blPrpCitemKind,prpItemcarDto.getClauseType());
    //intItemKindCount  = blPrpCitemKind.getSize(); 
     
    //�õ�ProfitDto����ļ�¼��
    if(policyDtoOld.getPrpCprofitDtoList()!=null){
      intProfitCount = policyDtoOld.getPrpCprofitDtoList().size();
    }
        
    //�õ�EngageDto����ļ�¼��
    if(policyDtoOld.getPrpCengageDtoList()!=null){
      intEngageCount = policyDtoOld.getPrpCengageDtoList().size();
    }
     
    //reason:���Ѻϼƴ�cfee����ȡ
    //�õ�Fee����
    if(policyDtoOld.getPrpCfeeDtoList()!=null){
    
      prpFeeDto = (PrpCfeeDto)policyDtoOld.getPrpCfeeDtoList().get(0);
    }
      System.out.println("-------4------------jsp----O--");         
    //*****����������Ϣ��PrpCmain*****
    strContractNo = StringConvert.encode(prpMainDto.getContractNo());    //���Ӻ�ͬ��
     
    //���Ѻϼ�
    strCSumPremium=MoneyUtils.toChinese(prpMainDto.getSumPremium(),prpMainDto.getCurrency()); 

    //reason:���Ѻϼƴ�cfee����ȡ  
    //modify bu lixiaohua ���Ѻϼƴ�cmain����ȡ begin 20040220
    strSumPremium =new DecimalFormat("#,##0.00").format(prpMainDto.getSumPremium()); 
                   
    //��������ʽ
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpMainDto.getArgueSolution());
    if( strCode.equals("1") )   //����
    {
      strName = "����";
    }
    else if( strCode.equals("2") )   //�ٲ�ίԱ��þ�
    {
      strName = "�ύ" + StringConvert.encode(prpMainDto.getArbitBoardName()) + "����";
    } 
    strArgueSolution     = strName;
    
    //*****�������ձ����Ϣ��PrpCitemCar*****
    //��UIPolicyDAASingleCarPolicyFormatPrint.jsp���ж��ǹ����������ǽ��ڲ���
    strCountryNature = StringConvert.encode(prpItemcarDto.getCountryNature());
      
    strLicenseNo     = StringConvert.encode(prpItemcarDto.getLicenseNo());    //���ƺ���
    strBrandName     = StringConvert.encode(prpItemcarDto.getBrandName());    //�����ͺ�
    strEngineNo      = StringConvert.encode(prpItemcarDto.getEngineNo());     //��������
    strVINNo         = StringConvert.encode(prpItemcarDto.getVINNo());        //VIN��
    strFrameNo       = StringConvert.encode(prpItemcarDto.getFrameNo());      //���ܺ�
          
    //��������
    strCode = ""; 
    strName = "";
    strCode = StringConvert.encode(prpItemcarDto.getCarKindCode());
    strName = uiCodeAction.translateCodeCode("CarKind",strCode,isChinese);
    strCarKind       = strName;
    
    strSeatCount     = "" + prpItemcarDto.getSeatCount();                                         //�˶��ؿ�
    strTonCount      = "" + new DecimalFormat("#,##0.00").format(prpItemcarDto.getTonCount());        //�˶�������
    strExhaustScale  = "" + new DecimalFormat("0.0000").format(prpItemcarDto.getExhaustScale());  //����/����
    strUseYears      = "" + prpItemcarDto.getUseYears();                                          //��ʹ������
    
    //���εǼ�����  
    DateTime dt = new DateTime();
    dt = prpItemcarDto.getEnrollDate();
    //strEnrollDate   = prpItemcarDto.getEnrollDate();
    if(strEnrollDate!=null)
    {
      strEnrollDate = "" + dt.getYear()
                    + "��" + dt.getMonth()
                    + "��";   
    }
    //���Ҫ�󽫴���Ϣע��
    //strRunMiles      = "" + new DecimalFormat("#,##0.00").format(prpItemcarDto.getRunMiles());       //��ʻ��� 
           
    //ʹ������
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpItemcarDto.getUseNatureCode());  
    //modify by dengxh begin 20040830  
    if(strCode!=null && strCode.equals("84"))
       strCode="83"; 
    //modify by dengxh end 20040830    
    strName = uiCodeAction.translateCodeCode("UseNature",strCode,isChinese);
    strUseNature     = strName;
          
    //��ȫ����(1:����װ�ã�2:ABS��3:��ȫ����)
    strCode = "";
    strName = "";
    strSafeDevice = StringConvert.encode(prpItemcarDto.getSafeDevice());  //�õ���ֵ�ĸ�ʽΪ��"1��2��3"
    int i = 0;
    for(i=0;i<strSafeDevice.length();i++)
    {
      String temp = strSafeDevice.substring(i,i+1);
      if( temp.equals("1") || temp.equals("2") || temp.equals("3") )
      {
        if( i==(strSafeDevice.length()-1) )
        {  
          strCode = temp;
          strName = strName + uiCodeAction.translateCodeCode("SafeDevice",strCode,isChinese) + " "; 
        }
        else
        {
          strCode = temp;
          strName = strName + uiCodeAction.translateCodeCode("SafeDevice",strCode,isChinese) + "��"; 
        }
      }
    } 
    strSafeDevice    = strName;
           
    //�̶�ͣ�ŵص�
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpItemcarDto.getParkSite());
    strName = uiCodeAction.translateCodeCode("ParkSite",strCode,isChinese);
    strParkSite      = strName;

    //��ʻ����
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpItemcarDto.getRunAreaName());
    if( !strCode.equals("") )
    {
      strName = strCode;
    }
    else
    {
      strName = "�л����񹲺͹�����(�����۰�̨)";
    }
    strRunAreaName   = strName;
    
    strPurchasePrice = new DecimalFormat("#,##0.00").format(prpItemcarDto.getPurchasePrice());  //�³����ü�
    
    //*****���������Ϣ��PrpCitemKind*****
    //��UIPolicyDAASingleCarPolicyFormatPrint.jsp��ʵ����
    
    //*****�ر�Լ����PrpCengage*****
    strClauses = "";
      
    //�ȿ���û�������豸���ر�Լ��
     int intLimitLine = 5;  //��textarea��������ʾ������
     if((!strCarType.equals("MultiCar"))&&(prpItemcarDto.getNewDeviceFlag().equals("1")))
     {
       intLimitLine = 4;
       strClauses += "�б������豸����������豸��ϸ��\\r\\n";
     }
     if(policyDtoOld.getPrpCengageDtoList()!=null){
      for(index=0;index<intEngageCount;index++)
      {
        prpEngageDto = (PrpCengageDto)policyDtoOld.getPrpCengageDtoList().get(index);
        strClauseCode = prpEngageDto.getClauseCode();
        String strTitleFlag =  prpEngageDto.getTitleFlag();     
        if(strTitleFlag.trim().equals("1"))
        {
            strClauses += prpEngageDto.getClauses()+ "\\r\\n" ;
        }
      }      
    }
    
    //����ر�Լ��������Ǽ���
    int intEngageCountTmp1 = 1;    //textarea��������֮����intEngageCountTmp�ĳ�ʼֲΪ1����Ϊ��������1��
    int intEngageCountTmp2 = 1;    //textarea��������֮����intEngageCountTmp�ĳ�ʼֲΪ1����Ϊ��������1��
    String strClausesTmp = "";    //��"�������ݣ�������嵥..."������
    
    for(index=0;index<strClauses.length();index++)
    {
      if(strClauses.substring(index,index+1).equals("\\"))
      {
        if(!(strClauses.substring(index).length()<4))
        {
          if(strClauses.substring(index,index+4).equals("\\r\\n"))
          {
             intEngageCountTmp1 += 1;    //ֻҪ�лس����У�intEngageCountTmp1+1
             intEngageCountTmp2 += 1;    //ֻҪ�лس����У�intEngageCountTmp2+1
            if(intEngageCountTmp2==intLimitLine)
            {
              strClausesTmp = strClauses.substring(0,index+4)  //intLimitLine�е�strClauses + "�������ݣ�������嵥..."
                            + "�������ݣ�������嵥...";
            }
          }
        }
      }
    }
    
    int x = 0;
    int y = 0;
    if(!(strClauses.length()<4))    //���strClauses.length()>=4���ж�strClauses��β�����֣����ǻس�����
    {
      x = strClauses.length()-4;
      y = strClauses.length();
      if(!strClauses.substring(x,y).equals("\\r\\n"))
      {
         intEngageCountTmp1 += 1;   
      }
    }
    else    //���strClauses����1�У�intEngageCountTmp1 = 1; 
      intEngageCountTmp1 = 1; 
    
    //���intEngageCountTmp1>intLimitLine+1����strClauses = intLimitLine�е�strClauses + "�������ݣ�������嵥..."
    if(intEngageCountTmp1>intLimitLine+1)
    {
      strClauses = strClausesTmp;
    }  
    
    //������ֱ�ӷ���HTML�У�������Ҫʹ��StringConvert.decode()�������е�"\\r\\n"ת��Ϊ"\r\n"
    strClauses = StringConvert.decode(strClauses);
  }  
  
  else if( strCarType.equals("MultiCar") )  //�೵
  {
  /*
    BLPrpCmain  blPrpCmain = null;   
    strContractNo = request.getParameter("PolicyNo");   //ȡ��ͬ��
    
    //�೵����"������"��ӡ��ͬ�� 
    strPolicyNo   = strContractNo;
    
    blPrpCmain = new BLPrpCmain();
    
    //�õ���һ�ű���������Ϣ����
    blPrpCmain.query("rowid = (SELECT MIN(rowid) FROM PrpCmain WHERE contractno = '"+ strContractNo+"')");
    prpMainDto = blPrpCmain.getArr(0);
    strStartDate = prpMainDto.getStartDate().trim();  ////�õ���һ�ű�����������
    
    blPrpCmain.query("contractno='" + strContractNo + "'");
    intPolicyCount = blPrpCmain.getSize();
    for(index=0;index<intPolicyCount;index++)
    {
      dblHSumPremium += Double.parseDouble(StringConvert.chgStrZero(blPrpCmain.getArr(index).getSumPremium()));
      //�жϳ����е��������Ƿ�һ��
      if(!blPrpCmain.getArr(index).getStartDate().trim().equals(strStartDate))
        isStartDate = false;  
    }
    //�ر�Լ��
    strClauses = "�ܹ�Ͷ����������Ϊ" + intPolicyCount + "�����ܱ���" + new DecimalFormat("#,##0.00").format(dblHSumPremium) + "Ԫ��";
    */
  }
    
  //*****��������****//
  //������������
  strInsuredName= StringConvert.encode(prpMainDto.getInsuredName());
     
  //�����ڼ䡪������ǵ�����ӡ���ǳ��Ӵ�ӡ����������һ�����ӡ�����ڼ�
  if( !strCarType.equals("MultiCar")||(strCarType.equals("MultiCar")&&isStartDate==true) )
  {
    strStartYear  =  ""+prpMainDto.getStartDate().getYear();
    strStartMonth =  ""+prpMainDto.getStartDate().getMonth();
    strStartDay   =  ""+prpMainDto.getStartDate().getDate();
    strEndYear    =  ""+prpMainDto.getEndDate().getYear();
    strEndMonth   =  ""+prpMainDto.getEndDate().getMonth();
    strEndDay     =  ""+prpMainDto.getEndDate().getDate() ; 
    //caopeng 11.30
  	strStartHour  =  ""+prpMainDto.getStartHour();  //��ʱ
  	strEndHour    =  ""+prpMainDto.getEndHour();  //�ձ�ʱ
  	//caopeng 11.30
    
  }
  
  //����������Ϣ
  strComCode       = StringConvert.encode(prpMainDto.getComCode());
  //prpDcompanyDto.getInfo(strComCode);
  UICompanyAction uiCompanyAction = new UICompanyAction();
  PrpDcompanyDto prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strComCode); 
  strComCName      = prpDcompanyDto.getComCName();
  strAddressCName  = prpDcompanyDto.getAddressCName();
  strPostCode      = prpDcompanyDto.getPostCode();
  strPhoneNumber   = prpDcompanyDto.getPhoneNumber();    
  
  //ǩ������
  strOperateDate   = "" + prpMainDto.getOperateDate().getYear()
                     + "��" + prpMainDto.getOperateDate().getMonth()
                     + "��" + prpMainDto.getOperateDate().getDate()
                     + "��";  
  
  strUnderwriteName= StringConvert.encode(prpMainDto.getUnderWriteName());   //�˱���
  
  //�Ƶ���
  strCode = "";
  strName = "";
  strCode = StringConvert.encode(prpMainDto.getOperatorCode());
  strName = uiCodeAction.translateUserCode(strCode,isChinese);  
  strOperatorCode  = strName;
  
  //������
  strCode = "";
  strName = "";
  strCode = StringConvert.encode(prpMainDto.getHandlerCode());
  strName = uiCodeAction.translateUserCode(strCode,isChinese);
  strHandlerCode   = strName;      
  
  //moify by lirj update begin 040326
  //�������ߴ�ӡͶ����ȷ����
  //ȷ���������                        
  String strValidNo       = ""; 
  
  //��������
  /*
  //BLPrpExtraBValid blPrpExtraBValid           = new BLPrpExtraBValid();
  PrpExtraBValidDto  prpExtraBValidDto  = null;
  String isql = "";
  String isql_count = "";
  int    countValid = 0;
   
  isql = "SELECT * FROM PrpExtraBValid WHERE PolicyNo='" + strPolicyNo + "'";
  isql_count = "SELECT COUNT(*) FROM PrpExtraBValid WHERE PolicyNo='" + strPolicyNo + "'";
   
  countValid = blPrpExtraBValid.getCount(isql_count);

  if( countValid == 0)
  {
    strValidNo       = ""; 
  }
  else
  {
    blPrpExtraBValid.query(isql);
    prpExtraBValidDto = blPrpExtraBValid.getArr(0);
    strValidNo    = prpExtraBValidDto.getValidNo();
    strValidNo    = "Ͷ����ȷ����Ϊ��" + strValidNo;
  }
  */
   //modify by lirj update end 040326
   System.out.println("-------5------------jsp----O--");         
%> 