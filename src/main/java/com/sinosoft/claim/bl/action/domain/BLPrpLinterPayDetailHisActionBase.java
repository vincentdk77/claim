package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailHisDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayDetailHis;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǽ�����Ϣ������------�켣��ʷ���ҵ���߼�������<br>
 */
public class BLPrpLinterPayDetailHisActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDetailHisActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPayDetailHisActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterPayDetailHisDto prpLinterPayDetailHisDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPayDetailHisDto prpLinterPayDetailHisDto)
            throws Exception{
        DBPrpLinterPayDetailHis dbPrpLinterPayDetailHis = new DBPrpLinterPayDetailHis(dbManager);
        //�����¼
        dbPrpLinterPayDetailHis.insert(prpLinterPayDetailHisDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����pk
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterPayDetailHis dbPrpLinterPayDetailHis = new DBPrpLinterPayDetailHis(dbManager);
        //ɾ����¼
        dbPrpLinterPayDetailHis.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayDetailHis dbPrpLinterPayDetailHis = new DBPrpLinterPayDetailHis(dbManager);
        //������ɾ����¼
        dbPrpLinterPayDetailHis.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterPayDetailHisDto prpLinterPayDetailHisDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterPayDetailHisDto prpLinterPayDetailHisDto)
            throws Exception{
        DBPrpLinterPayDetailHis dbPrpLinterPayDetailHis = new DBPrpLinterPayDetailHis(dbManager);
        //���¼�¼
        dbPrpLinterPayDetailHis.update(prpLinterPayDetailHisDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����pk
     * @return prpLinterPayDetailHisDto prpLinterPayDetailHisDto
     * @throws Exception
     */
    public PrpLinterPayDetailHisDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterPayDetailHis dbPrpLinterPayDetailHis = new DBPrpLinterPayDetailHis(dbManager);
        //����DTO
        PrpLinterPayDetailHisDto prpLinterPayDetailHisDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterPayDetailHisDto = dbPrpLinterPayDetailHis.findByPrimaryKey(id);
        return prpLinterPayDetailHisDto;
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
        DBPrpLinterPayDetailHis dbPrpLinterPayDetailHis = new DBPrpLinterPayDetailHis(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPayDetailHis.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterPayDetailHis.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterPayDetailHisDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayDetailHis dbPrpLinterPayDetailHis = new DBPrpLinterPayDetailHis(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterPayDetailHis.findByConditions(conditions);
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
        DBPrpLinterPayDetailHis dbPrpLinterPayDetailHis = new DBPrpLinterPayDetailHis(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPayDetailHis.getCount(conditions);
        return count;
    }
}
