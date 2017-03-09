import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ����Java Socket��̶��ԣ����������һ����ServerSocket��һ����Socket������˺Ϳͻ���֮��ͨ��Socket�������ӣ�֮�����ǾͿ��Խ���ͨ���ˡ�
	����ServerSocket���ڷ���˼���ĳ���˿ڣ������ֿͻ�����Socket����ͼ������ʱ������accept��Socket����������ͬʱ�ڷ���˽���һ����Ӧ��
	Socket��֮����ͨ�š�������������Socket�ˣ��ͻ��˺ͷ���˸�һ����
   	����Socket֮���ͨ����ʵ�ܼ򵥣��������Socket�����������д�������ͻ��˾Ϳ���ͨ��Socket����������ȡ��Ӧ�����ݡ�Socket��Socket֮����
   	˫����ͨ�ģ����Կͻ���Ҳ��������Ӧ��Socket���������д������Ȼ�����˶�Ӧ��Socket���������Ϳ��Զ�����Ӧ�����ݡ�
 *
 */
public class Server {
	public static void main(String[] args)throws Exception {
		int port=8899;
		ServerSocket server=new ServerSocket(port);
		Socket socket=server.accept();//server���Խ�������socket����������server��accept����������ʽ��
		Reader reader=new InputStreamReader(socket.getInputStream());
		//reader.read()����
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
