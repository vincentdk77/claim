package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLinvestigateAction;
import com.sinosoft.claim.dto.domain.PrpLinvestigateDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLinvestigate-���������Ϣ���ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.437<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLinvestigateFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLinvestigateFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinvestigateFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public void insert(PrpLinvestigateDto prpLinvestigateDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLinvestigateAction.insert(dbManager,prpLinvestigateDto);
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
     * @param serialNo ���
     * @param objectType �����������
--** 1.������
--** 2.������
--** 3.�����
--** 4.������
--** 5.�۳���
--** 6.������
--** 7.�������
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,String objectType) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLinvestigateAction.delete(dbManager,registNo, serialNo, objectType);
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
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLinvestigateAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public void update(PrpLinvestigateDto prpLinvestigateDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLinvestigateAction.update(dbManager,prpLinvestigateDto);
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
     * @param serialNo ���
     * @param objectType �����������
--** 1.������
--** 2.������
--** 3.�����
--** 4.������
--** 5.�۳���
--** 6.������
--** 7.�������
     * @return prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public PrpLinvestigateDto findByPrimaryKey(String registNo,int serialNo,String objectType) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        //����DTO
        PrpLinvestigateDto prpLinvestigateDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLinvestigateDto = blPrpLinvestigateAction.findByPrimaryKey(dbManager,registNo, serialNo, objectType);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinvestigateDto;
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
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinvestigateAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLinvestigateDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinvestigateAction.findByConditions(dbManager,conditions);
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
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinvestigateAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
