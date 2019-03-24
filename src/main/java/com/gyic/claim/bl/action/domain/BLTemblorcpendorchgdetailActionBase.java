package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorcpendorchgdetailDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorcpendorchgdetail;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORCPENDORCHGDETAIL��ҵ���߼�������<br>
 */
public class BLTemblorcpendorchgdetailActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorcpendorchgdetailActionBase.class);

    /**
     * ���캯��
     */
    public BLTemblorcpendorchgdetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param temblorcpendorchgdetailDto temblorcpendorchgdetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TemblorcpendorchgdetailDto temblorcpendorchgdetailDto)
            throws Exception{
        DBTemblorcpendorchgdetail dbTemblorcpendorchgdetail = new DBTemblorcpendorchgdetail(dbManager);
        //�����¼
        dbTemblorcpendorchgdetail.insert(temblorcpendorchgdetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        DBTemblorcpendorchgdetail dbTemblorcpendorchgdetail = new DBTemblorcpendorchgdetail(dbManager);
        //ɾ����¼
        dbTemblorcpendorchgdetail.delete(inusrelistcode, kindcode, itemcode, address, idcard);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorcpendorchgdetail dbTemblorcpendorchgdetail = new DBTemblorcpendorchgdetail(dbManager);
        //������ɾ����¼
        dbTemblorcpendorchgdetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param temblorcpendorchgdetailDto temblorcpendorchgdetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TemblorcpendorchgdetailDto temblorcpendorchgdetailDto)
            throws Exception{
        DBTemblorcpendorchgdetail dbTemblorcpendorchgdetail = new DBTemblorcpendorchgdetail(dbManager);
        //���¼�¼
        dbTemblorcpendorchgdetail.update(temblorcpendorchgdetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return temblorcpendorchgdetailDto temblorcpendorchgdetailDto
     * @throws Exception
     */
    public TemblorcpendorchgdetailDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        DBTemblorcpendorchgdetail dbTemblorcpendorchgdetail = new DBTemblorcpendorchgdetail(dbManager);
        //����DTO
        TemblorcpendorchgdetailDto temblorcpendorchgdetailDto = null;
        //��ѯ����,��ֵ��DTO
        temblorcpendorchgdetailDto = dbTemblorcpendorchgdetail.findByPrimaryKey(inusrelistcode, kindcode, itemcode, address, idcard);
        return temblorcpendorchgdetailDto;
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
        DBTemblorcpendorchgdetail dbTemblorcpendorchgdetail = new DBTemblorcpendorchgdetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorcpendorchgdetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTemblorcpendorchgdetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����temblorcpendorchgdetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorcpendorchgdetail dbTemblorcpendorchgdetail = new DBTemblorcpendorchgdetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTemblorcpendorchgdetail.findByConditions(conditions);
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
        DBTemblorcpendorchgdetail dbTemblorcpendorchgdetail = new DBTemblorcpendorchgdetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorcpendorchgdetail.getCount(conditions);
        return count;
    }
}
