package com.sinosoft.claimzy.facade;

import java.sql.ResultSet;
import java.util.Vector;

import com.sinosoft.prpall.dbsvr.lp.DBPrpLclaim;
import com.sinosoft.prpall.schema.PrpLclaimSchema;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.database.DbPool;
import com.sinosoft.utility.database.PagedStatementFactory;
import com.sinosoft.utility.error.UserException;

/**
 * ����PrpLclaim��BL��
 * @author Administrator
 *
 */
public class BLPrpLclaim{
    private Vector schemas = new Vector();
    /**
     * ���캯��
     */
    public BLPrpLclaim(){
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
     *����һ��PrpLclaimSchema��¼
     *@param iPrpLclaimSchema PrpLclaimSchema
     *@throws Exception
     */
    public void setArr(PrpLclaimSchema iPrpLclaimSchema) throws Exception
    {
       try
       {
         schemas.add(iPrpLclaimSchema);
       }
       catch(Exception e)
       {
         throw e;
       }
     }

    /**
     *�滻һ��PrpLclaimSchema��¼
     *@param iPrpLclaimSchema PrpLclaimSchema
     *@throws Exception
     */
    public void setArr(PrpLclaimSchema iPrpLclaimSchema,int index) throws Exception
    {
       try
       {
         schemas.setElementAt(iPrpLclaimSchema,index);
       }
       catch(Exception e)
       {
         throw e;
       }
     }

    /**
     *�õ�һ��PrpLclaimSchema��¼
     *@param index �±�
     *@return һ��PrpLclaimSchema����
     *@throws Exception
     */
    public PrpLclaimSchema getArr(int index) throws Exception
    {
     PrpLclaimSchema prpLclaimSchema = null;
       try
       {
        prpLclaimSchema = (PrpLclaimSchema)this.schemas.get(index);
       }
       catch(Exception e)
       {
         throw e;
       }
       return prpLclaimSchema;
     }
    /**
     *ɾ��һ��PrpLclaimSchema��¼
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
    public void query(String iWherePart,int iLimitCount) throws UserException,Exception
    {
      String strSqlStatement = "";
      DBPrpLclaim dbPrpLclaim = new DBPrpLclaim();
      if (iLimitCount > 0 && dbPrpLclaim.getCount(iWherePart) > iLimitCount)
      {
        throw new UserException(-98,-1003,"BLPrpLclaim.query");
      }
      else
      {
        initArr();
        strSqlStatement = " SELECT * FROM PrpLclaim WHERE " + iWherePart;
        schemas = dbPrpLclaim.findByConditions(strSqlStatement);
      }
    }
    /**
     *���ղ�ѯ�����õ�һ���¼�������������¼����schemas����
     *@param dbpool ȫ�ֳ�
     *@param iWherePart ��ѯ����(���������־�)
     *@throws UserException
     *@throws Exception
     */
    public void query(DbPool dbpool,String iWherePart) throws UserException,Exception
    {
       this.query(dbpool,iWherePart,Integer.parseInt(SysConfig.getProperty("QUERY_LIMIT_COUNT").trim()));
    }
    /**
     *���ղ�ѯ�����ͼ�¼�����Ƶõ�һ���¼�������������¼����schemas����
     *@param dbpool ȫ�ֳ�
     *@param iWherePart ��ѯ����(���������־�)
     *@param iLimitCount ��¼������(iLimitCount=0: ������)
     *@throws UserException
     *@throws Exception
     */
    public void query(DbPool dbpool,String iWherePart,int iLimitCount) throws UserException,Exception
    {
      String strSqlStatement = "";
      DBPrpLclaim dbPrpLclaim = new DBPrpLclaim();
      if (iLimitCount > 0 && dbPrpLclaim.getCount(iWherePart) > iLimitCount)
      {
        throw new UserException(-98,-1003,"BLPrpLclaim.query");
      }
      else
      {
        initArr();
        strSqlStatement = " SELECT * FROM PrpLclaim WHERE " + iWherePart;
        schemas = dbPrpLclaim.findByConditions(dbpool,strSqlStatement);
      }
    }


  /**
   *@Author     : �й������Ŀ��
   *���ղ�ѯ�����õ�һ���¼�������������¼����schemas����
   *@param iWherePart ��ѯ����(�����������־�)
   *@param iOthWherePart ���Ӳ�ѯ����(GROUP BY,ORDER BY��)
   *@throws UserException
   *@throws Exception
   */
  public void query(String iWherePart,String iOthWherePart) throws UserException,Exception
  {
    DbPool dbpool = new DbPool();
    dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
    try
    {
      this.query(dbpool,iWherePart,iOthWherePart);
    }
    catch (Exception e)
    {
      throw e;
    }
    finally
    {
      dbpool.close();
    }
  }

  /**
   *@Author     : �й������Ŀ��
   *���ղ�ѯ�����õ�һ���¼�������������¼����schemas����
   *@param dbpool ���ӳ�
   *@param iWherePart ��ѯ����(�����������־�)
   *@param iOthWherePart ���Ӳ�ѯ����(GROUP BY,ORDER BY��)
   *@throws UserException
   *@throws Exception
   */
  public void query(DbPool dbpool,String iWherePart,String iOthWherePart) throws Exception
  {
    String strSqlStatement = "";
    DBPrpLclaim dbPrpLclaim = new DBPrpLclaim();
    initArr();
    strSqlStatement = " SELECT * FROM PrpLclaim WHERE " + iWherePart + " " + "and (CaseType<>0 or CaseType is null or CaseType<>1)" + " " + iOthWherePart;

    try
    {
      schemas = dbPrpLclaim.findByConditions(dbpool,strSqlStatement);
    }
    catch(Exception e)
    {
      throw e;
    }
  }

  public void query(DbPool dbpool,String iWherePart,int intPageNum,int intPageCount) throws UserException,Exception
  {
    String strSqlStatement = "";
    int intStartNum = 0;
    int intEndNum = 0;

    intStartNum = (intPageNum - 1) * intPageCount;
    intEndNum = intPageNum * intPageCount;

    DBPrpLclaim dbPrpLclaim = new DBPrpLclaim();
    initArr();
    /*
    strSqlStatement = " SELECT * FROM PrpLclaim WHERE RowId In ( " +
       "Select rid From (Select T.RowId rid,RowNum As LineNum From (" +
       "Select RowId From PrpLclaim Where " + iWherePart +
       ") T Where RowNum<=" + intEndNum + ") Where LineNum>" + intStartNum +
       ") Order By EndorseNo DESC";
    */
/*    strSqlStatement = " SELECT * FROM ( " +
       "Select RowNum As LineNum,T.* From ( " +
       "Select * From PrpLclaim Where " + iWherePart +
       ") T Where RowNum<=" + intEndNum + ") U Where LineNum>" +
       intStartNum + " Order By ClaimNo DESC";   
*/
    strSqlStatement = "Select * From PrpLclaim Where " + iWherePart ;
    //�����ҳ
    strSqlStatement = PagedStatementFactory.getInstance().getPagedStatementWithOrderBy(
        			strSqlStatement, intStartNum, intEndNum, "ClaimNo");
    
    schemas = dbPrpLclaim.findByConditions(dbpool,strSqlStatement);
  }


  public void query(String iWherePart,int intPageNum,int intPageCount) throws UserException,Exception
  {
    DbPool dbpool = new DbPool();
    dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
    try
    {
      this.query(dbpool,iWherePart,intPageNum,intPageCount);
    }
    catch (Exception e)
    {
      throw e;
    }
    finally
    {
      dbpool.close();
    }
  }



    /**
     *��dbpool��save����
     *@param ��
     *@return ��
     */
    public void save(DbPool dbpool) throws Exception
    {
      DBPrpLclaim dbPrpLclaim = new DBPrpLclaim();

      int i = 0;

      for(i = 0; i< schemas.size(); i++)
      {
      dbPrpLclaim.setSchema((PrpLclaimSchema)schemas.get(i));
      dbPrpLclaim.insert(dbpool);
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
     *��dbpool��ɾ������
     *@param dbpool    ���ӳ�
     *@param iClaimNo ������
     *@return ��
     */
    public void cancel(DbPool dbpool,String iClaimNo) throws Exception
    {
      String strSqlStatement = "";

      strSqlStatement = " DELETE FROM PrpLclaim WHERE ClaimNo= '" + iClaimNo + "'";

      dbpool.delete(strSqlStatement);
    }

    /**
     * ����dbpool��ɾ������
     *@param iClaimNo ������
     *@return ��
     */
    public void cancel(String iClaimNo ) throws Exception
    {
      DbPool dbpool = new DbPool();

      dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
      try
      {
        dbpool.beginTransaction();
        cancel(dbpool,iClaimNo);
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
     * ��dbpool���������Ż�ȡ����
     *@param iClaimNo ������
     *@return ��
     */
    public void getData(String iClaimNo) throws Exception
    {
      DbPool dbpool = new DbPool();
      dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
      getData(dbpool,iClaimNo);
      dbpool.close();
    }

    /**
     * ����dbpool���������Ż�ȡ����
     *@param dbpool ���ӳ�
     *@param iClaimNo ������
     *@return ��
     */
    public void getData(DbPool dbpool,String iClaimNo) throws Exception
    {
    String strWherePart = "";
    strWherePart = "ClaimNo= '" + iClaimNo + "'";
    query(dbpool,strWherePart,0);
    }

    /* add by liuning begin 20040412 */
       /**
     *���ղ�ѯ�����õ�һ���¼�������������¼����schemas����
     *@param iWherePart ��ѯ����(���������־�)
     *@throws UserException
     *@throws Exception
     */
    public void querySum1(String iWherePart) throws UserException,Exception
    {
       this.querySum1(iWherePart,Integer.parseInt(SysConfig.getProperty("QUERY_LIMIT_COUNT").trim()));
    }
    /**
     *���ղ�ѯ�����ͼ�¼�����Ƶõ�һ���¼�������������¼����schemas����
     *@param iWherePart ��ѯ����(���������־�)
     *@param iLimitCount ��¼������(iLimitCount=0: ������)
     *@throws UserException
     *@throws Exception
     */
    public void querySum1(String iWherePart,int iLimitCount) throws UserException,Exception
    {
      String strSqlStatement = "";
      DBPrpLclaim dbPrpLclaim = new DBPrpLclaim();
      if (iLimitCount > 0 && dbPrpLclaim.getCount(iWherePart) > iLimitCount)
      {
        throw new UserException(-98,-1003,"BLPrpLclaim.querySum1");
      }
      else
      {
        initArr();
        strSqlStatement = " SELECT sum(SumPaid) as SumPaid,Currency,EndCaseDate FROM PrpLclaim WHERE " + iWherePart;
        schemas = dbPrpLclaim.findSum1ByConditions(strSqlStatement);
      }
    }

  /**
    *@desc Ϊ δ������ѯ�����ӵķ���
    *@Author     : �й������Ŀ��
    *@param dbpool ���ӳ�
    *@param iWherePart ��ѯ����(�����������־�)
    *@param iOthWherePart ���Ӳ�ѯ����(ORDER BY��)
    *@throws UserException
    *@throws Exception
    */
    public void querySumForNoEndCase(DbPool dbpool,String iWherePart,String iOthWherePart) throws UserException,Exception
    {
      String strSqlStatement = "";
      PrpLclaimSchema prpLclaimSchema = null;
      this.initArr();
      strSqlStatement = " SELECT sum(PrpLclaim.SumClaim) as SumClaim,count(*) as Count,"
         + " PrpLclaim.ClassCode,PrpLclaim.RiskCode,PrpLclaim.Currency,PrpLclaim.StartDate,PrpLclaim.EndDate "
         + " FROM PrpLclaim,PrpCmain WHERE PrpLclaim.PolicyNo=PrpCmain.PolicyNo AND " + iWherePart
         + " GROUP BY PrpLclaim.ClassCode,PrpLclaim.RiskCode,PrpLclaim.Currency,PrpLclaim.StartDate,PrpLclaim.EndDate"
         + iOthWherePart;
      strSqlStatement = SqlUtils.getWherePartForGetCount(strSqlStatement);
      ResultSet rs = dbpool.query(strSqlStatement);
      while(rs.next())
      {
        prpLclaimSchema = new PrpLclaimSchema();
        prpLclaimSchema.setClassCode(rs.getString("ClassCode"));
        prpLclaimSchema.setRiskCode(rs.getString("RiskCode"));
        prpLclaimSchema.setCurrency(rs.getString("Currency"));
        prpLclaimSchema.setStartDate(""+rs.getDate("StartDate"));
        prpLclaimSchema.setEndDate(""+rs.getDate("EndDate"));
        prpLclaimSchema.setSumClaim(""+rs.getDouble("SumClaim"));
        prpLclaimSchema.setRemark(rs.getString("Count"));
        this.setArr(prpLclaimSchema);
      }
    }

    /* add by liuning end 20040412 */
    /**
     * ������
     * @param args �����б�
     */
    public static void main(String[] args){
        //add test code here
    }
}
