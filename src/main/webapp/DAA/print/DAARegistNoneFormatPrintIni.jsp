<%--
****************************************************************************
* DESC       �������������ձ�����¼(������)��ӡ��ʼ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   Name       Date            Reason/Contents
--------------------------------------------------------------------------
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
<%@page import="com.sinosoft.utility.string.Str"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLclaimFacade"%>
<%@page import="com.sinosoft.claim.bl.facade.BLEndorseFacade"%>
<%@page import="com.sinosoft.claim.bl.facade.BLCompensateFacade"%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper" %>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmainSub"%>
<%@page import="com.sinosoft.prpall.bl.facade.BLPrpCengageFacade" %>

<%
	String strCode = "";
	String strName = "";
	boolean isChinese = true; //���ı�־

	//�����岿��

	int index = 0;
	PrpCmainDto prpMainDto = null; //������MainDto����
	PrpCinsuredDto prpInsuredDto = null; //������InsuredDto����
	PrpCitemCarDto PrpCitemCarDto = null; //������ItemcarDto����
	PrpCcarDriverDto prpcarDriverDto = null; //������CarDriverDto����
	PrpCitemKindDto prpCitemKindDto = null; //������ItemKindDto����
	PrpCengageDto prpEngageDto = null; //������EngageDto����
	com.sinosoft.prpall.dto.domain.PrpCengageDto prpEngageDtoMainSub = null;
	PrpLclaimDto prpLclaimDto = null; //ClaimDto����
	PrpLdriverDto prpLdriverDto = null; //DriverDto����
	PrpLthirdPartyDto prpLthirdPartyDto = null; //ThirdPartyDto����
	PrpPheadDto prpPheadDto = null; //PheadDto����
	//modify by lirj update begin 040211
	//reason:���ճ���������Ϣ������ʾ��������ժҪ��Ϣ��Ŀǰֻ��ʾ�������վ���
	PrpLregistTextDto prpLregistTextDto = null;

	PrpCplanDto prpCplanDto = null;
	PrpLextDto prpLextDto = null;

	UICodeAction uiCodeAction = new UICodeAction();

	String strRegistNo1 = "";
	int intRegistCount = 0; //RegistDto����ļ�¼��
	int intInsuredCount = 0; //InsuredDto����ļ�¼��
	int intCarDriverCount = 0; //CarDriverDto����ļ�¼��
	int intItemKindCount = 0; //ItemKindDto����ļ�¼��
	int intItemCarCount = 0; //ItemCarDto����ļ�¼��
	int intEngageCount = 0; //EngageDto����ļ�¼��
	int intEngageCountTmp = 0; //textarea����
	int intDriverCount = 0; //DriverDto����ļ�¼��
	int intThirdPartyCount = 0; //ThirdPartyDto����ļ�¼��
	int intPheadCount = 0; //PheadDto����ļ�¼��
	int intPheadCountTmp = 0;
	int intClaimCount = 0; //ClaimDto����ļ�¼��
	int intClaimCountTmp = 0;
	int intCompensateCount = 0; //Compensate����ļ�¼��   
	int intPlanCount = 0;

	String strInsuredNature = ""; //�ж�����Ȼ�˻��Ƿ���
	String strChangeLessFlag = ""; //�ж�������ʻ���Ǹ���ʻ
	String strInsuredTerm = ""; //�õ�"/"�ı����ڼ� 
	String strClauseCode = ""; //�õ��ر�Լ�����룺T0001
	String strClauses = ""; //�õ��ر�Լ������
	String strFlag = ""; //�ж����ر�Լ�������ƻ������ݣ�Flag[2]=0:���ƣ�Flag[2]=1:����
	String strEnrollDate = ""; //���εǼ�����
	String strLicenseNo = ""; //�����еĺ��ƺ���
	String strLicenseColorCode = ""; //�����еĺ��Ƶ�ɫ
	String strLicenseNo1 = ""; //���⳵����Ϣ�еĺ��ƺ���
	String strLicenseColorCode1 = ""; //���⳵����Ϣ�еĺ��Ƶ�ɫ
	String strLicenseNo2 = ""; //���ƺ���
	String strInsureCarFlag = ""; //�Ƿ�Ϊ����������
	String strEndorseNo = ""; //������
	String strPheadText = ""; //������Ϣ
	String strClaimText = ""; //������Ϣ
	String strContext1 = ""; //����ժҪ
	double dblSumPaid = 0; //����ܼ�
	String policyNo = ""; //��ҵ�ձ�����
	String DAZpolicyNo = ""; //��ǿ�ձ�����
	String DAZStartDate = ""; //��ǿ��������
	String DAZEndDate = ""; //��ǿ���ձ�����
	String DAAStartDate = ""; //��ҵ��������
	String DAAEndDate = ""; //��ҵ���ձ�����
	String VINorFramNo = ""; //VIN��/���ܺ�
	String DAZInsureDate = ""; //��ǿ�ձ����ڼ�
	String DAAInsureDate = ""; //��ҵ�ձ����ڼ�
	String strOperatorName = "";
	String strHandlerName = "";
	String strUnderwriteName = "";
	String strUserCode = "";
	String strUserName = "";
	String strInputDate = "";
	String strMessage = "";
	String strDelinquentFee = "";
	double douDelinquentFee = 0d;
	double douPlanFee = 0d;
	String[] strKindCode = new String[40];
	String[] strKindName = new String[40];
	String[] strDangerLevel = new String[40];//����ˮƽ
	String[] douAmount = new String[40];
	String[] strItemKindFlag5 = new String[40];//���������־λ
	String checkInfo = "";//�鿱��Ϣ�ظ�

	String strColorCode = "";//������ɫ
	String outColorCode = "";//������ɫ���
	String strDirverFirstTime = "";//��ʻ֤������֤����
	String strInsuredCompany = "";//�������˵�λ��Ϣ
	String strInsuredCompanyName = "";//�������˵�λ��Ϣ
	String strCarClause = "";//�����������
	String strCarClauseName = "";//���������������
	double strSumPremium = 0;//���շ�
	String strArgumentName = "";
	String strArgumentNumber = "";
	String strArgumentFirst = "";
	//ȡ��policyDto��registDto��endorseDto
	RegistDto registDto = (RegistDto) request.getAttribute("registDto");
	PrpLregistDto prpLregistDto = (PrpLregistDto) request
			.getAttribute("prpLregistDto");
	PolicyDto policyDto = (PolicyDto) request.getAttribute("policyDto");
	EndorseDto endorseDto = (EndorseDto) request
			.getAttribute("endorseDto");
	//����ǰ�ĳ�����ӡ:�����������Ϣ��Ҫ��ҳ������ȡ
	String strBizType = request.getParameter("bizType");
	String strmainPolicyNo = (String)request.getParameter("mainPolicyNo");
	if(strBizType != null && strBizType.equals("P")){
		policyNo = request.getParameter("PolicyNo");//������
		strLicenseNo = request.getParameter("licenseNo");
		//��ϵ��
        //��ϵ�绰
        //����ʱ��
        //�Ƿ��һ�ֳ�����        
        //����ԭ��
        //���յص�
        //�¹ʴ�����
		String strDamageStartDate = request.getParameter("damageStartDate");//����ʱ��
		String strDamageStartHour = request.getParameter("damageStartHour");//����Сʱ
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		policyDto = endorseViewHelper.findForEndorBefore(policyNo, strDamageStartDate, strDamageStartHour);//����ʱ������Ϣ
		UIEndorseAction uiEndorseAction = new UIEndorseAction();
        endorseDto = uiEndorseAction.findByConditions(policyNo);//������Ϣ
        registDto = new RegistDto();
        prpLregistDto = new PrpLregistDto();
        prpLregistDto.setPolicyNo(policyNo);
        prpLregistDto.setRiskCode(policyDto.getPrpCmainDto().getRiskCode());
        prpLregistDto.setDamageStartDate(new DateTime(strDamageStartDate));
        prpLregistDto.setDamageStartHour(strDamageStartHour);
        
        String riskType = uiCodeAction.translateRiskCodetoRiskType(policyDto.getPrpCmainDto().getRiskCode());
        if("RISKCODE_DAZ".equals(riskType) == false&&"RISKCODE_DAY".equals(riskType) == false &&"RISKCODE_DAU".equals(riskType) == false)
		{
	        if(policyDto.getPrpCmainSubDtoList().size() > 0){
	        	PrpCmainSubDto prpCmainSubDto = (PrpCmainSubDto)policyDto.getPrpCmainSubDtoList().get(0);
	        	if(prpCmainSubDto.getFlag().substring(0,1).equals("1")){
	        		PolicyDto rPolicyDto = new PolicyDto();
	        		if(prpLregistDto.getRiskCode().equals("0507")||prpLregistDto.getRiskCode().equals("0577")||prpLregistDto.getRiskCode().equals("0587")){
	        			rPolicyDto = endorseViewHelper.findForEndorBefore(prpCmainSubDto.getPolicyNo(),strDamageStartDate,strDamageStartHour);
	        		}else{
	        		    rPolicyDto = endorseViewHelper.findForEndorBefore(prpCmainSubDto.getMainPolicyNo(),strDamageStartDate,strDamageStartHour);
	        		}
	            	if (rPolicyDto.getPrpCitemKindDtoList() != null){
	    				 ArrayList rPrpCitemKindDtoList = rPolicyDto.getPrpCitemKindDtoList();
	    				 request.setAttribute("rPrpCitemKindDto",rPrpCitemKindDtoList);
	                }
	        	}
	        }
		}
        
	}
	ArrayList endroseDtoList = endorseDto.getPrpPheadDtoList(); //�����б�
	prpMainDto = policyDto.getPrpCmainDto();
	String strPolicyNo = prpLregistDto.getPolicyNo(); //��������

	Collection prpLregistDtoList = new ArrayList();
	String registInfo = "";
	PrpLregistDto prpLregistDto1 = null;
	UIRegistAction uiRegistAction = new UIRegistAction();
	prpLregistDtoList = (ArrayList) uiRegistAction
			.findSamePolicyRegist(strPolicyNo);
	Iterator it = prpLregistDtoList.iterator();
	//int count = 0;
	/*while (it.hasNext()) {
		count++;
		prpLregistDto1 = (PrpLregistDto) it.next();
		registInfo += "&nbsp;�����ţ�" + prpLregistDto1.getRegistNo()
		+ "&nbsp;&nbsp;����ʱ�䣺"
		+ prpLregistDto1.getDamageStartDate() + "<br>";
		if (count > 2) {
			registInfo += "���ݹ��࣬��鿴���γ�����Ϣ��";
			break;
		}
	}
    */
	//�õ�PrpCengage����ļ�¼��  
	if (policyDto.getPrpCengageDtoList() != null) {
		intEngageCount = policyDto.getPrpCengageDtoList().size();
	}

	UIClaimAction uiClaimAction = new UIClaimAction();
	String conditions = " PolicyNo='" + strPolicyNo + "'";
			//+ "' AND RegistNo !='" + prpLregistDto.getRegistNo()
			//+ "' AND ClaimDate<='" + prpLregistDto.getReportDate()
			//+ "' ";
	ArrayList listTemp = (ArrayList) uiClaimAction
			.findByConditions(conditions);
	if (listTemp != null) {
		intCompensateCount = listTemp.size();
	}

	//if(registDto.getPrpLregistTextDtoList()!=null){

	//}
	//�����ڼ�
	strInsuredTerm = prpMainDto.getStartDate().getYear() + "��"
			+ prpMainDto.getStartDate().getMonth() + "��"
			+ prpMainDto.getStartDate().getDate() + "��"
			+ prpMainDto.getStartHour() + "ʱ����"
			+ prpMainDto.getEndDate().getYear() + "��"
			+ prpMainDto.getEndDate().getMonth() + "��"
			+ prpMainDto.getEndDate().getDate() + "��"
			+ prpMainDto.getEndHour() + "ʱֹ";
	//ȡ�ý�ǿ������ҵ�յĹ�����Ϣ
	List prpcmainSubList = policyDto.getPrpCmainSubDtoList();
		if ("0507".equals(prpLregistDto.getRiskCode())
				||"0577".equals(prpLregistDto.getRiskCode())
				||"0587".equals(prpLregistDto.getRiskCode())) {
					DAZpolicyNo = prpLregistDto.getPolicyNo();
		}else{
			policyNo = prpLregistDto.getPolicyNo();
		}
	if ("0507".equals(prpLregistDto.getRiskCode())
			||"0577".equals(prpLregistDto.getRiskCode())
			||"0587".equals(prpLregistDto.getRiskCode())) {
		DAZInsureDate = strInsuredTerm;
	}else{
		DAAInsureDate = strInsuredTerm;
	}
		if (prpcmainSubList.size() > 0) {
			PrpCmainSubDto prpcmainDto = (PrpCmainSubDto) prpcmainSubList.get(0);
			if ("0507".equals(prpLregistDto.getRiskCode())
					||"0577".equals(prpLregistDto.getRiskCode())
					||"0587".equals(prpLregistDto.getRiskCode())) {
				if("P".equals(strBizType)){
					if(strmainPolicyNo!=null && !strmainPolicyNo.equals("")){
						policyNo = prpcmainDto.getPolicyNo();
					}else{
						policyNo = "--------";
					}
				}else{
					policyNo = prpcmainDto.getPolicyNo();
				}
				if (prpcmainDto.getStartDate().isEmpty()) {
					DAAInsureDate = "--------------------";
						} else {
					DAAInsureDate = prpcmainDto.getStartDate().getYear()
							+ "��" + prpcmainDto.getStartDate().getMonth()
							+ "��" + prpcmainDto.getStartDate().getDate()
							+ "��" + "0ʱ����"
							+ prpcmainDto.getEndDate().getYear() + "��"
							+ prpcmainDto.getEndDate().getMonth() + "��"
							+ prpcmainDto.getEndDate().getDate() + "��"
							+ "24ʱֹ";
						}
			}else{
				if("P".equals(strBizType)){
					if(strmainPolicyNo!=null && !strmainPolicyNo.equals("")){
						DAZpolicyNo = prpcmainDto.getMainPolicyNo();
					}else{
						DAZpolicyNo = "--------";
					}
				}else{
					DAZpolicyNo = prpcmainDto.getMainPolicyNo();
				}
				if (prpcmainDto.getStartDate().isEmpty()) {
					DAZInsureDate = "--------------------";
						} else {
					DAZInsureDate = prpcmainDto.getStartDate().getYear()
							+ "��" + prpcmainDto.getStartDate().getMonth()
							+ "��" + prpcmainDto.getStartDate().getDate()
							+ "��" + "0ʱ����"
							+ prpcmainDto.getEndDate().getYear() + "��"
							+ prpcmainDto.getEndDate().getMonth() + "��"
							+ prpcmainDto.getEndDate().getDate() + "��"
							+ "24ʱֹ";
						}
			}			
			BLEndorseFacade blEndorseFacade = new BLEndorseFacade();
			//�������Ľ�ǿ�ձ�����������Ϣ��ӽ� �����б���
			EndorseDto endorseDtoTemp = blEndorseFacade.findByConditions(DAZpolicyNo);
			if (endorseDtoTemp != null) {
				  endroseDtoList.addAll(endorseDtoTemp.getPrpPheadDtoList());
			}
		} else {
			if("0507".equals(prpLregistDto.getRiskCode())
					||"0577".equals(prpLregistDto.getRiskCode())
					||"0587".equals(prpLregistDto.getRiskCode())){
				
				policyNo="----------";
			}else{
				DAZpolicyNo = "----------";
			}
		}
	

	//�õ�PrpPhead����  
	if (endroseDtoList != null) {
		intPheadCount = endroseDtoList.size();
	}
%>

<script language="javascript">
  function loadForm()
  {
    tdDAZPolicyNo.innerHTML = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��ǿ�ձ����ţ�' + '<%=DAZpolicyNo%>';
    tdPolicyNo.innerHTML = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��ҵ�ձ����ţ�' + '<%=policyNo%>';
<!--    tdPolicyNo1.innerHTML = '���յ��ţ�' + '<%=prpLregistDto.getPolicyNo()%>'; -->
    tdRegistNo.innerHTML = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;������ţ�' + '<%=prpLregistDto.getRegistNo()%>' + '&nbsp;';
    tdDAZInsureDate.innerHTML = '��ǿ�ձ����ڼ䣺' + '<%=DAZInsureDate%>';
    tdDAAInsureDate.innerHTML = '��ҵ�ձ����ڼ䣺' + '<%=DAAInsureDate%>';
    //*****������Ϣ��PrpLregist*****
<%        
    //������ʽ
    strCode = "";
    strName = "";
    //strCode = StringConvert.encode(prpLregistDto.getReportType());
    //strName = uiCodeAction.translateCodeCode("ReportType",strCode,isChinese);
    
    String strReportType = prpLregistDto.getReportType();
   
    
    String strDateTemp = "";   
    if(prpLregistDto.getDamageStartHour()!=null){
//      if(prpLregistDto.getDamageStartHour().length()<2){
        strDateTemp = prpLregistDto.getDamageStartHour(); 
//      }else{
//        strDateTemp = prpLregistDto.getDamageStartHour().substring(0,2);
//      }
    	}
	
    
%>    
    tdReportType.innerHTML      = '������ʽ��' + '<%=strReportType%><%//=prpLregistDto.getReportType()%>';
    tdReportorName.innerHTML    = '�����ˣ�'   + '<%=prpLregistDto.getReportorName()%>';
    tdReportDate.innerHTML      = '����ʱ�䣺' + '<%=prpLregistDto.getReportDate()%>' + ' '+'<%=prpLregistDto.getReportHour()%>';
    tdLinkerName.innerHTML      = '��ϵ�ˣ�'   + '<%=StringConvert.encode(prpLregistDto.getLinkerName())%>';
    //tdLinkerName1.innerHTML      = '��ϵ�ˣ�'   + '<%=StringConvert.encode(prpLregistDto.getLinkerName())%>';
    tdPhoneNumber.innerHTML     = '��ϵ�绰��' + '<%=StringConvert.encode(prpLregistDto.getPhoneNumber())%>';
    //tdPhoneNumber1.innerHTML     = '��ϵ�绰��' + '<%=StringConvert.encode(prpLregistDto.getPhoneNumber())%>';
    //tdDamageStartDate.innerHTML = '����ʱ�䣺' + '<%=prpLregistDto.getDamageStartDate()%>';
    tdDamageStartDate.innerHTML = '����ʱ�䣺' + '<%=prpLregistDto.getDamageStartDate()%>'+ ' '+ '<%=strDateTemp%>';
    //modify by lirj update end 040219
    tdDamageName.innerHTML      = '����ԭ��' + '<%=StringConvert.encode(prpLregistDto.getDamageName())%>';
    tdDamageAddress.innerHTML   = '���յص㣺' + '<%=StringConvert.encode(prpLregistDto.getDamageAddress())%>';
<%
    //�Ƿ��ǵ�һ�ֳ�����
    strCode = ""; 
    strName = "";
    strCode = prpLregistDto.getFirstSiteFlag();
    if( strCode.equals("0") )
    {
      strName = "��";    
    }
    else 
    {
      strName = "��";  
    }
%>    
    tdFirstSiteFlag.innerHTML   = '��һ�ֳ�������' + '<%=strName%>';
<!--    tdPersonInjure.innerHTML    = '������Ա��';  -->
 <!--   tdDamageAreaName.innerHTML  = '��������'+'<%=prpLregistDto.getDamageAreaName()%>'; -->
  <!--  tdDamageAddressType.innerHTML  = '���յص���ࣺ'+'<%=uiCodeAction.translateCodeCode("DamageAddress",prpLregistDto.getDamageAddressType(),true)%>'; -->
<%
    //������
    strCode = "";
    strCode = StringConvert.encode(prpLregistDto.getHandleUnit());
    String strHandleUnit = uiCodeAction.translateCodeCode("HandleUnit",strCode,true);
    String strComCode = StringConvert.encode(policyDto.getPrpCmainDto().getComCode());
    String strComName = uiCodeAction.translateComCode(strComCode,true);
%>
    tdHandleUnit.innerHTML      = '�¹ʴ����ţ�' + '<%=strHandleUnit%>';
    tdHandleUnit1.innerHTML = '�б���˾��' +'<%=Str.encode(strComName)%>';
<%        
    //modify by liruijuan update end 031229
    //�б���˾
    strName = "";
    strName = StringConvert.encode(prpLregistDto.getComName());
%>    
    
    //*****���չ�ϵ�˱�PrpCinsured*****
    tdInsuredName.innerHTML        = '�������ˣ�';
    tdInsuredAddress.innerHTML     = '��������סַ��';
    tdInsuredPostCode.innerHTML    = '�������룺';
    tdMobile.innerHTML    = '�ƶ��绰��';
    tdCustomerType.innerHTML    = '�ͻ����';
    tdInsuredCompany.innerHTML    = '�������˵�λ���ʣ�';
<% 
  String strInsuredFlag       = "";   //�ж���Ͷ���˻��Ǳ������� 
    if(policyDto.getPrpCinsuredDtoList()!=null){
    ArrayList prpCinsuredDtoList = policyDto.getPrpCinsuredDtoList();
    intInsuredCount = prpCinsuredDtoList.size();
    for(index=0;index<intInsuredCount;index++)
    {
      prpInsuredDto = (PrpCinsuredDto)((ArrayList)prpCinsuredDtoList).get(index);       
      strInsuredFlag = prpInsuredDto.getInsuredFlag();
      strInsuredCompany =prpInsuredDto.getBusinessSource();
      strInsuredCompanyName = uiCodeAction.translateCodeCode("BusinessDetail",strInsuredCompany,isChinese);
      if( strInsuredFlag.equals("1") ) //��������
      {
        //��ϵ������(���ͻ����)
        strCode = "";
        strName = "";
        strCode = prpInsuredDto.getInsuredType();
        strName = uiCodeAction.translateCodeCode("InsuredType",strCode,isChinese);
%>
        tdInsuredName.innerHTML        = '�������ˣ�'    + '<%=StringConvert.encode(prpInsuredDto.getInsuredName())%>';
        tdInsuredAddress.innerHTML     = '�������˵�ַ��'+ '<%=StringConvert.encode(prpInsuredDto.getInsuredAddress())%>';
        tdInsuredPostCode.innerHTML    = '�ʱࣺ'    + '<%=StringConvert.encode(prpInsuredDto.getPostCode())%>';
        tdMobile.innerHTML    = '��ϵ�绰��'    + '<%=StringConvert.encode(prpInsuredDto.getMobile())==""?prpInsuredDto.getPhoneNumber():prpInsuredDto.getMobile()%>';
        tdInsuredCompany.innerHTML = '�������˵�λ���ʣ�'+ '<%=strInsuredCompanyName%>';
<%        
        //��λ����  (���ˣ�����λ�����е�λ��������)
        strCode = "";
        strName = "";        
        if( strInsuredNature.equals("4") ) //���ˣ�����λ��
        {
          strCode = prpInsuredDto.getBusinessSort();
          strName = "&nbsp&nbsp(" + uiCodeAction.translateCodeCode("BusinessSort",strCode,isChinese) + ")";
        }
        else if( strInsuredNature.equals("3") ) //��Ȼ�ˣ������ˣ�
        {
          strName = "";
        }
%>
        
<%        
      }
    }
    }
%>  
    //--------------����������Ϣ��PrpCmain***** 
  
    //tdInsuredTerm.innerHTML   = '�����ڼ䣺'      + '<%=strInsuredTerm%>';
<%        
    // ���շ�
    strSumPremium =prpMainDto.getSumPremium();
    
    
    //��������ʽ
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpMainDto.getArgueSolution());
    if( strCode.equals("1") )   //����
    {
      strName = "����";
    } 
    else if( strCode.equals("2") )   //�ٲ�
    {
      strName = "�ٲ�";
    }    
%>    
    tdSumPremium.innerHTML='���շѣ�' + '<%=strSumPremium%>';;   
    tdArgue.innerHTML='��������ʽ��'      + '<%=strName%>';
<%        
    //ǩ����
    strCode = "";
    strCode = StringConvert.encode(prpMainDto.getOperatorCode());
    strOperatorName = uiCodeAction.translateUserCode(strCode,isChinese);
    
    //������
    strCode = "";
    //modify by dengxh begin 20040823
    //reason:����ҵ��Ա
    //strCode = StringConvert.encode(prpMainDto.getHandlerCode());
    strCode = StringConvert.encode(prpMainDto.getHandler1Code());
    //modify by dengxh end 20040823
    strHandlerName = uiCodeAction.translateUserCode(strCode,isChinese);    
    //�˱���
    strUnderwriteName = StringConvert.encode(prpMainDto.getUnderWriteName());

    //������
    strUserCode = prpLregistDto.getOperatorCode();
    strUserName = uiCodeAction.translateUserCode(strUserCode,isChinese);
    
    //��������
    strInputDate = DateTime.current().getYear() + "��"
                 + DateTime.current().getMonth() + "��"
                 + DateTime.current().getDay() + "��";
   
%>
    
    tdHandlerName.innerHTML    ='�����ˣ�'   + '<%=strHandlerName%>';
    tdUnderwriteName.innerHTML ='�˱��ˣ�'   + '<%=strUnderwriteName%>';
    tdUserName.innerHTML       ='�����ˣ�'   + '<%=strUserName%>';
    tdInputDate.innerHTML      ='�������ڣ�' + '<%=strInputDate%>';
    tdOperatorName.innerHTML   ='ǩ���ˣ�'+'<%=strOperatorName%>';    
<% 
  if(registDto.getPrpLthirdPartyDtoList() != null){ 
    intThirdPartyCount = registDto.getPrpLthirdPartyDtoList().size();
    for(index=0;index<intThirdPartyCount;index++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)registDto.getPrpLthirdPartyDtoList().get(index);
      strInsureCarFlag     = prpLthirdPartyDto.getInsureCarFlag();
      
      if( strInsureCarFlag.equals("1") ) 
      {
        strLicenseNo = StringConvert.encode(prpLthirdPartyDto.getLicenseNo());
        //VIN��/���ܺ�
        if(!"".equals(prpLthirdPartyDto.getVINNo())){
        	VINorFramNo = StringConvert.encode(prpLthirdPartyDto.getVINNo());
        }
        if("".equals(VINorFramNo)){
        	VINorFramNo = StringConvert.encode(prpLthirdPartyDto.getFrameNo());
        }else if(!"".equals(prpLthirdPartyDto.getFrameNo())){
        	VINorFramNo = VINorFramNo + "/" +StringConvert.encode(prpLthirdPartyDto.getFrameNo());
        }
%>                
        tdUseYears.innerHTML        = '��ʹ�����ޣ�'       + '<%=DataUtils.zeroToEmpty(prpLthirdPartyDto.getUseYears())%>' +'��';
<%    
        //���Ƶ�ɫ
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpLthirdPartyDto.getLicenseColorCode());
        strName = "";
        strLicenseColorCode = strCode;
        strName = uiCodeAction.translateCodeCode("LicenseColor",strCode,isChinese);
%>                                                         
        tdVINorFramNo.innerHTML      = 'VIN��/���ܺţ�' + '<%=VINorFramNo %>';
        tdBrandName.innerHTML        = '�����ͺţ�'        + '<%=StringConvert.encode(prpLthirdPartyDto.getBrandName())%>';
   <!--     tdBrandName1.innerHTML        = tdBrandName.innerHTML ; -->
        tdEngineNo.innerHTML         = '�������ţ�'        + '<%=StringConvert.encode(prpLthirdPartyDto.getEngineNo())%>';

        tdFrameNo.innerHTML          = '���ܺţ�'          + '<%=StringConvert.encode(prpLthirdPartyDto.getFrameNo())%>';

        tdVinCode.innerHTML   = 'VIN�ţ�' + '<%=StringConvert.encode(prpLthirdPartyDto.getVINNo())%>';       
<%        
        
        //��������
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpLthirdPartyDto.getCarKindCode());
        strName = uiCodeAction.translateCodeCode("CarKind",strCode,isChinese);
%>       
       tdCarType.innerHTML  = '�������ࣺ'+ '<%=strName%>';
<%            
        //�������
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpLthirdPartyDto.getClauseType());
        strName = uiCodeAction.translateCodeCode("ClauseType",strCode,isChinese);
%>        
  
        tdUseNatureCode.innerHTML = '����ʹ�����ʣ�';
        tdSeatCount.innerHTML     = '�˶��ؿ� '+ '&nbsp;&nbsp;' + ' ��' +  ' �˶������� '+ '&nbsp;&nbsp;' + ' ��';
        tdRunAreaName.innerHTML    = '������ʻ����';
        tdPurchasePrice.innerHTML  = '�³����üۣ�'+ '&nbsp;&nbsp;' + 'Ԫ';
        tdCarRegistFirst.innerHTML = '�������εǼ����ڣ�'
<%  
      }
    } 
  }
%>
<%
    
    //------------�������ձ����Ϣ��PrpCitemCar*****
  if(policyDto.getPrpCitemCarDtoList()!=null){
    intItemCarCount = policyDto.getPrpCitemCarDtoList().size();
    for(index=0;index<intItemCarCount;index++)
    {
      PrpCitemCarDto = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
      strLicenseNo2 = StringConvert.encode(PrpCitemCarDto.getLicenseNo()); 
      //modify by kangzhen
      strColorCode = PrpCitemCarDto.getLicenseColorCode();

      outColorCode=uiCodeAction.translateCodeCode("LicenseColor",strColorCode,isChinese);
      strCarClause=PrpCitemCarDto.getClauseType();
      strCarClauseName=uiCodeAction.translateCodeCode("ClauseType",strCarClause,isChinese);
                                        
      if( strLicenseNo2.equals(strLicenseNo) )
      {              
        //ʹ������
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(PrpCitemCarDto.getUseNatureCode());
        strName = uiCodeAction.translateCodeCode("UseNature",strCode,isChinese);
        if(!"".equals(PrpCitemCarDto.getVINNo())){
            VINorFramNo = StringConvert.encode(PrpCitemCarDto.getVINNo());
        }
        if("".equals(VINorFramNo)){
            VINorFramNo = StringConvert.encode(PrpCitemCarDto.getFrameNo());
        }else if(!"".equals(PrpCitemCarDto.getFrameNo())){
            VINorFramNo = VINorFramNo + "/" +StringConvert.encode(PrpCitemCarDto.getFrameNo());
        }
%>        
        tdColorCode.innerHTML     ='������ɫ��'         + '<%=outColorCode%>';
        tdLicenseNo.innerHTML       = '���ƺ��룺'         + '<%=strLicenseNo%>';
        tdUseNatureCode.innerHTML = '����ʹ�����ʣ�'      + '<%=strName%>';
        tdSeatCount.innerHTML     = '�˶��ؿ� '           + '<%=PrpCitemCarDto.getSeatCount()%>' + ' ��' + ' �˶������� '      + '<%=DataUtils.zeroToEmpty(PrpCitemCarDto.getTonCount())%>' + ' ��';
        tdVINorFramNo.innerHTML      = 'VIN��/���ܺţ�' + '<%=VINorFramNo %>';
        tdBrandName.innerHTML        = '�����ͺţ�'        + '<%=StringConvert.encode(PrpCitemCarDto.getBrandName())%>';   
        tdEngineNo.innerHTML         = '�������ţ�'        + '<%=StringConvert.encode(PrpCitemCarDto.getEngineNo())%>';  
<%          
        //���εǼ�����
        strEnrollDate = PrpCitemCarDto.getEnrollDate().toString();
        if ( (strEnrollDate == null) || (strEnrollDate.equals("")) ) 
        {
          strEnrollDate = ""; 
        }
%>      
       tdCarRegistFirst.innerHTML = '�������εǼ����ڣ�'      + '<%=strEnrollDate%>';  
       tdUseYears.innerHTML        = '��ʹ�����ޣ�'       + '<%=DataUtils.zeroToEmpty(PrpCitemCarDto.getUseYears())%>' +'��';
<%            
        //��ʻ����
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(PrpCitemCarDto.getRunAreaName());
        if( !strCode.equals("") )
        {
          strName = strCode;
        }
        else
        {
          strName = "�л����񹲺͹�����(�����۰�̨)";
        }
%>        
        tdRunAreaName.innerHTML    = '������ʻ����'    + '<%=strName%>';
        tdPurchasePrice.innerHTML  = '�³����üۣ�'      + '<%=new DecimalFormat("#,##0.00").format(PrpCitemCarDto.getPurchasePrice())%>' + 'Ԫ';
<%
      }
    }
  }
%>
    //���ռ�ʻԱ��Ϣ��PrpLdriver*****
    tdDriverName.innerHTML         = '��ʻԱ������';
    tdDrivingCarType.innerHTML     = '׼�ݳ��ͣ�';
    
    tdDrivingLicenseNo.innerHTML   = '��ʻ֤���룺';
    tdDriverFirstTime.innerHTML = '��ʻ֤������֤���ڣ�';
<%  
  if(registDto.getPrpLdriverDtoList()!=null){
    intDriverCount = registDto.getPrpLdriverDtoList().size();
    for(index=0;index<intDriverCount;index++)
    {
      prpLdriverDto     = (PrpLdriverDto)registDto.getPrpLdriverDtoList().get(index) ;
      strLicenseNo1        = prpLdriverDto.getLicenseNo();
      strLicenseColorCode1 = prpLdriverDto.getLicenseColorCode();
     		
      strDirverFirstTime =prpLdriverDto.getReceiveLicenseDate().toString();
      if ( (strDirverFirstTime == null) || (strDirverFirstTime.equals("")) ) 
        {
          strDirverFirstTime = ""; 
        }
%>
      tdDriverName.innerHTML         = '��ʻԱ��'       + '<%=StringConvert.encode(prpLdriverDto.getDriverName())%>';
      tdDrivingLicenseNo.innerHTML   = '��ʻ֤���룺'         + '<%=StringConvert.encode(prpLdriverDto.getDrivingLicenseNo())%>';
<%      
      if( strLicenseNo1.equals(strLicenseNo) && strLicenseColorCode1.equals(strLicenseColorCode) ) 
      {
%>        
        tdDriverName.innerHTML         = '��ʻԱ��'       + '<%=StringConvert.encode(prpLdriverDto.getDriverName())%>';
        tdDrivingCarType.innerHTML     = '׼�ݳ��ͣ�'           + '<%=StringConvert.encode(prpLdriverDto.getDrivingCarType())%>';
        
        tdDrivingLicenseNo.innerHTML   = '��ʻ֤���룺'         + '<%=StringConvert.encode(prpLdriverDto.getDrivingLicenseNo())%>';
        tdDriverFirstTime.innerHTML = '��ʻ֤������֤���ڣ�'+'<%=strDirverFirstTime%>';
<%  
      }
    } 
  }
%>  

<%
  if(policyDto.getPrpCcarDriverDtoList()!=null){
    intCarDriverCount = policyDto.getPrpCcarDriverDtoList().size();
    for(index=0;index<intCarDriverCount;index++)
    {
      prpcarDriverDto = (PrpCcarDriverDto)policyDto.getPrpCcarDriverDtoList().get(index);      
      strChangeLessFlag = prpcarDriverDto.getChangelessFlag();
                           
      if( strChangeLessFlag.equals("1") )  //����ʻ
      {
      strArgumentName=prpcarDriverDto.getDriverName();
      strArgumentNumber=prpcarDriverDto.getDrivingLicenseNo();
      strArgumentFirst=prpcarDriverDto.getAcceptLicenseDate().toString();      
%>    
    tdArgumentName1.innerHTML = '<%=strArgumentName%>';
    tdArgumentNumber1.innerHTML = '<%=strArgumentNumber%>';
    tdArgumentFirst1.innerHTML = '<%=strArgumentFirst%>'; 
    tdArgumentSex1.innerHTML = '<%=StringConvert.encode(prpcarDriverDto.getSex())%>';
    tdDrivingCarType1.innerHTML = '<%=StringConvert.encode(prpcarDriverDto.getDrivingCarType())%>';
    //tdDrivingLicenseNo1.innerHTML = '<%=StringConvert.encode(prpcarDriverDto.getDrivingLicenseNo())%>';
<%
      }
      else if( strChangeLessFlag.equals("0") )  //�Ӽ�ʻԱ
      { 
%>               
    tdArgumentName2.innerHTML = '<%=prpcarDriverDto.getDriverName()%>';
    tdArgumentNumber2.innerHTML = '<%=prpcarDriverDto.getDrivingLicenseNo()%>';
    tdArgumentFirst2.innerHTML = '<%=prpcarDriverDto.getAcceptLicenseDate().toString()%>'; 
    tdArgumentSex2.innerHTML = '<%=StringConvert.encode(prpcarDriverDto.getSex())%>';
    tdDrivingCarType2.innerHTML = '<%=StringConvert.encode(prpcarDriverDto.getDrivingCarType())%>';
       
<%
      }
    }
  }

%>

 
    //�ر�Լ����PrpCengage*****
<% 
    strClauses = ""; 
    for(index=0;index<intEngageCount;index++) 
    {
      prpEngageDto = (PrpCengageDto)policyDto.getPrpCengageDtoList().get(index);
      strClauseCode = prpEngageDto.getClauseCode(); 
      String strTitleFlag =  prpEngageDto.getTitleFlag();
      strClauses += StringConvert.encode(prpEngageDto.getClauses());
    }
    
    //����ر�Լ��������Ǽ���
    intEngageCountTmp = 0;    //textarea������
    
    for(index=0;index<strClauses.length();index++)
    {
      if(strClauses.substring(index,index+1).equals("\\"))
      {
        if(!(strClauses.substring(index).length()<4))
        {
          if(strClauses.substring(index,index+4).equals("\\r\\n"))
          {
             intEngageCountTmp += 1;    //ֻҪ�лس����У�intEngageCountTmp+1
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
         intEngageCountTmp += 1;   
      }
    }
    else    //���strClauses����1�У�intEngageCountTmp = 1; 
      intEngageCountTmp = 1; 
    
    if(intEngageCountTmp>9)
    {
%>  
      tdEngage.innerHTML = ' �ر�Լ�������ݽ϶࣬������ر�Լ���嵥';
<%
    }
    else
    {
%>
      tdEngage.innerHTML = '<%=strClauses%>';
<%
    } 
%>
//�����������ر�Լ��
<%
	String policyNoMainSub = "";
    strClauses = "";
	if ("0507".equals(prpLregistDto.getRiskCode())
			||"0577".equals(prpLregistDto.getRiskCode())
			||"0587".equals(prpLregistDto.getRiskCode())) {
		policyNoMainSub = policyNo;
	}else{
		policyNoMainSub = DAZpolicyNo;
	}
    BLPrpCengageFacade blPrpCengageFacade = new BLPrpCengageFacade();
    String CengageConditions = "PolicyNo= '" + policyNoMainSub +"'";
    ArrayList PrpCengageDtoList = (ArrayList)blPrpCengageFacade.findByConditions(CengageConditions);
	for(int Engageindex= 0;Engageindex<PrpCengageDtoList.size();Engageindex++){
		prpEngageDtoMainSub = (com.sinosoft.prpall.dto.domain.PrpCengageDto)PrpCengageDtoList.get(Engageindex);
	      strClauseCode = prpEngageDtoMainSub.getClauseCode(); 
	      String strTitleFlag =  prpEngageDtoMainSub.getTitleFlag();
	      strClauses += StringConvert.encode(prpEngageDtoMainSub.getClauses());
	}
intEngageCountTmp = 0;    //textarea������
    
    for(index=0;index<strClauses.length();index++)
    {
      if(strClauses.substring(index,index+1).equals("\\"))
      {
        if(!(strClauses.substring(index).length()<4))
        {
          if(strClauses.substring(index,index+4).equals("\\r\\n"))
          {
             intEngageCountTmp += 1;    //ֻҪ�лس����У�intEngageCountTmp+1
          }
        }
      }
    }
    
    x = 0;
    y = 0;
    if(!(strClauses.length()<4))    //���strClauses.length()>=4���ж�strClauses��β�����֣����ǻس�����
    {
      x = strClauses.length()-4;
      y = strClauses.length();
      if(!strClauses.substring(x,y).equals("\\r\\n"))
      {
         intEngageCountTmp += 1;   
      }
    }
    else    //���strClauses����1�У�intEngageCountTmp = 1; 
      intEngageCountTmp = 1; 
    
    if(intEngageCountTmp>9)
    {
%>
     tdEngageMainSub.innerHTML = ' �ر�Լ�������ݽ϶࣬������ر�Լ���嵥';
<%
    }
    else
    {
%>
      tdEngageMainSub.innerHTML = '<%=strClauses%>';
<%
    } 
%>


<%
    //������Ϣ��PrpPhead*****
    strPheadText = "";
    int intPheadCount1 = 0;
    String strEndorLastLine = "none";   //������Ϣ���һ��  
    String strEndorInfoLine6 = "";             //������Ϣ������  
     //liubvo
    if( intPheadCount>5 )
    {
      intPheadCountTmp = 5;
      strEndorLastLine = "";
      strEndorInfoLine6 = "none";
%>
    tdEndorseNo5.style.colspan="7";
    tdEndorseNo5.innerHTML = '&nbsp;�������ݹ��࣬��鿴����������Ϣ����';
    tdEndorDate5.style.display = 'none';
    tdEndorType5.style.display = 'none';
    tdChgPremium5.style.display = 'none';
<%
    }
    else
    {
      intPheadCountTmp = intPheadCount;
    }
    //intPheadCount = endorseDto.getPrpPHeadDtoList().size();
    for(index=0;index<intPheadCountTmp;index++)
    { 
      String EndorDate = "";  //��������
      String EndorTypeName = ""; //������������
      String ChgPremium = "0.0";       //���ѱ仯��
      prpPheadDto = (PrpPheadDto)endroseDtoList.get(index); 
      strEndorseNo   = prpPheadDto.getEndorseNo();      
      if(!("56").equals(prpPheadDto.getEndorType())){
    	  EndorDate =  prpPheadDto.getEndorDate().getYear()
                      + "-" + prpPheadDto.getEndorDate().getMonth()
                      + "-" + prpPheadDto.getEndorDate().getDate();
    	  String[] endorseTypeTemp = prpPheadDto.getEndorType().split(",");
    	  for(int i = 0;i < endorseTypeTemp.length;i++){
    		    if(i == 0 ){
    		        EndorTypeName =  new UICodeAction().translateCodeCode("EndorType",endorseTypeTemp[i],true) ;
    		    }else{
    		    	EndorTypeName += "��" + new UICodeAction().translateCodeCode("EndorType",endorseTypeTemp[i],true) ;    		  
    		    }
    	  }
      
    	  //�õ�blPrpPmain����
          UIEndorseAction uiEndorseAction = new UIEndorseAction();   
          EndorseDto endorseDtoTemp = uiEndorseAction.findByPrimaryKey(strEndorseNo);
          PrpPmainDto PrpPmainDto = endorseDtoTemp.getPrpPmainDto();
      
          //�õ�����仯���ͱ��ѱ仯��
          if (PrpPmainDto!=null) 
          {
        	  ChgPremium  = "" + new DecimalFormat("0.00").format(PrpPmainDto.getChgPremium());
          }        
      }else{
    	  intPheadCount1++;
    	  break;
      }
%>
    tdEndorseNo<%=index%>.innerHTML = '<%=strEndorseNo%>';
    tdEndorDate<%=index%>.innerHTML = '<%=EndorDate%>';
    tdEndorType<%=index%>.innerHTML = '<%=EndorTypeName%>';
    tdChgPremium<%=index%>.innerHTML = '<%=ChgPremium %>';
<%
    }       
%>  
   // trEndorInfoLine5.style.display = '<%=strEndorInfoLine6 %>'; 
  //  trEndorLast.style.display = '<%=strEndorLastLine %>'; 
/**
 *���γ�����Ϣ
 */
<%
    double SumPaid = 0;     //����ܼ�
    int PayCount = 0;       //������
    String strDamageLastLine = "none";
    String strDamageLine6 = "";    
    String[] damageInfoRegistno       = new String[]{"","","","","","","",}; //������
    String[] damageInfoReportDate     = new String[]{"","","","","","","",};//����ʱ��
    String[] damageInfoStartDate      = new String[]{"","","","","","","",};//����ʱ��
    String[] damageInfoSumPay         = new String[]{"","","","","","","",};//�⸶���
    String[] damageInfoIsPersonInjure = new String[]{"","","","","","","",};//�Ƿ��漰����
    String[] damageInfoCaseTypeName   = new String[]{"","","","","","","",};//����״̬
    String[] damageInfoFlag           = new String[]{"","","","","","","",};//��ʶ����ҵ�ջ�ǿ��
    
    prpLregistDtoList = (ArrayList)uiRegistAction.findSamePolicyRegist(strPolicyNo);
    Iterator registIterator = prpLregistDtoList.iterator();
    String riskCode = "";
    int count = 0;         //������
    for(int k = 0;k < prpLregistDtoList.size();k++){
    	
    	prpLregistDto1 = (PrpLregistDto)registIterator.next();  
    	damageInfoIsPersonInjure[count] = "��";
    	if(  prpLregistDto1.getPersonInjureB() > 0 
    	  || prpLregistDto1.getPersonDeathB() > 0 
    	  || prpLregistDto1.getPersonInjureD1() > 0 
    	  || prpLregistDto1.getPersonDeathD1() > 0 ){
    		damageInfoIsPersonInjure[count] = "��";
    	}            
        damageInfoRegistno[count]   = prpLregistDto1.getRegistNo();
        damageInfoReportDate[count] = prpLregistDto1.getReportDate().toString();
        damageInfoStartDate[count]  = prpLregistDto1.getDamageStartDate().toString();
        riskCode = prpLregistDto1.getRiskCode();
        if("0507".equals(riskCode)||"0577".equals(riskCode)||"0587".equals(riskCode))
        {
        	damageInfoFlag[count] = "��ǿ��";
        }else 
        {
        	damageInfoFlag[count] = "��ҵ��";
        }
        if(!prpLregistDto1.getCancelDate().isEmpty() || prpLregistDto1.getCancelDate().toString().length() > 1){
        	damageInfoCaseTypeName[count]  = "��ע��";
        	damageInfoSumPay[count]        = "��������";        	
        }else {
        	String condition = "registno='" + prpLregistDto1.getRegistNo() + "' ";//and policyno='" + prpLregistDto1.getPolicyNo() + "' ";
        	
        	Collection claimList = new BLPrpLclaimFacade().findByConditions(condition);        	
        	if(claimList.size() < 1){
        		damageInfoCaseTypeName[count]  = "δ�᰸";
                damageInfoSumPay[count]        = "��������";      
        	}else{
        		Iterator claimIterator = claimList.iterator();
        		int currentIndex = count;
        		for(int j = 0;j < claimList.size();j++){
        			damageInfoRegistno[currentIndex + j]         = damageInfoRegistno[count];
        			damageInfoReportDate[currentIndex + j]       = damageInfoReportDate[count];
        			damageInfoStartDate[currentIndex + j]        = damageInfoStartDate[count];
        			damageInfoIsPersonInjure[currentIndex + j]   = damageInfoIsPersonInjure[count];
        			PrpLclaimDto prpLclaimDto1                   = (PrpLclaimDto)claimIterator.next();
        			riskCode  = prpLclaimDto1.getRiskCode();
        	        if("0507".equals(riskCode)||"0577".equals(riskCode)||"0587".equals(riskCode))
        	        {
        	        	damageInfoFlag[currentIndex + j] = "��ǿ��";
        	        }else 
        	        {
        	        	damageInfoFlag[currentIndex + j] = "��ҵ��";
        	        }
                    if(prpLclaimDto1 == null){
                    	damageInfoCaseTypeName[currentIndex + j]  = "δ�᰸";
                        damageInfoSumPay[currentIndex + j]        = "��������"; 
                    }else{
                        if("0".equals(prpLclaimDto1.getCaseType())){
                        	damageInfoCaseTypeName[currentIndex + j] = "��ע��";
                        	damageInfoSumPay[currentIndex + j] = "��������";
                        }else if("1".equals(prpLclaimDto1.getCaseType())){
                        	damageInfoCaseTypeName[currentIndex + j] = "�Ѿ���";
                        	damageInfoSumPay[currentIndex + j] = "��������";
                        }else if("2".equals(prpLclaimDto1.getCaseType())){
                        	damageInfoCaseTypeName[currentIndex + j] = "�ѽ᰸";
                        	damageInfoSumPay[currentIndex + j] = "" + prpLclaimDto1.getSumPaid();
                        	SumPaid += prpLclaimDto1.getSumPaid();
                        	PayCount += 1;
                        }else if(prpLclaimDto1.getCaseType() == null || "".equals(prpLclaimDto1.getCaseType())){
                        	damageInfoCaseTypeName[currentIndex + j]  = "δ�᰸";
                            damageInfoSumPay[currentIndex + j]        = "��������"; 
                        }
                    }
                   count = currentIndex + j;
        		}            		
        	}
        }
        
        if(count > 4){
            strDamageLastLine = "";
            strDamageLine6 = "none";  
            count = 5;
        }else{
        	count++;
        }        
    }
%>  
<%
    if("none".equals(strDamageLine6)){
%>
    tdDamageInfoLine61.colspan="7";
    tdDamageInfoLine61.innerHTML = '&nbsp;�������ݹ��࣬��鿴���γ�����Ϣ����';
    tdDamageInfoLine62.colspan="0";
    tdDamageInfoLine63.colspan="0";
    tdDamageInfoLine64.colspan="0";
    tdDamageInfoLine65.colspan="0";
    tdDamageInfoLine66.colspan="0";
    tdDamageInfoLine67.colspan="0";
    
    tdDamageInfoLine62.style.display = 'none';
    tdDamageInfoLine63.style.display = 'none';
    tdDamageInfoLine64.style.display = 'none';
    tdDamageInfoLine65.style.display = 'none';
    tdDamageInfoLine66.style.display = 'none';
    tdDamageInfoLine67.style.display = 'none';
    
    
    //trDamageInfoLine6.style.display = '<%=strDamageLine6 %>';
    //trDamageLast.style.display = '<%=strDamageLastLine %>';
<% }%>
/*
 *�漰��ʧ�ձ�
 */
<%
    String strRefKind = "";     //�漰��ʧ�ձ�
    Set kindSet = new HashSet();    //����漰���ձ����
    UICodeAction uicodeAction = new UICodeAction();
    Collection claimList = new BLPrpLclaimFacade().findByConditions("registno='" + prpLregistDto.getRegistNo() + "'");  
    Iterator claimIterator = claimList.iterator();
    for(int k = 0;k < claimList.size();k++){
    	PrpLclaimDto prpLclaimDto1  = (PrpLclaimDto)claimIterator.next();
    	Collection prpLcompensateDtoList = new BLCompensateFacade().findByConditions("claimno='" + prpLclaimDto1.getClaimNo() + "'");
        Iterator compensateIterator = prpLcompensateDtoList.iterator();
        BLCompensateFacade blCompensateFacade = new BLCompensateFacade();
        for(int m = 0;m < prpLcompensateDtoList.size();m++){
            PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)compensateIterator.next();
            CompensateDto compensateDto = blCompensateFacade.findByPrimaryKey(prpLcompensateDto.getCompensateNo());
            if(compensateDto != null){
                //ȡ�漰������⸶���ձ�
                for(int j = 0;j < compensateDto.getPrpLlossDtoList().size();j++){
                    PrpLlossDto prpLlossDto = (PrpLlossDto)compensateDto.getPrpLlossDtoList().get(j);
                    kindSet.add(uicodeAction.translateKindCode(prpLlossDto.getRiskCode(),prpLlossDto.getKindCode(),true));
                }
                //ȡ�漰�������⸶���ձ�
                for(int j = 0;j < compensateDto.getPrpLpersonLossDtoList().size();j++){
                    PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto)compensateDto.getPrpLpersonLossDtoList().get(j);
                    kindSet.add(uicodeAction.translateKindCode(prpLpersonLossDto.getRiskCode(),prpLpersonLossDto.getKindCode(),true));
                }
            }
        }
    }
    
    claimIterator = kindSet.iterator();
    
    for(int k = 0;k < kindSet.size();k++){
    	strRefKind += "��" + claimIterator.next();
    }
    if(strRefKind.length() > 2){
        strRefKind = strRefKind.substring(1) + "��";	
    }
%>
    tdRefKind.innerHTML = '<%=strRefKind%>';
<%    
    strClaimText = "";

        strClaimText += " �������ڣ�" + prpLregistDto.getDamageStartDate().getYear()
                        + "��" + prpLregistDto.getDamageStartDate().getMonth()
                        + "��" + prpLregistDto.getDamageStartDate().getDate()
                        + "��"+"<br>";
       
        strClaimText += " ����ԭ��" + StringConvert.encode(prpLregistDto.getDamageName());
        strClaimText += "\\r\\n";
          //modify by lirj update begin 040211
        //reason:���ճ���������Ϣ������ʾ��������ժҪ��Ϣ��Ŀǰֻ��ʾ�������վ���
        if(registDto.getPrpLregistTextDtoList()!=null){
         int intSizeTemp = registDto.getPrpLregistTextDtoList().size();
         if (intSizeTemp>0)
         {  
           for(int i=0;i<intSizeTemp;i++)
           {   
                 if ( ((PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(i)).getTextType().trim().equals("1")) 
              {   
               prpLregistTextDto = (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(i);  
               if(!prpLregistTextDto.getContext().trim().equals(""))  
               {          
               strContext1 += StringConvert.encode(prpLregistTextDto.getContext())+"\\r\\n";      
               }   
              }
              //add by wuxiaodong 050914 begain reasion �鿱�ظ���Ϣȡ�鿱����
                if ( ((PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(i)).getTextType().trim().equals("3")) 
              {   
               prpLregistTextDto = (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(i);  
                if(!prpLregistTextDto.getContext().trim().equals(""))  
               {          
             checkInfo += StringConvert.encode(prpLregistTextDto.getContext())+"<br>";      
               }     
              }
              //add by wuxiaodong 050914 end
            }  
            if(!strContext1.trim().equals(""))  
            {
            strClaimText += strContext1;
            }
         }
       }  
         
        //modify by lirj update end 040211
    
    if(intCompensateCount>8)
    {
      strClaimText += "(���������Ϣ�������)";
    }    
    //��������ܼ�
    for(int m=0;m<intCompensateCount;m++)
    {
      prpLclaimDto = (PrpLclaimDto)listTemp.get(m);
      dblSumPaid = dblSumPaid + prpLclaimDto.getSumPaid();
    }
%>  
    tdPheadCount.innerHTML      = '�������Ĵ�����'  + '<%=DataUtils.zeroToEmpty(intPheadCount - intPheadCount1)%>';
    tdClaimCount.innerHTML      = '�������մ�����'  + '<%=DataUtils.zeroToEmpty(intCompensateCount)%>';
    tdCompensateCount.innerHTML = '��������'      + '<%=DataUtils.zeroToEmpty(PayCount)%>';
    tdSumPaid.innerHTML         = '����ܼƣ�'      + '<%=DataUtils.zeroToEmpty(SumPaid)%>';   
    tdContext.innerHTML         = '���վ�������ʧ�����<br>'+'<%=strClaimText%>';
<%

    if(policyDto.getPrpCitemKindDtoList()!=null){
     ArrayList rPrpCitemKindDtoList = (ArrayList)request.getAttribute("rPrpCitemKindDto");
      //�����ϵ���0501ԭ���߼�����������ʾ��ȫ������
     if( rPrpCitemKindDtoList != null ){
      policyDto.getPrpCitemKindDtoList().addAll(rPrpCitemKindDtoList);
     }
     for(index=0;index<policyDto.getPrpCitemKindDtoList().size();index++){
           prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
           strKindCode[index] = prpCitemKindDto.getKindCode();
            
           strKindName[index] = prpCitemKindDto.getKindName();
           if(prpCitemKindDto.getFlag()!=null && prpCitemKindDto.getFlag().length()>=5 && "1".equals(prpCitemKindDto.getFlag().substring(4,5)))
           {
               strItemKindFlag5[index] = "��";
           }else if(prpCitemKindDto.getFlag()!=null && prpCitemKindDto.getFlag().length()>=5 && "0".equals(prpCitemKindDto.getFlag().substring(4,5)))
           {
               strItemKindFlag5[index] = "��";
           }else{
        	   strItemKindFlag5[index] = " ";
           }
           strDangerLevel[index] = "";
           if(prpCitemKindDto.getModeCode()!=null&&!prpCitemKindDto.getModeCode().equals("")&&(prpCitemKindDto.getKindCode().equals("A")||prpCitemKindDto.getKindCode().equals("B"))){
               if(prpCitemKindDto.getModeCode().equals("1")){strDangerLevel[index] = "(����ˮƽA)";}
               if(prpCitemKindDto.getModeCode().equals("2")){strDangerLevel[index] = "(����ˮƽB)";}
               if(prpCitemKindDto.getModeCode().equals("3")){strDangerLevel[index] = "(����ˮƽC)";}
           }
             if(prpCitemKindDto.getAmount()==0){
            	 if("F".equals(strKindCode[index])){
                     douAmount[index] = prpCitemKindDto.getModeName();
                 }else{
                	 douAmount[index]   = "";
                 }
             }else{
            	 if("F".equals(strKindCode[index])){
                     douAmount[index] = prpCitemKindDto.getModeName();
                 }else{
                     douAmount[index] = String.valueOf(new DecimalFormat("#,##0.00").format(prpCitemKindDto.getAmount()));         
                 }
             }
     }
   }
%>
 <!--  tdDelinquentFee.innerHTML  = '�Ƿ����ѣ�';  -->
 <!--  tdPlanFee.innerHTML        = 'Ӧ�ձ��ѣ�' ; -->
<!--   tdPlanDate.innerHTML       = '�������ڣ�'; -->
<%
  String strPlanFee = "";
  if(policyDto.getPrpCplanDtoList()!=null){
    intPlanCount = policyDto.getPrpCplanDtoList().size();
    for(index=0;index<intPlanCount;index++){
      prpCplanDto = (PrpCplanDto)policyDto.getPrpCplanDtoList().get(index);    
      douDelinquentFee = prpCplanDto.getDelinquentFee();
      if(douDelinquentFee==0){
        strDelinquentFee = "��";
        strPlanFee = "������";
      }else{
        strDelinquentFee = "��";
        strPlanFee = "��Ƿ���ѣ�"+douDelinquentFee;
      }
%>
 <!--  tdDelinquentFee.innerHTML  = '�Ƿ����ѣ�'+'<%=strDelinquentFee%>';  -->
  <!-- tdPlanFee.innerHTML        = 'Ӧ�ձ��ѣ�' +'<%=strPlanFee%>'; -->
  <!-- tdPlanDate.innerHTML       = '�������ڣ�'+'<%=prpCplanDto.getPlanDate()%>'; -->
<%
    }
  }
%>
<%
   prpLextDto = registDto.getPrpLextDto();
   if(prpLextDto != null){
     long personInjureB  = prpLextDto.getPersonInjureB();
     long personDeathB   = prpLextDto.getPersonDeathB();
     long personInjureD1 = prpLextDto.getPersonInjureD1();
     long personDeathD1  = prpLextDto.getPersonDeathD1();
     String personInjure1 = "";
     String personInjure2 = "";
     String personInjure = "�����ߣ��� "+personInjureB+" �ˣ��� "+personDeathB+" �ˣ���������Ա���� "
                            +personInjureD1+" �ˣ� �� "+personDeathD1+" �ˣ�";
     
     if(personInjureB==0){
       if(personDeathB==0){
         personInjure1 = "";
       }else{
         personInjure1 = "�����ߣ��� "+personDeathB+" �ˣ���";
       }  
     }else{
       if(personDeathB==0){
         personInjure1 = "�����ߣ��� "+personInjureB+" �ˣ���";
       }else{
         personInjure1 = "�����ߣ��� "+personInjureB+" �ˣ��� "+personDeathB+" �ˣ���";
       }
     }
     if(personInjureD1==0){
       if(personDeathD1==0){
         personInjure2 = "";
       }else{
         personInjure2 = "������Ա���� "+personDeathD1+" �ˣ�";
       }  
     }else{
       if(personDeathD1==0){
         personInjure2 = "������Ա���� "+personInjureD1+" �ˣ�";
       }else{
         personInjure2 = "������Ա���� "+personInjureD1+" �ˣ� �� "+personDeathD1+" �ˣ�";
       }
     }
     personInjure = personInjure1 + personInjure2; 
     if((prpLextDto.getPersonInjureB()==0)&&(prpLextDto.getPersonDeathB()==0)&&(prpLextDto.getPersonInjureD1()==0)&&(prpLextDto.getPersonDeathD1()==0)){
       personInjure = "����Ա����";
     }                          
%>
<!--   tdPersonInjure.innerHTML = '��Ա���������'+'<%=personInjure%>'; -->
<%
  }
%>
  }
</script>
 