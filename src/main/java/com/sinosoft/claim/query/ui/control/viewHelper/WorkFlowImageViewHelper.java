package com.sinosoft.claim.query.ui.control.viewHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;

import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.query.ui.control.actioin.UICodeAction;
import com.sinosoft.claim.query.ui.control.actioin.UIWorkFlowAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * <p>Title: ScheduleViewHelper</p>c
 * <p>Description:������ͼ��չ��ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� lixiang
 * @version 1.0
 * <br>
 */

 public  class WorkFlowImageViewHelper
 {
   /**
    * Ĭ�Ϲ��췽��
    */
   public WorkFlowImageViewHelper()
   {
   }
    /*========================�������֣�������ͼ��չ�ֲ���========================*/
   /*========================�������֣�������ͼ��չ�ֲ���========================*/
   /**
   * ���ù��������̵�����
   * @param httpServletRequest HttpServletRequest
   * @param businessNo String
   * @throws Exception
   */
  public void setFlowDtoToView(HttpServletRequest httpServletRequest,String swfLogFlowID) throws Exception
  {
    UICodeAction uiCodeAction = new UICodeAction();
    String editType = httpServletRequest.getParameter("editType");
  
    String   flowID   = swfLogFlowID ;//���̺�
  
    UIWorkFlowAction  uiWorkFlowAction = new UIWorkFlowAction();
    //��ѯ��������ͨ�����������е�flowstatus��״̬�������1����ʾû����ɣ���swflog�����ѯ
    //�����flowstatus=0 �����ʾ ��Ҫ��swflogstore��swfpathlogstore����ȡ���ݵġ�
    SwfFlowMainDto swfFlowMainDto = new SwfFlowMainDto();
    swfFlowMainDto =uiWorkFlowAction.findFlowMainByPrimaryKey(flowID);
    
    //����ҵ��ŵõ����е�wfLog�б�
    ArrayList swfLogList = new ArrayList();
    SwfLogDto swfLogDto = new SwfLogDto();
    //�������̺Ų�ѯ����·����Ϣ
    SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
    ArrayList   swfPathLogList = new ArrayList();
    
    if (swfFlowMainDto==null) return;
    
    if (!("1").equals(swfFlowMainDto.getStoreFlag())){
    	//�����ڵ�swflog��swfpathlog�в�ѯ
    	swfLogList = (ArrayList)uiWorkFlowAction.findNodesByFlowID(flowID) ;
      swfPathLogList = (ArrayList)uiWorkFlowAction.findFlowPathLogByFlowID(flowID) ;
    }else {
      //lixiang 2005-6-21 �Ӵ洢�����ѯ�������Ƶ�swfloglist����swfpathloglist
    	ArrayList swfLogStoreList = (ArrayList)uiWorkFlowAction.findStoreNodesByFlowID(flowID) ;
      ArrayList swfPathLogStoreList = (ArrayList)uiWorkFlowAction.findStoreFlowPathLogByFlowID(flowID) ;
      Iterator swfLogStoreIterator = swfLogStoreList.iterator();
      while(swfLogStoreIterator.hasNext()){
      	SwfLogDto swfLogStoreDto = (SwfLogDto)swfLogStoreIterator.next();
      	SwfLogDto swfLogDtoTemp = new SwfLogDto(); 
          PropertyUtils.copyProperties(swfLogDtoTemp,swfLogStoreDto);
          swfLogList.add(swfLogDtoTemp);
      }
         
      Iterator swfPathLogStoreIterator = swfPathLogStoreList.iterator();
      while(swfPathLogStoreIterator.hasNext()){
      	SwfPathLogDto swfPathLogStoreDto = (SwfPathLogDto)swfPathLogStoreIterator.next();
      	SwfPathLogDto swfPathLogDtoTemp = new SwfPathLogDto(); 
          PropertyUtils.copyProperties(swfPathLogDtoTemp,swfPathLogStoreDto);
          swfPathLogList.add(swfPathLogDtoTemp); 
      }
    }
      //״̬��������ת��
      SwfLogDto swfLogDtoTemp1 = null;
      for(int iStatus=0;iStatus<swfLogList.size();iStatus++){
        swfLogDtoTemp1=(SwfLogDto)swfLogList.get(iStatus);
        swfLogDtoTemp1.setNodeStatusName(uiCodeAction.translateCodeCode("ClaimStatus",swfLogDtoTemp1.getNodeStatus(),true));
      }

      SwfLogDto sswfLogListDto = (SwfLogDto)swfLogList.get(0) ;  //��һ���ڵ�
      flowID = swfLogFlowID ;
      swfLogDto.setSwfLogList(swfLogList) ;
      httpServletRequest.setAttribute("swfLogDto",swfLogDto) ;
      //added by zhangli 20070424
      String registNo = sswfLogListDto.getKeyOut();
      httpServletRequest.setAttribute("registNo", registNo);

      swfPathLogDto.setPathLogList(swfPathLogList) ;
      httpServletRequest.setAttribute("wfPathLogdto",swfPathLogDto) ;

      int    treeLayerDeep        = 0  ;//�ڵ�����
      int    treeStartNodeNo      = 1  ;//ȱʡ��ʼ�ڵ�Ϊ1
      Collection swfLogTreeList  = new ArrayList();
      System.out.println("swfLogList.size="+swfLogList.size());
      System.out.println("swfPathLogList.size="+swfPathLogList.size());

      //�����һ�������ڵ�
      if(treeLayerDeep==0)
      {
        for(int j=0;j<swfLogList.size() ;j++)
        {
          SwfLogDto swfLogFirstDto  = (SwfLogDto) swfLogList.get(j);
          if(swfLogFirstDto.getNodeNo() == 1)
          {
            treeLayerDeep = 1;
            swfLogFirstDto.setTreeLayer(treeLayerDeep);
            //���õ�����ڵ���Ϣװ��ڵ���

            swfLogFirstDto.setStartNodeNo(0);
            swfLogFirstDto.setEndNodeNo(1);
            swfLogList.add(swfLogFirstDto);
            break;
          }
        }
      }

      createNodeTree(swfLogTreeList,swfLogList,swfPathLogList,treeStartNodeNo,treeLayerDeep);
      //��һ���ڵ㣬�ڵ���Ϊ1
      //System.out.println("���б��е�����swfLogTreeList="+swfLogTreeList.size() );
      swfLogTreeList.add(sswfLogListDto);
      //����Ϊ���Դ���
      Collection treeList = new ArrayList();
      treeList = orderFlowList((ArrayList)swfLogTreeList);

      //System.out.println("���б��е�����treeList="+treeList.size() );
      SwfLogDto wfLogTestDto = null ;
      /*
      for (Iterator i = treeList.iterator(); i.hasNext(); ) {
            wfLogTestDto = (SwfLogDto)i.next();
            //System.out.println("layer"+wfLogTestDto.getTreeLayer() +"|"+ "startNo=" + wfLogTestDto.getStartNodeNo() + "|endNo=" +wfLogTestDto.getEndNodeNo() +  "||" + wfLogTestDto.getNodeNo() + "|"+wfLogTestDto.getNodeName() );
      }
      */
      SwfLogDto swfLogDtoTree = new SwfLogDto();
      swfLogDtoTree.setSwfLogList(treeList) ;
      httpServletRequest.setAttribute("swfLogDto",swfLogDtoTree) ;
      httpServletRequest.setAttribute("swfPathLogList",swfPathLogList) ;

      //�õ�״̬����
      ArrayList claimStatus = (ArrayList)uiCodeAction.getCodeType("ClaimStatus", BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
      httpServletRequest.setAttribute("claimStatus", claimStatus);

     //��ѯ��ǰ��������Ҫ��Ϣ
      //SwfFlowMainDto swfFlowMainDto = new SwfFlowMainDto();
      //swfFlowMainDto= uiWorkFlowAction.findFlowMainByPrimaryKey(flowID);
      httpServletRequest.setAttribute("swfFlowMainDto", swfFlowMainDto);
      return ;
    }
    /**
     * �����ڵ����ķ���
     * @param wfLogTreeDto Collection  �ڵ���
     * @param swfLogList Collection     wfLog�б�
     * @param swfPathLogList Collection wfPathLog�б�
     * @param treeStartNodeNo int      ���Ŀ�ʼ�ڵ�
     * @param treeLayerDeep int        ���Ĳ���
     * @throws Exception
     */
  private static  void createNodeTree(Collection swfLogTreeList,ArrayList swfLogList,ArrayList swfPathLogList,int treeStartNodeNo,int treeLayerDeep) throws Exception
    {
      /**
       * �������˼·:
       * ���ݵ�һ���ڵ㣬��Ϊ��ʼ�ڵ㣬�õ�startNode�ڵ��endNode,�Դ�endNode�ڵ����Ϊ
       * startNode�ٲ�ѯ����EndNode,�Դ˷����ݹ�õ�һ����״�ṹ
       */

      int treeEndNodeNo   = 0 ;                //����ߵ���ֹ�ڵ�
      ArrayList layerPathList = new ArrayList();   //��ű���Ľڵ�

      for(int i=0;i<swfPathLogList.size()  ;i++)
      {
         SwfPathLogDto swfPathLogNodeDto = (SwfPathLogDto)swfPathLogList.get(i) ;

        if(swfPathLogNodeDto.getStartNodeNo()==treeStartNodeNo)
        {
           layerPathList.add(swfPathLogNodeDto) ;

        }//end if
      }
      /*
      //�����һ�������ڵ�
      System.out.println("�Ƿ�����һ�������ڵ�="+treeLayerDeep);
      if(treeLayerDeep==0)
      {
        System.out.println("�����һ�������ڵ�="+treeLayerDeep);
        SwfLogDto swfLogFirstDto = (SwfLogDto) swfLogList.get(0);
        treeLayerDeep = 1;
        swfLogFirstDto.setTreeLayer(treeLayerDeep);
        //���õ�����ڵ���Ϣװ��ڵ���

        swfLogFirstDto.setStartNodeNo(0);
        swfLogFirstDto.setEndNodeNo(1);
        swfLogTreeList.add(swfLogFirstDto);
      }
     */


      //�Ӳ����ѯ������Щ�����ڵ㣬�жϽ����ڵ��Ƿ��к����ڵ㣬�������ȡ�����ڵ㣬û�������
      for(int k=0;k<layerPathList.size();k++)
      {
          SwfPathLogDto swfPathLogLayerDto = (SwfPathLogDto)layerPathList.get(k) ;
          treeEndNodeNo = swfPathLogLayerDto.getEndNodeNo() ;

          //�Ƿ��к����ڵ�
          if(isExistNextNode(swfPathLogList,treeEndNodeNo))
          {
            //System.out.println("startNo2=" + swfPathLogLayerDto.getStartNodeNo() +swfPathLogLayerDto.getStartNodeName() + "|endNo2=" +swfPathLogLayerDto.getEndNodeNo() + swfPathLogLayerDto.getEndNodeName()  );
            //�����������еĽ����ڵ�
            for(int j=0 ;j<swfLogList.size() ;j++)
            {
               SwfLogDto swfLogNodeDto = (SwfLogDto)swfLogList.get(j);
               //System.out.println("######Ҫ���������="+treeLayerDeep+"|"+ "startNo=" + swfPathLogLayerDto.getStartNodeNo() +swfPathLogLayerDto.getStartNodeName() + "|endNo=" +swfPathLogLayerDto.getEndNodeNo() + swfPathLogLayerDto.getEndNodeName() + "||" + swfLogNodeDto.getNodeNo() + "|"+swfLogNodeDto.getNodeName() );
               if(swfLogNodeDto.getLogNo()==treeEndNodeNo)
               {
                 //���ò�
                 if (k == 0) {
                   treeLayerDeep = treeLayerDeep + 1;
                 }

                  swfLogNodeDto.setTreeLayer(treeLayerDeep) ;
                  //���õ�����ڵ���Ϣװ��ڵ���
                  //System.out.println("layer="+treeLayerDeep+"|"+ "startNo=" + swfPathLogLayerDto.getStartNodeNo() +swfPathLogLayerDto.getStartNodeName() + "|endNo=" +swfPathLogLayerDto.getEndNodeNo() + swfPathLogLayerDto.getEndNodeName() + "||" + swfLogNodeDto.getNodeNo() + "|"+swfLogNodeDto.getNodeName() );
                  swfLogNodeDto.setStartNodeNo(swfPathLogLayerDto.getStartNodeNo()) ;
                  swfLogNodeDto.setEndNodeNo(swfPathLogLayerDto.getEndNodeNo()) ;
                  swfLogTreeList.add(swfLogNodeDto);

                  //�ݹ������һ�ڵ�
                  createNodeTree(swfLogTreeList,swfLogList,swfPathLogList,treeEndNodeNo,treeLayerDeep);
                  break;    //ȡ����һ�ڵ����ѭ��
               }
            }//end for
          }
          else
          {
            //�����������еĽ����ڵ�
            for(int j=0 ;j<swfLogList.size() ;j++)
            {
               SwfLogDto swfLogNodeDto = (SwfLogDto)swfLogList.get(j);
               if(swfLogNodeDto.getLogNo()==treeEndNodeNo)
               {
                  //���ò�
                  if (k == 0) {
                    treeLayerDeep = treeLayerDeep + 1;
                  }
                  swfLogNodeDto.setTreeLayer(treeLayerDeep) ;
                  //���õ�����ڵ���Ϣװ��ڵ���
                  System.out.println("�޺���ڵ�layer="+treeLayerDeep+"|"+ "startNo=" + swfPathLogLayerDto.getStartNodeNo() +swfPathLogLayerDto.getStartNodeName() + "|endNo=" +swfPathLogLayerDto.getEndNodeNo() + swfPathLogLayerDto.getEndNodeName() + "||" + swfLogNodeDto.getNodeNo() + "|"+swfLogNodeDto.getNodeName() + "|"  );
                  swfLogNodeDto.setStartNodeNo(swfPathLogLayerDto.getStartNodeNo()) ;
                  swfLogNodeDto.setEndNodeNo(swfPathLogLayerDto.getEndNodeNo()) ;
                  swfLogTreeList.add(swfLogNodeDto);
                  break;    //ȡ����һ�ڵ����ѭ��
               }
            }//end for
          }
      }

      treeLayerDeep = treeLayerDeep - 1 ;
    }
    /**
     * �ж��Ƿ��к����ڵ�
     * @param sourceList ArrayList
     * @param startNode int
     * @throws Exception
     * @return boolean
     */
    private static boolean isExistNextNode(ArrayList sourceList,int startNode) throws Exception
    {
      boolean isExist = false;  //�Ƿ��к����ڵ�
      for(int i=0;i<sourceList.size() ;i++)
      {
        SwfPathLogDto swfPathLogNodeDto = (SwfPathLogDto)sourceList.get(i) ;
        if(swfPathLogNodeDto.getStartNodeNo() ==startNode)
        {
          isExist = true;
        }
      }
      return isExist;
    }
    /**
     * �����Ҫ�����˳���б�
     * @param sourceList ArrayList
     * @throws Exception
     * @return ArrayList
     */
    private Collection orderFlowList(ArrayList sourceList) throws Exception
    {
        ArrayList sameLayerList = new ArrayList();  //���ͬ��
        ArrayList noSameNodeList = new ArrayList(); //ͬ��û����ͬ�ڵ��б�
        ArrayList orderList      = new ArrayList(); //���źô�����б�
        int startNodeNo     = 0 ;  //��ʼ�ڵ�
        int endNodeNo       = 0 ;  //�����ڵ�
        int treeLayerDeep   = 0 ;  //���нڵ���
        int countLayerSameNode = 0 ;//ͬ������ͬ�ڵ�ĸ���

        //ȥ��startNodeNo��endNodeNo��ͬ��ͬ��ڵ�,
        for(int i=0;i<sourceList.size();i++)
        {

           SwfLogDto swfLogSource = (SwfLogDto)sourceList.get(i);
           startNodeNo = swfLogSource.getStartNodeNo() ;
           //System.out.println("sourceList.size="+sourceList.size()+"|"+ "startNo=" + swfLogSource.getStartNodeNo() +"|endNo=" +swfLogSource.getEndNodeNo() + "||" + swfLogSource.getNodeNo() + "|"+swfLogSource.getNodeName() + "|"  );
           endNodeNo = swfLogSource.getEndNodeNo();
           treeLayerDeep = swfLogSource.getTreeLayer() ;
           for(int j=0;j<noSameNodeList.size();j++)
           {
             SwfLogDto swfLogDiff = (SwfLogDto)noSameNodeList.get(j);  //���ڱȽϵ�Dto
             if(swfLogDiff.getStartNodeNo()==startNodeNo && swfLogDiff.getEndNodeNo()==endNodeNo&&swfLogDiff.getTreeLayer() == treeLayerDeep)
             {
                countLayerSameNode = 1 ;
                break;
             }
           }
           if(countLayerSameNode==0)
                  noSameNodeList.add(swfLogSource) ;
           countLayerSameNode = 0 ;
        }
        //��ͬ�㰴˳������
        for(int k=0;k<noSameNodeList.size() ;k++)
        {
          for(int n=0;n<noSameNodeList.size() ;n++)
          {
            SwfLogDto swfLogList = (SwfLogDto) noSameNodeList.get(n);
            if (swfLogList.getTreeLayer() == k + 1) {
              sameLayerList.add(swfLogList);
            }
          }
        }
        //��ͬ��ڵ���������г�λ�ô��򣬴Ӹߵ��͵Ĵ���
        int nodeCount      = 0 ;//�ڵ���
        int nodePosOrder   = 0 ;//�ڵ��ڲ��λ��
        int oldLayer       = 0 ;//�ɵĲ�
        int currLayer      = 0 ;//��ǰ��

        for(int k=0;k<sameLayerList.size() ;k++)
        {

          SwfLogDto swfLogOrder = (SwfLogDto)sameLayerList.get(k);
          //�õ�ǰһ�ڵ�Ĳ���,����ǰһ�ڵ�Ĳ����ж��Ƿ����һ����
          if (k == 0) {
            oldLayer = 1;
          }
          else {
            oldLayer = currLayer;
          }
          currLayer = swfLogOrder.getTreeLayer() ;

          for(int n=0;n<sameLayerList.size() ;n++)
          {
            SwfLogDto swfLogList = (SwfLogDto) sameLayerList.get(n);
            if (swfLogList.getTreeLayer() == currLayer ) {
              nodeCount = nodeCount + 1;
            }
          }
          currLayer = swfLogOrder.getTreeLayer() ;
          swfLogOrder.setCountNode(nodeCount) ;

          //���ô���
          //��һ���ڵ�nodePosOrderΪ1
          if(oldLayer==currLayer)
          {
            if(nodePosOrder>0)
            {
              nodePosOrder = nodePosOrder - 1;
            }
            else
            {
                nodePosOrder = 1;
            }
            swfLogOrder.setNodePosLayer(nodePosOrder) ;
          }
          else
          {
              nodePosOrder = 1;
              swfLogOrder.setNodePosLayer(nodePosOrder) ;
              nodePosOrder = nodeCount+1 ;
          }
          orderList.add(swfLogOrder);
          nodeCount =  0 ;
        }
        //modify by weishixin add 20050225 start
        //reason:�������������ʱ���
        //����ͣ��ʱ���
        int size =  orderList.size();
        DateTime beginTime = null ;   //��ʼʱ��
        DateTime endTime   = null  ;  //����ʱ��
        String   flowInTime = "" ;    //����ʱ��
        String   submitTime = "" ;    //�ύʱ��
        int      stopTime   = 0 ;     //ͣ��ʱ��
        boolean  isDate     = false ;     //�Ƿ�������
        boolean  isDateInput    = false ; //���������Ƿ���ȷ
        StringBuffer stopTimeDesc  = null ;
        for(int i=0;i<size;i++)
        {
          SwfLogDto swfLogListStopTime = (SwfLogDto) orderList.get(i);
          flowInTime = swfLogListStopTime.getFlowInTime() ;
          submitTime = swfLogListStopTime.getSubmitTime() ;

          //����û��ʱ��İ��� ����stopTime = 0 ;
          if(flowInTime==null||flowInTime.equals("null") ||flowInTime.equals("")||submitTime==null||submitTime.equals("null") ||submitTime.equals("") )
          {
            stopTime = 0 ;
          }
          else  //�����ֵ
          {
              isDate = this.isDateTime(flowInTime);
              //�ж����������Ƿ���ȷ
              if(isDate)
              {
                if(flowInTime.length() <11)
                {
                  beginTime = new DateTime(flowInTime, DateTime.YEAR_TO_DAY);
                }
                else
                {
                   beginTime = new DateTime(flowInTime, DateTime.YEAR_TO_SECOND);
                }
                 isDateInput = true ;
              }
              else
              {
                  isDateInput = false ;
              }
              isDate = this.isDateTime(submitTime);
              if(isDate)
              {
                 if(submitTime.length()<11)
                 {
                   endTime = new DateTime(submitTime, DateTime.YEAR_TO_DAY);
                 }
                 else
                 {
                   endTime = new DateTime(submitTime, DateTime.YEAR_TO_SECOND);
                 }
                 isDateInput = true ;
              }
              else
              {
                  isDateInput = false ;
              }

              if(isDateInput)
              {
              long diffTime = endTime.getTime()- beginTime.getTime() ;

              swfLogListStopTime.setStopTime(diffTime) ;
              //������������
              long dayToMiins = 1000*60*60*24 ;
              long hourToMiins = 60*60*1000;
              long minuteToMiins = 60*1000;
              int  secondToMiins = 1000;
              long hourCount   = 0 ;  //Сʱ��
              long minuteCount = 0 ;  //����
              int  secondCount = 0;
              long dayCount   = (long)diffTime/dayToMiins  ;
              long remainNum = diffTime % dayToMiins  ;
              if(remainNum>0)
              {
                hourCount = (long)remainNum/hourToMiins;  //����Сʱ
                remainNum      = remainNum % hourToMiins;
                if(remainNum > 0)
                {
                  minuteCount = (long)remainNum/minuteToMiins; //�������
                  remainNum   = remainNum % minuteToMiins;
                  if(remainNum>0)
                  {
                     secondCount = (int)remainNum/secondToMiins;

                  }
                  else
                  {
                      secondCount = 0 ;
                  }
                }
                else
                {
                    minuteCount = 0 ;
                }
              }
              else
              {
                hourCount = 0 ;
              }
              stopTimeDesc = new StringBuffer();

              stopTimeDesc =  stopTimeDesc.append(dayCount+"��"+hourCount+"Сʱ"+minuteCount + "����"+secondCount+"��");
              }
              stopTimeDesc = stopTimeDesc.append("���ڸ�ʽ����ȷ");
              swfLogListStopTime.setStopTimeDesc(stopTimeDesc.toString()) ;
              //modify by weishixin add 20050225 end

          }
        }
        return orderList;
    }
    //modify by weishixin add 20050225 start
    //reason:�ж�����Դ���Ƿ�������
    /**
     * �ж�����Դ���Ƿ�������
     * @param sourceDateTime String
     * @throws Exception
     * @return boolean
     */
    private boolean isDateTime(String sourceDateTime) throws Exception
    {
      boolean isDate = false ;
      DateTime checkTime = null ;
      try
      {
         if(sourceDateTime.length()<11)
         {
           checkTime = new DateTime(sourceDateTime,DateTime.YEAR_TO_DAY);
           isDate = true ;
         }
         else
         {
             checkTime = new DateTime(sourceDateTime,DateTime.YEAR_TO_SECOND);
             isDate = true ;
         }
         System.out.println("�������ڣ�"+sourceDateTime);
      }
      catch(Exception e)
      {
         System.out.println("�������ڣ�"+sourceDateTime);
         isDate = false ;
      }

      return isDate;
    }
    //modify by weishixin add 20050225 end
    /*========================��������ͼ��չ�ֲ���������============================*/
 }
