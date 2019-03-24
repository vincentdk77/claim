package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorendorchgdetailDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorendorchgdetail;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORENDORCHGDETAIL��ҵ���߼�������<br>
 */
public class BLTemblorendorchgdetailActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorendorchgdetailActionBase.class);

    /**
     * ���캯��
     */
    public BLTemblorendorchgdetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param temblorendorchgdetailDto temblorendorchgdetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TemblorendorchgdetailDto temblorendorchgdetailDto)
            throws Exception{
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        //�����¼
        dbTemblorendorchgdetail.insert(temblorendorchgdetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String endorseno,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        //ɾ����¼
        dbTemblorendorchgdetail.delete(inusrelistcode, endorseno, kindcode, itemcode, address, idcard);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        //������ɾ����¼
        dbTemblorendorchgdetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param temblorendorchgdetailDto temblorendorchgdetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TemblorendorchgdetailDto temblorendorchgdetailDto)
            throws Exception{
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        //���¼�¼
        dbTemblorendorchgdetail.update(temblorendorchgdetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return temblorendorchgdetailDto temblorendorchgdetailDto
     * @throws Exception
     */
    public TemblorendorchgdetailDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String endorseno,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        //����DTO
        TemblorendorchgdetailDto temblorendorchgdetailDto = null;
        //��ѯ����,��ֵ��DTO
        temblorendorchgdetailDto = dbTemblorendorchgdetail.findByPrimaryKey(inusrelistcode, endorseno, kindcode, itemcode, address, idcard);
        return temblorendorchgdetailDto;
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
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorendorchgdetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTemblorendorchgdetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����temblorendorchgdetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTemblorendorchgdetail.findByConditions(conditions);
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
        DBTemblorendorchgdetail dbTemblorendorchgdetail = new DBTemblorendorchgdetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorendorchgdetail.getCount(conditions);
        return count;
    }
}
