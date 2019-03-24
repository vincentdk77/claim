package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimPolicytgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimPolicytg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimPolicy-���������嵥���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.171<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimPolicytgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimPolicytgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimPolicytgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimPolicytgDto prpLclaimPolicytgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimPolicytgDto prpLclaimPolicytgDto) throws Exception{
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        //�����¼
        dbPrpLclaimPolicytg.insert(prpLclaimPolicytgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param policyNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,String policyNo) throws Exception{
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        //ɾ����¼
        dbPrpLclaimPolicytg.delete(claimNo, policyNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        //������ɾ����¼
        dbPrpLclaimPolicytg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimPolicytgDto prpLclaimPolicytgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimPolicytgDto prpLclaimPolicytgDto) throws Exception{
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        //���¼�¼
        dbPrpLclaimPolicytg.update(prpLclaimPolicytgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param policyNo ������
     * @return prpLclaimPolicytgDto prpLclaimPolicytgDto
     * @throws Exception
     */
    public PrpLclaimPolicytgDto findByPrimaryKey(DBManager dbManager,String claimNo,String policyNo) throws Exception{
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        //����DTO
        PrpLclaimPolicytgDto prpLclaimPolicytgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimPolicytgDto = dbPrpLclaimPolicytg.findByPrimaryKey(claimNo, policyNo);
        return prpLclaimPolicytgDto;
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
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimPolicytg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimPolicytg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimPolicytgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimPolicytg.findByConditions(conditions);
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
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimPolicytg.getCount(conditions);
        return count;
    }
}
