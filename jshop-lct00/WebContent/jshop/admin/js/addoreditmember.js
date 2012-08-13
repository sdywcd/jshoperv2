var flg=false;
function validatethenpostinfotoaddgoods(){
	var userid=$('#hiduserid').val();
	var username=$('#username').val();
	var realname=$('#realname').val();
	var email=$('#email').val();
	var sex=$("#sex").val();
	var telno=$('#telno').val();
	var mobile=$('#mobile').val();
	var points=$('#points').val();
	var qq=$('#qq').val();
	var msn=$('#msn').val();
	var grade=$('#grade').val();
	var state=$('#state').val();
	var userstate=$('#userstate').val();
	flg=true;
}


//点击编辑更新内容
$(function(){
	
	$("#editadminregister").click(function(){
		validatethenpostinfotoaddgoods();
		if(flg){
		var userid=$('#hiduserid').val();
		var username=$('#username').val();
		var realname=$('#realname').val();
		var email=$('#email').val();
		var sex=$("#sex").val();
		var telno=$('#telno').val();
		var mobile=$('#mobile').val();
		var points=$('#points').val();
		var qq=$('#qq').val();
		var msn=$('#msn').val();
		var grade=$('#grade').val();
		var state=$('#state').val();
		var userstate=$('#userstate').val();
		$.post("UpdateUserTunpwd.action",{"userid":userid,"username":username,"realname":realname,"email":email,"sex":sex,"telno":telno,"mobile":mobile,"points":points,"qq":qq,"msn":msn,"grade":grade,"userstate":userstate,"state":state},function(data){
			$('#membermanagement').flexReload();
			window.location.href="jshop/admin/member/membermanagement.jsp";
		});
		}else {
			return false;
		}
		
	});

	var userid=$.query.get('userid');
	if(userid==null){
		return false;
	}
	$.post("findUserById.action",{"userid":userid},function(data){
		$('#username').attr("value",data.beanlist.username);
		$('#realname').attr("value",data.beanlist.realname);
		$('#email').attr("value",data.beanlist.email);
		$('#sex').val(data.beanlist.sex);
		$('#telno').attr("value",data.beanlist.telno);
		$('#mobile').attr("value",data.beanlist.mobile);
		$('#points').attr("value",data.beanlist.points);
		$('#qq').attr("value",data.beanlist.qq);
		$('#msn').attr("value",data.beanlist.msn);
		$('#grade').val(data.beanlist.grade);
		$('#state').val(data.beanlist.state);
		$('#userstate').val(data.beanlist.userstate);
		$('#hiduserid').attr("value",data.beanlist.userid);
		$('#submit').hide();
		$('#editadminregister').show();	
		return;
	});
});
//$(function(){
//	$('#submit').click(function(){
//		validatethenpostinfotoaddgoods();
//		if(flg){
//			var userid=$('#hiduserid').val();
//			var username=$('#username').val();
//			var realname=$('#realname').val();
//			var email=$('#email').val();
//			var sex=$("#sex").val();
//			var telno=$('#telno').val();
//			var mobile=$('#mobile').val();
//			var points=$('#points').val();
//			var qq=$('#qq').val();
//			var msn=$('#msn').val();
//			var grade=$('#grade').val();
//			var state=$('#state').val();
//			var userstate=$('#userstate').val();
//			$.post("adminregister.action",{"userid":userid,"username":username,"realname":realname,"email":email,"sex":sex,"telno":telno,"mobile":mobile,"points":points,"qq":qq,"msn":msn,"grade":grade,"userstate":userstate,"state":state},function(data){
//				
//			});
//		}
//		
//	});
//});
