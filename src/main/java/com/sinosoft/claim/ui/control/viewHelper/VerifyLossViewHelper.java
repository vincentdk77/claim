package com.sinosoft.claim.ui.control.viewHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;

/**
 * <p>Title: VerifyLossViewHelper</p>
 * <p>Description:����ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */ 
 public abstract class VerifyLossViewHelper
 {
   /**
    * Ĭ�Ϲ��췽��
    */
    public VerifyLossViewHelper()
    {
    }

   /**
    * �������ʱ����ҳ����������.
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
    * @param httpServletRequest
    * @return stepFlag ��־
    * @throws Exception
    */
    public VerifyLossDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      String lossType = httpServletRequest.getParameter("lossTypeFlag");
      String nodeType = httpServletRequest.getParameter("nodeType");
      
      VerifyLossDto verifyLossDto = new VerifyLossDto();
      
      /*---------------------�������� PrpLverifyLoss------------------------------------*/
      PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
      prpLverifyLossDto.setRegistNo            (httpServletRequest.getParameter("prpLverifyLossRegistNo"));
      prpLverifyLossDto.setClaimNo             (httpServletRequest.getParameter("prpLverifyLossClaimNo"));
      prpLverifyLossDto.setRiskCode            (httpServletRequest.getParameter("prpLverifyLossRiskCode"));
      prpLverifyLossDto.setPolicyNo            (httpServletRequest.getParameter("prpLverifyLossPolicyNo"));
      prpLverifyLossDto.setInsuredName         (httpServletRequest.getParameter("prpLverifyLossInsuredName"));
      prpLverifyLossDto.setLicenseNo           (httpServletRequest.getParameter("prpLverifyLossLicenseNo"));
      prpLverifyLossDto.setLicenseColorcode    (httpServletRequest.getParameter("prpLverifyLossLicenseColorcode"));
      prpLverifyLossDto.setCarKindCode         (httpServletRequest.getParameter("prpLverifyLossCarKindCode"));
      prpLverifyLossDto.setCurrency            (httpServletRequest.getParameter("prpLverifyLossCurrency"));
      prpLverifyLossDto.setSumPreDefLoss       (Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossSumPreDefLoss"))));
      prpLverifyLossDto.setSumDefLoss          (Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossSumDefLoss"))));
      prpLverifyLossDto.setMakeCom             (httpServletRequest.getParameter("prpLverifyLossMakeCom"));
      prpLverifyLossDto.setComCode             (httpServletRequest.getParameter("prpLverifyLossComCode"));
      prpLverifyLossDto.setHandlerCode         (httpServletRequest.getParameter("prpLverifyLossHandlerCode"));
      prpLverifyLossDto.setHandlerName         (httpServletRequest.getParameter("prpLverifyLossHandlerName"));
      
      //Modify by chenrenda update begin 20050421
      //Reason:�ں���ҳ�����Ӻ������ѡ��
      int intPrpLverifyLossLossItemCode = Integer.parseInt(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossLossItemCode")));
      String strVerifyPriceOpinion = "";
      String strVerifyOpinion = "";
      if(intPrpLverifyLossLossItemCode>0) {
      	strVerifyPriceOpinion =   httpServletRequest.getParameter("verpOpinion");	
      	strVerifyOpinion =   httpServletRequest.getParameter("verifyOpinion");
      }
      
      prpLverifyLossDto.setVerifyOpinion(strVerifyOpinion);
      //Modify by chenrenda update end 20050421
      
      prpLverifyLossDto.setVerpOpinion(strVerifyPriceOpinion);
      prpLverifyLossDto.setVerpDate(new DateTime(httpServletRequest.getParameter("prpLverifyLossVerpDate"),DateTime.YEAR_TO_DAY ));
      prpLverifyLossDto.setVerpApproverCode         (httpServletRequest.getParameter("prpLverifyLossVerpApproverCode"));
      prpLverifyLossDto.setVerpRemark         (httpServletRequest.getParameter("prpLverifyLossVerpRemark"));
      
      prpLverifyLossDto.setLossItemCode         (httpServletRequest.getParameter("prpLverifyLossLossItemCode"));
      prpLverifyLossDto.setLossItemName         (httpServletRequest.getParameter("prpLverifyLossLossItemName"));
      prpLverifyLossDto.setInsureCarFlag        (httpServletRequest.getParameter("prpLverifyLossInsureCarFlag"));
      prpLverifyLossDto.setDefLossDate         (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      prpLverifyLossDto.setDefLossDate         (new DateTime(httpServletRequest.getParameter("prpLverifyLossDefLossDate"),DateTime.YEAR_TO_DAY ));
      prpLverifyLossDto.setUnderWriteCode      (httpServletRequest.getParameter("prpLverifyLossUnderWriteCode"));
      prpLverifyLossDto.setUnderWriteName      (httpServletRequest.getParameter("prpLverifyLossUnderWriteName"));
      prpLverifyLossDto.setUnderWriteEndDate   (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      prpLverifyLossDto.setBackCheckRemark   (httpServletRequest.getParameter("prpLverifyLossBackCheckRemark"));  
      prpLverifyLossDto.setVeriwReturnReason   (httpServletRequest.getParameter("prpLverifyLossVeriwReturnReason"));  
      //prpLverifyLossDto.setUnderWriteEndDate   (httpServletRequest.getParameter("prpLverifyLossUnderWriteEndDate"));
      
      //����ƫ����  
      double prpLverifyLossFirstDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossFirstDefLoss")));      
      double prpLverifyLossWarpDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossWarpDefLoss")));
      prpLverifyLossDto.setFirstDefLoss(prpLverifyLossFirstDefLoss);
      prpLverifyLossDto.setWarpDefLoss(prpLverifyLossWarpDefLoss);
      //���ύʱ��ʾ����ͨ��underWriteFlag��״̬λΪ1,��ʾͨ��
      String buttonSaveType = httpServletRequest.getParameter("buttonSaveType");
      if(buttonSaveType.equals("3")||buttonSaveType.endsWith("4")) {
        prpLverifyLossDto.setUnderWriteFlag      ("1");
      } else {
        prpLverifyLossDto.setUnderWriteFlag      ("0");
      }
      prpLverifyLossDto.setRemark              (httpServletRequest.getParameter("prpLverifyLossRemark"));
      prpLverifyLossDto.setVerifyRemark        (httpServletRequest.getParameter("prpLverifyLossVerifyRemark"));
      prpLverifyLossDto.setFlag                (httpServletRequest.getParameter("prpLverifyLossFlag"));
      //prpLverifyLossDto.setBackCheckRemark     (httpServletRequest.getParameter("prpLverifyLossBackCheckRemark"));
     
//    add by lixiang start at 2006-04-21
      //reason: ���ӱ��������˻صĶ����ԭ�����ݵı���,�������ݲ��ᱻ������
      prpLverifyLossDto.setCompensateApproverCode( httpServletRequest.getParameter("prpLverifyLossCompensateApproverCode"));
      prpLverifyLossDto.setCompensateBackDate( new DateTime((String)httpServletRequest.getParameter("prpLverifyLossCompensateBackDate"),DateTime.YEAR_TO_DAY ));
      prpLverifyLossDto.setCompensateFlag( httpServletRequest.getParameter("prpLverifyLossCompensateFlag"));
      prpLverifyLossDto.setCompensateOpinion( httpServletRequest.getParameter("prpLverifyLossCompensateOpinion"));
      //add by lixiang end at 2006-04-21
      //add by wunier 20080103
      //reason:ũ�ո���������ֶ�
      String prpLverifyLossLossesNumber = httpServletRequest.getParameter("prpLverifyLossLossesNumber");
      if(prpLverifyLossLossesNumber!=null&&!"".equals(prpLverifyLossLossesNumber)){
      prpLverifyLossDto.setLossesNumber(Double.parseDouble(prpLverifyLossLossesNumber));
      }
      prpLverifyLossDto.setLossesUnitCode(httpServletRequest.getParameter("lossesUnitCode"));
      String prpLverifyLossDamageInsured = httpServletRequest.getParameter("prpLverifyLossDamageInsured");
      if(prpLverifyLossDamageInsured!=null&&!"".equals(prpLverifyLossDamageInsured)){
      prpLverifyLossDto.setDamageInsured(Double.parseDouble(prpLverifyLossDamageInsured));
      }
      String prpLverifyLossDisasterArea = httpServletRequest.getParameter("prpLverifyLossDisasterArea");
      if(prpLverifyLossDisasterArea!=null&&!"".equals(prpLverifyLossDisasterArea)){
      prpLverifyLossDto.setDisasterArea(Double.parseDouble(prpLverifyLossDisasterArea));
      }
      prpLverifyLossDto.setDisasterUnit(httpServletRequest.getParameter("disasterUnit"));
      String prpLverifyLossAffectedArea = httpServletRequest.getParameter("prpLverifyLossAffectedArea");
      if(prpLverifyLossAffectedArea!=null&&!"".equals(prpLverifyLossAffectedArea)){
      prpLverifyLossDto.setAffectedArea(Double.parseDouble(prpLverifyLossAffectedArea));
      }
      prpLverifyLossDto.setAffectedUnit(httpServletRequest.getParameter("affectedUnit"));
      String prpLverifyLossNoProductionArea = httpServletRequest.getParameter("prpLverifyLossNoProductionArea");
      if(prpLverifyLossNoProductionArea!=null&&!"".equals(prpLverifyLossNoProductionArea)){
      prpLverifyLossDto.setNoProductionArea(Double.parseDouble(prpLverifyLossNoProductionArea));
      }
      prpLverifyLossDto.setNoProductionUnit(httpServletRequest.getParameter("noProductionUnit"));
      String prpLverifyLossDeathQuantity = httpServletRequest.getParameter("prpLverifyLossDeathQuantity");
      if(prpLverifyLossDeathQuantity!=null&&!"".equals(prpLverifyLossDeathQuantity)){
      prpLverifyLossDto.setDeathQuantity(Double.parseDouble(prpLverifyLossDeathQuantity));
      prpLverifyLossDto.setDeathUnit(httpServletRequest.getParameter("deathUnit"));
      }
      String prpLverifyLossKillQuantity = httpServletRequest.getParameter("prpLverifyLossKillQuantity");
      if(prpLverifyLossKillQuantity!=null&&!"".equals(prpLverifyLossKillQuantity)){
      prpLverifyLossDto.setKillQuantity(Double.parseDouble(prpLverifyLossKillQuantity));
      prpLverifyLossDto.setKillUnit(httpServletRequest.getParameter("killUnit"));
      }
      //end by wunier 20080103

      verifyLossDto.setPrpLverifyLossDto(prpLverifyLossDto);

      /*---------------------״̬����prpLclaimStatus------------------------------------*/
      String statusTemp = httpServletRequest.getParameter("buttonSaveType");
      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
      prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
      prpLclaimStatusDto.setBusinessNo(httpServletRequest.getParameter("prpLverifyLossRegistNo"));
      prpLclaimStatusDto.setPolicyNo(httpServletRequest.getParameter("prpLverifyLossPolicyNo"));
      prpLclaimStatusDto.setRiskCode(prpLverifyLossDto.getRiskCode());
      prpLclaimStatusDto.setNodeType(nodeType);
      prpLclaimStatusDto.setSerialNo(0);
      prpLclaimStatusDto.setTypeFlag(prpLverifyLossDto.getLossItemCode());
      prpLclaimStatusDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLverifyLossDto.getLossItemCode())));
      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��������
      HttpSession session = httpServletRequest.getSession();
      UserDto user = (UserDto) session.getAttribute("user");
      System.out.println("user="+user);
      prpLclaimStatusDto.setHandlerCode(user.getUserCode());
      prpLclaimStatusDto.setInputDate(new DateTime(new Date(),DateTime.YEAR_TO_DAY));
      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      verifyLossDto.setPrpLclaimStatusDto(prpLclaimStatusDto);

      return verifyLossDto;
    }

   /**
    * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����.
    * ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
    * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ��
    * ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
    * @param httpServletRequest
    * @return RequestDto ȡ��ʼ����Ϣ��Ҫ������
    * @throws Exception
    */  
   public abstract VerifyLossDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception;
 
   /**
    * ��д����ҳ�漰��ѯ����request������.
    * ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
    * @param httpServletRequest ���ظ�ҳ���request
    * @param verifyLossDto ȡ���ĳ�ʼ����ϢDto
    * @throws Exception
    */
    public abstract void dtoToView(HttpServletRequest httpServletRequest, VerifyLossDto verifyLossDto) throws Exception;

 }
