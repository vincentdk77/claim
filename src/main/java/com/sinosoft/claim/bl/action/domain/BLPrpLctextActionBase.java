package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLctextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLctext;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLctext-���������ֱ��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.156<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLctextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLctextActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLctextActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLctextDto prpLctextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLctextDto prpLctextDto) throws Exception{
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        //�����¼
        dbPrpLctext.insert(prpLctextDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param textType ����˵������ ��
--** ������/��ע/��
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,String textType,int lineNo) throws Exception{
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        //ɾ����¼
        dbPrpLctext.delete(compensateNo, textType, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        //������ɾ����¼
        dbPrpLctext.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLctextDto prpLctextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLctextDto prpLctextDto) throws Exception{
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        //���¼�¼
        dbPrpLctext.update(prpLctextDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param textType ����˵������ ��
--** ������/��ע/��
     * @param lineNo �к�
     * @return prpLctextDto prpLctextDto
     * @throws Exception
     */
    public PrpLctextDto findByPrimaryKey(DBManager dbManager,String compensateNo,String textType,int lineNo) throws Exception{
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        //����DTO
        PrpLctextDto prpLctextDto = null;
        //��ѯ����,��ֵ��DTO
        prpLctextDto = dbPrpLctext.findByPrimaryKey(compensateNo, textType, lineNo);
        return prpLctextDto;
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
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLctext.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLctext.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLctextDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLctext.findByConditions(conditions);
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
        DBPrpLctext dbPrpLctext = new DBPrpLctext(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLctext.getCount(conditions);
        return count;
    }
}
