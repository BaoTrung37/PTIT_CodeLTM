package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
public class Client {
    
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109",2207);
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        
        String maSv = "B18DCCN669;911"; 
        out.writeUTF(maSv);
        int a = in.readInt();
        int b = in.readInt();
        int gcd = GCD(a, b);
        int lcm = (a * b) / gcd;
        int sum = a + b;
        int mul = a * b;
        out.writeInt(gcd);
        out.writeInt(lcm);
        out.writeInt(sum);
        out.writeInt(mul);
        
        in.close();
        out.close();
        client.close();

    }
    public static int GCD(int a, int b) {
        return (b == 0) ? a : GCD(b, a % b);
    }
}
