package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDdeprecateRateDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDdeprecateRate;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpddeprecaterate�۾��ʱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDdeprecateRateActionBase{
    private static Log log = LogFactory.getLog(BLPrpDdeprecateRateActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDdeprecateRateActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDdeprecateRateDto prpDdeprecateRateDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDdeprecateRateDto prpDdeprecateRateDto) throws Exception{
        DBPrpDdeprecateRate dbPrpDdeprecateRate = new DBPrpDdeprecateRate(dbManager);
        //�����¼
        dbPrpDdeprecateRate.insert(prpDdeprecateRateDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param clauseType �������
     * @param carKindCode �����������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String clauseType,String carKindCode) throws Exception{
        DBPrpDdeprecateRate dbPrpDdeprecateRate = new DBPrpDdeprecateRate(dbManager);
        //ɾ����¼
        dbPrpDdeprecateRate.delete(riskCode, clauseType, carKindCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDdeprecateRate dbPrpDdeprecateRate = new DBPrpDdeprecateRate(dbManager);
        //������ɾ����¼
        dbPrpDdeprecateRate.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDdeprecateRateDto prpDdeprecateRateDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDdeprecateRateDto prpDdeprecateRateDto) throws Exception{
        DBPrpDdeprecateRate dbPrpDdeprecateRate = new DBPrpDdeprecateRate(dbManager);
        //���¼�¼
        dbPrpDdeprecateRate.update(prpDdeprecateRateDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param clauseType �������
     * @param carKindCode �����������
     * @return prpDdeprecateRateDto prpDdeprecateRateDto
     * @throws Exception
     */
    public PrpDdeprecateRateDto findByPrimaryKey(DBManager dbManager,String riskCode,String clauseType,String carKindCode) throws Exception{
        DBPrpDdeprecateRate dbPrpDdeprecateRate = new DBPrpDdeprecateRate(dbManager);
        //����DTO
        PrpDdeprecateRateDto prpDdeprecateRateDto = null;
        //��ѯ����,��ֵ��DTO
        prpDdeprecateRateDto = dbPrpDdeprecateRate.findByPrimaryKey(riskCode, clauseType, carKindCode);
        return prpDdeprecateRateDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDdeprecateRateDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDdeprecateRate dbPrpDdeprecateRate = new DBPrpDdeprecateRate(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDdeprecateRate.getCount(conditions);
        collection = dbPrpDdeprecateRate.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDdeprecateRate dbPrpDdeprecateRate = new DBPrpDdeprecateRate(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDdeprecateRate.getCount(conditions);
        return count;
    }
}
