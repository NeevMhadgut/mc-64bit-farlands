import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet130UpdateSign extends abs {
   public long a;
   public int b;
   public long c;
   public String[] d;

   public Packet130UpdateSign() {
      this.q = true;
   }

   public Packet130UpdateSign(long par1, int par2, long par3, String[] par4ArrayOfStr) {
      this.q = true;
      this.a = par1;
      this.b = par2;
      this.c = par3;
      this.d = par4ArrayOfStr;
   }

   public void a(DataInputStream par1DataInputStream) throws IOException {
      try {
         this.a = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.a = par1DataInputStream.readInt();
      }

      this.b = par1DataInputStream.readShort();

      try {
         this.c = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.c = par1DataInputStream.readInt();
      }

      this.d = new String[4];

      for (int i = 0; i < 4; i++) {
         this.d[i] = a(par1DataInputStream, 15);
      }
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeLong(this.a);
      par1DataOutputStream.writeShort(this.b);
      par1DataOutputStream.writeLong(this.c);

      for (int i = 0; i < 4; i++) {
         a(this.d[i], par1DataOutputStream);
      }
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      int i = 0;

      for (int j = 0; j < 4; j++) {
         i += this.d[j].length();
      }

      return i;
   }
}
