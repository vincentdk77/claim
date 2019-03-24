package com.gyic.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.gyic.claim.dto.domain.PrplcombineDto;
import com.gyic.claim.resource.dtofactory.domain.DBPrplcombine;
import com.gyic.claim.resource.dtofactory.domain.PrplcombineSwfLog;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是理赔节点状态表与并案关联表联表的业务逻辑对象类<br>
 */
public class BLPrplcombineSwfLogActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcombineSwfLogActionBase.class);


    /**
     * 构造函数
     */
    public BLPrplcombineSwfLogActionBase(){
    }


    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
    	PrplcombineSwfLog prplcombineSwfLog = new PrplcombineSwfLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = prplcombineSwfLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = prplcombineSwfLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	PrplcombineSwfLog prplcombineSwfLog = new PrplcombineSwfLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = prplcombineSwfLog.findByConditions(conditions);
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
    	PrplcombineSwfLog prplcombineSwfLog = new PrplcombineSwfLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = prplcombineSwfLog.getCount(conditions);
        return count;
    }
}
