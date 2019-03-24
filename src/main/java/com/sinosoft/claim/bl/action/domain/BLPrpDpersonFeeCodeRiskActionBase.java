package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDpersonFeeCodeRiskDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDpersonFeeCodeRisk;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpDpersonFeeCodeRisk-���˷������ֶ��ձ��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDpersonFeeCodeRiskActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDpersonFeeCodeRiskActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpDpersonFeeCodeRiskActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto)
            throws Exception{
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        //�����¼
        dbPrpDpersonFeeCodeRisk.insert(prpDpersonFeeCodeRiskDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param feeCode ���ô���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String feeCode)
            throws Exception{
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        //ɾ����¼
        dbPrpDpersonFeeCodeRisk.delete(riskCode, feeCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        //������ɾ����¼
        dbPrpDpersonFeeCodeRisk.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto)
            throws Exception{
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        //���¼�¼
        dbPrpDpersonFeeCodeRisk.update(prpDpersonFeeCodeRiskDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param feeCode ���ô���
     * @return prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public PrpDpersonFeeCodeRiskDto findByPrimaryKey(DBManager dbManager,String riskCode,String feeCode)
            throws Exception{
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        //����DTO
        PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto = null;
        //��ѯ����,��ֵ��DTO
        prpDpersonFeeCodeRiskDto = dbPrpDpersonFeeCodeRisk.findByPrimaryKey(riskCode, feeCode);
        return prpDpersonFeeCodeRiskDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDpersonFeeCodeRisk.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDpersonFeeCodeRisk.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDpersonFeeCodeRiskDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDpersonFeeCodeRisk.findByConditions(conditions);
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
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDpersonFeeCodeRisk.getCount(conditions);
        return count;
    }
}
