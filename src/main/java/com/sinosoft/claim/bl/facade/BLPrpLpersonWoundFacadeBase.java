package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLpersonWoundAction;
import com.sinosoft.claim.dto.domain.PrpLpersonWoundDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpersonWound-������Ϣ��(����)��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpersonWoundFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonWoundFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpersonWoundFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLpersonWoundDto prpLpersonWoundDto
     * @throws Exception
     */
    public void insert(PrpLpersonWoundDto prpLpersonWoundDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonWoundAction blPrpLpersonWoundAction = new BLPrpLpersonWoundAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLpersonWoundAction.insert(dbManager,prpLpersonWoundDto);
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
     * @param personNo ��Ա���
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,int personNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonWoundAction blPrpLpersonWoundAction = new BLPrpLpersonWoundAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLpersonWoundAction.delete(dbManager,registNo, serialNo, personNo);
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
        BLPrpLpersonWoundAction blPrpLpersonWoundAction = new BLPrpLpersonWoundAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLpersonWoundAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLpersonWoundDto prpLpersonWoundDto
     * @throws Exception
     */
    public void update(PrpLpersonWoundDto prpLpersonWoundDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonWoundAction blPrpLpersonWoundAction = new BLPrpLpersonWoundAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpersonWoundAction.update(dbManager,prpLpersonWoundDto);
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
     * @param personNo ��Ա���
     * @return prpLpersonWoundDto prpLpersonWoundDto
     * @throws Exception
     */
    public PrpLpersonWoundDto findByPrimaryKey(String registNo,int serialNo,int personNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonWoundAction blPrpLpersonWoundAction = new BLPrpLpersonWoundAction();
        //����DTO
        PrpLpersonWoundDto prpLpersonWoundDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLpersonWoundDto = blPrpLpersonWoundAction.findByPrimaryKey(dbManager,registNo, serialNo, personNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpersonWoundDto;
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
        BLPrpLpersonWoundAction blPrpLpersonWoundAction = new BLPrpLpersonWoundAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpersonWoundAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLpersonWoundDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpersonWoundAction blPrpLpersonWoundAction = new BLPrpLpersonWoundAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpersonWoundAction.findByConditions(dbManager,conditions);
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
        BLPrpLpersonWoundAction blPrpLpersonWoundAction = new BLPrpLpersonWoundAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLpersonWoundAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
