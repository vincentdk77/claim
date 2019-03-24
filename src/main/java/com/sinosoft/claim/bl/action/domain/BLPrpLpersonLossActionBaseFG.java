package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonLossFG;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpersonLoss-人员赔付信息表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.046<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpersonLossActionBaseFG{
    private static Log logger = LogFactory.getLog(BLPrpLpersonLossActionBaseFG.class);

    /**
     * 构造函数
     */
    public BLPrpLpersonLossActionBaseFG(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLpersonLossDto prpLpersonLossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpersonLossDto prpLpersonLossDto) throws Exception{
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);
        //插入记录
        dbPrpLpersonLoss.insert(prpLpersonLossDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param serialNo 赔付标的序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);
        //删除记录
        dbPrpLpersonLoss.delete(compensateNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);
        //按条件删除记录
        dbPrpLpersonLoss.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLpersonLossDto prpLpersonLossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpersonLossDto prpLpersonLossDto) throws Exception{
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);
        //更新记录
        dbPrpLpersonLoss.update(prpLpersonLossDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param serialNo 赔付标的序号
     * @return prpLpersonLossDto prpLpersonLossDto
     * @throws Exception
     */
    public PrpLpersonLossDto findByPrimaryKey(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);
        //声明DTO
        PrpLpersonLossDto prpLpersonLossDto = null;
        //查询数据,赋值给DTO
        prpLpersonLossDto = dbPrpLpersonLoss.findByPrimaryKey(compensateNo, serialNo);
        return prpLpersonLossDto;
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
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpersonLoss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpersonLoss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLpersonLossDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpersonLossFG dbPrpLpersonLoss = new DBPrpLpersonLossFG(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpersonLoss.findByConditions(conditions);
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
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpersonLoss.getCount(conditions);
        return count;
    }
}
