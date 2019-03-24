package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDshipClassDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDshipClass;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdshipclass船舶船级社对照的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDshipClassActionBase{
    private static Log log = LogFactory.getLog(BLPrpDshipClassActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDshipClassActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDshipClassDto prpDshipClassDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDshipClassDto prpDshipClassDto) throws Exception{
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);
        //插入记录
        dbPrpDshipClass.insert(prpDshipClassDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param shipCode 船舶代码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String shipCode,int serialNo) throws Exception{
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);
        //删除记录
        dbPrpDshipClass.delete(shipCode, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);
        //按条件删除记录
        dbPrpDshipClass.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDshipClassDto prpDshipClassDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDshipClassDto prpDshipClassDto) throws Exception{
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);
        //更新记录
        dbPrpDshipClass.update(prpDshipClassDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param shipCode 船舶代码
     * @param serialNo 序号
     * @return prpDshipClassDto prpDshipClassDto
     * @throws Exception
     */
    public PrpDshipClassDto findByPrimaryKey(DBManager dbManager,String shipCode,int serialNo) throws Exception{
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);
        //声明DTO
        PrpDshipClassDto prpDshipClassDto = null;
        //查询数据,赋值给DTO
        prpDshipClassDto = dbPrpDshipClass.findByPrimaryKey(shipCode, serialNo);
        return prpDshipClassDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDshipClassDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDshipClass.getCount(conditions);
        collection = dbPrpDshipClass.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDshipClass.getCount(conditions);
        return count;
    }
}
