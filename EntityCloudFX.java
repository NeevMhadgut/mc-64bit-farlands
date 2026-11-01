public class EntityCloudFX extends EntityFX {
   float a;

   public EntityCloudFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
      super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
      float f = 2.5F;
      this.r *= 0.1F;
      this.s *= 0.1F;
      this.t *= 0.1F;
      this.r += par8;
      this.s += par10;
      this.t += par12;
      this.GenLayerHills = this.ap = this.aq = 1.0F - (float)(Math.random() * 0.3F);
      this.NoiseGeneratorPerlin *= 0.75F;
      this.NoiseGeneratorPerlin *= f;
      this.a = this.NoiseGeneratorPerlin;
      this.e = (int)(8.0 / (Math.random() * 0.8 + 0.3));
      this.e = (int)(this.e * f);
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
      this.r *= 0.96F;
      this.s *= 0.96F;
      this.t *= 0.96F;
      EntityPlayer entityplayer = this.k.a(this, 2.0);
      if (entityplayer != null && this.p > entityplayer.y.b) {
         this.p = this.p + (entityplayer.y.b - this.p) * 0.2;
         this.s = this.s + (entityplayer.s - this.s) * 0.2;
         this.d(this.o, this.p, this.q);
      }

      if (this.z) {
         this.r *= 0.7F;
         this.t *= 0.7F;
      }
   }
}
