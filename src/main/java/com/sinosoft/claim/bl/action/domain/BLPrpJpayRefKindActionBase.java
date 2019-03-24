package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayRefKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJpayRefKind;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjpayrefkind收付费险别分摊表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJpayRefKindActionBase{
    private static Log log = LogFactory.getLog(BLPrpJpayRefKindActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpJpayRefKindActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpJpayRefKindDto prpJpayRefKindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJpayRefKindDto prpJpayRefKindDto) throws Exception{
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);
        //插入记录
        dbPrpJpayRefKind.insert(prpJpayRefKindDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param certiNo 单证号
     * @param serialNo 序号
     * @param kindCode 险别代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo,int serialNo,String kindCode) throws Exception{
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);
        //删除记录
        dbPrpJpayRefKind.delete(certiNo, serialNo, kindCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);
        //按条件删除记录
        dbPrpJpayRefKind.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpJpayRefKindDto prpJpayRefKindDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJpayRefKindDto prpJpayRefKindDto) throws Exception{
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);
        //更新记录
        dbPrpJpayRefKind.update(prpJpayRefKindDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param certiNo 单证号
     * @param serialNo 序号
     * @param kindCode 险别代码
     * @return prpJpayRefKindDto prpJpayRefKindDto
     * @throws Exception
     */
    public PrpJpayRefKindDto findByPrimaryKey(DBManager dbManager,String certiNo,int serialNo,String kindCode) throws Exception{
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);
        //声明DTO
        PrpJpayRefKindDto prpJpayRefKindDto = null;
        //查询数据,赋值给DTO
        prpJpayRefKindDto = dbPrpJpayRefKind.findByPrimaryKey(certiNo, serialNo, kindCode);
        return prpJpayRefKindDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpJpayRefKindDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJpayRefKind.getCount(conditions);
        collection = dbPrpJpayRefKind.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJpayRefKind dbPrpJpayRefKind = new DBPrpJpayRefKind(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJpayRefKind.getCount(conditions);
        return count;
    }
}
