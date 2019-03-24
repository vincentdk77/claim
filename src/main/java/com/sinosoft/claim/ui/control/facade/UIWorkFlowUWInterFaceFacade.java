package com.sinosoft.claim.ui.control.facade;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;

import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLprepayFacade;
import com.sinosoft.claim.bl.facade.BLPrplreturnvisitswflogFacade;
import com.sinosoft.claim.bl.facade.BLSwfFlowMainFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrplpendtrackDto;
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
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimAcciSdPlatFormInterfaceFacade;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimPropPlatFormInterfaceFacade;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;

/**
 * 工作流操作逻辑
 * <p>
 * Title: 车险理赔
 * </p>
 * <p>
 * Description: 车险理赔工作流接口程序
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author 项目组
 * @version 1.0
 */
public class UIWorkFlowUWInterFaceFacade {

    /**
     * 在双核流程流转中产生新任务
     * 
     * @param LflowID String 理赔工作流号码
     * @param LlogNo String 理赔工作流节点号码
     * @param modelType String 模板类型 11:核保模板/22:核赔模板
     * @param certiType String 业务类型 T/P/E/C/Y
     * @param businessNo String 业务号
     * @param riskCode String 险种代码
     * @param classCode String 险类代码
     * @param comCode String 业务归属
     * @param handlerCode String 经办人代码
     * @param makecom String 出单部门
     * @param userCode String 系统操作人员
     * @param handler1Code String 业务归属人代码
     * @param contractNo String 合同号（一般针对车险、现只对车险核保有意义
     * @throws Exception
     * @return String
     */
    public String submitVericTask(String LflowID, String LlogNo, String modelType, String certiType, String businessNo,
            String riskCode, String classCode, String comCode, String handlerCode, String makecom, String userCode,
            String handler1Code, String contractNo) throws Exception {

        String uwFlowID = "";

        //判断是不是双核没有打开？？
        //UW_URLOPEN
        UIWFUWClientFacade uiWFUWClientAction = new UIWFUWClientFacade();

        String SERVER_OPEN = AppConfig.get("sysconst.UW_URLOPEN");
        if (SERVER_OPEN.equals("1")) {
            uwFlowID = uiWFUWClientAction.sendXMLData(LflowID, LlogNo, modelType, certiType, businessNo, riskCode,
                    classCode, comCode, handlerCode, makecom, userCode, handler1Code, contractNo);
        } else {
            uwFlowID = "1111111111111111111111111";
        }
        System.out.println("获得uwFlowID＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝"+uwFlowID);
        return uwFlowID;

    }

    /**
     * 双核流程流转中对理赔中的核赔节点的内容变更
     * 
     * @param LflowID String 理赔工作流号码
     * @param LlogNo int 理赔工作流节点号码
     * @param businessNo String 业务号码
     * @param notionInfo String 审批意见 人员名 时间时间
     * @param handlerCode String 操作员
     * @throws Exception
     * @return boolean
     */

    public int addInformationOnVeric(String LflowID, int LlogNo, String businessNo, String notionInfo,
            String handlerCode) throws Exception {
        //取赔款计算书号
        String swfLogFlowID = LflowID; //工作流号码
        int swfLogLogNo = LlogNo; //工作流logno

        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        SwfLogDto swfLogDto = new SwfLogDto();
        swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);

        int checkFlag = swfLogDto.getLogNo();
        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;

        //如果成功的话，存在工作流，那么就需要提交工作流，如果没有就算了
        WorkFlowDto workFlowDto = new WorkFlowDto();
        swfLogDto.setNodeStatus("2");
        swfLogDto.setHandleTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY).toString());
        workFlowDto.setUpdate(true);
        workFlowDto.setUpdateSwfLogDto(swfLogDto);
        System.out.println("addInformationOnVeric");

        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
        uiWorkFlowAction.deal(workFlowDto);
        System.out.println("addInformationOnVeric");
        return checkFlag;
    }
    /**
     * 核赔节点的退回
     * 
     * @param LflowID String 理赔工作流号码
     * @param LlogNo int 理赔工作流节点号码
     * @param businessNo String 业务号码
     * @param notionInfo String 审批意见 人员名 时间时间
     * @param handlerCode String 操作员
     * @throws Exception
     * @return boolean
     */

    public int backVericToCompp(String LflowID, int LlogNo, String businessNo, String notionInfo, String handlerCode)
            throws Exception {

        //取赔款计算书号
        String compensateNo = businessNo;
        String underWriteFlag = "1";
        String swfLogFlowID = LflowID; //工作流号码
        int swfLogLogNo = LlogNo; //工作流logno
        String keyString = ""; //工作流keyIn
        UserDto user = new UserDto(); //因为不是用户自己操作的，所以目前暂时认为就是计算机做的
        user.setUserCode(handlerCode);
        user.setUserName("双核回退");
        SwfLogDto swfLogDto = new SwfLogDto();
        //保存赔款计算书信息,如果双核可以直接写这边的业务数据库，就不需要这一步了。
        UICompensateAction uiCompensateAction = new UICompensateAction();
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);

        int checkFlag = swfLogDto.getLogNo();
        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;
        keyString = swfLogDto.getKeyIn();//获得立案号码
        user.setComCode(swfLogDto.getHandleDept());
        user.setComName(swfLogDto.getDeptName());

        //目前在接口中，如果双核没有写我们的业务库，那么就用这个保存，如果已经写了我们的业务库，那么只要保存工作流数据就可以了
        //uiCompensateAction.approve(compensateNo,user.getUserCode(),underWriteFlag);
        //如果成功的话，存在工作流，那么就需要提交工作流，如果没有就算了
        WorkFlowDto workFlowDto = getWorkFlowDto(user, swfLogFlowID, swfLogLogNo, "5", compensateNo, keyString,
                keyString, compensateNo, false);

        if (workFlowDto == null)
            return -5;
        //追加意见
        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
        
        
        if("1".equals(swfLogDto.getDataFlag())){
        	if(workFlowDto.getSubmitSwfLogDtoList()!=null){
            	ArrayList<SwfLogDto>  list = (ArrayList<SwfLogDto>)workFlowDto.getSubmitSwfLogDtoList();
            	for (SwfLogDto swfLogDto2 : list) {
            		swfLogDto2.setDataFlag("1");
    			}
            }
        }
        
        uiWorkFlowAction.deal(workFlowDto);

        System.out.println("backVericToCompp");
        return checkFlag;
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
            String notionInfo, String handlerCode) throws Exception {
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
            String businessNo, String notionInfo, String handlerCode) throws Exception {
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
        
        //by dongkun 修改自动结案时的结案节点的keyout存储：begin==========
        //修改前：logno最大值对应的节点的keyout字段为空时才存。
        //修改后：先找到结案节点，再修改该节点的keyout字段
        
//        int logMaxNo = lastuiWorkFlowAction.getSwfLogMaxLogNo(swfLogFlowID)-1;//此时swflog表已经没有数据logMaxNo=0
//        SwfLogDto lastSwfLogDto = lastuiWorkFlowAction.findNodeByPrimaryKey(swfLogFlowID,logMaxNo);
//        if(lastSwfLogDto != null ){
//        	if(lastSwfLogDto.getKeyOut()==null||lastSwfLogDto.getKeyOut().trim().length()<=0){//lastSwfLogDto.getKeyOut()=609083700002018000007-001
//            	lastSwfLogDto.setKeyOut(caseNo);
//            	BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
//            	blSwfLogFacade.updateStatus(lastSwfLogDto);
//        	}
//        }else{
//        	BLSwfLogStoreFacade blSwfLogStoreFacade = new BLSwfLogStoreFacade();
//        	logMaxNo = blSwfLogStoreFacade.getMaxLogNo(swfLogFlowID) -1;
//        	SwfLogStoreDto lastSwfLogStoreDto =  blSwfLogStoreFacade.findByPrimaryKey(swfLogFlowID,logMaxNo);
//        	if(lastSwfLogStoreDto != null && (lastSwfLogStoreDto.getKeyOut()==null||lastSwfLogStoreDto.getKeyOut().trim().length()<=0)){
//        		lastSwfLogStoreDto.setKeyOut(caseNo);
//            	blSwfLogStoreFacade.update(lastSwfLogStoreDto);
//            }
//        }
        String conditions2 = " flowid= '"+swfLogFlowID+"' and nodeType = 'endca' ";
        ArrayList<SwfLogDto> endcaSwfLogDtoList = (ArrayList)lastuiWorkFlowAction.findNodesByConditions(conditions2);
        	if(endcaSwfLogDtoList != null && endcaSwfLogDtoList.size() != 0 ){
        		for(int i=0;i<endcaSwfLogDtoList.size();i++){
        			SwfLogDto endcaSwfLogDto = endcaSwfLogDtoList.get(i);
        			if(endcaSwfLogDto.getKeyOut()==null||endcaSwfLogDto.getKeyOut().trim().length()<=0){//lastSwfLogDto.getKeyOut()=609083700002018000007-001
        				endcaSwfLogDto.setKeyOut(caseNo);
        				BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
        				blSwfLogFacade.updateStatus(endcaSwfLogDto);
        			}
        		}
            }else{
            	BLSwfLogStoreFacade blSwfLogStoreFacade = new BLSwfLogStoreFacade();
            	ArrayList<SwfLogStoreDto> endcaSwfLogStoreDtoList = (ArrayList)blSwfLogStoreFacade.findByConditions(conditions2);
            	for(int j=0;j<endcaSwfLogStoreDtoList.size();j++){
            		SwfLogStoreDto endcaSwfLogStoreDto = endcaSwfLogStoreDtoList.get(j);
            		if(endcaSwfLogStoreDto != null && (endcaSwfLogStoreDto.getKeyOut()==null||endcaSwfLogStoreDto.getKeyOut().trim().length()<=0)){
            			endcaSwfLogStoreDto.setKeyOut(caseNo);
            			blSwfLogStoreFacade.update(endcaSwfLogStoreDto);
            		}
            	}
            }
      //by dongkun 修改自动结案时的结案节点的keyout存储：end==========
        
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
        
         //山东意外险风险预警结案登记接口交互begin
		 String groupFlag = "";
		 String strPolicyNo = prpLclaimDto.getPolicyNo();//获取保单号
		 boolean isSuccess = false;
		 String upComCode = new BLPrpDcompany().getDaaPlatformComCode(prpLclaimDto.getComCode());
		 if(AppConfig.get("sysconst.SDACCI_RISKCODE").indexOf(prpLclaimDto.getRiskCode())>-1 && "370000".equals(upComCode)){
			 DBManager dbManager = new DBManager();
			 System.out.println("----山东意外险风险预警结案登记接口调用,claimNo= " + prpLclaimDto.getClaimNo() +" ----");
			 //根据保单号来查询保单信息,判断该保单是否为团单
			 BLPrpCmain blPrpCmain = new BLPrpCmain();
			 blPrpCmain.getData(strPolicyNo);	
			 try {	
			 	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			 	if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
					groupFlag = "0";//个险
				}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
					groupFlag = "1";//团险
				}
			 	isSuccess = BLCIClaimAcciSdPlatFormInterfaceFacade.getInstance().upload(dbManager, "L02", claimNo, groupFlag);
			 	if(isSuccess){
				    user.setUserMessage(user.getUserMessage() + "<br>山东意外险风险预警结案登记接口上传成功!");
				}else{
					user.setUserMessage(user.getUserMessage() + "<br>山东意外险风险预警结案登记接口上传失败!");
				}
			} catch (Exception e) {
				e.printStackTrace();								
				throw new Exception(e.getMessage() + "山东意外险风险预警结案登记接口上传失败!");
			}finally{
				dbManager.close();
			}
		}
		//山东意外险风险预警结案登记接口交互end
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
      //上海意健险平台结案接口交互begin
    	 PrpLclaimDto prpLclaimDto = recaseDto.getPrpLclaimDto();
		 boolean isYJXFlag = false;
		 String groupFlag = "";
		 String strPolicyNo = prpLclaimDto.getPolicyNo();//获取保单号
		 boolean isSuccess = false;
		 if("26,27,28".indexOf(prpLclaimDto.getRiskCode().substring(0,2)) > -1){
		  	isYJXFlag = true;
		 }
		 String upComCode = new BLPrpDcompany().getDaaPlatformComCode(prpLclaimDto.getComCode());
		 if(isYJXFlag && "310000".equals(upComCode)){
			 DBManager dbManager = new DBManager();
			 System.out.println("------------------上海平台意健险结案接口调用,claimNo= " + prpLclaimDto.getClaimNo() +" --------------------------");
			 //根据保单号来查询保单信息,判断该保单是否为团单
			 BLPrpCmain blPrpCmain = new BLPrpCmain();
			 blPrpCmain.getData(strPolicyNo);	
			 try {	
			 	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			 	//根据prpcmain.groupNo是否为空判断是否为团单
			 	if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
					groupFlag = "0";//个险
					isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C01", "03", prpLclaimDto.getClaimNo(),strPolicyNo,groupFlag,upComCode);
				}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
					groupFlag = "1";//团险
					isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C04", "03", prpLclaimDto.getClaimNo(),strPolicyNo,groupFlag,upComCode);
				}
			} catch (Exception e) {
				e.printStackTrace();								
				throw new Exception(e.getMessage() + "意健险上传平台失败,结案登记失败!");
			}finally{
				dbManager.close();
			}
		}
		//上海意健险平台结案接口交互end
		//山东意外险风险预警结案登记接口交互begin
		 if(AppConfig.get("sysconst.SDACCI_RISKCODE").indexOf(prpLclaimDto.getRiskCode())>-1 && "370000".equals(upComCode)){
			 DBManager dbManager = new DBManager();
			 System.out.println("----山东意外险风险预警结案登记接口调用,claimNo= " + prpLclaimDto.getClaimNo() +" ----");
			 //根据保单号来查询保单信息,判断该保单是否为团单
			 BLPrpCmain blPrpCmain = new BLPrpCmain();
			 blPrpCmain.getData(strPolicyNo);	
			 try {	
			 	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			 	if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
					groupFlag = "0";//个险
				}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
					groupFlag = "1";//团险
				}
			 	isSuccess = BLCIClaimAcciSdPlatFormInterfaceFacade.getInstance().upload(dbManager, "L02", claimNo, groupFlag);
			 	if(isSuccess){
				    user.setUserMessage(user.getUserMessage() + "<br>山东意外险风险预警结案登记接口上传成功!");
				}else{
					user.setUserMessage(user.getUserMessage() + "<br>山东意外险风险预警结案登记接口上传失败!");
				}
			} catch (Exception e) {
				e.printStackTrace();								
				throw new Exception(e.getMessage() + "山东意外险风险预警结案登记接口上传失败!");
			}finally{
				dbManager.close();
			}
		}
		//山东意外险风险预警结案登记接口交互end
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
     		
     		// add by dongkun 特殊赔案的后续理算核赔通过环节在这里workflowdto不能关闭的bug   begin=================
     		String conditions4  = "flowId='"+flowID +"' and nodeType='speci' ";
     		//查找该案子是否有特殊赔案操作
     		ArrayList speciList = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions4);
     		//假设发现还没有结完案子的流程，则不将流程结束，
     		//只是关闭掉目前立案的相关的那个理算，直接返回现有的workFlowDto.         		
     		if ( (claimList !=null && endList != null && claimList.size() - endList.size() >1) ||
        			 (compeList !=null && endList != null && compeList.size() - endList.size() >1 ) ||
        			 (endList1 != null && endList != null && endList1.size() - endList.size() >0 && speciList.size()==0)
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

}

