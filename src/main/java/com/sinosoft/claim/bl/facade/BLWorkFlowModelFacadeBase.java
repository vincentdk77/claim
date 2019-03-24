package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.custom.BLWorkFlowModelAction;
import com.sinosoft.claim.dto.custom.WorkFlowModelDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WorkFlowModel�����������������ҵ���߼�����Facade����<br>
 * ������ 2004-08-09 19:54:55.307<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLWorkFlowModelFacadeBase{
    private static Log logger = LogFactory.getLog(BLWorkFlowModelFacadeBase.class);

    /**
     * ���캯��
     */
    public BLWorkFlowModelFacadeBase(){
    }

    /**
     * ����һ������
     * @param workFlowModelDto workFlowModelDto
     * @throws Exception
     */
    public void insert(WorkFlowModelDto workFlowModelDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLWorkFlowModelAction blWorkFlowModelAction = new BLWorkFlowModelAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blWorkFlowModelAction.insert(dbManager,workFlowModelDto);
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
     * @param modelNo ģ�����
     * @param pathNo ���̱߱���
     * @param conditionNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLWorkFlowModelAction blWorkFlowModelAction = new BLWorkFlowModelAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blWorkFlowModelAction.delete(dbManager,modelNo, pathNo, conditionNo, serialNo);
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
        BLWorkFlowModelAction blWorkFlowModelAction = new BLWorkFlowModelAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blWorkFlowModelAction.deleteByConditions(dbManager,conditions);
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
     * @param workFlowModelDto workFlowModelDto
     * @throws Exception
     */
    public void update(WorkFlowModelDto workFlowModelDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLWorkFlowModelAction blWorkFlowModelAction = new BLWorkFlowModelAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blWorkFlowModelAction.update(dbManager,workFlowModelDto);
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
     * @param modelNo ģ�����
     * @param pathNo ���̱߱���
     * @param conditionNo ��������
     * @param serialNo ���
     * @return workFlowModelDto workFlowModelDto
     * @throws Exception
     */
    public WorkFlowModelDto findByPrimaryKey(int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLWorkFlowModelAction blWorkFlowModelAction = new BLWorkFlowModelAction();
        //����DTO
        WorkFlowModelDto workFlowModelDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            workFlowModelDto = blWorkFlowModelAction.findByPrimaryKey(dbManager,modelNo, pathNo, conditionNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return workFlowModelDto;
    }

    /**
     * ����������һ������
     * @param modelNo ģ�����
     * @return workFlowModelDto workFlowModelDto
     * @throws Exception
     */
    public WorkFlowModelDto findByPrimaryKey(int modelNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLWorkFlowModelAction blWorkFlowModelAction = new BLWorkFlowModelAction();
        //����DTO
        WorkFlowModelDto workFlowModelDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            workFlowModelDto = blWorkFlowModelAction.findByPrimaryKey(dbManager,modelNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return workFlowModelDto;
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
        PageRecord pageRecord = new PageRecord(0,pageNo,1,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLWorkFlowModelAction blWorkFlowModelAction = new BLWorkFlowModelAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blWorkFlowModelAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����workFlowModelDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0).getResult();
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
        BLWorkFlowModelAction blWorkFlowModelAction = new BLWorkFlowModelAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blWorkFlowModelAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
