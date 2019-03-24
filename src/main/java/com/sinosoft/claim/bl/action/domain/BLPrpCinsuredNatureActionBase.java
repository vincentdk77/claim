package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredNatureDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCinsuredNature;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcinsurednature自然人信息表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCinsuredNatureActionBase{
    private static Log log = LogFactory.getLog(BLPrpCinsuredNatureActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCinsuredNatureActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCinsuredNatureDto prpCinsuredNatureDto) throws Exception{
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);
        //插入记录
        dbPrpCinsuredNature.insert(prpCinsuredNatureDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);
        //删除记录
        dbPrpCinsuredNature.delete(policyNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);
        //按条件删除记录
        dbPrpCinsuredNature.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCinsuredNatureDto prpCinsuredNatureDto) throws Exception{
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);
        //更新记录
        dbPrpCinsuredNature.update(prpCinsuredNatureDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @return prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public PrpCinsuredNatureDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);
        //声明DTO
        PrpCinsuredNatureDto prpCinsuredNatureDto = null;
        //查询数据,赋值给DTO
        prpCinsuredNatureDto = dbPrpCinsuredNature.findByPrimaryKey(policyNo, serialNo);
        return prpCinsuredNatureDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCinsuredNatureDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCinsuredNature.getCount(conditions);
        collection = dbPrpCinsuredNature.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCinsuredNature dbPrpCinsuredNature = new DBPrpCinsuredNature(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCinsuredNature.getCount(conditions);
        return count;
    }
}
