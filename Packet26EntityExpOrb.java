import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet26EntityExpOrb extends abs {
   public int a;
   public long b;
   public int c;
   public long d;
   public int e;

   public Packet26EntityExpOrb() {
   }

   public Packet26EntityExpOrb(EntityXPOrb par1EntityXPOrb) {
      this.a = par1EntityXPOrb.f;
      this.b = MathHelper.d(par1EntityXPOrb.o * 32.0);
      this.c = MathHelper.c(par1EntityXPOrb.p * 32.0);
      this.d = MathHelper.d(par1EntityXPOrb.q * 32.0);
      this.e = par1EntityXPOrb.h();
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

      this.e = par1DataInputStream.readShort();
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeInt(this.a);
      par1DataOutputStream.writeLong(this.b);
      par1DataOutputStream.writeInt(this.c);
      par1DataOutputStream.writeLong(this.d);
      par1DataOutputStream.writeShort(this.e);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 18;
   }
}
