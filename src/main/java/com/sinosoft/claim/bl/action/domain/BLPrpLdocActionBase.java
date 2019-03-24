package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdocDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLdoc;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLdoc-���ⵥ֤��Ϣ���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.000<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLdocActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLdocActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLdocActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLdocDto prpLdocDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLdocDto prpLdocDto) throws Exception{
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        //�����¼
        dbPrpLdoc.insert(prpLdocDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @param docCode ��֤����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,String docCode) throws Exception{
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        //ɾ����¼
        dbPrpLdoc.delete(claimNo, docCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        //������ɾ����¼
        dbPrpLdoc.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLdocDto prpLdocDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLdocDto prpLdocDto) throws Exception{
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        //���¼�¼
        dbPrpLdoc.update(prpLdocDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @param docCode ��֤����
     * @return prpLdocDto prpLdocDto
     * @throws Exception
     */
    public PrpLdocDto findByPrimaryKey(DBManager dbManager,String claimNo,String docCode) throws Exception{
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        //����DTO
        PrpLdocDto prpLdocDto = null;
        //��ѯ����,��ֵ��DTO
        prpLdocDto = dbPrpLdoc.findByPrimaryKey(claimNo, docCode);
        return prpLdocDto;
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
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLdoc.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLdoc.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLdocDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLdoc.findByConditions(conditions);
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
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLdoc.getCount(conditions);
        return count;
    }
}
