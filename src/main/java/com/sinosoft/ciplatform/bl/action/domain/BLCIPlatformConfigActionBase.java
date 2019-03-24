package com.sinosoft.ciplatform.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBCIPlatformConfig;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CIPlatformConfig的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIPlatformConfigActionBase{
    private static Logger logger = Logger.getLogger(BLCIPlatformConfigActionBase.class);

    /**
     * 构造函数
     */
    public BLCIPlatformConfigActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param cIPlatformConfigDto cIPlatformConfigDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CIPlatformConfigDto cIPlatformConfigDto)
            throws Exception{
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        //插入记录
        dbCIPlatformConfig.insert(cIPlatformConfigDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param configCode configCode
     * @param comCode comCode
     * @param riskCode riskCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String configCode,String comCode,String riskCode)
            throws Exception{
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        //删除记录
        dbCIPlatformConfig.delete(configCode, comCode, riskCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        //按条件删除记录
        dbCIPlatformConfig.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param cIPlatformConfigDto cIPlatformConfigDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CIPlatformConfigDto cIPlatformConfigDto)
            throws Exception{
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        //更新记录
        dbCIPlatformConfig.update(cIPlatformConfigDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param configCode configCode
     * @param comCode comCode
     * @param riskCode riskCode
     * @return cIPlatformConfigDto cIPlatformConfigDto
     * @throws Exception
     */
    public CIPlatformConfigDto findByPrimaryKey(DBManager dbManager,String configCode,String comCode,String riskCode)
            throws Exception{
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        //声明DTO
        CIPlatformConfigDto cIPlatformConfigDto = null;
        //查询数据,赋值给DTO
        cIPlatformConfigDto = dbCIPlatformConfig.findByPrimaryKey(configCode, comCode, riskCode);
        return cIPlatformConfigDto;
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
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIPlatformConfig.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCIPlatformConfig.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含cIPlatformConfigDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCIPlatformConfig.findByConditions(conditions);
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
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIPlatformConfig.getCount(conditions);
        return count;
    }
}
