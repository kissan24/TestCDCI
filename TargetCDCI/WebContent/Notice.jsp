
<%-- 
    Document   : index
    Created on : Nov 18, 2015, 12:23:40 AM
    Author     : kishan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TaretCDCI Fispond</title>
         <link rel="shortcut icon" href="icon1.jpg">

        <link rel="stylesheet" href="bootstrap/css/bootstrap-responsive.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
        <link rel="stylesheet"  href="style.css"/>
        <script type="text/javascript" src="bootstrap/js/jQuery1.8.3.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
        <script type="text/javascript"  src="bootstrap/js/jquery.validate.js" ></script> 
        <script type="text/javascript" src="bootstrap/js/additional-methods.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){ 
                $('#shw').on('click',function(){
                    $('#shw').remove();
                    $('#divshw').show();
                    $('#back').show();
                    $.getJSON('FishComments','act=cmt&cmt='+$('#nm1').val(),function(data){
                        $('div').find('#remove1').remove();
                        for(var i=0;i<data.length;i++)
                        {
                             
                            var cmts='<p class="display-text">"'+data[i].comment+'"</p>'
                                +'<hr>'
                            $('div').find('#remove2').show().append(cmts);
                        }                   
                        
                    });
                    
                });
                

            });
        </script>
        <style>
            .input-xlarge{
                height:34px !important;
            }
        </style>

    </head>

    <body style="background-color: #F5F5F5 !important;">
        <div class="header highlight">
            <a href="Notice.jsp" style="color:white">Taret CDCI Fishpond</a>
            <%
                String name1 = (String) session.getAttribute("name1");
                String msg1 = (String) request.getAttribute("msgs");
                if (name1 != null) {
                    out.print("<input id='nm1'  name='username' style='display:none'type='text' value='" + name1 + "' >");

                    out.print("<a style='margin-right: 73px; color:white;' class='pull-right'><i class='icon-user icon-white'></i>welcome," + name1 + "</a>");
                    //out.print("<a style='margin-right: 73px; color:white;' class='pull-right'href='#myModal1' data-toggle='modal' rel='tooltip' data-placement='bottom' >&nbsp;Reset password</a>");
                    out.print("<a style='margin-right: 73px; color:white;' class='pull-right'href='LoginServlet' >Logout</a>");
                } else {
                    out.print("<a style='margin-right: 73px; color:white;' class='pull-right'href='#myModal' data-toggle='modal' rel='tooltip' data-placement='bottom' data-original-title='Feedback'><i class='icon-user icon-white'></i>&nbsp;Login</a>");
                    out.print("<a style='margin-right: 60px; color:white;' class='pull-right'href='#myModalreg' data-toggle='modal' rel='tooltip' data-placement='bottom' data-original-title='Feedback'><i class='icon-user icon-white'></i>&nbsp;Register</a>");
                }


            %>

        </div>
        <div class="wrap">
        
        <%
                            String regsuc = (String) request.getAttribute("regsucc");
                            String regerr = (String) request.getAttribute("regerr");
                         if (regsuc != null) {
                        %>
                        <div>
                            <div class="alert alert-success">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <h4>Thanks you!!</h4>
                                <p> <%out.print(regsuc);%></p>
                            </div>
                        </div> 
                        <% } else if (regerr != null) {%>


                        <div>
                            <div class="alert alert-error">
                                <button type="button" class="close" data-dismiss="alert">×</button>

                                <p> <%out.print(regerr);%></p>
                                </div>
                        </div> 

                           <%} %>                
        
        
        
        
            <%


                if (msg1 != null) {
            %>  
            <div class="alert alert-error" style="height: 15px;margin: 7px auto;width: 69%;">
                <button class="close" data-dismiss="alert" type="button">×</button>

                <% out.print(msg1);%>
            </div>
            <%
                }
            %>
            <%
                if (name1 != null) {
                    out.print(" <a href='#' id='shw' class='btn btn-block btn-primary'>Show me my fishpond comments</a> ");
                    out.print(" <div id='divshw'  style='display:none;text-align:center'class='heading today'>Comments about you</div> ");
                    out.print(" <a href='Notice.jsp'  style='display:none;' id='back'><strong>Go back</strong></a> ");
                }
            %>
            <div id="remove2" class="well span6 offset5" style="margin-top: 50px;display:none;">

            </div>


        <!--</div>-->
        <div id="remove1">
            <div class="heading today"><div class="post"></div>Lets spend few minutes with this application</div>
            <div >
                <h3 style="color:#222222;">Please give your valueble feedback for this application</h3>
                <!--                    </h1><a href="#myModal" role="button" class="btn" data-toggle="modal">Launch demo modal</a>-->

                <div class="span8" style="margin-top:20px;" >
                    <form class="form-horizontal" id="feedback_f" style="margin:0;" method="post" action="feedbackignite">

                        <div class="control-group">
                            <label class="control-label">Name</label>
                            <div class="controls">
                                <input id="textinput" style="height:34px;" name="name" type="text" placeholder="Name" class="input-xlarge required">
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label">Feedback</label>
                            <div class="controls ">                     
                                <textarea id="textarea" cols="100" name="feedback" placeholder="Feedback" class="required"></textarea>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label"></label>
                            <div class="controls">
                                <button type="submit" style="background-color:red" name="button1" value="" class="">submit</button>
                            </div>
                        </div>
                        <%
                            String feedback = (String) request.getAttribute("feed");
                            String error = (String) request.getAttribute("warning");
                            String name = (String) request.getAttribute("name");
                            String msg = (String) request.getAttribute("msg");
                            if (msg != null) {
                        %>
                        <div>
                            <div class="alert alert-block">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <h4>Excuse me!!!</h4>
                                <p> <%out.print(msg);%></p>
                            </div>
                        </div> 
                        <% } else if (feedback != null) {%>


                        <div>
                            <div class="alert alert-success">
                                <button type="button" class="close" data-dismiss="alert">×</button>

                                <p> <%out.print(feedback);%></p>
                                <h5>Thank you</h5>
                                <h4><%out.print(name);%></h4>
                            </div>
                        </div> 

                        <%   } else if (error != null) {%>


                        <div>
                            <div class="alert alert-error">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <p> <%out.print(error);%></p>


                            </div>
                        </div> 

                        <%
                        }
                        %>

                    </form>
                </div>
                <div class="clearfix"></div>


            </div>

            <div class="heading today">Lets play Fish Pond</div>
            <div>
                <%
                    if (name1 != null) {
                %>
                <form class="form-horizontal" method="post" action="fishpond">
                    <fieldset>
                        <legend>Let's play it this with below rule:</legend>
                        <div>
                            <p><b>*&nbsp;Please select a person to whom you want to comment</b></p>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Name</label>
                            <div class="controls">
                                <select id="name" name="sname" class="input-xlarge">
                                    <option ><font color="red">Select a person</font></option>
                                    <option>Kishan</option>
                                    <option>Kannan</option>
                                    <option>Rajesh</option>
                                    <option>Dhivya</option>
                                    <option>Venu</option>
                                    <option>Tanshi</option>
                                    <option>Annapoorani</option>
                                    <option>Mohan</option>
                                    <option>Siva</option>
                                    <option>Jothi</option>
                                    <option>Rajagopalan</option>
                                    <option>Gayatri</option>
                                    <option>Viji</option>
                                    <option>Sai</option>
                                    <option>Abbu</option>
                                    <option>Tanuja</option>
                                    <option>Bhavya</option>
                                    

                                </select>
                            </div>
                        </div>

                        <!-- Textarea -->
                        <div class="control-group">
                            <label class="control-label">About Him/Her</label>
                            <div class="controls">                     
                                <textarea id="comments" name="comments"></textarea>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label"></label>
                            <div class="controls">
                                <button type="submit" id="singlebutton" name="singlebutton" class="btn btn-success">Submit</button>
                            </div>
                        </div>

                    </fieldset>
                </form>
                <%} else {
                %>
                <h3>Please login to play fishpond......</h3>
                <%}%>
                
            </div>

        </div>
                </div>
        <%@include file="signinModal.jsp" %>
        <%@include file="resetpass.jsp" %>
        <%@include file="register.jsp" %>
    </body>

</html>