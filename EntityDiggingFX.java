public class EntityDiggingFX extends EntityFX {
   private Block a;

   public EntityDiggingFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, Block par14Block, int par15, int par16) {
      super(par1World, par2, par4, par6, par8, par10, par12);
      this.a = par14Block;
      this.c(par14Block.a(0, par16));
      this.MapGenVillage = par14Block.cc;
      this.GenLayerHills = this.ap = this.aq = 0.6F;
      this.NoiseGeneratorPerlin /= 2.0F;
   }

   public EntityDiggingFX func_4041_a(long par1, int par2, long par3) {
      if (this.a == Block.u) {
         return this;
      }

      int i = this.a.colorMultiplier(this.k, par1, par2, par3);
      this.GenLayerHills *= (i >> 16 & 0xFF) / 255.0F;
      this.ap *= (i >> 8 & 0xFF) / 255.0F;
      this.aq *= (i & 0xFF) / 255.0F;
      return this;
   }

   @Override
   public int n() {
      return 1;
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
