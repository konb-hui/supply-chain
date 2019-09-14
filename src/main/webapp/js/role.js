var roletree = {
		/**
		 *存放数据 
		 */
		data:{
			treeNode:'',
			zTreePlugin:''
		},
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
					roletree.data.treeNode=treeNode;
					roletree.showRMenu(event.clientX,event.clientY);
				}
			}
		},
		loadRoleTree:function(){
			$.post("roleAction_showRoleTree.action",null,function(data){
				 roletree.data.zTreePlugin=$("#roleTree").zTree(roletree.setting,data);
			});
		},
		/**
		 * 增加角色
		 */
		addRole:function(){
			var roleName = window.prompt("请输入角色的名称");
			if(roleName){
				var parameter = {
						name:roleName,
						pid:roletree.data.treeNode.rid,//所增加的父节点就是当前点击的节点
						isParent:false
				};
				$.post("roleAction_add.action",parameter,function(data){
					var newNode = {
							rid:data.rid,
							name:roleName,
							pid:roletree.data.treeNode.rid,
							isParent:false
					};
					/**
					 *roletree.data.zTreePlugin是zTree函数运行后的返回值 
					 */
					roletree.data.zTreePlugin.addNodes(roletree.data.treeNode,newNode,true)
				});
			}
		},
		/**
		 * 显示右键菜单 
		 */
		showRMenu:function(x,y){
			$("#rMenu ul").show();
			$("#rMenu").css({"top":y+"px","left":x+"px","display":"block"});
		},
		/**
		 *初始化事件 
		 */
		init:{
			initEvent:function(){
				/**
				 *添加角色事件 
				 */
				$("#addRole").unbind("click");
				$("#addRole").bind("click",function(){
					roletree.addRole();
				});
				/**
				 *修改角色事件 
				 */
				$("#updateRole").unbind("click");
				$("#updateRole").bind("click",function(){
					
				});
				/**
				 *删除角色事件 
				 */
				$("#deleteRole").unbind("click");
				$("#deleteRole").bind("click",function(){
					
				});
			}
		}
};
$().ready(function(){
	roletree.loadRoleTree();
	$("#rMenu").hover(function(){//进入rMenu区域是做的事
		
	},function(){//出来rMenu区域是做的事
		$("#rMenu").hide();
	});
	roletree.init.initEvent();
})