<%@page pageEncoding="UTF-8" %>
<script>
    $(function () {
        $("#user-show-table").jqGrid({
            url : "${pageContext.request.contextPath}/user/selectAll",
            datatype : "json",
            colNames : [ '编号', '电话', '用户名', '密码', '别名','省份','城市','签名','相片','性别','创建时间'],
            colModel : [
                {name : 'id'},
                {name : 'phone'},
                {name : 'username'},
                {name : 'password'},
               // {name : 'salt'},
                {name : 'nickname'},
                {name : 'province'},
                {name : 'city'},
                {name : 'sign'},
                {name : 'photo',formatter:function (value,option,rows) {
                        return "<img style='width:100px;height:70px' src='${pageContext.request.contextPath}/user/img/"+rows.photo+"'>";
                    }},
                {name : 'sex'},
                {name : 'createDate'}
            ],
            styleUI:"Bootstrap",
            autowidth:true,
            rowNum : 10,
            rowList : [ 10, 20, 30 ],
            pager : '#user-page',
            viewrecords : true,
            caption : "",
        }).navGrid("#user-page", {
            edit : false,
            add : false,
            del : false,
            search:false
        });
    })

</script>

<ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="#">所有用户</a></li>
    <li role="presentation"><a href="${pageContext.request.contextPath}/user/export" onclick="">导出用户</a></li>
</ul>
<table id="user-show-table"></table>
<div id="user-page" style="height: 40px"></div>
