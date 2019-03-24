package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpChospitalPersonDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpChospitalPerson;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpChospitalPerson��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpChospitalPersonActionBase{
    private static Log logger = LogFactory.getLog(BLPrpChospitalPersonActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpChospitalPersonActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpChospitalPersonDto prpChospitalPersonDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpChospitalPersonDto prpChospitalPersonDto)
            throws Exception{
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        //�����¼
        dbPrpChospitalPerson.insert(prpChospitalPersonDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo PolicyNo
     * @param hospitalNumber HospitalNumber
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,String hospitalNumber)
            throws Exception{
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        //ɾ����¼
        dbPrpChospitalPerson.delete(policyNo, hospitalNumber);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        //������ɾ����¼
        dbPrpChospitalPerson.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpChospitalPersonDto prpChospitalPersonDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpChospitalPersonDto prpChospitalPersonDto)
            throws Exception{
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        //���¼�¼
        dbPrpChospitalPerson.update(prpChospitalPersonDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo PolicyNo
     * @param hospitalNumber HospitalNumber
     * @return prpChospitalPersonDto prpChospitalPersonDto
     * @throws Exception
     */
    public PrpChospitalPersonDto findByPrimaryKey(DBManager dbManager,String policyNo,String hospitalNumber)
            throws Exception{
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        //����DTO
        PrpChospitalPersonDto prpChospitalPersonDto = null;
        //��ѯ����,��ֵ��DTO
        prpChospitalPersonDto = dbPrpChospitalPerson.findByPrimaryKey(policyNo, hospitalNumber);
        return prpChospitalPersonDto;
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
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpChospitalPerson.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpChospitalPerson.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpChospitalPersonDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpChospitalPerson.findByConditions(conditions);
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
        DBPrpChospitalPerson dbPrpChospitalPerson = new DBPrpChospitalPerson(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpChospitalPerson.getCount(conditions);
        return count;
    }
}
