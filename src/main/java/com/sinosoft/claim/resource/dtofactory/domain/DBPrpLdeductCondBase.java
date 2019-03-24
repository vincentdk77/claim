package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdeductCondDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLdeductCond-计算书免赔条件表的数据访问对象基类<br>
 * 创建于 2006-06-07 16:25:07.421<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLdeductCondBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLdeductCondBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLdeductCondBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLdeductCondDto prpLdeductCondDto
     * @throws Exception
     */
    public void insert(PrpLdeductCondDto prpLdeductCondDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLdeductCond (");
        buffer.append("CompensateNo,");
        buffer.append("DeductCondCode,");
        buffer.append("DeductCondName,");
        buffer.append("Times ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLdeductCondDto.getCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLdeductCondDto.getDeductCondCode()).append("',");
            debugBuffer.append("'").append(prpLdeductCondDto.getDeductCondName()).append("',");
            debugBuffer.append("").append(prpLdeductCondDto.getTimes()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLdeductCondDto.getCompensateNo());
        dbManager.setString(2,prpLdeductCondDto.getDeductCondCode());
        dbManager.setString(3,prpLdeductCondDto.getDeductCondName());
        dbManager.setInt(4,prpLdeductCondDto.getTimes());
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
        buffer.append("INSERT INTO PrpLdeductCond (");
        buffer.append("CompensateNo,");
        buffer.append("DeductCondCode,");
        buffer.append("DeductCondName,");
        buffer.append("Times ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLdeductCondDto prpLdeductCondDto = (PrpLdeductCondDto)i.next();
            dbManager.setString(1,prpLdeductCondDto.getCompensateNo());
            dbManager.setString(2,prpLdeductCondDto.getDeductCondCode());
            dbManager.setString(3,prpLdeductCondDto.getDeductCondName());
            dbManager.setInt(4,prpLdeductCondDto.getTimes());
            dbManager.addBatch();
            
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param compensateNo 计算书号
     * @param deductCondCode 免赔条件代码
     * @throws Exception
     */
    public void delete(String compensateNo,String deductCondCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLdeductCond ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("DeductCondCode=").append("'").append(deductCondCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? And ");
        buffer.append("DeductCondCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.setString(2,deductCondCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLdeductCondDto prpLdeductCondDto
     * @throws Exception
     */
    public void update(PrpLdeductCondDto prpLdeductCondDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLdeductCond SET ");
        buffer.append("DeductCondName = ?, ");
        buffer.append("Times = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLdeductCond SET ");
            debugBuffer.append("DeductCondName = '" + prpLdeductCondDto.getDeductCondName() + "', ");
            debugBuffer.append("Times = " + prpLdeductCondDto.getTimes() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(prpLdeductCondDto.getCompensateNo()).append("' AND ");
            debugBuffer.append("DeductCondCode=").append("'").append(prpLdeductCondDto.getDeductCondCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? And ");
        buffer.append("DeductCondCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLdeductCondDto.getDeductCondName());
        dbManager.setInt(2,prpLdeductCondDto.getTimes());
        //设置条件字段;
        dbManager.setString(3,prpLdeductCondDto.getCompensateNo());
        dbManager.setString(4,prpLdeductCondDto.getDeductCondCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param compensateNo 计算书号
     * @param deductCondCode 免赔条件代码
     * @return PrpLdeductCondDto
     * @throws Exception
     */
    public PrpLdeductCondDto findByPrimaryKey(String compensateNo,String deductCondCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CompensateNo,");
        buffer.append("DeductCondCode,");
        buffer.append("DeductCondName,");
        buffer.append("Times ");
        buffer.append("FROM PrpLdeductCond ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("DeductCondCode=").append("'").append(deductCondCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? And ");
        buffer.append("DeductCondCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.setString(2,deductCondCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLdeductCondDto prpLdeductCondDto = null;
        if(resultSet.next()){
            prpLdeductCondDto = new PrpLdeductCondDto();
            prpLdeductCondDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLdeductCondDto.setDeductCondCode(dbManager.getString(resultSet,2));
            prpLdeductCondDto.setDeductCondName(dbManager.getString(resultSet,3));
            prpLdeductCondDto.setTimes(dbManager.getInt(resultSet,4));
        }
        resultSet.close();
        return prpLdeductCondDto;
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
        buffer.append("CompensateNo,");
        buffer.append("DeductCondCode,");
        buffer.append("DeductCondName,");
        buffer.append("Times ");
        buffer.append("FROM PrpLdeductCond WHERE ");
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
        PrpLdeductCondDto prpLdeductCondDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLdeductCondDto = new PrpLdeductCondDto();
            prpLdeductCondDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLdeductCondDto.setDeductCondCode(dbManager.getString(resultSet,2));
            prpLdeductCondDto.setDeductCondName(dbManager.getString(resultSet,3));
            prpLdeductCondDto.setTimes(dbManager.getInt(resultSet,4));
            collection.add(prpLdeductCondDto);
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
        buffer.append("DELETE FROM PrpLdeductCond WHERE ");
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
        statement = "SELECT count(1) FROM PrpLdeductCond WHERE ";
        statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append("SELECT count(1) FROM PrpLdeductCond WHERE ");
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
