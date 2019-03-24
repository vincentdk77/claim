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
 * <p>Description:定损ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */ 
 public abstract class CertainLossViewHelper
 { 
   /** 
    * 默认构造方法
    */
    public CertainLossViewHelper()
    {    
    }   
   
   /**
    * 保存定损时定损页面数据整理.
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
    * @param httpServletRequest
    * @return stepFlag 标志
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
      /*---------------------定损主表 PrpLverifyLoss------------------------------------*/
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
 
      //定损偏差率
      double prpLverifyLossFirstDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossFirstDefLoss")));      
      double prpLverifyLossWarpDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossWarpDefLoss")));
      if(prpLverifyLossFirstDefLoss<=0){
      	prpLverifyLossFirstDefLoss=prpLverifyLossWarpDefLoss;
      }   
      prpLverifyLossDto.setFirstDefLoss(prpLverifyLossFirstDefLoss);
      prpLverifyLossDto.setWarpDefLoss(prpLverifyLossFirstDefLoss);
      certainLossDto.setPrpLverifyLossDto(prpLverifyLossDto);
      //每次改动的时候，把改动人，改动时间，改动的金额，写到swfnotion表里
    	ArrayList notionList = new ArrayList();

        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction ();
      int maxLineNo=uiWorkFlowAction.getSwfNotionMaxLineNo(httpServletRequest.getParameter("swfLogFlowID"),Integer.parseInt(DataUtils.nullToZero(httpServletRequest.getParameter("swfLogLogNo")) ));    	
      if(prpLverifyLossFirstDefLoss!=prpLverifyLossWarpDefLoss){
      	SwfNotionDto swfNotionDto = new SwfNotionDto();
      	swfNotionDto.setFlowID(httpServletRequest.getParameter("swfLogFlowID"));
      	swfNotionDto.setLogNo(Integer.parseInt(DataUtils.nullToZero(httpServletRequest.getParameter("swfLogLogNo")) ));
      	swfNotionDto.setLineNo(maxLineNo); 
      	swfNotionDto.setHandleText(user.getUserName()+"在"+new DateTime(new Date(),DateTime.YEAR_TO_DAY)+"修改了定损金额:"+prpLverifyLossWarpDefLoss+"元");
      	notionList.add(swfNotionDto);
      } 
      certainLossDto.setSwfNotionList(notionList);
      //如果定损金额为某一值时，算核损通过 
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

      /*---------------------状态内容prpLclaimStatus------------------------------------*/
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
      //取得当前用户信息，写操作员信息到定损中
      prpLclaimStatusDto.setHandlerCode(user.getUserCode());
      prpLclaimStatusDto.setInputDate(new DateTime(new Date(),DateTime.YEAR_TO_DAY));
      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      certainLossDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
      return certainLossDto;
    }

   /**
    * 取初始化信息需要的数据的整理.
    * 填写定损单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
    * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
    * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
    * @param httpServletRequest
    * @return RequestDto 取初始化信息需要的数据
    * @throws Exception
    */
   public abstract CertainLossDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception;

   /**
    * 填写定损页面及查询定损request的生成.
    * 填写定损时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
    * @param httpServletRequest 返回给页面的request
    * @param certainLossDto 取出的初始化信息Dto
    * @throws Exception
    */
    public abstract void dtoToView(HttpServletRequest httpServletRequest, CertainLossDto certainLossDto) throws Exception;

 }
