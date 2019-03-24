package com.sinosoft.communication.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.communication.bl.action.BLPrplCommunicatOpinionAction;
import com.sinosoft.communication.dto.custom.PrplCommunicatOpinionDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrplCommunicatOpinion沟通子表（沟通意见）的业务对象Facade类<br>
 * 创建于 2013-02-22
 * 
 */
public class BLPrplCommunicatOpinionFacadeBase {
	private static Log logger = LogFactory.getLog(BLPrplCommunicatOpinionFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrplCommunicatOpinionFacadeBase(){
    }
    
    /**
     * 插入一条数据
     * @param prplCommunicatOpinionDto prplCommunicatOpinionDto
     * @throws Exception
     */
    public void insert(PrplCommunicatOpinionDto prplCommunicatOpinionDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
            //dbManager.open("claimTempDataSource");
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrplCommunicatOpinionAction.insert(dbManager,prplCommunicatOpinionDto);
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
     * @param endorseNo 批单号码
     * @throws Exception
     */
    public void delete(String comunicationNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplCommunicatOpinionAction.delete(dbManager,comunicationNo);
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
     * @param endorseNo 批单号码
     * @throws Exception
     */
    public void delete(String comunicationNo,String personNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplCommunicatOpinionAction.delete(dbManager,comunicationNo,personNo);
            
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
     * @param endorseNo 批单号码
     * @throws Exception
     */
    public void delete(String comunicationNo,String personNo,String opinionNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplCommunicatOpinionAction.delete(dbManager,comunicationNo,opinionNo);
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
     * @param prplCommunicatOpinionDto prplCommunicatOpinionDto
     * @throws Exception
     */
    public void update(PrplCommunicatOpinionDto prplCommunicatOpinionDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplCommunicatOpinionAction.update(dbManager,prplCommunicatOpinionDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按沟通号码查找一组数据
     * @param communicaitonNo 沟通号码
     * @return Collection Collection
     * @throws Exception
     */
    public Collection findByCommunicationNo(String communicationNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        //声明DTO
        PrplCommunicatOpinionDto prplCommunicatOpinionDto = null;
        Collection collection = new ArrayList();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
        	collection = blPrplCommunicatOpinionAction.findByCommunicationNo(dbManager, communicationNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
    /**
     * 按主键查找一条数据
     * @param communicationNo 沟通号码
     * @param personNo 沟通人号码
     * @param personNo 沟通意见号码
     * @return prplCommunicatOpinionDto prplCommunicatOpinionDto
     * @throws Exception
     */
    public PrplCommunicatOpinionDto findByPrimaryKey(String communicationNo,String opinionNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        //声明DTO
        PrplCommunicatOpinionDto prplCommunicatOpinionDto = null;
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prplCommunicatOpinionDto = blPrplCommunicatOpinionAction.findByPrimaryKey(dbManager, communicationNo, opinionNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplCommunicatOpinionDto;
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
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplCommunicatOpinionAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prplCommunicatOpinionDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplCommunicatOpinionAction.findByConditions(dbManager,conditions);
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
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplCommunicatOpinionAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
