import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet21PickupSpawn extends abs {
   public int a;
   public long b;
   public int c;
   public long d;
   public byte e;
   public byte f;
   public byte g;
   public int h;
   public int i;
   public int j;

   public Packet21PickupSpawn() {
   }

   public Packet21PickupSpawn(EntityItem par1EntityItem) {
      this.a = par1EntityItem.f;
      this.h = par1EntityItem.a.c;
      this.i = par1EntityItem.a.a;
      this.j = par1EntityItem.a.i();
      this.b = MathHelper.d(par1EntityItem.o * 32.0);
      this.c = MathHelper.c(par1EntityItem.p * 32.0);
      this.d = MathHelper.d(par1EntityItem.q * 32.0);
      this.e = (byte)(par1EntityItem.r * 128.0);
      this.f = (byte)(par1EntityItem.s * 128.0);
      this.g = (byte)(par1EntityItem.t * 128.0);
   }

   public void a(DataInputStream par1DataInputStream) throws IOException {
      this.a = par1DataInputStream.readInt();
      this.h = par1DataInputStream.readShort();
      this.i = par1DataInputStream.readByte();
      this.j = par1DataInputStream.readShort();

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

      this.e = par1DataInputStream.readByte();
      this.f = par1DataInputStream.readByte();
      this.g = par1DataInputStream.readByte();
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeInt(this.a);
      par1DataOutputStream.writeShort(this.h);
      par1DataOutputStream.writeByte(this.i);
      par1DataOutputStream.writeShort(this.j);
      par1DataOutputStream.writeLong(this.b);
      par1DataOutputStream.writeInt(this.c);
      par1DataOutputStream.writeLong(this.d);
      par1DataOutputStream.writeByte(this.e);
      par1DataOutputStream.writeByte(this.f);
      par1DataOutputStream.writeByte(this.g);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 24;
   }
}
