package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCancelClaimRequest;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ��������ע�������������ҵ���߼�������<br>
 */
public class BLPrpLinterCancelClaimRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCancelClaimRequestActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCancelClaimRequestActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto)
            throws Exception{
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        //�����¼
        dbPrpLinterCancelClaimRequest.insert(prpLinterCancelClaimRequestDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        //ɾ����¼
        dbPrpLinterCancelClaimRequest.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        //������ɾ����¼
        dbPrpLinterCancelClaimRequest.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto)
            throws Exception{
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        //���¼�¼
        dbPrpLinterCancelClaimRequest.update(prpLinterCancelClaimRequestDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @return prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public PrpLinterCancelClaimRequestDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        //����DTO
        PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterCancelClaimRequestDto = dbPrpLinterCancelClaimRequest.findByPrimaryKey(id);
        return prpLinterCancelClaimRequestDto;
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
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCancelClaimRequest.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterCancelClaimRequest.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterCancelClaimRequestDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterCancelClaimRequest.findByConditions(conditions);
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
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCancelClaimRequest.getCount(conditions);
        return count;
    }
}
