public class EntityDropParticleFX extends EntityFX {
   private acn a;
   private int au;

   public EntityDropParticleFX(World par1World, double par2, double par4, double par6, acn par8Material) {
      super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
      this.r = this.s = this.t = 0.0;
      if (par8Material == acn.g) {
         this.GenLayerHills = 0.0F;
         this.ap = 0.0F;
         this.aq = 1.0F;
      } else {
         this.GenLayerHills = 1.0F;
         this.ap = 0.0F;
         this.aq = 0.0F;
      }

      this.c(113);
      this.a(0.01F, 0.01F);
      this.MapGenVillage = 0.06F;
      this.a = par8Material;
      this.au = 40;
      this.e = (int)(64.0 / (Math.random() * 0.8 + 0.2));
      this.r = this.s = this.t = 0.0;
   }

   @Override
   public int b(float par1) {
      return this.a == acn.g ? super.b(par1) : 257;
   }

   @Override
   public float a(float par1) {
      return this.a == acn.g ? super.a(par1) : 1.0F;
   }

   @Override
   public void J_() {
      this.l = this.o;
      this.m = this.p;
      this.n = this.q;
      if (this.a == acn.g) {
         this.GenLayerHills = 0.2F;
         this.ap = 0.3F;
         this.aq = 1.0F;
      } else {
         this.GenLayerHills = 1.0F;
         this.ap = 16.0F / (40 - this.au + 16);
         this.aq = 4.0F / (40 - this.au + 8);
      }

      this.s = this.s - this.MapGenVillage;
      if (this.au-- > 0) {
         this.r *= 0.02;
         this.s *= 0.02;
         this.t *= 0.02;
         this.c(113);
      } else {
         this.c(112);
      }

      this.b(this.r, this.s, this.t);
      this.r *= 0.98F;
      this.s *= 0.98F;
      this.t *= 0.98F;
      if (this.e-- <= 0) {
         this.A();
      }

      if (this.z) {
         if (this.a == acn.g) {
            this.A();
            this.k.a("splash", this.o, this.p, this.q, 0.0, 0.0, 0.0);
         } else {
            this.c(114);
         }

         this.r *= 0.7F;
         this.t *= 0.7F;
      }

      acn material = this.k.getBlockMaterial(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q));
      if (material.d() || material.a()) {
         double d = MathHelper.c(this.p) + 1 - BlockFluid.e(this.k.getBlockMetadata(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q)));
         if (this.p < d) {
            this.A();
         }
      }
   }
}
