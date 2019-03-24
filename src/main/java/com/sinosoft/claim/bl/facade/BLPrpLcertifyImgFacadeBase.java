package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcertifyImgAction;
import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertifyImg-理赔图片上传路径的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-23 16:36:59.781<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcertifyImgFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyImgFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcertifyImgFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLcertifyImgDto prpLcertifyImgDto
     * @throws Exception
     */
    public void insert(PrpLcertifyImgDto prpLcertifyImgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyImgAction blPrpLcertifyImgAction = new BLPrpLcertifyImgAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //插入记录
            blPrpLcertifyImgAction.insert(dbManager,prpLcertifyImgDto);
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
     * @param businessNo 业务号码
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @throws Exception
     */
    public void delete(String businessNo,int serialNo,String lossItemCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyImgAction blPrpLcertifyImgAction = new BLPrpLcertifyImgAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //删除记录
            blPrpLcertifyImgAction.delete(dbManager,businessNo, serialNo, lossItemCode);
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
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyImgAction blPrpLcertifyImgAction = new BLPrpLcertifyImgAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLcertifyImgAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcertifyImgDto prpLcertifyImgDto
     * @throws Exception
     */
    public void update(PrpLcertifyImgDto prpLcertifyImgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyImgAction blPrpLcertifyImgAction = new BLPrpLcertifyImgAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //更新记录
            blPrpLcertifyImgAction.update(dbManager,prpLcertifyImgDto);
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
     * @param businessNo 业务号码
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @return prpLcertifyImgDto prpLcertifyImgDto
     * @throws Exception
     */
    public PrpLcertifyImgDto findByPrimaryKey(String businessNo,int serialNo,String lossItemCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyImgAction blPrpLcertifyImgAction = new BLPrpLcertifyImgAction();
        //声明DTO
        PrpLcertifyImgDto prpLcertifyImgDto = null;
        try{
            dbManager.open("claimDataSource");
            //查询数据,赋值给DTO
            prpLcertifyImgDto = blPrpLcertifyImgAction.findByPrimaryKey(dbManager,businessNo, serialNo, lossItemCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcertifyImgDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcertifyImgAction blPrpLcertifyImgAction = new BLPrpLcertifyImgAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpLcertifyImgAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLcertifyImgDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcertifyImgAction blPrpLcertifyImgAction = new BLPrpLcertifyImgAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpLcertifyImgAction.findByConditions(dbManager,conditions);
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
        BLPrpLcertifyImgAction blPrpLcertifyImgAction = new BLPrpLcertifyImgAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpLcertifyImgAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
