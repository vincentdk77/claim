package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaimBillManager的数据访问对象基类<br>
 * 创建于 2014-07-30 15:51:55.500<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLclaimBillManagerBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLclaimBillManagerBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimBillManagerBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimBillManagerDto prpLclaimBillManagerDto
     * @throws Exception
     */
    public void insert(PrpLclaimBillManagerDto prpLclaimBillManagerDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLclaimBillManager (");
        buffer.append("registNo,");
        buffer.append("policyNo,");
        buffer.append("compensateNo,");
        buffer.append("serialNo,");
        buffer.append("payName,");
        buffer.append("identifyNumber,");
        buffer.append("insuredCode,");
        buffer.append("provinceName,");
        buffer.append("cityName,");
        buffer.append("accountType,");
        buffer.append("bankName,");
        buffer.append("openBank,");
        buffer.append("bankAccount,");
        buffer.append("sumPaid,");
        buffer.append("payAmount,");
        buffer.append("payFlag,");
        buffer.append("mobilePhone,");
        buffer.append("address,");
        buffer.append("accountFlag,");
        buffer.append("flag,");
        buffer.append("operatorCode,");
        buffer.append("routeNum ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getCompensateNo()).append("',");
            debugBuffer.append("").append(prpLclaimBillManagerDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getPayName()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getIdentifyNumber()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getInsuredCode()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getProvinceName()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getCityName()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getAccountType()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getBankName()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getOpenBank()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getBankAccount()).append("',");
            debugBuffer.append("").append(prpLclaimBillManagerDto.getSumPaid()).append(",");
            debugBuffer.append("").append(prpLclaimBillManagerDto.getPayAmount()).append(",");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getPayFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getMobilePhone()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getAddress()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getAccountFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagerDto.getRouteNum()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLclaimBillManagerDto.getRegistNo());
        dbManager.setString(2,prpLclaimBillManagerDto.getPolicyNo());
        dbManager.setString(3,prpLclaimBillManagerDto.getCompensateNo());
        dbManager.setInt(4,prpLclaimBillManagerDto.getSerialNo());
        dbManager.setString(5,prpLclaimBillManagerDto.getPayName());
        dbManager.setString(6,prpLclaimBillManagerDto.getIdentifyNumber());
        dbManager.setString(7,prpLclaimBillManagerDto.getInsuredCode());
        dbManager.setString(8,prpLclaimBillManagerDto.getProvinceName());
        dbManager.setString(9,prpLclaimBillManagerDto.getCityName());
        dbManager.setString(10,prpLclaimBillManagerDto.getAccountType());
        dbManager.setString(11,prpLclaimBillManagerDto.getBankName());
        dbManager.setString(12,prpLclaimBillManagerDto.getOpenBank());
        dbManager.setString(13,prpLclaimBillManagerDto.getBankAccount());
        dbManager.setDouble(14,prpLclaimBillManagerDto.getSumPaid());
        dbManager.setDouble(15,prpLclaimBillManagerDto.getPayAmount());
        dbManager.setString(16,prpLclaimBillManagerDto.getPayFlag());
        dbManager.setString(17,prpLclaimBillManagerDto.getMobilePhone());
        dbManager.setString(18,prpLclaimBillManagerDto.getAddress());
        dbManager.setString(19,prpLclaimBillManagerDto.getAccountFlag());
        dbManager.setString(20,prpLclaimBillManagerDto.getFlag());
        dbManager.setString(21,prpLclaimBillManagerDto.getOperatorCode());
        dbManager.setString(22,prpLclaimBillManagerDto.getRouteNum());
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
        buffer.append("INSERT INTO PrpLclaimBillManager (");
        buffer.append("registNo,");
        buffer.append("policyNo,");
        buffer.append("compensateNo,");
        buffer.append("serialNo,");
        buffer.append("payName,");
        buffer.append("identifyNumber,");
        buffer.append("insuredCode,");
        buffer.append("provinceName,");
        buffer.append("cityName,");
        buffer.append("accountType,");
        buffer.append("bankName,");
        buffer.append("openBank,");
        buffer.append("bankAccount,");
        buffer.append("sumPaid,");
        buffer.append("payAmount,");
        buffer.append("payFlag,");
        buffer.append("mobilePhone,");
        buffer.append("address,");
        buffer.append("accountFlag,");
        buffer.append("flag,");
        buffer.append("operatorCode,");
        buffer.append("routeNum ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimBillManagerDto prpLclaimBillManagerDto = (PrpLclaimBillManagerDto)i.next();
            dbManager.setString(1,prpLclaimBillManagerDto.getRegistNo());
            dbManager.setString(2,prpLclaimBillManagerDto.getPolicyNo());
            dbManager.setString(3,prpLclaimBillManagerDto.getCompensateNo());
            dbManager.setInt(4,prpLclaimBillManagerDto.getSerialNo());
            dbManager.setString(5,prpLclaimBillManagerDto.getPayName());
            dbManager.setString(6,prpLclaimBillManagerDto.getIdentifyNumber());
            dbManager.setString(7,prpLclaimBillManagerDto.getInsuredCode());
            dbManager.setString(8,prpLclaimBillManagerDto.getProvinceName());
            dbManager.setString(9,prpLclaimBillManagerDto.getCityName());
            dbManager.setString(10,prpLclaimBillManagerDto.getAccountType());
            dbManager.setString(11,prpLclaimBillManagerDto.getBankName());
            dbManager.setString(12,prpLclaimBillManagerDto.getOpenBank());
            dbManager.setString(13,prpLclaimBillManagerDto.getBankAccount());
            dbManager.setDouble(14,prpLclaimBillManagerDto.getSumPaid());
            dbManager.setDouble(15,prpLclaimBillManagerDto.getPayAmount());
            dbManager.setString(16,prpLclaimBillManagerDto.getPayFlag());
            dbManager.setString(17,prpLclaimBillManagerDto.getMobilePhone());
            dbManager.setString(18,prpLclaimBillManagerDto.getAddress());
            dbManager.setString(19,prpLclaimBillManagerDto.getAccountFlag());
            dbManager.setString(20,prpLclaimBillManagerDto.getFlag());
            dbManager.setString(21,prpLclaimBillManagerDto.getOperatorCode());
            dbManager.setString(22,prpLclaimBillManagerDto.getRouteNum());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registNo registNo
     * @throws Exception
     */
    public void delete(String registNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLclaimBillManager ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("registNo=").append("'").append(registNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("registNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLclaimBillManagerDto prpLclaimBillManagerDto
     * @throws Exception
     */
    public void update(PrpLclaimBillManagerDto prpLclaimBillManagerDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLclaimBillManager SET ");
        buffer.append("policyNo = ?, ");
        buffer.append("compensateNo = ?, ");
        buffer.append("serialNo = ?, ");
        buffer.append("payName = ?, ");
        buffer.append("identifyNumber = ?, ");
        buffer.append("insuredCode = ?, ");
        buffer.append("provinceName = ?, ");
        buffer.append("cityName = ?, ");
        buffer.append("accountType = ?, ");
        buffer.append("bankName = ?, ");
        buffer.append("openBank = ?, ");
        buffer.append("bankAccount = ?, ");
        buffer.append("sumPaid = ?, ");
        buffer.append("payAmount = ?, ");
        buffer.append("payFlag = ?, ");
        buffer.append("mobilePhone = ?, ");
        buffer.append("address = ?, ");
        buffer.append("accountFlag = ?, ");
        buffer.append("flag = ?, ");
        buffer.append("operatorCode = ?, ");
        buffer.append("routeNum = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLclaimBillManager SET ");
            debugBuffer.append("policyNo = '" + prpLclaimBillManagerDto.getPolicyNo() + "', ");
            debugBuffer.append("compensateNo = '" + prpLclaimBillManagerDto.getCompensateNo() + "', ");
            debugBuffer.append("serialNo = " + prpLclaimBillManagerDto.getSerialNo() + ", ");
            debugBuffer.append("payName = '" + prpLclaimBillManagerDto.getPayName() + "', ");
            debugBuffer.append("identifyNumber = '" + prpLclaimBillManagerDto.getIdentifyNumber() + "', ");
            debugBuffer.append("insuredCode = '" + prpLclaimBillManagerDto.getInsuredCode() + "', ");
            debugBuffer.append("provinceName = '" + prpLclaimBillManagerDto.getProvinceName() + "', ");
            debugBuffer.append("cityName = '" + prpLclaimBillManagerDto.getCityName() + "', ");
            debugBuffer.append("accountType = '" + prpLclaimBillManagerDto.getAccountType() + "', ");
            debugBuffer.append("bankName = '" + prpLclaimBillManagerDto.getBankName() + "', ");
            debugBuffer.append("openBank = '" + prpLclaimBillManagerDto.getOpenBank() + "', ");
            debugBuffer.append("bankAccount = '" + prpLclaimBillManagerDto.getBankAccount() + "', ");
            debugBuffer.append("sumPaid = " + prpLclaimBillManagerDto.getSumPaid() + ", ");
            debugBuffer.append("payAmount = " + prpLclaimBillManagerDto.getPayAmount() + ", ");
            debugBuffer.append("payFlag = '" + prpLclaimBillManagerDto.getPayFlag() + "', ");
            debugBuffer.append("mobilePhone = '" + prpLclaimBillManagerDto.getMobilePhone() + "', ");
            debugBuffer.append("address = '" + prpLclaimBillManagerDto.getAddress() + "', ");
            debugBuffer.append("accountFlag = '" + prpLclaimBillManagerDto.getAccountFlag() + "', ");
            debugBuffer.append("flag = '" + prpLclaimBillManagerDto.getFlag() + "', ");
            debugBuffer.append("operatorCode = '" + prpLclaimBillManagerDto.getOperatorCode() + "', ");
            debugBuffer.append("routeNum = '" + prpLclaimBillManagerDto.getRouteNum() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("registNo=").append("'").append(prpLclaimBillManagerDto.getRegistNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("registNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLclaimBillManagerDto.getPolicyNo());
        dbManager.setString(2,prpLclaimBillManagerDto.getCompensateNo());
        dbManager.setInt(3,prpLclaimBillManagerDto.getSerialNo());
        dbManager.setString(4,prpLclaimBillManagerDto.getPayName());
        dbManager.setString(5,prpLclaimBillManagerDto.getIdentifyNumber());
        dbManager.setString(6,prpLclaimBillManagerDto.getInsuredCode());
        dbManager.setString(7,prpLclaimBillManagerDto.getProvinceName());
        dbManager.setString(8,prpLclaimBillManagerDto.getCityName());
        dbManager.setString(9,prpLclaimBillManagerDto.getAccountType());
        dbManager.setString(10,prpLclaimBillManagerDto.getBankName());
        dbManager.setString(11,prpLclaimBillManagerDto.getOpenBank());
        dbManager.setString(12,prpLclaimBillManagerDto.getBankAccount());
        dbManager.setDouble(13,prpLclaimBillManagerDto.getSumPaid());
        dbManager.setDouble(14,prpLclaimBillManagerDto.getPayAmount());
        dbManager.setString(15,prpLclaimBillManagerDto.getPayFlag());
        dbManager.setString(16,prpLclaimBillManagerDto.getMobilePhone());
        dbManager.setString(17,prpLclaimBillManagerDto.getAddress());
        dbManager.setString(18,prpLclaimBillManagerDto.getAccountFlag());
        dbManager.setString(19,prpLclaimBillManagerDto.getFlag());
        dbManager.setString(20,prpLclaimBillManagerDto.getOperatorCode());
        dbManager.setString(21,prpLclaimBillManagerDto.getRouteNum());
        //设置条件字段;
        dbManager.setString(22,prpLclaimBillManagerDto.getRegistNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registNo registNo
     * @return PrpLclaimBillManagerDto
     * @throws Exception
     */
    public PrpLclaimBillManagerDto findByPrimaryKey(String registNo,String compensateNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("registNo,");
        buffer.append("policyNo,");
        buffer.append("compensateNo,");
        buffer.append("serialNo,");
        buffer.append("payName,");
        buffer.append("identifyNumber,");
        buffer.append("insuredCode,");
        buffer.append("provinceName,");
        buffer.append("cityName,");
        buffer.append("accountType,");
        buffer.append("bankName,");
        buffer.append("openBank,");
        buffer.append("bankAccount,");
        buffer.append("sumPaid,");
        buffer.append("payAmount,");
        buffer.append("payFlag,");
        buffer.append("mobilePhone,");
        buffer.append("address,");
        buffer.append("accountFlag,");
        buffer.append("flag,");
        buffer.append("operatorCode,");
        buffer.append("routeNum ");
        buffer.append("FROM PrpLclaimBillManager ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("registNo=").append("'").append(registNo).append("'");
            debugBuffer.append("and compensateNo=").append("'").append(compensateNo).append("'");
            debugBuffer.append("and serialNo=").append(serialNo);
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("registNo = ? And ");
        buffer.append("compensateNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,compensateNo);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLclaimBillManagerDto prpLclaimBillManagerDto = null;
        if(resultSet.next()){
            prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
            prpLclaimBillManagerDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimBillManagerDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimBillManagerDto.setCompensateNo(dbManager.getString(resultSet,3));
            prpLclaimBillManagerDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLclaimBillManagerDto.setPayName(dbManager.getString(resultSet,5));
            prpLclaimBillManagerDto.setIdentifyNumber(dbManager.getString(resultSet,6));
            prpLclaimBillManagerDto.setInsuredCode(dbManager.getString(resultSet,7));
            prpLclaimBillManagerDto.setProvinceName(dbManager.getString(resultSet,8));
            prpLclaimBillManagerDto.setCityName(dbManager.getString(resultSet,9));
            prpLclaimBillManagerDto.setAccountType(dbManager.getString(resultSet,10));
            prpLclaimBillManagerDto.setBankName(dbManager.getString(resultSet,11));
            prpLclaimBillManagerDto.setOpenBank(dbManager.getString(resultSet,12));
            prpLclaimBillManagerDto.setBankAccount(dbManager.getString(resultSet,13));
            prpLclaimBillManagerDto.setSumPaid(dbManager.getDouble(resultSet,14));
            prpLclaimBillManagerDto.setPayAmount(dbManager.getDouble(resultSet,15));
            prpLclaimBillManagerDto.setPayFlag(dbManager.getString(resultSet,16));
            prpLclaimBillManagerDto.setMobilePhone(dbManager.getString(resultSet,17));
            prpLclaimBillManagerDto.setAddress(dbManager.getString(resultSet,18));
            prpLclaimBillManagerDto.setAccountFlag(dbManager.getString(resultSet,19));
            prpLclaimBillManagerDto.setFlag(dbManager.getString(resultSet,20));
            prpLclaimBillManagerDto.setOperatorCode(dbManager.getString(resultSet,21));
            prpLclaimBillManagerDto.setRouteNum(dbManager.getString(resultSet,22));
        }
        resultSet.close();
        return prpLclaimBillManagerDto;
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
        buffer.append("registNo,");
        buffer.append("policyNo,");
        buffer.append("compensateNo,");
        buffer.append("serialNo,");
        buffer.append("payName,");
        buffer.append("identifyNumber,");
        buffer.append("insuredCode,");
        buffer.append("provinceName,");
        buffer.append("cityName,");
        buffer.append("accountType,");
        buffer.append("bankName,");
        buffer.append("openBank,");
        buffer.append("bankAccount,");
        buffer.append("sumPaid,");
        buffer.append("payAmount,");
        buffer.append("payFlag,");
        buffer.append("mobilePhone,");
        buffer.append("address,");
        buffer.append("accountFlag,");
        buffer.append("flag,");
        buffer.append("operatorCode,");
        buffer.append("routeNum ");
        buffer.append("FROM PrpLclaimBillManager WHERE ");
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
        PrpLclaimBillManagerDto prpLclaimBillManagerDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
            prpLclaimBillManagerDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimBillManagerDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimBillManagerDto.setCompensateNo(dbManager.getString(resultSet,3));
            prpLclaimBillManagerDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLclaimBillManagerDto.setPayName(dbManager.getString(resultSet,5));
            prpLclaimBillManagerDto.setIdentifyNumber(dbManager.getString(resultSet,6));
            prpLclaimBillManagerDto.setInsuredCode(dbManager.getString(resultSet,7));
            prpLclaimBillManagerDto.setProvinceName(dbManager.getString(resultSet,8));
            prpLclaimBillManagerDto.setCityName(dbManager.getString(resultSet,9));
            prpLclaimBillManagerDto.setAccountType(dbManager.getString(resultSet,10));
            prpLclaimBillManagerDto.setBankName(dbManager.getString(resultSet,11));
            prpLclaimBillManagerDto.setOpenBank(dbManager.getString(resultSet,12));
            prpLclaimBillManagerDto.setBankAccount(dbManager.getString(resultSet,13));
            prpLclaimBillManagerDto.setSumPaid(dbManager.getDouble(resultSet,14));
            prpLclaimBillManagerDto.setPayAmount(dbManager.getDouble(resultSet,15));
            prpLclaimBillManagerDto.setPayFlag(dbManager.getString(resultSet,16));
            prpLclaimBillManagerDto.setMobilePhone(dbManager.getString(resultSet,17));
            prpLclaimBillManagerDto.setAddress(dbManager.getString(resultSet,18));
            prpLclaimBillManagerDto.setAccountFlag(dbManager.getString(resultSet,19));
            prpLclaimBillManagerDto.setFlag(dbManager.getString(resultSet,20));
            prpLclaimBillManagerDto.setOperatorCode(dbManager.getString(resultSet,21));
            prpLclaimBillManagerDto.setRouteNum(dbManager.getString(resultSet,22));
            collection.add(prpLclaimBillManagerDto);
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
        buffer.append("DELETE FROM PrpLclaimBillManager WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLclaimBillManager WHERE ");
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
