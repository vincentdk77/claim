package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpaymaintg;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֧����Ϣ�����ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpaymaintgActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpaymaintgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpaymaintgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpaymaintgDto prpLpaymaintgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpaymainDto prpLpaymaintgDto)
            throws Exception{
        DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
        //�����¼
        dbPrpLpaymaintg.insert(prpLpaymaintgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param paymentNo ֧�����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String paymentNo)
            throws Exception{
        DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
        //ɾ����¼
        dbPrpLpaymaintg.delete(paymentNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
        //������ɾ����¼
        dbPrpLpaymaintg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpaymaintgDto prpLpaymaintgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpaymainDto prpLpaymaintgDto)
            throws Exception{
        DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
        //���¼�¼
        dbPrpLpaymaintg.update(prpLpaymaintgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param paymentNo ֧�����
     * @return prpLpaymaintgDto prpLpaymaintgDto
     * @throws Exception
     */
    public PrpLpaymainDto findByPrimaryKey(DBManager dbManager,String paymentNo)
            throws Exception{
        DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
        //����DTO
        PrpLpaymainDto prpLpaymaintgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpaymaintgDto = dbPrpLpaymaintg.findByPrimaryKey(paymentNo);
        return prpLpaymaintgDto;
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
        DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymaintg.getCount(conditions);
        collection = dbPrpLpaymaintg.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpaymaintg.findByConditions(conditions);
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
        DBPrpLpaymaintg dbPrpLpaymaintg = new DBPrpLpaymaintg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymaintg.getCount(conditions);
        return count;
    }
}
