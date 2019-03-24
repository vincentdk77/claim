package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimGrade;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimGrade--����ҵ��Ȩ�ޱ�(����)��ҵ���߼�������<br>
 * ������ 2005-04-19 09:24:22.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimGradeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimGradeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimGradeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimGradeDto prpLclaimGradeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimGradeDto prpLclaimGradeDto) throws Exception{
        DBPrpLclaimGrade dbPrpLclaimGrade = new DBPrpLclaimGrade(dbManager);
        //�����¼
        dbPrpLclaimGrade.insert(prpLclaimGradeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param userCode Ա������
     * @param taskCode �������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String userCode,String taskCode,String configPara) throws Exception{
        DBPrpLclaimGrade dbPrpLclaimGrade = new DBPrpLclaimGrade(dbManager);
        //ɾ����¼
        dbPrpLclaimGrade.delete(userCode, taskCode,configPara);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimGrade dbPrpLclaimGrade = new DBPrpLclaimGrade(dbManager);
        //������ɾ����¼
        dbPrpLclaimGrade.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimGradeDto prpLclaimGradeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimGradeDto prpLclaimGradeDto) throws Exception{
        DBPrpLclaimGrade dbPrpLclaimGrade = new DBPrpLclaimGrade(dbManager);
        //���¼�¼
        dbPrpLclaimGrade.update(prpLclaimGradeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param userCode Ա������
     * @param taskCode �������
     * @return prpLclaimGradeDto prpLclaimGradeDto
     * @throws Exception
     */
    public PrpLclaimGradeDto findByPrimaryKey(DBManager dbManager,String userCode,String taskCode,String configPara) throws Exception{
        DBPrpLclaimGrade dbPrpLclaimGrade = new DBPrpLclaimGrade(dbManager);
        //����DTO
        PrpLclaimGradeDto prpLclaimGradeDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimGradeDto = dbPrpLclaimGrade.findByPrimaryKey(userCode, taskCode,configPara);
        return prpLclaimGradeDto;
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
        DBPrpLclaimGrade dbPrpLclaimGrade = new DBPrpLclaimGrade(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimGrade.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimGrade.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimGradeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimGrade dbPrpLclaimGrade = new DBPrpLclaimGrade(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimGrade.findByConditions(conditions);
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
        DBPrpLclaimGrade dbPrpLclaimGrade = new DBPrpLclaimGrade(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimGrade.getCount(conditions);
        return count;
    }
}
