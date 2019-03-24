package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLregistTextAction;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLregistText-�������ֱ��ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.562<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLregistTextFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLregistTextFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLregistTextFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLregistTextDto prpLregistTextDto
     * @throws Exception
     */
    public void insert(PrpLregistTextDto prpLregistTextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLregistTextAction blPrpLregistTextAction = new BLPrpLregistTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLregistTextAction.insert(dbManager,prpLregistTextDto);
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
     * @param registNo ���յǼǺ�
     * @param textType �ı�����
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(String registNo,String textType,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLregistTextAction blPrpLregistTextAction = new BLPrpLregistTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLregistTextAction.delete(dbManager,registNo, textType, lineNo);
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
        BLPrpLregistTextAction blPrpLregistTextAction = new BLPrpLregistTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLregistTextAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLregistTextDto prpLregistTextDto
     * @throws Exception
     */
    public void update(PrpLregistTextDto prpLregistTextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLregistTextAction blPrpLregistTextAction = new BLPrpLregistTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLregistTextAction.update(dbManager,prpLregistTextDto);
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
     * @param registNo ���յǼǺ�
     * @param textType �ı�����
     * @param lineNo �к�
     * @return prpLregistTextDto prpLregistTextDto
     * @throws Exception
     */
    public PrpLregistTextDto findByPrimaryKey(String registNo,String textType,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLregistTextAction blPrpLregistTextAction = new BLPrpLregistTextAction();
        //����DTO
        PrpLregistTextDto prpLregistTextDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLregistTextDto = blPrpLregistTextAction.findByPrimaryKey(dbManager,registNo, textType, lineNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLregistTextDto;
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
        BLPrpLregistTextAction blPrpLregistTextAction = new BLPrpLregistTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLregistTextAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLregistTextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLregistTextAction blPrpLregistTextAction = new BLPrpLregistTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLregistTextAction.findByConditions(dbManager,conditions);
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
        BLPrpLregistTextAction blPrpLregistTextAction = new BLPrpLregistTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLregistTextAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
