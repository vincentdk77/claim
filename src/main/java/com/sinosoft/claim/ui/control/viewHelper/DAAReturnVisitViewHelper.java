package com.sinosoft.claim.ui.control.viewHelper;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.bl.facade.BLPrpCinsuredFacade;
import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrpJpayRefRecFacade;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplcomplaintFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.bl.facade.BLPrplreturnvisitFacade;
import com.sinosoft.claim.bl.facade.BLPrplreturnvisitswflogFacade;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.ReturnVisitDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpJpayRefRecDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrplcomplaintDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIReturnVisitAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.platform.bl.facade.BLPrpDcodeFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utiall.blsvr.BLPrpDcode;

public class DAAReturnVisitViewHelper {
	
	/**
	 * 整理回访主表数据(自动生成回访主表数据)
	 * @param httpServletRequest
	 * @param registNo		报案号
	 * @param nodeType		当前节点
	 * @param state			回访案件状态
	 * @throws Exception
	 */
	public PrplreturnvisitswflogDto setReturnVisitSwflogDto(HttpServletRequest httpServletRequest,String registNo,String nodeType,String state) throws Exception{
		
		//通过业务号 获取报案号
		UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		//通过报案号查询报案信息
		PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
		if(prpLregistDto != null && !"".equals(prpLregistDto)){
			prplreturnvisitswflogDto.setBusinessno(prpLregistDto.getRegistNo());								//业务号
			prplreturnvisitswflogDto.setNodetype(nodeType);														//节点号
			prplreturnvisitswflogDto.setRegistno(prpLregistDto.getRegistNo());									//报案号
			prplreturnvisitswflogDto.setComcode(prpLregistDto.getComCode());									//承保机构			
			prplreturnvisitswflogDto.setPolicyno(prpLregistDto.getPolicyNo());
			UICodeAction uiCodeAction = new UICodeAction();
			String comName = uiCodeAction.translateComCode(prpLregistDto.getComCode(), true);
			prplreturnvisitswflogDto.setComcodename(comName);										//机构名称
			prplreturnvisitswflogDto.setInsuredname(prpLregistDto.getInsuredName());							//被保险人
			String reportd = prpLregistDto.getReportDate().toString();
			reportd = reportd+" "+prpLregistDto.getReportHour();
			DateTime d =new DateTime(reportd,DateTime.YEAR_TO_MONTH);
			prplreturnvisitswflogDto.setReportdate(d);			//报案时间
			if("sched".equals(nodeType)){
				
			}else{
				prplreturnvisitswflogDto.setCeasedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));													//结案时间
			}
			prplreturnvisitswflogDto.setLicenseno(prpLregistDto.getLicenseNo());								//车牌号
			prplreturnvisitswflogDto.setHandlercode(userDto.getUserCode());										//处理人代码
			prplreturnvisitswflogDto.setHandlername(userDto.getUserName());										//处理人名称
			prplreturnvisitswflogDto.setHandlercomcode(userDto.getComCode());									//处理人部门
			
			prplreturnvisitswflogDto.setFlowintotime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));//流入时间
			prplreturnvisitswflogDto.setClasscode(prpLregistDto.getClassCode());								//险类
			prplreturnvisitswflogDto.setState(state);															//状态
			prplreturnvisitswflogDto.setRiskCode(prpLregistDto.getRiskCode());
			
		}
		return prplreturnvisitswflogDto;
	}
	/**
	 * 整理回访主表数据(自动生成回访主表数据)
	 * @param httpServletRequest
	 * @param registNo		报案号
	 * @param nodeType		当前节点
	 * @param state			回访案件状态
	 * @throws Exception
	 */
	public PrplreturnvisitswflogDto setReturnVisitSwflogDtoNew(UserDto userDto,String registNo,String nodeType,String state) throws Exception{
		
		//通过业务号 获取报案号
		//UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		//通过报案号查询报案信息
		PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
		if(prpLregistDto != null && !"".equals(prpLregistDto)){
			prplreturnvisitswflogDto.setBusinessno(prpLregistDto.getRegistNo());								//业务号
			prplreturnvisitswflogDto.setNodetype(nodeType);														//节点号
			prplreturnvisitswflogDto.setRegistno(prpLregistDto.getRegistNo());									//报案号
			prplreturnvisitswflogDto.setComcode(prpLregistDto.getComCode());									//承保机构			
			prplreturnvisitswflogDto.setPolicyno(prpLregistDto.getPolicyNo());
			UICodeAction uiCodeAction = new UICodeAction();
			String comName = uiCodeAction.translateComCode(prpLregistDto.getComCode(), true);
			prplreturnvisitswflogDto.setComcodename(comName);										//机构名称
			prplreturnvisitswflogDto.setInsuredname(prpLregistDto.getInsuredName());							//被保险人
			String reportd = prpLregistDto.getReportDate().toString();
			reportd = reportd+" "+prpLregistDto.getReportHour();
			DateTime d =new DateTime(reportd,DateTime.YEAR_TO_MONTH);
			prplreturnvisitswflogDto.setReportdate(d);			//报案时间
			if("sched".equals(nodeType)){
				
			}else{
				prplreturnvisitswflogDto.setCeasedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));													//结案时间
			}
			prplreturnvisitswflogDto.setLicenseno(prpLregistDto.getLicenseNo());								//车牌号
			prplreturnvisitswflogDto.setHandlercode(userDto.getUserCode());										//处理人代码
			prplreturnvisitswflogDto.setHandlername(userDto.getUserName());										//处理人名称
			prplreturnvisitswflogDto.setHandlercomcode(userDto.getComCode());									//处理人部门
			
			prplreturnvisitswflogDto.setFlowintotime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));//流入时间
			prplreturnvisitswflogDto.setClasscode(prpLregistDto.getClassCode());								//险类
			prplreturnvisitswflogDto.setState(state);															//状态
			prplreturnvisitswflogDto.setRiskCode(prpLregistDto.getRiskCode());
			
		}
		return prplreturnvisitswflogDto;
	}

	
	
	/**
	 * 整理回访主表数据(自动生成结案回访主表数据)
	 * @param httpServletRequest
	 * @param registNo		报案号
	 * @param nodeType		当前节点
	 * @param state			回访案件状态
	 * @throws Exception
	 */
	public PrplreturnvisitswflogDto setReturnVisitSwflogDto(HttpServletRequest httpServletRequest,String registNo,String nodeType,String state,UserDto userDto) throws Exception{
		//通过业务号 获取报案号
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		//通过报案号查询报案信息
		PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
		if(prpLregistDto != null && !"".equals(prpLregistDto)){
			prplreturnvisitswflogDto.setBusinessno(prpLregistDto.getRegistNo());								//业务号
			prplreturnvisitswflogDto.setNodetype(nodeType);														//节点号
			prplreturnvisitswflogDto.setRegistno(prpLregistDto.getRegistNo());									//报案号
			prplreturnvisitswflogDto.setComcode(prpLregistDto.getComCode());									//承保机构
			prplreturnvisitswflogDto.setPolicyno(prpLregistDto.getPolicyNo());
			UICodeAction uiCodeAction = new UICodeAction();
			String comName = uiCodeAction.translateComCode(prpLregistDto.getComCode(), true);
			prplreturnvisitswflogDto.setComcodename(comName);										//机构名称
			prplreturnvisitswflogDto.setInsuredname(prpLregistDto.getInsuredName());							//被保险人
			String reportd = prpLregistDto.getReportDate().toString();
			reportd = reportd+" "+prpLregistDto.getReportHour();
			DateTime d =new DateTime(reportd,DateTime.YEAR_TO_MINUTE);
			prplreturnvisitswflogDto.setReportdate(d);			//报案时间
			if("sched".equals(nodeType)){
			}else{
				prplreturnvisitswflogDto.setCeasedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_MINUTE));													//结案时间
			}
			prplreturnvisitswflogDto.setLicenseno(prpLregistDto.getLicenseNo());								//车牌号
			prplreturnvisitswflogDto.setHandlercode(userDto.getUserCode());										//处理人代码
			prplreturnvisitswflogDto.setHandlername(userDto.getUserName());										//处理人名称
			prplreturnvisitswflogDto.setHandlercomcode(userDto.getComCode());									//处理人部门
			prplreturnvisitswflogDto.setFlowintotime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));//流入时间
			prplreturnvisitswflogDto.setClasscode(prpLregistDto.getClassCode());								//险类
			prplreturnvisitswflogDto.setState(state);															//状态
		}
		return prplreturnvisitswflogDto;
	}
	
	public PrplreturnvisitswflogDto complaintReturnVisitDto(String state){
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
		prplreturnvisitswflogDto.setFlowintotime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));	//流入时间
		prplreturnvisitswflogDto.setClasscode("05");								//险类
		prplreturnvisitswflogDto.setState(state);		
		return prplreturnvisitswflogDto;
	}

	/**
	 * 回访查询 搜集查询条件 整理sql语句
	 * @param httpServletRequest
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public String showViewToList(HttpServletRequest httpServletRequest,String stats) throws NumberFormatException, Exception{
		HttpSession session = httpServletRequest.getSession();
		UserDto user= (UserDto) session.getAttribute("user");
		String registNo 			= httpServletRequest.getParameter("registNo");				//报案号
		String prplregistrPolicyNo 	= httpServletRequest.getParameter("policyNo");				//保单号
		String licensenno 			= httpServletRequest.getParameter("licensenno");			//车牌号
		String reportdateBegin 		= httpServletRequest.getParameter("reportdateBegin");		//报案时间起始
		String reportdateEnd		= httpServletRequest.getParameter("reportdateEnd");			//报案时间终止
		String insuredname 			= httpServletRequest.getParameter("insuredname");			//被保险人
		String endcasedateBegin 	= httpServletRequest.getParameter("endcasedateBegin");		//结案时间起始
		String endcasedateEnd 		= httpServletRequest.getParameter("endcasedateEnd");		//结案时间终止
		String nodeType 			= httpServletRequest.getParameter("nodeType");				//回访类型
		String bycomplaintcomcode 	= httpServletRequest.getParameter("bycomplaintcomcode");	//被投诉机构
		String complaintdateBegin 	= httpServletRequest.getParameter("complaintdateBegin");	//投诉时间起始
		String complaintdateEnd 	= httpServletRequest.getParameter("complaintdateEnd");		//投诉时间终止
		String nodeMark             = httpServletRequest.getParameter("nodeMark");				//0:未回访，4：已回访成功，2已回访未成功，  024：全部
		String customerType         = httpServletRequest.getParameter("customerType");			//客户类型 ： 0 全部，1 个人，2单位
		String enteringtimeBegin	= httpServletRequest.getParameter("enteringtimeBegin");		//已回访时间开始
		String enteringtimeEnd		= httpServletRequest.getParameter("enteringtimeEnd");		//已回访时间结束
		String riskCode   			= httpServletRequest.getParameter("prpLregistRiskCode");    //险种
		
		
		if("20".equals(nodeMark)){//
			stats = "20";
		}else if("21".equals(nodeMark)){
			stats = "21";
		}else if("0".equals(nodeMark)){
			stats = "0";
		}else if("4".equals(nodeMark)){
			stats = "4";
		}else if("024".equals(nodeMark)){
			stats = "024";
		}
		String conditions = " 1=1 ";
		
        String comCode=user.getComCode();   
        //权限判断
        if (!"0000000000".equals(comCode)) {
        	conditions=conditions+" and g.comcode in (select comcode from prpdcompany ";
        	conditions=conditions+" connect  by prior comcode=uppercomcode start with  comcode='"+comCode+"') ";
		}
       
		if(registNo != null && registNo.length()>0){
			conditions = conditions+StringConvert.convertString(" g.businessno", registNo,httpServletRequest.getParameter("registNoSign"));
		}
		
		if(prplregistrPolicyNo != null && prplregistrPolicyNo.length()>0){
			conditions = conditions+StringConvert.convertString(" y.policyNo", prplregistrPolicyNo,httpServletRequest.getParameter("policyNoSign"));
		}
		
		if(licensenno != null && licensenno.length()>0){
			conditions = conditions+StringConvert.convertString(" g.licenseno", licensenno,httpServletRequest.getParameter("licensennoSign"));
		}
		
		if(insuredname != null && insuredname.length()>0){
			conditions = conditions+StringConvert.convertString(" g.insuredname", insuredname,httpServletRequest.getParameter("insurednameSign"));
		}
		if(riskCode != null && riskCode.length()>0){
			conditions = conditions+StringConvert.convertString(" g.riskCode", riskCode,httpServletRequest.getParameter("RiskCodeSign"));
			System.out.println(conditions);
		}
		if(reportdateBegin != null && reportdateBegin.length()>0){
			//strReturn = " and " + strName + strSign + "to_date('" + strValue.trim() + "','YYYY-MM-DD') ";
			conditions = conditions+" and r.reportdate >= to_date('" + reportdateBegin.trim() + " 00:00:00"+"','YYYY-MM-DD hh24:mi:ss') ";
			//conditions = conditions+StringConvert.convertDate(" g.reportdate", reportdateBegin+" 00:00:00",">=");
		}
		
		if(reportdateEnd != null && reportdateEnd.length()>0){
			conditions = conditions+" and r.reportdate <= to_date('" + reportdateEnd.trim() +" 23:59:59"+ "','YYYY-MM-DD hh24:mi:ss') ";
			//conditions = conditions+StringConvert.convertDate(" g.reportdate", reportdateEnd+" 23:59:59","<=");
		}
		
		if(endcasedateBegin != null && endcasedateBegin.length()>0){
			conditions = conditions+" and g.ceasedate >= to_date('" + endcasedateBegin.trim() + " 00:00:00"+"','YYYY-MM-DD hh24:mi:ss') ";
			//conditions = conditions+StringConvert.convertDate(" g.ceasedate", endcasedateBegin+" 00:00:00",">=");
		}
		
		if(endcasedateEnd != null && endcasedateEnd.length()>0){
			conditions = conditions+" and g.ceasedate <= to_date('" + endcasedateEnd.trim() + " 23:59:59"+"','YYYY-MM-DD hh24:mi:ss') ";
			//conditions = conditions+StringConvert.convertDate(" g.ceasedate", endcasedateEnd+" 23:59:59","<=");
		}
		
		if(nodeType != null && nodeType.length()>0){
			if("0".equals(nodeType)){
				conditions = conditions+" and g.nodeType in ('sched','endca')";
			}else{
				conditions = conditions+StringConvert.convertString(" g.nodeType", nodeType,"=");
			}
		}
		
		if("4".equals(stats)){//当参数是4的时候查询所有回访成功信息
			conditions = conditions+StringConvert.convertString(" g.state", stats,"=");
		}else if("34".equals(stats)){
			conditions = conditions+" and state != '4'";
		}else if("5".equals(stats)){
			conditions = conditions+" and state = '4' and complaintno In (Select businessno From prplreturnvisitswflog Where state != '4')";
		}else if("20".equals(stats)){
			conditions = conditions+" and (g.state = '2' or g.state = '20') ";
		}else if("21".equals(stats)){
			conditions = conditions+" and g.state = '21'";
		}else if("024".equals(stats)){
			conditions = conditions+" and 1 = 1";
		}else if("0".equals(stats)){
			conditions = conditions+" and g.state = '0'";
		}else{
			conditions = conditions+" and g.state != '4'";
		}
		
		if(complaintdateBegin != null && complaintdateBegin.length()>0){
			//conditions = conditions+StringConvert.convertDate(" complaintdate", complaintdateBegin,">=");
			conditions = conditions+" and complaintdate >= to_date('" + complaintdateBegin.trim() + " 00:00:00"+"','YYYY-MM-DD hh24:mi:ss') ";
		}
		
		if(complaintdateEnd != null && complaintdateEnd.length()>0){
			//conditions = conditions+StringConvert.convertDate(" complaintdate", complaintdateEnd,"<=");
			conditions = conditions+" and complaintdate <= to_date('" + complaintdateEnd.trim() + " 23:59:59"+"','YYYY-MM-DD hh24:mi:ss') ";
		}
		
		if(bycomplaintcomcode != null && bycomplaintcomcode.length()>0){
			conditions = conditions+StringConvert.convertString(" bycomplaintcomcode", bycomplaintcomcode,httpServletRequest.getParameter("bycomplaintcomcodeSign"));
		}
		if(customerType != null && customerType.length()>0){
			if("1".equals(customerType)||"2".equals(customerType)){
				if(!"compl".equals(nodeType)){
					conditions = conditions + "  and exists (select 1 from prpdcustomer d  where d.customercode = r.insuredcode and customertype = '"+customerType+"') ";
				}
			}
		}
		
		if("endca".equals(nodeType)){
			String payType   = httpServletRequest.getParameter("payType");//支付标志：0--已支付，1--未支付，2--全部
			String paydateBegin   = httpServletRequest.getParameter("paydateBegin");
			String paydateEnd   = httpServletRequest.getParameter("paydateEnd");
			if("0".equals(payType)){
				conditions = conditions
						+ " and exists (select 1 from prplclaim c  where g.businessno =  c.registno and  exists (select 1 from prpjpayrefrec rf  "
						+ " where c.claimno = rf.claimno and rf.certitype in ('C', 'Y') and rf.payrefreason in ('P50', 'P60') and rf.payrefdate is not null ";
				if(paydateBegin != null && paydateBegin.length()>0){
					conditions = conditions + "  and rf.payrefdate >= to_date('" + paydateBegin.trim() + "','YYYY-MM-DD')  ";
				}
				if(paydateEnd != null && paydateEnd.length()>0){
					conditions = conditions + "  and rf.payrefdate <= to_date('" + paydateEnd.trim() + "','YYYY-MM-DD')  ";
				}
				stats = "6" ;
				conditions = conditions + " and rf.planfee = rf.payreffee  and rf.planfee >= 0)) ";
			}else if("1".equals(payType)){
				conditions = conditions + " and not exists (select 1 from prplclaim c  where g.businessno =  c.registno and  exists (select 1 from prpjpayrefrec rf  where c.claimno = rf.claimno and rf.certitype in ('C', 'Y') and rf.payrefreason in ('P50', 'P60') and rf.payrefdate is not null and rf.planfee = rf.payreffee  and rf.planfee >= 0)) ";
			}else if("2".equals(payType)){
				conditions = conditions + " and 1 = 1 ";
			}
		}
		//符合存在回访时间记录，且最后一次回访为准
		if((enteringtimeBegin != null && enteringtimeBegin.length()>0) || 
				(enteringtimeEnd != null && enteringtimeEnd.length()>0)){
			conditions = conditions + " AND EXISTS (SELECT 1 FROM PRPLRETURNVISIT RT WHERE G.BUSINESSNO = RT.BUSINESSNO ";
			if(nodeType != null && nodeType.length()>0){
				if("0".equals(nodeType)){
					conditions = conditions + " AND RT.NODETYPE IN ('sched','endca') ";
				}else{
					conditions = conditions + " AND RT.NODETYPE = '" + nodeType + "' ";
				}
			}
			if(enteringtimeBegin != null && enteringtimeBegin.length()>0){
				conditions = conditions + " AND RT.ENTERINGTIME > TO_DATE('" + enteringtimeBegin.trim() + " 00:00:00"+"','YYYY-MM-DD hh24:mi:ss') ";
			}
			if(enteringtimeEnd != null && enteringtimeEnd.length()>0){
				conditions = conditions + " AND RT.ENTERINGTIME <= TO_DATE('" + enteringtimeEnd.trim() + " 23:59:59"+"','YYYY-MM-DD hh24:mi:ss') ";
			}
			conditions = conditions +" AND SERIALNO = (SELECT MAX(SERIALNO) FROM PRPLRETURNVISIT RV WHERE RV.BUSINESSNO = RT.BUSINESSNO)) ";
		}
		if("".equals(stats)){
		  conditions = conditions + " order by flowintotime desc";
		}else if("5".equals(stats)){
		  conditions = conditions + " order by Handlerdate desc";	
		}else if("4".equals(stats)){
		  conditions = conditions + " order by g.ceasetime desc";	
		}else if("024".equals(stats)){
		  conditions = conditions + " order by g.ceasetime desc";
		}else if ("6".equals(stats)){//结案回访按照支付日期排序
		  conditions = conditions + " order by payrefdate desc, g.ceasetime desc";
		}

		return conditions;
		
	}
	
	/**
	 * 回访查询
	 * @param httpServletRequest
	 * @param conditions
	 * @return
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public ArrayList<PrplreturnvisitswflogDto> showReturnVisitList(HttpServletRequest httpServletRequest,String conditions) throws NumberFormatException, Exception{
		String nodeType = httpServletRequest.getParameter("nodeType");
		String condition = httpServletRequest.getParameter("condition");
		
		UIReturnVisitAction biReturnVisitAction = new UIReturnVisitAction();
		
		ArrayList<PrplreturnvisitswflogDto> prplreturnvisitswflogDtolist = new ArrayList<PrplreturnvisitswflogDto>();
		String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");//每页条数配置获得
		String pageNo     = httpServletRequest.getParameter("pageNo");
		if(pageNo == null || "".equals(pageNo)){
			pageNo = "1";
		}
		if(condition != null && !"".equals(condition)){
			conditions = condition;
		}
		PageRecord pageRecord = new PageRecord(0,Integer.parseInt(pageNo),1,Integer.parseInt(recordPerPage),new ArrayList());
		if("endca".equals(nodeType)){
			pageRecord = biReturnVisitAction.findByQueryConditionsEndca(conditions, Integer.parseInt(pageNo), Integer.parseInt(recordPerPage));
		}else{
			pageRecord = biReturnVisitAction.findByQueryConditions(conditions, Integer.parseInt(pageNo), Integer.parseInt(recordPerPage));
			
		}
		prplreturnvisitswflogDtolist = (ArrayList<PrplreturnvisitswflogDto>) pageRecord.getResult();
		
		TurnPageDto turnPageDto = new TurnPageDto();
		// 查询出来的一页的结构集
		turnPageDto.setResultList(prplreturnvisitswflogDtolist);
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
		turnPageDto.setCondition(conditions);
		
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
		prplreturnvisitswflogDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("prplreturnvisitswflogDto", prplreturnvisitswflogDto);
		
		//关联保单
		BLPrpLRegistRPolicyFacade blPrpLRegistRPolicyFacade = new BLPrpLRegistRPolicyFacade();
		UICodeAction uiCodeAction = new UICodeAction();
		
		BLPrplreturnvisitFacade blPrplreturnvisitFacade = new BLPrplreturnvisitFacade();
		
		for(PrplreturnvisitswflogDto prplreturnvisitswflog : prplreturnvisitswflogDtolist){
			String policyNo="";
			String sql = " registNo='"+prplreturnvisitswflog.getRegistno()+"' and validstatus='1'";
			ArrayList<PrpLRegistRPolicyDto> prpLRegistRPolicyDtoList = (ArrayList<PrpLRegistRPolicyDto>) blPrpLRegistRPolicyFacade.findByConditions(sql);
			if(!prpLRegistRPolicyDtoList.isEmpty()){
				for(PrpLRegistRPolicyDto prpLRegistRPolicyDto : prpLRegistRPolicyDtoList){
					policyNo = policyNo+prpLRegistRPolicyDto.getPolicyNo()+"<br/>";
				}
				prplreturnvisitswflog.setPolicyno(policyNo);
			}
			//已回访次数
			String serialno = "0";
			//联系电话 tel
			String tel = "";
			PrpLregistDto prpLregistDto = new PrpLregistDto();
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			prpLregistDto = blPrpLregistFacade.findByPrimaryKey(prplreturnvisitswflog.getRegistno());
			//如果是结案回访，增加 赔付金额（不含费用），已支付金额
			if("endca".equals(nodeType)){
				DecimalFormat format = new DecimalFormat("###0.00");
				String policyNo2="";
				Double sumpaid = 0d;//赔付金额
				Double sumprepaid = 0d;//已赔付金额
				String claimno = "";//由立案号组成的条件字符串，
				String endcaseno = "";//结案号
				sql = " registNo='"+prplreturnvisitswflog.getRegistno()+"'  and endCaserCode is not null and endCaseDate is not null";
				BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
				ArrayList<PrpLclaimDto> prpLclaimDtoList = (ArrayList<PrpLclaimDto>)blPrpLclaimFacade.findByConditions(sql); 
				if(!prpLclaimDtoList.isEmpty()){
					for (PrpLclaimDto prpLclaimDto : prpLclaimDtoList) {
						//结案号结果拼接
						endcaseno = endcaseno+prpLclaimDto.getCaseNo()+"<br/>";
						//立案号条件拼接
						claimno = claimno+"'"+prpLclaimDto.getClaimNo()+"'"+","; 
					}
					prplreturnvisitswflog.setEndcaseno(endcaseno);
					claimno = claimno.substring(0, claimno.length()-1);
					prplreturnvisitswflog.setEndCaseDate(prpLclaimDtoList.get(0).getEndCaseDate().toString());
					
				}
				if("".equals(claimno)){
					claimno = "''";
				}
				sql = "  claimno in ("+claimno+")";
				BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
				ArrayList<PrpLcompensateDto> prpLcompensateDtoList = new ArrayList<PrpLcompensateDto>();
				prpLcompensateDtoList = (ArrayList<PrpLcompensateDto>) blPrpLcompensateFacade.findByConditions(sql);
				if(!prpLcompensateDtoList.isEmpty()){
					for (PrpLcompensateDto prpLcompensateDto : prpLcompensateDtoList) {
						sumpaid+=prpLcompensateDto.getSumDutyPaid();
					}
					//赔付金额
					prplreturnvisitswflog.setSumpaid(Double.parseDouble(format.format(sumpaid)));
				}
				
				BLPrplreturnvisitswflogFacade blPrplreturnvisitswflogFacade = new BLPrplreturnvisitswflogFacade();
				sql = " certitype in ('C','Y') and PayRefReason in ('P50','P60') and payrefdate is not null and  claimno in ("+claimno+")";
				BLPrpJpayRefRecFacade bLPrpJpayRefRecFacade =  new BLPrpJpayRefRecFacade();
				ArrayList<PrpJpayRefRecDto> jpayrefrecList = new ArrayList<PrpJpayRefRecDto>();
				jpayrefrecList = (ArrayList<PrpJpayRefRecDto>)bLPrpJpayRefRecFacade.findByConditions(sql);
				String strPayRefDate1 = "";
				String strPayRefDate2 = "";
				if(jpayrefrecList.size() > 0){
					strPayRefDate1 = jpayrefrecList.get(0).getPayRefDate().toString();
					for(int i = 0;i < jpayrefrecList.size();i++){
						PrpJpayRefRecDto prpJpayRefRecDto = new PrpJpayRefRecDto();
						prpJpayRefRecDto = jpayrefrecList.get(i);
						sumprepaid += prpJpayRefRecDto.getPayRefFee();
						strPayRefDate2 = jpayrefrecList.get(i).getPayRefDate().toString();
						if(strPayRefDate2.compareTo(strPayRefDate1) < 0 ){
							strPayRefDate1 = strPayRefDate2;
						}
					}
				}
				//已支付金额
				prplreturnvisitswflog.setSumprepaid(Double.parseDouble(format.format(sumprepaid)));
				prplreturnvisitswflog.setPayRefDate(strPayRefDate1);
			}
			
			if("compl".equals(nodeType)){
				String bycomplaintcomcodeName = uiCodeAction.translateComCode(prplreturnvisitswflog.getBycomplaintcomcode(), true);
				prplreturnvisitswflog.setBycomplaintcomcodeName(bycomplaintcomcodeName);
			}else{
				String conditionSql = "businessno='"+prplreturnvisitswflog.getBusinessno()+"' and nodetype = '"+nodeType+"' Order By serialno Desc";
				ArrayList<PrplreturnvisitDto> prplreturnvisitDtoList = (ArrayList<PrplreturnvisitDto>) blPrplreturnvisitFacade.findByConditions(conditionSql);
				if(prplreturnvisitDtoList != null && prplreturnvisitDtoList.size()>0){
					prplreturnvisitswflog.setEnteringtime(prplreturnvisitDtoList.get(0).getEnteringtime().toString());
					prplreturnvisitswflog.setEnteringname(prplreturnvisitDtoList.get(0).getEnteringname());
					prplreturnvisitswflog.setExltel(prplreturnvisitDtoList.get(0).getContact());//属性 导出Excel电话号码
					serialno = prplreturnvisitDtoList.get(0).getSerialno();
				}
				prplreturnvisitswflog.setSerialno(serialno);//已回访次数
			}
			
			//联系电话
			if("endca".equals(nodeType) || "sched".equals(nodeType)){
				if(!"".equals(prpLregistDto.getPhoneNumber())){
					tel = prpLregistDto.getPhoneNumber();
				}else if(!"".equals(prpLregistDto.getInsuredPhone())){
					tel = prpLregistDto.getInsuredPhone();
				}else {
					String condition1 = "policyno = '"+prpLregistDto.getPolicyNo()+"' and insuredflag = '1'";
					BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade();
					Collection<PrpCinsuredDto> prpcinsuredDtoList = blPrpCinsuredFacade.findByConditions(condition1);
					if(null != prpcinsuredDtoList && prpcinsuredDtoList.size() > 0){
						Iterator<PrpCinsuredDto> it = prpcinsuredDtoList.iterator();
						PrpCinsuredDto prpCinsuredDto = new PrpCinsuredDto();
						while(it.hasNext()){
							prpCinsuredDto = it.next();
						}
						if(!"".equals(prpCinsuredDto.getMobile())){
							tel = prpCinsuredDto.getMobile();
						}else {
							tel = prpCinsuredDto.getPhoneNumber();
						}
					}
				/*	BLPrpDcustomerFacade blPrpDcustomerFacade = new BLPrpDcustomerFacade();
					PrpDcustomerDto prpDcustomerDto = blPrpDcustomerFacade.findByPrimaryKey(prpLregistDto.getInsuredCode());
					if("1".equals(prpDcustomerDto.getCustomerType())){//个人客户
						PrpDcustomerIdvDto prpDcustomerIdvDto = new BLPrpDcustomerIdvFacade().findByPrimaryKey(prpLregistDto.getInsuredCode());
						if(!"".equals(prpDcustomerIdvDto.getMobile())){
							tel = prpDcustomerIdvDto.getMobile();
						}else {
							tel = prpDcustomerIdvDto.getPhoneNumber();
						}
					}
					if("2".equals(prpDcustomerDto.getCustomerType())){//集体客户
						PrpDcustomerUnitDto prpDcustomerUnitDto = new BLPrpDcustomerUnitFacade().findByPrimaryKey(prpLregistDto.getInsuredCode());
						if(!"".equals(prpDcustomerUnitDto.getMobile())){
							tel = prpDcustomerUnitDto.getMobile();
						}else {
							tel = prpDcustomerUnitDto.getPhoneNumber();
						}
					}*/
				}
				prplreturnvisitswflog.setTel(tel);
				//报案电话
				prplreturnvisitswflog.setReportorPhoneNumber(prpLregistDto.getReportorPhoneNumber());
			}
			
			String visitCondition = " businessNo='"+prplreturnvisitswflog.getBusinessno()+"' and nodeType='"+nodeType+"' order by serialno desc";
			BLPrpDcodeFacade blPrpDcodeFacade = new BLPrpDcodeFacade();
			//存在问题 visitIssue
			ArrayList<com.sinosoft.platform.dto.domain.PrpDcodeDto> prpDcodeVisitIssue = (ArrayList<com.sinosoft.platform.dto.domain.PrpDcodeDto>) blPrpDcodeFacade.findByConditions(" codeType='visitIssue' order by codecode ");
			//满意度 satisfied
			ArrayList<com.sinosoft.platform.dto.domain.PrpDcodeDto> prpDcodeSatisfied = (ArrayList<com.sinosoft.platform.dto.domain.PrpDcodeDto>) blPrpDcodeFacade.findByConditions(" codeType='satisfied'");
			//回访子表集合
			ArrayList<PrplreturnvisitDto> prplreturnvisitDtoList = (ArrayList<PrplreturnvisitDto>) blPrplreturnvisitFacade.findByConditions(visitCondition);
			if(prplreturnvisitDtoList != null &&prplreturnvisitDtoList.size()>0 ){
				String existIssueCode = prplreturnvisitDtoList.get(0).getExistissue();
				String serviceCode = prplreturnvisitDtoList.get(0).getService();
				String existIssueName = "";
				String serviceName = "";
				for (int i = 0 ;i<prpDcodeSatisfied.size();i++) {
					com.sinosoft.platform.dto.domain.PrpDcodeDto prpDcodeDto = prpDcodeSatisfied.get(i); 
					if(serviceCode.equals(prpDcodeDto.getCodeCode())){
						serviceName = prpDcodeDto.getCodeCName();
					}
				}
				String[] issueCodes = existIssueCode.split(";");
				for (int j = 0; j < issueCodes.length; j++) {
					for (int i = 0 ;i<prpDcodeVisitIssue.size();i++) {
						com.sinosoft.platform.dto.domain.PrpDcodeDto prpDcodeDto =prpDcodeVisitIssue.get(i); 
						if(issueCodes[j].equals(prpDcodeDto.getCodeCode())){
							existIssueName += String.valueOf(j+1)+"."+ prpDcodeDto.getCodeCName()+";";
						}
					}
				}
				
				prplreturnvisitswflog.setServiceSelect(serviceName);
				prplreturnvisitswflog.setExistIssue(existIssueName);
			}
		
			if("4".equals(prplreturnvisitswflog.getState())){
				prplreturnvisitswflog.setNodeMark("已回访已成功");
			}else if("0".equals(prplreturnvisitswflog.getState())){
				prplreturnvisitswflog.setNodeMark("未回访");
			}else if("2".equals(prplreturnvisitswflog.getState())){
				prplreturnvisitswflog.setNodeMark("已回访未成功");
			}else if("20".equals(prplreturnvisitswflog.getState())){
				prplreturnvisitswflog.setNodeMark("已回访未成功（无需跟进）");
			}else if("21".equals(prplreturnvisitswflog.getState())){
				prplreturnvisitswflog.setNodeMark("已回访未成功（需跟进）");
			}
		}
		return prplreturnvisitswflogDtolist;
	}
	
	/**
	 * 回访查询
	 * @param httpServletRequest
	 * @param conditions
	 * @return
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public ArrayList<PrplreturnvisitswflogDto> showAllReturnVisitList(HttpServletRequest httpServletRequest,String conditions) throws NumberFormatException, Exception{
		String nodeType = httpServletRequest.getParameter("nodeType");
		String condition = httpServletRequest.getParameter("condition");
		
		UIReturnVisitAction biReturnVisitAction = new UIReturnVisitAction();
		BLPrpDcode blPrpDcode = new BLPrpDcode();
		
		ArrayList<PrplreturnvisitswflogDto> prplreturnvisitswflogDtolist = new ArrayList<PrplreturnvisitswflogDto>();
		String recordPerPage ="0";
		String pageNo     ="0";
		if(pageNo == null || "".equals(pageNo)){
			pageNo = "1";
		}
		if(condition != null && !"".equals(condition)){
			conditions = condition;
		}
		
		if("endca".equals(nodeType)){
			prplreturnvisitswflogDtolist = (ArrayList<PrplreturnvisitswflogDto>)biReturnVisitAction.findByQueryExpConditionsEndca(conditions, Integer.parseInt(pageNo), Integer.parseInt(recordPerPage));
		}else{
			prplreturnvisitswflogDtolist = (ArrayList<PrplreturnvisitswflogDto>)biReturnVisitAction.findByQueryExpConditions(conditions, Integer.parseInt(pageNo), Integer.parseInt(recordPerPage));
		}
			
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
		httpServletRequest.setAttribute("prplreturnvisitswflogDto", prplreturnvisitswflogDto);
		
		//关联保单
		BLPrpLRegistRPolicyFacade blPrpLRegistRPolicyFacade = new BLPrpLRegistRPolicyFacade();
		UICodeAction uiCodeAction = new UICodeAction();
		
		BLPrplreturnvisitFacade blPrplreturnvisitFacade = new BLPrplreturnvisitFacade();
		
		for(PrplreturnvisitswflogDto prplreturnvisitswflog : prplreturnvisitswflogDtolist){
			String policyNo="";
			String sql = " registNo='"+prplreturnvisitswflog.getRegistno()+"' and validstatus='1'";
			ArrayList<PrpLRegistRPolicyDto> prpLRegistRPolicyDtoList = (ArrayList<PrpLRegistRPolicyDto>) blPrpLRegistRPolicyFacade.findByConditions(sql);
			if(!prpLRegistRPolicyDtoList.isEmpty()){
				for(PrpLRegistRPolicyDto prpLRegistRPolicyDto : prpLRegistRPolicyDtoList){
					policyNo = policyNo+prpLRegistRPolicyDto.getPolicyNo()+"<br/>";
				}
				prplreturnvisitswflog.setPolicyno(policyNo);
			}
			//已回访次数
			String serialno = "0";
			//联系电话 tel
			String tel = "";
			PrpLregistDto prpLregistDto = new PrpLregistDto();
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			prpLregistDto = blPrpLregistFacade.findByPrimaryKey(prplreturnvisitswflog.getRegistno());
			//如果是结案回访，增加 赔付金额（不含费用），已支付金额
			if("endca".equals(nodeType)){
				DecimalFormat format = new DecimalFormat("###0.00");
				String policyNo2="";
				Double sumpaid = 0d;//赔付金额
				Double sumprepaid = 0d;//已赔付金额
				String claimno = "";//由立案号组成的条件字符串，
				String endcaseno = "";//结案号
				sql = " registNo='"+prplreturnvisitswflog.getRegistno()+"'  and endCaserCode is not null and endCaseDate is not null";
				BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
				ArrayList<PrpLclaimDto> prpLclaimDtoList = (ArrayList<PrpLclaimDto>)blPrpLclaimFacade.findByConditions(sql); 
				if(!prpLclaimDtoList.isEmpty()){
					for (PrpLclaimDto prpLclaimDto : prpLclaimDtoList) {
						//结案号结果拼接
						endcaseno = endcaseno+prpLclaimDto.getCaseNo()+"<br/>";
						//立案号条件拼接
						claimno = claimno+"'"+prpLclaimDto.getClaimNo()+"'"+","; 
					}
					prplreturnvisitswflog.setEndcaseno(endcaseno);
					claimno = claimno.substring(0, claimno.length()-1);
					prplreturnvisitswflog.setEndCaseDate(prpLclaimDtoList.get(0).getEndCaseDate().toString());
					
				}
				if("".equals(claimno)){
					claimno = "''";
				}
				sql = "  claimno in ("+claimno+")";
				BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
				ArrayList<PrpLcompensateDto> prpLcompensateDtoList = new ArrayList<PrpLcompensateDto>();
				prpLcompensateDtoList = (ArrayList<PrpLcompensateDto>) blPrpLcompensateFacade.findByConditions(sql);
				if(!prpLcompensateDtoList.isEmpty()){
					for (PrpLcompensateDto prpLcompensateDto : prpLcompensateDtoList) {
						sumpaid+=prpLcompensateDto.getSumDutyPaid();
					}
					//赔付金额
					prplreturnvisitswflog.setSumpaid(Double.parseDouble(format.format(sumpaid)));
				}
				
				BLPrplreturnvisitswflogFacade blPrplreturnvisitswflogFacade = new BLPrplreturnvisitswflogFacade();
				sql = " certitype in ('C','Y') and PayRefReason in ('P50','P60') and payrefdate is not null and  claimno in ("+claimno+")";
				BLPrpJpayRefRecFacade bLPrpJpayRefRecFacade =  new BLPrpJpayRefRecFacade();
				ArrayList<PrpJpayRefRecDto> jpayrefrecList = new ArrayList<PrpJpayRefRecDto>();
				jpayrefrecList = (ArrayList<PrpJpayRefRecDto>)bLPrpJpayRefRecFacade.findByConditions(sql);
				String strPayRefDate1 = "";
				String strPayRefDate2 = "";
				if(jpayrefrecList.size() > 0){
					strPayRefDate1 = jpayrefrecList.get(0).getPayRefDate().toString();
					for(int i = 0;i < jpayrefrecList.size();i++){
						PrpJpayRefRecDto prpJpayRefRecDto = new PrpJpayRefRecDto();
						prpJpayRefRecDto = jpayrefrecList.get(i);
						sumprepaid += prpJpayRefRecDto.getPayRefFee();
						strPayRefDate2 = jpayrefrecList.get(i).getPayRefDate().toString();
						if(strPayRefDate2.compareTo(strPayRefDate1) < 0 ){
							strPayRefDate1 = strPayRefDate2;
						}
					}
				}
				//已支付金额
				prplreturnvisitswflog.setSumprepaid(Double.parseDouble(format.format(sumprepaid)));
				prplreturnvisitswflog.setPayRefDate(strPayRefDate1);
			}
			
			if("compl".equals(nodeType)){
				String bycomplaintcomcodeName = uiCodeAction.translateComCode(prplreturnvisitswflog.getBycomplaintcomcode(), true);
				prplreturnvisitswflog.setBycomplaintcomcodeName(bycomplaintcomcodeName);
			}else{
				String conditionSql = "businessno='"+prplreturnvisitswflog.getBusinessno()+"' and nodetype = '"+nodeType+"' Order By serialno Desc";
				ArrayList<PrplreturnvisitDto> prplreturnvisitDtoList = (ArrayList<PrplreturnvisitDto>) blPrplreturnvisitFacade.findByConditions(conditionSql);
				if(prplreturnvisitDtoList != null && prplreturnvisitDtoList.size()>0){
					prplreturnvisitswflog.setEnteringtime(prplreturnvisitDtoList.get(0).getEnteringtime().toString());
					prplreturnvisitswflog.setEnteringname(prplreturnvisitDtoList.get(0).getEnteringname());
					prplreturnvisitswflog.setExltel(prplreturnvisitDtoList.get(0).getContact());
					prplreturnvisitswflog.setServiceName(blPrpDcode.translateCode
							("satisfied", prplreturnvisitDtoList.get(0).getService(), true));
					prplreturnvisitswflog.setRecorderNo(prplreturnvisitDtoList.get(0).getRecorderno());
					prplreturnvisitswflog.setVisitOpinion(prplreturnvisitDtoList.get(0).getVisitopinion());
					serialno = prplreturnvisitDtoList.get(0).getSerialno();
				}
				prplreturnvisitswflog.setSerialno(serialno);//已回访次数
			}
			
			//联系电话
			if("endca".equals(nodeType) || "sched".equals(nodeType)){
				if(!"".equals(prpLregistDto.getInsuredMobilePhone())){
					tel = prpLregistDto.getInsuredMobilePhone();
				}else if(!"".equals(prpLregistDto.getInsuredPhone())){
					tel = prpLregistDto.getInsuredPhone();
				}else {
					String condition1 = "policyno = '"+prpLregistDto.getPolicyNo()+"' and insuredflag = '1'";
					BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade();
					Collection<PrpCinsuredDto> prpcinsuredDtoList = blPrpCinsuredFacade.findByConditions(condition1);
					if(null != prpcinsuredDtoList && prpcinsuredDtoList.size() > 0){
						Iterator<PrpCinsuredDto> it = prpcinsuredDtoList.iterator();
						PrpCinsuredDto prpCinsuredDto = new PrpCinsuredDto();
						while(it.hasNext()){
							prpCinsuredDto = it.next();
						}
						if(!"".equals(prpCinsuredDto.getMobile())){
							tel = prpCinsuredDto.getMobile();
						}else {
							tel = prpCinsuredDto.getPhoneNumber();
						}
					}
				 /* BLPrpDcustomerFacade blPrpDcustomerFacade = new BLPrpDcustomerFacade();
					PrpDcustomerDto prpDcustomerDto = blPrpDcustomerFacade.findByPrimaryKey(prpLregistDto.getInsuredCode());
					if("1".equals(prpDcustomerDto.getCustomerType())){//个人客户
						PrpDcustomerIdvDto prpDcustomerIdvDto = new BLPrpDcustomerIdvFacade().findByPrimaryKey(prpLregistDto.getInsuredCode());
						if(!"".equals(prpDcustomerIdvDto.getMobile())){
							tel = prpDcustomerIdvDto.getMobile();
						}else {
							tel = prpDcustomerIdvDto.getPhoneNumber();
						}
					}
					if("2".equals(prpDcustomerDto.getCustomerType())){//集体客户
						PrpDcustomerUnitDto prpDcustomerUnitDto = new BLPrpDcustomerUnitFacade().findByPrimaryKey(prpLregistDto.getInsuredCode());
						if(!"".equals(prpDcustomerUnitDto.getMobile())){
							tel = prpDcustomerUnitDto.getMobile();
						}else {
							tel = prpDcustomerUnitDto.getPhoneNumber();
						}
					}*/
				}
				prplreturnvisitswflog.setTel(tel);
				//报案电话
				prplreturnvisitswflog.setReportorPhoneNumber(prpLregistDto.getReportorPhoneNumber());
			}
			String visitCondition = " businessNo='"+prplreturnvisitswflog.getBusinessno()+"' and nodeType='"+nodeType+"' order by serialno desc";
			//存在问题 visitIssue
			BLPrpDcodeFacade blPrpDcodeFacade = new BLPrpDcodeFacade();
			ArrayList<com.sinosoft.platform.dto.domain.PrpDcodeDto> prpDcodeVisitIssue = (ArrayList<com.sinosoft.platform.dto.domain.PrpDcodeDto>) blPrpDcodeFacade.findByConditions(" codeType='visitIssue' order by codecode ");
			//满意度 satisfied
			ArrayList<com.sinosoft.platform.dto.domain.PrpDcodeDto> prpDcodeSatisfied = (ArrayList<com.sinosoft.platform.dto.domain.PrpDcodeDto>) blPrpDcodeFacade.findByConditions(" codeType='satisfied'");
			//回访子表集合
			ArrayList<PrplreturnvisitDto> prplreturnvisitDtoList = (ArrayList<PrplreturnvisitDto>) blPrplreturnvisitFacade.findByConditions(visitCondition);
			if(prplreturnvisitDtoList != null &&prplreturnvisitDtoList.size()>0 ){
				String existIssueCode = prplreturnvisitDtoList.get(0).getExistissue();
				String serviceCode = prplreturnvisitDtoList.get(0).getService();
				String existIssueName = "";
				String serviceName = "";
				for (int i = 0 ;i<prpDcodeSatisfied.size();i++) {
					com.sinosoft.platform.dto.domain.PrpDcodeDto prpDcodeDto = prpDcodeSatisfied.get(i); 
					if(serviceCode.equals(prpDcodeDto.getCodeCode())){
						serviceName = prpDcodeDto.getCodeCName();
					}
				}
				String[] issueCodes = existIssueCode.split(";");
				for (int j = 0; j < issueCodes.length; j++) {
					for (int i = 0 ;i<prpDcodeVisitIssue.size();i++) {
						com.sinosoft.platform.dto.domain.PrpDcodeDto prpDcodeDto =prpDcodeVisitIssue.get(i); 
						if(issueCodes[j].equals(prpDcodeDto.getCodeCode())){
							existIssueName += String.valueOf(j+1)+"."+ prpDcodeDto.getCodeCName()+";";
						}
					}
				}
				
				prplreturnvisitswflog.setServiceSelect(serviceName);
				prplreturnvisitswflog.setExistIssue(existIssueName);
			}
			if("4".equals(prplreturnvisitswflog.getState())){
				prplreturnvisitswflog.setNodeMark("已回访已成功");
			}else if("0".equals(prplreturnvisitswflog.getState())){
				prplreturnvisitswflog.setNodeMark("未回访");
			}else if("2".equals(prplreturnvisitswflog.getState())){
				prplreturnvisitswflog.setNodeMark("已回访未成功");
			}
		}
		return prplreturnvisitswflogDtolist;
	}
	/**
	 * 投诉处理查询
	 * @param httpServletRequest
	 * @param conditions
	 * @return
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public ArrayList<PrplcomplaintDto> showDealWithDtoList(HttpServletRequest httpServletRequest,String conditions) throws NumberFormatException, Exception{
		UIReturnVisitAction biReturnVisitAction = new UIReturnVisitAction();
		
		ArrayList<PrplcomplaintDto> prplcomplaintDtoList = new ArrayList<PrplcomplaintDto>();
		
		String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String pageNo     = httpServletRequest.getParameter("pageNo");
		String condition     = httpServletRequest.getParameter("condition");
		if(pageNo == null || "".equals(pageNo)){
			pageNo = "1";
		}
		if(condition != null && !"".equals(condition)){
			conditions = condition;
		}
		PageRecord pageRecord = biReturnVisitAction.findByQuerycomplaintDto(conditions, Integer.parseInt(pageNo), Integer.parseInt(recordPerPage));
		prplcomplaintDtoList = (ArrayList<PrplcomplaintDto>) pageRecord.getResult();
		
		TurnPageDto turnPageDto = new TurnPageDto();
		// 查询出来的一页的结构集
		turnPageDto.setResultList(prplcomplaintDtoList);
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
		turnPageDto.setCondition(conditions);
		
		PrplcomplaintDto prplcomplaintDto = new PrplcomplaintDto();
		prplcomplaintDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("prplcomplaintDto", prplcomplaintDto);
		
		return prplcomplaintDtoList;
	}
	
	/**
	 * 初始化投诉跟踪数据
	 * @param httpServletRequest
	 * @throws Exception 
	 */
	public void findComplList(HttpServletRequest httpServletRequest) throws Exception{
		
		String complaintno = httpServletRequest.getParameter("complaintno");
		BLPrplreturnvisitFacade blPrplreturnvisitFacade = new BLPrplreturnvisitFacade();
		String conditions = " businessNo='"+complaintno+"'";
		ArrayList<PrplreturnvisitDto> prplreturnvisitDtoList = (ArrayList<PrplreturnvisitDto>) blPrplreturnvisitFacade.findByConditions(conditions);
		httpServletRequest.setAttribute("prplreturnvisitDtoList", prplreturnvisitDtoList);
		BLPrpDcodeFacade blPrpDcodeFacade = new BLPrpDcodeFacade();
		//失败原因 failCauser
		ArrayList<PrpDcodeDto> prpDcodeFailCause = (ArrayList<PrpDcodeDto>) blPrpDcodeFacade.findByConditions(" codeType='failCause'");
		httpServletRequest.setAttribute("prpDcodeFailCause", prpDcodeFailCause);
		
		//满意度 satisfied
		ArrayList<PrpDcodeDto> prpDcodeSatisfied = (ArrayList<PrpDcodeDto>) blPrpDcodeFacade.findByConditions(" codeType='satisfied'");
		httpServletRequest.setAttribute("prpDcodeSatisfied", prpDcodeSatisfied);
	}
	
	/**
	 * 初始化数据 回访
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void findreturnVisitList(HttpServletRequest httpServletRequest) throws Exception{
		String registNo = httpServletRequest.getParameter("registNo");
		String nodeType = httpServletRequest.getParameter("nodeType");
		BLPrplreturnvisitFacade blPrplreturnvisitFacade = new BLPrplreturnvisitFacade();
		String conditions = " businessNo='"+registNo+"' and nodeType='"+nodeType+"' order by enteringtime desc";
		//回访子表集合
		ArrayList<PrplreturnvisitDto> prplreturnvisitDtoList = (ArrayList<PrplreturnvisitDto>) blPrplreturnvisitFacade.findByConditions(conditions);
		for(int i = 0; i < prplreturnvisitDtoList.size(); i++){
			PrplreturnvisitDto prplreturnvisitDto = new PrplreturnvisitDto();
			prplreturnvisitDto = prplreturnvisitDtoList.get(i);
			String strVisitsuccess = prplreturnvisitDto.getVisitsuccess();
			if(strVisitsuccess.length() > 1){
				prplreturnvisitDto.setVisitsuccess(strVisitsuccess.substring(0,1));
				prplreturnvisitDto.setVisitfail(strVisitsuccess.substring(1,2));
			}else if(1 == strVisitsuccess.length()){
				prplreturnvisitDto.setVisitfail("");
			}
		}
		httpServletRequest.setAttribute("prplreturnvisitDtoList", prplreturnvisitDtoList);
		
		//回访主信息
		BLPrplreturnvisitswflogFacade blPrplreturnvisitswflogFacade = new BLPrplreturnvisitswflogFacade();
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = blPrplreturnvisitswflogFacade.findByPrimaryKey(registNo, nodeType);
		httpServletRequest.setAttribute("prplreturnvisitswflogDto", prplreturnvisitswflogDto);
		
		//回访问题条件 visitIssue
		BLPrpDcodeFacade blPrpDcodeFacade = new BLPrpDcodeFacade();
		ArrayList<PrpDcodeDto> prpDcodeVisitIssue = (ArrayList<PrpDcodeDto>) blPrpDcodeFacade.findByConditions(" codeType='visitIssue' order by codecode ");
		httpServletRequest.setAttribute("prpDcodeVisitIssue", prpDcodeVisitIssue);
		
		//失败原因 failCause
		ArrayList<PrpDcodeDto> prpDcodeFailCause = (ArrayList<PrpDcodeDto>) blPrpDcodeFacade.findByConditions(" codeType='failCause'");
		httpServletRequest.setAttribute("prpDcodeFailCause", prpDcodeFailCause);
		
		//满意度 satisfied
		ArrayList<PrpDcodeDto> prpDcodeSatisfied = (ArrayList<PrpDcodeDto>) blPrpDcodeFacade.findByConditions(" codeType='satisfied'");
		httpServletRequest.setAttribute("prpDcodeSatisfied", prpDcodeSatisfied);
		
		//自动带入电话和被回访人
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		PrpLregistDto prplregistdto=registDto.getPrpLregistDto();
		httpServletRequest.setAttribute("prplregistdto", prplregistdto);
		
		//联系电话
		String tel="";
		if("sched".equals(nodeType)){
		 //派工回访电话 报案人电话
		 tel=prplregistdto.getPhoneNumber();			
		}
		if("endca".equals(nodeType)){
		 //结案回访电话 被保险人手机号--被保险人固定电话--保单中被保险人电话--保单中被保险人固定电话
		 if(!"".equals(prplregistdto.getInsuredMobilePhone())){
			 tel=prplregistdto.getInsuredMobilePhone();
		 }
		 else if(!"".equals(prplregistdto.getPhoneNumber())){
		  tel=prplregistdto.getPhoneNumber();			
		 }else{	 
			 String condition1 = "policyno = '"+prplregistdto.getPolicyNo()+"' and insuredflag = '1'";
			 BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade();
			 Collection<PrpCinsuredDto> prpcinsuredDtoList = blPrpCinsuredFacade.findByConditions(condition1);
			 if(null != prpcinsuredDtoList && prpcinsuredDtoList.size() > 0){
				 Iterator<PrpCinsuredDto> it = prpcinsuredDtoList.iterator();
				 PrpCinsuredDto prpCinsuredDto = new PrpCinsuredDto();
				 while(it.hasNext()){
					 prpCinsuredDto = it.next();
				 }
				 if(!"".equals(prpCinsuredDto.getMobile())){
					 tel = prpCinsuredDto.getMobile();
				 }else {
					 tel = prpCinsuredDto.getPhoneNumber();
				 }
			 } 
			/*BLPrpDcustomerFacade blPrpDcustomerFacade = new BLPrpDcustomerFacade();
			PrpDcustomerDto prpDcustomerDto = blPrpDcustomerFacade.findByPrimaryKey(prplregistdto.getInsuredCode());
			if("1".equals(prpDcustomerDto.getCustomerType())){
				//个人客户
				PrpDcustomerIdvDto prpDcustomerIdvDto = new BLPrpDcustomerIdvFacade().findByPrimaryKey(prplregistdto.getInsuredCode());
				if(!"".equals(prpDcustomerIdvDto.getMobile())){
					tel = prpDcustomerIdvDto.getMobile();
				}else {
					tel = prpDcustomerIdvDto.getPhoneNumber();
				}
			}
			if("2".equals(prpDcustomerDto.getCustomerType())){
				//集体客户
				PrpDcustomerUnitDto prpDcustomerUnitDto = new BLPrpDcustomerUnitFacade().findByPrimaryKey(prplregistdto.getInsuredCode());
				if(!"".equals(prpDcustomerUnitDto.getMobile())){
					tel = prpDcustomerUnitDto.getMobile();
				}else {
					tel = prpDcustomerUnitDto.getPhoneNumber();
				}
			}*/			
		}
		 BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade();
		 String strPrpCinsuredCon = "policyno = '"+prplregistdto.getPolicyNo()+"' and insuredflag = '1'";
		 Collection<PrpCinsuredDto> prpcinsuredDtoList = blPrpCinsuredFacade.findByConditions(strPrpCinsuredCon);
		 if(null != prpcinsuredDtoList && prpcinsuredDtoList.size() > 0){
			 Iterator<PrpCinsuredDto> it = prpcinsuredDtoList.iterator();
			 PrpCinsuredDto prpCinsuredDto = new PrpCinsuredDto();
			 while(it.hasNext()){
				 prpCinsuredDto = it.next();
			 }
			 if(!"".equals(prpCinsuredDto.getInsuredName()) && null != prpCinsuredDto.getInsuredName()){
				 httpServletRequest.setAttribute("insuredName", prpCinsuredDto.getInsuredName());
			 }
			 if(!"".equals(prpCinsuredDto.getMobile()) && null != prpCinsuredDto.getMobile()){
				 httpServletRequest.setAttribute("insuredMobile", prpCinsuredDto.getMobile());
			 }
			 if(!"".equals(prpCinsuredDto.getPhoneNumber()) && null != prpCinsuredDto.getPhoneNumber()){
				 httpServletRequest.setAttribute("insuredMobilePhone", prpCinsuredDto.getPhoneNumber());
			 }
		 }
		 String strPrplPayCon = "";
			strPrplPayCon = " REGISTNO = '" + prplregistdto.getRegistNo() + "' AND RECEIVERFULLNAME = '" ;
			if("sched".equals(nodeType)){
				strPrplPayCon = strPrplPayCon + prplregistdto.getReportorName() + "' ORDER BY INPUTDATE DESC";
			}else {
				strPrplPayCon = strPrplPayCon + prplregistdto.getInsuredName() + "' ORDER BY INPUTDATE DESC";
			}
			BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
			ArrayList<PrplpayDto> prplpayDtoList = (ArrayList<PrplpayDto>)blPrplpayFacade.findByConditions(strPrplPayCon);
			if(prplpayDtoList.size() > 0){
				httpServletRequest.setAttribute("familyphone",prplpayDtoList.get(0).getFamilyphone());
				httpServletRequest.setAttribute("receiverfullname",prplpayDtoList.get(0).getReceiverfullname());
			}
		 
	 }
		httpServletRequest.setAttribute("tel", tel);		
	}
	
	/**
	 * 收集页面数据
	 * @param httpServletRequest
	 * @return
	 * @throws Exception 
	 */
	public ReturnVisitDto viewToDto(HttpServletRequest httpServletRequest) throws Exception{
		ReturnVisitDto peturnVisitDto = new ReturnVisitDto();
		PrplreturnvisitDto prplreturnvisitDto;
		ArrayList<PrplreturnvisitDto> prplreturnvisitDtoList = new ArrayList<PrplreturnvisitDto>();
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String nodeTypes = httpServletRequest.getParameter("nodeTypes");
		String[] businessNo 		= httpServletRequest.getParameterValues("businessNo");
		String[] nodeType 			= httpServletRequest.getParameterValues("nodeType");
		String[] serialno 			= httpServletRequest.getParameterValues("serialno");
		//String[] comcode 			= httpServletRequest.getParameterValues("comcode");
		String[] visitname 			= httpServletRequest.getParameterValues("visitname");
		String[] contact 			= httpServletRequest.getParameterValues("contact");
		String[] recorderno 		= httpServletRequest.getParameterValues("recorderno");
		String[] service 			= httpServletRequest.getParameterValues("service");
		String[] existissue 		= httpServletRequest.getParameterValues("existissue");
		String[] visitsuccess 		= httpServletRequest.getParameterValues("visitsuccess");
		String[] visitfail			= httpServletRequest.getParameterValues("visitfail");
		String[] visitnocause 		= httpServletRequest.getParameterValues("visitnocause");
		String[] visitopinion 		= httpServletRequest.getParameterValues("visitopinion");
		String[] enteringcode 		= httpServletRequest.getParameterValues("enteringcode");
		String[] enteringname 		= httpServletRequest.getParameterValues("enteringname");
		String[] enteringcomcode 	= httpServletRequest.getParameterValues("enteringcomcode");
		String[] enteringtime 		= httpServletRequest.getParameterValues("enteringtime");
		if("compl".equals(nodeTypes)){
			for(int i=0;i<recorderno.length;i++){
				String complaintno = httpServletRequest.getParameter("complaintno");
				prplreturnvisitDto = new PrplreturnvisitDto();
				prplreturnvisitDto.setBusinessNo(complaintno);
				if("".equals(serialno[i])){
					BLPrplreturnvisitFacade blPrplreturnvisitFacade = new BLPrplreturnvisitFacade();
					int a = blPrplreturnvisitFacade.getCount(" businessNo='"+complaintno+"'");
					prplreturnvisitDto.setSerialno(String.valueOf(a+1));
					prplreturnvisitDto.setEnteringcode(user.getUserCode());
					prplreturnvisitDto.setEnteringname(user.getUserName());
					prplreturnvisitDto.setEnteringcomcode(user.getComCode());
					prplreturnvisitDto.setEnteringtime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
				}else{
					prplreturnvisitDto.setSerialno(serialno[i]);
					prplreturnvisitDto.setEnteringcode(enteringcode[i]);
					prplreturnvisitDto.setEnteringname(enteringname[i]);
					prplreturnvisitDto.setEnteringcomcode(enteringcomcode[i]);
					prplreturnvisitDto.setEnteringtime(new DateTime(enteringtime[i].toString(),DateTime.YEAR_TO_SECOND));
				}
				prplreturnvisitDto.setNodetype(nodeTypes);
				prplreturnvisitDto.setRecorderno(recorderno[i]);
				prplreturnvisitDto.setService(service[i]);
				prplreturnvisitDto.setVisitopinion(visitopinion[i]);
				prplreturnvisitDto.setVisitsuccess(visitsuccess[i]);
				prplreturnvisitDto.setVisitnocause(visitnocause[i]);
				prplreturnvisitDto.setClasscode("05");
				prplreturnvisitDtoList.add(prplreturnvisitDto);
			}
		}else{
			for(int i=0;i<businessNo.length;i++){
				prplreturnvisitDto = new PrplreturnvisitDto();
				prplreturnvisitDto.setBusinessNo(businessNo[i]);
				prplreturnvisitDto.setNodetype(nodeType[i]);
				if("".equals(serialno[i])){
					BLPrplreturnvisitFacade blPrplreturnvisitFacade = new BLPrplreturnvisitFacade();
					int a = blPrplreturnvisitFacade.getCount(" businessNo='"+businessNo[i]+"'");
					prplreturnvisitDto.setSerialno(String.valueOf(a+1));
				}else{
					prplreturnvisitDto.setSerialno(serialno[i]);
				}
				prplreturnvisitDto.setVisitname(visitname[i]);
				prplreturnvisitDto.setContact(contact[i]);
				prplreturnvisitDto.setRecorderno(recorderno[i]);
				prplreturnvisitDto.setService(service[i]);
				prplreturnvisitDto.setExistissue(existissue[i]);
				if("1".equals(visitsuccess[i])){//回访标识-成功
					prplreturnvisitDto.setVisitsuccess(visitsuccess[i]);
				}else if("0".equals(visitsuccess[i])){//未成功时，增加是否需要跟进标识
					if("".equals(visitfail[i]) || null == visitfail[i]){
						prplreturnvisitDto.setVisitsuccess(visitsuccess[i]);
					}else{
						prplreturnvisitDto.setVisitsuccess(visitsuccess[i] + visitfail[i]);
					}
				}
				prplreturnvisitDto.setVisitnocause(visitnocause[i]);
				prplreturnvisitDto.setVisitopinion(visitopinion[i]);
				if("".equals(serialno[i])){
					prplreturnvisitDto.setEnteringcode(user.getUserCode());
					prplreturnvisitDto.setEnteringname(user.getUserName());
					prplreturnvisitDto.setEnteringcomcode(user.getComCode());
					prplreturnvisitDto.setEnteringtime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
				}else{
					prplreturnvisitDto.setEnteringcode(enteringcode[i]);
					prplreturnvisitDto.setEnteringname(enteringname[i]);
					prplreturnvisitDto.setEnteringcomcode(enteringcomcode[i]);
					prplreturnvisitDto.setEnteringtime(new DateTime(enteringtime[i].toString(), DateTime.YEAR_TO_SECOND));
				}
				prplreturnvisitDto.setClasscode("05");
				prplreturnvisitDtoList.add(prplreturnvisitDto);
			}
		}
		peturnVisitDto.setPrplreturnvisitDtoList(prplreturnvisitDtoList);
		return peturnVisitDto;
	}
	
	/**
	 * 收集回复主表数据
	 * @param httpServletRequest
	 * @param visitsuccessState
	 * @return
	 * @throws Exception
	 */
	public PrplreturnvisitswflogDto viewToReturnVisitSwflogDto(HttpServletRequest httpServletRequest,String visitsuccessState) throws Exception{
		String registNo = httpServletRequest.getParameter("prplreturnvisitswflogDtoRegistNo");
		String nodeType = httpServletRequest.getParameter("prplreturnvisitswflogDtoNodeType");
		BLPrplreturnvisitswflogFacade blPrplreturnvisitswflogFacade = new BLPrplreturnvisitswflogFacade();
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
		UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
		if("compl".equals(nodeType)){
			String businessno = httpServletRequest.getParameter("complaintno");
			prplreturnvisitswflogDto = blPrplreturnvisitswflogFacade.findByPrimaryKey(businessno, nodeType);
			prplreturnvisitswflogDto.setHandlercode(user.getUserCode());
			prplreturnvisitswflogDto.setHandlername(user.getUserName());
			prplreturnvisitswflogDto.setHandlercomcode(user.getComCode());
		}else{
			prplreturnvisitswflogDto = blPrplreturnvisitswflogFacade.findByPrimaryKey(registNo, nodeType);
			prplreturnvisitswflogDto.setHandlercode(user.getUserCode());
			prplreturnvisitswflogDto.setHandlername(user.getUserName());
			prplreturnvisitswflogDto.setHandlercomcode(user.getComCode());
		}
		if(prplreturnvisitswflogDto != null){
			if("1".equals(visitsuccessState.substring(0,1))){//当回访成功时状态为4 录入结束时间
				prplreturnvisitswflogDto.setState("4");
				prplreturnvisitswflogDto.setCeasetime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND));
			}else if("01".equals(visitsuccessState)){//第一位为0时，表示当回访失败 状态为2，第二位为1，表示需跟进
				prplreturnvisitswflogDto.setState("21");
			}else if("00".equals(visitsuccessState)){//第一位为0时，表示当回访失败 状态为2，第二位为0，表示无需跟进 
				prplreturnvisitswflogDto.setState("20");
			}
		}
		return prplreturnvisitswflogDto;
	}
	
	/**
	 * 初始化新增投诉页面数据
	 * @param httpServletRequest
	 * @throws Exception 
	 */
	public void getComplaintDto(HttpServletRequest httpServletRequest) throws Exception{
		//投诉原因
		BLPrpDcodeFacade blPrpDcodeFacade = new BLPrpDcodeFacade();
		ArrayList<PrpDcodeDto> prpDcodeVisitIssue = (ArrayList<PrpDcodeDto>) blPrpDcodeFacade.findByConditions(" codeType='visitIssue' order by codecode ");
		httpServletRequest.setAttribute("prpDcodeVisitIssue", prpDcodeVisitIssue);
		
		//被投诉机构
		String sql = " 1=1 Start With Comcode = '0000000000'  Connect By Prior Comcode = Uppercomcode And Prior Comcode != Comcode And Validstatus = '1' And companyflag='1'";
		BLPrpDcompanyFacade blPrpDcompanyFacade= new BLPrpDcompanyFacade();
		ArrayList<PrpDcompanyDto> prpDcompanyDtoList = (ArrayList<PrpDcompanyDto>) blPrpDcompanyFacade.findByConditions(sql);
		httpServletRequest.setAttribute("prpDcompanyDtoList", prpDcompanyDtoList);
		
		//投诉大类 
		ArrayList<PrpDcodeDto> prpDcodeComplaintType = (ArrayList<PrpDcodeDto>) blPrpDcodeFacade.findByConditions(" codetype='ComplaintType' order by codecode ");
		httpServletRequest.setAttribute("prpDcodeComplaintType", prpDcodeComplaintType);
	}
	
	/**
	 * 投诉收集页面数据
	 * @param httpServletRequest
	 * @return
	 * @throws Exception 
	 */
	public PrplcomplaintDto complaintViewToDto(HttpServletRequest httpServletRequest) throws Exception{
		String nodeType = httpServletRequest.getParameter("nodeType");
		String nodeTypes = httpServletRequest.getParameter("nodeTypes");
		PrplcomplaintDto prplcomplaintDto = new PrplcomplaintDto();
		UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
		//投诉信息 begin
		String complaintno 			= httpServletRequest.getParameter("complaintno");					//投诉编号
		String complaintdate 		= httpServletRequest.getParameter("complaintdate");					//投诉时间
		String complainttype 		= httpServletRequest.getParameter("complainttype");					//投诉大类
		String bycomplaintcomcode 	= httpServletRequest.getParameter("handleCode");					//投诉机构
		String bycomplaintcode 		= httpServletRequest.getParameter("bycomplaintcode");				//被投诉人
		String complaintname 		= httpServletRequest.getParameter("complaintname");					//投诉人姓名
		String callno 				= httpServletRequest.getParameter("callno");						//来电号码
		String telephone 			= httpServletRequest.getParameter("telephone");						//其他联系人电话
		String complaintcause 		= httpServletRequest.getParameter("complaintcause");				//投诉原因
		String detailedcause 		= httpServletRequest.getParameter("detailedcause");					//投诉详细原因
		String whethercomplaint 	= httpServletRequest.getParameter("whethercomplaint");				//是否有效投诉
		String whethertrack 		= httpServletRequest.getParameter("whethertrack");					//是否需要跟踪
		String registno 			= httpServletRequest.getParameter("registno");						//报案号码
		String recordingno 			= httpServletRequest.getParameter("recordingno");					//流水号
		String handlercode 			= httpServletRequest.getParameter("handlercode");					//投诉处理人ID
		String handlername 			= httpServletRequest.getParameter("handlername");					//投诉处理人姓名
		String handlercomcode		= httpServletRequest.getParameter("handlercomcode");				//投诉处理人机构
		String handlerdate 			= httpServletRequest.getParameter("handlerdate");					//投诉流入时间
		
		if("".equals(complaintno)){
			//生成投诉主键 begin
			BLPrplcomplaintFacade blPrplcomplaintFacade = new BLPrplcomplaintFacade();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM");
			System.out.println(sd.format(new Date()));
			int countNo = blPrplcomplaintFacade.getCount(" bycomplaintcomcode='"+bycomplaintcomcode+"' and handlerdate>to_date('"+sd.format(new Date())+"','yyyy-MM')")+1;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
			String date = sdf.format(new Date());
			String countNoStr = String.valueOf(countNo);
			if(countNoStr.length() == 1){
				countNoStr = StringUtils.newString("0", 3)+countNoStr;
			}else if(countNoStr.length() == 2){
				countNoStr = StringUtils.newString("0", 2)+countNoStr;
			}else if(countNoStr.length() == 3){
				countNoStr = StringUtils.newString("0", 1)+countNoStr;
			}
			complaintno = "9"+complainttype+bycomplaintcomcode+date+countNoStr;
			//生成投诉主键 end
			prplcomplaintDto.setComplaintno(complaintno);
			prplcomplaintDto.setComplaintdate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
			prplcomplaintDto.setHandlercode(user.getUserCode());
			prplcomplaintDto.setHandlername(user.getUserName());
			prplcomplaintDto.setHandlercomcode(user.getComCode());
			prplcomplaintDto.setHandlerdate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
		}else{
			prplcomplaintDto.setComplaintno(complaintno);
			prplcomplaintDto.setComplaintdate(new DateTime(complaintdate, DateTime.YEAR_TO_SECOND));
			prplcomplaintDto.setHandlercode(handlercode);
			prplcomplaintDto.setHandlername(handlername);
			prplcomplaintDto.setHandlercomcode(handlercomcode);
			prplcomplaintDto.setHandlerdate(new DateTime(handlerdate, DateTime.YEAR_TO_SECOND));
		}
		prplcomplaintDto.setRecordingno(recordingno);
		prplcomplaintDto.setComplainttype(complainttype);
		prplcomplaintDto.setBycomplaintcomcode(bycomplaintcomcode);
		prplcomplaintDto.setBycomplaintcode(bycomplaintcode);
		prplcomplaintDto.setComplaintname(complaintname);
		prplcomplaintDto.setCallno(callno);
		prplcomplaintDto.setTelephone(telephone);
		prplcomplaintDto.setComplaintcause(complaintcause);
		prplcomplaintDto.setDetailedcause(detailedcause);
		prplcomplaintDto.setWhethercomplaint(whethercomplaint);
		prplcomplaintDto.setWhethertrack(whethertrack);
		prplcomplaintDto.setRegistno(registno);
		prplcomplaintDto.setClasscode("05");
		if("complaint".equals(nodeTypes)){
			if("1".equals(whethertrack)){
				prplcomplaintDto.setState("3");
			}else{
				prplcomplaintDto.setState("4");
			}
		}
		//投诉信息 end
		if("dealWith".equals(nodeTypes)){
			String complaintopinion 		= httpServletRequest.getParameter("complaintopinion");					//处理意见
			String transactorname 			= httpServletRequest.getParameter("transactorname");					//处理人姓名
			String transactorcode 			= httpServletRequest.getParameter("transactorcode");					//处理人ID
			String transactordate 			= httpServletRequest.getParameter("transactordate");					//处理时间
			prplcomplaintDto.setComplaintopinion(complaintopinion);
			prplcomplaintDto.setTransactorname(user.getUserName());
			prplcomplaintDto.setTransactorcode(user.getUserCode());
			prplcomplaintDto.setTransactordate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
			prplcomplaintDto.setState("4");
		}
		
		return prplcomplaintDto;
	}
	
	/**
	 * 初始化 投诉数据
	 * @param httpServletRequest
	 * @throws Exception 
	 */
	public void finddealWithList(HttpServletRequest httpServletRequest) throws Exception{
		UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
		String editType = httpServletRequest.getParameter("editType");
		String nodeType = httpServletRequest.getParameter("nodeType");
		String complaintno = httpServletRequest.getParameter("complaintno");		//投诉编号
		BLPrplcomplaintFacade blPrplcomplaintFacade = new BLPrplcomplaintFacade();
		PrplcomplaintDto prplcomplaintDto = blPrplcomplaintFacade.findByPrimaryKey(complaintno);
		UICodeAction uiCodeAction = new UICodeAction();
		prplcomplaintDto.setBycomplaintcomcodeName(uiCodeAction.translateComCode(prplcomplaintDto.getBycomplaintcomcode(), true));
		if("".equals(prplcomplaintDto.getTransactorname())){
			prplcomplaintDto.setTransactorname(user.getUserName());
		}
		httpServletRequest.setAttribute("prplcomplaintDto", prplcomplaintDto);
		//调用投诉页面基础数据
		this.getComplaintDto(httpServletRequest);
	}
}
