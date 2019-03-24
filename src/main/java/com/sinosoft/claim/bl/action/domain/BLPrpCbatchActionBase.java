package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCbatchDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCbatch;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcbatch批量保单附表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCbatchActionBase{
    private static Log log = LogFactory.getLog(BLPrpCbatchActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCbatchActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCbatchDto prpCbatchDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCbatchDto prpCbatchDto) throws Exception{
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);
        //插入记录
        dbPrpCbatch.insert(prpCbatchDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);
        //删除记录
        dbPrpCbatch.delete(policyNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);
        //按条件删除记录
        dbPrpCbatch.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCbatchDto prpCbatchDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCbatchDto prpCbatchDto) throws Exception{
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);
        //更新记录
        dbPrpCbatch.update(prpCbatchDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @return prpCbatchDto prpCbatchDto
     * @throws Exception
     */
    public PrpCbatchDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);
        //声明DTO
        PrpCbatchDto prpCbatchDto = null;
        //查询数据,赋值给DTO
        prpCbatchDto = dbPrpCbatch.findByPrimaryKey(policyNo, serialNo);
        return prpCbatchDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCbatchDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCbatch.getCount(conditions);
        collection = dbPrpCbatch.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCbatch dbPrpCbatch = new DBPrpCbatch(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCbatch.getCount(conditions);
        return count;
    }
}
