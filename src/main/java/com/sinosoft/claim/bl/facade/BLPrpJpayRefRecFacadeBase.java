package com.sinosoft.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpJpayRefRecDto;
import com.sinosoft.claim.bl.action.domain.BLPrpJpayRefRecAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是收付信息表的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpJpayRefRecFacadeBase {
	private static Logger logger = Logger
			.getLogger(BLPrpJpayRefRecFacadeBase.class);

	/**
	 * 构造函数
	 */
	public BLPrpJpayRefRecFacadeBase() {
	}

	/**
	 * 按条件查询多条数据
	 * 
	 * @param conditions
	 *            查询条件
	 * @param pageNo
	 *            页号
	 * @param rowsPerPage
	 *            每页的行数
	 * @return PageRecord 查询的一页的结果
	 * @throws Exception
	 */

	public Collection findByConditions(String conditions) throws Exception {
		Collection collection = new ArrayList();

		if (conditions.trim().length() == 0) {
			conditions = "1=1";
		}

		DBManager dbManager = new DBManager();
		BLPrpJpayRefRecAction blPrpJpayRefRecAction = new BLPrpJpayRefRecAction();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();
			collection = blPrpJpayRefRecAction.findByConditions(
					dbManager, conditions);
			dbManager.commitTransaction();
		} catch (Exception exception) {
			throw exception;
		} finally {
			dbManager.close();
		}
		return collection;
	}
	
	/**
	 * 新增实收实付时间查询方法
	 * @throws Exception 
	 */
	public DateTime getRefDate(String conditions) throws Exception{
		DateTime refDate = null;
		DBManager dbManager = new DBManager();
		BLPrpJpayRefRecAction blPrpJpayRefRecAction = new BLPrpJpayRefRecAction();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();
			refDate = blPrpJpayRefRecAction.getRefDate(dbManager, conditions);
			dbManager.commitTransaction();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			dbManager.close();
		}
		return refDate;
		
	}
}
