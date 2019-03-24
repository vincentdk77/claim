package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.sinosoft.claim.bl.action.custom.BLClaimAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLRegistRPolicyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCancelClaimDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrplinterAutoClaimDetailAction;
import com.sinosoft.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.bl.facade.BLDangerUnitFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterCancelClaimDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpCmainCargoDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIExchAction;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIRiskUnitAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowApprovalInterFaceFacade;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.undwrt.bl.facade.BLWfCheckAdvanceFacade;
import com.sinosoft.undwrt.bl.facade.BLWfLogFacade;
import com.sinosoft.undwrt.dto.domain.UwNotionDto;
import com.sinosoft.undwrt.dto.domain.WfLogDto;
import com.sinosoft.undwrt.ui.control.action.UICommonDealSubmitAction;
import com.sinosoft.undwrt.ui.control.action.UIWflogQueryAction;
import com.sinosoft.undwrt.ui.model.UwNotionSaveNotionCommand;
import com.sinosoft.utiall.dbsvr.DBPrpDcompany;
import com.sinosoft.utiall.dbsvr.DBPrpDuser;
import com.sinosoft.utility.SysConfig;

/**
 * 报案注销类
 * */
public class UIMedicalAutoRegistCancleSubViewHelpe {
	/**
	 * 报案注销逻辑
	 * @param prpLinterRequestDto
	 * @return
	 * @throws Exception
	 */
	public PrpLinterCancelClaimRequestDto autoRegistCancel(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto) throws Exception{
		PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = new PrpLinterCancelClaimDetailDto();
		//组装user对象，方便后续使用
		UserDto user = new UserDto();
		user.setUserCode(prpLinterCancelClaimRequestDto.getOperatorCode());
		user.setUserName(prpLinterCancelClaimRequestDto.getOperatorName());
		user.setComCode(prpLinterCancelClaimRequestDto.getMakeCom());
		user.setComName(prpLinterCancelClaimRequestDto.getMakeComName());
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
	    UIRegistAction uiRegistAction = new UIRegistAction();
	    UIClaimAction uiClaimAction = new UIClaimAction();
		DBManager dbManager = new DBManager();
		dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;

	    try {
	       //开始事务
		   dbManager.beginTransaction();
		   String id = prpLinterCancelClaimRequestDto.getId();
		   BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
		   prpLinterCancelClaimDetailDto.setId(id);
		   prpLinterCancelClaimDetailDto.setRegistNo(prpLinterCancelClaimRequestDto.getRegistNo());
	    	
		   String registNo = prpLinterCancelClaimRequestDto.getRelationRegistNo();
		   if(registNo==null || "".equals(registNo)){
			   registNo = prpLinterCancelClaimDetailDto.getRegistNo();
		   }
	       RegistDto registDto = this.cancelViewToDto(prpLinterCancelClaimRequestDto, user, registNo);
	       
	       //保存立案拒赔注销信息
	       WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
	       //以下为工作流使用中的
	       //得到流程编号
	       String swfLogFlowID = uiWorkFlowAction.findFlowIDByRegistNo(registDto.getPrpLregistDto().getRegistNo());
	       String swfLogLogNo = "1"; //工作流logno黙认为1
	       SwfLogDto swfLogDtoDealNode = new SwfLogDto();
	       
	       String uploadUpolicyNo = "";
	       
	       //需要检查是否有已经立案的，但是是正常的立案的情况。。。
	       String strSql = "registNo='"+registDto.getPrpLregistDto().getRegistNo()+"' and canceldate is null ";
	       Collection claimList =uiClaimAction.findByConditions(strSql);
	       if (claimList!=null&&claimList.size() >0){
		       String msg = "此报案目前有"+claimList.size()+"保单已经立案，请做完此保单的立案注销后，再进行报案的全部注销！";
		       throw new UserException(1,3,"报案注销",msg);
		   }
	       if (swfLogFlowID!=null && swfLogLogNo!=null&&!swfLogFlowID.equals("null")&& !swfLogLogNo.equals("null")){
	             swfLogDtoDealNode.setFlowID(swfLogFlowID);
	             swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
	       }
	       swfLogDtoDealNode.setNodeStatus("4");
	       swfLogDtoDealNode.setEndFlag("1");
	       WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
	       
	       //取交强险保单号
	       String strWhere = " registNo = '" + registDto.getPrpLregistDto().getRegistNo() + "' and policyType='3' ";
	       Collection collection = new UIPrpLregistRPolicyAction().findByConditions(strWhere);
	       for(Iterator iter = collection.iterator();iter.hasNext();){
	    	   PrpLRegistRPolicyDto  prpLRegistRPolicyDto = (PrpLRegistRPolicyDto)iter.next();
	      	   uploadUpolicyNo = prpLRegistRPolicyDto.getPolicyNo();
	       }
	       if (workFlowViewHelper.checkDealDto(workFlowDto)){
	           //设置本节点为注销状态
	           if (workFlowDto.getUpdateSwfLogDto() !=null){
	        	   workFlowDto.getUpdateSwfLogDto().setNodeStatus( "6"); //撤消的流程
	        	   workFlowDto.getUpdateSwfLogDto().setSubmitTime(prpLinterCancelClaimRequestDto.getCancelDate().toString());
	           }
	           uiRegistAction.saveRegistCancel(registDto,workFlowDto);
	       }else{
	      	   throw new Exception("工作流不合法");
	       }
	       
	       prpLinterCancelClaimDetailDto.setCancelSuccFlag("1");
		   prpLinterCancelClaimDetailDto.setRemark("报案注销成功："+prpLinterCancelClaimDetailDto.getRegistNo());
		   blPrpLinterCancelClaimDetailAction.insert(dbManager, prpLinterCancelClaimDetailDto);
	      //提交事务
		  dbManager.commitTransaction();
	    } catch (Exception e) {
	      dbManager.rollbackTransaction();
	      prpLinterCancelClaimDetailDto.setCancelSuccFlag("0");
		  String messege = e.toString();
		  if(messege!=null&&messege.length()>1000){
			  messege = messege.substring(0,1000);
		  }
		  prpLinterCancelClaimDetailDto.setRemark("报案注销失败："+messege);;
		  new BLPrpLinterCancelClaimDetailFacade().insert(prpLinterCancelClaimDetailDto);
	      e.printStackTrace();
	      throw e;
	    }finally{
	    	dbManager.close();//增加数据库连接关闭
	    }
	     
	    return prpLinterCancelClaimRequestDto;
	  }
	
	/**
     * 报案注销时数据整理
     * @param httpServletRequest
     * @return RegistDto 报案数据传输数据结构
     * @throws Exception
     */
     public RegistDto cancelViewToDto(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto,UserDto user,String registNo) throws Exception{
       
       //初始化变量
       int RULE_LENGTH = 70; //rule字段的长度  
       RegistDto registDto = new RegistDto ();
       String msg = "";
       UIRegistAction uiRegistAction = new UIRegistAction();
       
       //得到报案号
       String strRegistNo =  registNo;
       //  判断报案号码是否存在
       if (!uiRegistAction.isExist(strRegistNo)){
       	   msg = "没有接收到合法的报案号！";
           throw new UserException(1,3,"报案注销",msg);
       }
       
       //得到报案对象
       registDto = uiRegistAction.findByPrimaryKey(strRegistNo);
       
       //收集报案注销原因
      
       ArrayList<PrpLregistTextDto> prpLregistTextDtoList = new ArrayList<PrpLregistTextDto>();
       String context = prpLinterCancelClaimRequestDto.getCancelContext();
       if(context != null && context.length()>0){
           String[] rules = StringUtils.split(context, RULE_LENGTH);
           //得到连接串,下面将其切分到数组
           for (int k = 0; k < rules.length; k++) {
               PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
               prpLregistTextDto.setRegistNo(registNo);
               prpLregistTextDto.setContext(rules[k]);
               prpLregistTextDto.setLineNo(k + 1);
               prpLregistTextDto.setTextType("2");
               prpLregistTextDtoList.add(prpLregistTextDto);
           }
       }
       
       //装入RegistDto
       registDto.setPrpLregistTextDtoList(prpLregistTextDtoList);
       
       //设置报案信息
       PrpLregistDto prpLregistDto = registDto.getPrpLregistDto() ;

       prpLregistDto.setCancelDate(new DateTime(prpLinterCancelClaimRequestDto.getCancelDate()));
       prpLregistDto.setDealerCode(prpLinterCancelClaimRequestDto.getDealerCode());
       prpLregistDto.setCancelReason(prpLregistDto.getCancelReason());
       prpLregistDto.setCancelReasonName(prpLregistDto.getCancelReasonName());
       prpLregistDto.setReportorName(prpLregistDto.getReportorName());
       registDto.setPrpLregistDto(prpLregistDto);
       if(registDto.getPrpLRegistRPolicyList()!=null){
    	   for(int i=0;i<registDto.getPrpLRegistRPolicyList().size();i++){
    		 PrpLRegistRPolicyDto  prpLRegistRPolicyDto=(PrpLRegistRPolicyDto)registDto.getPrpLRegistRPolicyList().get(i);
	         prpLRegistRPolicyDto.setRegistValidStatus("0");
	         prpLRegistRPolicyDto.setValidStatus("0");
		     prpLRegistRPolicyDto.setCancelOperaterCode(user.getUserCode());
		     prpLRegistRPolicyDto.setCancelComCode(user.getComCode());
		     prpLRegistRPolicyDto.setCancelReason(registDto.getPrpLregistDto().getCancelReason());
		     prpLRegistRPolicyDto.setCancelReasonName(registDto.getPrpLregistDto().getCancelReasonName());
		     prpLRegistRPolicyDto.setCancelDate(registDto.getPrpLregistDto().getCancelDate().toString());
		     registDto.getPrpLRegistRPolicyList().set(i, prpLRegistRPolicyDto);
    	   }
       }
       return registDto;
   }

     
     
     /**
 	 * 立案注销申请逻辑
 	 * @param prpLinterRequestDto
 	 * @return
 	 * @throws Exception
 	 */
 		PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = new PrpLinterCancelClaimDetailDto();
 		public PrpLinterCancelClaimRequestDto autoClaimCancel(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto) throws Exception{
 		//组装user对象，方便后续使用
 		UserDto user = new UserDto();
 		user.setUserCode(prpLinterCancelClaimRequestDto.getOperatorCode());
 		user.setUserName(prpLinterCancelClaimRequestDto.getOperatorName());
 		user.setComCode(prpLinterCancelClaimRequestDto.getMakeCom());
 		user.setComName(prpLinterCancelClaimRequestDto.getMakeComName());
 		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
 	    UIRegistAction uiRegistAction = new UIRegistAction();
 	    UIClaimAction uiClaimAction = new UIClaimAction();
 	    DAAClaimViewHelper daaClaimViewHelper = new DAAClaimViewHelper();
 		DBManager dbManager = new DBManager();
 		String msg = "";
 		prpLinterCancelClaimDetailDto.setId(prpLinterCancelClaimRequestDto.getId());
		prpLinterCancelClaimDetailDto.setPolicyNo(prpLinterCancelClaimRequestDto.getPolicyno());
		prpLinterCancelClaimDetailDto.setRegistNo(prpLinterCancelClaimRequestDto.getRegistNo());
 		dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
 		int RULE_LENGTH = 70;
 	    try {
 	       //开始事务
 		   dbManager.beginTransaction();
 		
 		  String caseType = prpLinterCancelClaimRequestDto.getCaseType();
 		  ClaimDto claimDto = new ClaimDto();
          
          String outRegistNo = prpLinterCancelClaimRequestDto.getOutRegistNo();

          String claimNo  = prpLinterCancelClaimRequestDto.getClaimNo();
          String registNo= prpLinterCancelClaimRequestDto.getRegistNo();
          String cancelReaseon =prpLinterCancelClaimRequestDto.getCancelContext();
          String prpCancel = prpLinterCancelClaimRequestDto.getCancelReson();
          String prpExclusions = prpLinterCancelClaimRequestDto.getCancelReson();
          /*---------------------立案主表prpLclaim------------------------------------*/
          PrpLclaimDto prpLclaimDto =null;
          if ((claimNo==null)||claimNo.equals(""))
          {
           msg = " 此案件没有立案，可以通知报案人员进行报案注销操作！";
           if ("1".equals(caseType)){
           	 msg = " 此案件没有立案，需要通知立案人员先进行立案后，再申请！";
              
           }
           throw new UserException(1,3,"注销/拒赔",msg);
          }
          prpLclaimDto = claimDtoToView(prpLinterCancelClaimRequestDto, claimNo);
          
          

          if (prpLclaimDto==null)
          {
            msg = "没有查询到相关立案！";
            throw new UserException(1,3,"拒赔",msg);
          }
          prpLclaimDto.setFlag("0"); //只update就可以了。。
          
          //设置第一次进入时的默认信息
          //prpLclaimDto.setCancelDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
          prpLclaimDto.setDealerCode(user.getUserCode() );
          prpLclaimDto.setDealerName(user.getUserName() );
          prpLclaimDto.setCancelReason(cancelReaseon);
          prpLclaimDto.setCaseType(caseType);
          if("1".equals(caseType)){
          	prpLclaimDto.setCancelReasonExplan(prpExclusions);
          }else{
          	prpLclaimDto.setCancelReasonExplan(prpCancel);
          }
          //用工作流的
          claimDto.setPrpLclaimDto(prpLclaimDto);

         /*---------------------立案注销文本表prpLltext------------------------------------*/
         ArrayList prpLltextDtoList = new ArrayList();
         PrpLltextDto prpLltextDto = null;
         String TextTemp = prpLinterCancelClaimRequestDto.getCancelContext();
         String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
         
         //得到连接串,下面将其切分到数组
         for (int k = 0; k < rules.length; k++) {
             prpLltextDto = new PrpLltextDto();
             prpLltextDto.setClaimNo(claimNo);
             prpLltextDto.setContext(rules[k]);
             prpLltextDto.setLineNo(k + 1);
             prpLltextDto.setTextType("10");
             prpLltextDtoList.add(prpLltextDto); 
         }

          //装入ClaimDto
         claimDto.setPrpLltextDtoList(prpLltextDtoList);

         /*---------------------立案操作状态内容prpLclaimStatus默认为完成------------------------------------*/
         PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
         prpLclaimStatusDto.setStatus("4");
         prpLclaimStatusDto.setBusinessNo(prpLclaimDto.getClaimNo() );
         prpLclaimStatusDto.setPolicyNo(prpLclaimDto.getPolicyNo());
         prpLclaimStatusDto.setNodeType("claim");

         //取得当前用户信息，写操作员信息到实际claimstatus中

        prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
        prpLclaimStatusDto.setInputDate(prpLclaimDto.getInputDate() );
        prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
        prpLclaimStatusDto.setRiskCode(prpLclaimDto.getRiskCode() );
        claimDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        
        BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
        String swfLogFlowID = ""; //工作流号码
        String swfLogLogNo = ""; //工作流logno
        ArrayList swflogList = (ArrayList)blSwfLogFacade.findByConditions("registno='"+registNo+"' and nodetype='certi'");
       
        SwfLogDto  swfLogDto= (SwfLogDto)swflogList.get(0);
        swfLogFlowID = swfLogDto.getFlowID();
        swfLogLogNo =String.valueOf(swfLogDto.getLogNo());
        
        String role = "";
        String appcode = "";
        String appname = "";  
        String username="";
        String comcode = "";
        String comname= "";
        int t = 0;
        DBPrpDuser dbPrpDuser = new DBPrpDuser();
        DBPrpDcompany dbprpDcompany = new DBPrpDcompany();
        t = dbPrpDuser.getInfo(user.getUserCode());
        username=dbPrpDuser.getUserName();
        t = dbprpDcompany.getInfo(dbPrpDuser.getComCode());
        comcode = dbPrpDuser.getComCode();
        comname= dbprpDcompany.getComCName();
        String result = "";
        
      //防止回退刷新再提交，或多人同时操作提交同一案件。
		String condition = "flowId ='"+swfLogFlowID+"' and  logno= "+ swfLogLogNo+"  and nodeStatus = '4'";
	    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
	    if(certifyNodeList!=null&&certifyNodeList.size()>0){
	    	   throw new UserException(1,3,"工作流","该案件注销/拒赔节点已处理！");
	    }
	    
	    WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        SwfLogDto swfLogNextNode= new SwfLogDto();
        Collection nextNodeList = new ArrayList();
    	
        //申请登记

        if (swfLogFlowID!=null && swfLogLogNo!=null&&!swfLogFlowID.equals("null")&& !swfLogLogNo.equals("null"))
        {
          swfLogDtoDealNode.setFlowID(swfLogFlowID);
          swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
        }
        
        swfLogDtoDealNode.setNodeType("certi");
        swfLogDtoDealNode.setNodeStatus("4");
        swfLogDtoDealNode.setBusinessNo("");
        swfLogDtoDealNode.setNextBusinessNo(claimDto.getPrpLclaimDto().getClaimNo() ); 
        
        //设置流转到注销/拒赔的受理节点去
        swfLogNextNode.setNodeNo(0);
       
        swfLogNextNode.setNodeType("cance");
        swfLogNextNode.setKeyIn(claimDto.getPrpLclaimDto().getClaimNo());
        swfLogNextNode.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
        swfLogNextNode.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
        
        //判断是注销还是拒赔，是要放在工作流上的
        swfLogNextNode.setTypeFlag( caseType);
        nextNodeList.add(swfLogNextNode);
        swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
        swfLogDtoDealNode.setSwfLogList(nextNodeList);
        //保存注销原因
        UIPrpLregistRPolicyAction  uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction(); 
        PrpLRegistRPolicyDto  prpLRegistRPolicyDto = uiPrpLregistRPolicyAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getRegistNo(),claimDto.getPrpLclaimDto().getPolicyNo());
        if (prpLRegistRPolicyDto!=null ){
        	claimDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
        }
        
        swfLogDtoDealNode.setKeyIn(claimDto.getPrpLclaimDto().getClaimNo() );
        swfLogDtoDealNode.setKeyOut(claimDto.getPrpLclaimDto().getClaimNo() );
        WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
        
        workFlowDto.setUpdate( false);
		workFlowDto.setUpdateSwfLogDto( null);
		
		new BLClaimAction().save(dbManager,claimDto);
	    if(workFlowDto!=null){
	        new BLWorkFlowAction().deal(dbManager,workFlowDto);
	    }    
		/************ 立案注销送审核平台start *****************/
		int vericLogNo = 0;
		if (workFlowDto.getSubmitSwfLogDtoList() != null
				&& workFlowDto.getSubmitSwfLogDtoList().size() > 0) {
			vericLogNo = ((SwfLogDto) workFlowDto
					.getSubmitSwfLogDtoList().get(0)).getLogNo();
		}
		
		UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
		String UWflowID = uiWorkFlowApprovalInterFaceFacade
		                      .submitApprovalPlatform("ClaimCance", swfLogDtoDealNode.getFlowID(),String.valueOf(vericLogNo),
		                    		  claimNo, claimDto.getPrpLclaimDto().getRiskCode(), claimDto.getPrpLclaimDto().getClassCode(), 
		                    		  claimDto.getPrpLclaimDto().getComCode(), user.getUserCode(),
		                    		  claimDto.getPrpLclaimDto().getMakeCom(), user.getUserCode(), user.getUserCode(), "");
		
		if (UWflowID.length() < 15) {
		    msg = "案件'" + claimNo
					+ "'提交双核系统失败，请重新提交或者与管理员联系!";
			throw new UserException(1, 3, "工作流", msg);
		}
		/************ 立案注销送审核平台end ****************/
        
		
		   BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
		   
		   prpLinterCancelClaimDetailDto.setClaimCancelFlag("1");
 		   prpLinterCancelClaimDetailDto.setRemark("立案注销申请成功："+prpLinterCancelClaimDetailDto.getRegistNo());
 		   blPrpLinterCancelClaimDetailAction.insert(dbManager, prpLinterCancelClaimDetailDto);
 	      //提交事务
 		  dbManager.commitTransaction();
          
 	    } catch (Exception e) {
 	      dbManager.rollbackTransaction();
 	      prpLinterCancelClaimDetailDto.setClaimCancelFlag("0");
 		  String messege = e.toString();
 		  if(messege!=null&&messege.length()>1000){
 			  messege = messege.substring(0,1000);
 		  }
 		  prpLinterCancelClaimDetailDto.setRemark("立案注销申请失败："+messege);;
 		  new BLPrpLinterCancelClaimDetailFacade().insert(prpLinterCancelClaimDetailDto);
 	      e.printStackTrace();
 	      throw e;
 	    }finally{
 	    	dbManager.close();//增加数据库连接关闭
 	    }
 	     
 	    return prpLinterCancelClaimRequestDto;
 	  }
 	
 	 /**
 	 * 立案注销审批逻辑
 	 * @param prpLinterRequestDto
 	 * @return
 	 * @throws Exception
 	 */
 	public PrpLinterCancelClaimRequestDto autoCancelApprov(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto) throws Exception{
 		PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = new PrpLinterCancelClaimDetailDto();
 		//组装user对象，方便后续使用
 		UserDto user = new UserDto();
 		String userCode = prpLinterCancelClaimRequestDto.getDealerCode();
 		
 		user.setUserCode(userCode);
 		user.setUserName(prpLinterCancelClaimRequestDto.getOperatorName());
 		user.setComCode(prpLinterCancelClaimRequestDto.getMakeCom());
 		user.setComName(prpLinterCancelClaimRequestDto.getMakeComName());
 		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
 	    UIRegistAction uiRegistAction = new UIRegistAction();
 	    UIClaimAction uiClaimAction = new UIClaimAction();
 		DBManager dbManager = new DBManager();
 		dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;

 	    try {
 	       //开始事务
 		   dbManager.beginTransaction();
 		   String id = prpLinterCancelClaimRequestDto.getId();
 		   String registNo = prpLinterCancelClaimRequestDto.getRegistNo();
 		   String claimNo = prpLinterCancelClaimRequestDto.getClaimNo();
 		   BLWfLogFacade blWfLogFacade = new BLWfLogFacade();
 		   ArrayList wflogList = (ArrayList)blWfLogFacade.findByConditions("businessno='"+claimNo+"'");
 		   WfLogDto wfLogDto = (WfLogDto)wflogList.get(0);
 		   String operatorCode= "";
 		   BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
 		   prpLinterCancelClaimDetailDto = blPrpLinterCancelClaimDetailAction.findByPrimaryKey(dbManager, id);
 	    	
 		   String flowId = wfLogDto.getFlowID();
		   int LogNo  =    blWfLogFacade.getCount("businessno='"+claimNo+"'");;
		   int ModelNo = wfLogDto.getModelNo();
		   int NodeNo = 6;
		   int currendNodeNo = 2;
		   String Flag = "";
		   String selectNodeName = "审核通过";
           UICommonDealSubmitAction uiCommonDealSubmitAction = new UICommonDealSubmitAction();
           //任务处理的主方法
          
           WfLogDto wfLogCurrDto = null;
           UIWflogQueryAction uiWflogQueryAction = new UIWflogQueryAction();
		   wfLogCurrDto = uiWflogQueryAction.findByPrimaryKey(flowId, LogNo);
		   //判断该工作流已处理流转，控制两用户对同一业务单进行操作时的冲突，从而引起工作流混乱
		   if(wfLogCurrDto != null)
			{
				if(wfLogCurrDto.getNodeStatus() != null && !"".equals(wfLogCurrDto.getNodeStatus()))
				{
					if("4".equals(wfLogCurrDto.getNodeStatus()) || "0".equals(wfLogCurrDto.getNodeStatus()))
					{
						throw new Exception("该工作流已处理流转，请不要重复操作！");
					}
				}
			}
			Flag = "1"; // 0表示从业务系统提交到双核，1表示双核系统内部提交
			
			String HandleText = StringUtils.replace(prpLinterCancelClaimRequestDto.getHandleText(), "'", "''");
			if (HandleText == null) {
				HandleText = "";
			}
			UwNotionDto uwNotionDto = new UwNotionDto();
			uwNotionDto.setFlowID(flowId);
			uwNotionDto.setLogNo(LogNo);
			uwNotionDto.setHandleText(HandleText);

			// 将HandleText拆分成多条 变成多个uwNotionDto对象批量插入uwNotion表
			UwNotionSaveNotionCommand uwNotionSaveNotionCommand = new UwNotionSaveNotionCommand(uwNotionDto);
			uwNotionSaveNotionCommand.execute();
			//权限控制
			BLWfCheckAdvanceFacade blWfCheckAdvanceFacade = new BLWfCheckAdvanceFacade();
			boolean hasPath = blWfCheckAdvanceFacade.checkAdvanceCondition(	ModelNo, currendNodeNo, "O", claimNo, "1",null);
			if (hasPath) {
				//这里没有语句
			}
			else{
				throw new UserException( -98, -1007,"你的权限不够!","请提交上级或下发修改!"); 
			}
			
			String uwFlowID = new UIWorkFlowApprovalInterFaceFacade(). submitApprovalPlatform("MedicalAutoRecasApprov",flowId,
					"3",claimNo,"2801","28",user.getComCode(),prpLinterCancelClaimRequestDto.getHandleText(),user.getComCode(),
					user.getUserCode(), user.getUserCode(), prpLinterCancelClaimRequestDto.getHandleText());
			
			if(!"SUCCESS".equals(uwFlowID)){
				throw new Exception("重开审批失败处理失败");
			}
			
//			blWfLogFacade.submitTaskApproval(flowId, ModelNo, NodeNo, "O", claimNo, "0",
//					Flag, userCode, operatorCode);
			/***************************************************************
			 * 1.更新立案节点
			 **************************************************************/
			BLPrpLclaimAction bLPrpLclaimAction  = new BLPrpLclaimAction();
			BLSwfLogAction blSwfLogFacade = new BLSwfLogAction();
			SwfLogDto swfLogDto = new SwfLogDto();
			ArrayList<SwfLogDto> list1 = (ArrayList<SwfLogDto>) blSwfLogFacade
			.findByConditions(dbManager, "businessNO='"
					+ claimNo + "' and nodeType='cance'");
			if (list1 != null && !list1.isEmpty()) {
				swfLogDto = list1.get(0);
			}
			BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
			PrpLclaimDto  prpLclaimDto  = bLPrpLclaimAction.findByPrimaryKey(dbManager, claimNo);
			ArrayList<SwfLogDto> list = (ArrayList<SwfLogDto>) blSwfLogFacade
					.findByConditions(dbManager, "businessNO='"
							+ claimNo + "' and nodeType='claim'");
			if (list != null && !list.isEmpty()) {
				SwfLogDto swfLogDto2 = list.get(0);
				swfLogDto2.setNodeStatus("6");
				blSwfLogFacade.update(dbManager, swfLogDto2);
			}
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			swfLogDto.setNodeStatus("4");
			BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
			/** ********************************* */
			UIBillAction uiBillAction = new UIBillAction();
			String tableName = "prplcaseno";
			String comCode = user.getComCode();
			String riskCode = "2801";
			int year = DateTime.current().getYear();
			 DAAEndcaseViewHelper endCaseViewHelper= new DAAEndcaseViewHelper();
			String caseNo = endCaseViewHelper.getCaseNo(claimNo, comCode);
			prpLclaimDto.setCaseNo(caseNo);
			prpLclaimDto.setEndCaseDate(new DateTime(prpLinterCancelClaimRequestDto.getCancelDate(), DateTime.YEAR_TO_SECOND));
			prpLclaimDto.setEndCaserCode(user.getUserCode());
			prpLclaimDto.setCaseNo(caseNo);
			prpLclaimDto.setCaseType("0");
			// 最后通过的时候才写这个数据的的
			prpLclaimDto.setCancelDate(new DateTime(prpLinterCancelClaimRequestDto.getCancelDate(), DateTime.YEAR_TO_DAY));
			BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
			PrpLRegistRPolicyDto prpLRegistRPolicyDto = blPrpLRegistRPolicyAction
					.findByPrimaryKey(dbManager,
							prpLclaimDto.getRegistNo(), prpLclaimDto
									.getPolicyNo());
			//统一报案需求：立案注销修改
			prpLRegistRPolicyDto.setValidStatus("0");
			prpLRegistRPolicyDto.setClaimNo(claimNo);
			
			
			blPrpLRegistRPolicyAction.update(dbManager,
					prpLRegistRPolicyDto);
			// 是否所有立案都结案了,如果都结案了，就需要做工作流转储
			boolean isAllClaimEnd = false;
			isAllClaimEnd = true;
			WorkFlowDto workFlowDto = null;
			if (isAllClaimEnd) {
				swfLogDto.setEndFlag("1");// 设置为1则会进行转储
			}
			workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDto);
			SwfLogDto updateDto = workFlowDto.getUpdateSwfLogDto();
			updateDto.setBusinessNo(claimNo);
			blWorkFlowAction.deal(dbManager, workFlowDto);
			
 	       
 	       prpLinterCancelClaimDetailDto.setCancelApprovFlag("1");
 		   prpLinterCancelClaimDetailDto.setRemark("立案注销审批成功："+prpLinterCancelClaimDetailDto.getRegistNo());
 		   blPrpLinterCancelClaimDetailAction.update(dbManager, prpLinterCancelClaimDetailDto);
 		   
 		   String sqlCance = " Update swflogStore Set  submittime='"+prpLinterCancelClaimRequestDto.getCancelDate()
                                                     +"',flowintime='" +prpLinterCancelClaimRequestDto.getCancelDate()
                                                     +"',handletime='" +prpLinterCancelClaimRequestDto.getCancelDate()
                                                     +"' Where registno ='"+registNo+"' and nodeType ='cance'";
           new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sqlCance);
           
           String sqlWCance = " Update wflogStore Set  submittime='"+prpLinterCancelClaimRequestDto.getCancelDate()
                                                  +"',flowintime='" +prpLinterCancelClaimRequestDto.getCancelDate()
                                                   +"',handletime='" +prpLinterCancelClaimRequestDto.getCancelDate()
                                                    +"' Where businessno ='"+claimNo+"'";
           new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sqlWCance);
 		   
 		   bLPrpLclaimAction.update(dbManager, prpLclaimDto);
 	      //提交事务
 		  dbManager.commitTransaction();
 	    } catch (Exception e) {
 	      dbManager.rollbackTransaction();
 	      prpLinterCancelClaimDetailDto.setCancelApprovFlag("0");
 		  String messege = e.toString();
 		  if(messege!=null&&messege.length()>1000){
 			  messege = messege.substring(0,1000);
 		  }
 		  prpLinterCancelClaimDetailDto.setRemark("立案注销审批失败："+messege);;
 		  new BLPrpLinterCancelClaimDetailFacade().update(prpLinterCancelClaimDetailDto);
 	      e.printStackTrace();
 	      throw e;
 	    }finally{
 	    	dbManager.close();//增加数据库连接关闭
 	    }
 	     
 	    return prpLinterCancelClaimRequestDto;
 	  }
 	
 	
 	/**
     * 填写立案页面及查询立案request的生成. 填写立案时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
     * 
     * @param httpServletRequest 返回给页面的request
     * @param proposalIniDto 取出的初始化信息Dto
     * @throws Exception
     */

    public PrpLclaimDto claimDtoToView(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto, String claimNo) throws Exception {
        //查询立案信息
    	UIClaimAction uiClaimAction = new UIClaimAction();
    	UICodeAction uiCodeAction = new UICodeAction();
        ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto(); 
        //给prpLclaimDto赋值
        if (claimDto.getPrpLclaimDto() == null) {
            String msg = "案件'" + claimNo + "'无法查询到！";
            throw new UserException(1, 3, "查询", msg);
        }
        prpLclaimDto = claimDto.getPrpLclaimDto();
        String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLclaimDto.getRiskCode());
        PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
        UICheckAction uiCheckAction = new UICheckAction();
        CheckDto checkDto = uiCheckAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getRegistNo());
        String timeTemp = StringConvert.toStandardTime(prpLclaimDto.getDamageStartHour());
        prpLclaimDto.setDamageStartHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageStartMinute(timeTemp.substring(3, 5));
        timeTemp = StringConvert.toStandardTime(prpLclaimDto.getDamageEndHour());
        prpLclaimDto.setDamageEndHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageEndMinute(timeTemp.substring(3, 5));
        
        String riskCode = prpLclaimDto.getRiskCode();
        String registNo = prpLclaimDto.getRegistNo();
        
        

        //设置立案操作的状态为 案件修改 (正处理任务)
        if (claimDto.getPrpLclaimStatusDto() != null) {
            if (claimDto.getPrpLclaimStatusDto().getStatus().equals("7"))
                claimDto.getPrpLclaimStatusDto().setStatus("3");
            prpLclaimDto.setStatus(claimDto.getPrpLclaimStatusDto().getStatus());
        } else {
            //已提交，已经处理完毕的状态
            prpLclaimDto.setStatus("4");
        }

        /*
         * 从保单中获得信息 原因：因为这些保单信息都已经保存到立案表信息中了，故注掉，但是因为需要转换界面上的 车辆信息，所以仍需要去取保单和下面的车辆信息这一个过程。
         */
        PolicyDto policyDto=null;
        if (!claimDto.getPrpLclaimDto().getPolicyNo().equals("")) {
            //查询保单信息
        	EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
    		//根据出险时间还原保单信息
        	policyDto = endorseViewHelper.findForEndorBefore(claimDto.getPrpLclaimDto().getPolicyNo()
        	  		,claimDto.getPrpLclaimDto().getDamageStartDate().toString()
					,claimDto.getPrpLclaimDto().getDamageStartHour());
        	
            prpLclaimDto.setClaimDate(new DateTime(prpLclaimDto.getClaimDate(),DateTime.YEAR_TO_DAY));
            prpLclaimDto.setClaimTime(new DateTime(prpLclaimDto.getClaimTime(), DateTime.YEAR_TO_SECOND));
        	
        	 
            //取被保险人名称，对于团单需要显示名称
            String strInsuredNameShow = "";
			int insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();
			if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
					|| insureQuantity <= 1 ) {
			    	strInsuredNameShow = policyDto.getPrpCmainDto().getInsuredName();
			}
			else {
					strInsuredNameShow = policyDto.getPrpCmainDto().getInsuredName()+"等"+insureQuantity+"人";
			}
			prpLclaimDto.setInsuredNameShow(strInsuredNameShow);
			prpLclaimDto.setSumInsured(policyDto.getPrpCmainDto().getSumInsured());
			
        }
        //设置相关代码的中文转换
        changeCodeToName(prpLclaimDto);
        //设置窗体表单中各个多选框中列表信息的内容
        
        //查询相同保单号的出险次数
        DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
       
        
        
        PubTools pubTools=new PubTools();
	    int time= pubTools.compareDate(policyDto.getPrpCmainDto().getInputDate().toString(),"2011-02-27");
	    //用旧的获取危险单位信息方法
        
        
      

        //设置各个子表信息项到窗体表单
        claimDto.setPrpLpersonTraceDtoList(claimDto.getPrpLpersonTraceDtoList());
        //显示立案日期和现在日期之间的工作日天数
        UIRegistAction uiRegistAction = new UIRegistAction();
        RegistDto registDto = uiRegistAction.findByPrimaryKey(prpLclaimDto.getRegistNo());
        DateTime registDate = registDto.getPrpLregistDto().getReportDate();
        
        //立案环节增加理赔联系记录
        Collection arrayListRegistExt = new ArrayList();
        PrpLregistExtDto prpLregistExtDto  = new PrpLregistExtDto();
        prpLregistExtDto.setRegistNo(claimDto.getPrpLclaimDto().getRegistNo());
        prpLregistExtDto.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
        arrayListRegistExt = claimDto.getPrpLregistExtDtoList();       
        prpLregistExtDto.setRegistExtList(arrayListRegistExt) ;
        
        //事故者模块   
        ArrayList prpLacciBenPersonDtoList = claimDto.getPrplacciBenPersonDtoList();
        PrpLacciPersonDto  prpLacciPersonDto = new PrpLacciPersonDto();
        prpLacciPersonDto.setPrpLacciBenPersonList(prpLacciBenPersonDtoList);
        
       	//索赔申请人
        ArrayList prpLacciPersonDtoList = claimDto.getPrpLacciPersonDtoList();
        prpLacciPersonDto.setPrpLacciPersonList(prpLacciPersonDtoList);
        //索赔申请人end-------------------------------------
        
        
        
        //缺省带出报案的币别 2005-09-05
        prpLclaimDto.setEstiCurrency(registDto.getPrpLregistDto().getEstiCurrency());
        
        //获取兑换率信息 2005-09-05
        Collection prpdexchDtoList = new ArrayList();
        UIExchAction uiExchAction = new UIExchAction(); 
        
        return prpLclaimDto;
    }
    
    /**
     * 根据PrpClaimDto中的已经设置的代码内容，对代码进行名称转换
     * 
     * @param httpServletRequest 返回给页面的request
     * @param prpClaimDto 立案的数据类
     * @param ClaimDto 查询出的数据类
     * @throws Exception
     */
    private void changeCodeToName(PrpLclaimDto prpLclaimDto) throws Exception {
        UICodeAction uiCodeAction = new UICodeAction();
        //(1)条款名称的转换
        String clauseType = prpLclaimDto.getClauseType();
        String clauseName = uiCodeAction.translateCodeCode("ClauseType", clauseType, true);
        prpLclaimDto.setClauseName(clauseName);
        //(2)号牌颜色转换
        String licenseColorCodeCode = prpLclaimDto.getLicenseColorCode();
        String licenseColor = uiCodeAction.translateCodeCode("LicenseColor", licenseColorCodeCode, true);
        prpLclaimDto.setLicenseColor(licenseColor);
        //(3)车辆类型转换
        String carKindCode = prpLclaimDto.getCarKindCode();
        String carKind = uiCodeAction.translateCodeCode("CarKind", carKindCode, true);
        prpLclaimDto.setCarKind(carKind);
        
        //(4)对业务归属结构进行转换
        String comCode = prpLclaimDto.getComCode();
        String comName = uiCodeAction.translateComCode(comCode, true);
        prpLclaimDto.setComName(comName);
        //(5)对归属业务员进行转换
        String handler1Code = prpLclaimDto.getHandler1Code();
        String handler1Name = uiCodeAction.translateUserCode(handler1Code, true);
        prpLclaimDto.setHandler1Name(handler1Name);
        //(6)对代理人进行转换
        String agentCode = prpLclaimDto.getAgentCode();
        String agentName = uiCodeAction.translateUserCode(agentCode, true);
        prpLclaimDto.setAgentName(agentName);
        //(7)对经办人进行转换
        String handlerCode = prpLclaimDto.getHandlerCode();
        String handlerName = uiCodeAction.translateUserCode(handlerCode, true);
        prpLclaimDto.setHandlerName(handlerName);
        
        //(8)对案件性质进行转换 2005-08-01
        String strClaimType = prpLclaimDto.getClaimType();
        String strClaimTypeName = uiCodeAction.translateCodeCode("CaseCode",strClaimType, true);
        prpLclaimDto.setClaimTypeName(strClaimTypeName);
        
        //(9)对业务类型进行转换
        String strBusinessNature = prpLclaimDto.getBusinessNature();
        String strBusinessNatureName = uiCodeAction.translateCodeCode("BusinessNature",strBusinessNature, true);
        prpLclaimDto.setBusinessNatureName(strBusinessNatureName);
        //10)对语种转换
 //System.out.println("aaaaaaaaaaaa"+prpLclaimDto.getLanguage());       
        if(prpLclaimDto.getLanguage().equals("C"))
        {
            prpLclaimDto.setLanguageName("中文");
        }
        if(prpLclaimDto.getLanguage().equals("E"))
        {
            prpLclaimDto.setLanguageName("英文");
        }
        //(11)对makeCom进行转换 add by liuyanmei 20051115 
        //reason :itest bug 647 立案任务查询，理赔登记部门显示的只有代码，没有名称。
        String makeCom = prpLclaimDto.getMakeCom();
        String makeComName = uiCodeAction.translateComCode(makeCom, true);
        prpLclaimDto.setMakeComName(makeComName);
        
    }
 	
}
