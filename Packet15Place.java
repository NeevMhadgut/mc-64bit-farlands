import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet15Place extends abs {
   public long a;
   public int b;
   public long c;
   public int d;
   public ItemStack e;

   public Packet15Place() {
   }

   public Packet15Place(long par1, int par2, long par3, int par4, ItemStack par5ItemStack) {
      this.a = par1;
      this.b = par2;
      this.c = par3;
      this.d = par4;
      this.e = par5ItemStack;
   }

   public void a(DataInputStream par1DataInputStream) throws IOException {
      try {
         this.a = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.a = par1DataInputStream.readInt();
      }

      this.b = par1DataInputStream.read();

      try {
         this.c = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.c = par1DataInputStream.readInt();
      }

      this.d = par1DataInputStream.read();
      this.e = this.b(par1DataInputStream);
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeLong(this.a);
      par1DataOutputStream.write(this.b);
      par1DataOutputStream.writeLong(this.c);
      par1DataOutputStream.write(this.d);
      this.a(this.e, par1DataOutputStream);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 15;
   }
}
