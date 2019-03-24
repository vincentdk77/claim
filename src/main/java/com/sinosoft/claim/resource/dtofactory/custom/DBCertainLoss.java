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
 * 定损数据库管理对象
 * <p>Title: 车险理赔定损数据管理</p>
 * <p>Description: 车险理赔定损数据管理</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBCertainLoss {
	/**
	 * 定损保存方法
	 *@param certainLossDto 定损对象
	 * @throws SQLException
	 * @throws Exception
	 *@return 无
	 */
	public void insert(DBManager dbManager, CertainLossDto certainLossDto) throws SQLException, Exception {

		if (certainLossDto.getPrpLverifyLossDto() == null) {
			throw new Exception();
		}
		//报案号码 关键字
		PrpLverifyLossDto prpLverifyLossDto = certainLossDto.getPrpLverifyLossDto();
	    String registNo = prpLverifyLossDto.getRegistNo();
		String lossItemCode = prpLverifyLossDto.getLossItemCode();
		//首先删除原来的相关数据
		deleteSubInfo(dbManager, registNo, lossItemCode);
		//new DBPrpLverifyLoss(dbManager).insert(certainLossDto.getPrpLverifyLossDto());
		//modify by zhaolu 20060809 start
		//reason:在定损中加入三者车的车牌号
        //国元项目组对于农险的lossItemCode的取值 开始
		if(lossItemCode=="" || lossItemCode== null){
			lossItemCode="-2";
		}
        //国元项目组对于农险的lossItemCode的取值 结束
		if( Integer.parseInt(lossItemCode)>= 2 )
		{
			prpLverifyLossDto.setLossItemName(certainLossDto.getPrpLthirdPartyDto().getLicenseNo());
			prpLverifyLossDto.setLicenseNo(certainLossDto.getPrpLthirdPartyDto().getLicenseNo());
		}
		if( lossItemCode.equals("0") )
			prpLverifyLossDto.setLossItemName("人伤");
		if( lossItemCode.equals("-1") )
			prpLverifyLossDto.setLossItemName("财产");
		new DBPrpLverifyLoss(dbManager).insert(certainLossDto.getPrpLverifyLossDto());
        //modify by zhaolu 20060809 end
       
		//定损车辆表
		if (certainLossDto.getPrpLcarLossDtoList() != null) {
			new DBPrpLcarLoss(dbManager).insertAll(certainLossDto.getPrpLcarLossDtoList());
		}
		//修理费用清单
		if (certainLossDto.getPrpLrepairFeeDtoList() != null) {
			new DBPrpLrepairFee(dbManager).insertAll(certainLossDto.getPrpLrepairFeeDtoList());
		}
		//换件项目清单
		if (certainLossDto.getPrpLcomponentDtoList() != null) {
			new DBPrpLcomponent(dbManager).insertAll(certainLossDto.getPrpLcomponentDtoList());
		}
		//定核损扩展信息 
		if (certainLossDto.getPrpLverifyLossExtDtoList() != null) {
			new DBPrpLverifyLossExt(dbManager).insertAll(certainLossDto.getPrpLverifyLossExtDtoList());
		}
		//扩展信息 
		if (certainLossDto.getPrpLregistExtDtoList() != null) {
			new DBPrpLregistExt(dbManager).insertAll(certainLossDto.getPrpLregistExtDtoList());
		}
		//人员伤亡明细信息表
		if (certainLossDto.getPrpLpersonDtoList() != null) {
			new DBPrpLperson(dbManager).insertAll(certainLossDto.getPrpLpersonDtoList());
		}

		//财产核定损明细清单表
		if (certainLossDto.getPrpLpropDtoList() != null) {
			new DBPrpLprop(dbManager).insertAll(certainLossDto.getPrpLpropDtoList());
		}
		//定核损处理标的表
		/*
		 if(certainLossDto.getPrpLverifyLossItemDtoList()!=null&&certainLossDto.getPrpLverifyLossItemDtoList().size()>0){
		 new DBPrpLverifyLossItem(dbManager).insertAll(certainLossDto.getPrpLverifyLossItemDtoList());
		 }*/
		//伤情信息表
		if (certainLossDto.getPrpLpersonWoundDtoList() != null && certainLossDto.getPrpLpersonWoundDtoList().size() > 0) {
			new DBPrpLpersonWound(dbManager).insertAll(certainLossDto.getPrpLpersonWoundDtoList());
		}
		//modify by liuyanmei add start 20051215 reason：定损涉案车辆可修改，需保存三者车的信息
		if (certainLossDto.getPrpLthirdPartyDto() != null) {
			String thirdPartyRegistNo = certainLossDto.getPrpLthirdPartyDto().getRegistNo();
			int thirdPartySerialNo = certainLossDto.getPrpLthirdPartyDto().getSerialNo();
			new DBPrpLthirdParty(dbManager).delete(thirdPartyRegistNo, thirdPartySerialNo);
			new DBPrpLthirdParty(dbManager).insert(certainLossDto.getPrpLthirdPartyDto());
		}
		//耳标号损失清单表保存
		if (certainLossDto.getPrplCompensateEarDtoList() != null && certainLossDto.getPrplCompensateEarDtoList().size() > 0) {
			new DBPrplcompensateear(dbManager).insertAll(certainLossDto.getPrplCompensateEarDtoList());
		}
		//0310清单表保存
		//System.err.println("PrplCompensateHouseDtoList1:" + certainLossDto.getPrplCompensateHouseDtoList().size());
		if (certainLossDto.getPrplCompensateHouseDtoList()!= null && certainLossDto.getPrplCompensateHouseDtoList().size() > 0) {
			PrplcompensatehouseDto PrplcompensatehouseDto = (PrplcompensatehouseDto)certainLossDto.getPrplCompensateHouseDtoList().get(0);
			String registno = PrplcompensatehouseDto.getRegistno();
			String nodetype = PrplcompensatehouseDto.getNodetype();
			String condition = " registno='" + registno + "' and nodetype='" + nodetype + "'";
			new DBPrplcompensatehouse(dbManager).deleteByConditions(condition);
			new DBPrplcompensatehouse(dbManager).insertAll(certainLossDto.getPrplCompensateHouseDtoList());
		}
		//modify by liuyanmei add end 20051215 reason：定损涉案车辆可修改，需保存三者车的信息    
		//进行状态的改变
		updateClaimStatus(dbManager, certainLossDto);
		/**
		 * modify by mengdongdong at 20060411
		 * 定损的时候不能重新更新立案估损金额
		 */
		//更新立案估损金额信息
		//updateSumClaim(dbManager,certainLossDto);
	}

	/**
	 * 定损删除子表信息
	 * @param registNo //报案号
	 * @throws SQLException
	 * @throws Exception
	 */
	private void deleteSubInfo(DBManager dbManager, String registNo, String lossItemCode) throws SQLException,
			Exception {

		String condition = " registNo = " + "'" + registNo.trim() + "'";
		//示例未完成
		String statement = "";
		//删除定核损扩展信息 
		String condition1 = " registNo = " + "'" + registNo.trim() + "' and  lossItemCode = '" + lossItemCode.trim()
				+ "'";
		statement = " DELETE FROM PrpLverifyLossExt Where " + condition1;
		dbManager.executeUpdate(statement);
		
		//删除扩展信息 
		statement = " DELETE FROM PrpLregistExt Where " + condition;
		dbManager.executeUpdate(statement);
		
		statement = " DELETE FROM prplCompensateEar Where " + condition +" and nodeType = 'certa'";
		dbManager.executeUpdate(statement);

		int i = Integer.parseInt(DataUtils.nullToZero(lossItemCode));
		if (i > 0) {
			//condition = condition + " and LossItemCode='"+lossItemCode+"'";
			//修理费用清单
			statement = " DELETE FROM prpLrepairFee Where " + condition + " and LossItemCode='" + lossItemCode + "'";
			dbManager.executeUpdate(statement);
			//换件项目清单
			statement = " DELETE FROM prpLcomponent Where " + condition + " and LossItemCode='" + lossItemCode + "'";
			dbManager.executeUpdate(statement);
			//定损车辆表
			statement = " DELETE FROM prpLcarLoss Where " + condition + " and LossItemCode='" + lossItemCode + "'";
			dbManager.executeUpdate(statement);
		} else if (i == 0) {
			//人员伤亡明细信息
			statement = " DELETE FROM prpLperson Where " + condition;
			dbManager.executeUpdate(statement);
//			伤情信息表
			statement = " DELETE FROM PrpLpersonWound Where " + condition;
			dbManager.executeUpdate(statement);

		} else if (i == -1) {
			//财产核定损明细
			statement = " DELETE FROM prpLprop Where " + condition;
			dbManager.executeUpdate(statement);
		} 
		//增加农险财产核定损明细
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
	 * 定损删除
	 * @param certainLossNo
	 * @throws SQLException
	 * @throws Exception
	 */
	public void delete(DBManager dbManager, String registNo) throws SQLException, Exception {
		String condition = " registNo = " + "'" + registNo.trim() + "'";
		String condition1 = " businessNo = " + "'" + registNo.trim() + "' AND NodeType ='certa'";
		//示例未完成
		String statement = "";
		//修理费用清单
		statement = " DELETE FROM prpLrepairFee Where " + condition;
		dbManager.executeUpdate(statement);
		//换件项目清单
		statement = " DELETE FROM prpLcomponent Where " + condition;
		dbManager.executeUpdate(statement);
		//人员伤亡明细信息
		statement = " DELETE FROM prpLperson Where " + condition;
		dbManager.executeUpdate(statement);
		//财产核定损明细
		statement = " DELETE FROM prpLprop Where " + condition;
		dbManager.executeUpdate(statement);
		//定损车辆表
		statement = " DELETE FROM prpLcarLoss Where " + condition;
		dbManager.executeUpdate(statement);
		//伤情信息表
		statement = " DELETE FROM PrpLpersonWound Where " + condition;
		dbManager.executeUpdate(statement);

		//状态
		statement = " DELETE FROM prplclaimstatus Where " + condition1;
		dbManager.executeUpdate(statement);
		//定损主表
		statement = " DELETE FROM PrpLverifyLoss Where " + condition;
		dbManager.executeUpdate(statement);

	}

	/*
	 * 定损查询方法
	 *@param certainLossDto 定损对象
	 * @throws SQLException
	 * @throws Exception
	 *@return 无
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
	 * 变更定损的操作状态的方法
	 *@param certainLossDto 立案对象
	 * @throws SQLException
	 * @throws Exception
	 *@return 无
	 */
	public void updateClaimStatus(DBManager dbManager, CertainLossDto certainLossDto) throws SQLException, Exception {
		//示例未完成
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
	 * 定损查询方法
	 *@param certainLossDto 定损对象
	 * @throws SQLException
	 * @throws Exception
	 *@return 无
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
		
		// 若是车险，查询车辆相关的信息
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
// * 更新立案的估损金额信息
//	 * @param checkNo
//	 * @throws SQLException
//	 * @throws Exception
//	 */
//	private void updateSumClaim(DBManager dbManager, CertainLossDto certainLossDto) throws SQLException, Exception {
//		double sumClaim = 0;
//
//		//修理
//		if (certainLossDto.getPrpLrepairFeeDtoList() != null && certainLossDto.getPrpLrepairFeeDtoList().size() > 0) {
//			for (int i = 0; i < certainLossDto.getPrpLrepairFeeDtoList().size(); i++) {
//				PrpLrepairFeeDto prpLrepairFeeDto = (PrpLrepairFeeDto) certainLossDto.getPrpLrepairFeeDtoList().get(i);
//				sumClaim = sumClaim + prpLrepairFeeDto.getSumDefLoss();
//			}
//		}
//		//换件
//		if (certainLossDto.getPrpLcomponentDtoList() != null && certainLossDto.getPrpLcomponentDtoList().size() > 0) {
//			for (int i = 0; i < certainLossDto.getPrpLcomponentDtoList().size(); i++) {
//				PrpLcomponentDto prpLcomponentDto = (PrpLcomponentDto) certainLossDto.getPrpLcomponentDtoList().get(i);
//				sumClaim = sumClaim + prpLcomponentDto.getSumDefLoss();
//			}
//		}
//		//物损
//		if (certainLossDto.getPrpLpropDtoList() != null && certainLossDto.getPrpLpropDtoList().size() > 0) {
//			for (int i = 0; i < certainLossDto.getPrpLpropDtoList().size(); i++) {
//				PrpLpropDto prpLpropDto = (PrpLpropDto) certainLossDto.getPrpLpropDtoList().get(i);
//				sumClaim = sumClaim + prpLpropDto.getSumDefLoss();
//			}
//		}
//		//人伤
//		if (certainLossDto.getPrpLpersonDtoList() != null && certainLossDto.getPrpLpersonDtoList().size() > 0) {
//			for (int i = 0; i < certainLossDto.getPrpLpersonDtoList().size(); i++) {
//				PrpLpersonDto prpLpersonDto = (PrpLpersonDto) certainLossDto.getPrpLpersonDtoList().get(i);
//				sumClaim = sumClaim + prpLpersonDto.getSumDefLoss();
//			}
//		}
//
//		String condition = " registNo = '" + StringUtils.rightTrim(certainLossDto.getPrpLverifyLossDto().getRegistNo())
//				+ "'";
//		String statement = ""; //示例未完成
//		statement = " UPDATE PrpLclaim set SumClaim=" + sumClaim + " Where " + condition;
//		dbManager.executeUpdate(statement);
//	}
}
