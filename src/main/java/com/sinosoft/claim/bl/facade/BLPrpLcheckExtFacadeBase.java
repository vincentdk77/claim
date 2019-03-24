package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcheckExtAction;
import com.sinosoft.claim.dto.domain.PrpLcheckExtDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheckExt-�鿱/���鿱��չ��(�޸�)��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.390<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckExtFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckExtFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcheckExtFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLcheckExtDto prpLcheckExtDto
     * @throws Exception
     */
    public void insert(PrpLcheckExtDto prpLcheckExtDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcheckExtAction blPrpLcheckExtAction = new BLPrpLcheckExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLcheckExtAction.insert(dbManager,prpLcheckExtDto);
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
     * @param registNo ��������
     * @param serialNo ���
     * @param columnName �鿱��Ŀ����
     * @param referSerialNo �������⳵�����
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,String columnName,int referSerialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcheckExtAction blPrpLcheckExtAction = new BLPrpLcheckExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLcheckExtAction.delete(dbManager,registNo, serialNo, columnName, referSerialNo);
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
        BLPrpLcheckExtAction blPrpLcheckExtAction = new BLPrpLcheckExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLcheckExtAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcheckExtDto prpLcheckExtDto
     * @throws Exception
     */
    public void update(PrpLcheckExtDto prpLcheckExtDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcheckExtAction blPrpLcheckExtAction = new BLPrpLcheckExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLcheckExtAction.update(dbManager,prpLcheckExtDto);
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
     * @param registNo ��������
     * @param serialNo ���
     * @param columnName �鿱��Ŀ����
     * @param referSerialNo �������⳵�����
     * @return prpLcheckExtDto prpLcheckExtDto
     * @throws Exception
     */
    public PrpLcheckExtDto findByPrimaryKey(String registNo,int serialNo,String columnName,int referSerialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcheckExtAction blPrpLcheckExtAction = new BLPrpLcheckExtAction();
        //����DTO
        PrpLcheckExtDto prpLcheckExtDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLcheckExtDto = blPrpLcheckExtAction.findByPrimaryKey(dbManager,registNo, serialNo, columnName, referSerialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcheckExtDto;
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
        BLPrpLcheckExtAction blPrpLcheckExtAction = new BLPrpLcheckExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLcheckExtAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLcheckExtDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcheckExtAction blPrpLcheckExtAction = new BLPrpLcheckExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLcheckExtAction.findByConditions(dbManager,conditions);
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
        BLPrpLcheckExtAction blPrpLcheckExtAction = new BLPrpLcheckExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLcheckExtAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
