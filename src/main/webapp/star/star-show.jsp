<%@page pageEncoding="UTF-8" %>
<script>
    $(function () {
        $("#star-show-table").jqGrid({
            url : '${pageContext.request.contextPath}/star/selectAll',
            datatype : "json",
            height : 300,
            colNames : [ '编号', '艺名', '真名', '照片', '性别', '生日' ],
            colModel : [
                {name : 'id',hidden:true},
                {name : 'nickname',editable:true},
                {name : 'realname',editable:true},
                {name : 'photo',editable:true,edittype:"file",formatter:function (value,option,rows) {
                        return "<img style='width:100px;height:70px' src='${pageContext.request.contextPath}/star/img/"+rows.photo+"'>";
                    }},
                {name : 'sex',editable:true,edittype:"select",editoptions:{value:"男:男;女:女"}},
                {name : 'bir',editable:true,edittype:"date"}
            ],
            styleUI:'Bootstrap',
            autowidth:true,
            rowNum : 3,
            rowList : [ 3, 5, 10],
            pager : '#star-page',
            viewrecords : true,
            subGrid : true,
            caption : "所有明星列表",
            editurl : "${pageContext.request.contextPath}/star/edit",
            subGridRowExpanded : function(subgrid_id, id) {
                var subgrid_table_id, pager_id;
                subgrid_table_id = subgrid_id + "_t";
                pager_id = "p_" + subgrid_table_id;
                $("#" + subgrid_id).html(
                    "<table id='" + subgrid_table_id  +"' class='scroll'></table>" +
                    "<div id='" + pager_id + "' class='scroll'></div>");
                $("#" + subgrid_table_id).jqGrid(
                    {
                        url : "${pageContext.request.contextPath}/user/selectUsersByStarId?starId=" + id,
                        datatype : "json",
                        colNames : [ '编号', '用户名', '昵称', '头像','电话', '性别','地址','签名' ],
                        colModel : [
                            {name : "id",hidden:true},
                            {name : "username",editable:true},
                            {name : "nickname",editable:true},
                            {name : "photo",formatter:function (value,option,rows) {
                                    return "<img style='width:100px;height:70px' src='${pageContext.request.contextPath}/star/img/"+rows.photo+"'>";
                                }},
                            {name : "phone",editable:true},
                            {name : "sex",editable:true,trueedittype:"select",editoptions:{value:"男:男;女:女"}},
                            {name : "address",editable:true},
                            {name : "sign",editable:true}
                        ],
                        styleUI:"Bootstrap",
                        rowNum : 2,
                        pager : pager_id,
                        autowidth:true,
                        height : '100%'
                    });
                jQuery("#" + subgrid_table_id).jqGrid('navGrid',
                    "#" + pager_id, {
                        edit : false,
                        add : true,
                        del : false,
                        search:false
                    });
            },

        }).jqGrid('navGrid', '#star-page', {
            add : true,
            edit : false,
            del : false,
            search:false
        },{},{
            closeAfterAdd:true,
            afterSubmit:function(data){
                var status = data.responseJSON.status;
                var message = data.responseJSON.message;
                if(status){
                    $.ajaxFileUpload({
                        url:"${pageContext.request.contextPath}/star/upload",
                        data:{id:message},
                        fileElementId:"photo",
                        type:"post",
                        success:function(){
                            $("#star-show-table").trigger("reloadGrid");
                        }
                    })
                }
                return "123";
            }
        });
    })
</script>


<div class="panel page-header">
    <h3>展示所有的明星</h3>
</div>
<table id="star-show-table"></table>
<div id="star-page" style="height: 40px;"></div>