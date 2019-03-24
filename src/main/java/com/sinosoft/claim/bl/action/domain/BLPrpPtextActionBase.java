package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPtextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPtext;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpptext����������Ϣ��ҵ���߼�������<br>
 * ������ 2004-11-22 15:24:31.265<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPtextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPtextActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpPtextActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpPtextDto prpPtextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpPtextDto prpPtextDto) throws Exception{
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        //�����¼
        dbPrpPtext.insert(prpPtextDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param endorseNo �����Ŵ�
     * @param policyNo ���յ��Ŵ�
     * @param lineNo ���ĵ��к�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseNo,String policyNo,int lineNo) throws Exception{
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        //ɾ����¼
        dbPrpPtext.delete(endorseNo, policyNo, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        //������ɾ����¼
        dbPrpPtext.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpPtextDto prpPtextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpPtextDto prpPtextDto) throws Exception{
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        //���¼�¼
        dbPrpPtext.update(prpPtextDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param endorseNo �����Ŵ�
     * @param policyNo ���յ��Ŵ�
     * @param lineNo ���ĵ��к�
     * @return prpPtextDto prpPtextDto
     * @throws Exception
     */
    public PrpPtextDto findByPrimaryKey(DBManager dbManager,String endorseNo,String policyNo,int lineNo) throws Exception{
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        //����DTO
        PrpPtextDto prpPtextDto = null;
        //��ѯ����,��ֵ��DTO
        prpPtextDto = dbPrpPtext.findByPrimaryKey(endorseNo, policyNo, lineNo);
        return prpPtextDto;
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
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPtext.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpPtext.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpPtextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpPtext.findByConditions(conditions);
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
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPtext.getCount(conditions);
        return count;
    }
}
