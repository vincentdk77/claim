package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfLogStoreDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLogStore;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SwfLogStore��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSwfLogStoreActionBase{
    private static Log logger = LogFactory.getLog(BLSwfLogStoreActionBase.class);

    /**
     * ���캯��
     */
    public BLSwfLogStoreActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param swfLogStoreDto swfLogStoreDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfLogStoreDto swfLogStoreDto)
            throws Exception{
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        //�����¼
        dbSwfLogStore.insert(swfLogStoreDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param flowID flowID
     * @throws Exception
     */
    public void delete(DBManager dbManager,String flowID)
            throws Exception{
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        //ɾ����¼
        dbSwfLogStore.delete(flowID);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        //������ɾ����¼
        dbSwfLogStore.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param swfLogStoreDto swfLogStoreDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfLogStoreDto swfLogStoreDto)
            throws Exception{
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        //���¼�¼
        dbSwfLogStore.update(swfLogStoreDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param flowID flowID
     * @return swfLogStoreDto swfLogStoreDto
     * @throws Exception
     */
    public SwfLogStoreDto findByPrimaryKey(DBManager dbManager,String flowID,int logNo)
            throws Exception{
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        //����DTO
        SwfLogStoreDto swfLogStoreDto = null;
        //��ѯ����,��ֵ��DTO
        swfLogStoreDto = dbSwfLogStore.findByPrimaryKey(flowID,logNo);
        return swfLogStoreDto;
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
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfLogStore.getCount(SqlUtils.getWherePartForGetCount(conditions));
        int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig
				.get("sysconst.MaxQueryCount")));

        if (maxQueryCount != 0 && count > maxQueryCount) {
			throw new UserException(1, 3, "0000", "��ѯ�����������ϵͳ����");
		}
        collection = dbSwfLogStore.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����swfLogStoreDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfLogStore.findByConditions(conditions);
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
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfLogStore.getCount(conditions);
        return count;
    }
}
