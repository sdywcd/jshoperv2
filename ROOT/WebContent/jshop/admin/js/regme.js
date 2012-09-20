// JavaScript Document regular verify
(function($){
	$.regtext = function(cregobj){
		
		cregobj = $.extend({ 		//creobj default values;		
			type : 'text',
			refillname : 'i need a filed name',
			behavior : 'alert',
			onSuccess : true,
			codelimit : 45
		},cregobj);

		if(cregobj.regular!=null){															//基本规范验证
				switch(cregobj.regular){
					case 'useraccount':
						var reg = /^[a-zA-Z0-9]{1,16}$/;								 	//用户账号必须是1至16位，大小写英文数字
						if(reg.test(cregobj.textvalue)){
							cregobj.onSuccess = true;
							$('#'+cregobj.regid).css("background-color","#fff");
							return cregobj;
							//you can do something when it's right ;
						}else{
							cregobj.onSuccess = false;
							$('#'+cregobj.regid).css("background-color","#F99");
							alert("用户账号必须是1至16位，大小写英文数字");
							return cregobj;		
							}
					break;
					case 'email':
						var reg = /\w+([-]?\w)*@([-]?\w)*[\.]?[\w]{2,3}([\.]?[\w]{2,3})?/; 	//email地址验证
						if(reg.test(cregobj.textvalue)){
							cregobj.onSuccess = true;
							$('#'+cregobj.regid).css("background-color","#fff");
							return cregobj;
						}else{
							cregobj.onSuccess = false;
							$('#'+cregobj.regid).css("background-color","#F99");
							alert("email地址不符合规范");
							return cregobj
						}
					break;	
					case 'EnChNum_':
						var reg = /^[a-zA-Z0-9\u4e00-\u9fa5_]*$/g; 							//以中文英文数字下划线组合
						if(reg.test(cregobj.textvalue)){
							cregobj.onSuccess = true;
							$('#'+cregobj.regid).css("background-color","#fff");
							return cregobj;
						}else{
							cregobj.onSuccess = false;
							$('#'+cregobj.regid).css("background-color","#F99");
							alert(cregobj.refillname+"合法组合以中文英文数字下划线组合");
							return cregobj;
						}
					break;
					default:
						var reg = new RegExp(cregobj.regular,"g");
						//自定义正则验证
						if(reg.test(cregobj.textvalue)){
							cregobj.onSuccess = true;
							$('#'+cregobj.regid).css("background-color","#fff");
							return cregobj;
						}else{
							cregobj.onSuccess = false;
							$('#'+cregobj.regid).css("background-color","#F99");
							alert(refillname);
							return cregobj;
						}
				}		
		}
		if(cregobj.codelimit){																//字符长度限制
			var reg = /^[\x00-\xff]$/g ;
			var textlength = 0;
			for(var i = 0 ; i<cregobj.textvalue.length;i++){
				if(reg.test(cregobj.textvalue.substring(i,1))){
						textlength +=2;
					}else{
						textlength++;
					}
			}
			if(textlength>cregobj.codelimit){					
					cregobj.onSuccess = false;
					alert('限制字符长度为'+cregobj.codelimit);
					$('#'+cregobj.regid).css("background-color","#F99");
					return cregobj;
			}else{
					cregobj.onSuccess = true;
					$('#'+cregobj.regid).css("background-color","#fff");
					return cregobj;
			}
			
		}
	};
	$.regvalue = function(cregobj){															//数值验证				
		cregobj = $.extend({ 		//creobj default values;		
			type : 'value',
			refillname : 'i need a filed name',
			behavior : 'alert',
			onSuccess : true,
			integerlimit : 10,
			fractionlimit : 0
		},cregobj);
		if(cregobj.regular!=null){
			switch(cregobj.regular){
				case 'nosigninteger':
					var reg = /^[1-9]\d*$/g;
					if(reg.test(cregobj.textvalue)){
						$('#'+cregobj.regid).css("background-color","#fff");
						return cregobj;
					}else{
						cregobj.onSuccess = false;
						$('#'+cregobj.regid).css("background-color","#F99");
						alert(cregobj.refillname+"不是无符号整数类型");
						return cregobj;
					}
				break;
				case 'floatordouble':
					var reg = /^(-?\d+)(\.\d+)?$/g;
					if(reg.test(cregobj.textvalue)){
						$('#'+cregobj.regid).css("background-color","#fff");
						return cregobj;
					}else{
						cregobj.onSuccess = false;
						$('#'+cregobj.regid).css("background-color","#F99");
						alert(cregobj.refillname+"不是浮点数类型");
						return cregobj;
					}
				break ;
				default:
					var reg = new RegExp(cregobj.regular,"g");
					//自定义正则验证
					if(reg.test(cregobj.textvalue)){
						cregobj.onSuccess = true;
						$('#'+cregobj.regid).css("background-color","#fff");
						return cregobj;
					}else{
						cregobj.onSuccess = false;
						$('#'+cregobj.regid).css("background-color","#F99");
						alert(refillname);
						return cregobj;
					}
			};
		}
		if(cregobj.fractionlimit==0){
			var strreg = "^[1-9][\\d]{0,"+(cregobj.integerlimit-1)+"}$";						//匹配多少位整数
			reg = new RegExp(strreg,"g");
			if(reg.test(cregobj.textvalue)){
				cregobj.onSuccess = true;
				$('#'+cregobj.regid).css("background-color","#fff");
				return cregobj;
				
			}else{
				alert("整数限制在"+cregobj.integerlimit);
				cregobj.onSuccess = false;
				$('#'+cregobj.regid).css("background-color","#F99");
				return cregobj;
				}
		}
		if(cregobj.fractionlimit!=0){
			var strreg = "^[1-9][\\d]{0,"+(cregobj.integerlimit-1)+"}\\.[\\d]{1,"+cregobj.fractionlimit+"}|(^0\\.)[\\d]{1,"+cregobj.fractionlimit+"}";//匹配积分10位,两位小数	
			alert (strreg);
			reg = new RegExp(strreg,"g");
			if(reg.test(cregobj.textvalue)){
				cregobj.onSuccess = true;
				$('#'+cregobj.regid).css("background-color","#fff");
				return cregobj;
			
			}else{
				alert("整数限制在"+cregobj.integerlimit+"精确度限制在"+cregobj.fractionlimit);
				$('#'+cregobj.regid).css("background-color","#F99");
				cregobj.onSuccess = false;
				return cregobj;
				}			
		}
	};
	$.regcompare = function(cregobj){													//比较数值上下限
			cregobj = $.extend({
				type : 'compare',
				uplimit : '',
				lowlimit : '',
				upregion : true,
				lowregion : false				
				},cregobj);
			if(cregobj.uplimit){
					if(cregobj.upregion){
						if(cregobj.textvalue<=cregobj.uplimit){
							cregobj.onSuccess = true;
							$('#'+cregobj.regid).css("background-color","#fff");
							return cregobj;
						}else if(cregobj.textvalue>cregobj.uplimit){
							alert(cregobj.refillname+"数值上限小于等于"+cregobj.uplimit);
							$('#'+cregobj.regid).css("background-color","#F99");
							cregobj.onSuccess = false;
							return cregobj;
						}
					}else{
						if(cregobj.textvalue<cregobj.uplimit){
							cregobj.onSuccess = true;
							$('#'+cregobj.regid).css("background-color","#fff");
							return cregobj;
						}else if(cregobj.textvalue>=cregobj.uplimit){
							alert(cregobj.refillname+"数值上限小于"+cregobj.uplimit);
							$('#'+cregobj.regid).css("background-color","#F99");
							cregobj.onSuccess = false;
							return cregobj;
						}
					}
				}
			if(cregobj.lowlimit){
					if(cregobj.lowregion){
						if(cregobj.textvalue>=cregobj.lowlimit){
							cregobj.onSuccess = true;
							$('#'+cregobj.regid).css("background-color","#fff");
							return cregobj;
						}else if(cregobj.textvalue<cregobj.lowlimit){
							alert(cregobj.refillname+"数值上限大于等于"+cregobj.lowlimit);
							$('#'+cregobj.regid).css("background-color","#F99");
							cregobj.onSuccess = false;
							return cregobj;
						}
					}else{
						if(cregobj.textvalue<cregobj.lowlimit){
							cregobj.onSuccess = true;
							$('#'+cregobj.regid).css("background-color","#fff");
							return cregobj;
						}else if(cregobj.textvalue<=cregobj.lowlimit){
							alert(cregobj.refillname+"数值上限大于"+cregobj.lowlimit);
							$('#'+cregobj.regid).css("background-color","#F99");
							cregobj.onSuccess = false;
							return cregobj;
						}
					}
				}
		};
	var docloaded = false;
	$(document).ready(function () {
		docloaded = true;
	});
	$.fn.regme = function(regobj){
		if(!regobj){
			//alert('is that nothing i can do?');
			return false;
		}
		if(regobj){
			
			for(var i = 0; i<regobj.length;i++)
				{
					var cregobj = regobj[i];
							
					if(!cregobj.regid){														//匹配对象id值不能为空
						alert('oops how can i find you my baby?');
						return false;			
					}
					if(!cregobj.textvalue){													//匹配对象的值不能为空
						alert('are you kidding nothing can compare');
						return false;
					}
					if(cregobj.type == 'text'){
						cregobj = $.regtext(cregobj);
						if(!cregobj.onSuccess){
							return false;
						}
					}else if(cregobj.type == 'value'){
						cregobj = $.regvalue(cregobj);
						if(!cregobj.onSuccess){
							return false;
						}
					}else if(cregobj.type == 'compare') {
						cregobj = $.regcompare(cregobj);
						if(!cregobj.onSuccess){
							return false;
						}
					}
				}
			return true;
		}else{
			return false;
		}
	};
})(jQuery);