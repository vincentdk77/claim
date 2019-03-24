package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.bl.action.domain.BLHerdpolicylistAction;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.dto.domain.PlantingpolicylistDto;

/**
 * 这是HERDPOLICYLIST的业务对象Facade类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLHerdpolicylistFacade extends BLHerdpolicylistFacadeBase{
    private static Logger logger = Logger.getLogger(BLHerdpolicylistFacade.class);

    /**
     * 构造函数
     */
    public BLHerdpolicylistFacade(){
        super();
    }
        /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findEarByConditions1(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        //DBManager dbManager1 = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            //dbManager1.open("ddccDataSource");
            
            pageRecord = blHerdpolicylistAction.findEarByConditions(dbManager,conditions,pageNo,rowsPerPage,"22","22");
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
            //dbManager1.close();
        }
        return pageRecord;
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findEarByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blHerdpolicylistAction.findEarByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    public PlantingpolicylistDto evaluateHerdToplanting(HerdpolicylistDto herdPolicyListDto,String riskcode)
    {
    	PlantingpolicylistDto plantingpolicylistDto = new PlantingpolicylistDto();
    	plantingpolicylistDto.setInusrelistcode(herdPolicyListDto.getInusrelistcode());
    	plantingpolicylistDto.setFcode(herdPolicyListDto.getFcode());
    	plantingpolicylistDto.setKindcode(herdPolicyListDto.getKindcode());
    	plantingpolicylistDto.setInsurearea(herdPolicyListDto.getAreaNumber());
    	plantingpolicylistDto.setZhibuka(herdPolicyListDto.getBankcard());
    	plantingpolicylistDto.setFname(herdPolicyListDto.getFname());
    	plantingpolicylistDto.setFidcard(herdPolicyListDto.getFidcard());
    	plantingpolicylistDto.setIndexcode(herdPolicyListDto.getIndexcode());
    	plantingpolicylistDto.setPhone(herdPolicyListDto.getPhone());
    	plantingpolicylistDto.setBank(herdPolicyListDto.getBank());
    	plantingpolicylistDto.setLitterArea(herdPolicyListDto.getLitterArea());
    	plantingpolicylistDto.setRiskcode(riskcode);
    	plantingpolicylistDto.setAmount(herdPolicyListDto.getAmount());
    	plantingpolicylistDto.setRate(herdPolicyListDto.getRate());
    	plantingpolicylistDto.setShortrate(herdPolicyListDto.getShortrate());
    	plantingpolicylistDto.setShortrateflag(herdPolicyListDto.getShortrateflag());
    	plantingpolicylistDto.setSumamount(herdPolicyListDto.getSumamount());
    	plantingpolicylistDto.setSumpremium(herdPolicyListDto.getSumpremium());
    	plantingpolicylistDto.setStartdate(herdPolicyListDto.getStartdate());
    	plantingpolicylistDto.setEnddate(herdPolicyListDto.getEnddate());
    	plantingpolicylistDto.setCalculateflag(herdPolicyListDto.getCalculateflag());
    	plantingpolicylistDto.setOpcode(herdPolicyListDto.getOpcode());
    	plantingpolicylistDto.setValidity(herdPolicyListDto.getValidity());
    	plantingpolicylistDto.setRemark(herdPolicyListDto.getRemark());
    	plantingpolicylistDto.setAtarea(herdPolicyListDto.getBreedingareaname());
    	System.err.println("getBreedingareaname:"+herdPolicyListDto.getBreedingareaname());
    	
    	
    	return plantingpolicylistDto;
    	
    }
//    public HerdpolicylistDto evaluatePlantingToherd(PlantingpolicylistDto plantingpolicylistDto ,String riskcode)
//    {
//    	HerdpolicylistDto herdPolicyListDto = new HerdpolicylistDto();
//    	herdPolicyListDto.setInusrelistcode(herdPolicyListDto.getInusrelistcode());
//    	herdPolicyListDto.setFcode(herdPolicyListDto.getFcode());
//    	herdPolicyListDto.setKindcode(herdPolicyListDto.getKindcode());
//    	herdPolicyListDto.setInsurearea(herdPolicyListDto.getAreaNumber());
//    	herdPolicyListDto.setZhibuka(herdPolicyListDto.getBankcard());
//    	herdPolicyListDto.setFname(herdPolicyListDto.getFname());
//    	herdPolicyListDto.setFidcard(herdPolicyListDto.getFidcard());
//    	herdPolicyListDto.setIndexcode(herdPolicyListDto.getIndexcode());
//    	herdPolicyListDto.setPhone(herdPolicyListDto.getPhone());
//    	herdPolicyListDto.setBank(herdPolicyListDto.getBank());
//    	herdPolicyListDto.setLitterArea(herdPolicyListDto.getLitterArea());
//    	herdPolicyListDto.setRiskcode(riskcode);
//    	herdPolicyListDto.setAmount(herdPolicyListDto.getAmount());
//    	herdPolicyListDto.setRate(herdPolicyListDto.getRate());
//    	herdPolicyListDto.setShortrate(herdPolicyListDto.getShortrate());
//    	herdPolicyListDto.setShortrateflag(herdPolicyListDto.getShortrateflag());
//    	herdPolicyListDto.setSumamount(herdPolicyListDto.getSumamount());
//    	herdPolicyListDto.setSumpremium(herdPolicyListDto.getSumpremium());
//    	herdPolicyListDto.setStartdate(herdPolicyListDto.getStartdate());
//    	herdPolicyListDto.setEnddate(herdPolicyListDto.getEnddate());
//    	herdPolicyListDto.setCalculateflag(herdPolicyListDto.getCalculateflag());
//    	herdPolicyListDto.setOpcode(herdPolicyListDto.getOpcode());
//    	herdPolicyListDto.setValidity(herdPolicyListDto.getValidity());
//    	herdPolicyListDto.setRemark(herdPolicyListDto.getRemark());
//    	herdPolicyListDto.setAtarea(herdPolicyListDto.getBreedingareaname());
//    	System.err.println("getBreedingareaname:"+herdPolicyListDto.getBreedingareaname());
//    	
//    	
//    	return plantingpolicylistDto;
//    	
//    }
    /**
     * 新农险按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     * 
     */
    public PageRecord findNewAgriEarByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blHerdpolicylistAction.findNEWEarByConditions(dbManager,conditions,pageNo,rowsPerPage,"22","22");
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
            //dbManager1.close();
        }
        return pageRecord;
    }
}
