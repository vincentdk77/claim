package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFeetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimFeetg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimFee-��������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.984<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFeetgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFeetgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimFeetgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimFeetgDto prpLclaimFeetgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimFeetgDto prpLclaimFeetgDto) throws Exception{
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        //�����¼
        dbPrpLclaimFeetg.insert(prpLclaimFeetgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ�ź�
     * @param currency �ұ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,String currency) throws Exception{
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        //ɾ����¼
        dbPrpLclaimFeetg.delete(claimNo, currency);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        //������ɾ����¼
        dbPrpLclaimFeetg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimFeetgDto prpLclaimFeetgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimFeetgDto prpLclaimFeetgDto) throws Exception{
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        //���¼�¼
        dbPrpLclaimFeetg.update(prpLclaimFeetgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ�ź�
     * @param currency �ұ����
     * @return prpLclaimFeetgDto prpLclaimFeetgDto
     * @throws Exception
     */
    public PrpLclaimFeetgDto findByPrimaryKey(DBManager dbManager,String claimNo,String currency) throws Exception{
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        //����DTO
        PrpLclaimFeetgDto prpLclaimFeetgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimFeetgDto = dbPrpLclaimFeetg.findByPrimaryKey(claimNo, currency);
        return prpLclaimFeetgDto;
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
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimFeetg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimFeetg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimFeetgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimFeetg.findByConditions(conditions);
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
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimFeetg.getCount(conditions);
        return count;
    }
}
