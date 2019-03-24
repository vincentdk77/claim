//---------------------------------------------------------------
//����ȫ�ֱ���
//---------------------------------------------------------------
var folderNode = folder;//--�������ѡ��
var folderlock = true;//---�������ѡ���Ƿ�����
var foldervar = 0     //---�������ѡ����λ�ñ���
var foldershow = false;
var folderhidden = false;
var isinfolder = false;

var NodeW = 36;       //---�����ڵ���
var NodeH = 58;       //---�����ڵ�߶�
var NodeZoneW = 60 ;   //---�����жϽڵ�����������Χ
var NodeZoneH = 30 ;   //---�����жϽڵ�����������Χ

var curElement;       //---����ѡ�е�Ԫ��
var moveElement;      //---����ѡ�еĽڵ�Ԫ��
var faketitle;        //---�����϶����е�����
var PX = 0;           //---������������x��λ��
var PY = 0;           //---������������y��λ��
var chooseNode=null;  //---����ѡ�е�Node
var fakeType=0;     //---����ѡ�е�����

var selType=new Array("��Ա","����","��ɫ","��","������","��ɫģ��");

var needShowDlg=false;    //--�����϶����Ƿ���Ҫ�ݽ�

var sFlow=new Flow();     //--��������

var pNode=l1.parentNode;  //--���帴�ƽڵ�ĸ��׽ڵ�
var listNode=list;        //--���帴�ƽڵ�
var listNodeImg=listpic;  //--���帴�ƽڵ�ͼ��
var listNodeTxt=listname; //--���帴�ƽڵ�����
var fakeNodeImg=fakepic;   //--�����϶���ͼ��
var fakeNodeTxt=fakename;  //--�����϶�������
var fakeNodeTable=faketable; //--�����϶������
var leftLineNode=l1;      //--������б��
var rightLineNode=l2;     //--������б��
var middleLineNode=l3;    //--������ֱ��
var acuteNode=acute;      //--�����߶μ�ͷ
var menuLayer= set1;      //--�����Ҽ���

var inWhoLeft= null;         //--��¼��ǰλ����who�����
var inWhoRight= null;        //--��¼��ǰλ����who���ұ�
var inWhoBottom= null;       //--��¼��ǰλ����who�ĵײ�
var inWhoTop= null;          //--��¼��ǰλ����who���ϲ�
var inWho = null;            //--��¼��ǰλ����who���ڲ�
var temp = 0;

//---------------------------------------------------------------
//����Node��
//---------------------------------------------------------------

function Node(nID,nName,nType,nX,nY)
{
this.n_name = nName;                 //�����ڵ�����
this.n_finish_yn = false;            //�����ڵ��Ƿ������
this.n_id = nID;                     //�����ڵ�id��
this.n_type=nType;                   //�����ڵ�����
this.height = NodeH;                 //�����ڵ�߶�
this.weight = NodeW;                 //�����ڵ���
this.sx = nX;                        //�����ڵ�X������
this.sy = nY;                        //�����ڵ�Y������
this.nNode = new Array();            //�����ڵ�ĺ����ڵ�����
this.displacement = 0;               //��ʾ�����ڵ����丸�׽ڵ��λ��
}


//---------------------------------------------------------------
//����Flow��
//---------------------------------------------------------------
function Flow()
{
this.sNode = new Array();      //---���������еĽڵ�
}


//---------------------------------------------------------------
//��������ͼ
//---------------------------------------------------------------

//---����sFlow��
function createFlow() {

    var nodeLength=id.length;
	var pathLength=path.length;
	for (var i=0;i<nodeLength;i++)
	{
       //---���ݵ������������ÿ���ڵ��࣬������sFlow��
	   var tempNode=new Node(id[i],name[i],type[i],iX[i],iY[i]);
         //---����·�����飬�ҳ��ýڵ�ĺ����ڵ㣬����Ľڵ�ĺ����ڵ�������
		 var tempnNode=0;
		 for (var j=0;j<pathLength;j++)
		 {
			 var tempPath=path[j];
			 var cpot=tempPath.indexOf("-");
			 if (cpot!=-1)
			 {
				 var startNodeID=tempPath.substring(0,cpot);
				 var endNodeID=tempPath.substring(cpot+1);
                 if (startNodeID==id[i])
                 {
					 //--�ҵ�һ������������·��
					 tempNode.nNode[tempnNode]=endNodeID;
					 tempnNode=tempnNode+1;
                 }
			 }
			 else
			 {
			     window.status="��Ч�Ľڵ�·��"+tempPath;
				 break;
			 }
		 }
       sFlow.sNode[i]=tempNode;

	}
}

function findNodeByID(nodeID) {
   for (var i=0;i<id.length;i++)
   {
	   if (sFlow.sNode[i].n_id==nodeID) return sFlow.sNode[i];
   }
}

//---����sFlow��ͼ��
function drawFlow() {
   //---�������еĽڵ�
   for (var i=0;i<id.length;i++)
   {
	   var startNode=sFlow.sNode[i];
	   if (startNode.n_type!="-3")
	   {
          	   drawNode(startNode);
	   }
	   //---�����ýڵ�ĺ���·��
	   for (var j=0;j<sFlow.sNode[i].nNode.length;j++)
	   {
           //�õ������ڵ�ID���ҵ��ýڵ�
           var endNode=findNodeByID(startNode.nNode[j]);
		   drawPath(startNode,endNode);
	   }
   }
}

//---����node��ͼ��
//---����Ϊnode
function drawNode(cNode) {
   //---�ı�ڵ���ʾ����
   listNodeTxt.title = cNode.n_name.length>3?(cNode.n_name.slice(0,1)=="<"?"":cNode.n_name):"";
   listNodeTxt.innerHTML=stringCut(cNode.n_name);
   //listNodeTxt.innerHTML=cNode.n_name;
   //--�жϽڵ����ͣ��ı�ڵ�ͼ��
   switch (cNode.n_type)
        {
        case -1:
        listNodeImg.src="/images/workflow/start.gif";
        listNodeTxt.innerHTML="������";
        break;
        case -2:
        listNodeImg.src="/images/workflow/end.gif";
	listNodeTxt.innerHTML="����";
        break;
        case 0:
        listNodeImg.src="/images/workflow/user.gif";
        break;
        case 1:
        listNodeImg.src="/images/workflow/depart.gif";
        break;
        case 2:
        listNodeImg.src="/images/workflow/role.gif";
		break;
        case 3:
        listNodeImg.src="/images/workflow/group.gif";
        break;
        case 4:
         listNodeImg.src="/images/workflow/process.gif";
         break;
         case 5:
         listNodeImg.src="/images/workflow/role.gif";
         break;
        default:
        }

  //---����listNode
  var tempNode=listNode.cloneNode(true);
  //---�ı�tempNode��λ��
  tempNode.style.posTop=cNode.sy;
  tempNode.style.posLeft=cNode.sx;
  //---�ı�tempNode����ʾ��ʽ
  tempNode.style.visibility="";
  //---���tempNode
  pNode.appendChild(tempNode);
}

//---����·��
//---����Ϊ��ʼ·���ͽ���·��
function drawPath(startNode,endNode) {
	var startX=0;
	var startY=0;
	var endX=0;
	var endY=0;
    endX=endNode.sx+NodeW/2;
	endY=endNode.sy;
	startX=startNode.sx+NodeW/2;
	startY=startNode.sy+NodeH;
	if (endNode.n_type==-3)
	{
		endY=endNode.sy+NodeH/2;
	}else {
	drawAcute(endX,endY);
	}
	if (startNode.n_type==-3)
	{
		startY=startNode.sy+NodeH/2;
	}

	/*
	if (startX==endX)
	{
		//--·��Ϊֱ��
		drawLine(middleLineNode,startX,startY,1,endY-startY);
	}else if (startX>endX)
	{
		//--·��Ϊ��б��
        drawLine(leftLineNode,endX,startY,startX-endX,endY-startY);
	}else if (startX<endX)
	{
		//--·��Ϊ��б��
        drawLine(rightLineNode,startX,startY,endX-startX,endY-startY);
	}
	*/

	drawLine(startX,startY,endX,endY);
}

function drawLine2(lineNode,lineX,lineY,lineW,lineH) {
    //---����lineNode
	var tempNode=lineNode.cloneNode(true);
	tempNode.style.posLeft=lineX;
	tempNode.style.posTop=lineY;
	tempNode.style.posWidth=lineW;
	tempNode.style.posHeight=lineH;
	tempNode.style.visibility="";
    //---���tempNode
    pNode.appendChild(tempNode);
}

function drawLine(sX,sY,eX,eY) {
/*
   var MyLine = document.createElement("vml:line");
   MyLine.from =sX+"px,"+(sY-18)+"px";
   //MyLine.from ="0px,-18px";
   MyLine.to  = eX+"px,"+(eY-18)+"px";
*/
   var mY=eY-(NodeZoneH/4);
   var Line1= document.createElement("vml:line");
   Line1.strokecolor="#0033cc";
   Line1.from = sX+"px,"+(sY-45)+"px";
   Line1.to = sX+"px,"+(mY-40)+"px";
   var Line2= document.createElement("vml:line");
   Line2.strokecolor="#0033cc";
   Line2.from = sX+"px,"+(mY-40)+"px";
   Line2.to = eX+"px,"+(mY-40)+"px";
   var Line3= document.createElement("vml:line");
   Line3.strokecolor="#0033cc";
   Line3.from = eX+"px,"+(mY-40)+"px";
   Line3.to = eX+"px,"+(eY-40)+"px";
   pNode.appendChild(Line1);
   pNode.appendChild(Line2);
   pNode.appendChild(Line3);
}

function drawAcute(acuteX,acuteY) {
   //---����acuteNode
   var tempNode=acuteNode.cloneNode(true);
   tempNode.style.posLeft=acuteX-2;
   tempNode.style.posTop=acuteY-2.5;
   tempNode.style.visibility="";
   //---���tempNode
   pNode.appendChild(tempNode);
}




//---���sFlow���ݣ�����
function outputFlow() {
    var outputTxt="sFlow����";
	outputTxt+="�ڵ���"+sFlow.sNode.length+"<br>";
	for (var i=0;i<sFlow.sNode.length;i++)
	{
		outputTxt+="�ڵ�"+sFlow.sNode[i].n_id+"--name:"+sFlow.sNode[i].n_name+"<br>";
		outputTxt+="����"+sFlow.sNode[i].n_type+"<br>";
	}
    output.innerHTML=outputTxt;
}


//---------------------------------------------------------------
//��������¼�
//---------------------------------------------------------------

//---�������ѡ�����Ԫ���¼�������ѡ�е�Ԫ�أ��ı��϶�������ʾ������
function MouseDoSel(OperType)
{
  if (window.event.button!=2)
  {

	fakeType=OperType;
	curElement = event.srcElement;
 //--�ж�ѡ�����ͣ��ı��϶���ͼ��
 switch (OperType)
        {
        case 0:
        fakeNodeImg.src="/images/workflow/user.gif";
        break;
        case 1:
        fakeNodeImg.src="/images/workflow/depart.gif";
        break;
        case 2:
        fakeNodeImg.src="/images/workflow/role.gif";
		break;
        case 3:
        fakeNodeImg.src="/images/workflow/group.gif";
		break;
        case 4:
        fakeNodeImg.src="/images/workflow/process.gif";
		break;
        default:
        }

fakeNodeTxt.innerHTML = selType[fakeType];
fakeNodeTable.style.backgroundColor="#FFFFCC";
  //----����״̬����������
  window.status="�϶�������ӵ�λ�ã���ɫΪ��ȷλ��";}
}

//---�������ѡ�нڵ��¼����϶���ɸı�ڵ�λ��
function moveNode()
{
	/*
if (window.event.button!=2)
{

if (inWho!=null) {
	fakeType=inWho.n_type;
	chooseNode = inWho;
	moveElement = event.srcElement;
 //--�ж�ѡ�����ͣ��ı��϶���ͼ��
 switch (fakeType)
        {
        case 0:
        fakeNodeImg.src="/images/workflow/user.gif";
        break;
        case 1:
        fakeNodeImg.src="/images/workflow/depart.gif";
        break;
        case 2:
        fakeNodeImg.src="/images/workflow/role.gif";
		break;
        case 3:
        fakeNodeImg.src="/images/workflow/group.gif";
		break;
        default:
        }
  fakeNodeTxt.innerHTML = inWho.n_name;
  fakeNodeTable.style.backgroundColor="";
  //----����״̬����������
  window.status="�ƶ��ڵ㵽��Ҫ��λ��";
}
}
*/
}


//---��������ƶ�ʱ���¼������ѡ��Ԫ�ز�Ϊ�յĻ��������϶�����������ƶ�
function doMouseMove()
{
var mouseX=window.event.clientX + PX;
var mouseY=window.event.clientY + PY;
//---�жϵ�ǰ���λ��
judgeMousePosition(mouseX,mouseY);

if (curElement!=null)
  {
  //---��ǰ״̬Ϊ�϶�������״̬

  //�϶�������
  fake.style.posLeft = mouseX-15;
  fake.style.posTop = mouseY-15;
  fake.style.display = '';

  //--���ݵ�ǰλ�ã��ı��϶��������֡����϶�������ɫ
	if (inWhoTop)
	{
		fakeNodeTable.style.backgroundColor="#C1FDD0";
		fakeNodeTxt.innerHTML="��ǩ";
		submitform.ProNodeID.value = inWhoTop.n_id;
		submitform.event.value="seriesUp";
		window.status="�ſ���꣬�����ڵ�ǰλ�ô���һ���ڵ�";
	}else if (inWhoBottom)
	{
		fakeNodeTable.style.backgroundColor="#C1FDD0";
        fakeNodeTxt.innerHTML="��ǩ";
		submitform.ProNodeID.value = inWhoBottom.n_id;
		submitform.event.value="seriesDown";
		window.status="�ſ���꣬�����ڵ�ǰλ�ô���һ���ڵ�";
	}else if (inWhoLeft)
	{
		fakeNodeTable.style.backgroundColor="#FFCACA";
        fakeNodeTxt.innerHTML="��ǩ";
		submitform.ProNodeID.value = inWhoLeft.n_id;
		submitform.event.value="parallelLeft";
		window.status="�ſ���꣬�����ڵ�ǰλ�ò���һ���ڵ�";
	}else if (inWhoRight)
	{
		fakeNodeTable.style.backgroundColor="#FFCACA";
        fakeNodeTxt.innerHTML="��ǩ";
		submitform.ProNodeID.value = inWhoRight.n_id;
		submitform.event.value="parallelRight";
		window.status="�ſ���꣬�����ڵ�ǰλ�ò���һ���ڵ�";
	}else if (inWho)
	{
		/*
		fakeNodeTable.style.backgroundColor="#DEE3F8";
		fakeNodeTxt.innerHTML="֪ͨ";
		submitform.ProNodeID.value = inWho.n_id;
		submitform.event.value="message";
		window.status="�ſ���꣬�����ڵ�ǰλ�����һ��֪ͨ";
		*/
		fakeNodeTable.style.backgroundColor="#FFFFCC";
	    fakeNodeTxt.innerHTML=selType[fakeType];
	}else {
		fakeNodeTable.style.backgroundColor="#FFFFCC";
	    fakeNodeTxt.innerHTML=selType[fakeType];
	}
  }
if (moveElement!=null)
{
  //---��ǰ״̬Ϊ�϶�������״̬

  //�϶�������
  fake.style.posLeft = mouseX-15;
  fake.style.posTop = mouseY-15;
  fake.style.display = '';
}

window.event.returnValue = false;

}


//---�������down�¼�
function doMouseDown()
{

}

//---�������up�¼������up�������϶����϶�ʱ�����ж��϶����Ƿ�����ύ��
//�ǣ�����������ύ�����ǣ�������Ӧ�ڱ�ɫλ��ʱ�ſ����
function doMouseUp()
{
//--�϶��������϶���
if (curElement!=null)
  {
  curElement = null;
  fake.style.display = 'none';
  event.returnValue =false;
  //--����϶����ڽڵ㸽��������ӽڵ�
  if (inWhoTop!=null||inWhoBottom!=null||inWhoLeft!=null||inWhoRight!=null)
  {
	  //--������ѡ���������ͣ�����Ӧ��ѡ������ѡ��

     var choose=window.showModalDialog('/workflow/ModelNodeFactory?event=SelectNodeEvent&OperType='+fakeType+'&BusinessID='+submitform.ProcessClass.value+'&isAlias='+submitform.isAlias.value+'&processID='+submitform.ProcessID.value,'','dialogwidth=480px; dialogheight=420px; status=no');
      //--������ؽ����Ϊ�յĻ����ύ�ڵ�
	 if (choose!=null)
           {

           submitform.OperID.value =  choose[1];
           submitform.BackFlag.value = choose[2];
           submitform.JumpFlag.value =  choose[3];
           submitform.ExpandFlag.value = choose[4];
           submitform.EditFlag.value = choose[5];
           submitform.CancleFlag.value = choose[6];
           submitform.AgentFlag.value = choose[7];
           submitform.DelayFlag.value = choose[8];
           submitform.AllFlag.value = choose[9];
           submitform.DelayDay.value = choose[10];
           submitform.aliasName.value = choose[11];
           submitform.sqlValue.value = choose[12];
           submitform.responseSql.value = choose[13];
           submitform.operURL.value = choose[14];
           submitform.OperType.value = choose[15];
           submitform.submit();
     }
	 else {
	     window.status="û��ѡ���κνڵ�����ˣ���Ӷ���ȡ��";
	     scrollback();
	 }
  }
  else {
     window.status="û���϶�����ȷ��λ�ã�������κνڵ�";
     scrollback();
  }
 }

//---�϶��ڵ�
if (moveElement!=null)
{
  moveElement = null;
  fake.style.display = 'none';
  event.returnValue =false;
  if (chooseNode!=null)
  {
  //---��õ�ǰλ�ã��ύ
  var mouseX=window.event.clientX + PX-15;
  var mouseY=window.event.clientY + PY-15;
  submitform.IX.value = mouseX;
  submitform.IY.value = mouseY;
  submitform.ProNodeID.value=chooseNode.n_id;
  submitform.event.value="move";
  submitform.submit();
  }
}
}

//---������������¼�
function doscroll(){
      setTimeout("scrolling()",300);
}
function scrolling(){
      PY = document.body.scrollTop;
      PX = document.body.scrollLeft;
      	folder.style.top  = PY;
      	folder.style.left = PX + foldervar;
      	hotdiv.style.top  = PY;
      	hotdiv.style.left = PX;
}

//---�ж���굱ǰλ�õ��㷨
function judgeMousePosition(cX,cY) {
   var nodeX=0;
   var nodeY=0;
   var halfNodeZoneW=NodeZoneW/2;
   var halfNodeZoneH=NodeZoneH/2;
   var halfNodeW = NodeW/2;
   var halfNodeH = NodeH/2
   inWhoLeft= null;
   inWhoRight = null;
   inWhoBottom= null;
   inWhoTop= null;
   inWho = null;

   for (var i=0;i<id.length;i++ )
   {
      //----��ڵ㲻�ж�
      if (sFlow.sNode[i].n_type!=-3) {
      //---�õ��ڵ������λ��
	  nodeX=sFlow.sNode[i].sx+halfNodeW;
	  nodeY=sFlow.sNode[i].sy+halfNodeH;


         //--���ڵ��δ�ڵ㲻�ж�����
	  if (sFlow.sNode[i].n_type!=-1&&sFlow.sNode[i].n_type!=-2)
      {

       //--�жϵ�ǰλ���Ƿ��ڽڵ�����
       if ((cX<=(nodeX-halfNodeW))&&(cX>(nodeX-halfNodeW-halfNodeZoneW))&&(cY<(nodeY+halfNodeH))&&(cY>(nodeY-halfNodeH)))
       {
		   inWhoLeft = sFlow.sNode[i];
		   //window.status="��ǰλ��-->"+inWhoLeft.n_name+"�����";
		   break;
	   }
	   //--�жϵ�ǰλ���Ƿ��ڽڵ���ұ�
	   if ((cX>=(nodeX+halfNodeW))&&(cX<(nodeX+halfNodeW+halfNodeZoneW))&&(cY<(nodeY+halfNodeH))&&(cY>(nodeY-halfNodeH)))
	   {
		   inWhoRight = sFlow.sNode[i];
		   //window.status="��ǰλ��-->"+inWhoRight.n_name+"���ұ�";
		   break;
	   }
	   if ((cX>(nodeX-halfNodeW))&&(cX<(nodeX+halfNodeW))&&(cY>(nodeY-halfNodeH))&&(cY<(nodeY+halfNodeH)))
	   {
           inWho = sFlow.sNode[i];
		   //window.status="��ǰλ��-->"+inWho.n_name+"������";
		   break;
	   }

	   }
	   //---���ڵ㲻�ж��Ͻڵ�
	   if (sFlow.sNode[i].n_type!=-1)
	   {
		   if ((cX>(nodeX-halfNodeW))&&(cX<(nodeX+halfNodeW))&&(cY<=(nodeY-halfNodeH))&&(cY>(nodeY-halfNodeH-halfNodeZoneH)))
	   {
		   inWhoTop = sFlow.sNode[i];
		   //window.status="��ǰλ��-->"+inWhoTop.n_name+"���ϱ�";
		   break;
	   }
	   }
	   //--ĩ�ڵ㲻�ж��½ڵ�
	   if (sFlow.sNode[i].n_type!=-2)
	   {
		   if ((cX>(nodeX-halfNodeW))&&(cX<(nodeX+halfNodeW))&&(cY>=(nodeY+halfNodeH))&&(cY<(nodeY+halfNodeH+halfNodeZoneH)))
	   {
		   inWhoBottom = sFlow.sNode[i];
		   //window.status="��ǰλ��-->"+inWhoBottom.n_name+"���±�";
		   break;
	   }
	   }
	   }

   }

}



//---------------------------------------------------------------
//����ҳ����ʹ�õķ���
//---------------------------------------------------------------
//---���Ҽ��˵�
function showMenu()
{
if (inWho!=null)
	{
	chooseNode=inWho;
	menuLayer.style.display = '';
	menuLayer.style.posLeft =window.event.clientX + PX;
	menuLayer.style.posTop  = window.event.clientY + PY;
	}
}
//--�ı�˵�����ɫ
function cl(node)
{
node.style.fontSize = '9pt';
node.style.color = '#FFFFFF';
node.style.background = '#000080';
node.style.cursor ='hand';
}

//--��ԭ�˵�����ɫ
function nr(node)
{
node.style.fontSize = '9pt';
node.style.color = '#000000';
node.style.background = "";
}


//---ɾ���ڵ�
function Node_Del()
{
var tmpNodeName=chooseNode.n_name;
var NodeName;
if (tmpNodeName.length>0?tmpNodeName.slice(0,1)=="<":false)
  {
  var NodeNameBegin = tmpNodeName.indexOf('>');
  var NodeNameEnd = tmpNodeName.indexOf('<',NodeNameBegin);
  NodeName = tmpNodeName.slice(NodeNameBegin+1,NodeNameEnd);
  }
else
  {
  NodeName = tmpNodeName;
  }
var conf = confirm('ȷ��Ҫɾ���˽ڵ�'+NodeName+'��');
if(conf)
  {
	submitform.ProNodeID.value=chooseNode.n_id;
	submitform.event.value="del";
    submitform.submit();
  }
chooseNode=null;
}

//---�޸Ľڵ�
function Node_Edit()
{
var retValue = new Array();
retValue = window.showModalDialog('/workflow/ModelNodeFactory?event=EditNodeEvent&ProNodeID='+chooseNode.n_id+'&BusinessID='+submitform.ProcessClass.value+'&isAlias='+submitform.isAlias.value+'&processID='+submitform.ProcessID.value,'','dialogwidth=480px; dialogheight=420px; status=no');
if (retValue!=null)
  {
  submitform.OperID.value =  retValue[1];
  submitform.BackFlag.value = retValue[2];
  submitform.JumpFlag.value =  retValue[3];
  submitform.ExpandFlag.value = retValue[4];
  submitform.EditFlag.value = retValue[5];
  submitform.CancleFlag.value = retValue[6];
  submitform.AgentFlag.value = retValue[7];
  submitform.DelayFlag.value = retValue[8];
  submitform.AllFlag.value = retValue[9];
  submitform.DelayDay.value = retValue[10];
  submitform.aliasName.value = retValue[11];
  submitform.sqlValue.value = retValue[12];
  submitform.responseSql.value = retValue[13];
  submitform.operURL.value = retValue[14];
  submitform.OperType.value = retValue[15];
  submitform.ProNodeID.value = chooseNode.n_id;
  submitform.event.value = "ProNodeEditEvent";
  submitform.submit();
  }
  chooseNode=null;
}

function refresh() {
  submitform.event.value="refresh";
  submitform.submit();
}

function delFlow() {
  submitform.event.value="delFlow";
  submitform.submit();
}

function stringCut(str)
{
var strLen = str.length;
if (strLen>0)
  if (str.slice(0,1)!="<")
    {
	if (strLen>5)
	  return str.slice(0,5)+"..";
	else
	  return str;
    }
  else
    return str;
}


function doContextmenu()
{
event.returnValue = false;
}

//-------------------------------------------------------------
//���ѡ������
//-------------------------------------------------------------
function infolder()
{
isinfolder = true;
}

function outfolder()
{
if (isinfolder)
  {
  scrollback();
  isinfolder = false;
  }
}

function scrolllock(obj)
{
folderlock = !folderlock;
if (folderlock)
  {
  obj.className='down';
  obj.bgColor='#F2F1EE';
  pushpin.src = '/images/workflow/pushpin_h.gif';
  obj.title="�����˵����Զ�����";
  }
else
  {
  obj.className='over';
  obj.bgColor='';
  pushpin.src="/images/workflow/pushpin.gif";
  obj.title="�رղ˵����Զ�����";
  }
//if (!folderlock)
//  {
//  scrollback();
//  }
}

function scrollback()
{
folderhidden = false;
if (!folderlock&&(folderNode.style.posLeft+folderNode.style.posWidth)>(PX+5)&&foldershow)
  {
  foldervar = foldervar - 5;
  folderNode.style.posLeft = PX + foldervar;
  setTimeout('scrollback()',10)
  }
else
  {
  folderhidden = true;
  }
}

function scrollall()
{
foldershow = false;
if (!folderlock&&folderNode.style.posLeft<PX&&folderhidden)
  {
  foldervar = foldervar + 5;
  folderNode.style.posLeft = PX + foldervar;
  setTimeout('scrollall()',10)
  }
else
  {
  foldershow = true;
  }
}

function menuout()
{
if (!folderlock)
  menustate.className='out';
}

function menuover()
{
if (!folderlock)
  menustate.className='over';
}

function menudown()
{
scrolllock(menustate);
}

function depsel() {
MouseDoSel(1);
}

function rolesel() {
MouseDoSel(2);
}

function personsel() {
MouseDoSel(0);
}

function groupsel() {
MouseDoSel(3);
}

function processsel() {
MouseDoSel(4);
}
//---------------------------------------------------------------
//ҳ��load��ִ��
//---------------------------------------------------------------

//----���崰�ڵ�onscroll�¼�
window.onscroll = doscroll;

menustate.onmouseout = menuout;
menustate.onmouseover = menuover;
menustate.onmousedown = menudown;
folder.onmouseover = infolder;

depselect.onmousedown = depsel;
roleselect.onmousedown = rolesel;
personselect.onmousedown = personsel;
groupselect.onmousedown = groupsel;
processselect.onmousedown = processsel;

scrollallhot.onmouseover = scrollall;
scrollallhot1.onmouseover = scrollall;
outfolderhot1.onmouseover = outfolder;

//----����ҳ�������¼�
document.onmousemove = doMouseMove;
document.onmouseup = doMouseUp;
document.onmousedown = doMouseDown;
document.oncontextmenu = doContextmenu;

createFlow();
drawFlow();
outputFlow();