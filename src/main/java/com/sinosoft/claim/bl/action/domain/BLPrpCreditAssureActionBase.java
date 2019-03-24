package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCreditAssureDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCreditAssure;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpCreditAssure风险预警确认函号表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCreditAssureActionBase{
    private static Log log = LogFactory.getLog(BLPrpCreditAssureActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCreditAssureActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCreditAssureDto prpCreditAssureDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCreditAssureDto prpCreditAssureDto) throws Exception{
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);
        //插入记录
        dbPrpCreditAssure.insert(prpCreditAssureDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param confirmNo 风险预警确认函号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String confirmNo) throws Exception{
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);
        //删除记录
        dbPrpCreditAssure.delete(confirmNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);
        //按条件删除记录
        dbPrpCreditAssure.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCreditAssureDto prpCreditAssureDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCreditAssureDto prpCreditAssureDto) throws Exception{
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);
        //更新记录
        dbPrpCreditAssure.update(prpCreditAssureDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param confirmNo 风险预警确认函号
     * @return prpCreditAssureDto prpCreditAssureDto
     * @throws Exception
     */
    public PrpCreditAssureDto findByPrimaryKey(DBManager dbManager,String confirmNo) throws Exception{
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);
        //声明DTO
        PrpCreditAssureDto prpCreditAssureDto = null;
        //查询数据,赋值给DTO
        prpCreditAssureDto = dbPrpCreditAssure.findByPrimaryKey(confirmNo);
        return prpCreditAssureDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCreditAssureDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCreditAssure.getCount(conditions);
        collection = dbPrpCreditAssure.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpCreditAssure dbPrpCreditAssure = new DBPrpCreditAssure(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCreditAssure.getCount(conditions);
        return count;
    }
}
