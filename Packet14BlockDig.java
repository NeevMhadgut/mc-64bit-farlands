import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet14BlockDig extends abs {
   public long a;
   public int b;
   public long c;
   public int d;
   public int e;

   public Packet14BlockDig() {
   }

   public Packet14BlockDig(int par1, long par2, int par3, long par4, int par5) {
      this.e = par1;
      this.a = par2;
      this.b = par3;
      this.c = par4;
      this.d = par5;
   }

   public void a(DataInputStream par1DataInputStream) throws IOException {
      this.e = par1DataInputStream.read();

      try {
         this.a = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.a = par1DataInputStream.readInt();
      }

      this.b = par1DataInputStream.read();

      try {
         this.c = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.c = par1DataInputStream.readInt();
      }

      this.d = par1DataInputStream.read();
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.write(this.e);
      par1DataOutputStream.writeLong(this.a);
      par1DataOutputStream.write(this.b);
      par1DataOutputStream.writeLong(this.c);
      par1DataOutputStream.write(this.d);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 11;
   }
}
