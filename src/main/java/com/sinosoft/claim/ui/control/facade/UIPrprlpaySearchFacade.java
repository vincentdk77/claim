package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
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
import com.sinosoft.claim.dto.domain.PrplfiscalpaydetailDto;
import com.sinosoft.claim.dto.domain.PrplfiscalpaymainDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;
import com.sinosoft.claim.ui.view.formbean.PrplFiscalPayForm;
import com.sinosoft.claim.ui.view.formbean.PrplPayForm;
import com.sinosoft.claim.util.DateCompute;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.claim.util.TurnPageUtil;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.workbench.claim.dto.domain.PrpLregistDto;

public class UIPrprlpaySearchFacade extends Action{
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
            String conditions2=this.getConditions2(payForm,request);//单笔支付查询
            String conditions3=this.getConditions3(payForm,request);//清单支付查询
            String conditions1=this.getConditions1(payForm, request);
            
            if (request.getParameter("condition")!=null) {
            	conditions=request.getParameter("condition");
			}
            if (request.getParameter("condition2")!=null) {
            	conditions2=request.getParameter("condition2");
			}
            if (request.getParameter("condition3")!=null) {
            	conditions3=request.getParameter("condition3");
			}
            conditions1 += " and prplfiscalpaydetail.vflag = 'ct' and prplfiscalpaydetail.payamount > (select  Nvl(Sum(Payamount),0) from prplpay where receiverfullname = prplfiscalpaydetail.receiverfullname  and compensateno = prplfiscalpaydetail.compensateno ) AND NOT EXISTS"+
                           " (SELECT 1"+//增加屏蔽新农险案件查询
                           " FROM prpcmain cm"+
                           " WHERE cm.policyno = PRPLREGIST.Policyno AND cm.systemflag='agri') ";
            if (request.getParameter("condition1")!=null) {
            	conditions1=request.getParameter("condition1");
			}
            //System.err.println(request.getParameter("type"));
            request.setAttribute("type", request.getParameter("type")) ;
            request.setAttribute("doQuery", request.getParameter("doQuery")) ;
            String type = request.getParameter("type");
            Collection paymainList  = new ArrayList();
            if("4".equals(type)){
              PageRecord pr= new BLPrpLpaymainFacade().findPayQueryByConditionsNew(conditions, pageNo, rowsPerPage);
              TurnPageDto pageDto=TurnPageUtil.getTurnPage(pr,request,conditions);
              payDto.setTurnPageDto(pageDto);
               paymainList = pr.getResult() ;
            }else{
            	if("3".equals(type)){
//            		PageRecord pr= new BLPrpLpaymainFacade().findPayQueryByConditionsBack(conditions,conditions1, pageNo, rowsPerPage);
            		PageRecord pr= new BLPrpLpaymainFacade().findPayQueryByConditionsBack(conditions3,conditions1,conditions2, pageNo, rowsPerPage);
                    TurnPageDto pageDto=TurnPageUtil.getTurnPage(pr,request,conditions,conditions2,conditions3);
                    payDto.setTurnPageDto(pageDto);
                    paymainList = pr.getResult() ;
            	}else{
            		PageRecord pr= new BLPrpLpaymainFacade().findPayQueryByConditions(conditions, pageNo, rowsPerPage);
                    TurnPageDto pageDto=TurnPageUtil.getTurnPage(pr,request,conditions);
                    payDto.setTurnPageDto(pageDto);
                    paymainList = pr.getResult() ;
            	}
            }
            
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
            PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
            String prevPageUrl = request.getParameter("prevPageUrl");
            request.setAttribute("prevPageUrl", prevPageUrl);
            request.setAttribute("paymentTypeMap",paymentViewHelper.getPaymentTypeMap());
            request.setAttribute("VFlagMap",paymentViewHelper.getVFlagMap());
            request.setAttribute("payTypeMap",paymentViewHelper.getPayTypeMap());
            request.setAttribute("paymainList", paymainList);
            request.setAttribute("payDto", payDto);
            request.setAttribute("thirdPayFlagMap", paymentViewHelper.getThirdPayFlagMap());
            request.setAttribute("realPayWayMap", paymentViewHelper.getRealPayWayMap());
            if("4".equals(type)){
            return mapping.findForward("success");
            }else{
            return mapping.findForward("true");
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
       
    }
    public String getConditions(PrplPayForm payForm, HttpServletRequest request) throws Exception{
        StringBuffer sb=new StringBuffer();
        PrplpayDto payDto=payForm.getPrplpay();
        PrpLpaymainDto paymainDto=payForm.getPrplpaymain();
        PrpLregistDto registDto=payForm.getPrplregist();
        String inputDate1 = request.getParameter("inputDate1");
        String inputDate2 = request.getParameter("inputDate2");
        String registnoSign = request.getParameter("registnoSign");
        String policynoSign = request.getParameter("policynoSign");
        String insuredNameSign = request.getParameter("insuredNameSign");
        String licenseNoSign = request.getParameter("licenseNoSign");
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
				String sqlStr = uiPowerInterface.addPower(user, "prplpaymain", "", "ComCode");
				sb.append("   "+sqlStr+"  ");
			}else{
				sb.append(" and prplpaymain.operatorcode = '" + user.getUserCode() + "'");
			}
		}
        
        try {
        	
        	//赔款类型
        	if(mechanism!=null&&!mechanism.trim().equals("")&&agnet!=null&&!agnet.trim().equals("")){
        		sb.append(" ");	
            }else if(mechanism!=null&&!mechanism.trim().equals("")){
            	sb.append("	  and prplregist.comcode in (select comcode from prpdcompany  connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComCode+"'  )");
            }else if(agnet!=null&&!agnet.trim().equals("")){
            	sb.append("	  and prplregist.comcode not in (select comcode from prpdcompany  connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComCode+"'  )");
            }
        	if(!paymainDto.getPaymentType().equals("")){
        		sb.append(" and prplpaymain.paymenttype='" + paymainDto.getPaymentType() + "'");
        	}
        	//支付类型
        	if(!paymainDto.getPayType().equals("")){
        		sb.append(" and prplpaymain.paytype='" + paymainDto.getPayType() + "'");
        	}
        	if(!paymainDto.getPayFlag().equals("")){
        		sb.append(" and prplpay.payflag='" + paymainDto.getPayFlag() + "'");
			}else{
				//任务状态
	        	if(null!=vflag&&vflag.length>0){
	        		sb.append(" and prplpaymain.vflag in (");
	        		for(int i=0;i<vflag.length;i++){
	        			
	        			System.out.println("vflag:"+vflag[i]);
	        			if(i==vflag.length-1){
	        				sb.append("'"+vflag[i]+"'");
	        			}else{
	        				sb.append("'"+vflag[i]+"',");
	        			}
	        		}
	        		sb.append(")");
	        		sb.append(" and (prplpay.payflag !='1' or prplpay.payflag is null)");
				}else{
					if("3".equals(type)){
						sb.append(" and prplpaymain.vflag in ('3','7','9') ");
					}
				}
	        	if ("2".equals(type)) {
					sb.append(" and prplpay.vflag = 1 ");
				}
	        	if ("4".equals(type)) {
					//sb.append(" and prplpaymain.vflag not in ('0','1','3','7','9') and prplpaymain.vflag is not null ");
				}
			}
        	sb.append(" and prplpay.classcode <> '05' ");
        	//流入时间
        	if(null!=inputDate1&&!"".equals(inputDate1)){
        		sb.append("and prplpaymain.inputDate >=  to_date('"+inputDate1+"','yyyy-mm-dd hh24:mi:ss')");
        	}
        	if(null!=inputDate2&&!"".equals(inputDate2)){
        		sb.append("and prplpaymain.inputDate <=  to_date('"+inputDate2+"','yyyy-mm-dd hh24:mi:ss')");
        	}
        	
        	
        	sb.append(" and prplpaymain.paymentno = prplpay.serialno");
        	sb.append(" and prplpay.registno = prplregist.registno ");
        	sb.append(" and prplpay.serialno = prplpaybill.paymentno(+) ");
        	sb.append(" and prplpaybill.billno = kk.billno(+) ");
        	/**
        	//加入委托相关条件
        	sb.append(" and (prplpaymain.comcode like '" + user.getComCode().substring(0, 6) + "%' or ");
        	sb.append(" prplpaymain.comcode in ");
        	sb.append(" (select t.resavecom ");
           	sb.append("    from prplentrust t ");
   			sb.append("  where t.registno = prplregist.registno ");
   			sb.append("   and t.entrusttype in ('1', '2') ");
   			sb.append(" and t.resavecom is not null)) ");
   			*/
			//String conditions = sb.toString();
//			sb.append(" and prplpay.serialno in ( ( ");
//			sb.append(" select serialno from Prplpay p2 left join prplcompensate c2 on p2.compensateno=c2.compensateno left join prplprepay pre2 on p2.compensateno=pre2.precompensateno  ");
//			sb.append(" where 1=1 ");
//			if (!payDto.getRegistno().equals("")) {
//				sb.append(" and p2.registno='" + payDto.getRegistno() + "'");
//			}
//			if (!payDto.getCompensateno().equals("")) {
//				sb.append(" and p2.compensateno='" + payDto.getCompensateno()
//						+ "'");
//			}
//			sb.append(" )) ");
        	//报案号码
        	if (!payDto.getRegistno().equals("")) {
        		if("*".equals(registnoSign)){
        			sb.append(" and prplpay.registno like '%"+payDto.getRegistno()+"%'");
        		}else if("=".equals(registnoSign)){
        			sb.append(" and prplpay.registno = '"+payDto.getRegistno()+"'");
        		}
        	}
        	//新增险类
        	String riskCategory = request.getParameter("riskCategory");
        	riskCategory = StringUtils.rightTrim(riskCategory);
        	if(riskCategory.length()>0){
        		sb.append(" and prplpay.classCode  in (select classcode from riskCategoryThirdPay where riskcategory ='"+riskCategory+"')");
        	}
        	
        	//新增险种
        	String riskCode     = request.getParameter("prpLregistRiskCode") ;  //险种代码
        	riskCode = StringUtils.rightTrim(riskCode);

        	if (riskCode.length() > 0) {
        		sb.append( StringConvert.convertString(" prplpay.riskCode", riskCode,request.getParameter("RiskCodeSign")));
        	}
        	
        	//保单号码
        	if (!payDto.getPolicyno().equals("")) {
        		if("*".equals(policynoSign)){
        			sb.append(" and prplregist.policyno like '%"+payDto.getPolicyno()+"%'");
        		}else if("=".equals(policynoSign)){
        			sb.append(" and prplregist.policyno = '"+payDto.getPolicyno()+"'");
        		}
        	}
        	//被保险人
        	if (!registDto.getInsuredName().equals("")) {
        		if("*".equals(insuredNameSign)){
        			sb.append(" and prplregist.insuredname like '%"+registDto.getInsuredName()+"%'");
        		}else if("=".equals(insuredNameSign)){
        			sb.append("and prplregist.insuredname = '"+registDto.getInsuredName()+"'");
        		}
        	}
        	//号牌号码
			if (!registDto.getLicenseNo().equals("")) {
				if("*".equals(licenseNoSign)){
					sb.append(" and prplregist.licenseNo like '%"+registDto.getLicenseNo()+"%'");
				}else if("=".equals(licenseNoSign)){
					sb.append(" and prplregist.licenseNo = '"+registDto.getLicenseNo()+"'");
				}
			}
			//添加区分新农险数据
			sb.append(" and (prplpay.registno in(select registno from swflog where (systemflag is null or systemflag <> 'agri') and nodetype='regis') ");
			sb.append(" or prplpay.registno in(select registno from swflogstore where (systemflag is null or systemflag <> 'agri') and nodetype='regis'))");
			
			sb.append(" And Not Exists ");
			sb.append(" (Select 1 ");
			sb.append("          From Prplinterrelation Nn ");
			sb.append("        Where Nn.Relationregistno = Prplpay.Registno) ");
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
    
    public String getConditions2(PrplPayForm payForm, HttpServletRequest request) throws Exception{
        StringBuffer sb=new StringBuffer();
        PrplpayDto payDto=payForm.getPrplpay();
        PrpLpaymainDto paymainDto=payForm.getPrplpaymain();
        PrpLregistDto registDto=payForm.getPrplregist();
        String inputDate1 = request.getParameter("inputDate1");
        String inputDate2 = request.getParameter("inputDate2");
        String registnoSign = request.getParameter("registnoSign");
        String policynoSign = request.getParameter("policynoSign");
        String insuredNameSign = request.getParameter("insuredNameSign");
        String licenseNoSign = request.getParameter("licenseNoSign");
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
				String sqlStr = uiPowerInterface.addPower(user, "prplpaymain", "", "ComCode");
				sb.append("   "+sqlStr+"  ");
			}else{
				sb.append(" and prplpaymain.operatorcode = '" + user.getUserCode() + "'");
			}
		}
        
        try {
        	
        	//赔款类型
        	if(mechanism!=null&&!mechanism.trim().equals("")&&agnet!=null&&!agnet.trim().equals("")){
        		sb.append(" ");	
            }else if(mechanism!=null&&!mechanism.trim().equals("")){
            	sb.append("	  and prplregist.comcode in (select comcode from prpdcompany  connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComCode+"'  )");
            }else if(agnet!=null&&!agnet.trim().equals("")){
            	sb.append("	  and prplregist.comcode not in (select comcode from prpdcompany  connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComCode+"'  )");
            }
        	if(!paymainDto.getPaymentType().equals("")){
        		sb.append(" and prplpaymain.paymenttype='" + paymainDto.getPaymentType() + "'");
        	}
        	//支付类型
        	if(!paymainDto.getPayType().equals("")){
        		sb.append(" and prplpaymain.paytype='" + paymainDto.getPayType() + "'");
        	}
        	if(!paymainDto.getPayFlag().equals("")){
        		sb.append(" and prplpay.payflag='" + paymainDto.getPayFlag() + "'");
			}else{
				//任务状态
	        	if(null!=vflag&&vflag.length>0){
	        		sb.append(" and prplpaymain.vflag in (");
	        		for(int i=0;i<vflag.length;i++){
	        			
	        			System.out.println("vflag:"+vflag[i]);
	        			if(i==vflag.length-1){
	        				sb.append("'"+vflag[i]+"'");
	        			}else{
	        				sb.append("'"+vflag[i]+"',");
	        			}
	        		}
	        		sb.append(")");
	        		sb.append(" and (prplpay.payflag !='1' or prplpay.payflag is null)");
				}else{
					if("3".equals(type)){
						sb.append(" and prplpaymain.vflag in ('3','7','9') ");
					}
				}
	        	if ("2".equals(type)) {
					sb.append(" and prplpay.vflag = 1 ");
				}
	        	if ("4".equals(type)) {
					sb.append(" and prplpaymain.vflag not in ('0','1','3','7','9') and prplpaymain.vflag is not null ");
				}
			}
        	sb.append(" and prplpay.classcode <> '05' ");
        	//流入时间
        	if(null!=inputDate1&&!"".equals(inputDate1)){
        		sb.append("and prplpaymain.inputDate >=  to_date('"+inputDate1+"','yyyy-mm-dd hh24:mi:ss')");
        	}
        	if(null!=inputDate2&&!"".equals(inputDate2)){
        		sb.append("and prplpaymain.inputDate <=  to_date('"+inputDate2+"','yyyy-mm-dd hh24:mi:ss')");
        	}
        	
        	
        	sb.append(" and prplpaymain.paymentno = prplpay.serialno");
        	sb.append(" and prplpay.registno = prplregist.registno ");
//        	sb.append(" and prplpay.serialno = prplpaybill.paymentno(+) ");
//        	sb.append(" and prplpaybill.billno = kk.billno(+) ");
        	sb.append("  and exists(select 1 from prplpaybill where prplpaybill.paymentno=prplpaymain.paymentno ");
        	sb.append(" AND PRPLPAYBILL.BILLNO IS  NULL) ");
        	
        	/**
        	//加入委托相关条件
        	sb.append(" and (prplpaymain.comcode like '" + user.getComCode().substring(0, 6) + "%' or ");
        	sb.append(" prplpaymain.comcode in ");
        	sb.append(" (select t.resavecom ");
           	sb.append("    from prplentrust t ");
   			sb.append("  where t.registno = prplregist.registno ");
   			sb.append("   and t.entrusttype in ('1', '2') ");
   			sb.append(" and t.resavecom is not null)) ");
   			*/
			//String conditions = sb.toString();
//			sb.append(" and prplpay.serialno in ( ( ");
//			sb.append(" select serialno from Prplpay p2 left join prplcompensate c2 on p2.compensateno=c2.compensateno left join prplprepay pre2 on p2.compensateno=pre2.precompensateno  ");
//			sb.append(" where 1=1 ");
//			if (!payDto.getRegistno().equals("")) {
//				sb.append(" and p2.registno='" + payDto.getRegistno() + "'");
//			}
//			if (!payDto.getCompensateno().equals("")) {
//				sb.append(" and p2.compensateno='" + payDto.getCompensateno()
//						+ "'");
//			}
//			sb.append(" )) ");
        	//报案号码
        	if (!payDto.getRegistno().equals("")) {
        		if("*".equals(registnoSign)){
        			sb.append(" and prplpay.registno like '%"+payDto.getRegistno()+"%'");
        		}else if("=".equals(registnoSign)){
        			sb.append(" and prplpay.registno = '"+payDto.getRegistno()+"'");
        		}
        	}
        	//新增险类
        	String riskCategory = request.getParameter("riskCategory");
        	riskCategory = StringUtils.rightTrim(riskCategory);
        	if(riskCategory.length()>0){
        		sb.append(" and prplpay.classCode  in (select classcode from riskCategoryThirdPay where riskcategory ='"+riskCategory+"')");
        	}
        	
        	//新增险种
        	String riskCode     = request.getParameter("prpLregistRiskCode") ;  //险种代码
        	riskCode = StringUtils.rightTrim(riskCode);

        	if (riskCode.length() > 0) {
        		sb.append( StringConvert.convertString(" prplpay.riskCode", riskCode,request.getParameter("RiskCodeSign")));
        	}
        	
        	//保单号码
        	if (!payDto.getPolicyno().equals("")) {
        		if("*".equals(policynoSign)){
        			sb.append(" and prplregist.policyno like '%"+payDto.getPolicyno()+"%'");
        		}else if("=".equals(policynoSign)){
        			sb.append(" and prplregist.policyno = '"+payDto.getPolicyno()+"'");
        		}
        	}
        	//被保险人
        	if (!registDto.getInsuredName().equals("")) {
        		if("*".equals(insuredNameSign)){
        			sb.append(" and prplregist.insuredname like '%"+registDto.getInsuredName()+"%'");
        		}else if("=".equals(insuredNameSign)){
        			sb.append("and prplregist.insuredname = '"+registDto.getInsuredName()+"'");
        		}
        	}
        	//号牌号码
			if (!registDto.getLicenseNo().equals("")) {
				if("*".equals(licenseNoSign)){
					sb.append(" and prplregist.licenseNo like '%"+registDto.getLicenseNo()+"%'");
				}else if("=".equals(licenseNoSign)){
					sb.append(" and prplregist.licenseNo = '"+registDto.getLicenseNo()+"'");
				}
			}
			sb.append(" And Not Exists ");
			sb.append(" (Select 1 ");
			sb.append("          From Prplinterrelation Nn ");
			sb.append("        Where Nn.Relationregistno = Prplpay.Registno) ");
			sb.append(" And Not Exists ");//增加屏蔽新农险案件查询
			sb.append(" (Select 1 ");
			sb.append("          From prpcmain cm ");
			sb.append("        WHERE cm.policyno = PRPLPAY.Policyno AND cm.systemflag='agri') ");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return sb.toString();
    }
    public String getConditions3(PrplPayForm payForm, HttpServletRequest request) throws Exception{
        StringBuffer sb=new StringBuffer();
        PrplpayDto payDto=payForm.getPrplpay();
        PrpLpaymainDto paymainDto=payForm.getPrplpaymain();
        PrpLregistDto registDto=payForm.getPrplregist();
        String inputDate1 = request.getParameter("inputDate1");
        String inputDate2 = request.getParameter("inputDate2");
        String registnoSign = request.getParameter("registnoSign");
        String policynoSign = request.getParameter("policynoSign");
        String insuredNameSign = request.getParameter("insuredNameSign");
        String licenseNoSign = request.getParameter("licenseNoSign");
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
				String sqlStr = uiPowerInterface.addPower(user, "prplpaymain", "", "ComCode");
				sb.append("   "+sqlStr+"  ");
			}else{
				sb.append(" and prplpaymain.operatorcode = '" + user.getUserCode() + "'");
			}
		}
        
        try {
        	
        	//赔款类型
        	if(mechanism!=null&&!mechanism.trim().equals("")&&agnet!=null&&!agnet.trim().equals("")){
        		sb.append(" ");	
            }else if(mechanism!=null&&!mechanism.trim().equals("")){
            	sb.append("	  and prplregist.comcode in (select comcode from prpdcompany  connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComCode+"'  )");
            }else if(agnet!=null&&!agnet.trim().equals("")){
            	sb.append("	  and prplregist.comcode not in (select comcode from prpdcompany  connect by prior comcode = uppercomcode and comcode <> '0000000000' start with comcode = '"+userComCode+"'  )");
            }
        	if(!paymainDto.getPaymentType().equals("")){
        		sb.append(" and prplpaymain.paymenttype='" + paymainDto.getPaymentType() + "'");
        	}
        	//支付类型
        	if(!paymainDto.getPayType().equals("")){
        		sb.append(" and prplpaymain.paytype='" + paymainDto.getPayType() + "'");
        	}
        	if(!paymainDto.getPayFlag().equals("")){
        		sb.append(" and prplpay.payflag='" + paymainDto.getPayFlag() + "'");
			}else{
				//任务状态
	        	if(null!=vflag&&vflag.length>0){
	        		sb.append(" and prplpaymain.vflag in (");
	        		for(int i=0;i<vflag.length;i++){
	        			
	        			System.out.println("vflag:"+vflag[i]);
	        			if(i==vflag.length-1){
	        				sb.append("'"+vflag[i]+"'");
	        			}else{
	        				sb.append("'"+vflag[i]+"',");
	        			}
	        		}
	        		sb.append(")");
	        		sb.append(" and (prplpay.payflag !='1' or prplpay.payflag is null)");
				}else{
					if("3".equals(type)){
						sb.append(" and prplpaymain.vflag in ('3','7','9') ");
					}
				}
	        	if ("2".equals(type)) {
					sb.append(" and prplpay.vflag = 1 ");
				}
	        	if ("4".equals(type)) {
					sb.append(" and prplpaymain.vflag not in ('0','1','3','7','9') and prplpaymain.vflag is not null ");
				}
			}
        	sb.append(" and prplpay.classcode <> '05' ");
        	//流入时间
        	if(null!=inputDate1&&!"".equals(inputDate1)){
        		sb.append("and prplpaymain.inputDate >=  to_date('"+inputDate1+"','yyyy-mm-dd hh24:mi:ss')");
        	}
        	if(null!=inputDate2&&!"".equals(inputDate2)){
        		sb.append("and prplpaymain.inputDate <=  to_date('"+inputDate2+"','yyyy-mm-dd hh24:mi:ss')");
        	}
        	
        	
        	sb.append(" and prplpaymain.paymentno = prplpay.serialno");
        	sb.append(" and prplpay.registno = prplregist.registno ");
//        	sb.append(" and prplpay.serialno = prplpaybill.paymentno(+) ");
//        	sb.append(" and prplpaybill.billno = kk.billno(+) ");
        	sb.append("  and exists(select 1 from prplpaybill where prplpaybill.billno=kk.billno and prplpaybill.paymentno=prplpaymain.paymentno ");
        	sb.append(" AND PRPLPAYBILL.BILLNO IS NOT NULL) ");
        	sb.append(" and kk.billno is not null ");
        	/**
        	//加入委托相关条件
        	sb.append(" and (prplpaymain.comcode like '" + user.getComCode().substring(0, 6) + "%' or ");
        	sb.append(" prplpaymain.comcode in ");
        	sb.append(" (select t.resavecom ");
           	sb.append("    from prplentrust t ");
   			sb.append("  where t.registno = prplregist.registno ");
   			sb.append("   and t.entrusttype in ('1', '2') ");
   			sb.append(" and t.resavecom is not null)) ");
   			*/
			//String conditions = sb.toString();
//			sb.append(" and prplpay.serialno in ( ( ");
//			sb.append(" select serialno from Prplpay p2 left join prplcompensate c2 on p2.compensateno=c2.compensateno left join prplprepay pre2 on p2.compensateno=pre2.precompensateno  ");
//			sb.append(" where 1=1 ");
//			if (!payDto.getRegistno().equals("")) {
//				sb.append(" and p2.registno='" + payDto.getRegistno() + "'");
//			}
//			if (!payDto.getCompensateno().equals("")) {
//				sb.append(" and p2.compensateno='" + payDto.getCompensateno()
//						+ "'");
//			}
//			sb.append(" )) ");
        	//报案号码
        	if (!payDto.getRegistno().equals("")) {
        		if("*".equals(registnoSign)){
        			sb.append(" and prplpay.registno like '%"+payDto.getRegistno()+"%'");
        		}else if("=".equals(registnoSign)){
        			sb.append(" and prplpay.registno = '"+payDto.getRegistno()+"'");
        		}
        	}
        	//新增险类
        	String riskCategory = request.getParameter("riskCategory");
        	riskCategory = StringUtils.rightTrim(riskCategory);
        	if(riskCategory.length()>0){
        		sb.append(" and prplpay.classCode  in (select classcode from riskCategoryThirdPay where riskcategory ='"+riskCategory+"')");
        	}
        	
        	//新增险种
        	String riskCode     = request.getParameter("prpLregistRiskCode") ;  //险种代码
        	riskCode = StringUtils.rightTrim(riskCode);

        	if (riskCode.length() > 0) {
        		sb.append( StringConvert.convertString(" prplpay.riskCode", riskCode,request.getParameter("RiskCodeSign")));
        	}
        	
        	//保单号码
        	if (!payDto.getPolicyno().equals("")) {
        		if("*".equals(policynoSign)){
        			sb.append(" and prplregist.policyno like '%"+payDto.getPolicyno()+"%'");
        		}else if("=".equals(policynoSign)){
        			sb.append(" and prplregist.policyno = '"+payDto.getPolicyno()+"'");
        		}
        	}
        	//被保险人
        	if (!registDto.getInsuredName().equals("")) {
        		if("*".equals(insuredNameSign)){
        			sb.append(" and prplregist.insuredname like '%"+registDto.getInsuredName()+"%'");
        		}else if("=".equals(insuredNameSign)){
        			sb.append("and prplregist.insuredname = '"+registDto.getInsuredName()+"'");
        		}
        	}
        	//号牌号码
			if (!registDto.getLicenseNo().equals("")) {
				if("*".equals(licenseNoSign)){
					sb.append(" and prplregist.licenseNo like '%"+registDto.getLicenseNo()+"%'");
				}else if("=".equals(licenseNoSign)){
					sb.append(" and prplregist.licenseNo = '"+registDto.getLicenseNo()+"'");
				}
			}
			sb.append(" And Not Exists ");
			sb.append(" (Select 1 ");
			sb.append("          From Prplinterrelation Nn ");
			sb.append("        Where Nn.Relationregistno = Prplpay.Registno) ");
			sb.append(" And Not Exists ");//增加屏蔽新农险案件查询
			sb.append(" (Select 1 ");
			sb.append("          From prpcmain cm ");
			sb.append("        WHERE cm.policyno = PRPLPAY.Policyno AND cm.systemflag='agri') ");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return sb.toString();
    }
}
