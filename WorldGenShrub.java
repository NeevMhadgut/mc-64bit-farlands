import java.util.Random;

public class WorldGenShrub extends WorldGenerator {
   private int a;
   private int b;

   public WorldGenShrub(int par1, int par2) {
      this.b = par1;
      this.a = par2;
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      int i = 0;

      while (((i = par1World.getBlockId(par3, par4, par5)) == 0 || i == Block.K.bO) && par4 > 0) {
         par4--;
      }

      i = par1World.getBlockId(par3, par4, par5);
      if (i == Block.v.bO || i == Block.u.bO) {
         this.setBlockAndMetadata(par1World, par3, ++par4, par5, Block.J.bO, this.b);

         for (int k = par4; k <= par4 + 2; k++) {
            int l = k - par4;
            int i1 = 2 - l;

            for (long j1 = par3 - i1; j1 <= par3 + i1; j1++) {
               long k1 = j1 - par3;

               for (long l1 = par5 - i1; l1 <= par5 + i1; l1++) {
                  long i2 = l1 - par5;
                  if ((Math.abs(k1) != i1 || Math.abs(i2) != i1 || par2Random.nextInt(2) != 0) && !Block.n[par1World.getBlockId(j1, k, l1)]) {
                     this.setBlockAndMetadata(par1World, j1, k, l1, Block.K.bO, this.a);
                  }
               }
            }
         }
      }

      return true;
   }
}
