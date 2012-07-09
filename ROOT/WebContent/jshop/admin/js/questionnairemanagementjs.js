/**
 * Global variables
 */
var session ="true";
var rid = "";
var globalrjson = "";//post json data to backstage server
/**
 * ui
 */
$(function() {

    $("h6").each(function() {
        $(this).removeClass("selected");
    });
    $("ul").each(function() {
        $(this).removeClass("opened");
        $(this).addClass("closed");
    });
    $("#h-menu-pagecontent").addClass("selected");
    $("#menu-pagecontent").removeClass("closed");
    $("#menu-pagecontent").addClass("opened");
});
/*===========================================Gorgeous split-line==============================================*/
/**
 * Function
 */



/*===========================================Gorgeous split-line==============================================*/


/**
 * Required to initialize the page data
 */

/*===========================================Gorgeous split-line==============================================*/

/**
 * flexigrid list 
 */
$(function() {
	$("#questionnairemanagement").flexigrid( {
		url : 'findAllQuestionnaireT.action',
		dataType : 'json',
		colModel : [{
			display : '标题',
			name : 'title',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '问题',
			name : 'question',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '选项代号',
			name : 'choosetag',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '回答',
			name : 'answer',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '创建时间',
			name : 'createtime',
			width : 200,
			sortable : true,
			align : 'center'
		} ],
		buttons : [ {
			name : '添加',
			bclass : 'add',
			onpress : action
		}, {
			name : '编辑',
			bclass : 'edit',
			onpress : action
		}, {
			name : '删除',
			bclass : 'delete',
			onpress : action
		}, {
			separator : true
		} ],
		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '问卷列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox : true
	});

	function action(com, grid) {
		if (com == '添加') {
            if($('.trSelected',grid).length>0){
                var str1="";
                var str2="";
                $(".trSelected td:nth-child(2) div", $('#questionnairemanagement')).each(function(i) {
                    str1= this.innerHTML;
                });
                $(".trSelected td:nth-child(3) div", $('#questionnairemanagement')).each(function(i) {
                    str2= this.innerHTML;
                });
                window.location.href = "addquestionnaire.jsp?session="+session+"#pagecontent&title="+str1+"&question="+str2;
            }else{
                window.location.href = "addquestionnaire.jsp?session="+session+"#pagecontent";
            }
			
		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "addquestionnaire.jsp?session="+session+"#pagecontent&qid=" + str;
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		} else if (com = '删除') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("delQuestionnaireTByqid.action", {
							"qid" : str
						}, function(data) {
							$('#questionnairemanagement').flexReload();
						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
		}
	}

});
/*===========================================Gorgeous split-line==============================================*/
/**
 * Add Function
 */
/*
 * 增加问卷
 */
$(function() {
    var title="";
    var question="";
    title = $.query.get('title');
    question=$.query.get('question');
    $('#title').attr("value",title);
    $('#question').attr("value",question);
	$('#submit').click(function() {
		var title = $('#title').val();
		if (title == "") {
			jAlert('标题必须填写', '信息提示');
			return false;
		}
		var question = $('#question').val();
		var choosetag = $('#choosetag').val();
		var answer = $('#answer').val();
		var inputtype =$('#inputtype').val();
		$.post("addQuestionnaireT.action", {
			"title" : title,
			"question" : question,
			"choosetag" : choosetag,
			"answer" : answer,
			"inputtype" : inputtype
		}, function(data) {
			if (data.sucflag) {
				window.location.href = "questionnairemanagement.jsp?session=" + session + "#pagecontent";
			} else {
				jAlert('提交问题失败','信息提示');
                return false;
			}
		});

	});
});

/**
 * Update Function
 */
/**
 * 根据qid获取问卷信息
 */
$(function() {
	var qid = $.query.get('qid');
	if (qid == "") {
		return false;
	}
	$.post("findQuestionnaireTByqid.action", {
		"qid" : qid
	}, function(data) {
		if (data.bean != null) {
			$("#title").attr("value",data.bean.title);
            $("#question").attr("value",data.bean.question);
            $("#choosetag").atrr("value",data.bean.choosetag);
            $("#inputtype").val(data.bean.inputtype);
            $("#answer").val("value",data.bean.answer);
            $("#qid").attr("value",data.bean.qid);
		}
		// 显示修改按钮
		$('#modify').show();
		// 隐藏增加按钮
		$('#submit').hide();
	});

	/**
	 * 修改问卷
	 */
	$('#modify').click(function() {
		var title = $('#title').val();
        if (title == "") {
            jAlert('标题必须填写', '信息提示');
            return false;
        }
        var question = $('#question').val();
        var choosetag = $('#choosetag').val();
        var answer = $('#answer').val();
        var inputtype =$('#inputtype').val();
        var qid=$("#qid").val();
        $.post("updateQuestionnaireT.action", {
            "title" : title,
            "question" : question,
            "choosetag" : choosetag,
            "answer" : answer,
            "inputtype" : inputtype,
            "qid":qid
        }, function(data) {
            if (data.sucflag) {
                window.location.href = "questionnairemanagement.jsp?session=" + session + "#pagecontent";
            } else {
                jAlert('更新问题失败','信息提示');
                return false;
            }
        });
		
	});
});




