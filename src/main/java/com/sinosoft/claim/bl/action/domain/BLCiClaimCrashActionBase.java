package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.CiClaimCrashDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBCiClaimCrash;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CIClaimCrash ���������¼��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimCrashActionBase{
    private static Log logger = LogFactory.getLog(BLCiClaimCrashActionBase.class);

    /**
     * ���캯��
     */
    public BLCiClaimCrashActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param ciClaimCrashDto ciClaimCrashDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CiClaimCrashDto ciClaimCrashDto)
            throws Exception{
        DBCiClaimCrash dbCiClaimCrash = new DBCiClaimCrash(dbManager);
        //�����¼
        dbCiClaimCrash.insert(ciClaimCrashDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo)
            throws Exception{
        DBCiClaimCrash dbCiClaimCrash = new DBCiClaimCrash(dbManager);
        //ɾ����¼
        dbCiClaimCrash.delete(policyNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimCrash dbCiClaimCrash = new DBCiClaimCrash(dbManager);
        //������ɾ����¼
        dbCiClaimCrash.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param ciClaimCrashDto ciClaimCrashDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CiClaimCrashDto ciClaimCrashDto)
            throws Exception{
        DBCiClaimCrash dbCiClaimCrash = new DBCiClaimCrash(dbManager);
        //���¼�¼
        dbCiClaimCrash.update(ciClaimCrashDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ������
     * @param serialNo ���
     * @return ciClaimCrashDto ciClaimCrashDto
     * @throws Exception
     */
    public CiClaimCrashDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo)
            throws Exception{
        DBCiClaimCrash dbCiClaimCrash = new DBCiClaimCrash(dbManager);
        //����DTO
        CiClaimCrashDto ciClaimCrashDto = null;
        //��ѯ����,��ֵ��DTO
        ciClaimCrashDto = dbCiClaimCrash.findByPrimaryKey(policyNo, serialNo);
        return ciClaimCrashDto;
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
        DBCiClaimCrash dbCiClaimCrash = new DBCiClaimCrash(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimCrash.getCount(conditions);
        collection = dbCiClaimCrash.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����ciClaimCrashDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimCrash dbCiClaimCrash = new DBCiClaimCrash(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCiClaimCrash.findByConditions(conditions);
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
        DBCiClaimCrash dbCiClaimCrash = new DBCiClaimCrash(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimCrash.getCount(conditions);
        return count;
    }
}
