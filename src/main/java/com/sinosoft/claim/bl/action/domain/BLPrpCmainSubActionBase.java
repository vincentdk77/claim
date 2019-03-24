package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainSubDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmainSub;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcmainsub�����������ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCmainSubActionBase{
    private static Log log = LogFactory.getLog(BLPrpCmainSubActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCmainSubActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCmainSubDto prpCmainSubDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCmainSubDto prpCmainSubDto) throws Exception{
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);
        //�����¼
        dbPrpCmainSub.insert(prpCmainSubDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param mainPolicyNo ����������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,String mainPolicyNo) throws Exception{
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);
        //ɾ����¼
        dbPrpCmainSub.delete(policyNo, mainPolicyNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);
        //������ɾ����¼
        dbPrpCmainSub.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCmainSubDto prpCmainSubDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCmainSubDto prpCmainSubDto) throws Exception{
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);
        //���¼�¼
        dbPrpCmainSub.update(prpCmainSubDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @param mainPolicyNo ����������
     * @return prpCmainSubDto prpCmainSubDto
     * @throws Exception
     */
    public PrpCmainSubDto findByPrimaryKey(DBManager dbManager,String policyNo,String mainPolicyNo) throws Exception{
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);
        //����DTO
        PrpCmainSubDto prpCmainSubDto = null;
        //��ѯ����,��ֵ��DTO
        prpCmainSubDto = dbPrpCmainSub.findByPrimaryKey(policyNo, mainPolicyNo);
        return prpCmainSubDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCmainSubDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCmainSub.getCount(conditions);
        collection = dbPrpCmainSub.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpCmainSub dbPrpCmainSub = new DBPrpCmainSub(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCmainSub.getCount(conditions);
        return count;
    }
}
