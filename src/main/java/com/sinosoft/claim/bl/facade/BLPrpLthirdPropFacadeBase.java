package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLthirdPropAction;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdProp-�Ʋ���ʧ��λ���ҵ���߼�����Facade����<br>
 * ������ 2005-04-12 11:37:54.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdPropFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdPropFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLthirdPropFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLthirdPropDto prpLthirdPropDto
     * @throws Exception
     */
    public void insert(PrpLthirdPropDto prpLthirdPropDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpLthirdPropAction.insert(dbManager,prpLthirdPropDto);
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
     * @param serialNo ��ʧ��Ŀ���
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLthirdPropAction.delete(dbManager,registNo, serialNo);
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
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLthirdPropAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLthirdPropDto prpLthirdPropDto
     * @throws Exception
     */
    public void update(PrpLthirdPropDto prpLthirdPropDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLthirdPropAction.update(dbManager,prpLthirdPropDto);
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
     * @param serialNo ��ʧ��Ŀ���
     * @return prpLthirdPropDto prpLthirdPropDto
     * @throws Exception
     */
    public PrpLthirdPropDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        //����DTO
        PrpLthirdPropDto prpLthirdPropDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            prpLthirdPropDto = blPrpLthirdPropAction.findByPrimaryKey(dbManager,registNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLthirdPropDto;
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
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpLthirdPropAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLthirdPropDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpLthirdPropAction.findByConditions(dbManager,conditions);
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
        BLPrpLthirdPropAction blPrpLthirdPropAction = new BLPrpLthirdPropAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpLthirdPropAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
