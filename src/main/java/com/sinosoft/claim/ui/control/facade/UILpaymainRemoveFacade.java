package com.sinosoft.claim.ui.control.facade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLclaimBillManagerFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayBillFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayExtFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayHisFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.dto.domain.PrpLpayBillDto;
import com.sinosoft.claim.dto.domain.PrpLpayHisDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 预赔理算环节支付信息删除
 * @author Administrator
 *
 */
public class UILpaymainRemoveFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		try{
			String paymentNo = httpServletRequest.getParameter("paymentNo");
			String billFlag = httpServletRequest.getParameter("billFlag");
			//String registNo = httpServletRequest.getParameter("registNo");
			BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
			BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
			BLPrpLpayExtFacade blPrpLpayExtFacade = new BLPrpLpayExtFacade();
			BLPrpLpayBillFacade blPrpLpayBillFacade = new BLPrpLpayBillFacade();
//			blPrpLpaymainFacade.delete(paymentNo);
			/*
			 * 删除prplpay表之前需要转储prplpayhis
			 */
			PrpLpaymainDto prpLpaymainDto =null;
			prpLpaymainDto= blPrpLpaymainFacade.findByPrimaryKey(paymentNo);
			ArrayList<PrplpayDto> prplpayDtoList = new ArrayList();
			String conditions = " Serialno = '"+paymentNo+"' ";
			prplpayDtoList = (ArrayList)blPrplpayFacade.findByConditions(conditions);
			PrplpayDto prplpayDto1 = new PrplpayDto();
			PrpLpayHisDto prpLpayHisDto = null;
			BLPrpLpayHisFacade blPrpLpayHisFacade =new BLPrpLpayHisFacade();
			ArrayList<PrpLpayHisDto> list2 = new ArrayList<PrpLpayHisDto>();
			DateTime dateTime = DateTime.current();
			for(int i=0;i<prplpayDtoList.size();i++){
				prpLpayHisDto = new PrpLpayHisDto();
				prplpayDto1 = prplpayDtoList.get(i);
				setPrpLpayTransPrpLpayHis(prplpayDto1,prpLpayHisDto);
				String conditions1 = " serialno='"+prplpayDto1.getSerialno()+"' and claimNo ='"+prplpayDto1.getClaimno()+"' and Compensateno = '"+prplpayDto1.getCompensateno()+"' and payType = '"+prplpayDto1.getPaytype()+"'";
				int count = blPrpLpayHisFacade.getCount(conditions1);
				prpLpayHisDto.setSerialNo2(String.valueOf(list2.size()+(++count)));
				if(prpLpaymainDto!=null){
					prpLpayHisDto.setProvinceCode(prpLpaymainDto.getProvinceCode());
					prpLpayHisDto.setCityCode(prpLpaymainDto.getCityCode());
					prpLpayHisDto.setUrgentType(prpLpaymainDto.getUrgentType());
					prpLpayHisDto.setQqNumber(prpLpaymainDto.getQqNumber());
					prpLpayHisDto.setEmail(prpLpaymainDto.getEmail());
					prpLpayHisDto.setUnitLink(prpLpaymainDto.getUnitLink());
					prpLpayHisDto.setPostCode(prpLpaymainDto.getPostCode());
					//支付信息历史轨迹表保存接口类型等
					prpLpayHisDto.setPayWay(prpLpaymainDto.getPayWay());
					prpLpayHisDto.setPayReason(prpLpaymainDto.getPayReason());
					prpLpayHisDto.setPayPurpose(prpLpaymainDto.getPayPurpose());
					prpLpayHisDto.setAccountFlag(prpLpaymainDto.getAccountFlag());
					prpLpayHisDto.setInterType(prpLpaymainDto.getInterType());
					prpLpayHisDto.setRouteNum(prpLpaymainDto.getRouteNum());
					prpLpayHisDto.setEditDate(dateTime);
					prpLpayHisDto.setRealPayWay(prpLpaymainDto.getRealPayWay());
				}
				if(prpLpayHisDto != null){
					list2.add(prpLpayHisDto);
				}
			}
			// 存储支付历史表，此效率低于prplpayhisaction.insertall
			for(PrpLpayHisDto prpLpayHisDto1:list2){
				blPrpLpayHisFacade.insert(prpLpayHisDto1);
			}
			blPrpLpaymainFacade.delete(paymentNo);
			blPrplpayFacade.deleteByConditions(" serialno='"+paymentNo+"' ");
			blPrpLpayExtFacade.deleteByConditions("  paymentNo='"+paymentNo+"' ");
			if(billFlag!=null&&"1".equals(billFlag)){
				BLPrpLclaimBillManagerFacade blPrpLclaimBillManagerFacade = new BLPrpLclaimBillManagerFacade();
				ArrayList list = (ArrayList)blPrpLpayBillFacade.findByConditions("businessno='"+paymentNo+"'");
				if(list.size()>0){
					for(int i=0;i<list.size();i++){
						PrpLpayBillDto prpLpayBillDto = (PrpLpayBillDto)list.get(i);
						blPrpLclaimBillManagerFacade.update(prpLpayBillDto.getRegistNo(), prpLpayBillDto.getCompensateNo(), prpLpayBillDto.getSerialNo(), 0, "","0");
					}
				}
				blPrpLpayBillFacade.deleteByConditions("  businessno='"+paymentNo+"' ");
			}else if(billFlag!=null&&"0".equals(billFlag)){
				BLPrpLclaimBillManagerFacade blPrpLclaimBillManagerFacade = new BLPrpLclaimBillManagerFacade();
				ArrayList list = (ArrayList)blPrpLpayBillFacade.findByConditions("businessno='"+paymentNo+"'");
				if(list.size()>0){
					for(int i=0;i<list.size();i++){
						PrpLpayBillDto prpLpayBillDto = (PrpLpayBillDto)list.get(i);
						blPrpLclaimBillManagerFacade.update(prpLpayBillDto.getRegistNo(), prpLpayBillDto.getCompensateNo(), prpLpayBillDto.getSerialNo(), 0, "","0");
					}
				}
				blPrpLpayBillFacade.deleteByConditions("  businessno='"+paymentNo+"' ");			
			}
			httpServletResponse.getWriter().write("true");
		}catch(Exception e){
			e.printStackTrace();
			httpServletResponse.getWriter().write(e.getMessage());
			
		}
		return null;
	}
	
	public void setPrpLpayTransPrpLpayHis(PrplpayDto prplpayDto,PrpLpayHisDto prpLpayHisDto){
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
//		prpLpayHisDto.setReceivertypeothername(receiverTypeOtherName);
		prpLpayHisDto.setCoinsCode(prplpayDto.getCoinsCode());
	}
}
