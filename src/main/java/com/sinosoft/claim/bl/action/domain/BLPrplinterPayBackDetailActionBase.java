package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterPayBackDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplinterPayBackDetail;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿ�֧���˻����̹켣���ҵ���߼�������<br>
 */
public class BLPrplinterPayBackDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrplinterPayBackDetailActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplinterPayBackDetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplinterPayBackDetailDto prplinterPayBackDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplinterPayBackDetailDto prplinterPayBackDetailDto)
            throws Exception{
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        //�����¼
        dbPrplinterPayBackDetail.insert(prplinterPayBackDetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����pk
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        //ɾ����¼
        dbPrplinterPayBackDetail.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        //������ɾ����¼
        dbPrplinterPayBackDetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplinterPayBackDetailDto prplinterPayBackDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplinterPayBackDetailDto prplinterPayBackDetailDto)
            throws Exception{
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        //���¼�¼
        dbPrplinterPayBackDetail.update(prplinterPayBackDetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����pk
     * @return prplinterPayBackDetailDto prplinterPayBackDetailDto
     * @throws Exception
     */
    public PrplinterPayBackDetailDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        //����DTO
        PrplinterPayBackDetailDto prplinterPayBackDetailDto = null;
        //��ѯ����,��ֵ��DTO
        prplinterPayBackDetailDto = dbPrplinterPayBackDetail.findByPrimaryKey(id);
        return prplinterPayBackDetailDto;
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
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplinterPayBackDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplinterPayBackDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplinterPayBackDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplinterPayBackDetail.findByConditions(conditions);
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
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplinterPayBackDetail.getCount(conditions);
        return count;
    }
}
