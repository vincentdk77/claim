package com.sinosoft.function.power.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpGrantDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpGrant 授权记录表的数据访问对象基类<br>
 * 创建于 2004-11-09 10:40:49.311<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGrantBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpGrantBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpGrantBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpGrantDto prpGrantDto
     * @throws Exception
     */
    public void insert(PrpGrantDto prpGrantDto) throws Exception{
        String mainStatement = " Insert Into PrpGrant (" +
                           " UserCode," +
                           " GroupCode," +
                           " TaskCode," +
                           " CheckCode," +
                           " Value," +
                           " GrantStartDate," +
                           " GrantEndDate," +
                           " Condition," +
                           " Remark," +
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpGrantDto.getUserCode() + "'," +
                           "'" + prpGrantDto.getGroupCode() + "'," +
                           "'" + prpGrantDto.getTaskCode() + "'," +
                           "'" + prpGrantDto.getCheckCode() + "'," +
                           "'" + prpGrantDto.getValue() + "'," +
                           "'" + prpGrantDto.getGrantStartDate() + "'," +
                           "'" + prpGrantDto.getGrantEndDate() + "'," +
                           "'" + prpGrantDto.getCondition() + "'," +
                           "'" + prpGrantDto.getRemark() + "'," +
                           "'" + prpGrantDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpGrantDto.getUserCode());
        dbManager.setString(2,prpGrantDto.getGroupCode());
        dbManager.setString(3,prpGrantDto.getTaskCode());
        dbManager.setString(4,prpGrantDto.getCheckCode());
        dbManager.setString(5,prpGrantDto.getValue());
        dbManager.setDateTime(6,prpGrantDto.getGrantStartDate());
        dbManager.setDateTime(7,prpGrantDto.getGrantEndDate());
        dbManager.setString(8,prpGrantDto.getCondition());
        dbManager.setString(9,prpGrantDto.getRemark());
        dbManager.setString(10,prpGrantDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpGrantBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpGrantDto prpGrantDto = (PrpGrantDto)i.next();
            insert(prpGrantDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param userCode 员工代码
     * @param groupCode 权限组号
     * @param taskCode 授权任务
     * @param checkCode 授权类型
     * @param grantStartDate 授权开始时限
     * @param grantEndDate 授权终止时限
     * @throws Exception
     */
    public void delete(String userCode,String groupCode,String taskCode,String checkCode,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        String statement = " Delete From PrpGrant" +
	            		   " Where " +
                           " UserCode = ? And " +
                           " GroupCode = ? And " +
                           " TaskCode = ? And " +
                           " CheckCode = ? And " +
                           " GrantStartDate = ? And " +
                           " GrantEndDate = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpGrant Where " +
                           " UserCode = '" + userCode + "' And " +
                           " GroupCode = '" + groupCode + "' And " +
                           " TaskCode = '" + taskCode + "' And " +
                           " CheckCode = '" + checkCode + "' And " +
                           " GrantStartDate = '" + grantStartDate + "' And " +
                           " GrantEndDate = '" + grantEndDate + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,userCode);
        dbManager.setString(2,groupCode);
        dbManager.setString(3,taskCode);
        dbManager.setString(4,checkCode);
        dbManager.setDateTime(5,grantStartDate);
        dbManager.setDateTime(6,grantEndDate);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpGrantBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpGrantDto prpGrantDto
     * @throws Exception
     */
    public void update(PrpGrantDto prpGrantDto) throws Exception{
        String statement = " Update PrpGrant Set Value = ?," +
                           " Condition = ?," +
                           " Remark = ?," +
                           " Flag = ?" +
	            		   " Where " +
                           " UserCode = ? And " +
                           " GroupCode = ? And " +
                           " TaskCode = ? And " +
                           " CheckCode = ? And " +
                           " GrantStartDate = ? And " +
                           " GrantEndDate = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpGrant Set " +
                           " UserCode = '" + prpGrantDto.getUserCode() + "'," +
                           " GroupCode = '" + prpGrantDto.getGroupCode() + "'," +
                           " TaskCode = '" + prpGrantDto.getTaskCode() + "'," +
                           " CheckCode = '" + prpGrantDto.getCheckCode() + "'," +
                           " Value = '" + prpGrantDto.getValue() + "'," +
                           " GrantStartDate = '" + prpGrantDto.getGrantStartDate() + "'," +
                           " GrantEndDate = '" + prpGrantDto.getGrantEndDate() + "'," +
                           " Condition = '" + prpGrantDto.getCondition() + "'," +
                           " Remark = '" + prpGrantDto.getRemark() + "'," +
                           " Flag = '" + prpGrantDto.getFlag() + "'" +
			               " Where " +
                           " UserCode = '" + prpGrantDto.getUserCode() + "' And " +
                           " GroupCode = '" + prpGrantDto.getGroupCode() + "' And " +
                           " TaskCode = '" + prpGrantDto.getTaskCode() + "' And " +
                           " CheckCode = '" + prpGrantDto.getCheckCode() + "' And " +
                           " GrantStartDate = '" + prpGrantDto.getGrantStartDate() + "' And " +
                           " GrantEndDate = '" + prpGrantDto.getGrantEndDate() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpGrantDto.getValue());
        dbManager.setString(2,prpGrantDto.getCondition());
        dbManager.setString(3,prpGrantDto.getRemark());
        dbManager.setString(4,prpGrantDto.getFlag());
        //设置条件字段;
        dbManager.setString(5,prpGrantDto.getUserCode());
        dbManager.setString(6,prpGrantDto.getGroupCode());
        dbManager.setString(7,prpGrantDto.getTaskCode());
        dbManager.setString(8,prpGrantDto.getCheckCode());
        dbManager.setDateTime(9,prpGrantDto.getGrantStartDate());
        dbManager.setDateTime(10,prpGrantDto.getGrantEndDate());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpGrantBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param userCode 员工代码
     * @param groupCode 权限组号
     * @param taskCode 授权任务
     * @param checkCode 授权类型
     * @param grantStartDate 授权开始时限
     * @param grantEndDate 授权终止时限
     * @return PrpGrantDto
     * @throws Exception
     */
    public PrpGrantDto findByPrimaryKey(String userCode,String groupCode,String taskCode,String checkCode,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        String mainStatement = " Select UserCode," +
                           " GroupCode," +
                           " TaskCode," +
                           " CheckCode," +
                           " Value," +
                           " GrantStartDate," +
                           " GrantEndDate," +
                           " Condition," +
                           " Remark," +
                           " Flag From PrpGrant";
        String statement = mainStatement + " Where " +
                           " UserCode = ? And " +
                           " GroupCode = ? And " +
                           " TaskCode = ? And " +
                           " CheckCode = ? And " +
                           " GrantStartDate = ? And " +
                           " GrantEndDate = ?";
        PrpGrantDto prpGrantDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " UserCode = '" + userCode + "' And " +
                           " GroupCode = '" + groupCode + "' And " +
                           " TaskCode = '" + taskCode + "' And " +
                           " CheckCode = '" + checkCode + "' And " +
                           " GrantStartDate = '" + grantStartDate + "' And " +
                           " GrantEndDate = '" + grantEndDate + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,userCode);
        dbManager.setString(2,groupCode);
        dbManager.setString(3,taskCode);
        dbManager.setString(4,checkCode);
        dbManager.setDateTime(5,grantStartDate);
        dbManager.setDateTime(6,grantEndDate);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpGrantDto = new PrpGrantDto();
            prpGrantDto.setUserCode(dbManager.getString(resultSet,1));
            prpGrantDto.setGroupCode(dbManager.getString(resultSet,2));
            prpGrantDto.setTaskCode(dbManager.getString(resultSet,3));
            prpGrantDto.setCheckCode(dbManager.getString(resultSet,4));
            prpGrantDto.setValue(dbManager.getString(resultSet,5));
            prpGrantDto.setGrantStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpGrantDto.setGrantEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpGrantDto.setCondition(dbManager.getString(resultSet,8));
            prpGrantDto.setRemark(dbManager.getString(resultSet,9));
            prpGrantDto.setFlag(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        logger.info("DBPrpGrantBase.findByPrimaryKey() success!");
        return prpGrantDto;
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
        String statement = "Select UserCode," +
                           " GroupCode," +
                           " TaskCode," +
                           " CheckCode," +
                           " Value," +
                           " GrantStartDate," +
                           " GrantEndDate," +
                           " Condition," +
                           " Remark," +
                           " Flag From PrpGrant Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpGrantDto prpGrantDto = null;
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

            prpGrantDto = new PrpGrantDto();
            prpGrantDto.setUserCode(dbManager.getString(resultSet,1));
            prpGrantDto.setGroupCode(dbManager.getString(resultSet,2));
            prpGrantDto.setTaskCode(dbManager.getString(resultSet,3));
            prpGrantDto.setCheckCode(dbManager.getString(resultSet,4));
            prpGrantDto.setValue(dbManager.getString(resultSet,5));
            prpGrantDto.setGrantStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpGrantDto.setGrantEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpGrantDto.setCondition(dbManager.getString(resultSet,8));
            prpGrantDto.setRemark(dbManager.getString(resultSet,9));
            prpGrantDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpGrantDto);
        }
        resultSet.close();
        logger.info("DBPrpGrantBase.findByConditions() success!");
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
        String statement = "Delete From PrpGrant Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpGrantBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpGrant Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpGrantBase.getCount() success!");
        return count;
    }
}
