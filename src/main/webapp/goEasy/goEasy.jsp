<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<script type="text/javascript" src="http://rest-hangzhou.goeasy.io/goeasy.js"></script>
<script>
    var goEasy = new GoEasy({
    //接收的appkey
    appkey: "BC-b161122b054940e995ba7c0e68fc6915"
    });
    goEasy.subscribe({
    //当前的channel名称
     channel: "123123",
        onMessage: function (message) {
         alert("Channel:" + message.channel + " content:" + message.content);
     }
    });
</script>

</body>
</html>