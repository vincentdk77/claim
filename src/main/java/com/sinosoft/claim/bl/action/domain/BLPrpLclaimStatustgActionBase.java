package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatustg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimStatus-理赔节点状态表(新增)的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimStatustgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimStatustgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimStatustgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLclaimStatustgDto prpLclaimStatustgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimStatusDto prpLclaimStatustgDto) throws Exception{
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        //插入记录
        dbPrpLclaimStatustg.insert(prpLclaimStatustgDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param businessNo 业务号
     * @param nodeType 节点种类
     * @param serialNo 序列号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessNo,String nodeType,int serialNo) throws Exception{
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        //删除记录
        dbPrpLclaimStatustg.delete(businessNo, nodeType, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        //按条件删除记录
        dbPrpLclaimStatustg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLclaimStatustgDto prpLclaimStatustgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimStatusDto prpLclaimStatustgDto) throws Exception{
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        //更新记录
        dbPrpLclaimStatustg.update(prpLclaimStatustgDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param businessNo 业务号
     * @param nodeType 节点种类
     * @param serialNo 序列号码
     * @return prpLclaimStatustgDto prpLclaimStatustgDto
     * @throws Exception
     */
    public PrpLclaimStatusDto findByPrimaryKey(DBManager dbManager,String businessNo,String nodeType,int serialNo) throws Exception{
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        //声明DTO
        PrpLclaimStatusDto prpLclaimStatustgDto = null;
        //查询数据,赋值给DTO
        prpLclaimStatustgDto = dbPrpLclaimStatustg.findByPrimaryKey(businessNo, nodeType, serialNo);
        return prpLclaimStatustgDto;
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
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimStatustg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimStatustg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLclaimStatustgDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimStatustg.findByConditions(conditions);
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
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimStatustg.getCount(conditions);
        return count;
    }
}
