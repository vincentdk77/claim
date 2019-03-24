package com.sinosoft.ciplatform.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.ciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBCIClaimUploadRegist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是理赔信息平台上传注册表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadRegistActionBase{
    private static Logger logger = Logger.getLogger(BLCIClaimUploadRegistActionBase.class);

    /**
     * 构造函数
     */
    public BLCIClaimUploadRegistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CIClaimUploadRegistDto cIClaimUploadRegistDto)
            throws Exception{
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        //插入记录
        dbCIClaimUploadRegist.insert(cIClaimUploadRegistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param uploadNo 上传序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String uploadNo)
            throws Exception{
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        //删除记录
        dbCIClaimUploadRegist.delete(uploadNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        //按条件删除记录
        dbCIClaimUploadRegist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CIClaimUploadRegistDto cIClaimUploadRegistDto)
            throws Exception{
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        //更新记录
        dbCIClaimUploadRegist.update(cIClaimUploadRegistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param uploadNo 上传序号
     * @return cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @throws Exception
     */
    public CIClaimUploadRegistDto findByPrimaryKey(DBManager dbManager,String uploadNo)
            throws Exception{
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        //声明DTO
        CIClaimUploadRegistDto cIClaimUploadRegistDto = null;
        //查询数据,赋值给DTO
        cIClaimUploadRegistDto = dbCIClaimUploadRegist.findByPrimaryKey(uploadNo);
        return cIClaimUploadRegistDto;
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
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimUploadRegist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCIClaimUploadRegist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含cIClaimUploadRegistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCIClaimUploadRegist.findByConditions(conditions);
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
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimUploadRegist.getCount(conditions);
        return count;
    }
}
