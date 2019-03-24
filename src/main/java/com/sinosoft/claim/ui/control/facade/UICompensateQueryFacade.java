package com.sinosoft.claim.ui.control.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.viewHelper.DAACompensateViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * �ַ�HTTP GET ʵ���ѯ
 * <p>Title: ��������ʵ���ѯ��Ϣ</p>
 * <p>Description: ��������ʵ��ʵ���ѯ��Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UICompensateQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String editType   = httpServletRequest.getParameter("editType");//����
    String policyNo   = httpServletRequest.getParameter("PolicyNo");    //������
    String claimNo   = httpServletRequest.getParameter("ClaimNo");//�ⰸ�� 
    String registNo   = httpServletRequest.getParameter("RegistNo");//�ⰸ��    
    String compensateNo   = httpServletRequest.getParameter("CompensateNo") ; //���������
    //Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ��,�����־��ѯ����
    String licenseNo  = httpServletRequest.getParameter("LicenseNo");//���ƺ�
    String status     = httpServletRequest.getParameter("caseFlag");//����״̬
    String operateDate  = httpServletRequest.getParameter("OperateDate");//����ʱ��
    String operateDateEnd = httpServletRequest.getParameter("OperateDateEnd");//����ʱ���ֹ
    String underWriteFlag = httpServletRequest.getParameter("compensateFlag");//�����־
    String strDeleteFlag = httpServletRequest.getParameter("deleteFlag");//ɾ���������־
    String arrCheckFlag[]  = httpServletRequest.getParameterValues("CheckFlag");//ѡ�е�Ҫɾ��������������к�
    String arrCompensateNo[] = httpServletRequest.getParameterValues("CompensateNo");//��Ҫɾ�����������
    

    //ȥ��status�����һ������
    if(status!=null&&status.trim().length()>0){
      status=status.substring(0,status.length()-1);
    }
    //ȥ��compensateFlag�����һ������
    if(underWriteFlag!=null&&underWriteFlag.trim().length()>0){
      underWriteFlag = underWriteFlag.substring(0,underWriteFlag.length()-1);	
    }
    HttpSession session = httpServletRequest.getSession();
    //User   user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //����

//  add by miaowenjun 20060412
	String registNoSign = httpServletRequest.getParameter("RegistNoSign");
	String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
	String licenseNoSign = httpServletRequest.getParameter("LicenseNoSign");
	String operateDateSign = httpServletRequest.getParameter("OperateDateSign");
	String operateDateSignEnd = httpServletRequest.getParameter("OperateDateSignEnd");
	String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
	String compensateNoSign = httpServletRequest.getParameter("CompensateNoSign");
	String insuredName = httpServletRequest.getParameter("InsuredName");
	WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
	workFlowQueryDto.setUnderWriteFlag(underWriteFlag);
	workFlowQueryDto.setCompensateNo(compensateNo);
	workFlowQueryDto.setCompensateNoSign(compensateNoSign);
	workFlowQueryDto.setClaimNo(claimNo);
	workFlowQueryDto.setPolicyNo(policyNo);
	workFlowQueryDto.setRegistNo(registNo);
	workFlowQueryDto.setLicenseNo(licenseNo);
	workFlowQueryDto.setStatus(status);
	workFlowQueryDto.setOperateDate(operateDate);
	workFlowQueryDto.setOperateDateEnd(operateDateEnd);
	workFlowQueryDto.setInsuredName(insuredName);
	workFlowQueryDto.setRegistNoSign(registNoSign);
	workFlowQueryDto.setPolicyNoSign(policyNoSign);
	workFlowQueryDto.setLicenseNoSign(licenseNoSign);
	workFlowQueryDto.setOperateDateSign(operateDateSign);
	workFlowQueryDto.setOperateDateSignEnd(operateDateSignEnd);
	workFlowQueryDto.setInsuredNameSign(insuredNameSign);
	//add by miaowenjun 20060412
    
    String forward  = "";                                          //��ǰ
    try
    {
      //��δ����type�쳣����{}��������������쳣����{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW")) {
        //��ѯʵ��r��Ϣ,�������룬���ڳ�ʼ������ʾ
        //add by zhaolu 20060803 start
    	  String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
          String pageNo     = httpServletRequest.getParameter("pageNo");
          if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
    	//add by zhaolu 20060803 end
        DAACompensateViewHelper dAACompensateViewHelper = new DAACompensateViewHelper();
        //modify by zhaolu 20060803 start
        //dAACompensateViewHelper.setPrpLcompensateDtoToView(httpServletRequest,workFlowQueryDto);
        dAACompensateViewHelper.setPrpLcompensateDtoToView(httpServletRequest,workFlowQueryDto,pageNo,recordPerPage);
        //modify by zhaolu 20060803 end

        forward = "success";

      }
      
      if (editType.equals("PRINT")) {
    	 Collection compensateList = new ArrayList();
      	if ( (claimNo==null ||claimNo.equals("") ) && (compensateNo==null || compensateNo.equals("")) ){
      	  String conditions="  registNo='"+registNo+"'";
      	  UIClaimAction  uiClaimAction = new UIClaimAction();
    	  Collection  claimDtoList= uiClaimAction.findByConditions(conditions);
    	  if (claimDtoList!=null &&claimDtoList.size()>0 ) {
    	 	Iterator it = claimDtoList.iterator();
    	 	  while(it.hasNext()){
    	           PrpLclaimDto prpLclaimDto = (PrpLclaimDto)it.next();
    	           claimNo = prpLclaimDto.getClaimNo();
    	           Collection compensateListTemp = new UICompensateAction().findByClaimNo("claimNo = '" + claimNo+ "'");
    	           compensateList.add(compensateListTemp);
    	           }
    	 	}
    	    else {
    	 	  throw new Exception("�ð�����δ������");
    	    }
      	}
       else if ( ! (compensateNo==null || compensateNo.equals(""))){
          UICompensateAction  uiCompensateAction = new  UICompensateAction();
          CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo); 
          claimNo =  compensateDto.getPrpLclaimDto().getClaimNo();
          
       }
      	DAACompensateViewHelper dAACompensateViewHelper = new DAACompensateViewHelper();
     	String printType   = httpServletRequest.getParameter("PrintType");//�ⰸ��
     	httpServletRequest.setAttribute("printType", printType);
     	if(compensateList.size() == 0)
    	dAACompensateViewHelper.setPrpLcompensateDtoToPrint(httpServletRequest,
    			claimNo,printType);
    	httpServletRequest.setAttribute("compensateLists",compensateList);
   	    forward = "PRINT";
	}
      //������ɾ��
      if ("1".equals(strDeleteFlag)) {
				int size = arrCheckFlag.length;
				BLCompensateFacade facade = new BLCompensateFacade();
				for (int i = 0; i < size; i++) {
					// �ж�checkboxѡ�е��������
					if ("Y".equals(arrCheckFlag[i])) {
						facade.deleteCompensateRelation(arrCompensateNo[i]);
					}
				}
				httpServletRequest.setAttribute("content", "������ɾ���ɹ�");
				forward = "delete";
			}
		}
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.queryRegistList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.queryRegistList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally
    {

    }
    System.out.println("finishQueryEdit forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
