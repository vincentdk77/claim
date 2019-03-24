package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDdeductCondDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDdeductCond;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpDdeductCond-�����������ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDdeductCondActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDdeductCondActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpDdeductCondActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDdeductCondDto prpDdeductCondDto)
            throws Exception{
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        //�����¼
        dbPrpDdeductCond.insert(prpDdeductCondDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode ����
     * @param clauseType �������
     * @param kindCode �ձ����
     * @param deductCondCode ������������
     * @param dEDUCTPERIOD ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String clauseType,String kindCode,String deductCondCode,String dEDUCTPERIOD)
            throws Exception{
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        //ɾ����¼
        dbPrpDdeductCond.delete(riskCode, clauseType, kindCode, deductCondCode, dEDUCTPERIOD);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        //������ɾ����¼
        dbPrpDdeductCond.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDdeductCondDto prpDdeductCondDto)
            throws Exception{
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        //���¼�¼
        dbPrpDdeductCond.update(prpDdeductCondDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode ����
     * @param clauseType �������
     * @param kindCode �ձ����
     * @param deductCondCode ������������
     * @param dEDUCTPERIOD ����
     * @return prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public PrpDdeductCondDto findByPrimaryKey(DBManager dbManager,String riskCode,String clauseType,String kindCode,String deductCondCode,String dEDUCTPERIOD)
            throws Exception{
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        //����DTO
        PrpDdeductCondDto prpDdeductCondDto = null;
        //��ѯ����,��ֵ��DTO
        prpDdeductCondDto = dbPrpDdeductCond.findByPrimaryKey(riskCode, clauseType, kindCode, deductCondCode, dEDUCTPERIOD);
        return prpDdeductCondDto;
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
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDdeductCond.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDdeductCond.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDdeductCondDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDdeductCond.findByConditions(conditions);
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
        DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDdeductCond.getCount(conditions);
        return count;
    }
}
