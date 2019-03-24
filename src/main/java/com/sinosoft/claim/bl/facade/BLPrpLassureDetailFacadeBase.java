package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLassureDetailAction;
import com.sinosoft.claim.dto.domain.PrpLassureDetailDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLassureDetail-��������ϸ����������ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.515<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLassureDetailFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLassureDetailFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLassureDetailFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLassureDetailDto prpLassureDetailDto
     * @throws Exception
     */
    public void insert(PrpLassureDetailDto prpLassureDetailDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLassureDetailAction.insert(dbManager,prpLassureDetailDto);
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
     * @param assureNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String assureNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLassureDetailAction.delete(dbManager,assureNo, serialNo);
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
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLassureDetailAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLassureDetailDto prpLassureDetailDto
     * @throws Exception
     */
    public void update(PrpLassureDetailDto prpLassureDetailDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLassureDetailAction.update(dbManager,prpLassureDetailDto);
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
     * @param assureNo ������
     * @param serialNo ���
     * @return prpLassureDetailDto prpLassureDetailDto
     * @throws Exception
     */
    public PrpLassureDetailDto findByPrimaryKey(String assureNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        //����DTO
        PrpLassureDetailDto prpLassureDetailDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLassureDetailDto = blPrpLassureDetailAction.findByPrimaryKey(dbManager,assureNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLassureDetailDto;
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
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLassureDetailAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLassureDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLassureDetailAction.findByConditions(dbManager,conditions);
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
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLassureDetailAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
