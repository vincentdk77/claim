package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleCompanyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleCompany;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleCompany--����������ʾ��Ϣ���ñ��ҵ���߼�������<br>
 * ������ 2005-08-20 17:56:01.505<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLscheduleCompanyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleCompanyActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleCompanyActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLscheduleCompanyDto prpLscheduleCompanyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLscheduleCompanyDto prpLscheduleCompanyDto) throws Exception{
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        //�����¼
        dbPrpLscheduleCompany.insert(prpLscheduleCompanyDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param comCode �������Ļ�������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String comCode) throws Exception{
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        //ɾ����¼
        dbPrpLscheduleCompany.delete(comCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        //������ɾ����¼
        dbPrpLscheduleCompany.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLscheduleCompanyDto prpLscheduleCompanyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLscheduleCompanyDto prpLscheduleCompanyDto) throws Exception{
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        //���¼�¼
        dbPrpLscheduleCompany.update(prpLscheduleCompanyDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param comCode �������Ļ�������
     * @return prpLscheduleCompanyDto prpLscheduleCompanyDto
     * @throws Exception
     */
    public PrpLscheduleCompanyDto findByPrimaryKey(DBManager dbManager,String comCode) throws Exception{
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        //����DTO
        PrpLscheduleCompanyDto prpLscheduleCompanyDto = null;
        //��ѯ����,��ֵ��DTO
        prpLscheduleCompanyDto = dbPrpLscheduleCompany.findByPrimaryKey(comCode);
        return prpLscheduleCompanyDto;
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
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleCompany.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLscheduleCompany.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLscheduleCompanyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLscheduleCompany.findByConditions(conditions);
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
        DBPrpLscheduleCompany dbPrpLscheduleCompany = new DBPrpLscheduleCompany(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLscheduleCompany.getCount(conditions);
        return count;
    }
}
