package com.sinosoft.function.power.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.bl.action.domain.BLPrpTaskAction;
import com.sinosoft.function.power.dto.domain.PrpTaskDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpTask����������ҵ���߼�����Facade����<br>
 * ������ 2004-11-09 10:40:55.460<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpTaskFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpTaskFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpTaskFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpTaskDto prpTaskDto
     * @throws Exception
     */
    public void insert(PrpTaskDto prpTaskDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //�����¼
            blPrpTaskAction.insert(dbManager,prpTaskDto);
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
     * @param taskCode �������
     * @param checkCode Ȩ�޼������
     * @throws Exception
     */
    public void delete(String taskCode,String checkCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpTaskAction.delete(dbManager,taskCode, checkCode);
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
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpTaskAction.deleteByConditions(dbManager,conditions);
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
     * @param prpTaskDto prpTaskDto
     * @throws Exception
     */
    public void update(PrpTaskDto prpTaskDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            dbManager.beginTransaction();
            //���¼�¼
            blPrpTaskAction.update(dbManager,prpTaskDto);
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
     * @param taskCode �������
     * @param checkCode Ȩ�޼������
     * @return prpTaskDto prpTaskDto
     * @throws Exception
     */
    public PrpTaskDto findByPrimaryKey(String taskCode,String checkCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        //����DTO
        PrpTaskDto prpTaskDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            //��ѯ����,��ֵ��DTO
            prpTaskDto = blPrpTaskAction.findByPrimaryKey(dbManager,taskCode, checkCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpTaskDto;
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
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            pageRecord = blPrpTaskAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpTaskDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            collection = blPrpTaskAction.findByConditions(dbManager,conditions);
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
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
            rowCount = blPrpTaskAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
