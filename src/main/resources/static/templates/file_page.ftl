<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!doctype html>
<html>

<head>
    <title>UPLOAD</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="Ravishing Contact Form Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>

    <!-- fonts -->
    <link href="//fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Roboto+Condensed:300,400,700" rel="stylesheet">
    <!-- /fonts -->
    <!-- css -->
    <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../css/stylee.css" rel="stylesheet" type='text/css' media="all"/>
    <link rel="icon" href="../image/favicon.ico" type="image/x-icon"/>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <!-- /css -->
</head>


<body>

<div style="display: flex">
    <a href="/">
        <svg style="margin: 24px 24px" t="1620573186441" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2148" width="24" height="24">
            <path d="M1024 438.857143L512 0 0 438.857143h82.651429v512a73.142857 73.142857 0 0 0 73.142857 73.142857h219.428571V585.142857h292.571429v438.857143h219.428571a73.142857 73.142857 0 0 0 73.142857-73.142857V438.857143z" p-id="2149" fill="#e74c3c"></path>
        </svg>
    </a>
    <h1 class="w3layouts" style="margin-left: 17%">UPLOAD</h1>
</div>
<div class="content-w3ls">
    <div class="content1-agile">
        <div class="info-w3l">
            <h2 class="wthree">UPLOAD</h2>
            <form
                    action="http://114.215.82.150:6754/fileAPI/up/original"
                    method="post"
                    id="form1"
                    enctype="multipart/form-data"
                    class="form-agileits">

                <input type="button" id="fileU" value="SELECT FILE" class="sign-in" onclick="clickFileButton()"/>

                <input hidden type="file" name="file" id="fileToUpload" onchange="fileSelected()"/>

                <br>
                <input type="text" id="username" name="project" placeholder="project path"
                       title="Please enter your First Name" required=""
                       style="height: 40px;width: 68%"
                >

                <input type="button" class="sign-in" onclick="uploadFile()" value="Upload" />

            </form>



            <p class="agileinfo" id="progressNumber"></p>
            <br>
            <ul class="social-w3-agileits">
                <li><a href="http://114.215.82.150:5200/up/belief#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="http://114.215.82.150:5200/up/belief#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="http://114.215.82.150:5200/up/belief#"><i class="fa fa-google-plus"></i></a></li>
                <li><a href="http://114.215.82.150:5200/up/belief#"><i class="fa fa-linkedin"></i></a></li>
            </ul>
        </div>
    </div>
    <div class="content2-agile">

    </div>
    <div class="clear"></div>
</div>
<p class="copyright-agileits">Nor shall Death brag thou wander'st in his shade, When in eternal lines to time thou
    growest</p>
</body>

<script type="text/javascript">
    function clickFileButton() {
        document.getElementById("fileToUpload").click();
    }
    function fileSelected() {

        var file = document.getElementById("fileToUpload").files[0];
        if (file) {

            var filesize = 0;
            if (file.size > 1024*1024)
                filesize = (Math.random(file.size * 100 / (1024*1024)) / 100).toString() + 'MB';
            else
                filesize = (Math.random(file.size * 100 / 1024) / 100).toString() + 'KB';

            document.getElementById("fileU").setAttribute("value", file.name);
        }
    }
    function uploadFile() {

        var xhr = new XMLHttpRequest();

        var formdata = document.querySelector("#form1");
        var fd = new FormData(formdata);

        xhr.upload.addEventListener("progress", uploadProgress, false);
        xhr.addEventListener("load", uploadComplete, false);
        xhr.addEventListener("error", uploadFailed, false);
        xhr.addEventListener("abort", uploadCanceled, false);
        /* Be sure to change the url below to the url of your upload server side script */
        xhr.open("POST", "http://114.215.82.150:6754/fileAPI/up/original");
        xhr.send(fd);
    }

    function uploadProgress(evt) {
        if (evt.lengthComputable) {
            var percentComplete = Math.round(evt.loaded * 100 / evt.total);
            document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '%';
        }
        else {
            document.getElementById('progressNumber').innerHTML = 'unable to compute';
        }
    }

    function uploadComplete(evt) {
        /* This event is raised when the server send back a response */
        alert(evt.target.responseText);
    }

    function uploadFailed(evt) {
        alert("There was an error attempting to upload the file.");
    }

    function uploadCanceled(evt) {
        alert("The upload has been canceled by the user or the browser dropped the connection.");
    }
</script>
</html>