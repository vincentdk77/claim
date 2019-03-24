package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.action.domain.BLPrpLpayBillAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayExtAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpaymainAction;
import com.sinosoft.claim.bl.action.domain.BLPrplpayAction;
import com.sinosoft.claim.bl.facade.BLPrpLclaimBillManagerFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayBillFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayExtFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLpayBillDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.function.insutil.bl.action.custom.BLBillAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BillPaymentExcel_new {

	public ArrayList selectAll(String[] compensate,String[] isChecked) throws Exception {
		ArrayList prpLclaimBillManagerList = new ArrayList();
		try{
			
			String editType = "ADD";
			String back = "0";
			String conditions = "";
			if(compensate!=null && compensate.length>0){
				for(int i=0;i<compensate.length;i++){
						if("".equals(conditions)){
							conditions += " and te.compensateNo in ('"+compensate[i]+"'";
						}else{
							conditions += ",'"+compensate[i]+"'";
						}
					
				}
				if(!"".equals(conditions)){
					conditions += ")";
				}else{
					
				}
				
			}
			 if(!"".equals(conditions)){
					conditions += " and Rr.payflag in ('0','3') and not exists (select 1 from prplpaybill bill where bill.registno = Rr.registno and bill.compensateno = Rr.compensateno And bill.Serialno = Rr.Serialno) ";
				}
			BLPrpLclaimBillManagerFacade blPrpLclaimBillManagerFacade = new BLPrpLclaimBillManagerFacade();
			PageRecord pr = null;
			pr = blPrpLclaimBillManagerFacade.findByConditonSum(conditions,editType,back,0,0);
			prpLclaimBillManagerList = (ArrayList)pr.getResult();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
		return prpLclaimBillManagerList;
	}
	
	

}
