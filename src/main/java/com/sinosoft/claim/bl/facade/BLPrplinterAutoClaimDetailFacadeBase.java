package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrplinterAutoClaimDetailAction;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗理赔自动流程状态查询表的业务逻辑对象Facade基类<br>
 */
public class BLPrplinterAutoClaimDetailFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplinterAutoClaimDetailFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrplinterAutoClaimDetailFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void insert(PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrplinterAutoClaimDetailAction.insert(dbManager,prplinterAutoClaimDetailDto);
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
     * @param id 主键
     * @param registNo 报案号码
     * @throws Exception
     */
    public void delete(String id,String registNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplinterAutoClaimDetailAction.delete(dbManager,id, registNo);
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
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrplinterAutoClaimDetailAction.deleteByConditions(dbManager,conditions);
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
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void update(PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplinterAutoClaimDetailAction.update(dbManager,prplinterAutoClaimDetailDto);
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
     * @param id 主键
     * @param registNo 报案号码
     * @return prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public PrplinterAutoClaimDetailDto findByPrimaryKey(String id,String registNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        //声明DTO
        PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prplinterAutoClaimDetailDto = blPrplinterAutoClaimDetailAction.findByPrimaryKey(dbManager,id, registNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplinterAutoClaimDetailDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplinterAutoClaimDetailAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prplinterAutoClaimDetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplinterAutoClaimDetailAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
    
    /**
     * 按SQL更新一条数据(主键本身无法变更)
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void updateBySQL(String sql)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplinterAutoClaimDetailAction.updateBySQL(dbManager,sql);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
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
        BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplinterAutoClaimDetailAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
