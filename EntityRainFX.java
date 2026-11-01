public class EntityRainFX extends EntityFX {
   public EntityRainFX(World par1World, double par2, double par4, double par6) {
      super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
      this.r *= 0.3F;
      this.s = (float)Math.random() * 0.2F + 0.1F;
      this.t *= 0.3F;
      this.GenLayerHills = 1.0F;
      this.ap = 1.0F;
      this.aq = 1.0F;
      this.c(19 + this.U.nextInt(4));
      this.a(0.01F, 0.01F);
      this.MapGenVillage = 0.06F;
      this.e = (int)(8.0 / (Math.random() * 0.8 + 0.2));
   }

   @Override
   public void J_() {
      this.l = this.o;
      this.m = this.p;
      this.n = this.q;
      this.s = this.s - this.MapGenVillage;
      this.b(this.r, this.s, this.t);
      this.r *= 0.98F;
      this.s *= 0.98F;
      this.t *= 0.98F;
      if (this.e-- <= 0) {
         this.A();
      }

      if (this.z) {
         if (Math.random() < 0.5) {
            this.A();
         }

         this.r *= 0.7F;
         this.t *= 0.7F;
      }

      acn material = this.k.getBlockMaterial(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q));
      if (material.d() || material.a()) {
         double d = (double)(MathHelper.c(this.p) + 1) - BlockFluid.e(this.k.getBlockMetadata(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q)));
         if (this.p < d) {
            this.A();
         }
      }
   }
}
