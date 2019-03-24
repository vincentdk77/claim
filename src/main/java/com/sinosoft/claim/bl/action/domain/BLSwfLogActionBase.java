package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLog;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLogStore;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfLog-��������־����������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.281<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfLogActionBase{
    private static Log logger = LogFactory.getLog(BLSwfLogActionBase.class);

    /**
     * ���캯��
     */
    public BLSwfLogActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param swfLogDto swfLogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfLogDto swfLogDto) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        //�����¼
        dbSwfLog.insert(swfLogDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param flowID ���̱��
     * @param logNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String flowID,int logNo) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        //ɾ����¼
        dbSwfLog.delete(flowID, logNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        //������ɾ����¼
        dbSwfLog.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param swfLogDto swfLogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfLogDto swfLogDto) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        //���¼�¼
        dbSwfLog.update(swfLogDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param flowID ���̱��
     * @param logNo ���
     * @return swfLogDto swfLogDto
     * @throws Exception
     */
    public SwfLogDto findByPrimaryKey(DBManager dbManager,String flowID,int logNo) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        //����DTO
        SwfLogDto swfLogDto = null;
        //��ѯ����,��ֵ��DTO
        swfLogDto = dbSwfLog.findByPrimaryKey(flowID, logNo);
        return swfLogDto;
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
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig
				.get("sysconst.MaxQueryCount")));

        if (maxQueryCount != 0 && count > maxQueryCount) {
			throw new UserException(1, 3, "0000", "��ѯ�����������ϵͳ����");
		}
        collection = dbSwfLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
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
    public PageRecord findAllStatusByConditions(DBManager dbManager,String swflogConditions,String swflogStoreCondition,int pageNo,int rowsPerPage) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        Collection collection = new ArrayList();

        if(swflogConditions.trim().length()==0){
        	swflogConditions = "1=1";
        }
        if(swflogStoreCondition.trim().length()==0){
        	swflogStoreCondition = "1=1";
        }
        int count = dbSwfLog.getCount(SqlUtils.getWherePartForGetCount(swflogConditions));
        count += dbSwfLogStore.getCount(SqlUtils.getWherePartForGetCount(swflogStoreCondition));
        int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig
				.get("sysconst.MaxQueryCount")));

        if (maxQueryCount != 0 && count > maxQueryCount) {
			throw new UserException(1, 3, "0000", "��ѯ�����������ϵͳ����");
		}
        collection = dbSwfLog.findAllStatusByConditions(swflogConditions,swflogStoreCondition,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����swfLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfLog.findByConditions(conditions);
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
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfLog.getCount(conditions);
        return count;
    }
}
