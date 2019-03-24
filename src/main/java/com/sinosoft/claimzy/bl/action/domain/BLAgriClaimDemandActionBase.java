package com.sinosoft.claimzy.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claimzy.dto.domain.AgriClaimDemandDto;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.claimzy.resource.dtofactory.domain.DBAgriClaimDemand;
import com.sinosoft.claimzy.resource.dtofactory.domain.DBAgriClaimUploadLog;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLAgriClaimDemand的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLAgriClaimDemandActionBase {
	private static Logger logger = Logger.getLogger(BLAgriClaimDemandActionBase.class);

    /**
     * 构造函数
     */
    public BLAgriClaimDemandActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,AgriClaimDemandDto agriClaimDemandDto)
            throws Exception{
        DBAgriClaimDemand dbAgriClaimDemand = new DBAgriClaimDemand(dbManager);
        //插入记录
        dbAgriClaimDemand.insert(agriClaimDemandDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimCode 理赔编码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String batchNo)
            throws Exception{
        DBAgriClaimUploadLog DBAgriClaimUploadLog = new DBAgriClaimUploadLog(dbManager);
        //删除记录
        DBAgriClaimUploadLog.delete(batchNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBAgriClaimUploadLog DBAgriClaimUploadLog = new DBAgriClaimUploadLog(dbManager);
        //按条件删除记录
        DBAgriClaimUploadLog.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public void update(DBManager dbManager,AgriClaimDemandDto agriClaimDemandDto)
            throws Exception{
        DBAgriClaimDemand dbAgriClaimDemand= new DBAgriClaimDemand(dbManager);
        //更新记录
        dbAgriClaimDemand.update(agriClaimDemandDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimCode 理赔编码
     * @return aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public AgriClaimDemandDto findByPrimaryKey(DBManager dbManager,String batchNo)
            throws Exception{
        DBAgriClaimDemand dbAgriClaimDemand = new DBAgriClaimDemand(dbManager);
        //声明DTO
        AgriClaimDemandDto agriClaimDemandDto = null;
        //查询数据,赋值给DTO
        agriClaimDemandDto = dbAgriClaimDemand.findByPrimaryKey(batchNo);
        return agriClaimDemandDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBAgriClaimUploadLog DBAgriClaimUploadLog = new DBAgriClaimUploadLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = DBAgriClaimUploadLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = DBAgriClaimUploadLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含aGRICLAIMUPLOADLOGDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBAgriClaimUploadLog DBAgriClaimUploadLog = new DBAgriClaimUploadLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = DBAgriClaimUploadLog.findByConditions(conditions);
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
        DBAgriClaimUploadLog DBAgriClaimUploadLog = new DBAgriClaimUploadLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = DBAgriClaimUploadLog.getCount(conditions);
        return count;
    }
}
