package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayRecDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJpayRec;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjpayrec收费登记表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJpayRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJpayRecActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpJpayRecActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpJpayRecDto prpJpayRecDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJpayRecDto prpJpayRecDto) throws Exception{
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);
        //插入记录
        dbPrpJpayRec.insert(prpJpayRecDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param certiNo 保单号码/批单号码
     * @param order02No 收费序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo,int order02No) throws Exception{
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);
        //删除记录
        dbPrpJpayRec.delete(certiNo, order02No);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);
        //按条件删除记录
        dbPrpJpayRec.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpJpayRecDto prpJpayRecDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJpayRecDto prpJpayRecDto) throws Exception{
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);
        //更新记录
        dbPrpJpayRec.update(prpJpayRecDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param certiNo 保单号码/批单号码
     * @param order02No 收费序号
     * @return prpJpayRecDto prpJpayRecDto
     * @throws Exception
     */
    public PrpJpayRecDto findByPrimaryKey(DBManager dbManager,String certiNo,int order02No) throws Exception{
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);
        //声明DTO
        PrpJpayRecDto prpJpayRecDto = null;
        //查询数据,赋值给DTO
        prpJpayRecDto = dbPrpJpayRec.findByPrimaryKey(certiNo, order02No);
        return prpJpayRecDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpJpayRecDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJpayRec.getCount(conditions);
        collection = dbPrpJpayRec.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJpayRec.getCount(conditions);
        return count;
    }
}
