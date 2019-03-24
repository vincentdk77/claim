package com.sinosoft.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLlocklogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLlocklog;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLLOCKLOG��ҵ���߼�������<br>
 */
public class BLPrpLlocklogActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLlocklogActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLlocklogActionBase(){
    }

    /**
     * �����������
     * @param dbManager DB������
     * @param prpllocklogDto prpllocklogDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection collection)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        for(Iterator itr = collection.iterator();itr.hasNext();){
        	PrpLlocklogDto prpllocklogDto = (PrpLlocklogDto)itr.next();
        	dbPrpllocklog.delete(prpllocklogDto.getRegistNo(), prpllocklogDto.getRecoveryCode(), prpllocklogDto.getRiskCode());
        }
        //�����¼
        dbPrpllocklog.insertAll(collection);
    }
    
    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpllocklogDto prpllocklogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLlocklogDto prpllocklogDto)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        //�����¼
        dbPrpllocklog.insert(prpllocklogDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registno REGISTNO
     * @param recoverycode RECOVERYCODE
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registno,String recoverycode,String serialno)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        //ɾ����¼
        dbPrpllocklog.delete(registno, recoverycode, serialno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        //������ɾ����¼
        dbPrpllocklog.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpllocklogDto prpllocklogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLlocklogDto prpllocklogDto)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        //���¼�¼
        dbPrpllocklog.update(prpllocklogDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registno REGISTNO
     * @param recoverycode RECOVERYCODE
     * @param serialno SERIALNO
     * @return prpllocklogDto prpllocklogDto
     * @throws Exception
     */
    public PrpLlocklogDto findByPrimaryKey(DBManager dbManager,String registno,String recoverycode,String serialno)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        //����DTO
        PrpLlocklogDto prpllocklogDto = null;
        //��ѯ����,��ֵ��DTO
        prpllocklogDto = dbPrpllocklog.findByPrimaryKey(registno, recoverycode, serialno);
        return prpllocklogDto;
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
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpllocklog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpllocklog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpllocklogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpllocklog.findByConditions(conditions);
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
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpllocklog.getCount(conditions);
        return count;
    }
}
