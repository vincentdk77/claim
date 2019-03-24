package com.sinosoft.communication.bl.action;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.communication.dto.custom.PrplCommunicatOpinionDto;
import com.sinosoft.communication.resource.dtofactory.custom.DBPrplCommunicatOpinion;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrplCommunicatOpinion沟通子表（沟通意见）的业务逻辑对象类<br>
 * 创建于 2013-02-21
 * 
 */
public class BLPrplCommunicatOpinionActionBase {
	private static Log logger = LogFactory.getLog(BLPrplCommunicatOpinionActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplCommunicatOpinionActionBase(){
    }
    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplCommunicatOpinionDto prplCommunicatOpinionDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplCommunicatOpinionDto prplCommunicatOpinionDto) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        //插入记录
        dbPrplCommunicatOpinion.insert(prplCommunicatOpinionDto);
    }

    /**
     * 按沟通号码删除一条数据
     * @param dbManager DB管理器
     * @param communicationNo 沟通号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String communicationNo) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        //删除记录
        dbPrplCommunicatOpinion.delete(communicationNo);
        
    }
    
    /**
     * 按沟通号码和沟通人号码删除一条数据
     * @param dbManager DB管理器
     * @param communicationNo 沟通号码
     * @param opinionNo 沟通信息号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String communicationNo,String opinionNo) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        //删除记录
        dbPrplCommunicatOpinion.delete(communicationNo,opinionNo);
        
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplCommunicatOpinionDto prplCommunicatOpinionDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplCommunicatOpinionDto prplCommunicatOpinionDto) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        //更新记录
        dbPrplCommunicatOpinion.update(prplCommunicatOpinionDto);
    }

    /**
     * 按沟通号码查找一组数据
     * @param dbManager DB管理器
     * @param communicationNo 沟通号码
     * @return Collection Collection
     * @throws Exception
     */
    public Collection findByCommunicationNo(DBManager dbManager,String communicationNo) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        //声明集合
        Collection collection = new ArrayList();
        //查询数据,赋值给DTO
        collection = dbPrplCommunicatOpinion.findByCommunicationNo(communicationNo);
        return collection;
    }
    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param communicationNo 沟通号码
     * @param opinionNo 沟通意见号码
     * @return prplCommunicatOpinionDto prplCommunicatOpinionDto
     * @throws Exception
     */
    public PrplCommunicatOpinionDto findByPrimaryKey(DBManager dbManager,String communicationNo,String opinionNo) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        //声明DTO
        PrplCommunicatOpinionDto prplCommunicatOpinionDto = null;
        //查询数据,赋值给DTO
        prplCommunicatOpinionDto = dbPrplCommunicatOpinion.findByPrimaryKey(communicationNo, opinionNo);
        return prplCommunicatOpinionDto;
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
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplCommunicatOpinion.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplCommunicatOpinion.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplCommunicatOpinionDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplCommunicatOpinion.findByConditions(conditions);
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
        DBPrplCommunicatOpinion dbPrplCommunicatOpinion = new DBPrplCommunicatOpinion(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplCommunicatOpinion.getCount(conditions);
        return count;
    }
}
