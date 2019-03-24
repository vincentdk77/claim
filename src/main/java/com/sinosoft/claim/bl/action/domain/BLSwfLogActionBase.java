package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLog;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLogStore;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfLog-工作流日志表（新增）的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.281<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfLogActionBase{
    private static Log logger = LogFactory.getLog(BLSwfLogActionBase.class);

    /**
     * 构造函数
     */
    public BLSwfLogActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param swfLogDto swfLogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfLogDto swfLogDto) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        //插入记录
        dbSwfLog.insert(swfLogDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param flowID 流程编号
     * @param logNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String flowID,int logNo) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        //删除记录
        dbSwfLog.delete(flowID, logNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        //按条件删除记录
        dbSwfLog.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param swfLogDto swfLogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfLogDto swfLogDto) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        //更新记录
        dbSwfLog.update(swfLogDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param flowID 流程编号
     * @param logNo 序号
     * @return swfLogDto swfLogDto
     * @throws Exception
     */
    public SwfLogDto findByPrimaryKey(DBManager dbManager,String flowID,int logNo) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        //声明DTO
        SwfLogDto swfLogDto = null;
        //查询数据,赋值给DTO
        swfLogDto = dbSwfLog.findByPrimaryKey(flowID, logNo);
        return swfLogDto;
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
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig
				.get("sysconst.MaxQueryCount")));

        if (maxQueryCount != 0 && count > maxQueryCount) {
			throw new UserException(1, 3, "0000", "查询结果个数超过系统限制");
		}
        collection = dbSwfLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
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
    public PageRecord findAllStatusByConditions(DBManager dbManager,String swflogConditions,String swflogStoreCondition,int pageNo,int rowsPerPage) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        Collection collection = new ArrayList();

        if(swflogConditions.trim().length()==0){
        	swflogConditions = "1=1";
        }
        if(swflogStoreCondition.trim().length()==0){
        	swflogStoreCondition = "1=1";
        }
        int count = dbSwfLog.getCount(SqlUtils.getWherePartForGetCount(swflogConditions));
        count += dbSwfLogStore.getCount(SqlUtils.getWherePartForGetCount(swflogStoreCondition));
        int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig
				.get("sysconst.MaxQueryCount")));

        if (maxQueryCount != 0 && count > maxQueryCount) {
			throw new UserException(1, 3, "0000", "查询结果个数超过系统限制");
		}
        collection = dbSwfLog.findAllStatusByConditions(swflogConditions,swflogStoreCondition,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含swfLogDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfLog.findByConditions(conditions);
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
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfLog.getCount(conditions);
        return count;
    }
}
