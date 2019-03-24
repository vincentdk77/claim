package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpDpersonFeeCodeRiskAction;
import com.sinosoft.claim.dto.domain.PrpDpersonFeeCodeRiskDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpDpersonFeeCodeRisk-人伤费用险种对照表的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDpersonFeeCodeRiskFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDpersonFeeCodeRiskFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpDpersonFeeCodeRiskFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public void insert(PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpDpersonFeeCodeRiskAction.insert(dbManager,prpDpersonFeeCodeRiskDto);
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
     * @param riskCode 险种代码
     * @param feeCode 费用代码
     * @throws Exception
     */
    public void delete(String riskCode,String feeCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpDpersonFeeCodeRiskAction.delete(dbManager,riskCode, feeCode);
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
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpDpersonFeeCodeRiskAction.deleteByConditions(dbManager,conditions);
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
     * @param prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public void update(PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpDpersonFeeCodeRiskAction.update(dbManager,prpDpersonFeeCodeRiskDto);
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
     * @param riskCode 险种代码
     * @param feeCode 费用代码
     * @return prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public PrpDpersonFeeCodeRiskDto findByPrimaryKey(String riskCode,String feeCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        //声明DTO
        PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpDpersonFeeCodeRiskDto = blPrpDpersonFeeCodeRiskAction.findByPrimaryKey(dbManager,riskCode, feeCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDpersonFeeCodeRiskDto;
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
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpDpersonFeeCodeRiskAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpDpersonFeeCodeRiskDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpDpersonFeeCodeRiskAction.findByConditions(dbManager,conditions);
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
        BLPrpDpersonFeeCodeRiskAction blPrpDpersonFeeCodeRiskAction = new BLPrpDpersonFeeCodeRiskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpDpersonFeeCodeRiskAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
