package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLbackVisitTextAction;
import com.sinosoft.claim.dto.domain.PrpLbackVisitTextDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 这是PrpLbackVisitText--回访备注表的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-23 09:00:40.750<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitTextFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitTextFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLbackVisitTextFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public void insert(PrpLbackVisitTextDto prpLbackVisitTextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLbackVisitTextAction.insert(dbManager,prpLbackVisitTextDto);
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
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @param lineNo 行序号
     * @throws Exception
     */
    public void delete(int backVisitID,String registNo,String backVisitType,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLbackVisitTextAction.delete(dbManager,backVisitID, registNo, backVisitType, lineNo);
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
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLbackVisitTextAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public void update(PrpLbackVisitTextDto prpLbackVisitTextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLbackVisitTextAction.update(dbManager,prpLbackVisitTextDto);
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
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @param lineNo 行序号
     * @return prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public PrpLbackVisitTextDto findByPrimaryKey(int backVisitID,String registNo,String backVisitType,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        //声明DTO
        PrpLbackVisitTextDto prpLbackVisitTextDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLbackVisitTextDto = blPrpLbackVisitTextAction.findByPrimaryKey(dbManager,backVisitID, registNo, backVisitType, lineNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLbackVisitTextDto;
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
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLbackVisitTextAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLbackVisitTextDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLbackVisitTextAction.findByConditions(dbManager,conditions);
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
        BLPrpLbackVisitTextAction blPrpLbackVisitTextAction = new BLPrpLbackVisitTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLbackVisitTextAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
