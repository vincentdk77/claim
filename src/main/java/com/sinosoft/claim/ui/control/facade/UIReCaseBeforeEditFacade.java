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

        //ҵ�����ͣ�ADD-���� EDIT-�޸� SHOW-��ʾ
        String claimNo = httpServletRequest.getParameter("reCaseClaimNo"); //�ⰸ��
        String editType = httpServletRequest.getParameter("editType");
        String forward = ""; //��ǰ
        try {
           
               ReCaseViewHelper  reCaseViewHelper = new ReCaseViewHelper();
               //�ؿ��ⰸֻ������һ��,��Ӧ�����������ɹ��ⰸ�ŵİ�������Ҫ�ؿ��ⰸ
               DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
               boolean isGenrateCaseNo = dAAEndcaseViewHelper.isGenrateCaseNo(claimNo);
               if(isGenrateCaseNo==false){
               	throw new Exception("������δ�᰸������Ҫ�ؿ��ⰸ��");	
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
               
               
               // ��session��ȡ��ƶ/�󻧱�־
       		   String strHPflag = (String)httpServletRequest.getSession().getAttribute("flag");
       		   if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null") && policytypetmp != null && !policytypetmp.equals("")) {
       		       if(strHPflag.equals("Large") && "H24, I28, E2, Q2".indexOf(policytypetmp) < 0) {
       		    	   throw new Exception("��ģ��Ӫ����ϵͳ�޷���ѯ�Ǿ�Ӫ����ҵ��ı�����");	
       			   }
       			   if(strHPflag.equals("Retaol") && "H23, I27, E1, Q1".indexOf(policytypetmp) < 0) {
       				   throw new Exception("��ƶϵͳ�޷���ѯ��������ҵ��ı�����");	
       			   }	
       		   }
       		
               
               String conditions = " businessNo = '" + claimNo + "' and dataFlag  is not null ";
               BLSwfLogStoreFacade blSwfLogStoreFacade = new BLSwfLogStoreFacade();
               ArrayList swflogStoreDtoList = (ArrayList)blSwfLogStoreFacade.findByConditions(conditions);
               BLSwfLogFacade blSwflogFacade = new BLSwfLogFacade();
               ArrayList swflogDtoList = (ArrayList)blSwflogFacade.findByConditions(conditions);
               if(swflogStoreDtoList.size() > 0 || swflogDtoList.size() > 0){
            	   throw new Exception("�ð�������������ϵͳ�İ���,����������ϵͳ�����ؿ��ⰸ!");
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
            //������Ϣ����
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
