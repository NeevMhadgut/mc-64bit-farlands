public class EntityReddustFX extends EntityFX {
   float a;

   public EntityReddustFX(World par1World, double par2, double par4, double par6, float par8, float par9, float par10) {
      this(par1World, par2, par4, par6, 1.0F, par8, par9, par10);
   }

   public EntityReddustFX(World par1World, double par2, double par4, double par6, float par8, float par9, float par10, float par11) {
      super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
      this.r *= 0.1F;
      this.s *= 0.1F;
      this.t *= 0.1F;
      if (par9 == 0.0F) {
         par9 = 1.0F;
      }

      float f = (float)Math.random() * 0.4F + 0.6F;
      this.GenLayerHills = ((float)(Math.random() * 0.2F) + 0.8F) * par9 * f;
      this.ap = ((float)(Math.random() * 0.2F) + 0.8F) * par10 * f;
      this.aq = ((float)(Math.random() * 0.2F) + 0.8F) * par11 * f;
      this.NoiseGeneratorPerlin *= 0.75F;
      this.NoiseGeneratorPerlin *= par8;
      this.a = this.NoiseGeneratorPerlin;
      this.e = (int)(8.0 / (Math.random() * 0.8 + 0.2));
      this.e = (int)(this.e * par8);
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

      this.c(7 - this.d * 8 / this.e);
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
}
