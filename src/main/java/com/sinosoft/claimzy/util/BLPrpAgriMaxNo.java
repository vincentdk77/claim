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
   * ���캯��
   */
  public BLPrpAgriMaxNo(){
  }

  /**
   *��ʼ����¼
   *@param ��
   *@return ��
   *@throws Exception
   */
  public void initArr() throws Exception
  {
    schemas = new Vector();
  }
  /**
   *����һ��PrpMaxNoSchema��¼
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
   *�õ�һ��PrpMaxNoSchema��¼
   *@param index �±�
   *@return һ��PrpMaxNoSchema����
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
   *ɾ��һ��PrpMaxNoSchema��¼
   *@param index �±�
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
   *�õ�schemas��¼��
   *@return schemas��¼��
   *@throws Exception
   */
  public int getSize() throws Exception
  {
    return this.schemas.size();
  }
  /**
   *���ղ�ѯ�����õ�һ���¼�������������¼����schemas����
   *@param iWherePart ��ѯ����(���������־�)
   *@throws UserException
   *@throws Exception
   */
  public void query(String iWherePart) throws UserException,Exception
  {
    this.query(iWherePart,Integer.parseInt(SysConfig.getProperty("QUERY_LIMIT_COUNT").trim()));
  }
  /**
   *���ղ�ѯ�����ͼ�¼�����Ƶõ�һ���¼�������������¼����schemas����
   *@param iWherePart ��ѯ����(���������־�)
   *@param iLimitCount ��¼������(iLimitCount=0: ������)
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
   try{//����try��catch��finally����飬�ر����ݿ�����
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
       *��dbpool��save����
       *@param ��
       *@return ��
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
       *����dbpool�ı��淽��
       *@param ��
       *@return ��
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
   * ��ѯ���õ����ź���С��
   * @param groupNo ���
   * @param tableName ����
   * @return ��ѯ�����¼��
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
   * ��ѯ���õ����ź���С��
   * @param groupNo ���
   * @param tableName ����
   * @return intResult 0:�ҵ� 100���Ҳ���
   * @throws Exception
   */
  public int getMaxMinNo(String iGroupNo)
      throws Exception{
    int intResult = 0;
    DbPool dbpool = new DbPool();
    String strDataSource =SysConfig.getProperty("DDCCDATASOURCE");
    //�����ݿ⣬��ʼ����
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
   * ��ȡ�����ֶε����ֵ �Կ�����
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
   * ��ȡ�����ֶε����ֵ
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
   * ����һ����¼
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
   * ������
   * @param args �����б�
   */
  public static void main(String[] args){
    //add test code here
  }
}
