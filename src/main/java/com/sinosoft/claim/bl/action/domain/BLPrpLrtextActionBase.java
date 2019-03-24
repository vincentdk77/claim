package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrtextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrtext;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLrtext-׷����������˵����ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.093<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLrtextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLrtextActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLrtextActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLrtextDto prpLrtextDto) throws Exception{
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        //�����¼
        dbPrpLrtext.insert(prpLrtextDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @param textType ����˵������ ��
--** ����ժҪ/�鿱����/�᰸����
     * @param serialNo ���
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,String textType,int serialNo,int lineNo) throws Exception{
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        //ɾ����¼
        dbPrpLrtext.delete(claimNo, textType, serialNo, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        //������ɾ����¼
        dbPrpLrtext.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLrtextDto prpLrtextDto) throws Exception{
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        //���¼�¼
        dbPrpLrtext.update(prpLrtextDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ����
     * @param textType ����˵������ ��
--** ����ժҪ/�鿱����/�᰸����
     * @param serialNo ���
     * @param lineNo �к�
     * @return prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public PrpLrtextDto findByPrimaryKey(DBManager dbManager,String claimNo,String textType,int serialNo,int lineNo) throws Exception{
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        //����DTO
        PrpLrtextDto prpLrtextDto = null;
        //��ѯ����,��ֵ��DTO
        prpLrtextDto = dbPrpLrtext.findByPrimaryKey(claimNo, textType, serialNo, lineNo);
        return prpLrtextDto;
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
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrtext.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLrtext.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLrtextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLrtext.findByConditions(conditions);
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
        DBPrpLrtext dbPrpLrtext = new DBPrpLrtext(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrtext.getCount(conditions);
        return count;
    }
}
