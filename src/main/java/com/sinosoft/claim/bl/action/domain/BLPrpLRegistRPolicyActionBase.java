package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLRegistRPolicy;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLRegistRPolicy�ⰸ�����������ҵ���߼�������<br>
 * ������ 2006-06-04 15:22:15.007<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLRegistRPolicyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLRegistRPolicyActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLRegistRPolicyActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLRegistRPolicyDto prpLRegistRPolicyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLRegistRPolicyDto prpLRegistRPolicyDto) throws Exception{
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        //�����¼
        dbPrpLRegistRPolicy.insert(prpLRegistRPolicyDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param policyNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String policyNo) throws Exception{
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        //ɾ����¼
        dbPrpLRegistRPolicy.delete(registNo, policyNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        //������ɾ����¼
        dbPrpLRegistRPolicy.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLRegistRPolicyDto prpLRegistRPolicyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLRegistRPolicyDto prpLRegistRPolicyDto) throws Exception{
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        //���¼�¼
        dbPrpLRegistRPolicy.update(prpLRegistRPolicyDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param policyNo ������
     * @return prpLRegistRPolicyDto prpLRegistRPolicyDto
     * @throws Exception
     */
    public PrpLRegistRPolicyDto findByPrimaryKey(DBManager dbManager,String registNo,String policyNo) throws Exception{
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        //����DTO
        PrpLRegistRPolicyDto prpLRegistRPolicyDto = null;
        //��ѯ����,��ֵ��DTO
        prpLRegistRPolicyDto = dbPrpLRegistRPolicy.findByPrimaryKey(registNo, policyNo);
        return prpLRegistRPolicyDto;
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
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLRegistRPolicy.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLRegistRPolicy.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLRegistRPolicyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLRegistRPolicy.findByConditions(conditions);
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
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLRegistRPolicy.getCount(conditions);
        return count;
    }
}
