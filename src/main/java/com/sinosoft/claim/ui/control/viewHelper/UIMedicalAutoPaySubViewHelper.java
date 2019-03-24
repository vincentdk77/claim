package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayDetailHisAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayRequestAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterRecaseDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterRecaseRequestAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayExtAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayHisAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpaymainAction;
import com.sinosoft.claim.bl.action.domain.BLPrplpayAction;
import com.sinosoft.claim.bl.facade.BLPrpLinterGetPaymentShowFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailHisDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayExtDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentShowDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.claim.dto.domain.PrpLpayHisDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowApprovalInterFaceFacade;
import com.sinosoft.function.insutil.bl.action.custom.BLBillAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 三方支付自动申请类
 * */
public class UIMedicalAutoPaySubViewHelper {
	private String hisPaymentNo = "";
	private String classCode = "";
	/**
	 * 自动申请逻辑
	 * @param prpLinterPayRequestDto
	 * @return prpLinterPayRequestDto
	 * @throws Exception
	 * */
	public PrpLinterPayRequestDto autoPay(PrpLinterPayRequestDto prpLinterPayRequestDto) throws Exception{
		//组装user对象，方便后续使用
		UserDto user = new UserDto();
		user.setUserCode(prpLinterPayRequestDto.getOperatorCode());
		user.setUserName(prpLinterPayRequestDto.getOperatorName());
		user.setComCode(prpLinterPayRequestDto.getMakeCom());
		user.setComName(prpLinterPayRequestDto.getMakeComName());
		BLBillAction uiBillAction = new BLBillAction();
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		BLPrplpayAction  blPrplpayAction = new BLPrplpayAction ();
		BLPrpLinterPayRequestAction blPrpLinterPayRequestAction = new BLPrpLinterPayRequestAction();
		DBManager dbManager = new DBManager();
		PrpLpaymainDto prpLpaymainDto = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();
			
			String paymentNo = uiBillAction.getNo(dbManager,"prplpaymain", "2801",
					user.getComCode(), new DateTime(DateTime.current().toString()).getYear(),"");
			prpLinterPayRequestDto.setPaymentNo(paymentNo);
			
			blPrpLpaymainAction.delete(dbManager, paymentNo);
			prpLpaymainDto = this.getPrpLpaymainDto(dbManager,prpLinterPayRequestDto,paymentNo,user);
			//支付主表保存接口类型
			prpLpaymainDto.setInterType(prpLinterPayRequestDto.getSeriousInterType());
			blPrpLpaymainAction.insert(dbManager, prpLpaymainDto);
			blPrplpayAction.deleteByConditions(dbManager, " serialno='"+paymentNo+"' ");
			
			this.savePrpLpay(dbManager, prpLinterPayRequestDto, paymentNo, user);
			this.savePrpLpayExt(dbManager, prpLinterPayRequestDto, paymentNo, user);
			
			//记录流程轨迹表
			PrpLinterPayDetailDto prpLinterPayDetailDto = new PrpLinterPayDetailDto();
			prpLinterPayDetailDto.setId(prpLinterPayRequestDto.getId());
			prpLinterPayDetailDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
			prpLinterPayDetailDto.setOutId(prpLinterPayRequestDto.getOutId());
			prpLinterPayDetailDto.setPaymentNo(paymentNo);
			prpLinterPayDetailDto.setPaySuccFlag("1");
			prpLinterPayRequestDto.setPrpLinterPayDetailDto(prpLinterPayDetailDto);
			BLPrpLinterPayDetailAction blPrpLinterPayDetailAction = new BLPrpLinterPayDetailAction();
			if("U".equals(prpLinterPayRequestDto.getOperateType())){
				Collection collection = blPrpLinterPayDetailAction.findByConditions(dbManager," outId='"+prpLinterPayRequestDto.getOutId()+"' ");
				if(collection==null || collection.size()<1){
					throw new Exception("无相关支付信息，无法更新");
				}
				PrpLinterPayDetailDto prpLinterPayDetailHis = (PrpLinterPayDetailDto)collection.iterator().next();
				PrpLinterPayDetailHisDto prpLinterPayDetailHisDto = new PrpLinterPayDetailHisDto();
				prpLinterPayDetailHisDto.setId(prpLinterPayDetailHis.getId());
				prpLinterPayDetailHisDto.setInputDate(prpLinterPayDetailHis.getInputDate());
				prpLinterPayDetailHisDto.setOutId(prpLinterPayDetailHis.getOutId());
				prpLinterPayDetailHisDto.setPaymentNo(prpLinterPayDetailHis.getPaymentNo());
				prpLinterPayDetailHisDto.setPaySuccFlag(prpLinterPayDetailHis.getPaySuccFlag());
				prpLinterPayDetailHisDto.setVericSuccFlag(prpLinterPayDetailHis.getVericSuccFlag());
				BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
				blPrpLinterPayDetailHisAction.insert(dbManager, prpLinterPayDetailHisDto);
				blPrpLinterPayDetailAction.deleteByConditions(dbManager, " outId='"+prpLinterPayRequestDto.getOutId()+"' and paymentNo='"+hisPaymentNo+"' ");
				//只有更新时 删除原支付信息
				blPrpLpaymainAction.delete(dbManager, hisPaymentNo);
			}
			blPrpLinterPayDetailAction.insert(dbManager, prpLinterPayDetailDto);
			prpLinterPayRequestDto.setAutoFlag("1");
			blPrpLinterPayRequestAction.update(dbManager, prpLinterPayRequestDto);
			dbManager.commitTransaction();
			
			UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
			//支付信息提交双核
			String UWflowID = uiWorkFlowApprovalInterFaceFacade
			                      .submitApprovalPlatform("VeriPay", "00","00",paymentNo, "2801", 
			                    		  classCode, user.getComCode(), user.getUserCode(),
			                    		  user.getComCode(), user.getUserCode(), user.getUserCode(), paymentNo);
			if (UWflowID.length() < 15) {
				String msg = "案件'"+ paymentNo+ "'提交双核系统失败，请重新提交或者与管理员联系!";
				blPrpLpaymainAction.delete(dbManager, paymentNo);
				blPrplpayAction.deleteByConditions(dbManager, " serialno='"+paymentNo+"' ");
				new BLPrpLpayExtAction().deleteByConditions(dbManager, " paymentNo='"+paymentNo+"' ");
				throw new Exception(msg);
			}
			
			dbManager.commitTransaction();
		} catch (Exception e) {
			dbManager.rollbackTransaction();
			e.printStackTrace();
			throw e;
		} finally{
		    dbManager.close();
		}
		return prpLinterPayRequestDto;
	}
	
	/**
	 * 若为一般案件，通过此方法获得报案号、保单号、立案号、计算书号等
	 * 
	 * */
	public Collection getPrpLinterPaymentShowDto(String outId) throws Exception{
		BLPrpLinterGetPaymentShowFacade blPrpLinterGetPaymentShowFacade = new BLPrpLinterGetPaymentShowFacade();
		Collection collection = blPrpLinterGetPaymentShowFacade.findByConditions(" and rl.outid='"+outId+"' ");
		return collection;
	}
	
	public void setPrpLpayTransPrpLpayHis(PrplpayDto prplpayDto,PrpLpayHisDto prpLpayHisDto,String receiverTypeOtherName){
		prpLpayHisDto.setAccountType(prplpayDto.getAccounttype());
		prpLpayHisDto.setAddress(prplpayDto.getAddress());
		prpLpayHisDto.setBank(prplpayDto.getBank());
		prpLpayHisDto.setBankAccount(prplpayDto.getBankaccount());
		prpLpayHisDto.setBankType(prplpayDto.getBanktype());
		prpLpayHisDto.setBankSite(prplpayDto.getBanksite());
		prpLpayHisDto.setCertifNo(prplpayDto.getCertifno());
		prpLpayHisDto.setCertifType(prplpayDto.getCertiftype());
		prpLpayHisDto.setClaimNo(prplpayDto.getClaimno());
		prpLpayHisDto.setClassCode(prplpayDto.getClasscode());
		prpLpayHisDto.setComCode(prplpayDto.getComCode());
		prpLpayHisDto.setCompensateNo(prplpayDto.getCompensateno());
		prpLpayHisDto.setFamilyPhone(prplpayDto.getFamilyphone());
		prpLpayHisDto.setInputDate(prplpayDto.getInputdate());
		prpLpayHisDto.setMobilePhone(prplpayDto.getMobilephone());
		prpLpayHisDto.setNode(prplpayDto.getNode());
		prpLpayHisDto.setOfficePhone(prplpayDto.getOfficephone());
		prpLpayHisDto.setOperatorCode(prplpayDto.getOperatorcode());
		prpLpayHisDto.setPayAmount(prplpayDto.getPayamount());
		prpLpayHisDto.setPayCode(prplpayDto.getPaycode());
		prpLpayHisDto.setPayDate(prplpayDto.getPaydate());
		prpLpayHisDto.setPayFlag(prplpayDto.getPayflag());
		prpLpayHisDto.setPaymentType(prplpayDto.getPaymenttype());
		prpLpayHisDto.setPayreMark(prplpayDto.getPayremark());
		prpLpayHisDto.setPayType(prplpayDto.getPaytype());
		prpLpayHisDto.setPolicyNo(prplpayDto.getPolicyno());
		prpLpayHisDto.setReceiverFullName(prplpayDto.getReceiverfullname());
		prpLpayHisDto.setReceiverType(prplpayDto.getReceivertype());
		prpLpayHisDto.setRegistNo(prplpayDto.getRegistno());
		prpLpayHisDto.setRiskCode(prplpayDto.getRiskcode());
		prpLpayHisDto.setSerialNo(prplpayDto.getSerialno());
		prpLpayHisDto.setSerialNo2(prplpayDto.getSerialNo2());
		prpLpayHisDto.setUploadSerialno(prplpayDto.getUploadserialno());
		prpLpayHisDto.setVflag(prplpayDto.getVFlag());
		prpLpayHisDto.setOperatorComCode(prplpayDto.getOperatorComCode());
		prpLpayHisDto.setReceivertypeothername(receiverTypeOtherName);
	}
	
	public PrpLpaymainDto getPrpLpaymainDto(DBManager dbManager,PrpLinterPayRequestDto prpLinterPayRequestDto,String paymentNo,UserDto user) throws Exception{
		PrpLpaymainDto prpLpaymainDto = new PrpLpaymainDto();
		if("A".equals(prpLinterPayRequestDto.getOperateType())){
			prpLpaymainDto = new PrpLpaymainDto();
			
			prpLpaymainDto.setPaymentNo(paymentNo);
			prpLpaymainDto.setPayType("P3");
			PrpLinterPaymentInfoDto[] prpLinterPaymentInfoDtos = prpLinterPayRequestDto.getPrpLinterPaymentInfoDto();
			prpLpaymainDto.setPaymentType(prpLinterPaymentInfoDtos[0].getPaymentType());
			double payAmount = 0.0;
			for(int i=0;i<prpLinterPaymentInfoDtos.length;i++){
				if(prpLinterPaymentInfoDtos[i]!=null){
					payAmount += prpLinterPaymentInfoDtos[i].getPaidPay();
				}
			}
			prpLpaymainDto.setPayAmount(payAmount);
			prpLpaymainDto.setUrgentType(prpLinterPayRequestDto.getUrgentType());
			prpLpaymainDto.setReceiverTypeOther(prpLinterPayRequestDto.getReceiverTypeOther());
			prpLpaymainDto.setReceiverTypeOtherName(prpLinterPayRequestDto.getReceiverTypeOtherName());
			prpLpaymainDto.setReceiverFullName(prpLinterPayRequestDto.getReceiverFullName());
//	prpLpaymainDto.setReceiverFullCode(receiverFullCode);
			prpLpaymainDto.setCertifNo(prpLinterPayRequestDto.getCertifNo());
			prpLpaymainDto.setCertifType(prpLinterPayRequestDto.getCertifType());
			prpLpaymainDto.setProvinceCode(prpLinterPayRequestDto.getProvinceCode());
			prpLpaymainDto.setCityCode(prpLinterPayRequestDto.getCityCode());
			prpLpaymainDto.setAccountType(prpLinterPayRequestDto.getAccountType());
			prpLpaymainDto.setBankType(prpLinterPayRequestDto.getBankType());
			prpLpaymainDto.setBank(prpLinterPayRequestDto.getBank());
			prpLpaymainDto.setBankAccount(prpLinterPayRequestDto.getBankAccount());
			prpLpaymainDto.setFamilyPhone(prpLinterPayRequestDto.getFamilyPhone());
			prpLpaymainDto.setOfficePhone(prpLinterPayRequestDto.getOfficePhone());
			prpLpaymainDto.setMobilePhone(prpLinterPayRequestDto.getMobilePhone());
			prpLpaymainDto.setAddress(prpLinterPayRequestDto.getAddress());
			prpLpaymainDto.setQqNumber(prpLinterPayRequestDto.getQqNumber());
			prpLpaymainDto.setEmail(prpLinterPayRequestDto.getEmail());
			prpLpaymainDto.setUnitLink(prpLinterPayRequestDto.getUnitLink());
			prpLpaymainDto.setPostCode(prpLinterPayRequestDto.getPostCode());
			prpLpaymainDto.setNode("apay");
			prpLpaymainDto.setVflag("6");//保存任务状态
			prpLpaymainDto.setMergerFlag("1");//合并下发标志
			prpLpaymainDto.setComCode(prpLinterPayRequestDto.getMakeCom());//一般是承保机构
			prpLpaymainDto.setOperatorCode(user.getUserCode());
			//prpLpaymainDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
			prpLpaymainDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
			//赔款增加新增第三方支付标识
			prpLpaymainDto.setThirdPayFlag("1");//提交 待审核
			prpLpaymainDto.setPayWay(prpLinterPayRequestDto.getPayWay());//支付方式
			prpLpaymainDto.setPayReason(prpLinterPayRequestDto.getPayReason());//支付原因
			prpLpaymainDto.setPayPurpose(prpLinterPayRequestDto.getPayPurpose());//用途说明
//			账号类型，等支付那边代码上线再去掉注释
			prpLpaymainDto.setAccountFlag(prpLinterPayRequestDto.getAccountFlag());
		}
		if("U".equals(prpLinterPayRequestDto.getOperateType())){
			prpLpaymainDto = new PrpLpaymainDto();
			BLPrpLinterPayDetailAction blPrpLinterPayDetailAction = new BLPrpLinterPayDetailAction();
			
			Collection collection = blPrpLinterPayDetailAction.findByConditions(dbManager," outId='"+prpLinterPayRequestDto.getOutId()+"' ");
			if(collection==null || collection.size()<1){
				throw new Exception("无相关支付信息，无法更新");
			}
			PrpLinterPayDetailDto prpLinterPayDetailDto = (PrpLinterPayDetailDto)collection.iterator().next();
			hisPaymentNo = prpLinterPayDetailDto.getPaymentNo();
			//判断是否为退回状态，如果不是退回则不允许操作
			BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
			PrpLpaymainDto prpLpaymainDtoHis =blPrpLpaymainAction.findByPrimaryKey(dbManager, hisPaymentNo);
			if(prpLpaymainDtoHis!=null && !"4".equals(prpLpaymainDtoHis.getThirdPayFlag())){
				throw new Exception("此支付信息不是退回，无法更新");
			}
			
			prpLpaymainDto.setPaymentNo(paymentNo);
			prpLpaymainDto.setPayType("P3");
			PrpLinterPaymentInfoDto[] prpLinterPaymentInfoDtos = prpLinterPayRequestDto.getPrpLinterPaymentInfoDto();
			prpLpaymainDto.setPaymentType(prpLinterPaymentInfoDtos[0].getPaymentType());
			double payAmount = 0.0;
			for(int i=0;i<prpLinterPaymentInfoDtos.length;i++){
				if(prpLinterPaymentInfoDtos[i]!=null){
					payAmount += prpLinterPaymentInfoDtos[i].getPaidPay();
				}
			}
			prpLpaymainDto.setPayAmount(payAmount);
			prpLpaymainDto.setUrgentType(prpLinterPayRequestDto.getUrgentType());
			prpLpaymainDto.setReceiverTypeOther(prpLinterPayRequestDto.getReceiverTypeOther());
			prpLpaymainDto.setReceiverTypeOtherName(prpLinterPayRequestDto.getReceiverTypeOtherName());
			prpLpaymainDto.setReceiverFullName(prpLinterPayRequestDto.getReceiverFullName());
//	prpLpaymainDto.setReceiverFullCode(receiverFullCode);
			prpLpaymainDto.setCertifNo(prpLinterPayRequestDto.getCertifNo());
			prpLpaymainDto.setCertifType(prpLinterPayRequestDto.getCertifType());
			prpLpaymainDto.setProvinceCode(prpLinterPayRequestDto.getProvinceCode());
			prpLpaymainDto.setCityCode(prpLinterPayRequestDto.getCityCode());
			prpLpaymainDto.setAccountType(prpLinterPayRequestDto.getAccountType());
			prpLpaymainDto.setBankType(prpLinterPayRequestDto.getBankType());
			prpLpaymainDto.setBank(prpLinterPayRequestDto.getBank());
			prpLpaymainDto.setBankAccount(prpLinterPayRequestDto.getBankAccount());
			prpLpaymainDto.setFamilyPhone(prpLinterPayRequestDto.getFamilyPhone());
			prpLpaymainDto.setOfficePhone(prpLinterPayRequestDto.getOfficePhone());
			prpLpaymainDto.setMobilePhone(prpLinterPayRequestDto.getMobilePhone());
			prpLpaymainDto.setAddress(prpLinterPayRequestDto.getAddress());
			prpLpaymainDto.setQqNumber(prpLinterPayRequestDto.getQqNumber());
			prpLpaymainDto.setEmail(prpLinterPayRequestDto.getEmail());
			prpLpaymainDto.setUnitLink(prpLinterPayRequestDto.getUnitLink());
			prpLpaymainDto.setPostCode(prpLinterPayRequestDto.getPostCode());
//	prpLpaymainDto.setNode(nodeType);
			prpLpaymainDto.setVflag("6");//保存任务状态
			prpLpaymainDto.setMergerFlag("1");//合并下发标志
			prpLpaymainDto.setComCode(prpLinterPayRequestDto.getMakeCom());//一般是承保机构
			prpLpaymainDto.setOperatorCode(user.getUserCode());
			//prpLpaymainDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
			prpLpaymainDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
			//赔款增加新增第三方支付标识
			prpLpaymainDto.setThirdPayFlag("1");//提交 待审核
			prpLpaymainDto.setPayWay(prpLinterPayRequestDto.getPayWay());//支付方式
			prpLpaymainDto.setPayReason(prpLinterPayRequestDto.getPayReason());//支付原因
			prpLpaymainDto.setPayPurpose(prpLinterPayRequestDto.getPayPurpose());//用途说明
//			账号类型，等支付那边代码上线再去掉注释
			prpLpaymainDto.setAccountFlag(prpLinterPayRequestDto.getAccountFlag());
		}
		
		return prpLpaymainDto;
	}
	
	public void savePrpLpay(DBManager dbManager,PrpLinterPayRequestDto prpLinterPayRequestDto,String paymentNo,UserDto user) throws Exception{
		int k = 1;
		int j = 1;
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		BLPrplpayAction  blPrplpayAction = new BLPrplpayAction ();
		BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
		PrpLinterPaymentInfoDto[] prpLinterPaymentInfoDtos = prpLinterPayRequestDto.getPrpLinterPaymentInfoDto();
		List<PrpLinterPaymentInfoDto> listR = new ArrayList<PrpLinterPaymentInfoDto>();
		List<PrpLinterPaymentInfoDto> listN = new ArrayList<PrpLinterPaymentInfoDto>();
		for(int i=0;i<prpLinterPaymentInfoDtos.length;i++){
			if("R".equals(prpLinterPaymentInfoDtos[i].getRelationOutIdType())){
				listR.add(prpLinterPaymentInfoDtos[i]);
			}else{
				listN.add(prpLinterPaymentInfoDtos[i]);
			}
		}
		if(listR!=null && listR.size()>0){
			ArrayList<PrplpayDto> listRlpay =new ArrayList<PrplpayDto>();
			ArrayList<PrpLpayHisDto> listRlpayHis = new ArrayList<PrpLpayHisDto>();
			for(int i=0;i<listR.size();i++){
				String relationOutId = listR.get(i).getRelationOutId();
				BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
				BLPrpLinterRecaseDetailAction blPrpLinterRecaseDetailAction = new BLPrpLinterRecaseDetailAction();
				Collection recaseList = blPrpLinterRecaseRequestAction.findByConditions(dbManager," outid='"+relationOutId+"' ");
				if(recaseList==null || recaseList.size()<1){
					throw new Exception("没有相关重开案件");
				}
				PrpLinterRecaseRequestDto PrpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto)recaseList.iterator().next();
				Collection recaseDetailList = blPrpLinterRecaseDetailAction.findByConditions(dbManager," id='"+PrpLinterRecaseRequestDto.getId()+"' ");
				if(recaseDetailList==null || recaseDetailList.size()<1){
					throw new Exception("没有相关重开案件");
				}
				PrplpayDto prplpayDto=null;
				PrpLpayHisDto prpLpayHisDto = null;
				PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = (PrpLinterRecaseDetailDto)recaseDetailList.iterator().next();
				String serialNo2 = k+"";
				prplpayDto = new PrplpayDto();
				prplpayDto.setClaimno(prpLinterRecaseDetailDto.getClaimNo());
				prplpayDto.setSerialno(paymentNo);
				prplpayDto.setSerialNo2(serialNo2);
				k++;
				prplpayDto.setCompensateno(prpLinterRecaseDetailDto.getCompensateNo());
				classCode = prpLinterRecaseDetailDto.getPolicyNo().substring(1, 3);
				prplpayDto.setClasscode(classCode);
				prplpayDto.setRiskcode(prpLinterRecaseDetailDto.getPolicyNo().substring(1,5));
				prplpayDto.setRegistno(prpLinterRecaseDetailDto.getRegistNo());
				prplpayDto.setPolicyno(prpLinterRecaseDetailDto.getPolicyNo());
				
				prplpayDto.setReceivertype(prpLinterPayRequestDto.getReceiverTypeOther());
				PrpLinterPaymentInfoDto PrpLinterPaymentInfoDto = prpLinterPaymentInfoDtos[i];
				prplpayDto.setPaytype("P3");
				prplpayDto.setPayamount(PrpLinterPaymentInfoDto.getPaidPay());
				prplpayDto.setBanktype(prpLinterPayRequestDto.getBankType());
				prplpayDto.setBank(prpLinterPayRequestDto.getBank());
				prplpayDto.setAccounttype(prpLinterPayRequestDto.getAccountType());
				prplpayDto.setReceiverfullname(prpLinterPayRequestDto.getReceiverFullName());
				prplpayDto.setCertiftype(prpLinterPayRequestDto.getCertifType());
				prplpayDto.setAddress(prpLinterPayRequestDto.getAddress());
				prplpayDto.setCertifno(prpLinterPayRequestDto.getCertifNo());
				prplpayDto.setFamilyphone(prpLinterPayRequestDto.getFamilyPhone());
				prplpayDto.setOfficephone(prpLinterPayRequestDto.getOfficePhone());
				prplpayDto.setMobilephone(prpLinterPayRequestDto.getMobilePhone());
				//prplpayDto.setPayremark(payRemark);
				prplpayDto.setOperatorcode(user.getUserCode());
				prplpayDto.setOperatorComCode(user.getComCode());
				//prplpayDto.setInputdate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
				prplpayDto.setInputdate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
				prplpayDto.setPaymenttype(PrpLinterPaymentInfoDto.getPaymentType());
				prplpayDto.setBankaccount(prpLinterPayRequestDto.getBankAccount());
				prplpayDto.setNode("apay");
				prplpayDto.setVFlag("6");
				prplpayDto.setComCode(user.getComCode());
				
				if("U".equals(prpLinterPayRequestDto.getOperateType())){
					prpLpayHisDto = new PrpLpayHisDto();
					ArrayList<PrplpayDto> prplpayDtoList = new ArrayList<PrplpayDto>();
					PrpLpaymainDto prpLpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager, hisPaymentNo);
					String conditions = " Serialno='"+hisPaymentNo+"' and Compensateno='"+prpLinterRecaseDetailDto.getCompensateNo()+"' and paymenttype ='"+PrpLinterPaymentInfoDto.getPaymentType()+"' ";
					prplpayDtoList = (ArrayList)blPrplpayAction.findByConditionsSql(dbManager, conditions);
					PrplpayDto prplpayDto1 = new PrplpayDto();
					if(prplpayDtoList.size()>0){
						prplpayDto1 = prplpayDtoList.get(0);
					}
					setPrpLpayTransPrpLpayHis(prplpayDto1,prpLpayHisDto,prpLinterPayRequestDto.getReceiverTypeOtherName());
					prpLpayHisDto.setProvinceCode(prpLpaymainDto.getProvinceCode());
					prpLpayHisDto.setCityCode(prpLpaymainDto.getCityCode());
					prpLpayHisDto.setUrgentType(prpLpaymainDto.getUrgentType());
					prpLpayHisDto.setQqNumber(prpLpaymainDto.getQqNumber());
					prpLpayHisDto.setEmail(prpLpaymainDto.getEmail());
					prpLpayHisDto.setUnitLink(prpLpaymainDto.getUnitLink());
					prpLpayHisDto.setPostCode(prpLpaymainDto.getPostCode());
					prpLpayHisDto.setEditDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
					//支付信息历史轨迹表保存接口类型等
					prpLpayHisDto.setPayWay(prpLpaymainDto.getPayWay());
					prpLpayHisDto.setPayReason(prpLpaymainDto.getPayReason());
					prpLpayHisDto.setPayPurpose(prpLpaymainDto.getPayPurpose());
					prpLpayHisDto.setAccountFlag(prpLpaymainDto.getAccountFlag());
					prpLpayHisDto.setInterType(prpLpaymainDto.getInterType());
//					String conditions1 = " claimNo ='"+prpLinterRecaseDetailDto.getClaimNo()+"' and Compensateno = '"+prpLinterRecaseDetailDto.getCompensateNo()+"' and payType = '"+prpLinterPayRequestDto.getPayWay()+"'";
//					int count = blPrpLpayHisAction.getCount(dbManager, conditions1);
//					prpLpayHisDto.setSerialNo2(String.valueOf(listRlpayHis.size()+(++count)));
					prpLpayHisDto.setSerialNo2(String.valueOf(j));
					j++;
					prplpayDto1.setVFlag("8");
					blPrplpayAction.delete(dbManager, prplpayDto1.getSerialno(), prplpayDto1.getCompensateno(), prplpayDto1.getSerialNo2());
				}
				listRlpay.add(prplpayDto);
				if(prpLpayHisDto != null){
					listRlpayHis.add(prpLpayHisDto);
				}
			}
			blPrplpayAction.insertAll(dbManager, listRlpay);
			blPrpLpayHisAction.insertAll(dbManager, listRlpayHis);
		}
		if(listN!=null && listN.size()>0){
			ArrayList<PrplpayDto> listNlpay =new ArrayList<PrplpayDto>();
			ArrayList<PrpLpayHisDto> listNlpayHis = new ArrayList<PrpLpayHisDto>();
			for(int i=0;i<listN.size();i++){
				String relationOutId = listN.get(i).getRelationOutId();
				Collection paymentShowList = this.getPrpLinterPaymentShowDto(relationOutId);
				if(paymentShowList==null || paymentShowList.size()==0){
					throw new Exception("没有相关案件");
				}
				PrplpayDto prplpayDto=null;
				PrpLpayHisDto prpLpayHisDto = null;
				PrpLinterPaymentShowDto prpLinterPaymentShowDto = (PrpLinterPaymentShowDto)paymentShowList.iterator().next();
				String serialNo2 = k+"";
				prplpayDto = new PrplpayDto();
				
				prplpayDto.setClaimno(prpLinterPaymentShowDto.getClaimNo());
				prplpayDto.setSerialno(paymentNo);
				prplpayDto.setSerialNo2(serialNo2);
				k++;
				prplpayDto.setCompensateno(prpLinterPaymentShowDto.getCompensateNo());
				classCode = prpLinterPaymentShowDto.getPolicyNo().substring(1, 3);
				prplpayDto.setClasscode(classCode);
				prplpayDto.setRiskcode(prpLinterPaymentShowDto.getPolicyNo().substring(1,5));
				prplpayDto.setRegistno(prpLinterPaymentShowDto.getRegistNo());
				prplpayDto.setPolicyno(prpLinterPaymentShowDto.getPolicyNo());
				prplpayDto.setPaytype("P3");
				
				prplpayDto.setReceivertype(prpLinterPayRequestDto.getReceiverTypeOther());
				PrpLinterPaymentInfoDto PrpLinterPaymentInfoDto = prpLinterPaymentInfoDtos[i];
				prplpayDto.setPayamount(PrpLinterPaymentInfoDto.getPaidPay());
				prplpayDto.setBanktype(prpLinterPayRequestDto.getBankType());
				prplpayDto.setBank(prpLinterPayRequestDto.getBank());
				prplpayDto.setAccounttype(prpLinterPayRequestDto.getAccountType());
				prplpayDto.setReceiverfullname(prpLinterPayRequestDto.getReceiverFullName());
				prplpayDto.setCertiftype(prpLinterPayRequestDto.getCertifType());
				prplpayDto.setAddress(prpLinterPayRequestDto.getAddress());
				prplpayDto.setCertifno(prpLinterPayRequestDto.getCertifNo());
				prplpayDto.setFamilyphone(prpLinterPayRequestDto.getFamilyPhone());
				prplpayDto.setOfficephone(prpLinterPayRequestDto.getOfficePhone());
				prplpayDto.setMobilephone(prpLinterPayRequestDto.getMobilePhone());
				//prplpayDto.setPayremark(payRemark);
				prplpayDto.setOperatorcode(user.getUserCode());
				prplpayDto.setOperatorComCode(user.getComCode());
				//prplpayDto.setInputdate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
				prplpayDto.setInputdate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
				prplpayDto.setPaymenttype(PrpLinterPaymentInfoDto.getPaymentType());
				prplpayDto.setBankaccount(prpLinterPayRequestDto.getBankAccount());
				prplpayDto.setNode("apay");
				prplpayDto.setVFlag("6");
				prplpayDto.setComCode(user.getComCode());
				
				if("U".equals(prpLinterPayRequestDto.getOperateType())){
					prpLpayHisDto = new PrpLpayHisDto();
					ArrayList<PrplpayDto> prplpayDtoList = new ArrayList<PrplpayDto>();
					PrpLpaymainDto prpLpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager, hisPaymentNo);
					String conditions = " Serialno='"+hisPaymentNo+"' and Compensateno='"+prpLinterPaymentShowDto.getCompensateNo()+"' and paymenttype ='"+PrpLinterPaymentInfoDto.getPaymentType()+"' ";
					prplpayDtoList = (ArrayList)blPrplpayAction.findByConditionsSql(dbManager, conditions);
					PrplpayDto prplpayDto1 = new PrplpayDto();
					if(prplpayDtoList.size()>0){
						prplpayDto1 = prplpayDtoList.get(0);
					}
					setPrpLpayTransPrpLpayHis(prplpayDto1,prpLpayHisDto,prpLinterPayRequestDto.getReceiverTypeOtherName());
					prpLpayHisDto.setProvinceCode(prpLpaymainDto.getProvinceCode());
					prpLpayHisDto.setCityCode(prpLpaymainDto.getCityCode());
					prpLpayHisDto.setUrgentType(prpLpaymainDto.getUrgentType());
					prpLpayHisDto.setQqNumber(prpLpaymainDto.getQqNumber());
					prpLpayHisDto.setEmail(prpLpaymainDto.getEmail());
					prpLpayHisDto.setUnitLink(prpLpaymainDto.getUnitLink());
					prpLpayHisDto.setPostCode(prpLpaymainDto.getPostCode());
					prpLpayHisDto.setEditDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
					//支付信息历史轨迹表保存接口类型等
					prpLpayHisDto.setPayWay(prpLpaymainDto.getPayWay());
					prpLpayHisDto.setPayReason(prpLpaymainDto.getPayReason());
					prpLpayHisDto.setPayPurpose(prpLpaymainDto.getPayPurpose());
					prpLpayHisDto.setAccountFlag(prpLpaymainDto.getAccountFlag());
					prpLpayHisDto.setInterType(prpLpaymainDto.getInterType());
//					String conditions1 = " claimNo ='"+prpLinterPaymentShowDto.getClaimNo()+"' and Compensateno = '"+prpLinterPaymentShowDto.getCompensateNo()+"' and payType = '"+prpLinterPayRequestDto.getPayWay()+"'";
//					int count = blPrpLpayHisAction.getCount(dbManager, conditions1);
//					prpLpayHisDto.setSerialNo2(String.valueOf(listNlpayHis.size()+(++count)));
					prpLpayHisDto.setSerialNo2(String.valueOf(j));
					j++;
					prplpayDto1.setVFlag("8");
					blPrplpayAction.delete(dbManager, prplpayDto1.getSerialno(), prplpayDto1.getCompensateno(), prplpayDto1.getSerialNo2());
				}
				listNlpay.add(prplpayDto);
				if(prpLpayHisDto != null){
					listNlpayHis.add(prpLpayHisDto);
				}
			}
			blPrplpayAction.insertAll(dbManager, listNlpay);
			blPrpLpayHisAction.insertAll(dbManager, listNlpayHis);
		}
		blPrpLpaymainAction.delete(dbManager, hisPaymentNo);
	}
	
	public void savePrpLpayExt(DBManager dbManager,PrpLinterPayRequestDto prpLinterPayRequestDto,String paymentNo,UserDto user)throws Exception{
		BLPrpLpayExtAction blPrpLpayExtAction = new BLPrpLpayExtAction();
		blPrpLpayExtAction.deleteByConditions(dbManager, " paymentNo='"+paymentNo+"' ");
		PrpLinterPayExtDto[] prpLinterPayExtDto = prpLinterPayRequestDto.getPrpLinterPayExtDto();
		if(prpLinterPayExtDto!=null && prpLinterPayExtDto.length>0){
			PrpLpayExtDto prpLpayExtDto =  null;
			for(int i=0;i<prpLinterPayExtDto.length;i++){
				prpLpayExtDto = new PrpLpayExtDto();
				prpLpayExtDto.setPaymentNo(paymentNo);
				prpLpayExtDto.setSerialNo(i + 1);
				prpLpayExtDto.setOperatorCode(user.getUserCode());
				prpLpayExtDto.setNotionCode("01");
				prpLpayExtDto.setNotionName("支付录入");
				prpLpayExtDto.setFlag("Y");
				//prpLpayExtDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
				prpLpayExtDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
				prpLpayExtDto.setContext(prpLinterPayExtDto[i].getContext());
				prpLpayExtDto.setComCode(user.getComCode());
				prpLpayExtDto.setNodeType("apay");
				prpLpayExtDto.setNodeName("支付录入");
				blPrpLpayExtAction.insert(dbManager,prpLpayExtDto);
			}
		}
	}

}
