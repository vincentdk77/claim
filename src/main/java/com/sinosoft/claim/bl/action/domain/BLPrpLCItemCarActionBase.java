package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLCItemCarDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLCItemCar;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLCItemCar-代赔保单车辆附表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLCItemCarActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLCItemCarActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLCItemCarActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLCItemCarDto prpLCItemCarDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLCItemCarDto prpLCItemCarDto) throws Exception{
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        //插入记录
        dbPrpLCItemCar.insert(prpLCItemCarDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param policyNo 保单号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String policyNo) throws Exception{
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        //删除记录
        dbPrpLCItemCar.delete(registNo, policyNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        //按条件删除记录
        dbPrpLCItemCar.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLCItemCarDto prpLCItemCarDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLCItemCarDto prpLCItemCarDto) throws Exception{
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        //更新记录
        dbPrpLCItemCar.update(prpLCItemCarDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param policyNo 保单号码
     * @return prpLCItemCarDto prpLCItemCarDto
     * @throws Exception
     */
    public PrpLCItemCarDto findByPrimaryKey(DBManager dbManager,String registNo,String policyNo) throws Exception{
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        //声明DTO
        PrpLCItemCarDto prpLCItemCarDto = null;
        //查询数据,赋值给DTO
        prpLCItemCarDto = dbPrpLCItemCar.findByPrimaryKey(registNo, policyNo);
        return prpLCItemCarDto;
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
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLCItemCar.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLCItemCar.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLCItemCarDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLCItemCar.findByConditions(conditions);
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
        DBPrpLCItemCar dbPrpLCItemCar = new DBPrpLCItemCar(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLCItemCar.getCount(conditions);
        return count;
    }
}
