package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDagentComDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDagentCom;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdagentcom承保地区,承保公司表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDagentComActionBase{
    private static Log log = LogFactory.getLog(BLPrpDagentComActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDagentComActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDagentComDto prpDagentComDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDagentComDto prpDagentComDto) throws Exception{
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);
        //插入记录
        dbPrpDagentCom.insert(prpDagentComDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param centreCode 承保地区代码
     * @param unitCode 承保公司代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String centreCode,String unitCode) throws Exception{
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);
        //删除记录
        dbPrpDagentCom.delete(centreCode, unitCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);
        //按条件删除记录
        dbPrpDagentCom.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDagentComDto prpDagentComDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDagentComDto prpDagentComDto) throws Exception{
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);
        //更新记录
        dbPrpDagentCom.update(prpDagentComDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param centreCode 承保地区代码
     * @param unitCode 承保公司代码
     * @return prpDagentComDto prpDagentComDto
     * @throws Exception
     */
    public PrpDagentComDto findByPrimaryKey(DBManager dbManager,String centreCode,String unitCode) throws Exception{
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);
        //声明DTO
        PrpDagentComDto prpDagentComDto = null;
        //查询数据,赋值给DTO
        prpDagentComDto = dbPrpDagentCom.findByPrimaryKey(centreCode, unitCode);
        return prpDagentComDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDagentComDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDagentCom.getCount(conditions);
        collection = dbPrpDagentCom.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDagentCom.getCount(conditions);
        return count;
    }
}
