package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpreChargeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpreCharge;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLpreChargeActionBase {
	private static Log logger = LogFactory.getLog(BLPrpLpreChargeActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpreChargeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param PrpLpreChargeDto PrpLpreChargeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpreChargeDto prpLpreChargeDto) throws Exception{
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        //插入记录
        dbPrpLpreCharge.insert(prpLpreChargeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String preCompensateNo,int serialNo) throws Exception{
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        //删除记录
        dbPrpLpreCharge.delete(preCompensateNo,serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        //按条件删除记录
        dbPrpLpreCharge.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param PrpLpreChargeDto PrpLpreChargeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpreChargeDto PrpLpreChargeDto) throws Exception{
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        //更新记录
        dbPrpLpreCharge.update(PrpLpreChargeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param serialNo 序号
     * @return PrpLpreChargeDto PrpLpreChargeDto
     * @throws Exception
     */
    public PrpLpreChargeDto findByPrimaryKey(DBManager dbManager,String preCompensateNo,int serialNo) throws Exception{
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        //声明DTO
        PrpLpreChargeDto PrpLpreChargeDto = null;
        //查询数据,赋值给DTO
        PrpLpreChargeDto = dbPrpLpreCharge.findByPrimaryKey(preCompensateNo,serialNo);
        return PrpLpreChargeDto;
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
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpreCharge.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpreCharge.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含PrpLpreChargeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpreCharge.findByConditions(conditions);
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
        DBPrpLpreCharge dbPrpLpreCharge = new DBPrpLpreCharge(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpreCharge.getCount(conditions);
        return count;
    }
}
