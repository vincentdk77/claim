package com.sinosoft.function.power.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpTaskDto;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpTask;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpTask工作任务表的业务逻辑对象类<br>
 * 创建于 2004-11-09 10:40:54.669<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpTaskActionBase{
    private static Log logger = LogFactory.getLog(BLPrpTaskActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpTaskActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpTaskDto prpTaskDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpTaskDto prpTaskDto) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //插入记录
        dbPrpTask.insert(prpTaskDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param taskCode 任务代码
     * @param checkCode 权限检验代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String taskCode,String checkCode) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //删除记录
        dbPrpTask.delete(taskCode, checkCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //按条件删除记录
        dbPrpTask.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpTaskDto prpTaskDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpTaskDto prpTaskDto) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //更新记录
        dbPrpTask.update(prpTaskDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param taskCode 任务代码
     * @param checkCode 权限检验代码
     * @return prpTaskDto prpTaskDto
     * @throws Exception
     */
    public PrpTaskDto findByPrimaryKey(DBManager dbManager,String taskCode,String checkCode) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //声明DTO
        PrpTaskDto prpTaskDto = null;
        //查询数据,赋值给DTO
        prpTaskDto = dbPrpTask.findByPrimaryKey(taskCode, checkCode);
        return prpTaskDto;
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
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpTask.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpTask.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpTaskDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpTask.findByConditions(conditions);
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
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpTask.getCount(conditions);
        return count;
    }
}
