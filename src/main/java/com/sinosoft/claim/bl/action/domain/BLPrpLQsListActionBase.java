package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsListDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLQsList;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLQs_list清算中心通赔结算明细清单的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLQsListActionBase{
    private static Log log = LogFactory.getLog(BLPrpLQsListActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpLQsListActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLQs_listDto prpLQs_listDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLQsListDto prpLQs_listDto) throws Exception{
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);
        //插入记录
        dbPrpLQs_list.insert(prpLQs_listDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param procNo 结算单批次号
     * @param serialNo 本次结算顺序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String procNo,int serialNo) throws Exception{
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);
        //删除记录
        dbPrpLQs_list.delete(procNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);
        //按条件删除记录
        dbPrpLQs_list.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLQs_listDto prpLQs_listDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLQsListDto prpLQs_listDto) throws Exception{
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);
        //更新记录
        dbPrpLQs_list.update(prpLQs_listDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param procNo 结算单批次号
     * @param serialNo 本次结算顺序号
     * @return prpLQs_listDto prpLQs_listDto
     * @throws Exception
     */
    public PrpLQsListDto findByPrimaryKey(DBManager dbManager,String procNo,int serialNo) throws Exception{
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);
        //声明DTO
        PrpLQsListDto prpLQs_listDto = null;
        //查询数据,赋值给DTO
        prpLQs_listDto = dbPrpLQs_list.findByPrimaryKey(procNo, serialNo);
        return prpLQs_listDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpLQs_listDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLQs_list.getCount(conditions);
        collection = dbPrpLQs_list.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLQsList dbPrpLQs_list = new DBPrpLQsList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLQs_list.getCount(conditions);
        return count;
    }
}
