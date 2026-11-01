import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet23VehicleSpawn extends abs {
   public int a;
   public long b;
   public int c;
   public long d;
   public int e;
   public int f;
   public int g;
   public int h;
   public int i;

   public void a(DataInputStream par1DataInputStream) throws IOException {
      this.a = par1DataInputStream.readInt();
      this.h = par1DataInputStream.readByte();

      try {
         this.b = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.b = par1DataInputStream.readInt();
      }

      this.c = par1DataInputStream.readInt();

      try {
         this.d = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.d = par1DataInputStream.readInt();
      }

      this.i = par1DataInputStream.readInt();
      if (this.i > 0) {
         this.e = par1DataInputStream.readShort();
         this.f = par1DataInputStream.readShort();
         this.g = par1DataInputStream.readShort();
      }
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeInt(this.a);
      par1DataOutputStream.writeByte(this.h);
      par1DataOutputStream.writeLong(this.b);
      par1DataOutputStream.writeInt(this.c);
      par1DataOutputStream.writeLong(this.d);
      par1DataOutputStream.writeInt(this.i);
      if (this.i > 0) {
         par1DataOutputStream.writeShort(this.e);
         par1DataOutputStream.writeShort(this.f);
         par1DataOutputStream.writeShort(this.g);
      }
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 21 + this.i <= 0 ? 0 : 6;
   }
}
