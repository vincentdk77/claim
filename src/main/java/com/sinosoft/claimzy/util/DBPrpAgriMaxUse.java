package com.sinosoft.claimzy.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.NamingException;


import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.database.DbPool;

public class DBPrpAgriMaxUse extends PrpAgriMaxUseSchema {
   /**
    * ���캯��
    */
	public DBPrpAgriMaxUse(){
		
	}
	 /**
     * ����һ����¼
     * @param dbpool dbpool
     * @throws Exception
     */       
    public void insert(DbPool dbpool) throws Exception{
    	String strSQL = " Insert Into PrpAgriMaxUse(" + 
				        " GroupNo, " + 
				        " MaxNo ) values(?,?) ";	
    	int index=1;
		dbpool.prepareStatement(strSQL); 
		dbpool.setString(index++,getGroupNo());
		dbpool.setString(index++,getMaxNo());
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
        dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
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

    public void delete(DbPool dbpool,String groupNo,String maxNo) throws Exception{
        String strSQL = " Delete From PrpMaxUse Where GroupNo = " + "'" + groupNo + "'" +
                            " And MaxNo = " + "'" + maxNo + "'";
        dbpool.delete(strSQL);
    }

    public void delete(String groupNo,String maxNo) throws Exception{
        DbPool dbpool = new DbPool();
        //�����ݿ⣬��ʼ����
        dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
        try{
            dbpool.beginTransaction();
            delete(dbpool,groupNo,maxNo);
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
      
    	String strSQL = " Update PrpAgriMaxUse Set" +
				        " GroupNo = ?," +
				        " MaxNo = ?," +
				        " Where GroupNo = ?" +
				         " And MaxNo = ?";
    	int index=1;
		dbpool.prepareStatement(strSQL); 
		dbpool.setString(index++,getGroupNo());
		dbpool.setString(index++,getMaxNo());
		dbpool.setString(index++,getGroupNo());
		dbpool.setString(index++,getMaxNo());
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
        dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
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

    public int getInfo(DbPool dbpool,String groupNo,String tableName,String maxNo) throws Exception{
        int intResult = 0;
        String strSQL = " Select * From PrpAgriMaxUse Where GroupNo = " + "'" + groupNo + "'" +
                            " And MaxNo = " + "'" + maxNo + "'";
        ResultSet resultSet = dbpool.query(strSQL);
        if(resultSet.next()){
            setGroupNo(resultSet.getString("groupNo"));
            setMaxNo(resultSet.getString("maxNo"));
            intResult = 0;
        }
        else{
            intResult = 100;
        }
        resultSet.close();
        return intResult;
    }

    public int getInfo(String groupNo,String tableName,String maxNo) throws Exception{
        int intResult = 0;
        DbPool dbpool = new DbPool();
        String strDataSource =SysConfig.getProperty("DDCCDATASOURCE");
        //�����ݿ⣬��ʼ����
        dbpool.open(strDataSource);
        try{
            intResult=getInfo(dbpool,groupNo,tableName,maxNo);
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
        String strSQL = " SELECT COUNT(*) FROM PrpAgriMaxUse WHERE "+ strWhere;
        strSQL = SqlUtils.getWherePartForGetCount(strSQL);
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
        dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
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
        dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
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
     * @param dbpool  ���ݿ����ӳ�
     * @param strSQL  SQL���
     * @return Vector ��ѯ�����¼��
     * @throws SQLException    ���ݿ�����쳣��
     * @throws NamingException �����쳣��
     */
    public Vector findByConditions(DbPool dbpool,String strSQL) throws
        SQLException,NamingException{
        Vector vector = new Vector();
        PrpAgriMaxUseSchema prpAgriMaxUseSchema = null;
        ResultSet resultSet = dbpool.query(strSQL);
        while(resultSet.next())
        {
        	prpAgriMaxUseSchema = new PrpAgriMaxUseSchema();
        	prpAgriMaxUseSchema.setGroupNo(resultSet.getString("groupNo"));
            prpAgriMaxUseSchema.setMaxNo(resultSet.getString("maxNo"));
            vector.add(prpAgriMaxUseSchema);
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
