package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.List;

import com.sinosoft.sysframework.reference.DBManager;

public interface BLPersonLossAction {
	public void initPersonLoss(DBManager dbManager,String configCode,String riskCode,List personLossList,double medicalLimit,double deathLimit)throws SQLException,Exception;
}
