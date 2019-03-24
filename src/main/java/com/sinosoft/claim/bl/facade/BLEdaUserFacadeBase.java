package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLEdaUserAction;
import com.sinosoft.claim.dto.domain.EdaUserDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaUser-座席员信息表的业务逻辑对象Facade基类<br>
 * 创建于 2005-06-22 14:57:12.464<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaUserFacadeBase{
    private static Log logger = LogFactory.getLog(BLEdaUserFacadeBase.class);

    /**
     * 构造函数
     */
    public BLEdaUserFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param edaUserDto edaUserDto
     * @throws Exception
     */
    public void insert(EdaUserDto edaUserDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
            
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blEdaUserAction.insert(dbManager,edaUserDto);
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
     * @param edaUserCode 座席员工号
     * @throws Exception
     */
    public void delete(String edaUserCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blEdaUserAction.delete(dbManager,edaUserCode);
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
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blEdaUserAction.deleteByConditions(dbManager,conditions);
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
     * @param edaUserDto edaUserDto
     * @throws Exception
     */
    public void update(EdaUserDto edaUserDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blEdaUserAction.update(dbManager,edaUserDto);
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
     * @param edaUserCode 座席员工号
     * @return edaUserDto edaUserDto
     * @throws Exception
     */
    public EdaUserDto findByPrimaryKey(String edaUserCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        //声明DTO
        EdaUserDto edaUserDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
           
            edaUserDto = blEdaUserAction.findByPrimaryKey(dbManager,edaUserCode);
           
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return edaUserDto;
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
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blEdaUserAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含edaUserDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blEdaUserAction.findByConditions(dbManager,conditions);
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
        BLEdaUserAction blEdaUserAction = new BLEdaUserAction();
        try{
             dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blEdaUserAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
