package com.sinosoft.claimzy.util;

import java.sql.ResultSet;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.database.DbPool;
import com.sinosoft.utility.error.UserException;

public class BLPrpAgriMaxNo {
	/**
	 * Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(BLPrpAgriMaxNo.class);

  public String MaxNo = "";
  public String MinNo = "";
  public int Count = 0;

  private Vector schemas = new Vector();
  /**
   * 构造函数
   */
  public BLPrpAgriMaxNo(){
  }

  /**
   *初始化记录
   *@param 无
   *@return 无
   *@throws Exception
   */
  public void initArr() throws Exception
  {
    schemas = new Vector();
  }
  /**
   *增加一条PrpMaxNoSchema记录
   *@param iPrpMaxNoSchema PrpMaxNoSchema
   *@throws Exception
   */
  public void setArr(PrpAgriMaxNoSchema iPrpAgriMaxNoSchema) throws Exception
  {
    try
    {
      schemas.add(iPrpAgriMaxNoSchema);
    }
    catch(Exception e)
    {
      throw e;
    }
  }
  /**
   *得到一条PrpMaxNoSchema记录
   *@param index 下标
   *@return 一个PrpMaxNoSchema对象
   *@throws Exception
   */
  public PrpAgriMaxNoSchema getArr(int index) throws Exception
  {
    PrpAgriMaxNoSchema prpAgriMaxNoSchema = null;
    try
    {
    	prpAgriMaxNoSchema = (PrpAgriMaxNoSchema)this.schemas.get(index);
    }
    catch(Exception e)
    {
      throw e;
    }
    return prpAgriMaxNoSchema;
  }
  /**
   *删除一条PrpMaxNoSchema记录
   *@param index 下标
   *@throws Exception
   */
  public void remove(int index) throws Exception
  {
    try
    {
      this.schemas.remove(index);
    }
    catch(Exception e)
    {
      throw e;
    }
  }
  /**
   *得到schemas记录数
   *@return schemas记录数
   *@throws Exception
   */
  public int getSize() throws Exception
  {
    return this.schemas.size();
  }
  /**
   *按照查询条件得到一组记录数，并将这组记录赋给schemas对象
   *@param iWherePart 查询条件(包括排序字句)
   *@throws UserException
   *@throws Exception
   */
  public void query(String iWherePart) throws UserException,Exception
  {
    this.query(iWherePart,Integer.parseInt(SysConfig.getProperty("QUERY_LIMIT_COUNT").trim()));
  }
  /**
   *按照查询条件和记录数限制得到一组记录数，并将这组记录赋给schemas对象
   *@param iWherePart 查询条件(包括排序字句)
   *@param iLimitCount 记录数限制(iLimitCount=0: 无限制)
   *@throws UserException
   *@throws Exception
   */
  public String getGroupNoArr(int index) throws Exception
  {
    String strItem = "";
    try {
      strItem=(String)schemas.get(index);

    }
    catch (Exception ex) {
      throw ex;

    }
    return strItem;
  }
  public void queryGroupNo(String strWherePart) throws UserException, Exception
  {
   String strSqlStatement = "";
   ResultSet rs = null;
   DbPool dbpool = new DbPool();
   DBPrpAgriMaxNo dbPrpAgriMaxNo = new DBPrpAgriMaxNo();
   try{//增加try、catch、finally代码块，关闭数据库连接
	   dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
	   initArr();
	   strSqlStatement = " SELECT DISTINCT GroupNo FROM PrpAgriMaxNo WHERE "
	       + strWherePart;

	   String strItem;
	   for(rs= dbpool.query(strSqlStatement);rs.next();schemas.add(strItem))
	   {
	   strItem = rs.getString("GroupNo");

	   }
   }catch(Exception e){
	   e.printStackTrace();
   }finally{
       if(rs!=null){
        rs.close();
       }
	   dbpool.close(); 
   }
  }

  public void query(String iWherePart,int iLimitCount) throws UserException,Exception
  {
    String strSqlStatement = "";
    DBPrpAgriMaxNo dbPrpAgriMaxNo = new DBPrpAgriMaxNo();
    if (iLimitCount > 0 && dbPrpAgriMaxNo.getCount(iWherePart) > iLimitCount)
    {
      throw new UserException(-98,-1003,"BLPrpAgriMaxNo.query");
    }
    else
    {
      initArr();
      strSqlStatement = " SELECT * FROM PrpAgriMaxNo WHERE " + iWherePart;
      schemas = dbPrpAgriMaxNo.findByConditions(strSqlStatement);
    }
  }

  /**
       *带dbpool的save方法
       *@param 无
       *@return 无
       */
      public void save(DbPool dbpool) throws Exception
      {
        DBPrpAgriMaxNo dbPrpAgriMaxNo = new DBPrpAgriMaxNo();

        int i = 0;
        for(i = 0; i< schemas.size(); i++)
        {
        	dbPrpAgriMaxNo.setSchema((PrpAgriMaxNoSchema)schemas.get(i));
        	dbPrpAgriMaxNo.delete(dbpool,((PrpAgriMaxNoSchema)schemas.get(i)).getGroupNo(),
                             ((PrpAgriMaxNoSchema)schemas.get(i)).getMaxNo());
        	dbPrpAgriMaxNo.insert(dbpool);
        }
      }

      /**
       *不带dbpool的保存方法
       *@param 无
       *@return 无
       */
      public void save() throws Exception
      {
        DbPool dbpool = new DbPool();

        dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));

        try
        {
          dbpool.beginTransaction();
          save(dbpool);
          dbpool.commitTransaction();
        }
        catch (Exception e)
        {
          dbpool.rollbackTransaction();
        }
        finally
        {
          dbpool.close();
        }
      }

  /**
   * 查询可用的最大号和最小号
   * @param groupNo 组号
   * @param tableName 表名
   * @return 查询结果记录集
   * @throws Exception
   */
  public int getMaxMinNo(DbPool dbpool,String iGroupNo) throws Exception
  {
    int intResult = 0;
    String[] strMaxMinNo=new String[3];
    String strSql = " SELECT MAX(MaxNo) MaxNo, MIN(MaxNo) MinNo, COUNT(*) Count FROM prpAgriMaxNo " +
                    " WHERE GroupNo = '" + iGroupNo + "'" ;
    DBPrpAgriMaxNo dbPrpAgriMaxNo = new DBPrpAgriMaxNo();
    strMaxMinNo = dbPrpAgriMaxNo.getMaxMinNo(dbpool,iGroupNo);

    MaxNo = strMaxMinNo[0];
    MinNo = strMaxMinNo[1];
    Count = Integer.parseInt(strMaxMinNo[2]);
    if (Count > 0 )
    {
       intResult = 0;
    }
    else
    {  intResult = 100;
    }
    return intResult;
  }


  /**
   * 查询可用的最大号和最小号
   * @param groupNo 组号
   * @param tableName 表名
   * @return intResult 0:找到 100：找不到
   * @throws Exception
   */
  public int getMaxMinNo(String iGroupNo)
      throws Exception{
    int intResult = 0;
    DbPool dbpool = new DbPool();
    String strDataSource =SysConfig.getProperty("DDCCDATASOURCE");
    //打开数据库，开始事务
    dbpool.open(strDataSource);
    try{
      intResult=getMaxMinNo(dbpool,iGroupNo);
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
   * 获取表中字段的最大值 自开事务
   * @param fieldNo String
   * @param tableName String
   * @throws Exception
   * @return int
   */
  public int getMaxNo(String fieldNo,String tableName,String part) throws Exception
  {
    int maxNo = 0;
    DbPool dbpool = new DbPool();
    dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
    try
    {
      maxNo = this.getMaxNo(dbpool,fieldNo,tableName,part);
    }
    catch(Exception e)
    {
      throw e;
    }
    finally{
      dbpool.close();
    }
    return maxNo;
  }

  /**
   * 获取表中字段的最大值
   * @param dbpool DbPool
   * @param fieldNo String
   * @param tableName String
   * @throws Exception
   * @return int
   * @author 
   * 
   */
  public int getMaxNo(DbPool dbpool,String fieldNo,String tableName,String part) throws Exception
  {
    int maxNo = 0;
    String sql = " SELECT MAX("+fieldNo+") AS MAXNO FROM " + tableName +" WHERE "+part;
    try
    {
      maxNo = new DBPrpAgriMaxNo().getMaxNo(dbpool, sql);
    }
    catch(Exception e)
    {
			logger.error("getMaxNo(DbPool, String, String, String)", e); //$NON-NLS-1$
      throw e;
    }
    return maxNo;
  }
 
  

  /**
   * 更新一条记录
   * @throws Exception
   */
  public void updateMaxNo(String groupno,String maxno) throws Exception{
  
      try{
    	  DBPrpAgriMaxNo dbAgriMaxNo = new DBPrpAgriMaxNo();
    	  dbAgriMaxNo.update(maxno);
      }
      catch(Exception exception){
         
          throw exception;
      }
     
  }

  /**
   * 主函数
   * @param args 参数列表
   */
  public static void main(String[] args){
    //add test code here
  }
}
