package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxendorchgdetailDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxendorchgdetail;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXENDORCHGDETAIL��ҵ���߼�������<br>
 */
public class BLNyxendorchgdetailActionBase{
    private static Logger logger = Logger.getLogger(BLNyxendorchgdetailActionBase.class);

    /**
     * ���캯��
     */
    public BLNyxendorchgdetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param nyxendorchgdetailDto nyxendorchgdetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxendorchgdetailDto nyxendorchgdetailDto)
            throws Exception{
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        //�����¼
        dbNyxendorchgdetail.insert(nyxendorchgdetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String businessno,String endorseno,String kindcode,String itemcode)
            throws Exception{
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        //ɾ����¼
        dbNyxendorchgdetail.delete(inusrelistcode, businessno, endorseno, kindcode, itemcode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        //������ɾ����¼
        dbNyxendorchgdetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param nyxendorchgdetailDto nyxendorchgdetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxendorchgdetailDto nyxendorchgdetailDto)
            throws Exception{
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        //���¼�¼
        dbNyxendorchgdetail.update(nyxendorchgdetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return nyxendorchgdetailDto nyxendorchgdetailDto
     * @throws Exception
     */
    public NyxendorchgdetailDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String businessno,String endorseno,String kindcode,String itemcode)
            throws Exception{
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        //����DTO
        NyxendorchgdetailDto nyxendorchgdetailDto = null;
        //��ѯ����,��ֵ��DTO
        nyxendorchgdetailDto = dbNyxendorchgdetail.findByPrimaryKey(inusrelistcode, businessno, endorseno, kindcode, itemcode);
        return nyxendorchgdetailDto;
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
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxendorchgdetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxendorchgdetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����nyxendorchgdetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxendorchgdetail.findByConditions(conditions);
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
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxendorchgdetail.getCount(conditions);
        return count;
    }
}
