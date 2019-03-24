package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayRequest;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�����������ҵ���߼�������<br>
 */
public class BLPrpLinterPayRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayRequestActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPayRequestActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterPayRequestDto prpLinterPayRequestDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPayRequestDto prpLinterPayRequestDto)
            throws Exception{
        DBPrpLinterPayRequest dbPrpLinterPayRequest = new DBPrpLinterPayRequest(dbManager);
        //�����¼
        dbPrpLinterPayRequest.insert(prpLinterPayRequestDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterPayRequest dbPrpLinterPayRequest = new DBPrpLinterPayRequest(dbManager);
        //ɾ����¼
        dbPrpLinterPayRequest.delete(id);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayRequest dbPrpLinterPayRequest = new DBPrpLinterPayRequest(dbManager);
        //������ɾ����¼
        dbPrpLinterPayRequest.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterPayRequestDto prpLinterPayRequestDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterPayRequestDto prpLinterPayRequestDto)
            throws Exception{
        DBPrpLinterPayRequest dbPrpLinterPayRequest = new DBPrpLinterPayRequest(dbManager);
        //���¼�¼
        dbPrpLinterPayRequest.update(prpLinterPayRequestDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����id PK
     * @return prpLinterPayRequestDto prpLinterPayRequestDto
     * @throws Exception
     */
    public PrpLinterPayRequestDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterPayRequest dbPrpLinterPayRequest = new DBPrpLinterPayRequest(dbManager);
        //����DTO
        PrpLinterPayRequestDto prpLinterPayRequestDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterPayRequestDto = dbPrpLinterPayRequest.findByPrimaryKey(id);
        return prpLinterPayRequestDto;
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
        DBPrpLinterPayRequest dbPrpLinterPayRequest = new DBPrpLinterPayRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPayRequest.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterPayRequest.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterPayRequestDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayRequest dbPrpLinterPayRequest = new DBPrpLinterPayRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterPayRequest.findByConditions(conditions);
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
        DBPrpLinterPayRequest dbPrpLinterPayRequest = new DBPrpLinterPayRequest(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPayRequest.getCount(conditions);
        return count;
    }
}
