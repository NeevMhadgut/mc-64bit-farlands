import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet6SpawnPosition extends abs {
   public long a;
   public int b;
   public long c;

   public void a(DataInputStream par1DataInputStream) throws IOException {
      try {
         this.a = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.a = par1DataInputStream.readInt();
      }

      this.b = par1DataInputStream.readInt();

      try {
         this.c = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.c = par1DataInputStream.readInt();
      }
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeLong(this.a);
      par1DataOutputStream.writeInt(this.b);
      par1DataOutputStream.writeLong(this.c);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 12;
   }
}
