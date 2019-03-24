package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterCompeInvDetailAction;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvDetailDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿڲ����м���ӱ�������嵥��Ϣ��ϸ���ҵ���߼�����Facade����<br>
 */
public class BLPrpLinterCompeInvDetailFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompeInvDetailFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCompeInvDetailFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLinterCompeInvDetailDto prpLinterCompeInvDetailDto
     * @throws Exception
     */
    public void insert(PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCompeInvDetailAction blPrpLinterCompeInvDetailAction = new BLPrpLinterCompeInvDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLinterCompeInvDetailAction.insert(dbManager,prpLinterCompeInvDetailDto);
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
     * @param serialNo �嵥�������
     * @param detilSerialNo �嵥��ϸ���
     * @throws Exception
     */
    public void delete(String id,int serialNo,int detilSerialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCompeInvDetailAction blPrpLinterCompeInvDetailAction = new BLPrpLinterCompeInvDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLinterCompeInvDetailAction.delete(dbManager,id, serialNo, detilSerialNo);
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
        BLPrpLinterCompeInvDetailAction blPrpLinterCompeInvDetailAction = new BLPrpLinterCompeInvDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLinterCompeInvDetailAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterCompeInvDetailDto prpLinterCompeInvDetailDto
     * @throws Exception
     */
    public void update(PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCompeInvDetailAction blPrpLinterCompeInvDetailAction = new BLPrpLinterCompeInvDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLinterCompeInvDetailAction.update(dbManager,prpLinterCompeInvDetailDto);
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
     * @param serialNo �嵥�������
     * @param detilSerialNo �嵥��ϸ���
     * @return prpLinterCompeInvDetailDto prpLinterCompeInvDetailDto
     * @throws Exception
     */
    public PrpLinterCompeInvDetailDto findByPrimaryKey(String id,int serialNo,int detilSerialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCompeInvDetailAction blPrpLinterCompeInvDetailAction = new BLPrpLinterCompeInvDetailAction();
        //����DTO
        PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLinterCompeInvDetailDto = blPrpLinterCompeInvDetailAction.findByPrimaryKey(dbManager,id, serialNo, detilSerialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterCompeInvDetailDto;
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
        BLPrpLinterCompeInvDetailAction blPrpLinterCompeInvDetailAction = new BLPrpLinterCompeInvDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterCompeInvDetailAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLinterCompeInvDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterCompeInvDetailAction blPrpLinterCompeInvDetailAction = new BLPrpLinterCompeInvDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterCompeInvDetailAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterCompeInvDetailAction blPrpLinterCompeInvDetailAction = new BLPrpLinterCompeInvDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterCompeInvDetailAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
