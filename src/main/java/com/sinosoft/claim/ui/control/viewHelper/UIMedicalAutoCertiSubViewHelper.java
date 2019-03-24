package com.sinosoft.claim.ui.control.viewHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.action.custom.BLCertifyAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrpLqualityCheckDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyDirect;
import com.sinosoft.claim.ui.control.action.UICertifyAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��֤��
 */
public class UIMedicalAutoCertiSubViewHelper {
	/**
	 * ��֤�����߼�
	 * @param prpLinterRequestDto
	 * @return
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoCerti (PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		
		CertifyDto certifyDto = new CertifyDto();
		PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = 
			prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
		
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
				prpLinterRequestDto.getPolicyno(),
				prpLinterRequestDto.getDamageStartDate().toString(), 
				prpLinterRequestDto.getDamageStartHour());
		String riskCode = policyDto.getPrpCmainDto().getRiskCode();
		UserDto user = new UserDto();
		String compeUser = prpLinterRequestDto.getCompeUser();
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
		PrpDuserDto prpDuserDto = blPrpDuserFacade.findByPrimaryKey(compeUser);
		String compeName = "";
		if(prpDuserDto!=null){
			compeName = prpDuserDto.getUserName();
		}
		user.setUserCode(compeUser);
		user.setUserName(compeName);
		user.setComCode(prpLinterRequestDto.getMakeCom());
		user.setComName(prpLinterRequestDto.getMakeComName());
		try{
			UICertifyAction uiCertifyAction = new UICertifyAction();
			
			PrpLcertifyCollectDto prpLcertifyCollectDto = new PrpLcertifyCollectDto();
		    prpLcertifyCollectDto.setBusinessNo(prpLinterRequestDto.getRelationRegistNo());
		    prpLcertifyCollectDto.setLossItemCode("1");
		    prpLcertifyCollectDto.setLossItemName("�������");
		    prpLcertifyCollectDto.setPicCount(0);
		    prpLcertifyCollectDto.setStartDate(prpLinterRequestDto.getDamageStartDate());
		    String[] startHours = prpLinterRequestDto.getDamageStartHour().split(":");
		    prpLcertifyCollectDto.setStartHour(startHours[0]);
		    prpLcertifyCollectDto.setEndDate(prpLinterRequestDto.getDamageStartDate());
		    prpLcertifyCollectDto.setEndHour(startHours[0]);
		    prpLcertifyCollectDto.setOperatorCode(compeUser);
		    prpLcertifyCollectDto.setCaseFlag("0000");
//		    prpLcertifyCollectDto.setFlag("");
		    prpLcertifyCollectDto.setUploadYear((prpLinterRequestDto.getDamageStartDate().getYear()+"").trim());
		    prpLcertifyCollectDto.setRiskCode(riskCode); 
//		    prpLcertifyCollectDto.setCltInsureCarFlag("");
//		    prpLcertifyCollectDto.setCltPersonFlag("");
//		    prpLcertifyCollectDto.setCltPropFlag("");
//		    prpLcertifyCollectDto.setCltCarLossFlag("");
//		    prpLcertifyCollectDto.setCltAllLossFlag("");
		    prpLcertifyCollectDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
//		    prpLcertifyCollectDto.setCollectFlag("");
//		    prpLcertifyCollectDto.setCltInsureCarFlag("");
//		    prpLcertifyCollectDto.setCompelFlag("");
		    prpLcertifyCollectDto.setContent(prpLinterRequestDto.getCertifyContext());
		    certifyDto.setPrpLcertifyCollectDto(prpLcertifyCollectDto);
		
		    /*---------------------״̬����prpLclaimStatus------------------------------------*/
		    PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
		    prpLclaimStatusDto.setStatus("4");
		    prpLclaimStatusDto.setBusinessNo(prpLinterRequestDto.getRelationRegistNo());
		    prpLclaimStatusDto.setPolicyNo(prpLcertifyCollectDto.getPolicyNo());
		    prpLclaimStatusDto.setNodeType("certi");
		    prpLclaimStatusDto.setRiskCode(riskCode);
		    //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��ʵ����
		    prpLclaimStatusDto.setHandlerCode(compeUser);
		    prpLclaimStatusDto.setInputDate(new DateTime(prpLinterRequestDto.getCompeTime(),DateTime.YEAR_TO_DAY));
		    prpLclaimStatusDto.setOperateDate(new DateTime(prpLinterRequestDto.getCompeTime(),DateTime.YEAR_TO_DAY));
		    certifyDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
		    
		    /*---------------------������������prpLqualityCheckDto------------------------------------*/
		    ArrayList<PrpLqualityCheckDto> prpLqualityCheckDtoList = new ArrayList<PrpLqualityCheckDto>();
		    UICodeAction uiCodeAction = new UICodeAction();
		    Collection collectionC = uiCodeAction.getCodeType ("CertiQuality", riskCode);
		    if(collectionC == null || collectionC.size()<1){
				throw new Exception("û��������������");
			}
		    PrpLqualityCheckDto prpLqualityCheckDto = null;
		    Iterator it = collectionC.iterator();
			for(int i=0,j=0;i<collectionC.size();i++){
		    	PrpDcodeDto prpDcodeDto = (PrpDcodeDto)it.next();
		    	if(!"1010".equals(prpDcodeDto.getCodeCode())){
		    		prpLqualityCheckDto = new PrpLqualityCheckDto();
		    		prpLqualityCheckDto.setRegistNo(prpLinterRequestDto.getRelationRegistNo());
					prpLqualityCheckDto.setQualityCheckType("certi");
					prpLqualityCheckDto.setSerialNo(j+1);j++;
					prpLqualityCheckDto.setTypeName(prpDcodeDto.getCodeCName());
					prpLqualityCheckDto.setTypeCode(prpDcodeDto.getCodeCode());
					prpLqualityCheckDtoList.add(prpLqualityCheckDto);
		    	}
		    }
			certifyDto.setPrpLqualityCheckList(prpLqualityCheckDtoList);
			
			/*---------------------PrpLcertifyDirectDto------------------------------------*/
			ArrayList<PrpLcertifyDirectDto> prpLcertifyDirectDtoList = new ArrayList<PrpLcertifyDirectDto>();
			PrpLinterCertifyDto[] prpLinterCertifyDtoList = prpLinterRequestDto.getPrpLinterCertifyDto();
			PrpLcertifyDirectDto prpLcertifyDirectDto = null;
			if(prpLinterCertifyDtoList!=null && prpLinterCertifyDtoList.length>0){
				for(int i=0;i<prpLinterCertifyDtoList.length;i++){
					prpLcertifyDirectDto = new PrpLcertifyDirectDto();
					prpLcertifyDirectDto.setRegistNo(prpLinterRequestDto.getRelationRegistNo());
					prpLcertifyDirectDto.setSerialNo(i + 1);
					prpLcertifyDirectDto.setRiskCode(riskCode);
					prpLcertifyDirectDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
					prpLcertifyDirectDto.setLossItemCode("1");
					prpLcertifyDirectDto.setTypeCode(prpLinterCertifyDtoList[i].getTypeCode());
					prpLcertifyDirectDto.setTypeName(prpLinterCertifyDtoList[i].getTypeName());
					prpLcertifyDirectDto.setColumnValue("columevaue");
					prpLcertifyDirectDtoList.add(prpLcertifyDirectDto);
				}
			}
			certifyDto.setPrpLcertifyDirectDtoList(prpLcertifyDirectDtoList);
			
			String registNo = prpLinterRequestDto.getRelationRegistNo();
			SwfLogDto swflogDto = new SwfLogDto();
			ArrayList<SwfLogDto> swflogArray  = (ArrayList<SwfLogDto>) new UIWorkFlowAction().findNodesByConditions(" registno='"+registNo+"' and nodetype='certi' and nodestatus='0' ");
//			Collection collection = new UIWorkFlowAction().findNodesByConditions(" registno='"+registNo+"' and nodetype='certi' and nodestatus='0' ");
//			if(collection == null || collection.size()<1){
//				throw new Exception("�޿ɴ���֤�ڵ�");
//			}
			//�ж��Ƿ���δ����ĵ�֤�ڵ���Ҫ�������û�е�֤�ڵ��账��ֱ���׳��쳣
			if(swflogArray!=null&&!swflogArray.isEmpty()&&swflogArray.size()>0){
				swflogDto = swflogArray.get(0);
			}else {
				throw new Exception("�޿ɴ���֤�ڵ�");
			}
//			collection.iterator().next();
//			SwfLogDto swflogDto = (SwfLogDto)collection.iterator().next();
		    String claimNo = uiCodeAction.translateBusinessCode(certifyDto.getPrpLclaimStatusDto().getBusinessNo(),true);
			swflogDto.setNextBusinessNo(claimNo);
			
			swflogDto.setKeyIn(prpLinterRequestDto.getRelationRegistNo());
	        swflogDto.setKeyOut(prpLinterRequestDto.getRelationRegistNo());
			swflogDto.setNodeStatus("4");
			
			ArrayList<SwfLogDto> swflogList = new ArrayList<SwfLogDto>();
			SwfLogDto nextSwflog = new SwfLogDto();
			nextSwflog.setHandlerCode(user.getUserCode());
			nextSwflog.setHandlerName(user.getUserName());
			nextSwflog.setNodeType("compe");
			swflogList.add(nextSwflog);
			
			if (swflogList.size() >0){
				swflogDto.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
				swflogDto.setSwfLogList(swflogList);
		    }
			
			//��¼���̹켣��-��֤���ڳɹ���־
			prplinterAutoClaimDetailDto.setCertiSuccFlag("1");
			prplinterAutoClaimDetailDto.setRemark("��֤�ɹ���"+registNo);
			new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			
			DBManager dbManager = new DBManager();
			try {
				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
				dbManager.beginTransaction();
				//���¼�¼
				this.savePrpLcertifyDirect(dbManager, certifyDto);
				WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
				workFlowViewHelper.viewToDto(user,swflogDto);
				WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swflogDto);
				/***********************add ��ϵͳ��־***********************/
				//���Ӵ�ϵͳ��־medicaltransitflag
				Collection submitSwfLogDtoList = workFlowDto.getSubmitSwfLogDtoList();
				Iterator iter = submitSwfLogDtoList.iterator();
				ArrayList submitListTemp = new ArrayList();
				while(iter.hasNext()){
					SwfLogDto swfLogDto = (SwfLogDto)iter.next();
					swfLogDto.setMedicalTransitFlag("1");
					submitListTemp.add(swfLogDto);
				}
				workFlowDto.setSubmitSwfLogDtoList(submitListTemp);
				SwfLogDto updateSwfLogDto = workFlowDto.getUpdateSwfLogDto();
				updateSwfLogDto.setMedicalTransitFlag("1");
				workFlowDto.setUpdateSwfLogDto(updateSwfLogDto);
				/*************************end****************/
				certifyDto.setNodeType("certi");
				new BLCertifyAction().save(dbManager,certifyDto);
			    if(workFlowDto!=null){
			        new BLWorkFlowAction().deal(dbManager,workFlowDto);
			    }
				dbManager.commitTransaction();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}finally{
	            dbManager.close();
	        }
			
			String sqlCerti = " Update swflog Set  submittime='"+prpLinterRequestDto.getCompeTime()
                                               +"' Where registno ='"+registNo+"' and nodeType ='certi'";
			String sqlCompe = " Update swflog Set Flowintime='"+prpLinterRequestDto.getCompeTime()
									            +"',handletime='"+prpLinterRequestDto.getCompeTime()
									            +"' Where registno ='"+registNo+"' and nodeType ='compe'";
			new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlCerti);
			new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlCompe);
		}catch (Exception e) {
			prplinterAutoClaimDetailDto.setCertiSuccFlag("0");
			String messege = e.toString();
			if(messege!=null&&messege.length()>1000){
				messege = messege.substring(0,1000);
			}
			prplinterAutoClaimDetailDto.setRemark("��֤ʧ�ܣ�"+messege);
			new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			e.printStackTrace();
			throw e;
		}
		return prpLinterRequestDto;
	}
	
	/**
	 * ����PrpLcertifyDirect��
	 * @param dbManager��certifyDto
	 * @return
	 * @throws SQLException,Exception
	 */
	public void savePrpLcertifyDirect(DBManager dbManager,CertifyDto certifyDto)
	throws SQLException,Exception{
		//���������嵥
	    String condition = " registNo = " + "'" + certifyDto.getPrpLcertifyCollectDto().getBusinessNo().trim() + "'";
	    //ʾ��δ���
	    String statement = "";
	    statement = " DELETE FROM PrpLcertifyDirect Where " + condition;
	    dbManager.executeUpdate(statement);
	    if (certifyDto.getPrpLcertifyDirectDtoList() != null) {
	      new DBPrpLcertifyDirect(dbManager).insertAll(certifyDto.getPrpLcertifyDirectDtoList());
	    }
    }
	
	
}
