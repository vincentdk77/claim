package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiWorkFlowDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiWorkFlow;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utiworkflow工作流表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiWorkFlowActionBase{
    private static Log log = LogFactory.getLog(BLUtiWorkFlowActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLUtiWorkFlowActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiWorkFlowDto utiWorkFlowDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiWorkFlowDto utiWorkFlowDto) throws Exception{
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);
        //插入记录
        dbUtiWorkFlow.insert(utiWorkFlowDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param workflowName 工作流名称
     * @param orderNo 工序
     * @throws Exception
     */
    public void delete(DBManager dbManager,String workflowName,String orderNo) throws Exception{
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);
        //删除记录
        dbUtiWorkFlow.delete(workflowName, orderNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);
        //按条件删除记录
        dbUtiWorkFlow.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiWorkFlowDto utiWorkFlowDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiWorkFlowDto utiWorkFlowDto) throws Exception{
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);
        //更新记录
        dbUtiWorkFlow.update(utiWorkFlowDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param workflowName 工作流名称
     * @param orderNo 工序
     * @return utiWorkFlowDto utiWorkFlowDto
     * @throws Exception
     */
    public UtiWorkFlowDto findByPrimaryKey(DBManager dbManager,String workflowName,String orderNo) throws Exception{
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);
        //声明DTO
        UtiWorkFlowDto utiWorkFlowDto = null;
        //查询数据,赋值给DTO
        utiWorkFlowDto = dbUtiWorkFlow.findByPrimaryKey(workflowName, orderNo);
        return utiWorkFlowDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含utiWorkFlowDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiWorkFlow.getCount(conditions);
        collection = dbUtiWorkFlow.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiWorkFlow dbUtiWorkFlow = new DBUtiWorkFlow(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiWorkFlow.getCount(conditions);
        return count;
    }
}
