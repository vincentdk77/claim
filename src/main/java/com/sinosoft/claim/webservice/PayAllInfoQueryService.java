package com.sinosoft.claim.webservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.sinosoft.claim.bl.facade.BLPrpLinterPayDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.dto.custom.PayInfo;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.PrpDcodeDtoInfo;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.sff.blsvr.BLPrpJpackDetail;


/**
 * 第三方支付状态信息查询接口类
 * 
 * @author Administrator
 * 
 */
public class PayAllInfoQueryService {

	/**
	 * 
	 * @param outid
	 * @param relationoutid
	 * @return String
	 * @throws Exception
	 */
	public PayInfo[] queryPayInfo(String[] outid) throws Exception {
		PayInfo[] PayInfoList = null;;
		String returnStr = "";
		PrpallInfo prpallInfo = new PrpallInfo();
		String conditions = "";
		String paymentNo = "";
		String thirdPayFlag = "";
		if (null != outid && !"".equals(outid)) {
			// 取得当前保单的信息
			try {
				BLPrpLinterPayDetailFacade blPrpLinterPayDetailFacade = new BLPrpLinterPayDetailFacade();
				System.err.println("GUOYUAN71==47==");
				BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade ();
				BLPrpJpackDetail  blPrpJpackDetail = new BLPrpJpackDetail();
				PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
				if(outid!=null&&outid.length>0){
					conditions +=" Prplinterpayrequest.outid in ( ";
        			for(int i=0;i<outid.length;i++){
        				if(i==outid.length-1){
        					conditions +="'"+outid[i]+"'";
        				}else{
        					conditions +="'"+outid[i]+"',";
        				}
        			}
        			conditions +=" )";
				}
				System.err.println("GUOYUAN71==62==");
				Collection<PrpLinterPayDetailDto> payDetailList = blPrpLinterPayDetailFacade.findByAllOutId(conditions);
				if(!isEmpty(payDetailList)) {
					PayInfoList = new PayInfo[payDetailList.size()];
					int i = 0;
					for(PrpLinterPayDetailDto element:payDetailList) {
						PayInfoList[i++] = new PayInfo(element.getOutId(),element.getThirdPayFlag());
					}
				}else{
				    returnStr = "0^查询失败不存在支付记录";
			    }
				System.err.println("GUOYUAN71===="+payDetailList.size()+"===conditions=="+conditions);
			} catch (Exception e) {
				returnStr = "0^查询失败";
				e.printStackTrace();
			}
		}
		return PayInfoList;
	}
	
	private boolean isEmpty(Collection<?> collection) {
		if (collection != null && collection.size() > 0) {
			return false;
		}
		return true;
	}

}
