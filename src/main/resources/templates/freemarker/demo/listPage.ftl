<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <title>list demo</title>
</head>
<body>
<p>We have these animals:
<table border=1>
<#list animals as animal>
    <tr>
        <td>${animal.name}</td>
        <td>${animal.price} Euros</td>
    </tr>
</#list>
</table>
</body>
</html>