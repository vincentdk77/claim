package com.sinosoft.function.power.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.bl.action.domain.BLPrpUserGradeAction;
import com.sinosoft.function.power.dto.domain.PrpUserGradeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpUserGrade 员工权限表的业务逻辑对象Facade基类<br>
 * 创建于 2004-11-09 10:40:55.450<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUserGradeFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpUserGradeFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpUserGradeFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void insert(PrpUserGradeDto prpUserGradeDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //插入记录
            blPrpUserGradeAction.insert(dbManager,prpUserGradeDto);
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
     * @param userCode 员工代码
     * @param groupCode 权限组号代码
     * @param taskCode 任务代码
     * @param checkCode 权限检验代码
     * @throws Exception
     */
    public void delete(String userCode,String groupCode,String taskCode,String checkCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //删除记录
            blPrpUserGradeAction.delete(dbManager,userCode, groupCode, taskCode, checkCode);
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
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpUserGradeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void update(PrpUserGradeDto prpUserGradeDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //更新记录
            blPrpUserGradeAction.update(dbManager,prpUserGradeDto);
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
     * @param userCode 员工代码
     * @param groupCode 权限组号代码
     * @param taskCode 任务代码
     * @param checkCode 权限检验代码
     * @return prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public PrpUserGradeDto findByPrimaryKey(String userCode,String groupCode,String taskCode,String checkCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        //声明DTO
        PrpUserGradeDto prpUserGradeDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            //查询数据,赋值给DTO
            prpUserGradeDto = blPrpUserGradeAction.findByPrimaryKey(dbManager,userCode, groupCode, taskCode, checkCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpUserGradeDto;
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
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            pageRecord = blPrpUserGradeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpUserGradeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            collection = blPrpUserGradeAction.findByConditions(dbManager,conditions);
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
        BLPrpUserGradeAction blPrpUserGradeAction = new BLPrpUserGradeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            rowCount = blPrpUserGradeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
