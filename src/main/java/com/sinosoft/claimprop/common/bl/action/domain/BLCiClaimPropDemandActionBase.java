package com.sinosoft.claimprop.common.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropDemandDto;
import com.sinosoft.claimprop.common.resource.dtofactory.domain.DBCiClaimPropDemand;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CiClaimPropDemand��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimPropDemandActionBase{
    private static Logger logger = Logger.getLogger(BLCiClaimPropDemandActionBase.class);

    /**
     * ���캯��
     */
    public BLCiClaimPropDemandActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CiClaimPropDemandDto ciClaimPropDemandDto)
            throws Exception{
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        //�����¼
        dbCiClaimPropDemand.insert(ciClaimPropDemandDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimCode claimCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimCode)
            throws Exception{
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        //ɾ����¼
        dbCiClaimPropDemand.delete(claimCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        //������ɾ����¼
        dbCiClaimPropDemand.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CiClaimPropDemandDto ciClaimPropDemandDto)
            throws Exception{
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        //���¼�¼
        dbCiClaimPropDemand.update(ciClaimPropDemandDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimCode claimCode
     * @return ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public CiClaimPropDemandDto findByPrimaryKey(DBManager dbManager,String claimCode)
            throws Exception{
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        //����DTO
        CiClaimPropDemandDto ciClaimPropDemandDto = null;
        //��ѯ����,��ֵ��DTO
        ciClaimPropDemandDto = dbCiClaimPropDemand.findByPrimaryKey(claimCode);
        return ciClaimPropDemandDto;
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
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimPropDemand.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCiClaimPropDemand.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����ciClaimPropDemandDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCiClaimPropDemand.findByConditions(conditions);
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
        DBCiClaimPropDemand dbCiClaimPropDemand = new DBCiClaimPropDemand(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimPropDemand.getCount(conditions);
        return count;
    }
}
