import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet61DoorChange extends abs {
   public int a;
   public int b;
   public long c;
   public int d;
   public long e;

   public void a(DataInputStream par1DataInputStream) throws IOException {
      this.a = par1DataInputStream.readInt();

      try {
         this.c = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.c = par1DataInputStream.readInt();
      }

      this.d = par1DataInputStream.readByte() & 255;

      try {
         this.e = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.e = par1DataInputStream.readInt();
      }

      this.b = par1DataInputStream.readInt();
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeInt(this.a);
      par1DataOutputStream.writeLong(this.c);
      par1DataOutputStream.writeByte(this.d & 0xFF);
      par1DataOutputStream.writeLong(this.e);
      par1DataOutputStream.writeInt(this.b);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 20;
   }
}
