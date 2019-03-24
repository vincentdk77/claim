package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLarrearageDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLarrearage;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLarrearage-���Ƿ���嵥���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.203<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLarrearageActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLarrearageActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLarrearageActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLarrearageDto prpLarrearageDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLarrearageDto prpLarrearageDto) throws Exception{
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        //�����¼
        dbPrpLarrearage.insert(prpLarrearageDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ������
     * @param arrearageEndDate ����Ӧ�����ֹ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,DateTime arrearageEndDate) throws Exception{
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        //ɾ����¼
        dbPrpLarrearage.delete(policyNo, arrearageEndDate);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        //������ɾ����¼
        dbPrpLarrearage.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLarrearageDto prpLarrearageDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLarrearageDto prpLarrearageDto) throws Exception{
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        //���¼�¼
        dbPrpLarrearage.update(prpLarrearageDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ������
     * @param arrearageEndDate ����Ӧ�����ֹ����
     * @return prpLarrearageDto prpLarrearageDto
     * @throws Exception
     */
    public PrpLarrearageDto findByPrimaryKey(DBManager dbManager,String policyNo,DateTime arrearageEndDate) throws Exception{
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        //����DTO
        PrpLarrearageDto prpLarrearageDto = null;
        //��ѯ����,��ֵ��DTO
        prpLarrearageDto = dbPrpLarrearage.findByPrimaryKey(policyNo, arrearageEndDate);
        return prpLarrearageDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLarrearage.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLarrearage.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLarrearageDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLarrearage.findByConditions(conditions);
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
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLarrearage.getCount(conditions);
        return count;
    }
}
