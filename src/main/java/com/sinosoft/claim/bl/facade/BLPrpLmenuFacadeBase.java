package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLmenuAction;
import com.sinosoft.claim.dto.domain.PrpLmenuDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
    
/**  
 * 这是PrpLmenu-菜单表(新增)的业务逻辑对象Facade基类<br>
 * 创建于 2005-05-08 15:15:54.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLmenuFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLmenuFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLmenuFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public void insert(PrpLmenuDto prpLmenuDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLmenuAction.insert(dbManager,prpLmenuDto);
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
     * @param funcID 菜单功能代码
     * @throws Exception
     */
    public void delete(String funcID) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLmenuAction.delete(dbManager,funcID);
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
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLmenuAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public void update(PrpLmenuDto prpLmenuDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLmenuAction.update(dbManager,prpLmenuDto);
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
     * @param funcID 菜单功能代码
     * @return prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public PrpLmenuDto findByPrimaryKey(String funcID) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        //声明DTO
        PrpLmenuDto prpLmenuDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLmenuDto = blPrpLmenuAction.findByPrimaryKey(dbManager,funcID);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLmenuDto;
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
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLmenuAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLmenuDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLmenuAction.findByConditions(dbManager,conditions);
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
        BLPrpLmenuAction blPrpLmenuAction = new BLPrpLmenuAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLmenuAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
