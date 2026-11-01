public class EntityPortalFX extends EntityFX {
   private float a;
   private double au;
   private double EntityThrowable;
   private double aw;

   public EntityPortalFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
      super(par1World, par2, par4, par6, par8, par10, par12);
      this.r = par8;
      this.s = par10;
      this.t = par12;
      this.au = this.o = par2;
      this.EntityThrowable = this.p = par4;
      this.aw = this.q = par6;
      float f = this.U.nextFloat() * 0.6F + 0.4F;
      this.a = this.NoiseGeneratorPerlin = this.U.nextFloat() * 0.2F + 0.5F;
      this.GenLayerHills = this.ap = this.aq = 1.0F * f;
      this.ap *= 0.3F;
      this.GenLayerHills *= 0.9F;
      this.e = (int)(Math.random() * 10.0) + 40;
      this.S = true;
      this.c((int)(Math.random() * 8.0));
   }

   @Override
   public void renderParticle(Tessellator par1Tessellator, double par2, double par3, double par4, double par5, double par6, double par7) {
      float f = (float)((this.d + par2) / this.e);
      f = 1.0F - f;
      f *= f;
      f = 1.0F - f;
      this.NoiseGeneratorPerlin = this.a * f;
      super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
   }

   @Override
   public int b(float par1) {
      int i = super.b(par1);
      float f = (float)this.d / this.e;
      f *= f;
      f *= f;
      int j = i & 0xFF;
      int k = i >> 16 & 0xFF;
      k += (int)(f * 15.0F * 16.0F);
      if (k > 240) {
         k = 240;
      }

      return j | k << 16;
   }

   @Override
   public float a(float par1) {
      float f = super.a(par1);
      float f1 = (float)this.d / this.e;
      f1 = f1 * f1 * f1 * f1;
      return f * (1.0F - f1) + f1;
   }

   @Override
   public void J_() {
      this.l = this.o;
      this.m = this.p;
      this.n = this.q;
      float f = (float)this.d / this.e;
      float f1 = f;
      f = -f + f * f * 2.0F;
      f = 1.0F - f;
      this.o = this.au + this.r * f;
      this.p = this.EntityThrowable + this.s * f + (1.0F - f1);
      this.q = this.aw + this.t * f;
      if (this.d++ >= this.e) {
         this.A();
      }
   }
}
