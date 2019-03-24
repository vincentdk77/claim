package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.ui.control.action.UIReinsTrialAction;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * UIReinsTrialFacade
 * <p>Title:分摊试算UI层Facade类 </p>
 * <p>Description: 分摊试算处理并返回试算结果</p>
 * <p>Copyright: Copyright (c) 2005/8</p>
 * <p>Company: sinosoft</p>
 * @author qinyongli
 * @version 1.0
 */
public class UIReinsTrialFacade extends Action{
  public ActionForward execute(ActionMapping actionMapping,
                                 ActionForm actionForm,
                                 HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse
                             ) throws Exception{
      String forward = "";
      ArrayList reinsTrialDtoList = null;
      int    year      = DateTime.current() .getYear()  ;
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      String userCode=user.getUserCode() ;
      String comCode   = user.getComCode() ;
      String claimNo = httpServletRequest.getParameter("claimNo");
      String compensateNo = httpServletRequest.getParameter("compensateNo");
      String riskCode  =httpServletRequest.getParameter("riskCode");
      String reinsTrial = "";
      BLPrpLdangerUnitFacade blPrpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
      List  reinsTrialListEX = new ArrayList();
      
      try{
           UIReinsTrialAction uiReinsTrialAction = new UIReinsTrialAction();
           //生成分摊试算结果    分为两种情况 立案和理算两个环节
           if(compensateNo==null||compensateNo.equals("")){//立案
               reinsTrial = "估损";
               uiReinsTrialAction.simulateRepayByDangerNo(claimNo,claimNo);
               System.out.println("------------------立案环节生成分摊信息成功，开始返回理算结果,claimNo："+claimNo);

               //取危险单位的数量
               int dangerSize = blPrpLdangerUnitFacade.getCount(" certino='"+claimNo+"'");
               for(int i=1;i<=dangerSize;i++)
               {
            	   reinsTrialDtoList =(ArrayList) uiReinsTrialAction.getDangerUnit(claimNo,i);
            	   reinsTrialListEX.add(reinsTrialDtoList);
               }
               
               
           }else if(compensateNo!=null&&!compensateNo.equals("")){//理算
               reinsTrial = "实赔";
           	   System.out.println("------------------理算环节生成分摊信息成功，compensateNo："+compensateNo);
               System.out.println("------------------理算环节生成分摊信息成功，claimNo："+claimNo);
           	   uiReinsTrialAction.simulateRepayByDangerNo(compensateNo,claimNo);
           	   
           	   //取危险单位的数量
               int dangerSize = blPrpLdangerUnitFacade.getCount(" certino='"+claimNo+"'");
               for(int i=1;i<=dangerSize;i++)
               {
            	   reinsTrialDtoList =(ArrayList) uiReinsTrialAction.getDangerUnit(compensateNo,i);
            	   reinsTrialListEX.add(reinsTrialDtoList);
               }
           }
           //返回分摊试算结果    
           if(reinsTrialDtoList.size()>0){
               httpServletRequest.setAttribute("reinsTrial",reinsTrial);             
               httpServletRequest.setAttribute("reinsTrialListEX",reinsTrialListEX);
           }else{
               httpServletRequest.setAttribute("reinsTrial","");
           }  
           forward = "success";
      }catch (Exception e) {
          httpServletRequest.setAttribute("Content","分摊试算失败!");
          e.printStackTrace();
          forward="false";
          
      }
       return actionMapping.findForward(forward);
    }

}
