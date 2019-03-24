package com.sinosoft.communication.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.communication.bl.action.BLPrplCommunicatOpinionAction;
import com.sinosoft.communication.bl.action.BLPrplCommunicatPersonAction;
import com.sinosoft.communication.bl.action.BLPrplCommunicationAction;
import com.sinosoft.communication.dto.custom.PrplCommunicatPersonDto;
import com.sinosoft.communication.dto.custom.PrplCommunicationDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 这是PrplCommunication沟通主表的业务对象Facade类<br>
 * 创建于 2013-02-20
 * 
 */
public class BLPrplCommunicationFacadeBase {
	private static Log logger = LogFactory.getLog(BLPrplCommunicationFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrplCommunicationFacadeBase(){
    }
    
    /**
     * 插入一条数据
     * @param prplCommunicationDto prplCommunicationDto
     * @throws Exception
     */
    public void insert(PrplCommunicationDto prplCommunicationDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrplCommunicationAction.insert(dbManager,prplCommunicationDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按沟通号码删除一条数据
     * @param comunicationNo 沟通号码
     * @throws Exception
     */
    public void delete(String comunicationNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplCommunicationAction.delete(dbManager,comunicationNo);
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
     * @param prplCommunicationDto prplCommunicationDto
     * @throws Exception
     */
    public void update(PrplCommunicationDto prplCommunicationDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplCommunicationAction.update(dbManager,prplCommunicationDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
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
        conditions = " 1=1 " + conditions;
        DBManager dbManager = new DBManager();
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplCommunicationAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    /**
     * 按条件查询一条沟通数据
     * @param conditions 查询沟通号码
     * @return PrplCommunicationDto 沟通信息
     * @throws Exception
     */
	public PrplCommunicationDto findByComminicationNo(String communicationNo) throws Exception{
		DBManager dbManager = new DBManager();
		PrplCommunicationDto prplCommunicationDto = null;
		BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            prplCommunicationDto = blPrplCommunicationAction.findByCommunicationNo(dbManager,communicationNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplCommunicationDto;
	}
	
	/**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        //conditions = " 1=1 " + conditions;
        if(conditions.trim().length()==0){
        	conditions = "1=1";
        }
        Collection collection = new ArrayList();
        DBManager dbManager = new DBManager();
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplCommunicationAction.findByConditions(dbManager,conditions);
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
        BLPrplCommunicationAction blPrplCommunicationAction = new BLPrplCommunicationAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplCommunicationAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
