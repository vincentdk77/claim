package com.sinosoft.communication.bl.action;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.communication.dto.custom.PrplCommunicationDto;
import com.sinosoft.communication.resource.dtofactory.custom.DBPrplCommunication;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrplCommunicationActionBase {
	
	public BLPrplCommunicationActionBase(){
		
	}
	/**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplCommunicationDto prplCommunicationDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplCommunicationDto prplCommunicationDto) throws Exception{
        DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
        //插入记录
        dbPrplCommunication.insert(prplCommunicationDto);
    }

    /**
     * 按沟通号码删除一条数据
     * @param dbManager DB管理器
     * @param communicationNo 沟通号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String communicationNo) throws Exception{
        DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
        //删除记录
        dbPrplCommunication.delete(communicationNo);
        
    }
	
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
        Collection collection = new ArrayList();

        //if(conditions.trim().length()==0){
         //   conditions = "1=1";
       // }

        int count = dbPrplCommunication.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplCommunication.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
        Collection collection = new ArrayList();
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        //int count = dbPrplCommunication.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplCommunication.findByConditions(conditions);
        return collection;
    }
    /**
     * 按条件查询一条沟通数据
     * @param conditions 查询沟通号码
     * @return PrplCommunicationDto 沟通信息
     * @throws Exception
     */
    public PrplCommunicationDto findByCommunicationNo(DBManager dbManager,String communicationNo) throws Exception{
    	DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
    	PrplCommunicationDto prplCommunicationDto = null;
    	prplCommunicationDto = dbPrplCommunication.findByPrimaryKey(communicationNo);
    	return prplCommunicationDto;
    }
    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplCommunicatPersonDto prplCommunicatPersonDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplCommunicationDto prplCommunicationDto) throws Exception{
    	DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
        //更新记录
    	dbPrplCommunication.update(prplCommunicationDto);
    }
    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions)
        throws Exception{
        DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplCommunication.getCount(conditions);
        return count;
    }
}
