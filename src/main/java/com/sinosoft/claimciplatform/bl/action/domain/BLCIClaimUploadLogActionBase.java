package com.sinosoft.claimciplatform.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadLogDto;
import com.sinosoft.claimciplatform.resource.dtofactory.domain.DBCIClaimUploadLog;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����������Ϣ�ϴ�ƽ̨��־���ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadLogActionBase{
    private static Log logger = LogFactory.getLog(BLCIClaimUploadLogActionBase.class);

    /**
     * ���캯��
     */
    public BLCIClaimUploadLogActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param cIClaimUploadLogDto cIClaimUploadLogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CIClaimUploadLogDto cIClaimUploadLogDto)
            throws Exception{
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        //�����¼
        dbCIClaimUploadLog.insert(cIClaimUploadLogDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param uploadNo �ϴ����
     * @param serialNo ˳���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String uploadNo,int serialNo)
            throws Exception{
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        //ɾ����¼
        dbCIClaimUploadLog.delete(uploadNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        //������ɾ����¼
        dbCIClaimUploadLog.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param cIClaimUploadLogDto cIClaimUploadLogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CIClaimUploadLogDto cIClaimUploadLogDto)
            throws Exception{
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        //���¼�¼
        dbCIClaimUploadLog.update(cIClaimUploadLogDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param uploadNo �ϴ����
     * @param serialNo ˳���
     * @return cIClaimUploadLogDto cIClaimUploadLogDto
     * @throws Exception
     */
    public CIClaimUploadLogDto findByPrimaryKey(DBManager dbManager,String uploadNo,int serialNo)
            throws Exception{
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        //����DTO
        CIClaimUploadLogDto cIClaimUploadLogDto = null;
        //��ѯ����,��ֵ��DTO
        cIClaimUploadLogDto = dbCIClaimUploadLog.findByPrimaryKey(uploadNo, serialNo);
        return cIClaimUploadLogDto;
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
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimUploadLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCIClaimUploadLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����cIClaimUploadLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCIClaimUploadLog.findByConditions(conditions);
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
        DBCIClaimUploadLog dbCIClaimUploadLog = new DBCIClaimUploadLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimUploadLog.getCount(conditions);
        return count;
    }
}
