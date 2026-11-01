import java.util.Random;

public class BlockGrass extends Block {
   protected BlockGrass(int par1) {
      super(par1, acn.b);
      this.bN = 3;
      this.a(true);
   }

   @Override
   public int a(int par1, int par2) {
      if (par1 == 1) {
         return 0;
      } else {
         return par1 != 0 ? 3 : 2;
      }
   }

   @Override
   public int getBlockTexture(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      if (par5 == 1) {
         return 0;
      }

      if (par5 == 0) {
         return 2;
      }

      acn material = par1IBlockAccess.getBlockMaterial(par2, par3 + 1, par4);
      return material != acn.v && material != acn.w ? 3 : 68;
   }

   @Override
   public int i() {
      double d = 0.5;
      double d1 = 1.0;
      return zv.a(d, d1);
   }

   @Override
   public int d(int par1) {
      return this.i();
   }

   @Override
   public int colorMultiplier(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = 0;
      int j = 0;
      int k = 0;

      for (int l = -1; l <= 1; l++) {
         for (int i1 = -1; i1 <= 1; i1++) {
            int j1 = par1IBlockAccess.getBiomeGenForCoords(par2 + i1, par4 + l).k();
            i += (j1 & 0xFF0000) >> 16;
            j += (j1 & 0xFF00) >> 8;
            k += j1 & 0xFF;
         }
      }

      return (i / 9 & 0xFF) << 16 | (j / 9 & 0xFF) << 8 | k / 9 & 0xFF;
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (!par1World.F) {
         if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && Block.o[par1World.getBlockId(par2, par3 + 1, par4)] > 2) {
            par1World.setBlockWithNotify(par2, par3, par4, Block.v.bO);
         } else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9) {
            for (int i = 0; i < 4; i++) {
               long j = par2 + par5Random.nextInt(3) - 1L;
               int k = par3 + par5Random.nextInt(5) - 3;
               long l = par4 + par5Random.nextInt(3) - 1L;
               int i1 = par1World.getBlockId(j, k + 1, l);
               if (par1World.getBlockId(j, k, l) == Block.v.bO && par1World.getBlockLightValue(j, k + 1, l) >= 4 && Block.o[i1] <= 2) {
                  par1World.setBlockWithNotify(j, k, l, Block.u.bO);
               }
            }
         }
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Block.v.a(0, par2Random, par3);
   }
}
