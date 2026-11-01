import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet34EntityTeleport extends abs {
   public int a;
   public long b;
   public int c;
   public long d;
   public byte e;
   public byte f;

   public Packet34EntityTeleport() {
   }

   public Packet34EntityTeleport(Entity par1Entity) {
      this.a = par1Entity.f;
      this.b = MathHelper.d(par1Entity.o * 32.0);
      this.c = MathHelper.c(par1Entity.p * 32.0);
      this.d = MathHelper.d(par1Entity.q * 32.0);
      this.e = (byte)(par1Entity.u * 256.0F / 360.0F);
      this.f = (byte)(par1Entity.v * 256.0F / 360.0F);
   }

   public void a(DataInputStream par1DataInputStream) throws IOException {
      this.a = par1DataInputStream.readInt();

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

      this.e = (byte)par1DataInputStream.read();
      this.f = (byte)par1DataInputStream.read();
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeInt(this.a);
      par1DataOutputStream.writeLong(this.b);
      par1DataOutputStream.writeInt(this.c);
      par1DataOutputStream.writeLong(this.d);
      par1DataOutputStream.write(this.e);
      par1DataOutputStream.write(this.f);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 34;
   }
}
