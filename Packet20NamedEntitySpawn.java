import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet20NamedEntitySpawn extends abs {
   public int a;
   public String b;
   public long c;
   public int d;
   public long e;
   public byte f;
   public byte g;
   public int h;

   public Packet20NamedEntitySpawn() {
   }

   public Packet20NamedEntitySpawn(EntityPlayer par1EntityPlayer) {
      this.a = par1EntityPlayer.f;
      this.b = par1EntityPlayer.aA;
      this.c = MathHelper.d(par1EntityPlayer.o * 32.0);
      this.d = MathHelper.c(par1EntityPlayer.p * 32.0);
      this.e = MathHelper.d(par1EntityPlayer.q * 32.0);
      this.f = (byte)(par1EntityPlayer.u * 256.0F / 360.0F);
      this.g = (byte)(par1EntityPlayer.v * 256.0F / 360.0F);
      ItemStack itemstack = par1EntityPlayer.ap.b();
      this.h = itemstack != null ? itemstack.c : 0;
   }

   public void a(DataInputStream par1DataInputStream) throws IOException {
      this.a = par1DataInputStream.readInt();
      this.b = a(par1DataInputStream, 16);

      try {
         this.c = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.c = par1DataInputStream.readInt();
      }

      this.d = par1DataInputStream.readInt();

      try {
         this.e = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.e = par1DataInputStream.readInt();
      }

      this.f = par1DataInputStream.readByte();
      this.g = par1DataInputStream.readByte();
      this.h = par1DataInputStream.readShort();
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeInt(this.a);
      a(this.b, par1DataOutputStream);
      par1DataOutputStream.writeLong(this.c);
      par1DataOutputStream.writeInt(this.d);
      par1DataOutputStream.writeLong(this.e);
      par1DataOutputStream.writeByte(this.f);
      par1DataOutputStream.writeByte(this.g);
      par1DataOutputStream.writeShort(this.h);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 28;
   }
}
