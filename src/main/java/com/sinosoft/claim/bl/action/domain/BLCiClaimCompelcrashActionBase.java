package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBCiClaimCompelcrash;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CIClaimCompelcrash ���⳵���������ݱ��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimCompelcrashActionBase{
    private static Log logger = LogFactory.getLog(BLCiClaimCompelcrashActionBase.class);

    /**
     * ���캯��
     */
    public BLCiClaimCompelcrashActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CiClaimCompelcrashDto ciClaimCompelcrashDto)
            throws Exception{
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        //�����¼
        dbCiClaimCompelcrash.insert(ciClaimCompelcrashDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param policyNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String policyNo)
            throws Exception{
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        //ɾ����¼
        dbCiClaimCompelcrash.delete(registNo, policyNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        //������ɾ����¼
        dbCiClaimCompelcrash.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CiClaimCompelcrashDto ciClaimCompelcrashDto)
            throws Exception{
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        //���¼�¼
        dbCiClaimCompelcrash.update(ciClaimCompelcrashDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param policyNo ������
     * @return ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public CiClaimCompelcrashDto findByPrimaryKey(DBManager dbManager,String registNo,String policyNo)
            throws Exception{
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        //����DTO
        CiClaimCompelcrashDto ciClaimCompelcrashDto = null;
        //��ѯ����,��ֵ��DTO
        ciClaimCompelcrashDto = dbCiClaimCompelcrash.findByPrimaryKey(registNo, policyNo);
        return ciClaimCompelcrashDto;
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
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimCompelcrash.getCount(conditions);
        collection = dbCiClaimCompelcrash.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����ciClaimCompelcrashDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCiClaimCompelcrash.findByConditions(conditions);
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
        DBCiClaimCompelcrash dbCiClaimCompelcrash = new DBCiClaimCompelcrash(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimCompelcrash.getCount(conditions);
        return count;
    }
}
