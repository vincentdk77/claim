 <%--
****************************************************************************
* DESC       ��ģ��·��
* AUTHOR     ��weishixin
* CREATEDATE ��2004-08-10
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
    <%--���������Զ���JavaScript������--%>
 
    <script language='javascript'>
      //��������뱾ҳ�Զ����JavaScript����

     /*
        ����һ���µ�WorkFlowPath֮��Ĵ�����ѡ������
      */
      function afterInsertWorkFlowPath()
      {
        setWorkFlowPathNo();
      }
    
      /*
        ɾ������֮��Ĵ�����ѡ������
      */
      function afterDeleteWorkFlowPath(field)
      {
        
        //setWorkFlowPathNo();
      }
    
        /**
         * ����setWorkFlowPathNo
         */
        function setWorkFlowPathNo()
        {
            var count=getElementCount("swfPathPathNo");
            var i = count -1;

           if(count!=2){
               fm.swfPathPathNo[i].value=parseInt(fm.swfPathPathNo[i-1].value)+1;
           }
           else
           {
             fm.swfPathPathNo[1].value = 1;
           }
            
        }
        
        /**
         * ��·���༭����
         */
         function openWinWorkFlowPathEdit(field)
         {
           var win ;
           setCurrRecordOrder(field);//���õ�ǰ��������˳��
           win=window.showModalDialog("/claim/workflow/model/WorkFlowPathAddEdit.jsp",window,'status:no;resizable:yes');
         }
         /**
          * �������
          */
          function setCurrRecordOrder(field)
          {
            var i = 0;
            i = getElementOrder(field);
            fm.WorkFlowPathRecordOrder.value = i;
            return true;
          } 
    </script> 
   <br>
  
   <!--������ʾ��¼����������������ʾ��-->
      <span style="display:none"> 
          <table class="common" style="display:none" id="WorkFlowPath_Data" cellspacing="1" cellpadding="0">
           <tbody>
           <tr class=common>                                             
          <td >
             <input name="swfPathPathNo" class="readonly" readonly style='width:95%' title="·����" > 
          </td>
          <td >                                                    
             <input name=swfPathPathName class="readonly"  readonly style="width:75%" title="·������">
          </td>
          <td >
              <input name=swfPathStartNodeNo class="readonly" readonly style="width:95%" title="��ʼ�ڵ�">
          </td>
          <td >
              <input name=swfPathStartNodeName class="readonly" readonly style="width:95%" title="��ʼ�ڵ�����">
          </td>
          <td >
              <input name=swfPathEndNodeNo class="readonly" readonly style="width:95%" title="��ֹ�ڵ�">
          </td>
          <td >
              <input name=swfPathEndNodeName class="readonly" readonly style="width:95%" title="��ֹ�ڵ�����">
          </td>                    
          <td >
              <input name=swfPathPriority class="readonly" readonly style="width:95%" title="���ȼ�">
          </td>
          <td >
              <input name=swfPathDefaultFlag class="readonly" readonly style="width:95%" title="ȱʡ·��">
          </td>
          <td >
              <input type=button name=buttonWorkFlowPathEdit  value="�༭" style="cursor: hand" onclick="openWinWorkFlowPathEdit(this);">
          </td>
          <td >
              <div align="center">
                <input type=button name="buttonWorkFlowPathDelete"  onclick="deleteRow(this,'WorkFlowPath');" value="-" style="cursor: hand">
              </div>
              
           </td>
             
         </tr>
       </tbody>

    </table>
    </span>
        
        <span  id="spanWorkFlowPath" >
        <%-- ��������չ���� --%>
        <table id="WorkFlowPath" cellpadding="5" cellspacing="1"  class="common">
          <thead>
             <tr>
                <td class="subsubformtitle" colspan=9>·����Ϣ  </td>
             </tr>
             <tr>
         <td class="title" style="width:8%">·����</td>
         <td class="title" >·������</td>
         <td class="title" >��ʼ�ڵ�</td>
         <td class="title">��ʼ�ڵ�����</td>                                        
         <td class="title" >��ֹ�ڵ�</td>
         <td class="title">��ֹ�ڵ�����</td>
         <td class="title" style="width:5%">���ȼ�</td>
         <td class="title" style="width:5%">ȱʡ·��</td>
         <td class="title" style="width:8%">�༭·��</td>
         <td class="title" style="width:3%">  </td>    
         <input type=hidden name="WorkFlowPathPageID" value="WorkFlowPath">   
         <input type=hidden name="WorkFlowPathRecordOrder" value="">                                    
       </tr> 
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan="9" style="width:97%"></td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" class=smallbutton value="+" onclick="insertRow('WorkFlowPath');" name="buttonWorkFlowPathInsert" style="cursor: hand">
                 </div>
                 </td>
              </tr>
           </tfoot> 
           
          <tbody>
        <%int indexPath=0;%>
        
		<logic:notEmpty  name="swfPathDto"  property="pathList"> 
        <logic:iterate id="swfPath" name="swfPathDto" property="pathList">
           <tr class=common>                                             
          <td >
             <input name="swfPathPathNo" class="readonly" readonly style='width:95%' title="·����" value="<bean:write name='swfPath' property='pathNo'/>"> 
          </td>
          <td >                                                    
             <input name=swfPathPathName class="readonly"  readonly style="width:75%" title="·������" value="<bean:write name='swfPath' property='pathName'/>">
          </td>
          <td >
              <input name=swfPathStartNodeNo class="readonly" readonly style="width:95%" title="��ʼ�ڵ�" value="<bean:write name='swfPath' property='startNodeNo'/>">
          </td>
          <td >
              <input name=swfPathStartNodeName class="readonly" readonly style="width:95%" title="��ʼ�ڵ�����" value="<bean:write name='swfPath' property='startNodeName'/>">
          </td>
          <td >
              <input name=swfPathEndNodeNo class="readonly" readonly style="width:95%" title="��ֹ�ڵ�" value="<bean:write name='swfPath' property='endNodeNo'/>">
          </td>
          <td >
              <input name=swfPathEndNodeName class="readonly" readonly style="width:95%" title="��ֹ�ڵ�����" value="<bean:write name='swfPath' property='endNodeName'/>">
          </td>                    
          <td >
              <input name=swfPathPriority class="readonly" readonly style="width:95%" title="���ȼ�" value="<bean:write name='swfPath' property='priority'/>">
          </td>
          <td >
              <input name=swfPathDefaultFlag class="readonly" readonly style="width:95%" title="ȱʡ·��" value="<bean:write name='swfPath' property='defaultFlag'/>">
          </td>
          <td >
              <input type=button name=buttonWorkFlowPathEdit  class=button value="�༭" style="cursor: hand" onclick="openWinWorkFlowPathEdit(this);">
          </td>
          <td >
              <div align="center">
                <input type=button name="buttonWorkFlowPathDelete"  class=smallbutton onclick="deleteRow(this,'WorkFlowPath');" value="-" style="cursor: hand">
              </div>
              
           </td>
             
         </tr>       
        <% indexPath++;%>
        </logic:iterate>
        </logic:notEmpty>  
          </tbody>
        </table>  
        </span>    
  


