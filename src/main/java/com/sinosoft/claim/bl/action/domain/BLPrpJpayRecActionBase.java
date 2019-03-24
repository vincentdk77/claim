package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayRecDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJpayRec;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjpayrec�շѵǼǱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJpayRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJpayRecActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpJpayRecActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJpayRecDto prpJpayRecDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJpayRecDto prpJpayRecDto) throws Exception{
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);
        //�����¼
        dbPrpJpayRec.insert(prpJpayRecDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param certiNo ��������/��������
     * @param order02No �շ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo,int order02No) throws Exception{
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);
        //ɾ����¼
        dbPrpJpayRec.delete(certiNo, order02No);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);
        //������ɾ����¼
        dbPrpJpayRec.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJpayRecDto prpJpayRecDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJpayRecDto prpJpayRecDto) throws Exception{
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);
        //���¼�¼
        dbPrpJpayRec.update(prpJpayRecDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param certiNo ��������/��������
     * @param order02No �շ����
     * @return prpJpayRecDto prpJpayRecDto
     * @throws Exception
     */
    public PrpJpayRecDto findByPrimaryKey(DBManager dbManager,String certiNo,int order02No) throws Exception{
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);
        //����DTO
        PrpJpayRecDto prpJpayRecDto = null;
        //��ѯ����,��ֵ��DTO
        prpJpayRecDto = dbPrpJpayRec.findByPrimaryKey(certiNo, order02No);
        return prpJpayRecDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpJpayRecDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJpayRec.getCount(conditions);
        collection = dbPrpJpayRec.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpJpayRec dbPrpJpayRec = new DBPrpJpayRec(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJpayRec.getCount(conditions);
        return count;
    }
}
