package com.sinosoft.claimprop.common.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropUploadLogDto;
import com.sinosoft.claimprop.common.resource.dtofactory.domain.DBCiClaimPropUploadLog;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CiClaimPropUploadLog��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimPropUploadLogActionBase{
    private static Logger logger = Logger.getLogger(BLCiClaimPropUploadLogActionBase.class);

    /**
     * ���캯��
     */
    public BLCiClaimPropUploadLogActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CiClaimPropUploadLogDto ciClaimPropUploadLogDto)
            throws Exception{
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        //�����¼
        dbCiClaimPropUploadLog.insert(ciClaimPropUploadLogDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param businessNo businessNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessNo)
            throws Exception{
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        //ɾ����¼
        dbCiClaimPropUploadLog.delete(businessNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        //������ɾ����¼
        dbCiClaimPropUploadLog.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CiClaimPropUploadLogDto ciClaimPropUploadLogDto)
            throws Exception{
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        //���¼�¼
        dbCiClaimPropUploadLog.update(ciClaimPropUploadLogDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param businessNo businessNo
     * @return ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public CiClaimPropUploadLogDto findByPrimaryKey(DBManager dbManager,String businessNo)
            throws Exception{
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        //����DTO
        CiClaimPropUploadLogDto ciClaimPropUploadLogDto = null;
        //��ѯ����,��ֵ��DTO
        ciClaimPropUploadLogDto = dbCiClaimPropUploadLog.findByPrimaryKey(businessNo);
        return ciClaimPropUploadLogDto;
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
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimPropUploadLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCiClaimPropUploadLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����ciClaimPropUploadLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCiClaimPropUploadLog.findByConditions(conditions);
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
        DBCiClaimPropUploadLog dbCiClaimPropUploadLog = new DBCiClaimPropUploadLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCiClaimPropUploadLog.getCount(conditions);
        return count;
    }
}
