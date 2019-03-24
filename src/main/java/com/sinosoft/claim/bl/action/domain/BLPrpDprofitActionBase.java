package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDprofitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDprofit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdprofit�Ż��ۿ��������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDprofitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDprofitActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDprofitActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDprofitDto prpDprofitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDprofitDto prpDprofitDto) throws Exception{
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);
        //�����¼
        dbPrpDprofit.insert(prpDprofitDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param comcode ��������
     * @param riskCode ����
     * @param profitPeriod ����
     * @param profitCode �Ż��ۿ۴���
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String comcode,String riskCode,int profitPeriod,String profitCode,int serialNo) throws Exception{
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);
        //ɾ����¼
        dbPrpDprofit.delete(comcode, riskCode, profitPeriod, profitCode, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);
        //������ɾ����¼
        dbPrpDprofit.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDprofitDto prpDprofitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDprofitDto prpDprofitDto) throws Exception{
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);
        //���¼�¼
        dbPrpDprofit.update(prpDprofitDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param comcode ��������
     * @param riskCode ����
     * @param profitPeriod ����
     * @param profitCode �Ż��ۿ۴���
     * @param serialNo ���
     * @return prpDprofitDto prpDprofitDto
     * @throws Exception
     */
    public PrpDprofitDto findByPrimaryKey(DBManager dbManager,String comcode,String riskCode,int profitPeriod,String profitCode,int serialNo) throws Exception{
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);
        //����DTO
        PrpDprofitDto prpDprofitDto = null;
        //��ѯ����,��ֵ��DTO
        prpDprofitDto = dbPrpDprofit.findByPrimaryKey(comcode, riskCode, profitPeriod, profitCode, serialNo);
        return prpDprofitDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDprofitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDprofit.getCount(conditions);
        collection = dbPrpDprofit.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDprofit.getCount(conditions);
        return count;
    }
}
