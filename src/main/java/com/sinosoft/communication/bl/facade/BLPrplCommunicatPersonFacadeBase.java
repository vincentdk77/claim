package com.sinosoft.communication.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.communication.bl.action.BLPrplCommunicatPersonAction;
import com.sinosoft.communication.dto.custom.PrplCommunicatPersonDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrplCommunicatPerson沟通子表（沟通人员）的业务对象Facade类<br>
 * 创建于 2013-02-21
 * 
 */
public class BLPrplCommunicatPersonFacadeBase {
	private static Log logger = LogFactory.getLog(BLPrplCommunicatPersonFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrplCommunicatPersonFacadeBase(){
    }
    /**
     * 插入一条数据
     * @param prplCommunicatPersonDto prplCommunicatPersonDto
     * @throws Exception
     */
    public void insert(PrplCommunicatPersonDto prplCommunicatPersonDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrplCommunicatPersonAction.insert(dbManager,prplCommunicatPersonDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按沟通号码删除一组数据
     * @param comunicationNo 沟通号码
     * @throws Exception
     */
    public void delete(String comunicationNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplCommunicatPersonAction.delete(dbManager,comunicationNo);
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
     * @param comunicationNo 沟通号码
     * @param personNo 沟通人号码
     * @throws Exception
     */
    public void delete(String comunicationNo,String personNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplCommunicatPersonAction.delete(dbManager,comunicationNo,personNo);
            
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
     * @param prplCommunicatPersonDto prplCommunicatPersonDto
     * @throws Exception
     */
    public void update(PrplCommunicatPersonDto prplCommunicatPersonDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplCommunicatPersonAction.update(dbManager,prplCommunicatPersonDto);
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
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        //声明DTO
        PrplCommunicatPersonDto prplCommunicatPersonDto = null;
        Collection collection = new ArrayList();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
        	collection = blPrplCommunicatPersonAction.findByCommunicationNo(dbManager, communicationNo);
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
     * @return prplCommunicatPersonDto prplCommunicatPersonDto
     * @throws Exception
     */
    public PrplCommunicatPersonDto findByPrimaryKey(String communicationNo,String personNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        //声明DTO
        PrplCommunicatPersonDto prplCommunicatPersonDto = null;
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prplCommunicatPersonDto = blPrplCommunicatPersonAction.findByPersonNo(dbManager, communicationNo, personNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplCommunicatPersonDto;
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
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplCommunicatPersonAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prplCommunicatPersonDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplCommunicatPersonAction.findByConditions(dbManager,conditions);
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
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplCommunicatPersonAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * 按沟通人主键删除一条沟通人数据
     * @param communicationNo 沟通号码
     * @param personNo 沟通人号码
     * @throws Exception
     */
	public void removePersonByKey(String communicationNo,String personNo) throws Exception{
		DBManager dbManager = new DBManager();
		BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            blPrplCommunicatPersonAction.removePersonByKey(dbManager, communicationNo, personNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
        	dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
	}
}
