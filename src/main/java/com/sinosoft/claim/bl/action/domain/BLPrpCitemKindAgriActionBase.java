package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemKindAgriDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCitemKindAgri;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpCitemKindAgri��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCitemKindAgriActionBase{
    private static Log logger = LogFactory.getLog(BLPrpCitemKindAgriActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpCitemKindAgriActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCitemKindAgriDto prpCitemKindAgriDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCitemKindAgriDto prpCitemKindAgriDto)
            throws Exception{
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        //�����¼
        dbPrpCitemKindAgri.insert(prpCitemKindAgriDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo PolicyNo
     * @param itemKindNo ItemKindNo
     * @param kindCode KindCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,long itemKindNo,String kindCode)
            throws Exception{
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        //ɾ����¼
        dbPrpCitemKindAgri.delete(policyNo, itemKindNo, kindCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        //������ɾ����¼
        dbPrpCitemKindAgri.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCitemKindAgriDto prpCitemKindAgriDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCitemKindAgriDto prpCitemKindAgriDto)
            throws Exception{
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        //���¼�¼
        dbPrpCitemKindAgri.update(prpCitemKindAgriDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo PolicyNo
     * @param itemKindNo ItemKindNo
     * @param kindCode KindCode
     * @return prpCitemKindAgriDto prpCitemKindAgriDto
     * @throws Exception
     */
    public PrpCitemKindAgriDto findByPrimaryKey(DBManager dbManager,String policyNo,long itemKindNo,String kindCode)
            throws Exception{
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        //����DTO
        PrpCitemKindAgriDto prpCitemKindAgriDto = null;
        //��ѯ����,��ֵ��DTO
        prpCitemKindAgriDto = dbPrpCitemKindAgri.findByPrimaryKey(policyNo, itemKindNo, kindCode);
        return prpCitemKindAgriDto;
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
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCitemKindAgri.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpCitemKindAgri.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpCitemKindAgriDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpCitemKindAgri.findByConditions(conditions);
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
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCitemKindAgri.getCount(conditions);
        return count;
    }
}
