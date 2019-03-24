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
 * ����PrpJpackDetail��DB��
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
     * ���캯��
     */
    public DBPrpJpaymentpackDetailBase(){
    }

    /**
     * ����һ����¼
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
     * ����һ����¼
     * @throws Exception
     */
    public void insert() throws Exception{
        DbPool dbpool = new DbPool();
        //�����ݿ⣬��ʼ����
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
        //�����ݿ⣬��ʼ����
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
     * ����һ����¼
     * @throws Exception
     */
    public void update() throws Exception{
        DbPool dbpool = new DbPool();
        //�����ݿ⣬��ʼ����
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
     * @desc ����������ѯ����
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

        //�����ݿ⣬��ʼ����
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
     * ��ģ����ѯ���α�
     * @param strSQL SQLstatement
     */
    public void open(String strSQL){
    }

    /**
     * �����α���ȡһ����¼
     * @param index index
     */
    public void fetch(int index){
    }

    /**
     * �ر�ģ����ѯ���α�
     */
    public void close(){
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbpool dbpool
     * @param statement statement
     * @return ����ģ����ѯ�����ļ�¼��
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
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param strSQL  SQLStatement
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String strWhere) throws
        Exception{
        int intCount = 0;
        DbPool dbpool = new DbPool();
        //�����ݿ⣬��ʼ����
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
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbpool dbpool
     * @param statement statement
     * @return ����ģ����ѯ�����ļ�¼��
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
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param strSQL  SQLStatement
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCountBack(String strWhere) throws
        Exception{
        int intCount = 0;
        DbPool dbpool = new DbPool();
        //�����ݿ⣬��ʼ����
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
     * ����SQL����ȡ�����
     * @param strSQL  SQL���
     * @return Vector ��ѯ�����¼��
     * @throws SQLException    ���ݿ�����쳣��
     * @throws NamingException �����쳣��
     */
    public Vector findByConditions(String strSQL) throws
        Exception,SQLException,NamingException{
        Vector vector = new Vector();
        DbPool dbpool = new DbPool();
        //�����ݿ⣬��ʼ����
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
     * ����SQL����ȡ�����
     * @param strSQL  SQL���
     * @return Vector ��ѯ�����¼��
     * @throws SQLException    ���ݿ�����쳣��
     * @throws NamingException �����쳣��
     */
    public Vector findByConditionsBack(String strSQL) throws
        Exception,SQLException,NamingException{
        Vector vector = new Vector();
        DbPool dbpool = new DbPool();
        //�����ݿ⣬��ʼ����
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
     * ����SQL����ȡ�����
     * @param dbpool  ���ݿ����ӳ�
     * @param strSQL  SQL���
     * @return Vector ��ѯ�����¼��
     * @throws SQLException    ���ݿ�����쳣��
     * @throws NamingException �����쳣��
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
     * ����SQL����ȡ�����
     * @param dbpool  ���ݿ����ӳ�
     * @param strSQL  SQL���
     * @return Vector ��ѯ�����¼��
     * @throws SQLException    ���ݿ�����쳣��
     * @throws NamingException �����쳣��
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
	 * ��ѯ����ģ����ѯ�����ļ�¼��
	 * @param strSQL  SQLStatement
	 * @return ����ģ����ѯ�����ļ�¼��
	 * @throws Exception
	 */
	public int getSinPayCount(String strWhere) throws
	    Exception{
	    int intCount = 0;
	    DbPool dbpool = new DbPool();
	    //�����ݿ⣬��ʼ����
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
    //�����ݿ⣬��ʼ����
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
     * ������
     * @param args �����б�
     */
    public static void main(String[] args){
        //add test code here
    }
}
