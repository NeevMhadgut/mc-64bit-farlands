import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet71Weather extends abs {
   public int a;
   public long b;
   public int c;
   public long d;
   public int e;

   public Packet71Weather() {
   }

   public Packet71Weather(Entity par1Entity) {
      this.a = par1Entity.f;
      this.b = MathHelper.d(par1Entity.o * 32.0);
      this.c = MathHelper.c(par1Entity.p * 32.0);
      this.d = MathHelper.d(par1Entity.q * 32.0);
      if (par1Entity instanceof d) {
         this.e = 1;
      }
   }

   public void a(DataInputStream par1DataInputStream) throws IOException {
      this.a = par1DataInputStream.readInt();
      this.e = par1DataInputStream.readByte();

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
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeInt(this.a);
      par1DataOutputStream.writeByte(this.e);
      par1DataOutputStream.writeLong(this.b);
      par1DataOutputStream.writeInt(this.c);
      par1DataOutputStream.writeLong(this.d);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 17;
   }
}
