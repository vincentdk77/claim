package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGnodeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpGnode;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgnode工作流节点模板表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGnodeActionBase{
    private static Log log = LogFactory.getLog(BLPrpGnodeActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpGnodeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpGnodeDto prpGnodeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGnodeDto prpGnodeDto) throws Exception{
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);
        //插入记录
        dbPrpGnode.insert(prpGnodeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板号
     * @param nodeNo 节点号
     * @param sonNodeNo 子节点号
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,int nodeNo,int sonNodeNo) throws Exception{
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);
        //删除记录
        dbPrpGnode.delete(modelNo, nodeNo, sonNodeNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);
        //按条件删除记录
        dbPrpGnode.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpGnodeDto prpGnodeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGnodeDto prpGnodeDto) throws Exception{
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);
        //更新记录
        dbPrpGnode.update(prpGnodeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板号
     * @param nodeNo 节点号
     * @param sonNodeNo 子节点号
     * @return prpGnodeDto prpGnodeDto
     * @throws Exception
     */
    public PrpGnodeDto findByPrimaryKey(DBManager dbManager,int modelNo,int nodeNo,int sonNodeNo) throws Exception{
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);
        //声明DTO
        PrpGnodeDto prpGnodeDto = null;
        //查询数据,赋值给DTO
        prpGnodeDto = dbPrpGnode.findByPrimaryKey(modelNo, nodeNo, sonNodeNo);
        return prpGnodeDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpGnodeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpGnode.getCount(conditions);
        collection = dbPrpGnode.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGnode.getCount(conditions);
        return count;
    }
}
