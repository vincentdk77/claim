package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLreplevyDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLreplevyDetail;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLreplevyDetail-Ȩ��ת�ü�׷����Ϣ��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.140<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLreplevyDetailActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLreplevyDetailActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLreplevyDetailActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLreplevyDetailDto prpLreplevyDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLreplevyDetailDto prpLreplevyDetailDto) throws Exception{
        DBPrpLreplevyDetail dbPrpLreplevyDetail = new DBPrpLreplevyDetail(dbManager);
        //�����¼
        dbPrpLreplevyDetail.insert(prpLreplevyDetailDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLreplevyDetail dbPrpLreplevyDetail = new DBPrpLreplevyDetail(dbManager);
        //ɾ����¼
        dbPrpLreplevyDetail.delete(claimNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLreplevyDetail dbPrpLreplevyDetail = new DBPrpLreplevyDetail(dbManager);
        //������ɾ����¼
        dbPrpLreplevyDetail.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLreplevyDetailDto prpLreplevyDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLreplevyDetailDto prpLreplevyDetailDto) throws Exception{
        DBPrpLreplevyDetail dbPrpLreplevyDetail = new DBPrpLreplevyDetail(dbManager);
        //���¼�¼
        dbPrpLreplevyDetail.update(prpLreplevyDetailDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo ���
     * @return prpLreplevyDetailDto prpLreplevyDetailDto
     * @throws Exception
     */
    public PrpLreplevyDetailDto findByPrimaryKey(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLreplevyDetail dbPrpLreplevyDetail = new DBPrpLreplevyDetail(dbManager);
        //����DTO
        PrpLreplevyDetailDto prpLreplevyDetailDto = null;
        //��ѯ����,��ֵ��DTO
        prpLreplevyDetailDto = dbPrpLreplevyDetail.findByPrimaryKey(claimNo, serialNo);
        return prpLreplevyDetailDto;
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
        DBPrpLreplevyDetail dbPrpLreplevyDetail = new DBPrpLreplevyDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLreplevyDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLreplevyDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLreplevyDetailDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLreplevyDetail dbPrpLreplevyDetail = new DBPrpLreplevyDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLreplevyDetail.findByConditions(conditions);
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
        DBPrpLreplevyDetail dbPrpLreplevyDetail = new DBPrpLreplevyDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLreplevyDetail.getCount(conditions);
        return count;
    }
}
