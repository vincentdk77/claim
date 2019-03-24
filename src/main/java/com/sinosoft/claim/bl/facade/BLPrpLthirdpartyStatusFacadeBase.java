package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLthirdpartyStatusAction;
import com.sinosoft.claim.dto.domain.PrpLthirdpartyStatusDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdpartyStatus-���������ҵ��Ϣ������Ϣ״̬���ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.546<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdpartyStatusFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdpartyStatusFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLthirdpartyStatusFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLthirdpartyStatusDto prpLthirdpartyStatusDto
     * @throws Exception
     */
    public void insert(PrpLthirdpartyStatusDto prpLthirdpartyStatusDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdpartyStatusAction blPrpLthirdpartyStatusAction = new BLPrpLthirdpartyStatusAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLthirdpartyStatusAction.insert(dbManager,prpLthirdpartyStatusDto);
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
     * @param businessNo ����ҵ�����
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String businessNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdpartyStatusAction blPrpLthirdpartyStatusAction = new BLPrpLthirdpartyStatusAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLthirdpartyStatusAction.delete(dbManager,businessNo, serialNo);
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
        BLPrpLthirdpartyStatusAction blPrpLthirdpartyStatusAction = new BLPrpLthirdpartyStatusAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLthirdpartyStatusAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLthirdpartyStatusDto prpLthirdpartyStatusDto
     * @throws Exception
     */
    public void update(PrpLthirdpartyStatusDto prpLthirdpartyStatusDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdpartyStatusAction blPrpLthirdpartyStatusAction = new BLPrpLthirdpartyStatusAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLthirdpartyStatusAction.update(dbManager,prpLthirdpartyStatusDto);
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
     * @param businessNo ����ҵ�����
     * @param serialNo ���
     * @return prpLthirdpartyStatusDto prpLthirdpartyStatusDto
     * @throws Exception
     */
    public PrpLthirdpartyStatusDto findByPrimaryKey(String businessNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdpartyStatusAction blPrpLthirdpartyStatusAction = new BLPrpLthirdpartyStatusAction();
        //����DTO
        PrpLthirdpartyStatusDto prpLthirdpartyStatusDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLthirdpartyStatusDto = blPrpLthirdpartyStatusAction.findByPrimaryKey(dbManager,businessNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLthirdpartyStatusDto;
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
        BLPrpLthirdpartyStatusAction blPrpLthirdpartyStatusAction = new BLPrpLthirdpartyStatusAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLthirdpartyStatusAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLthirdpartyStatusDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLthirdpartyStatusAction blPrpLthirdpartyStatusAction = new BLPrpLthirdpartyStatusAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLthirdpartyStatusAction.findByConditions(dbManager,conditions);
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
        BLPrpLthirdpartyStatusAction blPrpLthirdpartyStatusAction = new BLPrpLthirdpartyStatusAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLthirdpartyStatusAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
