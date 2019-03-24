package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLMidResultConfigAction;
import com.sinosoft.claim.dto.domain.MidResultConfigDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����MidResultConfig���ҳ�����ñ��ҵ���߼�����Facade����<br>
 * ������ 2005-03-11 10:51:28.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLMidResultConfigFacadeBase{
    private static Log logger = LogFactory.getLog(BLMidResultConfigFacadeBase.class);

    /**
     * ���캯��
     */
    public BLMidResultConfigFacadeBase(){
    }

    /**
     * ����һ������
     * @param midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public void insert(MidResultConfigDto midResultConfigDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
	    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //�����¼
            blMidResultConfigAction.insert(dbManager,midResultConfigDto);
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
     * @param configOwner ���ù�����
     * @param resultType ���ҳ������
     * @param itemNo ��Ŀ���
     * @throws Exception
     */
    public void delete(String configOwner,String resultType,int itemNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //ɾ����¼
            blMidResultConfigAction.delete(dbManager,configOwner, resultType, itemNo);
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
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //������ɾ����¼
            blMidResultConfigAction.deleteByConditions(dbManager,conditions);
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
     * @param midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public void update(MidResultConfigDto midResultConfigDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //���¼�¼
            blMidResultConfigAction.update(dbManager,midResultConfigDto);
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
     * @param configOwner ���ù�����
     * @param resultType ���ҳ������
     * @param itemNo ��Ŀ���
     * @return midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public MidResultConfigDto findByPrimaryKey(String configOwner,String resultType,int itemNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        //����DTO
        MidResultConfigDto midResultConfigDto = null;
        try{
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //��ѯ����,��ֵ��DTO
            midResultConfigDto = blMidResultConfigAction.findByPrimaryKey(dbManager,configOwner, resultType, itemNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return midResultConfigDto;
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
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blMidResultConfigAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����midResultConfigDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
    	     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;			
            collection = blMidResultConfigAction.findByConditions(dbManager,conditions);
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
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            rowCount = blMidResultConfigAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
