package com.sinosoft.claimzy.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claimzy.bl.action.domain.BLAgriClaimDemandAction;
import com.sinosoft.claimzy.bl.action.domain.BLAgriClaimUploadLogAction;
import com.sinosoft.claimzy.dto.domain.AgriClaimDemandDto;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLAgriDemandFacadeBase {
	 private static Logger logger = Logger.getLogger(BLAgriDemandFacadeBase.class);

	    /**
	     * ���캯��
	     */
	    public BLAgriDemandFacadeBase(){
	    }

	    /**
	     * ����һ������
	     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
	     * @throws Exception
	     */
	    public void insert(AgriClaimDemandDto agriClaimDemandDto)
	        throws Exception{
	        DBManager dbManager = new DBManager();
	        BLAgriClaimDemandAction blAgriClaimDemandAction = new BLAgriClaimDemandAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            dbManager.beginTransaction();
	            //�����¼
	            blAgriClaimDemandAction.insert(dbManager,agriClaimDemandDto);
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
	     * @param claimCode �������
	     * @throws Exception
	     */
	    public void delete(String batchNo)
	        throws Exception{
	        DBManager dbManager = new DBManager();
	        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            dbManager.beginTransaction();
	            //ɾ����¼
	            blAgriClaimUploadLogAction.delete(dbManager,batchNo);
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
	        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            dbManager.beginTransaction();
	            //������ɾ����¼
	            blAgriClaimUploadLogAction.deleteByConditions(dbManager,conditions);
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
	     * @param AgriClaimDemandDto AgriClaimDemandDto
	     * @throws Exception
	     */
	    public void update(AgriClaimDemandDto AgriClaimDemandDto)
	        throws Exception{
	        DBManager dbManager = new DBManager();
	        BLAgriClaimDemandAction blAgriClaimDemandAction = new BLAgriClaimDemandAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            dbManager.beginTransaction();
	            //���¼�¼
	            blAgriClaimDemandAction.update(dbManager,AgriClaimDemandDto);
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
	     * @param claimCode �������
	     * @return AgriClaimDemandDto AgriClaimDemandDto
	     * @throws Exception
	     */
	    public AgriClaimDemandDto findByPrimaryKey(String batchNo)
	        throws Exception{
	        DBManager dbManager = new DBManager();
	        BLAgriClaimDemandAction blAgriClaimDemandAction = new BLAgriClaimDemandAction();
	        //����DTO
	        AgriClaimDemandDto agriClaimDemandDto = null;
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            //��ѯ����,��ֵ��DTO
	            agriClaimDemandDto = blAgriClaimDemandAction.findByPrimaryKey(dbManager,batchNo);
	        }catch(Exception exception){
	            throw exception;
	        }finally{
	            dbManager.close();
	        }
	        return agriClaimDemandDto;
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
	        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            pageRecord = blAgriClaimUploadLogAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
	     * @return Collection ����AgriClaimDemandDto�ļ���
	     * @throws Exception
	     */
	    public Collection findByConditions(String conditions)
	        throws Exception{
	        Collection collection = new ArrayList();

	        if(conditions.trim().length()==0){
	            conditions = "1=1";
	        }

	        DBManager dbManager = new DBManager();
	        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            collection = blAgriClaimUploadLogAction.findByConditions(dbManager,conditions);
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
	        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            rowCount = blAgriClaimUploadLogAction.getCount(dbManager,conditions);
	        }catch(Exception exception){
	            throw exception;
	        }finally{
	            dbManager.close();
	        }
	        return rowCount;
	    }
}
