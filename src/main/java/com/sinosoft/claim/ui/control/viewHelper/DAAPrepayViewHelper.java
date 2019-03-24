package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimFeeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLdocDto;
import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.claim.dto.domain.PrpLpreChargeDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLptextDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UIClaimStatusAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * <p>Title: PrepayViewHelper</p>
 * <p>Description:Ԥ��ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */

 public class DAAPrepayViewHelper extends PrepayViewHelper
 {
	 private static Log logger = LogFactory.getLog(DAAPrepayViewHelper.class);
   /**
    * Ĭ�Ϲ��췽��
    */
    public DAAPrepayViewHelper()
    {
    }

    /**
     * ��дԤ��ҳ�漰��ѯ����request������.
     * ��дԤ��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
     * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
     * @param httpServletRequest ���ظ�ҳ���request
     * @param proposalIniDto ȡ���ĳ�ʼ����ϢDto
     * @throws Exception
     */
    public void  prepayDtoToView(HttpServletRequest httpServletRequest,
                                          String claimNo) throws Exception
    {
      //��ѯ��Ϣ
      UIPrepayAction uiPrepayAction = new UIPrepayAction();
      PrepayDto prepayDto = uiPrepayAction.findByPrimaryKey(claimNo);

      UIClaimAction uiClaimAction = new UIClaimAction();
      PrpLclaimLossDto prpLclaimLossDto = uiClaimAction.getClaimLoss(prepayDto.getPrpLprepayDto().getClaimNo());
//System.out.println("---------������--------" +prpLclaimLossDto.getSumClaim());
      httpServletRequest.setAttribute("sumClaim",String.valueOf(prpLclaimLossDto.getSumClaim()));
      //Ԥ������Ϣ
      PrpLprepayDto prpLprepayDto = new PrpLprepayDto();
      prpLprepayDto = prepayDto.getPrpLprepayDto();
      //Ԥ��ǼǺ�PreCompensateNo
      prpLprepayDto.setPreCompensateNo(prepayDto.getPrpLprepayDto().getPreCompensateNo());
      //�ⰸ����
      prpLprepayDto.setClaimNo(prepayDto.getPrpLprepayDto().getClaimNo());
      //����
      prpLprepayDto.setRiskCode(prepayDto.getPrpLprepayDto().getRiskCode());
      //����
      prpLprepayDto.setClassCode(prepayDto.getPrpLprepayDto().getClassCode());
      //��������
      prpLprepayDto.setPolicyNo(prepayDto.getPrpLprepayDto().getPolicyNo());
      //�ұ����
      prpLprepayDto.setCurrency(prepayDto.getPrpLprepayDto().getCurrency());
      /*
      //����Ƿ������arrearageTimes
      //����Ƿ����sumArrearage
      //��Ԥ���棩�����sumBeforePrePaid
      //���ε渶����Ƿ������blockUpTimes
      //Ԥ����sumPrePaid(�༭��Ŀ)
      //��Ԥ���棩�����sumTotalPrepaid
      //����Ա����approverCode
      //���պ����˴���underWriteCode
      //���պ���������underWriteName
      //�����������underWriteEndDate
      //�����־underWriteFlag
      */
      prpLprepayDto.setUnderWriteFlag(prepayDto.getPrpLprepayDto().getUnderWriteFlag());
      prpLprepayDto.setStartDate(prepayDto.getPrpLprepayDto().getStartDate());
      prpLprepayDto.setEndDate(prepayDto.getPrpLprepayDto().getEndDate());
      prpLprepayDto.setSumPrePaid(prepayDto.getPrpLprepayDto().getSumPrePaid());
      //��������
      prpLprepayDto.setMakeCom(prepayDto.getPrpLprepayDto().getMakeCom());
      //ҵ�������������
      prpLprepayDto.setComCode(prepayDto.getPrpLprepayDto().getComCode());
      //�����˴���
      prpLprepayDto.setHandlerCode(prepayDto.getPrpLprepayDto().getHandlerCode());
      //����ҵ��Ա����
      prpLprepayDto.setHandler1Code(prepayDto.getPrpLprepayDto().getHandler1Code());
      //ͳ������
      prpLprepayDto.setStatisticsYM(prepayDto.getPrpLprepayDto().getStatisticsYM());
      //����Ա����
      prpLprepayDto.setOperatorCode(prepayDto.getPrpLprepayDto().getOperatorCode());
      //�������������
      prpLprepayDto.setInputDate(prepayDto.getPrpLprepayDto().getInputDate());
      //��־�ֶ�flag
      prpLprepayDto.setFlag(prepayDto.getPrpLprepayDto().getFlag());
      prpLprepayDto.setStartDate(prepayDto.getPrpLprepayDto().getStartDate());
      prpLprepayDto.setEndDate(prepayDto.getPrpLprepayDto().getEndDate());
      prpLprepayDto.setSumAmount(prepayDto.getPrpLprepayDto().getSumAmount());
      prpLprepayDto.setSumPremium(prepayDto.getPrpLprepayDto().getSumPremium());

      ClaimDto claimDtoTemp = uiClaimAction.findByPrimaryKey(prepayDto.getPrpLprepayDto().getClaimNo());

      prpLprepayDto.setDamageStartDate(prepayDto.getPrpLprepayDto().getDamageStartDate());
      //prpLprepayDto.setDamageStartHour(prepayDto.getPrpLprepayDto().getDamageStartHour());
      String timeTemp = StringConvert.toStandardTime(claimDtoTemp.getPrpLclaimDto().getDamageStartHour());
      prpLprepayDto.setDamageStartHour(timeTemp.substring(0,2));
      prpLprepayDto.setDamageStartMinute(timeTemp.substring(3,5));

      prpLprepayDto.setDamageAddressType(prepayDto.getPrpLprepayDto().getDamageAddressType());
      prpLprepayDto.setDamageAddress(prepayDto.getPrpLprepayDto().getDamageAddress());
      prpLprepayDto.setSumClaim(prepayDto.getPrpLprepayDto().getSumClaim());
      //��������ĸ���
      prpLprepayDto.setClassCode(claimDtoTemp.getPrpLclaimDto() .getClassCode() ) ;


      //����Ԥ�������״̬Ϊ �����޸� (����������)
       if (prepayDto.getPrpLclaimStatusDto()==null )
       {
         prpLprepayDto.setStatus("4");
       }
       else
       {
       	if (prepayDto.getPrpLclaimStatusDto().getStatus().equals("7")) prepayDto.getPrpLclaimStatusDto().setStatus("3");
         prpLprepayDto.setStatus(prepayDto.getPrpLclaimStatusDto().getStatus()  );
       }

        String  status= httpServletRequest.getParameter("status");//�ӹ�������ȥ״̬.�Թ������ϵ�Ϊ׼ȷ
       if (status!=null&&!status.equals("") ) prpLprepayDto.setStatus(status);

       if (!prepayDto.getPrpLprepayDto().getPolicyNo().equals(""))
       {
         //��ѯ������Ϣ
         EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
    	 PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prepayDto.getPrpLprepayDto().getPolicyNo()
    	 		,claimDtoTemp.getPrpLclaimDto().getDamageStartDate().toString()
				,claimDtoTemp.getPrpLclaimDto().getDamageStartHour()); 

         PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
         if(policyDto.getPrpCitemCarDtoList().size()>0)
         {
            //�Գ��͵���Ϣ��֧��
            PrpCitemCarDto= (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(0);
            prpLprepayDto.setClauseType(PrpCitemCarDto.getClauseType());
            prpLprepayDto.setLicenseNo(PrpCitemCarDto.getLicenseNo());
            prpLprepayDto.setLicenseColorCode(PrpCitemCarDto.getLicenseColorCode());
            prpLprepayDto.setLicenseColor(PrpCitemCarDto.getLicenseColorCode());
            prpLprepayDto.setBrandName(PrpCitemCarDto.getBrandName() );
            prpLprepayDto.setCarKindCode(PrpCitemCarDto.getCarKindCode());
            prpLprepayDto.setEngineNo(PrpCitemCarDto.getEngineNo());
            prpLprepayDto.setFrameNo(PrpCitemCarDto.getFrameNo());
         }
       }
       //add by liubvo 20040601
       if (!prepayDto.getPrpLprepayDto().getClaimNo().equals(""))
       {
         //��ѯ������Ϣ
          ClaimDto claimDto = uiClaimAction.findByPrimaryKey(prepayDto.getPrpLprepayDto().getClaimNo());
          PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
          prpLclaimDto = claimDto.getPrpLclaimDto();
          prpLprepayDto.setDamageStartDate(prpLclaimDto.getDamageStartDate());
          String timeTemp1 = StringConvert.toStandardTime(claimDto.getPrpLclaimDto().getDamageStartHour());
          prpLprepayDto.setDamageStartHour(timeTemp1.substring(0,2));
          prpLprepayDto.setDamageStartMinute(timeTemp1.substring(3,5));
          //��������ĸ���
          prpLprepayDto.setClassCode(prpLclaimDto.getClassCode()) ;
          //prpLprepayDto.setDamageStartHour(prpLclaimDto.getDamageStartHour());
          prpLprepayDto.setStartDate(prpLclaimDto.getStartDate());
          prpLprepayDto.setEndDate(prpLclaimDto.getEndDate());
          prpLprepayDto.setDamageAddress(prpLclaimDto.getDamageAddress());
          prpLprepayDto.setSumClaim(prpLclaimDto.getSumClaim());
          prpLprepayDto.setSumAmount(prpLclaimDto.getSumAmount());
       }
      //��Ԥ���ļ������б�׼������
      PrpLptextDto prpLptextDto = new PrpLptextDto();
      String tempContext = "";
      if(prepayDto.getPrpLptextDtoList() != null){
        Iterator iterator = prepayDto.getPrpLptextDtoList().iterator();
        while(iterator.hasNext()){
          PrpLptextDto prpLptextDtoTemp = (PrpLptextDto)iterator.next();
          tempContext = tempContext + prpLptextDtoTemp.getContext();
        }
      }
      prpLptextDto.setContext(tempContext);
      httpServletRequest.setAttribute("prpLptextDto", prpLptextDto);

      UICodeAction uiCodeAction = new UICodeAction();
      PrpLpreChargeDto prpLpreChargeDto = new PrpLpreChargeDto();
      ArrayList prpLpreChargeDtoList = new ArrayList();
      if(prepayDto.getPrpLpreChargeDtoList() != null){
	      for(int i = 0; i < prepayDto.getPrpLpreChargeDtoList().size();i++){
	    	  PrpLpreChargeDto prpLpreChargeDto1 = (PrpLpreChargeDto)prepayDto.getPrpLpreChargeDtoList().get(i);
	    	  prpLpreChargeDto1.setKindName(uiCodeAction.translateKindCode(prpLpreChargeDto1.getRiskCode(),
	    			  prpLpreChargeDto1.getKindCode(), true));
	    	  prpLpreChargeDtoList.add(prpLpreChargeDto1);
	      }
      }
      prpLpreChargeDto.setPrpLpreChargeList(prpLpreChargeDtoList);
      httpServletRequest.setAttribute("prpLpreChargeDto", prpLpreChargeDto);
       //������ش��������ת��
       changeCodeToName(httpServletRequest,prpLprepayDto);
       //���ô�����и�����ѡ�����б���Ϣ������
       setSelectionList(httpServletRequest,prpLprepayDto);
       //��ѯ��ͬ�����ŵĳ��մ���
       //getSamePolicyRegistInfo(prpLprepayDto);
         DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
        dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,prpLprepayDto.getPolicyNo(),claimDtoTemp.getPrpLclaimDto().getRegistNo());

       //������������Ϣ���ݵ������
       httpServletRequest.setAttribute("prpLprepayDto", prpLprepayDto);
      //���ø����ӱ���Ϣ������
       setSubInfo(httpServletRequest,new ClaimDto());
     }

   /**
    * ����Ԥ��ʱԤ��ҳ����������.
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
    * @param httpServletRequest
    * @return registDto Ԥ�����ݴ������ݽṹ
    * @throws Exception
    */
    public PrepayDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      //�̳ж�regist,registText��ĸ�ֵ
      PrepayDto prepayDto = super.viewToDto(httpServletRequest);
      return prepayDto;
    }

    /**
     * ����Ԥ��źͱ����ź��ⰸ�Ų�ѯԤ����Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param prepayNo       Ԥ���
     * @param policyNo       ������
     * @param claimNo        �ⰸ��
     * @throws Exception
     */

    public void setPrpLprepayDtoToView(HttpServletRequest httpServletRequest,String prepayNo,String policyNo,String claimNo) throws Exception
    {
    	logger.info("����Ԥ��źͱ����ź��ⰸ�Ų�ѯԤ����Ϣ����LIKE �������Ż���");
       //��������ı����ţ�Ԥ�������SQL where �Ӿ�
       prepayNo = StringUtils.rightTrim(prepayNo) ;
       policyNo = StringUtils.rightTrim(policyNo) ;
       claimNo = StringUtils.rightTrim(claimNo) ;
       String conditions = "";
       conditions = " PreCompensateNo = '" + prepayNo + "' AND policyNo = '" + policyNo
				+ "' AND claimNo = '" + claimNo + "'";
       //��ѯԤ����Ϣ
       UIPrepayAction uiPrepayAction = new UIPrepayAction();

       //�õ�����Ԥ��������Ϣ
       Collection prepayList = new ArrayList();
       prepayList  = (Collection)uiPrepayAction.findByConditions(conditions) ;
       PrpLprepayDto prpLprepayDto = new PrpLprepayDto();
       prpLprepayDto.setClaimList(prepayList);
       prpLprepayDto.setEditType(httpServletRequest.getParameter("editType")) ;
       httpServletRequest.setAttribute("prpLprepayDto",prpLprepayDto) ;
    }

    /**
     * ��дԤ��ҳ�漰��ѯԤ��request������.
     * ��дԤ��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
     * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
     * @param httpServletRequest ���ظ�ҳ���request
     * @param proposalIniDto ȡ���ĳ�ʼ����ϢDto
     * @throws Exception
     */
    public void claimDtoToView(HttpServletRequest httpServletRequest,
                                          String claimNo) throws Exception
    {
      //��ѯ������Ϣ
      UIClaimAction uiClaimAction = new UIClaimAction();
      ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
      //�ж��Ƿ��ѳ�������  add by miaowenjun 20060825
      List compensateList = new ArrayList();
      String msg = "";
      compensateList = (ArrayList)new UICompensateAction().findByConditions(" claimno='"+claimNo+"'");
      if(compensateList.size() > 0){
    	  msg = "���ⰸ�ѳ������飬�����ٽ���Ԥ�⣡";
          throw new UserException(1,3,"Ԥ�ⰸ",msg);
      }
      //add end by miaowenjun 20060825
      
      //ȡ�ù�����ĺϼ�
      PrpLclaimLossDto prpLclaimLossDto = uiClaimAction.getClaimLoss(claimNo);
//System.out.println("---------������--------" +prpLclaimLossDto.getSumClaim());
      httpServletRequest.setAttribute("sumClaim",String.valueOf(prpLclaimLossDto.getSumClaim()));

      //Ԥ������Ϣ
      PrpLprepayDto prpLprepayDto = new PrpLprepayDto();

      //Ԥ��ǼǺ�PreCompensateNo
      prpLprepayDto.setPreCompensateNo("  ");
      //�ⰸ����
      prpLprepayDto.setClaimNo(claimDto.getPrpLclaimDto().getClaimNo());
      //����
      prpLprepayDto.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
      //����
      prpLprepayDto.setClassCode(claimDto.getPrpLclaimDto().getClassCode());
      //��������
      prpLprepayDto.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
      //�ұ����
      prpLprepayDto.setCurrency(claimDto.getPrpLclaimDto().getCurrency());
      prpLprepayDto.setRegistNo(claimDto.getPrpLclaimDto().getRegistNo());
      prpLprepayDto.setArrearageTimes(0);
      prpLprepayDto.setSumArrearage(0);
      prpLprepayDto.setSumBeforePrePaid(0);
      prpLprepayDto.setBlockUpTimes(0);
      prpLprepayDto.setSumTotalPrepaid(0);
      prpLprepayDto.setUnderWriteCode("");
      prpLprepayDto.setUnderWriteName("");
      prpLprepayDto.setUnderWriteEndDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
/*
      //����Ƿ������arrearageTimes
      //����Ƿ����sumArrearage
      //��Ԥ���棩�����sumBeforePrePaid
      //���ε渶����Ƿ������blockUpTimes
      //Ԥ����sumPrePaid(�༭��Ŀ)
      //��Ԥ���棩�����sumTotalPrepaid
      //����Ա����approverCode
      //���պ����˴���underWriteCode
      //���պ���������underWriteName
      //�����������underWriteEndDate
      //�����־underWriteFlag
*/
//    **************�жϱ����Ƿ��Ѿ�ʵ��add by qinyongli 2005-7-21
      UIPolicyAction uiPolicyAction = new UIPolicyAction();
      String conditions1 = " policyno = '" + prpLprepayDto.getPolicyNo() + "' and payreason not like 'PS%' and payreason not like 'RS%' ";
      int intReturn = 0;
      intReturn = uiPolicyAction.checkPay(conditions1);//-1Ϊδ�ɷѣ�0Ϊδ��ȫ��1Ϊ��ȫ
      //��ȡϵͳ������Ϣ
      UIConfigAction uiConfigAction = new UIConfigAction();
      String configValue = "" ; //��ȡ����δʵ���Ƿ�����Ԥ��
      configValue = uiConfigAction.getConfigValue("ALLOW_UNPAYED_PREPAY",prpLprepayDto.getRiskCode());
      if(configValue==null||configValue.equals("")){
    	throw new UserException(1,3,"platform","������δ���л������ݳ�ʼ�������ڻ���ƽ̨ϵͳ�����������н��г�ʼ����");
      }
      //���configValue =2 intReturn��=1���ʾδ���Ѳ���Ԥ��
      if(configValue.equals("2")&&intReturn!=1){
    	  String riskCode = claimDto.getPrpLclaimDto().getRiskCode();
    	  if("3101".equals(riskCode)){
    		  httpServletRequest.setAttribute("prePayFlag", "1");//��������������3101���������ⰸʱ������δʵ����������Ԥ��
    	  }else{
    		  httpServletRequest.setAttribute("prePayFlag", "0");//0��ʾ������Ԥ��
              System.out.println("����δʵ�գ�ϵͳ������Ԥ�⣡"+intReturn);
    	  }
      }else{
      	httpServletRequest.setAttribute("prePayFlag", "1");//1��ʾ����Ԥ��
      }
      //*******************************************add end 
      prpLprepayDto.setSumPrePaid(0);
      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Ԥ����
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");

     //��������
      prpLprepayDto.setMakeCom(claimDto.getPrpLclaimDto().getMakeCom());
      //ҵ�������������
      prpLprepayDto.setComCode(claimDto.getPrpLclaimDto().getComCode());
      //�����˴���
      prpLprepayDto.setHandlerCode(claimDto.getPrpLclaimDto().getHandlerCode());
      //����ҵ��Ա����
      //prpLprepayDto.setHandler1Code(claimDto.getPrpLclaimDto().getHandler1Code());
      prpLprepayDto.setHandler1Code(user.getUserCode());
      //ͳ������
      prpLprepayDto.setStatisticsYM(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      //����Ա����

      prpLprepayDto.setOperatorCode(user.getUserCode());
      //prpLprepayDto.setOperatorCode(claimDto.getPrpLclaimDto().getOperatorCode());
      //�������������
      prpLprepayDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      //��־�ֶ�flag
      prpLprepayDto.setFlag(claimDto.getPrpLclaimDto().getFlag());
      prpLprepayDto.setStartDate(new DateTime(claimDto.getPrpLclaimDto().getStartDate().toString(),DateTime.YEAR_TO_DAY));
      prpLprepayDto.setEndDate(new DateTime(claimDto.getPrpLclaimDto().getEndDate().toString(),DateTime.YEAR_TO_DAY));
      prpLprepayDto.setSumAmount(claimDto.getPrpLclaimDto().getSumAmount());
      prpLprepayDto.setSumPremium(claimDto.getPrpLclaimDto().getSumPremium());
      prpLprepayDto.setDamageStartDate(new DateTime(claimDto.getPrpLclaimDto().getDamageStartDate().toString(),DateTime.YEAR_TO_DAY));
      String timeTemp = StringConvert.toStandardTime(claimDto.getPrpLclaimDto().getDamageStartHour());
      prpLprepayDto.setDamageStartHour(timeTemp.substring(0,2));
      prpLprepayDto.setDamageStartMinute(timeTemp.substring(3,5));
      prpLprepayDto.setDamageAddressType(claimDto.getPrpLclaimDto().getDamageAddressType());
      prpLprepayDto.setDamageAddress(claimDto.getPrpLclaimDto().getDamageAddress());
      prpLprepayDto.setSumClaim(claimDto.getPrpLclaimDto().getSumClaim());

/*
      //prpLprepayDto.setLFlag(claimDto.getPrpLclaimDto().getLFlag() );
      //prpLprepayDto.setCaseNo(claimDto.getPrpLclaimDto().getCaseNo());
      //prpLprepayDto.setClassCode(claimDto.getPrpLclaimDto().getClassCode());
      //prpLprepayDto.setRegistNo(claimDto.getPrpLclaimDto().getRegistNo());
      //prpLprepayDto.setBusinessNature(claimDto.getPrpLclaimDto().getBusinessNature());
      //prpLprepayDto.setLanguage(claimDto.getPrpLclaimDto().getLanguage());
      //prpLprepayDto.setPolicyType(claimDto.getPrpLclaimDto().getPolicyType());
      //prpLprepayDto.setInsuredCode(claimDto.getPrpLclaimDto().getInsuredCode() );
      //prpLprepayDto.setInsuredName(claimDto.getPrpLclaimDto().getInsuredName());
      //prpLprepayDto.setStartHour(claimDto.getPrpLclaimDto().getStartHour());
      //prpLprepayDto.setEndHour(claimDto.getPrpLclaimDto().getEndHour());
      //prpLprepayDto.setSumQuantity(claimDto.getPrpLclaimDto().getSumQuantity());
      //prpLprepayDto.setDamageEndDate(claimDto.getPrpLclaimDto().getDamageEndDate());
      //prpLprepayDto.setDamageEndHour(claimDto.getPrpLclaimDto().getDamageEndHour());
      //prpLprepayDto.setDamageCode(claimDto.getPrpLclaimDto().getDamageCode());
      //prpLprepayDto.setDamageName(claimDto.getPrpLclaimDto().getDamageName());
      //prpLprepayDto.setDamageTypeCode(claimDto.getPrpLclaimDto().getDamageTypeCode());
      //prpLprepayDto.setDamageTypeName(claimDto.getPrpLclaimDto().getDamageTypeName());
      //prpLprepayDto.setDamageAreaCode(claimDto.getPrpLclaimDto().getDamageAreaCode());
      //prpLprepayDto.setDamageAreaName(claimDto.getPrpLclaimDto().getDamageAreaName());
      //prpLprepayDto.setLossName(claimDto.getPrpLclaimDto().getLossName());
      //prpLprepayDto.setLossQuantity(claimDto.getPrpLclaimDto().getLossQuantity());
      //prpLprepayDto.setDamageKind(claimDto.getPrpLclaimDto().getDamageKind());
      //prpLprepayDto.setClaimDate(claimDto.getPrpLclaimDto().getClaimDate() );
      //prpLprepayDto.setIndemnityDuty(claimDto.getPrpLclaimDto().getIndemnityDuty());
      //prpLprepayDto.setIndemnityDutyRate(claimDto.getPrpLclaimDto().getIndemnityDutyRate());
      //prpLprepayDto.setDeductibleRate(claimDto.getPrpLclaimDto().getDeductibleRate());
      //prpLprepayDto.setSumDefLoss(claimDto.getPrpLclaimDto().getSumDefLoss());
      //prpLprepayDto.setSumPaid(claimDto.getPrpLclaimDto().getSumPaid());
      //prpLprepayDto.setSumReplevy(claimDto.getPrpLclaimDto().getSumReplevy());
      //prpLprepayDto.setRemark(claimDto.getPrpLclaimDto().getRemark());
      //prpLprepayDto.setCaseType(claimDto.getPrpLclaimDto().getCaseType());
      //prpLprepayDto.setEndCaseDate(claimDto.getPrpLclaimDto().getEndCaseDate());
      //prpLprepayDto.setEndCaserCode(claimDto.getPrpLclaimDto().getEndCaserCode());
      //prpLprepayDto.setCancelDate(claimDto.getPrpLclaimDto().getCancelDate());
      //prpLprepayDto.setCancelReason(claimDto.getPrpLclaimDto().getCancelReason());
      //prpLprepayDto.setDealerCode(claimDto.getPrpLclaimDto().getDealerCode());
      //prpLprepayDto.setEscapeFlag(claimDto.getPrpLclaimDto().getEscapeFlag());
*/

      //����Ԥ�������״̬Ϊ �°����Ǽ� (δ��������)
      prpLprepayDto.setStatus("1");

      if (!claimDto.getPrpLclaimDto().getPolicyNo().equals(""))
      {
        //��ѯ������Ϣ
        EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
   	    PolicyDto policyDto = endorseViewHelper.findForEndorBefore(claimDto.getPrpLclaimDto().getPolicyNo()
   	    		,claimDto.getPrpLclaimDto().getDamageStartDate().toString()
				,claimDto.getPrpLclaimDto().getDamageStartHour()); 

        PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
        if(policyDto.getPrpCitemCarDtoList().size()>0)
        {
           //�Գ��͵���Ϣ��֧��
           PrpCitemCarDto= (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(0);
           prpLprepayDto.setClauseType(PrpCitemCarDto.getClauseType() );
           prpLprepayDto.setLicenseNo(PrpCitemCarDto.getLicenseNo()  );
           prpLprepayDto.setLicenseColorCode(PrpCitemCarDto.getLicenseColorCode() );
           prpLprepayDto.setLicenseColor(PrpCitemCarDto.getLicenseColorCode());
           prpLprepayDto.setBrandName(PrpCitemCarDto.getBrandName() );
           prpLprepayDto.setCarKindCode(PrpCitemCarDto.getCarKindCode() );
           prpLprepayDto.setEngineNo(PrpCitemCarDto.getEngineNo() );
           prpLprepayDto.setFrameNo(PrpCitemCarDto.getFrameNo() );
        }
      }

      PrpLptextDto prpLptextDto = new PrpLptextDto();
      //��ֵ�ı�������
      httpServletRequest.setAttribute("prpLptextDto", prpLptextDto);

      //������ش��������ת��
      changeCodeToName(httpServletRequest,prpLprepayDto);
      //���ô�����и�����ѡ�����б���Ϣ������
      setSelectionList(httpServletRequest,prpLprepayDto);
      //��ѯ��ͬ�����ŵĳ��մ���
       //getSamePolicyRegistInfo(prpLprepayDto);
       DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
        dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,prpLprepayDto.getPolicyNo(),claimDto.getPrpLclaimDto().getRegistNo());

      //������������Ϣ���ݵ������
      httpServletRequest.setAttribute("prpLprepayDto", prpLprepayDto);
      PrpLpreChargeDto prpLpreChargeDto = new PrpLpreChargeDto();
      httpServletRequest.setAttribute("prpLpreChargeDto", prpLpreChargeDto);
     //���ø����ӱ���Ϣ������
      setSubInfo(httpServletRequest,claimDto);
    }

    /**
      * ����PrpPrepayDto�еĸ��ӱ��ڵ���Ϣ������
      * @param httpServletRequest ���ظ�ҳ���request
      * @param prpPrepayDto    ������������
      * @throws Exception
      */
    private void setSubInfo(HttpServletRequest httpServletRequest,
                           ClaimDto claimDto) throws Exception
    {

       //[�永����]�����߳��������б�׼������
       Collection arrayList = new ArrayList();
       PrpLthirdPartyDto prpLthirdPartyDto  = new PrpLthirdPartyDto();
       arrayList = claimDto.getPrpLthirdPartyDtoList();
       prpLthirdPartyDto.setThirdPartyList(arrayList) ;

       httpServletRequest.setAttribute("prpLthirdPartyDto", prpLthirdPartyDto);

       //[��ʻԱ]����ʻԱ���ж����б�׼������
       Collection arrayListDriver = new ArrayList();
       PrpLdriverDto prpLdriverDto  = new PrpLdriverDto();
       arrayListDriver = claimDto.getPrpLdriverDtoList() ;
       prpLdriverDto.setDriverList(arrayListDriver) ;
       httpServletRequest.setAttribute("prpLdriverDto", prpLdriverDto);
/*
       //[�鿱��Ϣ]��Ԥ���ļ������б�׼������
       Collection arrayLTextList = new ArrayList();
       PrpLltextDto prpLltextDto  = new PrpLltextDto();
       prpLltextDto.setTextType("1") ;
       arrayLTextList  = claimDto.getPrpLltextDtoList() ;
       prpLltextDto.setLtextList(arrayLTextList) ;
       httpServletRequest.setAttribute("prpLltextDto", prpLltextDto  );
*/
       //[������]���������ļ������б�׼������
       Collection claimFeeList= new ArrayList();
       PrpLclaimFeeDto prpLclaimFeeDto = new PrpLclaimFeeDto();
       //û��
       //prpLclaimFeeDto.setPrepayFeeList(claimFeeList);
       httpServletRequest.setAttribute("prpLclaimFeeDto", prpLclaimFeeDto);

       //[��֤��Ϣ]�����ⵥ֤�ļ������б�׼������
       Collection docList= new ArrayList();
       PrpLdocDto prpLdocDto = new PrpLdocDto();
       docList  = claimDto.getPrpLdocDtoList()  ;
       prpLdocDto.setDocList(docList);
       httpServletRequest.setAttribute("prpLdocDto", prpLdocDto);
     }

    /**
     * ����PrpPrepayDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
     * @param httpServletRequest ���ظ�ҳ���request
     * @param prpPrepayDto    ������������
     * @param PrepayDto      ��ѯ����������
     * @throws Exception
     */
   private void changeCodeToName(HttpServletRequest httpServletRequest,
                          PrpLprepayDto prpLprepayDto) throws Exception
   {
      UICodeAction uiCodeAction = new UICodeAction();
      //(1)�������Ƶ�ת��
      String  clauseType = prpLprepayDto.getClauseType();
      String  clauseName = uiCodeAction.translateCodeCode("ClauseType",clauseType,true) ;
      prpLprepayDto.setClauseName(clauseName);
      //(2)������ɫת��
      String  licenseColorCodeCode = prpLprepayDto.getLicenseColorCode();
      String  licenseColor = uiCodeAction.translateCodeCode("LicenseColor",licenseColorCodeCode,true) ;
      prpLprepayDto.setLicenseColor(licenseColor);
      //(3)��������ת��
      String  carKindCode = prpLprepayDto.getCarKindCode();
      String  carKind = uiCodeAction.translateCodeCode("CarKind",carKindCode,true) ;
      prpLprepayDto.setCarKind(carKind);
      //(4)��ҵ������ṹ����ת��
      String comCode = prpLprepayDto.getComCode();
      String comName = uiCodeAction.translateComCode(comCode,true) ;
      prpLprepayDto.setComName(comName);
      //(5)�Թ���ҵ��Ա����ת��
      String handler1Code  = prpLprepayDto.getHandler1Code();
      String handler1Name = uiCodeAction.translateUserCode(handler1Code,true) ;
      prpLprepayDto.setHandler1Name(handler1Name) ;
      //(6)�Դ����˽���ת��
      String agentCode = prpLprepayDto.getAgentCode();
      String agentName = uiCodeAction.translateUserCode(agentCode,true) ;
      prpLprepayDto.setAgentName(agentName) ;
      //(7)�Ծ����˽���ת��
      String handlerCode = prpLprepayDto.getHandlerCode();
      String handlerName = uiCodeAction.translateUserCode(handlerCode,true) ;
      prpLprepayDto.setHandlerName(handlerName) ;
      //�Աұ����ת��
      String currency = prpLprepayDto.getCurrency();
      String currencyName = uiCodeAction.translateCurrencyCode(currency,true);
      prpLprepayDto.setCurrencyName(currencyName) ;
   }


   /**
     * ��ȡѡ�����б���е���������
     * @param httpServletRequest ���ظ�ҳ���request
     * @param prpPrepayDto    ������������
     * @throws Exception
     */
   private void setSelectionList(HttpServletRequest httpServletRequest,
                          PrpLprepayDto prpLprepayDto) throws Exception
   {
     UICodeAction uiCodeAction = new UICodeAction();

     //(1)�õ����������б�
     Collection reportTypes = uiCodeAction.getCodeType("ReportType", prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("reportTypes", reportTypes);
     //(2)�õ����������б��б�
     Collection claimTypes = uiCodeAction.getCodeType("CaseCode", prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("claimTypes", claimTypes);
     //(3)�õ����յ�ַ�����б�
     Collection damageAddressTypes = uiCodeAction.getCodeType("DamageAddress",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("damageAddressTypes", damageAddressTypes);
     //(4)�õ����������б�
     Collection carKindCodes = uiCodeAction.getCodeType("CarKind", prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("carKindCodes", carKindCodes);
     //(5)�õ����Ƶ�ɫ�б�
     Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("licenseColorCodes",licenseColorCode);
     //(6)�õ��⳥�����б�
     Collection indemnityDuty = uiCodeAction.getCodeType("IndemnityDuty",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("indemnityDutys",indemnityDuty);
     //(7)�õ��ⰸ����б�
     Collection escapeFlags = uiCodeAction.getCodeType("CaseCode",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("escapeFlags",escapeFlags);
     //(8)�õ��õ��Ա�
     Collection driverSex = uiCodeAction.getCodeType("SexCode",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("driverSexs",driverSex);
     //(9)�õ�ְҵ����
     Collection driverOccupation = uiCodeAction.getCodeType("Occupation",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("driverOccupations",driverOccupation) ;
     //(10)�õ��Ļ��̶�
     Collection education = uiCodeAction.getCodeType("Education",prpLprepayDto.getRiskCode());
     httpServletRequest.setAttribute("educations",education) ;
     //(11)�õ��������͵��б� --- Ŀǰ�޷��õ�
    }

    /**
     * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����.
     * ��дԤ�ⵥʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
     * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ��
     * ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
     * @param httpServletRequest
     * @return RequestDto ȡ��ʼ����Ϣ��Ҫ������
     * @throws Exception
     */
    public PrepayDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      return new PrepayDto();
    }

    /**
     * ��дԤ��ҳ�漰��ѯԤ��request������.
     * ��дԤ��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
     * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
     * @param httpServletRequest ���ظ�ҳ���request
     * @param prepayDto ȡ���ĳ�ʼ����ϢDto
     * @throws Exception
     */
     public void dtoToView(HttpServletRequest httpServletRequest, PrepayDto prepayDto) throws Exception
     {
     }

    /**
     * �����û�ID��Ԥ��״̬��ѯԤ����Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param status       Ԥ��״̬
     * @param userCode     �û�ID
     * @throws Exception
     */

    public void setPrpLprepayManageDtoToView(HttpServletRequest httpServletRequest,String status,String userCode) throws Exception
    {
       logger.info("�����û�ID��Ԥ��״̬��ѯԤ����Ϣ����LIKE �������Ż���");
       //��������ı����ţ��ⰸ������SQL where �Ӿ�
       status = StringUtils.rightTrim(status) ;
       userCode = StringUtils.rightTrim(userCode) ;
       String conditions = "";
       conditions = " Status  = '" + status + "' AND handlerCode = '" + userCode + "' AND NodeType = 'prepa'" ;
       //��ѯԤ����Ϣ
       UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();
       //�õ�����Ԥ��������Ϣ
       Collection prepayList = new ArrayList();
       prepayList  = (Collection)uiClaimStatusAction.findByConditions(conditions) ;
       PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
       prpLclaimStatusDto.setClaimList(prepayList);
       prpLclaimStatusDto.setEditType(httpServletRequest.getParameter("editType")) ;
       httpServletRequest.setAttribute("prpLclaimStatusDto",prpLclaimStatusDto) ;
    }

    /**
     * ����Ԥ��źͱ�����,�ⰸ��,����״̬�����ƺ��룬����ʱ���ѯԤ����Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param prepayNo       Ԥ���
     * @param policyNo       ������
     * @param claimNo        �ⰸ��
     * @throws Exception
     * Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
     */

    public void setPrpLprepayDtoToView(HttpServletRequest httpServletRequest,String prepayNo,String policyNo,String claimNo,String licenseNo,String status,String operateDate,String underWriteFlag) throws Exception
    {
       //��������ı����ţ�Ԥ�������SQL where �Ӿ�
       prepayNo = StringUtils.rightTrim(prepayNo) ;
       policyNo = StringUtils.rightTrim(policyNo) ;
       claimNo = StringUtils.rightTrim(claimNo) ;
       licenseNo = StringUtils.rightTrim(licenseNo);
       operateDate = StringUtils.rightTrim(operateDate);
       String strSign = httpServletRequest.getParameter("OperateDateSign");

       String conditions = " 1=1 ";
       conditions = conditions + StringConvert.convertString("a.PreCompensateNo",prepayNo,httpServletRequest.getParameter("PrepayNoSign"));
       conditions = conditions + StringConvert.convertString("a.claimNo",claimNo,httpServletRequest.getParameter("ClaimNoSign"));
       conditions = conditions + StringConvert.convertString("a.policyNo",policyNo,httpServletRequest.getParameter("PolicyNoSign"));
       conditions = conditions + StringConvert.convertString("c.licenseNo",licenseNo,httpServletRequest.getParameter("LicenseNoSign"));
       if(status.trim().length()>0){
       	 conditions = conditions + " AND b.status in ('" +status+ "')";
       	 }
       if(underWriteFlag.trim().length()>0){
       	 conditions = conditions + " AND a.underWriteFlag in (" +underWriteFlag+ ") ";
       }
       if(operateDate != null && !operateDate.trim().equals("")){
         conditions = conditions+ StringConvert.convertDate("b.operateDate",operateDate,strSign);
       }
       //��ѯԤ����Ϣ
       UIPrepayAction uiPrepayAction = new UIPrepayAction();
       //�õ�����Ԥ��������Ϣ
       Collection prepayList = new ArrayList();
       System.out.println("start to search,please waiting ...");
       prepayList  = (Collection)uiPrepayAction.findByQueryConditions(conditions) ;
       System.out.println("end search,please waiting for result...");
       PrpLprepayDto prpLprepayDto = new PrpLprepayDto();
       prpLprepayDto.setClaimList(prepayList);
       System.out.println("finish add list");
       System.out.println("editType="+httpServletRequest.getParameter("editType"));
       prpLprepayDto.setEditType(httpServletRequest.getParameter("editType")) ;
       httpServletRequest.setAttribute("prpLprepayDto",prpLprepayDto) ;
    }

    /**
     * ����Ԥ��źͱ����ź��ⰸ�Ų�ѯ�����˵�Ԥ����Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param prepayNo       Ԥ���
     * @param policyNo       ������
     * @param claimNo        �ⰸ��
     * @throws Exception
     */

    public void getApprovePrepayList(HttpServletRequest httpServletRequest,String prepayNo,String policyNo,String claimNo) throws Exception
    {
       //��������ı����ţ�Ԥ�������SQL where �Ӿ�
       prepayNo = StringUtils.rightTrim(prepayNo) ;
       policyNo = StringUtils.rightTrim(policyNo) ;
       claimNo = StringUtils.rightTrim(claimNo) ;
       String conditions = "1=1  ";
       conditions = conditions + StringConvert.convertString("prplprepay.precompensateNo",prepayNo,httpServletRequest.getParameter("PrepayNoSign"));
       conditions = conditions + StringConvert.convertString("prplprepay.policyNo",policyNo,httpServletRequest.getParameter("PolicyNoSign"));
       conditions = conditions + StringConvert.convertString("prplprepay.claimNo",claimNo,httpServletRequest.getParameter("ClaimNoSign"));
       conditions = conditions +" AND ( prplprepay.ApproverCode IS NULL OR  prplprepay.ApproverCode='' OR prplprepay.UnderWriteFlag='2') and prplclaimstatus.status='3'" ;
       //��ѯԤ����Ϣ
       UIPrepayAction uiPrepayAction = new UIPrepayAction();

       //�õ�����Ԥ��������Ϣ
       Collection prepayList = new ArrayList();
       prepayList  = (Collection)uiPrepayAction.findByApproveConditions(conditions) ;
       PrpLprepayDto prpLprepayDto = new PrpLprepayDto();
       prpLprepayDto.setClaimList(prepayList);
       prpLprepayDto.setEditType(httpServletRequest.getParameter("editType")) ;
       httpServletRequest.setAttribute("prpLprepayDto",prpLprepayDto) ;
    }

    /**
     * ��ѯ�Ѿ����������ݣ�������ִ�����������ʾ
     * @param registDto RegistDto
     * @throws Exception
     */
    private void getSamePolicyRegistInfo(PrpLprepayDto prpLprepayDto)
    throws Exception{

         UIRegistAction uiRegistAction  = new UIRegistAction ();
         Collection registList = new ArrayList();
         Collection registLastList = new ArrayList();
         PrpLregistDto prpLregistDtoTemp = new PrpLregistDto();
         UICodeAction uiCodeAction  = new UICodeAction ();
         String strOperatorCode="";
         String strOperatorName="";
         registList = uiRegistAction.findSamePolicyRegist(prpLprepayDto.getPolicyNo() ) ;
         int intPerilCount =0;
         Iterator it = registList.iterator() ;
          //ת��������Ա�����ƣ��Լ��������
         while (it.hasNext() )
         {
           prpLregistDtoTemp = (PrpLregistDto)it.next() ;
           strOperatorCode = prpLregistDtoTemp.getOperatorCode()   ;
           strOperatorName = uiCodeAction.translateUserCode(strOperatorCode,true);
           prpLregistDtoTemp.setOperatorName(strOperatorName);

           registLastList.add(prpLregistDtoTemp)  ;
           intPerilCount++;
         }
         //����ѯ������ͬ�����������ݷ���PrpLregistDto��list
         prpLprepayDto.setRegistList(registLastList) ;
         //������յĴ���
         prpLprepayDto .setPerilCount(intPerilCount);
    }

 }
