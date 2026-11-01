import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Packet60Explosion extends abs {
   public double a;
   public double b;
   public double c;
   public float d;
   public Set e;

   public void a(DataInputStream par1DataInputStream) throws IOException {
      this.a = par1DataInputStream.readDouble();
      this.b = par1DataInputStream.readDouble();
      this.c = par1DataInputStream.readDouble();
      this.d = par1DataInputStream.readFloat();
      int i = par1DataInputStream.readInt();
      this.e = new HashSet();
      long j = (long)this.a;
      int k = (int)this.b;
      long l = (long)this.c;

      for (int i1 = 0; i1 < i; i1++) {
         long j1 = par1DataInputStream.readByte() + j;
         int k1 = par1DataInputStream.readByte() + k;
         long l1 = par1DataInputStream.readByte() + l;
         this.e.add(new ChunkPosition(j1, k1, l1));
      }
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeDouble(this.a);
      par1DataOutputStream.writeDouble(this.b);
      par1DataOutputStream.writeDouble(this.c);
      par1DataOutputStream.writeFloat(this.d);
      par1DataOutputStream.writeInt(this.e.size());
      long i = (long)this.a;
      int j = (int)this.b;
      long k = (long)this.c;

      for (ChunkPosition chunkposition : this.e) {
         int l = (int)(chunkposition.a - i);
         int i1 = chunkposition.b - j;
         int j1 = (int)(chunkposition.c - k);
         par1DataOutputStream.writeByte(l);
         par1DataOutputStream.writeByte(i1);
         par1DataOutputStream.writeByte(j1);
      }
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 32 + this.e.size() * 3;
   }
}
