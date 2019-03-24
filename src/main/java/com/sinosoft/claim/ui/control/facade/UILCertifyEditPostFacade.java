package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICertifyAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAACertifyViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.image.bl.facade.*;
import com.sinosoft.image.dto.domain.*;
import com.sinosoft.utiall.dbsvr.*;
/**
 * �ַ�HTTP Post �������ⵥ֤�༭����
 * <p>Title: �������ⵥ֤�༭������Ϣ</p>
 * <p>Description: �������ⵥ֤�༭������Ϣ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author liubvo
 * @version 1.0
 */
public class UILCertifyEditPostFacade  extends Action {
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
     throws  Exception
  {

    String forward = ""; //��ǰ��ת
    try {
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      //��viewHelper�����������
       DAACertifyViewHelper daaCertifyViewHelper = new DAACertifyViewHelper();
       CertifyDto certifyDto = daaCertifyViewHelper.viewToDto(httpServletRequest);
       UICodeAction uiCodeAction = new UICodeAction();
       String claimNo = uiCodeAction.translateBusinessCode(certifyDto.getPrpLclaimStatusDto().getBusinessNo(),true);
       //���������������swfLogFlowID,��swfLogLogNo����д��request�����ˡ���
       String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //����������
       String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //������logno
       String riskCode =httpServletRequest.getParameter("riskCode");
       String registNos = httpServletRequest.getParameter("RegistNo");
       //Ӱ��ϵͳ���
       BLPrpdimagecodeFacade blPrpdimagecodeFacade = new BLPrpdimagecodeFacade();
       BLPrpdcertifycheckFacade blPrpdcertifycheckFacade = new BLPrpdcertifycheckFacade();
       PrpdimagecodeDto prpdimagecodeDto = new PrpdimagecodeDto();
       DBPrpDuser dbPrpDuser = new DBPrpDuser();
       DBPrpDcompany dbprpDcompany = new DBPrpDcompany();
       String role = "";
       String appcode = "";
       String appname = "";  
       String username="";
       String comcode = "";
       String comname= "";
       int t = 0;
       t = dbPrpDuser.getInfo(user.getUserCode());
       username=dbPrpDuser.getUserName();
       t = dbprpDcompany.getInfo(dbPrpDuser.getComCode());
       comcode = dbPrpDuser.getComCode();
       comname= dbprpDcompany.getComCName();
       String result = "";
      //�������������???
      //-----------------------------------------------------
      // 1requst����,2���ڵ�Ľڵ�����,3���ڵ���Ҫ���µ�״̬,4���ڵ��ҵ�����,5�Ժ�ڵ��ҵ�����,6���ڵ��ҵ���������,7�Ժ�ڵ��ҵ����������????
      //��֤��Ҫд����registno,��������Ҫ�õ�claimno��Ϊ�¸��ڵ��¼��
       
       //��ֹ�ظ��ύ
       String strLastAccessedTime = ""
			+ httpServletRequest.getSession().getLastAccessedTime()
			/ 1000;
       String oldLastAccessedTime = (String) httpServletRequest
			.getSession().getAttribute("oldCompensateLastAccessedTime");
       if (oldLastAccessedTime !=null && !oldLastAccessedTime.trim().equals("")) {
    	   throw new UserException(1, 3, "������", "�벻Ҫ�ظ��ύ");
       }
       httpServletRequest.getSession().setAttribute(
				"oldCompensateLastAccessedTime", strLastAccessedTime);
       WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
       UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
       String condition = "flowId ='"+swfLogFlowID+"' and nodeType='cance' and nodeStatus in ('0','2')";
       Collection cancelNodeList = uiWorkFlowAction.findNodesByConditions(condition);
       if(cancelNodeList!=null&&cancelNodeList.size()>0){
    	   throw new UserException(1,3,"1234","�����Ѿ�����ע�����⣡");
       }
       condition = "flowId ='"+swfLogFlowID+"' and nodeType='certi' and logno= "+ swfLogLogNo+"  and nodeStatus in ('4')";
       Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
       if(certifyNodeList!=null&&certifyNodeList.size()>0){
    	   throw new UserException(1,3,"1234","������֤�����Ѿ�����");
       }
       if(riskCode!=null)
       {
 		  prpdimagecodeDto = blPrpdimagecodeFacade.findByPrimaryKey(riskCode,"0000000000");
		  role = prpdimagecodeDto.getClaimrole();
		  appcode=prpdimagecodeDto.getClaimcode();
		  appname=prpdimagecodeDto.getClaimname();
		  //String businessno= "1111111111";
		  String businessno = registNos;
		   StringBuffer s = new StringBuffer();
		   s.append("<?xml version='1.0' encoding='UTF-8'?><root><BASE_DATA>");
		   s.append("<USER_CODE>");
		   s.append(user.getUserCode());
		   s.append("</USER_CODE>");
		   
		   s.append("<USER_NAME>");
		   s.append(username);
		   s.append("</USER_NAME>");
		   
		   s.append("<ORG_CODE>");
		   s.append(comcode);
		   s.append("</ORG_CODE>");
		   
		   s.append("<ORG_NAME>");
		   s.append(comname);
		   s.append("</ORG_NAME>");
		   
		   s.append("<ROLE_CODE>");
		   s.append(role);
		   s.append("</ROLE_CODE>");
		   
		   s.append("</BASE_DATA><META_DATA><BATCH>");
		   
		   s.append("<APP_CODE>");
		   s.append(appcode);
		   s.append("</APP_CODE>");
		   
		   s.append("<APP_NAME>");
		   s.append(appname);
		   s.append("</APP_NAME>");
		   
		   s.append("<BUSI_NO>");
		   s.append(businessno);
		   s.append("</BUSI_NO>");
		   
		   s.append("</BATCH></META_DATA></root>");
		   try{
			   System.err.println(s.toString());
			   result = blPrpdimagecodeFacade.imageStatistics(s.toString());
			   //System.err.println(result);
			   String newxml = blPrpdimagecodeFacade.html2xml(result);
			   String nodeID = "";
			   String strWaning = "";
			   Collection nodes =  new ArrayList();
			   nodes = blPrpdcertifycheckFacade.findAllByPrimaryKey(riskCode,"claim");
			   HashMap hm = blPrpdimagecodeFacade.imageNodeCheck(newxml,nodes);
			   strWaning = blPrpdcertifycheckFacade.checkMustUpload(nodes,hm);
			   if(!strWaning.equals(""))
			   {
				   throw new UserException(1, 3, "��֤��Ϣ", strWaning);
			   }
			}catch (Exception e){
			e.printStackTrace();
			throw e;
		}
		   
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
       //******************modify by qinyongli start   2005-8-1
       //�����Ҫ����Ҫ�����Ϳ��Խ��е�֤�ռ�����ʱ����ҵ���Ϊ�����ţ�       
       String registNo = certifyDto.getPrpLcertifyCollectDto().getBusinessNo();
       String buttonSaveType = httpServletRequest.getParameter("buttonSaveType"); //�ύ����
//       if(riskCode.substring(0,2).equals("27")){
//       	  if(buttonSaveType!=null&&!buttonSaveType.equals("")){
//       	     if(buttonSaveType.equals("0")){
//    	         swfLogDtoDealNode.setNodeStatus("0");
//       	     }else if(buttonSaveType.equals("2")){
//       	         swfLogDtoDealNode.setNodeStatus("2");
//       	     }else{
//       	         swfLogDtoDealNode.setNodeStatus("4");
//       	     }
//       	   }
//           swfLogDtoDealNode.setNextBusinessNo(registNo);
//           swfLogDtoDealNode.setKeyIn(registNo);
//           swfLogDtoDealNode.setKeyOut(registNo);
//       }else {
           swfLogDtoDealNode.setNodeStatus(certifyDto.getPrpLclaimStatusDto().getStatus());
           swfLogDtoDealNode.setNextBusinessNo(claimNo);
           swfLogDtoDealNode.setKeyIn(claimNo);
           swfLogDtoDealNode.setKeyOut(certifyDto.getPrpLclaimStatusDto().getBusinessNo());
//       }
       //add by lixiang start at 2006-6-8
       //�����ǳ��յ�ʱ������ǿ��ԭ���п��ܻ����2�����㣬������Ҫ�������ͬʱ����2���������񣬲��Ҳ������ڶ���ύ����������⣬����
       //ͬ��ϲ������⡣����
       //��Ҫ�жϳɳ��յġ����������ýش��ķ�ʽ������
       String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
	
       if (("I".equals(strRiskType) || "H".equals(strRiskType)|| "D".equals(strRiskType))&&"4".equals(buttonSaveType)){
       	//���ڿ��ܻ����������ע�������������Ŀǰֻ�ύ������û��ע��������£���ʾ��������
       	String strSql ="registNo='"+registNo+"' and canceldate is null ";
       	UIClaimAction uiClaimAction = new UIClaimAction();
       	ArrayList claimList =(ArrayList)uiClaimAction.findByConditions(strSql ) ;
       	//swfLogFlowID
       	BLSwfLogFacade  facadeSwf = new BLSwfLogFacade();
       	String conditions = "FlowID = '"+swfLogFlowID+"' and NodeType= 'compe'  and nodestatus='0' ";
       	Collection tion = facadeSwf.findByConditions(conditions);
       	  if (claimList!=null&&claimList.size() >0 && (tion.size()==0)){
       		 //�γ�����������б�����Ҫ��riskcode,
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
          	
          	swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
			swfLogDtoDealNode.setSwfLogList(nextNodeList);
       	  }
        }
      
       //add by lixiang end at 2006-6-8
       //*****************modify by qingyongli end  2005-8-1
       WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto((UserDto)httpServletRequest.getSession().getAttribute("user"),swfLogDtoDealNode);

       //add by lixiang start at 2006-08-24
    	  //������ύ�ĵ���-������������ڣ�����Ҫ�ж��ǲ��ǵ����Ѿ������ˣ�û������Ҳ�ѵ����ó���ɵ�״̬
       //��ˮ��Q���ύ��֤ʱ����д���ȴ����־
       if (("Q".equals(strRiskType) || "I".equals(strRiskType) || "H".equals(strRiskType)|| "D".equals(strRiskType)|| "E".equals(strRiskType))&&"4".equals(buttonSaveType)){ 
    	    Collection noSubmitNodesList=uiWorkFlowAction.findNodesByConditions(" flowID='"+swfLogDtoDealNode.getFlowID() +"' and nodeType='sched' and nodestatus<'4'");
    	    Collection noSubmitNodesListCheck=uiWorkFlowAction.findNodesByConditions(" flowID='"+swfLogDtoDealNode.getFlowID() +"' and nodeType='check' and nodestatus<'4'");
    	    SwfLogDto wfLogDtoTemp=null;
    	    if (noSubmitNodesList!=null&&noSubmitNodesListCheck.size() >0) {
    	   //��ɵ�������
    	    	throw new UserException(1,3,"0000","������"+swfLogDtoDealNode.getFlowID()+"�鿱����û���ύ�����ܽ��е�֤�ύ��");
    	    }
    	    
    	    if (noSubmitNodesList!=null&&noSubmitNodesList.size() >0) {
       	   //��ɵ�������
       	     wfLogDtoTemp = (SwfLogDto)noSubmitNodesList.iterator().next() ;
       	     wfLogDtoTemp.setNodeStatus( "4");
			 wfLogDtoTemp.setSubmitTime( new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
			 workFlowDto.setUpdateSwfLog2Dto( wfLogDtoTemp);
       	   }
       }       
       //add by lixiang end at 2006-08-24
       //���浥֤��Ϣ
       UICertifyAction uiCertifyAction = new UICertifyAction();

      if (workFlowViewHelper.checkDealDto(workFlowDto))
      {
        uiCertifyAction.save(certifyDto,workFlowDto);
        user.setUserMessage(certifyDto.getPrpLclaimStatusDto().getBusinessNo());
      }else
      {
        uiCertifyAction.save(certifyDto);
        //user.setUserMessage(certifyDto.getPrpLclaimStatusDto().getBusinessNo()+";ע��:û�з����빤������������κ����ݣ���");
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
      //������Ϣ����
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
      //������Ϣ����
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
      //������Ϣ����
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
