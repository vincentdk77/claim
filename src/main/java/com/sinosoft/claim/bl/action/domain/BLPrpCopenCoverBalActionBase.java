package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCopenCoverBalDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCopenCoverBal;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcopencoverbal协议结算记录表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCopenCoverBalActionBase{
    private static Log log = LogFactory.getLog(BLPrpCopenCoverBalActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCopenCoverBalActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCopenCoverBalDto prpCopenCoverBalDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCopenCoverBalDto prpCopenCoverBalDto) throws Exception{
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);
        //插入记录
        dbPrpCopenCoverBal.insert(prpCopenCoverBalDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 协议号
     * @param serialNo 顺序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);
        //删除记录
        dbPrpCopenCoverBal.delete(policyNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);
        //按条件删除记录
        dbPrpCopenCoverBal.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCopenCoverBalDto prpCopenCoverBalDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCopenCoverBalDto prpCopenCoverBalDto) throws Exception{
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);
        //更新记录
        dbPrpCopenCoverBal.update(prpCopenCoverBalDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 协议号
     * @param serialNo 顺序号
     * @return prpCopenCoverBalDto prpCopenCoverBalDto
     * @throws Exception
     */
    public PrpCopenCoverBalDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);
        //声明DTO
        PrpCopenCoverBalDto prpCopenCoverBalDto = null;
        //查询数据,赋值给DTO
        prpCopenCoverBalDto = dbPrpCopenCoverBal.findByPrimaryKey(policyNo, serialNo);
        return prpCopenCoverBalDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCopenCoverBalDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCopenCoverBal.getCount(conditions);
        collection = dbPrpCopenCoverBal.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCopenCoverBal dbPrpCopenCoverBal = new DBPrpCopenCoverBal(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCopenCoverBal.getCount(conditions);
        return count;
    }
}
