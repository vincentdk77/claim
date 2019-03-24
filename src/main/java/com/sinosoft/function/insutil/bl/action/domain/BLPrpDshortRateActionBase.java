package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDshortRateDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDshortRate;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdshortrate��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDshortRateActionBase{
    private static Log log = LogFactory.getLog(BLPrpDshortRateActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

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
     * @param riskCode riskcode
     * @param months months
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
     * @param riskCode riskcode
     * @param months months
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

        count = dbPrpDshortRate.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDshortRate.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDshortRateDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getCount(){
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDshortRate.getCount(conditions);
        return count;
    }
}
