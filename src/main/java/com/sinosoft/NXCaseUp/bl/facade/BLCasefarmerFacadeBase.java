package com.sinosoft.NXCaseUp.bl.facade;

import java.util.*;

import com.sinosoft.aip.webservice.server.CaseDto;
import com.sinosoft.aip.webservice.server.ClaimFarmerInfo;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasefarmerDto;
import com.sinosoft.NXCaseUp.bl.action.domain.BLCasefarmerAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CASEFARMER的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCasefarmerFacadeBase{
    private static Logger logger = Logger.getLogger(BLCasefarmerFacadeBase.class);

    /**
     * 构造函数
     */
    public BLCasefarmerFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param casefarmerDto casefarmerDto
     * @throws Exception
     */
    public void insert(CaseDto caseDto )
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        ClaimFarmerInfo claimFarmerInfo = null;
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            for(int i=0; i<caseDto.getFarmerInfoList().length; i++){
            	claimFarmerInfo = caseDto.getFarmerInfoList()[i];
            	 //插入记录
            	CasefarmerDto casefarmerDto = new CasefarmerDto();
                casefarmerDto.setFarmername(claimFarmerInfo.getFarmerName());
                casefarmerDto.setFarmeridnumber(claimFarmerInfo.getFarmerIDNumber());
                casefarmerDto.setFarmerphone(claimFarmerInfo.getFarmerTelephone());
                casefarmerDto.setInsureobiectnumber(claimFarmerInfo.getInsuredObjectNumber());
                casefarmerDto.setLossdegree(claimFarmerInfo.getLossDegree());
                casefarmerDto.setSettleamount(claimFarmerInfo.getSettledAmount());
                casefarmerDto.setSettlesumamount(claimFarmerInfo.getSettledSumAmount());
                casefarmerDto.setSerino(claimFarmerInfo.getSerialNo());
                casefarmerDto.setAffectedarea(claimFarmerInfo.getAffectedArea());
                casefarmerDto.setDamagedarea(claimFarmerInfo.getDamagedArea());
                casefarmerDto.setLossarea(claimFarmerInfo.getLossArea());
                casefarmerDto.setMeasuremantunit(claimFarmerInfo.getMeasuremantUnit());
                casefarmerDto.setCaseno(claimFarmerInfo.getCaseNumber());
                casefarmerDto.setFarmeridtype(claimFarmerInfo.getFarmerIDType());
                casefarmerDto.setSettleobjectnumber(claimFarmerInfo.getSettledObjectNumber());
                casefarmerDto.setPrepaidamount(claimFarmerInfo.getPrepaidAmount());
                blCasefarmerAction.insert(dbManager,casefarmerDto);
            }
           
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
     * @param farmername FARMERNAME
     * @throws Exception
     */
    public void delete(String farmername)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //删除记录
            blCasefarmerAction.delete(dbManager,farmername);
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
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blCasefarmerAction.deleteByConditions(dbManager,conditions);
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
     * @param casefarmerDto casefarmerDto
     * @throws Exception
     */
    public void update(CasefarmerDto casefarmerDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //更新记录
            blCasefarmerAction.update(dbManager,casefarmerDto);
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
     * @param farmername FARMERNAME
     * @return casefarmerDto casefarmerDto
     * @throws Exception
     */
    public CasefarmerDto findByPrimaryKey(String farmername)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        //声明DTO
        CasefarmerDto casefarmerDto = null;
        try{
            dbManager.open("ddccDataSource");
            //查询数据,赋值给DTO
            casefarmerDto = blCasefarmerAction.findByPrimaryKey(dbManager,farmername);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return casefarmerDto;
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
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        try{
            dbManager.open("ddccDataSource");
            pageRecord = blCasefarmerAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含casefarmerDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        try{
            dbManager.open("ddccDataSource");
            collection = blCasefarmerAction.findByConditions(dbManager,conditions);
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
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        try{
            dbManager.open("ddccDataSource");
            rowCount = blCasefarmerAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
