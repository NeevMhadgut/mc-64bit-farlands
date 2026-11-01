import java.util.Random;

public class WorldGenMinable extends WorldGenerator {
   private int a;
   private int b;

   public WorldGenMinable(int par1, int par2) {
      this.a = par1;
      this.b = par2;
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      float f = par2Random.nextFloat() * (float) Math.PI;
      double d = 8.0F + MathHelper.a(f) * this.b / 8.0F;
      double d1 = 8.0F - MathHelper.a(f) * this.b / 8.0F;
      double d2 = 8.0F + MathHelper.b(f) * this.b / 8.0F;
      double d3 = 8.0F - MathHelper.b(f) * this.b / 8.0F;
      double d4 = par4 + par2Random.nextInt(3) - 2;
      double d5 = par4 + par2Random.nextInt(3) - 2;

      for (int i = 0; i <= this.b; i++) {
         double d6 = d + (d1 - d) * i / this.b;
         double d7 = d4 + (d5 - d4) * i / this.b;
         double d8 = d2 + (d3 - d2) * i / this.b;
         double d9 = par2Random.nextDouble() * this.b / 16.0;
         double d10 = (MathHelper.a(i * (float) Math.PI / this.b) + 1.0F) * d9 + 1.0;
         double d11 = (MathHelper.a(i * (float) Math.PI / this.b) + 1.0F) * d9 + 1.0;
         int j = MathHelper.c(d6 - d10 / 2.0);
         int k = MathHelper.c(d7 - d11 / 2.0);
         int l = MathHelper.c(d8 - d10 / 2.0);
         int i1 = MathHelper.c(d6 + d10 / 2.0);
         int j1 = MathHelper.c(d7 + d11 / 2.0);
         int k1 = MathHelper.c(d8 + d10 / 2.0);

         for (int l1 = j; l1 <= i1; l1++) {
            double d12 = (l1 + 0.5 - d6) / (d10 / 2.0);
            if (!(d12 * d12 >= 1.0)) {
               for (int i2 = k; i2 <= j1; i2++) {
                  double d13 = (i2 + 0.5 - d7) / (d11 / 2.0);
                  if (!(d12 * d12 + d13 * d13 >= 1.0)) {
                     for (int j2 = l; j2 <= k1; j2++) {
                        double d14 = (j2 + 0.5 - d8) / (d10 / 2.0);
                        if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0 && par1World.getBlockId(par3 + l1, i2, par5 + j2) == Block.t.bO) {
                           par1World.setBlock(par3 + l1, i2, par5 + j2, this.a);
                        }
                     }
                  }
               }
            }
         }
      }

      return true;
   }
}
