package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.NamingException;

import com.sinosoft.claim.dto.domain.PrpJpaymentpackDetailDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utility.database.DbPool;
/**
 * 定义PrpJpackDetail的DB类
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>@createdate 2005-05-27</p>
 * @author DBGenerator
 * @version 1.0
 */
public class DBPrpJpaymentpackDetailBase extends PrpJpaymentpackDetailDto{
    /**
     * 
     */
    private static final long serialVersionUID = 2768352555419905809L;

    /**
     * 构造函数
     */
    public DBPrpJpaymentpackDetailBase(){
    }

    /**
     * 插入一条记录
     * @param dbpool dbpool
     * @throws Exception
     */
    public void insert(DbPool dbpool) throws Exception{
        String strSQL = " Insert Into PrpJpackDetail(" +
        " packNo," +
        " logno," +
        " fee," +
        " CertiType," +
        " VisaSerialNo," +
        " receiverfullname," +
        " bankAccount," +
        " bankType," +
        " bank," +
        " bankProv," +
        " bankCity," +
        " approveFlag," +
        " flag," +
        " yearmonth," +
        " centerCode," +
        " voucherNo, " +
        " merSeqId, " +
        " backReason, " +
        " taxFee, " +
        " payRefFee, " +
        " payDate, " +
        " reconFee " +
        ") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        dbpool.prepareStatement(strSQL);
        int index = 1; 
        dbpool.setString(index++,getPackNo());
        dbpool.setInt(index++,getLogNo());
        dbpool.setDouble(index++,getFee());
        dbpool.setString(index++,getCertiType());
        dbpool.setString(index++,getVisaSerialNo());
        dbpool.setString(index++,getReceiverfullname());
        dbpool.setString(index++,getBankAccount());
        dbpool.setString(index++,getBankType());
        dbpool.setString(index++,getBank());
        dbpool.setString(index++,getBankProv());
        dbpool.setString(index++,getBankCity());
        
        dbpool.setString(index++,getApproveFlag());
        dbpool.setString(index++,getFlag());
        dbpool.setString(index++,getYearMonth());
        dbpool.setString(index++,getCenterCode());
        dbpool.setString(index++,getVoucherNo());
        dbpool.setString(index++, getMerSeqId());
        dbpool.setString(index++, getBackReason());
        dbpool.setDouble(index++, getTaxFee());
        dbpool.setDouble(index++, getPayRefFee());
        dbpool.setString(index++, getPayDate());
        dbpool.setDouble(index++, getReconFee());
        dbpool.executePreparedUpdate(); 
        dbpool.closePreparedStatement();        
    }


	/**
     * 插入一条记录
     * @throws Exception
     */
    public void insert() throws Exception{
        DbPool dbpool = new DbPool();
        //打开数据库，开始事务
        dbpool.open(AppConfig.get("sysconst.DBJNDI"));

        try{
            dbpool.beginTransaction();
            insert(dbpool);
            dbpool.commitTransaction();
            dbpool.close();
        }
        catch(Exception exception){
            dbpool.rollbackTransaction();
            dbpool.close();
            throw exception;
        }
        finally{
            dbpool.close();
        }
    }

    public void delete(DbPool dbpool,String packNo) throws Exception{
    	String strSQL = " Delete From PrpJpackDetail Where packNo = ?";
    	dbpool.prepareStatement(strSQL);
    	int index = 1;
    	dbpool.setString(index++, packNo);
        dbpool.executePreparedUpdate();
        dbpool.closePreparedStatement();
    }

    public void delete(String packNo) throws Exception{
        DbPool dbpool = new DbPool();
        //打开数据库，开始事务
        dbpool.open(AppConfig.get("sysconst.DBJNDI"));

        try{
            dbpool.beginTransaction();
            delete(dbpool,packNo);
            dbpool.commitTransaction();
            dbpool.close();
        }
        catch(Exception exception){
            dbpool.rollbackTransaction();
            dbpool.close();
            throw exception;
        }
        finally{
            dbpool.close();
        }
    }

    public void update(DbPool dbpool) throws Exception{
        String strSQL = " Update PrpJpackDetail Set" +
        " packNo = ?," +
        " logNo = ?," +
        " fee = ?," +
        " CertiType = ?," +
        " visaSerialNo = ?," +
        " receiverfullname = ?," +
        " bankAccount = ?," +
        " bankType = ?," +
        " bank  = ?," +
        " bankProv = ?," +
        " bankCity  = ?," +
        " approveFlag = ?," +
        " flag = ?," +
        " yearmonth = ?," +
        " centerCode = ?," +
        " voucherNo = ?," +
        " merSeqId = ?," +
        " backReason = ?," +
        " taxFee = ?, " +
        " payRefFee = ?," +
        " payDate = ?, " +
        " reconFee = ?" +
        " Where packNo = ? and logno = ?" ;

        dbpool.prepareStatement(strSQL);   
        int index = 1;   
        dbpool.setString(index++,getPackNo());
        dbpool.setInt(index++,getLogNo());
        dbpool.setDouble(index++,getFee());
        dbpool.setString(index++,getCertiType());
        dbpool.setString(index++,getVisaSerialNo());
        dbpool.setString(index++,getReceiverfullname());
        dbpool.setString(index++,getBankAccount());
        dbpool.setString(index++,getBankType());
        dbpool.setString(index++,getBank());
        dbpool.setString(index++,getBankProv());
        dbpool.setString(index++,getBankCity());
        
        dbpool.setString(index++,getApproveFlag());
        dbpool.setString(index++,getFlag());
        dbpool.setString(index++,getYearMonth());
        dbpool.setString(index++,getCenterCode());
        dbpool.setString(index++,getVoucherNo());
        dbpool.setString(index++,getMerSeqId());
        dbpool.setString(index++,getBackReason());
        dbpool.setDouble(index++,getTaxFee());
        dbpool.setDouble(index++, getPayRefFee());
        dbpool.setString(index++, getPayDate());
        dbpool.setDouble(index++, getReconFee());
        
        dbpool.setString(index++,getPackNo());
        dbpool.setInt(index++,getLogNo());
        dbpool.executePreparedUpdate();                  
        dbpool.closePreparedStatement();  
    }
    /**
     * 更新一条记录
     * @throws Exception
     */
    public void update() throws Exception{
        DbPool dbpool = new DbPool();
        //打开数据库，开始事务
        dbpool.open(AppConfig.get("sysconst.DBJNDI"));
        try{
            dbpool.beginTransaction();
            update(dbpool);
            dbpool.commitTransaction();
            dbpool.close();
        }
        catch(Exception exception){
            dbpool.rollbackTransaction();
            dbpool.close();
            throw exception;
        }
        finally{
            dbpool.close();
        }
    }

    /**
     * @desc 根据主键查询数据
     * @param dbpool
     * @param packNo
     * @param logNo
     * @return
     * @throws Exception
     */
    public int getInfo(DbPool dbpool,String packNo,String logNo) throws Exception{
        int intResult = 0;
        String strSQL = " Select * From PrpJpackDetail Where packNo = ?" + 
                            " And logNo= ?";
        dbpool.prepareStatement(strSQL);
        int index = 1;
        dbpool.setString(index++, packNo);
        dbpool.setString(index++, logNo);
        
        ResultSet resultSet = dbpool.executePreparedQuery();
        if(resultSet.next()){
        	setPackNo(resultSet.getString("packNo"));
        	setLogNo(resultSet.getInt("logNo")+"");
        	setFee(resultSet.getDouble("fee")+"");
        	setCertiType(resultSet.getString("certiType"));
            setVisaSerialNo(resultSet.getString("visaSerialNo"));
            setReceiverfullname(resultSet.getString("receiverfullname"));
            setBankAccount(resultSet.getString("bankAccount"));
            setBankType(resultSet.getString("bankType"));
            setBank(resultSet.getString("bank"));
            setBankProv(resultSet.getString("bankProv"));
            setBankCity(resultSet.getString("bankCity"));
            setApproveFlag(resultSet.getString("approveFlag"));
            setFlag(resultSet.getString("flag"));
            setYearMonth(resultSet.getString("yearMonth"));
            setCenterCode(resultSet.getString("centerCode"));
            setVoucherNo(resultSet.getString("voucherNo"));
            setMerSeqId(resultSet.getString("merSeqId"));
            setBackReason(resultSet.getString("backReason"));
            setTaxFee(resultSet.getString("taxFee"));
            setPayRefFee(resultSet.getString("payRefFee"));
            setPayDate(resultSet.getString("payDate"));
            setReconFee(resultSet.getString("reconFee"));
            intResult = 0;
        }
        else{
            intResult = 100;
        }
        resultSet.close();
        dbpool.closePreparedStatement();
        return intResult;
    }

    public int getInfo(String packNo,String logNo) throws Exception{
        int intResult = 0;
        DbPool dbpool = new DbPool();
        dbpool.open(AppConfig.get("sysconst.DBJNDI"));

        //打开数据库，开始事务
        try{
            intResult=getInfo(dbpool,packNo,logNo);
            dbpool.close();
        }
        catch(Exception exception){
            dbpool.close();
            throw exception;
        }
        finally{
            dbpool.close();
        }
        return intResult;
    }

    /**
     * 打开模糊查询的游标
     * @param strSQL SQLstatement
     */
    public void open(String strSQL){
    }

    /**
     * 根据游标提取一条记录
     * @param index index
     */
    public void fetch(int index){
    }

    /**
     * 关闭模糊查询的游标
     */
    public void close(){
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbpool dbpool
     * @param statement statement
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DbPool dbpool,String strWhere)
        throws Exception{
        int intCount = 0;
        strWhere = SqlUtils.getWherePartForGetCount(strWhere);
        String strSQL = " SELECT COUNT(*) FROM PrpJpackDetail WHERE "+ strWhere;
        ResultSet resultSet = dbpool.query(strSQL);
        if(resultSet.next()){
            intCount = resultSet.getInt(1);
            resultSet.close();
        }
        return intCount;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param strSQL  SQLStatement
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String strWhere) throws
        Exception{
        int intCount = 0;
        DbPool dbpool = new DbPool();
        //打开数据库，开始事务
        dbpool.open(AppConfig.get("sysconst.DBJNDI"));
        try{
            intCount=getCount(dbpool,strWhere);
            dbpool.close();
        }
        catch(Exception exception){
            dbpool.close();
            throw exception;
        }
        finally{
            dbpool.close();
        }
        return intCount;
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param dbpool dbpool
     * @param statement statement
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCountBack(DbPool dbpool,String strWhere)
        throws Exception{
        int intCount = 0;
        strWhere = SqlUtils.getWherePartForGetCount(strWhere);
        String strSQL = " SELECT COUNT(*) FROM PrpJpackDetail,prpjpackmain,prpjplanfee WHERE "+ strWhere;
        ResultSet resultSet = dbpool.query(strSQL);
        if(resultSet.next()){
            intCount = resultSet.getInt(1);
            resultSet.close();
        }
        return intCount;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param strSQL  SQLStatement
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCountBack(String strWhere) throws
        Exception{
        int intCount = 0;
        DbPool dbpool = new DbPool();
        //打开数据库，开始事务
        dbpool.open(AppConfig.get("sysconst.DBJNDI"));
        try{
            intCount=getCountBack(dbpool,strWhere);
            dbpool.close();
        }
        catch(Exception exception){
            dbpool.close();
            throw exception;
        }
        finally{
            dbpool.close();
        }
        return intCount;
    }
    

    
    /**
     * 根据SQL语句获取结果集
     * @param strSQL  SQL语句
     * @return Vector 查询结果记录集
     * @throws SQLException    数据库操作异常类
     * @throws NamingException 名字异常类
     */
    public Vector findByConditions(String strSQL) throws
        Exception,SQLException,NamingException{
        Vector vector = new Vector();
        DbPool dbpool = new DbPool();
        //打开数据库，开始事务
        dbpool.open(AppConfig.get("sysconst.DBJNDI"));
        try{
            vector=findByConditions(dbpool,strSQL);
            dbpool.close();
        }
        catch(SQLException sqlException){
            dbpool.close();
            throw sqlException;
        }
        catch(NamingException namingException){
            dbpool.close();
            throw namingException;
        }
        finally{
            dbpool.close();
        }
        return vector;
    }
    /**
     * 根据SQL语句获取结果集
     * @param strSQL  SQL语句
     * @return Vector 查询结果记录集
     * @throws SQLException    数据库操作异常类
     * @throws NamingException 名字异常类
     */
    public Vector findByConditionsBack(String strSQL) throws
        Exception,SQLException,NamingException{
        Vector vector = new Vector();
        DbPool dbpool = new DbPool();
        //打开数据库，开始事务
        dbpool.open(AppConfig.get("sysconst.DBJNDI"));
        try{
            vector=findByConditionsBack(dbpool,strSQL);
            dbpool.close();
        }
        catch(SQLException sqlException){
            dbpool.close();
            throw sqlException;
        }
        catch(NamingException namingException){
            dbpool.close();
            throw namingException;
        }
        finally{
            dbpool.close();
        }
        return vector;
    }

    /**
     * 根据SQL语句获取结果集
     * @param dbpool  数据库连接池
     * @param strSQL  SQL语句
     * @return Vector 查询结果记录集
     * @throws SQLException    数据库操作异常类
     * @throws NamingException 名字异常类
     */
    public Vector findByConditions(DbPool dbpool,String strSQL) throws
        SQLException,NamingException{
        Vector vector = new Vector();
        PrpJpaymentpackDetailDto prpJpaymentpackDetailDto = null;
        ResultSet resultSet = dbpool.query(strSQL);
        while(resultSet.next())
        {
        	prpJpaymentpackDetailDto = new PrpJpaymentpackDetailDto();
        	prpJpaymentpackDetailDto.setPackNo(resultSet.getString("packNo"));
        	prpJpaymentpackDetailDto.setLogNo(resultSet.getString("logNo"));
        	prpJpaymentpackDetailDto.setFee(resultSet.getString("fee"));
        	prpJpaymentpackDetailDto.setCertiType(resultSet.getString("certiType"));
        	prpJpaymentpackDetailDto.setVisaSerialNo(resultSet.getString("visaSerialNo"));
        	prpJpaymentpackDetailDto.setReceiverfullname(resultSet.getString("receiverfullname"));
        	prpJpaymentpackDetailDto.setBankAccount(resultSet.getString("bankAccount"));
        	prpJpaymentpackDetailDto.setBankType(resultSet.getString("bankType"));
        	prpJpaymentpackDetailDto.setBank(resultSet.getString("bank"));
        	prpJpaymentpackDetailDto.setBankProv(resultSet.getString("bankProv"));
        	prpJpaymentpackDetailDto.setBankCity(resultSet.getString("bankCity"));
        	prpJpaymentpackDetailDto.setApproveFlag(resultSet.getString("approveFlag"));
        	prpJpaymentpackDetailDto.setFlag(resultSet.getString("flag"));
        	prpJpaymentpackDetailDto.setYearMonth(resultSet.getString("yearMonth"));
        	prpJpaymentpackDetailDto.setCenterCode(resultSet.getString("centerCode"));
        	prpJpaymentpackDetailDto.setVoucherNo(resultSet.getString("voucherNo"));
        	prpJpaymentpackDetailDto.setMerSeqId(resultSet.getString("merSeqId"));
        	prpJpaymentpackDetailDto.setBackReason(resultSet.getString("backReason"));
        	prpJpaymentpackDetailDto.setTaxFee(resultSet.getString("taxFee"));
        	prpJpaymentpackDetailDto.setPayRefFee(resultSet.getString("payRefFee"));
        	prpJpaymentpackDetailDto.setPayDate(resultSet.getString("payDate"));
        	prpJpaymentpackDetailDto.setReconFee(resultSet.getString("reconFee"));
            vector.add(prpJpaymentpackDetailDto);
        }
        resultSet.close();
        return vector;
    }
    /**
     * 根据SQL语句获取结果集
     * @param dbpool  数据库连接池
     * @param strSQL  SQL语句
     * @return Vector 查询结果记录集
     * @throws SQLException    数据库操作异常类
     * @throws NamingException 名字异常类
     */
    public Vector findByConditionsBack(DbPool dbpool,String strSQL) throws
        SQLException,NamingException{
        Vector vector = new Vector();
        PrpJpaymentpackDetailDto prpJpaymentpackDetailDto = null;
        ResultSet resultSet = dbpool.query(strSQL);
        while(resultSet.next())
        {
        	prpJpaymentpackDetailDto = new PrpJpaymentpackDetailDto();
        	prpJpaymentpackDetailDto.setPackNo(resultSet.getString("packNo"));
        	prpJpaymentpackDetailDto.setLogNo(resultSet.getString("logNo"));
        	prpJpaymentpackDetailDto.setFee(resultSet.getString("fee"));
        	prpJpaymentpackDetailDto.setCertiType(resultSet.getString("certiType"));
        	prpJpaymentpackDetailDto.setVisaSerialNo(resultSet.getString("visaSerialNo"));
        	prpJpaymentpackDetailDto.setReceiverfullname(resultSet.getString("receiverfullname"));
        	prpJpaymentpackDetailDto.setBankAccount(resultSet.getString("bankAccount"));
        	prpJpaymentpackDetailDto.setBankType(resultSet.getString("bankType"));
        	prpJpaymentpackDetailDto.setBank(resultSet.getString("bank"));
        	prpJpaymentpackDetailDto.setBankProv(resultSet.getString("bankProv"));
        	prpJpaymentpackDetailDto.setBankCity(resultSet.getString("bankCity"));
        	prpJpaymentpackDetailDto.setApproveFlag(resultSet.getString("approveFlag"));
        	prpJpaymentpackDetailDto.setFlag(resultSet.getString("flag"));
        	prpJpaymentpackDetailDto.setYearMonth(resultSet.getString("yearMonth"));
        	prpJpaymentpackDetailDto.setCenterCode(resultSet.getString("centerCode"));
        	prpJpaymentpackDetailDto.setVoucherNo(resultSet.getString("voucherNo"));
        	prpJpaymentpackDetailDto.setMerSeqId(resultSet.getString("merSeqId"));
        	prpJpaymentpackDetailDto.setBackReason(resultSet.getString("backReason"));
        	prpJpaymentpackDetailDto.setTaxFee(resultSet.getString("taxFee"));
        	prpJpaymentpackDetailDto.setPayRefFee(resultSet.getString("payRefFee"));
        	prpJpaymentpackDetailDto.setPayDate(resultSet.getString("payDate"));
        	prpJpaymentpackDetailDto.setReconFee(resultSet.getString("reconFee"));
        	prpJpaymentpackDetailDto.setPolicyNo(resultSet.getString("policyNo"));
            vector.add(prpJpaymentpackDetailDto);
        }
        resultSet.close();
        return vector;
    }
    public int getSinPayCount(DbPool dbpool,String strWhere)
    throws Exception{
    int intCount = 0;
    strWhere = SqlUtils.getWherePartForGetCount(strWhere);
    String strSQL = " SELECT COUNT(*) FROM prpjpackdetail WHERE "+ strWhere;
    ResultSet resultSet = dbpool.query(strSQL);
    if(resultSet.next()){
        intCount = resultSet.getInt(1);
        resultSet.close();
    }
    return intCount;
	}
	
	/**
	 * 查询满足模糊查询条件的记录数
	 * @param strSQL  SQLStatement
	 * @return 满足模糊查询条件的记录数
	 * @throws Exception
	 */
	public int getSinPayCount(String strWhere) throws
	    Exception{
	    int intCount = 0;
	    DbPool dbpool = new DbPool();
	    //打开数据库，开始事务
	    dbpool.open(AppConfig.get("sysconst.DBJNDI"));
	    try{
	        intCount=getSinPayCount(dbpool,strWhere);
	        dbpool.close();
	    }
	    catch(Exception exception){
	        dbpool.close();
	        throw exception;
	    }
	    finally{
	        dbpool.close();
	    }
	    return intCount;
	}
	
	public Vector findSinPayByConditions(String strSQL) throws
    Exception,SQLException,NamingException{
    Vector vector = new Vector();
    DbPool dbpool = new DbPool();
    //打开数据库，开始事务
    dbpool.open(AppConfig.get("sysconst.DBJNDI"));
    try{
        vector=findSinPayByConditions(dbpool,strSQL);
        dbpool.close();
    }
    catch(SQLException sqlException){
        dbpool.close();
        throw sqlException;
    }
    catch(NamingException namingException){
        dbpool.close();
        throw namingException;
    }
    finally{
        dbpool.close();
    }
    return vector;
	}
	
	public Vector findSinPayByConditions(DbPool dbpool,String strSQL) throws
    SQLException,NamingException{
    Vector vector = new Vector();
    PrpJpaymentpackDetailDto prpJpaymentpackDetailDto = null;
    ResultSet resultSet = dbpool.query(strSQL);
    while(resultSet.next())
    {
    	prpJpaymentpackDetailDto = new PrpJpaymentpackDetailDto();
    	prpJpaymentpackDetailDto.setPackNo(resultSet.getString("packNo"));
    	prpJpaymentpackDetailDto.setLogNo(resultSet.getString("logNo"));
    	prpJpaymentpackDetailDto.setFee(resultSet.getString("fee"));
    	prpJpaymentpackDetailDto.setCertiType(resultSet.getString("certiType"));
    	prpJpaymentpackDetailDto.setVisaSerialNo(resultSet.getString("visaSerialNo"));
    	prpJpaymentpackDetailDto.setReceiverfullname(resultSet.getString("receiverfullname"));
    	prpJpaymentpackDetailDto.setBankAccount(resultSet.getString("bankAccount"));
    	prpJpaymentpackDetailDto.setBankType(resultSet.getString("bankType"));
    	prpJpaymentpackDetailDto.setBank(resultSet.getString("bank"));
    	prpJpaymentpackDetailDto.setBankProv(resultSet.getString("bankProv"));
    	prpJpaymentpackDetailDto.setBankCity(resultSet.getString("bankCity"));
    	prpJpaymentpackDetailDto.setApproveFlag(resultSet.getString("approveFlag"));
    	prpJpaymentpackDetailDto.setFlag(resultSet.getString("flag"));
    	prpJpaymentpackDetailDto.setYearMonth(resultSet.getString("yearMonth"));
    	prpJpaymentpackDetailDto.setCenterCode(resultSet.getString("centerCode"));
    	prpJpaymentpackDetailDto.setVoucherNo(resultSet.getString("voucherNo"));
    	prpJpaymentpackDetailDto.setMerSeqId(resultSet.getString("merSeqId"));
    	prpJpaymentpackDetailDto.setBackReason(resultSet.getString("backReason"));
    	prpJpaymentpackDetailDto.setTaxFee(resultSet.getString("taxFee"));
    	prpJpaymentpackDetailDto.setPayRefFee(resultSet.getString("payRefFee"));
    	prpJpaymentpackDetailDto.setPayDate(resultSet.getString("payDate"));
    	prpJpaymentpackDetailDto.setReconFee(resultSet.getString("reconFee"));
        vector.add(prpJpaymentpackDetailDto);
    }
    resultSet.close();
    return vector;
}
	
	public Vector querySinPayStatTCondi(DbPool dbpool,String strSQL) throws
    SQLException,NamingException{
	    Vector vector = new Vector();
	    PrpJpaymentpackDetailDto prpJpaymentpackDetailDto = null;
	    ResultSet resultSet = dbpool.query(strSQL);
	    while(resultSet.next())
	    {
	    	prpJpaymentpackDetailDto = new PrpJpaymentpackDetailDto();
	    	prpJpaymentpackDetailDto.setReceiverfullname(resultSet.getString("receiverfullname"));
	    	prpJpaymentpackDetailDto.setPayRefFee(resultSet.getString("payRefFee"));
	    	prpJpaymentpackDetailDto.setVisaSerialNo(resultSet.getString("visaSerialNo"));
	        vector.add(prpJpaymentpackDetailDto);
	    }
	    resultSet.close();
	    return vector;
	}
    /**
     * 主函数
     * @param args 参数列表
     */
    public static void main(String[] args){
        //add test code here
    }
}
