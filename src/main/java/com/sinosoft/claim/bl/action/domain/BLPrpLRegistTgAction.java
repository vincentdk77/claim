package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.CaseNoQueryDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLregist-报案信息表的业务对象扩展类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLRegistTgAction extends BLPrpLRegistTgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLRegistTgAction.class);

    /**
     * 构造函数
     */
    public BLPrpLRegistTgAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLregistDto prpLregistDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLregistDto prpLregistDto,String mode) throws Exception{
    }
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLregistDto的集合
     * @throws Exception
     */
    public Collection findByConditionsNew(DBManager dbManager,String conditions ,int page, int rowsPerPage) throws Exception{
        DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLregist.findByConditionsNew(conditions , page,rowsPerPage);
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
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLRegistTgAction blPrpLregistAction = new BLPrpLRegistTgAction();
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
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCountNew(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);

        if(conditions.trim().length()==0){
            conditions = " ";
        }

        int count = dbPrpLregist.getCountNew(conditions);
        return count;
    }
    /**
     * 案件互查，查询记录数
     * @param dbManager
     * @param condition
     * @return
     * @throws Exception
     */
 	public int getCaseNoCount(DBManager dbManager, StringBuffer condition) throws Exception {
 		int totalCount = 0;
 		DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
 		totalCount = dbPrpLregist.getCaseNoCount(condition);
 		return totalCount;
 	}
 	/**
 	 * 案件互查分页查询信息
 	 * @param dbManager
 	 * @param condition
 	 * @return
 	 * @throws Exception 
 	 */
 	public ArrayList<CaseNoQueryDto> getCaseNo(DBManager dbManager,
 			StringBuffer condition,int pageNo,int recordPerPage) throws Exception {
 		ArrayList<CaseNoQueryDto> list = new ArrayList<CaseNoQueryDto>();
 		DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
 		list = dbPrpLregist.getCaseNo(condition,pageNo,recordPerPage);
 		return list;
 	}

}
