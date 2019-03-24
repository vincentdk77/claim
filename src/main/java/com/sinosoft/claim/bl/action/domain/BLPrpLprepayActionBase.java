package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprepay;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLprepay-Ԥ��ǼǱ��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.046<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLprepayActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLprepayActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLprepayActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLprepayDto prpLprepayDto) throws Exception{
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        //�����¼
        dbPrpLprepay.insert(prpLprepayDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param preCompensateNo Ԥ��ǼǺ�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String preCompensateNo) throws Exception{
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        //ɾ����¼
        dbPrpLprepay.delete(preCompensateNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        //������ɾ����¼
        dbPrpLprepay.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLprepayDto prpLprepayDto) throws Exception{
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        //���¼�¼
        dbPrpLprepay.update(prpLprepayDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param preCompensateNo Ԥ��ǼǺ�
     * @return prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public PrpLprepayDto findByPrimaryKey(DBManager dbManager,String preCompensateNo) throws Exception{
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        //����DTO
        PrpLprepayDto prpLprepayDto = null;
        //��ѯ����,��ֵ��DTO
        prpLprepayDto = dbPrpLprepay.findByPrimaryKey(preCompensateNo);
        return prpLprepayDto;
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
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLprepay.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLprepay.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLprepayDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLprepay.findByConditions(conditions);
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
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLprepay.getCount(conditions);
        return count;
    }
}
