import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet52MultiBlockChange extends abs {
   public long a;
   public long b;
   public byte[] c;
   public int d;
   private static byte[] e = new byte[0];

   public Packet52MultiBlockChange() {
      this.q = true;
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

      this.d = par1DataInputStream.readShort() & '\uffff';
      int i = par1DataInputStream.readInt();
      if (i > 0) {
         this.c = new byte[i];
         par1DataInputStream.readFully(this.c);
      }
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeLong(this.a);
      par1DataOutputStream.writeLong(this.b);
      par1DataOutputStream.writeShort((short)this.d);
      if (this.c != null) {
         par1DataOutputStream.writeInt(this.c.length);
         par1DataOutputStream.write(this.c);
      } else {
         par1DataOutputStream.writeInt(0);
      }
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 10 + this.d * 4;
   }
}
