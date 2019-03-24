package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDexchDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDexch;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdexch的业务逻辑对象类<br>
 * 创建于 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDexchActionBase{
    private static Log log = LogFactory.getLog(BLPrpDexchActionBase.class.getName());
    protected int count; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDexchActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDexchDto prpDexchDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDexchDto prpDexchDto) throws Exception{
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);
        //插入记录
        dbPrpDexch.insert(prpDexchDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param exchDate exchdate
     * @param baseCurrency basecurrency
     * @param exchCurrency exchcurrency
     * @throws Exception
     */
    public void delete(DBManager dbManager,DateTime exchDate,String baseCurrency,String exchCurrency) throws Exception{
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);
        //删除记录
        dbPrpDexch.delete(exchDate, baseCurrency, exchCurrency);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);
        //按条件删除记录
        dbPrpDexch.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDexchDto prpDexchDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDexchDto prpDexchDto) throws Exception{
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);
        //更新记录
        dbPrpDexch.update(prpDexchDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param exchDate exchdate
     * @param baseCurrency basecurrency
     * @param exchCurrency exchcurrency
     * @return prpDexchDto prpDexchDto
     * @throws Exception
     */
    public PrpDexchDto findByPrimaryKey(DBManager dbManager,DateTime exchDate,String baseCurrency,String exchCurrency) throws Exception{
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);
        //声明DTO
        PrpDexchDto prpDexchDto = null;
        //查询数据,赋值给DTO
        prpDexchDto = dbPrpDexch.findByPrimaryKey(exchDate, baseCurrency, exchCurrency);
        return prpDexchDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDexchDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDexch.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDexch.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDexchDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getCount(){
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDexch dbPrpDexch = new DBPrpDexch(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDexch.getCount(conditions);
        return count;
    }
}
