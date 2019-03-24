package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckItemDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheckItem;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcheckItem-查勘任务标的表（新增）的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.218<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckItemActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckItemActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcheckItemActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcheckItemDto prpLcheckItemDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcheckItemDto prpLcheckItemDto) throws Exception{
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        //插入记录
        dbPrpLcheckItem.insert(prpLcheckItemDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param itemNo 标的序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,int scheduleID,String registNo,int itemNo) throws Exception{
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        //删除记录
        dbPrpLcheckItem.delete(scheduleID, registNo, itemNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        //按条件删除记录
        dbPrpLcheckItem.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcheckItemDto prpLcheckItemDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcheckItemDto prpLcheckItemDto) throws Exception{
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        //更新记录
        dbPrpLcheckItem.update(prpLcheckItemDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param itemNo 标的序号
     * @return prpLcheckItemDto prpLcheckItemDto
     * @throws Exception
     */
    public PrpLcheckItemDto findByPrimaryKey(DBManager dbManager,int scheduleID,String registNo,int itemNo) throws Exception{
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        //声明DTO
        PrpLcheckItemDto prpLcheckItemDto = null;
        //查询数据,赋值给DTO
        prpLcheckItemDto = dbPrpLcheckItem.findByPrimaryKey(scheduleID, registNo, itemNo);
        return prpLcheckItemDto;
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
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckItem.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcheckItem.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcheckItemDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcheckItem.findByConditions(conditions);
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
        DBPrpLcheckItem dbPrpLcheckItem = new DBPrpLcheckItem(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckItem.getCount(conditions);
        return count;
    }
}
