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
 * 定义PrpLclaim的BL类
 * @author Administrator
 *
 */
public class BLPrpLclaim{
    private Vector schemas = new Vector();
    /**
     * 构造函数
     */
    public BLPrpLclaim(){
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
     *增加一条PrpLclaimSchema记录
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
     *替换一条PrpLclaimSchema记录
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
     *得到一条PrpLclaimSchema记录
     *@param index 下标
     *@return 一个PrpLclaimSchema对象
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
     *删除一条PrpLclaimSchema记录
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
     *按照查询条件得到一组记录数，并将这组记录赋给schemas对象
     *@param dbpool 全局池
     *@param iWherePart 查询条件(包括排序字句)
     *@throws UserException
     *@throws Exception
     */
    public void query(DbPool dbpool,String iWherePart) throws UserException,Exception
    {
       this.query(dbpool,iWherePart,Integer.parseInt(SysConfig.getProperty("QUERY_LIMIT_COUNT").trim()));
    }
    /**
     *按照查询条件和记录数限制得到一组记录数，并将这组记录赋给schemas对象
     *@param dbpool 全局池
     *@param iWherePart 查询条件(包括排序字句)
     *@param iLimitCount 记录数限制(iLimitCount=0: 无限制)
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
   *@Author     : 中国大地项目组
   *按照查询条件得到一组记录数，并将这组记录赋给schemas对象
   *@param iWherePart 查询条件(不包括排序字句)
   *@param iOthWherePart 附加查询条件(GROUP BY,ORDER BY等)
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
   *@Author     : 中国大地项目组
   *按照查询条件得到一组记录数，并将这组记录赋给schemas对象
   *@param dbpool 连接池
   *@param iWherePart 查询条件(不包括排序字句)
   *@param iOthWherePart 附加查询条件(GROUP BY,ORDER BY等)
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
    //加入分页
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
     *带dbpool的save方法
     *@param 无
     *@return 无
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
     *带dbpool的删除方法
     *@param dbpool    连接池
     *@param iClaimNo 立案号
     *@return 无
     */
    public void cancel(DbPool dbpool,String iClaimNo) throws Exception
    {
      String strSqlStatement = "";

      strSqlStatement = " DELETE FROM PrpLclaim WHERE ClaimNo= '" + iClaimNo + "'";

      dbpool.delete(strSqlStatement);
    }

    /**
     * 不带dbpool的删除方法
     *@param iClaimNo 立案号
     *@return 无
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
     * 带dbpool根据立案号获取数据
     *@param iClaimNo 立案号
     *@return 无
     */
    public void getData(String iClaimNo) throws Exception
    {
      DbPool dbpool = new DbPool();
      dbpool.open(SysConfig.getProperty("DDCCDATASOURCE"));
      getData(dbpool,iClaimNo);
      dbpool.close();
    }

    /**
     * 不带dbpool根据立案号获取数据
     *@param dbpool 连接池
     *@param iClaimNo 立案号
     *@return 无
     */
    public void getData(DbPool dbpool,String iClaimNo) throws Exception
    {
    String strWherePart = "";
    strWherePart = "ClaimNo= '" + iClaimNo + "'";
    query(dbpool,strWherePart,0);
    }

    /* add by liuning begin 20040412 */
       /**
     *按照查询条件得到一组记录数，并将这组记录赋给schemas对象
     *@param iWherePart 查询条件(包括排序字句)
     *@throws UserException
     *@throws Exception
     */
    public void querySum1(String iWherePart) throws UserException,Exception
    {
       this.querySum1(iWherePart,Integer.parseInt(SysConfig.getProperty("QUERY_LIMIT_COUNT").trim()));
    }
    /**
     *按照查询条件和记录数限制得到一组记录数，并将这组记录赋给schemas对象
     *@param iWherePart 查询条件(包括排序字句)
     *@param iLimitCount 记录数限制(iLimitCount=0: 无限制)
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
    *@desc 为 未决赔款查询而增加的方法
    *@Author     : 中国大地项目组
    *@param dbpool 连接池
    *@param iWherePart 查询条件(不包括排序字句)
    *@param iOthWherePart 附加查询条件(ORDER BY等)
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
     * 主函数
     * @param args 参数列表
     */
    public static void main(String[] args){
        //add test code here
    }
}
