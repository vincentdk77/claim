package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleItem;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleItem-调度任务标的表(新增）的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.234<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleItemActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleItemActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLscheduleItemActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLscheduleItemDto prpLscheduleItemDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLscheduleItemDto prpLscheduleItemDto) throws Exception{
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        //插入记录
        dbPrpLscheduleItem.insert(prpLscheduleItemDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param itemNo ITEMNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,int scheduleID,String registNo,int itemNo) throws Exception{
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        //删除记录
        dbPrpLscheduleItem.delete(scheduleID, registNo, itemNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        //按条件删除记录
        dbPrpLscheduleItem.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLscheduleItemDto prpLscheduleItemDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLscheduleItemDto prpLscheduleItemDto) throws Exception{
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        //更新记录
        dbPrpLscheduleItem.update(prpLscheduleItemDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param itemNo ITEMNO
     * @return prpLscheduleItemDto prpLscheduleItemDto
     * @throws Exception
     */
    public PrpLscheduleItemDto findByPrimaryKey(DBManager dbManager,int scheduleID,String registNo,int itemNo) throws Exception{
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        //声明DTO
        PrpLscheduleItemDto prpLscheduleItemDto = null;
        //查询数据,赋值给DTO
        prpLscheduleItemDto = dbPrpLscheduleItem.findByPrimaryKey(scheduleID, registNo, itemNo);
        return prpLscheduleItemDto;
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
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        //modify by zhaolu 20060802 start
        int count = dbPrpLscheduleItem.getCount(SqlUtils.getWherePartForGetCount(conditions));
        int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
        if(maxQueryCount!=0&&count>maxQueryCount){   
          throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
        }
        //modify by zhaolu 10060802 end
        collection = dbPrpLscheduleItem.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLscheduleItemDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLscheduleItem.findByConditions(conditions);
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
        DBPrpLscheduleItem dbPrpLscheduleItem = new DBPrpLscheduleItem(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleItem.getCount(conditions);
        return count;
    }
}
