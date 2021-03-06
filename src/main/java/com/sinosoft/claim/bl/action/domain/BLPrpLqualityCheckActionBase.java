package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLqualityCheckDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLqualityCheck;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLqualityCheck-质量评审内容表的业务逻辑对象类<br>
 * 创建于 2005-04-14 15:56:47.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLqualityCheckActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLqualityCheckActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLqualityCheckActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLqualityCheckDto prpLqualityCheckDto) throws Exception{
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        //插入记录
        dbPrpLqualityCheck.insert(prpLqualityCheckDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @param qualityCheckType 业务类型
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String qualityCheckType,int serialNo) throws Exception{
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        //删除记录
        dbPrpLqualityCheck.delete(registNo, qualityCheckType, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        //按条件删除记录
        dbPrpLqualityCheck.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLqualityCheckDto prpLqualityCheckDto) throws Exception{
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        //更新记录
        dbPrpLqualityCheck.update(prpLqualityCheckDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @param qualityCheckType 业务类型
     * @param serialNo 序号
     * @return prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public PrpLqualityCheckDto findByPrimaryKey(DBManager dbManager,String registNo,String qualityCheckType,int serialNo) throws Exception{
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        //声明DTO
        PrpLqualityCheckDto prpLqualityCheckDto = null;
        //查询数据,赋值给DTO
        prpLqualityCheckDto = dbPrpLqualityCheck.findByPrimaryKey(registNo, qualityCheckType, serialNo);
        return prpLqualityCheckDto;
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
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLqualityCheck.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLqualityCheck.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLqualityCheckDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLqualityCheck.findByConditions(conditions);
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
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLqualityCheck.getCount(conditions);
        return count;
    }
}
