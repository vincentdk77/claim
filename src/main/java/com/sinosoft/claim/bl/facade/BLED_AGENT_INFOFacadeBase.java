package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLED_AGENT_INFOAction;
import com.sinosoft.claim.dto.domain.ED_AGENT_INFODto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ������ϯԱ����Ϣ���ҵ���߼�����Facade����<br>
 * ������ 2005-07-19 09:59:06.511<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLED_AGENT_INFOFacadeBase{
    private static Log logger = LogFactory.getLog(BLED_AGENT_INFOFacadeBase.class);

    /**
     * ���캯��
     */
    public BLED_AGENT_INFOFacadeBase(){
    }

    /**
     * ����һ������
     * @param eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public void insert(ED_AGENT_INFODto eD_AGENT_INFODto) throws Exception{
        DBManager dbManager = new DBManager();
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            dbManager.beginTransaction();
            //�����¼
            blED_AGENT_INFOAction.insert(dbManager,eD_AGENT_INFODto);
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
     * @param aGENTID ��ϯ����
     * @throws Exception
     */
    public void delete(String aGENTID) throws Exception{
        DBManager dbManager = new DBManager();
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            dbManager.beginTransaction();
            //ɾ����¼
            blED_AGENT_INFOAction.delete(dbManager,aGENTID);
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
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            dbManager.beginTransaction();
            //������ɾ����¼
            blED_AGENT_INFOAction.deleteByConditions(dbManager,conditions);
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
     * @param eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public void update(ED_AGENT_INFODto eD_AGENT_INFODto) throws Exception{
        DBManager dbManager = new DBManager();
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            dbManager.beginTransaction();
            //���¼�¼
            blED_AGENT_INFOAction.update(dbManager,eD_AGENT_INFODto);
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
     * @param aGENTID ��ϯ����
     * @return eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public ED_AGENT_INFODto findByPrimaryKey(String aGENTID) throws Exception{
        DBManager dbManager = new DBManager();
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        //����DTO
        ED_AGENT_INFODto eD_AGENT_INFODto = null;
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            //��ѯ����,��ֵ��DTO
            eD_AGENT_INFODto = blED_AGENT_INFOAction.findByPrimaryKey(dbManager,aGENTID);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return eD_AGENT_INFODto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	 dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            pageRecord = blED_AGENT_INFOAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����eD_AGENT_INFODto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            collection = blED_AGENT_INFOAction.findByConditions(dbManager,conditions);
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
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            rowCount = blED_AGENT_INFOAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
