package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCfeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCfee;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcfee保单保额保费表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCfeeActionBase{
    private static Log log = LogFactory.getLog(BLPrpCfeeActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCfeeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCfeeDto prpCfeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCfeeDto prpCfeeDto) throws Exception{
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);
        //插入记录
        dbPrpCfee.insert(prpCfeeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param currency 币别代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,String currency) throws Exception{
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);
        //删除记录
        dbPrpCfee.delete(policyNo, currency);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);
        //按条件删除记录
        dbPrpCfee.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCfeeDto prpCfeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCfeeDto prpCfeeDto) throws Exception{
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);
        //更新记录
        dbPrpCfee.update(prpCfeeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param currency 币别代码
     * @return prpCfeeDto prpCfeeDto
     * @throws Exception
     */
    public PrpCfeeDto findByPrimaryKey(DBManager dbManager,String policyNo,String currency) throws Exception{
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);
        //声明DTO
        PrpCfeeDto prpCfeeDto = null;
        //查询数据,赋值给DTO
        prpCfeeDto = dbPrpCfee.findByPrimaryKey(policyNo, currency);
        return prpCfeeDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCfeeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCfee.getCount(conditions);
        collection = dbPrpCfee.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCfee dbPrpCfee = new DBPrpCfee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCfee.getCount(conditions);
        return count;
    }
}
