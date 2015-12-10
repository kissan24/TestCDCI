<%-- 
    Document   : signinModal
    Created on : Apr 6, 2013, 4:02:22 PM
    Author     : ignite165
--%>


    
         <div id="myModal1" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
                <div class="modal-header">
                    <a class="pull-right" data-dismiss="modal" aria-hidden="true"><i class="icon-remove" style="cursor: pointer"></i></a>
                    <h3 font-color="black"><i class="icon-th-large" style="margin-right: 10px;margin-top: 8px"></i>Sign in</h3>
                </div>
                <div class="modal-body">
                    <div class="span4">
                        <form class="form-horizontal" id="signIn" method="post" action="ResetPassword">
                            <fieldset>
                                <div class="control-group" style="margin-left:-55px">
                                    <!-- Text input-->
                                    <label class="control-label" for="uname">user name</label>
                                    <div class="controls">
                                        <input style="height: 33px"name="uname" id="uname" placeholder="name000" class="input-xlarge required " type="text">
                                        <p class="help-block"></p>
                                    </div>
                                    <label class="control-label" for="opassword">old password</label>
                                    <div class="controls">
                                        <input style="height: 33px"name="opassword" id="opassword" placeholder="old password" class="input-xlarge required " type="text">
                                        <p class="help-block"></p>
                                    </div>
                                    <!-- Text input-->
                                    <label class="control-label" for="npassword">New password</label>
                                    <div class="controls">
                                        <input style="height: 33px" id="npassword" name="npassword" placeholder="new password" class="input-xlarge requied" type="password">
                                       
<!--                                        <a href="forgotpassword.jsp" data-original-title="Forgot password">Forgot password</a>-->
<!--                                        &nbsp;&nbsp;&nbsp;<a href="Resetpassword.jsp" data-original-title="Reset password">Reset password</a>-->
                                        <br><br><button type="submit"  class="btn btn-primary"> Reset</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!--                                       <button id="Signupbtn"class="btn btn-primary" data-dismiss="modal">Sign up</button>-->
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
   