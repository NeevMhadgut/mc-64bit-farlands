public class EntityBreakingFX extends EntityFX {
   public EntityBreakingFX(World par1World, double par2, double par4, double par6, Item par8Item) {
      super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
      this.c(par8Item.b(0));
      this.GenLayerHills = this.ap = this.aq = 1.0F;
      this.MapGenVillage = Block.aU.cc;
      this.NoiseGeneratorPerlin /= 2.0F;
   }

   public EntityBreakingFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, Item par14Item) {
      this(par1World, par2, par4, par6, par14Item);
      this.r *= 0.1F;
      this.s *= 0.1F;
      this.t *= 0.1F;
      this.r += par8;
      this.s += par10;
      this.t += par12;
   }

   @Override
   public int n() {
      return 2;
   }

   @Override
   public void renderParticle(Tessellator par1Tessellator, double par2, double par3, double par4, double par5, double par6, double par7) {
      double f = (this.s() % 16 + this.b / 4.0F) / 16.0F;
      double f1 = f + 0.01560938;
      double f2 = (this.s() / 16 + this.c / 4.0F) / 16.0F;
      double f3 = f2 + 0.01560938;
      double f4 = 0.1 * this.NoiseGeneratorPerlin;
      double f5 = this.l + (this.o - this.l) * par2 - ar;
      double f6 = this.m + (this.p - this.m) * par2 - as;
      double f7 = this.n + (this.q - this.n) * par2 - at;
      float f8 = 1.0F;
      par1Tessellator.a(f8 * this.GenLayerHills, f8 * this.ap, f8 * this.aq);
      par1Tessellator.a(f5 - par3 * f4 - par6 * f4, f6 - par4 * f4, f7 - par5 * f4 - par7 * f4, f, f3);
      par1Tessellator.a(f5 - par3 * f4 + par6 * f4, f6 + par4 * f4, f7 - par5 * f4 + par7 * f4, f, f2);
      par1Tessellator.a(f5 + par3 * f4 + par6 * f4, f6 + par4 * f4, f7 + par5 * f4 + par7 * f4, f1, f2);
      par1Tessellator.a(f5 + par3 * f4 - par6 * f4, f6 - par4 * f4, f7 + par5 * f4 - par7 * f4, f1, f3);
   }
}
