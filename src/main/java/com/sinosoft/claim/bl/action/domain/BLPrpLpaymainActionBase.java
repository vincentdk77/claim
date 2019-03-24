package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpaymain;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֧����Ϣ�����ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpaymainActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpaymainActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpaymainActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpaymainDto prpLpaymainDto)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        //�����¼
        dbPrpLpaymain.insert(prpLpaymainDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param paymentNo ֧�����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String paymentNo)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        //ɾ����¼
        dbPrpLpaymain.delete(paymentNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        //������ɾ����¼
        dbPrpLpaymain.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpaymainDto prpLpaymainDto)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        //���¼�¼
        dbPrpLpaymain.update(prpLpaymainDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param paymentNo ֧�����
     * @return prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public PrpLpaymainDto findByPrimaryKey(DBManager dbManager,String paymentNo)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        //����DTO
        PrpLpaymainDto prpLpaymainDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpaymainDto = dbPrpLpaymain.findByPrimaryKey(paymentNo);
        return prpLpaymainDto;
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
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymain.getCount(conditions);
        collection = dbPrpLpaymain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLpaymainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpaymain.findByConditions(conditions);
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
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymain.getCount(conditions);
        return count;
    }
}
