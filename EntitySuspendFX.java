public class EntitySuspendFX extends EntityFX {
   public EntitySuspendFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
      super(par1World, par2, par4 - 0.125, par6, par8, par10, par12);
      this.GenLayerHills = 0.4F;
      this.ap = 0.4F;
      this.aq = 0.7F;
      this.c(0);
      this.a(0.01F, 0.01F);
      this.NoiseGeneratorPerlin = this.NoiseGeneratorPerlin * (this.U.nextFloat() * 0.6F + 0.2F);
      this.r = par8 * 0.0;
      this.s = par10 * 0.0;
      this.t = par12 * 0.0;
      this.e = (int)(16.0 / (Math.random() * 0.8 + 0.2));
   }

   @Override
   public void J_() {
      this.l = this.o;
      this.m = this.p;
      this.n = this.q;
      this.b(this.r, this.s, this.t);
      if (this.k.getBlockMaterial(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q)) != acn.g) {
         this.A();
      }

      if (this.e-- <= 0) {
         this.A();
      }
   }
}
