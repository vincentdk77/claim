package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayPatchRecDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJpayPatchRec;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjpaypatchrec批量收费登记表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJpayPatchRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJpayPatchRecActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpJpayPatchRecActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpJpayPatchRecDto prpJpayPatchRecDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJpayPatchRecDto prpJpayPatchRecDto) throws Exception{
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);
        //插入记录
        dbPrpJpayPatchRec.insert(prpJpayPatchRecDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param payGroupNo 批量收费登记号
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次收费序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String payGroupNo,String certiNo,int serialNo) throws Exception{
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);
        //删除记录
        dbPrpJpayPatchRec.delete(payGroupNo, certiNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);
        //按条件删除记录
        dbPrpJpayPatchRec.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpJpayPatchRecDto prpJpayPatchRecDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJpayPatchRecDto prpJpayPatchRecDto) throws Exception{
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);
        //更新记录
        dbPrpJpayPatchRec.update(prpJpayPatchRecDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param payGroupNo 批量收费登记号
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次收费序号
     * @return prpJpayPatchRecDto prpJpayPatchRecDto
     * @throws Exception
     */
    public PrpJpayPatchRecDto findByPrimaryKey(DBManager dbManager,String payGroupNo,String certiNo,int serialNo) throws Exception{
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);
        //声明DTO
        PrpJpayPatchRecDto prpJpayPatchRecDto = null;
        //查询数据,赋值给DTO
        prpJpayPatchRecDto = dbPrpJpayPatchRec.findByPrimaryKey(payGroupNo, certiNo, serialNo);
        return prpJpayPatchRecDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpJpayPatchRecDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJpayPatchRec.getCount(conditions);
        collection = dbPrpJpayPatchRec.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJpayPatchRec dbPrpJpayPatchRec = new DBPrpJpayPatchRec(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJpayPatchRec.getCount(conditions);
        return count;
    }
}
