public class NextTickListEntry implements Comparable {
   private static long f = 0L;
   public long a;
   public int b;
   public long c;
   public int d;
   public long e;
   private long g = f++;

   public NextTickListEntry(long par1, int par2, long par3, int par4) {
      this.a = par1;
      this.b = par2;
      this.c = par3;
      this.d = par4;
   }

   @Override
   public boolean equals(Object par1Obj) {
      if (!(par1Obj instanceof NextTickListEntry)) {
         return false;
      }

      NextTickListEntry nextticklistentry = (NextTickListEntry)par1Obj;
      return this.a == nextticklistentry.a && this.b == nextticklistentry.b && this.c == nextticklistentry.c && this.d == nextticklistentry.d;
   }

   @Override
   public int hashCode() {
      return (int)(this.a * 1024L * 1024L + this.c * 1024L + this.b) * 256 + this.d;
   }

   public NextTickListEntry a(long par1) {
      this.e = par1;
      return this;
   }

   public int a(NextTickListEntry par1NextTickListEntry) {
      if (this.e < par1NextTickListEntry.e) {
         return -1;
      } else if (this.e > par1NextTickListEntry.e) {
         return 1;
      } else if (this.g < par1NextTickListEntry.g) {
         return -1;
      } else {
         return this.g <= par1NextTickListEntry.g ? 0 : 1;
      }
   }

   @Override
   public int compareTo(Object par1Obj) {
      return this.a((NextTickListEntry)par1Obj);
   }
}
