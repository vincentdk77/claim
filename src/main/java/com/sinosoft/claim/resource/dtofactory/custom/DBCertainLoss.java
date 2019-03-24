package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.gyic.claim.resource.dtofactory.domain.DBPrplcompensateear;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcarLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcomponent;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLperson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonWound;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprop;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrepairFee;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdParty;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdProp;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLossExt;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehouse;

/**
 * �������ݿ�������
 * <p>Title: �������ⶨ�����ݹ���</p>
 * <p>Description: �������ⶨ�����ݹ���</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBCertainLoss {
	/**
	 * ���𱣴淽��
	 *@param certainLossDto �������
	 * @throws SQLException
	 * @throws Exception
	 *@return ��
	 */
	public void insert(DBManager dbManager, CertainLossDto certainLossDto) throws SQLException, Exception {

		if (certainLossDto.getPrpLverifyLossDto() == null) {
			throw new Exception();
		}
		//�������� �ؼ���
		PrpLverifyLossDto prpLverifyLossDto = certainLossDto.getPrpLverifyLossDto();
	    String registNo = prpLverifyLossDto.getRegistNo();
		String lossItemCode = prpLverifyLossDto.getLossItemCode();
		//����ɾ��ԭ�����������
		deleteSubInfo(dbManager, registNo, lossItemCode);
		//new DBPrpLverifyLoss(dbManager).insert(certainLossDto.getPrpLverifyLossDto());
		//modify by zhaolu 20060809 start
		//reason:�ڶ����м������߳��ĳ��ƺ�
        //��Ԫ��Ŀ�����ũ�յ�lossItemCode��ȡֵ ��ʼ
		if(lossItemCode=="" || lossItemCode== null){
			lossItemCode="-2";
		}
        //��Ԫ��Ŀ�����ũ�յ�lossItemCode��ȡֵ ����
		if( Integer.parseInt(lossItemCode)>= 2 )
		{
			prpLverifyLossDto.setLossItemName(certainLossDto.getPrpLthirdPartyDto().getLicenseNo());
			prpLverifyLossDto.setLicenseNo(certainLossDto.getPrpLthirdPartyDto().getLicenseNo());
		}
		if( lossItemCode.equals("0") )
			prpLverifyLossDto.setLossItemName("����");
		if( lossItemCode.equals("-1") )
			prpLverifyLossDto.setLossItemName("�Ʋ�");
		new DBPrpLverifyLoss(dbManager).insert(certainLossDto.getPrpLverifyLossDto());
        //modify by zhaolu 20060809 end
       
		//��������
		if (certainLossDto.getPrpLcarLossDtoList() != null) {
			new DBPrpLcarLoss(dbManager).insertAll(certainLossDto.getPrpLcarLossDtoList());
		}
		//��������嵥
		if (certainLossDto.getPrpLrepairFeeDtoList() != null) {
			new DBPrpLrepairFee(dbManager).insertAll(certainLossDto.getPrpLrepairFeeDtoList());
		}
		//������Ŀ�嵥
		if (certainLossDto.getPrpLcomponentDtoList() != null) {
			new DBPrpLcomponent(dbManager).insertAll(certainLossDto.getPrpLcomponentDtoList());
		}
		//��������չ��Ϣ 
		if (certainLossDto.getPrpLverifyLossExtDtoList() != null) {
			new DBPrpLverifyLossExt(dbManager).insertAll(certainLossDto.getPrpLverifyLossExtDtoList());
		}
		//��չ��Ϣ 
		if (certainLossDto.getPrpLregistExtDtoList() != null) {
			new DBPrpLregistExt(dbManager).insertAll(certainLossDto.getPrpLregistExtDtoList());
		}
		//��Ա������ϸ��Ϣ��
		if (certainLossDto.getPrpLpersonDtoList() != null) {
			new DBPrpLperson(dbManager).insertAll(certainLossDto.getPrpLpersonDtoList());
		}

		//�Ʋ��˶�����ϸ�嵥��
		if (certainLossDto.getPrpLpropDtoList() != null) {
			new DBPrpLprop(dbManager).insertAll(certainLossDto.getPrpLpropDtoList());
		}
		//���������ı�
		/*
		 if(certainLossDto.getPrpLverifyLossItemDtoList()!=null&&certainLossDto.getPrpLverifyLossItemDtoList().size()>0){
		 new DBPrpLverifyLossItem(dbManager).insertAll(certainLossDto.getPrpLverifyLossItemDtoList());
		 }*/
		//������Ϣ��
		if (certainLossDto.getPrpLpersonWoundDtoList() != null && certainLossDto.getPrpLpersonWoundDtoList().size() > 0) {
			new DBPrpLpersonWound(dbManager).insertAll(certainLossDto.getPrpLpersonWoundDtoList());
		}
		//modify by liuyanmei add start 20051215 reason�������永�������޸ģ��豣�����߳�����Ϣ
		if (certainLossDto.getPrpLthirdPartyDto() != null) {
			String thirdPartyRegistNo = certainLossDto.getPrpLthirdPartyDto().getRegistNo();
			int thirdPartySerialNo = certainLossDto.getPrpLthirdPartyDto().getSerialNo();
			new DBPrpLthirdParty(dbManager).delete(thirdPartyRegistNo, thirdPartySerialNo);
			new DBPrpLthirdParty(dbManager).insert(certainLossDto.getPrpLthirdPartyDto());
		}
		//�������ʧ�嵥����
		if (certainLossDto.getPrplCompensateEarDtoList() != null && certainLossDto.getPrplCompensateEarDtoList().size() > 0) {
			new DBPrplcompensateear(dbManager).insertAll(certainLossDto.getPrplCompensateEarDtoList());
		}
		//0310�嵥����
		//System.err.println("PrplCompensateHouseDtoList1:" + certainLossDto.getPrplCompensateHouseDtoList().size());
		if (certainLossDto.getPrplCompensateHouseDtoList()!= null && certainLossDto.getPrplCompensateHouseDtoList().size() > 0) {
			PrplcompensatehouseDto PrplcompensatehouseDto = (PrplcompensatehouseDto)certainLossDto.getPrplCompensateHouseDtoList().get(0);
			String registno = PrplcompensatehouseDto.getRegistno();
			String nodetype = PrplcompensatehouseDto.getNodetype();
			String condition = " registno='" + registno + "' and nodetype='" + nodetype + "'";
			new DBPrplcompensatehouse(dbManager).deleteByConditions(condition);
			new DBPrplcompensatehouse(dbManager).insertAll(certainLossDto.getPrplCompensateHouseDtoList());
		}
		//modify by liuyanmei add end 20051215 reason�������永�������޸ģ��豣�����߳�����Ϣ    
		//����״̬�ĸı�
		updateClaimStatus(dbManager, certainLossDto);
		/**
		 * modify by mengdongdong at 20060411
		 * �����ʱ�������¸�������������
		 */
		//����������������Ϣ
		//updateSumClaim(dbManager,certainLossDto);
	}

	/**
	 * ����ɾ���ӱ���Ϣ
	 * @param registNo //������
	 * @throws SQLException
	 * @throws Exception
	 */
	private void deleteSubInfo(DBManager dbManager, String registNo, String lossItemCode) throws SQLException,
			Exception {

		String condition = " registNo = " + "'" + registNo.trim() + "'";
		//ʾ��δ���
		String statement = "";
		//ɾ����������չ��Ϣ 
		String condition1 = " registNo = " + "'" + registNo.trim() + "' and  lossItemCode = '" + lossItemCode.trim()
				+ "'";
		statement = " DELETE FROM PrpLverifyLossExt Where " + condition1;
		dbManager.executeUpdate(statement);
		
		//ɾ����չ��Ϣ 
		statement = " DELETE FROM PrpLregistExt Where " + condition;
		dbManager.executeUpdate(statement);
		
		statement = " DELETE FROM prplCompensateEar Where " + condition +" and nodeType = 'certa'";
		dbManager.executeUpdate(statement);

		int i = Integer.parseInt(DataUtils.nullToZero(lossItemCode));
		if (i > 0) {
			//condition = condition + " and LossItemCode='"+lossItemCode+"'";
			//��������嵥
			statement = " DELETE FROM prpLrepairFee Where " + condition + " and LossItemCode='" + lossItemCode + "'";
			dbManager.executeUpdate(statement);
			//������Ŀ�嵥
			statement = " DELETE FROM prpLcomponent Where " + condition + " and LossItemCode='" + lossItemCode + "'";
			dbManager.executeUpdate(statement);
			//��������
			statement = " DELETE FROM prpLcarLoss Where " + condition + " and LossItemCode='" + lossItemCode + "'";
			dbManager.executeUpdate(statement);
		} else if (i == 0) {
			//��Ա������ϸ��Ϣ
			statement = " DELETE FROM prpLperson Where " + condition;
			dbManager.executeUpdate(statement);
//			������Ϣ��
			statement = " DELETE FROM PrpLpersonWound Where " + condition;
			dbManager.executeUpdate(statement);

		} else if (i == -1) {
			//�Ʋ��˶�����ϸ
			statement = " DELETE FROM prpLprop Where " + condition;
			dbManager.executeUpdate(statement);
		} 
		//����ũ�ղƲ��˶�����ϸ
		//modify by kangzhen
		else if (i == -2) {
			statement = " DELETE FROM prpLprop Where " + condition;
			dbManager.executeUpdate(statement);
		}

		
		condition = condition + " and LossItemCode='" + lossItemCode + "'";
		statement = " DELETE FROM PrpLverifyLoss Where " + condition;
		dbManager.executeUpdate(statement);
		
	}

	/**
	 * ����ɾ��
	 * @param certainLossNo
	 * @throws SQLException
	 * @throws Exception
	 */
	public void delete(DBManager dbManager, String registNo) throws SQLException, Exception {
		String condition = " registNo = " + "'" + registNo.trim() + "'";
		String condition1 = " businessNo = " + "'" + registNo.trim() + "' AND NodeType ='certa'";
		//ʾ��δ���
		String statement = "";
		//��������嵥
		statement = " DELETE FROM prpLrepairFee Where " + condition;
		dbManager.executeUpdate(statement);
		//������Ŀ�嵥
		statement = " DELETE FROM prpLcomponent Where " + condition;
		dbManager.executeUpdate(statement);
		//��Ա������ϸ��Ϣ
		statement = " DELETE FROM prpLperson Where " + condition;
		dbManager.executeUpdate(statement);
		//�Ʋ��˶�����ϸ
		statement = " DELETE FROM prpLprop Where " + condition;
		dbManager.executeUpdate(statement);
		//��������
		statement = " DELETE FROM prpLcarLoss Where " + condition;
		dbManager.executeUpdate(statement);
		//������Ϣ��
		statement = " DELETE FROM PrpLpersonWound Where " + condition;
		dbManager.executeUpdate(statement);

		//״̬
		statement = " DELETE FROM prplclaimstatus Where " + condition1;
		dbManager.executeUpdate(statement);
		//��������
		statement = " DELETE FROM PrpLverifyLoss Where " + condition;
		dbManager.executeUpdate(statement);

	}

	/*
	 * �����ѯ����
	 *@param certainLossDto �������
	 * @throws SQLException
	 * @throws Exception
	 *@return ��
	 */

	public CertainLossDto findByPrimaryKey(DBManager dbManager, String registNo) throws SQLException, Exception {

		String conditions = " registNo = '" + registNo + "'";
		String conditions1 = " registNo = '" + registNo + "' order by personNo";
		CertainLossDto certainLossDto = new CertainLossDto();
		//certainLossDto.setPrpLverifyLossItemDtoList((ArrayList)new DBPrpLverifyLossItem(dbManager).findByConditions(conditions,0,0));
		certainLossDto.setPrpLverifyLossDtoList((ArrayList) new DBPrpLverifyLoss(dbManager).findByConditions(
				conditions, 0, 0));
		//certainLossDto.setPrpLverifyLossDto(new DBPrpLverifyLoss(dbManager).findByPrimaryKey(registNo,"1"));
		certainLossDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(registNo, "certa", 0));
		certainLossDto.setPrpLcarLossDtoList((ArrayList) new DBPrpLcarLoss(dbManager)
				.findByConditions(conditions, 0, 0));
		certainLossDto.setPrpLcomponentDtoList((ArrayList) new DBPrpLcomponent(dbManager).findByConditions(conditions,
				0, 0));
		certainLossDto.setPrpLpersonDtoList((ArrayList) new DBPrpLperson(dbManager).findByConditions(conditions1, 0, 0));
		certainLossDto.setPrpLpropDtoList((ArrayList) new DBPrpLprop(dbManager).findByConditions(conditions, 0, 0));
		certainLossDto.setPrpLrepairFeeDtoList((ArrayList) new DBPrpLrepairFee(dbManager).findByConditions(conditions,
				0, 0));
		certainLossDto.setPrpLpersonWoundDtoList((ArrayList) new DBPrpLpersonWound(dbManager).findByConditions(
				conditions, 0, 0));
		certainLossDto.setPrpLverifyLossExtDtoList((ArrayList) new DBPrpLverifyLossExt(dbManager).findByConditions(
				conditions, 0, 0));
		certainLossDto.setPrpLregistExtDtoList((ArrayList) new DBPrpLregistExt(dbManager).findByConditions(conditions,
				0, 0));
		certainLossDto.setPrpLthirdPartyDtoList((ArrayList) new DBPrpLthirdParty(dbManager).findByConditions(
				conditions, 0, 0));
		return certainLossDto;
	}

	/**
	 * �������Ĳ���״̬�ķ���
	 *@param certainLossDto ��������
	 * @throws SQLException
	 * @throws Exception
	 *@return ��
	 */
	public void updateClaimStatus(DBManager dbManager, CertainLossDto certainLossDto) throws SQLException, Exception {
		//ʾ��δ���
		String statement = "";
		if (certainLossDto.getPrpLclaimStatusDto() != null) {
			String condition3 = " BusinessNo='" + certainLossDto.getPrpLclaimStatusDto().getBusinessNo().trim() + "' "
					+ " AND NodeType ='certa' and serialNo=" + certainLossDto.getPrpLclaimStatusDto().getSerialNo();
			statement = " DELETE FROM prpLclaimStatus Where " + condition3;
			dbManager.executeUpdate(statement);
			new DBPrpLclaimStatus(dbManager).insert(certainLossDto.getPrpLclaimStatusDto());
		}
	}

	/*
	 * �����ѯ����
	 *@param certainLossDto �������
	 * @throws SQLException
	 * @throws Exception
	 *@return ��
	 */

	public CertainLossDto findByPrimaryKey(DBManager dbManager, String registNo, String lossItemCode)
			throws SQLException, Exception {
		int intLossItemCode = Integer.parseInt(lossItemCode);
		CertainLossDto certainLossDto = new CertainLossDto();
		UICodeAction uiCodeAction = new UICodeAction();
		String conditions  = " registNo = '" + registNo + "'";
		String conditions1 = " registNo = '" + registNo + "' and lossItemCode = '" + lossItemCode + "'";
		String conditinos2 = " registNo = '" + registNo + "' order by personNo";
		certainLossDto.setPrpLverifyLossDto(new DBPrpLverifyLoss(dbManager).findByPrimaryKey(registNo, lossItemCode));
		certainLossDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(
				registNo, "certa", intLossItemCode));
		certainLossDto.setPrpLpersonDtoList((ArrayList) new DBPrpLperson(dbManager).findByConditions(conditinos2, 0, 0));
		certainLossDto.setPrpLpropDtoList((ArrayList) new DBPrpLprop(dbManager).findByConditions(conditions, 0, 0));
		if (certainLossDto.getPrpLpropDtoList() == null
				|| certainLossDto.getPrpLpropDtoList().size() == 0) {
			ArrayList thirdPropList = (ArrayList) new DBPrpLthirdProp(dbManager).findByConditions(conditions, 0, 0);
			for (int i = 0; i < thirdPropList.size(); i++) {
				PrpLthirdPropDto thirdPropDto = (PrpLthirdPropDto) thirdPropList.get(i);
				PrpLpropDto propDto = new PrpLpropDto();
				propDto.setRegistNo(thirdPropDto.getRegistNo());
				propDto.setRiskCode(thirdPropDto.getRiskCode());
				propDto.setSerialNo(thirdPropDto.getSerialNo());
				propDto.setLossItemCode(thirdPropDto.getLossItemCode());
				propDto.setLossItemName(thirdPropDto.getLossItemName());
				propDto.setFlag(thirdPropDto.getFlag());
				propDto.setRemark(thirdPropDto.getLossItemDesc());
				if (certainLossDto.getPrpLpropDtoList() == null) {
					certainLossDto.setPrpLpropDtoList(new ArrayList());
				}
				certainLossDto.getPrpLpropDtoList().add(propDto);
			}
		}
		certainLossDto.setPrpLpersonWoundDtoList((ArrayList) new DBPrpLpersonWound(dbManager).findByConditions(conditions, 0, 0));
		certainLossDto.setPrpLverifyLossExtDtoList((ArrayList) new DBPrpLverifyLossExt(dbManager).findByConditions(conditions1, 0, 0));
		certainLossDto.setPrpLregistExtDtoList((ArrayList) new DBPrpLregistExt(dbManager).findByConditions(conditions, 0, 0));
		certainLossDto.setPrpLthirdPartyDtoList((ArrayList) new DBPrpLthirdParty(dbManager).findByConditions(conditions, 0, 0));
		
		// ���ǳ��գ���ѯ������ص���Ϣ
		String strRiskCode = new DBPrpLregist(dbManager).findByPrimaryKey(registNo).getRiskCode();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(strRiskCode);
		if ("D".equals(strRiskType)) {
			certainLossDto.setPrpLcarLossDtoList((ArrayList) new DBPrpLcarLoss(dbManager).findByConditions(conditions1, 0, 0));
			certainLossDto.setPrpLcomponentDtoList((ArrayList) new DBPrpLcomponent(dbManager).findByConditions(conditions1, 0, 0));
			certainLossDto.setPrpLrepairFeeDtoList((ArrayList) new DBPrpLrepairFee(dbManager).findByConditions(conditions1, 0, 0));
			certainLossDto.setPrpLthirdPartyDto(new DBPrpLthirdParty(dbManager).findByPrimaryKey(registNo, intLossItemCode));
		}
		return certainLossDto;
	}

// /**
// * ���������Ĺ�������Ϣ
//	 * @param checkNo
//	 * @throws SQLException
//	 * @throws Exception
//	 */
//	private void updateSumClaim(DBManager dbManager, CertainLossDto certainLossDto) throws SQLException, Exception {
//		double sumClaim = 0;
//
//		//����
//		if (certainLossDto.getPrpLrepairFeeDtoList() != null && certainLossDto.getPrpLrepairFeeDtoList().size() > 0) {
//			for (int i = 0; i < certainLossDto.getPrpLrepairFeeDtoList().size(); i++) {
//				PrpLrepairFeeDto prpLrepairFeeDto = (PrpLrepairFeeDto) certainLossDto.getPrpLrepairFeeDtoList().get(i);
//				sumClaim = sumClaim + prpLrepairFeeDto.getSumDefLoss();
//			}
//		}
//		//����
//		if (certainLossDto.getPrpLcomponentDtoList() != null && certainLossDto.getPrpLcomponentDtoList().size() > 0) {
//			for (int i = 0; i < certainLossDto.getPrpLcomponentDtoList().size(); i++) {
//				PrpLcomponentDto prpLcomponentDto = (PrpLcomponentDto) certainLossDto.getPrpLcomponentDtoList().get(i);
//				sumClaim = sumClaim + prpLcomponentDto.getSumDefLoss();
//			}
//		}
//		//����
//		if (certainLossDto.getPrpLpropDtoList() != null && certainLossDto.getPrpLpropDtoList().size() > 0) {
//			for (int i = 0; i < certainLossDto.getPrpLpropDtoList().size(); i++) {
//				PrpLpropDto prpLpropDto = (PrpLpropDto) certainLossDto.getPrpLpropDtoList().get(i);
//				sumClaim = sumClaim + prpLpropDto.getSumDefLoss();
//			}
//		}
//		//����
//		if (certainLossDto.getPrpLpersonDtoList() != null && certainLossDto.getPrpLpersonDtoList().size() > 0) {
//			for (int i = 0; i < certainLossDto.getPrpLpersonDtoList().size(); i++) {
//				PrpLpersonDto prpLpersonDto = (PrpLpersonDto) certainLossDto.getPrpLpersonDtoList().get(i);
//				sumClaim = sumClaim + prpLpersonDto.getSumDefLoss();
//			}
//		}
//
//		String condition = " registNo = '" + StringUtils.rightTrim(certainLossDto.getPrpLverifyLossDto().getRegistNo())
//				+ "'";
//		String statement = ""; //ʾ��δ���
//		statement = " UPDATE PrpLclaim set SumClaim=" + sumClaim + " Where " + condition;
//		dbManager.executeUpdate(statement);
//	}
}
