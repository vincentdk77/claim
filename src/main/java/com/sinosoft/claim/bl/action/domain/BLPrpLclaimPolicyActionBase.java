package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimPolicyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimPolicy;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimPolicy-���������嵥���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.171<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimPolicyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimPolicyActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimPolicyActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimPolicyDto prpLclaimPolicyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimPolicyDto prpLclaimPolicyDto) throws Exception{
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        //�����¼
        dbPrpLclaimPolicy.insert(prpLclaimPolicyDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param policyNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,String policyNo) throws Exception{
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        //ɾ����¼
        dbPrpLclaimPolicy.delete(claimNo, policyNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        //������ɾ����¼
        dbPrpLclaimPolicy.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimPolicyDto prpLclaimPolicyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimPolicyDto prpLclaimPolicyDto) throws Exception{
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        //���¼�¼
        dbPrpLclaimPolicy.update(prpLclaimPolicyDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param policyNo ������
     * @return prpLclaimPolicyDto prpLclaimPolicyDto
     * @throws Exception
     */
    public PrpLclaimPolicyDto findByPrimaryKey(DBManager dbManager,String claimNo,String policyNo) throws Exception{
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        //����DTO
        PrpLclaimPolicyDto prpLclaimPolicyDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimPolicyDto = dbPrpLclaimPolicy.findByPrimaryKey(claimNo, policyNo);
        return prpLclaimPolicyDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimPolicy.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimPolicy.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimPolicyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimPolicy.findByConditions(conditions);
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
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimPolicy.getCount(conditions);
        return count;
    }
}
