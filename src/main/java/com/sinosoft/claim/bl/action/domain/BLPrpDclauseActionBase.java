package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDclauseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDclause;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdclause条款代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDclauseActionBase{
    private static Log log = LogFactory.getLog(BLPrpDclauseActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDclauseActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDclauseDto prpDclauseDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDclauseDto prpDclauseDto) throws Exception{
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
        //插入记录
        dbPrpDclause.insert(prpDclauseDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param clauseCode 条款代码
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String clauseCode,int lineNo) throws Exception{
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
        //删除记录
        dbPrpDclause.delete(clauseCode, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
        //按条件删除记录
        dbPrpDclause.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDclauseDto prpDclauseDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDclauseDto prpDclauseDto) throws Exception{
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
        //更新记录
        dbPrpDclause.update(prpDclauseDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param clauseCode 条款代码
     * @param lineNo 行号
     * @return prpDclauseDto prpDclauseDto
     * @throws Exception
     */
    public PrpDclauseDto findByPrimaryKey(DBManager dbManager,String clauseCode,int lineNo) throws Exception{
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
        //声明DTO
        PrpDclauseDto prpDclauseDto = null;
        //查询数据,赋值给DTO
        prpDclauseDto = dbPrpDclause.findByPrimaryKey(clauseCode, lineNo);
        return prpDclauseDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDclauseDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDclause.getCount(conditions);
        collection = dbPrpDclause.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDclause.getCount(conditions);
        return count;
    }
}
