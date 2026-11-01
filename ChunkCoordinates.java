public class ChunkCoordinates implements Comparable {
   public long a;
   public int b;
   public long c;

   public ChunkCoordinates() {
   }

   public ChunkCoordinates(long par1, int par2, long par3) {
      this.a = par1;
      this.b = par2;
      this.c = par3;
   }

   public ChunkCoordinates(ChunkCoordinates par1ChunkCoordinates) {
      this.a = par1ChunkCoordinates.a;
      this.b = par1ChunkCoordinates.b;
      this.c = par1ChunkCoordinates.c;
   }

   @Override
   public boolean equals(Object par1Obj) {
      if (!(par1Obj instanceof ChunkCoordinates)) {
         return false;
      }

      ChunkCoordinates chunkcoordinates = (ChunkCoordinates)par1Obj;
      return this.a == chunkcoordinates.a && this.b == chunkcoordinates.b && this.c == chunkcoordinates.c;
   }

   @Override
   public int hashCode() {
      return (int)(this.a + this.c << 8 + this.b << 16);
   }

   public int a(ChunkCoordinates par1ChunkCoordinates) {
      if (this.b == par1ChunkCoordinates.b) {
         return this.c == par1ChunkCoordinates.c ? (int)(this.a - par1ChunkCoordinates.a) : (int)(this.c - par1ChunkCoordinates.c);
      } else {
         return this.b - par1ChunkCoordinates.b;
      }
   }

   public void set(long par1, int par2, long par3) {
      this.a = par1;
      this.b = par2;
      this.c = par3;
   }

   public double getEuclideanDistanceTo(long par1, int par2, long par3) {
      long i = this.a - par1;
      int j = this.b - par2;
      long k = this.c - par3;
      return Math.sqrt(i * i + j * j + k * k);
   }

   public double getDistanceSquared(long par1, int par2, long par3) {
      long i = this.a - par1;
      int j = this.b - par2;
      long k = this.c - par3;
      return i * i + j * j + k * k;
   }

   @Override
   public int compareTo(Object par1Obj) {
      return this.a((ChunkCoordinates)par1Obj);
   }
}
