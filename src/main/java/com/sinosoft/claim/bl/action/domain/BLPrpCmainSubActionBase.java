package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainSubDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmainSub;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcmainsub保单隶属表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCmainSubActionBase{
    private static Log log = LogFactory.getLog(BLPrpCmainSubActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCmainSubActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCmainSubDto prpCmainSubDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCmainSubDto prpCmainSubDto) throws Exception{
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);
        //插入记录
        dbPrpCmainSub.insert(prpCmainSubDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param mainPolicyNo 主保单号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,String mainPolicyNo) throws Exception{
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);
        //删除记录
        dbPrpCmainSub.delete(policyNo, mainPolicyNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);
        //按条件删除记录
        dbPrpCmainSub.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCmainSubDto prpCmainSubDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCmainSubDto prpCmainSubDto) throws Exception{
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);
        //更新记录
        dbPrpCmainSub.update(prpCmainSubDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param mainPolicyNo 主保单号码
     * @return prpCmainSubDto prpCmainSubDto
     * @throws Exception
     */
    public PrpCmainSubDto findByPrimaryKey(DBManager dbManager,String policyNo,String mainPolicyNo) throws Exception{
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);
        //声明DTO
        PrpCmainSubDto prpCmainSubDto = null;
        //查询数据,赋值给DTO
        prpCmainSubDto = dbPrpCmainSub.findByPrimaryKey(policyNo, mainPolicyNo);
        return prpCmainSubDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCmainSubDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCmainSub.getCount(conditions);
        collection = dbPrpCmainSub.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCmainSub.getCount(conditions);
        return count;
    }
}
