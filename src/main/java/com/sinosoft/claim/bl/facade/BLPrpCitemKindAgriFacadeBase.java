package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpCitemKindAgriAction;
import com.sinosoft.claim.dto.domain.PrpCitemKindAgriDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpCitemKindAgri��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCitemKindAgriFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpCitemKindAgriFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpCitemKindAgriFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpCitemKindAgriDto prpCitemKindAgriDto
     * @throws Exception
     */
    public void insert(PrpCitemKindAgriDto prpCitemKindAgriDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCitemKindAgriAction blPrpCitemKindAgriAction = new BLPrpCitemKindAgriAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpCitemKindAgriAction.insert(dbManager,prpCitemKindAgriDto);
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
     * @param policyNo PolicyNo
     * @param itemKindNo ItemKindNo
     * @param kindCode KindCode
     * @throws Exception
     */
    public void delete(String policyNo,long itemKindNo,String kindCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCitemKindAgriAction blPrpCitemKindAgriAction = new BLPrpCitemKindAgriAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpCitemKindAgriAction.delete(dbManager,policyNo, itemKindNo, kindCode);
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
        BLPrpCitemKindAgriAction blPrpCitemKindAgriAction = new BLPrpCitemKindAgriAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpCitemKindAgriAction.deleteByConditions(dbManager,conditions);
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
     * @param prpCitemKindAgriDto prpCitemKindAgriDto
     * @throws Exception
     */
    public void update(PrpCitemKindAgriDto prpCitemKindAgriDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCitemKindAgriAction blPrpCitemKindAgriAction = new BLPrpCitemKindAgriAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpCitemKindAgriAction.update(dbManager,prpCitemKindAgriDto);
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
     * @param policyNo PolicyNo
     * @param itemKindNo ItemKindNo
     * @param kindCode KindCode
     * @return prpCitemKindAgriDto prpCitemKindAgriDto
     * @throws Exception
     */
    public PrpCitemKindAgriDto findByPrimaryKey(String policyNo,long itemKindNo,String kindCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCitemKindAgriAction blPrpCitemKindAgriAction = new BLPrpCitemKindAgriAction();
        //����DTO
        PrpCitemKindAgriDto prpCitemKindAgriDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            prpCitemKindAgriDto = blPrpCitemKindAgriAction.findByPrimaryKey(dbManager,policyNo, itemKindNo, kindCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpCitemKindAgriDto;
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
        BLPrpCitemKindAgriAction blPrpCitemKindAgriAction = new BLPrpCitemKindAgriAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpCitemKindAgriAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpCitemKindAgriDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpCitemKindAgriAction blPrpCitemKindAgriAction = new BLPrpCitemKindAgriAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpCitemKindAgriAction.findByConditions(dbManager,conditions);
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
        BLPrpCitemKindAgriAction blPrpCitemKindAgriAction = new BLPrpCitemKindAgriAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpCitemKindAgriAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
