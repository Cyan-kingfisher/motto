<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>信念</title>
    <link rel="stylesheet" href="../css/sidenav.css" type="text/css">
    <link rel="icon" href="../image/favicon.ico" type="image/x-icon"/>
    <style type="text/css">
        .toggle {
            display: block;
            height: 72px;
            line-height: 72px;
            text-align: center;
            width: 72px;
        }

        body {
            background: url("${img}");
            background-size: 100%;
            color: #fff;
        }
    </style>
</head>

<body>
<nav class="sidenav" data-sidenav data-sidenav-toggle="#sidenav-toggle">
    <div class="sidenav-header">
        <a href="/index">信念</a>
    </div>
    <div class="sidenav-header">
        <a href="/lover">爱情</a>
    </div>
    <div class="sidenav-header">
        <a href="/up/affection">UpLover</a>
    </div>
    <div class="sidenav-header">
        <a href="/up/belief">UpFaith</a>
    </div>
    <div class="sidenav-header">
        <a href="/step">跑步</a>
    </div>
</nav>
<a href="javascript:;" class="toggle" id="sidenav-toggle">
    <i class="material-icons">menu</i>
</a>
<div class="nr">
    <p class="center f24">${text}</p>
</div>

<script src="../js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="../js/sidenav.min.js"></script>
<script>
    $('[data-sidenav]').sidenav();
</script>
</body>

</html>