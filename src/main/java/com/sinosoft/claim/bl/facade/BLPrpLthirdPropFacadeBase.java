package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLthirdPropAction;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLthirdProp-财产损失部位表的业务逻辑对象Facade基类<br>
 * 创建于 2005-04-12 11:37:54.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdPropFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdPropFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLthirdPropFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLthirdPropDto prpLthirdPropDto
     * @throws Exception
     */
    public void insert(PrpLthirdPropDto prpLthirdPropDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //插入记录
            blPrpLthirdPropAction.insert(dbManager,prpLthirdPropDto);
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
     * @param registNo 报案号码
     * @param serialNo 损失项目序号
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //删除记录
            blPrpLthirdPropAction.delete(dbManager,registNo, serialNo);
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
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLthirdPropAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLthirdPropDto prpLthirdPropDto
     * @throws Exception
     */
    public void update(PrpLthirdPropDto prpLthirdPropDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //更新记录
            blPrpLthirdPropAction.update(dbManager,prpLthirdPropDto);
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
     * @param registNo 报案号码
     * @param serialNo 损失项目序号
     * @return prpLthirdPropDto prpLthirdPropDto
     * @throws Exception
     */
    public PrpLthirdPropDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        //声明DTO
        PrpLthirdPropDto prpLthirdPropDto = null;
        try{
            dbManager.open("claimDataSource");
            //查询数据,赋值给DTO
            prpLthirdPropDto = blPrpLthirdPropAction.findByPrimaryKey(dbManager,registNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLthirdPropDto;
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
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpLthirdPropAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLthirdPropDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpLthirdPropAction.findByConditions(dbManager,conditions);
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
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpLthirdPropAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
