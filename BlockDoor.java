import java.util.Random;

public class BlockDoor extends Block {
   protected BlockDoor(int par1, acn par2Material) {
      super(par1, par2Material);
      this.bN = 97;
      if (par2Material == acn.f) {
         this.bN++;
      }

      float f = 0.5F;
      float f1 = 1.0F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
   }

   @Override
   public int getBlockTexture(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      if (par5 != 0 && par5 != 1) {
         int i = this.getFullMetadata(par1IBlockAccess, par2, par3, par4);
         int j = this.bN;
         if ((i & 8) != 0) {
            j -= 16;
         }

         int k = i & 3;
         boolean flag = (i & 4) != 0;
         if (!flag) {
            if (k == 0 && par5 == 5) {
               j = -j;
            } else if (k == 1 && par5 == 3) {
               j = -j;
            } else if (k == 2 && par5 == 4) {
               j = -j;
            } else if (k == 3 && par5 == 2) {
               j = -j;
            }

            if ((i & 16) != 0) {
               j = -j;
            }
         } else if (k == 0 && par5 == 2) {
            j = -j;
         } else if (k == 1 && par5 == 5) {
            j = -j;
         } else if (k == 2 && par5 == 3) {
            j = -j;
         } else if (k == 3 && par5 == 4) {
            j = -j;
         }

         return j;
      } else {
         return this.bN;
      }
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = this.getFullMetadata(par1IBlockAccess, par2, par3, par4);
      return (i & 4) != 0;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public int d() {
      return 7;
   }

   @Override
   public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
      return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
      return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      this.e(this.getFullMetadata(par1IBlockAccess, par2, par3, par4));
   }

   public int getDoorOrientation(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return this.getFullMetadata(par1IBlockAccess, par2, par3, par4) & 3;
   }

   public boolean func_48213_h(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return (this.getFullMetadata(par1IBlockAccess, par2, par3, par4) & 4) != 0;
   }

   private void e(int par1) {
      float f = 0.1875F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
      int i = par1 & 3;
      boolean flag = (par1 & 4) != 0;
      boolean flag1 = (par1 & 16) != 0;
      if (i == 0) {
         if (!flag) {
            this.a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
         } else if (!flag1) {
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
         } else {
            this.a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
         }
      } else if (i == 1) {
         if (!flag) {
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
         } else if (!flag1) {
            this.a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else {
            this.a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
         }
      } else if (i == 2) {
         if (!flag) {
            this.a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else if (!flag1) {
            this.a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
         } else {
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
         }
      } else if (i == 3) {
         if (!flag) {
            this.a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
         } else if (!flag1) {
            this.a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
         } else {
            this.a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         }
      }
   }

   @Override
   public void onBlockClicked(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      this.blockActivated(par1World, par2, par3, par4, par5EntityPlayer);
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (this.cd == acn.f) {
         return true;
      }

      int i = this.getFullMetadata(par1World, par2, par3, par4);
      int j = i & 7;
      j ^= 4;
      if ((i & 8) != 0) {
         par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, j);
         par1World.markBlocksDirty(par2, par3 - 1, par4, par2, par3, par4);
      } else {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, j);
         par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
      }

      par1World.playAuxSFXAtEntity(par5EntityPlayer, 1003, par2, par3, par4, 0);
      return true;
   }

   public void onPoweredBlockChange(World par1World, long par2, int par3, long par4, boolean par5) {
      int i = this.getFullMetadata(par1World, par2, par3, par4);
      boolean flag = (i & 4) != 0;
      if (flag != par5) {
         int j = i & 7;
         j ^= 4;
         if ((i & 8) != 0) {
            par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, j);
            par1World.markBlocksDirty(par2, par3 - 1, par4, par2, par3, par4);
         } else {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, j);
            par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
         }

         par1World.playAuxSFXAtEntity(null, 1003, par2, par3, par4, 0);
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      if ((i & 8) != 0) {
         if (par1World.getBlockId(par2, par3 - 1, par4) != this.bO) {
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         }

         if (par5 > 0 && par5 != this.bO) {
            this.onNeighborBlockChange(par1World, par2, par3 - 1, par4, par5);
         }
      } else {
         boolean flag = false;
         if (par1World.getBlockId(par2, par3 + 1, par4) != this.bO) {
            par1World.setBlockWithNotify(par2, par3, par4, 0);
            flag = true;
         }

         if (!par1World.isBlockNormalCube(par2, par3 - 1, par4)) {
            par1World.setBlockWithNotify(par2, par3, par4, 0);
            flag = true;
            if (par1World.getBlockId(par2, par3 + 1, par4) == this.bO) {
               par1World.setBlockWithNotify(par2, par3 + 1, par4, 0);
            }
         }

         if (flag) {
            if (!par1World.F) {
               this.dropBlockAsItem(par1World, par2, par3, par4, i, 0);
            }
         } else {
            boolean flag1 = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4) || par1World.isBlockIndirectlyGettingPowered(par2, par3 + 1, par4);
            if ((flag1 || par5 > 0 && Block.m[par5].g() || par5 == 0) && par5 != this.bO) {
               this.onPoweredBlockChange(par1World, par2, par3, par4, flag1);
            }
         }
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      if ((par1 & 8) != 0) {
         return 0;
      } else {
         return this.cd == acn.f ? Item.aB.bQ : Item.EntityThrowable.bQ;
      }
   }

   @Override
   public MovingObjectPosition collisionRayTrace(World par1World, long par2, int par3, long par4, bo par5Vec3D, bo par6Vec3D) {
      this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
      return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3D, par6Vec3D);
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return par3 >= 255
         ? false
         : par1World.isBlockNormalCube(par2, par3 - 1, par4)
            && super.canPlaceBlockAt(par1World, par2, par3, par4)
            && super.canPlaceBlockAt(par1World, par2, par3 + 1, par4);
   }

   @Override
   public int f() {
      return 1;
   }

   public int getFullMetadata(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
      boolean flag = (i & 8) != 0;
      int j;
      int k;
      if (flag) {
         j = par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4);
         k = i;
      } else {
         j = i;
         k = par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4);
      }

      boolean flag1 = (k & 1) != 0;
      return j & 7 | (flag ? 8 : 0) | (flag1 ? 16 : 0);
   }
}
