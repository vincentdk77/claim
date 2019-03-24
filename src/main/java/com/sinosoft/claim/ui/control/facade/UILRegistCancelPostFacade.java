package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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

import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.facade.BLCIClaimSYXPlatFormInterfaceFacade;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.claim.bl.facade.BLPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrplregisthisFacade;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrplregisthisDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormCheckAction;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimDemandFacade;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimPlatFormInterfaceFacade;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.claimciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimPropPlatFormInterfaceFacade;
import com.sinosoft.platform.bl.facade.BLPrpDriskConfigFacade;
import com.sinosoft.platform.dto.domain.PrpDriskConfigDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;



/**
 * 分发HTTP Post 报案注销界面信息
 * <p>Title: 车险报案注销界面信息</p>
 * <p>Description: 车险报案注销界面信息保存</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author sinosoft
 * @version 1.0
 */

public class UILRegistCancelPostFacade
extends Action {
    public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
      Exception {

     

    String forward = ""; //向前流转

    try {
       
       //取得当前用户信息
       UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
       //得到是否为全部注销的标记
       String allCancleFlag =   StringUtils.rightTrim(httpServletRequest.getParameter("txtAllCancle"));
      //检查界面结果，如果选择的保单的报案已经立过案的话，则不能进行注销。
       //用viewHelper整理界面输入
       DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
       RegistDto registDto = dAARegistViewHelper.cancelViewToDto(httpServletRequest);
       if(registDto.getPrpLregistDto().getClassCode().equals("05")){
       BLPrplregisthisFacade blPrplregisthisFacade = new BLPrplregisthisFacade();
       int count = blPrplregisthisFacade.getCount("registNo='"+registDto.getPrpLregistDto().getRegistNo()+"'");
       String logoutType = httpServletRequest.getParameter("CancelReason");
       UICodeAction uiCodeAction = new UICodeAction();
       logoutType=uiCodeAction.translateCodeCode("CancelReason", logoutType, true);
       String logoutContext = httpServletRequest.getParameter("CancelReasonName");
       String str = logoutType;
       str = str+"，"+logoutContext;
       PrplregisthisDto prplregisthisDto = dAARegistViewHelper.getPrplregisthisDto(user, "01", "0", str, "01", registDto.getPrpLregistDto().getRegistNo(), count+1);
       registDto.setPrplregisthisDto(prplregisthisDto);
       }
       UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
       UIRegistAction uiRegistAction = new UIRegistAction();
       UIClaimAction uiClaimAction = new UIClaimAction();
       
       WorkFlowDto workFlowDto = new WorkFlowDto();
       //保存立案拒赔注销信息
       WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
       //以下为工作流使用中的
       //得到流程编号
       String swfLogFlowID = uiWorkFlowAction.findFlowIDByRegistNo(registDto.getPrpLregistDto().getRegistNo());
       String swfLogLogNo = "1"; //工作流logno黙认为1
       SwfLogDto swfLogDtoDealNode = new SwfLogDto();
       
       String uploadUpolicyNo = "";
       if (allCancleFlag.equals("1")){
        
         //需要检查是否有已经立案的，但是是正常的立案的情况。。。
       	
       	String strSql = "registNo='"+registDto.getPrpLregistDto().getRegistNo()+"' and canceldate is null ";
       	
       	Collection claimList =uiClaimAction.findByConditions(strSql);
       	
       	if (claimList!=null&&claimList.size() >0){
       	  String msg = "此报案目前有"+claimList.size()+"保单已经立案，请做完此保单的立案注销后，再进行报案的全部注销！";
          throw new UserException(1,3,"报案注销",msg);
       	}
          if (swfLogFlowID!=null && swfLogLogNo!=null&&!swfLogFlowID.equals("null")&& !swfLogLogNo.equals("null"))
          {
             swfLogDtoDealNode.setFlowID(swfLogFlowID);
             swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
          }
          swfLogDtoDealNode.setNodeStatus("4");
          swfLogDtoDealNode.setEndFlag("1");
          workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
          }
       
       
       String strRegistNo = httpServletRequest.getParameter("prpLclaimRegistNo");
       //BLEarAction blEarAction = new BLEarAction();
       //blEarAction.registUpdate(null, strRegistNo);
       
       
        //取交强险保单号
      	String strWhere = " registNo = '" + registDto.getPrpLregistDto().getRegistNo() + "' and policyType='3' ";
      	Collection collection = new UIPrpLregistRPolicyAction().findByConditions(strWhere);
      	for(Iterator iter = collection.iterator();iter.hasNext();){
      		PrpLRegistRPolicyDto  prpLRegistRPolicyDto = (PrpLRegistRPolicyDto)iter.next();
      		uploadUpolicyNo = prpLRegistRPolicyDto.getPolicyNo();
      	}
       //如果只是简单注销一部分，的操作
       if (allCancleFlag.equals("3")){
        	//根据保单号进行注销
       	String[] policyNoList = httpServletRequest
		.getParameterValues("prpLclaimPolicyNo"); //保单列表
       	
       	String[] selectToCancleList = httpServletRequest
		.getParameterValues("selectToCancle");    //选择进行注销的开关

       	registDto.getPrpLregistDto().setCancelDate(null);
       	registDto.getPrpLregistDto().setDealerCode("");
       	
       	for (int index = 0; index < policyNoList.length; index++) {
			if (selectToCancleList[index].equals( "1")){
			 //暂时先注销一个保单吧。。以后再说。。。目前支持一个一个的注销。。暂时！！
				//查询这个保单的
			    String policyNo= policyNoList[index];
			    
			    UIPrpLregistRPolicyAction  uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction(); 
		        PrpLRegistRPolicyDto  prpLRegistRPolicyDto = uiPrpLregistRPolicyAction.findByPrimaryKey(registDto.getPrpLregistDto().getRegistNo(), policyNo);
		        if ( prpLRegistRPolicyDto!=null ){
		        	prpLRegistRPolicyDto.setValidStatus("0");
		        	if("0507,0577,0587".indexOf(prpLRegistRPolicyDto.getRiskCode()) >= 0){
			        	uploadUpolicyNo = policyNo;
			        }
		         }
		        prpLRegistRPolicyDto.setCancelReason(registDto.getPrpLregistDto().getCancelReason());
		        prpLRegistRPolicyDto.setCancelReasonName(registDto.getPrpLregistDto().getCancelReasonName());
		        registDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
		        //工作流注销
		        
		        if (swfLogFlowID!=null && swfLogLogNo!=null&&!swfLogFlowID.equals("null")&& !swfLogLogNo.equals("null"))
		          {
		        	 String strSql="flowid='"+swfLogFlowID+"' and nodeType='claim' and policyNo='"+policyNo+"'";
		        	 ArrayList claimNodeList=(ArrayList)uiWorkFlowAction.findNodesByConditions(strSql);
		             if (claimNodeList!=null&&claimNodeList.size() >0){
		            	 SwfLogDto swfLogDto = (SwfLogDto)claimNodeList.get( 0);
		             	workFlowDto.setUpdate( true);
		             	swfLogDto.setHandlerCode(user.getUserCode());
		             	swfLogDto.setHandlerName(user.getUserName());
		             	swfLogDto.setHandleDept(user.getComCode());
		             	swfLogDto.setHandleTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
		             	workFlowDto.setUpdateSwfLogDto(swfLogDto);
		             }

		          }
		        
				break;
			}
       	
         }
       }
        //保存报案注销信息并查找工作流程

        if (workFlowViewHelper.checkDealDto(workFlowDto))
        {
           //设置本节点为注销状态 lixiang bakkkk!!
          if (workFlowDto.getUpdateSwfLogDto() !=null){
           	workFlowDto.getUpdateSwfLogDto().setNodeStatus( "6"); //撤消的流程
          }
           uiRegistAction.saveRegistCancel(registDto,workFlowDto);
         }else
         {
      	   uiRegistAction.saveRegistCancel(registDto);
          }
        
        try{
	    	UIClaimSynStatusFacade uiClaimSynStatusFacade = new UIClaimSynStatusFacade();
  		    uiClaimSynStatusFacade.synRegistStatus(registDto.getPrpLregistDto().getRegistNo(), "4");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
      
      //车险平台上传
        String strHerf = "(<a href=\"javascript:showErrorInfo('info')\">详细信息</a>)";
		try{
			
			System.out.println("============上海平台意健险立案注销信息上传平台begin============");
			//上海平台意健险立案信息上传
			boolean isYJXFlag = false;
			boolean isSuccess = false;
			String groupFlag = "";
			//String strRegistNo = registDto.getPrpLregistDto().getRegistNo();
			String strPolicyNo = registDto.getPrpLregistDto().getPolicyNo();//保单号
			//根据保单号来查询保单信息,判断该保单是否为团单
			BLPrpCmain blPrpCmain = new BLPrpCmain();
			blPrpCmain.getData(strPolicyNo);	
			String secodeComCode = new BLPrpDcompany().getDaaPlatformComCode(registDto.getPrpLregistDto().getComCode());
			DBManager dbManager = new DBManager();
			if("26,27,28".indexOf(registDto.getPrpLregistDto().getClassCode()) > -1){
				isYJXFlag = true;
			}
			if(isYJXFlag && "310000".equals(secodeComCode)){
				System.out.println("------------------上海平台意健险立案注销接口调用,registno= " + strRegistNo +" --------------------------");				
				try {					
					dbManager.open(AppConfig.get("sysconst.DBJNDI"));
					//根据prpcmain.groupNo是否为空判断是否为团单
					if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
						groupFlag = "0";//个险
						isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C12", "", strRegistNo, strPolicyNo, groupFlag, secodeComCode);
					}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
						groupFlag = "1";//团险
						isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C14", "", strRegistNo, strPolicyNo, groupFlag, secodeComCode);
					}
					if(isSuccess){
					    user.setUserMessage(user.getUserMessage() + "<br>意健险报案注销信息上传平台成功!");
					}else{
						user.setUserMessage(user.getUserMessage() + "<br>意健险报案注销信息上传平台失败!");
					}
				} catch (Exception e) {
					e.printStackTrace();
					user.setUserMessage(user.getUserMessage() + "<br>"+e.getMessage());
				} finally{//关闭数据源
					dbManager.close();
				}				
			}	
			System.out.println("============上海平台意健险立案注销信息上传平台end============");
			
			System.out.println("马上进行交强险平台交互");
			boolean isUpload = false;
			isUpload = BLCIClaimPlatFormCheckAction.checkUploadForRegistCancel(uploadUpolicyNo, registDto.getPrpLregistDto().getRegistNo());
			if(isUpload){
				BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
						RequestType.CASE_CANCEL,
						registDto.getPrpLregistDto().getRegistNo(),"", true,"0");
				
				user.setUserMessage(user.getUserMessage() + "<br>上传车险平台成功!");
			}
			
			System.out.println("马上进行商业险平台交互");
			//定2011
			PrpCmainDto prpCmainDtopm=new BLPolicyFacade().findPrpCmainDtoByPrimaryKey(registDto.getPrpLregistDto().getPolicyNo());
			String comcode=prpCmainDtopm.getComCode();
			String comcodesub="";
			String riskcode=registDto.getPrpLregistDto().getRiskCode();
			String registNo=registDto.getPrpLregistDto().getRegistNo();
			boolean boo=false;
			BLPrpLRegistRPolicyFacade blPrpLregistRPolicyFacade2=new BLPrpLRegistRPolicyFacade();
			String condtion=" registno='"+registNo+"' and riskcode='0506' and validstatus = '0' ";
			Collection coll=blPrpLregistRPolicyFacade2.findByConditions(condtion);
			if(coll!=null && coll.size()>0){
				PrpLRegistRPolicyDto prpLRegistRPolicyDto=(PrpLRegistRPolicyDto)coll.iterator().next();
				String policyno=prpLRegistRPolicyDto.getPolicyNo();
				com.sinosoft.prpall.dto.domain.PrpCmainDto prpCmainDtopm1=new com.sinosoft.prpall.bl.facade.BLPrpCmainFacade().findByPrimaryKey(policyno);
				if(prpCmainDtopm1!=null ){
					comcode=prpCmainDtopm1.getComCode();
					boo=true;
				}
			}
			if(boo){
				boo = false;
				BLCIClaimDemandFacade blCIClaimDemandFacade = new BLCIClaimDemandFacade();
				strWhere = " registno='" + registNo + "' and riskcode = '0506' ";
				collection = blCIClaimDemandFacade.findByConditions(strWhere);
				if(collection.size() > 0){
					CIClaimDemandDto ciClaimDemandDto = (CIClaimDemandDto)collection.iterator().next();
					if("1".equals(ciClaimDemandDto.getRegistUploadFlag()) && !"1".equals(ciClaimDemandDto.getCancelUploadFlag())){
						boo = true;
					} 
				}
			}
			if(boo && comcode!=null && !"".equals(comcode)){
				comcodesub=comcode.substring(0,2);
				BLCIPlatformConfigFacade bLCIPlatformConfigFacade=new BLCIPlatformConfigFacade();
				CIPlatformConfigDto cIPlatformConfigDto=bLCIPlatformConfigFacade.findByPrimaryKey("CI_TRANSPORT_MODE", comcodesub, "0506");
				if(cIPlatformConfigDto!=null && "1".equals(cIPlatformConfigDto.getValidStatus())){
					if("0".equals(cIPlatformConfigDto.getConfigValue().trim())) {// 商业险2011	0及时交互，1非及时交互
						BLCIClaimSYXPlatFormInterfaceFacade
						.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CANCEL_CASE,
								registDto.getPrpLregistDto().getRegistNo(),
								true,cIPlatformConfigDto,"0","");
						user.setUserMessage(user.getUserMessage()
								+ "<br>报案注销上传商业险平台成功!");
					}else{
						BLCIClaimSYXPlatFormInterfaceFacade
						.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CANCEL_CASE,
								registDto.getPrpLregistDto().getRegistNo(),
								false,cIPlatformConfigDto,"0","");
						user.setUserMessage(user.getUserMessage()
								+ "<br>报案注销上传商业险平台成功!");
					}
				}
			}
					
			
			
		
		}catch(ClaimCiPlatFormException e){
			e.printStackTrace();
			httpServletRequest.setAttribute("ciClaimException", e);
			user.setUserMessage(user.getUserMessage() + "<br>上传车险平台失败：<br>" + e.getMessage() + strHerf);
		}catch(Exception e ){
			e.printStackTrace();
			httpServletRequest.setAttribute("ciClaimException", e);
			user.setUserMessage(user.getUserMessage() + "<br>上传车险平台失败:<br>" + e.getMessage() + strHerf);
		}
       ActionMessages messages = new ActionMessages();
       ActionMessage message;
       message = new ActionMessage("报案注销保存成功");
       user.setUserMessage("报案注销保存成功" + user.getUserMessage());
       messages.add( ActionMessages.GLOBAL_MESSAGE, message );
       saveMessages( httpServletRequest, messages );
      
       forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("报案注销");
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
      ActionError error = new ActionError("报案注销");
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
      ActionError error = new ActionError("报案注销");
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
