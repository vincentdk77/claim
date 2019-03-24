package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.facade.BLCIClaimSYXPlatFormInterfaceFacade;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.ciplatform.ui.action.UICIClaimDemandAction;
import com.sinosoft.claim.bl.facade.BLPrpLcertifyImgFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.ReCaseViewHelper;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormCheckAction;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimPlatFormInterfaceFacade;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * 分发HTTP Post 车险理赔报案编辑界面
 * <p>Title: 车险理赔报案编辑界面信息</p>
 * <p>Description: 车险理赔报案编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author weishixin
 * @version 1.0
 */
public class UIReCaseEditPostFacade
    extends Action {
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
    Exception {

    String forward = ""; //向前流转
     
    /*
     * * 程序思路：
     *========================================================
     (1)查此案件重开赔案表（prplrecase）中有没有记录，没有则把serialNo置为1，有则累加serialNo
     (2)增加一条记录到重开赔案表
     (3)删除立案表中的结案日期
     (4)打开流转轨迹
     (5)产生一条待处理的理算任务     
     *======================================================== */
    try {
      
      UICodeAction uiCodeAction = new UICodeAction();
      String strRiskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");
     
      String claimNo          = httpServletRequest.getParameter("ClaimNo");
      String PolicyNo         = httpServletRequest.getParameter("PolicyNo");
      String riskCode         = httpServletRequest.getParameter("riskCode");
      String appRecaseReason  = httpServletRequest.getParameter("appRecaseReason");
      String reCaseDate       = httpServletRequest.getParameter("reCaseDate");
      String reCasehandleCode = httpServletRequest.getParameter("reCasehandleCode");
     
      int year = DateTime.current().getYear()  ;
      int serialNo=0;
      
      UserDto   user     =  (UserDto)httpServletRequest.getSession().getAttribute("user");
      String    comCode  =  user.getComCode() ;
         
         //从界面整理数据到reCaseDto,增加一条重开赔案记录
         ReCaseViewHelper  reCaseViewHelper = new ReCaseViewHelper();
         ReCaseDto reCaseDto = reCaseViewHelper.viewToDto(httpServletRequest);
         BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
         PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo.trim());
         //用来操作工作流的传输对象
         WorkFlowDto workFlowDto = new WorkFlowDto();
      
         //1.寻找工作流上的编码
         UIWorkFlowAction  uiWorkFlowAction =new UIWorkFlowAction();
         String flowId = uiWorkFlowAction.findStoreFlowIDBybusinessNo(claimNo); //获取flowId
         //modify by lixiang start at 2006-6-7
         //reason :检查工作流是否已经关闭,如关闭，则需要新生成理算任务，若没关闭，则只要将寻找的到结案号的一个结案变成0状态。
         //考虑漏洞。。重开赔案目前没有任何的的业务操作，则以后会不会有漏洞。。。
        
         if (flowId.equals( "")) {
        	 //一般情况下从转储表取，若没有转储，则从swflog表取
        	 flowId = uiWorkFlowAction.findFlowIDBybusinessNo(claimNo); 
        	 if (flowId.equals( "")) {
        		 throw new Exception("案件未查询到工作流信息，不能重开赔案！");	
        	 }
         }
         //2.检查流程现在的状态
         SwfFlowMainDto swfFlowMainDto=uiWorkFlowAction.findFlowMainByPrimaryKey(flowId);//将flowstatus置为1
         //已转储的从转储表取数据
         int maxLogNo= 0;  //db层maxLogNo是取的最大LogNo+1
         int maxEndcaseLogNo = 0; 
         BLSwfLogStoreFacade blSwflogStoreFacade = null;
         SwfLogDto swfLogjaDto = new SwfLogDto();
         //查询此立案最后一次理算节点
         String condition = "flowid='"+flowId+"' and businessno='"+claimNo+"' and nodeType='compe' order by logNo desc";
         //检查是否现在这个立案已经重开过赔案了，不能再重新开赔案了。。
         String compeStr ="flowid='"+flowId+"' and businessno='"+claimNo+"' and nodeType='compe' and flowstatus>'0' and nodestatus<'4'";
         Collection nodes = null;
         int compeCount = 0;
         //已转储的数据从swflogStore查询
         if("1".equals(swfFlowMainDto.getStoreFlag())){
        	 blSwflogStoreFacade = new BLSwfLogStoreFacade();
        	 maxLogNo = blSwflogStoreFacade.getMaxLogNo(flowId);
        	 maxEndcaseLogNo = blSwflogStoreFacade.getMaxNodeLogNo(flowId,"endca",claimNo); 
        	 swfLogjaDto = blSwflogStoreFacade.findByPrimaryKey(flowId,maxEndcaseLogNo);
        	 nodes = uiWorkFlowAction.findStoreNodesByConditions(condition);
        	 compeCount = uiWorkFlowAction.findFlowStoreNodeCountByConditon(compeStr);
         //未转储的数据从Swflog查询
         }else{
             maxLogNo= uiWorkFlowAction.getSwfLogMaxLogNo(flowId);  //db层maxLogNo是取的最大LogNo+1
             maxEndcaseLogNo = uiWorkFlowAction.getSwfLogMaxNodeLogNo(flowId,"endca",claimNo); 
             swfLogjaDto = uiWorkFlowAction.findNodeByPrimaryKey(flowId,maxEndcaseLogNo); //swfLogjaDto为结案结点的swflogDto
             nodes = uiWorkFlowAction.findNodesByConditions(condition);
             compeCount = uiWorkFlowAction.findFlowNodeCountByConditon(compeStr);
         }
         if (nodes == null || nodes.size() == 0){
           	throw new UserException(1,10,"重开赔案","没有发现此立案的理算节点！");
         }
         if (compeCount>0){
          	throw new UserException(1,10,"重开赔案","此案件的立案已经重开过赔案并未处理完毕，请不要再重开赔案！");
          }
         //生成一条待处理理算任务
         int modelNo=0; //默认
         SwfLogDto   swfLoglsDto = new SwfLogDto();          //swfLoglsDto为生成新理算节点的swfLogDto
         ArrayList swfLogList = new ArrayList();             //保存新增加的理算节点
         ArrayList swfPathLogList= new ArrayList();          //保存新增加的结案到理算的线信息
   
         if(swfLogjaDto==null){
          	throw new UserException(1,10,"重开赔案","案件未查询到结案的工作流信息，不能重开赔案！");
            
         }
         
         String conditions=" businessNo = '"+prpLclaimDto.getRegistNo()+"'  and ValidStatus ='1' and typeCode ='0105' ";
//         BLPrpLcertifyImgFacade blPrpLcertifyImgFacade = new BLPrpLcertifyImgFacade();
//         ArrayList<PrpLcertifyImgDto> PrpLcertifyImgDtoList = (ArrayList<PrpLcertifyImgDto>) blPrpLcertifyImgFacade.findByConditions(conditions);
//         if(null == PrpLcertifyImgDtoList || PrpLcertifyImgDtoList.size()==0){
//      	   throw new UserException(1,3,"重开赔案","至少上传一张重开赔案照片！");
//         }  
//          
          
         //3.关闭的流程的处理
         if(swfLogjaDto!=null&&swfFlowMainDto.getFlowStatus().equals( "0") ){
         	//3.1开启工作流主表数据，打开工作流的节点所有数据
         	swfFlowMainDto.setFlowStatus( "1");
            workFlowDto.setReOpen(true);
            workFlowDto.setReOpenSwfFlowMainDto(swfFlowMainDto);
         }
        
//         SwfLogDto swfLogCompe = (SwfLogDto)nodes.iterator().next();
//         //4.形成新的理赔节点数据
//         modelNo=swfLogjaDto.getModelNo() ;
//         SwfNodeDto  swfNodeDto= uiWorkFlowAction.findModelNodeByNodeType(modelNo,"compe");  
//         int nodeNo= swfNodeDto.getNodeNo();
//         String nodeName=swfNodeDto.getNodeName(); 
//           
//         if (nodeName==null||nodeName.trim().equals("")) nodeName="nodename";
//         String beforeHandlerCode=swfLogjaDto.getHandlerCode();
//         String beforeHandleName =swfLogjaDto.getHandlerName();
//         
//         swfLoglsDto.setBeforeHandlerCode(beforeHandlerCode);
//         swfLoglsDto.setBeforeHandlerName(beforeHandleName);
//         swfLoglsDto.setBusinessNo(claimNo); 
//         swfLoglsDto.setComCode(swfLogCompe.getComCode());
//         swfLoglsDto.setFlowID(flowId);
//       
//         swfLoglsDto.setFlowInTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
//         swfLoglsDto.setFlowStatus("1");
//         swfLoglsDto.setKeyIn(claimNo);
//         swfLoglsDto.setLogNo(maxLogNo);
//         swfLoglsDto.setNodeName(nodeName);   //modify 20051118
//         
//         swfLoglsDto.setNodeNo(nodeNo);     //modify 20051118
//         swfLoglsDto.setNodeStatus("0"); 
//         swfLoglsDto.setNodeType("compe");
//         swfLoglsDto.setPackageID("0");     //y 
//         swfLoglsDto.setMainFlowID("0");    //y
//          
//         swfLoglsDto.setSubFlowID("0");  //y
//         swfLoglsDto.setRegistNo(swfLogjaDto.getRegistNo());
//         swfLoglsDto.setInsuredName(swfLogjaDto.getInsuredName());
//    
//         swfLoglsDto.setPolicyNo(PolicyNo);
//         swfLoglsDto.setRiskCode(riskCode);
//         swfLoglsDto.setModelNo(modelNo); 
//         swfLoglsDto.setHandleDept(swfLogCompe.getHandleDept());
//         swfLoglsDto.setHandleTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
//         
//         swfLoglsDto.setTaskNo(swfNodeDto.getTaskNo());      //看文档
//         swfLoglsDto.setTaskType(swfNodeDto.getTaskType());  //看文档
//         swfLoglsDto.setTitleStr("重开赔案"); //看文档
//         swfLoglsDto.setDeptName(user.getComName());
//         swfLoglsDto.setPosX(0); //看文档
//         swfLoglsDto.setPosY(0); //看文档
//         swfLoglsDto.setTypeFlag(swfNodeDto.getTypeFlag());
//         if(riskCode.substring(0,2).equals("05")){
//           swfLoglsDto.setLossItemCode(swfLogjaDto.getLossItemCode());
//           swfLoglsDto.setLossItemName(swfLogjaDto.getLossItemName());
//         }
//         swfLoglsDto.setEndFlag(swfNodeDto.getEndFlag()); //看文档
//         swfLogList.add(swfLoglsDto );
         
         ArrayList<SwfLogDto> nextList=new ArrayList<SwfLogDto>();
         modelNo=swfLogjaDto.getModelNo() ;
         SwfNodeDto  swfNodeDto= uiWorkFlowAction.findModelNodeByNodeType(modelNo,"rcase");  
         int nodeNo= swfNodeDto.getNodeNo();
         String nodeName=swfNodeDto.getNodeName(); 
         SwfLogDto nextSwfLogDto = new SwfLogDto();
         nextSwfLogDto = swfLogjaDto;
         nextSwfLogDto.setNodeNo(nodeNo);
         nextSwfLogDto.setNodeName(nodeName);
         nextSwfLogDto.setFlowInTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
         nextSwfLogDto.setFlowStatus("1");
         
         nextSwfLogDto.setKeyIn(claimNo);
         nextSwfLogDto.setLogNo(maxLogNo);
         nextSwfLogDto.setNodeStatus("0"); 
         nextSwfLogDto.setNodeType("rcase");
         nextSwfLogDto.setPackageID("0");     //y 
         nextSwfLogDto.setMainFlowID("0");    //y
          
         nextSwfLogDto.setSubFlowID("0");  //y
         nextSwfLogDto.setRegistNo(swfLogjaDto.getRegistNo());
         nextSwfLogDto.setInsuredName(swfLogjaDto.getInsuredName());
         
         nextSwfLogDto.setHandleDept(swfLogjaDto.getHandleDept());
         nextSwfLogDto.setHandleTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
         String beforeHandlerCode=swfLogjaDto.getHandlerCode();
         String beforeHandleName =swfLogjaDto.getHandlerName();
         nextSwfLogDto.setBeforeHandlerCode(beforeHandlerCode);
         nextSwfLogDto.setBeforeHandlerName(beforeHandleName);
         nextSwfLogDto.setTaskNo(swfNodeDto.getTaskNo());      //看文档
         nextSwfLogDto.setTaskType(swfNodeDto.getTaskType());  //看文档
         nextSwfLogDto.setTitleStr("重开赔案"); //看文档
         nextSwfLogDto.setDeptName(user.getComName());
         nextSwfLogDto.setPosX(0); //看文档
         nextSwfLogDto.setPosY(0); //看文档
         nextSwfLogDto.setTypeFlag(swfNodeDto.getTypeFlag());
         if(swfLogjaDto.getRiskCode().substring(0,2).equals("05")){
        	 nextSwfLogDto.setLossItemCode(swfLogjaDto.getLossItemCode());
        	 nextSwfLogDto.setLossItemName(swfLogjaDto.getLossItemName());
         }
         nextSwfLogDto.setEndFlag(swfNodeDto.getEndFlag()); //看文档
         nextList.add(nextSwfLogDto);
         
         //5.形成新的理赔线数据
         String pathName ="从 结案 到 "+ nodeName ;
         SwfPathLogDto swfPathLogDtoTemp = new SwfPathLogDto();
         swfPathLogDtoTemp.setPathNo(uiWorkFlowAction.getSwfPathLogMaxPathNo( flowId) );
         swfPathLogDtoTemp.setFlowID(flowId );
         swfPathLogDtoTemp.setStartNodeNo(maxEndcaseLogNo );
         swfPathLogDtoTemp.setStartNodeName( "结案");
         swfPathLogDtoTemp.setEndNodeNo(maxLogNo );
         swfPathLogDtoTemp.setEndNodeName( nodeName );
         swfPathLogDtoTemp.setModelNo(modelNo); 
         swfPathLogDtoTemp.setPathName(pathName);
         SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
           
         swfPathLogList.add(swfPathLogDtoTemp );
         //6.设置新增加方式，做为后台数据保存的来源。
         workFlowDto.setSubmit( true);
         workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogList );
         workFlowDto.setSubmitSwfLogDtoList(nextList );
       
         //------------------------------------------------------------------------------
         UIRecaseAction uiRecaseAction = new  UIRecaseAction();
         uiRecaseAction.save(reCaseDto, workFlowDto);
         
         /*** 报案注销送审核平台 start****/
         int vericLogNo = 0;
         if (workFlowDto.getSubmitSwfLogDtoList() != null
   					&& workFlowDto.getSubmitSwfLogDtoList().size() > 0) {
   				vericLogNo = ((SwfLogDto) workFlowDto
   						.getSubmitSwfLogDtoList().get(0)).getLogNo();
   		}
   		UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
   		String UWflowID = uiWorkFlowApprovalInterFaceFacade
   					.submitApprovalPlatform("ClaimRecase",nextSwfLogDto.getFlowID(),
   							Integer.valueOf(vericLogNo).toString(),claimNo,prpLclaimDto.getRiskCode(),prpLclaimDto.getClassCode(),
   							prpLclaimDto.getComCode(),user.getUserCode(),
   							prpLclaimDto.getMakeCom(),user.getUserCode(),
   							user.getUserCode(),"");
   		if (UWflowID.length() < 15) {
   				String msg = "案件'" + prpLclaimDto.getClaimNo()
   						+ "'提交双核系统失败，请重新提交或者与管理员联系!";
   				throw new UserException(1, 3, "工作流", msg);
   		}
   		/*** 报案注销送审核平台 end****/
         
//       modify by lixiang end at 2006-6-7
         user.setUserMessage("申请重开赔案成功");
 
      //默认不需要自动跳转
      forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
   }

    catch(SQLException sqle)
    {
      StringWriter stringWriter = new StringWriter();
      sqle.printStackTrace(new PrintWriter(stringWriter));
      sqle.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString() ) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch (Exception e) {
      StringWriter stringWriter = new StringWriter();
      e.printStackTrace(new PrintWriter(stringWriter));
      e.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally {

    }

    return actionMapping.findForward(forward);
  }
  
  
}
