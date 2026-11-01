import java.util.Random;

public class BlockFarmland extends Block {
   protected BlockFarmland(int par1) {
      super(par1, acn.c);
      this.bN = 87;
      this.a(true);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
      this.f(255);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      return AxisAlignedBB.b(par2 + 0L, par3 + 0, par4 + 0L, par2 + 1L, par3 + 1, par4 + 1L);
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public int a(int par1, int par2) {
      if (par1 == 1 && par2 > 0) {
         return this.bN - 1;
      } else {
         return par1 == 1 ? this.bN : 2;
      }
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (!this.isWaterNearby(par1World, par2, par3, par4) && !par1World.canLightningStrikeAt(par2, par3 + 1, par4)) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         if (i > 0) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, i - 1);
         } else if (!this.isCropsNearby(par1World, par2, par3, par4)) {
            par1World.setBlockWithNotify(par2, par3, par4, Block.v.bO);
         }
      } else {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 7);
      }
   }

   @Override
   public void onFallenUpon(World par1World, long par2, int par3, long par4, Entity par5Entity, float par6) {
      if (par1World.r.nextFloat() < par6 - 0.5F) {
         par1World.setBlockWithNotify(par2, par3, par4, Block.v.bO);
      }
   }

   private boolean isCropsNearby(World par1World, long par2, int par3, long par4) {
      int i = 0;

      for (long j = par2 - i; j <= par2 + i; j++) {
         for (long k = par4 - i; k <= par4 + i; k++) {
            int l = par1World.getBlockId(j, par3 + 1, k);
            if (l == Block.TileEntityDispenser.bO || l == Block.EntityFireball.bO || l == Block.bs.bO) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean isWaterNearby(World par1World, long par2, int par3, long par4) {
      for (long i = par2 - 4L; i <= par2 + 4L; i++) {
         for (int j = par3; j <= par3 + 1; j++) {
            for (long k = par4 - 4L; k <= par4 + 4L; k++) {
               if (par1World.getBlockMaterial(i, j, k) == acn.g) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
      acn material = par1World.getBlockMaterial(par2, par3 + 1, par4);
      if (material.a()) {
         par1World.setBlockWithNotify(par2, par3, par4, Block.v.bO);
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Block.v.a(0, par2Random, par3);
   }
}
