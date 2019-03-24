package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimAgenttgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimAgenttg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimAgent-�����Ᵽ����Ϣ���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimAgenttgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimAgenttgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimAgenttgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimAgenttgDto prpLclaimAgenttgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimAgenttgDto prpLclaimAgenttgDto) throws Exception{
        DBPrpLclaimAgenttg dbPrpLclaimAgenttg = new DBPrpLclaimAgenttg(dbManager);
        //�����¼
        dbPrpLclaimAgenttg.insert(prpLclaimAgenttgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaimAgenttg dbPrpLclaimAgenttg = new DBPrpLclaimAgenttg(dbManager);
        //ɾ����¼
        dbPrpLclaimAgenttg.delete(claimNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimAgenttg dbPrpLclaimAgenttg = new DBPrpLclaimAgenttg(dbManager);
        //������ɾ����¼
        dbPrpLclaimAgenttg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimAgenttgDto prpLclaimAgenttgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimAgenttgDto prpLclaimAgenttgDto) throws Exception{
        DBPrpLclaimAgenttg dbPrpLclaimAgenttg = new DBPrpLclaimAgenttg(dbManager);
        //���¼�¼
        dbPrpLclaimAgenttg.update(prpLclaimAgenttgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @return prpLclaimAgenttgDto prpLclaimAgenttgDto
     * @throws Exception
     */
    public PrpLclaimAgenttgDto findByPrimaryKey(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaimAgenttg dbPrpLclaimAgenttg = new DBPrpLclaimAgenttg(dbManager);
        //����DTO
        PrpLclaimAgenttgDto prpLclaimAgenttgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimAgenttgDto = dbPrpLclaimAgenttg.findByPrimaryKey(claimNo);
        return prpLclaimAgenttgDto;
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
        DBPrpLclaimAgenttg dbPrpLclaimAgenttg = new DBPrpLclaimAgenttg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimAgenttg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimAgenttg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimAgenttgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimAgenttg dbPrpLclaimAgenttg = new DBPrpLclaimAgenttg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimAgenttg.findByConditions(conditions);
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
        DBPrpLclaimAgenttg dbPrpLclaimAgenttg = new DBPrpLclaimAgenttg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimAgenttg.getCount(conditions);
        return count;
    }
}
