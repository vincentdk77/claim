package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAgentAction;
import com.sinosoft.claim.dto.domain.PrpLclaimAgentDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimAgent-�����Ᵽ����Ϣ���ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.609<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimAgentFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimAgentFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimAgentFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLclaimAgentDto prpLclaimAgentDto
     * @throws Exception
     */
    public void insert(PrpLclaimAgentDto prpLclaimAgentDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimAgentAction blPrpLclaimAgentAction = new BLPrpLclaimAgentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLclaimAgentAction.insert(dbManager,prpLclaimAgentDto);
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
     * @param claimNo �ⰸ��
     * @throws Exception
     */
    public void delete(String claimNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimAgentAction blPrpLclaimAgentAction = new BLPrpLclaimAgentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLclaimAgentAction.delete(dbManager,claimNo);
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
        BLPrpLclaimAgentAction blPrpLclaimAgentAction = new BLPrpLclaimAgentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLclaimAgentAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLclaimAgentDto prpLclaimAgentDto
     * @throws Exception
     */
    public void update(PrpLclaimAgentDto prpLclaimAgentDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimAgentAction blPrpLclaimAgentAction = new BLPrpLclaimAgentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLclaimAgentAction.update(dbManager,prpLclaimAgentDto);
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
     * @param claimNo �ⰸ��
     * @return prpLclaimAgentDto prpLclaimAgentDto
     * @throws Exception
     */
    public PrpLclaimAgentDto findByPrimaryKey(String claimNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimAgentAction blPrpLclaimAgentAction = new BLPrpLclaimAgentAction();
        //����DTO
        PrpLclaimAgentDto prpLclaimAgentDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLclaimAgentDto = blPrpLclaimAgentAction.findByPrimaryKey(dbManager,claimNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLclaimAgentDto;
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
        BLPrpLclaimAgentAction blPrpLclaimAgentAction = new BLPrpLclaimAgentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLclaimAgentAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLclaimAgentDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimAgentAction blPrpLclaimAgentAction = new BLPrpLclaimAgentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLclaimAgentAction.findByConditions(dbManager,conditions);
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
        BLPrpLclaimAgentAction blPrpLclaimAgentAction = new BLPrpLclaimAgentAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLclaimAgentAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
