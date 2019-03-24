package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayNoticeListAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֪ͨ���������ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayNoticeListFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayNoticeListFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpayNoticeListFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLpayNoticeListDto prpLpayNoticeListDto
     * @throws Exception
     */
    public void insert(PrpLpayNoticeListDto prpLpayNoticeListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeListAction blPrpLpayNoticeListAction = new BLPrpLpayNoticeListAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLpayNoticeListAction.insert(dbManager,prpLpayNoticeListDto);
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
     * @param paymentNo �ո����
     * @throws Exception
     */
    public void delete(String noticeNo,String paymentNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeListAction blPrpLpayNoticeListAction = new BLPrpLpayNoticeListAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLpayNoticeListAction.delete(dbManager,noticeNo, paymentNo);
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
        BLPrpLpayNoticeListAction blPrpLpayNoticeListAction = new BLPrpLpayNoticeListAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLpayNoticeListAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLpayNoticeListDto prpLpayNoticeListDto
     * @throws Exception
     */
    public void update(PrpLpayNoticeListDto prpLpayNoticeListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeListAction blPrpLpayNoticeListAction = new BLPrpLpayNoticeListAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpayNoticeListAction.update(dbManager,prpLpayNoticeListDto);
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
     * @param paymentNo �ո����
     * @return prpLpayNoticeListDto prpLpayNoticeListDto
     * @throws Exception
     */
    public PrpLpayNoticeListDto findByPrimaryKey(String noticeNo,String paymentNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeListAction blPrpLpayNoticeListAction = new BLPrpLpayNoticeListAction();
        //����DTO
        PrpLpayNoticeListDto prpLpayNoticeListDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLpayNoticeListDto = blPrpLpayNoticeListAction.findByPrimaryKey(dbManager,noticeNo, paymentNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpayNoticeListDto;
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
        BLPrpLpayNoticeListAction blPrpLpayNoticeListAction = new BLPrpLpayNoticeListAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayNoticeListAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLpayNoticeListDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeListAction blPrpLpayNoticeListAction = new BLPrpLpayNoticeListAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpayNoticeListAction.findByConditions(dbManager,conditions);
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
        BLPrpLpayNoticeListAction blPrpLpayNoticeListAction = new BLPrpLpayNoticeListAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLpayNoticeListAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * ���������¼ add by zhongfen
     * @param prplpayNoticelistList
     * @throws Exception
     */
    public void insertAll(Collection prplpayNoticelistList)throws Exception{
    	DBManager dbManager = new DBManager();
        BLPrpLpayNoticeListAction blPrpLpayNoticeListAction = new BLPrpLpayNoticeListAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���������¼
            blPrpLpayNoticeListAction.insertAll(dbManager,prplpayNoticelistList);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
}
