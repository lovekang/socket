import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * �ͻ���
 * @author lsk
 *
 */
public class Client {
	
	public static void main(String[] args)throws Exception {
		String host="127.0.0.1";
		int port=8899;
		Socket client=new Socket(host,port);
		Writer writer=new OutputStreamWriter(client.getOutputStream());
		writer.write("hello server...");
		writer.flush();//�ǵ�Ҫflush
		writer.close();
		client.close();
	}
}
