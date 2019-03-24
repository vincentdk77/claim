package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDcompanyAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.error.UserException;

/**
 * ����prpdcompany����������ҵ�����Facade��<br>
 * ������ 2004-08-25 16:51:30.344<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcompanyFacade extends BLPrpDcompanyFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDcompanyFacade.class);

    /**
     * ���캯��
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
			// �����¼
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
	 *            ���Ŵ���
	 * @throw Exception
	 * @desc ��������ĵ�λ���룬��ѯ�õ�λ�����ĺ��㵥λ���룬����ũ�պ���ṹ��ȡ�ϼ����㵥λ
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
	 * �������
	 * 
	 * @param iComCode
	 *            ���Ŵ���
	 * @param isChinese
	 *            �����ı�ʶ
	 * @throw Exception
	 * @return ���������ı�ʶ�������Ļ�Ӣ������
	 */
	public String translateCode(String iComCode, boolean isChinese)
			throws Exception {
		String comName = "";
		if (iComCode.equals("")) {
			return ""; // �����ֱ�ӷ��ؿ��ַ���
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
