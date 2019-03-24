package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleMainWF;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleMainWF的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.328<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleMainWFActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleMainWFActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLscheduleMainWFActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLscheduleMainWFDto prpLscheduleMainWFDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLscheduleMainWFDto prpLscheduleMainWFDto) throws Exception{
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        //插入记录
        dbPrpLscheduleMainWF.insert(prpLscheduleMainWFDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,int scheduleID,String registNo) throws Exception{
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        //删除记录
        dbPrpLscheduleMainWF.delete(scheduleID, registNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        //按条件删除记录
        dbPrpLscheduleMainWF.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLscheduleMainWFDto prpLscheduleMainWFDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLscheduleMainWFDto prpLscheduleMainWFDto) throws Exception{
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        //更新记录
        dbPrpLscheduleMainWF.update(prpLscheduleMainWFDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @return prpLscheduleMainWFDto prpLscheduleMainWFDto
     * @throws Exception
     */
    public PrpLscheduleMainWFDto findByPrimaryKey(DBManager dbManager,int scheduleID,String registNo) throws Exception{
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        //声明DTO
        PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
        //查询数据,赋值给DTO
        prpLscheduleMainWFDto = dbPrpLscheduleMainWF.findByPrimaryKey(scheduleID, registNo);
        return prpLscheduleMainWFDto;
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
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
            
        }
        //modify by zhaolu 20060802 zhaolu start
        int count = dbPrpLscheduleMainWF.getCount(SqlUtils.getWherePartForGetCount(conditions));
        int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
        if(maxQueryCount!=0&&count>maxQueryCount){   
          throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
        }
        //modify by zhaolu 20060802 zhaolu end
        collection = dbPrpLscheduleMainWF.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLscheduleMainWFDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLscheduleMainWF.findByConditions(conditions);
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
        DBPrpLscheduleMainWF dbPrpLscheduleMainWF = new DBPrpLscheduleMainWF(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleMainWF.getCount(conditions);
        return count;
    }
}
