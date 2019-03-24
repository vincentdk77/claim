package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpUndoCancelFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpUndoCancelFee;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpUndoCancelFee作废或删除操作轨迹附表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUndoCancelFeeActionBase{
    private static Log log = LogFactory.getLog(BLPrpUndoCancelFeeActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpUndoCancelFeeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpUndoCancelFeeDto prpUndoCancelFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpUndoCancelFeeDto prpUndoCancelFeeDto) throws Exception{
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);
        //插入记录
        dbPrpUndoCancelFee.insert(prpUndoCancelFeeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param operateTypeCode 操作类型代码
     * @param certiNo 单证号
     * @param serialNo 序号
     * @param currency 币别代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String operateTypeCode,String certiNo,int serialNo,String currency) throws Exception{
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);
        //删除记录
        dbPrpUndoCancelFee.delete(operateTypeCode, certiNo, serialNo, currency);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);
        //按条件删除记录
        dbPrpUndoCancelFee.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpUndoCancelFeeDto prpUndoCancelFeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpUndoCancelFeeDto prpUndoCancelFeeDto) throws Exception{
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);
        //更新记录
        dbPrpUndoCancelFee.update(prpUndoCancelFeeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param operateTypeCode 操作类型代码
     * @param certiNo 单证号
     * @param serialNo 序号
     * @param currency 币别代码
     * @return prpUndoCancelFeeDto prpUndoCancelFeeDto
     * @throws Exception
     */
    public PrpUndoCancelFeeDto findByPrimaryKey(DBManager dbManager,String operateTypeCode,String certiNo,int serialNo,String currency) throws Exception{
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);
        //声明DTO
        PrpUndoCancelFeeDto prpUndoCancelFeeDto = null;
        //查询数据,赋值给DTO
        prpUndoCancelFeeDto = dbPrpUndoCancelFee.findByPrimaryKey(operateTypeCode, certiNo, serialNo, currency);
        return prpUndoCancelFeeDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpUndoCancelFeeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpUndoCancelFee.getCount(conditions);
        collection = dbPrpUndoCancelFee.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpUndoCancelFee dbPrpUndoCancelFee = new DBPrpUndoCancelFee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpUndoCancelFee.getCount(conditions);
        return count;
    }
}
