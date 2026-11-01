public class EntityFlameFX extends EntityFX {
   private float a;

   public EntityFlameFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
      super(par1World, par2, par4, par6, par8, par10, par12);
      this.r = this.r * 0.01F + par8;
      this.s = this.s * 0.01F + par10;
      this.t = this.t * 0.01F + par12;
      par2 += (this.U.nextFloat() - this.U.nextFloat()) * 0.05F;
      par4 += (this.U.nextFloat() - this.U.nextFloat()) * 0.05F;
      par6 += (this.U.nextFloat() - this.U.nextFloat()) * 0.05F;
      this.a = this.NoiseGeneratorPerlin;
      this.GenLayerHills = this.ap = this.aq = 1.0F;
      this.e = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
      this.S = true;
      this.c(48);
   }

   @Override
   public void renderParticle(Tessellator par1Tessellator, double par2, double par3, double par4, double par5, double par6, double par7) {
      float f = (float)((this.d + par2) / this.e);
      this.NoiseGeneratorPerlin = this.a * (1.0F - f * f * 0.5F);
      super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
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
      int j = i & 0xFF;
      int k = i >> 16 & 0xFF;
      j += (int)(f * 15.0F * 16.0F);
      if (j > 240) {
         j = 240;
      }

      return j | k << 16;
   }

   @Override
   public float a(float par1) {
      float f = (this.d + par1) / this.e;
      if (f < 0.0F) {
         f = 0.0F;
      }

      if (f > 1.0F) {
         f = 1.0F;
      }

      float f1 = super.a(par1);
      return f1 * f + (1.0F - f);
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
      this.r *= 0.96F;
      this.s *= 0.96F;
      this.t *= 0.96F;
      if (this.z) {
         this.r *= 0.7F;
         this.t *= 0.7F;
      }
   }
}
