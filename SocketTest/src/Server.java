import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 对于Java Socket编程而言，有两个概念，一个是ServerSocket，一个是Socket。服务端和客户端之间通过Socket建立连接，之后它们就可以进行通信了。
	首先ServerSocket将在服务端监听某个端口，当发现客户端有Socket来试图连接它时，它会accept该Socket的连接请求，同时在服务端建立一个对应的
	Socket与之进行通信。这样就有两个Socket了，客户端和服务端各一个。
   	对于Socket之间的通信其实很简单，服务端往Socket的输出流里面写东西，客户端就可以通过Socket的输入流读取对应的内容。Socket与Socket之间是
   	双向连通的，所以客户端也可以往对应的Socket输出流里面写东西，然后服务端对应的Socket的输入流就可以读出对应的内容。
 *
 */
public class Server {
	public static void main(String[] args)throws Exception {
		int port=8899;
		ServerSocket server=new ServerSocket(port);
		Socket socket=server.accept();//server尝试接收其他socket的连接请求，server的accept方法是阻塞式的
		Reader reader=new InputStreamReader(socket.getInputStream());
		//reader.read()方法
		char chars[]=new char[64];
		int len;
		StringBuilder sb=new StringBuilder();
		while((len=reader.read(chars))!=-1){
			sb.append(new String(chars,0,len));
		}
		System.out.println("from client:"+sb);
		reader.close();
		socket.close();
		server.close();
	}
}
