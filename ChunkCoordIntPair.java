public class ChunkCoordIntPair {
   public final long a;
   public final long b;

   public ChunkCoordIntPair(long par1, long par2) {
      this.a = par1;
      this.b = par2;
   }

   public static long chunkXZ2Int(long par0, long par1) {
      long l = par0;
      long l1 = par1;
      return l & 4294967295L | (l1 & 4294967295L) << 32;
   }

   @Override
   public int hashCode() {
      long l = chunkXZ2Int(this.a, this.b);
      long i = l;
      int j = (int)(l >> 32);
      return (int)(i ^ j);
   }

   @Override
   public boolean equals(Object par1Obj) {
      ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)par1Obj;
      return chunkcoordintpair.a == this.a && chunkcoordintpair.b == this.b;
   }

   public long getCenterXPos() {
      return (this.a << 4) + 8L;
   }

   public long getCenterZPos() {
      return (this.b << 4) + 8L;
   }

   public ChunkPosition a(int par1) {
      return new ChunkPosition(this.getCenterXPos(), par1, this.getCenterZPos());
   }

   @Override
   public String toString() {
      return "[" + this.a + ", " + this.b + "]";
   }
}
