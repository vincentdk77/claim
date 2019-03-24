package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.ui.control.viewHelper.DAAEndcaseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.ReCaseViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.claimzy.facade.*;
import com.sinosoft.prpall.blsvr.cb.*;


public class UIReCaseBeforeEditFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping,
            ActionForm actionForm, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws Exception {

        //业务类型：ADD-新增 EDIT-修改 SHOW-显示
        String claimNo = httpServletRequest.getParameter("reCaseClaimNo"); //赔案号
        String editType = httpServletRequest.getParameter("editType");
        String forward = ""; //向前
        try {
           
               ReCaseViewHelper  reCaseViewHelper = new ReCaseViewHelper();
               //重开赔案只允许做一次,且应该是曾经生成过赔案号的案件才需要重开赔案
               DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
               boolean isGenrateCaseNo = dAAEndcaseViewHelper.isGenrateCaseNo(claimNo);
               if(isGenrateCaseNo==false){
               	throw new Exception("案件还未结案，不需要重开赔案！");	
               } 
               
               BLPrpLclaim blPrpLclaim = new BLPrpLclaim();
               blPrpLclaim.query("claimno='" + claimNo + "'");
               String policynotmp = "";
               if(blPrpLclaim != null && blPrpLclaim.getSize() == 1)
            	   policynotmp = blPrpLclaim.getArr(0).getPolicyNo();
               BLPrpCmain blPrpCmain = new BLPrpCmain();
               blPrpCmain.query("policyno='" + policynotmp +"'");
               String policytypetmp = "";
               if(blPrpCmain != null && blPrpCmain.getSize() == 1)
            	   policytypetmp = blPrpCmain.getArr(0).getPolicyType();
               
               
               // 从session里取扶贫/大户标志
       		   String strHPflag = (String)httpServletRequest.getSession().getAttribute("flag");
       		   if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null") && policytypetmp != null && !policytypetmp.equals("")) {
       		       if(strHPflag.equals("Large") && "H24, I28, E2, Q2".indexOf(policytypetmp) < 0) {
       		    	   throw new Exception("规模经营主体系统无法查询非经营主体业务的保单！");	
       			   }
       			   if(strHPflag.equals("Retaol") && "H23, I27, E1, Q1".indexOf(policytypetmp) < 0) {
       				   throw new Exception("扶贫系统无法查询非特困户业务的保单！");	
       			   }	
       		   }
       		
               
               String conditions = " businessNo = '" + claimNo + "' and dataFlag  is not null ";
               BLSwfLogStoreFacade blSwfLogStoreFacade = new BLSwfLogStoreFacade();
               ArrayList swflogStoreDtoList = (ArrayList)blSwfLogStoreFacade.findByConditions(conditions);
               BLSwfLogFacade blSwflogFacade = new BLSwfLogFacade();
               ArrayList swflogDtoList = (ArrayList)blSwflogFacade.findByConditions(conditions);
               if(swflogStoreDtoList.size() > 0 || swflogDtoList.size() > 0){
            	   throw new Exception("该案件属于新理赔系统的案件,请在新理赔系统中做重开赔案!");
               }
               reCaseViewHelper.claimNoDtoToView(httpServletRequest,claimNo);
               reCaseViewHelper.recasemaxDtoToView(httpServletRequest,claimNo);//add by huangyunzhong 20051114 
               httpServletRequest.setAttribute("editType", editType);
               forward = "success"; 
            saveToken(httpServletRequest);
        } catch (UserException usee) {
            usee.printStackTrace();
            ActionMessages errors = new ActionMessages();
            ActionMessage error = new ActionMessage(
                    "title.endcaseBeforeEdit.titleName");
            errors.add(ActionMessages.GLOBAL_MESSAGE, error);
            httpServletRequest.setAttribute("errorMessage", usee.getMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";
        } catch (Exception e) {
            e.printStackTrace();
            //错误信息处理
            ActionMessages errors = new ActionMessages();
            ActionMessage error = new ActionMessage(
                    "title.endcaseBeforeEdit.titleName");
            errors.add(ActionMessages.GLOBAL_MESSAGE, error);
            httpServletRequest.setAttribute("errorMessage", e.getMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";

        } finally {

        }

        return actionMapping.findForward(forward);
    }
}
