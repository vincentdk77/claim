package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.MidResultConfigDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBMidResultConfig;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是MidResultConfig结果页面配置表的业务逻辑对象类<br>
 * 创建于 2005-03-11 10:51:28.109<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLMidResultConfigActionBase{
    private static Log logger = LogFactory.getLog(BLMidResultConfigActionBase.class);

    /**
     * 构造函数
     */
    public BLMidResultConfigActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,MidResultConfigDto midResultConfigDto) throws Exception{
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        //插入记录
        dbMidResultConfig.insert(midResultConfigDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param configOwner 配置归属者
     * @param resultType 结果页面类型
     * @param itemNo 项目序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String configOwner,String resultType,int itemNo) throws Exception{
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        //删除记录
        dbMidResultConfig.delete(configOwner, resultType, itemNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        //按条件删除记录
        dbMidResultConfig.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public void update(DBManager dbManager,MidResultConfigDto midResultConfigDto) throws Exception{
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        //更新记录
        dbMidResultConfig.update(midResultConfigDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param configOwner 配置归属者
     * @param resultType 结果页面类型
     * @param itemNo 项目序号
     * @return midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public MidResultConfigDto findByPrimaryKey(DBManager dbManager,String configOwner,String resultType,int itemNo) throws Exception{
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        //声明DTO
        MidResultConfigDto midResultConfigDto = null;
        //查询数据,赋值给DTO
        midResultConfigDto = dbMidResultConfig.findByPrimaryKey(configOwner, resultType, itemNo);
        return midResultConfigDto;
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
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMidResultConfig.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbMidResultConfig.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含midResultConfigDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        collection = dbMidResultConfig.findByConditions(conditions);
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
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMidResultConfig.getCount(conditions);
        return count;
    }
}
