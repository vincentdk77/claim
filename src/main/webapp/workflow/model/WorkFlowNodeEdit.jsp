 <%--
****************************************************************************
* DESC       ��ģ��ڵ�
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
        ����һ���µ�WorkFlowNode֮��Ĵ�����ѡ������
      */
      function afterInsertWorkFlowNode()
      {
        setWorkFlowNodeNo();
      }
    
      /*
        ɾ������֮��Ĵ�����ѡ������
      */
      function afterDeleteWorkFlowNode(field)
      {
        
        //setWorkFlowNodeNo();
      }
    
        /**
         * ����setWorkFlowNodeNo
         */
        function setWorkFlowNodeNo()
        {
            var count=getElementCount("swfNodeNodeNo");
            var i = count -1;

           if(count!=2){
               fm.swfNodeNodeNo[i].value=parseInt(fm.swfNodeNodeNo[i-1].value)+1;
           }
           else
           {
             fm.swfNodeNodeNo[1].value = 1;
           }

        }
        
        /**
         * ����ɾ�������ǵ�һ��ʱ��ɾ��
         */
         function deleteRowLimit(field,pageCode)
         {
            var order = getElementOrder(field);
            if(order==2)
            {
               alert("��һ���ڵ㲻��ɾ������");
            }
            else
            {
              deleteRow(field,pageCode);
            }
         }
         
         /**
           * �ڵ����͸ı�ʱҲ�ı�ڵ�����
           *
           */
          function  changeNodeType(field)
          {
            var order = getElementOrder(field);
            if(fm.nodeType[order-1].value=="regis")
            { 
              fm.swfNodeNodeName[order-1].value = "����";
            }
            else if(fm.nodeType[order-1].value=="sched")
            { 
              fm.swfNodeNodeName[order-1].value = "�鿱����";
            }
            else if(fm.nodeType[order-1].value=="check")
            { 
              fm.swfNodeNodeName[order-1].value = "�鿱";
            }
            else if(fm.nodeType[order-1].value=="certa")
            { 
              fm.swfNodeNodeName[order-1].value = "����";
            }
            else if(fm.nodeType[order-1].value=="verip")
            { 
              fm.swfNodeNodeName[order-1].value = "�˼�";
            }
            else if(fm.nodeType[order-1].value=="verpo")
            { 
              fm.swfNodeNodeName[order-1].value = "����ѯ��";
            }
            else if(fm.nodeType[order-1].value=="verif")
            { 
              fm.swfNodeNodeName[order-1].value = "����";
            }
            else if(fm.nodeType[order-1].value=="claim")
            { 
              fm.swfNodeNodeName[order-1].value = "����";
            }
            else if(fm.nodeType[order-1].value=="certi")
            { 
              fm.swfNodeNodeName[order-1].value = "��֤";
            }else if(fm.nodeType[order-1].value=="prepa")
            { 
              fm.swfNodeNodeName[order-1].value = "Ԥ��";
            }
            else if(fm.nodeType[order-1].value=="compe")
            { 
              fm.swfNodeNodeName[order-1].value = "ʵ��";
            }
            else if(fm.nodeType[order-1].value=="compp")
            { 
              fm.swfNodeNodeName[order-1].value = "������";
            }
            else if(fm.nodeType[order-1].value=="endca")
            { 
              fm.swfNodeNodeName[order-1].value = "�᰸";
            }
            else if(fm.nodeType[order-1].value=="wound")
            { 
              fm.swfNodeNodeName[order-1].value = "����";
            }
             else if(fm.nodeType[order-1].value=="veriw")
            { 
              fm.swfNodeNodeName[order-1].value = "���˺���";
            }
             else if(fm.nodeType[order-1].value=="cance")
            { 
              fm.swfNodeNodeName[order-1].value = "ע��/����";
            }
             else if(fm.nodeType[order-1].value=="speci")
            { 
              fm.swfNodeNodeName[order-1].value = "Ԥ�ⰸ";
            }

            //modify by liujianbo modify 20050314 start
            //reason:���ӲƲ�����/����
             else if(fm.nodeType[order-1].value=="propc")
            { 
              fm.swfNodeNodeName[order-1].value = "�Ʋ�����";
            }
             else if(fm.nodeType[order-1].value=="propv")
            { 
              fm.swfNodeNodeName[order-1].value = "�Ʋ�����";
            }   
             else if(fm.nodeType[order-1].value=="backc")
            { 
              fm.swfNodeNodeName[order-1].value = "�޸��鳵";
            } 
            //modify by liujianbo modify 20050314 end     
            //modify by lixiang modify 20050319 start
            //reason:�������
            
            else if(fm.nodeType[order-1].value=="schel")
            { 
              fm.swfNodeNodeName[order-1].value = "�������";
            }
            //modify by lixiang modify 20050319 end    
            //Modify by chenrenda update 20050323 begin
            //Reason:���ӻطýڵ�
            else if(fm.nodeType[order-1].value=="backv")
            { 
              fm.swfNodeNodeName[order-1].value = "�ط�";
            }
            //Modify by chenrenda update 20050323 end
             else if(fm.nodeType[order-1].value=="veric")
            { 
              fm.swfNodeNodeName[order-1].value = "����";
            }
            
            
                
          }
          /**
           * ���ܣ���ѡ��Ϊ������ʱ�������ſ�д
           */
           function setTaskNoEnable(field)
           {
              var order = getElementOrder(field);
              if(field.value=="M"||field.value=="T")
              {
                 fm.swfNodeTaskNo[order-1].readOnly = false;
              }
              else
              {
                 fm.swfNodeTaskNo[order-1].readOnly = true;
              }
           }
           
           /**
            * ���� �����������
            *
            */
            function resetTaskNo(field)
            {
               var mutiTaskNo   = field.value;          //������ڵ��ֵ
               var order = getElementOrder(field);
               var lengthTaskNo = fm.swfNodeTaskNo.length;  //������ڵ��
               
               if (fm.taskType[order-1].value=="T") return;
               
               for(var i=0;i<lengthTaskNo;i++)
               {
                  if(fm.swfNodeNodeNo[i].value == mutiTaskNo)
                  {
                     fm.swfNodeTaskNo[i].value = fm.swfNodeNodeNo[order-1].value;
                  }
               }
            }
    </script> 
   <br>
   <!--������ʾ��¼����������������ʾ��-->
      <span style="display:none"> 
          <table class="common" style="display:none" id="WorkFlowNode_Data" cellspacing="1" cellpadding="0">
           <tbody>
           <tr class=common>                                             
          <td class='input'>
             <input name="swfNodeNodeNo" class="readonly" readonly="true"  title="�ڵ���" value="1"> 
          </td>
          <td class='input'>                                                    
             <input name=swfNodeNodeName class="common" title="�ڵ�����"> <img src="/claim/images/markMustInput.gif">
          </td>
          <td class='input'>
              <html:select name="swfNodeDto" property="nodeType" styleClass="common" onclick="changeNodeType(this);">
			      <html:option value="regis" >����</html:option> 
			      <html:option value="sched" >�鿱����</html:option>       
			      <html:option value="check" >�鿱</html:option>       
			      <html:option value="certa" >����</html:option>       
			      <html:option value="verip" >�˼�</html:option>       
			      <html:option value="verpo" >����ѯ��</html:option>       
			      <html:option value="verif" >����</html:option>       
			      <html:option value="claim" >����</html:option>       
			      <html:option value="certi" >��֤</html:option>       
			      <html:option value="prepa" >Ԥ��</html:option>       
			      <html:option value="compe" >ʵ��</html:option> 
			      <html:option value="compp" >������</html:option>       
			      <html:option value="endca" >�᰸</html:option>     
			      <html:option value="wound" >����</html:option> 
			      <html:option value="veriw" >���˺���</html:option>  
			      <html:option value="cance" >ע��/����</html:option>  
			      <html:option value="speci" >Ԥ�ⰸ</html:option>  
			      <html:option value="veric" >����</html:option> 
			      
			           
          <%--modify by liujianbo modify 20050314 start--%>
          <%--resson:���ӲƲ�����/����--%>
			      <html:option value="propc" >�Ʋ�����</html:option>  
			      <html:option value="propv" >�Ʋ�����</html:option>  
			      <html:option value="backc" >�޸��鳵</html:option>  
		        <html:option value="backv" >�ط�</html:option>  
            <html:option value="schel" >�������</html:option> 
              
              </html:select>
          </td>
          <td class='input'>
              <html:select name="swfNodeDto" property="taskType" styleClass="three"  style="width:80px" onclick="return setTaskNoEnable(this);">
			      <html:option value="S" >������</html:option>       
			      <html:option value="M" >������</html:option> 
			      <html:option value="T" >��������</html:option> 
			      
              </html:select>
          </td>
          <td class='input'>
              <input name=swfNodeTaskNo class="common" style="width:95%" readonly title="������" onblur="return resetTaskNo(this);">
          </td>
          <td class='input'>
              <input name=swfNodeTimeLimit class="common" title="����ʱ��" value="0"> <img src="/claim/images/markMustInput.gif">
          </td>
          <td class='input'>
              <html:select name="swfNodeDto" property="endFlag" styleClass="three"  style="width:80px">
			      <html:option value="0" >��</html:option> 
			      <html:option value="1" >��</html:option> 
              </html:select>
          </td>                     
          <td class='input'>
              <input name=swfNodeCriterion class="common" style="width:95%" title="����Ҫ��">
          </td>
          <td class='input'>
              <div align="center">
                <input type=button name="buttonWorkFlowNodeDelete"  class=smallbutton onclick="deleteRowLimit(this,'WorkFlowNode')" value="-" style="cursor: hand">
              </div>
              
           </td>
           <input type=hidden name="swfNodePosX" value="0">  
           <input type=hidden name="swfNodePosY" value="0">  
         </tr>
       </tbody>

    </table>
    </span>
        
        <span  id="spanWorkFlowNode" >
        <%-- ��������չ���� --%>
        <table id="WorkFlowNode" cellpadding="5" cellspacing="1"  class="common">
          <thead>
             <tr class="mline">
                <td class="title" colspan=11>
                 �ڵ���Ϣ <img src="/claim/images/markMustInput.gif">
                </td>
             </tr>
             <tr class="mline">
		         <td class="title" >�ڵ���</td>
		         <td class="title" >�ڵ�����</td>
		         <td class="title" >�ڵ�����</td>
		         <td class="title" >��������</td>
		         <td class="title" >������</td>
		         <td class="title">����ʱ��(����)</td>
		         <td class="title" >������־</td>                                        
		         <td class="title" style="width:20%">����Ҫ��</td>
		         <td class="title" style="width:5%">  </td>                                           
		     </tr> 
          </thead>
          <tfoot>
              <tr class="mline">
                <td class="title" colspan="8" style="width:97%"></td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" class=smallbutton onclick="insertRow('WorkFlowNode');" name="buttonWorkFlowNodeInsert" style="cursor: hand">
                 </div>
                 </td>
              </tr>
           </tfoot> 
           
          <tbody>
        <%int indexNode=0;%>
        
		<logic:notEmpty  name="swfNodeDto"  property="nodeList"> 
        <logic:iterate id="swfNode" name="swfNodeDto" property="nodeList">
          <tr>                                             
          <td class='input'>
             <input name="swfNodeNodeNo" class="readonly" readonly="true" style='width:95%' title="�ڵ���" value="<bean:write name='swfNode' property='nodeNo'/>"> 
          </td>
          <td class='input'>                                                    
             <input name=swfNodeNodeName class="common" title="�ڵ�����" value="<bean:write name='swfNode' property='nodeName'/>"> <img src="/claim/images/markMustInput.gif">
          </td>
          <td class='input'>
              <html:select name="swfNode" property="nodeType" styleClass="three"  style="width:80px" onclick="changeNodeType(this);">
			      <html:option value="regis" >����</html:option> 
			      <html:option value="sched" >�鿱����</html:option>       
			      <html:option value="check" >�鿱</html:option>       
			      <html:option value="certa" >����</html:option>       
			      <html:option value="verip" >�˼�</html:option>       
			      <html:option value="verpo" >����ѯ��</html:option>       
			      <html:option value="verif" >����</html:option>       
			      <html:option value="claim" >����</html:option>       
			      <html:option value="certi" >��֤</html:option>       
			      <html:option value="prepa" >Ԥ��</html:option>       
			      <html:option value="compe" >ʵ��</html:option> 
			      <html:option value="compp" >������</html:option>       
			      <html:option value="endca" >�᰸</html:option>
			      <html:option value="wound" >����</html:option>       
			      <html:option value="veriw" >���˺���</html:option>    
			      <html:option value="cance" >ע��/����</html:option>  
			       <html:option value="speci" >Ԥ�ⰸ</html:option>  
            <html:option value="propc" >�Ʋ�����</html:option>   
			      <html:option value="propv" >�Ʋ�����</html:option> 
			      <html:option value="backc" >�޸��鳵</html:option>   
            <html:option value="backv" >�ط�</html:option>  
            <html:option value="schel" >�������</html:option> 
            <html:option value="veric" >����</html:option>
      	  </html:select> 
          </td>
          <td class='input'>
              <html:select name="swfNode" property="taskType" styleClass="three"  style="width:80px" onclick="return setTaskNoEnable(this);">
			      <html:option value="S" >������</html:option>   
			      <html:option value="M" >������</html:option> 
			       <html:option value="T" >��������</html:option> 
              </html:select>
          </td>
          <td class='input'>
              <input name=swfNodeTaskNo class="common"  readonly style="width:95%" title="������" onblur="return resetTaskNo(this);" value="<bean:write name='swfNode' property='taskNo'/>">
          </td>
          <td class='input'>
              <input name=swfNodeTimeLimit class="common" title="����ʱ��" value="<bean:write name='swfNode' property='timeLimit'/>"> <img src="/claim/images/markMustInput.gif">
          </td>
          <td class='input'>
              <html:select name="swfNode" property="endFlag" styleClass="three"  style="width:80px">
			      <html:option value="0" >��</html:option> 
			      <html:option value="1" >��</html:option>  
              </html:select>
          </td>                     
          <td class='input'>
              <input name=swfNodeCriterion class="common" style="width:95%" title="����Ҫ��" value="<bean:write name='swfNode' property='criterion'/>">
          </td>
          <td class='input'>
              <div align="center">
                <input type=button name="buttonWorkFlowNodeDelete"  onclick="deleteRowLimit(this,'WorkFlowNode')" class=smallbutton value="-" style="cursor: hand">
              </div>
              
           </td>
           <input type=hidden name="swfNodePosX" value="0" value="<bean:write name='swfNode' property='posX'/>">  
           <input type=hidden name="swfNodePosY" value="0" value="<bean:write name='swfNode' property='posY'/>">  
         </tr>        
       <% indexNode++;%>
        </logic:iterate>
        </logic:notEmpty>   
          </tbody>
        </table>  
        </span>    

