package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpXPformDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpXPform;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpxpform批改数据字典表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpXPformActionBase{
    private static Log log = LogFactory.getLog(BLPrpXPformActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpXPformActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpXPformDto prpXPformDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpXPformDto prpXPformDto) throws Exception{
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);
        //插入记录
        dbPrpXPform.insert(prpXPformDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param endorType 批改类型
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String endorType) throws Exception{
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);
        //删除记录
        dbPrpXPform.delete(riskCode, endorType);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);
        //按条件删除记录
        dbPrpXPform.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpXPformDto prpXPformDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpXPformDto prpXPformDto) throws Exception{
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);
        //更新记录
        dbPrpXPform.update(prpXPformDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param endorType 批改类型
     * @return prpXPformDto prpXPformDto
     * @throws Exception
     */
    public PrpXPformDto findByPrimaryKey(DBManager dbManager,String riskCode,String endorType) throws Exception{
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);
        //声明DTO
        PrpXPformDto prpXPformDto = null;
        //查询数据,赋值给DTO
        prpXPformDto = dbPrpXPform.findByPrimaryKey(riskCode, endorType);
        return prpXPformDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpXPformDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpXPform.getCount(conditions);
        collection = dbPrpXPform.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpXPform dbPrpXPform = new DBPrpXPform(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpXPform.getCount(conditions);
        return count;
    }
}
