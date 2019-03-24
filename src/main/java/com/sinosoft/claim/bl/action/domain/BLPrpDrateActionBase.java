package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrateDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDrate;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdrate标准费率表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDrateActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDrateDto prpDrateDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDrateDto prpDrateDto) throws Exception{
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);
        //插入记录
        dbPrpDrate.insert(prpDrateDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param serialNo 序号
     * @param riskCode 险种代码
     * @param rateCode 费率代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,int serialNo,String riskCode,String rateCode) throws Exception{
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);
        //删除记录
        dbPrpDrate.delete(serialNo, riskCode, rateCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);
        //按条件删除记录
        dbPrpDrate.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDrateDto prpDrateDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDrateDto prpDrateDto) throws Exception{
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);
        //更新记录
        dbPrpDrate.update(prpDrateDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param serialNo 序号
     * @param riskCode 险种代码
     * @param rateCode 费率代码
     * @return prpDrateDto prpDrateDto
     * @throws Exception
     */
    public PrpDrateDto findByPrimaryKey(DBManager dbManager,int serialNo,String riskCode,String rateCode) throws Exception{
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);
        //声明DTO
        PrpDrateDto prpDrateDto = null;
        //查询数据,赋值给DTO
        prpDrateDto = dbPrpDrate.findByPrimaryKey(serialNo, riskCode, rateCode);
        return prpDrateDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDrateDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDrate.getCount(conditions);
        collection = dbPrpDrate.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDrate dbPrpDrate = new DBPrpDrate(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrate.getCount(conditions);
        return count;
    }
}
