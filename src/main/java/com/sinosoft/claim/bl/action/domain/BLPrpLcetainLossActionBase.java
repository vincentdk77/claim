package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcetainLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcetainLoss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcetainLoss的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.343<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcetainLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcetainLossActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcetainLossActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcetainLossDto prpLcetainLossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcetainLossDto prpLcetainLossDto) throws Exception{
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        //插入记录
        dbPrpLcetainLoss.insert(prpLcetainLossDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @param itemNo 标的序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int itemNo) throws Exception{
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        //删除记录
        dbPrpLcetainLoss.delete(claimNo, itemNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        //按条件删除记录
        dbPrpLcetainLoss.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcetainLossDto prpLcetainLossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcetainLossDto prpLcetainLossDto) throws Exception{
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        //更新记录
        dbPrpLcetainLoss.update(prpLcetainLossDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @param itemNo 标的序号
     * @return prpLcetainLossDto prpLcetainLossDto
     * @throws Exception
     */
    public PrpLcetainLossDto findByPrimaryKey(DBManager dbManager,String claimNo,int itemNo) throws Exception{
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        //声明DTO
        PrpLcetainLossDto prpLcetainLossDto = null;
        //查询数据,赋值给DTO
        prpLcetainLossDto = dbPrpLcetainLoss.findByPrimaryKey(claimNo, itemNo);
        return prpLcetainLossDto;
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
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcetainLoss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcetainLoss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcetainLossDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcetainLoss.findByConditions(conditions);
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
        DBPrpLcetainLoss dbPrpLcetainLoss = new DBPrpLcetainLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcetainLoss.getCount(conditions);
        return count;
    }
}
