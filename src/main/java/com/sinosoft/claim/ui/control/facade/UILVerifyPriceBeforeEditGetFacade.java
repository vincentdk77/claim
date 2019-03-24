package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIPrpLclaimGradeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAVerifyLossViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * 分发HTTP GET 车险理赔核价前查询保单请求
 * <p>Title: 车险理赔核价前查询保单信息</p>
 * <p>Description: 车险理赔核价前查询保单信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UILVerifyPriceBeforeEditGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {


    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String editType     = httpServletRequest.getParameter("editType");
    String claimNo      = "" ;             //赔案号
    String registNo     = "" ;             //报案号
    HttpSession session = httpServletRequest.getSession();
    UserDto   user      = (UserDto)session.getAttribute("user");    //用户信息
    String lossType = httpServletRequest.getParameter("lossTypeFlag"); //定损类型
    String riskCode = httpServletRequest.getParameter("riskCode");                           //险种
    String insureCarFlag = httpServletRequest.getParameter("insureCarFlag");      //主车标志
    String lossItemCode = httpServletRequest.getParameter("lossItemCode");        //险种
    String lossItemName = httpServletRequest.getParameter("lossItemName");        //车牌号码
    String nodeType     = httpServletRequest.getParameter("nodeType");

    String tempStatus = httpServletRequest.getParameter("status"); 
    String swfLogFlowID =(String)httpServletRequest.getParameter("swfLogFlowID");
    String swfLogLogNo =(String)httpServletRequest.getParameter("swfLogLogNo");

    String forward  = "";                                                             //向前
    int intLossItemCode = Integer.parseInt(DataUtils.nullToZero(lossItemCode));        //险种
    String editForward  = editType;                 //最后做跳转的标志
    try
    {
        System.out.println("=========[ UILVerifyPriceBeforeEditGetFacade ]  [  查询核价金额权限  ] ====================");
       
	    
        double valueUpper = 0.00;
        if( nodeType.equals("verip")) {   //如果是总公司，只有异地委托的核价，进入核价，即查询异地委托的单子
         	String comLevel = user.getComLevel();
         }
        
        String  userCode="";
   	    String  configPara ="SINGLE_CUSTOM_COMP_PRICE" ;
   	    String  taskCode="lphj";
        
   	    if ( nodeType.equals("verip") ){
        	userCode=user.getUserCode();  //核价时，检查本人权限
        }
        if(nodeType.equals("verpo")) {   //向外询价节点时，检查提交询价的核价人权限
        	  SwfLogDto swflogDto  =new SwfLogDto (); 
        	  UIWorkFlowAction  uiWorkFlowAction  =new UIWorkFlowAction();  
        	  swflogDto = uiWorkFlowAction.findNodeByPrimaryKey(swfLogFlowID,Integer.parseInt(swfLogLogNo));
        	  userCode = swflogDto.getBeforeHandlerCode();
        }
        	
         	 
         	  UIPrpLclaimGradeAction  uiPrpLclaimGradeAction =new UIPrpLclaimGradeAction();
         	  PrpLclaimGradeDto  prpLclaimGradeDto =  uiPrpLclaimGradeAction.findByPrimaryKey(userCode,taskCode,configPara) ;
             if (prpLclaimGradeDto != null ){
             	valueUpper = prpLclaimGradeDto.getValueUpper();
             }else {
         	    valueUpper =0.00;
             }
        // }
        
         httpServletRequest.setAttribute("valueUpper", String.valueOf(valueUpper) );
         System.out.println("===============  [  查询核价金额权限 结束   ] ==[ valueUpper ]=====" +valueUpper);  
     	
    	
    	//尚未加入type异常处理{}、其它必须参数异常处理{}
      if (editType.equals("ADD")) {

        //查询立案信息,整理输入，用于初始界面显示
        registNo = httpServletRequest.getParameter("RegistNo"); //报案号
        DAAVerifyLossViewHelper dAAVerifyLossViewHelper = new DAAVerifyLossViewHelper();
     
        //==================================================
        //进行占号分析，只有当有工作流号码和LogNo的时候才能使用。
        //如果没有flowID和logno则不进行判断。
     String flowID =httpServletRequest.getParameter("swfLogFlowID") ;
        String logNo=httpServletRequest.getParameter("swfLogLogNo");
        String msg="";
        if (flowID!=null && logNo!=null)
        {  UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        	 SwfLogDto swfLogDto = new SwfLogDto();
        	 swfLogDto = uiWorkFlowAction.holdNode(flowID,Integer.parseInt(logNo) ,user.getUserCode() ,user.getUserName() );
        	 if (swfLogDto.getHoldNode()==false)
                   {
                     msg="案件'"+registNo+"'已经被代码:'"+swfLogDto.getHandlerCode() +"',名称:'"+swfLogDto.getHandlerName() +"'的用户所占用,请选择其它案件进行处理!";
                     throw new UserException(1,3,"工作流",msg);
                  }
      }
    //==================================================

        dAAVerifyLossViewHelper.certainLossDtoToView(httpServletRequest,registNo,editType);
        forward = editType+riskCode;
      }
      if(editType.equals("EDIT")||editType.equals("SHOW"))
      {
        //查询核价信息,整理输入，用于初始界面显示
        registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo"); //报案号
        
        DAAVerifyLossViewHelper dAAVerifyLossViewHelper = new DAAVerifyLossViewHelper();
        dAAVerifyLossViewHelper.verifyLossDtoView(httpServletRequest,registNo,editType,tempStatus);
        forward = editType+riskCode;
      }
    
      forward=BusinessRuleUtil.getForward(httpServletRequest,riskCode,"verip",editType,intLossItemCode);
    
      saveToken(httpServletRequest);
    }
    catch(SecurityException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.verifyPriceBeforeEdit.titleName");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.verifyPriceBeforeEdit.titleName");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally
    {

    }

   System.out.println("-----------forward---------"+forward);
    return actionMapping.findForward(forward);
  }
}
