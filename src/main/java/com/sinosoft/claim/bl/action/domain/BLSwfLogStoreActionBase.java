package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfLogStoreDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLogStore;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是SwfLogStore的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSwfLogStoreActionBase{
    private static Log logger = LogFactory.getLog(BLSwfLogStoreActionBase.class);

    /**
     * 构造函数
     */
    public BLSwfLogStoreActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param swfLogStoreDto swfLogStoreDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfLogStoreDto swfLogStoreDto)
            throws Exception{
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        //插入记录
        dbSwfLogStore.insert(swfLogStoreDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param flowID flowID
     * @throws Exception
     */
    public void delete(DBManager dbManager,String flowID)
            throws Exception{
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        //删除记录
        dbSwfLogStore.delete(flowID);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        //按条件删除记录
        dbSwfLogStore.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param swfLogStoreDto swfLogStoreDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfLogStoreDto swfLogStoreDto)
            throws Exception{
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        //更新记录
        dbSwfLogStore.update(swfLogStoreDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param flowID flowID
     * @return swfLogStoreDto swfLogStoreDto
     * @throws Exception
     */
    public SwfLogStoreDto findByPrimaryKey(DBManager dbManager,String flowID,int logNo)
            throws Exception{
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        //声明DTO
        SwfLogStoreDto swfLogStoreDto = null;
        //查询数据,赋值给DTO
        swfLogStoreDto = dbSwfLogStore.findByPrimaryKey(flowID,logNo);
        return swfLogStoreDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfLogStore.getCount(SqlUtils.getWherePartForGetCount(conditions));
        int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig
				.get("sysconst.MaxQueryCount")));

        if (maxQueryCount != 0 && count > maxQueryCount) {
			throw new UserException(1, 3, "0000", "查询结果个数超过系统限制");
		}
        collection = dbSwfLogStore.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含swfLogStoreDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfLogStore.findByConditions(conditions);
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
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfLogStore.getCount(conditions);
        return count;
    }
}
