package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplfiscalpaydetailDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLFISCALpaydetail的数据访问对象基类<br>
 */
public class DBPrplfiscalpaydetailBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplfiscalpaydetailBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplfiscalpaydetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prplfiscalpaydetailDto prplfiscalpaydetailDto
     * @throws Exception
     */
    public void insert(PrplfiscalpaydetailDto prplfiscalpaydetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplfiscalpaydetail (");
        buffer.append("Fiscalno,");
        buffer.append("Serialno,");
        buffer.append("Registno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Policyno,");
        buffer.append("Claimno,");
        buffer.append("Compensateno,");
        buffer.append("Paymenttype,");
        buffer.append("Paytype,");
        buffer.append("Receiverfullname,");
        buffer.append("Identifynumber,");
        buffer.append("Insuredcode,");
        buffer.append("Sumamount,");
        buffer.append("Payamount,");
        buffer.append("Banktype,");
        buffer.append("Bank,");
        buffer.append("Accounttype,");
        buffer.append("Mobilephone,");
        buffer.append("Payremark,");
        buffer.append("Bankaccount,");
        buffer.append("Vflag,");
        buffer.append("Provincename,");
        buffer.append("Cityname,");
        buffer.append("Accountflag,");
        buffer.append("Routenum, ");
        buffer.append("comCode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getFiscalno()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getSerialno()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getRegistno()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getClasscode()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getClaimno()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getCompensateno()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getPaymenttype()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getPaytype()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getReceiverfullname()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getIdentifynumber()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getInsuredcode()).append("',");
            debugBuffer.append("").append(prplfiscalpaydetailDto.getSumamount()).append(",");
            debugBuffer.append("").append(prplfiscalpaydetailDto.getPayamount()).append(",");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getBanktype()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getBank()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getAccounttype()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getMobilephone()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getPayremark()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getBankaccount()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getVflag()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getProvincename()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getCityname()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getAccountflag()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getRoutenum()).append("',");
            debugBuffer.append("'").append(prplfiscalpaydetailDto.getComcode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplfiscalpaydetailDto.getFiscalno());
        dbManager.setString(2,prplfiscalpaydetailDto.getSerialno());
        dbManager.setString(3,prplfiscalpaydetailDto.getRegistno());
        dbManager.setString(4,prplfiscalpaydetailDto.getClasscode());
        dbManager.setString(5,prplfiscalpaydetailDto.getRiskcode());
        dbManager.setString(6,prplfiscalpaydetailDto.getPolicyno());
        dbManager.setString(7,prplfiscalpaydetailDto.getClaimno());
        dbManager.setString(8,prplfiscalpaydetailDto.getCompensateno());
        dbManager.setString(9,prplfiscalpaydetailDto.getPaymenttype());
        dbManager.setString(10,prplfiscalpaydetailDto.getPaytype());
        dbManager.setString(11,prplfiscalpaydetailDto.getReceiverfullname());
        dbManager.setString(12,prplfiscalpaydetailDto.getIdentifynumber());
        dbManager.setString(13,prplfiscalpaydetailDto.getInsuredcode());
        dbManager.setDouble(14,prplfiscalpaydetailDto.getSumamount());
        dbManager.setDouble(15,prplfiscalpaydetailDto.getPayamount());
        dbManager.setString(16,prplfiscalpaydetailDto.getBanktype());
        dbManager.setString(17,prplfiscalpaydetailDto.getBank());
        dbManager.setString(18,prplfiscalpaydetailDto.getAccounttype());
        dbManager.setString(19,prplfiscalpaydetailDto.getMobilephone());
        dbManager.setString(20,prplfiscalpaydetailDto.getPayremark());
        dbManager.setString(21,prplfiscalpaydetailDto.getBankaccount());
        dbManager.setString(22,prplfiscalpaydetailDto.getVflag());
        dbManager.setString(23,prplfiscalpaydetailDto.getProvincename());
        dbManager.setString(24,prplfiscalpaydetailDto.getCityname());
        dbManager.setString(25,prplfiscalpaydetailDto.getAccountflag());
        dbManager.setString(26,prplfiscalpaydetailDto.getRoutenum());
        dbManager.setString(27,prplfiscalpaydetailDto.getComcode());
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
        buffer.append("INSERT INTO Prplfiscalpaydetail (");
        buffer.append("Fiscalno,");
        buffer.append("Serialno,");
        buffer.append("Registno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Policyno,");
        buffer.append("Claimno,");
        buffer.append("Compensateno,");
        buffer.append("Paymenttype,");
        buffer.append("Paytype,");
        buffer.append("Receiverfullname,");
        buffer.append("Identifynumber,");
        buffer.append("Insuredcode,");
        buffer.append("Sumamount,");
        buffer.append("Payamount,");
        buffer.append("Banktype,");
        buffer.append("Bank,");
        buffer.append("Accounttype,");
        buffer.append("Mobilephone,");
        buffer.append("Payremark,");
        buffer.append("Bankaccount,");
        buffer.append("Vflag,");
        buffer.append("Provincename,");
        buffer.append("Cityname,");
        buffer.append("Accountflag,");
        buffer.append("Routenum, ");
        buffer.append("Comcode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplfiscalpaydetailDto prplfiscalpaydetailDto = (PrplfiscalpaydetailDto)i.next();
            dbManager.setString(1,prplfiscalpaydetailDto.getFiscalno());
            dbManager.setString(2,prplfiscalpaydetailDto.getSerialno());
            dbManager.setString(3,prplfiscalpaydetailDto.getRegistno());
            dbManager.setString(4,prplfiscalpaydetailDto.getClasscode());
            dbManager.setString(5,prplfiscalpaydetailDto.getRiskcode());
            dbManager.setString(6,prplfiscalpaydetailDto.getPolicyno());
            dbManager.setString(7,prplfiscalpaydetailDto.getClaimno());
            dbManager.setString(8,prplfiscalpaydetailDto.getCompensateno());
            dbManager.setString(9,prplfiscalpaydetailDto.getPaymenttype());
            dbManager.setString(10,prplfiscalpaydetailDto.getPaytype());
            dbManager.setString(11,prplfiscalpaydetailDto.getReceiverfullname());
            dbManager.setString(12,prplfiscalpaydetailDto.getIdentifynumber());
            dbManager.setString(13,prplfiscalpaydetailDto.getInsuredcode());
            dbManager.setDouble(14,prplfiscalpaydetailDto.getSumamount());
            dbManager.setDouble(15,prplfiscalpaydetailDto.getPayamount());
            dbManager.setString(16,prplfiscalpaydetailDto.getBanktype());
            dbManager.setString(17,prplfiscalpaydetailDto.getBank());
            dbManager.setString(18,prplfiscalpaydetailDto.getAccounttype());
            dbManager.setString(19,prplfiscalpaydetailDto.getMobilephone());
            dbManager.setString(20,prplfiscalpaydetailDto.getPayremark());
            dbManager.setString(21,prplfiscalpaydetailDto.getBankaccount());
            dbManager.setString(22,prplfiscalpaydetailDto.getVflag());
            dbManager.setString(23,prplfiscalpaydetailDto.getProvincename());
            dbManager.setString(24,prplfiscalpaydetailDto.getCityname());
            dbManager.setString(25,prplfiscalpaydetailDto.getAccountflag());
            dbManager.setString(26,prplfiscalpaydetailDto.getRoutenum());
            dbManager.setString(27,prplfiscalpaydetailDto.getComcode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param fiscalno 财政打卡文件清单号
     * @param serialno 序号
     * @throws Exception
     */
    public void delete(String fiscalno,String serialno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplfiscalpaydetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Fiscalno=").append("'").append(fiscalno).append("' AND ");
            debugBuffer.append("Serialno=").append("'").append(serialno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Fiscalno = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,fiscalno);
        dbManager.setString(2,serialno);
        dbManager.executePreparedUpdate();
    }
    /**
     * 按主键删除一条数据
     * @param fiscalno 财政打卡文件清单号
     * @param serialno 序号
     * @throws Exception
     */
    public void delete(String fiscalno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplfiscalpaydetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Fiscalno=").append("'").append(fiscalno).append("' ");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Fiscalno = ? ");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,fiscalno);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prplfiscalpaydetailDto prplfiscalpaydetailDto
     * @throws Exception
     */
    public void update(PrplfiscalpaydetailDto prplfiscalpaydetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplfiscalpaydetail SET ");
        buffer.append("Registno = ?, ");
        buffer.append("Classcode = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Policyno = ?, ");
        buffer.append("Claimno = ?, ");
        buffer.append("Compensateno = ?, ");
        buffer.append("Paymenttype = ?, ");
        buffer.append("Paytype = ?, ");
        buffer.append("Receiverfullname = ?, ");
        buffer.append("Identifynumber = ?, ");
        buffer.append("Insuredcode = ?, ");
        buffer.append("Sumamount = ?, ");
        buffer.append("Payamount = ?, ");
        buffer.append("Banktype = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("Accounttype = ?, ");
        buffer.append("Mobilephone = ?, ");
        buffer.append("Payremark = ?, ");
        buffer.append("Bankaccount = ?, ");
        buffer.append("Vflag = ?, ");
        buffer.append("Provincename = ?, ");
        buffer.append("Cityname = ?, ");
        buffer.append("Accountflag = ?, ");
        buffer.append("Routenum = ?, ");
        buffer.append("Comcode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplfiscalpaydetail SET ");
            debugBuffer.append("Registno = '" + prplfiscalpaydetailDto.getRegistno() + "', ");
            debugBuffer.append("Classcode = '" + prplfiscalpaydetailDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + prplfiscalpaydetailDto.getRiskcode() + "', ");
            debugBuffer.append("Policyno = '" + prplfiscalpaydetailDto.getPolicyno() + "', ");
            debugBuffer.append("Claimno = '" + prplfiscalpaydetailDto.getClaimno() + "', ");
            debugBuffer.append("Compensateno = '" + prplfiscalpaydetailDto.getCompensateno() + "', ");
            debugBuffer.append("Paymenttype = '" + prplfiscalpaydetailDto.getPaymenttype() + "', ");
            debugBuffer.append("Paytype = '" + prplfiscalpaydetailDto.getPaytype() + "', ");
            debugBuffer.append("Receiverfullname = '" + prplfiscalpaydetailDto.getReceiverfullname() + "', ");
            debugBuffer.append("Identifynumber = '" + prplfiscalpaydetailDto.getIdentifynumber() + "', ");
            debugBuffer.append("Insuredcode = '" + prplfiscalpaydetailDto.getInsuredcode() + "', ");
            debugBuffer.append("Sumamount = " + prplfiscalpaydetailDto.getSumamount() + ", ");
            debugBuffer.append("Payamount = " + prplfiscalpaydetailDto.getPayamount() + ", ");
            debugBuffer.append("Banktype = '" + prplfiscalpaydetailDto.getBanktype() + "', ");
            debugBuffer.append("Bank = '" + prplfiscalpaydetailDto.getBank() + "', ");
            debugBuffer.append("Accounttype = '" + prplfiscalpaydetailDto.getAccounttype() + "', ");
            debugBuffer.append("Mobilephone = '" + prplfiscalpaydetailDto.getMobilephone() + "', ");
            debugBuffer.append("Payremark = '" + prplfiscalpaydetailDto.getPayremark() + "', ");
            debugBuffer.append("Bankaccount = '" + prplfiscalpaydetailDto.getBankaccount() + "', ");
            debugBuffer.append("Vflag = '" + prplfiscalpaydetailDto.getVflag() + "', ");
            debugBuffer.append("Provincename = '" + prplfiscalpaydetailDto.getProvincename() + "', ");
            debugBuffer.append("Cityname = '" + prplfiscalpaydetailDto.getCityname() + "', ");
            debugBuffer.append("Accountflag = '" + prplfiscalpaydetailDto.getAccountflag() + "', ");
            debugBuffer.append("Routenum = '" + prplfiscalpaydetailDto.getRoutenum() + "', ");
            debugBuffer.append("Comcode = '" + prplfiscalpaydetailDto.getRoutenum() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Fiscalno=").append("'").append(prplfiscalpaydetailDto.getFiscalno()).append("' AND ");
            debugBuffer.append("Serialno=").append("'").append(prplfiscalpaydetailDto.getSerialno()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Fiscalno = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prplfiscalpaydetailDto.getRegistno());
        dbManager.setString(2,prplfiscalpaydetailDto.getClasscode());
        dbManager.setString(3,prplfiscalpaydetailDto.getRiskcode());
        dbManager.setString(4,prplfiscalpaydetailDto.getPolicyno());
        dbManager.setString(5,prplfiscalpaydetailDto.getClaimno());
        dbManager.setString(6,prplfiscalpaydetailDto.getCompensateno());
        dbManager.setString(7,prplfiscalpaydetailDto.getPaymenttype());
        dbManager.setString(8,prplfiscalpaydetailDto.getPaytype());
        dbManager.setString(9,prplfiscalpaydetailDto.getReceiverfullname());
        dbManager.setString(10,prplfiscalpaydetailDto.getIdentifynumber());
        dbManager.setString(11,prplfiscalpaydetailDto.getInsuredcode());
        dbManager.setDouble(12,prplfiscalpaydetailDto.getSumamount());
        dbManager.setDouble(13,prplfiscalpaydetailDto.getPayamount());
        dbManager.setString(14,prplfiscalpaydetailDto.getBanktype());
        dbManager.setString(15,prplfiscalpaydetailDto.getBank());
        dbManager.setString(16,prplfiscalpaydetailDto.getAccounttype());
        dbManager.setString(17,prplfiscalpaydetailDto.getMobilephone());
        dbManager.setString(18,prplfiscalpaydetailDto.getPayremark());
        dbManager.setString(19,prplfiscalpaydetailDto.getBankaccount());
        dbManager.setString(20,prplfiscalpaydetailDto.getVflag());
        dbManager.setString(21,prplfiscalpaydetailDto.getProvincename());
        dbManager.setString(22,prplfiscalpaydetailDto.getCityname());
        dbManager.setString(23,prplfiscalpaydetailDto.getAccountflag());
        dbManager.setString(24,prplfiscalpaydetailDto.getRoutenum());
        dbManager.setString(25,prplfiscalpaydetailDto.getComcode());
        //设置条件字段;
        dbManager.setString(26,prplfiscalpaydetailDto.getFiscalno());
        dbManager.setString(27,prplfiscalpaydetailDto.getSerialno());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param fiscalno 财政打卡文件清单号
     * @param serialno 序号
     * @return PrplfiscalpaydetailDto
     * @throws Exception
     */
    public PrplfiscalpaydetailDto findByPrimaryKey(String fiscalno,String serialno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Fiscalno,");
        buffer.append("Serialno,");
        buffer.append("Registno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Policyno,");
        buffer.append("Claimno,");
        buffer.append("Compensateno,");
        buffer.append("Paymenttype,");
        buffer.append("Paytype,");
        buffer.append("Receiverfullname,");
        buffer.append("Identifynumber,");
        buffer.append("Insuredcode,");
        buffer.append("Sumamount,");
        buffer.append("Payamount,");
        buffer.append("Banktype,");
        buffer.append("Bank,");
        buffer.append("Accounttype,");
        buffer.append("Mobilephone,");
        buffer.append("Payremark,");
        buffer.append("Bankaccount,");
        buffer.append("Vflag,");
        buffer.append("Provincename,");
        buffer.append("Cityname,");
        buffer.append("Accountflag,");
        buffer.append("Routenum, ");
        buffer.append("Comcode ");
        buffer.append("FROM Prplfiscalpaydetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Fiscalno=").append("'").append(fiscalno).append("' AND ");
            debugBuffer.append("Serialno=").append("'").append(serialno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Fiscalno = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,fiscalno);
        dbManager.setString(2,serialno);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplfiscalpaydetailDto prplfiscalpaydetailDto = null;
        if(resultSet.next()){
            prplfiscalpaydetailDto = new PrplfiscalpaydetailDto();
            prplfiscalpaydetailDto.setFiscalno(dbManager.getString(resultSet,1));
            prplfiscalpaydetailDto.setSerialno(dbManager.getString(resultSet,2));
            prplfiscalpaydetailDto.setRegistno(dbManager.getString(resultSet,3));
            prplfiscalpaydetailDto.setClasscode(dbManager.getString(resultSet,4));
            prplfiscalpaydetailDto.setRiskcode(dbManager.getString(resultSet,5));
            prplfiscalpaydetailDto.setPolicyno(dbManager.getString(resultSet,6));
            prplfiscalpaydetailDto.setClaimno(dbManager.getString(resultSet,7));
            prplfiscalpaydetailDto.setCompensateno(dbManager.getString(resultSet,8));
            prplfiscalpaydetailDto.setPaymenttype(dbManager.getString(resultSet,9));
            prplfiscalpaydetailDto.setPaytype(dbManager.getString(resultSet,10));
            prplfiscalpaydetailDto.setReceiverfullname(dbManager.getString(resultSet,11));
            prplfiscalpaydetailDto.setIdentifynumber(dbManager.getString(resultSet,12));
            prplfiscalpaydetailDto.setInsuredcode(dbManager.getString(resultSet,13));
            prplfiscalpaydetailDto.setSumamount(dbManager.getDouble(resultSet,14));
            prplfiscalpaydetailDto.setPayamount(dbManager.getDouble(resultSet,15));
            prplfiscalpaydetailDto.setBanktype(dbManager.getString(resultSet,16));
            prplfiscalpaydetailDto.setBank(dbManager.getString(resultSet,17));
            prplfiscalpaydetailDto.setAccounttype(dbManager.getString(resultSet,18));
            prplfiscalpaydetailDto.setMobilephone(dbManager.getString(resultSet,19));
            prplfiscalpaydetailDto.setPayremark(dbManager.getString(resultSet,20));
            prplfiscalpaydetailDto.setBankaccount(dbManager.getString(resultSet,21));
            prplfiscalpaydetailDto.setVflag(dbManager.getString(resultSet,22));
            prplfiscalpaydetailDto.setProvincename(dbManager.getString(resultSet,23));
            prplfiscalpaydetailDto.setCityname(dbManager.getString(resultSet,24));
            prplfiscalpaydetailDto.setAccountflag(dbManager.getString(resultSet,25));
            prplfiscalpaydetailDto.setRoutenum(dbManager.getString(resultSet,26));
            prplfiscalpaydetailDto.setComcode(dbManager.getString(resultSet,27));
        }
        resultSet.close();
        return prplfiscalpaydetailDto;
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
        buffer.append("Fiscalno,");
        buffer.append("Serialno,");
        buffer.append("Registno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Policyno,");
        buffer.append("Claimno,");
        buffer.append("Compensateno,");
        buffer.append("Paymenttype,");
        buffer.append("Paytype,");
        buffer.append("Receiverfullname,");
        buffer.append("Identifynumber,");
        buffer.append("Insuredcode,");
        buffer.append("Sumamount,");
        buffer.append("Payamount,");
        buffer.append("Banktype,");
        buffer.append("Bank,");
        buffer.append("Accounttype,");
        buffer.append("Mobilephone,");
        buffer.append("Payremark,");
        buffer.append("Bankaccount,");
        buffer.append("Vflag,");
        buffer.append("Provincename,");
        buffer.append("Cityname,");
        buffer.append("Accountflag,");
        buffer.append("Routenum, ");
        buffer.append("Comcode ");
        buffer.append("FROM Prplfiscalpaydetail WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                String sql = buffer.toString();
                buffer.setLength(0);
                buffer.append("select * from ( select rownumber() over(");
                int orderByIndex = sql.toLowerCase().indexOf("order by");
                if ( orderByIndex>0 ) {
                   buffer.append( sql.substring(orderByIndex) );
                }
                buffer.append(") as rownumber_,");
                buffer.append(sql.substring( 6 ));
                buffer.append(" ) as temp_ where rownumber_");
                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrplfiscalpaydetailDto prplfiscalpaydetailDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplfiscalpaydetailDto = new PrplfiscalpaydetailDto();
            prplfiscalpaydetailDto.setFiscalno(dbManager.getString(resultSet,"Fiscalno"));
            prplfiscalpaydetailDto.setSerialno(dbManager.getString(resultSet,"Serialno"));
            prplfiscalpaydetailDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prplfiscalpaydetailDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            prplfiscalpaydetailDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            prplfiscalpaydetailDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            prplfiscalpaydetailDto.setClaimno(dbManager.getString(resultSet,"Claimno"));
            prplfiscalpaydetailDto.setCompensateno(dbManager.getString(resultSet,"Compensateno"));
            prplfiscalpaydetailDto.setPaymenttype(dbManager.getString(resultSet,"Paymenttype"));
            prplfiscalpaydetailDto.setPaytype(dbManager.getString(resultSet,"Paytype"));
            prplfiscalpaydetailDto.setReceiverfullname(dbManager.getString(resultSet,"Receiverfullname"));
            prplfiscalpaydetailDto.setIdentifynumber(dbManager.getString(resultSet,"Identifynumber"));
            prplfiscalpaydetailDto.setInsuredcode(dbManager.getString(resultSet,"Insuredcode"));
            prplfiscalpaydetailDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            prplfiscalpaydetailDto.setPayamount(dbManager.getDouble(resultSet,"Payamount"));
            prplfiscalpaydetailDto.setBanktype(dbManager.getString(resultSet,"Banktype"));
            prplfiscalpaydetailDto.setBank(dbManager.getString(resultSet,"Bank"));
            prplfiscalpaydetailDto.setAccounttype(dbManager.getString(resultSet,"Accounttype"));
            prplfiscalpaydetailDto.setMobilephone(dbManager.getString(resultSet,"Mobilephone"));
            prplfiscalpaydetailDto.setPayremark(dbManager.getString(resultSet,"Payremark"));
            prplfiscalpaydetailDto.setBankaccount(dbManager.getString(resultSet,"Bankaccount"));
            prplfiscalpaydetailDto.setVflag(dbManager.getString(resultSet,"Vflag"));
            prplfiscalpaydetailDto.setProvincename(dbManager.getString(resultSet,"Provincename"));
            prplfiscalpaydetailDto.setCityname(dbManager.getString(resultSet,"Cityname"));
            prplfiscalpaydetailDto.setAccountflag(dbManager.getString(resultSet,"Accountflag"));
            prplfiscalpaydetailDto.setRoutenum(dbManager.getString(resultSet,"Routenum"));
            prplfiscalpaydetailDto.setComcode(dbManager.getString(resultSet,"Comcode"));
            collection.add(prplfiscalpaydetailDto);
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
        buffer.append("DELETE FROM Prplfiscalpaydetail WHERE ");
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
        buffer.append("SELECT count(1) FROM Prplfiscalpaydetail WHERE ");
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
