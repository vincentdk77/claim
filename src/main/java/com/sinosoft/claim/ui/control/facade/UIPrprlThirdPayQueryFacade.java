/**
 * 
 */
package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;
import com.sinosoft.claim.ui.view.formbean.PrplPayForm;
import com.sinosoft.claim.util.DateCompute;
import com.sinosoft.claim.util.TurnPageUtil;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.utiall.blsvr.BLPrpDrisk;
import com.sinosoft.utiall.schema.PrpDriskSchema;
import com.sinosoft.workbench.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;

/**
 * @author Administrator
 *
 */
public class UIPrprlThirdPayQueryFacade  extends Action{

    public ActionForward execute(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        PrplpayDto payDto=new PrplpayDto();
        PrplPayForm payForm=(PrplPayForm)form;
        //PrplFiscalPayForm fiscalpayForm=(PrplFiscalPayForm)form;
        try {
        	 //每页显示多少条
            //int rowsPerPage =Integer.parseInt(AppConfig.get("sysconst.ROWS_PERPAGE"));
            int rowsPerPage = TurnPageUtil.PERPAGE;
            //页数
            int pageNo     = Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")+"");
            
            String conditions=this.getConditions(payForm,request);
            
            if (request.getParameter("condition")!=null) {
            	conditions=request.getParameter("condition");
			}
            
            String forward=(String)request.getParameter("forward");
            //System.err.println(request.getParameter("type"));
            request.setAttribute("type", request.getParameter("type")) ;
            request.setAttribute("doQuery", request.getParameter("doQuery")) ;

            Collection paymainList  = new ArrayList();
            Collection payList  = new ArrayList();
            
            if ("query".equals(forward)){
                PageRecord pr= new BLPrpLpaymainFacade().queryThirdPayByConditions(conditions, pageNo, rowsPerPage);
                TurnPageDto pageDto=TurnPageUtil.getTurnPage(pr,request,conditions);
                payDto.setTurnPageDto(pageDto);
                 paymainList = pr.getResult() ;

              
	              String nowTime = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND)+"";
	              if(null!=paymainList&&!paymainList.isEmpty()){
	          			for(Iterator<PrpLpaymainDto> itr=paymainList.iterator();itr.hasNext();){
	              			PrpLpaymainDto prpLpaymaiDto = itr.next();
	              			//流入时长取数
	              			String totalInputDate = DateCompute.betweenDate(prpLpaymaiDto.getInputDate()+"", nowTime);
	              			totalInputDate = totalInputDate.split("分钟")[0];
	              			prpLpaymaiDto.setTotalInputDate(totalInputDate);
	              			//承保机构名称取数
	              			BLPrpDcompanyFacade  blPrpDcompanyFacade = new BLPrpDcompanyFacade();
	              			PrpDcompanyDto prpDcompanyDto = blPrpDcompanyFacade.findByPrimaryKey(prpLpaymaiDto.getComCode());
	              			if(null!=prpDcompanyDto&&!"".equals(prpDcompanyDto)){
	              				prpLpaymaiDto.setComName(prpDcompanyDto.getComCName());
	              			}
	              			
	                  	}          			
	          	}
	            request.setAttribute("paymainList", paymainList);
            }else if ("detail".equals(forward)){
            	String paymentNo= request.getParameter("paymentNo");
            	BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
            	Collection collection = blPrplpayFacade.findPrintByPaymentNo(paymentNo);
            	
            	PageRecord pr = new PageRecord(collection.size(),pageNo,1,rowsPerPage,collection);
	            TurnPageDto pageDto=TurnPageUtil.getTurnPage(pr,request,conditions);
	            payDto.setTurnPageDto(pageDto);
	            payList = pr.getResult() ;	
	          
	              if(null!=payList&&!payList.isEmpty()){
	            	  	HashMap<String,String> comCodeMap = new HashMap<String,String>();
	          			for(Iterator<PrplpayDto> itr=payList.iterator();itr.hasNext();){
	          				PrplpayDto prplpayDto = itr.next();

	              			//承保机构名称取数
	              			BLPrpDcompanyFacade  blPrpDcompanyFacade = new BLPrpDcompanyFacade();
	              			PrpDcompanyDto prpDcompanyDto = blPrpDcompanyFacade.findByPrimaryKey(prplpayDto.getComCode());
	              			if(null!=prpDcompanyDto&&!"".equals(prpDcompanyDto)){
	              				String key = prpDcompanyDto.getComCode();
	              				String value= prpDcompanyDto.getComCName();
	              				comCodeMap.put(key, value);
	              			}
	                  	} 
	          			request.setAttribute("comCodeMap", comCodeMap);
	          	}
	            request.setAttribute("payList", payList);
            }

            
            PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
            String prevPageUrl = request.getParameter("prevPageUrl");
            request.setAttribute("prevPageUrl", prevPageUrl);
            request.setAttribute("paymentTypeMap",paymentViewHelper.getPaymentTypeMap());
            request.setAttribute("VFlagMap",paymentViewHelper.getVFlagMap());
            request.setAttribute("payTypeMap",paymentViewHelper.getPayTypeMap());
            request.setAttribute("riskCodeMap",paymentViewHelper.getRiskCodeMap());
            request.setAttribute("thirdPayFlagMap", paymentViewHelper.getThirdPayFlagMap());
            
            request.setAttribute("payDto", payDto);

            return mapping.findForward(forward);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
       
    }
    public String getConditions(PrplPayForm payForm, HttpServletRequest request) throws Exception{
        StringBuffer sb=new StringBuffer();

        PrpLpaymainDto paymainDto=payForm.getPrplpaymain();

        String payDate1 = request.getParameter("payDate1");
        String payDate2 = request.getParameter("payDate2");
        String receiverFullNameSign = request.getParameter("receiverFullNameSign");
        String bankAccountSign = request.getParameter("bankAccountSign");
        String payAmountSign = request.getParameter("payAmountSign");
        String paymentNo = request.getParameter("paymentNo");

        UserDto  user=(UserDto) request.getSession().getAttribute("user");
        String userComCode = user.getComCode();        
        String type = request.getParameter("type");
        sb.append(" 1=1 ");
        
        if (user==null) {
			throw new Exception("session失效");
		}
		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		String sqlStr = uiPowerInterface.addPower(user, "prplpaymain", "", "ComCode");
		sb.append("   "+sqlStr+"  ");
        
        try {
        	//支付号
        	if(null!=paymentNo&&!"".equals(paymentNo)){
        		sb.append(" and prplpaymain.paymentNo = '"+paymentNo+"'");
        	}
        	//流入时间
        	if(null!=payDate1&&!"".equals(payDate1)){
        		sb.append(" and prpjpackdetail.payDate >=  ('"+payDate1+" 00:00:00"+"')");
        	}
        	if(null!=payDate2&&!"".equals(payDate2)){
        		sb.append(" and prpjpackdetail.payDate <=  ('"+payDate2+" 23:59:59"+"')");
        	}

        	//收款账号
        	if (!paymainDto.getBankAccount().equals("")) {
        		if("*".equals(bankAccountSign)){
        			sb.append(" and prplpaymain.bankaccount like '%"+paymainDto.getBankAccount()+"%'");
        		}else if("=".equals(bankAccountSign)){
        			sb.append(" and prplpaymain.bankaccount = '"+paymainDto.getBankAccount()+"'");
        		}
        	}
        	//收款人
        	if (!paymainDto.getReceiverFullName().equals("")) {
        		if("*".equals(receiverFullNameSign)){
        			sb.append(" and prplpaymain.ReceiverFullName like '%"+paymainDto.getReceiverFullName()+"%'");
        		}else if("=".equals(receiverFullNameSign)){
        			sb.append(" and prplpaymain.ReceiverFullName = '"+paymainDto.getReceiverFullName()+"'");
        		}
        	}
        	//金额
        	if (paymainDto.getPayAmount()>0) {
        		sb.append(" and prplpaymain.PayAmount = "+paymainDto.getPayAmount()+"");
        	}

			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return sb.toString();
    }
    
    public String getConditions1(PrplPayForm payForm, HttpServletRequest request) throws Exception{
        StringBuffer sb=new StringBuffer();
        PrplpayDto payDto=payForm.getPrplpay();
        PrpLpaymainDto paymainDto=payForm.getPrplpaymain();
        PrpLregistDto registDto=payForm.getPrplregist();
        String registnoSign = request.getParameter("registnoSign");
        String policynoSign = request.getParameter("policynoSign");
        UserDto  user=(UserDto) request.getSession().getAttribute("user");
        String userComCode = user.getComCode();
        
        String mechanism = request.getParameter("mechanism");
        String agnet = request.getParameter("agnet");
        
        String[] vflag = request.getParameterValues("vflag");
        String type = request.getParameter("type");
        sb.append(" 1=1 ");
        
        if (user==null) {
			throw new Exception("session失效");
		}else {
			//替换为,此处在下面的委托处理中处理--此处为新增委托处处理,权限管理改为系统类的向下兼容模式
			//sb.append("");
			if(type!=null&&"4".equals(type)){
				UIPowerInterface uiPowerInterface = new UIPowerInterface();
				String sqlStr = uiPowerInterface.addPower(user, "prplfiscalpaymain", "", "operatorComCode");
				sb.append("   "+sqlStr+"  ");
			}else{
				sb.append(" and prplfiscalpaymain.operatorcode = '" + user.getUserCode() + "'");
			}
			if(type!=null&&!"".equals(type)&&!"4".equals(type)&&!"null".equals(type)){
				sb.append(" and prplfiscalpaymain.status = '"+type+"'"); 
			}
		}
        
        try {
        	
        	sb.append(" and prplfiscalpaymain.fiscalno = prplfiscalpaydetail.fiscalno");
        	sb.append(" and prplfiscalpaymain.registno = prplregist.registno ");
        	//报案号码
        	if (!payDto.getRegistno().equals("")) {
        		if("*".equals(registnoSign)){
        			sb.append(" and prplfiscalpaymain.registno like '%"+payDto.getRegistno()+"%'");
        		}else if("=".equals(registnoSign)){
        			sb.append(" and prplfiscalpaymain.registno = '"+payDto.getRegistno()+"'");
        		}
        	}
        	//支付清单号
//        	if (!fiscalpaymainDto.getFiscalno().equals("")) {
//        		if("*".equals(policynoSign)){
//        			sb.append(" and prplregist.policyno like '%"+fiscalpaymainDto.getFiscalno()+"%'");
//        		}else if("=".equals(policynoSign)){
//        			sb.append(" and prplregist.policyno = '"+fiscalpaymainDto.getFiscalno()+"'");
//        		}
//        	}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return sb.toString();
    }

}
