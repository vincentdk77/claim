/*****************************************************************************
 * DESC       ����Ա�б�����JS
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-08-01
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */	  
function saveForm(field,saveType)
{
  fm.buttonSaveType.value = saveType;
   
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
 
 if(!validateForm(fm,'Prop_Data'))
  { 
    return false; 
  }
  
var addNewRepairCompentRow=-1;//Ĭ��û������һ����¼����
var compensatebackFlag=fm.prpLverifyLossCompensateFlag.value; //�����˻صı��
 for(i=1;i<fm.prpLpropSerialNo.length;i++)
     {
      if (fm.prpLpropCompensateBackFlag[i].value!="1") addNewRepairCompentRow=1;
       
  }
  
  //�����������˵ģ�����û���������еĻ�����ô����ֱ���ύ������ 
  if (compensatebackFlag=="1" &&addNewRepairCompentRow<0 ) fm.NextComeBackCompensate.value="1";
  
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  
  fm.submit(); 
  //return true;   	
}


function getSumPropDefLoss(field)
 {  
  var fieldname=field.name; 
  var i = 0;
  var findex=0;       
  var propSumLoss;
  var propSumReject;
  var propSumDefLoss;


  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  } 
 
    propSumLoss= parseFloat(fm.all("prpLpropSumLoss")[findex].value);
    propSumReject  = parseFloat(fm.all("prpLpropSumReject")[findex].value)      

	
    if(isNaN(propSumLoss)||propSumLoss.length<1){
      propSumLoss = 0;
    }
    if(isNaN(propSumReject)||propSumReject.length<1) {
      propSumReject = 0;
    }
    propSumDefLoss = propSumLoss-propSumReject;
    fm.all("prpLpropSumDefLoss")[findex].value = point(round(propSumDefLoss ,2),2);
    return true;  
       
}