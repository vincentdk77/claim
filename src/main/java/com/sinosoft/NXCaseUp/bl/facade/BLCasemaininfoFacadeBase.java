package com.sinosoft.NXCaseUp.bl.facade;

import java.util.*;

import com.sinosoft.aip.webservice.server.CaseMainInfo;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasemaininfoDto;
import com.sinosoft.NXCaseUp.bl.action.domain.BLCasemaininfoAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CASEMAININFO的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCasemaininfoFacadeBase{
    private static Logger logger = Logger.getLogger(BLCasemaininfoFacadeBase.class);

    /**
     * 构造函数
     */
    public BLCasemaininfoFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public void insert(CaseMainInfo caseMainInfo )
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //插入记录
            CasemaininfoDto casemaininfoDto = new CasemaininfoDto();
            casemaininfoDto.setComcode(caseMainInfo.getCompanyCode());
            casemaininfoDto.setPolicyno(caseMainInfo.getPolicyNumber());
            casemaininfoDto.setCaseno(caseMainInfo.getCaseNumber());
            casemaininfoDto.setClaimno(caseMainInfo.getClaimNumber());
            casemaininfoDto.setUnderwriteenddate(caseMainInfo.getAssessmentDate());
            casemaininfoDto.setEndcasedate(caseMainInfo.getSettlementDate());
            casemaininfoDto.setAsumpaid(caseMainInfo.getSetteledAmount());
            casemaininfoDto.setAsumfee(caseMainInfo.getSetteledDirectExpense());
            casemaininfoDto.setCasemoney(caseMainInfo.getClaimAmout());
            casemaininfoDto.setCasemoneyfee(caseMainInfo.getDirectExpense());
            casemaininfoDto.setPresumpaid(caseMainInfo.getPrepaidAmount());
            casemaininfoDto.setPresumfee(caseMainInfo.getPrepaidDirectExpense());
            casemaininfoDto.setDamageinsured(caseMainInfo.getSettledFamilyNumber());
            casemaininfoDto.setLossesnumber(caseMainInfo.getSettledObjectNumber());
            casemaininfoDto.setLossesunitcode(caseMainInfo.getMeasuremantUnit());
            casemaininfoDto.setReopenedtype(caseMainInfo.getReopenedType());
            casemaininfoDto.setTimes(caseMainInfo.getReopenedTimes());
            casemaininfoDto.setAffectedarea(caseMainInfo.getAffectedArea());
            casemaininfoDto.setLossarea(caseMainInfo.getLossArea());
            casemaininfoDto.setLawsuitflag(caseMainInfo.getLawsuitFlag());
            casemaininfoDto.setFarmercount(caseMainInfo.getFarmerCount());
            casemaininfoDto.setClaimcode(caseMainInfo.getClaimSequenceNo());
            casemaininfoDto.setDamagedarea(caseMainInfo.getDamagedArea());
            blCasemaininfoAction.insert(dbManager,casemaininfoDto);
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
     * @param comcode COMCODE
     * @throws Exception
     */
    public void delete(String comcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //删除记录
            blCasemaininfoAction.delete(dbManager,comcode);
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
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blCasemaininfoAction.deleteByConditions(dbManager,conditions);
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
     * @param casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public void update(CasemaininfoDto casemaininfoDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //更新记录
            blCasemaininfoAction.update(dbManager,casemaininfoDto);
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
     * @param comcode COMCODE
     * @return casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public CasemaininfoDto findByPrimaryKey(String comcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        //声明DTO
        CasemaininfoDto casemaininfoDto = null;
        try{
            dbManager.open("ddccDataSource");
            //查询数据,赋值给DTO
            casemaininfoDto = blCasemaininfoAction.findByPrimaryKey(dbManager,comcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return casemaininfoDto;
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
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            pageRecord = blCasemaininfoAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含casemaininfoDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            collection = blCasemaininfoAction.findByConditions(dbManager,conditions);
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
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            rowCount = blCasemaininfoAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
