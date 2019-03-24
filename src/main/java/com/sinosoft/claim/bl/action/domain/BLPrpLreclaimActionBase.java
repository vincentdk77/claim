package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLreclaimDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLreclaim;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLreclaim-���������Ϣ���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.078<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLreclaimActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLreclaimActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLreclaimActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLreclaimDto prpLreclaimDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLreclaimDto prpLreclaimDto) throws Exception{
        DBPrpLreclaim dbPrpLreclaim = new DBPrpLreclaim(dbManager);
        //�����¼
        dbPrpLreclaim.insert(prpLreclaimDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLreclaim dbPrpLreclaim = new DBPrpLreclaim(dbManager);
        //ɾ����¼
        dbPrpLreclaim.delete(claimNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLreclaim dbPrpLreclaim = new DBPrpLreclaim(dbManager);
        //������ɾ����¼
        dbPrpLreclaim.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLreclaimDto prpLreclaimDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLreclaimDto prpLreclaimDto) throws Exception{
        DBPrpLreclaim dbPrpLreclaim = new DBPrpLreclaim(dbManager);
        //���¼�¼
        dbPrpLreclaim.update(prpLreclaimDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @param serialNo ���
     * @return prpLreclaimDto prpLreclaimDto
     * @throws Exception
     */
    public PrpLreclaimDto findByPrimaryKey(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLreclaim dbPrpLreclaim = new DBPrpLreclaim(dbManager);
        //����DTO
        PrpLreclaimDto prpLreclaimDto = null;
        //��ѯ����,��ֵ��DTO
        prpLreclaimDto = dbPrpLreclaim.findByPrimaryKey(claimNo, serialNo);
        return prpLreclaimDto;
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
        DBPrpLreclaim dbPrpLreclaim = new DBPrpLreclaim(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLreclaim.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLreclaim.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLreclaimDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLreclaim dbPrpLreclaim = new DBPrpLreclaim(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLreclaim.findByConditions(conditions);
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
        DBPrpLreclaim dbPrpLreclaim = new DBPrpLreclaim(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLreclaim.getCount(conditions);
        return count;
    }
}
