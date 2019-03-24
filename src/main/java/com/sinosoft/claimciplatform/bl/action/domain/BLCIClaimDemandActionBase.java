package com.sinosoft.claimciplatform.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.claimciplatform.resource.dtofactory.domain.DBCIClaimDemand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是理赔平台查询表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimDemandActionBase{
    private static Log logger = LogFactory.getLog(BLCIClaimDemandActionBase.class);

    /**
     * 构造函数
     */
    public BLCIClaimDemandActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param cIClaimDemandDto cIClaimDemandDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CIClaimDemandDto cIClaimDemandDto)
            throws Exception{
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        //插入记录
        dbCIClaimDemand.insert(cIClaimDemandDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimCode 理赔编码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimCode)
            throws Exception{
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        //删除记录
        dbCIClaimDemand.delete(claimCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        //按条件删除记录
        dbCIClaimDemand.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param cIClaimDemandDto cIClaimDemandDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CIClaimDemandDto cIClaimDemandDto)
            throws Exception{
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        //更新记录
        dbCIClaimDemand.update(cIClaimDemandDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimCode 理赔编码
     * @return cIClaimDemandDto cIClaimDemandDto
     * @throws Exception
     */
    public CIClaimDemandDto findByPrimaryKey(DBManager dbManager,String claimCode)
            throws Exception{
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        //声明DTO
        CIClaimDemandDto cIClaimDemandDto = null;
        //查询数据,赋值给DTO
        cIClaimDemandDto = dbCIClaimDemand.findByPrimaryKey(claimCode);
        return cIClaimDemandDto;
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
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimDemand.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCIClaimDemand.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含cIClaimDemandDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCIClaimDemand.findByConditions(conditions);
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
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimDemand.getCount(conditions);
        return count;
    }
}
