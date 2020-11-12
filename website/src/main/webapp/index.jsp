<%--
  Created by IntelliJ IDEA.
  User: jnc350
  Date: 10/19/20
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        h1{
            margin-top: 50px;
            text-align: center;
        }
        body{margin:0px;padding:0px;  font-size: 150%;}
        #result{
            width: 80%;
            margin: auto;
        }
        .column1{
            float:left;
            width:33.33333%;
            min-height:800px;
        }
        #my_form{
            margin-top: 50px;
            text-align: center;
        }
        div{
            text-align: center;
        }
        .column2{
            border-style: solid;
            width:80%;
            min-height:600px;
            margin: auto;
        }
        .column3{
            float:left;
            width:33.33333%;
            background-color:#218c74;
            min-height:800px;
        }
    </style>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script>
        $(document).ready(function (){
            $("#btn").click(function(event){
                event.preventDefault();
                $.ajax({
                    url:"returnS_JSON.do",
                    data: {s:$("#txt").val()},
                    type:"POST",
                    success:function (resp){
                        $("#s").html(resp).append("<br/>")
                    }
                });
            })
        })
        $(document).ready(function (){
            $("#btn").click(function(event){
                event.preventDefault();
                $("#cs").empty();
                $.ajax({
                    url:"returnCS_JSON.do",
                    data: {s:$("#txt").val()},
                    type:"POST",
                    success:function (resp){
                        $.each(resp,function(i,n){
                            $("#cs").append(n).append("<br/>")
                        })
                    }
                });
            })
        })
        $(document).ready(function (){
            $("#btn").click(function(event){
                event.preventDefault();
                $("#as").empty();
                $.ajax({
                    url:"returnAS_JSON.do",
                    data: {s:$("#txt").val()},
                    type:"POST",
                    success:function (resp){

                        $.each(resp,function(i,n){
                            if(i===0){
                                $("#as").html(n).append("<br/>")
                            }
                            else{
                                $("#as").append(n).append("<br/>")
                            }
                        })
                    }
                });
            })
        })
    </script>
</head>
<body>
    <h1>SuperNova Search Engine</h1>

    <form id="my_form" method="post">
        <label>Input Text: </label>
        <input type="text" name="inputText" id="txt">
        <input type="submit" value="Search" id = "btn">
    </form>

    <br/>
<%--    <button is="btn">Click Me</button>--%>
    <div id="result">
        <div class="column1">Input text
            <div class = "column2" id="s"></div>
        </div>
        <div class="column1">Text after CircularShift
            <div class = "column2" id = "cs"></div>
        </div>
        <div class="column1">Text after AlphabeticShift
            <div class = "column2" id = "as"></div>
        </div>
    </div>

</body>
</html>
