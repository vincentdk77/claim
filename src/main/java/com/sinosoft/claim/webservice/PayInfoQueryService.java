package com.sinosoft.claim.webservice;

import java.util.ArrayList;
import java.util.Map;

import com.sinosoft.claim.bl.facade.BLPrpLinterPayDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;


/**
 * 第三方支付状态信息查询接口类
 * 
 * @author Administrator
 * 
 */
public class PayInfoQueryService {

	/**
	 * 
	 * @param outid
	 * @param relationoutid
	 * @return String
	 * @throws Exception
	 */
	public String queryPayInfo(String outid,String relationoutid) throws Exception {
		String returnStr = "";
		PrpallInfo prpallInfo = new PrpallInfo();
		PolicyDto policyDto = null;
		String conditions = "";
		String paymentNo = "";
		String thirdPayFlag = "";
		if (null != outid && !"".equals(outid)&&null != relationoutid && !"".equals(relationoutid)) {
			// 取得当前保单的信息
			try {
//				BLPrpLinterPayDetailFacade blPrpLinterPayDetailFacade = new BLPrpLinterPayDetailFacade();
//				BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade ();
//				BLPrpJpackDetail  blPrpJpackDetail = new BLPrpJpackDetail();
//				PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
//				conditions = " outid = '"+outid+"'";
//				ArrayList payDetailList = (ArrayList)blPrpLinterPayDetailFacade.findByConditions(conditions);
//				if(payDetailList!=null&&payDetailList.size()>0){
//				    PrpLinterPayDetailDto prpLinterPayDetailDto = (PrpLinterPayDetailDto)payDetailList.get(0);
//				    paymentNo = prpLinterPayDetailDto.getPaymentNo();
//				    if(paymentNo!=null&&!"".equals(paymentNo)){
//				        conditions = " paymentno = '"+paymentNo+"'";
//				        PrpLpaymainDto prpLpaymainDto = blPrpLpaymainFacade.findByPrimaryKey(paymentNo);
//				        thirdPayFlag = prpLpaymainDto.getThirdPayFlag();
//				        if(thirdPayFlag!=null&&!"".equals(thirdPayFlag)){
//				        	Map thirdPayFlagMap = paymentViewHelper.getThirdPayFlagMap();
//				        	if(thirdPayFlagMap.containsKey(thirdPayFlag)){
//				               	String status = (String)thirdPayFlagMap.get(thirdPayFlag);
//				               	if("4".equals(thirdPayFlag)){
//				               		returnStr = "1^查询成功-"+status+"-"+prpLpaymainDto.getPayRemark();	
//				               	}else if("8".equals(thirdPayFlag)){
//				               		conditions = " visaserialno = '"+paymentNo+"' and approveflag!='3' ";
//				               		blPrpJpackDetail.query(conditions);
//				               		if(blPrpJpackDetail.getSize()>0){
//				               			returnStr = "1^查询成功-"+status+blPrpJpackDetail.getArr(0).getBackReason();	
//				               		}else{
//				               			returnStr = "1^查询成功-"+status;	
//				               		}
//				               	}else{
//				               		returnStr = "1^查询成功-"+status;
//				               	}
//				        	}else{
//				        		returnStr = "0^查询失败收付编号支付状态代码不存在对应状态";	
//				        	}
//				        }else{
//				        	returnStr = "0^查询失败收付编号不存在支付状态";
//				        }
//				    }else{
//				    	returnStr = "0^查询失败不存在收付编号";
//				    }
//				}else{
//					returnStr = "0^查询失败不存在收付记录";
//				}
			} catch (Exception e) {
				returnStr = "0^查询失败";
				e.printStackTrace();
			}
		}
		return returnStr;
	}

}
