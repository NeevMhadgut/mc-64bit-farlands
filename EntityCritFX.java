public class EntityCritFX extends EntityFX {
   float a;

   public EntityCritFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
      this(par1World, par2, par4, par6, par8, par10, par12, 1.0F);
   }

   public EntityCritFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, float par14) {
      super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
      this.r *= 0.1F;
      this.s *= 0.1F;
      this.t *= 0.1F;
      this.r += par8 * 0.4;
      this.s += par10 * 0.4;
      this.t += par12 * 0.4;
      this.GenLayerHills = this.ap = this.aq = (float)(Math.random() * 0.3F + 0.6F);
      this.NoiseGeneratorPerlin *= 0.75F;
      this.NoiseGeneratorPerlin *= par14;
      this.a = this.NoiseGeneratorPerlin;
      this.e = (int)(6.0 / (Math.random() * 0.8 + 0.6));
      this.e = (int)(this.e * par14);
      this.S = false;
      this.c(65);
      this.J_();
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
      this.ap = (float)(this.ap * 0.96);
      this.aq = (float)(this.aq * 0.9);
      this.r *= 0.7F;
      this.s *= 0.7F;
      this.t *= 0.7F;
      this.s -= 0.02F;
      if (this.z) {
         this.r *= 0.7F;
         this.t *= 0.7F;
      }
   }
}
