package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDagentDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDagent;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdagent代理人代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDagentActionBase{
    private static Log log = LogFactory.getLog(BLPrpDagentActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDagentActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDagentDto prpDagentDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDagentDto prpDagentDto) throws Exception{
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);
        //插入记录
        dbPrpDagent.insert(prpDagentDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param agentCode 代理人代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String agentCode) throws Exception{
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);
        //删除记录
        dbPrpDagent.delete(agentCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);
        //按条件删除记录
        dbPrpDagent.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDagentDto prpDagentDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDagentDto prpDagentDto) throws Exception{
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);
        //更新记录
        dbPrpDagent.update(prpDagentDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param agentCode 代理人代码
     * @return prpDagentDto prpDagentDto
     * @throws Exception
     */
    public PrpDagentDto findByPrimaryKey(DBManager dbManager,String agentCode) throws Exception{
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);
        //声明DTO
        PrpDagentDto prpDagentDto = null;
        //查询数据,赋值给DTO
        prpDagentDto = dbPrpDagent.findByPrimaryKey(agentCode);
        return prpDagentDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDagentDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDagent.getCount(conditions);
        collection = dbPrpDagent.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDagent dbPrpDagent = new DBPrpDagent(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDagent.getCount(conditions);
        return count;
    }
}
