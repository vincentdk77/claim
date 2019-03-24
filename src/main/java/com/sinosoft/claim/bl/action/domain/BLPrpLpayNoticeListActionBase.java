package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayNoticeList;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֪ͨ���������ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayNoticeListActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayNoticeListActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpayNoticeListActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpayNoticeListDto prpLpayNoticeListDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpayNoticeListDto prpLpayNoticeListDto)
            throws Exception{
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        //�����¼
        dbPrpLpayNoticeList.insert(prpLpayNoticeListDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param noticeNo ֪ͨ����
     * @param paymentNo �ո����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String noticeNo,String paymentNo)
            throws Exception{
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        //ɾ����¼
        dbPrpLpayNoticeList.delete(noticeNo, paymentNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        //������ɾ����¼
        dbPrpLpayNoticeList.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpayNoticeListDto prpLpayNoticeListDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpayNoticeListDto prpLpayNoticeListDto)
            throws Exception{
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        //���¼�¼
        dbPrpLpayNoticeList.update(prpLpayNoticeListDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param noticeNo ֪ͨ����
     * @param paymentNo �ո����
     * @return prpLpayNoticeListDto prpLpayNoticeListDto
     * @throws Exception
     */
    public PrpLpayNoticeListDto findByPrimaryKey(DBManager dbManager,String noticeNo,String paymentNo)
            throws Exception{
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        //����DTO
        PrpLpayNoticeListDto prpLpayNoticeListDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpayNoticeListDto = dbPrpLpayNoticeList.findByPrimaryKey(noticeNo, paymentNo);
        return prpLpayNoticeListDto;
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
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayNoticeList.getCount(conditions);
        collection = dbPrpLpayNoticeList.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLpayNoticeListDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpayNoticeList.findByConditions(conditions);
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
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayNoticeList.getCount(conditions);
        return count;
    }
    
    /**
     * ���������¼ add by zhongfen
     * @param dbManager
     * @param prplpayNoticelistList
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection prplpayNoticelistList)throws Exception{
    	DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        //���������¼
        dbPrpLpayNoticeList.insertAll(prplpayNoticelistList);
    }
}
