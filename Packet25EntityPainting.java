import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet25EntityPainting extends abs {
   public int a;
   public long b;
   public int c;
   public long d;
   public int e;
   public String f;

   public Packet25EntityPainting() {
   }

   public Packet25EntityPainting(EntityPainting par1EntityPainting) {
      this.a = par1EntityPainting.f;
      this.b = par1EntityPainting.b;
      this.c = par1EntityPainting.c;
      this.d = par1EntityPainting.d;
      this.e = par1EntityPainting.a;
      this.f = par1EntityPainting.e.A;
   }

   public void a(DataInputStream par1DataInputStream) throws IOException {
      this.a = par1DataInputStream.readInt();
      this.f = a(par1DataInputStream, go.z);

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

      this.e = par1DataInputStream.readInt();
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeInt(this.a);
      a(this.f, par1DataOutputStream);
      par1DataOutputStream.writeLong(this.b);
      par1DataOutputStream.writeInt(this.c);
      par1DataOutputStream.writeLong(this.d);
      par1DataOutputStream.writeInt(this.e);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 24;
   }
}
