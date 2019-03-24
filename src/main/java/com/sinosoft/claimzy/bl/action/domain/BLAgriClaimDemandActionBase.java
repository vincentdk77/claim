package com.sinosoft.claimzy.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claimzy.dto.domain.AgriClaimDemandDto;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.claimzy.resource.dtofactory.domain.DBAgriClaimDemand;
import com.sinosoft.claimzy.resource.dtofactory.domain.DBAgriClaimUploadLog;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLAgriClaimDemand��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLAgriClaimDemandActionBase {
	private static Logger logger = Logger.getLogger(BLAgriClaimDemandActionBase.class);

    /**
     * ���캯��
     */
    public BLAgriClaimDemandActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,AgriClaimDemandDto agriClaimDemandDto)
            throws Exception{
        DBAgriClaimDemand dbAgriClaimDemand = new DBAgriClaimDemand(dbManager);
        //�����¼
        dbAgriClaimDemand.insert(agriClaimDemandDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimCode �������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String batchNo)
            throws Exception{
        DBAgriClaimUploadLog DBAgriClaimUploadLog = new DBAgriClaimUploadLog(dbManager);
        //ɾ����¼
        DBAgriClaimUploadLog.delete(batchNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBAgriClaimUploadLog DBAgriClaimUploadLog = new DBAgriClaimUploadLog(dbManager);
        //������ɾ����¼
        DBAgriClaimUploadLog.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public void update(DBManager dbManager,AgriClaimDemandDto agriClaimDemandDto)
            throws Exception{
        DBAgriClaimDemand dbAgriClaimDemand= new DBAgriClaimDemand(dbManager);
        //���¼�¼
        dbAgriClaimDemand.update(agriClaimDemandDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimCode �������
     * @return aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public AgriClaimDemandDto findByPrimaryKey(DBManager dbManager,String batchNo)
            throws Exception{
        DBAgriClaimDemand dbAgriClaimDemand = new DBAgriClaimDemand(dbManager);
        //����DTO
        AgriClaimDemandDto agriClaimDemandDto = null;
        //��ѯ����,��ֵ��DTO
        agriClaimDemandDto = dbAgriClaimDemand.findByPrimaryKey(batchNo);
        return agriClaimDemandDto;
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
        DBAgriClaimUploadLog DBAgriClaimUploadLog = new DBAgriClaimUploadLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = DBAgriClaimUploadLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = DBAgriClaimUploadLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����aGRICLAIMUPLOADLOGDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBAgriClaimUploadLog DBAgriClaimUploadLog = new DBAgriClaimUploadLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = DBAgriClaimUploadLog.findByConditions(conditions);
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
        DBAgriClaimUploadLog DBAgriClaimUploadLog = new DBAgriClaimUploadLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = DBAgriClaimUploadLog.getCount(conditions);
        return count;
    }
}
