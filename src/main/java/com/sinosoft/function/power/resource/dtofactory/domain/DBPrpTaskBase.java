package com.sinosoft.function.power.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpTaskDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpTask工作任务表的数据访问对象基类<br>
 * 创建于 2004-11-09 10:40:49.331<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpTaskBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpTaskBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpTaskBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpTaskDto prpTaskDto
     * @throws Exception
     */
    public void insert(PrpTaskDto prpTaskDto) throws Exception{
        String mainStatement = " Insert Into PrpTask (" + 
                           " TaskCode," + 
                           " TaskName," + 
                           " CheckCode," + 
                           " CheckName," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpTaskDto.getTaskCode() + "'," + 
                           "'" + prpTaskDto.getTaskName() + "'," + 
                           "'" + prpTaskDto.getCheckCode() + "'," + 
                           "'" + prpTaskDto.getCheckName() + "'," + 
                           "'" + prpTaskDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpTaskDto.getTaskCode());
        dbManager.setString(2,prpTaskDto.getTaskName());
        dbManager.setString(3,prpTaskDto.getCheckCode());
        dbManager.setString(4,prpTaskDto.getCheckName());
        dbManager.setString(5,prpTaskDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpTaskBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpTaskDto prpTaskDto = (PrpTaskDto)i.next();
            insert(prpTaskDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param taskCode 任务代码
     * @param checkCode 权限检验代码
     * @throws Exception
     */
    public void delete(String taskCode,String checkCode) throws Exception{
        String statement = " Delete From PrpTask" + 
	            		   " Where " +
                           " TaskCode = ? And " + 
                           " CheckCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpTask Where " +
                           " TaskCode = '" + taskCode + "' And " + 
                           " CheckCode = '" + checkCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,taskCode);
        dbManager.setString(2,checkCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpTaskBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpTaskDto prpTaskDto
     * @throws Exception
     */
    public void update(PrpTaskDto prpTaskDto) throws Exception{
        String statement = " Update PrpTask Set TaskName = ?," + 
                           " CheckName = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " TaskCode = ? And " + 
                           " CheckCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpTask Set " + 
                           " TaskCode = '" + prpTaskDto.getTaskCode() + "'," + 
                           " TaskName = '" + prpTaskDto.getTaskName() + "'," + 
                           " CheckCode = '" + prpTaskDto.getCheckCode() + "'," + 
                           " CheckName = '" + prpTaskDto.getCheckName() + "'," + 
                           " Flag = '" + prpTaskDto.getFlag() + "'" + 
			               " Where " +
                           " TaskCode = '" + prpTaskDto.getTaskCode() + "' And " + 
                           " CheckCode = '" + prpTaskDto.getCheckCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpTaskDto.getTaskName());
        dbManager.setString(2,prpTaskDto.getCheckName());
        dbManager.setString(3,prpTaskDto.getFlag());
        //设置条件字段;
        dbManager.setString(4,prpTaskDto.getTaskCode());
        dbManager.setString(5,prpTaskDto.getCheckCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpTaskBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param taskCode 任务代码
     * @param checkCode 权限检验代码
     * @return PrpTaskDto
     * @throws Exception
     */
    public PrpTaskDto findByPrimaryKey(String taskCode,String checkCode) throws Exception{
        String mainStatement = " Select TaskCode," + 
                           " TaskName," + 
                           " CheckCode," + 
                           " CheckName," + 
                           " Flag From PrpTask";
        String statement = mainStatement + " Where " +
                           " TaskCode = ? And " + 
                           " CheckCode = ?";
        PrpTaskDto prpTaskDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " TaskCode = '" + taskCode + "' And " + 
                           " CheckCode = '" + checkCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,taskCode);
        dbManager.setString(2,checkCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpTaskDto = new PrpTaskDto();
            prpTaskDto.setTaskCode(dbManager.getString(resultSet,1));
            prpTaskDto.setTaskName(dbManager.getString(resultSet,2));
            prpTaskDto.setCheckCode(dbManager.getString(resultSet,3));
            prpTaskDto.setCheckName(dbManager.getString(resultSet,4));
            prpTaskDto.setFlag(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        logger.info("DBPrpTaskBase.findByPrimaryKey() success!");
        return prpTaskDto;
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
        String statement = "Select TaskCode," + 
                           " TaskName," + 
                           " CheckCode," + 
                           " CheckName," + 
                           " Flag From PrpTask Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpTaskDto prpTaskDto = null;
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

            prpTaskDto = new PrpTaskDto();
            prpTaskDto.setTaskCode(dbManager.getString(resultSet,1));
            prpTaskDto.setTaskName(dbManager.getString(resultSet,2));
            prpTaskDto.setCheckCode(dbManager.getString(resultSet,3));
            prpTaskDto.setCheckName(dbManager.getString(resultSet,4));
            prpTaskDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpTaskDto);
        }
        resultSet.close();
        logger.info("DBPrpTaskBase.findByConditions() success!");
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
        String statement = "Delete From PrpTask Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpTaskBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpTask Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpTaskBase.getCount() success!");
        return count;
    }
}
