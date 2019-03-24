package com.sinosoft.workrove.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcarLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcomponent;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLperson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonWound;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleItem;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprop;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrepairFee;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleMainWF;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdParty;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdProp;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLossExt;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.workrove.dto.formbean.WorkRoveDto;

/**
 * �������ݿ�������
 * <p>
 * Title: �������ⶨ�����ݹ���
 * </p>
 * <p>
 * Description: �������ⶨ�����ݹ���
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class DBWorkRove {
	/**
	 * ���𱣴淽��
	 * 
	 * @param certainLossDto
	 *            �������
	 * @throws SQLException
	 * @throws Exception
	 * @return ��
	 */
	public void insert(DBManager dbManager, WorkRoveDto workRoveDto)
			throws SQLException, Exception {

		String registNo = workRoveDto.getRegistNo();
		// ����ɾ��ԭ�����������
		deleteSubInfo(dbManager, registNo);
		
		//1 ������ϸ��
		if(workRoveDto.getPrpLscheduleItemDto()!=null){
			new DBPrpLscheduleItem(dbManager).delete(workRoveDto.getPrpLscheduleItemDto().getScheduleID(), workRoveDto.getPrpLscheduleItemDto().getRegistNo(), workRoveDto.getPrpLscheduleItemDto().getItemNo());
			new DBPrpLscheduleItem(dbManager).insert(workRoveDto.getPrpLscheduleItemDto());
		}
		//2
		if(workRoveDto.getPrpLscheduleMainWFDto()!=null){
			new DBPrpLscheduleMainWF(dbManager).update(workRoveDto.getPrpLscheduleMainWFDto());
		}
	}

	/**
	 * ����ɾ���ӱ���Ϣ
	 * 
	 * @param registNo
	 *            //������
	 * @throws SQLException
	 * @throws Exception
	 */
	private void deleteSubInfo(DBManager dbManager,String  registNo) throws SQLException, Exception {

		// ɾ���鿱�����Ϣ
		//String statement = "registNo = '"+registNo.trim()+"'";
		String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'";
		String condition2 = " registNo = '" + StringUtils.rightTrim(registNo) + "' and nodetype ='check'";
		String statement = ""; //ʾ��δ���

			//�鿱��ɾ�������ӱ�(���⽡����һ�㶼�ǲ鿱)
			
			statement =  " DELETE FROM prpLcompensateEar Where " + condition2;
			dbManager.executeUpdate(statement);
			
			//statement =  " DELETE FROM PrpLregistExt Where " + condition;
			//dbManager.executeUpdate(statement);
			statement = " DELETE FROM PrpLregistText Where " + condition +" and (TextType = '3' or TextType='07')";
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM PrpLcheckExt Where " + condition;
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM PrpLcheckLoss Where " + condition;
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM PrpLcheck Where " + condition;
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM prpLprop Where " + condition;
			dbManager.executeUpdate(statement);
			
			statement = " DELETE FROM prpLverifyloss Where " + condition;
			dbManager.executeUpdate(statement);
		
	}

	/**
	 * �������Ĳ���״̬�ķ���
	 * 
	 * @param certainLossDto
	 *            ��������
	 * @throws SQLException
	 * @throws Exception
	 * @return ��
	 */
	public void updateClaimStatus(DBManager dbManager,
			CertainLossDto certainLossDto) throws SQLException, Exception {
		// ʾ��δ���
		String statement = "";
		if (certainLossDto.getPrpLclaimStatusDto() != null) {
			String condition3 = " BusinessNo='"
					+ certainLossDto.getPrpLclaimStatusDto().getBusinessNo()
							.trim() + "' "
					+ " AND NodeType ='certa' and serialNo="
					+ certainLossDto.getPrpLclaimStatusDto().getSerialNo();
			statement = " DELETE FROM prpLclaimStatus Where " + condition3;
			dbManager.executeUpdate(statement);
			new DBPrpLclaimStatus(dbManager).insert(certainLossDto
					.getPrpLclaimStatusDto());
		}
	}

}
