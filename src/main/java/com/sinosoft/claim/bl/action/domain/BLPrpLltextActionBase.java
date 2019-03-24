package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLltext;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLltext-�������ֱ��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.031<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLltextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLltextActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLltextActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLltextDto prpLltextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLltextDto prpLltextDto) throws Exception{
        DBPrpLltext dbPrpLltext = new DBPrpLltext(dbManager);
        //�����¼
        dbPrpLltext.insert(prpLltextDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @param textType ����˵������ ��
--** ����ժҪ/�鿱����/�᰸����
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,String textType,int lineNo) throws Exception{
        DBPrpLltext dbPrpLltext = new DBPrpLltext(dbManager);
        //ɾ����¼
        dbPrpLltext.delete(claimNo, textType, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLltext dbPrpLltext = new DBPrpLltext(dbManager);
        //������ɾ����¼
        dbPrpLltext.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLltextDto prpLltextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLltextDto prpLltextDto) throws Exception{
        DBPrpLltext dbPrpLltext = new DBPrpLltext(dbManager);
        //���¼�¼
        dbPrpLltext.update(prpLltextDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @param textType ����˵������ ��
--** ����ժҪ/�鿱����/�᰸����
     * @param lineNo �к�
     * @return prpLltextDto prpLltextDto
     * @throws Exception
     */
    public PrpLltextDto findByPrimaryKey(DBManager dbManager,String claimNo,String textType,int lineNo) throws Exception{
        DBPrpLltext dbPrpLltext = new DBPrpLltext(dbManager);
        //����DTO
        PrpLltextDto prpLltextDto = null;
        //��ѯ����,��ֵ��DTO
        prpLltextDto = dbPrpLltext.findByPrimaryKey(claimNo, textType, lineNo);
        return prpLltextDto;
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
        DBPrpLltext dbPrpLltext = new DBPrpLltext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLltext.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLltext.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLltextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLltext dbPrpLltext = new DBPrpLltext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLltext.findByConditions(conditions);
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
        DBPrpLltext dbPrpLltext = new DBPrpLltext(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLltext.getCount(conditions);
        return count;
    }
}
