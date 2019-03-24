package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdpartyStatusDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdpartyStatus;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLthirdpartyStatus-与第三方企业信息交互信息状态表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.125<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdpartyStatusActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdpartyStatusActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLthirdpartyStatusActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLthirdpartyStatusDto prpLthirdpartyStatusDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLthirdpartyStatusDto prpLthirdpartyStatusDto) throws Exception{
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        //插入记录
        dbPrpLthirdpartyStatus.insert(prpLthirdpartyStatusDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param businessNo 交互业务代码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessNo,int serialNo) throws Exception{
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        //删除记录
        dbPrpLthirdpartyStatus.delete(businessNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        //按条件删除记录
        dbPrpLthirdpartyStatus.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLthirdpartyStatusDto prpLthirdpartyStatusDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLthirdpartyStatusDto prpLthirdpartyStatusDto) throws Exception{
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        //更新记录
        dbPrpLthirdpartyStatus.update(prpLthirdpartyStatusDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param businessNo 交互业务代码
     * @param serialNo 序号
     * @return prpLthirdpartyStatusDto prpLthirdpartyStatusDto
     * @throws Exception
     */
    public PrpLthirdpartyStatusDto findByPrimaryKey(DBManager dbManager,String businessNo,int serialNo) throws Exception{
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        //声明DTO
        PrpLthirdpartyStatusDto prpLthirdpartyStatusDto = null;
        //查询数据,赋值给DTO
        prpLthirdpartyStatusDto = dbPrpLthirdpartyStatus.findByPrimaryKey(businessNo, serialNo);
        return prpLthirdpartyStatusDto;
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
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLthirdpartyStatus.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLthirdpartyStatus.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLthirdpartyStatusDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLthirdpartyStatus.findByConditions(conditions);
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
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLthirdpartyStatus.getCount(conditions);
        return count;
    }
}
