package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayBillDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpLpayBill的数据访问对象基类<br>
 * 创建于 2014-07-22 16:16:56.203<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpayBillBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLpayBillBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpayBillBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public void insert(PrpLpayBillDto prpLpayBillDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLpayBill (");
        buffer.append("billNo,");
        buffer.append("paymentNo,");
        buffer.append("registNo,");
        buffer.append("compensateNo,");
        buffer.append("serialNo,");
        buffer.append("payAmount, ");
        buffer.append("businessNo ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLpayBillDto.getBillNo()).append("',");
            debugBuffer.append("'").append(prpLpayBillDto.getPaymentNo()).append("',");
            debugBuffer.append("'").append(prpLpayBillDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLpayBillDto.getCompensateNo()).append("',");
            debugBuffer.append("").append(prpLpayBillDto.getSerialNo()).append(",");
            debugBuffer.append("").append(prpLpayBillDto.getPayAmount()).append(",");
            debugBuffer.append("").append(prpLpayBillDto.getBusinessNo()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1, prpLpayBillDto.getBillNo());
        dbManager.setString(2,prpLpayBillDto.getPaymentNo());
        dbManager.setString(3,prpLpayBillDto.getRegistNo());
        dbManager.setString(4,prpLpayBillDto.getCompensateNo());
        dbManager.setInt(5,prpLpayBillDto.getSerialNo());
        dbManager.setDouble(6,prpLpayBillDto.getPayAmount());
        dbManager.setString(6, prpLpayBillDto.getBusinessNo());
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
        buffer.append("INSERT INTO PrpLpayBill (");
        buffer.append("billNo,");
        buffer.append("paymentNo,");
        buffer.append("registNo,");
        buffer.append("compensateNo,");
        buffer.append("serialNo,");
        buffer.append("payAmount, ");
        buffer.append("businessNo ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLpayBillDto prpLpayBillDto = (PrpLpayBillDto)i.next();
            dbManager.setString(1, prpLpayBillDto.getBillNo());
            dbManager.setString(2,prpLpayBillDto.getPaymentNo());
            dbManager.setString(3,prpLpayBillDto.getRegistNo());
            dbManager.setString(4,prpLpayBillDto.getCompensateNo());
            dbManager.setInt(5,prpLpayBillDto.getSerialNo());
            dbManager.setDouble(6,prpLpayBillDto.getPayAmount());
            dbManager.setString(7, prpLpayBillDto.getBusinessNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param paymentNo paymentNo
     * @param registNo registNo
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(String paymentNo,String registNo,String compensateNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLpayBill ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("paymentNo=").append("'").append(paymentNo).append("' AND ");
            debugBuffer.append("registNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("compensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("paymentNo = ? And ");
        buffer.append("registNo = ? And ");
        buffer.append("compensateNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,paymentNo);
        dbManager.setString(2,registNo);
        dbManager.setString(3,compensateNo);
        dbManager.setInt(4,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public void update(PrpLpayBillDto prpLpayBillDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLpayBill SET ");
        buffer.append("payAmount = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLpayBill SET ");
            debugBuffer.append("payAmount = " + prpLpayBillDto.getPayAmount() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("paymentNo=").append("'").append(prpLpayBillDto.getPaymentNo()).append("' AND ");
            debugBuffer.append("registNo=").append("'").append(prpLpayBillDto.getRegistNo()).append("' AND ");
            debugBuffer.append("compensateNo=").append("'").append(prpLpayBillDto.getCompensateNo()).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(prpLpayBillDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("paymentNo = ? And ");
        buffer.append("registNo = ? And ");
        buffer.append("compensateNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setDouble(1,prpLpayBillDto.getPayAmount());
        //设置条件字段;
        dbManager.setString(2,prpLpayBillDto.getPaymentNo());
        dbManager.setString(3,prpLpayBillDto.getRegistNo());
        dbManager.setString(4,prpLpayBillDto.getCompensateNo());
        dbManager.setInt(5,prpLpayBillDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param paymentNo paymentNo
     * @param registNo registNo
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @return PrpLpayBillDto
     * @throws Exception
     */
    public PrpLpayBillDto findByPrimaryKey(String paymentNo,String registNo,String compensateNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("billNo,");
        buffer.append("paymentNo,");
        buffer.append("registNo,");
        buffer.append("compensateNo,");
        buffer.append("serialNo,");
        buffer.append("payAmount, ");
        buffer.append("businessNo ");
        buffer.append("FROM PrpLpayBill ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("paymentNo=").append("'").append(paymentNo).append("' AND ");
            debugBuffer.append("registNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("compensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("paymentNo = ? And ");
        buffer.append("registNo = ? And ");
        buffer.append("compensateNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,paymentNo);
        dbManager.setString(2,registNo);
        dbManager.setString(3,compensateNo);
        dbManager.setInt(4,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLpayBillDto prpLpayBillDto = null;
        if(resultSet.next()){
            prpLpayBillDto = new PrpLpayBillDto();
            prpLpayBillDto.setBillNo(dbManager.getString(resultSet, 1));
            prpLpayBillDto.setPaymentNo(dbManager.getString(resultSet,2));
            prpLpayBillDto.setRegistNo(dbManager.getString(resultSet,3));
            prpLpayBillDto.setCompensateNo(dbManager.getString(resultSet,4));
            prpLpayBillDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpLpayBillDto.setPayAmount(dbManager.getDouble(resultSet,6));
            prpLpayBillDto.setBusinessNo(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        return prpLpayBillDto;
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
        buffer.append("billNo,");
        buffer.append("paymentNo,");
        buffer.append("registNo,");
        buffer.append("compensateNo,");
        buffer.append("serialNo,");
        buffer.append("payAmount, ");
        buffer.append("businessNo ");
        buffer.append("FROM PrpLpayBill WHERE ");
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
        PrpLpayBillDto prpLpayBillDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLpayBillDto = new PrpLpayBillDto();
            prpLpayBillDto.setBillNo(dbManager.getString(resultSet,1));
            prpLpayBillDto.setPaymentNo(dbManager.getString(resultSet,2));
            prpLpayBillDto.setRegistNo(dbManager.getString(resultSet,3));
            prpLpayBillDto.setCompensateNo(dbManager.getString(resultSet,4));
            prpLpayBillDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpLpayBillDto.setPayAmount(dbManager.getDouble(resultSet,6));
            prpLpayBillDto.setBusinessNo(dbManager.getString(resultSet,7));
            collection.add(prpLpayBillDto);
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
        buffer.append("DELETE FROM PrpLpayBill WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLpayBill WHERE ");
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
    /*************************优化修改：start**************************/
    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditionsByPrepered(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLpayBill WHERE paymentNo = ? ");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1, conditions);
        int count = dbManager.executePreparedUpdate();
        return count;
    }
    /*************************优化修改：end**************************/
}
