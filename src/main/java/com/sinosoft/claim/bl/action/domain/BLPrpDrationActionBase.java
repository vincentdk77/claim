package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrationDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDration;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdration定额保单标的险别代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrationActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrationActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDrationActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDrationDto prpDrationDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDrationDto prpDrationDto) throws Exception{
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);
        //插入记录
        dbPrpDration.insert(prpDrationDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param rationType 定额类型代码
     * @param itemCode 标的类别
     * @param kindCode 险别代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String rationType,String itemCode,String kindCode) throws Exception{
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);
        //删除记录
        dbPrpDration.delete(riskCode, rationType, itemCode, kindCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);
        //按条件删除记录
        dbPrpDration.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDrationDto prpDrationDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDrationDto prpDrationDto) throws Exception{
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);
        //更新记录
        dbPrpDration.update(prpDrationDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param rationType 定额类型代码
     * @param itemCode 标的类别
     * @param kindCode 险别代码
     * @return prpDrationDto prpDrationDto
     * @throws Exception
     */
    public PrpDrationDto findByPrimaryKey(DBManager dbManager,String riskCode,String rationType,String itemCode,String kindCode) throws Exception{
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);
        //声明DTO
        PrpDrationDto prpDrationDto = null;
        //查询数据,赋值给DTO
        prpDrationDto = dbPrpDration.findByPrimaryKey(riskCode, rationType, itemCode, kindCode);
        return prpDrationDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDrationDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDration.getCount(conditions);
        collection = dbPrpDration.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDration dbPrpDration = new DBPrpDration(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDration.getCount(conditions);
        return count;
    }
}
