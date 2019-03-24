package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcompensateAction;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.database.DbPool;

/**
 * 这是PrpLcompensate-赔款计算书表的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.375<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcompensateFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcompensateFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcompensateFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public void insert(PrpLcompensateDto prpLcompensateDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLcompensateAction.insert(dbManager,prpLcompensateDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键删除一条数据
     * @param compensateNo 赔款计算书号码
     * @throws Exception
     */
    public void delete(String compensateNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLcompensateAction.delete(dbManager,compensateNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按条件删除数据
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLcompensateAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public void update(PrpLcompensateDto prpLcompensateDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLcompensateAction.update(dbManager,prpLcompensateDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键查找一条数据
     * @param compensateNo 赔款计算书号码
     * @return prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public PrpLcompensateDto findByPrimaryKey(String compensateNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        //声明DTO
        PrpLcompensateDto prpLcompensateDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLcompensateDto = blPrpLcompensateAction.findByPrimaryKey(dbManager,compensateNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcompensateDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLcompensateAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection 包含prpLcompensateDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLcompensateAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLcompensateAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    /**
     * 查找理赔清单相关数据
     * @param conditions 查询条件
     *@param rowsPerPage 记录数限制(rowsPerPage=0: 无限制)
     * @throws Exception
     */
    public Collection findByConditionsForNXDA(String conditions,int pageNo,int rowsPerPage) throws Exception{
        Collection collection = new ArrayList(rowsPerPage);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        
        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blPrpLcompensateAction.findByConditionsForNXDA(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
    
    /**
     * 查询满足条件的理赔清单的记录数
     * @param conditions conditions
     * @return 查询满足条件的理赔清单记录数
     * @throws Exception
     */
    public int getCountForNXDA(String conditions) 
        throws Exception{
        int rowCount= -1;

        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPrpLcompensateAction.getCountForNXDA(dbManager, conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    
    /**
     * 查询理赔清单的总亩数
     * @param conditions conditions
     * @return 查询满足条件的理赔清单总亩数
     * @throws Exception
     */
    public double getSumSettleAreaForNXDA(String conditions) 
        throws Exception{
    	double rowCount= -1;

        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPrpLcompensateAction.getSumSettleAreaForNXDA(dbManager, conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    /**
     * 理赔 回写SETTLELISTCODELIST  信息数据
     * @param registNo 报案号
     * @param claimNo  立案号
     * @param compensateNo 计算书号
     * @param relationNo 理算清单号
     * @throws Exception
     */
    public void update(String registNo,String claimNo,String compensateNo,String relationNo) throws Exception{
    	DbPool dbpool = new DbPool();
    	
    	  dbpool.open("NXDADataSource");
    	  try
    	  {
    	    dbpool.beginTransaction();
    	    String strSQL = " Update SETTLELISTCODELIST  Set" +
					        " reportcode = ?, " +
					        " registercode = ?, " +
					        " adjustmentcode = ? " +
					        " Where settlelistcode = ?";     

    	    int index=1;   
    	    dbpool.prepareStatement(strSQL);  
    	    dbpool.setString(index++,registNo); 
    	    dbpool.setString(index++,claimNo);
    	    dbpool.setString(index++,compensateNo);
            dbpool.setString(index++,relationNo); 
            dbpool.executePreparedUpdate(); 
            dbpool.closePreparedStatement();  
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
}
