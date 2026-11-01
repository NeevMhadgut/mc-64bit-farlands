import java.util.Random;

public class BlockStationary extends BlockFluid {
   protected BlockStationary(int par1, acn par2Material) {
      super(par1, par2Material);
      this.a(false);
      if (par2Material == acn.h) {
         this.a(true);
      }
   }

   @Override
   public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return this.cd != acn.h;
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
      if (par1World.getBlockId(par2, par3, par4) == this.bO) {
         this.setNotStationary(par1World, par2, par3, par4);
      }
   }

   private void setNotStationary(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      par1World.o = true;
      par1World.setBlockAndMetadata(par2, par3, par4, this.bO - 1, i);
      par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
      par1World.scheduleBlockUpdate(par2, par3, par4, this.bO - 1, this.e());
      par1World.o = false;
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (this.cd == acn.h) {
         int i = par5Random.nextInt(3);

         for (int j = 0; j < i; j++) {
            par2 += par5Random.nextInt(3) - 1;
            par3++;
            par4 += par5Random.nextInt(3) - 1;
            int l = par1World.getBlockId(par2, par3, par4);
            if (l == 0) {
               if (this.isFlammable(par1World, par2 - 1L, par3, par4)
                  || this.isFlammable(par1World, par2 + 1L, par3, par4)
                  || this.isFlammable(par1World, par2, par3, par4 - 1L)
                  || this.isFlammable(par1World, par2, par3, par4 + 1L)
                  || this.isFlammable(par1World, par2, par3 - 1, par4)
                  || this.isFlammable(par1World, par2, par3 + 1, par4)) {
                  par1World.setBlockWithNotify(par2, par3, par4, Block.ar.bO);
                  return;
               }
            } else if (Block.m[l].cd.c()) {
               return;
            }
         }

         if (i == 0) {
            long k = par2;
            long i1 = par4;

            for (int j1 = 0; j1 < 3; j1++) {
               par2 = k + par5Random.nextInt(3) - 1L;
               par4 = i1 + par5Random.nextInt(3) - 1L;
               if (par1World.isAirBlock(par2, par3 + 1, par4) && this.isFlammable(par1World, par2, par3, par4)) {
                  par1World.setBlockWithNotify(par2, par3 + 1, par4, Block.ar.bO);
               }
            }
         }
      }
   }

   private boolean isFlammable(World par1World, long par2, int par3, long par4) {
      return par1World.getBlockMaterial(par2, par3, par4).g();
   }
}
