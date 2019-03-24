package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 * <p>Title: CertainLossViewHelper</p>
 * <p>Description:����ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */ 
 public abstract class CertainLossViewHelper
 { 
   /** 
    * Ĭ�Ϲ��췽��
    */
    public CertainLossViewHelper()
    {    
    }   
   
   /**
    * ���涨��ʱ����ҳ����������.
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
    * @param httpServletRequest
    * @return stepFlag ��־
    * @throws Exception
    */
    public CertainLossDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      double underWritePreDef = Double.parseDouble(DataUtils.nullToZero(AppConfig.get("sysconst.UnderWritePreDef")));
      double sumPreDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossSumPreDefLoss")));
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      String    userCode = user.getUserCode() ;
      String    userName = user.getUserName() ;

      CertainLossDto certainLossDto = new CertainLossDto();
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

      prpLverifyLossDto.setLossItemCode         (httpServletRequest.getParameter("prpLverifyLossLossItemCode"));
      prpLverifyLossDto.setLossItemName         (httpServletRequest.getParameter("prpLverifyLossLossItemName"));
      prpLverifyLossDto.setInsureCarFlag        (httpServletRequest.getParameter("prpLverifyLossLossInsureCarFlag"));

      prpLverifyLossDto.setDefLossDate         (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      prpLverifyLossDto.setDefLossDate         (new DateTime(httpServletRequest.getParameter("prpLverifyLossDefLossDate"),DateTime.YEAR_TO_DAY ));
      prpLverifyLossDto.setUnderWriteCode      (httpServletRequest.getParameter("prpLverifyLossUnderWriteCode"));
      prpLverifyLossDto.setUnderWriteName      (httpServletRequest.getParameter("prpLverifyLossUnderWriteName"));
      prpLverifyLossDto.setUnderWriteEndDate   (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      //prpLverifyLossDto.setUnderWriteEndDate   (httpServletRequest.getParameter("prpLverifyLossUnderWriteEndDate"));
      prpLverifyLossDto.setUnderWriteFlag      (httpServletRequest.getParameter("prpLverifyLossUnderWriteFlag"));
      prpLverifyLossDto.setRemark              (httpServletRequest.getParameter("prpLverifyLossRemark"));
      prpLverifyLossDto.setVerifyRemark        (httpServletRequest.getParameter("prpLverifyLossVerifyRemark"));
      prpLverifyLossDto.setVeriwReturnReason   (httpServletRequest.getParameter("prpLverifyLossVeriwReturnReason"));
      prpLverifyLossDto.setFlag                (httpServletRequest.getParameter("prpLverifyLossFlag"));
      prpLverifyLossDto.setVerifyOpinion       (httpServletRequest.getParameter("verifyOpinion"));
      //add by lixiang start at 2006-04-21
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
 
      //����ƫ����
      double prpLverifyLossFirstDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossFirstDefLoss")));      
      double prpLverifyLossWarpDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossWarpDefLoss")));
      if(prpLverifyLossFirstDefLoss<=0){
      	prpLverifyLossFirstDefLoss=prpLverifyLossWarpDefLoss;
      }   
      prpLverifyLossDto.setFirstDefLoss(prpLverifyLossFirstDefLoss);
      prpLverifyLossDto.setWarpDefLoss(prpLverifyLossFirstDefLoss);
      certainLossDto.setPrpLverifyLossDto(prpLverifyLossDto);
      //ÿ�θĶ���ʱ�򣬰ѸĶ��ˣ��Ķ�ʱ�䣬�Ķ��Ľ�д��swfnotion����
    	ArrayList notionList = new ArrayList();

        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction ();
      int maxLineNo=uiWorkFlowAction.getSwfNotionMaxLineNo(httpServletRequest.getParameter("swfLogFlowID"),Integer.parseInt(DataUtils.nullToZero(httpServletRequest.getParameter("swfLogLogNo")) ));    	
      if(prpLverifyLossFirstDefLoss!=prpLverifyLossWarpDefLoss){
      	SwfNotionDto swfNotionDto = new SwfNotionDto();
      	swfNotionDto.setFlowID(httpServletRequest.getParameter("swfLogFlowID"));
      	swfNotionDto.setLogNo(Integer.parseInt(DataUtils.nullToZero(httpServletRequest.getParameter("swfLogLogNo")) ));
      	swfNotionDto.setLineNo(maxLineNo); 
      	swfNotionDto.setHandleText(user.getUserName()+"��"+new DateTime(new Date(),DateTime.YEAR_TO_DAY)+"�޸��˶�����:"+prpLverifyLossWarpDefLoss+"Ԫ");
      	notionList.add(swfNotionDto);
      } 
      certainLossDto.setSwfNotionList(notionList);
      //���������Ϊĳһֵʱ�������ͨ�� 
        //System.out.println("++++++++++++++++++++underWritePreDef="+underWritePreDef + "|++++++++++++++sumPreDefLoss="+sumPreDefLoss);
        if(underWritePreDef>=sumPreDefLoss)
        {
          prpLverifyLossDto.setUnderWriteCode      (userCode);
          prpLverifyLossDto.setUnderWriteName(userName);
          prpLverifyLossDto.setUnderWriteEndDate(new DateTime(DateTime.current().
              toString(), DateTime.YEAR_TO_DAY));
          //prpLverifyLossDto.setUnderWriteEndDate   (httpServletRequest.getParameter("prpLverifyLossUnderWriteEndDate"));
          prpLverifyLossDto.setUnderWriteFlag("1");
        }  

      /*---------------------״̬����prpLclaimStatus------------------------------------*/
      String statusTemp = httpServletRequest.getParameter("buttonSaveType");
      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
      prpLclaimStatusDto.setBusinessNo(httpServletRequest.getParameter("prpLverifyLossRegistNo"));
      prpLclaimStatusDto.setPolicyNo(httpServletRequest.getParameter("prpLverifyLossPolicyNo"));
      prpLclaimStatusDto.setRiskCode(httpServletRequest.getParameter("prpLverifyLossRiskCode"));
      prpLclaimStatusDto.setNodeType("certa");
      prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
      /*
      if(statusTemp.trim().equals("4")){
        prpLclaimStatusDto.setNodeType("verif");
        prpLclaimStatusDto.setStatus("1");
      }else{
        prpLclaimStatusDto.setNodeType("certa");
        prpLclaimStatusDto.setStatus(statusTemp);
      }
*/
      prpLclaimStatusDto.setTypeFlag(prpLverifyLossDto.getLossItemCode());
      prpLclaimStatusDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLverifyLossDto.getLossItemCode())));
      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��������
      prpLclaimStatusDto.setHandlerCode(user.getUserCode());
      prpLclaimStatusDto.setInputDate(new DateTime(new Date(),DateTime.YEAR_TO_DAY));
      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      certainLossDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
      return certainLossDto;
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
   public abstract CertainLossDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception;

   /**
    * ��д����ҳ�漰��ѯ����request������.
    * ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
    * @param httpServletRequest ���ظ�ҳ���request
    * @param certainLossDto ȡ���ĳ�ʼ����ϢDto
    * @throws Exception
    */
    public abstract void dtoToView(HttpServletRequest httpServletRequest, CertainLossDto certainLossDto) throws Exception;

 }
