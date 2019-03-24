package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalPolicyListDto;
import com.gyic.claim.bl.action.domain.BLMedicalPolicyListAction;
import com.gyic.claim.bl.action.domain.BLMedicalsettlelistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PLANTINGPOLICYLIST��ҵ���߼�����Facade����<br>
 */
public class BLMedicalPolicyListFacadeBase{
    private static Logger logger = Logger.getLogger(BLMedicalPolicyListFacadeBase.class);

    /**
     * ���캯��
     */
    public BLMedicalPolicyListFacadeBase(){
    }

    /**
     * ����һ������
     * @param medicalpolicylistDto medicalpolicylistDto
     * @throws Exception
     */
    public void insert(MedicalPolicyListDto medicalpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalPolicyListAction blMedicalpolicylistAction = new BLMedicalPolicyListAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //�����¼
            blMedicalpolicylistAction.insert(dbManager,medicalpolicylistDto);
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
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String idcard)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalPolicyListAction blMedicalpolicylistAction = new BLMedicalPolicyListAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blMedicalpolicylistAction.delete(dbManager,inusrelistcode, idcard);
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
        BLMedicalPolicyListAction blMedicalpolicylistAction = new BLMedicalPolicyListAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blMedicalpolicylistAction.deleteByConditions(dbManager,conditions);
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
     * @param medicalpolicylistDto medicalpolicylistDto
     * @throws Exception
     */
    public void update(MedicalPolicyListDto medicalpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalPolicyListAction blMedicalpolicylistAction = new BLMedicalPolicyListAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blMedicalpolicylistAction.update(dbManager,medicalpolicylistDto);
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
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @return medicalpolicylistDto medicalpolicylistDto
     * @throws Exception
     */
    public MedicalPolicyListDto findByPrimaryKey(String inusrelistcode,String idcard)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalPolicyListAction blMedicalpolicylistAction = new BLMedicalPolicyListAction();
        //����DTO
        MedicalPolicyListDto medicalpolicylistDto = null;
        try{
            dbManager.open("JKXDataSource");
            //��ѯ����,��ֵ��DTO
            medicalpolicylistDto = blMedicalpolicylistAction.findByPrimaryKey(dbManager,inusrelistcode, idcard);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return medicalpolicylistDto;
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
        BLMedicalPolicyListAction blMedicalpolicylistAction = new BLMedicalPolicyListAction();
        try{
        	//System.err.println("MedicalPolicyList��ѯ������" + conditions);
            dbManager.open("JKXDataSource");
            pageRecord = blMedicalpolicylistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����medicalpolicylistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLMedicalPolicyListAction blMedicalpolicylistAction = new BLMedicalPolicyListAction();
        try{
            dbManager.open("JKXDataSource");
            collection = blMedicalpolicylistAction.findByConditions(dbManager,conditions);
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
        BLMedicalPolicyListAction blMedicalpolicylistAction = new BLMedicalPolicyListAction();
        try{
            dbManager.open("JKXDataSource");
            rowCount = blMedicalpolicylistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @param fieldName �ֶ���
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public double getSum(String conditions, String fieldName)
        throws Exception{
        double sum=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLMedicalPolicyListAction blMedicalpolicylistAction = new BLMedicalPolicyListAction();
        try{
            dbManager.open("JKXDataSource");
            sum = blMedicalpolicylistAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}
