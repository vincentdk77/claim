package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleNewDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleNew;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleNew-新案件调度提示表(新增)的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.218<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleNewActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleNewActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLscheduleNewActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLscheduleNewDto prpLscheduleNewDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLscheduleNewDto prpLscheduleNewDto) throws Exception{
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        //插入记录
        dbPrpLscheduleNew.insert(prpLscheduleNewDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案受理号
     * @param surveyNo 已查勘次数
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int surveyNo) throws Exception{
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        //删除记录
        dbPrpLscheduleNew.delete(registNo, surveyNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        //按条件删除记录
        dbPrpLscheduleNew.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLscheduleNewDto prpLscheduleNewDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLscheduleNewDto prpLscheduleNewDto) throws Exception{
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        //更新记录
        dbPrpLscheduleNew.update(prpLscheduleNewDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案受理号
     * @param surveyNo 已查勘次数
     * @return prpLscheduleNewDto prpLscheduleNewDto
     * @throws Exception
     */
    public PrpLscheduleNewDto findByPrimaryKey(DBManager dbManager,String registNo,int surveyNo) throws Exception{
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        //声明DTO
        PrpLscheduleNewDto prpLscheduleNewDto = null;
        //查询数据,赋值给DTO
        prpLscheduleNewDto = dbPrpLscheduleNew.findByPrimaryKey(registNo, surveyNo);
        return prpLscheduleNewDto;
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
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleNew.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLscheduleNew.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLscheduleNewDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLscheduleNew.findByConditions(conditions);
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
        DBPrpLscheduleNew dbPrpLscheduleNew = new DBPrpLscheduleNew(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleNew.getCount(conditions);
        return count;
    }
}
