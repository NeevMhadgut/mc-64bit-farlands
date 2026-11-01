import java.util.Random;

public class BlockTorch extends Block {
   protected BlockTorch(int par1, int par2) {
      super(par1, par2, acn.p);
      this.a(true);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long i) {
      return null;
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
   public int d() {
      return 2;
   }

   private boolean canPlaceTorchOn(World par1World, long par2, int par3, long par4) {
      if (par1World.isBlockNormalCubeDefault(par2, par3, par4, true)) {
         return true;
      }

      int i = par1World.getBlockId(par2, par3, par4);
      if (i != Block.aZ.bO && i != Block.bB.bO && i != Block.M.bO) {
         if (Block.m[i] != null && Block.m[i] instanceof BlockStairs) {
            int j = par1World.getBlockMetadata(par2, par3, par4);
            if ((4 & j) != 0) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      if (par1World.isBlockNormalCubeDefault(par2 - 1L, par3, par4, true)) {
         return true;
      } else if (par1World.isBlockNormalCubeDefault(par2 + 1L, par3, par4, true)) {
         return true;
      } else if (par1World.isBlockNormalCubeDefault(par2, par3, par4 - 1L, true)) {
         return true;
      } else {
         return par1World.isBlockNormalCubeDefault(par2, par3, par4 + 1L, true) ? true : this.canPlaceTorchOn(par1World, par2, par3 - 1, par4);
      }
   }

   @Override
   public void onBlockPlaced(World par1World, long par2, int par3, long par4, int par5) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      if (par5 == 1 && this.canPlaceTorchOn(par1World, par2, par3 - 1, par4)) {
         i = 5;
      }

      if (par5 == 2 && par1World.isBlockNormalCubeDefault(par2, par3, par4 + 1L, true)) {
         i = 4;
      }

      if (par5 == 3 && par1World.isBlockNormalCubeDefault(par2, par3, par4 - 1L, true)) {
         i = 3;
      }

      if (par5 == 4 && par1World.isBlockNormalCubeDefault(par2 + 1L, par3, par4, true)) {
         i = 2;
      }

      if (par5 == 5 && par1World.isBlockNormalCubeDefault(par2 - 1L, par3, par4, true)) {
         i = 1;
      }

      par1World.setBlockMetadataWithNotify(par2, par3, par4, i);
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      super.updateTick(par1World, par2, par3, par4, par5Random);
      if (par1World.getBlockMetadata(par2, par3, par4) == 0) {
         this.onBlockAdded(par1World, par2, par3, par4);
      }
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      if (par1World.isBlockNormalCubeDefault(par2 - 1L, par3, par4, true)) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 1);
      } else if (par1World.isBlockNormalCubeDefault(par2 + 1L, par3, par4, true)) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 2);
      } else if (par1World.isBlockNormalCubeDefault(par2, par3, par4 - 1L, true)) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
      } else if (par1World.isBlockNormalCubeDefault(par2, par3, par4 + 1L, true)) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 4);
      } else if (this.canPlaceTorchOn(par1World, par2, par3 - 1, par4)) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 5);
      }

      this.dropTorchIfCantStay(par1World, par2, par3, par4);
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (this.dropTorchIfCantStay(par1World, par2, par3, par4)) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         boolean flag = false;
         if (!par1World.isBlockNormalCubeDefault(par2 - 1L, par3, par4, true) && i == 1) {
            flag = true;
         }

         if (!par1World.isBlockNormalCubeDefault(par2 + 1L, par3, par4, true) && i == 2) {
            flag = true;
         }

         if (!par1World.isBlockNormalCubeDefault(par2, par3, par4 - 1L, true) && i == 3) {
            flag = true;
         }

         if (!par1World.isBlockNormalCubeDefault(par2, par3, par4 + 1L, true) && i == 4) {
            flag = true;
         }

         if (!this.canPlaceTorchOn(par1World, par2, par3 - 1, par4) && i == 5) {
            flag = true;
         }

         if (flag) {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         }
      }
   }

   private boolean dropTorchIfCantStay(World par1World, long par2, int par3, long par4) {
      if (!this.canPlaceBlockAt(par1World, par2, par3, par4)) {
         if (par1World.getBlockId(par2, par3, par4) == this.bO) {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         }

         return false;
      } else {
         return true;
      }
   }

   @Override
   public MovingObjectPosition collisionRayTrace(World par1World, long par2, int par3, long par4, bo par5Vec3D, bo par6Vec3D) {
      int i = par1World.getBlockMetadata(par2, par3, par4) & 7;
      float f = 0.15F;
      if (i == 1) {
         this.a(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
      } else if (i == 2) {
         this.a(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
      } else if (i == 3) {
         this.a(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
      } else if (i == 4) {
         this.a(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
      } else {
         float f1 = 0.1F;
         this.a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, 0.6F, 0.5F + f1);
      }

      return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3D, par6Vec3D);
   }

   @Override
   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      double d = par2 + 0.5;
      double d1 = par3 + 0.7;
      double d2 = par4 + 0.5;
      double d3 = 0.22F;
      double d4 = 0.27F;
      if (i == 1) {
         par1World.a("smoke", d - d4, d1 + d3, d2, 0.0, 0.0, 0.0);
         par1World.a("flame", d - d4, d1 + d3, d2, 0.0, 0.0, 0.0);
      } else if (i == 2) {
         par1World.a("smoke", d + d4, d1 + d3, d2, 0.0, 0.0, 0.0);
         par1World.a("flame", d + d4, d1 + d3, d2, 0.0, 0.0, 0.0);
      } else if (i == 3) {
         par1World.a("smoke", d, d1 + d3, d2 - d4, 0.0, 0.0, 0.0);
         par1World.a("flame", d, d1 + d3, d2 - d4, 0.0, 0.0, 0.0);
      } else if (i == 4) {
         par1World.a("smoke", d, d1 + d3, d2 + d4, 0.0, 0.0, 0.0);
         par1World.a("flame", d, d1 + d3, d2 + d4, 0.0, 0.0, 0.0);
      } else {
         par1World.a("smoke", d, d1, d2, 0.0, 0.0, 0.0);
         par1World.a("flame", d, d1, d2, 0.0, 0.0, 0.0);
      }
   }
}
