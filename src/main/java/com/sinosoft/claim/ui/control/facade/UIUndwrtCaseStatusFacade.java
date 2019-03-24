package com.sinosoft.claim.ui.control.facade;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gyic.claim.bl.facade.BLHerdsettlelistFacade;
import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.dto.domain.HerdsettlelistDto;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.sinosoft.claim.bl.facade.BLPrpLclaimBillManagerFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLprepayFacade;
import com.sinosoft.claim.bl.facade.BLPrplreturnvisitswflogFacade;
import com.sinosoft.claim.bl.facade.BLSwfFlowMainFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.UndwrtCaseStatusDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfLogStoreDto;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIEndcaseAction;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 核赔工作流信息补传
 * @author Administrator
 *
 */
public class UIUndwrtCaseStatusFacade  extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		try{
			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			if(user==null){
				forward = "error";
				return actionMapping.findForward(forward);
			}
			String editType  =  httpServletRequest.getParameter("editType");
			if("query".equals(editType)){
				query(httpServletRequest,httpServletResponse);
				forward = "resultList";
			}else if("passVeric".equals(editType)||"passVericAndCloseFlow".equals(editType)){
				String strErrMessage = passVericAll(httpServletRequest,editType);
				
				if(strErrMessage==null||!"".equals(strErrMessage)){
					//错误信息处理
					ActionErrors errors = new ActionErrors();
					ActionError error = new ActionError("title.undwrtCaseStatus.resultList");
					errors.add(ActionErrors.GLOBAL_ERROR, error);
					httpServletRequest.setAttribute("errorMessage", strErrMessage);
					saveErrors(httpServletRequest, errors);
					forward = "error";
				}else{
					forward = "success";
				}
				
			}else if ("passVericSettleList".equals(editType)) {
				query1( httpServletRequest, httpServletResponse);
				forward = "success";
				
			}else{
				//错误信息处理
				ActionErrors errors = new ActionErrors();
				ActionError error = new ActionError("title.undwrtCaseStatus.resultList");
				errors.add(ActionErrors.GLOBAL_ERROR, error);
				httpServletRequest.setAttribute("errorMessage", "沒有对应处理方法");
				saveErrors(httpServletRequest, errors);
				forward = "error";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.undwrtCaseStatus.resultList");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
	/**
	 * 补传 核赔通过工作流
	 * @param editType 
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private String passVericAll(HttpServletRequest httpServletRequest,String editType) throws NumberFormatException, Exception {
		//获取所有数据
		String[] strSerial = httpServletRequest.getParameterValues("selectSerial");
 		String[] LflowIDs = httpServletRequest.getParameterValues("Lflowid");
		String[] lLogNos = httpServletRequest.getParameterValues("Llogno");
		String[] registNos = httpServletRequest.getParameterValues("registno");
		String[] businessNos = httpServletRequest.getParameterValues("compensateno");
		String[] notionInfos = httpServletRequest.getParameterValues("notionInfo");
		String[] handlerCodes = httpServletRequest.getParameterValues("handlerCode");
		String[] submitTimes = httpServletRequest.getParameterValues("submittime");
		//获取有效数据
		String strErrMessage ="";
		for(int i = 0;i<strSerial.length;i++){
			int serial = Integer.parseInt(strSerial[i]);
			String LflowID = LflowIDs[serial];
			String LlogNo = lLogNos[serial];
			String registNo = registNos[serial];
			String businessNo = businessNos[serial];
			String notionInfo = notionInfos[serial];
			String handlerCode = handlerCodes[serial];
			String submitTime = submitTimes[serial];
			System.err.println(serial+" | "+LflowID+" | "+LlogNo+" | "+businessNo+" | "+notionInfo+" | "+handlerCode+" | "+submitTime);
			int intFlag = 0;
			if("passVeric".equals(editType)){
				intFlag = passVeric(httpServletRequest,LflowID,Integer.parseInt(LlogNo),
						businessNo,notionInfo,handlerCode,submitTime);
			}else if("passVericAndCloseFlow".equals(editType)){
				intFlag = passVericAndCloseFlow(httpServletRequest,LflowID,Integer.parseInt(LlogNo),
						businessNo,notionInfo,handlerCode,submitTime);
			}
			String flag = String.valueOf(intFlag);
			if (flag.equals("-1"))
		    {	
				strErrMessage += "报案号： "+registNo+" ";
				strErrMessage += "理赔工作流:没查询到工作流节点！请与系统管理员联系！<br/>";
		    }
		    else if (flag.equals("-2"))
		    {	
		    	strErrMessage += "报案号： "+registNo+" ";
		    	strErrMessage += "理赔工作流:业务号不是这个工作流上的业务号码！请与系统管理员联系！<br/>";
		    }
		    else if (flag.equals("-3"))
		    {	
		    	strErrMessage += "报案号： "+registNo+" ";
		    	strErrMessage += "理赔工作流:已经回退过了的案件的节点！请与系统管理员联系！<br/>";
		    }
		    else if (flag.equals("-5"))
		    {	
		    	strErrMessage += "报案号： "+registNo+" ";
		    	strErrMessage += "理赔工作流:工作流流程整理异常！请与系统管理员联系！<br/>";
		    }
		    else if (flag.equals("-998") || flag.equals("-999") || flag.equals("-997"))
		    {	
		    	strErrMessage += "报案号： "+registNo+" ";
		    	strErrMessage += "未知错误！请与系统管理员联系！<br/>";
		    }
		}
		return strErrMessage;
	}
	 /**
     * 核赔节点的通过（手工结案）
     * 
     * @param LflowID String 理赔工作流号码
     * @param LlogNo int 理赔工作流节点号码
     * @param businessNo String 业务号码
     * @param notionInfo String 审批意见 人员名 时间时间
     * @param handlerCode String 操作员
     * @throws Exception
     * @return boolean
     */

    public int passVeric(HttpServletRequest httpServletRequest, String LflowID, int LlogNo, String businessNo,
            String notionInfo, String handlerCode,String submitTime) throws Exception {
        boolean flag = true;

           String policyNo="";
           String riskCode="";
           //String compensateNo = businessNo;	
           CompensateDto compensateDto = new  CompensateDto(); 
           PrpLprepayDto  prpLprepayDto= new PrpLprepayDto();
        
        //取赔款计算书号
        
        String underWriteFlag = "1";
        String swfLogFlowID = LflowID; //工作流号码
        int swfLogLogNo = LlogNo; //工作流logno
        String keyString = ""; //工作流keyIn
        UserDto user = new UserDto(); //因为不是用户自己操作的，所以目前暂时认为就是计算机做的
        user.setUserCode(handlerCode);
        user.setUserName("双核通过");
        //保存赔款计算书信息,如果双核可以直接写这边的业务数据库，就不需要这一步了。
        UICompensateAction uiCompensateAction = new UICompensateAction();
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

        //???判断是不是自动结案(从 appconfig+计算书的最终标志)，如果是做passVericAndCloseFlow();

        String autoEndCaseFlag = AppConfig.get("sysconst.AutoEndCase");
        boolean  isNewCar=false;
        SwfLogDto swfLogDto = new SwfLogDto();
        swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);
        if (swfLogDto.getDataFlag()!=null&&"1".equals(swfLogDto.getDataFlag())) {
        	isNewCar=true;
		}
        //是否需要自动结案，是否是案终赔付
        String  caseType="";
        if (businessNo.substring(0,1).equals("6") ){
            compensateDto = uiCompensateAction.findByPrimaryKey(businessNo);
            policyNo =compensateDto.getPrpLcompensateDto().getPolicyNo();
            riskCode =compensateDto.getPrpLcompensateDto().getRiskCode();
        }else  if (businessNo.substring(0,1).equals("Y") 
        	||(isNewCar&&businessNo.substring(0,1).equals("8"))	){
        	BLPrpLprepayFacade  blPrpLprepayFacade  =new BLPrpLprepayFacade();
        	prpLprepayDto= blPrpLprepayFacade.findByPrimaryKey(businessNo);
        	policyNo= prpLprepayDto.getPolicyNo();
        	riskCode =prpLprepayDto.getRiskCode();
        	caseType = prpLprepayDto.getCaseType();
        }
        //System.out.println("-------自动结案----"+autoEndCaseFlag+"|"+compensateDto.getPrpLcompensateDto().getFinallyFlag());
        //if ("1".equals(autoEndCaseFlag) && "1".equals(compensateDto.getPrpLcompensateDto().getFinallyFlag())) {
        if (businessNo.substring(0,1).equals("6")&&"1".equals(autoEndCaseFlag) && "1".equals(compensateDto.getPrpLcompensateDto().getFinallyFlag()) ) {
        	/*下面的注释将核赔通过自动结案的开关关闭开始*/
         //return passVericAndCloseFlow(httpServletRequest, LflowID, LlogNo, businessNo, notionInfo, handlerCode);
        	/*下面的注释将核赔通过自动结案的开关关闭结束*/
        }

        

        int checkFlag = swfLogDto.getLogNo();

        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;
        System.out.println("swfLogDto.getflowid:" + swfLogDto.getFlowID());
        keyString = swfLogDto.getKeyIn();
        user.setComCode(swfLogDto.getHandleDept());
        user.setComName(swfLogDto.getDeptName());
        //目前在接口中，如果双核没有写我们的业务库，那么就用这个保存，如果已经写了我们的业务库，那么只要保存工作流数据就可以了
        //uiCompensateAction.approve(compensateNo,user.getUserCode(),underWriteFlag);
        //如果成功的话，存在工作流，那么就需要提交工作流，如果没有就算了

        System.out.println("swfLogDto.getflowid:" + swfLogDto.getFlowID());
        System.out.println("keyString:" + keyString);
        WorkFlowDto workFlowDto = getWorkFlowDto(user, swfLogFlowID, swfLogLogNo, "4", keyString, keyString, keyString,
                businessNo, false);
        if (workFlowDto == null)
        	return -5;
        //时间处理 -開始
	      SwfLogDto updateSwfLogDto = workFlowDto.getUpdateSwfLogDto();
	      if(updateSwfLogDto!=null){
	    	  updateSwfLogDto.setSubmitTime(submitTime);
	      }
	      ArrayList<SwfLogDto> list2 = workFlowDto.getSubmitSwfLogDtoList();
	      if(list2!=null&&list2.size()>0){
	    	  SwfLogDto submitSwfLogDto = list2.get(0);
	    	  submitSwfLogDto.setFlowInTime(submitTime);
	    	  submitSwfLogDto.setHandleTime(submitTime);
	    	  String titleStr = "";
	    	  if(submitSwfLogDto.getTitleStr()!=null){
	    		  String[] strs = submitSwfLogDto.getTitleStr().split("：");
	    		  if(strs.length>1){
	    			  String[] strs2 = strs[1].split(":");
	    			  if(strs2.length>1){
	    				  titleStr +=  strs[0];
	    				  titleStr +="："+submitTime+" 上一节点操作人:";
	    				  titleStr +=strs2[strs2.length-1];
	    				  submitSwfLogDto.setTitleStr(titleStr);
	    			  }
	    		  }
	    	  }
	    	  
	      }
	    //时间处理 -結束
        //追加意见

        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
        
        if(caseType!=null && !caseType.equals("") && (caseType.equals("7")||isNewCar)){//支付不产生结案
        	swfLogDto.setNodeStatus("4"); //
        	swfLogDto.setHandlerCode(handlerCode);
        	swfLogDto.setHandlerName(user.getUserName());
        	swfLogDto.setSubmitTime(new DateTime(DateTime.current(),
                    DateTime.YEAR_TO_SECOND).toString());
        	uiWorkFlowAction.updateFlow(swfLogDto);
        	
        }else {
        	if("1".equals(swfLogDto.getDataFlag())){
            	if(workFlowDto.getSubmitSwfLogDtoList()!=null){
                	ArrayList<SwfLogDto>  list = (ArrayList<SwfLogDto>)workFlowDto.getSubmitSwfLogDtoList();
                	for (SwfLogDto swfLogDto2 : list) {
                		swfLogDto2.setDataFlag("1");
        			}
                }
            }
        	uiWorkFlowAction.deal(workFlowDto);
        }
        System.out.println("passVeric");
        return checkFlag;
    }
	/**
	 * 查询核赔通过但没有回传理赔工作流的相关信息
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws Exception 
	 */
	private void query(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		DBManager dbManager = new DBManager();
		ResultSet rs = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			
			String strRegistNo  =  httpServletRequest.getParameter("registNo");
			strRegistNo = strRegistNo.trim();
			String conditions = "";
			if(strRegistNo!=null&&!"".equals(strRegistNo)){
				String[] registNos = strRegistNo.split("\r\n");
				String registNo = "";
				for(int i = 0;i<registNos.length;i++){
					if(i==registNos.length-1){
						registNo+="'"+registNos[i]+"'";
					}else{
						registNo+="'"+registNos[i]+"',";
					}
				}
				conditions = " and g.registno in("+registNo+")";
			}
			
			
			StringBuffer buffer = new StringBuffer();
			buffer.append(" select e.compensateno,                                                                               ");
			buffer.append("        e.claimno,                                                                                    ");
			buffer.append("        m.registno,                                                                                   ");
			buffer.append("        w.submittime,                                                                                 ");
			buffer.append("        g.flowid as lflowid,                                                                          ");
			buffer.append("        g.logno as llogno,                                                                            ");
			buffer.append("        w.flowid as hflowid,                                                                          ");
			buffer.append("        w.logno as hlogno,                                                                            ");
			buffer.append("        (select w2.operatorname || ' ' || w2.nodename || ' #'                                         ");
			buffer.append("           from wflogstore w2                                                                         ");
			buffer.append("          where w2.flowid = w.flowid                                                                  ");
			buffer.append("            and w2.logno = w.logno - 1) || uw.handletext as notioninfo,                               ");
			buffer.append("        (select w2.operatorcode                                                                       ");
			buffer.append("           from wflogstore w2                                                                         ");
			buffer.append("          where w2.flowid = w.flowid                                                                  ");
			buffer.append("            and w2.logno = w.logno - 1) as handlercode                                                ");
			buffer.append("   from prplcompensate e,                                                                             ");
			buffer.append("        swflog g,                                                                                     ");
			buffer.append("        prplclaim m,                                                                                  ");
			buffer.append("        wflogstore w,                                                                                 ");
			buffer.append("        (select u.flowid,                                                                             ");
			buffer.append("               u.logno,                                                                               ");
			buffer.append("               u.lineno,                                                                              ");
			buffer.append("               u.handletext,                                                                          ");
			buffer.append("               row_number() over(partition by u.flowid, u.logno order by u.lineno desc) as new_index  ");
			buffer.append("          from uwnotion u)  uw                                                                        ");
			buffer.append("         where e.compensateno = g.businessno                                                          ");
			buffer.append("           and e.claimno = m.claimno                                                                  ");
			buffer.append("           and w.businessno = e.compensateno                                                          ");
			buffer.append("           and w.nodename = '审核通过'                                                                ");
			buffer.append("           and e.underwriteflag in ('1', '3')                                                         ");
			buffer.append("           and g.nodetype = 'veric'                                                                   ");
			buffer.append("           and g.dataflag is null                                                                       ");
			buffer.append("           and g.nodestatus not in ('5', '4')                                                         ");
			buffer.append("           and w.flowid = uw.flowid(+)                                                                ");
			buffer.append("           and w.logno - 1 = uw.logno                                                                 ");
			buffer.append("           and uw.new_index = 1                                                                       ");
			buffer.append(conditions);
			buffer.append("         order by m.registno                                                                          ");
			System.err.println(buffer.toString());
			rs = dbManager.executeQuery(buffer.toString());
			ArrayList<UndwrtCaseStatusDto> undwrtCaseStatusDtoList = new ArrayList<UndwrtCaseStatusDto>();
			while(rs.next()){
				int index = 1;
				UndwrtCaseStatusDto undwrtCaseStatusDto = new UndwrtCaseStatusDto();
				undwrtCaseStatusDto.setCompensateno(rs.getString(index++));   
				undwrtCaseStatusDto.setClaimno(rs.getString(index++));         
				undwrtCaseStatusDto.setRegistno(rs.getString(index++));       
				undwrtCaseStatusDto.setSubmittime(rs.getString(index++));      
				undwrtCaseStatusDto.setLflowid(rs.getString(index++));       
				undwrtCaseStatusDto.setLlogno(String.valueOf(rs.getInt(index++)));       
				undwrtCaseStatusDto.setHflowid(rs.getString(index++));       
				undwrtCaseStatusDto.setHlogno(String.valueOf(rs.getInt(index++)));       
				undwrtCaseStatusDto.setNotionInfo(rs.getString(index++));    
				undwrtCaseStatusDto.setHandlerCode(rs.getString(index++));  
				undwrtCaseStatusDtoList.add(undwrtCaseStatusDto);
			}
			httpServletRequest.setAttribute("undwrtCaseStatusDtoList", undwrtCaseStatusDtoList);
		} catch (Exception e) {
			throw e;
		} finally{
			if(rs!=null){
				rs.close();
			}
			dbManager.close();
		}
	}
	/**
     * 核赔节点的通过（自动结案）
     * 
     * @param LflowID String 理赔工作流号码
     * @param LlogNo int 理赔工作流节点号码
     * @param businessNo String 业务号码
     * @param notionInfo String 审批意见 人员名 时间时间
     * @param handlerCode String 操作员
     * @throws Exception
     * @return boolean
     */

    public int passVericAndCloseFlow(HttpServletRequest httpServletRequest, String LflowID, int LlogNo,
            String businessNo, String notionInfo, String handlerCode,String submitTime) throws Exception {
    	UICompensateAction uiCompensateAction = new UICompensateAction();
    	CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(businessNo);
    	UIRecaseAction  uiRecaseAction  =new  UIRecaseAction ();
    	Collection cases =uiRecaseAction.findByConditions(" claimNo = '" +compensateDto.getPrpLcompensateDto().getClaimNo()+"'");
    	if(cases.size() > 0){
    		return repassVericAndCloseFlow(httpServletRequest,LflowID,LlogNo,
    				compensateDto.getPrpLcompensateDto().getCompensateNo(), compensateDto.getPrpLcompensateDto().getClaimNo(),
    				notionInfo,handlerCode);
    	}
        System.out.println("----passVericAndCloseFlow---自动结案--");
        //取赔款计算书号
        String compensateNo = businessNo;
        String underWriteFlag = "1";
        String swfLogFlowID = LflowID; //工作流号码
        int swfLogLogNo = LlogNo; //工作流logno
        String keyString = ""; //工作流keyIn
        UserDto user = new UserDto(); //因为不是用户自己操作的，所以目前暂时认为就是计算机做的
        user.setUserCode(handlerCode);
        user.setUserName("双核通过");

        //保存赔款计算书信息,如果双核可以直接写这边的业务数据库，就不需要这一步了。
        
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

        SwfLogDto swfLogDto = new SwfLogDto();
        swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);
        int checkFlag = swfLogDto.getLogNo();
        System.out.println("****checkFlag="+checkFlag);
        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;
        keyString = swfLogDto.getKeyIn();
        user.setComCode(swfLogDto.getHandleDept());
        user.setComName(swfLogDto.getDeptName());
        //目前在接口中，如果双核没有写我们的业务库，那么就用这个保存，如果已经写了我们的业务库，那么只要保存工作流数据就可以了
        //uiCompensateAction.approve(compensateNo,user.getUserCode(),underWriteFlag);
        //如果成功的话，存在工作流，那么就需要提交工作流，如果没有就算了

        WorkFlowDto workFlowDto = getWorkFlowDto(user, swfLogFlowID, swfLogLogNo, "4", keyString, keyString, keyString,
                compensateNo, true);
        if (workFlowDto == null){
            return -5;
        }
        //时间处理 -開始
	      SwfLogDto updateSwfLogDto = workFlowDto.getUpdateSwfLogDto();
	      if(updateSwfLogDto!=null){
	    	  updateSwfLogDto.setSubmitTime(submitTime);
	      }
	      ArrayList<SwfLogDto> list2 = workFlowDto.getSubmitSwfLogDtoList();
	      if(list2!=null&&list2.size()>0){
	    	  SwfLogDto submitSwfLogDto = list2.get(0);
	    	  submitSwfLogDto.setFlowInTime(submitTime);
	    	  submitSwfLogDto.setHandleTime(submitTime);
	    	  String titleStr = "";
	    	  if(submitSwfLogDto.getTitleStr()!=null){
	    		  String[] strs = submitSwfLogDto.getTitleStr().split("：");
	    		  if(strs.length>1){
	    			  String[] strs2 = strs[1].split(":");
	    			  if(strs2.length>1){
	    				  titleStr +=  strs[0];
	    				  titleStr +="："+submitTime+" 上一节点操作人:";
	    				  titleStr +=strs2[strs2.length-1];
	    				  submitSwfLogDto.setTitleStr(titleStr);
	    			  }
	    		  }
	    	  }
	    	  
	      }
	    //时间处理 -結束
        //追加意见
        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
                             /**********************自动结案开始**********************/
        //生成陪案号
        UIBillAction uiBillAction = new UIBillAction();
        String tableName = "prplcaseno";
        String comCode = user.getComCode();
        String strRiskCode = swfLogDto.getRiskCode();
        String riskCode = BusinessRuleUtil.getRiskCode(swfLogDto.getRegistNo(),"RegistNo");
        if(!strRiskCode.equals(riskCode)){
        	riskCode=strRiskCode;
        	
        }
        int year = DateTime.current().getYear();
        String caseNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
        httpServletRequest.getSession().setAttribute("caseNo", caseNo);
        httpServletRequest.getSession().setAttribute(caseNo, "caseNo");
        //结案主表
        EndcaseDto endcaseDto = new EndcaseDto();
        
        String claimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
        String conditions = "claimNo ='" + claimNo.trim() + "'";
        //赔案表集合
        ArrayList prpLperpayDtoList = new ArrayList();
        ArrayList arraylist = (ArrayList) uiCompensateAction.findByConditions(conditions);
        if (arraylist != null) {
            for (int i = 0; i < arraylist.size(); i++) {
                PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
                PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
                prpLcompensateDto = (PrpLcompensateDto) arraylist.get(i);
                prpLcompensateDto.setCaseNo(caseNo);
                prpLcaseNoDto.setCertiNo(prpLcompensateDto.getCompensateNo());
                prpLcaseNoDto.setCertiType("C");
                prpLcaseNoDto.setCaseNo(caseNo);
                prpLcaseNoDto.setFlag("");
                prpLcaseNoDto.setClaimNo(claimNo.trim());
                prpLperpayDtoList.add(prpLcaseNoDto);
            }
        }
        endcaseDto.setPrpLcaseNoDtoList(prpLperpayDtoList);
        endcaseDto.setPrpLcompensateDtoList(arraylist);
      //获取未复审信息begin
        //生成回访信息
      		BLPrplreturnvisitswflogFacade blPrplreturnvisitswflogFacade = new BLPrplreturnvisitswflogFacade();
      		DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
      		String registNo =  swfLogDto.getRegistNo();   		      		
      		PrplreturnvisitswflogDto prplreturnvisitswflog = blPrplreturnvisitswflogFacade.findByPrimaryKey(registNo, "endca");
      		if(prplreturnvisitswflog == null){
      			PrplreturnvisitswflogDto prplreturnvisitswflogDto = daaReturnVisitViewHelper.setReturnVisitSwflogDto(httpServletRequest, registNo, "endca", "0",user);
      			endcaseDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
      		}
        //取得立案信息
      		
        UIClaimAction uIClaimAction = new UIClaimAction();
        ClaimDto claimDto = uIClaimAction.findByPrimaryKey(claimNo);
        //取得结案报告 2005-08-05
        ArrayList prpLltextList = claimDto.getPrpLltextDtoList();
        ArrayList prpLltextListNew = new ArrayList();
        for (int i = 0; i < prpLltextList.size(); i++) {
        	PrpLltextDto prpLltextDto = (PrpLltextDto) prpLltextList.get(i);
        	if (prpLltextDto.getTextType().equals("08")) {   //只保留“08”为结案报告
        		prpLltextListNew.add(prpLltextDto);
        	}
        }
        endcaseDto.setPrpLltextDtoList(prpLltextListNew);
        
        PrpLclaimDto prpLclaimDto = claimDto.getPrpLclaimDto();
        prpLclaimDto.setCaseNo(caseNo);
        //重开赔案不更新原有的结案时间
        if(prpLclaimDto.getEndCaseDate() == null || prpLclaimDto.getEndCaseDate().isEmpty()){
            prpLclaimDto.setEndCaseDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
        }
        prpLclaimDto.setEndCaserCode(user.getUserCode());
        endcaseDto.setPrpLclaimDto(prpLclaimDto);
        

        if(caseNo != null){
            /*---------------------状态内容prpLclaimStatus------------------------------------*/
        	System.out.println("------保存prpLclaimStatus信息");
        	
            PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
            prpLclaimStatusDto.setStatus("4");            
            prpLclaimStatusDto.setBusinessNo(caseNo.trim());
            prpLclaimStatusDto.setPolicyNo(prpLclaimDto.getPolicyNo());
            prpLclaimStatusDto.setRiskCode(riskCode);
            prpLclaimStatusDto.setNodeType("endca");
            prpLclaimStatusDto.setSerialNo(0);
            //取得当前用户信息，写操作员信息到结案中                        
            prpLclaimStatusDto.setHandlerCode(user.getUserCode());
            prpLclaimStatusDto.setInputDate(new DateTime(new Date(),DateTime.YEAR_TO_DAY));
            prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
            endcaseDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        }
        
        //保存结案信息
        //modify by zhaolu 200608010 start
        UIEndcaseAction uiEndcaseAction = new UIEndcaseAction(); 
        try{
        uiEndcaseAction.save(endcaseDto);
        }catch(Exception ex)
        {
        	return -10;
        }
        //modify by zhaolu 200608010 start
        
        /** *******************自动结案结束******************** */
        System.out.println("/** *******************自动结案结束******************** */");

        //lixiang
       //做了工作流程，真正的自动结案是要调用endcaseFacade( workflowDto).
        System.out.println("****只做了工作流程，真正的自动结案是要调用endcaseFacade( workflowDto).");
        uiWorkFlowAction.deal(workFlowDto);
        //业务操作，加入就可以了。就是从业务中，写结案数据，并且可以自动产生结案报案的过程，写入这里。
         //modify by zhaolu 200608010 end
        System.out.println("passVericAndCloseFlow");
        //add by kangzhen start 061125
        //reason 自动结案后没有向swflog表中的keyout字段赋值，导致理赔流程查询中显示的信息不全，现在增加给keyout字段的赋值
        UIWorkFlowAction lastuiWorkFlowAction = new UIWorkFlowAction();
        int logMaxNo = lastuiWorkFlowAction.getSwfLogMaxLogNo(swfLogFlowID)-1;
        SwfLogDto lastSwfLogDto = lastuiWorkFlowAction.findNodeByPrimaryKey(swfLogFlowID,logMaxNo);
        if(lastSwfLogDto != null ){
        	if(lastSwfLogDto.getKeyOut()==null||lastSwfLogDto.getKeyOut().trim().length()<=0){
            	lastSwfLogDto.setKeyOut(caseNo);
            	BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
            	blSwfLogFacade.updateStatus(lastSwfLogDto);
        	}
        }else{
        	BLSwfLogStoreFacade blSwfLogStoreFacade = new BLSwfLogStoreFacade();
        	logMaxNo = blSwfLogStoreFacade.getMaxLogNo(swfLogFlowID) -1;
        	SwfLogStoreDto lastSwfLogStoreDto =  blSwfLogStoreFacade.findByPrimaryKey(swfLogFlowID,logMaxNo);
        	if(lastSwfLogStoreDto != null && (lastSwfLogStoreDto.getKeyOut()==null||lastSwfLogStoreDto.getKeyOut().trim().length()<=0)){
        		lastSwfLogStoreDto.setKeyOut(caseNo);
            	blSwfLogStoreFacade.update(lastSwfLogStoreDto);
            }
        }
        BLSwfFlowMainFacade blSwfFlowMainFacade = new BLSwfFlowMainFacade();
        SwfFlowMainDto  swfFlowMainDto = blSwfFlowMainFacade.findByPrimaryKey(swfLogFlowID);
        ArrayList endSwfLogDtoList = new ArrayList();
        String condition = "flowId = '" + swfLogFlowID + "' and businessno = '"+ claimNo +"' and nodeType = 'endca' and nodeStatus!='4'"; 
        SwfLogDto swfLogDtoTemp = null;
        SwfLogStoreDto swfLogStoreDtoTemp = null;
        if(!"1".equals(swfFlowMainDto.getStoreFlag())){
            endSwfLogDtoList = (ArrayList)lastuiWorkFlowAction.findNodesByConditions(condition);
            for(Iterator it = endSwfLogDtoList.iterator();it.hasNext();){
            	swfLogDtoTemp =  new SwfLogDto();
            	swfLogDtoTemp = (SwfLogDto) it.next();
            	swfLogDtoTemp.setNodeStatus("4");
            	swfLogDtoTemp.setHandlerName("自动结案");
            	lastuiWorkFlowAction.updateFlow(swfLogDtoTemp);
            }      
        }else{
        	endSwfLogDtoList = (ArrayList)lastuiWorkFlowAction.findStoreNodesByConditions(condition);
            for(Iterator it = endSwfLogDtoList.iterator();it.hasNext();){
            	swfLogDtoTemp =  (SwfLogDto) it.next();
            	swfLogStoreDtoTemp =  new SwfLogStoreDto();
            	PropertyUtils.copyProperties(swfLogStoreDtoTemp, swfLogDtoTemp);
            	swfLogStoreDtoTemp.setNodeStatus("4");
            	swfLogStoreDtoTemp.setHandlerName("自动结案");
            	lastuiWorkFlowAction.updateStoreFlow(swfLogStoreDtoTemp);
            }      
        }
    
        //add by kangzhen end 061125
        //reason:如果有预赔,在审核通过时已经生成了结案节点,在这里将节点置为已处理
        return checkFlag;
    }
    /**
     * 核赔节点的通过（重开赔案自动结案）
     * @param LflowID String 理赔工作流号码
     * @param LlogNo int 理赔工作流节点号码
     * @param businessNo String 业务号码
     * @param notionInfo String 审批意见 人员名 时间时间
     * @param handlerCode String 操作员
     * @throws Exception
     * @return boolean
     */

    public int repassVericAndCloseFlow(HttpServletRequest httpServletRequest, String LflowID, int LlogNo,
            String compensateNo, String claimNo, String notionInfo, String handlerCode) throws Exception {

        System.out.println("----repassVericAndCloseFlow---重开赔案自动结案--");
        String underWriteFlag = "1";
        String swfLogFlowID = LflowID; //工作流号码
        int swfLogLogNo = LlogNo; //工作流logno
        String keyString = ""; //工作流keyIn
        UserDto user = new UserDto(); //因为不是用户自己操作的，所以目前暂时认为就是计算机做的
        user.setUserCode(handlerCode);
        user.setUserName("双核通过");

        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

        SwfLogDto swfLogDto = new SwfLogDto();
        ReCaseDto recaseDto = new ReCaseDto();
        swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, compensateNo);
        System.out.println("%%%%%%%%%%%%%%%%%%swfLogDto%%%%%%%%%%%%%%%%%%%%%%"+swfLogDto.getLogNo());
        int checkFlag = swfLogDto.getLogNo();
        System.out.println("****checkFlag="+checkFlag);
        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;
        keyString = swfLogDto.getKeyIn();
        user.setComCode(swfLogDto.getHandleDept());
        user.setComName(swfLogDto.getDeptName());
        
        System.out.println("****getWorkFlowDto");
        WorkFlowDto workFlowDto = getWorkFlowDto(user, swfLogFlowID, swfLogLogNo, "4", keyString, keyString, keyString,
                compensateNo, true);
        if (workFlowDto == null){
            return -5;
        }
        //追加意见
        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
        System.out.println("********重开赔案自动结案开始********");
        uiWorkFlowAction.deal(workFlowDto);
        //把swfflowmain中所有节点的flowStatus置为"0" 
         SwfFlowMainDto swfFlowMainDto=uiWorkFlowAction.findFlowMainByPrimaryKey(swfLogFlowID);//将flowstatus置为1
         SwfFlowMainDto updswfFlowMainDto = new  SwfFlowMainDto();
         
         //回写重开赔案表(目前结案时不判断第几次重开赔案，可配置化在重开赔案开始时实现)
         int maxSerialNo=0;
         UIRecaseAction  uiRecaseAction  =new  UIRecaseAction ();
         String conditions="claimNo ='"+claimNo+"'";
         if(uiRecaseAction.findByConditions(conditions)!=null){
             maxSerialNo =  uiRecaseAction.getMaxSerialNo(claimNo);
         }else{maxSerialNo =1;}
         recaseDto = uiRecaseAction.findByPrimaryKey(claimNo,maxSerialNo);
         PrpLrecaseDto prpLrecaseDto = recaseDto.getPrpLrecaseDto();
         
         prpLrecaseDto.setCloseCaseDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
         prpLrecaseDto.setCloseCaseUserCode(user.getUserCode());
         recaseDto.setPrpLrecaseDto(prpLrecaseDto);
         uiRecaseAction.savePrpLrecase(recaseDto);
       //重开赔案不更新结案时间
//         UIClaimAction uiClaimmAction =  new  UIClaimAction();
//		 uiClaimmAction.updateEndCaseDate(claimNo, prpLrecaseDto.getCloseCaseDate());
        /** *******************自动结案结束******************** */
        System.out.println("*****重开赔案自动结案结束");
       // UIPrpLchargeDealAction uiPrpLchargeDealAction = new UIPrpLchargeDealAction();
        //if(uiPrpLchargeDealAction.chargedeal(claimNo)){System.out.println("费用分摊完成。");}
        //System.out.println("repassVericAndCloseFlow");
        return checkFlag;
    }
	 /**
     * 检查增加内容是不是合法
     * 
     * @param flowID String
     * @param logNo int
     * @param businessNo String
     * @param swfLogDto SwfLogDto
     * @throws Exception
     * @return int
     */
    private SwfLogDto checkFlowNode(String flowID, int logNo, String businessNo) throws Exception {
        //检查工作流是否合法。。
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        System.out.println("flowID="+flowID);
        System.out.println("logNo="+logNo);
        System.out.println("businessNo="+businessNo);
        SwfLogDto swfLogTemp = uiWorkFlowAction.findNodeByPrimaryKey(flowID, logNo);
        SwfLogDto swfLogDto = new SwfLogDto();
        //没查询到工作流，有错误
        if (swfLogTemp == null) {
            swfLogDto.setLogNo(-1);
            System.out.println("没查询到工作流，有错误");
            return swfLogDto;
        }
        //业务号不是这个工作流上的业务号码，直接返回false
        if (!swfLogTemp.getBusinessNo().equals(businessNo)) {
            swfLogDto.setLogNo(-2);
            System.out.println("业务号不是这个工作流上的业务号码");
            return swfLogDto;
        }
        //已经回退过了
        if (swfLogTemp.getNodeStatus().equals("5")) {
            swfLogDto.setLogNo(-3);
            System.out.println("已经回退过了的案件");
            return swfLogDto;
        }

        //已经提交过了，直接返回ture
        if (swfLogTemp.getNodeStatus().equals("4")) {
            swfLogDto.setLogNo(0);
            System.out.println("已经提交过了的案件");
            return swfLogDto;
        }

        swfLogDto = swfLogTemp;

        //没有问题的
        return swfLogDto;
    }
    /**
     * 整理dto
     * 
     * @param user UserDto
     * @param flowID String
     * @param logNo int
     * @param nodeStatus String
     * @param nextBusinessNo String
     * @param keyIn String
     * @param keyOut String
     * @param wclose boolean
     * @throws Exception
     * @return WorkFlowDto
     */
    private WorkFlowDto getWorkFlowDto(UserDto user, String flowID, int logNo, String nodeStatus, String businessNo,
            String nextBusinessNo, String keyIn, String keyOut, boolean wclose) throws Exception {
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        swfLogDtoDealNode.setFlowID(flowID);
        swfLogDtoDealNode.setLogNo(logNo);
        swfLogDtoDealNode.setNodeStatus(nodeStatus);
        swfLogDtoDealNode.setBusinessNo(businessNo);//计算书号码/赔付号码等
        swfLogDtoDealNode.setNextBusinessNo(nextBusinessNo);
        swfLogDtoDealNode.setKeyIn(keyIn);
        swfLogDtoDealNode.setKeyOut(keyOut);
        WorkFlowDto workFlowDto = new WorkFlowDto();
        if (nodeStatus.equals("5")) { //回退
            //查询工作流状态信息,整理输入，用于初始界面显示
            workFlowDto = workFlowViewHelper.getBackFlowInfo(user, flowID, logNo);
        } else {
            workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
        }
        if (wclose) {
            //关闭操作
            SwfFlowMainDto swfFlowMainDto = new SwfFlowMainDto();
            swfFlowMainDto = uiWorkFlowAction.findFlowMainByPrimaryKey(flowID);
            if (swfFlowMainDto != null) {
                swfFlowMainDto.setCloseDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
                swfFlowMainDto.setFlowStatus("0");
            }
            workFlowDto.setCloseSwfFlowMainDto(swfFlowMainDto);
            workFlowDto.setClose(true);
            //设置submit中的swflog为都提交
            if (workFlowDto.getSubmit()) {
                if (workFlowDto.getSubmitSwfLogDtoList() != null) {
                    ArrayList nodeList = workFlowDto.getSubmitSwfLogDtoList();
                    ArrayList nodeLastList = new ArrayList();
                    //设置的提交节点都自动结束的
                    for (int i = 0; i < nodeList.size(); i++) {
                        SwfLogDto swfLogDto = (SwfLogDto) nodeList.get(i);
                        swfLogDto.setHandlerName("自动结案");
                        swfLogDto.setNodeStatus("4");
                        nodeLastList.add(swfLogDto);
                    }
                    workFlowDto.setSubmitSwfLogDtoList(nodeLastList);
                }
            }
            //由于结案是可能有多个结案的，所以当判断还存在没有关闭的结案，则流程不结束。
            //等待所有的结案都完毕时，流程才结束。
            String conditonss   = "flowId='"+flowID +"' and nodeType='claim' and nodestatus <> '6'";
     		String conditions1  = "flowId='"+flowID +"' and endflag='1' and nodestatus='4'";
     		String conditions2  = "flowId='"+flowID +"' and nodeType='compe' and nodestatus <> '5'";
     		String conditions3  = "flowId='"+flowID +"' and endflag='1' ";
     		//查找该案的理算节点数
     		ArrayList claimList = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditonss);
     		//查找该案的已结束的节点数
     		ArrayList endList   = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions1);
     		//查找理算节点数
     		ArrayList compeList   = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions2);
     		//查找该案的结案节点数
     		ArrayList endList1 = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions3);
     		//假设发现还没有结完案子的流程，则不将流程结束，
     		//只是关闭掉目前立案的相关的那个理算，直接返回现有的workFlowDto.         		
     		if ( (claimList !=null && endList != null && claimList.size() - endList.size() >1) ||
        			 (compeList !=null && endList != null && compeList.size() - endList.size() >1 ) ||
        			 (endList1 != null && endList != null && endList1.size() - endList.size() >0 )
          			){
     			workFlowDto.setClose(false);
     		}
     		

        }
        if (!workFlowViewHelper.checkDealDto(workFlowDto))
            return null;
        return workFlowDto;
    }
    /**
     * 追加披办信息
     * 
     * @param workFlowDto WorkFlowDto
     * @param flowID String
     * @param logNo int
     * @param notion String
     * @throws Exception
     * @return WorkFlowDto
     */
    private WorkFlowDto AddNotionToWorkFlowDto(WorkFlowDto workFlowDto, String flowID, int logNo, String notion)
            throws Exception {
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        int maxLineNo = uiWorkFlowAction.getSwfNotionMaxLineNo(flowID, logNo);
        SwfNotionDto swfNotionDto = new SwfNotionDto();
        swfNotionDto.setFlowID(flowID);
        swfNotionDto.setLogNo(logNo);
        swfNotionDto.setLineNo(maxLineNo);
        if (notion.length() > 70)
            notion = notion.substring(0, 65) + "...";
        swfNotionDto.setHandleText(notion);
        ArrayList notionList = new ArrayList();
        notionList.add(swfNotionDto);
        workFlowDto.setSwfNotionDtoList(notionList);
        return workFlowDto;
    }


   private void insertHerdsettlist(PrpLcompensateDto compensateDto,PrpLclaimDto claimDto)throws Exception {
		BLHerdsettlelistFacade blHerdsettlelistFacade = new BLHerdsettlelistFacade();
		BLSettlemainlistFacade blSettlemainlistFacade = new BLSettlemainlistFacade();
		// String herdFarmerListFlag =
		// SysConfig.getProperty("BREEDING_FARMER_LIST_FLAG");
		String BusinessNo = compensateDto.getCompensateNo();
		if (null != BusinessNo && !"".equals(BusinessNo)) {
			String conditions = " compensateno='"+BusinessNo+"'  and nodetype='compe'";
			PrplcompensateearDto prplcompensateearDto = new PrplcompensateearDto();
			BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
			ArrayList compensateearList = (ArrayList) bLPrplcompensateearFacade
					.findByConditions(conditions);
			ArrayList herdsettlelistDtoList = new ArrayList();
			SettlemainlistDto settlemainlistDto = new SettlemainlistDto();
			if (null != compensateearList && compensateearList.size() > 0) {
				prplcompensateearDto = (PrplcompensateearDto) compensateearList.get(0);
				String Inusrelistcode = prplcompensateearDto
						.getInusrelistcode();
				if (Inusrelistcode != null && !"".equals(Inusrelistcode)) {
					for (int index = 0; index < compensateearList.size(); index++) {
						
						HerdsettlelistDto herdsettlelistDto = new HerdsettlelistDto();
						PrplcompensateearDto compensateearDto = new PrplcompensateearDto();
						String condition = "Settlelistcode = '"+ BusinessNo+"'";
						ArrayList herdsettlelistlist = (ArrayList) blHerdsettlelistFacade
								.findByConditions(condition);
						if (herdsettlelistlist == null
								|| "".equals(herdsettlelistlist)
								|| herdsettlelistlist.size() == 0) {
							compensateearDto = (PrplcompensateearDto) compensateearList
									.get(index);
							herdsettlelistDto
									.setSettlelistcode(compensateearDto
											.getCompensateno());
							herdsettlelistDto.setEarlabel(compensateearDto
									.getEarno());
							herdsettlelistDto.setFcode(compensateearDto
									.getFcode());
							herdsettlelistDto.setKindcode(compensateearDto
									.getKindcode());
							herdsettlelistDto.setSerialno(index + 1);
							herdsettlelistDto.setInsurelistcode(Inusrelistcode);
							herdsettlelistDto.setFname(compensateearDto
									.getName());
							herdsettlelistDto.setFidcard(compensateearDto
									.getId_card());
							herdsettlelistDto
									.setBreedingareacode(compensateearDto
											.getBreedingareacode());
							herdsettlelistDto
									.setBreedingareaname(compensateearDto
											.getBreedingareaname());
							herdsettlelistDto.setBankname(compensateearDto
									.getBank());
							herdsettlelistDto.setBankaccount(compensateearDto
									.getAccount());
							herdsettlelistDto.setDamagetime(compensateearDto
									.getDamagestartdate().toString());// 出险时间
							herdsettlelistDto.setReporttime(compensateearDto
									.getReporttime());
							herdsettlelistDto.setDeadnumber(compensateearDto
									.getDeadnumber());
							herdsettlelistDto.setDeadreason(compensateearDto
									.getDeadreason());
							// herdsettlelistDto.setBreedingareaname(breedingareaname);//养殖地点名称
							herdsettlelistDto.setCullnumber(compensateearDto
									.getCullnumber());
							herdsettlelistDto
									.setSettleamount((int) compensateearDto
											.getSumrealpay());
							herdsettlelistDto.setOpcode(compensateDto
									.getHandlerCode());// 操作员代码
							herdsettlelistDto.setOptime(new DateTime(DateTime
									.current(), DateTime.YEAR_TO_SECOND));// 操作时间
							herdsettlelistDto.setRemark(compensateDto
									.getRemark());
							herdsettlelistDtoList.add(herdsettlelistDto);
						}
					}
					blHerdsettlelistFacade.insertAll(herdsettlelistDtoList);
					settlemainlistDto = blSettlemainlistFacade
							.findByPrimaryKey(BusinessNo);
					if (settlemainlistDto == null
							|| "".equals(settlemainlistDto)) {
						settlemainlistDto = new SettlemainlistDto();
						settlemainlistDto.setSettlelistcode(compensateDto
								.getCompensateNo());
						settlemainlistDto.setInusrelistcode(Inusrelistcode);
						settlemainlistDto.setFareacode(claimDto
								.getDamageAreaCode());
						settlemainlistDto.setClasscode(compensateDto
								.getClassCode());
						settlemainlistDto.setCompensateno(compensateDto
								.getCompensateNo());
						settlemainlistDto.setDamagetime(claimDto
								.getDamageStartDate());
						// settlemainlistDto.setInusrelistcode(inusrelistcode);//承保清单号
						// settlemainlistDto.setOpcode(opcode);//关联操作员代码
						settlemainlistDto.setPolicyno(compensateDto
								.getPolicyNo());
						settlemainlistDto
								.setRegistercode(claimDto.getClaimNo());
						settlemainlistDto.setRemark(claimDto.getRemark());
						settlemainlistDto.setReportcode(claimDto.getRegistNo());
						settlemainlistDto.setRiskcode(compensateDto
								.getRiskCode());
						// settlemainlistDto.setUpdatecode(updatecode);//上次编辑代码
						// settlemainlistDto.setUpdatedate(updatedate);//上次编辑时间
						// settlemainlistDto.setValidity(validity);//清单标志
						blSettlemainlistFacade.insert(settlemainlistDto);
					}
				}
			}

		}
	}
	/**
	 * 补传清单
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws Exception 
	 */
	private void query1(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		try {
			String strRegistNo  =  httpServletRequest.getParameter("registNo");
			strRegistNo = strRegistNo.trim();
			if(strRegistNo!=null&&!"".equals(strRegistNo)){
				String[] registNos = strRegistNo.split("\r\n");
				String registNo = "";
				for(int i = 0;i<registNos.length;i++){
					if(i==registNos.length-1){
						registNo+="'"+registNos[i]+"'";
					}else{
						registNo+="'"+registNos[i]+"',";
					}
				}
				if(null!=registNo&&!"".equals(registNo) ){
					String claimNo="";
					String conditions1 = "RegistNo in ("+registNo+")";
					String conditions2 = "";
					
					BLPrpLclaimFacade claimFacade=new BLPrpLclaimFacade();
					BLPrpLcompensateFacade compensateFacade=new BLPrpLcompensateFacade();
					PrpLcompensateDto compensateDto=new PrpLcompensateDto();
					PrpLclaimDto claimDto=new PrpLclaimDto();
					ArrayList prpLclaimList = (ArrayList)claimFacade.findByConditions(conditions1);
					
			        if (null!=prpLclaimList&&prpLclaimList.size()>0){
			        	for (int i = 0; i<prpLclaimList.size();i++){
			        		claimDto=(PrpLclaimDto)prpLclaimList.get(i);
			        		claimNo = claimDto.getClaimNo();
			        		conditions2 = "claimno ='"+claimNo+"'";
			        		ArrayList prpLcompensateList = (ArrayList)compensateFacade.findByConditions(conditions2);
			                if (null!=prpLcompensateList&&prpLcompensateList.size()>0){
			                	for (int j = 0; j <prpLcompensateList.size() ; j++) {
			                		compensateDto = (PrpLcompensateDto) prpLcompensateList.get(j);
			                		insertHerdsettlist(compensateDto, claimDto);
			                	}
			                }
			        	}
			        }
				}
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
		}
	}
}

