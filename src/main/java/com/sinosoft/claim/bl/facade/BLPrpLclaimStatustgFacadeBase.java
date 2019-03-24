package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimStatustgAction;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimStatus-����ڵ�״̬��(����)��ҵ���߼�����tgFacade����<br>
 * ������ 2005-03-18 17:53:38.687<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimStatustgFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimStatustgFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimStatustgFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLclaimStatusDto prpLclaimStatusDto
     * @throws Exception
     */
    public void insert(PrpLclaimStatusDto prpLclaimStatustgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimStatustgAction blPrpLclaimStatustgAction = new BLPrpLclaimStatustgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLclaimStatustgAction.insert(dbManager,prpLclaimStatustgDto);
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
     * @param businessNo ҵ���
     * @param nodeType �ڵ�����
     * @param serialNo ���к���
     * @throws Exception
     */
    public void delete(String businessNo,String nodeType,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimStatustgAction blPrpLclaimStatustgAction = new BLPrpLclaimStatustgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLclaimStatustgAction.delete(dbManager,businessNo, nodeType, serialNo);
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
        BLPrpLclaimStatustgAction blPrpLclaimStatustgAction = new BLPrpLclaimStatustgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLclaimStatustgAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLclaimStatusDto prpLclaimStatusDto
     * @throws Exception
     */
    public void update(PrpLclaimStatusDto prpLclaimStatustgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimStatustgAction blPrpLclaimStatustgAction = new BLPrpLclaimStatustgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLclaimStatustgAction.update(dbManager,prpLclaimStatustgDto);
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
     * @param businessNo ҵ���
     * @param nodeType �ڵ�����
     * @param serialNo ���к���
     * @return prpLclaimStatusDto prpLclaimStatusDto
     * @throws Exception
     */
    public PrpLclaimStatusDto findByPrimaryKey(String businessNo,String nodeType,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimStatustgAction blPrpLclaimStatustgAction = new BLPrpLclaimStatustgAction();
        //����DTO
        PrpLclaimStatusDto prpLclaimStatustgDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLclaimStatustgDto = blPrpLclaimStatustgAction.findByPrimaryKey(dbManager,businessNo, nodeType, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLclaimStatustgDto;
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
        BLPrpLclaimStatustgAction blPrpLclaimStatustgAction = new BLPrpLclaimStatustgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLclaimStatustgAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLclaimStatusDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimStatustgAction blPrpLclaimStatustgAction = new BLPrpLclaimStatustgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLclaimStatustgAction.findByConditions(dbManager,conditions);
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
        BLPrpLclaimStatustgAction blPrpLclaimStatustgAction = new BLPrpLclaimStatustgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLclaimStatustgAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}