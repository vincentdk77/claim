package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDaccidentDeductDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDaccidentDeduct;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpDaccidentDeduct-�¹����������ʵ�ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDaccidentDeductActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDaccidentDeductActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpDaccidentDeductActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDaccidentDeductDto prpDaccidentDeductDto)
            throws Exception{
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        //�����¼
        dbPrpDaccidentDeduct.insert(prpDaccidentDeductDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param kindCode �ձ����
     * @param indemnityDuty �⳥���δ���
     * @param dangerLevel ����ˮƽ
     * @param deductPeriod ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String kindCode,String indemnityDuty,String dangerLevel,String deductPeriod)
            throws Exception{
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        //ɾ����¼
        dbPrpDaccidentDeduct.delete(riskCode, kindCode, indemnityDuty, dangerLevel, deductPeriod);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        //������ɾ����¼
        dbPrpDaccidentDeduct.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDaccidentDeductDto prpDaccidentDeductDto)
            throws Exception{
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        //���¼�¼
        dbPrpDaccidentDeduct.update(prpDaccidentDeductDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param kindCode �ձ����
     * @param indemnityDuty �⳥���δ���
     * @param dangerLevel ����ˮƽ
     * @param deductPeriod ����
     * @return prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public PrpDaccidentDeductDto findByPrimaryKey(DBManager dbManager,String riskCode,String kindCode,String indemnityDuty,String dangerLevel,String deductPeriod)
            throws Exception{
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        //����DTO
        PrpDaccidentDeductDto prpDaccidentDeductDto = null;
        //��ѯ����,��ֵ��DTO
        prpDaccidentDeductDto = dbPrpDaccidentDeduct.findByPrimaryKey(riskCode, kindCode, indemnityDuty, dangerLevel, deductPeriod);
        
        return prpDaccidentDeductDto;
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
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDaccidentDeduct.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDaccidentDeduct.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDaccidentDeductDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDaccidentDeduct.findByConditions(conditions);
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
        DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDaccidentDeduct.getCount(conditions);
        return count;
    }
}
