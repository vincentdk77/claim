package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimLosstgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimLosstg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimLoss-�����ձ��������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.000<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimLosstgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimLosstgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimLosstgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimLosstgDto prpLclaimLosstgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimLosstgDto prpLclaimLosstgDto) throws Exception{
        DBPrpLclaimLosstg dbPrpLclaimLosstg = new DBPrpLclaimLosstg(dbManager);
        //�����¼
        dbPrpLclaimLosstg.insert(prpLclaimLosstgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLclaimLosstg dbPrpLclaimLosstg = new DBPrpLclaimLosstg(dbManager);
        //ɾ����¼
        dbPrpLclaimLosstg.delete(claimNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimLosstg dbPrpLclaimLosstg = new DBPrpLclaimLosstg(dbManager);
        //������ɾ����¼
        dbPrpLclaimLosstg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimLosstgDto prpLclaimLosstgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimLosstgDto prpLclaimLosstgDto) throws Exception{
        DBPrpLclaimLosstg dbPrpLclaimLosstg = new DBPrpLclaimLosstg(dbManager);
        //���¼�¼
        dbPrpLclaimLosstg.update(prpLclaimLosstgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo ���
     * @return prpLclaimLosstgDto prpLclaimLosstgDto
     * @throws Exception
     */
    public PrpLclaimLosstgDto findByPrimaryKey(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLclaimLosstg dbPrpLclaimLosstg = new DBPrpLclaimLosstg(dbManager);
        //����DTO
        PrpLclaimLosstgDto prpLclaimLosstgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimLosstgDto = dbPrpLclaimLosstg.findByPrimaryKey(claimNo, serialNo);
        return prpLclaimLosstgDto;
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
        DBPrpLclaimLosstg dbPrpLclaimLosstg = new DBPrpLclaimLosstg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimLosstg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimLosstg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimLosstgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimLosstg dbPrpLclaimLosstg = new DBPrpLclaimLosstg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimLosstg.findByConditions(conditions);
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
        DBPrpLclaimLosstg dbPrpLclaimLosstg = new DBPrpLclaimLosstg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimLosstg.getCount(conditions);
        return count;
    }
}
