package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrecasetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrecasetg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLrecase-�ؿ��ⰸ��;��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.078<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLrecasetgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLrecasetgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLrecasetgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLrecasetgDto prpLrecasetgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLrecasetgDto prpLrecasetgDto) throws Exception{
        DBPrpLrecasetg dbPrpLrecasetg = new DBPrpLrecasetg(dbManager);
        //�����¼
        dbPrpLrecasetg.insert(prpLrecasetgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo �ؿ��ⰸ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLrecasetg dbPrpLrecasetg = new DBPrpLrecasetg(dbManager);
        //ɾ����¼
        dbPrpLrecasetg.delete(claimNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrecasetg dbPrpLrecasetg = new DBPrpLrecasetg(dbManager);
        //������ɾ����¼
        dbPrpLrecasetg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLrecasetgDto prpLrecasetgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLrecasetgDto prpLrecasetgDto) throws Exception{
        DBPrpLrecasetg dbPrpLrecasetg = new DBPrpLrecasetg(dbManager);
        //���¼�¼
        dbPrpLrecasetg.update(prpLrecasetgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo �ؿ��ⰸ����
     * @return prpLrecasetgDto prpLrecasetgDto
     * @throws Exception
     */
    public PrpLrecasetgDto findByPrimaryKey(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLrecasetg dbPrpLrecasetg = new DBPrpLrecasetg(dbManager);
        //����DTO
        PrpLrecasetgDto prpLrecasetgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLrecasetgDto = dbPrpLrecasetg.findByPrimaryKey(claimNo, serialNo);
        return prpLrecasetgDto;
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
        DBPrpLrecasetg dbPrpLrecasetg = new DBPrpLrecasetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrecasetg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLrecasetg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLrecasetgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrecasetg dbPrpLrecasetg = new DBPrpLrecasetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLrecasetg.findByConditions(conditions);
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
        DBPrpLrecasetg dbPrpLrecasetg = new DBPrpLrecasetg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrecasetg.getCount(conditions);
        return count;
    }
}
