package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLpaymaintgAction;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֧����Ϣ�����ҵ���߼�����tgFacade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpaymaintgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpaymaintgFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpaymaintgFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public void insert(PrpLpaymainDto prpLpaymainDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLpaymaintgAction.insert(dbManager,prpLpaymainDto);
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
     * @param paymentNo ֧�����
     * @throws Exception
     */
    public void delete(String paymentNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLpaymaintgAction.delete(dbManager,paymentNo);
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
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLpaymaintgAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public void update(PrpLpaymainDto prpLpaymainDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpaymaintgAction.update(dbManager,prpLpaymainDto);
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
     * @param paymentNo ֧�����
     * @return prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public PrpLpaymainDto findByPrimaryKey(String paymentNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        //����DTO
        PrpLpaymainDto prpLpaymainDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLpaymainDto = blPrpLpaymaintgAction.findByPrimaryKey(dbManager,paymentNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpaymainDto;
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
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymaintgAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLpaymainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpaymaintgAction.findByConditions(dbManager,conditions);
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
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLpaymaintgAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
