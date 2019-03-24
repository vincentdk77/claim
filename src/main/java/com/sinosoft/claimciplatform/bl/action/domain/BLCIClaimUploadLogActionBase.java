package com.sinosoft.claimciplatform.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadLogDto;
import com.sinosoft.claimciplatform.resource.dtofactory.domain.DBCIClaimUploadLog;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是理赔信息上传平台日志表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadLogActionBase{
    private static Log logger = LogFactory.getLog(BLCIClaimUploadLogActionBase.class);

    /**
     * 构造函数
     */
    public BLCIClaimUploadLogActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param cIClaimUploadLogDto cIClaimUploadLogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CIClaimUploadLogDto cIClaimUploadLogDto)
            throws Exception{
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        //插入记录
        dbCIClaimUploadLog.insert(cIClaimUploadLogDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param uploadNo 上传序号
     * @param serialNo 顺序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String uploadNo,int serialNo)
            throws Exception{
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        //删除记录
        dbCIClaimUploadLog.delete(uploadNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        //按条件删除记录
        dbCIClaimUploadLog.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param cIClaimUploadLogDto cIClaimUploadLogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CIClaimUploadLogDto cIClaimUploadLogDto)
            throws Exception{
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        //更新记录
        dbCIClaimUploadLog.update(cIClaimUploadLogDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param uploadNo 上传序号
     * @param serialNo 顺序号
     * @return cIClaimUploadLogDto cIClaimUploadLogDto
     * @throws Exception
     */
    public CIClaimUploadLogDto findByPrimaryKey(DBManager dbManager,String uploadNo,int serialNo)
            throws Exception{
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        //声明DTO
        CIClaimUploadLogDto cIClaimUploadLogDto = null;
        //查询数据,赋值给DTO
        cIClaimUploadLogDto = dbCIClaimUploadLog.findByPrimaryKey(uploadNo, serialNo);
        return cIClaimUploadLogDto;
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
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimUploadLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCIClaimUploadLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含cIClaimUploadLogDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCIClaimUploadLog.findByConditions(conditions);
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
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimUploadLog.getCount(conditions);
        return count;
    }
}
