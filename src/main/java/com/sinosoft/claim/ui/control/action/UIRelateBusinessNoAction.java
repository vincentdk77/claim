package com.sinosoft.claim.ui.control.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RelateBusinessNoDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.util.BusinessRuleUtil;
;

/**
 * 查询关联页面相关业务号
 * <p>Title: 查询关联页面相关业务号</p>
 * <p>Description: 查询关联页面相关业务号</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft</p>
 * @author Sunhao
 * @version 1.0
 */
public class UIRelateBusinessNoAction {
  public UIRelateBusinessNoAction() {
  }
  
  /**
   * 用于根据业务号得到和此业务号相关的业务号 add by qinyongli 2005-9-14
   * @param bussinessNo
   * @return
   * @throws Exception
   */
  public ArrayList getRelateBusinessNo(String bussinessNo)throws Exception{
  	   ArrayList relateBusinessDtoList = new ArrayList();
  	   ArrayList relateBusinessNoList = new ArrayList();
  	   SwfLogDto swfLogDto = new SwfLogDto();
  	   String businessNo = "";
  	   //首先根据业务号得到工作流号，然后，跟据工作流号得到所有的相关业务号
  	   UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
  	   relateBusinessDtoList =(ArrayList)uiWorkFlowAction.findFlowLogByBuessionNo(bussinessNo);
  	   Iterator iterator = relateBusinessDtoList.iterator();
  	   
  	   while(iterator.hasNext()){
  	         swfLogDto =(SwfLogDto)iterator.next();
  	         relateBusinessNoList.add(swfLogDto.getBusinessNo());
  	   }
  	   return relateBusinessNoList;
  }
  
  
/**
 * 关联页面查询方法
 * @param policyNo String  保单号
 * @param registNo String  报案号
 * @param claimNo String   赔案号
 * @param compensateNo String  赔款计算书号
 * @throws Exception
 * @return Object
 */
    public RelateBusinessNoDto queryRelateInfo(HttpServletRequest httpServletRequest,String policyNo)
       throws Exception
    { 
      
      String policyNoList = "";
      String registNoList = "";
      String scheduleNoList = "";
      String checkNoList = "";
      String certainLossNoList = "";
      String verifyLossNoList = "";
      String claimNoList = "";
      String certifyNoList = "";
      String prepayNoList = "";
      String compensateNoList = "";
      String endcaseNoList = "";

      String certifyCondition = "";

      String conditions = "";
      Collection collection = new ArrayList();
      Iterator iterator = null;
      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
      Collection swflogDtoList = null;
      

      conditions = " PolicyNo='" + policyNo + "'";
      UIRegistAction uiRegistAction = new UIRegistAction();
      collection   = (Collection)uiRegistAction.findByConditions(conditions) ;
      iterator = collection.iterator();
      while(iterator.hasNext()){
        PrpLregistDto prpLregistDto = (PrpLregistDto)iterator.next();
        registNoList = registNoList + prpLregistDto.getRegistNo()+",";
        certifyCondition = certifyCondition + "'"+prpLregistDto.getRegistNo()+"',";
      }

      //取得调度号码
      conditions = " PolicyNo='" + policyNo + "'";
      UIScheduleAction uiScheduleAction = new UIScheduleAction();
      collection   = (Collection)uiScheduleAction.findByConditions(conditions) ;
      iterator = collection.iterator();
      while(iterator.hasNext()){
        PrpLscheduleMainWFDto prpLscheduleMainWFDto = (PrpLscheduleMainWFDto)iterator.next();
        scheduleNoList = scheduleNoList + prpLscheduleMainWFDto.getRegistNo()+",";
      }

      //取得查勘号码
      conditions = " PolicyNo='" + policyNo + "'";
      UICheckAction uiCheckAction = new UICheckAction();
      collection   = (Collection)uiCheckAction.findByConditions(conditions) ;
      iterator = collection.iterator();
      while(iterator.hasNext()){
        PrpLcheckDto prpLcheckDto = (PrpLcheckDto)iterator.next();
        checkNoList = checkNoList + prpLcheckDto.getRegistNo()+",";
      } 

      //取得定损号码
      conditions = " PolicyNo='" + policyNo + "'";
      UICertainLossAction uiCertainLossAction = new UICertainLossAction();
      collection   = (Collection)uiCertainLossAction.findByConditions(conditions) ;
      iterator = collection.iterator();
      while(iterator.hasNext()){     
        PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto)iterator.next(); 
        certainLossNoList = certainLossNoList + prpLverifyLossDto.getLossItemCode()+"|"+prpLverifyLossDto.getRegistNo()+",";
      } 

      //取得核损号码
      conditions = " PolicyNo='" + policyNo + "'";
      UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
      collection   = (Collection)uiVerifyLossAction.findByConditions(conditions) ;
      iterator = collection.iterator();
      while(iterator.hasNext()){
        PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto)iterator.next();
        verifyLossNoList = verifyLossNoList + prpLverifyLossDto.getLossItemCode()+"|"+prpLverifyLossDto.getRegistNo()+",";
      } 

      //取得赔案号码
      conditions = " PolicyNo='" + policyNo + "'";
      UIClaimAction uiClaimAction = new UIClaimAction();
      collection   = (Collection)uiClaimAction.findByConditions(conditions) ;
      iterator = collection.iterator();
      while(iterator.hasNext()){
        PrpLclaimDto prpLclaimDto = (PrpLclaimDto)iterator.next();
        claimNoList = claimNoList + prpLclaimDto.getClaimNo()+",";
      }
 
      //取得单证号码
      if(certifyCondition.trim().length()>0){
        conditions = " BusinessNo in (" + certifyCondition.substring(0,(certifyCondition.length()-1)) + ")";
        UICertifyAction uiCertifyAction = new UICertifyAction();
        collection   = (Collection)uiCertifyAction.findByConditions(conditions) ;
        iterator = collection.iterator();
        while(iterator.hasNext()){
          PrpLcertifyCollectDto prpLcertifyCollectDto = (PrpLcertifyCollectDto)iterator.next();
          certifyNoList = certifyNoList + prpLcertifyCollectDto.getBusinessNo()+",";
        }
      }
      //取得预赔号码
      conditions = " PolicyNo='" + policyNo + "'";
      UIPrepayAction uiPrepayAction = new UIPrepayAction();
      collection   = (Collection)uiPrepayAction.findByConditions(conditions) ;
      iterator = collection.iterator();
      while(iterator.hasNext()){
        PrpLprepayDto prpLprepayDto = (PrpLprepayDto)iterator.next();
        prepayNoList = prepayNoList + prpLprepayDto.getPreCompensateNo()+",";
      }

      //取得实赔号码
      conditions = " PolicyNo='" + policyNo + "'";
      UICompensateAction uiCompensateAction = new UICompensateAction();
      collection   = (Collection)uiCompensateAction.findByConditions(conditions) ;
      iterator = collection.iterator();
      while(iterator.hasNext()){
        PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)iterator.next();
        compensateNoList = compensateNoList + prpLcompensateDto.getCompensateNo()+",";
      }

      //取得结案号码
      conditions = " PolicyNo='" + policyNo + "' and endCaserCode is not null and endCaseDate is not null";
      collection   = (Collection)uiClaimAction.findByConditions(conditions) ;
      iterator = collection.iterator();
      while(iterator.hasNext()){
        PrpLclaimDto prpLclaimDto = (PrpLclaimDto)iterator.next();
        endcaseNoList = endcaseNoList + prpLclaimDto.getCaseNo()+",";
      }
      
     
      
      
      //取得险种
      UIPolicyAction uiPolicyAction = new UIPolicyAction();
      PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
      String strRiskCode = policyDto.getPrpCmainDto().getRiskCode();
      
      
      //add by lixiang start at 2005-12-28
      //reason: 增加调查类型的查询 目前认为是E类的会有调查
      if ((BusinessRuleUtil.getOuterCode(httpServletRequest, "E")).equals( policyDto.getPrpCmainDto().getClassCode() )){
      	
      }
      //add by lixiang start at 2005-12-28

      RelateBusinessNoDto relateBusinessNoDto = new RelateBusinessNoDto();
      relateBusinessNoDto.setPolicyNo(policyNo) ;
      relateBusinessNoDto.setRegistNo(registNoList) ;
      relateBusinessNoDto.setCheckNo(checkNoList) ;
      relateBusinessNoDto.setCertainLossNo(certainLossNoList) ;
      relateBusinessNoDto.setVerifyLossNo(verifyLossNoList) ;
      relateBusinessNoDto.setClaimNo(claimNoList) ;
      relateBusinessNoDto.setCertifyNo(certifyNoList) ;
      relateBusinessNoDto.setPrepayNo(prepayNoList) ;
      relateBusinessNoDto.setCompensateNo(compensateNoList) ;
      relateBusinessNoDto.setEndcaseNo(endcaseNoList) ; 
      relateBusinessNoDto.setScheduleNo(scheduleNoList) ;
      relateBusinessNoDto.setRiskCode(strRiskCode);
     
      return relateBusinessNoDto;
   }

}
