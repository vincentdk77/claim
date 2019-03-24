package com.sinosoft.claimzy.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;


import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.claimzy.resource.dtofactory.domain.DBAgriClaimUploadLog;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLAgriClaimUploadLog��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLAgriClaimUploadLogActionBase {
	private static Logger logger = Logger.getLogger(BLAgriClaimUploadLogActionBase.class);

    /**
     * ���캯��
     */
    public BLAgriClaimUploadLogActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,AgriClaimUploadLogDto agriClaimUploadLogDto)
            throws Exception{
        DBAgriClaimUploadLog dbAgriClaimUploadLog = new DBAgriClaimUploadLog(dbManager);
        //�����¼
        dbAgriClaimUploadLog.insert(agriClaimUploadLogDto);
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
    public void update(DBManager dbManager,AgriClaimUploadLogDto agriClaimUploadLogDto)
            throws Exception{
        DBAgriClaimUploadLog DBAgriClaimUploadLog = new DBAgriClaimUploadLog(dbManager);
        //���¼�¼
        DBAgriClaimUploadLog.update(agriClaimUploadLogDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimCode �������
     * @return aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public AgriClaimUploadLogDto findByPrimaryKey(DBManager dbManager,String batchNo)
            throws Exception{
        DBAgriClaimUploadLog DBAgriClaimUploadLog = new DBAgriClaimUploadLog(dbManager);
        //����DTO
        AgriClaimUploadLogDto agriClaimUploadLogDto = null;
        //��ѯ����,��ֵ��DTO
        agriClaimUploadLogDto = DBAgriClaimUploadLog.findByPrimaryKey(batchNo);
        return agriClaimUploadLogDto;
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
