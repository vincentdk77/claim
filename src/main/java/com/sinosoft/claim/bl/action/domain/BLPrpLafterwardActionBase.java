package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLafterwardDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLafterward;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLafterward-������ô�����ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLafterwardActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLafterwardActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLafterwardActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLafterwardDto prpLafterwardDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLafterwardDto prpLafterwardDto) throws Exception{
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        //�����¼
        dbPrpLafterward.insert(prpLafterwardDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        //ɾ����¼
        dbPrpLafterward.delete(claimNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        //������ɾ����¼
        dbPrpLafterward.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLafterwardDto prpLafterwardDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLafterwardDto prpLafterwardDto) throws Exception{
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        //���¼�¼
        dbPrpLafterward.update(prpLafterwardDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo ���
     * @return prpLafterwardDto prpLafterwardDto
     * @throws Exception
     */
    public PrpLafterwardDto findByPrimaryKey(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        //����DTO
        PrpLafterwardDto prpLafterwardDto = null;
        //��ѯ����,��ֵ��DTO
        prpLafterwardDto = dbPrpLafterward.findByPrimaryKey(claimNo, serialNo);
        return prpLafterwardDto;
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
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLafterward.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLafterward.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLafterwardDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLafterward.findByConditions(conditions);
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
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLafterward.getCount(conditions);
        return count;
    }
}
