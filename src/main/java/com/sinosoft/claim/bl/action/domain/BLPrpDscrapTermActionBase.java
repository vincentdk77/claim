package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDscrapTermDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDscrapTerm;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdscrapterm汽车报废标准表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDscrapTermActionBase{
    private static Log log = LogFactory.getLog(BLPrpDscrapTermActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDscrapTermActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDscrapTermDto prpDscrapTermDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDscrapTermDto prpDscrapTermDto) throws Exception{
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);
        //插入记录
        dbPrpDscrapTerm.insert(prpDscrapTermDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param carKindCode 车辆种类代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String carKindCode) throws Exception{
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);
        //删除记录
        dbPrpDscrapTerm.delete(carKindCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);
        //按条件删除记录
        dbPrpDscrapTerm.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDscrapTermDto prpDscrapTermDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDscrapTermDto prpDscrapTermDto) throws Exception{
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);
        //更新记录
        dbPrpDscrapTerm.update(prpDscrapTermDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param carKindCode 车辆种类代码
     * @return prpDscrapTermDto prpDscrapTermDto
     * @throws Exception
     */
    public PrpDscrapTermDto findByPrimaryKey(DBManager dbManager,String carKindCode) throws Exception{
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);
        //声明DTO
        PrpDscrapTermDto prpDscrapTermDto = null;
        //查询数据,赋值给DTO
        prpDscrapTermDto = dbPrpDscrapTerm.findByPrimaryKey(carKindCode);
        return prpDscrapTermDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDscrapTermDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDscrapTerm.getCount(conditions);
        collection = dbPrpDscrapTerm.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDscrapTerm dbPrpDscrapTerm = new DBPrpDscrapTerm(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDscrapTerm.getCount(conditions);
        return count;
    }
}
