(function(jQuery) {
	/**
	 * 删除的组件 
	 */
	$.deleteObj = function(config) {
		/**
		 * config.id代表删除按钮的id
		 */
		 $("#"+config.id).unbind("click");
		 $("#"+config.id).bind("click",function(){
			if($("input[name='"+config.checkboxname+"']:checked").length==0){
				alert("请选中一个再删除");
			}else{
				if(window.confirm("您确认要删除吗")){
					//被选中的所有复选框
					var checkedNodes = $("input[name='"+config.checkboxname+"']:checked");
					/**
					 * 1,2,3,4
					 */
					var checkedStr = "";
					for(var i=0;i<checkedNodes.length;i++){
						if(i==checkedNodes.length-1){
							/**
							 * checkedNodes[i]代表一个CheckBox元素
							 * checkedNodes[i]是一个dom对象
							 */
							checkedStr = checkedStr+$(checkedNodes[i]).attr("value");
						}else{
							checkedStr = checkedStr+$(checkedNodes[i]).attr("value")+",";
						}
					}
					window.location.href = config.url+"?checkedStr="+checkedStr;
				}
			}
		 });
		 
		 /**
		  * 触发最上面的CheckBox事件
		  * 如果该CheckBox被全部选中，下面的所有CheckBox被选中
		  * 如果该CheckBox不被选中，下面的所有CheckBox不被选中
		  */
		 $('#'+config.controlCheckBox).unbind("click");
		 $('#'+config.controlCheckBox).bind("click",function(){
			 if($(this).attr("checked")){
				 $("input[name='"+config.checkboxname+"']").attr("checked",true);
			 }else{
				 $("input[name='"+config.checkboxname+"']").attr("checked",false);
			 }
		 });
		 
		 /**
		  *表格中的CheckBox事件 
		  */
		 $("input[name='"+config.checkboxname+"']").unbind("click");
		 $("input[name='"+config.checkboxname+"']").bind("click",function(){//表格中的CheckBox被全部选中
			 if( $("input[name='"+config.checkboxname+"']:not:(:checked)").length==0){
				 $('#'+config.controlCheckBox).attr("checked",true);
			 }else{
				 $('#'+config.controlCheckBox).attr("checked",false);
			 }
		 });
	}
})(jQuery);