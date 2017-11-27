<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div>
    <span>hello world! this is my first springboot demo!</span>
    <table border="1px">
    <#list data as item>
        <tr><td>${item.id}</td><td>${item.name}</td><td>${item.remark}</td></tr>
    </#list>
    </table>
</div>
</body>

</html>
