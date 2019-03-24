package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonTrace;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpersonTrace-人伤跟踪表(新增)的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.250<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpersonTraceActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonTraceActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpersonTraceActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpersonTraceDto prpLpersonTraceDto) throws Exception{
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        //插入记录
        dbPrpLpersonTrace.insert(prpLpersonTraceDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param personNo 人员序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int personNo) throws Exception{
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        //删除记录
        dbPrpLpersonTrace.delete(registNo, personNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        //按条件删除记录
        dbPrpLpersonTrace.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpersonTraceDto prpLpersonTraceDto) throws Exception{
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        //更新记录
        dbPrpLpersonTrace.update(prpLpersonTraceDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param personNo 人员序号
     * @return prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public PrpLpersonTraceDto findByPrimaryKey(DBManager dbManager,String registNo,int personNo) throws Exception{
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        //声明DTO
        PrpLpersonTraceDto prpLpersonTraceDto = null;
        //查询数据,赋值给DTO
        prpLpersonTraceDto = dbPrpLpersonTrace.findByPrimaryKey(registNo, personNo);
        return prpLpersonTraceDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpersonTrace.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpersonTrace.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLpersonTraceDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpersonTrace.findByConditions(conditions);
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
        DBPrpLpersonTrace dbPrpLpersonTrace = new DBPrpLpersonTrace(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpersonTrace.getCount(conditions);
        return count;
    }
}
