public class VillageDoorInfo {
   public final long a;
   public final int b;
   public final long c;
   public final int d;
   public final int e;
   public int f;
   public boolean g = false;
   private int h = 0;

   public VillageDoorInfo(long par1, int par2, long par3, int par4, int par5, int par6) {
      this.a = par1;
      this.b = par2;
      this.c = par3;
      this.d = par4;
      this.e = par5;
      this.f = par6;
   }

   public int getDistanceSquared(long par1, int par2, long par3) {
      int i = (int)(par1 - this.a);
      int j = par2 - this.b;
      int k = (int)(par3 - this.c);
      return i * i + j * j + k * k;
   }

   public int getInsideDistanceSquare(long par1, int par2, long par3) {
      int i = (int)(par1 - this.a - this.d);
      int j = par2 - this.b;
      int k = (int)(par3 - this.c - this.e);
      return i * i + j * j + k * k;
   }

   public long getInsidePosX() {
      return this.a + this.d;
   }

   public int b() {
      return this.b;
   }

   public long getInsidePosZ() {
      return this.c + this.e;
   }

   public boolean isInside(long par1, long par2) {
      int i = (int)(par1 - this.a);
      int j = (int)(par2 - this.c);
      return i * this.d + j * this.e >= 0;
   }

   public void d() {
      this.h = 0;
   }

   public void e() {
      this.h++;
   }

   public int f() {
      return this.h;
   }
}
