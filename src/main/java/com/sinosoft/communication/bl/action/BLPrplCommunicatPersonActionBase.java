package com.sinosoft.communication.bl.action;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.communication.dto.custom.PrplCommunicatPersonDto;
import com.sinosoft.communication.resource.dtofactory.custom.DBPrplCommunicatPerson;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrplCommunicatPerson沟通子表（沟通人员）的业务逻辑对象类<br>
 * 创建于 2013-02-21
 * 
 */
public class BLPrplCommunicatPersonActionBase {
	private static Log logger = LogFactory.getLog(BLPrplCommunicatPersonActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplCommunicatPersonActionBase(){
    }
	
    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplCommunicatPersonDto prplCommunicatPersonDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplCommunicatPersonDto prplCommunicatPersonDto) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        //插入记录
        dbPrplCommunicatPerson.insert(prplCommunicatPersonDto);
    }

    /**
     * 按沟通号码删除一组数据
     * @param dbManager DB管理器
     * @param communicationNo 沟通号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String communicationNo) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        //删除记录
        dbPrplCommunicatPerson.delete(communicationNo);
        
    }
    /**
     * 按沟通号码和沟通人号码删除一条数据
     * @param dbManager DB管理器
     * @param communicationNo 沟通号码
     * @param personNo 沟通人号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String communicationNo,String personNo) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        //删除记录
        dbPrplCommunicatPerson.delete(communicationNo,personNo);
        
    }
    /**
     * 按主键删除一条沟通人信息
     * @param dbManager DB管理器
     * @param communicationNo 沟通号码
     * @param personNo 沟通人号码
     * @throws Exception
     */
    public void removePersonByKey(DBManager dbManager,String communicationNo,String personNo) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        dbPrplCommunicatPerson.delete(communicationNo, personNo);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplCommunicatPersonDto prplCommunicatPersonDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplCommunicatPersonDto prplCommunicatPersonDto) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        //更新记录
        dbPrplCommunicatPerson.update(prplCommunicatPersonDto);
    }

    /**
     * 按沟通号码查找一组数据
     * @param dbManager DB管理器
     * @param communicationNo 沟通号码
     * @return Collection Collection
     * @throws Exception
     */
    public Collection findByCommunicationNo(DBManager dbManager,String communicationNo) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        //声明集合
        Collection collection = new ArrayList();
        //查询数据,赋值给DTO
        collection = dbPrplCommunicatPerson.findByCommunicationNo(communicationNo);
        return collection;
    }
    /**
     * 按沟通号码和沟通人号码(主键)查找一条数据
     * @param dbManager DB管理器
     * @param communicationNo 沟通号码
     * @param personNo 沟通人号码
     * @return Collection Collection
     * @throws Exception
     */
    public PrplCommunicatPersonDto findByPersonNo(DBManager dbManager,String communicationNo,String personNo) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        //声明DTO
        PrplCommunicatPersonDto prplCommunicatPersonDto = null;
        //查询数据,赋值给DTO
        prplCommunicatPersonDto = dbPrplCommunicatPerson.findByPrimaryKey(communicationNo, personNo);
        return prplCommunicatPersonDto;
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
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplCommunicatPerson.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplCommunicatPerson.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplCommunicatPersonDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplCommunicatPerson.findByConditions(conditions);
        return collection;
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
        DBPrplCommunicatPerson dbPrplCommunicatPerson = new DBPrplCommunicatPerson(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplCommunicatPerson.getCount(conditions);
        return count;
    }
}
