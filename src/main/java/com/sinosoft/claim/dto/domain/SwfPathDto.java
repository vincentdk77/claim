package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是WFPATH工作流路径定义表的数据传输对象类<br>
 * 创建于 2004-08-09 19:54:50.610<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfPathDto extends SwfPathDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的WfPathDto对象
     */
    public SwfPathDto(){
    }
    /** 属性显示列表*/
    private Collection pathList ;
    
     /** 属性属性下个节点s*/
    private int nextNodeNo ;

     /** 属性属性下个节点s*/
    private String[] nextNodeNoList ;

    /**
     * 获取列表
     * @return 属性列表
     */
    public Collection getPathList(){
      return pathList;
    }
    
    /**
     * 获取下个节点s
     * @return 属性下个节点s
     */
    public int getNextNodeNo(){
      return nextNodeNo;
    }
    
        
    /**
     * 设置列表
     * @param pathList 待设置的列表
     */
    public void setPathList(Collection pathList) {
      this.pathList = pathList;
    }
    
     /**
     * 设置下个节点s
     * @param pathList 待下个节点s
     */
    public void setNextNodeNo(int nextNodeNo) {
      this.nextNodeNo = nextNodeNo;
    }
    
    
     /**
     * 获取被选择的节点下个节点slist
     * @return 属性被选择的节点下个节点slist
     */
    public String[] getNextNodeNoList(){
      return nextNodeNoList;
    }
    
      /**
     * 设置被选择的节点slist
     * @param pathList 待被选择的节点slist
     */
    public void setNextNodeNoList(String[] nextNodeNoList) {
      this.nextNodeNoList = nextNodeNoList;
    }
   

}
