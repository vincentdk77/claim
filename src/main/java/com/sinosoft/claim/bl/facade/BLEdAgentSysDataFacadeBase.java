package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLEdAgentSysDataAction;
import com.sinosoft.claim.dto.domain.EdAgentSysDataDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdAgentSysData��ҵ���߼�����Facade����<br>
 * ������ 2005-07-19 09:59:06.511<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdAgentSysDataFacadeBase{
    private static Log logger = LogFactory.getLog(BLEdAgentSysDataFacadeBase.class);

    /**
     * ���캯��
     */
    public BLEdAgentSysDataFacadeBase(){
    }

    /**
     * ����һ������
     * @param edAgentSysDataDto edAgentSysDataDto
     * @throws Exception
     */
    public void insert(EdAgentSysDataDto edAgentSysDataDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdAgentSysDataAction blEdAgentSysDataAction = new BLEdAgentSysDataAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blEdAgentSysDataAction.insert(dbManager,edAgentSysDataDto);
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
     * @param cALLID ���б�ʶ
     * @throws Exception
     */
    public void delete(String cALLID) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdAgentSysDataAction blEdAgentSysDataAction = new BLEdAgentSysDataAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blEdAgentSysDataAction.delete(dbManager,cALLID);
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
        BLEdAgentSysDataAction blEdAgentSysDataAction = new BLEdAgentSysDataAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blEdAgentSysDataAction.deleteByConditions(dbManager,conditions);
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
     * @param edAgentSysDataDto edAgentSysDataDto
     * @throws Exception
     */
    public void update(EdAgentSysDataDto edAgentSysDataDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdAgentSysDataAction blEdAgentSysDataAction = new BLEdAgentSysDataAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blEdAgentSysDataAction.update(dbManager,edAgentSysDataDto);
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
     * @param cALLID ���б�ʶ
     * @return edAgentSysDataDto edAgentSysDataDto
     * @throws Exception
     */
    public EdAgentSysDataDto findByPrimaryKey(String cALLID) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdAgentSysDataAction blEdAgentSysDataAction = new BLEdAgentSysDataAction();
        //����DTO
        EdAgentSysDataDto edAgentSysDataDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            edAgentSysDataDto = blEdAgentSysDataAction.findByPrimaryKey(dbManager,cALLID);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return edAgentSysDataDto;
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
        BLEdAgentSysDataAction blEdAgentSysDataAction = new BLEdAgentSysDataAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blEdAgentSysDataAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����edAgentSysDataDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLEdAgentSysDataAction blEdAgentSysDataAction = new BLEdAgentSysDataAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blEdAgentSysDataAction.findByConditions(dbManager,conditions);
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
        BLEdAgentSysDataAction blEdAgentSysDataAction = new BLEdAgentSysDataAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blEdAgentSysDataAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
