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
 * 这是PrpLregist-报案信息表的业务对象Facade类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLregistFacade extends BLPrpLregistFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLregistFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLregistFacade(){
        super();
    }
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection 包含prpLregistDto的集合
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
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
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
     * 案件互查，查询记录数
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
 	 * 案件互查分页查询信息
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
