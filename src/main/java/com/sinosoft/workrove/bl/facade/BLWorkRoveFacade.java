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
 *  定损逻辑分发
 * <p>Title: 车险理赔定损</p>
 * <p>Description: 车险理赔定损facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLWorkRoveFacade {
	/**
	 * 保存定损
	 * @param certainLossDto：自定义定损对象
	 * @throws SQLException
	 * @throws Exception
	 */
	public void save(WorkRoveDto workRoveDto) throws SQLException, Exception {
		//创建数据库管理对象
		DBManager dbManager = new DBManager();
		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		//开始事务
		dbManager.beginTransaction();
		try {
			new BLWorkRoveAction().save(dbManager, workRoveDto);
			//提交事务
			dbManager.commitTransaction();
		} catch (SQLException sqle) {
			//回滚事务
			dbManager.rollbackTransaction();
			throw sqle;
		} catch (Exception ex) {
			//回滚事务
			dbManager.rollbackTransaction();
			throw ex;
		} finally {
			//关闭数据库连接
			dbManager.close();
		}
	}

	/**
	 * 保存定损带工作流
	 * @param certainLossDto：自定义定损对象
	 * @throws SQLException
	 * @throws Exception
	 */
	public void save(WorkRoveDto workRoveDto, WorkFlowDto workFlowDto)
			throws SQLException, Exception {
		//创建数据库管理对象
		DBManager dbManager = new DBManager();
		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		//开始事务
		dbManager.beginTransaction();
		try {
			new BLWorkRoveAction().save(dbManager, workRoveDto);
			if (workFlowDto != null) {
				new BLWorkFlowAction().deal(dbManager, workFlowDto);
			}
			//提交事务
			dbManager.commitTransaction();
		} catch (SQLException sqle) {
			//回滚事务
			dbManager.rollbackTransaction();
			throw sqle;
		} catch (Exception ex) {
			//回滚事务
			dbManager.rollbackTransaction();
			throw ex;
		} finally {
			//关闭数据库连接
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
					//定损节点已经有人占有，不进行处理
					if(null!=swfLogDtoCerta.getHandlerCode()&&!"".equals(swfLogDtoCerta.getHandlerCode().trim())){
						
					}else{
						//取转交人员所在部门，如果没有转交人员，取转交受理部门
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
