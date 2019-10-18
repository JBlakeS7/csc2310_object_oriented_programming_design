package network;

import java.net.*;

public class GameServer
{
   private Socket[] clients;
   private util.GameAccept game;
   
   private GameReadSocketServerVisitor game_read;
   private GameWriteSocketServerVisitor game_write;

   public GameServer(util.GameAccept ga, int port_num, int num_clients)
   {
	   game = ga;
      clients = new Socket[num_clients];

      //watch out, this is threaded
	  //blocks for all clients to connect
      startServer(port_num, clients);
	  
	  //DO THIS
       //set up the server socket classes
        game_read = new GameReadSocketServerVisitor(clients);
        game_write = new GameWriteSocketServerVisitor(clients);

        game_write.visit(game); //perform the initial write
        serverLoop(); //start the server loop
        game_write(game); //perform the final write
   }
   
   //the server simply collects and disseminates the game state periodically
   public void serverLoop()
   {
	   //DO THIS
	   while (!game_read.isGameOver())
       {
           game_write.visit(brass.BrassGame brass_game);
           game_read.visit(brass.BrassGame brass_game);
       }
   }
   
   public void startServer(int port, Socket[] clients)
   {
      int num_clients = clients.length;

      try
      {
         //start the server
         ServerSocket welcomeSocket = new ServerSocket(port);
         int num_connect = 0;

         while(num_connect < num_clients)
         {
            Socket connection_socket = welcomeSocket.accept();
            clients[num_connect] = connection_socket;
            num_connect++;
         }  
      }
      catch (java.io.IOException ioe) {}

	  //blocking code
      //wait for all clients before proceeding
      //this is necessary as the above code is threaded
      boolean wait = true;
      while(wait)
      {
			wait = false;
		  
			try
			{
				Thread.sleep(1000);  //1 second
			}
			catch(InterruptedException ie) {}
		
			for (int i = 1; i <= num_clients; i++)
			{
				if (clients[i - 1] == null)
				{
					wait = true;
					break;
				}
			}
		}
   }
}

