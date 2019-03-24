package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaimGrade的数据访问对象基类<br>
 * 创建于 2006-03-07 16:50:47.953<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLclaimGradeBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLclaimGradeBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimGradeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimGradeDto prpLclaimGradeDto
     * @throws Exception
     */
    public void insert(PrpLclaimGradeDto prpLclaimGradeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLclaimGrade (");
        buffer.append("UserCode,");
        buffer.append("UserName,");
        buffer.append("TaskCode,");
        buffer.append("ComCode,");
        buffer.append("ClaimLevel,");
        buffer.append("ValueLower,");
        buffer.append("ValueUpper,");
        buffer.append("Rate,");
        buffer.append("ValidStatus,");
        buffer.append("Flag,");
        buffer.append("ConfigPara,");
        buffer.append("ConfigDesc ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLclaimGradeDto.getUserCode()).append("',");
            debugBuffer.append("'").append(prpLclaimGradeDto.getUserName()).append("',");
            debugBuffer.append("'").append(prpLclaimGradeDto.getTaskCode()).append("',");
            debugBuffer.append("'").append(prpLclaimGradeDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpLclaimGradeDto.getClaimLevel()).append("',");
            debugBuffer.append("").append(prpLclaimGradeDto.getValueLower()).append(",");
            debugBuffer.append("").append(prpLclaimGradeDto.getValueUpper()).append(",");
            debugBuffer.append("").append(prpLclaimGradeDto.getRate()).append(",");
            debugBuffer.append("'").append(prpLclaimGradeDto.getValidStatus()).append("',");
            debugBuffer.append("'").append(prpLclaimGradeDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimGradeDto.getConfigPara()).append("',");
            debugBuffer.append("'").append(prpLclaimGradeDto.getConfigDesc()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLclaimGradeDto.getUserCode());
        dbManager.setString(2,prpLclaimGradeDto.getUserName());
        dbManager.setString(3,prpLclaimGradeDto.getTaskCode());
        dbManager.setString(4,prpLclaimGradeDto.getComCode());
        dbManager.setString(5,prpLclaimGradeDto.getClaimLevel());
        dbManager.setDouble(6,prpLclaimGradeDto.getValueLower());
        dbManager.setDouble(7,prpLclaimGradeDto.getValueUpper());
        dbManager.setDouble(8,prpLclaimGradeDto.getRate());
        dbManager.setString(9,prpLclaimGradeDto.getValidStatus());
        dbManager.setString(10,prpLclaimGradeDto.getFlag());
        dbManager.setString(11,prpLclaimGradeDto.getConfigPara());
        dbManager.setString(12,prpLclaimGradeDto.getConfigDesc());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLclaimGrade (");
        buffer.append("UserCode,");
        buffer.append("UserName,");
        buffer.append("TaskCode,");
        buffer.append("ComCode,");
        buffer.append("ClaimLevel,");
        buffer.append("ValueLower,");
        buffer.append("ValueUpper,");
        buffer.append("Rate,");
        buffer.append("ValidStatus,");
        buffer.append("Flag,");
        buffer.append("ConfigPara,");
        buffer.append("ConfigDesc ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimGradeDto prpLclaimGradeDto = (PrpLclaimGradeDto)i.next();
            dbManager.setString(1,prpLclaimGradeDto.getUserCode());
            dbManager.setString(2,prpLclaimGradeDto.getUserName());
            dbManager.setString(3,prpLclaimGradeDto.getTaskCode());
            dbManager.setString(4,prpLclaimGradeDto.getComCode());
            dbManager.setString(5,prpLclaimGradeDto.getClaimLevel());
            dbManager.setDouble(6,prpLclaimGradeDto.getValueLower());
            dbManager.setDouble(7,prpLclaimGradeDto.getValueUpper());
            dbManager.setDouble(8,prpLclaimGradeDto.getRate());
            dbManager.setString(9,prpLclaimGradeDto.getValidStatus());
            dbManager.setString(10,prpLclaimGradeDto.getFlag());
            dbManager.setString(11,prpLclaimGradeDto.getConfigPara());
            dbManager.setString(12,prpLclaimGradeDto.getConfigDesc());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param userCode UserCode
     * @param taskCode TaskCode
     * @param configPara ConfigPara
     * @throws Exception
     */
    public void delete(String userCode,String taskCode,String configPara)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLclaimGrade ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("UserCode=").append("'").append(userCode).append("' AND ");
            debugBuffer.append("TaskCode=").append("'").append(taskCode).append("' AND ");
            debugBuffer.append("ConfigPara=").append("'").append(configPara).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UserCode = ? And ");
        buffer.append("TaskCode = ? And ");
        buffer.append("ConfigPara = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,userCode);
        dbManager.setString(2,taskCode);
        dbManager.setString(3,configPara);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLclaimGradeDto prpLclaimGradeDto
     * @throws Exception
     */
    public void update(PrpLclaimGradeDto prpLclaimGradeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLclaimGrade SET ");
        buffer.append("UserName = ?, ");
        buffer.append("ComCode = ?, ");
        buffer.append("ClaimLevel = ?, ");
        buffer.append("ValueLower = ?, ");
        buffer.append("ValueUpper = ?, ");
        buffer.append("Rate = ?, ");
        buffer.append("ValidStatus = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("ConfigDesc = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLclaimGrade SET ");
            debugBuffer.append("UserName = '" + prpLclaimGradeDto.getUserName() + "', ");
            debugBuffer.append("ComCode = '" + prpLclaimGradeDto.getComCode() + "', ");
            debugBuffer.append("ClaimLevel = '" + prpLclaimGradeDto.getClaimLevel() + "', ");
            debugBuffer.append("ValueLower = " + prpLclaimGradeDto.getValueLower() + ", ");
            debugBuffer.append("ValueUpper = " + prpLclaimGradeDto.getValueUpper() + ", ");
            debugBuffer.append("Rate = " + prpLclaimGradeDto.getRate() + ", ");
            debugBuffer.append("ValidStatus = '" + prpLclaimGradeDto.getValidStatus() + "', ");
            debugBuffer.append("Flag = '" + prpLclaimGradeDto.getFlag() + "', ");
            debugBuffer.append("ConfigDesc = '" + prpLclaimGradeDto.getConfigDesc() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("UserCode=").append("'").append(prpLclaimGradeDto.getUserCode()).append("' AND ");
            debugBuffer.append("TaskCode=").append("'").append(prpLclaimGradeDto.getTaskCode()).append("' AND ");
            debugBuffer.append("ConfigPara=").append("'").append(prpLclaimGradeDto.getConfigPara()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UserCode = ? And ");
        buffer.append("TaskCode = ? And ");
        buffer.append("ConfigPara = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLclaimGradeDto.getUserName());
        dbManager.setString(2,prpLclaimGradeDto.getComCode());
        dbManager.setString(3,prpLclaimGradeDto.getClaimLevel());
        dbManager.setDouble(4,prpLclaimGradeDto.getValueLower());
        dbManager.setDouble(5,prpLclaimGradeDto.getValueUpper());
        dbManager.setDouble(6,prpLclaimGradeDto.getRate());
        dbManager.setString(7,prpLclaimGradeDto.getValidStatus());
        dbManager.setString(8,prpLclaimGradeDto.getFlag());
        dbManager.setString(9,prpLclaimGradeDto.getConfigDesc());
        //设置条件字段;
        dbManager.setString(10,prpLclaimGradeDto.getUserCode());
        dbManager.setString(11,prpLclaimGradeDto.getTaskCode());
        dbManager.setString(12,prpLclaimGradeDto.getConfigPara());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param userCode UserCode
     * @param taskCode TaskCode
     * @param configPara ConfigPara
     * @return PrpLclaimGradeDto
     * @throws Exception
     */
    public PrpLclaimGradeDto findByPrimaryKey(String userCode,String taskCode,String configPara)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("UserCode,");
        buffer.append("UserName,");
        buffer.append("TaskCode,");
        buffer.append("ComCode,");
        buffer.append("ClaimLevel,");
        buffer.append("ValueLower,");
        buffer.append("ValueUpper,");
        buffer.append("Rate,");
        buffer.append("ValidStatus,");
        buffer.append("Flag,");
        buffer.append("ConfigPara,");
        buffer.append("ConfigDesc ");
        buffer.append("FROM PrpLclaimGrade ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("UserCode=").append("'").append(userCode).append("' AND ");
            debugBuffer.append("TaskCode=").append("'").append(taskCode).append("' AND ");
            debugBuffer.append("ConfigPara=").append("'").append(configPara).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UserCode = ? And ");
        buffer.append("TaskCode = ? And ");
        buffer.append("ConfigPara = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,userCode);
        dbManager.setString(2,taskCode);
        dbManager.setString(3,configPara);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLclaimGradeDto prpLclaimGradeDto = null;
        if(resultSet.next()){
            prpLclaimGradeDto = new PrpLclaimGradeDto();
            prpLclaimGradeDto.setUserCode(dbManager.getString(resultSet,1));
            prpLclaimGradeDto.setUserName(dbManager.getString(resultSet,2));
            prpLclaimGradeDto.setTaskCode(dbManager.getString(resultSet,3));
            prpLclaimGradeDto.setComCode(dbManager.getString(resultSet,4));
            prpLclaimGradeDto.setClaimLevel(dbManager.getString(resultSet,5));
            prpLclaimGradeDto.setValueLower(dbManager.getDouble(resultSet,6));
            prpLclaimGradeDto.setValueUpper(dbManager.getDouble(resultSet,7));
            prpLclaimGradeDto.setRate(dbManager.getDouble(resultSet,8));
            prpLclaimGradeDto.setValidStatus(dbManager.getString(resultSet,9));
            prpLclaimGradeDto.setFlag(dbManager.getString(resultSet,10));
            prpLclaimGradeDto.setConfigPara(dbManager.getString(resultSet,11));
            prpLclaimGradeDto.setConfigDesc(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        return prpLclaimGradeDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("UserCode,");
        buffer.append("UserName,");
        buffer.append("TaskCode,");
        buffer.append("ComCode,");
        buffer.append("ClaimLevel,");
        buffer.append("ValueLower,");
        buffer.append("ValueUpper,");
        buffer.append("Rate,");
        buffer.append("ValidStatus,");
        buffer.append("Flag,");
        buffer.append("ConfigPara,");
        buffer.append("ConfigDesc ");
        buffer.append("FROM PrpLclaimGrade WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLclaimGradeDto prpLclaimGradeDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLclaimGradeDto = new PrpLclaimGradeDto();
            prpLclaimGradeDto.setUserCode(dbManager.getString(resultSet,1));
            prpLclaimGradeDto.setUserName(dbManager.getString(resultSet,2));
            prpLclaimGradeDto.setTaskCode(dbManager.getString(resultSet,3));
            prpLclaimGradeDto.setComCode(dbManager.getString(resultSet,4));
            prpLclaimGradeDto.setClaimLevel(dbManager.getString(resultSet,5));
            prpLclaimGradeDto.setValueLower(dbManager.getDouble(resultSet,6));
            prpLclaimGradeDto.setValueUpper(dbManager.getDouble(resultSet,7));
            prpLclaimGradeDto.setRate(dbManager.getDouble(resultSet,8));
            prpLclaimGradeDto.setValidStatus(dbManager.getString(resultSet,9));
            prpLclaimGradeDto.setFlag(dbManager.getString(resultSet,10));
            prpLclaimGradeDto.setConfigPara(dbManager.getString(resultSet,11));
            prpLclaimGradeDto.setConfigDesc(dbManager.getString(resultSet,12));
            collection.add(prpLclaimGradeDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLclaimGrade WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
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
        StringBuffer buffer = new StringBuffer(100);
       String statement ;
          statement = "SELECT count(1) FROM PrpLclaimGrade WHERE ";
           statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
    
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
}
