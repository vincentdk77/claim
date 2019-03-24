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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICertifyAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAACertifyViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * 分发HTTP Post 车险理赔单证编辑界面
 * <p>Title: 车险理赔单证编辑界面信息</p>
 * <p>Description: 车险理赔单证编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author liubvo
 * @version 1.0
 */
public class UILCertifyEditPostCombineOneFacade  extends Action {
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
     throws  Exception
  {

    String forward = ""; //向前流转
    String dealHref = "";
	String flowStr = "";
    try {
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      //用viewHelper整理界面输入
       DAACertifyViewHelper daaCertifyViewHelper = new DAACertifyViewHelper();
       CertifyDto certifyDto = daaCertifyViewHelper.viewToDto(httpServletRequest);
       UICodeAction uiCodeAction = new UICodeAction();
       String claimNo = uiCodeAction.translateBusinessCode(certifyDto.getPrpLclaimStatusDto().getBusinessNo(),true);
       //在数据整理那里，把swfLogFlowID,和swfLogLogNo重新写到request里面了。。
       String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //工作流号码
       String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //工作流logno
       String riskCode =httpServletRequest.getParameter("riskCode");
      //工作流处理过程???
      //-----------------------------------------------------
      // 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码????
      //单证需要写的是registno,诶，所以要得到claimno作为下个节点的录入
       
       //组织暂存页面成功后往回跳转路径
        BLPrpLclaimFacade bLPrpLclaimFacade = new BLPrpLclaimFacade();
        PrpLclaimDto prpLclaimDto = bLPrpLclaimFacade.findByPrimaryKey(claimNo);
        String policyNo = prpLclaimDto.getPolicyNo();
        String registNo = prpLclaimDto.getRegistNo();
        String isCombine = "certi";//判断合并案件
		String combineNo = httpServletRequest.getParameter("combineNo");
		flowStr = "&swfLogFlowID="+swfLogFlowID+"&swfLogLogNo="+swfLogLogNo+"&status=0&riskCode="+riskCode;
		flowStr = flowStr + "&editType=ADD&nodeType=certi&&policyNo="+policyNo+"&combineNo="+combineNo;
		dealHref="/claim/certifyCombineBeforeEdit.do?RegistNo="+registNo+flowStr;
		httpServletRequest.setAttribute("isCombine", isCombine);
		httpServletRequest.setAttribute("dealHref", dealHref);
       
       
       //防止重复提交
       String strLastAccessedTime = ""
			+ httpServletRequest.getSession().getLastAccessedTime()
			/ 1000;
       String oldLastAccessedTime = (String) httpServletRequest
			.getSession().getAttribute("oldCompensateLastAccessedTime");
       if (oldLastAccessedTime !=null && !oldLastAccessedTime.trim().equals("")) {
    	   throw new UserException(1, 3, "工作流", "请不要重复提交");
       }
       httpServletRequest.getSession().setAttribute(
				"oldCompensateLastAccessedTime", strLastAccessedTime);
       WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
       UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
       String condition = "flowId ='"+swfLogFlowID+"' and nodeType='cance' and nodeStatus in ('0','2')";
       Collection cancelNodeList = uiWorkFlowAction.findNodesByConditions(condition);
       if(cancelNodeList!=null&&cancelNodeList.size()>0){
    	   throw new UserException(1,3,"1234","案件已经申请注销拒赔！");
       }
       condition = "flowId ='"+swfLogFlowID+"' and nodeType='certi' and logno= "+ swfLogLogNo+"  and nodeStatus in ('4')";
       Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
       if(certifyNodeList!=null&&certifyNodeList.size()>0){
    	   throw new UserException(1,3,"1234","案件单证环节已经处理！");
       }
       
       SwfLogDto swfLogDtoDealNode = new SwfLogDto();
       if (swfLogFlowID!=null && swfLogLogNo!=null && !swfLogLogNo.equals("null"))
        { 
    	  swfLogDtoDealNode.setFlowID(swfLogFlowID); 
          swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));  
         }else
        {
          swfLogDtoDealNode.setNodeType("certi");
          swfLogDtoDealNode.setBusinessNo(certifyDto.getPrpLclaimStatusDto().getBusinessNo());
       }
       
       //意键险要求不需要立案就可以进行单证收集，此时保存业务号为报案号！       
       registNo = certifyDto.getPrpLcertifyCollectDto().getBusinessNo();
       String buttonSaveType = httpServletRequest.getParameter("buttonSaveType"); //提交类型
           swfLogDtoDealNode.setNodeStatus(certifyDto.getPrpLclaimStatusDto().getStatus());
           swfLogDtoDealNode.setNextBusinessNo(claimNo);
           swfLogDtoDealNode.setKeyIn(claimNo);
           swfLogDtoDealNode.setKeyOut(certifyDto.getPrpLclaimStatusDto().getBusinessNo());

       
       //考虑是车险的时候，由于强三原因，有可能会产生2个理算，所以需要考虑如何同时生成2个理算任务，并且不会由于多个提交到理算的问题，引起
       //同类合并的问题。。。
       //需要判断成车险的。。。不能用截串的方式。。。
       String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
	
       if (("I".equals(strRiskType) || "H".equals(strRiskType)|| "D".equals(strRiskType))&&"4".equals(buttonSaveType)){
       	//由于可能会出现立案被注销的情况，所以目前只提交出立案没有注销的情况下，显示理算任务。
       	String strSql ="registNo='"+registNo+"' and canceldate is null ";
       	UIClaimAction uiClaimAction = new UIClaimAction();
       	ArrayList claimList =(ArrayList)uiClaimAction.findByConditions(strSql ) ;
       	//swfLogFlowID
       	BLSwfLogFacade  facadeSwf = new BLSwfLogFacade();
       	String conditions = "FlowID = '"+swfLogFlowID+"' and NodeType= 'compe'  and nodestatus='0' ";
       	Collection tion = facadeSwf.findByConditions(conditions);
       	  if (claimList!=null&&claimList.size() >0 && (tion.size()==0)){
       		 //形成理算任务的列表，由于要分riskcode,
       		Collection nextNodeList = new ArrayList();           
    		
          	for (int i=0;i<claimList.size();i++ ){
          		SwfLogDto swfLogNextNode = new SwfLogDto();
          		swfLogNextNode.setNodeNo(0);  
				swfLogNextNode.setNodeType("compe");              
				swfLogNextNode.setRiskCode(((PrpLclaimDto)claimList.get(i)).getRiskCode()  );
				swfLogNextNode.setPolicyNo (((PrpLclaimDto)claimList.get(i)).getPolicyNo()  );
				swfLogNextNode.setKeyIn(((PrpLclaimDto)claimList.get(i)).getClaimNo()  );
				swfLogNextNode.setBusinessNo(((PrpLclaimDto)claimList.get(i)).getClaimNo()  );
				nextNodeList.add(swfLogNextNode);   
            }
          	
          	swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
			swfLogDtoDealNode.setSwfLogList(nextNodeList);
       	  }
        }
      
       //add by lixiang end at 2006-6-8
       //*****************modify by qingyongli end  2005-8-1
       WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto((UserDto)httpServletRequest.getSession().getAttribute("user"),swfLogDtoDealNode);

       //add by lixiang start at 2006-08-24
    	  //如果是提交的单正-》理算这个环节，则需要判断是不是调度已经做完了，没做完则也把调度置成完成的状态
       //非水险Q在提交单证时，回写调度处理标志
       if (("Q".equals(strRiskType) || "I".equals(strRiskType) || "H".equals(strRiskType)|| "D".equals(strRiskType))&&"4".equals(buttonSaveType)){ 
    	    Collection noSubmitNodesList=uiWorkFlowAction.findNodesByConditions(" flowID='"+swfLogDtoDealNode.getFlowID() +"' and nodeType='sched' and nodestatus<'4'");
    	    Collection noSubmitNodesListCheck=uiWorkFlowAction.findNodesByConditions(" flowID='"+swfLogDtoDealNode.getFlowID() +"' and nodeType='check' and nodestatus<'4'");
    	    SwfLogDto wfLogDtoTemp=null;
    	    if (noSubmitNodesList!=null&&noSubmitNodesListCheck.size() >0) {
    	   //完成调度任务
    	    	throw new UserException(1,3,"0000","工作流"+swfLogDtoDealNode.getFlowID()+"查勘环节没有提交，不能进行单证提交！");
    	    }
    	    
    	    if (noSubmitNodesList!=null&&noSubmitNodesList.size() >0) {
       	   //完成调度任务
       	     wfLogDtoTemp = (SwfLogDto)noSubmitNodesList.iterator().next() ;
       	     wfLogDtoTemp.setNodeStatus( "4");
			 wfLogDtoTemp.setSubmitTime( new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
			 workFlowDto.setUpdateSwfLog2Dto( wfLogDtoTemp);
       	   }
       }       
       //add by lixiang end at 2006-08-24
       //保存单证信息
       UICertifyAction uiCertifyAction = new UICertifyAction();

      if (workFlowViewHelper.checkDealDto(workFlowDto))
      {
        uiCertifyAction.save(certifyDto,workFlowDto);
        user.setUserMessage(certifyDto.getPrpLclaimStatusDto().getBusinessNo());
      }else
      {
        uiCertifyAction.save(certifyDto);
        //user.setUserMessage(certifyDto.getPrpLclaimStatusDto().getBusinessNo()+";注意:没有发现与工作流流程相关任何数据！！");
        user.setUserMessage(certifyDto.getPrpLclaimStatusDto().getBusinessNo());
      }
      ActionMessages messages = new ActionMessages();
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.certify.save"));
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLregist.registNo"));
      saveMessages( httpServletRequest, messages );
      httpServletRequest.getSession().setAttribute("user",user);
      forward="success";

    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.certifyBeforeEdit.editCertify");
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
      ActionError error = new ActionError("title.certifyBeforeEdit.editCertify");
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
      ActionError error = new ActionError("title.certifyBeforeEdit.editCertify");
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
