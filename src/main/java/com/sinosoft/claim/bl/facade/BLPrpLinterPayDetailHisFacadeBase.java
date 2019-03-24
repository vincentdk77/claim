package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailHisDto;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayDetailHisAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǽ�����Ϣ������------�켣��ʷ���ҵ���߼�����Facade����<br>
 */
public class BLPrpLinterPayDetailHisFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDetailHisFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPayDetailHisFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLinterPayDetailHisDto prpLinterPayDetailHisDto
     * @throws Exception
     */
    public void insert(PrpLinterPayDetailHisDto prpLinterPayDetailHisDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpLinterPayDetailHisAction.insert(dbManager,prpLinterPayDetailHisDto);
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
     * @param id ����pk
     * @throws Exception
     */
    public void delete(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLinterPayDetailHisAction.delete(dbManager,id);
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
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLinterPayDetailHisAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterPayDetailHisDto prpLinterPayDetailHisDto
     * @throws Exception
     */
    public void update(PrpLinterPayDetailHisDto prpLinterPayDetailHisDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLinterPayDetailHisAction.update(dbManager,prpLinterPayDetailHisDto);
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
     * @param id ����pk
     * @return prpLinterPayDetailHisDto prpLinterPayDetailHisDto
     * @throws Exception
     */
    public PrpLinterPayDetailHisDto findByPrimaryKey(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        //����DTO
        PrpLinterPayDetailHisDto prpLinterPayDetailHisDto = null;
        try{
            dbManager.open("prplinterpaydetailDataSource");
            //��ѯ����,��ֵ��DTO
            prpLinterPayDetailHisDto = blPrpLinterPayDetailHisAction.findByPrimaryKey(dbManager,id);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterPayDetailHisDto;
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
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            pageRecord = blPrpLinterPayDetailHisAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLinterPayDetailHisDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            collection = blPrpLinterPayDetailHisAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            rowCount = blPrpLinterPayDetailHisAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
