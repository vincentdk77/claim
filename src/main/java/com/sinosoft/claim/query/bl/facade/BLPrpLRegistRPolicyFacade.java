package com.sinosoft.claim.query.bl.facade;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLRegistRPolicyAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLRegistRPolicy�ⰸ�����������ҵ�����Facade��<br>
 * ������ 2006-06-04 15:22:18.622<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLRegistRPolicyFacade extends BLPrpLRegistRPolicyFacadeBase{
	private static Log logger = LogFactory.getLog(BLPrpLRegistRPolicyFacade.class);
	
	/**
	 * ���캯��
	 */
	public BLPrpLRegistRPolicyFacade(){
		super();
	}
	
	/**
	 * �Ƿ���� ��־(�����ڱ�����Ļ���)
	 * @param registNo
	 * @return  compelFlag
	 * @throws Exception
	 */
	public  boolean  getCompelFlag(String registNo)  throws Exception{
		DBManager dbManager = new DBManager();
		String conditions ="  registNo ='"+registNo+"'";
		int rowCount=0;
		boolean compelFlag=false;
		BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			rowCount = blPrpLRegistRPolicyAction.getCount(dbManager,conditions);
			if (rowCount>1){
				compelFlag=true;	
			}
		}catch(Exception exception){
			throw exception;
		}finally{
			dbManager.close();
		}
		return compelFlag;
	}
	
	 public Collection findByRegistNo(String registNo) throws Exception
	 {
			DBManager dbManager = new DBManager();
			String conditions ="  registNo ='"+registNo+"'";
			BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
			try{
				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
				Collection collection = blPrpLRegistRPolicyAction.findByConditions(dbManager, conditions);
				return collection;
			}catch(Exception exception){
				throw exception;
			}finally{
				dbManager.close();
			}
			
	 }
}