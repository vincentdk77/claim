package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLbackVisitQueAction;
import com.sinosoft.claim.dto.domain.PrpLbackVisitQueDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLbackVisitQue--�ط���ѯ���ҵ���߼�����Facade����<br>
 * ������ 2005-03-23 09:00:26.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitQueFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitQueFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLbackVisitQueFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public void insert(PrpLbackVisitQueDto prpLbackVisitQueDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLbackVisitQueAction.insert(dbManager,prpLbackVisitQueDto);
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
     * @param backVisitID �ͻ��طü�¼ID
     * @param registNo ��������
     * @param backVisitType ҵ������
     * @param questionCode �ط���Ŀ����
     * @throws Exception
     */
    public void delete(int backVisitID,String registNo,String backVisitType,String questionCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLbackVisitQueAction.delete(dbManager,backVisitID, registNo, backVisitType, questionCode);
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
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLbackVisitQueAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public void update(PrpLbackVisitQueDto prpLbackVisitQueDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLbackVisitQueAction.update(dbManager,prpLbackVisitQueDto);
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
     * @param backVisitID �ͻ��طü�¼ID
     * @param registNo ��������
     * @param backVisitType ҵ������
     * @param questionCode �ط���Ŀ����
     * @return prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public PrpLbackVisitQueDto findByPrimaryKey(int backVisitID,String registNo,String backVisitType,String questionCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        //����DTO
        PrpLbackVisitQueDto prpLbackVisitQueDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLbackVisitQueDto = blPrpLbackVisitQueAction.findByPrimaryKey(dbManager,backVisitID, registNo, backVisitType, questionCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLbackVisitQueDto;
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
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLbackVisitQueAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLbackVisitQueDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLbackVisitQueAction.findByConditions(dbManager,conditions);
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
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLbackVisitQueAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
