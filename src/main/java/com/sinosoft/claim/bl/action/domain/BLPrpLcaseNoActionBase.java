package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcaseNo;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcaseNo-�ⰸ�ű��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.109<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcaseNoActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcaseNoActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcaseNoActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcaseNoDto prpLcaseNoDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcaseNoDto prpLcaseNoDto) throws Exception{
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        //�����¼
        dbPrpLcaseNo.insert(prpLcaseNoDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param certiNo ��֤��
     * @param certiType ��֤����
     * @param caseNo �ⰸ��
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo,String certiType,String caseNo) throws Exception{
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        //ɾ����¼
        dbPrpLcaseNo.delete(certiNo, certiType, caseNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        //������ɾ����¼
        dbPrpLcaseNo.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcaseNoDto prpLcaseNoDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcaseNoDto prpLcaseNoDto) throws Exception{
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        //���¼�¼
        dbPrpLcaseNo.update(prpLcaseNoDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param certiNo ��֤��
     * @param certiType ��֤����
     * @param caseNo �ⰸ��
     * @return prpLcaseNoDto prpLcaseNoDto
     * @throws Exception
     */
    public PrpLcaseNoDto findByPrimaryKey(DBManager dbManager,String certiNo,String certiType,String caseNo) throws Exception{
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        //����DTO
        PrpLcaseNoDto prpLcaseNoDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcaseNoDto = dbPrpLcaseNo.findByPrimaryKey(certiNo, certiType, caseNo);
        return prpLcaseNoDto;
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
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcaseNo.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcaseNo.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcaseNoDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcaseNo.findByConditions(conditions);
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
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcaseNo.getCount(conditions);
        return count;
    }
}
