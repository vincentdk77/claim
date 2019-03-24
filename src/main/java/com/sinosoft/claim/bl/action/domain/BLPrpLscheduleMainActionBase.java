package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleMainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleMain;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleMain-调度任务主表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.140<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleMainActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleMainActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLscheduleMainActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLscheduleMainDto prpLscheduleMainDto) throws Exception{
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        //插入记录
        dbPrpLscheduleMain.insert(prpLscheduleMainDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,int scheduleID,String registNo,int serialNo) throws Exception{
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        //删除记录
        dbPrpLscheduleMain.delete(scheduleID, registNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        //按条件删除记录
        dbPrpLscheduleMain.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLscheduleMainDto prpLscheduleMainDto) throws Exception{
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        //更新记录
        dbPrpLscheduleMain.update(prpLscheduleMainDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param serialNo 序号
     * @return prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public PrpLscheduleMainDto findByPrimaryKey(DBManager dbManager,int scheduleID,String registNo,int serialNo) throws Exception{
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        //声明DTO
        PrpLscheduleMainDto prpLscheduleMainDto = null;
        //查询数据,赋值给DTO
        prpLscheduleMainDto = dbPrpLscheduleMain.findByPrimaryKey(scheduleID, registNo, serialNo);
        return prpLscheduleMainDto;
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
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleMain.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLscheduleMain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLscheduleMainDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLscheduleMain.findByConditions(conditions);
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
        DBPrpLscheduleMain dbPrpLscheduleMain = new DBPrpLscheduleMain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleMain.getCount(conditions);
        return count;
    }
}
