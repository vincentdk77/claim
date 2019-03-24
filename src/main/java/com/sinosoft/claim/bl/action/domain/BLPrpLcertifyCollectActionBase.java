package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyCollect;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcertifyCollect-��֤�ռ�(�޸�)��ҵ���߼�������<br>
 * ������ 2005-03-23 16:36:58.625<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcertifyCollectActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyCollectActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcertifyCollectActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcertifyCollectDto prpLcertifyCollectDto) throws Exception{
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        //�����¼
        dbPrpLcertifyCollect.insert(prpLcertifyCollectDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param businessNo ҵ�����
     * @param lossItemCode ��Ĵ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessNo,String lossItemCode) throws Exception{
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        //ɾ����¼
        dbPrpLcertifyCollect.delete(businessNo, lossItemCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        //������ɾ����¼
        dbPrpLcertifyCollect.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcertifyCollectDto prpLcertifyCollectDto) throws Exception{
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        //���¼�¼
        dbPrpLcertifyCollect.update(prpLcertifyCollectDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param businessNo ҵ�����
     * @param lossItemCode ��Ĵ���
     * @return prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public PrpLcertifyCollectDto findByPrimaryKey(DBManager dbManager,String businessNo,String lossItemCode) throws Exception{
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        //����DTO
        PrpLcertifyCollectDto prpLcertifyCollectDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcertifyCollectDto = dbPrpLcertifyCollect.findByPrimaryKey(businessNo, lossItemCode);
        return prpLcertifyCollectDto;
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
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertifyCollect.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcertifyCollect.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcertifyCollectDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcertifyCollect.findByConditions(conditions);
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
        DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertifyCollect.getCount(conditions);
        return count;
    }
}
