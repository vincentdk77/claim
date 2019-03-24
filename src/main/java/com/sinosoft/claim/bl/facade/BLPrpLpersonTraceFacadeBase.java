package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLpersonTraceAction;
import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpersonTrace-���˸��ٱ�(����)��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpersonTraceFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonTraceFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpersonTraceFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public void insert(PrpLpersonTraceDto prpLpersonTraceDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLpersonTraceAction.insert(dbManager,prpLpersonTraceDto);
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
     * @param registNo ������
     * @param personNo ��Ա���
     * @throws Exception
     */
    public void delete(String registNo,int personNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLpersonTraceAction.delete(dbManager,registNo, personNo);
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
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLpersonTraceAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public void update(PrpLpersonTraceDto prpLpersonTraceDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpersonTraceAction.update(dbManager,prpLpersonTraceDto);
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
     * @param registNo ������
     * @param personNo ��Ա���
     * @return prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public PrpLpersonTraceDto findByPrimaryKey(String registNo,int personNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        //����DTO
        PrpLpersonTraceDto prpLpersonTraceDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLpersonTraceDto = blPrpLpersonTraceAction.findByPrimaryKey(dbManager,registNo, personNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpersonTraceDto;
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
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpersonTraceAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLpersonTraceDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpersonTraceAction.findByConditions(dbManager,conditions);
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
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLpersonTraceAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
