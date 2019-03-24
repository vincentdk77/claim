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
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CIPlatformConfig��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIPlatformConfigFacadeBase{
    private static Logger logger = Logger.getLogger(BLCIPlatformConfigFacadeBase.class);

    /**
     * ���캯��
     */
    public BLCIPlatformConfigFacadeBase(){
    }

    /**
     * ����һ������
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
            //�����¼
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
     * ������ɾ��һ������
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
            //ɾ����¼
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
     * ������ɾ������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIPlatformConfigAction blCIPlatformConfigAction = new BLCIPlatformConfigAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
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
     * ����������һ������(���������޷����)
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
            //���¼�¼
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
     * ����������һ������
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
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
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
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection ����cIPlatformConfigDto�ļ���
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
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
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
