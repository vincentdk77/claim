package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPitemKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPitemKind;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prppitemkind标的子险信息的业务逻辑对象类<br>
 * 创建于 2004-11-22 15:24:31.171<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPitemKindActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPitemKindActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpPitemKindActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpPitemKindDto prpPitemKindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpPitemKindDto prpPitemKindDto) throws Exception{
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        //插入记录
        dbPrpPitemKind.insert(prpPitemKindDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param endorseNo 批单号码
     * @param itemKindNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseNo,int itemKindNo) throws Exception{
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        //删除记录
        dbPrpPitemKind.delete(endorseNo, itemKindNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        //按条件删除记录
        dbPrpPitemKind.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpPitemKindDto prpPitemKindDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpPitemKindDto prpPitemKindDto) throws Exception{
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        //更新记录
        dbPrpPitemKind.update(prpPitemKindDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param endorseNo 批单号码
     * @param itemKindNo 序号
     * @return prpPitemKindDto prpPitemKindDto
     * @throws Exception
     */
    public PrpPitemKindDto findByPrimaryKey(DBManager dbManager,String endorseNo,int itemKindNo) throws Exception{
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        //声明DTO
        PrpPitemKindDto prpPitemKindDto = null;
        //查询数据,赋值给DTO
        prpPitemKindDto = dbPrpPitemKind.findByPrimaryKey(endorseNo, itemKindNo);
        return prpPitemKindDto;
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
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPitemKind.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpPitemKind.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpPitemKindDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpPitemKind.findByConditions(conditions);
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
        DBPrpPitemKind dbPrpPitemKind = new DBPrpPitemKind(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPitemKind.getCount(conditions);
        return count;
    }
}
