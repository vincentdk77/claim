package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGtask1Dto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpGtask1;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgtask1任务日志表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGtask1ActionBase{
    private static Log log = LogFactory.getLog(BLPrpGtask1ActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpGtask1ActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpGtask1Dto prpGtask1Dto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGtask1Dto prpGtask1Dto) throws Exception{
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);
        //插入记录
        dbPrpGtask1.insert(prpGtask1Dto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param taskType 任务类型
     * @param modelNo 模板号
     * @param caseIdNo 案件标识号
     * @param certiNo 单证号码
     * @param serialNo 序号
     * @param currentNode 当前结点号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String taskType,int modelNo,String caseIdNo,String certiNo,int serialNo,int currentNode) throws Exception{
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);
        //删除记录
        dbPrpGtask1.delete(taskType, modelNo, caseIdNo, certiNo, serialNo, currentNode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);
        //按条件删除记录
        dbPrpGtask1.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpGtask1Dto prpGtask1Dto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGtask1Dto prpGtask1Dto) throws Exception{
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);
        //更新记录
        dbPrpGtask1.update(prpGtask1Dto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param taskType 任务类型
     * @param modelNo 模板号
     * @param caseIdNo 案件标识号
     * @param certiNo 单证号码
     * @param serialNo 序号
     * @param currentNode 当前结点号
     * @return prpGtask1Dto prpGtask1Dto
     * @throws Exception
     */
    public PrpGtask1Dto findByPrimaryKey(DBManager dbManager,String taskType,int modelNo,String caseIdNo,String certiNo,int serialNo,int currentNode) throws Exception{
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);
        //声明DTO
        PrpGtask1Dto prpGtask1Dto = null;
        //查询数据,赋值给DTO
        prpGtask1Dto = dbPrpGtask1.findByPrimaryKey(taskType, modelNo, caseIdNo, certiNo, serialNo, currentNode);
        return prpGtask1Dto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpGtask1Dto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpGtask1.getCount(conditions);
        collection = dbPrpGtask1.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpGtask1 dbPrpGtask1 = new DBPrpGtask1(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGtask1.getCount(conditions);
        return count;
    }
}
