package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyCollect;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertifyCollect-单证收集(修改)的业务逻辑对象类<br>
 * 创建于 2005-03-23 16:36:58.625<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcertifyCollectActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyCollectActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcertifyCollectActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcertifyCollectDto prpLcertifyCollectDto) throws Exception{
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        //插入记录
        dbPrpLcertifyCollect.insert(prpLcertifyCollectDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param businessNo 业务号码
     * @param lossItemCode 标的代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessNo,String lossItemCode) throws Exception{
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        //删除记录
        dbPrpLcertifyCollect.delete(businessNo, lossItemCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        //按条件删除记录
        dbPrpLcertifyCollect.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcertifyCollectDto prpLcertifyCollectDto) throws Exception{
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        //更新记录
        dbPrpLcertifyCollect.update(prpLcertifyCollectDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param businessNo 业务号码
     * @param lossItemCode 标的代码
     * @return prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public PrpLcertifyCollectDto findByPrimaryKey(DBManager dbManager,String businessNo,String lossItemCode) throws Exception{
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        //声明DTO
        PrpLcertifyCollectDto prpLcertifyCollectDto = null;
        //查询数据,赋值给DTO
        prpLcertifyCollectDto = dbPrpLcertifyCollect.findByPrimaryKey(businessNo, lossItemCode);
        return prpLcertifyCollectDto;
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
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertifyCollect.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcertifyCollect.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcertifyCollectDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcertifyCollect.findByConditions(conditions);
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
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertifyCollect.getCount(conditions);
        return count;
    }
}
