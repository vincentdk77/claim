/*�������� */

/* *
 * ȫ�ֿռ� Vcity
 * */
var Vcity = {};
/* *
 * ��̬������
 * @name _m
 * */
Vcity._m = {
    /* ѡ��Ԫ�� */
    $:function (arg, context) {
        var tagAll, n, eles = [], i, sub = arg.substring(1);
        context = context || document;
        if (typeof arg == 'string') {
            switch (arg.charAt(0)) {
                case '#':
                    return document.getElementById(sub);
                    break;
                case '.':
                    if (context.getElementsByClassName) return context.getElementsByClassName(sub);
                    tagAll = Vcity._m.$('*', context);
                    n = tagAll.length;
                    for (i = 0; i < n; i++) {
                        if (tagAll[i].className.indexOf(sub) > -1) eles.push(tagAll[i]);
                    }
                    return eles;
                    break;
                default:
                    return context.getElementsByTagName(arg);
                    break;
            }
        }
    },

    /* ���¼� */
    on:function (node, type, handler) {
        node.addEventListener ? node.addEventListener(type, handler, false) : node.attachEvent('on' + type, handler);
    },

    /* ��ȡ�¼� */
    getEvent:function(event){
        return event || window.event;
    },

    /* ��ȡ�¼�Ŀ�� */
    getTarget:function(event){
        return event.target || event.srcElement;
    },

    /* ��ȡԪ��λ�� */
    getPos:function (node) {
        var scrollx = document.documentElement.scrollLeft || document.body.scrollLeft,
                scrollt = document.documentElement.scrollTop || document.body.scrollTop;
        var pos = node.getBoundingClientRect();
        return {top:pos.top + scrollt, right:pos.right + scrollx, bottom:pos.bottom + scrollt, left:pos.left + scrollx }
    },

    /* �����ʽ�� */
    addClass:function (c, node) {
        if(!node)return;
        node.className = Vcity._m.hasClass(c,node) ? node.className : node.className + ' ' + c ;
    },

    /* �Ƴ���ʽ�� */
    removeClass:function (c, node) {
        var reg = new RegExp("(^|\\s+)" + c + "(\\s+|$)", "g");
        if(!Vcity._m.hasClass(c,node))return;
        node.className = reg.test(node.className) ? node.className.replace(reg, '') : node.className;
    },

    /* �Ƿ���CLASS */
    hasClass:function (c, node) {
        if(!node || !node.className)return false;
        return node.className.indexOf(c)>-1;
    },

    /* ��ֹð�� */
    stopPropagation:function (event) {
        event = event || window.event;
        event.stopPropagation ? event.stopPropagation() : event.cancelBubble = true;
    },
    /* ȥ�����˿ո� */
    trim:function (str) {
        return str.replace(/^\s+|\s+$/g,'');
    }
};

/* ���г�������,���԰��ո�ʽ������ӣ�����|beijing|bj����ǰ6��Ϊ���ų��� */

Vcity.allCity = ['ũҵ����|nongye|ny','��ͨ����|jiaotong|jt', '��������|jianshe|js',  '�������|guangda|gd', '��������|zhaoshang|zs', '��������|zhongxin|zx',
    '��������|gongshang|gs', '�ַ�����|pufa|pf', '��������|minsheng|ms', '�㷢����|guangfa|gf','�й�����|zhonguo|zg', '���ҿ�������|guojia|gj',
    '�й�����������|zhonguojinchukou|zgjck','�й�ũҵ��չ����|zhonguonongyefazhan|zg', '��������|huaxia|hx','�㶫��չ����|guangdongfazhan|gd',
    '���ڷ�չ����|shenzhenfazhan|sz','��ҵ����|xingye|xy','������ҵ����|chengshishangye|cs', '����ũ����ҵ����|nongcunshangyeyinhang|nc',
    '�������|huifeng|hf', '��������|zheshang|zs','ũ���������|nongcunhezuo|nc', '�������йɷ����޹�˾|bohai|bh', '�������йɷ����޹�˾|huishang|hs', 
    '�������������ι�˾|zhenyinhang|zy','����������|chengshixinyongshe|cs', 'ũ�������纬����ũ����ҵ����|nongcunxinyongshe|nc', 
    '�й�������������|zhongguoyongzheng|zg', '�������|huifeng|hf', '��������|dongya|dy', '������ҵ����|nanyang|ny', '���������й����޹�˾|hengsheng|fs', 
    '�й�����������޹�˾|zhongguoxianggang|zg', '�����������޹�˾|jiyou|jy', '�����������޹�˾|chuangye|cy', '��չ�����й����޹�˾|xingchen|xc',
    '���������й����޹�˾|yongheng|yh', '��¡����|yonglong|yl', '���������й����޹�˾|huaqi|hq', '�����������޹�˾|meiguo|mg','Ħ����ͨ�����й����޹�˾|mogen|mg',
    '���ⶫ�����������й����޹�˾|sanling|sl','�ձ�����ס�����йɷ����޹�˾|riben|rb','��۵�������|xianggang|xg','����ʵҵ�����й����޹�˾|ruihui|rh',
    '�ձ�ɽ�����йɷ����޹�˾|riben|rb','�����⻻���йɷ����޹�˾|hanguo|hg','���������й����޹�˾|youli|yl','������ҵ����|hanguo|hg',
    '�º������й����޹�˾|xinhan|xh','������С��ҵ�������޹�˾|hanguo|hg','���������й����޹�˾|hanya|hy','���������й����޹�˾|huaqiao|hq',
    '�������й����޹�˾|dahua|dh','��չ�����й����޹�˾|xingzhan|xz','̩���̹����д������޹�˾|taiguo|tg','�µ�������������йɷ����޹�˾|aodili|ad',
    '����ʱ�������йɷ����޹�˾|buli|bl','����ʱ��ͨ�������޹�˾|fubi|fb','��������|helan|hl','�����������йɷ����޹�˾|helan|hl',
    '��������|zhada|zd','Ӣ���ո����ʼ����й������޹�˾|yinguo|yg','������ҵ�����й����޹�˾|faguo|fg','���������������йɷ����޹�˾|faguo|fg',
    '������ó���йɷ����޹�˾|faguo|fg','�¹�����˹�����йɷݹ�˾|deguo|dg','����־�����й����޹�˾|deyi|dy','�¹���ҵ���йɷ����޹�˾|deguo|dg',
    '�¹��������йɷ����޹�˾|deguo|dg','�¹��ͷ�����������|deguo|dg','�¹�������־������|deguo|dg','���������ʥ�������йɷ����޹�˾|yidali|yd',
    '��ʿ�Ŵ����йɷ����޹�˾|ruishi|rs','��ʿ����|ruishi|rs','���ô��ҵ�������޹�˾|jiana|jn','���ô����������������޹�˾|jiana|jn',
    '�Ĵ����Ǻ����������м������޹�˾|aoda|ad','Ħ��ʿ�������������й����޹�˾|mogen|mg','���������й����޹�˾|lianhe|lh','���������������޹�˾|helan|hl',
    '���Ź�������|xiamen|xm','�������������й����޹�˾|faguo|fg','��������|huashang|hs','��һ����|huayi|hy','���ŵ�������|aomen|am','���ҽ��|guojia|gj','��������|qita|qt'];

/* ������ʽ ɸѡ���ĳ�������ƴ��������ĸ */

Vcity.regEx = /^([\u4E00-\u9FA5\uf900-\ufa2d]+)\|(\w+)\|(\w)\w*$/i;
Vcity.regExChiese = /([\u4E00-\u9FA5\uf900-\ufa2d]+)/;

/* *
 * ��ʽ����������Ϊ����oCity������a-h,i-p,q-z,hot���ų��з��飺
 * {HOT:{hot:[]},ABCDEFGH:{a:[1,2,3],b:[1,2,3]},IJKLMNOP:{i:[1.2.3],j:[1,2,3]},QRSTUVWXYZ:{}}
 * */

(function () {
    var citys = Vcity.allCity, match, letter,
            regEx = Vcity.regEx,
            reg2 = /^[a-h]$/i, reg3 = /^[i-p]$/i, reg4 = /^[q-z]$/i;
    if (!Vcity.oCity) {
        Vcity.oCity = {hot:{},ABCDEFGH:{}, IJKLMNOP:{}, QRSTUVWXYZ:{}};
        //console.log(citys.length);
        for (var i = 0, n = citys.length; i < n; i++) {
            match = regEx.exec(citys[i]);
            letter = match[3].toUpperCase();
            if (reg2.test(letter)) {
                if (!Vcity.oCity.ABCDEFGH[letter]) Vcity.oCity.ABCDEFGH[letter] = [];
                Vcity.oCity.ABCDEFGH[letter].push(match[1]);
            } else if (reg3.test(letter)) {
                if (!Vcity.oCity.IJKLMNOP[letter]) Vcity.oCity.IJKLMNOP[letter] = [];
                Vcity.oCity.IJKLMNOP[letter].push(match[1]);
            } else if (reg4.test(letter)) {
                if (!Vcity.oCity.QRSTUVWXYZ[letter]) Vcity.oCity.QRSTUVWXYZ[letter] = [];
                Vcity.oCity.QRSTUVWXYZ[letter].push(match[1]);
            }
            /* ���ų��� ǰ16�� */
            if(i<10){
                if(!Vcity.oCity.hot['hot']) Vcity.oCity.hot['hot'] = [];
                Vcity.oCity.hot['hot'].push(match[1]);
            }
        }
    }
})();
/* ����HTMLģ�� */
Vcity._template = [
    '<p class="tip">��������������ĸ˳Ѱ����</p>',
    '<ul>',
    '<li class="on">��������</li>',
    '<li>ABCDEFGH</li>',
    '<li>IJKLMNOP</li>',
    '<li>QRSTUVWXYZ</li>',
    '</ul>'
];

/* *
 * ���пؼ����캯��
 * @CitySelector
 * */

Vcity.CitySelector = function () {
    this.initialize.apply(this, arguments);
};

Vcity.CitySelector.prototype = {

    constructor:Vcity.CitySelector,

    /* ��ʼ�� */

    initialize :function (options) {
        var input = options.input;
        this.input = Vcity._m.$('#'+ input);
        this.inputEvent();
    },

    /* *
     * @createWarp
     * ��������BOX HTML ���
     * */

    createWarp:function(){
        var inputPos = Vcity._m.getPos(this.input);
        var div = this.rootDiv = document.createElement('div');
        var that = this;

        // ����DIV��ֹð��
        Vcity._m.on(this.rootDiv,'click',function(event){
            Vcity._m.stopPropagation(event);
        });

        // ���õ���ĵ����ص����ĳ���ѡ���
        Vcity._m.on(document, 'click', function (event) {
            event = Vcity._m.getEvent(event);
            var target = Vcity._m.getTarget(event);
            if(target == that.input) return false;
            //console.log(target.className);
            if (that.cityBox)Vcity._m.addClass('hide', that.cityBox);
            if (that.ul)Vcity._m.addClass('hide', that.ul);
            if(that.myIframe)Vcity._m.addClass('hide',that.myIframe);
        });
        div.className = 'citySelector';
        div.style.position = 'absolute';
        div.style.left = inputPos.left + 'px';
        div.style.top = inputPos.bottom + 'px';
        div.style.zIndex = 999999;

        // �ж��Ƿ�IE6�������IE6��Ҫ���iframe������סSELECT��
        var isIe = (document.all) ? true : false;
        var isIE6 = this.isIE6 = isIe && !window.XMLHttpRequest;
        if(isIE6){
            var myIframe = this.myIframe =  document.createElement('iframe');
            myIframe.frameborder = '0';
            myIframe.src = 'about:blank';
            myIframe.style.position = 'absolute';
            myIframe.style.zIndex = '-1';
            this.rootDiv.appendChild(this.myIframe);
        }

        var childdiv = this.cityBox = document.createElement('div');
        childdiv.className = 'cityBox';
        childdiv.id = 'cityBox';
        childdiv.innerHTML = Vcity._template.join('');
        var hotCity = this.hotCity =  document.createElement('div');
        hotCity.className = 'hotCity';
        childdiv.appendChild(hotCity);
        div.appendChild(childdiv);
        this.createHotCity();
    },

    /* *
     * @createHotCity
     * TAB����DIV��hot,a-h,i-p,q-z ����HTML���ɣ�DOM����
     * {HOT:{hot:[]},ABCDEFGH:{a:[1,2,3],b:[1,2,3]},IJKLMNOP:{},QRSTUVWXYZ:{}}
     **/

    createHotCity:function(){
        var odiv,odl,odt,odd,odda=[],str,key,ckey,sortKey,regEx = Vcity.regEx,
                oCity = Vcity.oCity;
        for(key in oCity){
            odiv = this[key] = document.createElement('div');
            // ������ȫ������hide
            odiv.className = key + ' ' + 'cityTab hide';
            sortKey=[];
            for(ckey in oCity[key]){
                sortKey.push(ckey);
                // ckey����ABCDEDG˳������
                sortKey.sort();
            }
            for(var j=0,k = sortKey.length;j<k;j++){
                odl = document.createElement('dl');
                odt = document.createElement('dt');
                odd = document.createElement('dd');
                odt.innerHTML = sortKey[j] == 'hot'?'&nbsp;':sortKey[j];
                odda = [];
                for(var i=0,n=oCity[key][sortKey[j]].length;i<n;i++){
                    str = '<a href="#">' + oCity[key][sortKey[j]][i] + '</a>';
                    odda.push(str);
                }
                odd.innerHTML = odda.join('');
                odl.appendChild(odt);
                odl.appendChild(odd);
                odiv.appendChild(odl);
            }

            // �Ƴ����ų��е�����CSS
            Vcity._m.removeClass('hide',this.hot);
            this.hotCity.appendChild(odiv);
        }
        document.body.appendChild(this.rootDiv);
        /* IE6 */
        this.changeIframe();

        this.tabChange();
        this.linkEvent();
    },

    /* *
     *  tab����ĸ˳���л�
     *  @ tabChange
     * */

    tabChange:function(){
        var lis = Vcity._m.$('li',this.cityBox);
        var divs = Vcity._m.$('div',this.hotCity);
        var that = this;
        for(var i=0,n=lis.length;i<n;i++){
            lis[i].index = i;
            lis[i].onclick = function(){
                for(var j=0;j<n;j++){
                    Vcity._m.removeClass('on',lis[j]);
                    Vcity._m.addClass('hide',divs[j]);
                }
                Vcity._m.addClass('on',this);
                Vcity._m.removeClass('hide',divs[this.index]);
                /* IE6 �ı�TAB��ʱ�� �ı�Iframe ��С*/
                that.changeIframe();
            };
        }
    },

    /* *
     * ����LINK�¼�
     *  @linkEvent
     * */

    linkEvent:function(){
        var links = Vcity._m.$('a',this.hotCity);
        var that = this;
        for(var i=0,n=links.length;i<n;i++){
            links[i].onclick = function(){
                that.input.value = this.innerHTML;
                Vcity._m.addClass('hide',that.cityBox);
                /* �����������ʱ������myIframe */
                Vcity._m.addClass('hide',that.myIframe);
            }
        }
    },

    /* *
     * INPUT����������¼�
     * @inputEvent
     * */

    inputEvent:function(){
        var that = this;
        Vcity._m.on(this.input,'click',function(event){
            event = event || window.event;
            if(!that.cityBox){
                that.createWarp();
            }else if(!!that.cityBox && Vcity._m.hasClass('hide',that.cityBox)){
                // slideul �����ڻ��� slideul���ڵ��������ص�ʱ�� ���߲��ܹ���
                if(!that.ul || (that.ul && Vcity._m.hasClass('hide',that.ul))){
                    Vcity._m.removeClass('hide',that.cityBox);

                    /* IE6 �Ƴ�iframe ��hide ��ʽ */
                    //alert('click');
                    Vcity._m.removeClass('hide',that.myIframe);
                    that.changeIframe();
                }
            }
        });
        Vcity._m.on(this.input,'focus',function(){
            that.input.select();
            if(that.input.value == '') that.input.value = '';
        });
        Vcity._m.on(this.input,'blur',function(){
            if(that.input.value == '') that.input.value = '';
        });
        Vcity._m.on(this.input,'keyup',function(event){
            event = event || window.event;
            var keycode = event.keyCode;
            Vcity._m.addClass('hide',that.cityBox);
            that.createUl();

            /* �Ƴ�iframe ��hide ��ʽ */
            Vcity._m.removeClass('hide',that.myIframe);

            // �����˵���ʾ��ʱ��׽�����¼�
            if(that.ul && !Vcity._m.hasClass('hide',that.ul) && !that.isEmpty){
                that.KeyboardEvent(event,keycode);
            }
        });
    },
    /* IE6�ĸı�����SELECT �� IFRAME�ߴ��С */
    changeIframe:function(){
        if(!this.isIE6)return;
        this.myIframe.style.width = this.rootDiv.offsetWidth + 'px';
        this.myIframe.style.height = this.rootDiv.offsetHeight + 'px';
    },

    /* *
     * �ض������¼����ϡ��¡�Enter��
     * @ KeyboardEvent
     * */

    KeyboardEvent:function(event,keycode){
        var lis = Vcity._m.$('li',this.ul);
        var len = lis.length;
        switch(keycode){
            case 40: //���¼�ͷ��
                this.count++;
                if(this.count > len-1) this.count = 0;
                for(var i=0;i<len;i++){
                    Vcity._m.removeClass('on',lis[i]);
                }
                Vcity._m.addClass('on',lis[this.count]);
                break;
            case 38: //���ϼ�ͷ��
                this.count--;
                if(this.count<0) this.count = len-1;
                for(i=0;i<len;i++){
                    Vcity._m.removeClass('on',lis[i]);
                }
                Vcity._m.addClass('on',lis[this.count]);
                break;
            case 13: // enter��
                this.input.value = Vcity.regExChiese.exec(lis[this.count].innerHTML)[0];
                Vcity._m.addClass('hide',this.ul);
                Vcity._m.addClass('hide',this.ul);
                /* IE6 */
                Vcity._m.addClass('hide',this.myIframe);
                break;
            default:
                break;
        }
    },

    /* *
     * �����б��li�¼�
     * @ liEvent
     * */

    liEvent:function(){
        var that = this;
        var lis = Vcity._m.$('li',this.ul);
        for(var i = 0,n = lis.length;i < n;i++){
            Vcity._m.on(lis[i],'click',function(event){
                event = Vcity._m.getEvent(event);
                var target = Vcity._m.getTarget(event);
                that.input.value = Vcity.regExChiese.exec(target.innerHTML)[0];
                Vcity._m.addClass('hide',that.ul);
                /* IE6 �����˵�����¼� */
                Vcity._m.addClass('hide',that.myIframe);
            });
            Vcity._m.on(lis[i],'mouseover',function(event){
                event = Vcity._m.getEvent(event);
                var target = Vcity._m.getTarget(event);
                Vcity._m.addClass('on',target);
            });
            Vcity._m.on(lis[i],'mouseout',function(event){
                event = Vcity._m.getEvent(event);
                var target = Vcity._m.getTarget(event);
                Vcity._m.removeClass('on',target);
            })
        }
    }
};
    var test=new Vcity.CitySelector({input:'citySelect'});