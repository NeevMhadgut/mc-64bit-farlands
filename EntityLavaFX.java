public class EntityLavaFX extends EntityFX {
   private float a;

   public EntityLavaFX(World par1World, double par2, double par4, double par6) {
      super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
      this.r *= 0.8F;
      this.s *= 0.8F;
      this.t *= 0.8F;
      this.s = this.U.nextFloat() * 0.4F + 0.05F;
      this.GenLayerHills = this.ap = this.aq = 1.0F;
      this.NoiseGeneratorPerlin = this.NoiseGeneratorPerlin * (this.U.nextFloat() * 2.0F + 0.2F);
      this.a = this.NoiseGeneratorPerlin;
      this.e = (int)(16.0 / (Math.random() * 0.8 + 0.2));
      this.S = false;
      this.c(49);
   }

   @Override
   public int b(float par1) {
      float f = (this.d + par1) / this.e;
      if (f < 0.0F) {
         f = 0.0F;
      }

      if (f > 1.0F) {
         f = 1.0F;
      }

      int i = super.b(par1);
      char c = 240;
      int j = i >> 16 & 0xFF;
      return c | j << 16;
   }

   @Override
   public float a(float par1) {
      return 1.0F;
   }

   @Override
   public void renderParticle(Tessellator par1Tessellator, double par2, double par3, double par4, double par5, double par6, double par7) {
      float f = (float)((this.d + par2) / this.e);
      this.NoiseGeneratorPerlin = this.a * (1.0F - f * f);
      super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
   }

   @Override
   public void J_() {
      this.l = this.o;
      this.m = this.p;
      this.n = this.q;
      if (this.d++ >= this.e) {
         this.A();
      }

      float f = (float)this.d / this.e;
      if (this.U.nextFloat() > f) {
         this.k.a("smoke", this.o, this.p, this.q, this.r, this.s, this.t);
      }

      this.s -= 0.03;
      this.b(this.r, this.s, this.t);
      this.r *= 0.999F;
      this.s *= 0.999F;
      this.t *= 0.999F;
      if (this.z) {
         this.r *= 0.7F;
         this.t *= 0.7F;
      }
   }
}
