package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLdoc-���ⵥ֤��Ϣ������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.312<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLdocDtoBase implements Serializable{
    /** �����ⰸ���� */
    private String claimNo = "";
    /** ���Ե�֤���� */
    private String docCode = "";
    /** ���Ե�֤���� */
    private String docName = "";
    /** ���Ե�֤���� */
    private int docCount = 0;
    /** ����ǩ������ */
    private DateTime signInDate = new DateTime();
    /** ���Ա�־�ֶ�
--** [1] ��֤ɨ����� 
--** 0:δɨ�裬1����ɨ�� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLdocDtoBase����
     */
    public PrpLdocDtoBase(){
    }

    /**
     * ���������ⰸ����
     * @param claimNo �����õ������ⰸ�����ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ����
     * @return �����ⰸ�����ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * �������Ե�֤����
     * @param docCode �����õ����Ե�֤�����ֵ
     */
    public void setDocCode(String docCode){
        this.docCode = StringUtils.rightTrim(docCode);
    }

    /**
     * ��ȡ���Ե�֤����
     * @return ���Ե�֤�����ֵ
     */
    public String getDocCode(){
        return docCode;
    }

    /**
     * �������Ե�֤����
     * @param docName �����õ����Ե�֤���Ƶ�ֵ
     */
    public void setDocName(String docName){
        this.docName = StringUtils.rightTrim(docName);
    }

    /**
     * ��ȡ���Ե�֤����
     * @return ���Ե�֤���Ƶ�ֵ
     */
    public String getDocName(){
        return docName;
    }

    /**
     * �������Ե�֤����
     * @param docCount �����õ����Ե�֤������ֵ
     */
    public void setDocCount(int docCount){
        this.docCount = docCount;
    }

    /**
     * ��ȡ���Ե�֤����
     * @return ���Ե�֤������ֵ
     */
    public int getDocCount(){
        return docCount;
    }

    /**
     * ��������ǩ������
     * @param signInDate �����õ�����ǩ�����ڵ�ֵ
     */
    public void setSignInDate(DateTime signInDate){
        this.signInDate = signInDate;
    }

    /**
     * ��ȡ����ǩ������
     * @return ����ǩ�����ڵ�ֵ
     */
    public DateTime getSignInDate(){
        return signInDate;
    }

    /**
     * �������Ա�־�ֶ�
--** [1] ��֤ɨ����� 
--** 0:δɨ�裬1����ɨ��
     * @param flag �����õ����Ա�־�ֶ�
--** [1] ��֤ɨ����� 
--** 0:δɨ�裬1����ɨ���ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
--** [1] ��֤ɨ����� 
--** 0:δɨ�裬1����ɨ��
     * @return ���Ա�־�ֶ�
--** [1] ��֤ɨ����� 
--** 0:δɨ�裬1����ɨ���ֵ
     */
    public String getFlag(){
        return flag;
    }
}
