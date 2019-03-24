package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCprofitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCprofit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcprofit�Ż���Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCprofitActionBase{
    private static Log log = LogFactory.getLog(BLPrpCprofitActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCprofitActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCprofitDto prpCprofitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCprofitDto prpCprofitDto) throws Exception{
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);
        //�����¼
        dbPrpCprofit.insert(prpCprofitDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ������
     * @param profitType �Ż��ۿ�����
     * @param itemkindNo ����ձ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,String profitType,int itemkindNo) throws Exception{
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);
        //ɾ����¼
        dbPrpCprofit.delete(policyNo, profitType, itemkindNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);
        //������ɾ����¼
        dbPrpCprofit.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCprofitDto prpCprofitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCprofitDto prpCprofitDto) throws Exception{
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);
        //���¼�¼
        dbPrpCprofit.update(prpCprofitDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ������
     * @param profitType �Ż��ۿ�����
     * @param itemkindNo ����ձ����
     * @return prpCprofitDto prpCprofitDto
     * @throws Exception
     */
    public PrpCprofitDto findByPrimaryKey(DBManager dbManager,String policyNo,String profitType,int itemkindNo) throws Exception{
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);
        //����DTO
        PrpCprofitDto prpCprofitDto = null;
        //��ѯ����,��ֵ��DTO
        prpCprofitDto = dbPrpCprofit.findByPrimaryKey(policyNo, profitType, itemkindNo);
        return prpCprofitDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCprofitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCprofit.getCount(conditions);
        collection = dbPrpCprofit.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCprofit.getCount(conditions);
        return count;
    }
}
