import java.util.Random;

public class BlockRail extends Block {
   private final boolean a;

   public static final boolean isRailBlockAt(World par0World, long par1, int par2, long par3) {
      int i = par0World.getBlockId(par1, par2, par3);
      return i == Block.aG.bO || i == Block.T.bO || i == Block.U.bO;
   }

   public static final boolean e(int par0) {
      return par0 == Block.aG.bO || par0 == Block.T.bO || par0 == Block.U.bO;
   }

   protected BlockRail(int par1, int par2, boolean par3) {
      super(par1, par2, acn.p);
      this.a = par3;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean v() {
      return this.a;
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
   public MovingObjectPosition collisionRayTrace(World par1World, long par2, int par3, long par4, bo par5Vec3D, bo par6Vec3D) {
      this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
      return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3D, par6Vec3D);
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 7;
      if (i >= 2 && i <= 5) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      }
   }

   @Override
   public int a(int par1, int par2) {
      if (this.a) {
         if (this.bO == Block.T.bO && (par2 & 8) == 0) {
            return this.bN - 16;
         }
      } else if (par2 >= 6) {
         return this.bN - 16;
      }

      return this.bN;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public int d() {
      return 9;
   }

   @Override
   public int a(Random par1Random) {
      return 1;
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return par1World.isBlockNormalCube(par2, par3 - 1, par4);
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      if (!par1World.F) {
         this.refreshTrackShape(par1World, par2, par3, par4, true);
         if (this.bO == Block.T.bO) {
            this.onNeighborBlockChange(par1World, par2, par3, par4, this.bO);
         }
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (!par1World.F) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         int j = i;
         if (this.a) {
            j &= 7;
         }

         boolean flag = false;
         if (!par1World.isBlockNormalCube(par2, par3 - 1, par4)) {
            flag = true;
         }

         if (j == 2 && !par1World.isBlockNormalCube(par2 + 1L, par3, par4)) {
            flag = true;
         }

         if (j == 3 && !par1World.isBlockNormalCube(par2 - 1L, par3, par4)) {
            flag = true;
         }

         if (j == 4 && !par1World.isBlockNormalCube(par2, par3, par4 - 1L)) {
            flag = true;
         }

         if (j == 5 && !par1World.isBlockNormalCube(par2, par3, par4 + 1L)) {
            flag = true;
         }

         if (flag) {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         } else if (this.bO == Block.T.bO) {
            boolean flag1 = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4);
            flag1 = flag1
               || this.isNeighborRailPowered(par1World, par2, par3, par4, i, true, 0)
               || this.isNeighborRailPowered(par1World, par2, par3, par4, i, false, 0);
            boolean flag2 = false;
            if (flag1 && (i & 8) == 0) {
               par1World.setBlockMetadataWithNotify(par2, par3, par4, j | 8);
               flag2 = true;
            } else if (!flag1 && (i & 8) != 0) {
               par1World.setBlockMetadataWithNotify(par2, par3, par4, j);
               flag2 = true;
            }

            if (flag2) {
               par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
               if (j == 2 || j == 3 || j == 4 || j == 5) {
                  par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.bO);
               }
            }
         } else if (par5 > 0 && Block.m[par5].g() && !this.a && RailLogic.a(new RailLogic(this, par1World, par2, par3, par4)) == 3) {
            this.refreshTrackShape(par1World, par2, par3, par4, false);
         }
      }
   }

   private void refreshTrackShape(World par1World, long par2, int par3, long par4, boolean par5) {
      if (!par1World.F) {
         new RailLogic(this, par1World, par2, par3, par4).a(par1World.isBlockIndirectlyGettingPowered(par2, par3, par4), par5);
      }
   }

   private boolean isNeighborRailPowered(World par1World, long par2, int par3, long par4, int par5, boolean par6, int par7) {
      if (par7 >= 8) {
         return false;
      }

      int i = par5 & 7;
      boolean flag = true;
      switch (i) {
         case 0:
            if (par6) {
               par4++;
            } else {
               par4--;
            }
            break;
         case 1:
            if (par6) {
               par2--;
            } else {
               par2++;
            }
            break;
         case 2:
            if (par6) {
               par2--;
            } else {
               par2++;
               par3++;
               flag = false;
            }

            i = 1;
            break;
         case 3:
            if (par6) {
               par2--;
               par3++;
               flag = false;
            } else {
               par2++;
            }

            i = 1;
            break;
         case 4:
            if (par6) {
               par4++;
            } else {
               par4--;
               par3++;
               flag = false;
            }

            i = 0;
            break;
         case 5:
            if (par6) {
               par4++;
               par3++;
               flag = false;
            } else {
               par4--;
            }

            i = 0;
      }

      return this.isRailPassingPower(par1World, par2, par3, par4, par6, par7, i)
         ? true
         : flag && this.isRailPassingPower(par1World, par2, par3 - 1, par4, par6, par7, i);
   }

   private boolean isRailPassingPower(World par1World, long par2, int par3, long par4, boolean par5, int par6, int par7) {
      int i = par1World.getBlockId(par2, par3, par4);
      if (i == Block.T.bO) {
         int j = par1World.getBlockMetadata(par2, par3, par4);
         int k = j & 7;
         if (par7 == 1 && (k == 0 || k == 4 || k == 5)) {
            return false;
         }

         if (par7 == 0 && (k == 1 || k == 2 || k == 3)) {
            return false;
         }

         if ((j & 8) != 0) {
            if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
               return true;
            }

            return this.isNeighborRailPowered(par1World, par2, par3, par4, j, par5, par6 + 1);
         }
      }

      return false;
   }

   @Override
   public int f() {
      return 0;
   }

   static boolean a(BlockRail par0BlockRail) {
      return par0BlockRail.a;
   }
}
