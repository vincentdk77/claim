package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcarModelDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcarModel;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcarmodel车型代码的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcarModelActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcarModelActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDcarModelActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDcarModelDto prpDcarModelDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcarModelDto prpDcarModelDto) throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);
        //插入记录
        dbPrpDcarModel.insert(prpDcarModelDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param modelCode 车型代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String modelCode) throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);
        //删除记录
        dbPrpDcarModel.delete(modelCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);
        //按条件删除记录
        dbPrpDcarModel.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDcarModelDto prpDcarModelDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcarModelDto prpDcarModelDto) throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);
        //更新记录
        dbPrpDcarModel.update(prpDcarModelDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param modelCode 车型代码
     * @return prpDcarModelDto prpDcarModelDto
     * @throws Exception
     */
    public PrpDcarModelDto findByPrimaryKey(DBManager dbManager,String modelCode) throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);
        //声明DTO
        PrpDcarModelDto prpDcarModelDto = null;
        //查询数据,赋值给DTO
        prpDcarModelDto = dbPrpDcarModel.findByPrimaryKey(modelCode);
        return prpDcarModelDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDcarModelDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDcarModel.getCount(conditions);
        collection = dbPrpDcarModel.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcarModel.getCount(conditions);
        return count;
    }
}
