package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLendorDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLendor;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLendor��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLendorActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLendorActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLendorActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLendorDto prpLendorDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLendorDto prpLendorDto)
            throws Exception{
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        //�����¼
        dbPrpLendor.insert(prpLendorDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param compensateNo compensateNo
     * @param policyNo policyNo
     * @param itemKindNo itemKindNo
     * @param endorType endorType
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,String policyNo,int itemKindNo,String endorType)
            throws Exception{
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        //ɾ����¼
        dbPrpLendor.delete(compensateNo, policyNo, itemKindNo, endorType);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        //������ɾ����¼
        dbPrpLendor.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLendorDto prpLendorDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLendorDto prpLendorDto)
            throws Exception{
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        //���¼�¼
        dbPrpLendor.update(prpLendorDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param compensateNo compensateNo
     * @param policyNo policyNo
     * @param itemKindNo itemKindNo
     * @param endorType endorType
     * @return prpLendorDto prpLendorDto
     * @throws Exception
     */
    public PrpLendorDto findByPrimaryKey(DBManager dbManager,String compensateNo,String policyNo,int itemKindNo,String endorType)
            throws Exception{
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        //����DTO
        PrpLendorDto prpLendorDto = null;
        //��ѯ����,��ֵ��DTO
        prpLendorDto = dbPrpLendor.findByPrimaryKey(compensateNo, policyNo, itemKindNo, endorType);
        return prpLendorDto;
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
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLendor.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLendor.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLendorDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLendor.findByConditions(conditions);
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
        DBPrpLendor dbPrpLendor = new DBPrpLendor(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLendor.getCount(conditions);
        return count;
    }
}
