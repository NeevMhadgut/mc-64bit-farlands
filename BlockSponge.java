public class BlockSponge extends Block {
   protected BlockSponge(int par1) {
      super(par1, acn.l);
      this.bN = 48;
   }

   @Override
   public void onBlockAdded(World world, long i, int j, long k) {
      this.removeWater(world, i, j, k);
   }

   @Override
   public void onBlockRemoval(World world, long i, int j, long k) {
      this.removeWater(world, i, j, k);
   }

   private void removeWater(World world, long i, int j, long k) {
      for (long i1 = i - 2L; i1 <= i + 2L; i1++) {
         for (int j1 = j - 2; j1 <= j + 2; j1++) {
            for (long k1 = k - 2L; k1 <= k + 2L; k1++) {
               if (world.getBlockMaterial(i1, j1, k1) == acn.g) {
                  world.setBlockWithNotify(i1, j1, k1, 0);
               }
            }
         }
      }
   }
}
