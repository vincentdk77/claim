package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeDto;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayNoticeAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֪ͨ�����ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayNoticeFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayNoticeFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpayNoticeFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public void insert(PrpLpayNoticeDto prpLpayNoticeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLpayNoticeAction.insert(dbManager,prpLpayNoticeDto);
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
     * @param noticeNo ֪ͨ����
     * @throws Exception
     */
    public void delete(String noticeNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLpayNoticeAction.delete(dbManager,noticeNo);
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
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLpayNoticeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public void update(PrpLpayNoticeDto prpLpayNoticeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpayNoticeAction.update(dbManager,prpLpayNoticeDto);
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
     * @param noticeNo ֪ͨ����
     * @return prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public PrpLpayNoticeDto findByPrimaryKey(String noticeNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        //����DTO
        PrpLpayNoticeDto prpLpayNoticeDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLpayNoticeDto = blPrpLpayNoticeAction.findByPrimaryKey(dbManager,noticeNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpayNoticeDto;
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
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayNoticeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLpayNoticeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpayNoticeAction.findByConditions(dbManager,conditions);
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
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLpayNoticeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
