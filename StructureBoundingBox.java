public class StructureBoundingBox {
   public long a;
   public int b;
   public long c;
   public long d;
   public int e;
   public long f;

   public StructureBoundingBox() {
   }

   public static StructureBoundingBox a() {
      return new StructureBoundingBox(2147483647L, Integer.MAX_VALUE, 2147483647L, -2147483648L, Integer.MIN_VALUE, -2147483648L);
   }

   public static StructureBoundingBox getComponentToAddBoundingBox(long par0, int par1, long par2, long par3, int par4, long par5, long par6, int par7, long par8, int par9) {
      switch (par9) {
         case 0:
            return new StructureBoundingBox(par0 + par3, par1 + par4, par2 + par5, par0 + par6 - 1L + par3, par1 + par7 - 1 + par4, par2 + par8 - 1L + par5);
         case 1:
            return new StructureBoundingBox(par0 - par8 + 1L + par5, par1 + par4, par2 + par3, par0 + par5, par1 + par7 - 1 + par4, par2 + par6 - 1L + par3);
         case 2:
            return new StructureBoundingBox(par0 + par3, par1 + par4, par2 - par8 + 1L + par5, par0 + par6 - 1L + par3, par1 + par7 - 1 + par4, par2 + par5);
         case 3:
            return new StructureBoundingBox(par0 + par5, par1 + par4, par2 + par3, par0 + par8 - 1L + par5, par1 + par7 - 1 + par4, par2 + par6 - 1L + par3);
         default:
            return new StructureBoundingBox(par0 + par3, par1 + par4, par2 + par5, par0 + par6 - 1L + par3, par1 + par7 - 1 + par4, par2 + par8 - 1L + par5);
      }
   }

   public StructureBoundingBox(StructureBoundingBox par1StructureBoundingBox) {
      this.a = par1StructureBoundingBox.a;
      this.b = par1StructureBoundingBox.b;
      this.c = par1StructureBoundingBox.c;
      this.d = par1StructureBoundingBox.d;
      this.e = par1StructureBoundingBox.e;
      this.f = par1StructureBoundingBox.f;
   }

   public StructureBoundingBox(long par1, int par2, long par3, long par4, int par5, long par6) {
      this.a = par1;
      this.b = par2;
      this.c = par3;
      this.d = par4;
      this.e = par5;
      this.f = par6;
   }

   public StructureBoundingBox(long par1, long par2, long par3, long par4) {
      this.a = par1;
      this.c = par2;
      this.d = par3;
      this.f = par4;
      this.b = 1;
      this.e = 512;
   }

   public boolean a(StructureBoundingBox par1StructureBoundingBox) {
      return this.d >= par1StructureBoundingBox.a
         && this.a <= par1StructureBoundingBox.d
         && this.f >= par1StructureBoundingBox.c
         && this.c <= par1StructureBoundingBox.f
         && this.e >= par1StructureBoundingBox.b
         && this.b <= par1StructureBoundingBox.e;
   }

   public boolean intersectsWith(long par1, long par2, long par3, long par4) {
      return this.d >= par1 && this.a <= par3 && this.f >= par2 && this.c <= par4;
   }

   public void b(StructureBoundingBox par1StructureBoundingBox) {
      this.a = Math.min(this.a, par1StructureBoundingBox.a);
      this.b = Math.min(this.b, par1StructureBoundingBox.b);
      this.c = Math.min(this.c, par1StructureBoundingBox.c);
      this.d = Math.max(this.d, par1StructureBoundingBox.d);
      this.e = Math.max(this.e, par1StructureBoundingBox.e);
      this.f = Math.max(this.f, par1StructureBoundingBox.f);
   }

   public void offset(long par1, int par2, long par3) {
      this.a += par1;
      this.b += par2;
      this.c += par3;
      this.d += par1;
      this.e += par2;
      this.f += par3;
   }

   public boolean isVecInside(long par1, int par2, long par3) {
      return par1 >= this.a && par1 <= this.d && par3 >= this.c && par3 <= this.f && par2 >= this.b && par2 <= this.e;
   }

   public int b() {
      return (int)(this.d - this.a) + 1;
   }

   public int c() {
      return this.e - this.b + 1;
   }

   public int d() {
      return (int)(this.f - this.c) + 1;
   }

   public long getCenterX() {
      return this.a + (this.d - this.a + 1L) / 2L;
   }

   public int f() {
      return this.b + (this.e - this.b + 1) / 2;
   }

   public long getCenterZ() {
      return this.c + (this.f - this.c + 1L) / 2L;
   }

   @Override
   public String toString() {
      return "(" + this.a + ", " + this.b + ", " + this.c + "; " + this.d + ", " + this.e + ", " + this.f + ")";
   }
}
