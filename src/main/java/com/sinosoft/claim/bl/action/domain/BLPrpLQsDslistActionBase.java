package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsDslistDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLQsDslist;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLQs_Dslist地市通赔结算明细清单表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLQsDslistActionBase{
    private static Log log = LogFactory.getLog(BLPrpLQsDslistActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpLQsDslistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLQs_DslistDto prpLQs_DslistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLQsDslistDto prpLQs_DslistDto) throws Exception{
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);
        //插入记录
        dbPrpLQs_Dslist.insert(prpLQs_DslistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param procNo 结算单批次号
     * @param serialNo 本次结算顺序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String procNo,int serialNo) throws Exception{
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);
        //删除记录
        dbPrpLQs_Dslist.delete(procNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);
        //按条件删除记录
        dbPrpLQs_Dslist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLQs_DslistDto prpLQs_DslistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLQsDslistDto prpLQs_DslistDto) throws Exception{
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);
        //更新记录
        dbPrpLQs_Dslist.update(prpLQs_DslistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param procNo 结算单批次号
     * @param serialNo 本次结算顺序号
     * @return prpLQs_DslistDto prpLQs_DslistDto
     * @throws Exception
     */
    public PrpLQsDslistDto findByPrimaryKey(DBManager dbManager,String procNo,int serialNo) throws Exception{
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);
        //声明DTO
        PrpLQsDslistDto prpLQs_DslistDto = null;
        //查询数据,赋值给DTO
        prpLQs_DslistDto = dbPrpLQs_Dslist.findByPrimaryKey(procNo, serialNo);
        return prpLQs_DslistDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpLQs_DslistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLQs_Dslist.getCount(conditions);
        collection = dbPrpLQs_Dslist.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLQsDslist dbPrpLQs_Dslist = new DBPrpLQsDslist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLQs_Dslist.getCount(conditions);
        return count;
    }
}
