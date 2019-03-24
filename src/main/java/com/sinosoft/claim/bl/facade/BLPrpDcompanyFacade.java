package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDcompanyAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.error.UserException;

/**
 * 这是prpdcompany机构代码表的业务对象Facade类<br>
 * 创建于 2004-08-25 16:51:30.344<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcompanyFacade extends BLPrpDcompanyFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDcompanyFacade.class);

    /**
     * 构造函数
     */
    public BLPrpDcompanyFacade(){
        super();
    }
	public String getRecursionComCode(String  condition) throws Exception {
		DBManager dbManager = new DBManager();
		String ComCode="";
		BLPrpDcompanyAction blPrpDcompanyAction = new BLPrpDcompanyAction();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();
			// 插入记录
			ComCode=blPrpDcompanyAction.getRecursionComCode(dbManager, condition);
			dbManager.commitTransaction();
		} catch (Exception exception) {
			dbManager.rollbackTransaction();
			throw exception;
		} finally {
			dbManager.close();
		}
		return ComCode;
	} 
	
	/**
	 * @param iComCode
	 *            部门代码
	 * @throw Exception
	 * @desc 根据输入的单位代码，查询该单位所属的核算单位代码，若是农险核算结构，取上级核算单位
	 */
	public String getCenterCode(String iComCode) throws Exception {
		DBManager dbManager = new DBManager();
		String centerCode = "";
		BLPrpDcompanyAction blPrpDcompanyAction = new BLPrpDcompanyAction();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();
			centerCode = blPrpDcompanyAction.getCenterCode(dbManager, iComCode);
			dbManager.commitTransaction();
		} catch (Exception e) {
			dbManager.rollbackTransaction();
			throw e;
		} finally {
			dbManager.close();
		}
		return centerCode;
	}
	/**
	 * 翻译代码
	 * 
	 * @param iComCode
	 *            部门代码
	 * @param isChinese
	 *            中外文标识
	 * @throw Exception
	 * @return 根据中外文标识返回中文或英文名称
	 */
	public String translateCode(String iComCode, boolean isChinese)
			throws Exception {
		String comName = "";
		if (iComCode.equals("")) {
			return ""; // 代码空直接返回空字符串
		}
		DBManager dbManager = new DBManager();
		BLPrpDcompanyAction blPrpDcompanyAction = new BLPrpDcompanyAction();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();
			comName = blPrpDcompanyAction.translateCode(dbManager, iComCode, isChinese);
			dbManager.commitTransaction();
		}catch(Exception exception){
			dbManager.rollbackTransaction();
			throw exception;
		}finally{
			dbManager.close();
		}
		return comName;
	}
}
