public class EntityHugeExplodeFX extends EntityFX {
   private int a = 0;
   private int au = 0;

   public EntityHugeExplodeFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
      super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
      this.au = 8;
   }

   @Override
   public void renderParticle(Tessellator tessellator, double f, double f1, double f2, double f3, double f4, double f5) {
   }

   @Override
   public void J_() {
      for (int i = 0; i < 6; i++) {
         double d = this.o + (this.U.nextFloat() - this.U.nextFloat()) * 4.0F;
         double d1 = this.p + (this.U.nextFloat() - this.U.nextFloat()) * 4.0F;
         double d2 = this.q + (this.U.nextFloat() - this.U.nextFloat()) * 4.0F;
         this.k.a("largeexplode", d, d1, d2, (float)this.a / this.au, 0.0, 0.0);
      }

      this.a++;
      if (this.a == this.au) {
         this.A();
      }
   }

   @Override
   public int n() {
      return 1;
   }
}
