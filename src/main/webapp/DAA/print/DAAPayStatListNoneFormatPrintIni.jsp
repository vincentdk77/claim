<%--
****************************************************************************
* DESC       �����������������ͳ����ϸ���ӡ��ʼ��ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>

<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.utility.string.Money"%>
<%@page import="com.sinosoft.utility.string.Date"%>
<%@page import="com.sinosoft.utility.string.Str"%>

<%@page import="com.ddcc.utiall.dbsvr.*"%>
<%@page import="com.ddcc.utiall.dbsvr.*"%>
<%@page import="com.ddcc.utiall.blsvr.*"%>
<%@page import="com.ddcc.utiall.blsvr.*"%>

<%@page import="com.ddcc.ddccall.dbsvr.lp.*"%>
<%@page import="com.ddcc.ddccall.blsvr.tb.*"%>
<%@page import="com.ddcc.ddccall.blsvr.cb.*"%>
<%@page import="com.ddcc.ddccall.blsvr.lp.*"%>
<%@page import="com.ddcc.ddccall.blsvr.pg.*"%>
<%@page import="com.ddcc.ddccall.schema.*"%>
<%@page import="com.ddcc.ddccall.ui.*"%>

<%@page import="com.sinosoft.utility.error.*"%>
<%@page import="com.sinosoft.utility.SysConst"%>

<%
  //������������
  String strCaseNo                = request.getParameter("CaseNo"); //�鵵��
  String strCompensateNo          = "";   //���������
  String strClaimNo               = "";   //������
  String strPolicyNo              = "";   //������
  String strInsureCarFlag         = "";   //�Ƿ�Ϊ����������
  String strMessage               = "";
  String strKindCode              = "";
  String strFeeTypeCode           = "";
  String strLiabDetailCode        = "";
  String strClauseType            = "";
  String strChargeCode        = "";  
    
  double dblChakanLoss      = 0;        
  double dblChakanRealpay      = 0;
  double dblJiandingLoss       = 0;
  double dblJiandingRealpay    = 0;
  double dblElseSusongLoss    = 0;
  double dblElseSusongRealpay    = 0;
  double dblSusongLoss      = 0;
  double dblSusongRealpay      = 0;
  double dblChargeElseLoss        = 0;    //Charge��������
  double dblChargeElseRealpay     = 0;    //Charge��������
  double dblCarCaiLiaoLoss        = 0;
  double dblCarCaiLiaoRealpay     = 0;
  double dblCarGongshiLoss        = 0;
  double dblCarGongshiRealpay     = 0;
  double dblCarShijiuLoss         = 0;
  double dblCarShijiuRealpay      = 0;
  double dblCarSumRest            = 0;
  double dblCarCarElseLoss        = 0;
  double dblCarCarElseRealpay     = 0;
  double dblCarCarSumLoss         = 0;    //����С��
  double dblCarCarSumRealpay      = 0;    //����С��
  double dblDaoqiangLoss          = 0;
  double dblDaoqiangRealpay       = 0;
  double dblHuozaiLoss            = 0;
  double dblHuozaiRealpay         = 0;
  double dblZiranLoss             = 0;
  double dblZiranRealpay          = 0;
  double dblPoliLoss              = 0;
  double dblPoliRealpay           = 0;
  double dblHuowuLoss             = 0;
  double dblHuowuRealpay          = 0;
  double dblTingshiLoss           = 0;
  double dblTingshiRealpay        = 0;
  double dblWuguoshiLoss          = 0;
  double dblWuguoshiRealpay       = 0;
  double dblHuahenLoss            = 0;
  double dblHuahenRealpay         = 0;
  double dblMianpeiLoss           = 0;
  double dblMianpeiRealpay        = 0;
  double dblJiuzhuLoss            = 0;
  double dblJiuzhuRealpay         = 0;
  double dblElseRiskLoss           = 0;    //���������ϼ�
  double dblElseRiskRealpay       = 0;    //���������ϼ�
  double dblThirdCailiaoLoss      = 0;
  double dblThirdCailiaoRealpay   = 0;
  double dblThirdGongshiLoss      = 0;
  double dblThirdGongshiRealpay   = 0;
  double dblThirdShijiuLoss       = 0;
  double dblThirdShijiuRealpay    = 0;
  double dblThirdSumRest          = 0;
  double dblThirdCarElseLoss      = 0;
  double dblThirdCarElseRealpay   = 0;
  double dblThirdCarSumLoss       = 0;    //�����߳���С��
  double dblThirdCarSumRealpay    = 0;    //�����߳���С��
  double dblThirdYiliaoLoss       = 0;
  double dblThirdYiliaoRealpay    = 0;
  double dblThirdXuyiLoss         = 0;
  double dblThirdXuyiRealpay      = 0;
  double dblThirdWugongLoss       = 0;
  double dblThirdWugongRealpay    = 0;
  double dblThirdZhuyuanLoss      = 0;
  double dblThirdZhuyuanRealpay   = 0;
  double dblThirdHuliLoss         = 0;
  double dblThirdHuliRealpay      = 0;
  double dblThirdYiliaoSumLoss    = 0;    //������ҽ�ƻ����С��
  double dblThirdYiliaoSumRealpay = 0;    //������ҽ�ƻ����С��
  double dblThirdCanshengLoss     = 0;
  double dblThirdCanshengRealpay  = 0;
  double dblThirdCanjuLoss        = 0;
  double dblThirdCanjuRealpay     = 0;
  double dblThirdCanbuSumLoss     = 0;    //�����߲в���С��
  double dblThirdCanbuSumRealpay  = 0;    //�����߲в���С��
  double dblThirdSiwangLoss       = 0;
  double dblThirdSiwangRealpay    = 0;
  double dblThirdSangzangLoss     = 0;
  double dblThirdSangzangRealpay  = 0;
  double dblThirdWangbuSumLoss    = 0;    //������������С��
  double dblThirdWangbuSumRealpay = 0;    //������������С��
  double dblThirdFuyangLoss       = 0;
  double dblThirdFuyangRealpay    = 0;
  double dblThirdJiaotongLoss     = 0;
  double dblThirdJiaotongRealpay  = 0;
  double dblThirdZhusuLoss        = 0;
  double dblThirdZhusuRealpay     = 0;
  double dblThirdJiaotongSumLoss  = 0;    //��ͨס�޷�С��
  double dblThirdJiaotongSumRealpay= 0;    //��ͨס�޷�С��
  double dblThirdPersonElseLoss   = 0;     
  double dblThirdPersonElseRealpay= 0;        
  double dblThirdPersonSumLoss    = 0;    //������Ա�����Ѻϼ�
  double dblThirdPersonSumRealpay  = 0;    //������Ա�����Ѻϼ�
  double dblThirdPropElseLoss     = 0;    //�����Ʋ����     
  double dblThirdPropElseRealpay  = 0;    //�����Ʋ����         
  double dblThirdSumLoss          = 0;    //����С��
  double dblThirdSumRealpay        = 0;    //����С��
  double dblPersonYiliaoLoss      = 0;
  double dblPersonYiliaoRealpay   = 0;
  double dblPersonXuyiLoss        = 0;
  double dblPersonXuyiRealpay     = 0;
  double dblPersonWugongLoss      = 0;
  double dblPersonWugongRealpay   = 0;
  double dblPersonZhuyuanLoss     = 0;
  double dblPersonZhuyuanRealpay  = 0;
  double dblPersonHuliLoss        = 0;
  double dblPersonHuliRealpay     = 0;
  double dblPersonYiliaoSumLoss   = 0;    //��Աҽ�ƻ���Ѻϼ�
  double dblPersonYiliaoSumRealpay= 0;    //��Աҽ�ƻ���Ѻϼ�
  double dblPersonCanshengLoss    = 0;
  double dblPersonCanshengRealpay = 0;
  double dblPersonCanjuLoss       = 0;
  double dblPersonCanjuRealpay    = 0;
  double dblPersonSiwangLoss      = 0;
  double dblPersonSiwangRealpay   = 0;
  double dblPersonSangzangLoss    = 0;
  double dblPersonSangzangRealpay = 0;
  double dblPersonCanwangSumLoss  = 0;    //��Ա��������С��
  double dblPersonCanwangSumRealpay= 0;   //��Ա��������С��
  double dblPersonFuyangLoss      = 0;
  double dblPersonFuyangRealpay   = 0;
  double dblPersonJiaotongLoss    = 0;
  double dblPersonJiaotongRealpay = 0;
  double dblPersonZhusuLoss       = 0;
  double dblPersonZhusuRealpay    = 0;
  double dblPersonSumLoss         = 0;    //��ԱС��
  double dblPersonSumRealpay      = 0;    //��ԱС��
  double dblSumPrepaid            = 0;    //Ԥ��
  double dblElseSumRest            = 0;    //��������/��ֵ
  
  String strChakanLoss            = "";        
  String strChakanRealpay          = "";
  String strJiandingLoss           = "";
  String strJiandingRealpay        = "";
  String strElseSusongLoss        = "";
  String strElseSusongRealpay      = "";
  String strSusongLoss            = "";
  String strSusongRealpay          = "";
  String strChargeElseLoss        = "";    //Charge��������
  String strChargeElseRealpay     = "";    //Charge��������
  String strCarCaiLiaoLoss        = "";
  String strCarCaiLiaoRealpay     = "";
  String strCarGongshiLoss        = "";
  String strCarGongshiRealpay     = "";
  String strCarShijiuLoss         = "";
  String strCarShijiuRealpay      = "";
  String strCarSumRest            = "";
  String strCarCarElseLoss        = "";
  String strCarCarElseRealpay     = "";
  String strCarCarSumLoss         = "";    //����С��
  String strCarCarSumRealpay      = "";    //����С��
  String strDaoqiangLoss          = "";
  String strDaoqiangRealpay       = "";
  String strHuozaiLoss            = "";
  String strHuozaiRealpay         = "";
  String strZiranLoss             = "";
  String strZiranRealpay          = "";
  String strPoliLoss              = "";
  String strPoliRealpay           = "";
  String strHuowuLoss             = "";
  String strHuowuRealpay          = "";
  String strTingshiLoss           = "";
  String strTingshiRealpay        = "";
  String strWuguoshiLoss          = "";
  String strWuguoshiRealpay       = "";
  String strHuahenLoss            = "";
  String strHuahenRealpay         = "";
  String strMianpeiLoss           = "";
  String strMianpeiRealpay        = "";
  String strJiuzhuLoss            = "";
  String strJiuzhuRealpay         = "";
  String strElseRiskLoss           = "";    //���������ϼ�
  String strElseRiskRealpay       = "";    //���������ϼ�
  String strThirdCailiaoLoss      = "";
  String strThirdCailiaoRealpay   = "";
  String strThirdGongshiLoss      = "";
  String strThirdGongshiRealpay   = "";
  String strThirdShijiuLoss       = "";
  String strThirdShijiuRealpay    = "";
  String strThirdSumRest          = "";
  String strThirdCarElseLoss      = "";
  String strThirdCarElseRealpay   = "";
  String strThirdCarSumLoss       = "";    //�����߳���С��
  String strThirdCarSumRealpay    = "";    //�����߳���С��
  String strThirdYiliaoLoss       = "";
  String strThirdYiliaoRealpay    = "";
  String strThirdXuyiLoss         = "";
  String strThirdXuyiRealpay      = "";
  String strThirdWugongLoss       = "";
  String strThirdWugongRealpay    = "";
  String strThirdZhuyuanLoss      = "";
  String strThirdZhuyuanRealpay   = "";
  String strThirdHuliLoss         = "";
  String strThirdHuliRealpay      = "";
  String strThirdYiliaoSumLoss    = "";    //������ҽ�ƻ����С��
  String strThirdYiliaoSumRealpay = "";    //������ҽ�ƻ����С��
  String strThirdCanshengLoss     = "";
  String strThirdCanshengRealpay  = "";
  String strThirdCanjuLoss        = "";
  String strThirdCanjuRealpay     = "";
  String strThirdCanbuSumLoss     = "";    //�����߲в���С��
  String strThirdCanbuSumRealpay  = "";    //�����߲в���С��
  String strThirdSiwangLoss       = "";
  String strThirdSiwangRealpay    = "";
  String strThirdSangzangLoss     = "";
  String strThirdSangzangRealpay  = "";
  String strThirdWangbuSumLoss    = "";    //������������С��
  String strThirdWangbuSumRealpay = "";    //������������С��
  String strThirdFuyangLoss       = "";
  String strThirdfuyangRealpay    = "";
  String strThirdJiaotongLoss     = "";
  String strThirdJiaotongRealpay  = "";
  String strThirdZhusuLoss        = "";
  String strThirdZhusuRealpay     = "";
  String strThirdJiaotongSumLoss  = "";      //��ͨס�޷�С��
  String strThirdJiaotongSumRealpay= "";    //��ͨס�޷�С��
  String strThirdPersonElseLoss   = "";     
  String strThirdPersonElseRealpay= "";        
  String strThirdPersonSumLoss    = "";      //������Ա�����Ѻϼ�
  String strThirdPersonSumRealpay  = "";      //������Ա�����Ѻϼ�
  String strThirdPropElseLoss     = "";      //�����Ʋ����     
  String strThirdPropElseRealpay  = "";      //�����Ʋ����        
  String strThirdSumLoss          = "";      //����С��
  String strThirdSumRealpay        = "";      //����С��
  String strPersonYiliaoLoss      = "";
  String strPersonYiliaoRealpay   = "";
  String strPersonXuyiLoss        = "";
  String strPersonXuyiRealpay     = "";
  String strPersonWugongLoss      = "";
  String strPersonWugongRealpay   = "";
  String strPersonZhuyuanLoss     = "";
  String strPersonZhuyuanRealpay  = "";
  String strPersonHuliLoss        = "";
  String strPersonHuliRealpay     = "";
  String strPersonYiliaoSumLoss   = "";
  String strPersonYiliaoSumRealpay= "";
  String strPersonCanshengLoss    = "";
  String strPersonCanshengRealpay = "";
  String strPersonCanjuLoss       = "";
  String strPersonCanjuRealpay    = "";
  String strPersonSiwangLoss      = "";
  String strPersonSiwangRealpay   = "";
  String strPersonSangzangLoss    = "";
  String strPersonSangzangRealpay = "";
  String strPersonCanwangSumLoss  = "";    //��Ա��������С��
  String strPersonCanwangSumRealpay= "";   //��Ա��������С��
  String strPersonFuyangLoss      = "";
  String strPersonFuyangRealpay   = "";
  String strPersonJiaotongLoss    = "";
  String strPersonJiaotongRealpay = "";
  String strPersonZhusuLoss       = "";
  String strPersonZhusuRealpay    = "";
  String strPersonSumLoss         = "";    //��ԱС��
  String strPersonSumRealpay      = "";    //��ԱС��
  String strSumPrepaid            = "";    //Ԥ��
  String strElseSumRest            = "";    //��������/��ֵ
  String strSumPaid                = "";    //���ϼ�
  
  //���뷭�����
  BLPrpDcode  blPrpDcode  = new BLPrpDcode();
  BLPrpDagent blPrpDagent = new BLPrpDagent();
  BLPrpDuser  blPrpDuser  = new BLPrpDuser ();
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��
  BLCompensate          blCompensate          = null;   //ʵ�����
  BLPrpLclaim           blPrpLclaim           = null;   //BLPrpLclaim����
  BLPrpLthirdParty      blPrpLthirdParty      = null;   //BLPrpLthirdParty����
  BLPrpLprepay          blPrpLprepay          = null;   //BLPrpLprepay����
  BLPrpLcompensate      blPrpLcompensate      = null;   //BLPrpLcompensate����
  BLPrpDcompany         blPrpDcompany         = new BLPrpDcompany();
  
  PrpLlossDto        prpLlossDto        = null;   //LossDto����
  PrpLpersonLossDto  prpLpersonLossDto  = null;   //PersonlossDto����
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto����
  
  int intCaseCount       = 0;
  int intThirdPartyCount = 0;
  int intPrepayCount     = 0;
  int intLossCount       = 0;
  int intPersonLossCount = 0;
  int intChargeCount      = 0;
  int index = 0;
  
  //�õ��鵵��
  if( strCaseNo == null )
  {
    throw new UserException(-98,-998,"","û���ṩstrCaseNo������");
  }
  if( strCaseNo.trim().length() == 0 )
  {
    throw new UserException(-98,-997,"","�û�û���ṩ�鵵�ţ�");
  }
 
  //�õ�blPrpLcompensate����
  blPrpLcompensate = new BLPrpLcompensate();
  blPrpLcompensate.query(" CaseNo = " + "'" + strCaseNo + "'");
  intCaseCount = blPrpLcompensate.getSize();
  if ( intCaseCount==0 )
  {
    strMessage = "�˹鵵�Ų����ڡ�";
%>
    <jsp:include page="/common/print/MessagePage.jsp">
      <jsp:param name="Picture" value="F" />
      <jsp:param name="Content" value="<%=strMessage%>" />
    </jsp:include>
<%
    return;
  }
  strCompensateNo = blPrpLcompensate.getArr(0).getCompensateNo();
  strClaimNo      = blPrpLcompensate.getArr(0).getClaimNo();
  strPolicyNo     = blPrpLcompensate.getArr(0).getPolicyNo();
  
  //�õ�blCompemsate����
  blCompensate = new BLCompensate();                                         
  blCompensate.getData(strCompensateNo);
  
  //�õ�blPrpLclaim����
  blPrpLclaim = new BLPrpLclaim();
  blPrpLclaim.query(" ClaimNo = " + "'" + strClaimNo + "'");
    
  //�õ�blPrpLthirdParty����ļ�¼��
  blPrpLthirdParty    = new BLPrpLthirdParty();
  blPrpLthirdParty.query(" ClaimNo = " + "'" + strClaimNo + "'");
  intThirdPartyCount  = blPrpLthirdParty.getSize();
  
  //�õ�blPrpLprepay����ļ�¼��
  blPrpLprepay    = new BLPrpLprepay();
  blPrpLprepay.query(" ClaimNo = " + "'" + strClaimNo + "'");
  intPrepayCount  = blPrpLprepay.getSize();
    
  //�õ�blPrpLloss����ļ�¼��
  intLossCount        = blCompensate.getBLPrpLloss().getSize();
  
  //�õ�blPrpLpersonLoss����ļ�¼��
  intPersonLossCount  = blCompensate.getBLPrpLpersonLoss().getSize();
  
  //�õ�blPrpLcharge����ļ�¼��
  intChargeCount      = blCompensate.getBLPrpLcharge().getSize();
%>
<script language="javascript">
  function loadForm()
  {
    tdInsuredName.innerHTML = '�������ˣ�' + '<%=StringConvert.encode(blPrpLclaim.getArr(0).getInsuredName())%>';
    tdPolicyNo.innerHTML    = '���յ��ţ�' + '<%=strPolicyNo%>';
    tdClaimNo.innerHTML     = '������ţ�' + '<%=strClaimNo%>';
    tdCaseNo.innerHTML      = '�ⰸ��ţ�' + '<%=strCaseNo%>';
    
    //*****���⳵����ϢPrpLthirdParty*****
<%    
    for(index=0;index<intThirdPartyCount;index++)
    {
      strInsureCarFlag = blPrpLthirdParty.getArr(index).getInsureCarFlag();
      
      if( strInsureCarFlag.equals("1") ) 
      {
        //�������
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(blPrpLthirdParty.getArr(index).getClauseType());
        strClauseType = blPrpDcode.translateCode("ClauseType",strCode,isChinese);
      }
    }
%>    
    tdClauseType.innerHTML  = '�������' + '<%=strClauseType%>';
<%    
    //*****Ԥ����ϢPrpLprepay*****
    for(index=0;index<intPrepayCount;index++)
    {
      dblSumPrepaid += Double.parseDouble(DataUtils.nullToZero(blPrpLprepay.getArr(index).getSumPrePaid()));
    }

    //*****��������Ϣ��PrpLcharge*****
    for(index=0;index<intChargeCount;index++)
    {
      prpLchargeDto = blCompensate.getBLPrpLcharge().getArr(index);
      strChargeCode = prpLchargeDto.getChargeCode();
      
      if( strChargeCode.equals("06") )    //���鿱�� 
      {
        dblChakanLoss    += Double.parseDouble(DataUtils.nullToZero(prpLchargeDto.getChargeAmount()));        
        dblChakanRealpay += Double.parseDouble(DataUtils.nullToZero(prpLchargeDto.getSumRealPay()));        
      }
      else if( strChargeCode.equals("07") )    //������ 
      {
        dblJiandingLoss    += Double.parseDouble(DataUtils.nullToZero(prpLchargeDto.getChargeAmount()));        
        dblJiandingRealpay += Double.parseDouble(DataUtils.nullToZero(prpLchargeDto.getSumRealPay()));        
      }
      else if( strChargeCode.equals("05") )    //���ϡ��ٲ÷�
      {
        if(prpLchargeDto.getKindCode().equals("B"))
        {
          dblSusongLoss    += Double.parseDouble(DataUtils.nullToZero(prpLchargeDto.getChargeAmount()));        
          dblSusongRealpay += Double.parseDouble(DataUtils.nullToZero(prpLchargeDto.getSumRealPay()));        
        }
        else    //�������ϡ��ٲ÷�
        {
          dblElseSusongLoss    += Double.parseDouble(DataUtils.nullToZero(prpLchargeDto.getChargeAmount()));        
          dblElseSusongRealpay += Double.parseDouble(DataUtils.nullToZero(prpLchargeDto.getSumRealPay()));        
        }
      }
      else    //PrpLcharge����������     
      {
        dblChargeElseLoss    += Double.parseDouble(DataUtils.nullToZero(prpLchargeDto.getChargeAmount()));        
        dblChargeElseRealpay += Double.parseDouble(DataUtils.nullToZero(prpLchargeDto.getSumRealPay()));        
      }
    }

    //*****�⸶�����Ϣ��PrpLloss*****
    for(index=0;index<intLossCount;index++)
    {
      prpLlossDto = blCompensate.getBLPrpLloss().getArr(index);
      
      strKindCode     = prpLlossDto.getKindCode();
      strFeeTypeCode  = prpLlossDto.getFeeTypeCode();

      if(strKindCode.equals("A"))   //������
      {
        if(strFeeTypeCode.equals("02"))   //���Ϸ�
        {
          dblCarCaiLiaoLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
          dblCarCaiLiaoRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
        }
        else if(strFeeTypeCode.equals("43"))   //��ʱ��
        {
          dblCarGongshiLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
          dblCarGongshiRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
        }
        else if(strFeeTypeCode.equals("03"))   //ʩ�ȷ�
        {
          dblCarShijiuLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
          dblCarShijiuRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
        }
        else
        {
          dblCarCarElseLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
          dblCarCarElseRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
        }
        dblCarSumRest += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRest()));
        dblCarCarSumLoss    = dblCarCaiLiaoLoss    + dblCarGongshiLoss    + dblCarShijiuLoss    + dblCarCarElseLoss + dblCarSumRest;
        dblCarCarSumRealpay = dblCarCaiLiaoRealpay + dblCarGongshiRealpay + dblCarShijiuRealpay + dblCarCarElseRealpay;
      }
      else if(strKindCode.equals("B"))   //������
      {
        if(strFeeTypeCode.equals("02"))   //���Ϸ�
        {
          dblThirdCailiaoLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
          dblThirdCailiaoRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
        }
        else if(strFeeTypeCode.equals("43"))   //��ʱ��
        {
          dblThirdGongshiLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
          dblThirdGongshiRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
        }
        else if(strFeeTypeCode.equals("03"))   //ʩ�ȷ�
        {
          dblThirdShijiuLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
          dblThirdShijiuRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
        }
        else
        {
          dblThirdCarElseLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
          dblThirdCarElseRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
        }
        dblThirdSumRest += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRest()));
        dblThirdCarSumLoss    = dblThirdCailiaoLoss    + dblThirdGongshiLoss    + dblThirdShijiuLoss    + dblThirdCarElseLoss + dblThirdSumRest;
        dblThirdCarSumRealpay = dblThirdCailiaoRealpay + dblThirdGongshiRealpay + dblThirdShijiuRealpay + dblThirdCarElseRealpay;
      } 
      else
      {
        dblElseSumRest += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRest()));
      }     
      
      if(strKindCode.equals("C"))   //������
      {
        dblDaoqiangLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
        dblDaoqiangRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
      }
      if(strKindCode.equals("E"))   //���֡���ը����ȼ��
      {
        dblHuozaiLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
        dblHuozaiRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
      }
      if(strKindCode.equals("Z"))   //��Ȼ��ʧ��
      {
        dblZiranLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
        dblZiranRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
      }
      if(strKindCode.equals("F"))   //��������������
      {
        dblPoliLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
        dblPoliRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
      }
      if(strKindCode.equals("D2"))    //���ϻ���������
      {
        dblHuowuLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
        dblHuowuRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
      }
      if(strKindCode.equals("T"))   //ͣʻ��ʧ��
      {
        dblTingshiLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
        dblTingshiRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
      }
      if(strKindCode.equals("W"))   //�޹�ʧ������
      {
        dblWuguoshiLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
        dblWuguoshiRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
      }
      if(strKindCode.equals("L"))   //��������ʧ��
      {
        dblHuahenLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
        dblHuahenRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
      }
      if(strKindCode.equals("M"))   //����������Լ��
      {
        dblMianpeiLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
        dblMianpeiRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
      }
      if(strKindCode.equals("J"))   //������Լ��
      {
        dblJiuzhuLoss    += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumLoss()));        
        dblJiuzhuRealpay += Double.parseDouble(DataUtils.nullToZero(prpLlossDto.getSumRealPay()));        
      }
      dblElseRiskLoss = dblDaoqiangLoss + dblHuozaiLoss  + dblZiranLoss    + dblPoliLoss 
                      + dblHuowuLoss    + dblTingshiLoss + dblWuguoshiLoss + dblHuahenLoss 
                      + dblMianpeiLoss  + dblJiuzhuLoss;
      dblElseRiskRealpay = dblDaoqiangRealpay + dblHuozaiRealpay  + dblZiranRealpay    + dblPoliRealpay 
                         + dblHuowuRealpay    + dblTingshiRealpay + dblWuguoshiRealpay + dblHuahenRealpay 
                         + dblMianpeiRealpay  + dblJiuzhuRealpay;
    }
    
    //*****��Ա�⸶��Ϣ��PrpLpersonLoss*****
    for(index=0;index<intPersonLossCount;index++)
    {
      prpLpersonLossDto = blCompensate.getBLPrpLpersonLoss().getArr(index);
      
      strKindCode       = prpLpersonLossDto.getKindCode();
      strLiabDetailCode = prpLpersonLossDto.getLiabDetailCode();

      if(strKindCode.equals("B"))   //������
      {
        if(strLiabDetailCode.equals("10"))   //ҽ�Ʒ�
        {
          dblThirdYiliaoLoss    += Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDto.getSumLoss()));        
          dblThirdYiliaoRealpay += Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDto.getSumRealPay()));        
        }
        else if(strLiabDetailCode.equals("12"))   //��ҽ��  
        {
          dblThirdXuyiLoss    += Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDto.getSumLoss()));        
          dblThirdXuyiRealpay += Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDto.getSumRealPay()));        
        }
        else if(strLiabDetailCode.equals("15"))   //�󹤷�
        {
          dblThirdWugongLoss    += Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDto.getSumLoss()));        
          dblThirdWugongRealpay += Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDto.getSumRealPay()));        
        }
        else if(strLiabDetailCode.equals("34"))   //סԺ��ʳ������
        {
          dblThirdZhuyuanLoss    += Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDto.getSumLoss()));        
          dblThirdZhuyuanRealpay += Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDto.getSumRealPay()));        
        }
        else if(strLiabDetailCode.equals("14"))   //�����
        {
          dblThirdHuliLoss    += Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDto.getSumLoss()));        
          dblThirdHuliRealpay += Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDto.getSumRealPay()));        
        }
        else if(strLiabDetailCode.equals("17"))   //�м����������
        {
          dblThirdCanshengLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblThirdCanshengRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("18"))   //�м��þ߷�
        {
          dblThirdCanjuLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblThirdCanjuRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("19"))   //����������
        {
          dblThirdSiwangLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblThirdSiwangRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("20"))   //ɥ���
        {
          dblThirdSangzangLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblThirdSangzangRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("21"))   //�������������  
        {
          dblThirdFuyangLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblThirdFuyangRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("24"))   //��ͨ��
        {
          dblThirdJiaotongLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblThirdJiaotongRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("23"))   //ס�޷�
        {
          dblThirdZhusuLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblThirdZhusuRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else
        {
          dblThirdPersonElseLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblThirdPersonElseRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        dblThirdYiliaoSumLoss    = dblThirdYiliaoLoss        + dblThirdWugongLoss    + dblThirdZhuyuanLoss    + dblThirdHuliLoss;
        dblThirdYiliaoSumRealpay = dblThirdYiliaoRealpay     + dblThirdWugongRealpay + dblThirdZhuyuanRealpay + dblThirdHuliRealpay;
        dblThirdCanbuSumLoss     = dblThirdCanshengLoss      + dblThirdCanjuLoss;
        dblThirdCanbuSumRealpay  = dblThirdCanshengRealpay  + dblThirdCanjuRealpay;
        dblThirdWangbuSumLoss     = dblThirdSiwangLoss        + dblThirdSangzangLoss;
        dblThirdWangbuSumRealpay = dblThirdSiwangRealpay    + dblThirdSangzangRealpay;
        dblThirdJiaotongSumLoss  = dblThirdJiaotongLoss      + dblThirdZhusuLoss;
        dblThirdJiaotongSumRealpay= dblThirdJiaotongRealpay  + dblThirdZhusuRealpay;
        
        //������Ա�����Ѻϼ�
        dblThirdPersonSumLoss    = dblThirdYiliaoSumLoss    + dblThirdCanbuSumLoss    + dblThirdWangbuSumLoss    + dblThirdJiaotongSumLoss    + dblThirdFuyangLoss    + dblThirdPersonElseLoss;
        dblThirdPersonSumRealpay = dblThirdYiliaoSumRealpay + dblThirdCanbuSumRealpay + dblThirdWangbuSumRealpay + dblThirdJiaotongSumRealpay + dblThirdFuyangRealpay + dblThirdPersonElseRealpay;

        //����С��
        dblThirdSumLoss    = dblThirdCarSumLoss    + dblThirdPersonSumLoss    + dblThirdPropElseLoss    + dblSusongLoss;
        dblThirdSumRealpay = dblThirdCarSumRealpay + dblThirdPersonSumRealpay + dblThirdPropElseRealpay + dblSusongRealpay; 
      }
      if(strKindCode.equals("D1"))   //��Ա
      {
        if(strLiabDetailCode.equals("10"))   //ҽ�Ʒ�
        {
          dblPersonYiliaoLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblPersonYiliaoRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("12"))   //��ҽ��  
        {
          dblPersonXuyiLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblPersonXuyiRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("15"))   //�󹤷�
        {
          dblPersonWugongLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblPersonWugongRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("34"))   //סԺ��ʳ������
        {
          dblPersonZhuyuanLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblPersonZhuyuanRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("14"))   //�����
        {
          dblPersonHuliLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblPersonHuliRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("17"))   //�м����������
        {
          dblPersonCanshengLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblPersonCanshengRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("18"))   //�м��þ߷�
        {
          dblPersonCanjuLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblPersonCanjuRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("19"))   //����������
        {
          dblPersonSiwangLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblPersonSiwangRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("20"))   //ɥ���
        {
          dblPersonSangzangLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblPersonSangzangRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("21"))   //�������������  
        {
          dblPersonFuyangLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblPersonFuyangRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("24"))   //��ͨ��
        {
          dblPersonJiaotongLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblPersonJiaotongRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        else if(strLiabDetailCode.equals("23"))   //ס�޷�
        {
          dblPersonZhusuLoss    += Double.parseDouble(prpLpersonLossDto.getSumLoss());        
          dblPersonZhusuRealpay += Double.parseDouble(prpLpersonLossDto.getSumRealPay());        
        }
        dblPersonYiliaoSumLoss    = dblPersonYiliaoLoss    + dblPersonWugongLoss    + dblPersonZhuyuanLoss    + dblPersonHuliLoss;
        dblPersonYiliaoSumRealpay = dblPersonYiliaoRealpay + dblPersonWugongRealpay + dblPersonZhuyuanRealpay + dblPersonHuliRealpay;
        dblPersonCanwangSumLoss   = dblPersonCanshengLoss  + dblPersonCanjuLoss      + dblPersonSiwangLoss      + dblPersonSangzangLoss;
        dblPersonCanwangSumRealpay= dblPersonCanshengRealpay+ dblPersonCanjuRealpay  + dblPersonSiwangRealpay  + dblPersonSangzangRealpay;
      
        //��ԱС��
        dblPersonSumLoss    = dblPersonYiliaoSumLoss    + dblPersonCanwangSumLoss    + dblPersonFuyangLoss    + dblPersonJiaotongLoss    + dblPersonZhusuLoss;
        dblPersonSumRealpay = dblPersonYiliaoSumRealpay + dblPersonCanwangSumRealpay + dblPersonFuyangRealpay + dblPersonJiaotongRealpay + dblPersonZhusuRealpay;
      }
    }
    
    strChakanLoss             = new DecimalFormat("0.00").format(dblChakanLoss            );        
    strChakanRealpay         = new DecimalFormat("0.00").format(dblChakanRealpay         );
    strJiandingLoss          = new DecimalFormat("0.00").format(dblJiandingLoss          );
    strJiandingRealpay       = new DecimalFormat("0.00").format(dblJiandingRealpay       );
    strElseSusongLoss         = new DecimalFormat("0.00").format(dblElseSusongLoss        );
    strElseSusongRealpay     = new DecimalFormat("0.00").format(dblElseSusongRealpay     );
    strSusongLoss             = new DecimalFormat("0.00").format(dblSusongLoss             );
    strSusongRealpay         = new DecimalFormat("0.00").format(dblSusongRealpay         );
    strChargeElseLoss         = new DecimalFormat("0.00").format(dblChargeElseLoss        );
    strChargeElseRealpay     = new DecimalFormat("0.00").format(dblChargeElseRealpay     );
    strCarCaiLiaoLoss        = new DecimalFormat("0.00").format(dblCarCaiLiaoLoss        );
    strCarCaiLiaoRealpay     = new DecimalFormat("0.00").format(dblCarCaiLiaoRealpay     );
    strCarGongshiLoss        = new DecimalFormat("0.00").format(dblCarGongshiLoss        );
    strCarGongshiRealpay     = new DecimalFormat("0.00").format(dblCarGongshiRealpay     );
    strCarShijiuLoss         = new DecimalFormat("0.00").format(dblCarShijiuLoss         );
    strCarShijiuRealpay      = new DecimalFormat("0.00").format(dblCarShijiuRealpay      );
    strCarSumRest            = new DecimalFormat("0.00").format(dblCarSumRest            );
    strCarCarElseLoss        = new DecimalFormat("0.00").format(dblCarCarElseLoss        );
    strCarCarElseRealpay     = new DecimalFormat("0.00").format(dblCarCarElseRealpay     );
    strCarCarSumLoss         = new DecimalFormat("0.00").format(dblCarCarSumLoss         );
    strCarCarSumRealpay      = new DecimalFormat("0.00").format(dblCarCarSumRealpay      );
    strDaoqiangLoss          = new DecimalFormat("0.00").format(dblDaoqiangLoss          );
    strDaoqiangRealpay       = new DecimalFormat("0.00").format(dblDaoqiangRealpay       );
    strHuozaiLoss            = new DecimalFormat("0.00").format(dblHuozaiLoss            );
    strHuozaiRealpay         = new DecimalFormat("0.00").format(dblHuozaiRealpay         );
    strZiranLoss             = new DecimalFormat("0.00").format(dblZiranLoss             );
    strZiranRealpay          = new DecimalFormat("0.00").format(dblZiranRealpay          );
    strPoliLoss              = new DecimalFormat("0.00").format(dblPoliLoss              );
    strPoliRealpay           = new DecimalFormat("0.00").format(dblPoliRealpay           );
    strHuowuLoss             = new DecimalFormat("0.00").format(dblHuowuLoss             );
    strHuowuRealpay          = new DecimalFormat("0.00").format(dblHuowuRealpay          );
    strTingshiLoss           = new DecimalFormat("0.00").format(dblTingshiLoss           );
    strTingshiRealpay        = new DecimalFormat("0.00").format(dblTingshiRealpay        );
    strWuguoshiLoss          = new DecimalFormat("0.00").format(dblWuguoshiLoss          );
    strWuguoshiRealpay       = new DecimalFormat("0.00").format(dblWuguoshiRealpay       );
    strHuahenLoss            = new DecimalFormat("0.00").format(dblHuahenLoss            );
    strHuahenRealpay         = new DecimalFormat("0.00").format(dblHuahenRealpay         );
    strMianpeiLoss           = new DecimalFormat("0.00").format(dblMianpeiLoss           );
    strMianpeiRealpay        = new DecimalFormat("0.00").format(dblMianpeiRealpay        );
    strJiuzhuLoss            = new DecimalFormat("0.00").format(dblJiuzhuLoss            );
    strJiuzhuRealpay         = new DecimalFormat("0.00").format(dblJiuzhuRealpay         );
    strElseRiskLoss          = new DecimalFormat("0.00").format(dblElseRiskLoss          );
    strElseRiskRealpay       = new DecimalFormat("0.00").format(dblElseRiskRealpay       );
    strThirdCailiaoLoss      = new DecimalFormat("0.00").format(dblThirdCailiaoLoss      );
    strThirdCailiaoRealpay   = new DecimalFormat("0.00").format(dblThirdCailiaoRealpay   );
    strThirdGongshiLoss      = new DecimalFormat("0.00").format(dblThirdGongshiLoss      );
    strThirdGongshiRealpay   = new DecimalFormat("0.00").format(dblThirdGongshiRealpay   );
    strThirdShijiuLoss       = new DecimalFormat("0.00").format(dblThirdShijiuLoss       );
    strThirdShijiuRealpay    = new DecimalFormat("0.00").format(dblThirdShijiuRealpay    );
    strThirdSumRest          = new DecimalFormat("0.00").format(dblThirdSumRest          );
    strThirdCarElseLoss      = new DecimalFormat("0.00").format(dblThirdCarElseLoss      );
    strThirdCarElseRealpay   = new DecimalFormat("0.00").format(dblThirdCarElseRealpay   );
    strThirdCarSumLoss       = new DecimalFormat("0.00").format(dblThirdCarSumLoss       );
    strThirdCarSumRealpay    = new DecimalFormat("0.00").format(dblThirdCarSumRealpay    );
    strThirdYiliaoLoss       = new DecimalFormat("0.00").format(dblThirdYiliaoLoss       );
    strThirdYiliaoRealpay    = new DecimalFormat("0.00").format(dblThirdYiliaoRealpay    );
    strThirdXuyiLoss         = new DecimalFormat("0.00").format(dblThirdXuyiLoss         );
    strThirdXuyiRealpay      = new DecimalFormat("0.00").format(dblThirdXuyiRealpay      );
    strThirdWugongLoss       = new DecimalFormat("0.00").format(dblThirdWugongLoss       );
    strThirdWugongRealpay    = new DecimalFormat("0.00").format(dblThirdWugongRealpay    );
    strThirdZhuyuanLoss      = new DecimalFormat("0.00").format(dblThirdZhuyuanLoss      );
    strThirdZhuyuanRealpay   = new DecimalFormat("0.00").format(dblThirdZhuyuanRealpay   );
    strThirdHuliLoss         = new DecimalFormat("0.00").format(dblThirdHuliLoss         );
    strThirdHuliRealpay      = new DecimalFormat("0.00").format(dblThirdHuliRealpay      );
    strThirdYiliaoSumLoss    = new DecimalFormat("0.00").format(dblThirdYiliaoSumLoss    );
    strThirdYiliaoSumRealpay = new DecimalFormat("0.00").format(dblThirdYiliaoSumRealpay );
    strThirdCanshengLoss     = new DecimalFormat("0.00").format(dblThirdCanshengLoss     );
    strThirdCanshengRealpay  = new DecimalFormat("0.00").format(dblThirdCanshengRealpay  );
    strThirdCanjuLoss        = new DecimalFormat("0.00").format(dblThirdCanjuLoss        );
    strThirdCanjuRealpay     = new DecimalFormat("0.00").format(dblThirdCanjuRealpay     );
    strThirdCanbuSumLoss     = new DecimalFormat("0.00").format(dblThirdCanbuSumLoss     );
    strThirdCanbuSumRealpay  = new DecimalFormat("0.00").format(dblThirdCanbuSumRealpay  );
    strThirdSiwangLoss       = new DecimalFormat("0.00").format(dblThirdSiwangLoss       );
    strThirdSiwangRealpay    = new DecimalFormat("0.00").format(dblThirdSiwangRealpay    );
    strThirdSangzangLoss     = new DecimalFormat("0.00").format(dblThirdSangzangLoss     );
    strThirdSangzangRealpay  = new DecimalFormat("0.00").format(dblThirdSangzangRealpay  );
    strThirdWangbuSumLoss    = new DecimalFormat("0.00").format(dblThirdWangbuSumLoss    );
    strThirdWangbuSumRealpay = new DecimalFormat("0.00").format(dblThirdWangbuSumRealpay );
    strThirdFuyangLoss       = new DecimalFormat("0.00").format(dblThirdFuyangLoss       );
    strThirdfuyangRealpay    = new DecimalFormat("0.00").format(dblThirdFuyangRealpay    );
    strThirdJiaotongLoss     = new DecimalFormat("0.00").format(dblThirdJiaotongLoss     );
    strThirdJiaotongRealpay  = new DecimalFormat("0.00").format(dblThirdJiaotongRealpay  );
    strThirdZhusuLoss        = new DecimalFormat("0.00").format(dblThirdZhusuLoss        );
    strThirdZhusuRealpay     = new DecimalFormat("0.00").format(dblThirdZhusuRealpay     );
    strThirdJiaotongSumLoss  = new DecimalFormat("0.00").format(dblThirdJiaotongSumLoss  );
    strThirdJiaotongSumRealpay= new DecimalFormat("0.00").format(dblThirdJiaotongSumRealpay);
    strThirdPersonElseLoss   = new DecimalFormat("0.00").format(dblThirdPersonElseLoss   );
    strThirdPersonElseRealpay= new DecimalFormat("0.00").format(dblThirdPersonElseRealpay);
    strThirdPersonSumLoss    = new DecimalFormat("0.00").format(dblThirdPersonSumLoss    );
    strThirdPersonSumRealpay = new DecimalFormat("0.00").format(dblThirdPersonSumRealpay );
    strThirdPropElseLoss      = new DecimalFormat("0.00").format(dblThirdPropElseLoss      );
    strThirdPropElseRealpay   = new DecimalFormat("0.00").format(dblThirdPropElseRealpay   );
    strThirdSumLoss            = new DecimalFormat("0.00").format(dblThirdSumLoss           );
    strThirdSumRealpay        = new DecimalFormat("0.00").format(dblThirdSumRealpay       );
    strPersonYiliaoLoss      = new DecimalFormat("0.00").format(dblPersonYiliaoLoss      );
    strPersonYiliaoRealpay   = new DecimalFormat("0.00").format(dblPersonYiliaoRealpay   );
    strPersonXuyiLoss        = new DecimalFormat("0.00").format(dblPersonXuyiLoss        );
    strPersonXuyiRealpay     = new DecimalFormat("0.00").format(dblPersonXuyiRealpay     );
    strPersonWugongLoss      = new DecimalFormat("0.00").format(dblPersonWugongLoss      );
    strPersonWugongRealpay   = new DecimalFormat("0.00").format(dblPersonWugongRealpay   );
    strPersonZhuyuanLoss     = new DecimalFormat("0.00").format(dblPersonZhuyuanLoss     );
    strPersonZhuyuanRealpay  = new DecimalFormat("0.00").format(dblPersonZhuyuanRealpay  );
    strPersonHuliLoss        = new DecimalFormat("0.00").format(dblPersonHuliLoss        );
    strPersonHuliRealpay     = new DecimalFormat("0.00").format(dblPersonHuliRealpay     );
    strPersonYiliaoSumLoss   = new DecimalFormat("0.00").format(dblPersonYiliaoSumLoss   );
    strPersonYiliaoSumRealpay= new DecimalFormat("0.00").format(dblPersonYiliaoSumRealpay);
    strPersonCanshengLoss    = new DecimalFormat("0.00").format(dblPersonCanshengLoss    );
    strPersonCanshengRealpay = new DecimalFormat("0.00").format(dblPersonCanshengRealpay );
    strPersonCanjuLoss       = new DecimalFormat("0.00").format(dblPersonCanjuLoss       );
    strPersonCanjuRealpay    = new DecimalFormat("0.00").format(dblPersonCanjuRealpay    );
    strPersonSiwangLoss      = new DecimalFormat("0.00").format(dblPersonSiwangLoss      );
    strPersonSiwangRealpay   = new DecimalFormat("0.00").format(dblPersonSiwangRealpay   );
    strPersonSangzangLoss    = new DecimalFormat("0.00").format(dblPersonSangzangLoss    );
    strPersonSangzangRealpay = new DecimalFormat("0.00").format(dblPersonSangzangRealpay );
    strPersonCanwangSumLoss  = new DecimalFormat("0.00").format(dblPersonCanwangSumLoss  );
    strPersonCanwangSumRealpay= new DecimalFormat("0.00").format(dblPersonCanwangSumRealpay );
    strPersonFuyangLoss      = new DecimalFormat("0.00").format(dblPersonFuyangLoss      );
    strPersonFuyangRealpay   = new DecimalFormat("0.00").format(dblPersonFuyangRealpay   );
    strPersonJiaotongLoss    = new DecimalFormat("0.00").format(dblPersonJiaotongLoss    );
    strPersonJiaotongRealpay = new DecimalFormat("0.00").format(dblPersonJiaotongRealpay );
    strPersonZhusuLoss       = new DecimalFormat("0.00").format(dblPersonZhusuLoss       );
    strPersonZhusuRealpay    = new DecimalFormat("0.00").format(dblPersonZhusuRealpay    );
    strPersonSumLoss         = new DecimalFormat("0.00").format(dblPersonSumLoss         );
    strPersonSumRealpay       = new DecimalFormat("0.00").format(dblPersonSumRealpay      );
    strSumPrepaid              = new DecimalFormat("0.00").format(dblSumPrepaid             );
    strElseSumRest            = new DecimalFormat("0.00").format(dblElseSumRest           );
    strSumPaid      = new DecimalFormat("0.00").format(Double.parseDouble(blPrpLclaim.getArr(0).getSumPaid()));
%>    
  }
</script>
