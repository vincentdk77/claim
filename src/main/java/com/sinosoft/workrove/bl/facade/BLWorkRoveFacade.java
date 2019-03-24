package com.sinosoft.workrove.bl.facade;

import java.sql.SQLException;
import java.util.*;

import com.sinosoft.platform.bl.facade.BLPrpDuserFacade;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.reference.*;
import com.sinosoft.workrove.bl.action.custom.BLWorkRoveAction;
import com.sinosoft.workrove.dto.formbean.WorkRoveDto;
import com.sinosoft.workrove.dto.formbean.WorkRoveForm;
import com.sinosoft.claim.bl.action.custom.*;
import com.sinosoft.claim.bl.action.domain.*;
import com.sinosoft.claim.dto.custom.*;
import com.sinosoft.claim.dto.domain.PrpLcertainLossDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;

/**
 *  �����߼��ַ�
 * <p>Title: �������ⶨ��</p>
 * <p>Description: �������ⶨ��facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLWorkRoveFacade {
	/**
	 * ���涨��
	 * @param certainLossDto���Զ��嶨�����
	 * @throws SQLException
	 * @throws Exception
	 */
	public void save(WorkRoveDto workRoveDto) throws SQLException, Exception {
		//�������ݿ�������
		DBManager dbManager = new DBManager();
		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		//��ʼ����
		dbManager.beginTransaction();
		try {
			new BLWorkRoveAction().save(dbManager, workRoveDto);
			//�ύ����
			dbManager.commitTransaction();
		} catch (SQLException sqle) {
			//�ع�����
			dbManager.rollbackTransaction();
			throw sqle;
		} catch (Exception ex) {
			//�ع�����
			dbManager.rollbackTransaction();
			throw ex;
		} finally {
			//�ر����ݿ�����
			dbManager.close();
		}
	}

	/**
	 * ���涨���������
	 * @param certainLossDto���Զ��嶨�����
	 * @throws SQLException
	 * @throws Exception
	 */
	public void save(WorkRoveDto workRoveDto, WorkFlowDto workFlowDto)
			throws SQLException, Exception {
		//�������ݿ�������
		DBManager dbManager = new DBManager();
		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		//��ʼ����
		dbManager.beginTransaction();
		try {
			new BLWorkRoveAction().save(dbManager, workRoveDto);
			if (workFlowDto != null) {
				new BLWorkFlowAction().deal(dbManager, workFlowDto);
			}
			//�ύ����
			dbManager.commitTransaction();
		} catch (SQLException sqle) {
			//�ع�����
			dbManager.rollbackTransaction();
			throw sqle;
		} catch (Exception ex) {
			//�ع�����
			dbManager.rollbackTransaction();
			throw ex;
		} finally {
			//�ر����ݿ�����
			dbManager.close();
		}
	}

	public void updateSwflogForCerta(WorkRoveForm workRoveForm) throws Exception {
		// TODO Auto-generated method stub
		if(null!=workRoveForm && null!=workRoveForm.getHandleCode() && !"".equals(workRoveForm.getHandleCode())){
			BLSwfLogFacade 		swfLogFacade 		= new BLSwfLogFacade();
			SwfLogDto 			swfLogDtoCerta 	= new SwfLogDto();
			String 				swfLogFlowID 		= workRoveForm.getSwfLogFlowID();
			BLPrpDuserFacade 	prpDuserFacade 		= new BLPrpDuserFacade();
			
			ArrayList swflogList = (ArrayList) swfLogFacade.findByConditions(" flowid='"+swfLogFlowID+"' and nodetype='certa' ");
			if(swflogList.size()>0){
				Iterator ite = swflogList.iterator();
				swfLogDtoCerta = (SwfLogDto) ite.next();
				if(null!=swfLogDtoCerta){
					//����ڵ��Ѿ�����ռ�У������д���
					if(null!=swfLogDtoCerta.getHandlerCode()&&!"".equals(swfLogDtoCerta.getHandlerCode().trim())){
						
					}else{
						//ȡת����Ա���ڲ��ţ����û��ת����Ա��ȡת��������
						if(null!=workRoveForm.getHandleCode() &&!"".equals(workRoveForm.getHandleCode())){
							swfLogDtoCerta.setHandleDept(workRoveForm.getHandleCode());
						}
					}
					
					new BLSwfLogFacade().update(swfLogDtoCerta);
				}
			}
		}
	}

}
