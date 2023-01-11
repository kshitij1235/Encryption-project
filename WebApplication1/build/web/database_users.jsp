<%@ page import="java.sql.*" %>

<% Class.forName("org.apache.derby.jdbc.ClientDriver"); %>

<HTML>
	<head>
    	<title>users</title>
    	<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>

    <BODY>
<div style="background-color: rgb(67 56 202);" >
  <div class="max-w-7xl mx-auto px-4 sm:px-6 bg-cyan-700">
	<div class="flex justify-between items-center border-b-2 border-gray-100 py-6 md:justify-start md:space-x-10">
  	<div class="flex justify-start lg:w-0 lg:flex-1">
    	<a href="#">
      	<h1  class="text-indigo-600 hover:text-indigo-500"> users</h1>

    	</a>
  	</div>

  	<div class="hidden md:flex items-center justify-end md:flex-1 lg:w-0">
      	<button type="submit" name='login'>
        	<a href="index.html" class="ml-8 whitespace-nowrap inline-flex items-center justify-center px-4 py-2 border border-transparent rounded-md shadow-sm text-base font-medium text-white bg-indigo-600 hover:bg-indigo-700">x</a>  
      	</button>

  	</div>
	</div>
  </div>
</DIV>
    <HR>
    
        <% 
            Connection connection = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/sample", "app", "app");

            Statement statement = connection.createStatement() ;
            ResultSet resultset = statement.executeQuery("select * from users") ; 
        %>


        
        
<table class="table">
  <thead>
    <tr>
      <th>username</th>
      <th>name</th>
      <th>password</th>
    </tr>
  </thead>
  <tbody>
      <% while(resultset.next()){ %>
            <TR>
                <TD> <%= resultset.getString(1) %></td>
                <TD> <%= resultset.getString(2) %></TD>
                <TD> <%= resultset.getString(3) %></TD>

            </TR>
      <% } %>
  </tbody>
</table>
        
    </BODY>
</HTML>