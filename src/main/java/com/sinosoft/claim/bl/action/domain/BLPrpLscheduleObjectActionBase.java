package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleObjectDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleObject;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleObject-调度对象表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.218<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleObjectActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleObjectActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLscheduleObjectActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLscheduleObjectDto prpLscheduleObjectDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLscheduleObjectDto prpLscheduleObjectDto) throws Exception{
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        //插入记录
        dbPrpLscheduleObject.insert(prpLscheduleObjectDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param scheduleObjectID 调度对象代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String scheduleObjectID) throws Exception{
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        //删除记录
        dbPrpLscheduleObject.delete(scheduleObjectID);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        //按条件删除记录
        dbPrpLscheduleObject.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLscheduleObjectDto prpLscheduleObjectDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLscheduleObjectDto prpLscheduleObjectDto) throws Exception{
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        //更新记录
        dbPrpLscheduleObject.update(prpLscheduleObjectDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param scheduleObjectID 调度对象代码
     * @return prpLscheduleObjectDto prpLscheduleObjectDto
     * @throws Exception
     */
    public PrpLscheduleObjectDto findByPrimaryKey(DBManager dbManager,String scheduleObjectID) throws Exception{
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        //声明DTO
        PrpLscheduleObjectDto prpLscheduleObjectDto = null;
        //查询数据,赋值给DTO
        prpLscheduleObjectDto = dbPrpLscheduleObject.findByPrimaryKey(scheduleObjectID);
        return prpLscheduleObjectDto;
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
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleObject.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLscheduleObject.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLscheduleObjectDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLscheduleObject.findByConditions(conditions);
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
        DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleObject.getCount(conditions);
        return count;
    }
}
