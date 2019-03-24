package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalPolicyListDto;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalPolicyList;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalsettlelist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PLANTINGPOLICYLIST��ҵ���߼�������<br>
 */
public class BLMedicalPolicyListActionBase{
    private static Logger logger = Logger.getLogger(BLMedicalPolicyListActionBase.class);

    /**
     * ���캯��
     */
    public BLMedicalPolicyListActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param medicalpolicylistDto medicalpolicylistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,MedicalPolicyListDto medicalpolicylistDto)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        //�����¼
        dbMedicalpolicylist.insert(medicalpolicylistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String idcard)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        //ɾ����¼
        dbMedicalpolicylist.delete(inusrelistcode, idcard);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        //������ɾ����¼
        dbMedicalpolicylist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param medicalpolicylistDto medicalpolicylistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,MedicalPolicyListDto medicalpolicylistDto)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        //���¼�¼
        dbMedicalpolicylist.update(medicalpolicylistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @return medicalpolicylistDto medicalpolicylistDto
     * @throws Exception
     */
    public MedicalPolicyListDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String idcard)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        //����DTO
        MedicalPolicyListDto medicalpolicylistDto = null;
        //��ѯ����,��ֵ��DTO
        medicalpolicylistDto = dbMedicalpolicylist.findByPrimaryKey(inusrelistcode, idcard);
        return medicalpolicylistDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        //System.err.println("MedicalPolicyList��ѯ������" + conditions);
        int count = dbMedicalpolicylist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        //System.err.println("MedicalPolicyList��ѯ��Ŀ��" + count);
        collection = dbMedicalpolicylist.findByConditions(conditions,pageNo,rowsPerPage);
        //System.err.println("��ѯ�����嵥");
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����medicalpolicylistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbMedicalpolicylist.findByConditions(conditions);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBMedicalPolicyList dbMedicalpolicylist = new DBMedicalPolicyList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMedicalpolicylist.getCount(conditions);
        return count;
    }
    
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @param fieldName �ֶ���
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public double getSum(DBManager dbManager,String conditions,String fieldName) 
        throws Exception{
        DBMedicalPolicyList dbMedicalPolicyList = new DBMedicalPolicyList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbMedicalPolicyList.getSum(conditions,fieldName);
        return sum;
    }
}
