var roletree = {
		setting:{
			isSimpleData:true,
			treeNodeKey:"rid",
			treeNodeParentKey:"pid",
			showLine:"true",
			root:{
				isRoot:true,
				nodes:{}
			},
			callback:{//回调函数
				rightClick:function(event,treeId,treeNode){
					roletree.showRMenu(event.clientX,event.clientY);
				}
			}
		},
		loadRoleTree:function(){
			$.post("roleAction_showRoleTree.action",null,function(data){
				$("#roleTree").zTree(roletree.setting,data);
			});
		},
		/**
		 * 显示右键菜单 
		 */
		showRMenu:function(x,y){
			$("#rMenu ul").show();
			$("#rMenu").css({"top":y+"px","left":x+"px","display":"block"});
		}
};
$().ready(function(){
	roletree.loadRoleTree();
})