package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterRecaseDetail;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿ��ؿ��ⰸ����״̬���ҵ���߼�������<br>
 */
public class BLPrpLinterRecaseDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterRecaseDetailActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterRecaseDetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterRecaseDetailDto prpLinterRecaseDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterRecaseDetailDto prpLinterRecaseDetailDto)
            throws Exception{
        DBPrpLinterRecaseDetail dbPrpLinterRecaseDetail = new DBPrpLinterRecaseDetail(dbManager);
        //�����¼
        dbPrpLinterRecaseDetail.insert(prpLinterRecaseDetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����pk
     * @param registNo ��������
     * @param recaseTime �ؿ�����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,String registNo,int recaseTime)
            throws Exception{
        DBPrpLinterRecaseDetail dbPrpLinterRecaseDetail = new DBPrpLinterRecaseDetail(dbManager);
        //ɾ����¼
        dbPrpLinterRecaseDetail.delete(id, registNo, recaseTime);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterRecaseDetail dbPrpLinterRecaseDetail = new DBPrpLinterRecaseDetail(dbManager);
        //������ɾ����¼
        dbPrpLinterRecaseDetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterRecaseDetailDto prpLinterRecaseDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterRecaseDetailDto prpLinterRecaseDetailDto)
            throws Exception{
        DBPrpLinterRecaseDetail dbPrpLinterRecaseDetail = new DBPrpLinterRecaseDetail(dbManager);
        //���¼�¼
        dbPrpLinterRecaseDetail.update(prpLinterRecaseDetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����pk
     * @param registNo ��������
     * @param recaseTime �ؿ�����
     * @return prpLinterRecaseDetailDto prpLinterRecaseDetailDto
     * @throws Exception
     */
    public PrpLinterRecaseDetailDto findByPrimaryKey(DBManager dbManager,String id,String registNo,int recaseTime)
            throws Exception{
        DBPrpLinterRecaseDetail dbPrpLinterRecaseDetail = new DBPrpLinterRecaseDetail(dbManager);
        //����DTO
        PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterRecaseDetailDto = dbPrpLinterRecaseDetail.findByPrimaryKey(id, registNo, recaseTime);
        return prpLinterRecaseDetailDto;
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
        DBPrpLinterRecaseDetail dbPrpLinterRecaseDetail = new DBPrpLinterRecaseDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterRecaseDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterRecaseDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterRecaseDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterRecaseDetail dbPrpLinterRecaseDetail = new DBPrpLinterRecaseDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterRecaseDetail.findByConditions(conditions);
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
        DBPrpLinterRecaseDetail dbPrpLinterRecaseDetail = new DBPrpLinterRecaseDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterRecaseDetail.getCount(conditions);
        return count;
    }
}
