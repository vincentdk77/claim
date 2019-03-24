package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagertgDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaimBillManager的数据访问对象基类<br>
 * 创建于 2014-07-30 15:51:55.500<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLclaimBillManagertgBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLclaimBillManagertgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimBillManagertgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimBillManagertgDto prpLclaimBillManagertgDto
     * @throws Exception
     */
    public void insert(PrpLclaimBillManagertgDto prpLclaimBillManagertgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLclaimBillManagertg (");
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
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getCompensateNo()).append("',");
            debugBuffer.append("").append(prpLclaimBillManagertgDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getPayName()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getIdentifyNumber()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getInsuredCode()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getProvinceName()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getCityName()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getAccountType()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getBankName()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getOpenBank()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getBankAccount()).append("',");
            debugBuffer.append("").append(prpLclaimBillManagertgDto.getSumPaid()).append(",");
            debugBuffer.append("").append(prpLclaimBillManagertgDto.getPayAmount()).append(",");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getPayFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getMobilePhone()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getAddress()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getAccountFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLclaimBillManagertgDto.getRouteNum()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLclaimBillManagertgDto.getRegistNo());
        dbManager.setString(2,prpLclaimBillManagertgDto.getPolicyNo());
        dbManager.setString(3,prpLclaimBillManagertgDto.getCompensateNo());
        dbManager.setInt(4,prpLclaimBillManagertgDto.getSerialNo());
        dbManager.setString(5,prpLclaimBillManagertgDto.getPayName());
        dbManager.setString(6,prpLclaimBillManagertgDto.getIdentifyNumber());
        dbManager.setString(7,prpLclaimBillManagertgDto.getInsuredCode());
        dbManager.setString(8,prpLclaimBillManagertgDto.getProvinceName());
        dbManager.setString(9,prpLclaimBillManagertgDto.getCityName());
        dbManager.setString(10,prpLclaimBillManagertgDto.getAccountType());
        dbManager.setString(11,prpLclaimBillManagertgDto.getBankName());
        dbManager.setString(12,prpLclaimBillManagertgDto.getOpenBank());
        dbManager.setString(13,prpLclaimBillManagertgDto.getBankAccount());
        dbManager.setDouble(14,prpLclaimBillManagertgDto.getSumPaid());
        dbManager.setDouble(15,prpLclaimBillManagertgDto.getPayAmount());
        dbManager.setString(16,prpLclaimBillManagertgDto.getPayFlag());
        dbManager.setString(17,prpLclaimBillManagertgDto.getMobilePhone());
        dbManager.setString(18,prpLclaimBillManagertgDto.getAddress());
        dbManager.setString(19,prpLclaimBillManagertgDto.getAccountFlag());
        dbManager.setString(20,prpLclaimBillManagertgDto.getFlag());
        dbManager.setString(21,prpLclaimBillManagertgDto.getOperatorCode());
        dbManager.setString(22,prpLclaimBillManagertgDto.getRouteNum());
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
        buffer.append("INSERT INTO PrpLclaimBillManagertg (");
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
            PrpLclaimBillManagertgDto prpLclaimBillManagertgDto = (PrpLclaimBillManagertgDto)i.next();
            dbManager.setString(1,prpLclaimBillManagertgDto.getRegistNo());
            dbManager.setString(2,prpLclaimBillManagertgDto.getPolicyNo());
            dbManager.setString(3,prpLclaimBillManagertgDto.getCompensateNo());
            dbManager.setInt(4,prpLclaimBillManagertgDto.getSerialNo());
            dbManager.setString(5,prpLclaimBillManagertgDto.getPayName());
            dbManager.setString(6,prpLclaimBillManagertgDto.getIdentifyNumber());
            dbManager.setString(7,prpLclaimBillManagertgDto.getInsuredCode());
            dbManager.setString(8,prpLclaimBillManagertgDto.getProvinceName());
            dbManager.setString(9,prpLclaimBillManagertgDto.getCityName());
            dbManager.setString(10,prpLclaimBillManagertgDto.getAccountType());
            dbManager.setString(11,prpLclaimBillManagertgDto.getBankName());
            dbManager.setString(12,prpLclaimBillManagertgDto.getOpenBank());
            dbManager.setString(13,prpLclaimBillManagertgDto.getBankAccount());
            dbManager.setDouble(14,prpLclaimBillManagertgDto.getSumPaid());
            dbManager.setDouble(15,prpLclaimBillManagertgDto.getPayAmount());
            dbManager.setString(16,prpLclaimBillManagertgDto.getPayFlag());
            dbManager.setString(17,prpLclaimBillManagertgDto.getMobilePhone());
            dbManager.setString(18,prpLclaimBillManagertgDto.getAddress());
            dbManager.setString(19,prpLclaimBillManagertgDto.getAccountFlag());
            dbManager.setString(20,prpLclaimBillManagertgDto.getFlag());
            dbManager.setString(21,prpLclaimBillManagertgDto.getOperatorCode());
            dbManager.setString(22,prpLclaimBillManagertgDto.getRouteNum());
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
        buffer.append("DELETE FROM PrpLclaimBillManagertg ");
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
     * @param prpLclaimBillManagertgDto prpLclaimBillManagertgDto
     * @throws Exception
     */
    public void update(PrpLclaimBillManagertgDto prpLclaimBillManagertgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLclaimBillManagertg SET ");
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
            debugBuffer.append("UPDATE PrpLclaimBillManagertg SET ");
            debugBuffer.append("policyNo = '" + prpLclaimBillManagertgDto.getPolicyNo() + "', ");
            debugBuffer.append("compensateNo = '" + prpLclaimBillManagertgDto.getCompensateNo() + "', ");
            debugBuffer.append("serialNo = " + prpLclaimBillManagertgDto.getSerialNo() + ", ");
            debugBuffer.append("payName = '" + prpLclaimBillManagertgDto.getPayName() + "', ");
            debugBuffer.append("identifyNumber = '" + prpLclaimBillManagertgDto.getIdentifyNumber() + "', ");
            debugBuffer.append("insuredCode = '" + prpLclaimBillManagertgDto.getInsuredCode() + "', ");
            debugBuffer.append("provinceName = '" + prpLclaimBillManagertgDto.getProvinceName() + "', ");
            debugBuffer.append("cityName = '" + prpLclaimBillManagertgDto.getCityName() + "', ");
            debugBuffer.append("accountType = '" + prpLclaimBillManagertgDto.getAccountType() + "', ");
            debugBuffer.append("bankName = '" + prpLclaimBillManagertgDto.getBankName() + "', ");
            debugBuffer.append("openBank = '" + prpLclaimBillManagertgDto.getOpenBank() + "', ");
            debugBuffer.append("bankAccount = '" + prpLclaimBillManagertgDto.getBankAccount() + "', ");
            debugBuffer.append("sumPaid = " + prpLclaimBillManagertgDto.getSumPaid() + ", ");
            debugBuffer.append("payAmount = " + prpLclaimBillManagertgDto.getPayAmount() + ", ");
            debugBuffer.append("payFlag = '" + prpLclaimBillManagertgDto.getPayFlag() + "', ");
            debugBuffer.append("mobilePhone = '" + prpLclaimBillManagertgDto.getMobilePhone() + "', ");
            debugBuffer.append("address = '" + prpLclaimBillManagertgDto.getAddress() + "', ");
            debugBuffer.append("accountFlag = '" + prpLclaimBillManagertgDto.getAccountFlag() + "', ");
            debugBuffer.append("flag = '" + prpLclaimBillManagertgDto.getFlag() + "', ");
            debugBuffer.append("operatorCode = '" + prpLclaimBillManagertgDto.getOperatorCode() + "', ");
            debugBuffer.append("routeNum = '" + prpLclaimBillManagertgDto.getRouteNum() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("registNo=").append("'").append(prpLclaimBillManagertgDto.getRegistNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("registNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLclaimBillManagertgDto.getPolicyNo());
        dbManager.setString(2,prpLclaimBillManagertgDto.getCompensateNo());
        dbManager.setInt(3,prpLclaimBillManagertgDto.getSerialNo());
        dbManager.setString(4,prpLclaimBillManagertgDto.getPayName());
        dbManager.setString(5,prpLclaimBillManagertgDto.getIdentifyNumber());
        dbManager.setString(6,prpLclaimBillManagertgDto.getInsuredCode());
        dbManager.setString(7,prpLclaimBillManagertgDto.getProvinceName());
        dbManager.setString(8,prpLclaimBillManagertgDto.getCityName());
        dbManager.setString(9,prpLclaimBillManagertgDto.getAccountType());
        dbManager.setString(10,prpLclaimBillManagertgDto.getBankName());
        dbManager.setString(11,prpLclaimBillManagertgDto.getOpenBank());
        dbManager.setString(12,prpLclaimBillManagertgDto.getBankAccount());
        dbManager.setDouble(13,prpLclaimBillManagertgDto.getSumPaid());
        dbManager.setDouble(14,prpLclaimBillManagertgDto.getPayAmount());
        dbManager.setString(15,prpLclaimBillManagertgDto.getPayFlag());
        dbManager.setString(16,prpLclaimBillManagertgDto.getMobilePhone());
        dbManager.setString(17,prpLclaimBillManagertgDto.getAddress());
        dbManager.setString(18,prpLclaimBillManagertgDto.getAccountFlag());
        dbManager.setString(19,prpLclaimBillManagertgDto.getFlag());
        dbManager.setString(20,prpLclaimBillManagertgDto.getOperatorCode());
        dbManager.setString(21,prpLclaimBillManagertgDto.getRouteNum());
        //设置条件字段;
        dbManager.setString(22,prpLclaimBillManagertgDto.getRegistNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registNo registNo
     * @return PrpLclaimBillManagertgDto
     * @throws Exception
     */
    public PrpLclaimBillManagertgDto findByPrimaryKey(String registNo,String compensateNo,int serialNo)
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
        buffer.append("FROM PrpLclaimBillManagertg ");
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
        PrpLclaimBillManagertgDto prpLclaimBillManagertgDto = null;
        if(resultSet.next()){
            prpLclaimBillManagertgDto = new PrpLclaimBillManagertgDto();
            prpLclaimBillManagertgDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimBillManagertgDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimBillManagertgDto.setCompensateNo(dbManager.getString(resultSet,3));
            prpLclaimBillManagertgDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLclaimBillManagertgDto.setPayName(dbManager.getString(resultSet,5));
            prpLclaimBillManagertgDto.setIdentifyNumber(dbManager.getString(resultSet,6));
            prpLclaimBillManagertgDto.setInsuredCode(dbManager.getString(resultSet,7));
            prpLclaimBillManagertgDto.setProvinceName(dbManager.getString(resultSet,8));
            prpLclaimBillManagertgDto.setCityName(dbManager.getString(resultSet,9));
            prpLclaimBillManagertgDto.setAccountType(dbManager.getString(resultSet,10));
            prpLclaimBillManagertgDto.setBankName(dbManager.getString(resultSet,11));
            prpLclaimBillManagertgDto.setOpenBank(dbManager.getString(resultSet,12));
            prpLclaimBillManagertgDto.setBankAccount(dbManager.getString(resultSet,13));
            prpLclaimBillManagertgDto.setSumPaid(dbManager.getDouble(resultSet,14));
            prpLclaimBillManagertgDto.setPayAmount(dbManager.getDouble(resultSet,15));
            prpLclaimBillManagertgDto.setPayFlag(dbManager.getString(resultSet,16));
            prpLclaimBillManagertgDto.setMobilePhone(dbManager.getString(resultSet,17));
            prpLclaimBillManagertgDto.setAddress(dbManager.getString(resultSet,18));
            prpLclaimBillManagertgDto.setAccountFlag(dbManager.getString(resultSet,19));
            prpLclaimBillManagertgDto.setFlag(dbManager.getString(resultSet,20));
            prpLclaimBillManagertgDto.setOperatorCode(dbManager.getString(resultSet,21));
            prpLclaimBillManagertgDto.setRouteNum(dbManager.getString(resultSet,22));
        }
        resultSet.close();
        return prpLclaimBillManagertgDto;
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
        buffer.append("FROM PrpLclaimBillManagertg WHERE ");
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
        PrpLclaimBillManagertgDto prpLclaimBillManagertgDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLclaimBillManagertgDto = new PrpLclaimBillManagertgDto();
            prpLclaimBillManagertgDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimBillManagertgDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimBillManagertgDto.setCompensateNo(dbManager.getString(resultSet,3));
            prpLclaimBillManagertgDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLclaimBillManagertgDto.setPayName(dbManager.getString(resultSet,5));
            prpLclaimBillManagertgDto.setIdentifyNumber(dbManager.getString(resultSet,6));
            prpLclaimBillManagertgDto.setInsuredCode(dbManager.getString(resultSet,7));
            prpLclaimBillManagertgDto.setProvinceName(dbManager.getString(resultSet,8));
            prpLclaimBillManagertgDto.setCityName(dbManager.getString(resultSet,9));
            prpLclaimBillManagertgDto.setAccountType(dbManager.getString(resultSet,10));
            prpLclaimBillManagertgDto.setBankName(dbManager.getString(resultSet,11));
            prpLclaimBillManagertgDto.setOpenBank(dbManager.getString(resultSet,12));
            prpLclaimBillManagertgDto.setBankAccount(dbManager.getString(resultSet,13));
            prpLclaimBillManagertgDto.setSumPaid(dbManager.getDouble(resultSet,14));
            prpLclaimBillManagertgDto.setPayAmount(dbManager.getDouble(resultSet,15));
            prpLclaimBillManagertgDto.setPayFlag(dbManager.getString(resultSet,16));
            prpLclaimBillManagertgDto.setMobilePhone(dbManager.getString(resultSet,17));
            prpLclaimBillManagertgDto.setAddress(dbManager.getString(resultSet,18));
            prpLclaimBillManagertgDto.setAccountFlag(dbManager.getString(resultSet,19));
            prpLclaimBillManagertgDto.setFlag(dbManager.getString(resultSet,20));
            prpLclaimBillManagertgDto.setOperatorCode(dbManager.getString(resultSet,21));
            prpLclaimBillManagertgDto.setRouteNum(dbManager.getString(resultSet,22));
            collection.add(prpLclaimBillManagertgDto);
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
        buffer.append("DELETE FROM PrpLclaimBillManagertg WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLclaimBillManagertg WHERE ");
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
