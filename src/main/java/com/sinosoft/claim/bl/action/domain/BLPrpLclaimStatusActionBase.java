package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimStatus-����ڵ�״̬��(����)��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimStatusActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimStatusActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimStatusActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimStatusDto prpLclaimStatusDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimStatusDto prpLclaimStatusDto) throws Exception{
        DBPrpLclaimStatus dbPrpLclaimStatus = new DBPrpLclaimStatus(dbManager);
        //�����¼
        dbPrpLclaimStatus.insert(prpLclaimStatusDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param businessNo ҵ���
     * @param nodeType �ڵ�����
     * @param serialNo ���к���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessNo,String nodeType,int serialNo) throws Exception{
        DBPrpLclaimStatus dbPrpLclaimStatus = new DBPrpLclaimStatus(dbManager);
        //ɾ����¼
        dbPrpLclaimStatus.delete(businessNo, nodeType, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimStatus dbPrpLclaimStatus = new DBPrpLclaimStatus(dbManager);
        //������ɾ����¼
        dbPrpLclaimStatus.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimStatusDto prpLclaimStatusDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimStatusDto prpLclaimStatusDto) throws Exception{
        DBPrpLclaimStatus dbPrpLclaimStatus = new DBPrpLclaimStatus(dbManager);
        //���¼�¼
        dbPrpLclaimStatus.update(prpLclaimStatusDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param businessNo ҵ���
     * @param nodeType �ڵ�����
     * @param serialNo ���к���
     * @return prpLclaimStatusDto prpLclaimStatusDto
     * @throws Exception
     */
    public PrpLclaimStatusDto findByPrimaryKey(DBManager dbManager,String businessNo,String nodeType,int serialNo) throws Exception{
        DBPrpLclaimStatus dbPrpLclaimStatus = new DBPrpLclaimStatus(dbManager);
        //����DTO
        PrpLclaimStatusDto prpLclaimStatusDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimStatusDto = dbPrpLclaimStatus.findByPrimaryKey(businessNo, nodeType, serialNo);
        return prpLclaimStatusDto;
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
        DBPrpLclaimStatus dbPrpLclaimStatus = new DBPrpLclaimStatus(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimStatus.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimStatus.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimStatusDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimStatus dbPrpLclaimStatus = new DBPrpLclaimStatus(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimStatus.findByConditions(conditions);
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
        DBPrpLclaimStatus dbPrpLclaimStatus = new DBPrpLclaimStatus(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimStatus.getCount(conditions);
        return count;
    }
}
