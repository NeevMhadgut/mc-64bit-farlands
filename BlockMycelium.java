import java.util.Random;

public class BlockMycelium extends Block {
   protected BlockMycelium(int par1) {
      super(par1, acn.b);
      this.bN = 77;
      this.a(true);
   }

   @Override
   public int a(int par1, int par2) {
      if (par1 == 1) {
         return 78;
      } else {
         return par1 != 0 ? 77 : 2;
      }
   }

   @Override
   public int getBlockTexture(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      if (par5 == 1) {
         return 78;
      }

      if (par5 == 0) {
         return 2;
      }

      acn material = par1IBlockAccess.getBlockMaterial(par2, par3 + 1, par4);
      return material != acn.v && material != acn.w ? 77 : 68;
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
                  par1World.setBlockWithNotify(j, k, l, this.bO);
               }
            }
         }
      }
   }

   @Override
   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
      if (par5Random.nextInt(10) == 0) {
         par1World.a("townaura", par2 + par5Random.nextDouble(), par3 + 1.1, par4 + par5Random.nextDouble(), 0.0, 0.0, 0.0);
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Block.v.a(0, par2Random, par3);
   }
}
