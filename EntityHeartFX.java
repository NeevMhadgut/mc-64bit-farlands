public class EntityHeartFX extends EntityFX {
   float a;

   public EntityHeartFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
      this(par1World, par2, par4, par6, par8, par10, par12, 2.0F);
   }

   public EntityHeartFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, float par14) {
      super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
      this.r *= 0.01F;
      this.s *= 0.01F;
      this.t *= 0.01F;
      this.s += 0.1;
      this.NoiseGeneratorPerlin *= 0.75F;
      this.NoiseGeneratorPerlin *= par14;
      this.a = this.NoiseGeneratorPerlin;
      this.e = 16;
      this.S = false;
      this.c(80);
   }

   @Override
   public void renderParticle(Tessellator par1Tessellator, double par2, double par3, double par4, double par5, double par6, double par7) {
      float f = (float)((this.d + par2) / this.e) * 32.0F;
      if (f < 0.0F) {
         f = 0.0F;
      }

      if (f > 1.0F) {
         f = 1.0F;
      }

      this.NoiseGeneratorPerlin = this.a * f;
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

      this.b(this.r, this.s, this.t);
      if (this.p == this.m) {
         this.r *= 1.1;
         this.t *= 1.1;
      }

      this.r *= 0.86F;
      this.s *= 0.86F;
      this.t *= 0.86F;
      if (this.z) {
         this.r *= 0.7F;
         this.t *= 0.7F;
      }
   }
}
