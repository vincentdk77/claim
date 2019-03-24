package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvMainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompeInvMain;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿڲ����м���ӱ�������嵥��Ϣ���ҵ���߼�������<br>
 */
public class BLPrpLinterCompeInvMainActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompeInvMainActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCompeInvMainActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterCompeInvMainDto prpLinterCompeInvMainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompeInvMainDto prpLinterCompeInvMainDto)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        //�����¼
        dbPrpLinterCompeInvMain.insert(prpLinterCompeInvMainDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param id ����pk
     * @param serialNo ��� PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        //ɾ����¼
        dbPrpLinterCompeInvMain.delete(id, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        //������ɾ����¼
        dbPrpLinterCompeInvMain.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLinterCompeInvMainDto prpLinterCompeInvMainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterCompeInvMainDto prpLinterCompeInvMainDto)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        //���¼�¼
        dbPrpLinterCompeInvMain.update(prpLinterCompeInvMainDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param id ����pk
     * @param serialNo ��� PK
     * @return prpLinterCompeInvMainDto prpLinterCompeInvMainDto
     * @throws Exception
     */
    public PrpLinterCompeInvMainDto findByPrimaryKey(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        //����DTO
        PrpLinterCompeInvMainDto prpLinterCompeInvMainDto = null;
        //��ѯ����,��ֵ��DTO
        prpLinterCompeInvMainDto = dbPrpLinterCompeInvMain.findByPrimaryKey(id, serialNo);
        return prpLinterCompeInvMainDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompeInvMain.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterCompeInvMain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterCompeInvMainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterCompeInvMain.findByConditions(conditions);
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
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompeInvMain.getCount(conditions);
        return count;
    }
}
