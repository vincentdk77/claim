package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLprepaytgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprepaytg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLprepay-Ԥ��ǼǱ��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.046<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLprepaytgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLprepaytgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLprepaytgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLprepaytgDto prpLprepaytgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLprepaytgDto prpLprepaytgDto) throws Exception{
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        //�����¼
        dbPrpLprepaytg.insert(prpLprepaytgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param preCompensateNo Ԥ��ǼǺ�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String preCompensateNo) throws Exception{
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        //ɾ����¼
        dbPrpLprepaytg.delete(preCompensateNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        //������ɾ����¼
        dbPrpLprepaytg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLprepaytgDto prpLprepaytgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLprepaytgDto prpLprepaytgDto) throws Exception{
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        //���¼�¼
        dbPrpLprepaytg.update(prpLprepaytgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param preCompensateNo Ԥ��ǼǺ�
     * @return prpLprepaytgDto prpLprepaytgDto
     * @throws Exception
     */
    public PrpLprepaytgDto findByPrimaryKey(DBManager dbManager,String preCompensateNo) throws Exception{
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        //����DTO
        PrpLprepaytgDto prpLprepaytgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLprepaytgDto = dbPrpLprepaytg.findByPrimaryKey(preCompensateNo);
        return prpLprepaytgDto;
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
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLprepaytg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLprepaytg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLprepaytgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLprepaytg.findByConditions(conditions);
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
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLprepaytg.getCount(conditions);
        return count;
    }
}
