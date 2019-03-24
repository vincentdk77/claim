package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCreditInvestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCreditInvest;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpCreditInvest���ŵ�����ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCreditInvestActionBase{
    private static Log log = LogFactory.getLog(BLPrpCreditInvestActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCreditInvestActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCreditInvestDto prpCreditInvestDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCreditInvestDto prpCreditInvestDto) throws Exception{
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);
        //�����¼
        dbPrpCreditInvest.insert(prpCreditInvestDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param investigateNo ����Ԥ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String investigateNo) throws Exception{
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);
        //ɾ����¼
        dbPrpCreditInvest.delete(investigateNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);
        //������ɾ����¼
        dbPrpCreditInvest.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCreditInvestDto prpCreditInvestDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCreditInvestDto prpCreditInvestDto) throws Exception{
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);
        //���¼�¼
        dbPrpCreditInvest.update(prpCreditInvestDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param investigateNo ����Ԥ����
     * @return prpCreditInvestDto prpCreditInvestDto
     * @throws Exception
     */
    public PrpCreditInvestDto findByPrimaryKey(DBManager dbManager,String investigateNo) throws Exception{
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);
        //����DTO
        PrpCreditInvestDto prpCreditInvestDto = null;
        //��ѯ����,��ֵ��DTO
        prpCreditInvestDto = dbPrpCreditInvest.findByPrimaryKey(investigateNo);
        return prpCreditInvestDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCreditInvestDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCreditInvest.getCount(conditions);
        collection = dbPrpCreditInvest.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCreditInvest.getCount(conditions);
        return count;
    }
}
