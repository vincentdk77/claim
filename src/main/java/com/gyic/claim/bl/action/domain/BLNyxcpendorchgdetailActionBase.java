package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxcpendorchgdetailDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxcpendorchgdetail;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXCPENDORCHGDETAIL��ҵ���߼�������<br>
 */
public class BLNyxcpendorchgdetailActionBase{
    private static Logger logger = Logger.getLogger(BLNyxcpendorchgdetailActionBase.class);

    /**
     * ���캯��
     */
    public BLNyxcpendorchgdetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param nyxcpendorchgdetailDto nyxcpendorchgdetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxcpendorchgdetailDto nyxcpendorchgdetailDto)
            throws Exception{
        DBNyxcpendorchgdetail dbNyxcpendorchgdetail = new DBNyxcpendorchgdetail(dbManager);
        //�����¼
        dbNyxcpendorchgdetail.insert(nyxcpendorchgdetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String businessno,String kindcode,String itemcode)
            throws Exception{
        DBNyxcpendorchgdetail dbNyxcpendorchgdetail = new DBNyxcpendorchgdetail(dbManager);
        //ɾ����¼
        dbNyxcpendorchgdetail.delete(inusrelistcode, businessno, kindcode, itemcode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxcpendorchgdetail dbNyxcpendorchgdetail = new DBNyxcpendorchgdetail(dbManager);
        //������ɾ����¼
        dbNyxcpendorchgdetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param nyxcpendorchgdetailDto nyxcpendorchgdetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxcpendorchgdetailDto nyxcpendorchgdetailDto)
            throws Exception{
        DBNyxcpendorchgdetail dbNyxcpendorchgdetail = new DBNyxcpendorchgdetail(dbManager);
        //���¼�¼
        dbNyxcpendorchgdetail.update(nyxcpendorchgdetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return nyxcpendorchgdetailDto nyxcpendorchgdetailDto
     * @throws Exception
     */
    public NyxcpendorchgdetailDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String businessno,String kindcode,String itemcode)
            throws Exception{
        DBNyxcpendorchgdetail dbNyxcpendorchgdetail = new DBNyxcpendorchgdetail(dbManager);
        //����DTO
        NyxcpendorchgdetailDto nyxcpendorchgdetailDto = null;
        //��ѯ����,��ֵ��DTO
        nyxcpendorchgdetailDto = dbNyxcpendorchgdetail.findByPrimaryKey(inusrelistcode, businessno, kindcode, itemcode);
        return nyxcpendorchgdetailDto;
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
        DBNyxcpendorchgdetail dbNyxcpendorchgdetail = new DBNyxcpendorchgdetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxcpendorchgdetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxcpendorchgdetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����nyxcpendorchgdetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxcpendorchgdetail dbNyxcpendorchgdetail = new DBNyxcpendorchgdetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxcpendorchgdetail.findByConditions(conditions);
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
        DBNyxcpendorchgdetail dbNyxcpendorchgdetail = new DBNyxcpendorchgdetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxcpendorchgdetail.getCount(conditions);
        return count;
    }
}
