package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrateUsualDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDrateUsual;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrateusual��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateUsualActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateUsualActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDrateUsualActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDrateUsualDto prpDrateUsualDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDrateUsualDto prpDrateUsualDto) throws Exception{
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);
        //�����¼
        dbPrpDrateUsual.insert(prpDrateUsualDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param ratePeriod rateperiod
     * @param rateCode ratecode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,int ratePeriod,String rateCode) throws Exception{
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);
        //ɾ����¼
        dbPrpDrateUsual.delete(riskCode, ratePeriod, rateCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);
        //������ɾ����¼
        dbPrpDrateUsual.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDrateUsualDto prpDrateUsualDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDrateUsualDto prpDrateUsualDto) throws Exception{
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);
        //���¼�¼
        dbPrpDrateUsual.update(prpDrateUsualDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode riskcode
     * @param ratePeriod rateperiod
     * @param rateCode ratecode
     * @return prpDrateUsualDto prpDrateUsualDto
     * @throws Exception
     */
    public PrpDrateUsualDto findByPrimaryKey(DBManager dbManager,String riskCode,int ratePeriod,String rateCode) throws Exception{
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);
        //����DTO
        PrpDrateUsualDto prpDrateUsualDto = null;
        //��ѯ����,��ֵ��DTO
        prpDrateUsualDto = dbPrpDrateUsual.findByPrimaryKey(riskCode, ratePeriod, rateCode);
        return prpDrateUsualDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDrateUsualDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDrateUsual.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDrateUsual.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDrateUsualDto�ļ���
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
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrateUsual.getCount(conditions);
        return count;
    }
}
