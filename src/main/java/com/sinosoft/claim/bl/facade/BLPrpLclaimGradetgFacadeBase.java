package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimGradetgAction;
import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimGradetgDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 这是PrpLclaimGrade--理赔业务权限表(新增)的业务逻辑对象tgFacade基类<br>
 * 创建于 2005-04-19 09:24:24.500<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimGradetgFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimGradetgFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimGradetgFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLclaimGradeDto prpLclaimGradeDto
     * @throws Exception
     */
    public void insert(PrpLclaimGradetgDto prpLclaimGradetgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLclaimGradetgAction.insert(dbManager,prpLclaimGradetgDto);
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
     * @param taskCode 任务代码
     * @throws Exception
     */
    public void delete(String userCode,String taskCode,String configPara) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLclaimGradetgAction.delete(dbManager,userCode, taskCode,configPara);
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
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLclaimGradetgAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLclaimGradeDto prpLclaimGradeDto
     * @throws Exception
     */
    public void update(PrpLclaimGradetgDto prpLclaimGradetgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLclaimGradetgAction.update(dbManager,prpLclaimGradetgDto);
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
     * @param taskCode 任务代码
     * @return prpLclaimGradeDto prpLclaimGradeDto
     * @throws Exception
     */
    public PrpLclaimGradetgDto findByPrimaryKey(String userCode,String taskCode,String configPara) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        //声明DTO
        PrpLclaimGradetgDto prpLclaimGradetgDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLclaimGradetgDto = blPrpLclaimGradetgAction.findByPrimaryKey(dbManager,userCode, taskCode,configPara);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLclaimGradetgDto;
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
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLclaimGradetgAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLclaimGradeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLclaimGradetgAction.findByConditions(dbManager,conditions);
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
        BLPrpLclaimGradetgAction blPrpLclaimGradetgAction = new BLPrpLclaimGradetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLclaimGradetgAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
