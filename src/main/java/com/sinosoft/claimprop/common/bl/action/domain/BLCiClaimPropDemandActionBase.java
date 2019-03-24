package com.sinosoft.claimprop.common.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropDemandDto;
import com.sinosoft.claimprop.common.resource.dtofactory.domain.DBCiClaimPropDemand;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CiClaimPropDemand的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimPropDemandActionBase{
    private static Logger logger = Logger.getLogger(BLCiClaimPropDemandActionBase.class);

    /**
     * 构造函数
     */
    public BLCiClaimPropDemandActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CiClaimPropDemandDto ciClaimPropDemandDto)
            throws Exception{
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        //插入记录
        dbCiClaimPropDemand.insert(ciClaimPropDemandDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimCode claimCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimCode)
            throws Exception{
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        //删除记录
        dbCiClaimPropDemand.delete(claimCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        //按条件删除记录
        dbCiClaimPropDemand.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CiClaimPropDemandDto ciClaimPropDemandDto)
            throws Exception{
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        //更新记录
        dbCiClaimPropDemand.update(ciClaimPropDemandDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimCode claimCode
     * @return ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public CiClaimPropDemandDto findByPrimaryKey(DBManager dbManager,String claimCode)
            throws Exception{
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        //声明DTO
        CiClaimPropDemandDto ciClaimPropDemandDto = null;
        //查询数据,赋值给DTO
        ciClaimPropDemandDto = dbCiClaimPropDemand.findByPrimaryKey(claimCode);
        return ciClaimPropDemandDto;
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
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimPropDemand.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCiClaimPropDemand.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含ciClaimPropDemandDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCiClaimPropDemand.findByConditions(conditions);
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
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimPropDemand.getCount(conditions);
        return count;
    }
}
