package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpUndoCancelDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpUndoCancel;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpUndoCancel作废或删除操作轨迹主表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUndoCancelActionBase{
    private static Log log = LogFactory.getLog(BLPrpUndoCancelActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpUndoCancelActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpUndoCancelDto prpUndoCancelDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpUndoCancelDto prpUndoCancelDto) throws Exception{
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);
        //插入记录
        dbPrpUndoCancel.insert(prpUndoCancelDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param operateTypeCode 操作类型
     * @param certiNo 单证号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String operateTypeCode,String certiNo,int serialNo) throws Exception{
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);
        //删除记录
        dbPrpUndoCancel.delete(operateTypeCode, certiNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);
        //按条件删除记录
        dbPrpUndoCancel.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpUndoCancelDto prpUndoCancelDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpUndoCancelDto prpUndoCancelDto) throws Exception{
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);
        //更新记录
        dbPrpUndoCancel.update(prpUndoCancelDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param operateTypeCode 操作类型
     * @param certiNo 单证号
     * @param serialNo 序号
     * @return prpUndoCancelDto prpUndoCancelDto
     * @throws Exception
     */
    public PrpUndoCancelDto findByPrimaryKey(DBManager dbManager,String operateTypeCode,String certiNo,int serialNo) throws Exception{
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);
        //声明DTO
        PrpUndoCancelDto prpUndoCancelDto = null;
        //查询数据,赋值给DTO
        prpUndoCancelDto = dbPrpUndoCancel.findByPrimaryKey(operateTypeCode, certiNo, serialNo);
        return prpUndoCancelDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpUndoCancelDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpUndoCancel.getCount(conditions);
        collection = dbPrpUndoCancel.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpUndoCancel dbPrpUndoCancel = new DBPrpUndoCancel(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpUndoCancel.getCount(conditions);
        return count;
    }
}
