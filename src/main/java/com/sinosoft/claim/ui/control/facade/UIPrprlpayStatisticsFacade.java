package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;
import com.sinosoft.claim.ui.view.formbean.PrplPayForm;
import com.sinosoft.claim.util.TurnPageUtil;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.workbench.claim.dto.domain.PrpLregistDto;

public class UIPrprlpayStatisticsFacade extends Action{
    public ActionForward execute(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        PrplpayDto payDto=new PrplpayDto();
        PrplPayForm payForm=(PrplPayForm)form;
        try {
        	 //每页显示多少条
            //int rowsPerPage =Integer.parseInt(AppConfig.get("sysconst.ROWS_PERPAGE"));
        	BLPrpLpaymainFacade blPrpLpaymainFacade  = new BLPrpLpaymainFacade();
        	Collection paymainList = new ArrayList();
            int rowsPerPage = TurnPageUtil.PERPAGE;
            //页数
            int pageNo     = Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")+"");
            String conditions=request.getParameter("conditions");
            if(null==conditions||"".equals(conditions))
            	conditions = this.getConditions(payForm,request);
            request.setAttribute("type", request.getParameter("type")) ;
            String type = request.getParameter("type");
            if("2".equals(type)){
            	PageRecord pr = blPrpLpaymainFacade
						.findPayStatisticsByConditions(conditions, 0, 0);
            	request.setAttribute("paymainList", pr.getResult());
        		return mapping.findForward("export");
            }
			PageRecord pr = blPrpLpaymainFacade
					.findPayStatisticsByConditions(conditions, pageNo,
							rowsPerPage);
			TurnPageDto pageDto = TurnPageUtil.getTurnPage(pr, request,
					conditions);
			payDto.setTurnPageDto(pageDto);
			paymainList = pr.getResult();
            String prevPageUrl = request.getParameter("prevPageUrl");
            request.setAttribute("prevPageUrl", prevPageUrl);
            request.setAttribute("paymainList", paymainList);
            request.setAttribute("payDto", payDto);
            request.setAttribute("conditions", conditions);
            if("4".equals(type))
            	return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
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
//        String userComCode = user.getComCode();
//        String mechanism = request.getParameter("mechanism");
//        String agnet = request.getParameter("agnet");
        String[] payStatus = request.getParameterValues("payStatus");//查询条件中的支付状态字段
        String type = request.getParameter("type");
        sb.append(" 1=1 ");
        //添加区分新农险数据标志
        sb.append(" and (registno in(select registno from swflog where (systemflag is null or systemflag <> 'agri') and nodetype='regis')");
        sb.append(" or registno in (select registno from swflogstore where (systemflag is null or systemflag <> 'agri') and nodetype='regis'))");
        if (user==null) {
			throw new Exception("session失效");
		}else {
//			if(type!=null&&"4".equals(type)){
//				UIPowerInterface uiPowerInterface = new UIPowerInterface();
//				String sqlStr = uiPowerInterface.addPower(user, "prplpaymain", "", "ComCode");
//				sb.append("   "+sqlStr+"  ");
//			}else{
//				sb.append(" and prplpaymain.operatorcode = '" + user.getUserCode() + "'");
//			}
		}
        try {
        	//加机构限定
        	String sqlComTmp = "";
        		if("3477000000".equals(user.getComCode())){
        			sqlComTmp = " and ee.comcode  in (select comcode from prpdcompany where speclevel like '0000000000/3488000000/3477000000/%') ";
        		}else{
					sqlComTmp = " and exists  (Select Comcode From Prpdcompany Yy "
							+ "where comcode = ee.comcode Start With Comcode = '"+user.getComCode()+"' "
							+ "Connect By nocycle Prior Comcode = Uppercomcode)";
		        }
			
        	//流入时间
        	StringBuffer sqlUnPaid = new StringBuffer("");
        	//保单号码
        	StringBuffer sqlPolicyNo = new StringBuffer("");
        	if (!payDto.getPolicyno().equals("")) {
        		if("*".equals(policynoSign)){
        			sqlPolicyNo.append(" and ee.policyno like '%"+payDto.getPolicyno().trim()+"%'");
        		}else if("=".equals(policynoSign)){
        			sqlPolicyNo.append(" and ee.policyno = '"+payDto.getPolicyno().trim()+"'");
        		}
        	}
        	//号牌号码
        	StringBuffer sqlLicenseNo = new StringBuffer("");
			if (!registDto.getLicenseNo().equals("")) {
				if("*".equals(licenseNoSign)){
					sqlLicenseNo.append(" and exists(select 1 from prplregist,prplclaim where prplregist.registno = prplclaim.registno ");
					sqlLicenseNo.append(" and prplclaim.claimno = ee.claimno and prplregist.licenseNo like '%"+registDto.getLicenseNo().trim()+"%' ) ");
				}else if("=".equals(licenseNoSign)){
					sqlLicenseNo.append(" and exists(select 1 from prplregist,prplclaim where prplregist.registno = prplclaim.registno ");
					sqlLicenseNo.append(" and prplclaim.claimno = ee.claimno and prplregist.licenseNo = '"+registDto.getLicenseNo().trim()+"')");
				}
			}
        	
        	sqlUnPaid.append(sqlPolicyNo);
        	sqlUnPaid.append(sqlLicenseNo);
        	String sqlPaid = sqlUnPaid.toString().replaceAll("ee", "yy");
        	sqlUnPaid.append(sqlComTmp);
        	sqlPaid+=sqlComTmp;
        	if(null!=inputDate1&&!"".equals(inputDate1)){
        		sqlUnPaid.append("and ee.underwriteEnddate >=  to_date('"+inputDate1+"','yyyy-mm-dd hh24:mi:ss')");
        		sqlPaid+="and ee.underwriteEnddate >=  to_date('"+inputDate1+"','yyyy-mm-dd hh24:mi:ss')";
        	}
        	if(null!=inputDate2&&!"".equals(inputDate2)){
        		sqlUnPaid.append("and ee.underwriteEnddate <=  to_date('"+inputDate2+"','yyyy-mm-dd hh24:mi:ss')");
        		sqlPaid+="and ee.underwriteEnddate <=  to_date('"+inputDate2+"','yyyy-mm-dd hh24:mi:ss')";
        	}
//        	sqlPaid += sqlPaid;
        	//任务状态
        	String strUnPaidStatus = "";
        	String strPaidStatus = "";
        	if(null!=payStatus&&payStatus.length>0){
	        	for(String str:payStatus){
	        		if(str.equals("Q")){
	        			strUnPaidStatus = "Q";
	        		}else if(str.length()>0){
	        			strPaidStatus +="'"+str+"',";
	        		}
	        	}
        	}
        	if(strPaidStatus.trim().length()>0){
        		strPaidStatus = new StringBuffer(strPaidStatus).insert(0," and exists(Select 1 From Prplpaymain Mm Where Mm.Paymentno = Yy.Serialno and Thirdpayflag in ( ").toString();
	        	strPaidStatus = strPaidStatus.substring(0, strPaidStatus.length()-1);
	        	strPaidStatus +="))";
        	}
        	sqlUnPaid.append(strUnPaidStatus);
        	sqlPaid = sqlPaid+strPaidStatus;
        	/*Select Registno
            From Prplclaim Mm
           Where Mm.Claimno = Ee.Claimno*/
        	//报案号码
        	if (!payDto.getRegistno().equals("")) {
        		if("*".equals(registnoSign)){
        			sqlUnPaid.append(" and exists(Select Registno From Prplclaim Mm Where Mm.Claimno = Ee.Claimno and Registno like '%"+payDto.getRegistno().trim()+"%')");
        			sqlPaid+=" and Yy.Registno like '%"+payDto.getRegistno().trim()+"%'";
        		}else if("=".equals(registnoSign)){
        			sqlUnPaid.append(" and exists(Select Registno From Prplclaim Mm Where Mm.Claimno = Ee.Claimno and Registno  = '"+payDto.getRegistno().trim()+"')");
        			sqlPaid+=" and Yy.Registno  = '"+payDto.getRegistno().trim()+"'";
        		}
        	}
        	/*Select Nn.Insuredname
            From Prpcmain Nn
           Where Nn.Policyno = Yy.Policyno*/
        	//被保险人
        	if (!registDto.getInsuredName().equals("")) {
        		if("*".equals(insuredNameSign)){
        			sqlUnPaid.append(" and exists(Select Nn.Insuredname From Prpcmain Nn Where Nn.Policyno = ee.Policyno and Insuredname like '%"+registDto.getInsuredName().trim()+"%')");
        			sqlPaid+=" and exists(Select Nn.Insuredname From Prpcmain Nn Where Nn.Policyno = Yy.Policyno and Insuredname like '%"+registDto.getInsuredName().trim()+"%')";
        		}else if("=".equals(insuredNameSign)){
        			sqlUnPaid.append(" and exists(Select Nn.Insuredname From Prpcmain Nn Where Nn.Policyno = ee.Policyno and Insuredname = '"+registDto.getInsuredName().trim()+"')");
        			sqlPaid+=" and exists(Select Nn.Insuredname From Prpcmain Nn Where Nn.Policyno = Yy.Policyno and Insuredname like '%"+registDto.getInsuredName().trim()+"%')";
        		}
        	}
        	sb.append(";"+sqlUnPaid.toString());
        	sb.append(";"+sqlPaid);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return sb.toString();
    }
}
