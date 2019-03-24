package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDeleteRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayDeleteRequest;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLINTERPAYDELETEQUEST��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayDeleteRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDeleteRequestActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPayDeleteRequestActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param pRPLINTERPAYDELETEQUESTDto pRPLINTERPAYDELETEQUESTDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto)
            throws Exception{
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        //�����¼
        dbPRPLINTERPAYDELETEQUEST.insert(pRPLINTERPAYDELETEQUESTDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param outId �ͻ�������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String outId)
            throws Exception{
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        //ɾ����¼
        dbPRPLINTERPAYDELETEQUEST.delete(outId);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        //������ɾ����¼
        dbPRPLINTERPAYDELETEQUEST.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param pRPLINTERPAYDELETEQUESTDto pRPLINTERPAYDELETEQUESTDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto)
            throws Exception{
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        //���¼�¼
        dbPRPLINTERPAYDELETEQUEST.update(pRPLINTERPAYDELETEQUESTDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param outId �ͻ�������
     * @return pRPLINTERPAYDELETEQUESTDto pRPLINTERPAYDELETEQUESTDto
     * @throws Exception
     */
    public PrpLinterPayDeleteRequestDto findByPrimaryKey(DBManager dbManager,String outId)
            throws Exception{
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        //����DTO
        PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto = null;
        //��ѯ����,��ֵ��DTO
        pRPLINTERPAYDELETEQUESTDto = dbPRPLINTERPAYDELETEQUEST.findByPrimaryKey(outId);
        return pRPLINTERPAYDELETEQUESTDto;
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
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPRPLINTERPAYDELETEQUEST.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPRPLINTERPAYDELETEQUEST.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����pRPLINTERPAYDELETEQUESTDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPRPLINTERPAYDELETEQUEST.findByConditions(conditions);
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
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPRPLINTERPAYDELETEQUEST.getCount(conditions);
        return count;
    }
}
