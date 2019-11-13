<html>
<title>文章列表</title>
<body>
<h6>Freemarker 模板引擎</h6>
<table border="1">
    <thead>
    <tr>
        <th>序号</th>
        <th>标题</th>
        <th>摘要</th>
        <th>创建时间</th>
    </tr>
    </thead>
<#list list as order>
    <tr>
        <td>${order.id}</td>
        <td>${order.orderCode}</td>
        <td>${order.userId}</td>
        <td>${order.createTime?string('yyyy-MM-dd hh:mm:ss')}</td>
    </tr>
</#list>
</table>

</body>
</html>