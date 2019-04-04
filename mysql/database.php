<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
   <head>
      <title>Search Results</title>
   </head>

   <body style = "font-family: arial, sans-serif" 
      style = "background-color: #F0E68C">
      <?php

         extract( $_POST );
		$connection = "";
		$servername = "localhost";
		$username = "Your_ID";     //here goes your own login ID
		$password = "password";    //here goes your own MySQL password
		$dbname = "Myshowdb";      //here goes the name of your database to be accessed
		$table = "Students";       //here goes the particular table of your database to be accessed

	if ($select == "") { $select = '*'; }

         // build SELECT query (specifies table as well)
         $query = "SELECT " . $select . " FROM $table";
        
         // Connect to MySQL
         if ( !( $connection = mysql_connect( $servername, 
            $username, $password ) ) )
            die( "Could not connect to database" );
   
         print("Now open a database <br>");
		 // open the particular database
         if ( !mysql_select_db( $dbname, $connection ) )
            die( "Could not open the database" );
   
         print("Now query the database<br>");
		 // query the database
         if ( !( $result = mysql_query( $query, $connection ) ) ) {
            print( "Could not execute query! <br />" );
            die( mysql_error() );
         }
		 
		 print("End of demo<br>");
      ?>

      <h3 style = "color: blue"> 
      Search Results</h3>

      <table border = "1" cellpadding = "3" cellspacing = "2"
         style = "background-color: #ADD8E6">

         <?php

            // fetch each record in result set
            for ( $counter = 0; 
               $row = mysql_fetch_row( $result );
               $counter++ ){

               // build table to display results
               print( "<tr>" );

               foreach ( $row as $key => $value ) 
                  print( "<td>$value</td>" );

               print( "</tr>" );
            }

            mysql_close( $dbname );
         ?>

      </table>

      <br />Your search yielded <strong>
      <?php print( "$counter" ) ?> results.<br /><br /></strong>

   </body>
</html>
