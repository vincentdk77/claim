package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatustg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimStatus-����ڵ�״̬��(����)��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimStatustgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimStatustgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimStatustgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimStatustgDto prpLclaimStatustgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimStatusDto prpLclaimStatustgDto) throws Exception{
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        //�����¼
        dbPrpLclaimStatustg.insert(prpLclaimStatustgDto);
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
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        //ɾ����¼
        dbPrpLclaimStatustg.delete(businessNo, nodeType, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        //������ɾ����¼
        dbPrpLclaimStatustg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimStatustgDto prpLclaimStatustgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimStatusDto prpLclaimStatustgDto) throws Exception{
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        //���¼�¼
        dbPrpLclaimStatustg.update(prpLclaimStatustgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param businessNo ҵ���
     * @param nodeType �ڵ�����
     * @param serialNo ���к���
     * @return prpLclaimStatustgDto prpLclaimStatustgDto
     * @throws Exception
     */
    public PrpLclaimStatusDto findByPrimaryKey(DBManager dbManager,String businessNo,String nodeType,int serialNo) throws Exception{
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        //����DTO
        PrpLclaimStatusDto prpLclaimStatustgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimStatustgDto = dbPrpLclaimStatustg.findByPrimaryKey(businessNo, nodeType, serialNo);
        return prpLclaimStatustgDto;
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
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimStatustg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimStatustg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimStatustgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimStatustg.findByConditions(conditions);
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
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimStatustg.getCount(conditions);
        return count;
    }
}
