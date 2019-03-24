package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLEdaComplainTextAction;
import com.sinosoft.claim.dto.domain.EdaComplainTextDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaComplainTextͶ�����ֱ��ҵ���߼�����Facade����<br>
 * ������ 2005-08-20 17:56:02.116<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaComplainTextFacadeBase{
    private static Log logger = LogFactory.getLog(BLEdaComplainTextFacadeBase.class);

    /**
     * ���캯��
     */
    public BLEdaComplainTextFacadeBase(){
    }

    /**
     * ����һ������
     * @param edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public void insert(EdaComplainTextDto edaComplainTextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //�����¼
            blEdaComplainTextAction.insert(dbManager,edaComplainTextDto);
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
     * @param acceptNo Ͷ�ߵǼǺ�
     * @param textType �ı�����
     * @param serialNo ���
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(double acceptNo,String textType,double serialNo,double lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //ɾ����¼
            blEdaComplainTextAction.delete(dbManager,acceptNo, textType, serialNo, lineNo);
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
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //������ɾ����¼
            blEdaComplainTextAction.deleteByConditions(dbManager,conditions);
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
     * @param edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public void update(EdaComplainTextDto edaComplainTextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //���¼�¼
            blEdaComplainTextAction.update(dbManager,edaComplainTextDto);
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
     * @param acceptNo Ͷ�ߵǼǺ�
     * @param textType �ı�����
     * @param serialNo ���
     * @param lineNo �к�
     * @return edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public EdaComplainTextDto findByPrimaryKey(double acceptNo,String textType,double serialNo,double lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        //����DTO
        EdaComplainTextDto edaComplainTextDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //��ѯ����,��ֵ��DTO
            edaComplainTextDto = blEdaComplainTextAction.findByPrimaryKey(dbManager,acceptNo, textType, serialNo, lineNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return edaComplainTextDto;
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
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blEdaComplainTextAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����edaComplainTextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blEdaComplainTextAction.findByConditions(dbManager,conditions);
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
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            rowCount = blEdaComplainTextAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
