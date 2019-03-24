package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 自动查勘类
 */
public class UIMedicalAutoCheckSubViewHelper {
	/**
	 * 自动查勘逻辑
	 * @param prpLinterRequestDto
	 * @return
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoCheck (PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		CheckDto checkDto = new CheckDto();
		PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = 
			prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
		
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
				prpLinterRequestDto.getPolicyno(),
				prpLinterRequestDto.getDamageStartDate().toString(), 
				prpLinterRequestDto.getDamageStartHour());
		String riskCode = policyDto.getPrpCmainDto().getRiskCode();
		UserDto user = new UserDto();
		String compeUser = prpLinterRequestDto.getCompeUser();
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
		PrpDuserDto prpDuserDto = blPrpDuserFacade.findByPrimaryKey(compeUser);
		String compeName = "";
		if(prpDuserDto!=null){
			compeName = prpDuserDto.getUserName();
		}
		user.setUserCode(compeUser);
		user.setUserName(compeName);
		user.setComCode(prpLinterRequestDto.getMakeCom());
		user.setComName(prpLinterRequestDto.getMakeComName());
		
		try{
			UICheckAction uiCheckAction = new UICheckAction();
			
			PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
			prpLcheckDto.setRegistNo(prpLinterRequestDto.getRelationRegistNo());
			prpLcheckDto.setRiskCode(riskCode);
			prpLcheckDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
			String repeatInsureFlag = prpLinterRequestDto.getThirdComFlag();
			if(prpLinterRequestDto.getThirdComFlag() != null){
				repeatInsureFlag = "-";
			}
			prpLcheckDto.setRepeatInsureFlag(repeatInsureFlag);
			prpLcheckDto.setCheckType(prpLinterRequestDto.getCheckType());
			prpLcheckDto.setCheckDate(prpLinterRequestDto.getCheckDate());
			prpLcheckDto.setEstimateLoss(prpLinterRequestDto.getCheckEstimateLoss());
			prpLcheckDto.setEstimateFee(prpLinterRequestDto.getEstimateFee());
			prpLcheckDto.setCheckNature(prpLinterRequestDto.getCheckNature());
			prpLcheckDto.setDamageCode(prpLinterRequestDto.getDamageCode());
			prpLcheckDto.setDamageAddress(prpLinterRequestDto.getDamageAddress());
			prpLcheckDto.setCheckSite(prpLinterRequestDto.getCheckSite());
			prpLcheckDto.setRemark(prpLinterRequestDto.getRemark());
			String damageCode = prpLinterRequestDto.getDamageCode();
	        String damageName = new UICodeAction().translateCodeCode("DamageCode", damageCode, true);
			prpLcheckDto.setDamageName(damageName);
			prpLcheckDto.setHandleUnitCode(prpLinterRequestDto.getMakeCom());
			prpLcheckDto.setHandleUnit(prpLinterRequestDto.getMakeComName());
			prpLcheckDto.setReferSerialNo(1);
			prpLcheckDto.setUnitType(prpLinterRequestDto.getUnitType());
			prpLcheckDto.setChecker1(prpLinterRequestDto.getNextHandlerName());
			checkDto.setPrpLcheckDto(prpLcheckDto);
			
			PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
			prpLclaimStatusDto.setBusinessNo(prpLinterRequestDto.getRelationRegistNo());
			prpLclaimStatusDto.setRiskCode(riskCode);
			prpLclaimStatusDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
			prpLclaimStatusDto.setOperateDate(new DateTime(prpLinterRequestDto.getCompeTime(),DateTime.YEAR_TO_DAY));
			prpLclaimStatusDto.setHandlerCode(compeUser);
			prpLclaimStatusDto.setInputDate(new DateTime(prpLinterRequestDto.getCompeTime(),DateTime.YEAR_TO_DAY));
			prpLclaimStatusDto.setNodeType("check");
			prpLclaimStatusDto.setStatus("4");
			checkDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
			
			String registNo = prpLinterRequestDto.getRelationRegistNo();
			Collection collection = new UIWorkFlowAction().findNodesByConditions(" registno='"+registNo+"' and nodetype='check' and nodestatus='0' ");
			if(collection == null || collection.size()<1){
				throw new Exception("不存在查勘节点");
			}
//			collection.iterator().next();
			SwfLogDto swflogDto = (SwfLogDto)collection.iterator().next();
			swflogDto.setNextBusinessNo(prpLinterRequestDto.getRelationRegistNo());
			swflogDto.setKeyIn(prpLinterRequestDto.getRelationRegistNo());
	        swflogDto.setKeyOut(prpLinterRequestDto.getRelationRegistNo());
	        
			swflogDto.setNodeStatus("4");//设置大病系统的标志字段为1，不为不是大病系统的数据
			//回访是查勘提交过来的回访,没有typeflag的值,1表示查勘回访，2表示定损回访,此处同正常案件的提交赋值
			swflogDto.setTypeFlag("1");
			
			ArrayList<SwfLogDto> swflogList = new ArrayList<SwfLogDto>();
			SwfLogDto nextSwflog = new SwfLogDto();
			nextSwflog.setHandlerCode(user.getUserCode());
			nextSwflog.setHandlerName(user.getUserName());
			if(riskCode!=null&&"2606".equals(riskCode)){
			   nextSwflog.setNodeType("certi");
			}else{
			   nextSwflog.setNodeType("claim");
			}
			swflogList.add(nextSwflog);
			
			if (swflogList.size() >0){
				swflogDto.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
				swflogDto.setSwfLogList(swflogList);
		    }
			
			String sqlCheck = " Update swflog Set  submittime='"+prpLinterRequestDto.getCompeTime()
	                                           +"' Where registno ='"+registNo+"' and nodeType ='check'";
            String sqlClaim = " Update swflog Set Flowintime='"+prpLinterRequestDto.getCompeTime()
                                               +"',handletime='"+prpLinterRequestDto.getCompeTime()
                                               +"' Where registno ='"+registNo+"' and nodeType ='claim'";
			
			//记录流程轨迹表-查勘环节成功标志
			prplinterAutoClaimDetailDto.setCheckSuccFlag("1");
			prplinterAutoClaimDetailDto.setRemark("查勘成功："+registNo);
			new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			
			CertainLossDto CertainLossDto = new CertainLossDto();
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			WorkFlowDto workFlowDto =workFlowViewHelper.viewToDto(user,swflogDto);
			/*********************************add 大病系统标志medicaltransitflag************************************/
			Collection submitSwfLogDtoList = workFlowDto.getSubmitSwfLogDtoList();
			Iterator iter = submitSwfLogDtoList.iterator();
			ArrayList submitListTemp = new ArrayList();
			while(iter.hasNext()){
				SwfLogDto swfLogDto = (SwfLogDto)iter.next();
				swfLogDto.setMedicalTransitFlag("1");
				submitListTemp.add(swfLogDto);
			}
			workFlowDto.setSubmitSwfLogDtoList(submitListTemp);
			SwfLogDto updateSwfLogDto = workFlowDto.getUpdateSwfLogDto();
			updateSwfLogDto.setMedicalTransitFlag("1");
			workFlowDto.setUpdateSwfLogDto(updateSwfLogDto);
			/*****************************************************************************/
			uiCheckAction.save(checkDto, CertainLossDto,workFlowDto);
			
			new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlCheck);
			new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlClaim);
		}catch (Exception e) {
			prplinterAutoClaimDetailDto.setCheckSuccFlag("0");
			String messege = e.toString();
			if(messege!=null&&messege.length()>1000){
				messege = messege.substring(0,1000);
			}
			prplinterAutoClaimDetailDto.setRemark("查勘失败："+messege);
			new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			e.printStackTrace();
			//出险异常后如果是最新创建的报案号码，需要放回号码
			//this.putNoback(prpLinterRequestDto.getRelationRegistNo());
			throw e;
		}
		return prpLinterRequestDto;
	}
}
