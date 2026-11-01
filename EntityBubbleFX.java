public class EntityBubbleFX extends EntityFX {
   public EntityBubbleFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
      super(par1World, par2, par4, par6, par8, par10, par12);
      this.GenLayerHills = 1.0F;
      this.ap = 1.0F;
      this.aq = 1.0F;
      this.c(32);
      this.a(0.02F, 0.02F);
      this.NoiseGeneratorPerlin = this.NoiseGeneratorPerlin * (this.U.nextFloat() * 0.6F + 0.2F);
      this.r = par8 * 0.2F + (float)(Math.random() * 2.0 - 1.0) * 0.02F;
      this.s = par10 * 0.2F + (float)(Math.random() * 2.0 - 1.0) * 0.02F;
      this.t = par12 * 0.2F + (float)(Math.random() * 2.0 - 1.0) * 0.02F;
      this.e = (int)(8.0 / (Math.random() * 0.8 + 0.2));
   }

   @Override
   public void J_() {
      this.l = this.o;
      this.m = this.p;
      this.n = this.q;
      this.s += 0.002;
      this.b(this.r, this.s, this.t);
      this.r *= 0.85F;
      this.s *= 0.85F;
      this.t *= 0.85F;
      if (this.k.getBlockMaterial(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q)) != acn.g) {
         this.A();
      }

      if (this.e-- <= 0) {
         this.A();
      }
   }
}
