package com.sinosoft.claim.query.bl.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLregistAction;
import com.sinosoft.claim.dto.custom.CaseNoQueryDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLregist-������Ϣ���ҵ�����Facade��<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLregistFacade extends BLPrpLregistFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLregistFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLregistFacade(){
        super();
    }
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection ����prpLregistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditionsNew( DBManager dbManager, String conditions,int page, int rowsPerPage) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        //DBManager dbManager = new DBManager();
        BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
        try{
           // dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLregistAction.findByConditionsNew(dbManager,conditions , page,  rowsPerPage);
            
        }catch(Exception exception){
            throw exception;
        }finally{
           // dbManager.close();
        }
        return collection;
    }
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCountNew(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = " ";
        }

        DBManager dbManager = new DBManager();
        BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLregistAction.getCountNew(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * �������飬��ѯ��¼��
     * @param dbManager
     * @param condition
     * @return
     * @throws Exception
     */
	public int getCaseNoCount(StringBuffer condition) throws Exception{
		int totalCount = 0;
		DBManager dbManager = new DBManager();
    	BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
    	try {
    		//dbManager.open(AppConfig.get("sysconst.DBJNDI"));
    		dbManager.open(Constant.QUERY_DATA_SOURCE);
    		totalCount = blPrpLregistAction.getCaseNoCount(dbManager,condition);
		} catch (Exception exception) {
			throw exception;
		}finally{
			dbManager.close();
		}
		return totalCount;
		
	}
	/**
 	 * ���������ҳ��ѯ��Ϣ
 	 * @param dbManager
 	 * @param condition
 	 * @return
 	 * @throws Exception 
 	 */
	public ArrayList<CaseNoQueryDto> getCaseNo(StringBuffer condition, int pageNo,
			int recordPerPage) throws Exception {
		ArrayList<CaseNoQueryDto> list = new ArrayList<CaseNoQueryDto>();
		DBManager dbManager = new DBManager();
    	BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
    	try {
    		//dbManager.open(AppConfig.get("sysconst.DBJNDI"));
    		dbManager.open(Constant.QUERY_DATA_SOURCE);
    		list = blPrpLregistAction.getCaseNo(dbManager,condition,pageNo,recordPerPage);
		} catch (Exception exception) {
			throw exception;
		}finally{
			dbManager.close();
		}
		return list;
	}
    
	

}
