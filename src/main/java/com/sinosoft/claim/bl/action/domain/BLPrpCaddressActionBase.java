package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCaddressDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCaddress;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcaddress保险地址表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCaddressActionBase{
    private static Log log = LogFactory.getLog(BLPrpCaddressActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCaddressActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCaddressDto prpCaddressDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCaddressDto prpCaddressDto) throws Exception{
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);
        //插入记录
        dbPrpCaddress.insert(prpCaddressDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param addressNo 地址序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int addressNo) throws Exception{
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);
        //删除记录
        dbPrpCaddress.delete(policyNo, addressNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);
        //按条件删除记录
        dbPrpCaddress.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCaddressDto prpCaddressDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCaddressDto prpCaddressDto) throws Exception{
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);
        //更新记录
        dbPrpCaddress.update(prpCaddressDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param addressNo 地址序号
     * @return prpCaddressDto prpCaddressDto
     * @throws Exception
     */
    public PrpCaddressDto findByPrimaryKey(DBManager dbManager,String policyNo,int addressNo) throws Exception{
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);
        //声明DTO
        PrpCaddressDto prpCaddressDto = null;
        //查询数据,赋值给DTO
        prpCaddressDto = dbPrpCaddress.findByPrimaryKey(policyNo, addressNo);
        return prpCaddressDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCaddressDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCaddress.getCount(conditions);
        collection = dbPrpCaddress.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCaddress dbPrpCaddress = new DBPrpCaddress(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCaddress.getCount(conditions);
        return count;
    }
}
