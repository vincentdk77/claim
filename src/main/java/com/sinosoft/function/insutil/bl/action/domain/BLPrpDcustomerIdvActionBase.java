package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcustomerIdvDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDcustomerIdv;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcustomeridv的业务逻辑对象类<br>
 * 创建于 2004-4-6 16:08:19<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerIdvActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerIdvActionBase.class.getName());
    protected int count; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDcustomerIdvActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDcustomerIdvDto prpDcustomerIdvDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);
        //插入记录
        dbPrpDcustomerIdv.insert(prpDcustomerIdvDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param customerCode customercode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);
        //删除记录
        dbPrpDcustomerIdv.delete(customerCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);
        //按条件删除记录
        dbPrpDcustomerIdv.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDcustomerIdvDto prpDcustomerIdvDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);
        //更新记录
        dbPrpDcustomerIdv.update(prpDcustomerIdvDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param customerCode customercode
     * @return prpDcustomerIdvDto prpDcustomerIdvDto
     * @throws Exception
     */
    public PrpDcustomerIdvDto findByPrimaryKey(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);
        //声明DTO
        PrpDcustomerIdvDto prpDcustomerIdvDto = null;
        //查询数据,赋值给DTO
        prpDcustomerIdvDto = dbPrpDcustomerIdv.findByPrimaryKey(customerCode);
        return prpDcustomerIdvDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDcustomerIdvDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDcustomerIdv.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDcustomerIdv.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDcustomerIdvDto的集合
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
        DBPrpDcustomerIdv dbPrpDcustomerIdv = new DBPrpDcustomerIdv(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcustomerIdv.getCount(conditions);
        return count;
    }
}
