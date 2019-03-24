package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDinvestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDinvest;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdinvest投资型险种投资信息表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDinvestActionBase{
    private static Log log = LogFactory.getLog(BLPrpDinvestActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDinvestActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDinvestDto prpDinvestDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDinvestDto prpDinvestDto) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        //插入记录
        dbPrpDinvest.insert(prpDinvestDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param investType 投资类型代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String investType) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        //删除记录
        dbPrpDinvest.delete(riskCode, investType);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        //按条件删除记录
        dbPrpDinvest.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDinvestDto prpDinvestDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDinvestDto prpDinvestDto) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        //更新记录
        dbPrpDinvest.update(prpDinvestDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param investType 投资类型代码
     * @return prpDinvestDto prpDinvestDto
     * @throws Exception
     */
    public PrpDinvestDto findByPrimaryKey(DBManager dbManager,String riskCode,String investType) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        //声明DTO
        PrpDinvestDto prpDinvestDto = null;
        //查询数据,赋值给DTO
        prpDinvestDto = dbPrpDinvest.findByPrimaryKey(riskCode, investType);
        return prpDinvestDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDinvestDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDinvest.getCount(conditions);
        collection = dbPrpDinvest.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDinvest dbPrpDinvest = new DBPrpDinvest(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDinvest.getCount(conditions);
        return count;
    }
}
