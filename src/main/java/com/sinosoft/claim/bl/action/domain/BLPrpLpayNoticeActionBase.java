package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayNotice;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֪ͨ�����ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayNoticeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayNoticeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpayNoticeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpayNoticeDto prpLpayNoticeDto)
            throws Exception{
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        //�����¼
        dbPrpLpayNotice.insert(prpLpayNoticeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param noticeNo ֪ͨ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String noticeNo)
            throws Exception{
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        //ɾ����¼
        dbPrpLpayNotice.delete(noticeNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        //������ɾ����¼
        dbPrpLpayNotice.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpayNoticeDto prpLpayNoticeDto)
            throws Exception{
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        //���¼�¼
        dbPrpLpayNotice.update(prpLpayNoticeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param noticeNo ֪ͨ����
     * @return prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public PrpLpayNoticeDto findByPrimaryKey(DBManager dbManager,String noticeNo)
            throws Exception{
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        //����DTO
        PrpLpayNoticeDto prpLpayNoticeDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpayNoticeDto = dbPrpLpayNotice.findByPrimaryKey(noticeNo);
        return prpLpayNoticeDto;
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
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayNotice.getCount(conditions);
        collection = dbPrpLpayNotice.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLpayNoticeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpayNotice.findByConditions(conditions);
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
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayNotice.getCount(conditions);
        return count;
    }
}
