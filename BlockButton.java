import java.util.Random;

public class BlockButton extends Block {
   protected BlockButton(int par1, int par2) {
      super(par1, par2, acn.p);
      this.a(true);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long i) {
      return null;
   }

   @Override
   public int e() {
      return 20;
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
   public boolean canPlaceBlockOnSide(World par1World, long par2, int par3, long par4, int par5) {
      if (par5 == 2 && par1World.isBlockNormalCube(par2, par3, par4 + 1L)) {
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
      } else {
         return par1World.isBlockNormalCube(par2, par3, par4 - 1L) ? true : par1World.isBlockNormalCube(par2, par3, par4 + 1L);
      }
   }

   @Override
   public void onBlockPlaced(World par1World, long par2, int par3, long par4, int par5) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      int j = i & 8;
      i &= 7;
      if (par5 == 2 && par1World.isBlockNormalCube(par2, par3, par4 + 1L)) {
         i = 4;
      } else if (par5 == 3 && par1World.isBlockNormalCube(par2, par3, par4 - 1L)) {
         i = 3;
      } else if (par5 == 4 && par1World.isBlockNormalCube(par2 + 1L, par3, par4)) {
         i = 2;
      } else if (par5 == 5 && par1World.isBlockNormalCube(par2 - 1L, par3, par4)) {
         i = 1;
      } else {
         i = this.getOrientation(par1World, par2, par3, par4);
      }

      par1World.setBlockMetadataWithNotify(par2, par3, par4, i + j);
   }

   private int getOrientation(World par1World, long par2, int par3, long par4) {
      if (par1World.isBlockNormalCube(par2 - 1L, par3, par4)) {
         return 1;
      } else if (par1World.isBlockNormalCube(par2 + 1L, par3, par4)) {
         return 2;
      } else if (par1World.isBlockNormalCube(par2, par3, par4 - 1L)) {
         return 3;
      } else {
         return !par1World.isBlockNormalCube(par2, par3, par4 + 1L) ? 1 : 4;
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (this.redundantCanPlaceBlockAt(par1World, par2, par3, par4)) {
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

         if (flag) {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         }
      }
   }

   private boolean redundantCanPlaceBlockAt(World par1World, long par2, int par3, long par4) {
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
      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
      int j = i & 7;
      boolean flag = (i & 8) > 0;
      float f = 0.375F;
      float f1 = 0.625F;
      float f2 = 0.1875F;
      float f3 = 0.125F;
      if (flag) {
         f3 = 0.0625F;
      }

      if (j == 1) {
         this.a(0.0F, f, 0.5F - f2, f3, f1, 0.5F + f2);
      } else if (j == 2) {
         this.a(1.0F - f3, f, 0.5F - f2, 1.0F, f1, 0.5F + f2);
      } else if (j == 3) {
         this.a(0.5F - f2, f, 0.0F, 0.5F + f2, f1, f3);
      } else if (j == 4) {
         this.a(0.5F - f2, f, 1.0F - f3, 0.5F + f2, f1, 1.0F);
      }
   }

   @Override
   public void onBlockClicked(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      this.blockActivated(par1World, par2, par3, par4, par5EntityPlayer);
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      int j = i & 7;
      int k = 8 - (i & 8);
      if (k == 0) {
         return true;
      }

      par1World.setBlockMetadataWithNotify(par2, par3, par4, j + k);
      par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
      par1World.a(par2 + 0.5, par3 + 0.5, par4 + 0.5, "random.click", 0.3F, 0.6F);
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

      par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, this.e());
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
         if (j == 5 && par5 == 1) {
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

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (!par1World.F) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         if ((i & 8) != 0) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, i & 7);
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

            par1World.a(par2 + 0.5, par3 + 0.5, par4 + 0.5, "random.click", 0.3F, 0.5F);
            par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
         }
      }
   }

   @Override
   public void h() {
      float f = 0.1875F;
      float f1 = 0.125F;
      float f2 = 0.125F;
      this.a(0.5F - f, 0.5F - f1, 0.5F - f2, 0.5F + f, 0.5F + f1, 0.5F + f2);
   }
}
