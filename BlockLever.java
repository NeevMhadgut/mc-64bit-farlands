public class BlockLever extends Block {
   protected BlockLever(int par1, int par2) {
      super(par1, par2, acn.p);
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
      return 12;
   }

   @Override
   public boolean canPlaceBlockOnSide(World par1World, long par2, int par3, long par4, int par5) {
      if (par5 == 1 && par1World.isBlockNormalCube(par2, par3 - 1, par4)) {
         return true;
      } else if (par5 == 2 && par1World.isBlockNormalCube(par2, par3, par4 + 1L)) {
         return true;
      } else if (par5 == 3 && par1World.isBlockNormalCube(par2, par3, par4 - 1L)) {
         return true;
      } else {
         return par5 == 4 && par1World.isBlockNormalCube(par2 + 1L, par3, par4) ? true : par5 == 5 && par1World.isBlockNormalCube(par2 - 1L, par3, par4);
      }
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      if (par1World.isBlockNormalCube(par2 - 1L, par3, par4)) {
         return true;
      } else if (par1World.isBlockNormalCube(par2 + 1L, par3, par4)) {
         return true;
      } else if (par1World.isBlockNormalCube(par2, par3, par4 - 1L)) {
         return true;
      } else {
         return par1World.isBlockNormalCube(par2, par3, par4 + 1L) ? true : par1World.isBlockNormalCube(par2, par3 - 1, par4);
      }
   }

   @Override
   public void onBlockPlaced(World par1World, long par2, int par3, long par4, int par5) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      int j = i & 8;
      i &= 7;
      i = -1;
      if (par5 == 1 && par1World.isBlockNormalCube(par2, par3 - 1, par4)) {
         i = 5 + par1World.r.nextInt(2);
      }

      if (par5 == 2 && par1World.isBlockNormalCube(par2, par3, par4 + 1L)) {
         i = 4;
      }

      if (par5 == 3 && par1World.isBlockNormalCube(par2, par3, par4 - 1L)) {
         i = 3;
      }

      if (par5 == 4 && par1World.isBlockNormalCube(par2 + 1L, par3, par4)) {
         i = 2;
      }

      if (par5 == 5 && par1World.isBlockNormalCube(par2 - 1L, par3, par4)) {
         i = 1;
      }

      if (i == -1) {
         this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      } else {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, i + j);
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (this.checkIfAttachedToBlock(par1World, par2, par3, par4)) {
         int i = par1World.getBlockMetadata(par2, par3, par4) & 7;
         boolean flag = false;
         if (!par1World.isBlockNormalCube(par2 - 1L, par3, par4) && i == 1) {
            flag = true;
         }

         if (!par1World.isBlockNormalCube(par2 + 1L, par3, par4) && i == 2) {
            flag = true;
         }

         if (!par1World.isBlockNormalCube(par2, par3, par4 - 1L) && i == 3) {
            flag = true;
         }

         if (!par1World.isBlockNormalCube(par2, par3, par4 + 1L) && i == 4) {
            flag = true;
         }

         if (!par1World.isBlockNormalCube(par2, par3 - 1, par4) && i == 5) {
            flag = true;
         }

         if (!par1World.isBlockNormalCube(par2, par3 - 1, par4) && i == 6) {
            flag = true;
         }

         if (flag) {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         }
      }
   }

   private boolean checkIfAttachedToBlock(World par1World, long par2, int par3, long par4) {
      if (!this.canPlaceBlockAt(par1World, par2, par3, par4)) {
         this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
         return false;
      } else {
         return true;
      }
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 7;
      float f = 0.1875F;
      if (i == 1) {
         this.a(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
      } else if (i == 2) {
         this.a(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
      } else if (i == 3) {
         this.a(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
      } else if (i == 4) {
         this.a(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
      } else {
         float f1 = 0.25F;
         this.a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, 0.6F, 0.5F + f1);
      }
   }

   @Override
   public void onBlockClicked(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      this.blockActivated(par1World, par2, par3, par4, par5EntityPlayer);
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (par1World.F) {
         return true;
      }

      int i = par1World.getBlockMetadata(par2, par3, par4);
      int j = i & 7;
      int k = 8 - (i & 8);
      par1World.setBlockMetadataWithNotify(par2, par3, par4, j + k);
      par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
      par1World.a(par2 + 0.5, par3 + 0.5, par4 + 0.5, "random.click", 0.3F, k <= 0 ? 0.5F : 0.6F);
      par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.bO);
      if (j == 1) {
         par1World.notifyBlocksOfNeighborChange(par2 - 1L, par3, par4, this.bO);
      } else if (j == 2) {
         par1World.notifyBlocksOfNeighborChange(par2 + 1L, par3, par4, this.bO);
      } else if (j == 3) {
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1L, this.bO);
      } else if (j == 4) {
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1L, this.bO);
      } else {
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
      }

      return true;
   }

   @Override
   public void onBlockRemoval(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      if ((i & 8) > 0) {
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.bO);
         int j = i & 7;
         if (j == 1) {
            par1World.notifyBlocksOfNeighborChange(par2 - 1L, par3, par4, this.bO);
         } else if (j == 2) {
            par1World.notifyBlocksOfNeighborChange(par2 + 1L, par3, par4, this.bO);
         } else if (j == 3) {
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1L, this.bO);
         } else if (j == 4) {
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1L, this.bO);
         } else {
            par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
         }
      }

      super.onBlockRemoval(par1World, par2, par3, par4);
   }

   @Override
   public boolean isPoweringTo(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      return (par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 8) > 0;
   }

   @Override
   public boolean isIndirectlyPoweringTo(World par1World, long par2, int par3, long par4, int par5) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      if ((i & 8) == 0) {
         return false;
      } else {
         int j = i & 7;
         if (j == 6 && par5 == 1) {
            return true;
         } else if (j == 5 && par5 == 1) {
            return true;
         } else if (j == 4 && par5 == 2) {
            return true;
         } else if (j == 3 && par5 == 3) {
            return true;
         } else {
            return j == 2 && par5 == 4 ? true : j == 1 && par5 == 5;
         }
      }
   }

   @Override
   public boolean g() {
      return true;
   }
}
