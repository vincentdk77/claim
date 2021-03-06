package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpTaskDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpTask;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prptask任务定义表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpTaskActionBase{
    private static Log log = LogFactory.getLog(BLPrpTaskActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

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
     * @param checkType 权限检验类型
     * @throws Exception
     */
    public void delete(DBManager dbManager,String taskCode,String checkType) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //删除记录
        dbPrpTask.delete(taskCode, checkType);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
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
     * @param checkType 权限检验类型
     * @return prpTaskDto prpTaskDto
     * @throws Exception
     */
    public PrpTaskDto findByPrimaryKey(DBManager dbManager,String taskCode,String checkType) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        //声明DTO
        PrpTaskDto prpTaskDto = null;
        //查询数据,赋值给DTO
        prpTaskDto = dbPrpTask.findByPrimaryKey(taskCode, checkType);
        return prpTaskDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpTaskDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpTask.getCount(conditions);
        collection = dbPrpTask.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpTask dbPrpTask = new DBPrpTask(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpTask.getCount(conditions);
        return count;
    }
}
