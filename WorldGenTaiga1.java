import java.util.Random;

public class WorldGenTaiga1 extends WorldGenerator {
   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      int i = par2Random.nextInt(5) + 7;
      int j = i - par2Random.nextInt(2) - 3;
      int k = i - j;
      int l = 1 + par2Random.nextInt(k + 1);
      boolean flag = true;
      if (par4 >= 1 && par4 + i + 1 <= 128) {
         for (int i1 = par4; i1 <= par4 + 1 + i && flag; i1++) {
            int k1 = 1;
            if (i1 - par4 < j) {
               k1 = 0;
            } else {
               k1 = l;
            }

            for (long i2 = par3 - k1; i2 <= par3 + k1 && flag; i2++) {
               for (long l2 = par5 - k1; l2 <= par5 + k1 && flag; l2++) {
                  if (i1 >= 0 && i1 < 128) {
                     int k3 = par1World.getBlockId(i2, i1, l2);
                     if (k3 != 0 && k3 != Block.K.bO) {
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

         int j1 = par1World.getBlockId(par3, par4 - 1, par5);
         if ((j1 == Block.u.bO || j1 == Block.v.bO) && par4 < 128 - i - 1) {
            this.func_50073_a(par1World, par3, par4 - 1, par5, Block.v.bO);
            int l1 = 0;

            for (int j2 = par4 + i; j2 >= par4 + j; j2--) {
               for (long i3 = par3 - l1; i3 <= par3 + l1; i3++) {
                  long l3 = i3 - par3;

                  for (long i4 = par5 - l1; i4 <= par5 + l1; i4++) {
                     long j4 = i4 - par5;
                     if ((Math.abs(l3) != l1 || Math.abs(j4) != l1 || l1 <= 0) && !Block.n[par1World.getBlockId(i3, j2, i4)]) {
                        this.setBlockAndMetadata(par1World, i3, j2, i4, Block.K.bO, 1);
                     }
                  }
               }

               if (l1 >= 1 && j2 == par4 + j + 1) {
                  l1--;
               } else if (l1 < l) {
                  l1++;
               }
            }

            for (int k2 = 0; k2 < i - 1; k2++) {
               int j3 = par1World.getBlockId(par3, par4 + k2, par5);
               if (j3 == 0 || j3 == Block.K.bO) {
                  this.setBlockAndMetadata(par1World, par3, par4 + k2, par5, Block.J.bO, 1);
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
