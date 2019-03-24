package com.sinosoft.claimprop.common.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropUploadLogDto;
import com.sinosoft.claimprop.common.bl.action.domain.BLCiClaimPropUploadLogAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CiClaimPropUploadLog的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimPropUploadLogFacadeBase{
    private static Logger logger = Logger.getLogger(BLCiClaimPropUploadLogFacadeBase.class);

    /**
     * 构造函数
     */
    public BLCiClaimPropUploadLogFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public void insert(CiClaimPropUploadLogDto ciClaimPropUploadLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //插入记录
            blCiClaimPropUploadLogAction.insert(dbManager,ciClaimPropUploadLogDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键删除一条数据
     * @param businessNo businessNo
     * @throws Exception
     */
    public void delete(String businessNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //删除记录
            blCiClaimPropUploadLogAction.delete(dbManager,businessNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按条件删除数据
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blCiClaimPropUploadLogAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public void update(CiClaimPropUploadLogDto ciClaimPropUploadLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //更新记录
            blCiClaimPropUploadLogAction.update(dbManager,ciClaimPropUploadLogDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键查找一条数据
     * @param businessNo businessNo
     * @return ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public CiClaimPropUploadLogDto findByPrimaryKey(String businessNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        //声明DTO
        CiClaimPropUploadLogDto ciClaimPropUploadLogDto = null;
        try{
            dbManager.open("daaplatformDataSource");
            //查询数据,赋值给DTO
            ciClaimPropUploadLogDto = blCiClaimPropUploadLogAction.findByPrimaryKey(dbManager,businessNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return ciClaimPropUploadLogDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            pageRecord = blCiClaimPropUploadLogAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection 包含ciClaimPropUploadLogDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            collection = blCiClaimPropUploadLogAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCiClaimPropUploadLogAction blCiClaimPropUploadLogAction = new BLCiClaimPropUploadLogAction();
        try{
            dbManager.open("daaplatformDataSource");
            rowCount = blCiClaimPropUploadLogAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
