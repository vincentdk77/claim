package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcharge;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcharge-赔款费用信息表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:37.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLchargeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLchargeActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLchargeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLchargeDto prpLchargeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLchargeDto prpLchargeDto) throws Exception{
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        //插入记录
        dbPrpLcharge.insert(prpLchargeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        //删除记录
        dbPrpLcharge.delete(compensateNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        //按条件删除记录
        dbPrpLcharge.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLchargeDto prpLchargeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLchargeDto prpLchargeDto) throws Exception{
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        //更新记录
        dbPrpLcharge.update(prpLchargeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param serialNo 序号
     * @return prpLchargeDto prpLchargeDto
     * @throws Exception
     */
    public PrpLchargeDto findByPrimaryKey(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        //声明DTO
        PrpLchargeDto prpLchargeDto = null;
        //查询数据,赋值给DTO
        prpLchargeDto = dbPrpLcharge.findByPrimaryKey(compensateNo, serialNo);
        return prpLchargeDto;
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
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcharge.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcharge.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLchargeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcharge.findByConditions(conditions);
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
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcharge.getCount(conditions);
        return count;
    }
    
    
    public int getMaxSerialNo(DBManager dbManager,String conditions) 
    throws Exception{
    DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    int count = dbPrpLcharge.getMaxSerialNo(conditions);
    return count;
}
}
