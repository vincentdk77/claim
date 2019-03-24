package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcaseNoAction;
import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcaseNo-�ⰸ�ű��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.515<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcaseNoFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcaseNoFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcaseNoFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLcaseNoDto prpLcaseNoDto
     * @throws Exception
     */
    public void insert(PrpLcaseNoDto prpLcaseNoDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcaseNoAction blPrpLcaseNoAction = new BLPrpLcaseNoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLcaseNoAction.insert(dbManager,prpLcaseNoDto);
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
     * @param certiNo ��֤��
     * @param certiType ��֤����
     * @param caseNo �ⰸ��
     * @throws Exception
     */
    public void delete(String certiNo,String certiType,String caseNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcaseNoAction blPrpLcaseNoAction = new BLPrpLcaseNoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLcaseNoAction.delete(dbManager,certiNo, certiType, caseNo);
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
        BLPrpLcaseNoAction blPrpLcaseNoAction = new BLPrpLcaseNoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLcaseNoAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcaseNoDto prpLcaseNoDto
     * @throws Exception
     */
    public void update(PrpLcaseNoDto prpLcaseNoDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcaseNoAction blPrpLcaseNoAction = new BLPrpLcaseNoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLcaseNoAction.update(dbManager,prpLcaseNoDto);
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
     * @param certiNo ��֤��
     * @param certiType ��֤����
     * @param caseNo �ⰸ��
     * @return prpLcaseNoDto prpLcaseNoDto
     * @throws Exception
     */
    public PrpLcaseNoDto findByPrimaryKey(String certiNo,String certiType,String caseNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcaseNoAction blPrpLcaseNoAction = new BLPrpLcaseNoAction();
        //����DTO
        PrpLcaseNoDto prpLcaseNoDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLcaseNoDto = blPrpLcaseNoAction.findByPrimaryKey(dbManager,certiNo, certiType, caseNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcaseNoDto;
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
        BLPrpLcaseNoAction blPrpLcaseNoAction = new BLPrpLcaseNoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLcaseNoAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLcaseNoDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcaseNoAction blPrpLcaseNoAction = new BLPrpLcaseNoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLcaseNoAction.findByConditions(dbManager,conditions);
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
        BLPrpLcaseNoAction blPrpLcaseNoAction = new BLPrpLcaseNoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLcaseNoAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
