package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheckLoss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcheckLoss-查勘事故估损金额表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.125<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckLossActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcheckLossActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcheckLossDto prpLcheckLossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcheckLossDto prpLcheckLossDto) throws Exception{
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        //插入记录
        dbPrpLcheckLoss.insert(prpLcheckLossDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 出险登记号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        //删除记录
        dbPrpLcheckLoss.delete(registNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        //按条件删除记录
        dbPrpLcheckLoss.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcheckLossDto prpLcheckLossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcheckLossDto prpLcheckLossDto) throws Exception{
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        //更新记录
        dbPrpLcheckLoss.update(prpLcheckLossDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 出险登记号
     * @param serialNo 序号
     * @return prpLcheckLossDto prpLcheckLossDto
     * @throws Exception
     */
    public PrpLcheckLossDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        //声明DTO
        PrpLcheckLossDto prpLcheckLossDto = null;
        //查询数据,赋值给DTO
        prpLcheckLossDto = dbPrpLcheckLoss.findByPrimaryKey(registNo, serialNo);
        return prpLcheckLossDto;
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
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckLoss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcheckLoss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcheckLossDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcheckLoss.findByConditions(conditions);
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
        DBPrpLcheckLoss dbPrpLcheckLoss = new DBPrpLcheckLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckLoss.getCount(conditions);
        return count;
    }
}
