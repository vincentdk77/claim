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
 * �ַ�HTTP Post �������ⱨ���༭����
 * <p>Title: �������ⱨ���༭������Ϣ</p>
 * <p>Description: �������ⱨ���༭������Ϣ</p>
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

    String forward = ""; //��ǰ��ת
     
    /*
     * * ����˼·��
     *========================================================
     (1)��˰����ؿ��ⰸ��prplrecase������û�м�¼��û�����serialNo��Ϊ1�������ۼ�serialNo
     (2)����һ����¼���ؿ��ⰸ��
     (3)ɾ���������еĽ᰸����
     (4)����ת�켣
     (5)����һ�����������������     
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
         
         //�ӽ����������ݵ�reCaseDto,����һ���ؿ��ⰸ��¼
         ReCaseViewHelper  reCaseViewHelper = new ReCaseViewHelper();
         ReCaseDto reCaseDto = reCaseViewHelper.viewToDto(httpServletRequest);
         BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
         PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo.trim());
         //���������������Ĵ������
         WorkFlowDto workFlowDto = new WorkFlowDto();
      
         //1.Ѱ�ҹ������ϵı���
         UIWorkFlowAction  uiWorkFlowAction =new UIWorkFlowAction();
         String flowId = uiWorkFlowAction.findStoreFlowIDBybusinessNo(claimNo); //��ȡflowId
         //modify by lixiang start at 2006-6-7
         //reason :��鹤�����Ƿ��Ѿ��ر�,��رգ�����Ҫ����������������û�رգ���ֻҪ��Ѱ�ҵĵ��᰸�ŵ�һ���᰸���0״̬��
         //����©�������ؿ��ⰸĿǰû���κεĵ�ҵ����������Ժ�᲻����©��������
        
         if (flowId.equals( "")) {
        	 //һ������´�ת����ȡ����û��ת�������swflog��ȡ
        	 flowId = uiWorkFlowAction.findFlowIDBybusinessNo(claimNo); 
        	 if (flowId.equals( "")) {
        		 throw new Exception("����δ��ѯ����������Ϣ�������ؿ��ⰸ��");	
        	 }
         }
         //2.����������ڵ�״̬
         SwfFlowMainDto swfFlowMainDto=uiWorkFlowAction.findFlowMainByPrimaryKey(flowId);//��flowstatus��Ϊ1
         //��ת���Ĵ�ת����ȡ����
         int maxLogNo= 0;  //db��maxLogNo��ȡ�����LogNo+1
         int maxEndcaseLogNo = 0; 
         BLSwfLogStoreFacade blSwflogStoreFacade = null;
         SwfLogDto swfLogjaDto = new SwfLogDto();
         //��ѯ���������һ������ڵ�
         String condition = "flowid='"+flowId+"' and businessno='"+claimNo+"' and nodeType='compe' order by logNo desc";
         //����Ƿ�������������Ѿ��ؿ����ⰸ�ˣ����������¿��ⰸ�ˡ���
         String compeStr ="flowid='"+flowId+"' and businessno='"+claimNo+"' and nodeType='compe' and flowstatus>'0' and nodestatus<'4'";
         Collection nodes = null;
         int compeCount = 0;
         //��ת�������ݴ�swflogStore��ѯ
         if("1".equals(swfFlowMainDto.getStoreFlag())){
        	 blSwflogStoreFacade = new BLSwfLogStoreFacade();
        	 maxLogNo = blSwflogStoreFacade.getMaxLogNo(flowId);
        	 maxEndcaseLogNo = blSwflogStoreFacade.getMaxNodeLogNo(flowId,"endca",claimNo); 
        	 swfLogjaDto = blSwflogStoreFacade.findByPrimaryKey(flowId,maxEndcaseLogNo);
        	 nodes = uiWorkFlowAction.findStoreNodesByConditions(condition);
        	 compeCount = uiWorkFlowAction.findFlowStoreNodeCountByConditon(compeStr);
         //δת�������ݴ�Swflog��ѯ
         }else{
             maxLogNo= uiWorkFlowAction.getSwfLogMaxLogNo(flowId);  //db��maxLogNo��ȡ�����LogNo+1
             maxEndcaseLogNo = uiWorkFlowAction.getSwfLogMaxNodeLogNo(flowId,"endca",claimNo); 
             swfLogjaDto = uiWorkFlowAction.findNodeByPrimaryKey(flowId,maxEndcaseLogNo); //swfLogjaDtoΪ�᰸����swflogDto
             nodes = uiWorkFlowAction.findNodesByConditions(condition);
             compeCount = uiWorkFlowAction.findFlowNodeCountByConditon(compeStr);
         }
         if (nodes == null || nodes.size() == 0){
           	throw new UserException(1,10,"�ؿ��ⰸ","û�з��ִ�����������ڵ㣡");
         }
         if (compeCount>0){
          	throw new UserException(1,10,"�ؿ��ⰸ","�˰����������Ѿ��ؿ����ⰸ��δ������ϣ��벻Ҫ���ؿ��ⰸ��");
          }
         //����һ����������������
         int modelNo=0; //Ĭ��
         SwfLogDto   swfLoglsDto = new SwfLogDto();          //swfLoglsDtoΪ����������ڵ��swfLogDto
         ArrayList swfLogList = new ArrayList();             //���������ӵ�����ڵ�
         ArrayList swfPathLogList= new ArrayList();          //���������ӵĽ᰸�����������Ϣ
   
         if(swfLogjaDto==null){
          	throw new UserException(1,10,"�ؿ��ⰸ","����δ��ѯ���᰸�Ĺ�������Ϣ�������ؿ��ⰸ��");
            
         }
         
         String conditions=" businessNo = '"+prpLclaimDto.getRegistNo()+"'  and ValidStatus ='1' and typeCode ='0105' ";
//         BLPrpLcertifyImgFacade blPrpLcertifyImgFacade = new BLPrpLcertifyImgFacade();
//         ArrayList<PrpLcertifyImgDto> PrpLcertifyImgDtoList = (ArrayList<PrpLcertifyImgDto>) blPrpLcertifyImgFacade.findByConditions(conditions);
//         if(null == PrpLcertifyImgDtoList || PrpLcertifyImgDtoList.size()==0){
//      	   throw new UserException(1,3,"�ؿ��ⰸ","�����ϴ�һ���ؿ��ⰸ��Ƭ��");
//         }  
//          
          
         //3.�رյ����̵Ĵ���
         if(swfLogjaDto!=null&&swfFlowMainDto.getFlowStatus().equals( "0") ){
         	//3.1�����������������ݣ��򿪹������Ľڵ���������
         	swfFlowMainDto.setFlowStatus( "1");
            workFlowDto.setReOpen(true);
            workFlowDto.setReOpenSwfFlowMainDto(swfFlowMainDto);
         }
        
//         SwfLogDto swfLogCompe = (SwfLogDto)nodes.iterator().next();
//         //4.�γ��µ�����ڵ�����
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
//         swfLoglsDto.setTaskNo(swfNodeDto.getTaskNo());      //���ĵ�
//         swfLoglsDto.setTaskType(swfNodeDto.getTaskType());  //���ĵ�
//         swfLoglsDto.setTitleStr("�ؿ��ⰸ"); //���ĵ�
//         swfLoglsDto.setDeptName(user.getComName());
//         swfLoglsDto.setPosX(0); //���ĵ�
//         swfLoglsDto.setPosY(0); //���ĵ�
//         swfLoglsDto.setTypeFlag(swfNodeDto.getTypeFlag());
//         if(riskCode.substring(0,2).equals("05")){
//           swfLoglsDto.setLossItemCode(swfLogjaDto.getLossItemCode());
//           swfLoglsDto.setLossItemName(swfLogjaDto.getLossItemName());
//         }
//         swfLoglsDto.setEndFlag(swfNodeDto.getEndFlag()); //���ĵ�
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
         nextSwfLogDto.setTaskNo(swfNodeDto.getTaskNo());      //���ĵ�
         nextSwfLogDto.setTaskType(swfNodeDto.getTaskType());  //���ĵ�
         nextSwfLogDto.setTitleStr("�ؿ��ⰸ"); //���ĵ�
         nextSwfLogDto.setDeptName(user.getComName());
         nextSwfLogDto.setPosX(0); //���ĵ�
         nextSwfLogDto.setPosY(0); //���ĵ�
         nextSwfLogDto.setTypeFlag(swfNodeDto.getTypeFlag());
         if(swfLogjaDto.getRiskCode().substring(0,2).equals("05")){
        	 nextSwfLogDto.setLossItemCode(swfLogjaDto.getLossItemCode());
        	 nextSwfLogDto.setLossItemName(swfLogjaDto.getLossItemName());
         }
         nextSwfLogDto.setEndFlag(swfNodeDto.getEndFlag()); //���ĵ�
         nextList.add(nextSwfLogDto);
         
         //5.�γ��µ�����������
         String pathName ="�� �᰸ �� "+ nodeName ;
         SwfPathLogDto swfPathLogDtoTemp = new SwfPathLogDto();
         swfPathLogDtoTemp.setPathNo(uiWorkFlowAction.getSwfPathLogMaxPathNo( flowId) );
         swfPathLogDtoTemp.setFlowID(flowId );
         swfPathLogDtoTemp.setStartNodeNo(maxEndcaseLogNo );
         swfPathLogDtoTemp.setStartNodeName( "�᰸");
         swfPathLogDtoTemp.setEndNodeNo(maxLogNo );
         swfPathLogDtoTemp.setEndNodeName( nodeName );
         swfPathLogDtoTemp.setModelNo(modelNo); 
         swfPathLogDtoTemp.setPathName(pathName);
         SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
           
         swfPathLogList.add(swfPathLogDtoTemp );
         //6.���������ӷ�ʽ����Ϊ��̨���ݱ������Դ��
         workFlowDto.setSubmit( true);
         workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogList );
         workFlowDto.setSubmitSwfLogDtoList(nextList );
       
         //------------------------------------------------------------------------------
         UIRecaseAction uiRecaseAction = new  UIRecaseAction();
         uiRecaseAction.save(reCaseDto, workFlowDto);
         
         /*** ����ע�������ƽ̨ start****/
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
   				String msg = "����'" + prpLclaimDto.getClaimNo()
   						+ "'�ύ˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!";
   				throw new UserException(1, 3, "������", msg);
   		}
   		/*** ����ע�������ƽ̨ end****/
         
//       modify by lixiang end at 2006-6-7
         user.setUserMessage("�����ؿ��ⰸ�ɹ�");
 
      //Ĭ�ϲ���Ҫ�Զ���ת
      forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
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
      //������Ϣ����
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
      //������Ϣ����
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
