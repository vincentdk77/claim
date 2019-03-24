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
     * 构造函数
     */
	public DBPrpAgriMaxNo(){
		
	}
	/**
     * 插入一条记录
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
     * 插入一条记录
     * @throws Exception
     */       
    public void insert() throws Exception{
        DbPool dbpool = new DbPool();
        //打开数据库，开始事务
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
        //打开数据库，开始事务
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
     * 更新一条记录
     * @throws Exception
     */
    public void update(String maxno) throws Exception{
        DbPool dbpool = new DbPool();
        //打开数据库，开始事务
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
        //打开数据库，开始事务
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
     * 获取最大最小号
 */
    public String[] getMaxMinNo(String iGroupNo,String iTableName)throws
        Exception,SQLException
    {
      String[] strMaxMinNo=new String[3];
      String strSql = " SELECT MAX(MaxNo) MaxNo,MIN(MaxNo) MinNo,COUNT(*) Count FROM PrpAgriMaxNo"+
                      " WHERE GroupNo ='" + iGroupNo + " '";
      DbPool dbpool = new DbPool();
      //打开数据库，开始事务
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
     * 获取最大最小号
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
  * 向数据库表（prpmaxno)插入一条记录
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
     * 获取表中字段最大值
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
     * 主函数
     * @param args 参数列表
     */
    public static void main(String[] args){
        //add test code here
    }

}
