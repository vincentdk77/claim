package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterRequest;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿڲ����м�������ҵ���߼�������<br>
 */
public class BLPrpLinterRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterRequestActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterRequestActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterRequestDto prpLinterRequestDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterRequestDto prpLinterRequestDto)
            throws Exception{
        DBPrpLinterRequest dbPrpLinterRequest = new DBPrpLinterRequest(dbManager);
        //�����¼
        dbPrpLinterRequest.insert(prpLinterRequestDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterRequest dbPrpLinterRequest = new DBPrpLinterRequest(dbManager);
        //ɾ����¼
        dbPrpLinterRequest.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterRequest dbPrpLinterRequest = new DBPrpLinterRequest(dbManager);
        //������ɾ����¼
        dbPrpLinterRequest.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterRequestDto prpLinterRequestDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterRequestDto prpLinterRequestDto)
            throws Exception{
        DBPrpLinterRequest dbPrpLinterRequest = new DBPrpLinterRequest(dbManager);
        //���¼�¼
        dbPrpLinterRequest.update(prpLinterRequestDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @return prpLinterRequestDto prpLinterRequestDto
     * @throws Exception
     */
    public PrpLinterRequestDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterRequest dbPrpLinterRequest = new DBPrpLinterRequest(dbManager);
        //����DTO
        PrpLinterRequestDto prpLinterRequestDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterRequestDto = dbPrpLinterRequest.findByPrimaryKey(id);
        return prpLinterRequestDto;
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
        DBPrpLinterRequest dbPrpLinterRequest = new DBPrpLinterRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterRequest.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterRequest.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterRequestDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterRequest dbPrpLinterRequest = new DBPrpLinterRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterRequest.findByConditions(conditions);
        return collection;
    }
    
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterRequestDto�ļ���
     * @throws Exception
     */
    public Collection findBySQL(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterRequest dbPrpLinterRequest = new DBPrpLinterRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterRequest.findBySQL(conditions);
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
        DBPrpLinterRequest dbPrpLinterRequest = new DBPrpLinterRequest(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterRequest.getCount(conditions);
        return count;
    }
}
