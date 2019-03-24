package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcoinsDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcoins;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpccoins共保信息表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCcoinsActionBase{
    private static Log log = LogFactory.getLog(BLPrpCcoinsActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCcoinsActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCcoinsDto prpCcoinsDto) throws Exception{
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
        //插入记录
        dbPrpCcoins.insert(prpCcoinsDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
        //删除记录
        dbPrpCcoins.delete(policyNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
        //按条件删除记录
        dbPrpCcoins.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCcoinsDto prpCcoinsDto) throws Exception{
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
        //更新记录
        dbPrpCcoins.update(prpCcoinsDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @return prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public PrpCcoinsDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
        //声明DTO
        PrpCcoinsDto prpCcoinsDto = null;
        //查询数据,赋值给DTO
        prpCcoinsDto = dbPrpCcoins.findByPrimaryKey(policyNo, serialNo);
        return prpCcoinsDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCcoinsDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCcoins.getCount(conditions);
        collection = dbPrpCcoins.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCcoins dbPrpCcoins = new DBPrpCcoins(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCcoins.getCount(conditions);
        return count;
    }
}
