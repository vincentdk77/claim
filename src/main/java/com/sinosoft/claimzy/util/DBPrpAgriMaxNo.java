package com.sinosoft.claimzy.util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.NamingException;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;





import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.SysConst;
import com.sinosoft.utility.database.DbPool;





public class DBPrpAgriMaxNo extends PrpAgriMaxNoSchema{
	private static final Log logger = LogFactory.getLog(DBPrpAgriMaxNo.class);
    /**
     * ���캯��
     */
	public DBPrpAgriMaxNo(){
		
	}
	/**
     * ����һ����¼
     * @param dbpool dbpool
     * @throws Exception
     */       
    public void insert(DbPool dbpool) throws Exception{
       	String strSQL = " Insert Into prpagrimaxno(" + 
       	"GROUPNO,"+	
       	"MAXNO ) values(?,?)" ;
    	 int index = 1; 
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
        dbpool.open(SysConst.getProperty("DDCCDATASOURCE"));
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
        String strSQL = " Delete From PrpMaxNo Where GroupNo = " + "'" + groupNo + "'" +
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

    public void update(DbPool dbpool,String maxno) throws Exception{
            	String strSQL = " Update PrpAgriMaxNo Set" +
				        " GroupNo = ?," +
				        " MaxNo = ?" +
				        " Where MaxNo = ?" ;
				         
		dbpool.prepareStatement(strSQL); 
		dbpool.setString(1,getGroupNo());
		dbpool.setString(2,getMaxNo());
		dbpool.setString(3,maxno);
		dbpool.executePreparedUpdate();
		dbpool.closePreparedStatement();
    }

    /**
     * ����һ����¼
     * @throws Exception
     */
    public void update(String maxno) throws Exception{
        DbPool dbpool = new DbPool();
        //�����ݿ⣬��ʼ����
        dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
        try{
            dbpool.beginTransaction();
            update(dbpool,maxno);
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

    public int getInfo(DbPool dbpool,String groupNo,String maxNo) throws Exception{
        int intResult = 0;
        String strSQL = " Select * From PrpAgriMaxNo Where GroupNo = " + "'" + groupNo + "'" +
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

    public int getInfo(String groupNo,String maxNo) throws Exception{
        int intResult = 0;
        DbPool dbpool = new DbPool();
        String strDataSource =SysConfig.getProperty("DDCCDATASOURCE");
        //�����ݿ⣬��ʼ����
        dbpool.open(strDataSource);
        try{
            intResult=getInfo(dbpool,groupNo,maxNo);
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
        String strSQL = " SELECT COUNT(*) FROM PrpAgriMaxNo WHERE "+ strWhere;
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
        PrpAgriMaxNoSchema prpAgriMaxNoSchema = null;
        ResultSet resultSet = dbpool.query(strSQL);
        while(resultSet.next())
        {
        	prpAgriMaxNoSchema = new PrpAgriMaxNoSchema();
        	prpAgriMaxNoSchema.setGroupNo(resultSet.getString("groupNo"));
        	prpAgriMaxNoSchema.setMaxNo(resultSet.getString("maxNo"));
            vector.add(prpAgriMaxNoSchema);
        }
        resultSet.close();
        return vector;
    }

/**
     * @param iGroupNo
     * @param iTableName
     * @return String[]  String[1]:MaxNo,String[2]:MinNo,String[3]:Count
     * @throws Exception
     * @throws SQLException
     * ��ȡ�����С��
 */
    public String[] getMaxMinNo(String iGroupNo,String iTableName)throws
        Exception,SQLException
    {
      String[] strMaxMinNo=new String[3];
      String strSql = " SELECT MAX(MaxNo) MaxNo,MIN(MaxNo) MinNo,COUNT(*) Count FROM PrpAgriMaxNo"+
                      " WHERE GroupNo ='" + iGroupNo + " '";
      DbPool dbpool = new DbPool();
      //�����ݿ⣬��ʼ����
      dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
      try{
        getMaxMinNo(dbpool,iGroupNo);
      }
      catch(Exception e){
          throw e;
        }
        finally{
          dbpool.close();
        }

      return strMaxMinNo;
    }

/**
     * @param dbpool
     * @param iGroupNo
     * @param iTableName
     * @return String[]  String[1]:MaxNo,String[2]:MinNo,String[3]:Count
     * @throws Exception
     * @throws SQLException
     * ��ȡ�����С��
 */
    public String[] getMaxMinNo(DbPool dbpool,String iGroupNo) throws
            Exception,SQLException
    {
          String[] strMaxMinNo=new String[3];
          String strSql = " SELECT MAX(MaxNo) MaxNo,MIN(MaxNo) MinNo,COUNT(*) Count FROM PrpMaxNo"+
                          " WHERE GroupNo ='" + iGroupNo + "'";
		if (logger.isDebugEnabled()) {
			logger.debug("getMaxMinNo(DbPool, String) - ************" + strSql); //$NON-NLS-1$
		}
          ResultSet resultSet = dbpool.query(strSql);
          strMaxMinNo[2]="0";
          while(resultSet.next())
          {
            strMaxMinNo[0]=resultSet.getString("MaxNo")==null?" ":resultSet.getString("MaxNo").trim();
            strMaxMinNo[1]=resultSet.getString("MinNo")==null?" ":resultSet.getString("MinNo").trim();
            strMaxMinNo[2]=resultSet.getString("Count")==null?" ":resultSet.getString("Count").trim();
          }
          resultSet.close();
          return strMaxMinNo;
    }
    
 /**
  * �����ݿ��prpmaxno)����һ����¼
  * @author zhukunlong 
  * @param iGroupNo
  * @param iTableName
  * @throws Exception
  * @throws SQLException
  * 
  */   
    public void InsertMaxNo(String iGroupNo)throws
            Exception,SQLException
    {
    	DbPool dbpool = new DbPool();
    	try{
        	dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
        	dbpool.beginTransaction();
        	String strSql = "insert into PrpAgriMaxNo (GroupNo,MaxNo)values('"+iGroupNo+"','000001')";
        	dbpool.insert(strSql);
        	dbpool.commitTransaction();
    	}catch (Exception e){
    		dbpool.rollbackTransaction();
    		throw  e;
    	}finally{
    		dbpool.close();
		}
    	
     }


    /**
     * ��ȡ�����ֶ����ֵ
     * @param dbpool DbPool
     * @param sql String
     * @throws Exception
     * @throws SQLException
     * 
     * 
     * 
     */
    public int getMaxNo(DbPool dbpool,String sql) throws
        Exception,SQLException
    {
      int maxNo = 0;
      ResultSet resultSet = null;
      try
      {
        resultSet = dbpool.query(sql);
        while (resultSet.next()) {
          maxNo = resultSet.getInt("MAXNO");
        }
      }
      catch(SQLException se)
      {
        throw se;
      }
      catch(Exception e)
      {
			logger.error("getMaxNo(DbPool, String)", e); //$NON-NLS-1$
        throw e;
      }
      finally
      {
        resultSet.close();
      }
      return maxNo;
    }


    /**
     * ������
     * @param args �����б�
     */
    public static void main(String[] args){
        //add test code here
    }

}
