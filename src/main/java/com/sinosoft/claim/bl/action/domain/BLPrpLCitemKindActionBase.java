package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLCitemKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLCitemKind;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLCitemKind-代赔保单投保险别表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.203<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLCitemKindActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLCitemKindActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLCitemKindActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLCitemKindDto prpLCitemKindDto) throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        //插入记录
        dbPrpLCitemKind.insert(prpLCitemKindDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param policyNo 保单号码
     * @param itemKindNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String policyNo,int itemKindNo) throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        //删除记录
        dbPrpLCitemKind.delete(registNo, policyNo, itemKindNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        //按条件删除记录
        dbPrpLCitemKind.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLCitemKindDto prpLCitemKindDto) throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        //更新记录
        dbPrpLCitemKind.update(prpLCitemKindDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param policyNo 保单号码
     * @param itemKindNo 序号
     * @return prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public PrpLCitemKindDto findByPrimaryKey(DBManager dbManager,String registNo,String policyNo,int itemKindNo) throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        //声明DTO
        PrpLCitemKindDto prpLCitemKindDto = null;
        //查询数据,赋值给DTO
        prpLCitemKindDto = dbPrpLCitemKind.findByPrimaryKey(registNo, policyNo, itemKindNo);
        return prpLCitemKindDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLCitemKind.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLCitemKind.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLCitemKindDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLCitemKind.findByConditions(conditions);
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLCitemKind dbPrpLCitemKind = new DBPrpLCitemKind(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLCitemKind.getCount(conditions);
        return count;
    }
}
