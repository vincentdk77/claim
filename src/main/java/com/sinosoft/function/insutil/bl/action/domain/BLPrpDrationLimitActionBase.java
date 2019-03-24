package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrationLimitDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDrationLimit;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdrationlimit的业务逻辑对象类<br>
 * 创建于 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrationLimitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrationLimitActionBase.class.getName());
    protected int count; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDrationLimitActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDrationLimitDto prpDrationLimitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDrationLimitDto prpDrationLimitDto) throws Exception{
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);
        //插入记录
        dbPrpDrationLimit.insert(prpDrationLimitDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode riskcode
     * @param limitCode limitcode
     * @param rationType rationtype
     * @param kindCode kindcode
     * @param itemCode itemcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String limitCode,String rationType,String kindCode,String itemCode) throws Exception{
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);
        //删除记录
        dbPrpDrationLimit.delete(riskCode, limitCode, rationType, kindCode, itemCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);
        //按条件删除记录
        dbPrpDrationLimit.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDrationLimitDto prpDrationLimitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDrationLimitDto prpDrationLimitDto) throws Exception{
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);
        //更新记录
        dbPrpDrationLimit.update(prpDrationLimitDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode riskcode
     * @param limitCode limitcode
     * @param rationType rationtype
     * @param kindCode kindcode
     * @param itemCode itemcode
     * @return prpDrationLimitDto prpDrationLimitDto
     * @throws Exception
     */
    public PrpDrationLimitDto findByPrimaryKey(DBManager dbManager,String riskCode,String limitCode,String rationType,String kindCode,String itemCode) throws Exception{
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);
        //声明DTO
        PrpDrationLimitDto prpDrationLimitDto = null;
        //查询数据,赋值给DTO
        prpDrationLimitDto = dbPrpDrationLimit.findByPrimaryKey(riskCode, limitCode, rationType, kindCode, itemCode);
        return prpDrationLimitDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDrationLimitDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDrationLimit.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDrationLimit.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDrationLimitDto的集合
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
        DBPrpDrationLimit dbPrpDrationLimit = new DBPrpDrationLimit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrationLimit.getCount(conditions);
        return count;
    }
}
