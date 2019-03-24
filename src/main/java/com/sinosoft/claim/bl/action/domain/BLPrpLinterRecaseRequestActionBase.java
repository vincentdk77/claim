package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterRecaseRequest;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿ��ؿ��ⰸ�����м���ҵ���߼�������<br>
 */
public class BLPrpLinterRecaseRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterRecaseRequestActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterRecaseRequestActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterRecaseRequestDto prpLinterRecaseRequestDto)
            throws Exception{
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        //�����¼
        dbPrpLinterRecaseRequest.insert(prpLinterRecaseRequestDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        //ɾ����¼
        dbPrpLinterRecaseRequest.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        //������ɾ����¼
        dbPrpLinterRecaseRequest.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterRecaseRequestDto prpLinterRecaseRequestDto)
            throws Exception{
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        //���¼�¼
        dbPrpLinterRecaseRequest.update(prpLinterRecaseRequestDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @return prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public PrpLinterRecaseRequestDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        //����DTO
        PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterRecaseRequestDto = dbPrpLinterRecaseRequest.findByPrimaryKey(id);
        return prpLinterRecaseRequestDto;
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
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterRecaseRequest.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterRecaseRequest.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterRecaseRequestDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterRecaseRequest.findByConditions(conditions);
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
        DBPrpLinterRecaseRequest dbPrpLinterRecaseRequest = new DBPrpLinterRecaseRequest(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterRecaseRequest.getCount(conditions);
        return count;
    }
}
