package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDclassDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDclass;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdclass险类代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDclassActionBase{
    private static Log log = LogFactory.getLog(BLPrpDclassActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDclassActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDclassDto prpDclassDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDclassDto prpDclassDto) throws Exception{
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);
        //插入记录
        dbPrpDclass.insert(prpDclassDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param classCode 险类代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String classCode) throws Exception{
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);
        //删除记录
        dbPrpDclass.delete(classCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);
        //按条件删除记录
        dbPrpDclass.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDclassDto prpDclassDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDclassDto prpDclassDto) throws Exception{
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);
        //更新记录
        dbPrpDclass.update(prpDclassDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param classCode 险类代码
     * @return prpDclassDto prpDclassDto
     * @throws Exception
     */
    public PrpDclassDto findByPrimaryKey(DBManager dbManager,String classCode) throws Exception{
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);
        //声明DTO
        PrpDclassDto prpDclassDto = null;
        //查询数据,赋值给DTO
        prpDclassDto = dbPrpDclass.findByPrimaryKey(classCode);
        return prpDclassDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDclassDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDclass.getCount(conditions);
        collection = dbPrpDclass.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDclass dbPrpDclass = new DBPrpDclass(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDclass.getCount(conditions);
        return count;
    }
}
