package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGtaskDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpGtask;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgtask核保核赔任务日志表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGtaskActionBase{
    private static Log log = LogFactory.getLog(BLPrpGtaskActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpGtaskActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpGtaskDto prpGtaskDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGtaskDto prpGtaskDto) throws Exception{
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);
        //插入记录
        dbPrpGtask.insert(prpGtaskDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param taskType 任务类型
     * @param certiType 单证类型
     * @param certiNo 单证号码
     * @param times 次数
     * @param currentNode 当前结点号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String taskType,String certiType,String certiNo,int times,int currentNode) throws Exception{
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);
        //删除记录
        dbPrpGtask.delete(taskType, certiType, certiNo, times, currentNode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);
        //按条件删除记录
        dbPrpGtask.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpGtaskDto prpGtaskDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGtaskDto prpGtaskDto) throws Exception{
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);
        //更新记录
        dbPrpGtask.update(prpGtaskDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param taskType 任务类型
     * @param certiType 单证类型
     * @param certiNo 单证号码
     * @param times 次数
     * @param currentNode 当前结点号
     * @return prpGtaskDto prpGtaskDto
     * @throws Exception
     */
    public PrpGtaskDto findByPrimaryKey(DBManager dbManager,String taskType,String certiType,String certiNo,int times,int currentNode) throws Exception{
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);
        //声明DTO
        PrpGtaskDto prpGtaskDto = null;
        //查询数据,赋值给DTO
        prpGtaskDto = dbPrpGtask.findByPrimaryKey(taskType, certiType, certiNo, times, currentNode);
        return prpGtaskDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpGtaskDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpGtask.getCount(conditions);
        collection = dbPrpGtask.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpGtask dbPrpGtask = new DBPrpGtask(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGtask.getCount(conditions);
        return count;
    }
}
