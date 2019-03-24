package com.sinosoft.ciplatform.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.bz.common.BZAppConfig;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.ciplatform.bl.action.domain.BLCIPlatformConfigAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CIPlatformConfig的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIPlatformConfigFacadeBase{
    private static Logger logger = Logger.getLogger(BLCIPlatformConfigFacadeBase.class);

    /**
     * 构造函数
     */
    public BLCIPlatformConfigFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param cIPlatformConfigDto cIPlatformConfigDto
     * @throws Exception
     */
    public void insert(CIPlatformConfigDto cIPlatformConfigDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIPlatformConfigAction blCIPlatformConfigAction = new BLCIPlatformConfigAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blCIPlatformConfigAction.insert(dbManager,cIPlatformConfigDto);
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
     * @param configCode configCode
     * @param comCode comCode
     * @param riskCode riskCode
     * @throws Exception
     */
    public void delete(String configCode,String comCode,String riskCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIPlatformConfigAction blCIPlatformConfigAction = new BLCIPlatformConfigAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blCIPlatformConfigAction.delete(dbManager,configCode, comCode, riskCode);
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
        BLCIPlatformConfigAction blCIPlatformConfigAction = new BLCIPlatformConfigAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blCIPlatformConfigAction.deleteByConditions(dbManager,conditions);
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
     * @param cIPlatformConfigDto cIPlatformConfigDto
     * @throws Exception
     */
    public void update(CIPlatformConfigDto cIPlatformConfigDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIPlatformConfigAction blCIPlatformConfigAction = new BLCIPlatformConfigAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blCIPlatformConfigAction.update(dbManager,cIPlatformConfigDto);
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
     * @param configCode configCode
     * @param comCode comCode
     * @param riskCode riskCode
     * @return cIPlatformConfigDto cIPlatformConfigDto
     * @throws Exception
     */
    public CIPlatformConfigDto findByPrimaryKey(String configCode,String comCode,String riskCode)
        throws Exception{
        String str = "";        
        if("34".equals(comCode)||"00".equals(comCode)){
        	str ="AH";
        }else if("41".equals(comCode)){
        	str ="HN";
        }else if("42".equals(comCode)){
        	str ="HB";
        }else if("52".equals(comCode)){
        	str ="GZ";
        }
        String riskCodeBusiness =AppConfig.get("ciplatform."+str+"Riskcode");
        if(riskCodeBusiness==null)
        {
        	return null;
        }
        if("0506,0546,0556".indexOf(riskCode)>-1)
        {
        	
        }else{
        	return null;
        }
        CIPlatformConfigDto cIPlatformConfigDto = new CIPlatformConfigDto();

        try{
        	cIPlatformConfigDto.setVersion(AppConfig.get("ciplatform."+str+"Version"));
          	cIPlatformConfigDto.setUrl(AppConfig.get("ciplatform."+str+"Url"));
        	cIPlatformConfigDto.setPwd(AppConfig.get("ciplatform."+str+"Pwd"));
        	cIPlatformConfigDto.setUserName(AppConfig.get("ciplatform."+str+"User"));
			cIPlatformConfigDto.setComCode(AppConfig.get("ciplatform."+str+"ComCode"));
			cIPlatformConfigDto.setRiskCode(AppConfig.get("ciplatform."+str+"Riskcode"));
        	cIPlatformConfigDto.setConfigValue("0");
        	cIPlatformConfigDto.setValidStatus("1");        	
        }catch(Exception exception){
            throw exception;
        }finally{
        }
        return cIPlatformConfigDto;
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
        BLCIPlatformConfigAction blCIPlatformConfigAction = new BLCIPlatformConfigAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blCIPlatformConfigAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含cIPlatformConfigDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCIPlatformConfigAction blCIPlatformConfigAction = new BLCIPlatformConfigAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blCIPlatformConfigAction.findByConditions(dbManager,conditions);
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
        BLCIPlatformConfigAction blCIPlatformConfigAction = new BLCIPlatformConfigAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blCIPlatformConfigAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
