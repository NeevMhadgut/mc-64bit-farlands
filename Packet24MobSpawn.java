import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class Packet24MobSpawn extends abs {
   public int a;
   public int b;
   public long c;
   public int d;
   public long e;
   public byte f;
   public byte g;
   public byte h;
   private DataWatcher i;
   private List j;

   public Packet24MobSpawn() {
   }

   public Packet24MobSpawn(EntityLiving par1EntityLiving) {
      this.a = par1EntityLiving.f;
      this.b = (byte)EntityList.a(par1EntityLiving);
      this.c = MathHelper.d(par1EntityLiving.o * 32.0);
      this.d = MathHelper.c(par1EntityLiving.p * 32.0);
      this.e = MathHelper.d(par1EntityLiving.q * 32.0);
      this.f = (byte)(par1EntityLiving.u * 256.0F / 360.0F);
      this.g = (byte)(par1EntityLiving.v * 256.0F / 360.0F);
      this.h = (byte)(par1EntityLiving.WorldGenSwamp * 256.0F / 360.0F);
      this.i = par1EntityLiving.y();
   }

   public void a(DataInputStream par1DataInputStream) throws IOException {
      this.a = par1DataInputStream.readInt();
      this.b = par1DataInputStream.readByte() & 255;

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
      this.h = par1DataInputStream.readByte();
      this.j = DataWatcher.a(par1DataInputStream);
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeInt(this.a);
      par1DataOutputStream.writeByte(this.b & 0xFF);
      par1DataOutputStream.writeLong(this.c);
      par1DataOutputStream.writeInt(this.d);
      par1DataOutputStream.writeLong(this.e);
      par1DataOutputStream.writeByte(this.f);
      par1DataOutputStream.writeByte(this.g);
      par1DataOutputStream.writeByte(this.h);
      this.i.a(par1DataOutputStream);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 20;
   }

   public List b() {
      return this.j;
   }
}
