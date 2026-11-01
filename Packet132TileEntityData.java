import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet132TileEntityData extends abs {
   public long a;
   public int b;
   public long c;
   public int d;
   public int e;
   public int f;
   public int g;

   public Packet132TileEntityData() {
      this.q = true;
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

      this.d = par1DataInputStream.readByte();
      this.e = par1DataInputStream.readInt();
      this.f = par1DataInputStream.readInt();
      this.g = par1DataInputStream.readInt();
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeLong(this.a);
      par1DataOutputStream.writeShort(this.b);
      par1DataOutputStream.writeLong(this.c);
      par1DataOutputStream.writeByte((byte)this.d);
      par1DataOutputStream.writeInt(this.e);
      par1DataOutputStream.writeInt(this.f);
      par1DataOutputStream.writeInt(this.g);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 25;
   }
}
