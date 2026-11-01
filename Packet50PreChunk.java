import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet50PreChunk extends abs {
   public long a;
   public long b;
   public boolean c;

   public Packet50PreChunk() {
      this.q = false;
   }

   public void a(DataInputStream par1DataInputStream) throws IOException {
      try {
         this.a = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.a = par1DataInputStream.readInt();
      }

      try {
         this.b = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.b = par1DataInputStream.readInt();
      }

      this.c = par1DataInputStream.read() != 0;
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeLong(this.a);
      par1DataOutputStream.writeLong(this.b);
      par1DataOutputStream.write(this.c ? 1 : 0);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 9;
   }
}
