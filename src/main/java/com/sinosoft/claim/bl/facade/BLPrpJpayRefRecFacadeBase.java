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
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * �����ո���Ϣ���ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpJpayRefRecFacadeBase {
	private static Logger logger = Logger
			.getLogger(BLPrpJpayRefRecFacadeBase.class);

	/**
	 * ���캯��
	 */
	public BLPrpJpayRefRecFacadeBase() {
	}

	/**
	 * ��������ѯ��������
	 * 
	 * @param conditions
	 *            ��ѯ����
	 * @param pageNo
	 *            ҳ��
	 * @param rowsPerPage
	 *            ÿҳ������
	 * @return PageRecord ��ѯ��һҳ�Ľ��
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
	 * ����ʵ��ʵ��ʱ���ѯ����
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
