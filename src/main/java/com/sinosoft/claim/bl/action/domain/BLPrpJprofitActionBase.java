package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJprofitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJprofit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjprofit�Żݼ�¼���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJprofitActionBase{
    private static Log log = LogFactory.getLog(BLPrpJprofitActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpJprofitActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJprofitDto prpJprofitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJprofitDto prpJprofitDto) throws Exception{
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);
        //�����¼
        dbPrpJprofit.insert(prpJprofitDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ���յ��Ŵ�
     * @param profitNo �Ż����
     * @param itemKindNo ����ձ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int profitNo,int itemKindNo) throws Exception{
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);
        //ɾ����¼
        dbPrpJprofit.delete(policyNo, profitNo, itemKindNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);
        //������ɾ����¼
        dbPrpJprofit.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJprofitDto prpJprofitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJprofitDto prpJprofitDto) throws Exception{
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);
        //���¼�¼
        dbPrpJprofit.update(prpJprofitDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ���յ��Ŵ�
     * @param profitNo �Ż����
     * @param itemKindNo ����ձ����
     * @return prpJprofitDto prpJprofitDto
     * @throws Exception
     */
    public PrpJprofitDto findByPrimaryKey(DBManager dbManager,String policyNo,int profitNo,int itemKindNo) throws Exception{
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);
        //����DTO
        PrpJprofitDto prpJprofitDto = null;
        //��ѯ����,��ֵ��DTO
        prpJprofitDto = dbPrpJprofit.findByPrimaryKey(policyNo, profitNo, itemKindNo);
        return prpJprofitDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpJprofitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJprofit.getCount(conditions);
        collection = dbPrpJprofit.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJprofit.getCount(conditions);
        return count;
    }
}
