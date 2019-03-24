package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLAcciCheckChargeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是调查费用表-PrpLAcciCheckCharge的数据访问对象基类<br>
 * 创建于 2006-01-23 15:30:13.765<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLAcciCheckChargeBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLAcciCheckChargeBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLAcciCheckChargeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public void insert(PrpLAcciCheckChargeDto prpLAcciCheckChargeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLAcciCheckCharge (");
        buffer.append("CheckNo,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("ChargeAmount ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLAcciCheckChargeDto.getCheckNo()).append("',");
            debugBuffer.append("").append(prpLAcciCheckChargeDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLAcciCheckChargeDto.getChargeCode()).append("',");
            debugBuffer.append("'").append(prpLAcciCheckChargeDto.getChargeName()).append("',");
            debugBuffer.append("'").append(prpLAcciCheckChargeDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLAcciCheckChargeDto.getChargeAmount()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLAcciCheckChargeDto.getCheckNo());
        dbManager.setInt(2,prpLAcciCheckChargeDto.getSerialNo());
        dbManager.setString(3,prpLAcciCheckChargeDto.getChargeCode());
        dbManager.setString(4,prpLAcciCheckChargeDto.getChargeName());
        dbManager.setString(5,prpLAcciCheckChargeDto.getCurrency());
        dbManager.setDouble(6,prpLAcciCheckChargeDto.getChargeAmount());
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
        buffer.append("INSERT INTO PrpLAcciCheckCharge (");
        buffer.append("CheckNo,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("ChargeAmount ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLAcciCheckChargeDto prpLAcciCheckChargeDto = (PrpLAcciCheckChargeDto)i.next();
            dbManager.setString(1,prpLAcciCheckChargeDto.getCheckNo());
            dbManager.setInt(2,prpLAcciCheckChargeDto.getSerialNo());
            dbManager.setString(3,prpLAcciCheckChargeDto.getChargeCode());
            dbManager.setString(4,prpLAcciCheckChargeDto.getChargeName());
            dbManager.setString(5,prpLAcciCheckChargeDto.getCurrency());
            dbManager.setDouble(6,prpLAcciCheckChargeDto.getChargeAmount());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param checkNo 调查号-CheckNo
     * @param serialNo 序号-SerialNo
     * @throws Exception
     */
    public void delete(String checkNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLAcciCheckCharge ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CheckNo=").append("'").append(checkNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CheckNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,checkNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public void update(PrpLAcciCheckChargeDto prpLAcciCheckChargeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLAcciCheckCharge SET ");
        buffer.append("ChargeCode = ?, ");
        buffer.append("ChargeName = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("ChargeAmount = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLAcciCheckCharge SET ");
            debugBuffer.append("ChargeCode = '" + prpLAcciCheckChargeDto.getChargeCode() + "', ");
            debugBuffer.append("ChargeName = '" + prpLAcciCheckChargeDto.getChargeName() + "', ");
            debugBuffer.append("Currency = '" + prpLAcciCheckChargeDto.getCurrency() + "', ");
            debugBuffer.append("ChargeAmount = " + prpLAcciCheckChargeDto.getChargeAmount() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("CheckNo=").append("'").append(prpLAcciCheckChargeDto.getCheckNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLAcciCheckChargeDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CheckNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLAcciCheckChargeDto.getChargeCode());
        dbManager.setString(2,prpLAcciCheckChargeDto.getChargeName());
        dbManager.setString(3,prpLAcciCheckChargeDto.getCurrency());
        dbManager.setDouble(4,prpLAcciCheckChargeDto.getChargeAmount());
        //设置条件字段;
        dbManager.setString(5,prpLAcciCheckChargeDto.getCheckNo());
        dbManager.setInt(6,prpLAcciCheckChargeDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param checkNo 调查号-CheckNo
     * @param serialNo 序号-SerialNo
     * @return PrpLAcciCheckChargeDto
     * @throws Exception
     */
    public PrpLAcciCheckChargeDto findByPrimaryKey(String checkNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CheckNo,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("ChargeAmount ");
        buffer.append("FROM PrpLAcciCheckCharge ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CheckNo=").append("'").append(checkNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CheckNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,checkNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLAcciCheckChargeDto prpLAcciCheckChargeDto = null;
        if(resultSet.next()){
            prpLAcciCheckChargeDto = new PrpLAcciCheckChargeDto();
            prpLAcciCheckChargeDto.setCheckNo(dbManager.getString(resultSet,1));
            prpLAcciCheckChargeDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLAcciCheckChargeDto.setChargeCode(dbManager.getString(resultSet,3));
            prpLAcciCheckChargeDto.setChargeName(dbManager.getString(resultSet,4));
            prpLAcciCheckChargeDto.setCurrency(dbManager.getString(resultSet,5));
            prpLAcciCheckChargeDto.setChargeAmount(dbManager.getDouble(resultSet,6));
        }else{
            logger.info("DBPrpLAcciCheckChargeBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLAcciCheckChargeDto;
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
        buffer.append("CheckNo,");
        buffer.append("SerialNo,");
        buffer.append("ChargeCode,");
        buffer.append("ChargeName,");
        buffer.append("Currency,");
        buffer.append("ChargeAmount ");
        buffer.append("FROM PrpLAcciCheckCharge WHERE ");
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
        PrpLAcciCheckChargeDto prpLAcciCheckChargeDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLAcciCheckChargeDto = new PrpLAcciCheckChargeDto();
            prpLAcciCheckChargeDto.setCheckNo(dbManager.getString(resultSet,1));
            prpLAcciCheckChargeDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLAcciCheckChargeDto.setChargeCode(dbManager.getString(resultSet,3));
            prpLAcciCheckChargeDto.setChargeName(dbManager.getString(resultSet,4));
            prpLAcciCheckChargeDto.setCurrency(dbManager.getString(resultSet,5));
            prpLAcciCheckChargeDto.setChargeAmount(dbManager.getDouble(resultSet,6));
            collection.add(prpLAcciCheckChargeDto);
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
        buffer.append("DELETE FROM PrpLAcciCheckCharge WHERE ");
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
                          statement = "SELECT count(1) FROM PrpLAcciCheckCharge WHERE ";
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
