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
 * �ַ�HTTP Post ����ע��������Ϣ
 * <p>Title: ���ձ���ע��������Ϣ</p>
 * <p>Description: ���ձ���ע��������Ϣ����</p>
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

     

    String forward = ""; //��ǰ��ת

    try {
       
       //ȡ�õ�ǰ�û���Ϣ
       UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
       //�õ��Ƿ�Ϊȫ��ע���ı��
       String allCancleFlag =   StringUtils.rightTrim(httpServletRequest.getParameter("txtAllCancle"));
      //�������������ѡ��ı����ı����Ѿ��������Ļ������ܽ���ע����
       //��viewHelper�����������
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
       str = str+"��"+logoutContext;
       PrplregisthisDto prplregisthisDto = dAARegistViewHelper.getPrplregisthisDto(user, "01", "0", str, "01", registDto.getPrpLregistDto().getRegistNo(), count+1);
       registDto.setPrplregisthisDto(prplregisthisDto);
       }
       UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
       UIRegistAction uiRegistAction = new UIRegistAction();
       UIClaimAction uiClaimAction = new UIClaimAction();
       
       WorkFlowDto workFlowDto = new WorkFlowDto();
       //������������ע����Ϣ
       WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
       //����Ϊ������ʹ���е�
       //�õ����̱��
       String swfLogFlowID = uiWorkFlowAction.findFlowIDByRegistNo(registDto.getPrpLregistDto().getRegistNo());
       String swfLogLogNo = "1"; //������logno�a��Ϊ1
       SwfLogDto swfLogDtoDealNode = new SwfLogDto();
       
       String uploadUpolicyNo = "";
       if (allCancleFlag.equals("1")){
        
         //��Ҫ����Ƿ����Ѿ������ģ����������������������������
       	
       	String strSql = "registNo='"+registDto.getPrpLregistDto().getRegistNo()+"' and canceldate is null ";
       	
       	Collection claimList =uiClaimAction.findByConditions(strSql);
       	
       	if (claimList!=null&&claimList.size() >0){
       	  String msg = "�˱���Ŀǰ��"+claimList.size()+"�����Ѿ�������������˱���������ע�����ٽ��б�����ȫ��ע����";
          throw new UserException(1,3,"����ע��",msg);
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
       
       
        //ȡ��ǿ�ձ�����
      	String strWhere = " registNo = '" + registDto.getPrpLregistDto().getRegistNo() + "' and policyType='3' ";
      	Collection collection = new UIPrpLregistRPolicyAction().findByConditions(strWhere);
      	for(Iterator iter = collection.iterator();iter.hasNext();){
      		PrpLRegistRPolicyDto  prpLRegistRPolicyDto = (PrpLRegistRPolicyDto)iter.next();
      		uploadUpolicyNo = prpLRegistRPolicyDto.getPolicyNo();
      	}
       //���ֻ�Ǽ�ע��һ���֣��Ĳ���
       if (allCancleFlag.equals("3")){
        	//���ݱ����Ž���ע��
       	String[] policyNoList = httpServletRequest
		.getParameterValues("prpLclaimPolicyNo"); //�����б�
       	
       	String[] selectToCancleList = httpServletRequest
		.getParameterValues("selectToCancle");    //ѡ�����ע���Ŀ���

       	registDto.getPrpLregistDto().setCancelDate(null);
       	registDto.getPrpLregistDto().setDealerCode("");
       	
       	for (int index = 0; index < policyNoList.length; index++) {
			if (selectToCancleList[index].equals( "1")){
			 //��ʱ��ע��һ�������ɡ����Ժ���˵������Ŀǰ֧��һ��һ����ע��������ʱ����
				//��ѯ���������
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
		        //������ע��
		        
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
        //���汨��ע����Ϣ�����ҹ�������

        if (workFlowViewHelper.checkDealDto(workFlowDto))
        {
           //���ñ��ڵ�Ϊע��״̬ lixiang bakkkk!!
          if (workFlowDto.getUpdateSwfLogDto() !=null){
           	workFlowDto.getUpdateSwfLogDto().setNodeStatus( "6"); //����������
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
      
      //����ƽ̨�ϴ�
        String strHerf = "(<a href=\"javascript:showErrorInfo('info')\">��ϸ��Ϣ</a>)";
		try{
			
			System.out.println("============�Ϻ�ƽ̨�⽡������ע����Ϣ�ϴ�ƽ̨begin============");
			//�Ϻ�ƽ̨�⽡��������Ϣ�ϴ�
			boolean isYJXFlag = false;
			boolean isSuccess = false;
			String groupFlag = "";
			//String strRegistNo = registDto.getPrpLregistDto().getRegistNo();
			String strPolicyNo = registDto.getPrpLregistDto().getPolicyNo();//������
			//���ݱ���������ѯ������Ϣ,�жϸñ����Ƿ�Ϊ�ŵ�
			BLPrpCmain blPrpCmain = new BLPrpCmain();
			blPrpCmain.getData(strPolicyNo);	
			String secodeComCode = new BLPrpDcompany().getDaaPlatformComCode(registDto.getPrpLregistDto().getComCode());
			DBManager dbManager = new DBManager();
			if("26,27,28".indexOf(registDto.getPrpLregistDto().getClassCode()) > -1){
				isYJXFlag = true;
			}
			if(isYJXFlag && "310000".equals(secodeComCode)){
				System.out.println("------------------�Ϻ�ƽ̨�⽡������ע���ӿڵ���,registno= " + strRegistNo +" --------------------------");				
				try {					
					dbManager.open(AppConfig.get("sysconst.DBJNDI"));
					//����prpcmain.groupNo�Ƿ�Ϊ���ж��Ƿ�Ϊ�ŵ�
					if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
						groupFlag = "0";//����
						isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C12", "", strRegistNo, strPolicyNo, groupFlag, secodeComCode);
					}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
						groupFlag = "1";//����
						isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C14", "", strRegistNo, strPolicyNo, groupFlag, secodeComCode);
					}
					if(isSuccess){
					    user.setUserMessage(user.getUserMessage() + "<br>�⽡�ձ���ע����Ϣ�ϴ�ƽ̨�ɹ�!");
					}else{
						user.setUserMessage(user.getUserMessage() + "<br>�⽡�ձ���ע����Ϣ�ϴ�ƽ̨ʧ��!");
					}
				} catch (Exception e) {
					e.printStackTrace();
					user.setUserMessage(user.getUserMessage() + "<br>"+e.getMessage());
				} finally{//�ر�����Դ
					dbManager.close();
				}				
			}	
			System.out.println("============�Ϻ�ƽ̨�⽡������ע����Ϣ�ϴ�ƽ̨end============");
			
			System.out.println("���Ͻ��н�ǿ��ƽ̨����");
			boolean isUpload = false;
			isUpload = BLCIClaimPlatFormCheckAction.checkUploadForRegistCancel(uploadUpolicyNo, registDto.getPrpLregistDto().getRegistNo());
			if(isUpload){
				BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
						RequestType.CASE_CANCEL,
						registDto.getPrpLregistDto().getRegistNo(),"", true,"0");
				
				user.setUserMessage(user.getUserMessage() + "<br>�ϴ�����ƽ̨�ɹ�!");
			}
			
			System.out.println("���Ͻ�����ҵ��ƽ̨����");
			//��2011
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
					if("0".equals(cIPlatformConfigDto.getConfigValue().trim())) {// ��ҵ��2011	0��ʱ������1�Ǽ�ʱ����
						BLCIClaimSYXPlatFormInterfaceFacade
						.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CANCEL_CASE,
								registDto.getPrpLregistDto().getRegistNo(),
								true,cIPlatformConfigDto,"0","");
						user.setUserMessage(user.getUserMessage()
								+ "<br>����ע���ϴ���ҵ��ƽ̨�ɹ�!");
					}else{
						BLCIClaimSYXPlatFormInterfaceFacade
						.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CANCEL_CASE,
								registDto.getPrpLregistDto().getRegistNo(),
								false,cIPlatformConfigDto,"0","");
						user.setUserMessage(user.getUserMessage()
								+ "<br>����ע���ϴ���ҵ��ƽ̨�ɹ�!");
					}
				}
			}
					
			
			
		
		}catch(ClaimCiPlatFormException e){
			e.printStackTrace();
			httpServletRequest.setAttribute("ciClaimException", e);
			user.setUserMessage(user.getUserMessage() + "<br>�ϴ�����ƽ̨ʧ�ܣ�<br>" + e.getMessage() + strHerf);
		}catch(Exception e ){
			e.printStackTrace();
			httpServletRequest.setAttribute("ciClaimException", e);
			user.setUserMessage(user.getUserMessage() + "<br>�ϴ�����ƽ̨ʧ��:<br>" + e.getMessage() + strHerf);
		}
       ActionMessages messages = new ActionMessages();
       ActionMessage message;
       message = new ActionMessage("����ע������ɹ�");
       user.setUserMessage("����ע������ɹ�" + user.getUserMessage());
       messages.add( ActionMessages.GLOBAL_MESSAGE, message );
       saveMessages( httpServletRequest, messages );
      
       forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("����ע��");
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
      ActionError error = new ActionError("����ע��");
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
      ActionError error = new ActionError("����ע��");
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
