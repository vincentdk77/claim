package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpMaxNoDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpMaxNo;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpmaxno单证号表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpMaxNoActionBase{
    private static Log log = LogFactory.getLog(BLPrpMaxNoActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpMaxNoActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpMaxNoDto prpMaxNoDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpMaxNoDto prpMaxNoDto) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //插入记录
        dbPrpMaxNo.insert(prpMaxNoDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param groupNo 编组
     * @param maxNo 编号
     * @param tableName 表名
     * @throws Exception
     */
    public void delete(DBManager dbManager,String groupNo,String maxNo,String tableName) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //删除记录
        dbPrpMaxNo.delete(groupNo, maxNo, tableName);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //按条件删除记录
        dbPrpMaxNo.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpMaxNoDto prpMaxNoDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpMaxNoDto prpMaxNoDto) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //更新记录
        dbPrpMaxNo.update(prpMaxNoDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param groupNo 编组
     * @param maxNo 编号
     * @param tableName 表名
     * @return prpMaxNoDto prpMaxNoDto
     * @throws Exception
     */
    public PrpMaxNoDto findByPrimaryKey(DBManager dbManager,String groupNo,String maxNo,String tableName) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        //声明DTO
        PrpMaxNoDto prpMaxNoDto = null;
        //查询数据,赋值给DTO
        prpMaxNoDto = dbPrpMaxNo.findByPrimaryKey(groupNo, maxNo, tableName);
        return prpMaxNoDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpMaxNoDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpMaxNo.getCount(conditions);
        collection = dbPrpMaxNo.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpMaxNo.getCount(conditions);
        return count;
    }
}
