package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����WFPATH������·�����������ݴ��������<br>
 * ������ 2004-08-09 19:54:50.610<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfPathDto extends SwfPathDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�WfPathDto����
     */
    public SwfPathDto(){
    }
    /** ������ʾ�б�*/
    private Collection pathList ;
    
     /** ���������¸��ڵ�s*/
    private int nextNodeNo ;

     /** ���������¸��ڵ�s*/
    private String[] nextNodeNoList ;

    /**
     * ��ȡ�б�
     * @return �����б�
     */
    public Collection getPathList(){
      return pathList;
    }
    
    /**
     * ��ȡ�¸��ڵ�s
     * @return �����¸��ڵ�s
     */
    public int getNextNodeNo(){
      return nextNodeNo;
    }
    
        
    /**
     * �����б�
     * @param pathList �����õ��б�
     */
    public void setPathList(Collection pathList) {
      this.pathList = pathList;
    }
    
     /**
     * �����¸��ڵ�s
     * @param pathList ���¸��ڵ�s
     */
    public void setNextNodeNo(int nextNodeNo) {
      this.nextNodeNo = nextNodeNo;
    }
    
    
     /**
     * ��ȡ��ѡ��Ľڵ��¸��ڵ�slist
     * @return ���Ա�ѡ��Ľڵ��¸��ڵ�slist
     */
    public String[] getNextNodeNoList(){
      return nextNodeNoList;
    }
    
      /**
     * ���ñ�ѡ��Ľڵ�slist
     * @param pathList ����ѡ��Ľڵ�slist
     */
    public void setNextNodeNoList(String[] nextNodeNoList) {
      this.nextNodeNoList = nextNodeNoList;
    }
   

}
