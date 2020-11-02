<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <form action="login" method="post">

${msg}
  <div class="container">
    

  
    <label ><b>Email</b></label>
    <input type="text" placeholder="Enter Username" name="email" required>

    <label ><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <button type="submit">Login</button>

  </div>

</form>

  