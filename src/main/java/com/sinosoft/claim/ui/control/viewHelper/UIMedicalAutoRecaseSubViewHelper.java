package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLReCaseAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterRecaseDetailAction;
import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcertifyDirectFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseDetailFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyDirect;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowApprovalInterFaceFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDuser;

/**
 * 1.	�����м��������֯�ؿ��ⰸ���ҵ�����ݡ�
 * 2.	�����������ݣ������ؿ��ⰸ�ڵ㲢���ù��������ת����
 * 3.	��ɶ��ؿ��ⰸ��ҵ�����ݼ����������ݵĴ洢��
 * 4.	���ýӿڷ����ؿ��ⰸ���ݵ��˱�����ϵͳ���д���
 * 5.	��������״̬���ؿ����뻷��״̬��
 * 
 * @author Administrator
 *
 */
public class UIMedicalAutoRecaseSubViewHelper {
	/**
	 * ��ҽ�ƽӿ��Զ������ؿ������̷����������Զ������ؿ���ҵ�����ݺ͹���������
	 * @param prpLinterRecaseRequestDto
	 * @return
	 * @throws Exception
	 */
	public PrpLinterRecaseRequestDto autoRecase (PrpLinterRecaseRequestDto prpLinterRecaseRequestDto) throws Exception{
		String registNo = prpLinterRecaseRequestDto.getRelationRegistNo();
		String operatorCode  =  prpLinterRecaseRequestDto.getApplyRecaseUser();
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
        PrpDuserDto prpDuserDto = blPrpDuserFacade.findByPrimaryKey(operatorCode);
		String operatorName  =  prpDuserDto.getUserName();
		String operatorComCode = prpLinterRecaseRequestDto.getMakeCom();
		String operatorComCName = prpLinterRecaseRequestDto.getMakeComName();
		//��֯UserDto����
		UserDto user  = new UserDto();
		user.setUserCode(operatorCode);
		user.setUserName(operatorName);
		user.setComCode(operatorComCode);
		user.setComName(operatorComCName);
		String claimNo = "";
		BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = new PrpLinterRecaseDetailDto();
		BLPrpLinterRecaseDetailAction blPrpLinterRecaseDetailAction = new BLPrpLinterRecaseDetailAction();
		BLPrpLinterRecaseDetailFacade blPrpLinterRecaseDetailFacade = new BLPrpLinterRecaseDetailFacade();
		try {
			String conditions  = " registno='"+registNo.trim()+"' ";
			ArrayList<PrpLclaimDto> prpLclaimList = (ArrayList<PrpLclaimDto>) blPrpLclaimFacade.findByConditions(conditions);
			if(prpLclaimList==null||prpLclaimList.isEmpty()||prpLclaimList.size()<1){
				throw new Exception("δ��ѯ���Ϸ���������Ϣ");
			}
			PrpLclaimDto prpLclaimDto = prpLclaimList.get(0);
			claimNo = prpLclaimDto.getClaimNo();
			//��ȡ���serialNo
			int serialNo=0;
			UIRecaseAction  uiRecaseAction  =new  UIRecaseAction ();
			conditions="claimNo ='"+claimNo+"'";
			if(uiRecaseAction.findByConditions(conditions)!=null){
			    int maxSerialNo =  uiRecaseAction.getMaxSerialNo(claimNo);
			    serialNo = maxSerialNo+1;
			}
			else {
				serialNo =1;
			}
			ReCaseDto   reCaseDto = new ReCaseDto();;
			//���ؿ��ⰸ��ֵ
			PrpLrecaseDto   prpLrecaseDto =  new PrpLrecaseDto();
			prpLrecaseDto.setClaimNo(claimNo);
			prpLrecaseDto.setSerialNo(serialNo);
			prpLrecaseDto.setOpenCaseDate(new DateTime(prpLinterRecaseRequestDto.getApplyRecaseTime(),DateTime.YEAR_TO_SECOND));
			prpLrecaseDto.setOpenCaseUserCode(prpLinterRecaseRequestDto.getApplyRecaseUser());
			prpLrecaseDto.setReCaseReason(prpLinterRecaseRequestDto.getAppRecaseReason());
			reCaseDto.setPrpLrecaseDto(prpLrecaseDto);
			
			//��֤��Ϣ
			ArrayList<PrpLcertifyDirectDto> prpLcertifyDirectDtoList = new ArrayList<PrpLcertifyDirectDto>();
			PrpLinterCertifyDto[] prpLinterCertifyDtoList = prpLinterRecaseRequestDto.getPrpLinterCertifyDto();
			PrpLcertifyDirectDto prpLcertifyDirectDto = null;
			int maxSerialNo = new BLPrpLcertifyDirectFacade().getCount(" registno='"+registNo+"' and lossitemcode='1' ")+1;
			if(prpLinterCertifyDtoList!=null && prpLinterCertifyDtoList.length>0){
				for(int i=0;i<prpLinterCertifyDtoList.length;i++){
					prpLcertifyDirectDto = new PrpLcertifyDirectDto();
					prpLcertifyDirectDto.setRegistNo(registNo);
					prpLcertifyDirectDto.setSerialNo(i + maxSerialNo);
					prpLcertifyDirectDto.setRiskCode(prpLclaimDto.getRiskCode());
					prpLcertifyDirectDto.setPolicyNo(prpLinterRecaseRequestDto.getPolicyno());
					prpLcertifyDirectDto.setLossItemCode("1");
					prpLcertifyDirectDto.setTypeCode(prpLinterCertifyDtoList[i].getTypeCode());
					prpLcertifyDirectDto.setTypeName(prpLinterCertifyDtoList[i].getTypeName());
					prpLcertifyDirectDto.setColumnValue("columevaue");
					prpLcertifyDirectDtoList.add(prpLcertifyDirectDto);
				}
			}
			
			/***********����������ʼ*************/
			
			//���������������Ĵ������
			WorkFlowDto workFlowDto = new WorkFlowDto();
    
			//1.Ѱ�ҹ������ϵı���
			UIWorkFlowAction  uiWorkFlowAction =new UIWorkFlowAction();
			String flowId = uiWorkFlowAction.findStoreFlowIDBybusinessNo(claimNo); //��ȡflowId
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
			  	throw new Exception("û�з��ִ�����������ڵ㣡");
			}
			if (compeCount>0){
			 	throw new Exception("�˰����������Ѿ��ؿ����ⰸ��δ������ϣ��벻Ҫ���ؿ��ⰸ��");
			 }
			//����һ����������������
			int modelNo=0; //Ĭ��
			ArrayList swfPathLogList= new ArrayList();          //���������ӵĽ᰸�����������Ϣ
			if(swfLogjaDto==null){
			 	throw new Exception("����δ��ѯ���᰸�Ĺ�������Ϣ�������ؿ��ⰸ��");
			   
			}
			//3.�رյ����̵Ĵ���
			if(swfLogjaDto!=null&&swfFlowMainDto.getFlowStatus().equals( "0") ){
				//3.1�����������������ݣ��򿪹������Ľڵ���������
				swfFlowMainDto.setFlowStatus( "1");
				workFlowDto.setReOpen(true);
				workFlowDto.setReOpenSwfFlowMainDto(swfFlowMainDto);
			}
			
			ArrayList<SwfLogDto> nextList=new ArrayList<SwfLogDto>();
			modelNo=swfLogjaDto.getModelNo() ;
			SwfNodeDto  swfNodeDto= uiWorkFlowAction.findModelNodeByNodeType(modelNo,"rcase");  
			int nodeNo= swfNodeDto.getNodeNo();
			String nodeName=swfNodeDto.getNodeName(); 
			SwfLogDto nextSwfLogDto = new SwfLogDto();
			nextSwfLogDto = swfLogjaDto;
			nextSwfLogDto.setNodeNo(nodeNo);
			nextSwfLogDto.setNodeName(nodeName);
			nextSwfLogDto.setFlowInTime(new DateTime(prpLinterRecaseRequestDto.getApplyRecaseTime(),DateTime.YEAR_TO_SECOND).toString());
			nextSwfLogDto.setFlowStatus("1");
			
			nextSwfLogDto.setKeyIn(claimNo);
			nextSwfLogDto.setLogNo(maxLogNo);
			nextSwfLogDto.setNodeStatus("0"); 
			nextSwfLogDto.setNodeType("rcase");
			nextSwfLogDto.setPackageID("0");     
			nextSwfLogDto.setMainFlowID("0");    
			 
			nextSwfLogDto.setSubFlowID("0");  
			nextSwfLogDto.setRegistNo(swfLogjaDto.getRegistNo());
			nextSwfLogDto.setInsuredName(swfLogjaDto.getInsuredName());
			
			nextSwfLogDto.setHandleDept(swfLogjaDto.getHandleDept());
			nextSwfLogDto.setHandleTime(new DateTime(prpLinterRecaseRequestDto.getApplyRecaseTime(),DateTime.YEAR_TO_SECOND).toString());
			String beforeHandlerCode=swfLogjaDto.getHandlerCode();
			String beforeHandleName =swfLogjaDto.getHandlerName();
			nextSwfLogDto.setBeforeHandlerCode(beforeHandlerCode);
			nextSwfLogDto.setBeforeHandlerName(beforeHandleName);
			nextSwfLogDto.setTaskNo(swfNodeDto.getTaskNo());      
			nextSwfLogDto.setTaskType(swfNodeDto.getTaskType());  
			nextSwfLogDto.setTitleStr("�ؿ��ⰸ");
			nextSwfLogDto.setDeptName(user.getComName());
			nextSwfLogDto.setPosX(0);
			nextSwfLogDto.setPosY(0); 
			nextSwfLogDto.setTypeFlag(swfNodeDto.getTypeFlag());
			nextSwfLogDto.setEndFlag(swfNodeDto.getEndFlag()); 
			nextSwfLogDto.setSubmitTime(new DateTime(prpLinterRecaseRequestDto.getAuditRecaseTime(),DateTime.YEAR_TO_SECOND).toString());
			
			nextSwfLogDto.setMedicalTransitFlag("1");//���ô�ϵͳ���ݱ�־��1Ϊ��ϵͳ�������������ݣ��ղ�Ϊ��ϵͳ�Ľ�������
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
			  
			swfPathLogList.add(swfPathLogDtoTemp );
			//6.���������ӷ�ʽ����Ϊ��̨���ݱ������Դ��
			workFlowDto.setSubmit( true);
			workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogList );
			workFlowDto.setSubmitSwfLogDtoList(nextList );
     
			//uiRecaseAction.save(reCaseDto, workFlowDto);
			//�������ݿ�������
		    DBManager dbManager = new DBManager();
		    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			try {
				//��ʼ����
				dbManager.beginTransaction();
				new BLReCaseAction().save(dbManager,reCaseDto);
				new DBPrpLcertifyDirect(dbManager).insertAll(prpLcertifyDirectDtoList);
				if (workFlowDto!=null){
					new BLWorkFlowAction().deal(dbManager,workFlowDto);
				}
				prpLinterRecaseDetailDto.setId(prpLinterRecaseRequestDto.getId());
				prpLinterRecaseDetailDto.setPolicyNo(prpLinterRecaseRequestDto.getPolicyno());
				prpLinterRecaseDetailDto.setRegistNo(prpLinterRecaseRequestDto.getRelationRegistNo());
				prpLinterRecaseDetailDto.setClaimNo(prpLclaimDto.getClaimNo());
				prpLinterRecaseDetailDto.setRecaseTime(serialNo);
				prpLinterRecaseDetailDto.setRecaseSuccFlag("1");
				prpLinterRecaseDetailDto.setRemark("�ؿ�����ɹ���"+prpLclaimDto.getClaimNo());
				blPrpLinterRecaseDetailAction.insert(dbManager, prpLinterRecaseDetailDto);
				
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
						throw new Exception(msg);
				}
				
				prpLinterRecaseRequestDto.setPrpLinterRecaseDetailDto(prpLinterRecaseDetailDto);
				//�ύ����
				dbManager.commitTransaction();
			} catch (Exception e) {
				e.printStackTrace();
				 //�ع�����
			    dbManager.rollbackTransaction();
			    throw e;
			}finally{
				//�ر����ݿ�����
			    dbManager.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		    throw e;
		}
		return prpLinterRecaseRequestDto;
	}
}
