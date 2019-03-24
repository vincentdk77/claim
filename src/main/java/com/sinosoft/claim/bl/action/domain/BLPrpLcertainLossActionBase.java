package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertainLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertainLoss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertainLoss定损主表的业务逻辑对象类<br>
 * 创建于 2004-07-15 14:09:36.135<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcertainLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertainLossActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcertainLossActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcertainLossDto prpLcertainLossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcertainLossDto prpLcertainLossDto) throws Exception{
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
        //插入记录
        dbPrpLcertainLoss.insert(prpLcertainLossDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param lossItemCode 标的序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String lossItemCode) throws Exception{
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
        //删除记录
        dbPrpLcertainLoss.delete(registNo, lossItemCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
        //按条件删除记录
        dbPrpLcertainLoss.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcertainLossDto prpLcertainLossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcertainLossDto prpLcertainLossDto) throws Exception{
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
        //更新记录
        dbPrpLcertainLoss.update(prpLcertainLossDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param lossItemCode 标的序号
     * @return prpLcertainLossDto prpLcertainLossDto
     * @throws Exception
     */
    public PrpLcertainLossDto findByPrimaryKey(DBManager dbManager,String registNo,String lossItemCode) throws Exception{
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
        //声明DTO
        PrpLcertainLossDto prpLcertainLossDto = null;
        //查询数据,赋值给DTO
        prpLcertainLossDto = dbPrpLcertainLoss.findByPrimaryKey(registNo, lossItemCode);
        return prpLcertainLossDto;
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
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertainLoss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcertainLoss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcertainLossDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0).getResult();
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
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertainLoss.getCount(conditions);
        return count;
    }
}
