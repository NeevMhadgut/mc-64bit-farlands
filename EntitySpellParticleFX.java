public class EntitySpellParticleFX extends EntityFX {
   private int a = 128;

   public EntitySpellParticleFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
      super(par1World, par2, par4, par6, par8, par10, par12);
      this.s *= 0.2F;
      if (par8 == 0.0 && par12 == 0.0) {
         this.r *= 0.1F;
         this.t *= 0.1F;
      }

      this.NoiseGeneratorPerlin *= 0.75F;
      this.e = (int)(8.0 / (Math.random() * 0.8 + 0.2));
      this.S = false;
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

      this.c(this.a + (7 - this.d * 8 / this.e));
      this.s += 0.004;
      this.b(this.r, this.s, this.t);
      if (this.p == this.m) {
         this.r *= 1.1;
         this.t *= 1.1;
      }

      this.r *= 0.96F;
      this.s *= 0.96F;
      this.t *= 0.96F;
      if (this.z) {
         this.r *= 0.7F;
         this.t *= 0.7F;
      }
   }

   public void b(int par1) {
      this.a = par1;
   }
}
