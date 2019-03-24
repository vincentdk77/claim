package com.sinosoft.ciplatform.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.ciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBCIClaimUploadRegist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����������Ϣƽ̨�ϴ�ע����ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadRegistActionBase{
    private static Logger logger = Logger.getLogger(BLCIClaimUploadRegistActionBase.class);

    /**
     * ���캯��
     */
    public BLCIClaimUploadRegistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CIClaimUploadRegistDto cIClaimUploadRegistDto)
            throws Exception{
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        //�����¼
        dbCIClaimUploadRegist.insert(cIClaimUploadRegistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param uploadNo �ϴ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String uploadNo)
            throws Exception{
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        //ɾ����¼
        dbCIClaimUploadRegist.delete(uploadNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        //������ɾ����¼
        dbCIClaimUploadRegist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CIClaimUploadRegistDto cIClaimUploadRegistDto)
            throws Exception{
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        //���¼�¼
        dbCIClaimUploadRegist.update(cIClaimUploadRegistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param uploadNo �ϴ����
     * @return cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @throws Exception
     */
    public CIClaimUploadRegistDto findByPrimaryKey(DBManager dbManager,String uploadNo)
            throws Exception{
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        //����DTO
        CIClaimUploadRegistDto cIClaimUploadRegistDto = null;
        //��ѯ����,��ֵ��DTO
        cIClaimUploadRegistDto = dbCIClaimUploadRegist.findByPrimaryKey(uploadNo);
        return cIClaimUploadRegistDto;
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
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimUploadRegist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCIClaimUploadRegist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����cIClaimUploadRegistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCIClaimUploadRegist.findByConditions(conditions);
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
        DBCIClaimUploadRegist dbCIClaimUploadRegist = new DBCIClaimUploadRegist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimUploadRegist.getCount(conditions);
        return count;
    }
}
