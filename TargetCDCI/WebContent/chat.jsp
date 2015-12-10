
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
            
            	$('#chatbtn').on('click',function(){
                           	
            		$('#removeforchat').remove();
                    //how all are online it will append here
                    
                 $.getJSON('OnlineMember','act=onlmem&onlmem=LetsChat',function(data){
                   //  $('div').find('#remove1').remove();
                     for(var i=0;i<data.length;i++)
                     {
                          
                         var onl_mem='<p class="display-text">"'+data[i].onlinemem+'"</p>'+' '+'<button type="submit" style="background-color:" name="chatbtn" id="letchatyou" value="" class="">Wanna Chat</button>'
                             +'<hr>'
                         $('div').find('#remove2').show().append(onl_mem);
                     }
                    
                     
             
                 });
                 
             });
            	
         	
         	 $('#letchatyou').on('click',function(){
                 
                  $('div').find('#removeforchat').remove();
                  $('#remove2').remove();
                  
//                   $('#divshw').show();
//                   $('#back').show();
//                   $.getJSON('FishComments','act=cmt&cmt='+$('#nm1').val(),function(data){
//                       $('div').find('#remove1').remove();
//                       for(var i=0;i<data.length;i++)
//                       {
                           
//                           var cmts='<p class="display-text">"'+data[i].comment+'"</p>'
//                               +'<hr>'
//                           $('div').find('#show1').show().append(cmts);
//                       }
                     
                      
              
//                   });
            	
         	});
         	 
//                 $('#chathide').on('click',function(){
//                     $('#shw').remove();
//                     $('#divshw').show();
//                     $('#back').show();
//                     $.getJSON('FishComments','act=cmt&cmt='+$('#nm1').val(),function(data){
//                         $('div').find('#remove1').remove();
//                         for(var i=0;i<data.length;i++)
//                         {
                             
//                             var cmts='<p class="display-text">"'+data[i].comment+'"</p>'
//                                 +'<hr>'
//                             $('div').find('#remove2').show().append(cmts);
//                         }
                       
                        
                
//                     });
                    
//                 });
            	

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
         <div class="control-group" id="removeforchat">
                            <label class="control-label"></label>
                            <div class="controls">
                                <button type="submit" style="background-color:white" name="chatbtn" id="chatbtn" value="LetsChat" class="">Lets Chat</button>
                            </div>
                        </div>
                        
        	<a style="visibility: hidden;" href="" id="chathide"> HiddenClickForChat</a>
        	
          <div id="remove2" class="well span6 offset5" style="margin-top: 50px;display:none;">
          
          

           </div>
           
           
           <div id="show1" class="well span6 offset5" style="margin-top: 50px;display:none;">
          
          

           </div>


  
        </div>
        <%@include file="signinModal.jsp" %>
        <%@include file="resetpass.jsp" %>
        <%@include file="register.jsp" %>
    </body>

</html>