package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDshortRateDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDshortRate;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdshortrate�¶��ڷ��ʱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDshortRateActionBase{
    private static Log log = LogFactory.getLog(BLPrpDshortRateActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDshortRateActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDshortRateDto prpDshortRateDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDshortRateDto prpDshortRateDto) throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);
        //�����¼
        dbPrpDshortRate.insert(prpDshortRateDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param months �·���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,int months) throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);
        //ɾ����¼
        dbPrpDshortRate.delete(riskCode, months);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);
        //������ɾ����¼
        dbPrpDshortRate.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDshortRateDto prpDshortRateDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDshortRateDto prpDshortRateDto) throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);
        //���¼�¼
        dbPrpDshortRate.update(prpDshortRateDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param months �·���
     * @return prpDshortRateDto prpDshortRateDto
     * @throws Exception
     */
    public PrpDshortRateDto findByPrimaryKey(DBManager dbManager,String riskCode,int months) throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);
        //����DTO
        PrpDshortRateDto prpDshortRateDto = null;
        //��ѯ����,��ֵ��DTO
        prpDshortRateDto = dbPrpDshortRate.findByPrimaryKey(riskCode, months);
        return prpDshortRateDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDshortRateDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDshortRate.getCount(conditions);
        collection = dbPrpDshortRate.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDshortRate.getCount(conditions);
        return count;
    }
}
