package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiWorkFlowDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utiworkflow工作流表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiWorkFlowBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBUtiWorkFlowBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiWorkFlowBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiWorkFlowDto utiWorkFlowDto
     * @throws Exception
     */
    public void insert(UtiWorkFlowDto utiWorkFlowDto) throws Exception{
        String statement = " Insert Into UtiWorkFlow(" + 
                           " WorkflowName," + 
                           " OrderNo," + 
                           " Message," + 
                           " Note," + 
                           " Flag) values(?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiWorkFlowDto.getWorkflowName());
        dbManager.setString(2,utiWorkFlowDto.getOrderNo());
        dbManager.setString(3,utiWorkFlowDto.getMessage());
        dbManager.setString(4,utiWorkFlowDto.getNote());
        dbManager.setString(5,utiWorkFlowDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiWorkFlowBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiWorkFlowDto utiWorkFlowDto = (UtiWorkFlowDto)i.next();
            insert(utiWorkFlowDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param workflowName 工作流名称
     * @param orderNo 工序
     * @throws Exception
     */
    public void delete(String workflowName,String orderNo) throws Exception{
        String statement = " Delete From UtiWorkFlow Where " +
                           " WorkflowName = ? And " + 
                           " OrderNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,workflowName);
        dbManager.setString(2,orderNo);
        dbManager.executePreparedUpdate();
        log.info("DBUtiWorkFlowBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiWorkFlowDto utiWorkFlowDto
     * @throws Exception
     */
    public void update(UtiWorkFlowDto utiWorkFlowDto) throws Exception{
        String statement = " Update UtiWorkFlow Set Message = ?," + 
                           " Note = ?," + 
                           " Flag = ? Where " +
                           " WorkflowName = ? And " + 
                           " OrderNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,utiWorkFlowDto.getMessage());
        dbManager.setString(2,utiWorkFlowDto.getNote());
        dbManager.setString(3,utiWorkFlowDto.getFlag());
        //设置条件字段;
        dbManager.setString(4,utiWorkFlowDto.getWorkflowName());
        dbManager.setString(5,utiWorkFlowDto.getOrderNo());
        dbManager.executePreparedUpdate();

        log.info("DBUtiWorkFlowBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param workflowName 工作流名称
     * @param orderNo 工序
     * @return UtiWorkFlowDto
     * @throws Exception
     */
    public UtiWorkFlowDto findByPrimaryKey(String workflowName,String orderNo) throws Exception{
        String statement = " Select WorkflowName," + 
                           " OrderNo," + 
                           " Message," + 
                           " Note," + 
                           " Flag From UtiWorkFlow Where " +
                           " WorkflowName = ? And " + 
                           " OrderNo = ?";
        UtiWorkFlowDto utiWorkFlowDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,workflowName);
        dbManager.setString(2,orderNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiWorkFlowDto = new UtiWorkFlowDto();
            utiWorkFlowDto.setWorkflowName(dbManager.getString(resultSet,1));
            utiWorkFlowDto.setOrderNo(dbManager.getString(resultSet,2));
            utiWorkFlowDto.setMessage(dbManager.getString(resultSet,3));
            utiWorkFlowDto.setNote(dbManager.getString(resultSet,4));
            utiWorkFlowDto.setFlag(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        log.info("DBUtiWorkFlowBase.findByPrimaryKey() success!");
        return utiWorkFlowDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select WorkflowName," + 
                           " OrderNo," + 
                           " Message," + 
                           " Note," + 
                           " Flag From UtiWorkFlow Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiWorkFlowDto utiWorkFlowDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            utiWorkFlowDto = new UtiWorkFlowDto();
            utiWorkFlowDto.setWorkflowName(dbManager.getString(resultSet,1));
            utiWorkFlowDto.setOrderNo(dbManager.getString(resultSet,2));
            utiWorkFlowDto.setMessage(dbManager.getString(resultSet,3));
            utiWorkFlowDto.setNote(dbManager.getString(resultSet,4));
            utiWorkFlowDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(utiWorkFlowDto);
        }
        resultSet.close();
        log.info("DBUtiWorkFlowBase.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From UtiWorkFlow Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiWorkFlowBase.deleteByConditions() success!");
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "Select count(1) from UtiWorkFlow Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiWorkFlowBase.getCount() success!");
        return count;
    }
}
