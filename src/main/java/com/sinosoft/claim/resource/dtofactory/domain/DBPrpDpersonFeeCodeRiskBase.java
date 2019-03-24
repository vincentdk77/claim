package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDpersonFeeCodeRiskDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpDpersonFeeCodeRisk-人伤费用险种对照表的数据访问对象基类<br>
 * 创建于 2006-06-20 15:51:34.468<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpDpersonFeeCodeRiskBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpDpersonFeeCodeRiskBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDpersonFeeCodeRiskBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public void insert(PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpDpersonFeeCodeRisk (");
        buffer.append("riskCode,");
        buffer.append("feeCode,");
        buffer.append("feeCategory,");
        buffer.append("priority,");
        buffer.append("validStatus,");
        buffer.append("validDate ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpDpersonFeeCodeRiskDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpDpersonFeeCodeRiskDto.getFeeCode()).append("',");
            debugBuffer.append("'").append(prpDpersonFeeCodeRiskDto.getFeeCategory()).append("',");
            debugBuffer.append("").append(prpDpersonFeeCodeRiskDto.getPriority()).append(",");
            debugBuffer.append("").append(prpDpersonFeeCodeRiskDto.getValidStatus()).append(",");
            debugBuffer.append("'").append(prpDpersonFeeCodeRiskDto.getValidDate()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpDpersonFeeCodeRiskDto.getRiskCode());
        dbManager.setString(2,prpDpersonFeeCodeRiskDto.getFeeCode());
        dbManager.setString(3,prpDpersonFeeCodeRiskDto.getFeeCategory());
        dbManager.setInt(4,prpDpersonFeeCodeRiskDto.getPriority());
        dbManager.setInt(5,prpDpersonFeeCodeRiskDto.getValidStatus());
        dbManager.setDateTime(6,prpDpersonFeeCodeRiskDto.getValidDate());
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
        buffer.append("INSERT INTO PrpDpersonFeeCodeRisk (");
        buffer.append("riskCode,");
        buffer.append("feeCode,");
        buffer.append("feeCategory,");
        buffer.append("priority,");
        buffer.append("validStatus,");
        buffer.append("validDate ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto = (PrpDpersonFeeCodeRiskDto)i.next();
            dbManager.setString(1,prpDpersonFeeCodeRiskDto.getRiskCode());
            dbManager.setString(2,prpDpersonFeeCodeRiskDto.getFeeCode());
            dbManager.setString(3,prpDpersonFeeCodeRiskDto.getFeeCategory());
            dbManager.setInt(4,prpDpersonFeeCodeRiskDto.getPriority());
            dbManager.setInt(5,prpDpersonFeeCodeRiskDto.getValidStatus());
            dbManager.setDateTime(6,prpDpersonFeeCodeRiskDto.getValidDate());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param riskCode 险种代码
     * @param feeCode 费用代码
     * @throws Exception
     */
    public void delete(String riskCode,String feeCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpDpersonFeeCodeRisk ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("riskCode=").append("'").append(riskCode).append("' AND ");
            debugBuffer.append("feeCode=").append("'").append(feeCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("riskCode = ? And ");
        buffer.append("feeCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,feeCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public void update(PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpDpersonFeeCodeRisk SET ");
        buffer.append("feeCategory = ?, ");
        buffer.append("priority = ?, ");
        buffer.append("validStatus = ?, ");
        buffer.append("validDate = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpDpersonFeeCodeRisk SET ");
            debugBuffer.append("feeCategory = '" + prpDpersonFeeCodeRiskDto.getFeeCategory() + "', ");
            debugBuffer.append("priority = " + prpDpersonFeeCodeRiskDto.getPriority() + ", ");
            debugBuffer.append("validStatus = " + prpDpersonFeeCodeRiskDto.getValidStatus() + ", ");
            debugBuffer.append("validDate = '" + prpDpersonFeeCodeRiskDto.getValidDate() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("riskCode=").append("'").append(prpDpersonFeeCodeRiskDto.getRiskCode()).append("' AND ");
            debugBuffer.append("feeCode=").append("'").append(prpDpersonFeeCodeRiskDto.getFeeCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("riskCode = ? And ");
        buffer.append("feeCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpDpersonFeeCodeRiskDto.getFeeCategory());
        dbManager.setInt(2,prpDpersonFeeCodeRiskDto.getPriority());
        dbManager.setInt(3,prpDpersonFeeCodeRiskDto.getValidStatus());
        dbManager.setDateTime(4,prpDpersonFeeCodeRiskDto.getValidDate());
        //设置条件字段;
        dbManager.setString(5,prpDpersonFeeCodeRiskDto.getRiskCode());
        dbManager.setString(6,prpDpersonFeeCodeRiskDto.getFeeCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param riskCode 险种代码
     * @param feeCode 费用代码
     * @return PrpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public PrpDpersonFeeCodeRiskDto findByPrimaryKey(String riskCode,String feeCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("riskCode,");
        buffer.append("feeCode,");
        buffer.append("feeCategory,");
        buffer.append("priority,");
        buffer.append("validStatus,");
        buffer.append("validDate ");
        buffer.append("FROM PrpDpersonFeeCodeRisk ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("riskCode=").append("'").append(riskCode).append("' AND ");
            debugBuffer.append("feeCode=").append("'").append(feeCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("riskCode = ? And ");
        buffer.append("feeCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,feeCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto = null;
        if(resultSet.next()){
            prpDpersonFeeCodeRiskDto = new PrpDpersonFeeCodeRiskDto();
            prpDpersonFeeCodeRiskDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDpersonFeeCodeRiskDto.setFeeCode(dbManager.getString(resultSet,2));
            prpDpersonFeeCodeRiskDto.setFeeCategory(dbManager.getString(resultSet,3));
            prpDpersonFeeCodeRiskDto.setPriority(dbManager.getInt(resultSet,4));
            prpDpersonFeeCodeRiskDto.setValidStatus(dbManager.getInt(resultSet,5));
            prpDpersonFeeCodeRiskDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
        }
        resultSet.close();
        return prpDpersonFeeCodeRiskDto;
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
        buffer.append("riskCode,");
        buffer.append("feeCode,");
        buffer.append("feeCategory,");
        buffer.append("priority,");
        buffer.append("validStatus,");
        buffer.append("validDate ");
        buffer.append("FROM PrpDpersonFeeCodeRisk WHERE ");
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
        PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpDpersonFeeCodeRiskDto = new PrpDpersonFeeCodeRiskDto();
            prpDpersonFeeCodeRiskDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDpersonFeeCodeRiskDto.setFeeCode(dbManager.getString(resultSet,2));
            prpDpersonFeeCodeRiskDto.setFeeCategory(dbManager.getString(resultSet,3));
            prpDpersonFeeCodeRiskDto.setPriority(dbManager.getInt(resultSet,4));
            prpDpersonFeeCodeRiskDto.setValidStatus(dbManager.getInt(resultSet,5));
            prpDpersonFeeCodeRiskDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            collection.add(prpDpersonFeeCodeRiskDto);
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
        buffer.append("DELETE FROM PrpDpersonFeeCodeRisk WHERE ");
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
        String  statement ;
            statement ="SELECT count(1) FROM PrpDpersonFeeCodeRisk WHERE ";
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
