public class PathPoint {
   public final long a;
   public final int b;
   public final long c;
   private final int j;
   int d = -1;
   float e;
   float f;
   float g;
   e h;
   public boolean i = false;

   public PathPoint (long par1, int par2, long par3) {
      this.a = par1;
      this.b = par2;
      this.c = par3;
      this.j = makeHash(par1, par2, par3);
   }

   public static int makeHash(long par0, int par1, long par2) {
      return par1 & 0xFF | (int)(par0 & 32767L) << 8 | (int)(par2 & 32767L) << 24 | (par0 >= 0L ? 0 : Integer.MIN_VALUE) | (par2 >= 0L ? 0 : 32768);
   }

   public float a(e par1PathPoint) {
      float f = (float)(par1PathPoint.a - this.a);
      float f1 = par1PathPoint.b - this.b;
      float f2 = (float)(par1PathPoint.c - this.c);
      return MathHelper.c(f * f + f1 * f1 + f2 * f2);
   }

   @Override
   public boolean equals(Object par1Obj) {
      if (!(par1Obj instanceof e)) {
         return false;
      }

      e pathpoint = (e)par1Obj;
      return this.j == pathpoint.j && this.a == pathpoint.a && this.b == pathpoint.b && this.c == pathpoint.c;
   }

   @Override
   public int hashCode() {
      return this.j;
   }

   public boolean a() {
      return this.d >= 0;
   }

   @Override
   public String toString() {
      return this.a + ", " + this.b + ", " + this.c;
   }
}
