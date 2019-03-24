package com.sinosoft.claimciplatform.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.claimciplatform.resource.dtofactory.domain.DBCIClaimDemand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ��������ƽ̨��ѯ���ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimDemandActionBase{
    private static Log logger = LogFactory.getLog(BLCIClaimDemandActionBase.class);

    /**
     * ���캯��
     */
    public BLCIClaimDemandActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param cIClaimDemandDto cIClaimDemandDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CIClaimDemandDto cIClaimDemandDto)
            throws Exception{
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        //�����¼
        dbCIClaimDemand.insert(cIClaimDemandDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimCode �������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimCode)
            throws Exception{
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        //ɾ����¼
        dbCIClaimDemand.delete(claimCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        //������ɾ����¼
        dbCIClaimDemand.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param cIClaimDemandDto cIClaimDemandDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CIClaimDemandDto cIClaimDemandDto)
            throws Exception{
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        //���¼�¼
        dbCIClaimDemand.update(cIClaimDemandDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimCode �������
     * @return cIClaimDemandDto cIClaimDemandDto
     * @throws Exception
     */
    public CIClaimDemandDto findByPrimaryKey(DBManager dbManager,String claimCode)
            throws Exception{
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        //����DTO
        CIClaimDemandDto cIClaimDemandDto = null;
        //��ѯ����,��ֵ��DTO
        cIClaimDemandDto = dbCIClaimDemand.findByPrimaryKey(claimCode);
        return cIClaimDemandDto;
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
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimDemand.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCIClaimDemand.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����cIClaimDemandDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCIClaimDemand.findByConditions(conditions);
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
        DBCIClaimDemand dbCIClaimDemand = new DBCIClaimDemand(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimDemand.getCount(conditions);
        return count;
    }
}
