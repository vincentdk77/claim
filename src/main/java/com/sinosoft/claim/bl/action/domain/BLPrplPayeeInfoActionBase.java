package com.sinosoft.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.claim.dto.domain.PrplPayeeInfoDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplPayeeInfo;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrplPayeeInfo��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplPayeeInfoActionBase{
    private static Logger logger = Logger.getLogger(BLPrplPayeeInfoActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplPayeeInfoActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplPayeeInfoDto prplPayeeInfoDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplPayeeInfoDto prplPayeeInfoDto)
            throws Exception{
        DBPrplPayeeInfo dbPrplPayeeInfo = new DBPrplPayeeInfo(dbManager);
        //�����¼
        dbPrplPayeeInfo.insert(prplPayeeInfoDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param receiverFullName receiverFullName
     * @throws Exception
     */
    public void delete(DBManager dbManager,String receiverFullName)
            throws Exception{
        DBPrplPayeeInfo dbPrplPayeeInfo = new DBPrplPayeeInfo(dbManager);
        //ɾ����¼
        dbPrplPayeeInfo.delete(receiverFullName);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplPayeeInfo dbPrplPayeeInfo = new DBPrplPayeeInfo(dbManager);
        //������ɾ����¼
        dbPrplPayeeInfo.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplPayeeInfoDto prplPayeeInfoDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplPayeeInfoDto prplPayeeInfoDto)
            throws Exception{
        DBPrplPayeeInfo dbPrplPayeeInfo = new DBPrplPayeeInfo(dbManager);
        //���¼�¼
        dbPrplPayeeInfo.update(prplPayeeInfoDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param receiverFullName receiverFullName
     * @return prplPayeeInfoDto prplPayeeInfoDto
     * @throws Exception
     */
    public PrplPayeeInfoDto findByPrimaryKey(DBManager dbManager,String receiverFullName)
            throws Exception{
        DBPrplPayeeInfo dbPrplPayeeInfo = new DBPrplPayeeInfo(dbManager);
        //����DTO
        PrplPayeeInfoDto prplPayeeInfoDto = null;
        //��ѯ����,��ֵ��DTO
        prplPayeeInfoDto = dbPrplPayeeInfo.findByPrimaryKey(receiverFullName);
        return prplPayeeInfoDto;
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
        DBPrplPayeeInfo dbPrplPayeeInfo = new DBPrplPayeeInfo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplPayeeInfo.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplPayeeInfo.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplPayeeInfoDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplPayeeInfo dbPrplPayeeInfo = new DBPrplPayeeInfo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplPayeeInfo.findByConditions(conditions);
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
        DBPrplPayeeInfo dbPrplPayeeInfo = new DBPrplPayeeInfo(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplPayeeInfo.getCount(conditions);
        return count;
    }
}
