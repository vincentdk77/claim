package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLverifyLossExtDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLverifyLossExt的数据访问对象基类<br>
 * 创建于 2006-03-20 17:55:51.031<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLverifyLossExtBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLverifyLossExtBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLverifyLossExtBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLverifyLossExtDto prpLverifyLossExtDto
     * @throws Exception
     */
    public void insert(PrpLverifyLossExtDto prpLverifyLossExtDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLverifyLossExt (");
        buffer.append("RegistNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("InputDate,");
        buffer.append("InputHour,");
        buffer.append("OperatorCode,");
        buffer.append("ComCode,");
        buffer.append("title,");
        buffer.append("Context,");
        buffer.append("LossItemCode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLverifyLossExtDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLverifyLossExtDto.getRiskCode()).append("',");
            debugBuffer.append("").append(prpLverifyLossExtDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLverifyLossExtDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLverifyLossExtDto.getInputHour()).append("',");
            debugBuffer.append("'").append(prpLverifyLossExtDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLverifyLossExtDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpLverifyLossExtDto.getTitle()).append("',");
            debugBuffer.append("'").append(prpLverifyLossExtDto.getContext()).append("',");
            debugBuffer.append("'").append(prpLverifyLossExtDto.getLossItemCode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLverifyLossExtDto.getRegistNo());
        dbManager.setString(2,prpLverifyLossExtDto.getRiskCode());
        dbManager.setInt(3,prpLverifyLossExtDto.getSerialNo());
        dbManager.setDateTime(4,prpLverifyLossExtDto.getInputDate());
        dbManager.setString(5,prpLverifyLossExtDto.getInputHour());
        dbManager.setString(6,prpLverifyLossExtDto.getOperatorCode());
        dbManager.setString(7,prpLverifyLossExtDto.getComCode());
        dbManager.setString(8,prpLverifyLossExtDto.getTitle());
        dbManager.setString(9,prpLverifyLossExtDto.getContext());
        dbManager.setString(10,prpLverifyLossExtDto.getLossItemCode());
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
        buffer.append("INSERT INTO PrpLverifyLossExt (");
        buffer.append("RegistNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("InputDate,");
        buffer.append("InputHour,");
        buffer.append("OperatorCode,");
        buffer.append("ComCode,");
        buffer.append("title,");
        buffer.append("Context, ");
        buffer.append("LossItemCode, ");
        buffer.append("nodeType, ");
        buffer.append("status ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLverifyLossExtDto prpLverifyLossExtDto = (PrpLverifyLossExtDto)i.next();
            dbManager.setString(1,prpLverifyLossExtDto.getRegistNo());
            dbManager.setString(2,prpLverifyLossExtDto.getRiskCode());
            dbManager.setInt(3,prpLverifyLossExtDto.getSerialNo());
            dbManager.setDateTime(4,prpLverifyLossExtDto.getInputDate());
            dbManager.setString(5,prpLverifyLossExtDto.getInputHour());
            dbManager.setString(6,prpLverifyLossExtDto.getOperatorCode());
            dbManager.setString(7,prpLverifyLossExtDto.getComCode());
            dbManager.setString(8,prpLverifyLossExtDto.getTitle());
            dbManager.setString(9,prpLverifyLossExtDto.getContext());
            dbManager.setString(10,prpLverifyLossExtDto.getLossItemCode());
            dbManager.setString(11,prpLverifyLossExtDto.getNodeType());
            dbManager.setString(12,prpLverifyLossExtDto.getStatus());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registNo RegistNo
     * @param serialNo SerialNo
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,String lossItemCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLverifyLossExt ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append(" AND ");
            debugBuffer.append("LossItemCode=").append("'").append(lossItemCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,lossItemCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLverifyLossExtDto prpLverifyLossExtDto
     * @throws Exception
     */
    public void update(PrpLverifyLossExtDto prpLverifyLossExtDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLverifyLossExt SET ");
        buffer.append("RiskCode = ?, ");
        buffer.append("InputDate = ?, ");
        buffer.append("InputHour = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("ComCode = ?, ");
        buffer.append("title = ?, ");
        buffer.append("Context = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLverifyLossExt SET ");
            debugBuffer.append("RiskCode = '" + prpLverifyLossExtDto.getRiskCode() + "', ");
            debugBuffer.append("InputDate = '" + prpLverifyLossExtDto.getInputDate() + "', ");
            debugBuffer.append("InputHour = '" + prpLverifyLossExtDto.getInputHour() + "', ");
            debugBuffer.append("OperatorCode = '" + prpLverifyLossExtDto.getOperatorCode() + "', ");
            debugBuffer.append("ComCode = '" + prpLverifyLossExtDto.getComCode() + "', ");
            debugBuffer.append("title = '" + prpLverifyLossExtDto.getTitle() + "', ");
            debugBuffer.append("Context = '" + prpLverifyLossExtDto.getContext() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(prpLverifyLossExtDto.getRegistNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLverifyLossExtDto.getSerialNo()).append(" AND ");
            debugBuffer.append("LossItemCode=").append("'").append(prpLverifyLossExtDto.getLossItemCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLverifyLossExtDto.getRiskCode());
        dbManager.setDateTime(2,prpLverifyLossExtDto.getInputDate());
        dbManager.setString(3,prpLverifyLossExtDto.getInputHour());
        dbManager.setString(4,prpLverifyLossExtDto.getOperatorCode());
        dbManager.setString(5,prpLverifyLossExtDto.getComCode());
        dbManager.setString(6,prpLverifyLossExtDto.getTitle());
        dbManager.setString(7,prpLverifyLossExtDto.getContext());
        //设置条件字段;
        dbManager.setString(8,prpLverifyLossExtDto.getRegistNo());
        dbManager.setInt(9,prpLverifyLossExtDto.getSerialNo());
        dbManager.setString(10,prpLverifyLossExtDto.getLossItemCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registNo RegistNo
     * @param serialNo SerialNo
     * @return PrpLverifyLossExtDto
     * @throws Exception
     */
    public PrpLverifyLossExtDto findByPrimaryKey(String registNo,int serialNo,String lossItemCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("RegistNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("InputDate,");
        buffer.append("InputHour,");
        buffer.append("OperatorCode,");
        buffer.append("ComCode,");
        buffer.append("title,");
        buffer.append("Context, ");
        buffer.append("LossItemCode ");
        buffer.append("FROM PrpLverifyLossExt ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("  AND ");
            debugBuffer.append("LossItemCode=").append("'").append(lossItemCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,lossItemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLverifyLossExtDto prpLverifyLossExtDto = null;
        if(resultSet.next()){
            prpLverifyLossExtDto = new PrpLverifyLossExtDto();
            prpLverifyLossExtDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLverifyLossExtDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLverifyLossExtDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLverifyLossExtDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpLverifyLossExtDto.setInputHour(dbManager.getString(resultSet,5));
            prpLverifyLossExtDto.setOperatorCode(dbManager.getString(resultSet,6));
            prpLverifyLossExtDto.setComCode(dbManager.getString(resultSet,7));
            prpLverifyLossExtDto.setTitle(dbManager.getString(resultSet,8));
            prpLverifyLossExtDto.setContext(dbManager.getString(resultSet,9));
            prpLverifyLossExtDto.setLossItemCode(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        return prpLverifyLossExtDto;
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
        buffer.append("RegistNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("InputDate,");
        buffer.append("InputHour,");
        buffer.append("OperatorCode,");
        buffer.append("ComCode,");
        buffer.append("title,");
        buffer.append("Context,");
        buffer.append("LossItemCode, ");
        buffer.append("nodeType, ");
        buffer.append("status ");
        buffer.append("FROM PrpLverifyLossExt WHERE ");
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
        PrpLverifyLossExtDto prpLverifyLossExtDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLverifyLossExtDto = new PrpLverifyLossExtDto();
            prpLverifyLossExtDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLverifyLossExtDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLverifyLossExtDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLverifyLossExtDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpLverifyLossExtDto.setInputHour(dbManager.getString(resultSet,5));
            prpLverifyLossExtDto.setOperatorCode(dbManager.getString(resultSet,6));
            prpLverifyLossExtDto.setComCode(dbManager.getString(resultSet,7));
            prpLverifyLossExtDto.setTitle(dbManager.getString(resultSet,8));
            prpLverifyLossExtDto.setContext(dbManager.getString(resultSet,9));
            prpLverifyLossExtDto.setLossItemCode(dbManager.getString(resultSet,10));
            prpLverifyLossExtDto.setNodeType(dbManager.getString(resultSet,11));
            prpLverifyLossExtDto.setStatus(dbManager.getString(resultSet,12));
            collection.add(prpLverifyLossExtDto);
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
        buffer.append("DELETE FROM PrpLverifyLossExt WHERE ");
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
              statement = "SELECT count(1) FROM PrpLverifyLossExt WHERE ";
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
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getMaxSerialNo(String conditions) 
    		throws Exception{
    	int count = -1;
    	StringBuffer buffer = new StringBuffer(100);
    	String statement ;
    	statement = "SELECT max(serialNo) FROM PrpLverifyLossExt WHERE ";
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
