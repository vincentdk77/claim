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
 * <p>Description:核损ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */ 
 public abstract class VerifyLossViewHelper
 {
   /**
    * 默认构造方法
    */
    public VerifyLossViewHelper()
    {
    }

   /**
    * 保存核损时核损页面数据整理.
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
    * @param httpServletRequest
    * @return stepFlag 标志
    * @throws Exception
    */
    public VerifyLossDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      String lossType = httpServletRequest.getParameter("lossTypeFlag");
      String nodeType = httpServletRequest.getParameter("nodeType");
      
      VerifyLossDto verifyLossDto = new VerifyLossDto();
      
      /*---------------------核损主表 PrpLverifyLoss------------------------------------*/
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
      //Reason:在核损页面增加核损意见选项
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
      
      //定损偏差率  
      double prpLverifyLossFirstDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossFirstDefLoss")));      
      double prpLverifyLossWarpDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossWarpDefLoss")));
      prpLverifyLossDto.setFirstDefLoss(prpLverifyLossFirstDefLoss);
      prpLverifyLossDto.setWarpDefLoss(prpLverifyLossWarpDefLoss);
      //当提交时表示核损通过underWriteFlag的状态位为1,表示通过
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
      //reason: 增加保存理算退回的定损的原有数据的保存,若有数据不会被保存冲掉
      prpLverifyLossDto.setCompensateApproverCode( httpServletRequest.getParameter("prpLverifyLossCompensateApproverCode"));
      prpLverifyLossDto.setCompensateBackDate( new DateTime((String)httpServletRequest.getParameter("prpLverifyLossCompensateBackDate"),DateTime.YEAR_TO_DAY ));
      prpLverifyLossDto.setCompensateFlag( httpServletRequest.getParameter("prpLverifyLossCompensateFlag"));
      prpLverifyLossDto.setCompensateOpinion( httpServletRequest.getParameter("prpLverifyLossCompensateOpinion"));
      //add by lixiang end at 2006-04-21
      //add by wunier 20080103
      //reason:农险改造添加新字段
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

      /*---------------------状态内容prpLclaimStatus------------------------------------*/
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
      //取得当前用户信息，写操作员信息到核损中
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
    * 取初始化信息需要的数据的整理.
    * 填写核损单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
    * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
    * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
    * @param httpServletRequest
    * @return RequestDto 取初始化信息需要的数据
    * @throws Exception
    */  
   public abstract VerifyLossDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception;
 
   /**
    * 填写核损页面及查询核损request的生成.
    * 填写核损时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
    * @param httpServletRequest 返回给页面的request
    * @param verifyLossDto 取出的初始化信息Dto
    * @throws Exception
    */
    public abstract void dtoToView(HttpServletRequest httpServletRequest, VerifyLossDto verifyLossDto) throws Exception;

 }
