package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpChospitalPersonAction;
import com.sinosoft.claim.dto.domain.PrpChospitalPersonDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpChospitalPerson��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpChospitalPersonFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpChospitalPersonFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpChospitalPersonFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpChospitalPersonDto prpChospitalPersonDto
     * @throws Exception
     */
    public void insert(PrpChospitalPersonDto prpChospitalPersonDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpChospitalPersonAction blPrpChospitalPersonAction = new BLPrpChospitalPersonAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //�����¼
            blPrpChospitalPersonAction.insert(dbManager,prpChospitalPersonDto);
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
     * @param hospitalNumber HospitalNumber
     * @throws Exception
     */
    public void delete(String policyNo,String hospitalNumber)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpChospitalPersonAction blPrpChospitalPersonAction = new BLPrpChospitalPersonAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpChospitalPersonAction.delete(dbManager,policyNo, hospitalNumber);
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
        BLPrpChospitalPersonAction blPrpChospitalPersonAction = new BLPrpChospitalPersonAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpChospitalPersonAction.deleteByConditions(dbManager,conditions);
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
     * @param prpChospitalPersonDto prpChospitalPersonDto
     * @throws Exception
     */
    public void update(PrpChospitalPersonDto prpChospitalPersonDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpChospitalPersonAction blPrpChospitalPersonAction = new BLPrpChospitalPersonAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPrpChospitalPersonAction.update(dbManager,prpChospitalPersonDto);
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
     * @param hospitalNumber HospitalNumber
     * @return prpChospitalPersonDto prpChospitalPersonDto
     * @throws Exception
     */
    public PrpChospitalPersonDto findByPrimaryKey(String policyNo,String hospitalNumber)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpChospitalPersonAction blPrpChospitalPersonAction = new BLPrpChospitalPersonAction();
        //����DTO
        PrpChospitalPersonDto prpChospitalPersonDto = null;
        try{
            dbManager.open("ddccDataSource");
            //��ѯ����,��ֵ��DTO
            prpChospitalPersonDto = blPrpChospitalPersonAction.findByPrimaryKey(dbManager,policyNo, hospitalNumber);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpChospitalPersonDto;
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
        BLPrpChospitalPersonAction blPrpChospitalPersonAction = new BLPrpChospitalPersonAction();
        try{
            dbManager.open("ddccDataSource");
            pageRecord = blPrpChospitalPersonAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpChospitalPersonDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpChospitalPersonAction blPrpChospitalPersonAction = new BLPrpChospitalPersonAction();
        try{
            dbManager.open("ddccDataSource");
            collection = blPrpChospitalPersonAction.findByConditions(dbManager,conditions);
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
        BLPrpChospitalPersonAction blPrpChospitalPersonAction = new BLPrpChospitalPersonAction();
        try{
            dbManager.open("ddccDataSource");
            rowCount = blPrpChospitalPersonAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
