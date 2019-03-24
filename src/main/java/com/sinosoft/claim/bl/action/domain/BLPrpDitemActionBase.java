package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDitemDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDitem;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpditem标的项目代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDitemActionBase{
    private static Log log = LogFactory.getLog(BLPrpDitemActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDitemActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDitemDto prpDitemDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDitemDto prpDitemDto) throws Exception{
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);
        //插入记录
        dbPrpDitem.insert(prpDitemDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param itemCode 标的项目代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String itemCode) throws Exception{
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);
        //删除记录
        dbPrpDitem.delete(riskCode, itemCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);
        //按条件删除记录
        dbPrpDitem.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDitemDto prpDitemDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDitemDto prpDitemDto) throws Exception{
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);
        //更新记录
        dbPrpDitem.update(prpDitemDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param itemCode 标的项目代码
     * @return prpDitemDto prpDitemDto
     * @throws Exception
     */
    public PrpDitemDto findByPrimaryKey(DBManager dbManager,String riskCode,String itemCode) throws Exception{
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);
        //声明DTO
        PrpDitemDto prpDitemDto = null;
        //查询数据,赋值给DTO
        prpDitemDto = dbPrpDitem.findByPrimaryKey(riskCode, itemCode);
        return prpDitemDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDitemDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDitem.getCount(conditions);
        collection = dbPrpDitem.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDitem.getCount(conditions);
        return count;
    }
}
