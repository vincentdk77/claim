package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLoss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLverifyLoss-定核损主表（新增）的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.250<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLverifyLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLverifyLossActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLverifyLossActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLverifyLossDto prpLverifyLossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLverifyLossDto prpLverifyLossDto) throws Exception{
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        //插入记录
        dbPrpLverifyLoss.insert(prpLverifyLossDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @param lossItemCode 标的序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String lossItemCode) throws Exception{
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        //删除记录
        dbPrpLverifyLoss.delete(registNo, lossItemCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        //按条件删除记录
        dbPrpLverifyLoss.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLverifyLossDto prpLverifyLossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLverifyLossDto prpLverifyLossDto) throws Exception{
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        //更新记录
        dbPrpLverifyLoss.update(prpLverifyLossDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @param lossItemCode 标的序号
     * @return prpLverifyLossDto prpLverifyLossDto
     * @throws Exception
     */
    public PrpLverifyLossDto findByPrimaryKey(DBManager dbManager,String registNo,String lossItemCode) throws Exception{
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        //声明DTO
        PrpLverifyLossDto prpLverifyLossDto = null;
        //查询数据,赋值给DTO
        prpLverifyLossDto = dbPrpLverifyLoss.findByPrimaryKey(registNo, lossItemCode);
        return prpLverifyLossDto;
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
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLverifyLoss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLverifyLoss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLverifyLossDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLverifyLoss.findByConditions(conditions);
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
        DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLverifyLoss.getCount(conditions);
        return count;
    }
}
