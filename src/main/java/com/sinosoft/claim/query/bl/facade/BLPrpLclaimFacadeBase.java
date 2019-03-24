package com.sinosoft.claim.query.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAction;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaim-立案基本信息表的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.359<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void insert(PrpLclaimDto prpLclaimDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLclaimAction.insert(dbManager,prpLclaimDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    public boolean IsAutoClaim(String claimno)
    {
    	boolean result = false;
    	Collection collection = new ArrayList();

    	try
    	{
    		String statement = "Claimno='" + claimno + "' and autoflag='1'";
    		collection = findByConditions(statement);
    		
    		if(null != collection && collection.size() > 0)
    		{
    			result = true;
    		}
    		
    		
    	}
    	catch(Exception ex)
    	{
    		
    	}
    	
    	return result;
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号码
     * @throws Exception
     */
    public void delete(String claimNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLclaimAction.delete(dbManager,claimNo);
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
        BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLclaimAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void update(PrpLclaimDto prpLclaimDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLclaimAction.update(dbManager,prpLclaimDto);
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
     * @param claimNo 赔案号码
     * @return prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public PrpLclaimDto findByPrimaryKey(String claimNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
        //声明DTO
        PrpLclaimDto prpLclaimDto = null;
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(Constant.QUERY_DATA_SOURCE);
            //查询数据,赋值给DTO
            prpLclaimDto = blPrpLclaimAction.findByPrimaryKey(dbManager,claimNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLclaimDto;
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
        BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLclaimAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLclaimDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLclaimAction.findByConditions(dbManager,conditions);
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
        BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLclaimAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
