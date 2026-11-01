public class ChunkPosition {
   public final long a;
   public final int b;
   public final long c;

   public ChunkPosition(long par1, int par2, long par3) {
      this.a = par1;
      this.b = par2;
      this.c = par3;
   }

   public ChunkPosition(bo par1Vec3D) {
      this(MathHelper.d(par1Vec3D.a), MathHelper.c(par1Vec3D.b), MathHelper.d(par1Vec3D.c));
   }

   @Override
   public boolean equals(Object par1Obj) {
      if (!(par1Obj instanceof ChunkPosition)) {
         return false;
      }

      ChunkPosition chunkposition = (ChunkPosition)par1Obj;
      return chunkposition.a == this.a && chunkposition.b == this.b && chunkposition.c == this.c;
   }

   @Override
   public int hashCode() {
      return (int)(this.a * 8976890L + this.b * 981131 + this.c);
   }
}
