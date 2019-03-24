package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCplanDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCplan;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcplan收费计划表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCplanActionBase{
    private static Log log = LogFactory.getLog(BLPrpCplanActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCplanActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCplanDto prpCplanDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCplanDto prpCplanDto) throws Exception{
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);
        //插入记录
        dbPrpCplan.insert(prpCplanDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 交费次数序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);
        //删除记录
        dbPrpCplan.delete(policyNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);
        //按条件删除记录
        dbPrpCplan.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCplanDto prpCplanDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCplanDto prpCplanDto) throws Exception{
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);
        //更新记录
        dbPrpCplan.update(prpCplanDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 交费次数序号
     * @return prpCplanDto prpCplanDto
     * @throws Exception
     */
    public PrpCplanDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);
        //声明DTO
        PrpCplanDto prpCplanDto = null;
        //查询数据,赋值给DTO
        prpCplanDto = dbPrpCplan.findByPrimaryKey(policyNo, serialNo);
        return prpCplanDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCplanDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCplan.getCount(conditions);
        collection = dbPrpCplan.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCplan dbPrpCplan = new DBPrpCplan(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCplan.getCount(conditions);
        return count;
    }
}
