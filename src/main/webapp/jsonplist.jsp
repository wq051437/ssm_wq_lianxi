<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/5/7
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 这是jquery的核心包  -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <!-- 这是easyui的核心包  -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/util-js.js"></script>
    <!--  分页中文转换-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <!-- jqeuy默认的css样式 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/icon.css">
</head>
<body>

    <input type="button" id="jsonpButton" value="查询">

    <script>
        $("#jsonpButton").click(function(){
            alert(1344);
            $.ajax({
                async:"true",
                url:"http://localhost:8080/admin/queryShopList",
                type:"GET",
                dataType:"jsonp",
                jsonp:"theFunction",
                jsonpCallback:"showData",
                success:function(result){
                    alert(result);
                }
            });
        });
    </script>

</body>
</html>
