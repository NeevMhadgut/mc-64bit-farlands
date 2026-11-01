import java.util.Random;

public class WorldGenForest extends WorldGenerator {
   public WorldGenForest (boolean par1) {
      super(par1);
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      int i = par2Random.nextInt(3) + 5;
      boolean flag = true;
      if (par4 >= 1 && par4 + i + 1 <= 256) {
         for (int j = par4; j <= par4 + 1 + i; j++) {
            byte byte0 = 1;
            if (j == par4) {
               byte0 = 0;
            }

            if (j >= par4 + 1 + i - 2) {
               byte0 = 2;
            }

            for (long j1 = par3 - byte0; j1 <= par3 + byte0 && flag; j1++) {
               for (long i2 = par5 - byte0; i2 <= par5 + byte0 && flag; i2++) {
                  if (j >= 0 && j < 256) {
                     int k2 = par1World.getBlockId(j1, j, i2);
                     if (k2 != 0 && k2 != Block.K.bO) {
                        flag = false;
                     }
                  } else {
                     flag = false;
                  }
               }
            }
         }

         if (!flag) {
            return false;
         }

         int k = par1World.getBlockId(par3, par4 - 1, par5);
         if ((k == Block.u.bO || k == Block.v.bO) && par4 < 256 - i - 1) {
            this.func_50073_a(par1World, par3, par4 - 1, par5, Block.v.bO);

            for (int l = par4 - 3 + i; l <= par4 + i; l++) {
               int k1 = l - (par4 + i);
               int j2 = 1 - k1 / 2;

               for (long l2 = par3 - j2; l2 <= par3 + j2; l2++) {
                  long i3 = l2 - par3;

                  for (long j3 = par5 - j2; j3 <= par5 + j2; j3++) {
                     long k3 = j3 - par5;
                     if ((Math.abs(i3) != j2 || Math.abs(k3) != j2 || par2Random.nextInt(2) != 0 && k1 != 0) && !Block.n[par1World.getBlockId(l2, l, j3)]) {
                        this.setBlockAndMetadata(par1World, l2, l, j3, Block.K.bO, 2);
                     }
                  }
               }
            }

            for (int i1 = 0; i1 < i; i1++) {
               int l1 = par1World.getBlockId(par3, par4 + i1, par5);
               if (l1 == 0 || l1 == Block.K.bO) {
                  this.setBlockAndMetadata(par1World, par3, par4 + i1, par5, Block.J.bO, 2);
               }
            }

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
