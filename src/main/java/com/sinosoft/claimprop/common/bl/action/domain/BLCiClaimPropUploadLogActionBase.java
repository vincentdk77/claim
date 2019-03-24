package com.sinosoft.claimprop.common.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropUploadLogDto;
import com.sinosoft.claimprop.common.resource.dtofactory.domain.DBCiClaimPropUploadLog;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CiClaimPropUploadLog的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimPropUploadLogActionBase{
    private static Logger logger = Logger.getLogger(BLCiClaimPropUploadLogActionBase.class);

    /**
     * 构造函数
     */
    public BLCiClaimPropUploadLogActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CiClaimPropUploadLogDto ciClaimPropUploadLogDto)
            throws Exception{
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        //插入记录
        dbCiClaimPropUploadLog.insert(ciClaimPropUploadLogDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param businessNo businessNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessNo)
            throws Exception{
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        //删除记录
        dbCiClaimPropUploadLog.delete(businessNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        //按条件删除记录
        dbCiClaimPropUploadLog.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CiClaimPropUploadLogDto ciClaimPropUploadLogDto)
            throws Exception{
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        //更新记录
        dbCiClaimPropUploadLog.update(ciClaimPropUploadLogDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param businessNo businessNo
     * @return ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public CiClaimPropUploadLogDto findByPrimaryKey(DBManager dbManager,String businessNo)
            throws Exception{
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        //声明DTO
        CiClaimPropUploadLogDto ciClaimPropUploadLogDto = null;
        //查询数据,赋值给DTO
        ciClaimPropUploadLogDto = dbCiClaimPropUploadLog.findByPrimaryKey(businessNo);
        return ciClaimPropUploadLogDto;
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
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimPropUploadLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCiClaimPropUploadLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含ciClaimPropUploadLogDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCiClaimPropUploadLog.findByConditions(conditions);
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
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimPropUploadLog.getCount(conditions);
        return count;
    }
}
