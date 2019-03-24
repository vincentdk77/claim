package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPackageDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfPackage;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfPackage��������־ҵ����Ϣ����������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.312<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfPackageActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPackageActionBase.class);

    /**
     * ���캯��
     */
    public BLSwfPackageActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param swfPackageDto swfPackageDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfPackageDto swfPackageDto) throws Exception{
        DBSwfPackage dbSwfPackage = new DBSwfPackage(dbManager);
        //�����¼
        dbSwfPackage.insert(swfPackageDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param packageID ��������Ϣ��ID
     * @param detailNo ��ϸ�����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String packageID,int detailNo) throws Exception{
        DBSwfPackage dbSwfPackage = new DBSwfPackage(dbManager);
        //ɾ����¼
        dbSwfPackage.delete(packageID, detailNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfPackage dbSwfPackage = new DBSwfPackage(dbManager);
        //������ɾ����¼
        dbSwfPackage.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param swfPackageDto swfPackageDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfPackageDto swfPackageDto) throws Exception{
        DBSwfPackage dbSwfPackage = new DBSwfPackage(dbManager);
        //���¼�¼
        dbSwfPackage.update(swfPackageDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param packageID ��������Ϣ��ID
     * @param detailNo ��ϸ�����
     * @return swfPackageDto swfPackageDto
     * @throws Exception
     */
    public SwfPackageDto findByPrimaryKey(DBManager dbManager,String packageID,int detailNo) throws Exception{
        DBSwfPackage dbSwfPackage = new DBSwfPackage(dbManager);
        //����DTO
        SwfPackageDto swfPackageDto = null;
        //��ѯ����,��ֵ��DTO
        swfPackageDto = dbSwfPackage.findByPrimaryKey(packageID, detailNo);
        return swfPackageDto;
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
        DBSwfPackage dbSwfPackage = new DBSwfPackage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfPackage.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfPackage.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����swfPackageDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfPackage dbSwfPackage = new DBSwfPackage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfPackage.findByConditions(conditions);
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
        DBSwfPackage dbSwfPackage = new DBSwfPackage(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfPackage.getCount(conditions);
        return count;
    }
}
