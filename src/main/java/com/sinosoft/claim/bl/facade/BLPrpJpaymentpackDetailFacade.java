package com.sinosoft.claim.bl.facade;

import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpaymentpackDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJpaymentpackDetailBase;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utility.SysConst;
import com.sinosoft.utility.database.DbPool;
import com.sinosoft.utility.database.PagedStatementFactory;
import com.sinosoft.utility.error.UserException;

/**
 * 定义PrpJpackDetail的BL类
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * 
 * @createdate 2005-05-27
 *             </p>
 * @author BLGenerator
 * @version 1.0
 */
public class BLPrpJpaymentpackDetailFacade {
    private Vector schemas = new Vector();

    private static Log logger = LogFactory.getLog(BLPrpJpaymentpackDetailFacade.class);


    /**
     * 构造函数
     */
    public BLPrpJpaymentpackDetailFacade() {
    }

    /**
     * 初始化记录
     * 
     * @param 无
     * @return 无
     * @throws Exception
     */
    public void initArr() throws Exception {
        schemas = new Vector();
    }

    /**
     * 增加一条BLPrpJpaymentpackDetailDto记录
     * 
     * @param 
     *            BLPrpJpaymentpackDetailDto
     * @throws Exception
     */
    public void setArr(PrpJpaymentpackDetailDto iPrpJpaymentpackDetailDto) throws Exception
    {
        try 
        {
            schemas.add(iPrpJpaymentpackDetailDto);
        } catch (Exception e) {
            throw e;
        }
      
    }
    /**
     * 得到一条PrpJpaymentpackDetailDto记录
     * 
     * @param index
     *            下标
     * @return 一个PrpJpaymentpackDetailDto对象
     * @throws Exception
     */
    public PrpJpaymentpackDetailDto getArr(int index) throws Exception {
    	PrpJpaymentpackDetailDto prpJpaymentpackDetailDto = null;
        try {
        	prpJpaymentpackDetailDto = (PrpJpaymentpackDetailDto) this.schemas.get(index);
        } catch (Exception e) {
            throw e;
        }
        return prpJpaymentpackDetailDto;
    }
    /**
     * 得到schemas记录
     * @return 一个PrpJpaymentpackDetailDto对象
     * @throws Exception
     */
    public Vector getSchemas() throws Exception {

        return this.schemas;
    }

    /**
     * 删除一条PrpJpaymentpackDetailDto记录
     * 
     * @param index
     *            下标
     * @throws Exception
     */
    public void remove(int index) throws Exception {
        try {
            this.schemas.remove(index);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 得到schemas记录数
     * 
     * @return schemas记录数
     * @throws Exception
     */
    public int getSize() throws Exception {
        return this.schemas.size();
    }

    /**
     * 按照查询条件得到一组记录数，并将这组记录赋给schemas对象
     * 
     * @param iWherePart
     *            查询条件(包括排序字句)
     * @throws UserException
     * @throws Exception
     */
    public void query(String iWherePart) throws UserException, Exception {
        this.query(iWherePart, Integer.parseInt(SysConst.getProperty("QUERY_LIMIT_COUNT").trim()));
    }

    /**
     * 按照查询条件和记录数限制得到一组记录数，并将这组记录赋给schemas对象
     * 
     * @param iWherePart
     *            查询条件(包括排序字句)
     * @param iLimitCount
     *            记录数限制(iLimitCount=0: 无限制)
     * @throws UserException
     * @throws Exception
     */
    public void query(String iWherePart, int iLimitCount) throws UserException, Exception {
        String strSqlStatement = "";
        DBPrpJpaymentpackDetailBase dbPrpJpaymentpackDetailBase = new DBPrpJpaymentpackDetailBase();
        if (iLimitCount > 0 && dbPrpJpaymentpackDetailBase.getCount(iWherePart) > iLimitCount) {
            throw new UserException(-98, -1003, "BLPrpJpackDetail.query", "查询结果个数超过系统限制");
        } else {
            initArr();
            strSqlStatement = " SELECT * FROM PrpJpackDetail WHERE " + iWherePart;
            schemas = dbPrpJpaymentpackDetailBase.findByConditions(strSqlStatement);
        }
    }
    
    public void queryBack(String iWherePart, int iLimitCount) throws UserException, Exception {
        String strSqlStatement = "";
        DBPrpJpaymentpackDetailBase dbPrpJpaymentpackDetailBase = new DBPrpJpaymentpackDetailBase();
        if (iLimitCount > 0 && dbPrpJpaymentpackDetailBase.getCountBack(iWherePart) > iLimitCount) {
            throw new UserException(-98, -1003, "BLPrpJpackDetail.query", "查询结果个数超过系统限制");
        } else {
            initArr();
            strSqlStatement = " SELECT PrpJpackDetail.*,prpjplanfee.policyNo FROM PrpJpackDetail,prpjpackmain,prpjplanfee WHERE " + iWherePart;
            schemas = dbPrpJpaymentpackDetailBase.findByConditionsBack(strSqlStatement);
        }
    }


    /**
     * 按照查询条件得到一组记录数，并将这组记录赋给schemas对象
     * 
     * @param dbpool
     *            全局池
     * @param iWherePart
     *            查询条件(包括排序字句)
     * @throws UserException
     * @throws Exception
     */
    public void query(DbPool dbpool, String iWherePart) throws UserException, Exception {
        this.query(dbpool, iWherePart, Integer.parseInt(SysConst.getProperty("QUERY_LIMIT_COUNT").trim()));
    }

    /**
     * 按照查询条件和记录数限制得到一组记录数，并将这组记录赋给schemas对象
     * 
     * @param dbpool
     *            全局池
     * @param iWherePart
     *            查询条件(包括排序字句)
     * @param iLimitCount
     *            记录数限制(iLimitCount=0: 无限制)
     * @throws UserException
     * @throws Exception
     */
    public void query(DbPool dbpool, String iWherePart, int iLimitCount) throws UserException, Exception {
        String strSqlStatement = "";
        DBPrpJpaymentpackDetailBase dbPrpJpaymentpackDetailBase = new DBPrpJpaymentpackDetailBase();
        if (iLimitCount > 0 && dbPrpJpaymentpackDetailBase.getCount(dbpool, iWherePart) > iLimitCount) {
            throw new UserException(-98, -1003, "BLPrpJpackDetail.query");
        } else {
            initArr();
            strSqlStatement = " SELECT * FROM PrpJpackDetail WHERE " + iWherePart;
            schemas = dbPrpJpaymentpackDetailBase.findByConditions(dbpool, strSqlStatement);
        }
    }

    public void query(String iWherePart, int intPageNum, int intPageCount) throws UserException, Exception {
        DbPool dbpool = new DbPool();
        dbpool.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            this.query(dbpool, iWherePart, intPageNum, intPageCount);
        } catch (Exception e) {
            throw e;
        } finally {
            dbpool.close();
        }
    }

    public void query(DbPool dbpool, String iWherePart, int intPageNum, int intPageCount) throws UserException, Exception {
        String strSqlStatement = "";
        int intStartNum = 0;
        int intEndNum = 0;

        intStartNum = (intPageNum - 1) * intPageCount;
        intEndNum = intPageNum * intPageCount;

        DBPrpJpaymentpackDetailBase dbPrpJpaymentpackDetailBase = new DBPrpJpaymentpackDetailBase();
        initArr();

        strSqlStatement = "Select * From PrpJpackDetail Where " + iWherePart;
        // 加入分页
        strSqlStatement = PagedStatementFactory.getInstance().getPagedStatementWithOrderBy(strSqlStatement, intStartNum,
                intEndNum, "packno");

        schemas = dbPrpJpaymentpackDetailBase.findByConditions(dbpool, strSqlStatement);
    }

    /**
     * 带dbpool的save方法
     * 
     * @param 无
     * @return 无
     */
    public void save(DbPool dbpool) throws Exception {
        DBPrpJpaymentpackDetailBase dbPrpJpaymentpackDetailBase = new DBPrpJpaymentpackDetailBase();

        for (int i = 0; i < schemas.size(); i++) {
            dbPrpJpaymentpackDetailBase.setSchema((PrpJpaymentpackDetailDto) schemas.get(i));
            dbPrpJpaymentpackDetailBase.insert(dbpool);
        }
    }

    /**
     * 不带dbpool的保存方法
     * 
     * @param 无
     * @return 无
     */
    public void save() throws Exception {
        DbPool dbpool = new DbPool();

        dbpool.open(AppConfig.get("sysconst.DBJNDI"));

        try {
            dbpool.beginTransaction();
            save(dbpool);
            dbpool.commitTransaction();
        } catch (Exception e) {
            dbpool.rollbackTransaction();
        } finally {
            dbpool.close();
        }
    }

    
    /**
	 * 按照查询条件和记录数限制得到一组记录数，并将这组记录赋给schemas对象
	 * 
	 * @param dbpool
	 *            全局池
	 * @param iWherePart
	 *            查询条件(包括排序字句)
	 * @param iLimitCount
	 *            记录数限制(iLimitCount=0: 无限制)
	 * @throws UserException
	 * @throws Exception
	 */
    public void query(DbPool dbpool, String iWherePart,String OrderByWherePart, int iLimitCount) throws UserException, Exception {
        String strSqlStatement = "";
        DBPrpJpaymentpackDetailBase dbPrpJpaymentpackDetailBase = new DBPrpJpaymentpackDetailBase();
        if (iLimitCount > 0 && dbPrpJpaymentpackDetailBase.getCount(dbpool, iWherePart) > iLimitCount) {
            throw new UserException(-98, -1003, "BLPrpJpackDetail.query");
        } else {
            initArr();
            strSqlStatement = " SELECT * FROM PrpJpackDetail WHERE " + iWherePart+" "+OrderByWherePart;
            schemas = dbPrpJpaymentpackDetailBase.findByConditions(dbpool, strSqlStatement);
        }
    }
    
    
    
    /**
     *不带dbpool的保存方法
     *@param 无
     *@return 无
     */
    public void update() throws Exception
    {
      DbPool dbpool = new DbPool();

      dbpool.open(AppConfig.get("sysconst.DBJNDI"));

      try
      {
        dbpool.beginTransaction();
        update(dbpool);
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
     *带dbpool的save方法
     *@param 无
     *@return 无
     */
    public void update(DbPool dbpool) throws Exception
    {
    	DBPrpJpaymentpackDetailBase dbPrpJpaymentpackDetailBase = new DBPrpJpaymentpackDetailBase();

      int i = 0;

      for(i = 0; i< schemas.size(); i++)
      {
    	  dbPrpJpaymentpackDetailBase.setSchema((PrpJpaymentpackDetailDto)schemas.get(i));
    	  dbPrpJpaymentpackDetailBase.update(dbpool);
      }
    }
    
    public void sinPayquery(String iWherePart, int iLimitCount) throws UserException, Exception {
        String strSqlStatement = "";
        DBPrpJpaymentpackDetailBase dbPrpJpaymentpackDetailBase = new DBPrpJpaymentpackDetailBase();
        if (iLimitCount > 0 && dbPrpJpaymentpackDetailBase.getSinPayCount(iWherePart) > iLimitCount) {
            throw new UserException(-98, -1003, "BLPrpJpackDetail.sinPayquery", "查询结果个数超过系统限制");
        } else {
            initArr();
            strSqlStatement = " SELECT prpjpackdetail.* FROM prpjpackdetail WHERE " + iWherePart;
            schemas = dbPrpJpaymentpackDetailBase.findSinPayByConditions(strSqlStatement);
        }
    }
    
    public void querySinPayStatTCondi(String iWherePart) throws Exception {
    	String strSqlStatement = "";
    	DBPrpJpaymentpackDetailBase dbPrpJpaymentpackDetailBase = new DBPrpJpaymentpackDetailBase();
    	DbPool dbpool = new DbPool();
    	dbpool.open(AppConfig.get("sysconst.DBJNDI"));
    	try{
    		dbpool.beginTransaction();
    		strSqlStatement = " select  '处理中' as receiverfullname,sum(payreffee) as payreffee,count(payreffee) as visaserialno from prpjpackdetail where " + iWherePart;
        	schemas = dbPrpJpaymentpackDetailBase.querySinPayStatTCondi(dbpool,strSqlStatement);
        	dbpool.commitTransaction();
    	}catch(Exception e){
    		e.printStackTrace();
    		dbpool.rollbackTransaction();
    	}finally{
    		dbpool.close();
    	}
    	
    }
    
    public void queryByMerSeqIdTo(DbPool dbpool,String iWherePart)throws Exception {
    	String strSqlStatement = "";
        DBPrpJpaymentpackDetailBase dbPrpJpaymentpackDetailBase = new DBPrpJpaymentpackDetailBase();
        initArr();
        strSqlStatement = " SELECT * FROM PrpJpackDetail WHERE " + iWherePart;
        schemas = dbPrpJpaymentpackDetailBase.findByConditions(dbpool, strSqlStatement);
    	
    }
    
    /**
	 * 主函数
	 * 
	 * @param args
	 *            参数列表
	 */
    public static void main(String[] args) {
        // add test code here
    	
    }
     

    
}
